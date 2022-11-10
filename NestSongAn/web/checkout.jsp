<%-- 
    Document   : checkout
    Created on : Nov 9, 2022, 8:35:29 PM
    Author     : minhd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>   <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-bag-check" viewBox="0 0 16 16">
            <path fill-rule="evenodd" d="M10.854 8.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 0 1 .708-.708L7.5 10.793l2.646-2.647a.5.5 0 0 1 .708 0z"/>
            <path d="M8 1a2.5 2.5 0 0 1 2.5 2.5V4h-5v-.5A2.5 2.5 0 0 1 8 1zm3.5 3v-.5a3.5 3.5 0 1 0-7 0V4H1v10a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V4h-3.5zM2 5h12v9a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V5z"/>
            </svg> Bạn Đã Đặt Hàng Thành Công </h1>
        <h1><a href="HomeController">Tiếp Tục Mua Hàng</a></h1>
        <script type="text/javascript">
            var count = 10;
            var redirect = "HomeController";
            function countDown() {
                var timer = document.getElementById("timer");
                if (count > 0) {
                    count--;
                    timer.innerHTML = "Bạn sẽ được tự động về trang chủ trong <b>" + count + "</b> giây.";
                    setTimeout("countDown()", 1000);
                } else {
                    window.location.href = redirect;
                }
            }
        </script>
        <style>
            .wrap {
                width: 600px;
                margin: 250px auto;
                padding: 20px;
                border-radius: 10px;
                border: 1px solid #ddd;
                font-size: 20px;
                line-height: 1.3em;
                text-align: center;
            }
        </style>
        <div class="wrap">
            <p id="timer"><script type="text/javascript">countDown();</script></p>
        </div>
    </body>
</html>
</body>
</html>
