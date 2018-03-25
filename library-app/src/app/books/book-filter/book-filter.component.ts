import {Component, Input, OnInit} from '@angular/core';
import {GenreService} from "../../services/genre.service";

@Component({
  selector: 'book-filter',
  templateUrl: './book-filter.component.html',
  styleUrls: ['./book-filter.component.css']
})
export class BookFilterComponent implements OnInit {

  genres$;

  @Input('genreId') genreId;

  constructor(genreService: GenreService) {
    this.genres$ = genreService.getAll();
  }

  ngOnInit() {
  }

}
