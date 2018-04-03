import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import 'rxjs/add/operator/take';

import {GenreService} from "../../services/genre.service";
import {BookService} from "../../services/book.service";
import {Book} from "../../models/book";
import {Genre} from "../../models/genre";
import {Author} from "../../models/author";
import {AuthorService} from "../../services/author.service";

@Component({
  selector: 'app-book-form',
  templateUrl: './book-form.component.html',
  styleUrls: ['./book-form.component.css'],
})
export class BookFormComponent implements OnInit {

  genres: Genre[];
  authors: Author[];
  book = {};
  id;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private genreService: GenreService,
              private authorService: AuthorService,
              private bookService: BookService) {
    genreService.getAll().subscribe(genres => this.genres = genres);

    this.authorService.getAll().subscribe(authors=> this.authors = authors);

    this.id = this.route.snapshot.paramMap.get('id');
    if (this.id) this.bookService.get(this.id).take(1).subscribe(b => this.book = b);
  }

  save(book: Book) {
    console.log(this.book);
    if (this.id)
      this.bookService.update(this.id, this.book).subscribe(updatedBook =>  this.router.navigate(['/admin/books']));
    else {
      console.log(book);
      this.bookService.create(book).subscribe(newBook =>  this.router.navigate(['/admin/books']));
    }
  }

  delete() {
    if (!confirm('Are you sure you want to delete this book?')) return;

    this.bookService.delete(this.id).subscribe(()=>this.router.navigate(['/admin/books']));
  }

  ngOnInit() {
  }

}
