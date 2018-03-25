import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import 'rxjs/add/operator/take';

import {GenreService} from "../../services/genre.service";
import {BookService} from "../../services/book.service";
import {Book} from "../../models/book";
import {Genre} from "../../models/genre";

@Component({
  selector: 'app-book-form',
  templateUrl: './book-form.component.html',
  styleUrls: ['./book-form.component.css'],
})
export class BookFormComponent implements OnInit {

  genres: Genre[];
  book = {};
  id;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private genreService: GenreService,
              private bookService: BookService) {
    genreService.getAll().subscribe(genres => this.genres = genres);

    this.id = this.route.snapshot.paramMap.get('id');
    if (this.id) this.bookService.get(this.id).take(1).subscribe(b => this.book = b);
  }

  save(book: Book) {
    if (this.id)
      this.bookService.update(this.id, this.book).subscribe(updatedBook => console.log(updatedBook));
    else {
      console.log(book);
      this.bookService.create(book).subscribe(newBook => console.log(newBook));
    }
    this.router.navigate(['/admin/books']);
  }

  delete() {
    if (!confirm('Are you sure you want to delete this book?')) return;

    this.bookService.delete(this.id).subscribe(()=>this.router.navigate(['/admin/books']));
  }

  ngOnInit() {
  }

}
