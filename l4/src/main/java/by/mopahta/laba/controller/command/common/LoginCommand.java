package by.bsuir.kaminskiy.controller.command.common;

import by.bsuir.kaminskiy.controller.command.Command;
import by.bsuir.kaminskiy.controller.command.CommandResult;
import by.bsuir.kaminskiy.entity.Role;
import by.bsuir.kaminskiy.entity.User;
import by.bsuir.kaminskiy.exception.ServiceException;
import by.bsuir.kaminskiy.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class LoginCommand implements Command {

    private static final String MAIN_PAGE = "controller?command=mainPage";
    private static final String ADMIN_PAGE = "controller?command=showRooms";
    private static final String LOGIN_PAGE = "/WEB-INF/pages/login.jsp";
    private static final String ID = "id";
    private static final String USERNAME = "username";
    private static final String ROLE = "role";
    private static final String PASSWORD = "password";
    private static final String ERROR_MESSAGE = "errorMessage";
    private static final String WRONG_PARAMETER = "Wrong login or password";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession session = request.getSession();
        UserService service = new UserService();
        String login = request.getParameter(USERNAME);
        String password = request.getParameter(PASSWORD);
        Optional<User> optionalUser = service.findByUsernameAndPassword(login, password);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            Role role = user.getRole();

            session.setAttribute(ID, user.getId());
            session.setAttribute(USERNAME, user.getUsername());
            session.setAttribute(ROLE, role);

            return Role.ADMIN.equals(role) ?
                    CommandResult.redirect(ADMIN_PAGE) :
                    CommandResult.redirect(MAIN_PAGE);
        } else {
            request.setAttribute(ERROR_MESSAGE, WRONG_PARAMETER);
            return CommandResult.forward(LOGIN_PAGE);
        }
    }
}
