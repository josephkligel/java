package com.codingdojo.urlpathvariables;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@RequestMapping("/m/{courseId}/{moduleId}")
	public String showLesson(@PathVariable("courseId") String courseId, 
			@PathVariable("moduleId") String moduleId) {
		return String.format("Course: %s, Module: %s\n", courseId, moduleId);
	}
}
