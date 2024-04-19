/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.service;

import demo.bean.ProductObj;
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
public class OrderMenuService {

    public List<ProductObj> getProductList(String categoryId) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;

        // 接続文字列
        String url = "jdbc:postgresql://localhost:5432/pr";
        String user = "postgres";
        String password = "postgres";

        List<ProductObj> productObjList = new ArrayList<ProductObj>();
        // PostgreSQLへ接続
        try {

            Class.forName("org.postgresql.Driver");

            conn = DriverManager.getConnection(url, user, password);

            //自動コミットOFF
            conn.setAutoCommit(false);

            //SELECT文の実行
            stmt = conn.createStatement();

            StringBuilder sb = new StringBuilder();
            sb.append("select inv.product_id,inv.product_name,inv.product_count,inv.product_price,inv.category_id from category ca left join productmanagement inv on ca.category_id = inv.category_id where inv.category_id =");
            sb.append("'" + categoryId + "';");
            System.out.println(sb.toString());
            rset = stmt.executeQuery(sb.toString());

            //SELECT結果の受け取り
            while (rset.next()) {
      
                ProductObj obj = new ProductObj();

                obj.setProductId(rset.getInt(1));
                obj.setProductName(rset.getString(2));
                obj.setProductCount(rset.getInt(3));
                obj.setProductPrice(rset.getInt(4));
                productObjList.add(obj);
            }

        } catch (SQLException | ClassNotFoundException e) {
            
            System.out.println("SQL ERRO");
            
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
        return productObjList;
    }
}
