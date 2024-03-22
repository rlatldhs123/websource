package service;

import java.util.List;

import dao.BookDao;
import dto.BookDto;

public class BookServiceImpl implements BookService {

    // dao 를 호출 해야 하기 때문에 객체 하나 생성
    BookDao dao = new BookDao();

    @Override
    public BookDto read(int code) {
        return dao.getRow(code);

    }

    @Override
    public List<BookDto> listAll() {
        return dao.getList();

    }

    @Override
    public List<BookDto> searchlistAll(String criteria, String keyword) {
        return dao.getSearchList(criteria, keyword);

    }

    @Override
    public boolean create(BookDto inseDto) {
        return dao.insert(inseDto) == 1;

    }

    @Override
    public boolean update(BookDto inseDto) {
        return dao.update(inseDto) == 1;

    }

    @Override
    public boolean delete(int code) {
        return dao.delete(null) == 1;

    }

}
