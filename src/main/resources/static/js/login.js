/**
 * 
 */

function validateLogin() {
	const username = document.getElementById('usernameInput').value.trim();
	const password = document.getElementById('passwordInput').value.trim();

	if (username === "" || password === "") {
		alert("両方の項目を入力してください。");
		return false;
	}
	return true;
}
