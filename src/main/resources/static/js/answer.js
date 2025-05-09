/**
 * 
 */
//タイマーの経過時間の表示
const time = sessionStorage.getItem("elapsedTime");
if (time) {
  document.getElementById("display-time").textContent = `あなたの解答時間：${time}でした`;
}


// 解説を見るリンクをクリックしたときに解説をトグル表示
//document.querySelectorAll('.toggle-explanation').forEach(function(toggleButton) {
//  toggleButton.addEventListener('click', function() {
//    const explanationContent = this.nextElementSibling;
//    explanationContent.classList.toggle('visible');
//    
//    // もし解説が表示されているなら「解説を閉じる」にテキスト変更
//    if (explanationContent.classList.contains('visible')) {
//      this.textContent = '解説を閉じる';
//    } else {
//      this.textContent = '解説を見る';
//    }
//  });
//});

document.addEventListener('DOMContentLoaded', function () {
  const toggles = document.querySelectorAll('.toggle-explanation');
  toggles.forEach(function (toggle) {
    toggle.addEventListener('click', function () {
      const content = this.nextElementSibling;
      if (content.style.display === 'block') {
        content.style.display = 'none';
        this.textContent = '解説を見る';
      } else {
        content.style.display = 'block';
        this.textContent = '解説を閉じる';
      }
    });
  });
});
