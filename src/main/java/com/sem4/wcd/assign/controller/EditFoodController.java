package com.sem4.wcd.assign.controller;

import com.sem4.wcd.assign.entity.Food;
import com.sem4.wcd.assign.service.FoodService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "editController", urlPatterns = "/admin/food/edit")
public class EditFoodController extends HttpServlet {
    FoodService foodService = new FoodService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = null;
        Food chooseFood = new Food();
        if (req.getParameter("id") != null) {
            id = Long.parseLong(req.getParameter("id"));
        }
        if (id != null) {
            Food foodResult = foodService.getById(id);
            chooseFood = foodResult;
        }
        req.setAttribute("chooseFood", chooseFood);
        req.getRequestDispatcher("/admin/food/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Food food = new Food();
        if (req.getParameter("id") != null) {
            food.setId(Long.parseLong(req.getParameter("id")));
        }
        if (req.getParameter("foodCode") != null) {
            food.setFoodCode(req.getParameter("foodCode"));
        }
        if (req.getParameter("foodName") != null) {
            food.setFoodName(req.getParameter("foodName"));
        }
        if (req.getParameter("description") != null) {
            food.setDescription(req.getParameter("description"));
        }
        if (req.getParameter("avatar") != null) {
            food.setAvatar(req.getParameter("avatar"));
        }
        if (req.getParameter("categoryCode") != null) {
            food.setCategoryCode(req.getParameter("categoryCode"));
        }
        if (req.getParameter("price") != null) {
            food.setPrice(Integer.parseInt(req.getParameter("price")));
        }
        boolean resultUpdate = foodService.update(food);
        if (resultUpdate) {
            req.setAttribute("errorMessage", "success");
        } else {
            req.setAttribute("errorMessage", "fail");
        }
        req.setAttribute("action", "Update ");
        req.getRequestDispatcher("/admin/food/success_error.jsp").forward(req, resp);
    }
}
