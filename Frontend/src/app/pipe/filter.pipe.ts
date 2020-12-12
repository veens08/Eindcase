import { Pipe, PipeTransform } from '@angular/core';
import {Persoon} from '../model/Persoon';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {

  /**
   * Deze methode controleert of het attribuut in een reservering van het type Persoon is
   * Dit door het attribuut te casten naar een Persoon type
   * Om vervolgens de attributen van Persoon te controleren of ze wel gedefinieerd zijn
   * @param attribuut van de reservering
   */
  isPersoon(attribuut: any): attribuut is Persoon {
    return (attribuut as Persoon).naam !== undefined
      || (attribuut as Persoon).telNr !== undefined
      || (attribuut as Persoon).email !== undefined;
  }

  transform(reserveringen, searchCriterium: any): any {
    const filteredList = [];
    // Als er een zoekquery wordt uitgevoerd..
    if (searchCriterium) {
      // Converteer dan de query naar een string als het een nummerieke waarde is
      // of verander de string in hoofdletters en geef deze uiteindelijk terug
      const newSearchCriterium = !isNaN(searchCriterium) ? searchCriterium.toString() : searchCriterium.toString().toUpperCase();
      let data;
      // Let the filtering begin... Itereer eerst over de lijst van reserveringen
      return reserveringen.filter(r => {
        // Itereer daarna over de properties van een reservering
        for (const property in r) {
          // Is deze property van het type Persoon? Stuur dan (alleen) de naam terug
          if (this.isPersoon(r[property])) {
            const p: Persoon = r[property];
            data = p.naam.toUpperCase();
          // .. zo niet, stuur dan de waarde van de property (r[property]) in hoofdletters terug
          } else {
            data = isNaN(r[property]) ? r[property].toString().toUpperCase() : r[property].toString();
          }
          // Vervolgens controleren we of de waarde vd property een deel bevat van de zoekquery
          if (data.indexOf(newSearchCriterium) > -1) {
            // Zo ja, voeg de reservering toe
            filteredList.push(r);
            return filteredList;
          }
        }
      });
    // Als er GEEN zoekquery wordt uitgevoerd, geef dan de initiele lijst van reserveringen terug
    } else {
      return reserveringen;
    }
  }

}

