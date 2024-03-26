package action;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import dto.BoardDto;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;

@AllArgsConstructor

public class BoardCreateAction implements Action {

    String path;

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        // 게시판 추가 화면에서 넘어오는 데이터 가져오기

        // 작성자 제목 내용 비밀번호 파일첨부

        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String password = req.getParameter("password");
        String name = req.getParameter("name");

        BoardDto dto = new BoardDto();

        dto.setTitle(title);
        dto.setContent(content);
        dto.setPassword(password);
        dto.setName(name);

        // 업로드 처리

        Part part = req.getPart("attach");
        String fileName = getFileName(part);

        String seavDir = "c:\\upload";

        if (!fileName.isEmpty()) {
            // 고유한 값 생성 (UUID) => 고유한 값 사용자가 올린 파일명
            // 왜 한거냐? 파일명이 중복되어도 시스템에서 고유한 값으로 만들었기에 저장 가능
            // 중복 파일명은 저장을 해주지 않음 => 서버에 저장 시 다른 이름 사용

            UUID uuid = UUID.randomUUID();
            File uploadFile = new File(seavDir + File.separator + uuid + "_" + fileName);

            part.write(uploadFile.toString()); // 서버의 디스크에 파일 저장 하는 부분
            dto.setAttach(uploadFile.toString());

        }
        System.out.println(dto);

        BoardService service = new BoardServiceImpl();

        if (!service.create(dto)) {
            path = "/view/qna_board_write.jsp";

        }

        return new ActionForward(path, false);

    }

    private String getFileName(Part part) {
        // Content-Disposition: attachment; filename="filename.jpg"
        String header = part.getHeader("content-disposition");
        String[] arr = header.split(";");

        for (int i = 0; i < arr.length; i++) {
            String temp = arr[i];
            if (temp.trim().startsWith("filename")) {
                return temp.substring(temp.indexOf("=") + 2, temp.length() - 1);

            }

        }
        return "";

    }

}

// 파일 저장 설명

// private String getFileName(Part part) {
// // Content-Disposition 헤더에서 파일 이름을 추출하는 메서드입니다.
// // Content-Disposition: attachment; filename="filename.jpg" 형식의 헤더에서 파일 이름을
// 가져옵니다.
// String header = part.getHeader("content-disposition"); // Part의
// content-disposition 헤더를 가져옵니다.
// String[] arr = header.split(";"); // 세미콜론을 기준으로 문자열을 분할하여 배열에 저장합니다.

// // 분할된 문자열 배열을 순회하면서 파일 이름을 찾습니다.
// for (int i = 0; i < arr.length; i++) {
// String temp = arr[i]; // 배열의 각 요소를 가져옵니다.
// // 만약 현재 요소가 파일 이름을 가리키는 부분이라면
// if (temp.trim().startsWith("filename")) {
// // "=" 다음에 나오는 파일 이름을 가져와 반환합니다. (큰따옴표 제외)
// return temp.substring(temp.indexOf("=") + 2, temp.length() - 1);
// }
// }
// // 파일 이름을 찾지 못한 경우 빈 문자열을 반환합니다.
// return "";
// }

// 추가 설명이 메소드는 HTTP 요청의 Part 객체에서 content-disposition 헤더를 통해 전송된 파일 이름을 추출합니다.
// content-disposition 헤더에는 파일이 첨부되어 있을 때 해당 파일의 이름이 포함됩니다. 이 메소드는 이러한 헤더에서 파일
// 이름을 추출하여 반환합니다.

// 메소드의 주요 역할은 다음과 같습니다:

// Part 객체에서 content-disposition 헤더를 가져옵니다.
// content-disposition 헤더를 세미콜론(;)으로 분할하여 파일 이름을 찾습니다.
// 파일 이름을 찾으면 이를 반환합니다. 파일 이름은 큰따옴표(")로 묶여있는데, 이를 제외한 이름을 반환합니다.
// 파일 이름을 찾지 못한 경우 빈 문자열을 반환합니다.
