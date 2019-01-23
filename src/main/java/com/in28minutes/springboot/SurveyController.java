package com.in28minutes.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SurveyController {
	@Autowired
	private SurveyService service;
	
	@GetMapping(value="/Surveys")
	public List<Survey> retrieveEverySurvey(){
		return service.retrieveAllSurvey();
	}
	
	@GetMapping(value ="/Surveys/{surveyId}")
	public Survey retrieveSingleSurvey(@PathVariable String surveyId) {
		return service.retrieveSurvey("Survey1");
		
	}
	
	@GetMapping(value ="/Surveys/{surveyId}/Questions")
	public List<Questions> retrieveEveryQuestions(String surveyId){
		
		return service.retrieveQuestions("Survey1");
	}
	
	@GetMapping(value ="/Surveys/{surveyId}/Questions/{questionId}")
	public Questions retrieveSingleQuestion(@PathVariable String surveyId ,@PathVariable String questionId) {
		return service.retriveOneQuestion(surveyId,questionId);
	}

}
