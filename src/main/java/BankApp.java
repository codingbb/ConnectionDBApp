import dao.BankDAO;
import db.DBConnection;
import model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        //이거 BR로도 만들 수 있다
        Scanner sc = new Scanner(System.in);

        // http://bank.com/account GET
        // http://bank.com/account/1 GET
        // http://bank.com/account POST
        // http://bank.com/account/1 DELETE
        // http://bank.com/account/1 PUT

        System.out.println("http 메서드를 입력하세요");
        String method = sc.nextLine();

        System.out.println("식별자를 입력하세요");
        String action = sc.nextLine();

        String body = "";

        BankDAO bankDAO = new BankDAO();
        if (method.equals("GET")) {
            if (action.equals("/account")) {
                List<Account> accountList = bankDAO.selectAll();
                System.out.println(accountList);

            } else if (action.equals("/account/3")) {
                Account account = bankDAO.selectByNumber(3); //지금은 파싱 안하고 강제로 1넣기
                System.out.println(account);
            }

        } else if (method.equals("POST")) {
            System.out.println("body 데이터를 입력하세요");
            body = sc.nextLine();

            // password=1234&balance=1000
            String[] st1 = body.split("&");
            String password = st1[0].split("=")[1];
            int balance = Integer.parseInt(st1[1].split("=")[1]);

            if (action.equals("/account")) {
                bankDAO.insert(password,balance);
            }

        } else if (method.equals("PUT")) {
            
        } else if (method.equals("DELETE")) {
            
        }


    }
}
