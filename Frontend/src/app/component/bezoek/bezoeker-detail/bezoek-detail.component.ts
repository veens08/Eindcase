import { Component, OnInit } from '@angular/core';
import {Bezoek} from '../../../model/Bezoek';
import {BezoekService} from '../../../service/bezoek/bezoek.service';

@Component({
  selector: 'app-bezoekers',
  templateUrl: './bezoek-detail.component.html',
  styleUrls: ['./bezoek-detail.component.scss']
})
export class BezoekDetailComponent implements OnInit {
  bezoeken: Bezoek[];

  constructor(private bezoekService: BezoekService) { }

  ngOnInit(): void {
    this.bezoekService.getAll().subscribe((b) => {
      console.log(b);
      this.bezoeken = b;
    });
  }
}
