
package at.itkolleg.Temp_Test.controller;

import at.itkolleg.Temp_Test.domain.Messdaten;
import at.itkolleg.Temp_Test.exceptions.DatenNichtGefunden;
import at.itkolleg.Temp_Test.service.MessdatenService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/Messdaten")
public class MessdatenController {

    public MessdatenService messdatenService;
    public MessdatenController(MessdatenService messdatenService) {this.messdatenService = messdatenService;}



    @PostMapping
    public ResponseEntity<Messdaten> messdatenEinfuegen(@Valid @RequestBody Messdaten messdaten){

        return ResponseEntity.ok(this.messdatenService.messDatenAnlegen(messdaten));

    }


    @GetMapping
    public ResponseEntity<List<Messdaten>> gibAlleMessdaten(){
        return ResponseEntity.ok(this.messdatenService.alleMessdaten());



    }

        @GetMapping("/mitStation/{messStation}")
        public ResponseEntity<List<Messdaten>> alleMessdatenmitStation(@PathVariable String messStation) {

            return ResponseEntity.ok(this.messdatenService.alleMessdatenNachStation(messStation));

        }

    @GetMapping("/{id}")
    public ResponseEntity<Messdaten> datenMitId(@PathVariable Long id) throws DatenNichtGefunden {

        return ResponseEntity.ok(this.messdatenService.datenNachId(id));
    }

    @DeleteMapping("/{id}")
    public String Datenloeschen(@PathVariable Long id) {
    this.messdatenService.messdatenLoeschenMitId(id);
    return "Daten gelöscht!";
    }




}







