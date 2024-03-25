package service;

import java.util.List;

import dto.BookDto;
import dto.ChangeDto;
import dto.MemberDto;

public interface BookService {
    // 서비스 인터페이스는 dao 를 호출 하는 곳이다

    // crud - 조회,검색,사입,삭제, 수정
    BookDto read(int code);

    List<BookDto> listAll();

    List<BookDto> searchlistAll(String criteria, String keyword);

    boolean create(BookDto inseDto);

    boolean update(BookDto inseDto);

    boolean delete(int code);

    MemberDto isLogin(MemberDto loginDto);

    boolean passwordChange(ChangeDto changeDto);

    boolean register(MemberDto insertDto);

    boolean leave(MemberDto leaveDto);

}
