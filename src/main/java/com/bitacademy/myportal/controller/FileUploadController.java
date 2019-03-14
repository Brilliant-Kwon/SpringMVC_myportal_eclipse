package com.bitacademy.myportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bitacademy.myportal.service.FileUploadService;

@Controller
@RequestMapping("/upload")
public class FileUploadController {
	@Autowired
	FileUploadService fileUploadService;

	@RequestMapping("/form")
	public String form() {
		return "upload/form";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(@RequestParam("user_file")MultipartFile mFile, Model model) {
		if (mFile != null) {
			String saveFilename = fileUploadService.store(mFile);
			//Image URL 생성
			String url = "upload-images/"+saveFilename;
			model.addAttribute("urlImage", url);
		}
		return "upload/result";
	}
}
