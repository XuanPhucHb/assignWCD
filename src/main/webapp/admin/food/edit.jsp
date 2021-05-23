<%@ page import="com.sem4.wcd.assign.entity.Food" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/21/2021
  Time: 3:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit</title>
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
            <form action="/admin/food/edit?id=${chooseFood.id}" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Edit Food</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Code of food</label>
                        <input value="${chooseFood.foodCode}" name="foodCode" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Name of food</label>
                        <input value="${chooseFood.foodName}" name="foodName" minlength="7" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Description</label>
                        <textarea name="description" rows="4" class="form-control">${chooseFood.description}</textarea>
                    </div>
                    <div class="form-group">
                        <label>Code of category</label>
                        <select class="form-control" name="categoryCode" required>
                            <option value="1" ${chooseFood.categoryCode == 1 ? 'selected="selected"' : ''}>
                                Grill
                            </option>
                            <option value="2" ${chooseFood.categoryCode == 2 ? 'selected="selected"' : ''}>
                                Boiled food
                            </option>
                            <option value="3" ${chooseFood.categoryCode == 3 ? 'selected="selected"' : ''}>
                                Vegetarian dish
                            </option>
                            <option value="4" ${chooseFood.categoryCode == 4 ? 'selected="selected"' : ''}>
                                Drinks
                            </option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Photo</label>
                        <div class="form-group avatar-form" style="text-align: left">
                            <input class="url-image" name="avatar" type="text" style="display: none" value="${chooseFood.avatar}"
                                   class="form-control"/>
                            <img class="avatar-food" style="width: 20%; min-width: 100px" src="${chooseFood.avatar}" />
                        </div>
                        <button id="upload_widget" class="form-control" style="width: 20%; min-width: 100px">Choose photo</button>
                    </div>
                    <div class="form-group">
                        <label>Price</label>
                        <input name="price" value="${chooseFood.price}" type="number" min="1" class="form-control" max="3000000000" required>
                    </div>
                </div>
                <div class="modal-footer">
<%--                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">--%>
                    <input type="submit" class="btn btn-success" value="Edit">
                </div>
            </form>
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
<script>
    var myWidget = cloudinary.createUploadWidget({
            cloudName: 'xuanphuc',
            uploadPreset: 'ehbmei9h'
        }, (error, result) => {
            if (!error && result && result.event === "success") {
                $('.url-image').val(result.info.url);
                if( $('.avatar-form').find('img').hasClass('avatar-food')){
                    $('.avatar-food').remove();
                }
                $('.avatar-form').append(`<img class="avatar-food" style="width: 60%" src='` + result.info.url + `' />`);
            }
        }
    )

    document.getElementById("upload_widget").addEventListener("click", function () {
        myWidget.open();
    }, false);
</script>
</html>
