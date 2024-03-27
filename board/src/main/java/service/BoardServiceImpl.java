package service;

import java.util.List;

import dao.BoardDao;
import dto.BoardDto;

public class BoardServiceImpl implements BoardService {

    BoardDao dao = new BoardDao();

    @Override
    public List<BoardDto> getList() {
        return dao.getList();

    }

    @Override
    public boolean create(BoardDto insertDto) {

        return dao.insert(insertDto) == 1;

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

}
