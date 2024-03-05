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
                return response.json();
            }
            else {
                throw new Error('Failed to recognize audio');
            }
        })
        .then(data => {
            if (data === true) {
                document.getElementById("signUpForm").style.display = "none";
                document.getElementById("confirmationForm").style.display = "";
            }
            else {
                document.getElementById("signUpForm").style.display = "none";
                document.getElementById("alreadyRegistered").style.display = "";
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
    })
        .then(response => {
            if (response.status === 200) {
                return response.json();
            }
            else {
                throw new Error('Failed to recognize audio');
            }
        })
        .then(data => {
            if (data === true) {
                document.getElementById("confirmationForm").style.display = "none";
                document.getElementById("confirmed").style.display = "";
                document.getElementById("notConfirmed").style.display = "none";
            } else {
                document.getElementById("notConfirmed").style.display = "";
            }
        });
}
