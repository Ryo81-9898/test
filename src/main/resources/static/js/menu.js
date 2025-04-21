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


