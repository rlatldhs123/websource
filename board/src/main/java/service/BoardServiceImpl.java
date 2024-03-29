package service;

import java.util.List;

import dao.BoardDao;
import dto.BoardDto;
import dto.SearchDto;

public class BoardServiceImpl implements BoardService {

    BoardDao dao = new BoardDao();

    @Override
    public List<BoardDto> getList(SearchDto searchDto) {
        return dao.getList(searchDto);

    }

    @Override
    public BoardDto getRow(int bno) {
        return dao.getRow(bno);

    }

    @Override
    public boolean update(BoardDto updateDto) {

        return dao.update(updateDto) == 1;

    }

    @Override
    public boolean delete(BoardDto deleteDto) {
        return dao.delete(deleteDto) == 1;

    }

    @Override
    public boolean reply(BoardDto replyDto) {
        return dao.reply(replyDto) == 1;

    }

    @Override
    public boolean updateRead(int readDto) {

        return dao.updateRead(readDto) == 1;

    }

    @Override
    public List<BoardDto> getSearchList(SearchDto searchDto) {

        return dao.getSearchList(searchDto);

    }

    @Override
    public boolean insert(BoardDto insertDto) {

        return dao.insert(insertDto) == 1;

    }

    @Override
    public int getRows(String criteria, String ketword) {

        return dao.getRows(criteria, ketword);

    }

    @Override
    public boolean deleteAll(int re_ref) {
        return dao.deleteAll(re_ref) == 1;

    }

    @Override
    public boolean pwdCheck(BoardDto passDto) {
        return dao.pwdCheck(passDto) == 1;

    }

}
