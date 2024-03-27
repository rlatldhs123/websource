document.querySelector("#list").addEventListener("click", () => {
  location.href = "qList.do";
});

// 수정 모디파이

document.querySelector("#modify").addEventListener("click", () => {
  location.href = "modify.do?bno=" + bno;
});
