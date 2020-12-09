import { Injectable } from '@angular/core';
import {Reservering} from '../model/Reservering';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReserveringService {
  readonly API_URL = 'http://localhost:9080/HoestschaamteBackEnd-1.0-SNAPSHOT/resources';

  constructor(private httpClient: HttpClient) { }

  getReserveringen(): Observable<Reservering[]> {
    const url = this.API_URL + '/reserveringen/';
    return this.httpClient.get<Reservering[]>(url);
  }
}
