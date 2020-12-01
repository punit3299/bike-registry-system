import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const httpOptions = {
  headers: new Headers({ 'Content-Type': 'application/json' })
}

@Injectable({
  providedIn: 'root'
})
export class BikeService {

  constructor(private http: HttpClient) { }

  getBikes(){
    return this.http.get("/server/api/v1/bikes");
  }
}
