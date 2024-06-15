<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>LoginPage</title>
    <style>
        .line_t{
            border: 1px solid black;
        }
        a{
            /*text-decoration: none;*/
            color:inherit;
            text-decoration-line: none;
        }

       .container{
           display: flex;
           height:500px;
           justify-content: center;
           width: 400px;
           margin:0 auto;
           box-sizing: border-box;
        }
        .login_wrap{
            justify-content: center;
        }
        .container > .login_wrap > .login_header_box{
            width:100%;
            font-weight: bold;
            color: #090;
            text-align: center;

        }
        .login_input_item{
            width:100%;
            padding:4px;
            margin: 7px 0;
        }

        .btn_login_submit{
            margin-top:15px;
            width:100px;
            height:30px;
            border:1px solid cornsilk;
            border-radius: 11px;
            background-color: cadetblue;
            color:white;
        }

    </style>
    <script>
        const validate = () =>{
            let strUserId = document.getElementById("userId");
            let strPassword = document.getElementById("password");

            return true;
        }

    </script>


</head>
<body>
    <div class="container line_t">
        <div class="login_wrap">
            <div class="login_header_box">
                <h2>로그인</h2>
            </div>
            <form action="../member/login" method="post">
                <input type="text" placeholder="아이디" name="userId" id="userId" class="login_input_item"><br>

                <input type="password" placeholder="패스워드" name="password" id="password" class="login_input_item">
                <div class="login_header_box">
                    <a href="/web/member/signup">회원가입</a> /
                    <a href="/web/member/">아이디 찾기</a> /
                    <a href="#">패스워드 찾기</a>
                </div>
                <input type="submit" value="로그인" class="btn_login_submit" onclick="return validate()" >

            </form>
        </div>
    </div>

</body>
</html>