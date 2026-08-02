package model.dto.Usuario;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
public class LoginRequestDTO {

    private String username;
    private String password;
}
