<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>后台管理登录</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        body{
            width: 100%;
            height: 100%;
            min-width: 1200px;
            background: url('http://www.cycphp.top/Didu/images/banner1.jpg');
            /*  background-color: gray;*/
            position: relative;
        }
        form{
            width: 300px;
            height:200px;
            background-color: white;
            position: absolute;
            top: 160px;
            left: 50%;
            transform: translateX(-50%);
            text-align: center;
            line-height: 40px;
            /*opacity: 0.6;*/
            border: none;
            border-radius: 10px;
            padding: 10px;
        }
        form .images{
            float: left;
            width: 100px;
            height: 200px;
        }
        form input{
            margin: 0 auto;
            width: 200px;
            height: 30px;
            outline:none;
        }
        form button{
            width: 160px;
            height: 40px;
            margin-top: 20px;
            background-color: skyblue;
            border-radius: 10px;
            border: none;
            color: white;
        }
    </style>
</head>
<body>
<!-- 登录  表 id  number（管理编号001以后 001的权限最高） username password -->
<form id="addform" action="login" method="post">
    <input class="ip1" name="status" type="text" placeholder="请输入管理员编号"><br>
    <input class="ip2" type="text" name="username" placeholder="请输入管理员姓名"><br>
    <input class="ip3" type="password" name="password" placeholder="请输入密码">
    <br>
    <button class="button" type="button" >登陆</button>
</form>
<script src="js/jquery-1.12.3.min.js"></script>
<script>
    $(".button").click(function(){
        if (($(".ip1").val()=='')||($(".ip2").val()=='')||($(".ip3").val()=='')) {
            alert('请输入')
        }else{
            ajax1();
        }
    });
    function ajax1(){
        $.post({
            url:"login",   //同action
            type:'post',
            dataType: 'json',
            success:function(data)
            {
                console.log(data);
                alert('登陆成功')
                location.href='gly';
                localStorage.setItem('number',$('.ip1').val());
                localStorage.setItem('username',$('.ip2').val());
            },
            error :function(data)
            {
                console.log(2)
                console.log(data)
            },
        })
    }
</script>
</body>
</html>
