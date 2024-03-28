package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor

public class SearchDto {

    private int page;
    private int amount;

    private String criteria;
    private String keyword;

    public SearchDto(int page, int amount) {
        this.page = page;
        this.amount = amount;

    }

}
