package core.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class ScheduleDayDto extends BaseDto {
    @NonNull
    private String date;

    @NonNull
    private Long sceneid;

    @NonNull
    private Integer nrofparticipants;
}
