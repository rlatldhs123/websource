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

    // 전체 리스트 가져오기

    public List<BoardDto> getList() {
        List<BoardDto> list = new ArrayList<>();

        con = getConnection();
        String sql = "SELECT BNO ,TITLE ,name,REGDATE ,READ_COUNT  FROM BOARD b  ORDER BY bno desc";
        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                BoardDto dto = new BoardDto();
                dto.setBno(rs.getInt("bno"));
                dto.setTitle(rs.getString("title"));
                dto.setName(rs.getString("name"));
                dto.setRegDate(rs.getDate("regdate"));
                dto.setReadCount(rs.getInt("read_count"));

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
        String sql = "select bno,title,name,content,attach from BOARD where bno=?";
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

            }

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            // 자원 닫아주기
            close(con, pstmt, rs);
        }

        return dto;

    }

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
