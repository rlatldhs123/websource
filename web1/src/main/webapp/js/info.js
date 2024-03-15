// submit 클릭시
// 값이 비어 있지 않도록 처리
// age 는 숫자인지 확인

const form = document.querySelector("form");

form.addEventListener("submit", (e) => {
  e.preventDefault();
  const id = document.querySelector("#id");
  const name = document.querySelector("#name");
  const age = document.querySelector("#age");

  if (!id.value) {
    alert("id 값이 비어있습니다");
    id.focus();
    return;
  } else if (!name.value) {
    alert("name 값이 비어있습니다");
    name.focus();
    return;
  } else if (!age.value || isNaN(age.value)) {
    alert("age 값을 확인해주세요");
    age.focus();
    return;
  }
  form.submit();
});

// 검증 완료후 폼  submit 실행

// 이 구문이 없으면 412  에러가 뜬다 폼이 제출이 되지 않았기 때문이다
