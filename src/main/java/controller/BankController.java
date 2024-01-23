package controller;

// 책임 : 유효성 검사(바디데이터), 파싱(바디데이터), 적절한 DAO 찾기

import dao.BankDAO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BankController {

    private BankDAO dao;

    public void insert() {
        // 1. 파싱 (split 그거.. 짤라내는 것)

        // 2. 유효성 검사 (비번을 4자만 받아야하는데 5천자 받을 수도 있잖아)

        // 3. DAO 찾기
        System.out.println("controller : insert");
        dao.insert("1234", 1000);
    }

    public void delete() {
        System.out.println("controller : delete");
        dao.deleteByNumber(1);
    }

    public void update() {
        System.out.println("controller : update");
        dao.updateByNumber(1000,1);
    }

    public void selectOne() {
        System.out.println("controller : selectOne");
        dao.selectByNumber(1);
    }

    public void selectAll() {
        System.out.println("controller : selectAll");
        dao.selectAll();
    }

    public void withdraw() {
        dao.updateByNumber(1000, 1);
        dao.updateByNumber(-1000, 2);
    }

}
