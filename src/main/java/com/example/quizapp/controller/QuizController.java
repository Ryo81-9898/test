package com.example.quizapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.quizapp.dto.Quizhelper;
import com.example.quizapp.dto.UserResult;
import com.example.quizapp.entity.Quiz;
import com.example.quizapp.form.QuizForm;
import com.example.quizapp.service.QuizService;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping
@RequiredArgsConstructor
@Data
public class QuizController {

	// DI
	private final QuizService q;
	
//情報保持のためのフィールド
	//正答率計算のため
	private int numQuestion;
	//ランダムに選ばれた問題と、解答後の情報保持
	private  List<UserResult> results;
	//再編集の際に使用
	private QuizForm temporaryForm;
	

	
	
//	=====以下メソッド======
	
	//	最初のメニュー表示
	@GetMapping
	public String menu(Model model) {
		int maxId = q.findMaxId(); // DBからIDの最大値を取得
	    model.addAttribute("maxId", maxId);
		return "menu";
	}

	
// ===== 問題・解説=====
	
	//	問題集の表示
	@GetMapping("challenge/{no}")
	public String quizList(@PathVariable int no, Model model) {
		no = no % 5 == 0 ? no : 5; //ボタンに無い数を入力されても初期化する
//		ランダムに取ってきた問題をフィールドに保存
		List<UserResult> ur = new ArrayList<>();
		for(Quiz qu : q.randomSelectQuiz(no)) {
			ur.add(Quizhelper.convertUserResult(qu));
			results = ur;
		}
		model.addAttribute("quizList", results);
		//フィールドに問題数を保存
		this.setNumQuestion(no);
		return "quiz/quizzes";
	}

	
	
	// 正答率、答え、解説表示
	@PostMapping("result")
	public String answerList(@RequestParam Map<String, String> params, Model model) {
		
		//表示した問題数を取得する
		int questionCount = this.getNumQuestion();
		
		//答え、解説に関する情報を取得
		for (int i = 1; i <= questionCount; i++) {
			results.get(i-1).setUserAnswer(params.get("userAnswerQuestionNo" + i));
			System.out.println(results.get(i-1));
		}
//		 List<UserResult> results = q.getUserResult(params, questionCount);
			
		//正答率の取得
		int rate = q.correctAnsRate(results, questionCount);
		
		//正答率、結果の格納
		model.addAttribute("userResults", results);
		model.addAttribute("correctRate", rate);
		model.addAttribute("questionCount", this.getNumQuestion());
		return "quiz/answer";
	}
	
// =====問題表示======
	//問題一覧
	@GetMapping("/list")
	public String getAllQuizList(Model model) {
		model.addAttribute("quizAllList", q.selectAllQuiz());
		return "list";
	}
	
	//Idで問題検索
	@GetMapping("pickUp")
	public String pickUpQuiz(@RequestParam int id, Model model) {
		QuizForm form = Quizhelper.convertForm(q.findQuizById(id));
		//ID検索からの詳細画面用設定のため
		form.setIsNew(true);
		//trueを持ったフォームを情報を格納
		model.addAttribute("pickUpQuiz", form);
		return "detail";
	}
	
	
// =====登録・更新=====
	
	//新規登録画面の設定
	@GetMapping("/form")
	public String newQuiz(@ModelAttribute QuizForm form) {
		form.setIsNew(true);
		return "form";
		
	}
	
	//新規登録問題の入力後の画面遷移
	@GetMapping("save")
	public String creat(@ModelAttribute QuizForm form, RedirectAttributes attributes) {
		//登録実行
		q.insertNewQuiz(Quizhelper.toQuiz(form));
		// フラッシュメッセージ
		attributes.addFlashAttribute("message", "新しい問題が追加されました");
		//同じフォーム画面へもどる（上記フラッシュメッセージ付き）
		return "redirect:/form";
	}
	
	//編集画面へ(menu.html->form(isNew=null))
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model model, RedirectAttributes att) {
		Quiz target = q.findQuizById(id);
		if(target != null) {
			//対象データがある場合はFormへの変換
			QuizForm form = Quizhelper.toForm(target);
			model.addAttribute("quizForm", form);
			return "/form";
		} else {
			//対象データがない場合はフラッシュメッセージを表示
			att.addFlashAttribute("errorMessage", "対象のデータがありません");
			return "redirect:/list";
		}
	}
		
	//編集やり直し(detail.html->form)
	@PostMapping("reedit")
	public String reedit(Model model) {
		model.addAttribute("quizForm", getTemporaryForm());
		return "form";
	}
	
	//更新前確認(form.html->detail(pickUpQuiz.isNew=null))
	@GetMapping("/check")
	public String checkBeforeUpdate(@ModelAttribute QuizForm form,
			Model model) {
//		更新のため一時的にフィールドに情報保存
		this.setTemporaryForm(form);
//		//isNew判定とメッセージ表示、変更予定の内容を格納
		model.addAttribute("pickUpQuiz", form);
		//タイムテーブルから午前か午後かの情報を取ってくる
		model.addAttribute("timeTable",q.findTimeTable(form.getTimeId()));
		//項目テーブルから小項目情報を取ってくる
		model.addAttribute("koumokuTable",q.findKoumokuTable(form.getKoumokuId()));
		model.addAttribute("checkMessage", "変更内容に間違いはありませんか");
		//変更前の内容
		model.addAttribute("before", q.findQuizById(form.getId()));
		return "detail";
		
	}
	
	//更新処理
	@PostMapping("update")
	public String updateQuestion(@ModelAttribute QuizForm form,  RedirectAttributes redirect) {
		//データベースへの更新処理
		q.updateQuiz(Quizhelper.toQuiz(this.getTemporaryForm()));

		//フラッシュメッセージ
		redirect.addFlashAttribute("updateMessage", "問題が更新されました");
		return "redirect:/list";
	}
	
// ======問題の削除=======
	//最終確認のページ
	@GetMapping("pickUpDeleteQuestion")
	public String pickUpDeleteQuestion(@RequestParam int id, Model model) {
		QuizForm form = Quizhelper.convertForm(q.findQuizById(id));
		//ID検索からの詳細画面用設定のため
		form.setIsNew(true);
		//trueを持ったフォームを情報を格納
		model.addAttribute("pickUpQuiz", form);
		//削除ボタン追加のため
		model.addAttribute("deleteButton", true);
		return "detail";
	}
	
	//削除処理
	@PostMapping("delete")
	public String deleteQuestion(@RequestParam int id, Model model, RedirectAttributes att) {
		q.deleteQuiz(id);
		att.addFlashAttribute("deleteMessage", "問題を削除しました");
		return "redirect:/list";
		
	}
	

}

