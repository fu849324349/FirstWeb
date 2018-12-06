window.onload = function ()
{
	//获取input的ID
	var vuserName = document.getElementById("userName");
	var vpassword1 = document.getElementById("password1");
	// var vpassword2 = document.getElementById("password2");
	var vEmail = document.getElementById("email");
	var viphone = document.getElementById("iphone");
	// var vpostCode = document.getElementById("postCode");
	// var vidCode = document.getElementById("idCode");
	// var vbutton = document.getElementById("button1");
	//判断用户名是否合法
	vuserName.onblur = function()
	{
		var result = this.value.match(/\w{6,14}$/);//\w表示所有的数字字母和下划线
		if(result == null)
		{
			document.getElementById("span1").innerText = "账户名不合规定";
		}else
		{
			document.getElementById("span1").innerText = "账户名合格"
		}
	}
	//判断密码是否合法
	vpassword1.onblur = function()
	{
		var result = this.value.match(/[0-9a-z]{6,14}/);
		if(result == null)
		{
			document.getElementById("span2").innerText ="密码不合格";
		}else
		{
			document.getElementById("span2").innerText = "密码输入成功";
		}
	}
	// 	//判断重复密码是否合法上次输入的值
	// vpassword2.onblur = function()
	// {
	// 	if(this.value == "" || this.value !=  vpassword1.value)
	// 	{
	// 		document.getElementById("span3").innerText = "密码不一致";
	// 	}else
	// 	{
	// 		document.getElementById("span3").innerText = "密码一致";
	// 	}
	// }
	//判断邮箱是否合法
    vEmail.onblur = function ()
    {
        var result = this.value.match(/[0-9]{5,11}@qq(\.com|\.cn|\.org)/);
        if(result == null)
        {
            document.getElementById("span3").innerText = "邮箱不合法";
        }else
        {
            document.getElementById("span3").innerText = "可以注册";
        }
    }
    
	//判断手机号是否符合规则
	viphone.onblur = function()
	{
		var result = this.value.match(/^\+861[0-9]{10}$/);
		if(result == null)
		{
			document.getElementById("span4").innerText = "手机号不合规定";
		}else
		{
			document.getElementById("span4").innerText = "手机号符合规定";
		}
	}
	// //判断邮编是否符合规则
	// vpostCode.onblur = function()
	// {
	// 	var result = this.value.match(/^[0-9]{6}$/);
	// 	if(result == null)
	// 	{
	// 		document.getElementById("span6").innerText = "邮编不合格";
	// 	}else
	// 	{
	// 		document.getElementById("span6").innerText = "邮编合格";
	// 	}
	// }
	//
	// //判断身份证号是否符合规则
	// vidCode.onblur = function()
	// {
	// 	var result = this.value.match(/^\d{15}|\d{18}$/);
	// 	if(result == null)
	// 	{
	// 		document.getElementById("span7").innerText = "身份证号不合格";
	// 	}else
	// 	{
	// 		document.getElementById("span7").innerText = "身份证号合格";
	// 	}
	// }

}