--テーブルが存在したら削除する
DROP TABLE IF EXISTS quizzes;
DROP TABLE IF EXISTS test_number_table;
DROP TABLE IF EXISTS gengo_table;
DROP TABLE IF EXISTS time_table;
DROP TABLE IF EXISTS koumoku_table;
DROP TABLE IF EXISTS mokuhyo_table;
DROP TABLE IF EXISTS l_koumoku_table;
DROP TABLE IF EXISTS m_koumoku_table;
DROP TABLE IF EXISTS authentications;
DROP TYPE IF EXISTS role;


--テーブルの作成
-- 元号テーブルを作成
CREATE TABLE gengo_table (
    gengo_id SERIAL PRIMARY KEY,  -- 元号ID（自動採番）
    gengo VARCHAR(10) NOT NULL  -- 元号（例：平成、令和）
);




--テスト年度（INSERT時、test_nuberを入れるだけで自動的に年数を追加する）
CREATE TABLE test_number_table (
    test_number_id INTEGER PRIMARY KEY,  -- テスト回数（入力）
    gengo_id INTEGER NOT NULL,        -- 元号ID（自動設定）
    gengo_nen INTEGER NOT NULL,       -- 元号の年数（例：令和6年 → 6） 自動設定
    seireki INTEGER NOT NULL,         -- 西暦 自動設定
    FOREIGN KEY (gengo_id) REFERENCES gengo_table (gengo_id)  -- 外部キー制約
);

--午前、午後
CREATE TABLE time_table(
	time_id serial PRIMARY KEY,
	time VARCHAR(10) NOT NULL
);


--出題基準
CREATE TABLE mokuhyo_table(
	mokuhyo_id serial PRIMARY KEY,
	mokuhyo TEXT NOT NULL
);

CREATE TABLE l_koumoku_table(
	l_koumoku_id serial PRIMARY KEY,
	l_koumoku TEXT NOT NULL
);

CREATE TABLE m_koumoku_table(
	m_koumoku_id serial PRIMARY KEY,
	m_koumoku TEXT NOT NULL
);

CREATE TABLE koumoku_table (
	koumoku_id serial PRIMARY KEY,
	s_koumoku text NOT NULL,
	m_koumoku_id INTEGER NOT NULL
		REFERENCES m_koumoku_table(m_koumoku_id),
	l_koumoku_id INTEGER NOT NULL
		REFERENCES l_koumoku_table(l_koumoku_id),
	mokuhyo_id INTEGER NOT NULL
		REFERENCES mokuhyo_table(mokuhyo_id)
);


--問題内容
CREATE TABLE quizzes (
	id serial PRIMARY KEY,
	test_number_id INTEGER NOT NULL CHECK (test_number_id >= 105) 
		REFERENCES test_number_table(test_number_id),
	time_id INTEGER NOT NULL CHECK(time_id between 1 and 2)
		REFERENCES time_table(time_id),
	question_number INTEGER NOT NULL CHECK(question_number between 1 and 25),
	question TEXT NOT NULL,
	choice1 TEXT NOT NULL,
	choice2 TEXT NOT NULL,
	choice3 TEXT NOT NULL,
	choice4 TEXT NOT NULL,
	choice5 TEXT,
	ans INTEGER NOT NULL CHECK(ans BETWEEN 1 and 5),
	explanation TEXT NOT NULL DEFAULT '未入力',
	koumoku_id INTEGER NOT NULL
	REFERENCES koumoku_table(koumoku_id)
);


--権限用のENUM型
CREATE TYPE role AS ENUM ('ADMIN', 'USER');


--認証情報を格納するテーブル
CREATE TABLE authentications(
	--	ユーザー名：主キー
	username VARCHAR(50) PRIMARY KEY,
	--	パスワード
	password VARCHAR(255) NOT NULL,
	--権限
	authority role NOT NULL,
	--表示名
	displayname VARCHAR(50) NOT NULL
);


