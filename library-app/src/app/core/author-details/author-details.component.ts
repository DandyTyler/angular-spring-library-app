import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {AuthorService} from "../../shared/services/author.service";


@Component({
  selector: 'author-details',
  templateUrl: './author-details.component.html',
  styleUrls: ['./author-details.component.css']
})
export class AuthorDetailsComponent implements OnInit {

  authorId;

  author = null;

  constructor(private route: ActivatedRoute, authorService: AuthorService) {
    this.authorId = this.route.snapshot.paramMap.get('id');

    authorService.get(this.authorId).subscribe(author => this.author = author);
  }

  ngOnInit() {
  }

}
