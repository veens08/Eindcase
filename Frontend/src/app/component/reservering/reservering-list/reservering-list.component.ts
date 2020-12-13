import {AfterViewInit, Component, OnInit} from '@angular/core';
import {Reservering} from '../../../model/Reservering';
import {ReserveringService} from '../../../service/reservering.service';
import {Angular2MaterializeV1Service} from 'angular2-materialize-v1';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Persoon} from '../../../model/Persoon';
import {IModal} from 'angular2-materialize-v1/lib/IInstance';

@Component({
  selector: 'app-reservering',
  templateUrl: './reservering-list.component.html',
  styleUrls: ['./reservering-list.component.scss']
})
export class ReserveringListComponent implements OnInit, AfterViewInit {
  reserveringen: Reservering[];
  searchCriterium = '';
  modal: IModal;

  constructor(private reserveringService: ReserveringService, private angular2MaterializeService: Angular2MaterializeV1Service){}

  reserveringForm = new FormGroup({
    naam: new FormControl('', [
      Validators.required
    ]),
    telNr: new FormControl('', [
      Validators.required
    ]),
    email: new FormControl('', [
      Validators.required
    ]),
    aantalPersonen: new FormControl('', [
      Validators.max(4)
    ]),
    tijdSlot: new FormControl('', [
      Validators.required
    ]),
    datum: new FormControl('', [
      Validators.required
    ])
  });

  ngOnInit(): void {
    this.reserveringService.getAll().subscribe((r) => {
      this.reserveringen = r;
    });
  }

  ngAfterViewInit(): void {
    this.modal = (this.angular2MaterializeService.initModal('#reserveringRegistratieModal') as IModal);
  }

  getReserveringen(): Reservering[] {
    return this.reserveringen;
  }

  addReservering(): void {
    const newPersoon: Persoon = {
      naam: this.reserveringForm.value.naam,
      telNr: this.reserveringForm.value.telNr,
      email: this.reserveringForm.value.email
    };
    const newReservering: Reservering = {
      contactpersoon: newPersoon,
      aantalPersonen: this.reserveringForm.value.aantalPersonen,
      tijdSlot: 2, // TODO: tijdslot moet bepaald worden aan de hand van de tijd die meegegeven wordt
      // tijdSlot: this.reserveringForm.value.tijdSlot,
      reserveringsDatum: this.reserveringForm.value.datum,
    };

    this.reserveringService.save(newReservering).subscribe(r => {
      this.reserveringen.push(r);
      this.reserveringForm.reset();
    });

    this.modal.close();
  }
}
