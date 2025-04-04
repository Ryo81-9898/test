--解説なし(4択)Ver
INSERT INTO quizzes (question, choice1, choice2, choice3, choice4, ans) 
	VALUES
		('question1', 'choice1-1', 'choice1-2', 'choice1-3', 'choice1-4', 1 ),
		('question2', 'choice2-1', 'choice2-2', 'choice2-3', 'choice2-4', 2 );

--解説なし(5択)Ver
INSERT INTO quizzes (question, choice1, choice2, choice3, choice4, choice5, ans) 
	VALUES
		('question3', 'choice3-1', 'choice3-2', 'choice3-3', 'choice3-4',  'choice3-5', 3 ),
		('question4', 'choice4-1', 'choice4-2', 'choice4-3', 'choice4-4',  'choice4-5', 5 );
		
--フル(5択)Ver
INSERT INTO quizzes (question, choice1, choice2, choice3, choice4, choice5, ans, explanation) 
	VALUES
		('question5', 'choice5-1', 'choice5-2', 'choice5-3', 'choice5-4','choice5-5', 5, 'explanation5'),
		('question6', 'choice6-1', 'choice6-2', 'choice6-3', 'choice6-4','choice6-5', 2, 'explanation6');

--フル(4択)Ver
INSERT INTO quizzes (question, choice1, choice2, choice3, choice4, ans, explanation) 
	VALUES
		('question7', 'choice7-1', 'choice7-2', 'choice7-3', 'choice7-4', 3, 'explanation7'),
		('question8', 'choice8-1', 'choice8-2', 'choice8-3', 'choice8-4', 4, 'explanation8'),
		('question9', 'choice9-1', 'choice9-2', 'choice9-3', 'choice9-4', 1, 'explanation9'),
		('question10', 'choice10-1', 'choice10-2', 'choice10-3', 'choice10-4', 2, 'explanation10'),
		('question11', 'choice11-1', 'choice11-2', 'choice11-3', 'choice11-4', 3, 'explanation11'),
		('question12', 'choice12-1', 'choice12-2', 'choice12-3', 'choice12-4', 4, 'explanation12'),
		('question13', 'choice13-1', 'choice13-2', 'choice13-3', 'choice13-4', 1, 'explanation13'),
		('question14', 'choice14-1', 'choice14-2', 'choice14-3', 'choice14-4', 2, 'explanation14'),
		('question15', 'choice15-1', 'choice15-2', 'choice15-3', 'choice15-4', 3, 'explanation15'),
		('question16', 'choice16-1', 'choice16-2', 'choice16-3', 'choice16-4', 4, 'explanation16'),
		('question17', 'choice17-1', 'choice17-2', 'choice17-3', 'choice17-4', 1, 'explanation17'),
		('question18', 'choice18-1', 'choice18-2', 'choice18-3', 'choice18-4', 2, 'explanation18'),
		('question19', 'choice19-1', 'choice19-2', 'choice19-3', 'choice19-4', 3, 'explanation19'),
		('question20', 'choice20-1', 'choice20-2', 'choice20-3', 'choice20-4', 4, 'explanation20');
