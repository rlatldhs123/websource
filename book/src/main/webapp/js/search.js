const criteria = document.querySelector("#criteria");
const keyword = document.querySelector("#keyword");

document.querySelector("form").addEventListener("submit", (e) => {
  e.preventDefault();

  const criteria = document.querySelector("#criteria");
  const keyword = document.querySelector("#keyword");

  if (criteria.value == "검색 조건 선택") {
    alert("검색 조건을 선택해주세요");
    criteria.focus();
    return;
  } else if (!keyword.value) {
    alert("검색어를 입력해주세요");
    keyword.focus();
    return;
  }

  e.target.submit();
});
