<html>
<#include "../common/header.ftl">

<body>
<div id="wrapper" class="toggled">

<#--边栏sidebar-->
<#include "../common/nav.ftl">

<#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/sell/seller/product/save">
                        <div class="form-group">
                            <label>名称</label>
                            <input name="name" type="text" class="form-control" value="${(productInfo.name)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>旧价格</label>
                            <input name="oldPrice" type="text" class="form-control" value="${(productInfo.oldPrice)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>价格</label>
                            <input name="price" type="text" class="form-control" value="${(productInfo.price)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>库存</label>
                            <input name="stock" type="number" class="form-control" value="${(productInfo.stock)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>描述</label>
                            <input name="description" type="text" class="form-control" value="${(productInfo.description)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>图标</label>
                            <input name="icon" type="text" class="form-control" value="${(productInfo.icon)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>图片</label>
                            <input name="image" type="text" class="form-control" value="${(productInfo.image)!''}"/>
                        </div>
                        <#--<div class="form-group">-->
                            <#--<label>图片</label>-->
                            <#--<input id="productIcon" name="productIcon" type="text" hidden="hidden" value="${(productInfo.icon)!''}"/>-->

                            <#--<div class="file-loading">-->
                                <#--<input id="input-id" type="file">-->
                                <#--<p class="help-block">支持jpg、jpeg、png、gif格式，大小不超过1M</p>-->
                            <#--</div>-->
                        <#--</div>-->
                        <div class="form-group">
                            <label>类目</label>
                            <select name="categoryId" class="form-control">
                                <#list categoryList as category>
                                    <option value="${category.id}"
                                            <#if (productInfo.categoryId)?? && productInfo.categoryId == category.id>
                                                selected
                                            </#if>
                                        >${category.name}
                                    </option>
                                </#list>
                            </select>
                        </div>
                        <input hidden type="text" name="id" value="${(productInfo.id)!''}">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-fileinput/4.4.8/js/fileinput.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-fileinput/4.4.8/js/locales/zh.min.js"></script>
<script>

    <#--$(function () {-->
        <#--var initialPreview = [];-->
        <#--if ('${(productInfo.icon)!""}' != '') {-->
            <#--initialPreview = "<img class='kv-preview-data file-preview-image' src='${(productInfo.icon)!""}'>"-->
        <#--}-->

        <#--$("#input-id").fileinput({-->
            <#--uploadUrl: '/sell/image/upload',-->
            <#--language: 'zh',-->
            <#--browseClass: "btn btn-primary btn-block",-->
            <#--showCaption: false,-->
            <#--showRemove: false,-->
            <#--showUpload: false,-->
            <#--allowedFileExtensions: [ 'jpg', 'jpeg', 'png', 'gif' ],-->
            <#--maxFileSize: 1024,-->
            <#--autoReplace: true,-->
            <#--overwriteInitial: true,-->
            <#--maxFileCount: 1,-->
            <#--initialPreview: initialPreview,-->
        <#--});-->
    <#--});-->
    <#--//上传完成设置表单内容-->
    <#--$('#input-id').on('fileuploaded', function(event, data, previewId, index) {-->
        <#--if (data.response.code != 0) {-->
            <#--alert(data.response.msg)-->
            <#--return-->
        <#--}-->
        <#--$('#productIcon').val(data.response.data.fileName)-->
    <#--});-->
</script>
</body>
</html>