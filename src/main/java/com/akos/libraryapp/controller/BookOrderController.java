package com.akos.libraryapp.controller;

import com.akos.libraryapp.domain.entity.BookOrder;
import com.akos.libraryapp.services.BookOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/orders")
public class BookOrderController {

    //To place order use method in userController ("/order/{bookId}")

    private BookOrderService bookOrderService;

    @Autowired
    public BookOrderController(BookOrderService bookOrderService) {
        this.bookOrderService = bookOrderService;
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<BookOrder> getAll() {
        return bookOrderService.getAll();
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<BookOrder> getAll(@RequestParam(value = "username", required = false) String username, @RequestParam(value = "page", required = false) Integer pageNumber) {
        System.out.println(username);
        if (username != null) {
            if (pageNumber != null) {
                return bookOrderService.getAllByUsername(username, pageNumber - 1);
            }
            return bookOrderService.getAllByUsername(username, 0);
        }
        return bookOrderService.getFirstPage();
    }



    @RequestMapping(value = "/accept/{orderId}", method = RequestMethod.POST)
    public BookOrder acceptOrder(@PathVariable Long orderId) {
        return bookOrderService.acceptOrder(orderId);
    }

    @RequestMapping(value = "/close/{orderId}", method = RequestMethod.POST)
    public BookOrder closeOrder(@PathVariable Long orderId) {
        return bookOrderService.closeOrder(orderId);
    }

    @RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
    public BookOrder getOrder(@PathVariable Long orderId) {
        return bookOrderService.getOrder(orderId);
    }

    @RequestMapping(value = "/{orderId}", method = RequestMethod.DELETE)
    public void deleteOrder(@PathVariable Long orderId) {
        bookOrderService.deleteOrder(orderId);
    }
}
