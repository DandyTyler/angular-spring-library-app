import {Genre} from "./genre";
import {Author} from "./author";

export class Book {
  constructor(public genre: Genre,
              public name: string,
              public authors: Author[],
              public publishYear: number,
              public imageURL: string,
              public description: string,
              public quantity: number,
              public rating: number) {
  }

}
