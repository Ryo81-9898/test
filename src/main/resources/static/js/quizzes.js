/**
 * 
 */

// ページ読み込み時に実行される処理
window.onload = function() {
    // 初期状態で問題部分とボタン類を隠す
    document.getElementById("quiz-section").style.display = "none";
    document.getElementById(".sidebar").style.display = "none";
};

// スタートボタンがクリックされた時に問題とボタンを表示
function startQuiz() {
    document.getElementById("quiz-section").style.display = "block";  // 問題部分を表示
    document.getElementById("submit-button").style.display = "inline-block";  // 解答ボタンを表示
    document.getElementById("back-button").style.display = "inline-block";  // メニューへ戻るボタンを表示
	document.querySelector(".start-button-container").style.display = "none";  // スタートボタンとチェックボックスのコンテナーを非表示
//    document.getElementById("startButton").style.display = "none";  // スタートボタンを非表示
//    document.getElementById("timer-option").style.display = "none";  // タイマーのチェックボックスを非表示
}


//タイマー設置
let timerInterval;
let secondsElapsed = 0;

document.getElementById('startButton').addEventListener('click', () => {
  const timerCheckbox = document.getElementById('timerCheckbox');
  if (timerCheckbox.checked) {
    document.getElementById('timerDisplay').classList.remove('hidden');
    timerInterval = setInterval(() => {
      secondsElapsed++;

      const minutes = Math.floor(secondsElapsed / 60);
      const seconds = secondsElapsed % 60;

      // 2桁表示にしたい場合（例: 01分09秒）→ padStartを使う
      const formattedMinutes = String(minutes).padStart(2, '0');
      const formattedSeconds = String(seconds).padStart(2, '0');

      document.getElementById('time').textContent = `${formattedMinutes}分${formattedSeconds}秒`;
    }, 1000);
  }
});


//let timerInterval;
//let secondsElapsed = 0;
//
//document.getElementById('startButton').addEventListener('click', () => {
//  const timerCheckbox = document.getElementById('timerCheckbox');
//  if (timerCheckbox.checked) {
//    document.getElementById('timerDisplay').classList.remove('hidden');
//    timerInterval = setInterval(() => {
//      secondsElapsed++;
//      document.getElementById('time').textContent = secondsElapsed;
//    }, 1000);
//  }
//});
