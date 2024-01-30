package jdbc.day1;

import project.dao.TblCustomerDao;
import project.vo.CustomerVo;

public class CustomerApp {
    
    public static void main(String[] args) {
        System.out.println("우리 쇼핑몰 [회원가입] 환영합니다.");
        System.out.println("주의사항 : 아이디는 중복된 값을 저장하면 무결성 위반 오류입니다.");
        
        System.out.print(" 아이디를 입력하세요. __ ");
        String customId = System.console().readLine();
        
        System.out.print(" 이름을 입력하세요. __ ");
        String name = System.console().readLine();

        System.out.print(" 이메일을 입력하세요. __ ");
        String email = System.console().readLine();

        System.out.print(" 나이를 입력하세요. __ ");
        int age = Integer.parseInt(System.console().readLine());
        CustomerVo vo = new CustomerVo(customId, null, email, age, null);
        TblCustomerDao dao = new TblCustomerDao();
        dao.modify(vo);    
        
        vo = new CustomerVo(customId, name, email, age, null);
        dao.join(vo);
        System.out.println("회원 가입이 완료 되었습니다.");
        
        System.out.println("우리 쇼핑몰 [회원정보]-이메일과 나이 수정 합니다.");
        System.out.print(" 아이디를 입력하세요. __ ");
        customId = System.console().readLine();

        System.out.print(" 이메일을 입력하세요. __ ");
        email = System.console().readLine();

        System.out.print(" 나이를 입력하세요. __ ");
        age = Integer.parseInt(System.console().readLine());
        vo = new CustomerVo(customId, null, email, age, null);
        dao.modify(vo);  


        dao.modify(vo);


        System.out.println("우리 쇼핑몰 [회원탈퇴]- 합니다.");
        System.out.print(" 아이디를 입력하세요. __ ");
        customId = System.console().readLine();
        dao.delete(customId);
    }   //main end

}
