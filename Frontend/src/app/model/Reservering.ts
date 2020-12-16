import {Persoon} from './Persoon';
import {Tafel} from './Tafel';

export interface Reservering {
  id?: number;
  datum: string;
  tijdSlot: number;
  code?: string;
  aantalPersonen: number;
  contactpersoon: Persoon;
  tafel?: Tafel;
}
