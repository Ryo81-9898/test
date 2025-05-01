/**
 * 
 */
//URL変更時のアラート機能
document.addEventListener('DOMContentLoaded', function () {
	const form = document.querySelector('form');
	const blogUrlInput = document.getElementById('blogUrl');

	// 初期値を取得（ページ読み込み時の値を記録）
	const originalValue = blogUrlInput.value;

	form.addEventListener('submit', function (e) {
		// 入力値が変更されているかチェック
		if (blogUrlInput.value !== originalValue) {
			const confirmed = confirm('URLが変更されています。本当に送信しますか？');
			if (!confirmed) {
				e.preventDefault(); // 送信をキャンセル
			}
		}
	});
});
