<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: levon
  Date: 12/11/16
  Time: 10:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><tiles:getAsString name="title"/></title>
    <tiles:insertAttribute name="import"/>
    <script>
        $(document).ready(function () {
            $("#source").change(function () {
                var category = $(this).val();
                $.ajax({
                    url:"searchForm",data:{category:category},
                    success:function (data) {
                        $("#status").html(data);
                    }

                });
            });
        });
//        $(function () {
//            $( "#datepicker").datepicker();
//        })

        $(document).ready(function () {
            $("#parentCategory").change(function () {
                var id=$("#parentCategory").val();
                $(".categ").css("display","none");
                $("#"+id).css("display","block");

            })
        })

    </script>

</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <tiles:insertAttribute name="header"/>
    </div>
</nav>
<div class="container">
    <div class="row">
        <tiles:insertAttribute name="content"/>
    </div>
</div>

<div id="footer">
    <tiles:insertAttribute name="footer"/>
</div>


</body>
</html>
