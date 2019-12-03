jQuery(document).ready(function () {

    /*
        Background slideshow
    */
    $.backstretch([
        "assets/img/backgrounds/1.jpg"
        , "assets/img/backgrounds/2.jpg"
        , "assets/img/backgrounds/3.jpg"
    ], {duration: 3000, fade: 750});

    /*
        Tooltips
    */
    $('.links a.home').tooltip();
    $('.links a.blog').tooltip();

    var tagusername=1;
    var times = 60;

    function roof() {
        if (times == 0) {
            $('.yanzhengma').text('发送验证码(' + times + 's)');
            $('.yanzhengma').prop('disabled', false);
            $('.yanzhengma').text('发送验证码');
            times = 60;
            return
        }
        $('.yanzhengma').prop('disabled', true);
        $('.yanzhengma').text('发送验证码(' + times + 's)');
        times--;

        setTimeout(roof, 1000);
    }

    $('.yanzhengma').on('click', function () {
        $("#dataform").find("label[for='phone']").html('手机号');
        var phone = $('#phone').val();
        if (phone == '') {
            $("#dataform").find("label[for='phone']").append("<span style='display:none' class='red'> - 请输入手机号.</span>");
            $("#dataform").find("label[for='phone'] span").fadeIn('medium');
            return false;
        }
        if (!phone.match(/^1[34578]\d{9}$/)) {
            $("#dataform").find("label[for='phone']").append("<span style='display:none' class='red'> - 手机号码格式不正确.</span>");
            $("#dataform").find("label[for='phone'] span").fadeIn('medium');
            return false;
        }
        // 验证手机
        $.get(
            "/register/member/checkedMobile.do?mobile=" + phone,
            function (result) {
                if (result.code == 200) {
                    var errorMobileMessage = result.msg;
                    $("#dataform").find("label[for='phone']").append("<span style='display:none' class='green'> - " + errorMobileMessage + ".</span>");
                    $("#dataform").find("label[for='phone'] span").fadeIn('medium');
                    // 异步  发送验证码
                    $.get(
                        "/register/member/getMobileCode.do?mobile=" + phone,
                        function (result2) {
                            if (result2.code == 200) {
                                // 发送成功  就开始计时
                                $("#dataform").prop('disabled', true);
                                roof();
                            }
                        }, "json"
                    );
                }
                if (result.code == 400) {
                    var errorMobileMessage = result.msg;
                    $("#dataform").find("label[for='phone']").append("<span style='display:none' class='red'> - " + errorMobileMessage + ".</span>");
                    $("#dataform").find("label[for='phone'] span").fadeIn('medium');
                    return;
                }
            }, "json");
    });

    /*
        Form validation
    */
    $('#sub').click(function () {
        $("#dataform").find("label[for='username']").html('姓名');
        $("#dataform").find("label[for='loginname']").html('登录名');
        $("#dataform").find("label[for='phone']").html('手机号');
        $("#dataform").find("label[for='mima']").html('密码');
        $("#dataform").find("label[for='repeatmima']").html('确认密码');
        ////
        var username = $("#dataform").find('input#username').val();
        var loginname = $("#dataform").find('input#loginname').val();
        var phone = $("#dataform").find('input#phone').val();
        var yanzhengma = $("#dataform").find('input#yanzhengma').val();
        var mima = $("#dataform").find('input#mima').val();
        var repeatmima = $("#dataform").find('input#repeatmima').val();
        if (username == '') {
            $("#dataform").find("label[for='username']").append("<span style='display:none' class='red'> - 请输入姓名.</span>");
            $("#dataform").find("label[for='username'] span").fadeIn('medium');
            return false;
        }
        if (loginname == '') {
            $("#dataform").find("label[for='loginname']").append("<span style='display:none' class='red'> - 请输入登录名.</span>");
            $("#dataform").find("label[for='loginname'] span").fadeIn('medium');
            return false;
        }
        if (phone == '') {
            $("#dataform").find("label[for='phone']").append("<span style='display:none' class='red'> - 请输入手机号.</span>");
            $("#dataform").find("label[for='phone'] span").fadeIn('medium');
            return false;
        }
        if (yanzhengma == '') {
            $("#dataform").find("label[for='phone']").append("<span style='display:none' class='red'> - 请输入验证码.</span>");
            $("#dataform").find("label[for='phone'] span").fadeIn('medium');
            return false;
        }
        if (mima == '') {
            $("#dataform").find("label[for='mima']").append("<span style='display:none' class='red'> - 请输入密码.</span>");
            $("#dataform").find("label[for='mima'] span").fadeIn('medium');
            return false;
        }
        if (repeatmima == '') {
            $("#dataform").find("label[for='repeatmima']").append("<span style='display:none' class='red'> - 请输入密码.</span>");
            $("#dataform").find("label[for='repeatmima'] span").fadeIn('medium');
            return false;
        }
        if (repeatmima != mima) {
            $("#dataform").find("label[for='repeatmima']").append("<span style='display:none' class='red'> - 两次密码不一致.</span>");
            $("#dataform").find("label[for='repeatmima'] span").fadeIn('medium');
            return false;
        }
        var getUrl="/register/member/checkedMobileCode.do";
        $.get(
            getUrl,
            {code:yanzhengma,mobile:phone},
            function (res) {
                if (res.code==200){
                    var url = "/register/member/register.do";
                    $.post(
                        url,
                        {
                            username: username,
                            loginname: loginname,
                            pwd: mima,
                            phone: phone
                        },
                        function (result) {
                            alert(result.code)
                            if (result.code == 200) {
                                // 成功
                                location.href = "/register/success.html";
                                return;
                            }
                            $("#dataform").find("label[for='phone']").append("<span  class='red'> - 注册失败</span>");
                            $("#dataform").find("label[for='phone'] span").fadeIn('medium');
                            return;
                        }, 'json'
                    );
                }else{
                    $("#dataform").find("label[for='phone']").append("<span  class='red'> - 验证码不一致.请再发一次</span>");
                    $("#dataform").find("label[for='phone'] span").fadeIn('medium');
                    return;
                }
            },'json'
        )
    });
    $("#loginname").blur(function () {
        var loginname=$("#dataform").val().trim();
        if (loginname.length>=4) {
            $.get("/register/member/checkedLoginName.do",{loginname:loginname},function (res) {
                if (res.code==200){
                    $("#dataform").find("label[for='loginname']").append("<span style='display:none' class='green'> - 登录名可以注册.</span>");
                    $("#dataform").find("label[for='loginname'] span").fadeIn('medium');
                    tagusername=0;
                } else {
                    $("#dataform").find("label[for='loginname']").append("<span style='display:none' class='red'> - 登录名重复，请更换.</span>");
                    $("#dataform").find("label[for='loginname'] span").fadeIn('medium');
                    tagusername=1;
                }
            });
        }

    })
});


