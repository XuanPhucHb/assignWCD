package com.sem4.wcd.assign.service;

import com.sem4.wcd.assign.controller.FoodController;
import com.sem4.wcd.assign.entity.Food;
import com.sem4.wcd.assign.utils.ConnectionHelper;
import com.sem4.wcd.assign.utils.FoodConstant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FoodService implements IService<Food> {

    public static final int ZERO_RECORD = 0;

    @Override
    public List<Food> getAll() {
        Statement stmt = null;
        List<Food> foodList = new ArrayList<>();
        try (Connection conn = ConnectionHelper.getConnection()) {
            stmt = conn.createStatement();
            String query = "SELECT * FROM food WHERE status = " + FoodConstant.SELLING;
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Food food = new Food();
                food.setId(rs.getLong("id"));
                food.setFoodCode(rs.getString("food_code"));
                food.setFoodName(rs.getString("food_name"));
                food.setDescription(rs.getString("description"));
                food.setAvatar(rs.getString("avatar"));
                food.setPrice(rs.getInt("price"));
                food.setStatus(rs.getInt("status"));
                food.setCreateDate(rs.getDate("create_date"));
                food.setStartSellDate(rs.getDate("start_sell_date"));
                food.setCreateDate(rs.getDate("create_date"));
                food.setUpdateDate(rs.getDate("update_date"));
                foodList.add(food);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return foodList;
    }

    public List<Food> getByPagination(int start, int end) {
        Statement stmt = null;
        List<Food> listFood = new ArrayList<>();
        try (Connection conn = ConnectionHelper.getConnection()) {
            stmt = conn.createStatement();
            String query = "SELECT * FROM food WHERE status = " + FoodConstant.SELLING + " LIMIT " + start + ", " + end;
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Food food = new Food();
                food.setId(rs.getLong("id"));
                food.setFoodCode(rs.getString("food_code"));
                food.setFoodName(rs.getString("food_name"));
                food.setCategoryCode(rs.getString("category_code"));
                food.setDescription(rs.getString("description"));
                food.setAvatar(rs.getString("avatar"));
                food.setPrice(rs.getInt("price"));
                food.setStatus(rs.getInt("status"));
                food.setCreateDate(rs.getDate("create_date"));
                food.setStartSellDate(rs.getDate("start_sell_date"));
                food.setUpdateDate(rs.getDate("update_date"));
                listFood.add(food);
            }
            return listFood;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Food getById(Long id) {
        Statement stmt = null;
        try (Connection conn = ConnectionHelper.getConnection()) {
            stmt = conn.createStatement();
            String query = "SELECT * FROM food WHERE id = " + id;
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Food food = new Food();
                food.setId(rs.getLong("id"));
                food.setFoodCode(rs.getString("food_code"));
                food.setFoodName(rs.getString("food_name"));
                food.setCategoryCode(rs.getString("category_code"));
                food.setDescription(rs.getString("description"));
                food.setAvatar(rs.getString("avatar"));
                food.setPrice(rs.getInt("price"));
                food.setStatus(rs.getInt("status"));
                food.setCreateDate(rs.getDate("create_date"));
                food.setStartSellDate(rs.getDate("start_sell_date"));
                food.setUpdateDate(rs.getDate("update_date"));
                return food;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean create(Food food) {
        PreparedStatement pstm = null;
        try (Connection conn = ConnectionHelper.getConnection()) {
            String query = "INSERT INTO food (food_code, food_name, category_code, description, avatar, price, status) " +
                    "VALUES (?,?,?,?,?,?,?) ";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, food.getFoodCode());
            pstm.setString(2, food.getFoodName());
            pstm.setString(3, food.getCategoryCode());
            pstm.setString(4, food.getDescription());
            pstm.setString(5, food.getAvatar());
            pstm.setInt(6, food.getPrice());
            pstm.setInt(7, food.getStatus());
            int resultCreate = pstm.executeUpdate();
            if (resultCreate != ZERO_RECORD) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Food food) {
        Food foodCheck = getById(food.getId());
        PreparedStatement pstm = null;
        if (foodCheck != null) {
            try (Connection conn = ConnectionHelper.getConnection()) {
                String query = "UPDATE food SET food_code = ?, food_name = ?, category_code = ?, description = ?" +
                        ", avatar = ?, price = ?, update_date = ? WHERE id = ?";
                pstm = conn.prepareStatement(query);
                pstm.setString(1, food.getFoodCode());
                pstm.setString(2, food.getFoodName());
                pstm.setString(3, food.getCategoryCode());
                pstm.setString(4, food.getDescription());
                pstm.setString(5, food.getAvatar());
                pstm.setInt(6, food.getPrice());
                pstm.setDate(7, new Date(new java.util.Date().getTime()));
                pstm.setLong(8, food.getId());
                int resultUpdate = pstm.executeUpdate();
                if (resultUpdate != ZERO_RECORD) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        Food foodCheck = getById(id);
        PreparedStatement pstm = null;
        if (foodCheck != null) {
            try (Connection conn = ConnectionHelper.getConnection()) {
                String query = "UPDATE food SET status = ? WHERE id = ?";
                pstm = conn.prepareStatement(query);
                pstm.setInt(1, FoodConstant.DELETED);
                pstm.setLong(2, id);
                int resultUpdate = pstm.executeUpdate();
                if (resultUpdate != ZERO_RECORD) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
