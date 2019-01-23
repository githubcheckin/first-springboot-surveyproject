package com.in28minutes.springboot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class SurveyService {
	private static List<Survey>surveys = new ArrayList<>();
	static {
		
		List<String> options=new ArrayList<>();
		options.add("India");
		options.add("Russia");
		options.add("Unisted States");
		options.add("China");
		
		Questions question1 = new Questions( "Question1",
				"Largest Country in the World", "Russia", options);
		Questions question2 = new Questions("Question2",
				"Most Populus Country in the World", "China", Arrays.asList(
						"India", "Russia", "United States", "China"));
		Questions question3 = new Questions("Question3",
				"Highest GDP in the World", "United States", Arrays.asList(
						"India", "Russia", "United States", "China"));
		Questions question4 = new Questions("Question4",
				"Second largest english speaking country", "India", Arrays
						.asList("India", "Russia", "United States", "China"));
		
		List<Questions>questions = new ArrayList<>(Arrays.asList(question1,
				question2, question3, question4));
		
		Survey survey = new Survey("Survey1", "My Favorite Survey",
				"Description of the Survey", questions);
		surveys.add(survey);
		
	}
	
	public List<Survey> retrieveAllSurvey() {
		
		return surveys;
		
	}
	
	public Survey retrieveSurvey(String id) {
		for (Survey survey :surveys) {
			if (survey.getId().equals(id)) {
				
				return survey;
				
			}
			
		}
		return null;
	}

public List<Questions> retrieveQuestions(String surveyId){
	
	if(surveyId==null) {
		
		return null;
	}
	
	Survey retrieveSurvey = retrieveSurvey(surveyId);
	List<Questions> questionList= retrieveSurvey.getQuestions();
	return questionList;
	
}

public Questions retriveOneQuestion(String surveyId ,String questionId) {
	
	 Survey retrievedSurvey=retrieveSurvey(surveyId);
	
	return retrieveQuestionFromSurvey(retrievedSurvey,questionId);
	
	}

public Questions retrieveQuestionFromSurvey(Survey survey ,String questionId) {
	
	List<Questions>retrievedQuestions=  survey.getQuestions();
			for( Questions question: retrievedQuestions) {
		if ( question.getId().equals(questionId)) {
			return question;
		}
		

}
return null;	 
	
}


}
