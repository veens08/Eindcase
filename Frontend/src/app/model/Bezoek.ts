import {Persoon} from './Persoon';

export interface Bezoek {
  id?: number;
  datum: Date;
  tijdSlot: number;
  gasten: Persoon[];
}
