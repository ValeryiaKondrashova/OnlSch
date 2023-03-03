package school.onlineschool.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ResTeacher {

    private Long id;

    private String firstName;
    private String lastName;
    private String patronymic;
    private String birthday;
    private int experience;
    private String telephone;
    private String email;
}
