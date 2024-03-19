package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.TodoDto;

public class Dao {

    private Connection con; // DB 연결 객체
    private PreparedStatement pstmt; // SQL 문 실행 객체
    private ResultSet rs; // SQL 결과셋 객체

    // JDBC 드라이버 로드
    static {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // DB 연결 얻기
    public Connection getConnection() {
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 데이터베이스 접속 정보
        String user = "C##TEST2"; // 사용자 이름
        String password = "test"; // 비밀번호
        try {
            con = DriverManager.getConnection(url, user, password); // 연결 생성
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    // 전체 데이터 조회
    public List<TodoDto> getList() {
        List<TodoDto> list = new ArrayList<>(); // 결과를 담을 리스트

        con = getConnection(); // 연결 얻기
        String sql = "select no, title, created_at, completed from todotbl order by no desc"; // SQL 작성
        try {
            pstmt = con.prepareStatement(sql); // SQL 실행 객체 생성
            rs = pstmt.executeQuery(); // 쿼리 실행
            while (rs.next()) { // 결과 반복
                TodoDto dto = new TodoDto(); // 결과를 담을 DTO 객체 생성
                dto.setNo(rs.getInt("no")); // 데이터 설정
                dto.setTitle(rs.getString("title"));
                dto.setCreatedAt(rs.getDate("created_at"));
                dto.setCompleted(rs.getBoolean("completed"));
                list.add(dto); // 결과 리스트에 추가
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con, pstmt, rs); // 자원 닫기
        }
        return list; // 결과 반환
    }

    // 특정 데이터 조회
    public TodoDto getRow(String no) {
        TodoDto dto = null; // 결과를 담을 DTO 객체

        con = getConnection(); // 연결 얻기
        String sql = "select * from todotbl where no=?"; // SQL 작성
        try {
            pstmt = con.prepareStatement(sql); // SQL 실행 객체 생성
            pstmt.setInt(1, Integer.parseInt(no)); // 파라미터 설정
            rs = pstmt.executeQuery(); // 쿼리 실행
            if (rs.next()) { // 결과 반복
                dto = new TodoDto(); // DTO 객체 생성
                dto.setNo(rs.getInt("no")); // 데이터 설정
                dto.setTitle(rs.getString("title"));
                dto.setCreatedAt(rs.getDate("created_at"));
                dto.setCompleted(rs.getBoolean("completed"));
                dto.setDescription(rs.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con, pstmt, rs); // 자원 닫기
        }
        return dto; // 결과 반환
    }

    // 데이터 추가
    public int insert(TodoDto inserDto) {
        int result = 0; // 결과 변수 초기화

        con = getConnection(); // 연결 얻기
        String sql = "INSERT INTO TODOTBL (NO, title, description) VALUES (todo_seq.nextval,?,?)"; // SQL 작성

        try {
            pstmt = con.prepareStatement(sql); // SQL 실행 객체 생성
            pstmt.setString(1, inserDto.getTitle()); // 파라미터 설정
            pstmt.setString(2, inserDto.getDescription());
            result = pstmt.executeUpdate(); // 쿼리 실행 및 결과 반환 (0: 실패, 1: 성공)
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con, pstmt); // 자원 닫기
        }

        return result; // 결과 반환
    }

    // 데이터 수정
    public int update(TodoDto inserDto) {
        int result = 0; // 결과 변수 초기화

        con = getConnection(); // 연결 얻기
        String sql = "UPDATE TODOTBL SET COMPLETED =?,DESCRIPTION =? WHERE NO=?"; // SQL 작성

        try {
            pstmt = con.prepareStatement(sql); // SQL 실행 객체 생성
            pstmt.setBoolean(1, inserDto.isCompleted()); // 파라미터 설정
            pstmt.setString(2, inserDto.getDescription());
            pstmt.setInt(3, inserDto.getNo());
            result = pstmt.executeUpdate(); // 쿼리 실행 및 결과 반환 (0: 실패, 1: 성공)
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con, pstmt); // 자원 닫기
        }

        return result; // 결과 반환
    }

    // 자원 닫기
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

    // 자원 닫기
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
