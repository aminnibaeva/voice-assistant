function signUp() {
    const username = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    fetch('/auth/sign-up', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            username: username,
            email: email,
            password: password,
            role: "OWNER"
        })
    })
        .then(response => {
            if (response.status === 200) {
                document.getElementById("signUpForm").style.display = "none";
                document.getElementById("confirmationForm").style.display = "";
            }
        });
}

function confirm() {
    const email = document.getElementById("email").value;
    const confirmCode = document.getElementById("confirmCode").value;

    fetch('/auth/confirm', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            email: email,
            confirmCode: confirmCode,
            role: "OWNER"
        })
    });
}
