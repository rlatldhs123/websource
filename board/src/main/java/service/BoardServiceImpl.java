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

}
