import controller.BankController;
import controller.RequestMapping;
import lombok.AllArgsConstructor;

import java.lang.reflect.Method;

//책임 : 라우팅, 적절한 컨트롤러 찾기

@AllArgsConstructor
public class Dispatcher {

    //컴포지션
    private BankController con;

    public void route(String path) {

        Method[] methods = con.getClass().getDeclaredMethods();
//        System.out.println(methods.length);
//
        for (Method method : methods) {
            RequestMapping rm = method.getDeclaredAnnotation(RequestMapping.class);

            if (rm == null) continue;

            if (rm.uri().equals(path)) {
                try {
                    method.invoke(con); // =con.login()이랑 같은 코드임
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}