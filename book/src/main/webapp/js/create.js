// submit 발생시
// submit  기능 중지
// code() title writer price 비어 있는지 확인

// 값이 있다면 code는 4자리인지 확인

// 값이 존재한다면 submit 하면 됌

document.querySelector("button").addEventListener("submit", (e) => {
  e.preventDefault();

  const code = document.querySelector("#code");
  const title = document.querySelector("#title");
  const writer = document.querySelector("#writer");
  const price = document.querySelector("#price");

  if (code.value || code.value.length != 4 || isNaN(code.value)) {
    alert("코드 값이 비어있거나 숫자 4자리가 아닙니다");
    code.focus();
    return;
  } else if (!title.value) {
    alert("title 값이 비어 있습니다");
    code.focus();
    return;
  } else if (!writer.value) {
    alert("writer 값이 비어 있습니다");
    code.focus();
    return;
  } else if (!price.value || isNaN(price.value)) {
    alert("price 값이 비어 있습니다");
    code.focus();
    return;
  }

  e.target.submit();
});
