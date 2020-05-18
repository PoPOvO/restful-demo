<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>freemarker使用</title>
</head>
<body>
    hello world!
    <#--自定义标签测试-->
    <@repeat count=3; cnt>
        ${cnt}. Test
    </@repeat>
    <#-- 引入文件 -->
    <#--<#include "index.html">-->
</body>
</html>