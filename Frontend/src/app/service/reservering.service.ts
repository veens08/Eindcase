import { Injectable } from '@angular/core';
import {Reservering} from '../model/Reservering';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReserveringService {
  private readonly API_URL = 'http://localhost:9081/HoestschaamteBackEnd-1.0-SNAPSHOT/resources/reserveringen';

  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<Reservering[]> {
    const url = this.API_URL + '/';
    return this.httpClient.get<Reservering[]>(url);
  }

  getById(id: string): Observable<Reservering> {
    const url = this.API_URL + '/' + id;
    return this.httpClient.get<Reservering>(url);
  }

  save(reservering: Reservering): Observable<any> {
    const contentTypeHeader = new HttpHeaders({contentType: 'application/json'});
    const observableResponse = this.httpClient.post(this.API_URL + '/add', reservering, {headers: contentTypeHeader});
    return observableResponse;
  }
}
