function generatePassword() {
    let length = document.getElementById("length").value;
    let includeNumbers = document.getElementById("includeNumbers").checked;
    let includeSpecialChars = document.getElementById("includeSpecialChars").checked;

    fetch(`/generate?length=${length}&includeNumbers=${includeNumbers}&includeSpecialChars=${includeSpecialChars}`)
        .then(response => response.text())
        .then(data => {
            document.getElementById("passwordResult").value = data;
        })
        .catch(error => console.error("Error:", error));
}

function copyToClipboard() {
    let passwordField = document.getElementById("passwordResult");
    passwordField.select();
    document.execCommand("copy");
    alert("비밀번호가 복사되었습니다!");
}
