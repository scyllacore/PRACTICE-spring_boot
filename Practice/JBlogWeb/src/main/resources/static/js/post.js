let postObj = {
    init: function () {
        let _this = this;

        $("#btn-insert").on("click", () => {
            _this.insertPost();
        });

        $("#btn-update").on("click", () => {
            _this.updatePost();
        });
        $("#btn-delete").on("click", () => {
            _this.deletePost();
        });
    },

    insertPost: function () {
        alert("게시물 등록 요청됨");

        let post = {
            title: $("#title").val(), // userName : -> username : 으로 수정.
            content: $("#content").val()
        }

        //console.log(user);

        $.ajax({
            type: "POST", // "Post" -> "POST" 수정.
            url: "/post",
            data: JSON.stringify(post),
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

                if (errors.title != null) {
                    warn += errors.title + "\n";
                }
                if (errors.content != null) {
                    warn += errors.content;
                }
                alert(warn);
            }
        }).fail(function (error) {
            alert("에러 발생 : " + error);
        });

    },

    updatePost : function () {
        alert("게시글 수정 요청됨");

        let post = {
            id : $("#id").val(),
            title: $("#title").val(),
            content: $("#content").val()
        }


        $.ajax({
            type: "PUT", // "Post" -> "POST" 수정.
            url: "/post",
            data: JSON.stringify(post),
            contentType: "application/json; charset=utf-8"
        }).done(function (response) {
            let message = response["data"];
            console.log(message);
            location = "/";
        }).fail(function (error) {
            let message = error["data"];
            alert("에러 발생 : " + message);
        });

    },

    deletePost : function () {
        alert("게시글 삭제 요청됨");

        let id = $("#id").text();

        $.ajax({
            type: "DELETE", // "Post" -> "POST" 수정.
            url: "/post/" + id,
            contentType: "application/json; charset=utf-8"
        }).done(function (response) {
            let message = response["data"];
            console.log(message);
            location = "/";
        }).fail(function (error) {
            let message = error["data"];
            alert("에러 발생 : " + message);
        });

    },

}

postObj.init();