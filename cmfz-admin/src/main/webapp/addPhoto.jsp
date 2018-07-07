<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">		
	$(function(){

	});
</script>
		
<form id="photoff" method="post" enctype="multipart/form-data" accept-charset="utf-8">
	<div style="margin-left:100px;margin-top:20px;">
		轮播图描述<input class="easyui-textbox" data-options="width:200" name="description" />
		<br><br>
		轮播图状态
		<select class="easyui-combobox" data-options="width:200" name="status">
			<option value="1">展示中</option>
			<option value="0">不展示</option>
		</select>
		<br><br>
		上传轮播图<input id="p1" class="easyui-filebox" data-options="buttonText:'选择图片',width:200" name="myFile"/>
	</div>
</form>