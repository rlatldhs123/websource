package action;

import javax.servlet.http.HttpServletRequest;

import service.TodoService;
import service.TodoServiceImpl;

public class TododeleteAction implements Action {

    private String path;

    public TododeleteAction(String path) {
        this.path = path;
    }

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {
        String no = req.getParameter("no");

        TodoService service = new TodoServiceImpl();
        boolean result = service.delete(no);

        return new ActionForward(path, true);

    }

}
