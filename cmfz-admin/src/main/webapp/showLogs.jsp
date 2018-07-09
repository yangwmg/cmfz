<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
	$(function(){
		$("#logfm").datagrid({
			url:"${pageContext.request.contextPath}/log/allLog",
			fitColumns:true,
			singleSelect:true,
			striped:true,//斑马线
			pagination:true,//分页工具栏
			pageList:[2,4,6,8,10],
		});
	});
</script>

<table id="logfm" style="width:100%;height:100%">
    <thead>
        <tr>
            <th data-options="field:'logId',width:100,align:'center',sorttable:true">日志编号</th>
            <th data-options="field:'user',width:50,align:'center'">操作用户</th>
            <th data-options="field:'time',width:70,align:'center'">操作时间</th>
			<th data-options="field:'resource',width:70,align:'center'">操作对象</th>
            <th data-options="field:'action',width:50,align:'center'">操作类型</th>
            <th data-options="field:'message',width:200,align:'center'">详细信息</th>
            <th data-options="field:'result',width:100,align:'center'">操作结果</th>
        </tr>
    </thead>
</table>