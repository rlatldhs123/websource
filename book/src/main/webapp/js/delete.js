document.querySelector("form").addEventListener("submit", (e) => {
  e.preventDefault();

  const code = document.querySelector("#code");

  if (!code.value || code.value.length !== 4 || isNaN(code.value)) {
    alert("코드 값이 비어있거나 숫자 4자리가 아닙니다");
    code.focus();
    return;
  }

  // 모든 필드가 유효하면 폼을 제출합니다.
  e.target.submit();
});
