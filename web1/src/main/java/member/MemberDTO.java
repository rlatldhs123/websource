package member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor // 디폴트 생성자
@AllArgsConstructor // 전체 생성자
@ToString
@Setter
@Getter
public class MemberDTO {

    private String userid;
    private String password;
    private String name;

}
