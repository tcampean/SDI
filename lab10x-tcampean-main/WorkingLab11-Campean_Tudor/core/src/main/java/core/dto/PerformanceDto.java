package core.dto;

import lombok.*;

import javax.persistence.Column;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class PerformanceDto extends BaseDto{

    @NonNull
    private Long artistid;

    @NonNull
    private Long dayid;

    @NonNull
    private String startingtime;

    @NonNull
    private String endingtime;
}
