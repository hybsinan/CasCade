<%@page contentType="text/html; utf-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        $(function () {
            $.ajax({
                url: "${pageContext.request.contextPath}/p/showProvinces",
                type: "get",
                dataType: "json",
                success: function (provinces) {
                    var pro = $("#province");
                    for (var i = 0; i < provinces.length; i++) {
                        var option = $("<option value='" + provinces[i].code + "'>" + provinces[i].name + "</option>");
                        pro.append(option);
                    }
                    $.ajax({
                        url: "${pageContext.request.contextPath}/p/showCity",
                        type: "get",
                        data: "provinceCode=" + 110000,
                        dataType: "json",
                        success: function (cities) {

                            var city = $("#city");
                            city.empty();
                            for (var i = 0; i < cities.length; i++) {
                                var option = $("<option value='" + cities[i].code + "'>" + cities[i].name + "</option>")
                                city.append(option);
                            }
                            $.ajax({
                                url: "${pageContext.request.contextPath}/p/showArea",
                                type: "get",
                                data: "cityCode=" + cities[0].code,
                                dataType: "json",
                                success: function (areas) {
                                    var area = $("#area");
                                    area.empty();
                                    for (var i = 0; i < areas.length; i++) {
                                        var option = $("<option value='" + areas[i].code + "'>" + areas[i].name + "</option>")
                                        area.append(option)
                                    }
                                }
                            })
                        }
                    })
                }
            })

            $("#province").change(function () {
                var provinceCode = $("#province").val();
                $.ajax({
                    url: "${pageContext.request.contextPath}/p/showCity",
                    type: "get",
                    data: "provinceCode=" + provinceCode,
                    dataType: "json",
                    success: function (cities) {

                        var city = $("#city");
                        city.append($(""));
                        city.empty();
                        for (var i = 0; i < cities.length; i++) {
                            var option = $("<option value='" + cities[i].code + "'>" + cities[i].name + "</option>")
                            city.append(option);
                        }
                        $.ajax({
                            url: "${pageContext.request.contextPath}/p/showArea",
                            type: "get",
                            data: "cityCode=" + cities[0].code,
                            dataType: "json",
                            success: function (areas) {
                                var area = $("#area");
                                area.empty();
                                for (var i = 0; i < areas.length; i++) {
                                    var option = $("<option value='" + areas[i].code + "'>" + areas[i].name + "</option>")
                                    area.append(option)
                                }
                            }
                        })
                    }
                })
            })
            $("#city").change(function () {
                var cityCode = $("#city").val();
                $.ajax({
                    url: "${pageContext.request.contextPath}/p/showArea",
                    type: "get",
                    data: "cityCode=" + cityCode,
                    dataType: "json",
                    success: function (areas) {
                        var area = $("#area");
                        area.empty();
                        for (var i = 0; i < areas.length; i++) {
                            var option = $("<option value='" + areas[i].code + "'>" + areas[i].name + "</option>")
                            area.append(option)
                        }
                    }
                })
            })
        })
    </script>
</head>
<body>
<select id="province">
    <%--  <option>省级</option>--%>
</select>
<select id="city">
    <%-- <option>市级</option>--%>
</select>
<select id="area">
    <%-- <option>地区</option>--%>
</select>
</body>
</html>