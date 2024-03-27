<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="java.io.BufferedOutputStream, java.io.FileInputStream"%>

<%
    // 클라이언트가 요청한 파일 이름 가져오기
    String fileName = request.getParameter("fileName");


// 서버에 저장된 폴더 경로 지정 하는 작업
    String fDownloadPath = "c:\\upload"; 

// c:\\upload\\ df927d71-d68d-4c69-9b6f-0c6898bfecd4_스크린샷(7)
    String filePath = fDownloadPath + "\\" + fileName; 



// 1input
    // 1) 키보드 : System.in
    // 2) 파일
    // 텍스트 : Reader(추천) InputStream
    // 이미지 동영상 : FileInputStream
     //  하드디스크에 있는 파일 읽기
    FileInputStream in = new FileInputStream(filePath);

// 브라우저가 응답할 때 읽어온 파일 보내기
    response.setContentType("application/octet-stream"); // 파일을 보낼때 어떤 타입인지 알려줘야 하는데 그럴때 application/octet-stream 이구문이 거의 만능이다

    fileName = new String(fileName.getBytes("utf-8"), "iso-8859-1"); // 파일 이름 인코딩 수정

    int start = fileName.lastIndexOf("_");
    String oriName = fileName.substring(start + 1);
    response.setHeader("Content-Disposition", "attachment;filename=" + oriName); // Content-Disposition 오타 수정

    out.clear();

    out = pageContext.pushBody();

    BufferedOutputStream buf = new BufferedOutputStream(response.getOutputStream());

    int numRead;

    byte b[] = new byte[4096];

    while ((numRead = in.read(b, 0, b.length)) != -1) { // 조건식 오류 수정
        buf.write(b, 0, numRead);
    }

    buf.flush();
    buf.close();
    in.close();
%>
