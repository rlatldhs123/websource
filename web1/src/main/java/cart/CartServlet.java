package cart;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addCart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 사용자 요청 한글 처리
        req.setCharacterEncoding("utf-8");

        // 사용자가 선택한 값을 가져오기
        String product = req.getParameter("product");

        // 세션에 담기
        // 장바구나 세션 여부 확인
        HttpSession session = req.getSession();

        ArrayList<String> products = (ArrayList<String>) session.getAttribute("products");

        if (products == null) {
            // 장바구니에담긴게 없다면?

            // 장바구나 리스트 생성
            products = new ArrayList<>();
            products.add(product);
            session.setAttribute("products", products);

        } else {
            // 장바구나 세션이 존대한다면 제품만 추가
            products.add(product);

        }
        // session.setAttribute("product", product);

        // 페이지 이동 barsket.jsp 로
        resp.sendRedirect("/cart/basket.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
