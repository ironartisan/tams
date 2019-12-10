// 判断是否为空
function is_null(value) {
    // var value = $("#type_id").val();
    if (value == null|| value == undefined || value=='') {
        return false;
    }
}
function check_tname() {
    // 判断姓名是否为空
    var username = $("#tname").val();
    if(is_null(username) == false){
        err ='用户名输入错误';
        document.getElementById("error").style.visibility  = "visible";
        document.getElementById("error").innerHTML="提示："+err;
    }else{
        document.getElementById("error").style.visibility  = "hidden";
    }

}
function check_tno() {
    // 判断学号是否为10位
    var tno = $("#tno").val();
    if(/^\d{10}$/g.test(tno) == false) {
        err ='编号输入错误';
        document.getElementById("error").style.visibility  = "visible";
        document.getElementById("error").innerHTML="提示："+err;;
    }else{
        document.getElementById("error").style.visibility  = "hidden";
    }
}
function check_age() {
    // 判断年龄范围
    var age = $("#age").val();
    if(is_null(age) == false){
        err ='年龄输入为空';
        document.getElementById("error").style.visibility  = "visible";
        document.getElementById("error").innerHTML="提示："+err;
    }
    else if(age >70 || age <=15){
        err ='年龄输入错误';
        document.getElementById("error").style.visibility  = "visible";
        document.getElementById("error").innerHTML="提示："+err;
    }else{
        document.getElementById("error").style.visibility  = "hidden";
    }
}

function check_eamil() {
    // 判断Email格式
    var email = $("#email").val();
    if(is_null(email)== false){
        err ='邮箱输入错误';
        document.getElementById("error").style.visibility  = "visible";
        document.getElementById("error").innerHTML="提示："+err;
    }
    var reg = /[a-z0-9]*@[a-z0-9]*\.[a-z0-9]+/gi;
    var  is_email = reg.test(email);
    console.log(is_email)
    if (!is_email) {
        err ='邮箱输入错误';
        document.getElementById("error").style.visibility  = "visible";
        document.getElementById("error").innerHTML="提示："+err;
    }else{
        document.getElementById("error").style.visibility  = "hidden";
    }
}
function check_password()
{
    // 判断两次输入的密码是否一致
    var password = $("#password").val();
    var confirm_password = $("#confirm-password").val();
    if(password != confirm_password){
        err ='两次密码输入不一致';
        document.getElementById("error").style.visibility  = "visible";
        document.getElementById("error").innerHTML="提示："+err;
    }else{
        document.getElementById("error").style.visibility  = "hidden";
    }
}

