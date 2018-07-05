<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">		
	$(function(){
		$("#fm").datagrid({
			url:"${pageContext.request.contextPath}/photo/allPhoto",
			fitColumns:true,
			singleSelect:true,
			toolbar:"#tb",
			striped:true,//斑马线
			pagination:true,//分页工具栏
			pageList:[2,4,6,8,10],
		});
		
		$("#add").linkbutton({
			onClick:function(){
				$("#ff").form("clear");
				$("#dialog").dialog({    
				    title:"新增轮播图",
				    width:425,
				    height:249,
				    collapsible:true,
				    minimizable:true,
				    maximizable:true,
				    resizable:true,
					
					buttons:[{
						text:"保存",
						iconCls:"icon-save",
						handler:function(){
							$("#ff").form("submit", {
								url:"",
								onSubmit:function(){
									return true;
								},
								success:function(data){
									$("#dialog").dialog("close");
									$("#ff").form("clear");
									$("#fm").datagrid({
										url:"",
										fitColumns:true,
										singleSelect:true,
										toolbar:"#tb",
										striped:true,//斑马线
										pagination:true,//分页工具栏
										pageList:[2,4,6,8,10],
									});
								},
							});
						},
					},{
						text:"取消",
						iconCls:"icon-search",
						handler:function(){
							$("#dialog").dialog("close");
						},
					}],
					href:"${pageContext.request.contextPath }/form.jsp",
				});
			},
		});
		
		$("#update").linkbutton({
			onClick:function(){
				var rowData = $("#fm").datagrid("getSelected");
				$("#dialog").dialog({    
				    title:"修改用户信息",
				    width:425,
				    height:249,
				    collapsible:true,
				    minimizable:true,
				    maximizable:true,
				    resizable:true,
				    
				    toolbar:[{
						text:"帮助",
						iconCls:"icon-help",
						handler:function(){
							alert("help");
						},
					}],
					
					buttons:[{
						text:"保存",
						iconCls:"icon-save",
						handler:function(){
							$("#ff").form("submit", {
								url:"http://localhost:8088/EasyUI/student/modify",
								onSubmit:function(){
									return true;
								},
								success:function(data){
									$("#dialog").dialog("close");
									$("#ff").form("clear");
									$("#fm").datagrid({
										url:"http://localhost:8088/EasyUI/student/showAll",
										fitColumns:true,
										singleSelect:true,
										toolbar:"#tb",
										striped:true,//斑马线
										pagination:true,//分页工具栏
										pageList:[2,4,6,8,10],
									});
								},
							});
						},
					},{
						text:"取消",
						iconCls:"icon-search",
						handler:function(){
							$("#dialog").dialog("close");
						},
					}],
					href:"${pageContext.request.contextPath }/form.jsp",
					onLoad:function(){
						$("#ff").form("load",rowData);
					},
				});
			},
		});
		
		$("#remove").linkbutton({
			text:"删除用户",
			onClick:function(){
				var rowData = $("#fm").datagrid("getSelected");
				
				$("#dialog").dialog({    
				    title:"删除用户",
				    width:425,
				    height:249,
				    collapsible:true,
				    minimizable:true,
				    maximizable:true,
				    resizable:true,
				    
				    toolbar:[{
						text:"帮助",
						iconCls:"icon-help",
						handler:function(){
							alert("help");
						},
					}],
					
					buttons:[{
						text:"确定",
						iconCls:"icon-ok",
						handler:function(){
							$("#ff").form("submit", {
								url:"http://localhost:8088/EasyUI/student/remove",
								onSubmit:function(){
									return true;
								},
								success:function(data){
									$("#dialog").dialog("close");
									$("#ff").form("clear");
									$("#fm").datagrid({
										url:"http://localhost:8088/EasyUI/student/showAll",
										fitColumns:true,
										singleSelect:true,
										toolbar:"#tb",
										striped:true,//斑马线
										pagination:true,//分页工具栏
										pageList:[2,4,6,8,10],
									});
								},
							});
						},
					},{
						text:"取消",
						iconCls:"icon-search",
						handler:function(){
							$("#dialog").dialog("close");
						},
					}],
					href:"${pageContext.request.contextPath }/form.jsp",
					onLoad:function(){
						$("#ff").form("load",rowData);
					},
				});
			},
		});
	});
</script>

<table id="fm" style="width:100%;height:100%">
    <thead>
        <tr>
            <th data-options="field:'photoId',width:50,align:'center',sorttable:true">标识编号</th>
            <th data-options="field:'photoName',width:100,align:'center'">文件名</th>
            <th data-options="field:'description',width:100,align:'center'">描述信息</th>
			<th data-options="field:'status',width:100,align:'center'">轮播图状态</th>
            <th data-options="field:'uploadTime',width:100,align:'center'">轮播图创建时间</th>
            <th data-options="field:'update',width:100,align:'center'">操作</th>
        </tr>
    </thead>
</table>
<div id="tb" style="display: none">
	<a href="#" class="easyui-linkbutton" id="add"
		data-options="iconCls:'icon-add',plain:true,text:'新增轮播图'"></a>
	<a href="#" class="easyui-linkbutton" id="help"
		data-options="iconCls:'icon-help',plain:true,text:'帮助'"></a>
</div>
<div id="dialog"></div>