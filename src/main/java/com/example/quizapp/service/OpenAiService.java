package com.example.quizapp.service;

//@Service
//public class OpenAiService {
//
//	@Value("${openai.api.key}")
//	private String openAiApiKey;
//
//	public String generateExplanation(String question, String choice1, String choice2, String choice3, String choice4,
//			String choice5) {
//		// OpenAiServiceを初期化
//		OpenAiService openAiService = new OpenAiService(openAiApiKey);
//
//		// 問題文と選択肢を組み合わせて解説を生成するリクエスト
//		String prompt = "問題文: " + question + "\n選択肢:\n1. " + choice1 + "\n2. " + choice2 + "\n3. " + choice3 + "\n4. "
//				+ choice4 + "\n5. " + choice5 + "\nこの問題について簡潔な解説を生成してください。";
//
//		// リクエスト作成
//		ChatCompletionRequestMessage message = new ChatCompletionRequestMessage();
//		message.setRole("user");
//		message.setContent(prompt);
//
//		ChatCompletionRequest request = ChatCompletionRequest.builder()
//				.model("gpt-3.5-turbo") // 使用するモデルを指定
//				.messages(Arrays.asList(message))
//				.build();
//
//		// OpenAI APIにリクエストを送信
//		ChatCompletionResponse response = openAiService.createChatCompletion(request);
//
//		// レスポンスから生成されたテキストを取得
//		String explanation = response.getChoices().get(0).getMessage().getContent();
//		return explanation;
//	}
//
//}
