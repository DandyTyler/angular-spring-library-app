import {Component, Input, OnInit} from '@angular/core';

import {ActivatedRoute, Params} from "@angular/router";
import {GenreService} from "../../../shared/services/genre.service";

@Component({
  selector: 'book-filter',
  templateUrl: './book-filter.component.html',
  styleUrls: ['./book-filter.component.css']
})
export class BookFilterComponent implements OnInit {

  genres$;

  params: Params;

  @Input('genreId') genreId;

  constructor( route: ActivatedRoute,genreService: GenreService) {
    this.genres$ = genreService.getAll();
    this.params = route.snapshot.params;
  }

  ngOnInit() {
  }

}
