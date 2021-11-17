
package at.itkolleg.Temp_Test.repo;

import at.itkolleg.Temp_Test.domain.Messdaten;
import at.itkolleg.Temp_Test.exceptions.DatenNichtGefunden;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Component
public class DBZugriffImpl implements DBZugriffMessdaten{

    private  MessdatenRpoJPA messdatenRpoJPA;

    public DBZugriffImpl(MessdatenRpoJPA messdatenRpoJPA) {this.messdatenRpoJPA = messdatenRpoJPA;}

    @Override
    public Messdaten messDatenAnlegen(Messdaten messdaten) {
        return this.messdatenRpoJPA.save(messdaten);
    }

    @Override
    public List<Messdaten> alleMessdaten() {
        return this.messdatenRpoJPA.findAll();
    }

    @Override
    public List<Messdaten> alleMessdatenNachStation(String messsStation) {
        return this.messdatenRpoJPA.findAllByMessStation(messsStation);
    }

    @Override
    public Messdaten datenNachId(Long id) throws DatenNichtGefunden {
        Optional<Messdaten> optMessdaten = this.messdatenRpoJPA.findById(id);
        if(optMessdaten.isPresent()){
            return optMessdaten.get();

        }else {
        throw new DatenNichtGefunden("Daten mit der ID " + id + " nicht gefunden.");
        }
    }

    @Override
    public void messdatenLoeschenMitId(Long id) {
        this.messdatenRpoJPA.deleteById(id);
    }
}
