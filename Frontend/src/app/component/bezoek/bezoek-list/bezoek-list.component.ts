import { Component, OnInit } from '@angular/core';
import {Bezoek} from '../../../model/Bezoek';
import {BezoekService} from '../../../service/bezoek/bezoek.service';

@Component({
  selector: 'app-bezoek-list',
  templateUrl: './bezoek-list.component.html',
  styleUrls: ['./bezoek-list.component.scss']
})
export class BezoekListComponent implements OnInit {
  searchCriterium = '';
  bezoeken: Bezoek[] = [];

  constructor(private bezoekService: BezoekService) { }

  ngOnInit(): void {
    this.bezoekService.getAll().subscribe(b => {
      this.bezoeken = b;
    });
  }

}
