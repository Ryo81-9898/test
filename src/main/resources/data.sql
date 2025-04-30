
-- 元号テーブルにデータを挿入
INSERT INTO gengo_table (gengo) 
VALUES	('平成'),
		('令和');

--テスト年度INSERT
INSERT INTO test_number_table VALUES (105, 1, 27, 2015);  
INSERT INTO test_number_table VALUES (106, 1, 28, 2016);  
INSERT INTO test_number_table VALUES (107, 1, 29, 2017);
INSERT INTO test_number_table VALUES (108, 1, 30, 2018);
INSERT INTO test_number_table VALUES (109, 2, 1, 2019);
INSERT INTO test_number_table VALUES (110, 2, 2, 2020);
INSERT INTO test_number_table VALUES (111, 2, 3, 2021);
INSERT INTO test_number_table VALUES (112, 2, 4, 2022);
INSERT INTO test_number_table VALUES (113, 2, 5, 2023);
INSERT INTO test_number_table VALUES (114, 2, 6, 2024);



-- 時間テーブルにデータを挿入
INSERT INTO time_table (time) VALUES
('午前'),
('午後');


--出題基準データ挿入
--目標
INSERT INTO mokuhyo_table(mokuhyo)
VALUES 	('mokuhyo1'),
		('mokuhyo2')
;

--大項目
INSERT INTO l_koumoku_table(l_koumoku)
VALUES 	('dai_koumoku1'),
		('dai_koumoku2'),
		('dai_koumoku3'),
		('dai_koumoku4')
;

--中項目
INSERT INTO m_koumoku_table(m_koumoku)
VALUES 	('cho_koumoku1'),
		('cho_koumoku2'),
		('cho_koumoku3'),
		('cho_koumoku4'),
		('cho_koumoku5'),
		('cho_koumoku6'),
		('cho_koumoku7'),
		('cho_koumoku8')
;

--小項目
--INSERT INTO koumoku_table(s_koumoku, m_koumoku_id, l_koumoku_id, mokuhyo_id)
--VALUES  ('sho_koumoku1', 1, 1, 1),
--		('sho_koumoku2', 1, 1, 1),
--		('sho_koumoku3', 2, 1, 1),
--		('sho_koumoku4', 2, 1, 1),
--		('sho_koumoku5', 1, 2, 1),
--		('sho_koumoku6', 1, 2, 1),
--		('sho_koumoku7', 2, 2, 1),
--		('sho_koumoku8', 2, 2, 1),
--		('sho_koumoku9' , 1, 1, 2),
--		('sho_koumoku10', 1, 1, 2),
--		('sho_koumoku11', 2, 1, 2),
--		('sho_koumoku12', 2, 1, 2),
--		('sho_koumoku13', 1, 2, 2),
--		('sho_koumoku14', 1, 2, 2),
--		('sho_koumoku15', 2, 2, 2),
--		('sho_koumoku16', 2, 2, 2)
--;
INSERT INTO koumoku_table(s_koumoku, m_koumoku_id, l_koumoku_id, mokuhyo_id, blog_url)
VALUES  ('sho_koumoku1', 1, 1, 1, 'https://saisakinoyoi-tenkouhuryou.hatenablog.com/entry/2025/03/05/100000'),
		('sho_koumoku2', 1, 1, 1, null),
		('sho_koumoku3', 2, 1, 1, null),
		('sho_koumoku4', 2, 1, 1, null),
		('sho_koumoku5', 1, 2, 1, 'https://saisakinoyoi-tenkouhuryou.hatenablog.com/entry/2025/02/19/100000'),
		('sho_koumoku6', 1, 2, 1, null),
		('sho_koumoku7', 2, 2, 1, null),
		('sho_koumoku8', 2, 2, 1, null),
		('sho_koumoku9' , 1, 1, 2, null),
		('sho_koumoku10', 1, 1, 2, 'https://saisakinoyoi-tenkouhuryou.hatenablog.com/entry/2025/02/19/100000'),
		('sho_koumoku11', 2, 1, 2, null),
		('sho_koumoku12', 2, 1, 2, null),
		('sho_koumoku13', 1, 2, 2, null),
		('sho_koumoku14', 1, 2, 2, null),
		('sho_koumoku15', 2, 2, 2, 'https://saisakinoyoi-tenkouhuryou.hatenablog.com/entry/2025/02/10/100000'),
		('sho_koumoku16', 2, 2, 2, null)
