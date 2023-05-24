let userObj = {
    init: function () {
        let _this = this;

        $("#btn-save").on("click", () => {
            _this.insertUser();
        });
    },

    insertUser: function () {
        alert("회원가입 요청됨");

        let user = {
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val()
        }

        console.log(user);

        $.ajax({
            type: "POST", // "Post" -> "POST" 수정.
            url: "/auth/insertUser",
            data: JSON.stringify(user),
            contentType: "application/json; charset=utf-8"
        }).done(function (response) {
            let status = response["status"];

            if (status == 200) {
                let message = response["data"];
                console.log(message);
                location = "/";
            } else {
                let warn = response["data"]; // 이 부분 어찌할지 생각해보기
                // 코드를 추가하면서 id중복에 대한 alert 처리가 이상하게 됨.
                let errors = response["data"];

                if (errors.username != null) {
                    warn += errors.username + "\n";
                }
                if (errors.password != null) {
                    warn += errors.password + "\n";
                }
                if (errors.email != null) { // 여기 잘못 썼다..
                    warn += errors.email;
                }
                alert(warn);
            }

        }).fail(function (error) {
            alert("에러 발생 : " + error);
        });

    },
}

userObj.init();