import { Pipe, PipeTransform } from '@angular/core';
import {Persoon} from '../model/Persoon';

@Pipe({
  name: 'bezoekFilter'
})
export class BezoekFilterPipe implements PipeTransform {

  transform(bezoeken, searchCriterium: any): any {
    const filteredList = [];
    // Als er een zoekquery wordt uitgevoerd..
    if (searchCriterium) {
      // Converteer dan de query naar een string als het een nummerieke waarde is
      // of verander de string in hoofdletters en geef deze uiteindelijk terug
      const newSearchCriterium = !isNaN(searchCriterium) ? searchCriterium.toString() : searchCriterium.toString().toUpperCase();
      let data;
      // Let the filtering begin... Itereer eerst over de lijst van reserveringen
      return bezoeken.filter(b => {
        // Itereer daarna over de properties van een reservering
        for (const property in b) {
          // console.log(property);
          // if (property. === 'gasten') {
          //   console.log('PERSONEN: ' + b[property]);
          // }
          // Is deze property van het type Persoon? Stuur dan (alleen) de naam terug
          // if (this.isPersoon(b[property])) {
          //   const p: Persoon = b[property];
          //   data = p.naam.toUpperCase();
          //   // .. zo niet, stuur dan de waarde van de property (r[property]) in hoofdletters terug
          // } else {
            data = isNaN(b[property]) ? b[property].toString().toUpperCase() : b[property].toString();
          // }
          // Vervolgens controleren we of de waarde vd property een deel bevat van de zoekquery
          if (data.indexOf(newSearchCriterium) > -1) {
            // Zo ja, voeg de reservering toe
            filteredList.push(b);
            return filteredList;
          }
        }
      });
      // Als er GEEN zoekquery wordt uitgevoerd, geef dan de initiele lijst van reserveringen terug
    } else {
      return bezoeken;
    }
  }

}
