package com.example.dashboard.model;

import com.example.dashboard.DashboardApplication;
import com.example.dashboard.controllers.PageController;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;

public class MysqlCon extends DashboardApplication {

    private String idLogin = "";

    public String getIdLogin() {
        return idLogin;
    }

    public void createAccount(String name, String email, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dashboard?useSSL=false", "root", "root");
            String query;
            query = String.format("INSERT INTO user (name, email, password, isAdmin, w1, w2, w3, w4, w5) VALUES ('%s','%s','%s',0,0,0,0,0,0);", name, email, password);
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public boolean loginBDD(String email, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dashboard?useSSL=false", "root", "root");
            Statement stmt = con.createStatement();
            String query;
            query = String.format("select id,password from user where email = '%s';", email);
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            if (password.equals(rs.getString(2))) {
                this.idLogin = "" + rs.getInt(1);
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    public void addWidget(HttpServletRequest request, String widget){
        try {
            String email = PageController.getCookieValue(request.getCookies(), "email", "");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dashboard?useSSL=false", "root", "root");
            String query;
            query = String.format("UPDATE `user` SET `"+widget+"` = '1' WHERE `user`.`email` =\""+email+"\";");
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void delWidget(HttpServletRequest request, String widget){
        try{
            String email = PageController.getCookieValue(request.getCookies(), "email", "");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dashboard?useSSL=false", "root", "root");
            String query;
            query = String.format("UPDATE `user` SET `"+widget+"` = '0' WHERE `user`.`email` =\""+email+"\";");
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
            con.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }
    public boolean isWidgetSelected(HttpServletRequest request, String widget){
        try{
            String email = PageController.getCookieValue(request.getCookies(), "email", "");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dashboard?useSSL=false", "root", "root");
            Statement stmt = con.createStatement();
            String query;
            query = String.format("select "+widget+" from user where email = '%s';", email);
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            if (rs.getInt(1) == 1){
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
