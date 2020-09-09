<!DOCTYPE html>
<html>
<head>
    <meta charset="utf‐8">
    <title>Hello World!</title>
</head>
<body>
Hello ${name}!
<br/>
<table>
    <tr>
        <td>序号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>钱包</td>
    </tr>
    <#list stus as stu>
        <tr>
            <td>${stu_index + 1}</td>
            <td <#if stu.name == '小明'>style="background:red;"</#if>>${stu.name}</td>
            <td>${stu.age}</td>
            <td>${stu.money}</td>
        </tr>
    </#list>
</table>
<br/>
<br/>
输出stu1的学生信息:<br/>
姓名:${stuMap['stu1'].name}<br/>
年龄:${stuMap['stu1'].age}<br/>
钱包:${stuMap['stu1'].money}<br/>
输出stu2的学生信息:<br/>
姓名:${stuMap['stu2'].name}<br/>
年龄:${stuMap['stu2'].age}<br/>
钱包:${stuMap['stu2'].money}<br/>
</body>
</html>