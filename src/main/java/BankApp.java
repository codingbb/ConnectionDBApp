import controller.BankController;
import dao.BankDAO;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BankApp {
    public static void main(String[] args) {
        String path = "/selectOne";

        BankDAO dao = new BankDAO();
        BankController con = new BankController(dao);
        Dispatcher dis = new Dispatcher(con);
        dis.route(path);

    }
}