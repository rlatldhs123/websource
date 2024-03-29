// form 이 비어 있는지 확인
const actionForm = document.querySelector("#actionForm");

document.querySelector("#writeForm").addEventListener("submit", (e) => {
  e.preventDefault();

  const name = document.querySelector("#name");
  const title = document.querySelector("#title");
  const content = document.querySelector("#content");
  const password = document.querySelector("#password");

  if (!name.value) {
    alert("작성자를 입력해주세요");

    name.focus();
    return;
  }
  if (!title.value) {
    alert("제목을 입력해주세요");
    title.focus();
    return;
  }
  if (!content.value) {
    alert("내용을 입력해주세요");
    content.focus();
    return;
  }
  if (!password.value) {
    alert("비밀번호를 확인해주세요");
    password.focus();
    return;
  }

  e.target.submit();

  document.querySelector("#list").addEventListener("click", () => {
    // location.href = "/qList.do";
    // actionForm 보내기

    actionForm.submit();
  });
});