;


-- quizzesINSERT
--解説なし(4択)Ver
--INSERT INTO quizzes (test_number_id, time_id, question_number, question, choice1, choice2, choice3, choice4, ans, koumoku_id, image_path) 
--	VALUES
--		(105, 1, 1, 'question1', 'choice1-1', 'choice1-2', 'choice1-3', 'choice1-4', 1, 1, 'example.png'),
--		(106, 2, 5, 'question2', 'choice2-1', 'choice2-2', 'choice2-3', 'choice2-4', 2, 2, null)
--;
--
----解説なし(5択)Ver
--INSERT INTO quizzes  (test_number_id, time_id, question_number, question, choice1, choice2, choice3, choice4, choice5, ans, koumoku_id, image_path)
--	VALUES
--		(107, 1, 10, 'question3', 'choice3-1', 'choice3-2', 'choice3-3', 'choice3-4', 'choice3-5', 3, 3, 'example.png'),
--		(108, 2, 15, 'question4', 'choice4-1', 'choice4-2', 'choice4-3', 'choice4-4', 'choice4-5', 5, 4, null)
--;
--
----フル(5択)Ver
--INSERT INTO quizzes  (test_number_id, time_id, question_number, question, choice1, choice2, choice3, choice4, choice5, ans, explanation, koumoku_id, image_path)
--	VALUES
--		(109, 1, 20, 'question5', 'choice5-1', 'choice5-2', 'choice5-3', 'choice5-4', 'choice5-5', 4, 'explanation5', 5, 'example.png'),
--		(110, 2, 25, 'question6', 'choice6-1', 'choice6-2', 'choice6-3', 'choice6-4', 'choice6-5', 5, 'explanation6',  6, null)
--;
--
----フル(4択)Ver
--INSERT INTO quizzes (test_number_id, time_id, question_number, question, choice1, choice2, choice3, choice4, ans, explanation, koumoku_id, image_path)
--	VALUES
--		(111, 1, 1, 'question7', 'choice7-1', 'choice7-2', 'choice7-3', 'choice7-4',  1, 'explanation7',  7, 'example.png'),
--		(112, 2, 5, 'question8', 'choice8-1', 'choice8-2', 'choice8-3', 'choice8-4',  2, 'explanation8', 8, null),
--		(113, 1, 10, 'question9', 'choice9-1', 'choice9-2', 'choice9-3', 'choice9-4',  3, 'explanation9', 9, 'example.png'),
--		(114, 2, 15, 'question10', 'choice10-1', 'choice10-2', 'choice10-3', 'choice10-4', 4, 'explanation10', 10, null),
--		(105, 1, 20, 'question11', 'choice11-1', 'choice11-2', 'choice11-3', 'choice11-4', 1, 'explanation11', 11, 'example.png'),
--		(106, 2, 25, 'question12', 'choice12-1', 'choice12-2', 'choice12-3', 'choice12-4', 2, 'explanation12', 12, null),
--		(107, 1, 1, 'question13', 'choice13-1', 'choice13-2', 'choice13-3', 'choice13-4', 3, 'explanation13', 13, 'example.png'),
--		(108, 2, 5, 'question14', 'choice14-1', 'choice14-2', 'choice14-3', 'choice14-4', 4, 'explanation14', 14, null),
--		(109, 1, 10, 'question15', 'choice15-1', 'choice15-2', 'choice15-3', 'choice15-4', 1, 'explanation15', 15, 'example.png'),
--		(110, 2, 15, 'question16', 'choice16-1', 'choice16-2', 'choice16-3', 'choice16-4', 2, 'explanation16', 16, null),
--		(111, 1, 20, 'question17', 'choice17-1', 'choice17-2', 'choice17-3', 'choice17-4', 3, 'explanation17', 1, 'example.png'),
--		(112, 2, 25, 'question18', 'choice18-1', 'choice18-2', 'choice18-3', 'choice18-4', 4, 'explanation18', 2, null),
--		(113, 1, 1, 'question19', 'choice19-1', 'choice19-2', 'choice19-3', 'choice19-4', 1, 'explanation19',  3, 'example.png'),
--		(114, 2, 5, 'question20', 'choice20-1', 'choice20-2', 'choice20-3', 'choice20-4', 2, 'explanation20', 4, null)
--	;

