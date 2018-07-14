export class Vote {
  constructor( public bookId: number,
               public username : string,
               public value: number,
               public comment: string){}
}
