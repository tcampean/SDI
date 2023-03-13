package core.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "artist")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Artist extends BaseEntity<Long>{
    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "dateofbirth")
    private String dateofbirth;

    @NonNull
    @Column(name = "genre")
    private String genre;


}