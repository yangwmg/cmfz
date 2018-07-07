<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">		
	/*$(function(){
		$("#m1").filebox({
			onChange:function(){
			    alert("内容改变");
			    console.log($("#m1").val());
			    $("#m2").value = $("#m1").val();
			},
		});
	});*/
</script>
		
<form id="masterff" method="post" enctype="multipart/form-data" accept-charset="utf-8">
	<div style="margin-left:100px;margin-top:20px;">
		上师编号<input class="easyui-textbox" data-options="width:200" name="masterId" />
		<br><br>
		上师法名<input class="easyui-textbox" data-options="width:200" name="masterName" />
		<br><br>
		上师年龄<input class="easyui-textbox" data-options="width:200" name="masterAge" />
		<br><br>
		上师图片<input id="m1" class="easyui-filebox" data-options="buttonText:'选择图片',width:200" name="myFile" />
		<br><br>
		上师简介<input class="easyui-textbox" data-options="width:200" name="masterSummery" />
	</div>
</form>