import {AfterViewInit, Component, OnInit} from '@angular/core';
import {Bezoek} from '../../../model/Bezoek';
import {BezoekService} from '../../../service/bezoek/bezoek.service';
import {Persoon} from '../../../model/Persoon';
import {ReserveringService} from '../../../service/reservering/reservering.service';
import {Angular2MaterializeV1Service} from 'angular2-materialize-v1';
import {IModal, ISelect} from 'angular2-materialize-v1/lib/IInstance';
import {Router} from '@angular/router';

@Component({
  selector: 'app-bezoek-list',
  templateUrl: './bezoek-list.component.html',
  styleUrls: ['./bezoek-list.component.scss']
})
export class BezoekListComponent implements OnInit, AfterViewInit {
  searchCriterium = '';
  bezoeken: Bezoek[] = [];
  gasten: Persoon[] = [];
  modal: IModal;
  potentieleBesmettingBezoek: Bezoek;

  constructor(private bezoekService: BezoekService,
              private angular2MaterializeService: Angular2MaterializeV1Service,
              private router: Router){}

  ngOnInit(): void {
    this.bezoekService.getAll().subscribe(b => {
      this.bezoeken = b;
    });
  }

  ngAfterViewInit(): void {
    this.modal = (this.angular2MaterializeService.initModal('#besmettingModal') as IModal);
  }


  besmettingDoorvoeren(p: Persoon): void {
    this.router.navigate(['/besmetting-report']);
  }

  initializeBezoek(b: Bezoek): void {
    this.potentieleBesmettingBezoek = b;
    this.gasten = b.gasten;
  }
}
