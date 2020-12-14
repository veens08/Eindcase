import {Persoon} from './Persoon';

export interface Reservering {
  id?: number;
  datum: Date;
  tijdSlot: number;
  code?: string;
  aantalPersonen: number;
  contactpersoon: Persoon;
}
