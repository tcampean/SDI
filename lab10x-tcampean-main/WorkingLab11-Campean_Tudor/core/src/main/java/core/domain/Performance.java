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
@Table(name = "performance")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)

public class Performance extends BaseEntity<Long> {

    @NonNull
    @Column(name = "artistid")
    private Long artistid;

    @NonNull
    @Column(name = "dayid")
    private Long dayid;

    @NonNull
    @Column(name = "startingtime")
    private String startingtime;

    @NonNull
    @Column(name = "endingtime")
    private String endingtime;
}
