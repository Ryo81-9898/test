/**
 * 
 */

//タイトルの動き
window.addEventListener('load', function() {
    document.querySelector('.menu-title').classList.add('loaded');
});




/*button .btnのjsの機能の設定*/
/* クリックアニメーション */
document.addEventListener("DOMContentLoaded", () => {
    const buttons = document.querySelectorAll("button, .btn");
    buttons.forEach(button => {
        button.addEventListener("click", () => {
            button.classList.add("clicked");
            setTimeout(() => {
                button.classList.remove("clicked");
            }, 200);
        });
    });
});


//チャレンジボタンのカーソルを合わせて出るメッセージ
//document.addEventListener("DOMContentLoaded", function () {
//    const buttons = document.querySelectorAll(".menu-buttons .btn");
//    const messageBox = document.getElementById("hover-message");
//
//    buttons.forEach(btn => {
//        btn.addEventListener("mouseenter", function (e) {
//            const message = btn.dataset.message;
//            messageBox.textContent = message;
//            messageBox.style.display = "block";
//
//            // マウス位置に合わせて表示
//            const rect = btn.getBoundingClientRect();
//            messageBox.style.left = `${rect.left}px`;
//            messageBox.style.top = `${rect.top}px`;  // 上に表示
//        });
//
//        btn.addEventListener("mouseleave", function () {
//            messageBox.style.display = "none";
//        });
//    });
//});

document.addEventListener("DOMContentLoaded", function () {
    const buttons = document.querySelectorAll(".menu-buttons .btn");
    const messageBox = document.getElementById("hover-message");

    function isMobileView() {
        return window.innerWidth < 600;
    }

    buttons.forEach(btn => {
        btn.addEventListener("mouseenter", function (e) {
            if (isMobileView()) return; // モバイル表示なら何もしない

            const message = btn.dataset.message;
            messageBox.textContent = message;
            messageBox.style.display = "block";

            const rect = btn.getBoundingClientRect();
            messageBox.style.left = `${rect.left}px`;
            messageBox.style.top = `${rect.top + 200}px`;
        });

        btn.addEventListener("mouseleave", function () {
            if (isMobileView()) return;

            messageBox.style.display = "none";
        });
    });
});



