import {Persoon} from './Persoon';
import {Tafel} from './Tafel';

export interface Bezoek {
  id?: number;
  datum: Date;
  tijdSlot: number;
  gasten: Persoon[];
  tafel: Tafel;
}
