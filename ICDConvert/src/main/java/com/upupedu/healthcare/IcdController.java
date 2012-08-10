package com.upupedu.healthcare;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class IcdController {
	private static final Logger logger = LoggerFactory.getLogger(IcdController.class);
	private IcdService service = new IcdService();
	
//	@Autowired
//	public IcdController(IcdService service){
//		this.service=service;
//		
//	}
    @RequestMapping(value = "/icd/search", method = RequestMethod.GET)
    public String search(SearchCriteria searchCriteria, Principal currentUser, Model model) {
	if (currentUser != null) {
//	    List<Booking> booking = bookingService.findBookings(currentUser.getName());
//	    model.addAttribute(booking);
	}
	logger.info("search - "+searchCriteria.getSearchString());
	ICD icd = service.findByCode9(searchCriteria.getSearchString(),searchCriteria.getPageSize());
	model.addAttribute("icd", icd);
	return "icd/search";
	
    }
    @RequestMapping(value = "/icd", method = RequestMethod.GET)
    public String list(SearchCriteria searchCriteria, Model model) {

	logger.info("list - "+ searchCriteria.getSearchString());
	logger.info("list - "+ searchCriteria.getSearchType());
	ICD icd = null;
	if (searchCriteria.getSearchType().equals("icd9"))
		icd=service.findByCode9(searchCriteria.getSearchString(),searchCriteria.getPageSize());
	else if (searchCriteria.getSearchType().equals("icd10"))
		icd=service.findByCode10(searchCriteria.getSearchString(),searchCriteria.getPageSize());
	if (searchCriteria.getSearchType().equals("keywords"))
		icd=service.findByKeywords(searchCriteria.getSearchString(),searchCriteria.getPageSize());
	model.addAttribute("icd", icd);
	model.addAttribute("icd9s", icd.getIcd9s());
	model.addAttribute("icd10s", icd.getIcd10s());
	return "icd/list";
	
    }
}
