import {AfterViewInit, Component, OnInit} from '@angular/core';
import {Reservering} from '../../../model/Reservering';
import {ReserveringService} from '../../../service/reservering/reservering.service';
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
      Validators.required,
      Validators.pattern('^[a-zA-Z.\'][a-zA-Z.\']*$'),
    ]),
    telNr: new FormControl('', [
      Validators.required,
      // Validators.pattern('/^(((0)[1-9]{2}[0-9][-]?[1-9][0-9]{5})|((\\\\+31|0|0031)[1-9][0-9][-]?[1-9][0-9]{6}))$/')
    ]),
    email: new FormControl('', [
      Validators.required,
      // Validators.pattern('/^([\\w-]+(?:\\.[\\w-]+)*)@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)$/i')
    ]),
    aantalPersonen: new FormControl('', [
      Validators.max(4),
      Validators.min(1)
    ]),
    tijdSlot: new FormControl('', [
      Validators.required
    ]),
    datum: new FormControl('', [
      Validators.required,
      Validators.min(Date.now())
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
