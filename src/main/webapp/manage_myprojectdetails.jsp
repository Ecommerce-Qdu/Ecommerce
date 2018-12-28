<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE HTML>
<html>

<head>

    <style type="text/css">
        table {
            /*widtd: 100%;*/
            text-align: center;
            margin-top: 1%
        }

        table tr {
            font-size: 18px;
            font-family: "微软雅黑";
            height: 40px;
        }

        table tr:nth-child(2n) {
            background-color: white;
        }

        table tr:nth-child(2n-1) {
            background-color: #E7E7E7;
        }
    </style>

</head>

<body>
<div>

    <table align="left" style="width: 30%;border: 1px solid #151515">
        <tr>
            <td>项目编号</td>
            <td>${ProjectDetails.pid}</td>
        </tr>
        <tr>
            <td>项目名</td>
            <td>${ProjectDetails.pname}</td>
        </tr>
        <tr>
            <td>项目描述</td>
            <td>${ProjectDetails.pdesc}</td>
        </tr>
        <tr>
            <td>项目开始时间</td>
            <td>${ProjectDetails.psd}</td>
        </tr>
        <tr>
            <td>项目结束时间</td>
            <td>${ProjectDetails.ped}</td>
        </tr>
        <tr>
            <td>目标金额</td>
            <td>${ProjectDetails.ptarget}</td>
        </tr>
        <tr>
            <td>当前金额</td>
            <td>${ProjectDetails.pnm}</td>
        </tr>
        <tr>
            <td>当前人数</td>
            <td>${ProjectDetails.pnp}</td>
        </tr>
        <tr>
            <td>投资前景</td>
            <td>${ProjectDetails.pmilestone}</td>
        </tr>
        <tr>
            <td>项目类型</td>
            <td>${ProjectDetails.projectTypeByPCategoryId.projecttypename}</td>
        </tr>
        <tr>
            <td>币种</td>
            <td>${ProjectDetails.pmf}</td>
        </tr>
        <tr>
            <td>限制最大金额</td>
            <td>
                <c:if test="${ProjectDetails.plimit==0}">
                    否
                </c:if>
                <c:if test="${ProjectDetails.plimit==1}">
                    是
                </c:if>
            </td>
        </tr>
        <tr>
            <td>项目状态</td>
            <td>
                <c:if test="${ProjectDetails.pstate == 0}">未开始</c:if>
                <c:if test="${ProjectDetails.pstate == 1}">进行中</c:if>
                <c:if test="${ProjectDetails.pstate == 2}">已完成</c:if>
                <c:if test="${ProjectDetails.pstate == 3}">未成功</c:if>
            </td>
        </tr>
        <tr>
            <td>项目团队介绍</td>
            <td>${ProjectDetails.pteam}</td>
        </tr>
        <tr>
            <td>开发计划</td>
            <td>${ProjectDetails.pplan}</td>
        </tr>
        <tr>
            <td>备注</td>
            <td>${ProjectDetails.premark}</td>
        </tr>

    </table>

    <table style="width: 70%;border: 1px solid #151515">
        <caption>投资者订单</caption>
        <tr>
            <th>用户名</th>
            <th>手机号</th>
            <th>支持金额</th>
            <th>支持时间</th>
            <th>需要回报</th>
            <th>回报类型</th>
            <th>地址</th>
            <th>备注</th>
        </tr>

        <c:forEach items="${ProjectDetailsOrders}" var="pro">
            <tr>
                <td>${pro.usersByUPhone.uname}</td>
                <td>${pro.usersByUPhone.uphone} </td>
                <td>${pro.money}</td>
                <td>${pro.orderdate}</td>
                <td>
                    <c:if test="${pro.expect==0}">
                        不需要回报
                    </c:if>
                    <c:if test="${pro.expect==1}">
                        需要回报
                    </c:if>
                </td>
                <td>
                    <c:if test="${pro.expecttype==-1}">
                    </c:if>
                    <c:if test="${pro.expecttype==1}">
                        投资产品享受折扣
                    </c:if>
                    <c:if test="${pro.expecttype==2}">
                        购买产品享有更高折扣或附加服务
                    </c:if>
                    <c:if test="${pro.expecttype==3}">
                        免费获得投资产品
                    </c:if>
                    <c:if test="${pro.expecttype==4}">
                        其他
                    </c:if>
                </td>
                <td>
                    <c:if test="${pro.expect==1}">
                        ${pro.usersAddressByAId.address}
                    </c:if>
                </td>
                <td>
                    <c:if test="${pro.expectType==4}">
                        ${pro.usersAddressByAId.exceptother}
                    </c:if>
                </td>
            </tr>
        </c:forEach>

    </table>

</div>
</body>

</html>