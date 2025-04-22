/**
 * 
 */
const time = sessionStorage.getItem("elapsedTime");
if (time) {
  document.getElementById("display-time").textContent = `あなたの解答時間：${time}でした`;
}