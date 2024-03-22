package action;

import javax.servlet.http.HttpServletRequest;

import dto.TodoDto;
import service.TodoService;
import service.TodoServiceImpl;

public class TodoCrateAction implements Action {

    private String path;

    public TodoCrateAction(String path) {
        this.path = path;
    }

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        String title = req.getParameter("title");
        String description = req.getParameter("description");

        TodoDto insertDto = new TodoDto();
        insertDto.setTitle(title);
        insertDto.setDescription(description);

        TodoService service = new TodoServiceImpl();

        boolean result = service.insert(insertDto);

        // resp.sendRedirect("/list.do");

        return new ActionForward(path, true);

    }

}
