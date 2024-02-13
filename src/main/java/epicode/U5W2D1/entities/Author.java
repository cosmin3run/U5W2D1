package epicode.U5W2D1.entities;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Author {

    private int id;
    private String name;
    private String surname;
    private String email;
    private String dateBirth;
    private String avatar;

}
