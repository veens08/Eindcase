import {AfterViewInit, Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {Reservering} from '../../../model/Reservering';
import {ReserveringService} from '../../../service/reservering/reservering.service';
import {Location} from '@angular/common';
import {Angular2MaterializeV1Service} from 'angular2-materialize-v1';
import {IModal} from 'angular2-materialize-v1/lib/IInstance';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Persoon} from '../../../model/Persoon';

@Component({
  selector: 'app-reservering-detail',
  templateUrl: './reservering-detail.component.html',
  styleUrls: ['./reservering-detail.component.scss']
})
export class ReserveringDetailComponent implements OnInit, AfterViewInit {

  constructor(private route: ActivatedRoute,
              private reserveringService: ReserveringService,
              private location: Location,
              private angular2MaterializeService: Angular2MaterializeV1Service) { }
  id: string;
  reservering: Reservering;
  modal: IModal;
  personen: Persoon[] = [];

  persoonRegistratieForm = new FormGroup({
    naam: new FormControl('', [
      Validators.required
    ]),
    telNr: new FormControl('', [
      Validators.required
    ]),
    email: new FormControl('', [
      Validators.required
    ])
  });

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.reserveringService.getById(this.id).subscribe(r => {
      this.reservering = r;
    });
  }

  ngAfterViewInit(): void {
    this.modal = (this.angular2MaterializeService.initModal('#persoonRegistratieModal') as IModal);
  }

  gaPaginaTerug(): void {
    this.location.back();
  }

  addPersoon(): void {
    const newPersoon: Persoon = {
      naam: this.persoonRegistratieForm.value.naam,
      telNr: this.persoonRegistratieForm.value.telNr,
      email: this.persoonRegistratieForm.value.email
    };
    this.personen.push(newPersoon);
    this.persoonRegistratieForm.reset();
    this.modal.close();
  }

  isAantalPersonenBereikt(): boolean {
    return this.personen.length + 1 >= this.reservering.aantalPersonen;
  }

  removePersoon(p: Persoon): void {
    // TODO: wil je deze afmaken Sjoerd? Ik ga slapen...
  }
}
