package com.mis.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mis.domain.ProductVO;

@Controller
public class SampleController {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	/**
	 * 1) void 타입 -> doA.jsp로 응답
	 */
	@RequestMapping("doA")
	public void doA() {
		
		// 요청 -> 응답 (화면으로, .jsp)  ->  나의 requestMapping 주소와 동일한 jsp를 실행하겠다. -> doA.jsp
		logger.info("doA called..............");
		
	}
	
	
	/**
	 * 2) 리턴 타입 String -> 기술한 문자열.jsp로 응답 -> home.jsp
	 * @return 
	 */
	@RequestMapping("doB")
	public String doB() {
		
		
		return "home";
		
	}
	
	/**
	 * 3) 리턴 타입 String -> 기술한 문자열.jsp로 응답 -> result.jsp + 매개변수 msg 전달
	 * @param msg
	 * @return
	 */
	@RequestMapping("doC")
	public String doC(@ModelAttribute("msg") String msg) {
		
		logger.info("doC called............");
		return "result";
		
	}
	
	/**
	 * 4) VO를 jsp로 전달 ** 가장 많이 사용하는 방법
	 */
	@RequestMapping("doD")
	public String doD(Model model) {
		
		// model은 화면(jsp)으로 정보를 전달 할 때 사용하는 객체
		// 1) 데이터베이스에서 VO 전달을 받음 -> 가상의 데이터를 객체 생성
		ProductVO product = new ProductVO("제품이름", 10000);
		
		// 2) model속성에 VO 담기
		model.addAttribute("pVO", product);
		
		return "productDetail";
		
	}
	
	/**
	 * 5) Redirect 해야 하는 경우 (등록, 수정, 삭제 후 이동) -> 주소창 정보 변경
	 */
	@RequestMapping("doE")
	public String doE(RedirectAttributes rttr) {
		
		rttr.addAttribute("msg", "page moved.");
		
		return  "redirect:/doC";
		
	}
	
}
