<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/custom.css" rel="stylesheet">
    <title>JSP AJAX 실시간 익명 채팅 사이트</title>
    <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous">
    </script>
    <script src="js/bootstrap.js"></script>
    <script>
        function submitFunction(){
            let charName= $("chatName").val();
            let chatContent= $("chatContent").val();
            $.ajax({
                type:"POST",
                url :"./chatSubmitServlet",
                data:{
                    chatName:charName,
                    //파라미터 이름 : 실제로 보내는값
                    chatContent:chatContent
                },
                success:function (result){
                    if (result == 1){
                        alert("전송에 성공하셨습니다");
                    }
                    else if (result == 0){
                        alert("이름과 내용을 정확히 입력해주세요");
                    }else {
                        alert("데이터베이스 오류가 발생했습니다");
                    }
                }

            });
            $("#chatContent").val("");
        }
    </script>
</head>
<body>
    <div class="container">
        <div class="container bootstrap snippet">
            <div class="row">
                <div class="col-xs-12">
                    <div class="portlet portlet-title">
                        <div class="portlet-heading" style="background-color: #5dbcd5; height: 7%">
                            <div class="portlet-title">
                                <h4 style="height: 10%"><i class="fa fa-circle text-green"></i>실시간 채팅방</h4>
                            </div>
                            <div class="clearfix" style="height: 7%"></div>
                        </div>
                        <div id="chat" class="panel-collapse collapse in">
                            <div class="portlet-body chat-widget" style="overflow: auto; width: auto;height: 300px">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <p class="text-center text-muted small">2023년 3월 8일</p>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg=12">
                                        <div class="media">
                                            <a class="pull-left" href="#">
                                                <img class="media-object img-circle" src="https://th.bing.com/th?id=OIP.AlA7Yenn0urfoIpt8wshHwHaHa&w=250&h=250&c=8&rs=1&qlt=90&o=6&dpr=1.3&pid=3.1&rm=2" width="70px" height="50px">
                                            </a>
                                            <div class="media-body">
                                                <h4 class="media-heading">홍길동
                                                    <span class="small pull-right">오전 12시 30분</span>
                                                </h4>
                                            </div>
                                            <p>안녕하세요 주동호 입니다</p>
                                        </div>
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-lg=12">
                                        <div class="media">
                                            <a class="pull-left" href="#">
                                                <img class="media-object img-circle" src="https://th.bing.com/th?id=OIP.AlA7Yenn0urfoIpt8wshHwHaHa&w=250&h=250&c=8&rs=1&qlt=90&o=6&dpr=1.3&pid=3.1&rm=2" width="70px" height="50px">
                                            </a>
                                            <div class="media-body">
                                                <h4 class="media-heading">홍길동
                                                    <span class="small pull-right">오전 12시 30분</span>
                                                </h4>
                                            </div>
                                            <p>안녕하세요 주동호 입니다</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="portlet-footer">
                                <div class="row">
                                    <div class="form-group col-xs-4">
                                        <input style="height: 40px;" type="text" id="chatName" class="form-control" placeholder="이름" maxlength="20">
                                    </div>
                                </div>
                                <div class="row" style="height: 90px">
                                    <div class="form-group col-xs-10">
                                    <textarea style="height: 80px" id="chatContent" class="form-control" placeholder="메세지를 입력하세요" maxlength="100">
                                    </textarea>
                                    </div>
                                    <div class="form-group col-xs-2">
                                        <button type="button" class="btn btn-default pull-right" onclick="submitFunction()">
                                            전송
                                        </button>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>