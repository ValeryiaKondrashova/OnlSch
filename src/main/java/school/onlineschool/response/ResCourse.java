package school.onlineschool.response;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ResCourse {

    private Long id;
    private String nameCourse;
    private int duration;
    private double price;
}
