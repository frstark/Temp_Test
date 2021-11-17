package at.itkolleg.Temp_Test.service;

import at.itkolleg.Temp_Test.domain.Messdaten;
import at.itkolleg.Temp_Test.exceptions.DatenNichtGefunden;
import at.itkolleg.Temp_Test.repo.DBZugriffImpl;
import at.itkolleg.Temp_Test.repo.DBZugriffMessdaten;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessdatenServiceImpl implements MessdatenService{


    private DBZugriffMessdaten dbZugriffMessdaten;

    public MessdatenServiceImpl(DBZugriffMessdaten dbZugriffMessdaten) {this.dbZugriffMessdaten = dbZugriffMessdaten;}


    @Override
    public Messdaten messDatenAnlegen(Messdaten messdaten) {
        return this.dbZugriffMessdaten.messDatenAnlegen(messdaten);
    }

    @Override
    public List<Messdaten> alleMessdaten() {
        return this.dbZugriffMessdaten.alleMessdaten();
    }

    @Override
    public List<Messdaten> alleMessdatenNachStation(String messsStation) {
        return this.dbZugriffMessdaten.alleMessdatenNachStation(messsStation);
    }

    @Override
    public Messdaten datenNachId(Long id) throws DatenNichtGefunden {
        return this.dbZugriffMessdaten.datenNachId(id);
    }

    @Override
    public void messdatenLoeschenMitId(Long id) {
        this.dbZugriffMessdaten.messdatenLoeschenMitId(id);
    }
}
