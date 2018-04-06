import { Component, OnInit } from '@angular/core';
import {Author} from "../../models/author";
import {Subscription} from "rxjs/Subscription";
import {DataTableResource} from "angular5-data-table";
import {AuthorService} from "../../services/author.service";
import {Book} from "../../models/book";

@Component({
  selector: 'app-admin-authors',
  templateUrl: './admin-authors.component.html',
  styleUrls: ['./admin-authors.component.css']
})
export class AdminAuthorsComponent {

  authors : Author[];

  subscription: Subscription;

  tableResource : DataTableResource<Author>;

  items: Author[] = [];
  itemCount: number;

  constructor(private authorService : AuthorService) {
    this.subscription = this.authorService.getAll().subscribe(authors=>{
      this.authors = authors;
      this.initializeTable(authors)
    });
  }

  private initializeTable(authors: Author[]){
    this.tableResource = new DataTableResource(authors);
    this.tableResource.query({offset: 0})
      .then(items=> this.items = items);
    this.tableResource.count()
      .then(count=> this.itemCount = count);
  }

  reloadItems(params){
    if(!this.tableResource) return;

    this.tableResource.query(params)
      .then(items=> this.items = items);
  }

  filter(query: string) {
    let filteredAuthors = (query)?
      this.authors.filter(a=> a.fullName.toLowerCase().includes(query.toLowerCase())):
      this.authors;

    this.initializeTable(filteredAuthors)
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }

}
