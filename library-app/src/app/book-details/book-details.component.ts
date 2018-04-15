import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {BookService} from "../services/book.service";
import {AuthService} from "../services/auth.service";
import {UserService} from "../services/user.service";
import {Book} from "../models/book";
import {Vote} from "../models/vote";

@Component({
  selector: 'book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.css']
})
export class BookDetailsComponent implements OnInit {

  bookId;

  book = new Book(null,null,null,null,null,null,null);

  userVote = new Vote(null,null,null,null);

  voted: boolean = false;

  votes: Vote[] = [];

  constructor(private route: ActivatedRoute, private router: Router, private bookService: BookService, private authService: AuthService,
              private userService: UserService) {
    this.bookId = this.route.snapshot.paramMap.get('id');

    if(this.authService.isAuthenticated())
      userService.getVote(this.authService.getCurrentUser().sub, this.bookId).subscribe(
        (vote: any) => {
          if (vote.value != 0)
            this.voted = true;

          this.userVote = vote;
        }
      );

    bookService.get(this.bookId).subscribe(book => {
      this.book = book;
    });

    bookService.getVotes(this.bookId).subscribe(votes=> this.votes = votes.reverse());

  }

  vote() {
    if (!this.authService.isAuthenticated()){
      this.router.navigate(['/login'],{queryParams:{returnUrl: location.pathname}});
      return;
    }

    this.userVote.bookId =this.bookId;
    this.userVote.username = this.authService.getCurrentUser().sub;

    this.userService.voteBook(this.userVote).subscribe((vote: any) => {
      this.userVote = vote;
      this.voted = true;
      this.votes.splice(0,0,vote);
    });
  }

  ngOnInit() {
  }

}
