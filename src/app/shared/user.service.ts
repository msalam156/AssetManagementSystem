import { Injectable } from '@angular/core';
import { Luser } from './luser';
import { Observable,of } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  //constructor() { }
   constructor(private httpClient:HttpClient) { }
  vaifyUser(luser:Luser) {
    console.log("service working");
    return this.httpClient.post('http://localhost:9090/api/login',luser);
  }
}
