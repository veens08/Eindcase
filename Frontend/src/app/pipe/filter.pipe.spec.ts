import { FilterPipe } from './filter.pipe';
import {Persoon} from '../model/Persoon';

describe('FilterPipe', () => {
  it('create an instance', () => {
    const pipe = new FilterPipe();
    expect(pipe).toBeTruthy();
  });

  it('create an instance', () => {
    const pipe = new FilterPipe();
    const p: Persoon = { naam: 'Joshua', telNr: '098765431' };
    expect(pipe.isPersoon(p)).toBeTrue();
  });
});
