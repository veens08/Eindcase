import { Component, OnInit } from '@angular/core';
import {Reservering} from '../../model/Reservering';
import {ReserveringService} from '../../service/reservering.service';

@Component({
  selector: 'app-bezoekers',
  templateUrl: './bezoekers.component.html',
  styleUrls: ['./bezoekers.component.scss']
})
export class BezoekersComponent implements OnInit {
  reserveringen: Reservering[];
  // bezoekers: Bezoek[];

  // constructor(private bezoekService: BezoekService) { }
  constructor(private reserveringService: ReserveringService) { }

  ngOnInit(): void {
    this.reserveringService.getAll().subscribe((r) => {
      console.log(r);
      this.reserveringen = r;
    });
  }

  getReserveringen(): Reservering[] {
    return this.reserveringen;
  }
}
