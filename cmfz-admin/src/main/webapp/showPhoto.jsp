<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
	$(function(){
		$("#photofm").datagrid({
			url:"${pageContext.request.contextPath}/photo/allPhoto",
			fitColumns:true,
			singleSelect:true,
			toolbar:"#phototb",
			striped:true,//斑马线
			pagination:true,//分页工具栏
			pageList:[2,4,6,8,10],
		});
		
		$("#photoadd").linkbutton({
			onClick:function(){
				$("#photoff").form("clear");
				$("#photodialog").dialog({
				    title:"新增轮播图",
				    width:425,
				    height:249,
				    collapsible:true,
				    minimizable:true,
				    maximizable:true,
				    resizable:true,
					
					buttons:[{
						text:"保存",
						iconCls:"icon-ok",
						handler:function(){
							$("#photoff").form("submit", {
								url:"${pageContext.request.contextPath}/photo/add",
								onSubmit:function(){
									return true;
								},
								success:function(data){
									$("#photodialog").dialog("close");
									$("#photoff").form("clear");
									$("#photofm").datagrid({
										url:"${pageContext.request.contextPath}/photo/allPhoto",
										fitColumns:true,
										singleSelect:true,
										toolbar:"#phototb",
										striped:true,//斑马线
										pagination:true,//分页工具栏
										pageList:[2,4,6,8,10],
									});
								},
							});
						},
					},{
						text:"取消",
						iconCls:"icon-error",
						handler:function(){
							$("#photodialog").dialog("close");
						},
					}],
					href:"${pageContext.request.contextPath }/addPhoto.jsp",
				});
			},
		});
		
		$("#photoupdate").linkbutton({
			onClick:function(){
				var rowData = $("#photofm").datagrid("getSelected");
                console.log(rowData);
				$("#photodialog").dialog({
				    title:"修改",
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
							$("#photoff").form("submit", {
								url:"http://localhost:8080/cmfz-admin/photo/update",
								onSubmit:function(param){
								    param.photoId = rowData.photoId;
									return true;
								},
								success:function(data){
									$("#photodialog").dialog("close");
									$("#photoff").form("clear");
									$("#photofm").datagrid({
										url:"http://localhost:8080/cmfz-admin/photo/allPhoto",
										fitColumns:true,
										singleSelect:true,
										toolbar:"#phototb",
										striped:true,//斑马线
										pagination:true,//分页工具栏
										pageList:[2,4,6,8,10],
									});
								},
							});
						},
					},{
						text:"取消",
						iconCls:"icon-error",
						handler:function(){
							$("#photodialog").dialog("close");
						},
					}],
					href:"${pageContext.request.contextPath }/addPhoto.jsp",
					onLoad:function(){
						$("#photoff").form("load",rowData);
					},
				});
			},
		});
		
		$("#photoremove").linkbutton({
			text:"删除",
			onClick:function(){
				var rowData = $("#photofm").datagrid("getSelected");
				console.log(rowData);
				$("#photodialog").dialog({
				    title:"删除",
				    width:425,
				    height:249,
				    collapsible:true,
				    minimizable:true,
				    maximizable:true,
				    resizable:true,

					buttons:[{
						text:"确定",
						iconCls:"icon-ok",
						handler:function(){
							$("#photoff").form("submit", {
								url:"http://localhost:8080/cmfz-admin/photo/remove",
								onSubmit:function(){
									return true;
								},
								success:function(data){
									$("#photodialog").dialog("close");
									$("#photoff").form("clear");
									$("#photofm").datagrid({
										url:"http://localhost:8080/cmfz-admin/photo/allPhoto",
										fitColumns:true,
										singleSelect:true,
										toolbar:"#phototb",
										striped:true,//斑马线
										pagination:true,//分页工具栏
										pageList:[2,4,6,8,10],
									});
								},
							});
						},
					},{
						text:"取消",
						iconCls:"icon-error",
						handler:function(){
							$("#photodialog").dialog("close");
						},
					}],
					href:"${pageContext.request.contextPath }/removePhoto.jsp",
					onLoad:function(){
						$("#photoff").form("load",rowData);
					},
				});
			},
		});
	});
</script>

<table id="photofm" style="width:100%;height:100%">
    <thead>
        <tr>
            <th data-options="field:'photoId',width:150,align:'center',sorttable:true">标识编号</th>
            <th data-options="field:'photoName',width:100,align:'center'">文件名</th>
            <th data-options="field:'description',width:100,align:'center'">描述信息</th>
			<th data-options="field:'status',width:100,align:'center'">轮播图状态</th>
            <th data-options="field:'uploadTime',width:100,align:'center'">轮播图创建时间</th>
        </tr>
    </thead>
</table>
<div id="phototb" style="display: none">
	<a href="#" class="easyui-linkbutton" id="photoadd"
		data-options="iconCls:'icon-add',plain:true,text:'新增轮播图'"></a>
    <a href="#" class="easyui-linkbutton" id="photoupdate"
       data-options="iconCls:'icon-edit',plain:true,text:'修改'"></a>
    <a href="#" class="easyui-linkbutton" id="photoremove"
       data-options="iconCls:'icon-cancel',plain:true,text:'删除'"></a>
	<a href="#" class="easyui-linkbutton" id="photohelp"
		data-options="iconCls:'icon-help',plain:true,text:'帮助'"></a>
</div>
<div id="photodialog"></div>