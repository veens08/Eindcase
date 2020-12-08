import { Injectable } from '@angular/core';
import {Reservering} from '../model/Reservering';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReserveringService {
  readonly API_URL = 'http://localhost:9080/HoestschaamteBackEnd-1.0-SNAPSHOT/';

  constructor(private httpClient: HttpClient) { }

  getReserveringen(): Observable<Reservering[]> {
    // json-server --watch db/reserveringen.json
    const url = 'http://localhost:3000/reserveringen'; // todo: gebruik (this.url + 'resourcelink') als backendresource klaar is
    return this.httpClient.get<Reservering[]>(url);
  }
}
