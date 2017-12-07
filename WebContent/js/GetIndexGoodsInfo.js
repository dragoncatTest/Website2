window.onload = function ()
{
	getIndexGoodsInfo() ;
}

function getIndexGoodsInfo ()
{
	var info = new XMLHttpRequest() ;
	info.onreadystatechange = function()
	{
		if(info.readyState == 4&&info.status == 200)
		{
			var infoObj = eval(info.responseText) ;
			for(var i = 0 ; i < infoObj.length ; i ++)
			{
				var goodinfo = GoodsInfo.createNew(infoObj[i]) ;
				var tdNode = addShopElement() ;
				tdNode[0].innerText = goodinfo.name ;
				tdNode[1].innerText = goodinfo.price ;
				tdNode[2].innerText = goodinfo.description ;
				tdNode[3].firstChild.setAttribute("src",goodinfo.picture) ;
			}
		}
	}
	info.open("POST","GetIndexGoodsInfo",true) ;
	info.send(null) ;
}

var GoodsInfo = 
{
	createNew: function(infoObj)
	{
		var info = {} ;
		info.name = infoObj.name ;
		info.goodid = infoObj.goodid ;
		info.description = infoObj.description ;
		info.price = infoObj.price ;
		info.picture = infoObj.picture ;
		return info ;
	}
}

var textNodeArray = new Array(5) ;
textNodeArray[0] = "名称" ;
textNodeArray[1] = "价格" ;
textNodeArray[2] = "描述" ;
textNodeArray[3] = "图片" ;
textNodeArray[4] = "购买" ;

function addShopElement()
{
	var tdNodeArray = new Array(5) ;
	
	var formEle = document.createElement("form") ;
	formEle.setAttribute("method","post") ;
	formEle.setAttribute("action","ShopCart") ;
	
	var tableEle = document.createElement("table") ;
	tableEle.setAttribute("align","center") ;
	tableEle.setAttribute("border","1") ;
	
	formEle.appendChild(tableEle) ;
	
	for(var i = 0 ; i < 5 ; i ++)
	{
		var trEle = document.createElement("tr") ;
		tableEle.appendChild(trEle) ;
		
		var thEle = document.createElement("th") ;
		thEle.appendChild(document.createTextNode(textNodeArray[i])) ;
		
		trEle.appendChild(thEle) ;
		
		var tdEle = document.createElement("td") ;
		if(i == 3)
		{
			var imgEle = document.createElement("img") ;
			imgEle.setAttribute("src","") ;
			tdEle.appendChild(imgEle) ;
		}
		if(i == 4)
		{
			var inputEle1 = document.createElement("input") ;
			var inputEle2 = document.createElement("input") ;
			inputEle1.setAttribute("type","number") ;
			inputEle2.setAttribute("type","submit") ;
			tdEle.appendChild(inputEle1) ;
			tdEle.appendChild(inputEle2) ;
		}
		
		tdNodeArray[i] = tdEle ;
		
		trEle.appendChild(tdEle) ;
		
		tableEle.appendChild(trEle) ;
	}
	var discount = document.getElementById("todayDiscount") ;
	discount.appendChild(formEle) ;
	
	return tdNodeArray ;
}
