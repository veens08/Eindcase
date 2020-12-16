import {Persoon} from './Persoon';
import {Tafel} from './Tafel';

export interface Bezoek {
  id?: number;
  datum: string;
  tijdSlot: number;
  gasten: Persoon[];
  tafel: Tafel;
}
