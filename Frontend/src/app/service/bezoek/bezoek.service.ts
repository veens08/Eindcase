import { Injectable } from '@angular/core';
import {Bezoek} from '../../model/Bezoek';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Persoon} from '../../model/Persoon';

@Injectable({
  providedIn: 'root'
})
export class BezoekService {

  private readonly API_URL = 'http://localhost:9081/HoestschaamteBackEnd-1.0-SNAPSHOT/resources/bezoeken';

  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<Bezoek[]> {
    const url = this.API_URL + '/';
    return this.httpClient.get<Bezoek[]>(url);
  }

  save(bezoek: Bezoek): Observable<any> {
    const contentTypeHeader = new HttpHeaders({contentType: 'application/json'});
    return this.httpClient.post(this.API_URL + '/add', bezoek, {headers: contentTypeHeader});
  }

  getBezoekByDatumTijdSlotAndTafelCluster(datum: string, tijdslot: string, tafelcluster: string): Observable<Bezoek[]> {
    const params = new HttpParams()
      .set('datum', datum)
      .set('tijdslot', tijdslot)
      .set('tafelcluster', tafelcluster);
    const url = this.API_URL + '/search';
    console.log(url);
    return this.httpClient.get<Bezoek[]>(url, {params});
  }
}
