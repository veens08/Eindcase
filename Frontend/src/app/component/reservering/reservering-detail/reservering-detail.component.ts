import {AfterViewInit, Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Reservering} from '../../../model/Reservering';
import {ReserveringService} from '../../../service/reservering/reservering.service';
import {Location} from '@angular/common';
import {Angular2MaterializeV1Service} from 'angular2-materialize-v1';
import {IModal} from 'angular2-materialize-v1/lib/IInstance';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Persoon} from '../../../model/Persoon';
import {BezoekService} from '../../../service/bezoek/bezoek.service';
import {Bezoek} from '../../../model/Bezoek';

@Component({
  selector: 'app-reservering-detail',
  templateUrl: './reservering-detail.component.html',
  styleUrls: ['./reservering-detail.component.scss']
})
export class ReserveringDetailComponent implements OnInit, AfterViewInit {

  constructor(private route: ActivatedRoute,
              private reserveringService: ReserveringService,
              private location: Location,
              private angular2MaterializeService: Angular2MaterializeV1Service,
              private bezoekService: BezoekService,
              private router: Router) { }
  id: string;
  reservering: Reservering;
  modal: IModal;
  gasten: Persoon[] = [];
  bezoek: Bezoek;
  isKlachtSwitchVoorContactpersoonChecked: boolean;
  isKlachtSwitchVoorExtraGastChecked: boolean;

  persoonRegistratieForm = new FormGroup({
    naam: new FormControl('', [
      Validators.required,
      Validators.pattern('^[a-zA-Z.\'][a-zA-Z.\']*$'),
    ]),
    telNr: new FormControl('', [
      Validators.required,
      Validators.minLength(10),
      Validators.maxLength(10),
      Validators.pattern('[0-9]+')
    ]),
    email: new FormControl('', [
      Validators.required,
      Validators.pattern('^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$')
    ])
  });

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.isKlachtSwitchVoorContactpersoonChecked = true;
    this.isKlachtSwitchVoorExtraGastChecked = true;
    this.reserveringService.getById(this.id).subscribe(r => {
      this.reservering = r;
      this.bezoek = {
        datum: r.datum,
        tijdSlot: r.tijdSlot,
        tafel: r.tafel,
        gasten: []
      };
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
    this.gasten.push(newPersoon);
    this.persoonRegistratieForm.reset();
    this.modal.close();
    console.log(this.gasten);
  }

  isAantalPersonenBereikt(): boolean {
    return this.gasten.length + 1 >= this.reservering.aantalPersonen;
  }

  /**
   * Deze methode verwijdert een persoon van de gasten lijst
   * @param p van type Persoon
   */
  removePersoon(p: Persoon): void {
    // bepaal index van de te verwijderen persoon
    const indexPersoon = this.gasten.indexOf(p);
    // "Als persoon is gevonden"
    if (indexPersoon > -1){
      this.gasten.splice(indexPersoon, 1);
    }
  }

  AddBezoek(): void {
    this.bezoek.gasten = this.gasten;
    this.bezoek.gasten.push(this.reservering.contactpersoon);
    this.bezoekService.save(this.bezoek).subscribe();
    this.router.navigate(['/reserveringen']);
  }

  /**
   * Deze methode wordt aangeroepen op het moment dat er een verandering plaatsvindt bij een selectbox
   * Hij verandert de defaultwaardes van booleans in de klasse
   * @param event JS event
   */
  onChangeKlachtSwitch(event): void {
    if (event.target.id === 'klachtSwitchContactpersoon') {
      this.isKlachtSwitchVoorContactpersoonChecked = event.target.checked;
    } else if (event.target.id === 'klachtSwitchExtraGast') {
      this.isKlachtSwitchVoorExtraGastChecked = event.target.checked;
    }
  }
}
