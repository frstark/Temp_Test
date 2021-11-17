package at.itkolleg.Temp_Test.domain;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Messdaten {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    @NotNull
    private double temp;

    @Size(min = 2)
    @NotNull
    private String messStation;

    public Messdaten(double temp, String messStation) {
        this.temp = temp;
        this.messStation = messStation;
    }
}
