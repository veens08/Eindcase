import { Component, OnInit } from '@angular/core';
import {Reservering} from '../../model/Reservering';
import {ReserveringService} from '../../service/reservering.service';

@Component({
  selector: 'app-reservering',
  templateUrl: './reservering.component.html',
  styleUrls: ['./reservering.component.scss']
})
export class ReserveringComponent implements OnInit {
  reserveringen: Reservering[];

  constructor(private reserveringService: ReserveringService) { }

  ngOnInit(): void {
    this.reserveringService.getReserveringen().subscribe((r) => {
      console.log(r);
      this.reserveringen = r;
    });
  }

  getReserveringen(): Reservering[] {
    return this.reserveringen;
  }
}
