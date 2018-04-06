import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {BookService} from "../services/book.service";
import {AuthService} from "../services/auth.service";
import {UserService} from "../services/user.service";
import {Book} from "../models/book";

@Component({
  selector: 'book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.css']
})
export class BookDetailsComponent implements OnInit {

  bookId;

  book = {};

  userVoteValue = 0;

  voted: boolean = false;

  constructor(private route: ActivatedRoute, private router: Router, bookService: BookService, private authService: AuthService,
              private userService: UserService) {
    this.bookId = this.route.snapshot.paramMap.get('id');

    bookService.get(this.bookId).subscribe(book => {
      this.book = book;
    });

    if(this.authService.isAuthenticated())
      userService.getVote(this.authService.getCurrentUser().sub, this.bookId).subscribe(
        (vote: any) => {
          if (vote.value != 0)
            this.voted = true;

          this.userVoteValue = vote.value;
        }
      )
  }

  vote() {

    if (!this.authService.isAuthenticated()){
      this.router.navigate(['/login'],{queryParams:{returnUrl: location.pathname}});
      return;
    }

    let vote = {
      "bookId": this.bookId,
      "username": this.authService.getCurrentUser().sub,
      "value": this.userVoteValue
    };

    this.userService.voteBook(vote).subscribe((vote: any) => {
      this.userVoteValue = vote.value;
      this.voted = true;
    });
  }

  ngOnInit() {
  }

}
