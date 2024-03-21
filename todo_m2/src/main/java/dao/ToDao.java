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

import dto.TodoDto;

public class ToDao {

    // jdbc 단계

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
    // 3. sql 작업2

    // 전체 조회 - read 전체 조회는 리스트로 해야 한다

    public List<TodoDto> getList() {
        List<TodoDto> list = new ArrayList<>();

        con = getConnection();
        String sql = "select no, title, created_at, completed from todotbl order by no desc";
        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                TodoDto dto = new TodoDto();
                dto.setNo(rs.getInt("no"));
                dto.setTitle(rs.getString("title"));
                dto.setCreatedAt(rs.getDate("created_at"));
                dto.setCompleted(rs.getBoolean("completed"));

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

    public TodoDto getRow(String no) {
        TodoDto dto = null;

        con = getConnection();
        String sql = "select * from todotbl where no=?";
        try {
            pstmt = con.prepareStatement(sql);
            // ? 해결
            pstmt.setInt(1, Integer.parseInt(no));
            rs = pstmt.executeQuery();
            if (rs.next()) {
                dto = new TodoDto();
                dto.setNo(rs.getInt("no"));
                dto.setTitle(rs.getString("title"));
                dto.setCreatedAt(rs.getDate("created_at"));
                dto.setCompleted(rs.getBoolean("completed"));
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

    // 추가 create (insert)
    public int insert(TodoDto inserDto) {
        int result = 0;

        con = getConnection();
        String sql = "INSERT INTO TODOTBL (NO, title, description) VALUES (todo_seq.nextval,?,?)";

        try {

            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, inserDto.getTitle());
            pstmt.setString(2, inserDto.getDescription());

            result = pstmt.executeUpdate(); // 0 false 1 success

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            close(con, pstmt);
        }

        return result;

    }
    // 수정 - update

    public int update(TodoDto inserDto) {
        int result = 0;

        con = getConnection();
        String sql = "UPDATE TODOTBL SET  COMPLETED =?,DESCRIPTION =?,title=? WHERE NO=?";

        try {

            pstmt = con.prepareStatement(sql);

            pstmt.setBoolean(1, inserDto.isCompleted());
            pstmt.setString(2, inserDto.getDescription());
            pstmt.setString(3, inserDto.getTitle());
            pstmt.setInt(4, inserDto.getNo());
            result = pstmt.executeUpdate(); // 0 false 1 success

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            close(con, pstmt);
        }

        return result;

    }

    // 삭제 메소드

    public int delete(String no) {
        int result = 0;

        con = getConnection();
        String sql = "DELETE FROM TODOTBL t WHERE NO=?";

        try {

            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, Integer.parseInt(no));
            result = pstmt.executeUpdate(); // 0 false 1 success

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            close(con, pstmt);
        }

        return result;
    }

    // 4. 자원 정리

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
