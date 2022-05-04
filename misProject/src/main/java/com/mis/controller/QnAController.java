package com.mis.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mis.domain.PageMaker;
import com.mis.domain.QnAVO;
import com.mis.domain.SearchCriteria;
import com.mis.service.QnAService;

@Controller
@RequestMapping("/qna")
public class QnAController {

	@Inject
	private QnAService service;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET() throws Exception {

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(QnAVO vo, RedirectAttributes rttr) throws Exception {

		service.register(vo);
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/qna/list";

	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void readPage(Model model, @RequestParam("qnaNo") int qnaNo, @ModelAttribute("cri") SearchCriteria cri)
			throws Exception {

		model.addAttribute(service.read(qnaNo));

	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

		model.addAttribute("list", service.listSearch(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(cri));

		model.addAttribute("pageMaker", pageMaker);

	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyPageGET(int qnaNo, @ModelAttribute("cri") SearchCriteria cri, Model model,
			RedirectAttributes rttr) throws Exception {

		model.addAttribute(service.read(qnaNo));
		

	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPagePOST(QnAVO vo, @ModelAttribute("cri") SearchCriteria cri, RedirectAttributes rttr)
			throws Exception {

		service.modify(vo);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		rttr.addFlashAttribute("msg", "MODIFY");

		return "redirect:/qna/list";

	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String removePage(@RequestParam("qnaNo") int qnaNo, HttpSession session,
			@ModelAttribute("cri") SearchCriteria cri, Model model, RedirectAttributes rttr) throws Exception {

		service.remove(qnaNo);
		
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		rttr.addFlashAttribute("msg", "REMOVE");

		return "redirect:/qna/list";

	}

}
