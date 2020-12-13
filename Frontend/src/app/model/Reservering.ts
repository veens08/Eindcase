import {Persoon} from './Persoon';

export interface Reservering {
  id?: number;
  reserveringsDatum: Date;
  tijdSlot: number;
  code?: string;
  aantalPersonen: number;
  contactpersoon: Persoon;
}
