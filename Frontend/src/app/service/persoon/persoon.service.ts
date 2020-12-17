import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Persoon} from '../../model/Persoon';

@Injectable({
  providedIn: 'root'
})
export class PersoonService {

  private readonly API_URL = 'http://localhost:9081/HoestschaamteBackEnd-1.0-SNAPSHOT/resources/personen';

  constructor(private httpClient: HttpClient) { }

  getById(id: number): Observable<Persoon> {
    const url = this.API_URL + '/' + id;
    return this.httpClient.get<Persoon>(url);

  }

  getPersonenByDatumTijdSlotAndTafelCluster(datum: string, tijdslot: string, tafelcluster: string): Observable<Persoon[]> {
    const params = new HttpParams()
      .set('datum', datum)
      .set('tijdslot', tijdslot)
      .set('tafelcluster', tafelcluster);
    const url = this.API_URL + '/search';
    console.log(url);
    return this.httpClient.get<Persoon[]>(url, {params});
  }
}
