import {Component, Input, OnInit} from '@angular/core';
import {GenreService} from "../../services/genre.service";
import {ActivatedRoute, Params} from "@angular/router";

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
