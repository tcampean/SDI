package core.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class SceneDto extends BaseDto {
    @NonNull
    private String scenename;
}