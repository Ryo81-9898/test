--テーブルが存在したら削除する
DROP TABLE IF EXISTS quizzes;

--テーブルの作成
CREATE TABLE quizzes (
	id serial PRIMARY KEY,
	question TEXT NOT NULL,
	choice1 TEXT NOT NULL,
	choice2 TEXT NOT NULL,
	choice3 TEXT NOT NULL,
	choice4 TEXT NOT NULL,
	choice5 TEXT,
	ans INTEGER NOT NULL CHECK(ans BETWEEN 1 and 5),
	explanation TEXT NOT NULL DEFAULT '未入力'
);