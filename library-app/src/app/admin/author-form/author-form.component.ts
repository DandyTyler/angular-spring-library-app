import {Component, OnInit} from '@angular/core';
import {Book} from "../../models/book";
import {AuthorService} from "../../services/author.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-author-form',
  templateUrl: './author-form.component.html',
  styleUrls: ['./author-form.component.css']
})
export class AuthorFormComponent implements OnInit {

  author = {};

  id;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private authorService: AuthorService) {

    this.id = this.route.snapshot.paramMap.get('id');
    if (this.id) this.authorService.get(this.id).take(1).subscribe(author => this.author = author);
  }

  save(author) {
    console.log(author);

    if (this.id)
      this.authorService.update(this.id, this.author).subscribe(updatedAuthor => console.log(updatedAuthor));
    else {
      this.authorService.create(author).subscribe(author => console.log(author))
    }
  }

  delete() {
    if (!confirm('Are you sure you want to delete this author? If you delete this author,' +
        ' all books written by this author will also be deleted')) return;

    this.authorService.delete(this.id).subscribe(()=>this.router.navigate(['/admin/authors']));
  }

  ngOnInit() {
  }

}
