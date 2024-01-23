import controller.BankController;
import lombok.AllArgsConstructor;

//책임 : 라우팅, 적절한 컨트롤러 찾기

@AllArgsConstructor
public class Dispatcher {

    //컴포지션
    private BankController con;

    @RequestMapping(uri="/insert")
    public void insert() {
        System.out.println("삽입 함!!!");
    }

    @RequestMapping(uri = "/delete")
    public void delete() {
        System.out.println("삭제 함!!!");
    }

    @RequestMapping(uri = "/update")
    public void update() {
        System.out.println("업데이트 함!!!");
    }

    @RequestMapping(uri = "/selectOne")
    public void selectOne() {
        System.out.println("조회 함!!!");
    }

    @RequestMapping(uri = "/selectAll")
    public void selectAll() {
        System.out.println("전체 조회 함!!!");
    }
}
