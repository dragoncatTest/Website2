
//window.onbeforeunload = function()
//{
//	if(event.clientX>document.body.clientWidth && event.clientY<0 || event.altKey)
//	{
//		alert("close") ;
//	}
//	else
//	{
//		alert("refresh") ;
//	}
//}
//
//
//window.onbeforeunload=function ()
//{ 
//	var n = window.event.screenX - window.screenLeft;
//	//鼠标在当前窗口内时，n<m，b为false；鼠标在当前窗口外时，n>m，b为true。20这个值是指关闭按钮的宽度
//	var b = n > document.documentElement.scrollWidth-20;
//	//鼠标在客户区内时，window.event.clientY>0；鼠标在客户区外时，window.event.clientY<0
//	if(b && window.event.clientY < 0 || window.event.altKey || window.event.ctrlKey)
//	{
//		alert("close") ;
//	}else
//	if(event.clientY > document.body.clientHeight || event.altKey)
//	{
//		alert("refresh") ;
//	}
//} 