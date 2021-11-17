package at.itkolleg.Temp_Test.repo;


import at.itkolleg.Temp_Test.domain.Messdaten;
import at.itkolleg.Temp_Test.exceptions.DatenNichtGefunden;

import java.util.List;

public interface DBZugriffMessdaten {

    Messdaten messDatenAnlegen(Messdaten messdaten);
    List<Messdaten> alleMessdaten();
    List<Messdaten> alleMessdatenNachStation(String messsStation);
    Messdaten datenNachId(Long id) throws DatenNichtGefunden;
    void messdatenLoeschenMitId(Long id);



}
