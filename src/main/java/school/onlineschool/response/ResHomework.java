package school.onlineschool.response;


import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ResHomework {

    private Long id;
    private String taskHomework;
    private LocalDate dateTask;
    private LocalDate deadlineTask;

}
