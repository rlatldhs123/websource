package service;

import java.util.List;

import dto.BoardDto;
import dto.SearchDto;

public interface BoardService {

    List<BoardDto> getList(SearchDto searchDto);

    BoardDto getRow(int bno);

    boolean update(BoardDto updateDto);

    boolean delete(BoardDto deleteDto);

    boolean reply(BoardDto replyDto);

    boolean updateRead(int readDto);

    List<BoardDto> getSearchList(SearchDto SearchDto);

    boolean insert(BoardDto insertDto);

    int getRows(String criteria, String ketword);

    boolean deleteAll(int re_ref);

    boolean pwdCheck(BoardDto passDto);

}
