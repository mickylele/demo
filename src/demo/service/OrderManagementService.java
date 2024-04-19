/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.service;

import demo.bean.OrderManagementObj;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sonra
 */
public class OrderManagementService {

    public List<OrderManagementObj> getOrderMenuList() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;

        // 接続文字列
        String url = "jdbc:postgresql://localhost:5432/pr";
        String user = "postgres";
        String password = "postgres";

        // PostgreSQLへ接続
        List<OrderManagementObj> orderMenuObjList = new ArrayList<OrderManagementObj>();

        try {

            Class.forName("org.postgresql.Driver");

            conn = DriverManager.getConnection(url, user, password);

            //自動コミットOFF
            conn.setAutoCommit(false);

            //SELECT文の実行
            stmt = conn.createStatement();
            String sql = "select * from OrderMenu order by order_number asc;";
            rset = stmt.executeQuery(sql);

            //SELECT結果の受け取り
            while (rset.next()) {
                int orderNumber = rset.getInt(1);
                String orderDate = rset.getString(2);
                int totalPrice = rset.getInt(3);

                OrderManagementObj obj = new OrderManagementObj();

                obj.setOrderNumber(orderNumber);
                obj.setOrderDate(orderDate);
                obj.setTotalPrice(totalPrice);
                orderMenuObjList.add(obj);

            }

        } catch (SQLException | ClassNotFoundException e) {
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
            }

        }
        return orderMenuObjList;

    }

}
