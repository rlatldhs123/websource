package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.BookDto;

public class BookDao {

    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;

    // 1. 드라이버 로드

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

    // etc.
    // String url = "jdbc:oracle:thin:@localhost:1521:xe"; //
    // "jdbc:oracle:thin:@localhost:1521:xe"
    // String user = "C##TEST2";
    // String password = "test";
    // try {
    // con = DriverManager.getConnection(url, user, password);

    // } catch (SQLException e) {
    // e.printStackTrace();

    // }
    // return con;

    // }

    // 3. sql 작업2

    // 전체 조회 - read 전체 조회는 리스트로 해야 한다

    public List<BookDto> getList() {
        List<BookDto> list = new ArrayList<>();

        con = getConnection();
        String sql = "select * from booktbl order by code desc";
        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                BookDto dto = new BookDto();
                dto.setCode(rs.getInt("code"));
                dto.setTitle(rs.getString("title"));
                dto.setWriter(rs.getString("writer"));
                dto.setPrice(rs.getInt("price"));

                list.add(dto);

            }
        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            // 자원 닫아주기
            close(con, pstmt, rs);
        }
        return list;
    }
    ///
    //
    //
    // 선택 조회BookDto

    public BookDto getRow(String code) {
        BookDto dto = null;

        con = getConnection();
        String sql = "select * from booktbl where code=?";
        try {
            pstmt = con.prepareStatement(sql);
            // ? 해결
            pstmt.setInt(1, Integer.parseInt(code));
            rs = pstmt.executeQuery();
            if (rs.next()) {
                dto = new BookDto();
                dto.setCode(rs.getInt("code"));
                dto.setTitle(rs.getString("title"));
                dto.setWriter(rs.getString("writer"));
                dto.setPrice(rs.getInt("price"));
                dto.setDescription(rs.getString("description"));

            }
        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            // 자원 닫아주기
            close(con, pstmt, rs);
        }
        return dto;
    }
    // //
    // //
    // //
    // //

    // 추가 create (insert)
    public int insert(BookDto inserDto) {
        int result = 0;

        con = getConnection();
        String sql = "INSERT INTO booktbl (code, title, writer, price, description) VALUES (?,?,?,?,?)";

        try {

            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, inserDto.getCode());
            pstmt.setString(2, inserDto.getTitle());
            pstmt.setString(3, inserDto.getWriter());
            pstmt.setInt(4, inserDto.getPrice());
            pstmt.setString(5, inserDto.getDescription());

            result = pstmt.executeUpdate(); // 0 false 1 success

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            close(con, pstmt);
        }

        return result;

    }

    // 수정 - update

    public int update(BookDto updateDto) {
        int result = 0;

        con = getConnection();
        String sql = "UPDATE BOOKTBL SET price = ? WHERE code = ?";

        try {

            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, updateDto.getPrice());
            pstmt.setInt(2, updateDto.getCode());

            result = pstmt.executeUpdate(); // 0 false 1 success

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            close(con, pstmt);
        }

        return result;
    }

    public List<BookDto> getSearchList(String criteria, String keyword) {
        List<BookDto> list = new ArrayList<>();

        con = getConnection();

        String sql = "";

        if (criteria.equals("code")) {
            sql = "SELECT * FROM BOOKTBL b WHERE CODE=?";

        } else {
            sql = " SELECT * FROM BOOKTBL b WHERE writer=?";
        }

        //
        //

        try {
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, (keyword));

            rs = pstmt.executeQuery();
            while (rs.next()) {
                BookDto dto = new BookDto();
                dto.setCode(rs.getInt("code"));
                dto.setTitle(rs.getString("title"));
                dto.setWriter(rs.getString("writer"));
                dto.setPrice(rs.getInt("price"));

                list.add(dto);

            }
        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            // 자원 닫아주기
            close(con, pstmt, rs);
        }
        return list;
    }

    // }
    // 삭제 메소드

    public int delete(String code) {
        int result = 0;

        con = getConnection();
        String sql = "DELETE FROM bookTBL  WHERE code=?";

        try {

            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, Integer.parseInt(code));
            result = pstmt.executeUpdate(); // 0 false 1 success

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            close(con, pstmt);
        }

        return result;
    }

    //
    //
    // 자원 닫아주기
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
