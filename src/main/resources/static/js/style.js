/**
 * 
 */

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


// ページ下部に表示＆クリックでトップへ戻る
document.addEventListener('DOMContentLoaded', () => {
  const scrollTopBtn = document.getElementById('scrollTopBtn');

  window.addEventListener('scroll', () => {
    if (window.scrollY > 600) {
      scrollTopBtn.classList.add('show');
    } else {
      scrollTopBtn.classList.remove('show');
    }
  });

  scrollTopBtn.addEventListener('click', () => {
    window.scrollTo({
      top: 0,
      behavior: 'smooth'
    });
  });
});

