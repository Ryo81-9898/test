/**
 * 
 */
//タイマーの経過時間の表示
const time = sessionStorage.getItem("elapsedTime");
const displayTime = document.getElementById("display-time");

if (time && time !== "00分00秒") {
  displayTime.textContent = `解答時間：${time}`;
  displayTime.style.display = "block";
}




// 解説を見るリンクをクリックしたときに解説をトグル表示
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


