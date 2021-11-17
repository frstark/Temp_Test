package at.itkolleg.Temp_Test;

import at.itkolleg.Temp_Test.domain.Messdaten;
import at.itkolleg.Temp_Test.repo.DBZugriffMessdaten;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TempTestApplication implements ApplicationRunner {

	@Autowired
	DBZugriffMessdaten dbZugriffMessdaten;


	public static void main(String[] args) {
		SpringApplication.run(TempTestApplication.class, args);
	}


	@Override
	public void run(ApplicationArguments args) throws Exception {

		this.dbZugriffMessdaten.messDatenAnlegen(new Messdaten(3.5,"Zams"));
		this.dbZugriffMessdaten.messDatenAnlegen(new Messdaten(-1,"Innsbruck"));
		this.dbZugriffMessdaten.messDatenAnlegen(new Messdaten(-3.5,"Kufstein"));



	}
}
