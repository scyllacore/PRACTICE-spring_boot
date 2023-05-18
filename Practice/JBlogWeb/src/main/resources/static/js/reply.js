let replyObj = {
    init: function () {
        let _this = this;

        $("#btn-save-reply").on("click", () => {
            _this.insertReply();
        });
    },

    insertReply: function () {
        alert("댓글 등록 요청됨");

        let id = $("#postId").val();

        let reply = {
            content: $("#reply-content").val()
        }

        $.ajax({
            type: "POST", // "Post" -> "POST" 수정.
            url: "/reply/" + id,
            data: JSON.stringify(reply),
            contentType: "application/json; charset=utf-8"
        }).done(function (response) {
            let messege = response["data"];
            alert(messege);
            location = "/post/" + id;
        }).fail(function (error) {
            alert("에러 발생 : " + error);
        });
    },
}

replyObj.init();