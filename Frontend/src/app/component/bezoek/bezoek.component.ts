import { Component, OnInit } from '@angular/core';
import {Bezoek} from '../../model/Bezoek';
import {BezoekService} from '../../service/bezoek/bezoek.service';

@Component({
  selector: 'app-bezoekers',
  templateUrl: './bezoek.component.html',
  styleUrls: ['./bezoek.component.scss']
})
export class BezoekComponent implements OnInit {
  bezoeken: Bezoek[];

  constructor(private bezoekService: BezoekService) { }

  ngOnInit(): void {
    this.bezoekService.getAll().subscribe((b) => {
      console.log(b);
      this.bezoeken = b;
    });
  }
}
