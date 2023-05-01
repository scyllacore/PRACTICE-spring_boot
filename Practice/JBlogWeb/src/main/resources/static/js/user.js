let userObj = {
    init: function () {
        let _this = this;

        $("#btn-save").on("click",() => {
            _this.insertUser();
        });
    },

    insertUser :function (){
        alert("회원가입 요청됨");

        let user = {
            userName : $("#userName").val(), // username : -> userName : 으로 수정.
            password : $("#pwd").val(),
            email : $("#email").val()
        }

        //console.log(user);

        $.ajax({
            type : "POST", // "Post" -> "POST" 수정.
            url: "/auth/insertUser",
            data: JSON.stringify(user),
            contentType: "application/json; charset=utf-8"
        }).done(function (response){
            console.log(response);
            //location = "/";
        }).fail(function (error){
           alert("에러 발생 : " + error);
        });

        },
}

userObj.init();