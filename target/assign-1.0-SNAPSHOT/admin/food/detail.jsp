<%@ page import="com.sem4.wcd.assign.entity.Food" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/22/2021
  Time: 6:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%
    Food resultFood = (Food) request.getAttribute("resultFood");
%>
<html>
<head>
    <title>Detail</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap CRUD Data Table for Database with Modal Form</title>
    <%--	<link rel="stylesheet" href="/css/style.css">--%>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <%--	<script src="/js/script.js"></script>--%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://upload-widget.cloudinary.com/global/all.js" type="text/javascript"></script>
    <script src="/js/toast.js"></script>
</head>
<body>
<div class="container">
    <div class="table-wrapper">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Detail: ${resultFood.foodName}</h4>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label>Code of food: </label>
                    <span class="form-control">${resultFood.foodCode}</span>
                </div>
                <div class="form-group">
                    <label>Name of food: </label>
                    <span class="form-control">${resultFood.foodName}</span>
                </div>
                <div class="form-group">
                    <label>Description</label>
                    <textarea readonly name="description" rows="4"
                              class="form-control">${resultFood.description}</textarea>
                </div>
                <div class="form-group">
                    <label>Code of category</label>
                    <c:if test="${resultFood.categoryCode == 1}">
                        <span class="form-control">Grill</span>
                    </c:if>
                    <c:if test="${resultFood.categoryCode == 2}">
                        <span class="form-control">Boiled food</span>
                    </c:if>
                    <c:if test="${resultFood.categoryCode == 3}">
                        <span class="form-control">Vegetarian dish</span>
                    </c:if>
                    <c:if test="${resultFood.categoryCode == 4}">
                        <span class="form-control">Drinks</span>
                    </c:if>
                </div>
                <div class="form-group">
                    <label>Photo</label>
                    <div class="form-group avatar-form" style="text-align: left">
                        <img class="avatar-food" style="width: 20%; min-width: 100px" src="${resultFood.avatar}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label>Price</label>
                    <span class="form-control">${resultFood.price}</span>
                </div>
                <div class="form-group">
                    <label>Start Sell Date</label>
                    <span class="form-control"><fmt:formatDate pattern="dd-MM-yyyy HH:mm:ss" value="${resultFood.startSellDate}" /></span>
                </div>
                <div class="form-group">
                    <label>Create Date</label>
                    <span class="form-control"><fmt:formatDate pattern="dd-MM-yyyy HH:mm:ss" value="${resultFood.createDate}" /></span>
                </div>
                <div class="form-group">
                    <label>Update Date</label>
                    <span class="form-control"><fmt:formatDate pattern="dd-MM-yyyy HH:mm:ss" value="${resultFood.updateDate}" /></span>
                </div>
                <div class="form-group">
                    <a href="/admin/food/list" class="goback" data-toggle="modal" style="cursor: pointer; right: 0">
                        <i class="material-icons" data-toggle="tooltip" title="Go back here" style="font-size: 50px; color: #0080ff;">&#xe317;</i>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<style>
    body {
        color: #566787;
        background: #f5f5f5;
        font-family: 'Varela Round', sans-serif;
        font-size: 13px;
    }

    .table-wrapper {
        background: #fff;
        padding: 20px 25px;
        margin: 30px 0;
        border-radius: 3px;
        box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
        width: 80%;
        margin-left: 10%;
    }

    .modal .modal-content {
        border-radius: 3px;
    }

    .modal .modal-header, .modal .modal-body, .modal .modal-footer {
        padding: 20px 30px;
    }

    .table-title .btn {
        color: #fff;
        float: right;
        font-size: 13px;
        border: none;
        min-width: 50px;
        border-radius: 2px;
        border: none;
        outline: none !important;
        margin-left: 10px;
    }
</style>
</html>
