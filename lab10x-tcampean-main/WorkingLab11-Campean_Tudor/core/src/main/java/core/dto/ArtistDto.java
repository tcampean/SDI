package core.dto;

import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class ArtistDto extends BaseDto {
    @NonNull
    private String dateofbirth;
    @NonNull
    private String name;
    @NonNull
    private String genre;
}