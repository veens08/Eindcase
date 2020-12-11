import { Component, OnInit } from '@angular/core';
import {ReserveringService} from '../../../service/reservering.service';
import {Location} from '@angular/common';

@Component({
  selector: 'app-reservering-create',
  templateUrl: './reservering-create.component.html',
  styleUrls: ['./reservering-create.component.scss']
})
export class ReserveringCreateComponent implements OnInit {

  constructor(private reserveringService: ReserveringService, private location: Location) { } // TODO: maak deze aan in lijst van reserveringen

  ngOnInit(): void {
  }

  gaPaginaTerug(): void {
    this.location.back();
  }
}
