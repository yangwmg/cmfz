<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false"
	pageEncoding="utf-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/IconExtension.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/datagrid-detailview.js"></script>
<script type="text/javascript">

	$(function(){
	    $.ajax({
			url:"${pageContext.request.contextPath}/menu/allMenuOne",
			dataType:"json",
			success:function(res){
			    $.each(res, function(index, obj){
					//console.log(obj);
			        var content = "";
			        $.each(obj.mes, function(index1, obj1){
                        //console.log(obj.mes);
                        content += "<p style=\"text-align:center;\"><a class=\"easyui-linkbutton\" data-options=\"iconCls:'"+obj1.menuIcon+"', plain:true\" onclick=\"addTab('"+obj1.menuName+"', '"+obj1.menuURL+"')\">"+ obj1.menuName +"</a></p>";
                    });

			        $("#aa").accordion("add", {
			            title:obj.menuName,
						iconCls:obj.menuIcon,
						content:content,
					});
				});
			},
		});
	});
    function addTab(res, path){
        //console.log(res);
        console.log(path);
        //console.log(res.text);
        var b = $("#tt").tabs("exists", res);

        if(!b){
            $("#tt").tabs("add", {
                title:res,
                href:"${pageContext.request.contextPath }/" + path,//动态加载页面
                closable:true,
            });
        }else{
            $("#tt").tabs("select",res);
        }
    };
</script>

</head>
<body class="easyui-layout">
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
		<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:<shiro:principal></shiro:principal> &nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/man/loginOut" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>   
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 gaozhy@zparkhr.com.cn</div>
    </div>   
       
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="aa" class="easyui-accordion" data-options="fit:true">

		</div>  
    </div>   
    <div data-options="region:'center'">
    	<div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">   
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(${pageContext.request.contextPath}/main/image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>  
    </div>   
</body> 
</html>