var xmlHttp;

window.onload = function(){
	decorateHeaders();
	loadLayout();
	insertLayoutButtons();
}

window.onunload = function(){
	saveLayout();
}

function decorateHeaders(){
	decorateHeader("query", "Query");
	decorateHeader("trythis", "Try This");
	decorateHeader("signupform", "Change Password");
	decorateHeader("myfavorite", "My Favorite");
	decorateHeader("searchfavorite", "Search Favorite");
	decorateHeader("mygroup", "My Group");
	decorateHeader("searchgroup", "Search Group");
	decorateHeader("pdf-area", "PDF View & Discussion");
	decorateHeader("result-list", "Results");
	decorateHeader("settingform", "Setting");
	decorateHeader("loginform", "Please log in to continue");
	decorateHeader("donothaveaccout", "Do not have account?");
}
	
function insertLayoutButtons(){
	var id = getWikiId();
	if(id == ""){
		return;
	}
	//alert("insertLayoutButtons()");
	var topbar = document.getElementById("topbar");	
		
	var saveButton = document.createElement("input");
	saveButton.type = "button";
	saveButton.onclick = saveLayout;
	saveButton.value = "Save Layout";	
	topbar.insertBefore(saveButton, topbar.firstChild);
	
	var loadButton = document.createElement("input");
	loadButton.type = "button";
	loadButton.onclick = loadLayout;
	loadButton.value = "Load Layout";	
	topbar.insertBefore(loadButton, topbar.firstChild);
}

function decorateHeader(id, headerString){
	var e = document.getElementById(id);
	if(e == null){
		return;
	}
	
	var items = document.createElement("div");
	items.setAttribute("class", "items");
	var header = document.createElement("div");
	header.setAttribute("class", "header");
	var content = document.createElement("div");
	content.setAttribute("class", "content");
	
	moveContent(e, content);
	header.innerHTML = headerString;
	
	items.appendChild(header);
	items.appendChild(content);
	
	e.appendChild(items);
	
	//alert(e.innerHTML);
}

function moveContent(src, dst){
	dst.innerHTML = src.innerHTML;
	src.innerHTML = "";
}

String.prototype.trim = function () {
	return this.replace(/(^\s+)|(\s+$)/g, "");   
}

function getWikiId(){
	return document.getElementById("wiki-id").innerHTML.trim();
}

function loadLayout(){
	var id = getWikiId();
	if(id == ""){
		return;
	}
	//alert("loadLayout()");
	getUserInfo(id);
	//alert("end loadLayout()");
}

function saveLayout(){
	var id = getWikiId();
	if(id == ""){
		return;
	}
	//alert("saveLayout():" + id);
	saveUserInfo(id);
}

/**
 * 读取用户布局信息
 */
function getUserInfo(uid) {
  //alert("getUserInfo()")
  var show = document.getElementById("show");
  if(show != null){
	  show.style.opacity=0;
  }
  xmlHttp=GetXmlHttpObject();
  if (xmlHttp==null)
  {
    alert ("您的浏览器不支持AJAX！");
    return;
  } 
  var url="data.jsp";
  url=url+"?uid="+uid;
  xmlHttp.onreadystatechange=stateChanged;
  xmlHttp.open("GET",url,true);
  xmlHttp.send(null);
  //alert("end getUserInfo()")
}
function stateChanged()
{ 
  //alert("stateChanged(): "+xmlHttp.readyState);
  if (xmlHttp.readyState==4)
  { 
	//alert("before re-arrange divs: "+xmlHttp.readyState + " " + xmlHttp.responseText.trim())
	var container = document.getElementById("edit-wiki-form");
	if(container == null){
		  container = document.getElementById("wiki-content");
	}
	if(container == null){
		  return;
	}
	var info=xmlHttp.responseText;
	var list = new Array();
	list=info.split(";");
	//for (var i=1;i<list.length-1;i++)
	for (var i=list.length-1; i>=0; --i)
	{ 
		//alert("list[i]="+list[i]);
		obj = document.getElementById(list[i].trim());
		if(obj != null){
			//container.appendChild(obj);
			//alert(obj.id);
			insertFront(container, obj);
		}
	}
  } 
}

function insertFront(c, o){
	if(o != c.firstChild){
		c.insertBefore(o, c.firstChild);
	}
}

/**
 * 保存用户布局信息
 */
function saveUserInfo(uid){
  var container = document.getElementById("edit-wiki-form");
  if(container == null){
	  container = document.getElementById("wiki-content");
  }
  if(container == null){
	  return;
  }
  var d = container.children;
  var info="";
  for (var i=0;i<d.length;i++)
  { 
    info += d[i].id+";";
  }
  //alert("saveUserInfo(): "+uid+" "+info);
  xmlHttp=GetXmlHttpObject();
  if (xmlHttp==null)
  {
    alert ("您的浏览器不支持AJAX！");
    return;
  } 
  var url="savedata.jsp";
  var postdate="uid="+uid+"&info="+info;
  xmlHttp.onreadystatechange=function(){
    if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
  	  var div=document.getElementById('show');
  	  if(div != null){
  		  div.style.opacity=1;
  		  hidden(document.getElementById("show"),1,-0.005);
  	  }
    }
  };
  xmlHttp.open("POST",url,true);
  xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
  xmlHttp.send(postdate);
}

/**
 * 提醒层渐隐效果
 */
function hidden(o,i,s){
  t=setInterval(function(){   
  i+=s;
  o.style.opacity=i;
  if(i<0)window.clearInterval(t); 
  },1);   
};

/**
 * 创建Request对象
 */
function GetXmlHttpObject()
{
  var xmlHttp=null;
  try {
    xmlHttp=new XMLHttpRequest();  // Firefox, Opera 8.0+, Safari
  } 
  catch(e)
  {
    try {
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");  // Internet Explorer
    } 
    catch (e) 
    {
      xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
  }
  return xmlHttp;
}