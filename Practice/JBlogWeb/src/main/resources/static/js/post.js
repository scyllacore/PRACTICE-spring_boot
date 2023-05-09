let postObj = {
    init: function () {
        let _this = this;

        $("#btn-insert").on("click", () => {
            _this.insertPost();
        });
    },

    insertPost: function () {
        alert("게시물 등록 요청됨");

        let post = {
            title: $("#userName").val(), // username : -> userName : 으로 수정.
            content: $("#pwd").val()
        }

        //console.log(user);

        $.ajax({
            type: "POST", // "Post" -> "POST" 수정.
            url: "/post",
            data: JSON.stringify(post),
            contentType: "application/json; charset=utf-8"
        }).done(function (response) {
            let message = response["data"];
            console.log(message);
            location = "/";
        }).fail(function (error) {
            alert("에러 발생 : " + error);
        });

    },
}

postObj.init();