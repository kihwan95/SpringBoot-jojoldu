var main = {
    init: function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
    },
    save: function () {
        var data = {
            title: $("#title").val(),
            author: $("#author").val(),
            content: $("#content").val()
        };

        var stringifyData = JSON.stringify(data);
        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: stringifyData,
            success : function () {
                alert('글이 등록되었습니다.');
                window.location.href = '/';
            },error : function(error){
                alert(JSON.stringify(error));
            }
        })//ajax
    }
};

main.init();