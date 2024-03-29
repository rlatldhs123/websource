// page 영역 가져오기

const pagenation = document.querySelector(".pagination");
const actionForm = document.querySelector("#actionForm");
// console.log(pagenation);

const createB = document.querySelector(".btn-success");

createB.addEventListener("click", (e) => {
  // actionForm 안에 page=1 로 셋팅  criteria="", keyword ="" 변 경후

  //actionForm submit();

  // 제목 클릭시   a 태그 기능 중지
  e.preventDefault();

  // 클릭시 새글 작성 클릭시 a 태그 기능 중지
  actionForm.querySelector("[name='page']").value = 1;
  actionForm.querySelector("[name='criteria']").value = "";
  actionForm.querySelector("[name='keyword']").value = "";
  // actionForm 액션을  /view/qna_board_write.jsp 로

  actionForm.action = "/view/qna_board_write.jsp";

  actionForm.submit();
});

const moves = document.querySelectorAll(".move");

moves.forEach((move) => {
  move.addEventListener("click", (e) => {
    e.preventDefault();
    const href = e.target.getAttribute("href");

    const element = `<input type="hidden" name="bno" value="${href}">`;

    actionForm.insertAdjacentHTML("beforeend", element);

    actionForm.action = "/Count.do";

    // console.log(actionForm);
    actionForm.submit();
  });
});

//href 값 가져오기

// actionForm안에 bno 태그 추가

// actionForm.action = "/qCount.do"

// 하단의 번호를 클릭을하면

pagenation.addEventListener("click", (e) => {
  // a태그 기능 중지
  e.preventDefault();

  // a 태그의 href 속성 값을 가져오기
  // const href = pagenation.getAttribute("href"); //
  // console.log(e.target.href);
  const href = e.target.getAttribute("href");

  // 가져온 값을 action form 에 page value 값으로 지정

  actionForm.querySelector("[name='page']").value = href;

  // console.log(actionForm);

  actionForm.submit();

  // pageValue = href;
});

// amount

const amount = document.querySelector("select[name='amount']");

amount.addEventListener("change", (e) => {
  actionForm.querySelector("[name='amount']").value = e.target.value;

  actionForm.submit();
});

// 사용자가 목록 개수 변경시 목록 값 가져온 후
// actionForm 안에 amount 값 변경후 action form  전송

document.querySelector("[name = 'search']").addEventListener("submit", (e) => {
  e.preventDefault();

  const criteria = document.querySelector('[name ="criteria"]');
  const keyword = document.querySelector('[name ="keyword"]');

  // 검색하는 경우에는 첫페이지 보여주기

  document.querySelector("[name='page']").value = 1;

  if (criteria.value == "n") {
    alert("검색 조건을 선택하세요");
    criteria.focus();
    return;
  } else if (!keyword.value) {
    alert("검색어를 입력하세요");
    keyword.focus();
    return;
  }

  e.target.submit();
});

// a 태그의 기능을 막고

//
