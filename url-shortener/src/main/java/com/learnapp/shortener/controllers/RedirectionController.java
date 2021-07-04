package com.learnapp.shortener.controllers;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.learnapp.shortener.service.StorageService;

@RestController
public class RedirectionController {
	
	@Autowired
	StorageService storageService;
	
	Log log = LogFactory.getLog(getClass());
	
	@GetMapping("/{hash}")
	@ResponseStatus(code = HttpStatus.FOUND)
	public String redirectToActualUrl(@PathVariable ("hash") String hash, HttpServletResponse response) {
		String url = storageService.getUrl(hash);
		response.setHeader("Location", url);
		return "redirect:"+url;
	}

}
