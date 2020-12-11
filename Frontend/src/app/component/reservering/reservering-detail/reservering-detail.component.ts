import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {Reservering} from '../../../model/Reservering';
import {ReserveringService} from '../../../service/reservering.service';
import {Location} from '@angular/common';

@Component({
  selector: 'app-reservering-detail',
  templateUrl: './reservering-detail.component.html',
  styleUrls: ['./reservering-detail.component.scss']
})
export class ReserveringDetailComponent implements OnInit {

  constructor(private route: ActivatedRoute,
              private reserveringService: ReserveringService,
              private location: Location) { }
  id: string;
  reservering: Reservering;

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.reserveringService.getById(this.id).subscribe(r => {
      this.reservering = r;
    });
  }

  gaPaginaTerug(): void {
    this.location.back();
  }
}
