package dto;

import java.time.LocalDateTime;

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

public class ToDoDao {
    // 테이블 구조랑 동일하게 작성

    private int no;
    private String title;
    private LocalDateTime createdAt;
    private boolean completed;
    private String description;

    // CREATE TABLE todotbl (
    // NO number(8) PRIMARY KEY,
    // title nvarchar2(100) NOT NULL,
    // created_at DATE DEFAULT sysdate,
    // completed char(1) DEFAULT '0',
    // description nvarchar2(1000)
    // );

}
