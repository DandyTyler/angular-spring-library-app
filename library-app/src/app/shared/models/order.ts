export class Order {
  constructor(public id: number,
              public bookId: number,
              public username: string,
              public bookName: string,
              public orderDate: Date,
              public accepted: boolean,
              public returned: boolean,
              public returnDate: Date){

  }
}
