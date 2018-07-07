<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
	$(function(){
		$("#masterfm").datagrid({
			url:"http://localhost:8080/cmfz-admin/master/allMaster",
			fitColumns:true,
			singleSelect:true,
			toolbar:"#mastertb",
			striped:true,//斑马线
			pagination:true,//分页工具栏
			pageList:[2,4,6,8,10],
		});
		
		$("#masteradd").linkbutton({
			onClick:function(){
				$("#masterff").form("clear");
				$("#masterdialog").dialog({
				    title:"新增上师",
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
							$("#masterff").form("submit", {
								url:"http://localhost:8080/cmfz-admin/master/add",
								onSubmit:function(){
									return true;
								},
								success:function(data){
									$("#masterdialog").dialog("close");
									$("#masterff").form("clear");
									$("#masterfm").datagrid({
										url:"http://localhost:8080/cmfz-admin/master/allMaster",
										fitColumns:true,
										singleSelect:true,
										toolbar:"#mastertb",
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
							$("#masterdialog").dialog("close");
						},
					}],
					href:"${pageContext.request.contextPath }/addMaster.jsp",
				});
			},
		});
		
		$("#masterupdate").linkbutton({
			onClick:function(){
				var rowData = $("#masterfm").datagrid("getSelected");
                console.log(rowData);
				$("#masterdialog").dialog({
				    title:"修改上师信息",
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
							$("#masterff").form("submit", {
								url:"http://localhost:8080/cmfz-admin/master/update",
								onSubmit:function(param){
								    param.photoId = rowData.photoId;
									return true;
								},
								success:function(data){
									$("#masterdialog").dialog("close");
									$("#masterff").form("clear");
									$("#masterfm").datagrid({
										url:"http://localhost:8080/cmfz-admin/master/allMaster",
										fitColumns:true,
										singleSelect:true,
										toolbar:"#mastertb",
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
							$("#masterdialog").dialog("close");
						},
					}],
					href:"${pageContext.request.contextPath }/addMaster.jsp",
					onLoad:function(){
						$("#masterff").form("load",rowData);
					},
				});
			},
		});
		
		$("#masterremove").linkbutton({
			text:"删除",
			onClick:function(){
				var rowData = $("#masterfm").datagrid("getSelected");
				console.log(rowData);
				$("#masterdialog").dialog({
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
							$("#masterff").form("submit", {
								url:"http://localhost:8080/cmfz-admin/master/remove",
								onSubmit:function(){
									return true;
								},
								success:function(data){
									$("#masterdialog").dialog("close");
									$("#masterff").form("clear");
									$("#masterfm").datagrid({
										url:"http://localhost:8080/cmfz-admin/master/allMaster",
										fitColumns:true,
										singleSelect:true,
										toolbar:"#mastertb",
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
							$("#masterdialog").dialog("close");
						},
					}],
					href:"${pageContext.request.contextPath }/removeMaster.jsp",
					onLoad:function(){
						$("#masterff").form("load",rowData);
					},
				});
			},
		});
	});

    function qq(value) {
        console.log("模糊查询");
        $("#masterfm").datagrid({
            url:"http://localhost:8080/cmfz-admin/master/showMasterByName?value="+value,
            fitColumns:true,
            singleSelect:true,
            toolbar:"#mastertb",
            striped:true,//斑马线
            pagination:true,//分页工具栏
            pageList:[2,4,6,8,10],
        });
    };
</script>

<table id="masterfm" style="width:100%;height:100%">
    <thead>
        <tr>
            <th data-options="field:'masterId',width:100,align:'center',sorttable:true">上师编号</th>
            <th data-options="field:'masterName',width:100,align:'center'">上师法名</th>
            <th data-options="field:'masterAge',width:100,align:'center'">年龄</th>
			<th data-options="field:'masterPhoto',width:100,align:'center'">上师图片</th>
            <th data-options="field:'masterSummery',width:100,align:'center'">上师简介</th>
        </tr>
    </thead>
</table>
<div id="mastertb" style="display: none">
	<a href="#" class="easyui-linkbutton" id="masteradd"
		data-options="iconCls:'icon-add',plain:true,text:'新增上师'"></a>
    <a href="#" class="easyui-linkbutton" id="masterupdate"
       data-options="iconCls:'icon-edit',plain:true,text:'修改上师信息'"></a>
    <a href="#" class="easyui-linkbutton" id="masterremove"
       data-options="iconCls:'icon-cancel',plain:true,text:'删除'"></a>
    <a href="#" class="easyui-linkbutton" id="masteraddmore"
       data-options="iconCls:'icon-add',plain:true,text:'批量插入'"></a>
    <input id="masterss" class="easyui-searchbox" style="width:300px"
           data-options="searcher:qq,prompt:'请您输入需要模糊查询的内容',menu:'#mastermm'"></input>
    <div id="mastermm" style="width:120px">
        <div data-options="name:'masterName',iconCls:'icon-man'">上师法名</div>
    </div>
</div>
<div id="masterdialog"></div>