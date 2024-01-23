import controller.BankController;
import dao.BankDAO;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BankApp {
    public static void main(String[] args) {
        String path = "/update";

        BankDAO dao = new BankDAO();
        BankController con = new BankController(dao);
        Dispatcher dis = new Dispatcher(con);

        Method[] methods = dis.getClass().getDeclaredMethods();

        for (Method method : methods) {
            RequestMapping rm = method.getDeclaredAnnotation(RequestMapping.class);

            if (rm == null) continue;

            if (rm.uri().equals(path)) {
                try {
                    method.invoke(dis);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }
    }
}
