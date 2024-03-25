package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class ChangeDto {

    private String userid;
    private String password;// 현재 비밀번호
    private String newPassword; // 새 비밀번호
    private String cofirmPassword; // 변경 비밀번호 확인

    public boolean newPasswordEqualsConfirmPassword() {
        return newPassword.equals(cofirmPassword);
    }

}
