import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, retry } from 'rxjs/operators';
import { throwError } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class SportyShoesService {


  constructor(private http: HttpClient) {

  }

  httpHeader = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  } 

  httpError(error: { error: { message: string; }; status: any; message: any; }) {
    let msg = '';
    if(error.error instanceof ErrorEvent) {
      // client side error
      msg = error.error.message;
    } else {
      // server side error
      msg = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    console.log(msg);
    return throwError(msg);
  }

  endPoint = "http://localhost:8080/";
   USER_NAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUser'

  validateLogin(email: string | "", password: string | undefined) {
    return this.http.post(this.endPoint + '/login', { email : email, password : password}, this.httpHeader)
    .pipe(map((res) => {
      this.registerSuccessfulLogin(email);
      retry(1),
      catchError(this.httpError)
    }))
  }

  registerSuccessfulLogin(email: string | "") {
    sessionStorage.setItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME, email);
  }

  logout() {
    sessionStorage.removeItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME);
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME)
    if (user === null) return false
    return true
  }
}
