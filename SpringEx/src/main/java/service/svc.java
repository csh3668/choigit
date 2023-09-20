package service;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import actANDsvc.StepOne;
import model.field_rent;
import model.Login_info;

@Service
public class svc {
	@Autowired
	StepOne ob;
	
	public List<field_rent> select_method() throws Exception {
		List<field_rent>selc =ob.rent_select();
		return selc;
	}
	
	public void insert_method(@ModelAttribute field_rent list) throws Exception{
	    ob.db_insert(list);
	}
	public void delete_method(@RequestParam Integer num) throws Exception {
		ob.db_delete(num);
		
	}
	
	public String login_check(Login_info uid, HttpServletRequest request) throws Exception {
	    System.out.println(uid.getLog_id() + uid.getPassword() + "서비스시작");
	    Login_info Login_info = ob.log_select(uid);
	    String login_ck="fail";
	     if (Login_info.getLog_id() != null && Login_info.getLog_id().equals(uid.getLog_id())) {
	    	 	login_ck= "success";
	    	 	HttpSession session = request.getSession();
	            session.setAttribute("Login_infoId", uid.getLog_id());
	     }else {
	        System.out.println("로그인 정보가 존재하지 않습니다.");
	         // 로그인 정보가 존재하지 않음
	    }
	     return login_ck;
	}
	public field_rent detail_select(HttpServletRequest request) throws Exception {
		Integer num=Integer.parseInt(request.getParameter("num"));
		field_rent detail= ob.detail_select(num);
		if (detail == null) {
	        throw new Exception("데이터를 조회하지 못했습니다.");
	    }
	    return detail;
	}
	
}	

//	2차 로그인 실패시 적용 전
//	public List<Login_info> login_check(@ModelAttribute Login_info uid, HttpServletRequest request) throws Exception {
//	    System.out.println(uid.getLog_id()+uid.getPassword()+"서비스시작");
//	    List<Login_info> Login_info = ob.log_select(uid);
//	    if (Login_info != null && Login_info.size() > 0) { // List 객체가 존재하고, 크기가 0보다 큰 경우
//	        System.out.println(Login_info.get(0).getLog_id());
//	        
//	        if (Login_info.get(0).getLog_id() != null && Login_info.get(0).getLog_id().equals(uid.getLog_id())) {
//	            HttpSession session = request.getSession();
//	            session.setAttribute("Login_infoId", uid);
//	        }else{
//	        	System.out.println("값이 없습니다.");
//	        }
//	    }
//	    return Login_info;
//	}
//	
//	1차 오류 IndexOutOfBoundsException error 발생
//	public List<Login_info> login_check(@ModelAttribute Login_info uid, HttpServletRequest request) throws Exception {
//		System.out.println(uid.getLog_id()+uid.getPassword()+"서비스시작");
//		List<Login_info> User = ob.log_select(uid);
//	    System.out.println(User.get(0).getLog_id());
//	    //
//	    if (User.get(0).getLog_id() != null && User.get(0).getLog_id().equals(uid.getLog_id())) {
//	        HttpSession session = request.getSession();
//	        session.setAttribute("Login_infoId", uid);
//	    }
//	    return User;
//	}
	

