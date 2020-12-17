import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {PersoonService} from '../../service/persoon/persoon.service';
import {Persoon} from '../../model/Persoon';
import {BezoekService} from '../../service/bezoek/bezoek.service';
import {Bezoek} from '../../model/Bezoek';
import {BesmettingRapportItem} from '../../model/BesmettingRapportItem';

@Component({
  selector: 'app-besmetting-report',
  templateUrl: './besmetting-report.component.html',
  styleUrls: ['./besmetting-report.component.scss']
})
export class BesmettingReportComponent implements OnInit {

  persoonId: number;
  datum: string;
  tijdslot: string;
  besmettingsRapportItems: BesmettingRapportItem[] = [];
  besmettePersoon: Persoon;
  tafelcluster: string;
  bezoeken: Bezoek[];

  constructor(private route: ActivatedRoute,
              private persoonService: PersoonService,
              private bezoekService: BezoekService) { }

  ngOnInit(): void {

    this.route.queryParams.subscribe(params => {
      this.persoonId = params.persoon;
      this.datum = params.datum;
      this.tijdslot = params.tijdslot;
      this.tafelcluster = params.tafelcluster;
      console.log(params);
    });

    console.log(this.tafelcluster);
    this.persoonService.getById(this.persoonId).subscribe(p => {
      this.besmettePersoon = p;
    });

    this.bezoekService.getBezoekByDatumTijdSlotAndTafelCluster(this.datum, this.tijdslot, this.tafelcluster).subscribe(b => {
      this.bezoeken = b;

      this.besmettingsRapportItems = this.maakBesmettingsRapportItemsAan(this.bezoeken);

    });
  }

  maakBesmettingsRapportItemsAan(bezoeken: Bezoek[]): BesmettingRapportItem[] {
    const items: BesmettingRapportItem[] = [];
    for (const bezoek of bezoeken) {
      console.log(bezoek);
      for (const persoon of bezoek.gasten) {
        const item: BesmettingRapportItem = {
          datum: bezoek.datum,
          tijdslot: bezoek.tijdSlot,
          tafelcluster: bezoek.tafel.cluster,
          tafelnummer: bezoek.tafel.nummer,
          naamGast: persoon.naam
        };
        items.push(item);
      }
      return items;
    }
  }
}
