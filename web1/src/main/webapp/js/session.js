// 세션 값 저장 클릯 sessionset.jsp 이동
// 세션 값 삭제 클릯 sessiondel.jsp 이동
// 세션 값 초기화 클릭시

const save = document.querySelector("div button:nth-child(1)");

const del = document.querySelector("div button:nth-child(2)");

const cho = document.querySelector("div button:nth-child(3)");

const q = document.querySelector("div button:nth-child(4)");

const w = document.querySelector("div button:nth-child(5)");

const e = document.querySelector("div button:nth-child(6)");

const r = document.querySelector("div button:nth-child(7)");

const t = document.querySelector("div button:nth-child(8)");

save.addEventListener("click", () => {
  location.href = "sessionset.jsp"; // 자바에서 파일 이동 구문
});

del.addEventListener("click", () => {
  location.href = "sessiondel.jsp";
});

cho.addEventListener("click", () => {
  location.href = "sessioninv.jsp";
});
