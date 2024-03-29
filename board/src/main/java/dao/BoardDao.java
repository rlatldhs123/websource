package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.BoardDto;
import dto.SearchDto;

public class BoardDao {

    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;

    static {
        try {
            Class.forName("oracle.jdbc.OracleDriver");

        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
    }

    // 2. 커넥션 얻기

    public Connection getConnection() {

        // "java:/comp/env"; : 등록된 이름 관리
        Context initContext;
        try {
            initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
            con = ds.getConnection();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return con;

    }

    // 전체 게시물 개수 가져오기

    public int getRows(String criteria, String ketword) {
        int total = 0;

        try {
            con = getConnection();

            String sql = "";

            if (criteria.isEmpty()) {

                sql += "SELECT count(*) FROM BOARD b ";
                pstmt = con.prepareStatement(sql);

            } else {

                sql += "SELECT count(*) FROM BOARD b where " + criteria + "like ?";
                pstmt.setString(1, "%" + ketword + "%");
                pstmt = con.prepareStatement(sql);

            }

            rs = pstmt.executeQuery();

            if (rs.next()) {

                total = rs.getInt(1);

            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            // 자원 닫아주기
            close(con, pstmt, rs);
        }
        return total;

    }

    // 전체 리스트 가져오기

    public List<BoardDto> getList(SearchDto searchDto) {
        List<BoardDto> list = new ArrayList<>();

        int start = searchDto.getPage() * searchDto.getAmount();
        int end = (searchDto.getPage() - 1) * searchDto.getAmount();

        con = getConnection();

        // 전체 리스트

        // 검색 리스트

        try {

            String sql = "SELECT BNO, TITLE, REGDATE, READ_COUNT, RE_LEV, name ";
            sql += "from (SELECT rownum AS rnum, A.* ";
            sql += "FROM (SELECT BNO, TITLE, REGDATE, READ_COUNT, RE_LEV, name ";
            sql += "FROM BOARD  WHERE bno > 0 ";

            if (searchDto.getCriteria().isEmpty()) {// 전체 리스트로 봄

                sql += "ORDER BY RE_REF  DESC, RE_SEQ ASC) A ";
                sql += "WHERE rownum <= ?) ";
                sql += "WHERE rnum > ? ";

                pstmt = con.prepareStatement(sql);

                pstmt.setInt(1, start);
                pstmt.setInt(2, end);
            } else { // 검색 리스트로 봄

                sql += "and " + searchDto.getCriteria() + " like ? ";
                sql += "ORDER BY RE_REF  DESC, RE_SEQ ASC) A ";
                sql += "WHERE rownum <= ?) ";
                sql += "WHERE rnum > ? ";

                pstmt = con.prepareStatement(sql);

                pstmt.setString(1, "%" + searchDto.getKeyword() + "%");
                pstmt.setInt(2, start);
                pstmt.setInt(3, end);

            }

            rs = pstmt.executeQuery();

            while (rs.next()) {
                BoardDto dto = new BoardDto();

                dto.setBno(rs.getInt("bno"));
                dto.setTitle(rs.getString("title"));
                dto.setName(rs.getString("name"));
                dto.setRegDate(rs.getDate("regdate"));
                dto.setReadCount(rs.getInt("read_count"));
                dto.setReLev(rs.getInt("re_Lev"));

                list.add(dto);

            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            // 자원 닫아주기
            close(con, pstmt, rs);
        }

        return list;
    }

    // 새글 작성 메소드

    public int insert(BoardDto insertDto) {

        int result = 0;

        con = getConnection();

        String sql = "INSERT INTO BOARD (bno,name,password,title,content,attach,re_ref,re_lev,re_seq)  VALUES (board_seq.nextval,?,?,?,?,?,board_seq.currval,?,?)";
        try {

            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, insertDto.getName());
            pstmt.setString(2, insertDto.getPassword());
            pstmt.setString(3, insertDto.getTitle());
            pstmt.setString(4, insertDto.getContent());
            pstmt.setString(5, insertDto.getAttach());
            pstmt.setInt(6, 0);
            pstmt.setInt(7, 0);

            result = pstmt.executeUpdate(); // 0 false 1 success

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            close(con, pstmt);
        }

        return result;

    }

    // 특정 글 조회

    public BoardDto getRow(int bno) {
        BoardDto dto = null;
        con = getConnection();
        String sql = "select bno, title, name, content, attach, re_ref, re_seq, re_lev from BOARD where bno=?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, bno);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                dto = new BoardDto();
                // 글쓴이 제목 내용 파일첨부

                dto.setBno(rs.getInt(1));
                dto.setTitle(rs.getString(2));
                dto.setName(rs.getString(3));
                dto.setContent(rs.getString("content"));
                dto.setAttach(rs.getString("attach"));

                // reply 에서 필요함

                dto.setReRef(rs.getInt("re_ref"));
                dto.setReSeq(rs.getInt("re_seq"));
                dto.setReLev(rs.getInt("re_lev"));

            }

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            // 자원 닫아주기
            close(con, pstmt, rs);
        }

        return dto;

    }

    // 업데이트 (수정)

    public int update(BoardDto updateDto) {
        int result = 0;
        con = getConnection();
        // 제목 내용 수정 파일 첨부
        //
        String sql = "UPDATE board SET title = ?,content = ? WHERE bno = ? and password = ?";

        try {
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, updateDto.getTitle());
            pstmt.setString(2, updateDto.getContent());
            pstmt.setInt(3, updateDto.getBno());
            pstmt.setString(4, updateDto.getPassword());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            close(con, pstmt);
        }

        return result;
    }

