<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
<meta http-equiv="X-UA-Compatible" content="IE=9" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>出错啦</title>
</head>
<body style="background:white;padding:0px;margin:0px;">
	<img src="${base}/static/common/images/undefined.jpg" width="100%" height="100%">
	<div>
		<a href="javascript:history.back();" style="top: 10px;position: fixed;left: 10px;color:black">&lt;返回</a>
	</div>
	<div style="position: absolute;top: 35px;left: 0px;text-align: center;width: 100%;">
		<div style="font-size: 14px;"> 错误提示 </div>
		<div>
			<div style="text-align: center;margin-top: 10px;">${exception.message!'未知错误'}</div>
		</div>
	</div>
</body>
</html>