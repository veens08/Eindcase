import { Component, OnInit } from '@angular/core';
import {Reservering} from '../../model/Reservering';
import {ReserveringService} from '../../service/reservering/reservering.service';
import {Angular2MaterializeV1Service} from 'angular2-materialize-v1';
import {Bezoek} from '../../model/Bezoek';
import {BezoekService} from '../../service/bezoek/bezoek.service';

@Component({
  selector: 'app-startpagina',
  templateUrl: './startpagina.component.html',
  styleUrls: ['./startpagina.component.scss']
})
export class StartpaginaComponent implements OnInit {
  reserveringen: Reservering[];
  bezoeken: Bezoek[] = [];
  huidigeDatum = Date.now();

  constructor(private reserveringService: ReserveringService, private bezoekService: BezoekService){}

  ngOnInit(): void {
    this.bezoekService.getAll().subscribe(b => {
      this.bezoeken = b;
    });
    this.reserveringService.getAll().subscribe((r) => {
      this.reserveringen = r;
    });
  }

  getReserveringen(): Reservering[] {
    return this.reserveringen;
  }

  getBezoeken(): Bezoek[] {
    return this.bezoeken;
  }

}
