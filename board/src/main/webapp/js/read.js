document.querySelector("#list").addEventListener("click", () => {
  location.href = "qList.do";
});

// 수정 모디파이

document.querySelector("#modify").addEventListener("click", () => {
  location.href = "modify.do?bno=" + bno;
});

document.querySelector("#delete").addEventListener("click", () => {
  location.href = "/view/qna_board_pwdCheck.jsp?bno=" + bno;
});

document.querySelector("#reply").addEventListener("click", () => {
  location.href = "/ReplyView.do?bno=" + bno;
});
