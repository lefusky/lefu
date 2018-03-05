<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>所见即所得的Markdown编辑器tui.editor|DEMO1_jQuery之家-自由分享jQuery、html5、css3的插件库</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/htmleaf-demo.css">
	<script src="http://cdn.bootcss.com/jquery/1.11.0/jquery.min.js" type="text/javascript"></script>
	<script>window.jQuery || document.write('<script src="js/jquery-1.11.0.min.js"><\/script>')</script>
	<script src="lib/markdown-it/dist/markdown-it.js"></script>
	<script src="lib/toMark/dist/toMark.js"></script>
	<script src="lib/tui-code-snippet/dist/tui-code-snippet.js"></script>
	<script src="lib/tui-color-picker/dist/tui-color-picker.js"></script>
	<script src="lib/codemirror/lib/codemirror.js"></script>
	<script src="lib/highlightjs/highlight.pack.js"></script>
	<script src="lib/squire-rte/build/squire-raw.js"></script>
	<link rel="stylesheet" href="lib/codemirror/lib/codemirror.css">
	<link rel="stylesheet" href="lib/highlightjs/styles/github.css">
	<link rel="stylesheet" href="./explain.css">
</head>
<body>
	<div class="htmleaf-container">
		<div class="container" style="width:100%;padding:0">
			<div class="code-html">
				<script src="lib/plantuml-encoder/dist/plantuml-encoder.js"></script>
				<script src="lib/raphael/raphael.js"></script>
				<script src="lib/tui-chart/dist/tui-chart.js"></script>
				<script src="dist/tui-editor-Editor-all.js"></script>
				<link rel="stylesheet" href="dist/tui-editor.css">
				<link rel="stylesheet" href="dist/tui-editor-contents.css">
				<link rel="stylesheet" href="lib/tui-color-picker/dist/tui-color-picker.css">
				<link rel="stylesheet" href="lib/tui-chart/dist/tui-chart.css">

				<div id="editSection"></div>
			</div>
		</div>
	</div>
	<script class="code-js">
		var content = ['${edit_content}'
		].join('\n');

		var editor = new tui.Editor({
		  el: document.querySelector('#editSection'),
		  previewStyle: 'vertical',
		  height: '808px',
		  initialEditType: 'markdown',
		  useCommandShortcut: true,
		  initialValue: content,
		  exts: ['scrollSync', 'colorSyntax', 'uml', 'chart', 'mark', 'table', 'taskCounter']
		});
	</script>
</body>
</html>