$(document).ready(function(){
	var commoditys = $(".commodity");
	var lis = $("#menu ul li");
	commoditys.css("display","none");
	$(commoditys[0]).css("display","block");
	for(var i=0;i<lis.length;i++)
	{
		lis[i].id=i;
		$(lis[i]).click(function(){
			console.log("aaa");
			commoditys.css("display","none");
			$(commoditys[this.id]).css("display","block");
		})
	}
})
