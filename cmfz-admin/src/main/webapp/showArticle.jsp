<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
	$(function(){
		$("#articlefm").datagrid({
			url:"${pageContext.request.contextPath}/article/allArticle",
			fitColumns:true,
			singleSelect:true,
			striped:true,//斑马线
			pagination:true,//分页工具栏
			pageList:[2,4,6,8,10],

            onDblClickRow:function(index, row){
                $("#articledialog").dialog({
                    title:'文章详情',
                    maximizable:true,
                    width:250,
                    height:550,
                    resizable:true,
                    href:"${pageContext.request.contextPath}/article/query?articleId="+row.articleId,
                });
            },
		});
	});
</script>

<table id="articlefm" style="width:100%;height:100%">
    <thead>
        <tr>
            <th data-options="field:'articleId',width:100,align:'center',sorttable:true">文章编号</th>
            <th data-options="field:'articleName',width:100,align:'center'">文章标题</th>
            <th data-options="field:'author',width:100,align:'center'">作者</th>
			<th data-options="field:'releaseTime',width:100,align:'center'">上传时间</th>
        </tr>
    </thead>
</table>
<div id="articledialog"></div>