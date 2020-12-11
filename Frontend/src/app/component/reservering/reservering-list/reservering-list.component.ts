import { Component, OnInit } from '@angular/core';
import {Reservering} from '../../../model/Reservering';
import {ReserveringService} from '../../../service/reservering.service';

@Component({
  selector: 'app-reservering',
  templateUrl: './reservering-list.component.html',
  styleUrls: ['./reservering-list.component.scss']
})
export class ReserveringListComponent implements OnInit {
  reserveringen: Reservering[];

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
