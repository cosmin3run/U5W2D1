package epicode.U5W2D1.entities;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BlogPost {
    private int id;
    private String category;
    private String title;
    private String cover;
    private String content;
    private int readTime;


}

