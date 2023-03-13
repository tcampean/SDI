package core.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "scene")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Scene extends BaseEntity<Long>{
    private String scenename;

}
