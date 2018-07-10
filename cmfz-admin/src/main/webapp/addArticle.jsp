<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false"
         pageEncoding="utf-8"%>
    <script type="text/javascript">
        $(function(){
            $("#create").linkbutton({
                onClick:function(){
                    /*alert("xxx");*/
                    $("#articleff").form("submit", {
                        url:"${pageContext.request.contextPath}/article/add",
                        onSubmit:function(param){
                            var p1 = (editor).txt.html();
                            param.content = p1;
                            return true;
                        },
                        success:function(data){
                            $("#articleff").form("clear");
                            (editor).txt.clear();
                            $.messager.show({
                                title:"我的消息",
                                msg:"文章创建成功",
                                timeout:2000,
                                showType:"slide",
                            });
                            $("#logfm").datagrid("reload");
                        },
                    });
                },
            });

            $("#reset").linkbutton({
                onClick:function(){
                    (editor).txt.clear();
                    $("#articleff").form("clear");
                },
            });
        });
    </script>
<form id="articleff" method="post" enctype="multipart/form-data" accept-charset="utf-8">

    文章标题:<input class="easyui-textbox" data-options="width:200,prompt:'请您输入文章的标题'" name="articleName" />
    <br><br>
    文章作者:
    <input id="articlebox" class="easyui-combobox" name="author"
           data-options="valueField:'masterName',textField:'masterName',url:'${pageContext.request.contextPath}/master/allMaster2'"/>
    <br><br>
    文章状态:<input id="text" class="easyui-switchbutton" data-options="width:60,onText:'上架',offText:'下架'" name="" />
    <br><br>
    文章内容:
    <div id="editor">
    </div>
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/wangEditor.min.js"></script>
    <script type="text/javascript">
        var E = window.wangEditor
        var editor = new E('#editor')
        editor.customConfig.uploadImgServer = '${pageContext.request.contextPath}/article/upload'
        editor.customConfig.uploadFileName = 'files'
        editor.create()
    </script>

    <a id="create" href="#" class="easyui-linkbutton" data-options="text:'创建文章'"></a>
    <a id="reset" href="#" class="easyui-linkbutton" data-options="text:'重置内容'"></a>
</form>
