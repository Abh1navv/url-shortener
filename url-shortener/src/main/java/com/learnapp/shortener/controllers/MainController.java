package com.learnapp.shortener.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.learnapp.shortener.service.StorageService;

@Controller
public class MainController {

	@Autowired
	StorageService storageService;
		
	@GetMapping("/")
	public String getHome() {
		return "home";
	}

	@PostMapping("/short")
	public ModelAndView getShortUrl(@RequestParam(name = "url") String url, HttpServletRequest request) {
		ModelAndView shortView = new ModelAndView("short", HttpStatus.OK);
		String hostName = request.getHeader("referer");
		shortView.addObject("url", hostName + storageService.saveAndGetHash(url));
		return shortView;
	}

	

}
