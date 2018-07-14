package com.akos.libraryapp.services;

import com.akos.libraryapp.domain.entity.Book;
import com.akos.libraryapp.domain.entity.BookOrder;
import com.akos.libraryapp.repositories.BookOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class BookOrderService {

    private static final int PAGE_SIZE = 10;

    private BookOrderRepository bookOrderRepository;

    private BookService bookService;

    @Autowired
    public BookOrderService(BookOrderRepository bookOrderRepository, BookService bookService) {
        this.bookOrderRepository = bookOrderRepository;
        this.bookService = bookService;
    }

    public List<BookOrder> getAll() {

        return bookOrderRepository.findAll();
    }

    public Page<BookOrder> getFirstPage() {

        return bookOrderRepository.getAllBy(PageRequest.of(0, PAGE_SIZE));
    }

    public BookOrder placeOrder(String username, Long bookId) {

        String bookName = bookService.getById(bookId).getName();

        BookOrder bookOrder = new BookOrder();
        bookOrder.setUsername(username);
        bookOrder.setBookName(bookName);
        bookOrder.setOrderDate(new Date());
        bookOrder.setAccepted(false);
        bookOrder.setReturned(false);
        bookOrder.setBookId(bookId);

        return bookOrderRepository.save(bookOrder);
    }

    public BookOrder getOrder(Long orderId) {
        return bookOrderRepository.getOne(orderId);
    }

    public void deleteOrder(Long orderId) {
        if(!bookOrderRepository.getOne(orderId).getAccepted())
        bookOrderRepository.deleteById(orderId);
        else throw new OrderProcessingException("Order already accepted");
    }


    public BookOrder acceptOrder(Long orderId) {

        BookOrder bookOrder = bookOrderRepository.getOne(orderId);

        Book book = bookService.getById(bookOrder.getBookId());

        if (!bookOrder.getAccepted()) {
            if (book.getQuantity() != null && book.getQuantity() > 0) {
                book.setQuantity(book.getQuantity() - 1);
                bookOrder.setAccepted(true);
                bookOrder.setReturnDate(new Date(new Date().getTime() + TimeUnit.DAYS.toMillis(12)));
                bookService.save(book);
            } else throw new OrderProcessingException("No books left");
        }

        return bookOrderRepository.save(bookOrder);
    }

    public BookOrder closeOrder(Long orderId) {
        BookOrder bookOrder = bookOrderRepository.getOne(orderId);

        if (bookOrder.getAccepted() && !bookOrder.getReturned()) {
            bookOrder.setReturned(true);

            Book book = bookService.getById(bookOrder.getBookId());

            book.setQuantity(book.getQuantity() + 1);
            bookService.save(book);
        }

        return bookOrderRepository.save(bookOrder);
    }

    public List<BookOrder> getAllByUsername(String username){
        return bookOrderRepository.getAllByUsername(username);
    }

    public Page<BookOrder> getAllByUsername(String username, int page){
        return bookOrderRepository.getAllByUsername(username, PageRequest.of(page,PAGE_SIZE));
    }

}
