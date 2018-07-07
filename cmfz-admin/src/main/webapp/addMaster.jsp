<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">		
	$(function(){
		
	});
</script>
		
<form id="masterff" method="post" enctype="multipart/form-data" accept-charset="utf-8">
	<div style="margin-left:100px;margin-top:20px;">
		上师编号<input class="easyui-textbox" data-options="width:200" name="masterId" />
		<br><br>
		上师法名<input class="easyui-textbox" data-options="width:200" name="masterName" />
		<br><br>
		上师年龄<input class="easyui-textbox" data-options="width:200" name="masterAge" />
		<br><br>
		上师图片<input class="easyui-filebox" data-options="buttonText:'选择图片',width:200" name="myFile" />
		<br><br>
		图片名称<input class="easyui-textbox" data-options="width:200" name="masterPhoto" />
		<br><br>
		上师简介<input class="easyui-textbox" data-options="width:200" name="masterSummery" />
	</div>
</form>