--解説なし(4択)Ver
INSERT INTO quizzes (test_number_id, time_id, question_number, question, choice1, choice2, choice3, choice4, ans, koumoku_id) 
	VALUES
		(105, 1, 1, 'question1', 'choice1-1', 'choice1-2', 'choice1-3', 'choice1-4', 1, 1),
		(106, 2, 5, 'question2', 'choice2-1', 'choice2-2', 'choice2-3', 'choice2-4', 2, 2)
;

--解説なし(5択)Ver
INSERT INTO quizzes  (test_number_id, time_id, question_number, question, choice1, choice2, choice3, choice4, choice5, ans, koumoku_id)
	VALUES
		(107, 1, 10, 'question3', 'choice3-1', 'choice3-2', 'choice3-3', 'choice3-4', 'choice3-5', 3, 3),
		(108, 2, 15, 'question4', 'choice4-1', 'choice4-2', 'choice4-3', 'choice4-4', 'choice4-5', 5, 4)
;

--フル(5択)Ver
INSERT INTO quizzes  (test_number_id, time_id, question_number, question, choice1, choice2, choice3, choice4, choice5, ans, explanation, koumoku_id)
	VALUES
		(109, 1, 20, 'question5', 'choice5-1', 'choice5-2', 'choice5-3', 'choice5-4', 'choice5-5', 4, 'explanation5', 5),
		(110, 2, 25, 'question6', 'choice6-1', 'choice6-2', 'choice6-3', 'choice6-4', 'choice6-5', 5, 'explanation6',  6)
;

--フル(4択)Ver
INSERT INTO quizzes (test_number_id, time_id, question_number, question, choice1, choice2, choice3, choice4, ans, explanation, koumoku_id)
	VALUES
		(111, 1, 1, 'question7', 'choice7-1', 'choice7-2', 'choice7-3', 'choice7-4',  1, 'explanation7',  7),
		(112, 2, 5, 'question8', 'choice8-1', 'choice8-2', 'choice8-3', 'choice8-4',  2, 'explanation8', 8),
		(113, 1, 10, 'question9', 'choice9-1', 'choice9-2', 'choice9-3', 'choice9-4',  3, 'explanation9', 9),
		(114, 2, 15, 'question10', 'choice10-1', 'choice10-2', 'choice10-3', 'choice10-4', 4, 'explanation10', 10),
		(105, 1, 20, 'question11', 'choice11-1', 'choice11-2', 'choice11-3', 'choice11-4', 1, 'explanation11', 11),
		(106, 2, 25, 'question12', 'choice12-1', 'choice12-2', 'choice12-3', 'choice12-4', 2, 'explanation12', 12),
		(107, 1, 1, 'question13', 'choice13-1', 'choice13-2', 'choice13-3', 'choice13-4', 3, 'explanation13', 13),
		(108, 2, 5, 'question14', 'choice14-1', 'choice14-2', 'choice14-3', 'choice14-4', 4, 'explanation14', 14),
		(109, 1, 10, 'question15', 'choice15-1', 'choice15-2', 'choice15-3', 'choice15-4', 1, 'explanation15', 15),
		(110, 2, 15, 'question16', 'choice16-1', 'choice16-2', 'choice16-3', 'choice16-4', 2, 'explanation16', 16),
		(111, 1, 20, 'question17', 'choice17-1', 'choice17-2', 'choice17-3', 'choice17-4', 3, 'explanation17', 1),
		(112, 2, 25, 'question18', 'choice18-1', 'choice18-2', 'choice18-3', 'choice18-4', 4, 'explanation18', 2),
		(113, 1, 1, 'question19', 'choice19-1', 'choice19-2', 'choice19-3', 'choice19-4', 1, 'explanation19',  3),
		(114, 2, 5, 'question20', 'choice20-1', 'choice20-2', 'choice20-3', 'choice20-4', 2, 'explanation20', 4)
	;

	
--認証テーブルへのダミーデータの追加
--password: adminpass
INSERT INTO authentications (username, password, authority, displayname)
	VALUES ('admin', '$2a$10$wnz5r4I7MfF78TJagE/3s.l4BQ3i3AWelDkYbklx4UvqYkX6Mxs7C','ADMIN', '管理者');
	
--password: userpass
INSERT INTO authentications (username, password, authority, displayname)
	VALUES ('user', '$2a$10$/65M/Lyf.mXzGXogrBmFDeVFiUm4yZ2kKtwy/KMcp9BW3aE52.4eu','USER', '利用者');


