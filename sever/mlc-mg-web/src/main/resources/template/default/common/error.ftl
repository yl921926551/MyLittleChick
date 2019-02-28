<html>
<head>
<#include "${res.template.head}">
</head>
<body>
    <div id="selectBankPage" class="page">
	<!--top-->
	<div class="top">
		<!-- InstanceBeginEditable name="nav" -->
		<div class="top_btn gotoPrevPage"> 上一页 </div>
		<!-- InstanceEndEditable -->
		<img src="${base}/skin/cms/images/common/logo.png" />
		<div class="top_img"><img height="45px" src="${base!''}/skin/cms/themes/default/images/common/jingyu.png" /></div>
	</div>
	<!-- InstanceBeginEditable name="body" -->
	<div class="info_title"> 错误提示 </div>
	<div id="bankList_div" class="body">
		<div style="text-align: center;">${exception.message!'未知错误'}</div>
	</div>
</div>
</body>
</html>