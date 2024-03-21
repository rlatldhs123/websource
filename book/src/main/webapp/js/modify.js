document.querySelector("form").addEventListener("submit", (e) => {
  e.preventDefault();

  const code = document.querySelector("#code");

  const price = document.querySelector("#price");

  if (!code.value || code.value.length !== 4 || isNaN(code.value)) {
    alert("코드 값이 비어있거나 숫자 4자리가 아닙니다");
    code.focus();
    return;
    // } else if (!title.value) {
    //   alert("제목 값이 비어 있습니다");
    //   title.focus();
    //   return;
    // } else if (!writer.value) {
    //   alert("작가 값이 비어 있습니다");
    //   writer.focus();
    //   return;
  } else if (!price.value || isNaN(price.value)) {
    alert("가격 값이 비어 있거나 숫자가 아닙니다");
    price.focus();
    return;
  }

  // 모든 필드가 유효하면 폼을 제출합니다.
  e.target.submit();

  alert(code.value + " 번 코드의수정이 정상적으로 진행 되었습니다");
});
