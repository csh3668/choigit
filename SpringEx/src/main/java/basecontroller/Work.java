package basecontroller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import actANDsvc.StepOne;
import model.field_rent;
import model.Login_info;
import service.svc;


@Controller
// @~~~ == annotation이라 통칭함
public class Work {
	@Autowired
	StepOne ob;
	//@Autowired==객체를 생성하는 것
	@Autowired
	svc svc;
	
	@RequestMapping("/page.choi") // 로그인 페이지
	public String method(@ModelAttribute Login_info uid, HttpServletRequest request) throws Exception {
	    System.out.println(uid.getLog_id()+uid.getPassword());
	    String result = svc.login_check(uid, request);
	    System.out.println(uid.getLog_id());
	    if (result.equals("success")) {
	    	System.out.println("로그인 성공");
	        return "/page.choi2"; // 로그인이 성공했으면 페이지2로 이동
	    } 
	    else {
	    	System.out.println("로그인 실패");
	    	return "redirect:index.jsp"; // 로그인이 실패했으면 다시 로그인 페이지로 이동
	    }
	}
	
	@RequestMapping("/page.choi2")// 입력 페이지
	public String method2(@ModelAttribute field_rent list) {
		return "/WEB-INF/Monday/Pageinsr.jsp";
	}
	
	@RequestMapping("/page.choi3") // 목록 페이지
	public String method3(Model m) throws Exception {
		//ArrayList<field_rent>selc =ob.rent_select();
		List<field_rent>select= svc.select_method();
		m.addAttribute("ten",select);
		return "/WEB-INF/Monday/Page2.jsp";
	}
	
	@RequestMapping("/page.choi4") //글 입력
	public String insert(@ModelAttribute field_rent list) throws Exception {
		svc.insert_method(list);
		return "redirect:/page.choi3";
	} // redirect == 해당 페이지 새로고침 즉 인서트하고 새로고침을 해야 갱신이 되므로 page.choi3 기재한 것
	
	@RequestMapping("/page.choi5") //삭제
	public String delete(@RequestParam Integer num) throws Exception {
		svc.delete_method(num);
		return "redirect:/page.choi3";
	}
	
	@RequestMapping("/page.choi6") // 상세 페이지
	public String detail(Model m,HttpServletRequest request) throws Exception {
		field_rent detail= svc.detail_select(request);
		System.out.println(detail);
		m.addAttribute("detail",detail);
		return "/WEB-INF/Monday/Pagedetail.jsp";
	}
	
}
