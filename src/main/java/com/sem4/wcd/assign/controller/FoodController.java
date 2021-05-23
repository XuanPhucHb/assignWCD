package com.sem4.wcd.assign.controller;

import com.sem4.wcd.assign.entity.Food;
import com.sem4.wcd.assign.service.FoodService;
import com.sem4.wcd.assign.utils.FoodConstant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@WebServlet(name = "foodController", urlPatterns = "/admin/food/list")
public class FoodController extends HttpServlet {
    public static List<Food> foodList = new ArrayList<>();
    FoodService foodService = new FoodService();
    public static int page = 1;
    public static int limit = 5;
    public static int allOfPage = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("goGet Food");
        if (req.getParameter("action") != null && Integer.parseInt(req.getParameter("action")) == 4) {
            if (req.getParameter("id") != null) {
                String a = req.getParameter("id");
                Long id = Long.parseLong(req.getParameter("id"));
                Food resultFood = foodService.getById(id);
                if (resultFood != null) {
                    req.setAttribute("resultFood", resultFood);
                    req.getRequestDispatcher("/admin/food/detail.jsp").forward(req, resp);
                } else {
                    req.setAttribute("errorMessage", "fail");
                    req.setAttribute("action", "Get detail ");
                    req.getRequestDispatcher("/admin/food/success_error.jsp").forward(req, resp);
                }
                return;
            }
        }
        if (req.getParameter("action") != null && Integer.parseInt(req.getParameter("action")) == 3) {
            if (req.getParameter("idDelete") != null) {
                String a = req.getParameter("idDelete");
                Long id = Long.parseLong(req.getParameter("idDelete"));
                boolean resultDelete = foodService.delete(id);
                if (resultDelete) {
                    req.setAttribute("errorMessage", "success");
                } else {
                    req.setAttribute("errorMessage", "fail");
                }
                req.setAttribute("action", "Delete ");
                req.getRequestDispatcher("/admin/food/success_error.jsp").forward(req, resp);
                return;
            }
        }
        if (req.getParameter("limit") != null) {
            limit = Integer.parseInt(req.getParameter("limit"));
        }
        if (req.getParameter("page") != null) {
            page = Integer.parseInt(req.getParameter("page"));
        }
        foodList = foodService.getByPagination(page * 5 - 5, limit);
        int size = foodService.getAll().size();
        req.setAttribute("foodList", foodList);
        req.setAttribute("sizeInPage", foodList.size());
        req.setAttribute("foodListSizeAll", size);
        req.setAttribute("page", page);
        req.setAttribute("limit", limit);
        allOfPage = size / limit;
        if (size % limit > 0) {
            allOfPage += 1;
        }
        req.setAttribute("allOfPage", allOfPage);
        req.getRequestDispatcher("/admin/food/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Food food = new Food();
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
        food.setStatus(FoodConstant.SELLING);
        boolean resultCreate = foodService.create(food);
        if (resultCreate) {
            req.setAttribute("errorMessage", "success");
        } else {
            req.setAttribute("errorMessage", "fail");
        }
        req.setAttribute("action", "Create ");
        req.getRequestDispatcher("/admin/food/success_error.jsp").forward(req, resp);
    }
}
