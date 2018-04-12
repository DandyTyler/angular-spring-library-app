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

  content: File = null;
  fileSelected: boolean = false;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private genreService: GenreService,
              private authorService: AuthorService,
              private bookService: BookService) {
    genreService.getAll().subscribe(genres => this.genres = genres);

    this.authorService.getAll().subscribe(authors => this.authors = authors);

    this.id = this.route.snapshot.paramMap.get('id');
    if (this.id) this.bookService.get(this.id).take(1).subscribe(b => {
      this.book = b;
      this.fileSelected = true;
    });
  }

  save(book: Book) {

    if (this.id) {
      this.bookService.update(this.id, this.book).subscribe(updatedBook => this.router.navigate(['/admin/books']));
      if(this.content){
        this.bookService.updateContent(this.id, this.content).subscribe(()=> console.log("Success"))
      }
    }
    else {
      const fd = new FormData();
      fd.append('content', this.content, this.content.name);
      fd.append('book', new Blob([JSON.stringify(this.book)], {type: 'application/json'}));


      console.log(book);
      this.bookService.create(fd).subscribe(newBook => this.router.navigate(['/admin/books']));
    }

  }

  delete() {
    if (!confirm('Are you sure you want to delete this book?')) return;

    this.bookService.delete(this.id).subscribe(() => this.router.navigate(['/admin/books']));
  }

  onFileSelected(event) {
    if (event.target.files[0]) {
      this.content = <File> event.target.files[0];
      this.fileSelected = true;
    } else this.fileSelected = false;
  }

  ngOnInit() {
  }

}
