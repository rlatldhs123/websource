package dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class BoardDto {

    private int bno;
    private String name;
    private String password;
    private String title;
    private String content;
    private String attach;
    private int reRef;
    private int reLev;
    private int reSeq;
    private int readCount;
    private Date regDate;

}