    // 삭제 delete 메소드

    public int delete(BoardDto deleteDto) {
        int result = 0;
        con = getConnection();
        // 제목 내용 수정 파일 첨부
        //
        String sql = "delete from Board where bno = ? and password = ?";

        try {
            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, deleteDto.getBno());
            pstmt.setString(2, deleteDto.getPassword());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            close(con, pstmt);
        }

        return result;
    }

    // bno 와 password 받아서 비밀번호 확인하는 메소드

    public int pwdCheck(BoardDto passDto) {
        int result = 0;
        con = getConnection();
        String sql = "select count(*) from board where bno=? and password =?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, passDto.getBno());
            pstmt.setString(2, passDto.getPassword());
            rs = pstmt.executeQuery();

            if (rs.next()) {

                result = rs.getInt(1);

            }

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            // 자원 닫아주기
            close(con, pstmt, rs);
        }

        return result;

    }

    // 원본과 댓글 같이날려버리기

    public int deleteAll(int re_ref) {

        // 부모 자식 둘다 제거
        int result = 0;
        con = getConnection();
        // 제목 내용 수정 파일 첨부
        // 원본글 비밀번호가 맞다면 전체 삭제
        String sql = "delete from Board where re_ref=?";

        try {
            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, re_ref);

            result = pstmt.executeUpdate();
        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            close(con, pstmt);
        }

        return result;
    }

    public int reply(BoardDto replyDto) {

        int result = 0;

        // 원본글의 re_ref , re_seq , re_lev 가져오기

        try {
            con = getConnection();

            String sql = "update board set RE_SEQ = RE_SEQ + 1 WHERE RE_REF = ? AND   RE_SEQ > ?";

            int reRef = replyDto.getReRef();
            int reSeq = replyDto.getReSeq();
            int reLev = replyDto.getReLev();

            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, reRef);
            pstmt.setInt(2, reSeq);

            sql = "INSERT INTO  BOARD(bno,name,password,title,content,re_ref,re_lev,re_seq)";

            sql += " VALUES(board_seq.nextval,?,?,?,?,?,?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, replyDto.getName());
            pstmt.setString(2, replyDto.getPassword());
            pstmt.setString(3, replyDto.getTitle());

            pstmt.setString(4, replyDto.getContent());

            pstmt.setInt(5, reRef);
            pstmt.setInt(6, reLev + 1);
            pstmt.setInt(7, reSeq + 1);

            result = pstmt.executeUpdate(); // 0 false 1 success

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            close(con, pstmt);
        }

        return result;

    }

    // readCount 조회수 업데이트

    public int updateRead(int readDto) {

        // 제목 내용 수정 파일 첨부
        int result = 0;

        try {
            con = getConnection();
            String sql = "UPDATE BOARD  SET READ_COUNT = READ_COUNT + 1 WHERE  BNO =?";
            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, readDto);

            result = pstmt.executeUpdate();
        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            close(con, pstmt);
        }

        return result;
    }

    // 검색

    public List<BoardDto> getSearchList(SearchDto searchDto) {
        List<BoardDto> list = new ArrayList<>();

        con = getConnection();
        String sql = "SELECT BNO ,TITLE ,REGDATE ,READ_COUNT ,RE_LEV,name ";
        sql += "FROM BOARD where " + searchDto.getCriteria() + " like ? ";
        sql += "ORDER BY RE_REF DESC, RE_SEQ ASC ";

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "%" + searchDto.getKeyword() + "%");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                BoardDto dto = new BoardDto();

                dto.setBno(rs.getInt("bno"));
                dto.setTitle(rs.getString("title"));
                dto.setName(rs.getString("name"));
                dto.setRegDate(rs.getDate("regdate"));
                dto.setReadCount(rs.getInt("read_count"));
                dto.setReLev(rs.getInt("re_Lev"));

                list.add(dto);

            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            // 자원 닫아주기
            close(con, pstmt, rs);
        }

        return list;
    }

    // ----------------------------------------자원정리----------------------------------------------------------------------------------------
    // ----------------------------------------자원정리----------------------------------------------------------------------------------------
    // ----------------------------------------자원정리----------------------------------------------------------------------------------------

    public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null)
                rs.close();
            if (pstmt != null)
                pstmt.close();
            if (con != null)

                con.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void close(Connection con, PreparedStatement pstmt) {
        try {

            if (pstmt != null)
                pstmt.close();
            if (con != null)
                con.close();

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

}
