package at.itkolleg.Temp_Test.repo;

import at.itkolleg.Temp_Test.domain.Messdaten;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessdatenRpoJPA extends JpaRepository<Messdaten, Long> {
     List<Messdaten> findAllByMessStation(String messsStation);


}
