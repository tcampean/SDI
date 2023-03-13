package core.domain;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "scheduleday")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ScheduleDay extends BaseEntity<Long> {
    @NonNull
    @Column(name = "date")
    private String date;
    @NonNull
    @Column(name = "sceneid")
    private Long sceneid;
    @NonNull
    @Column(name = "nrofparticipants")
    private Integer nrofparticipants;
}
