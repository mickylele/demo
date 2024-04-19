/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.service;

import demo.bean.CategoryObj;
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
public class ProductService {

    public List<ProductObj> getProductList() {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;

        // 接続文字列
        String url = "jdbc:postgresql://localhost:5432/pr";
        String user = "postgres";
        String password = "postgres";

        // PostgreSQLへ接続
        List<ProductObj> productObjList = new ArrayList<ProductObj>();

        try {

            Class.forName("org.postgresql.Driver");

            conn = DriverManager.getConnection(url, user, password);

            //自動コミットOFF
            conn.setAutoCommit(false);

            //SELECT文の実行
            stmt = conn.createStatement();
            String sql = "select * from productmanagement order by product_id asc;";
            rset = stmt.executeQuery(sql);

            //SELECT結果の受け取り
            while (rset.next()) {

                int productId = rset.getInt(1);
                String productName = rset.getString(2);
                int productPrice = rset.getInt(3);
                int productCount = rset.getInt(4);
                int categoryId = rset.getInt(5);

                ProductObj obj = new ProductObj();

                obj.setProductId(productId);
                obj.setProductName(productName);
                obj.setProductPrice(productPrice);
                obj.setProductCount(productCount);
                obj.setCategoryId(categoryId);

                productObjList.add(obj);

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
        return productObjList;
    }

    public void addProduct(int productId, String productName, int productCount, int productPrice, Integer categoryId) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;

        // 接続文字列
        String url = "jdbc:postgresql://localhost:5432/pr";
        String user = "postgres";
        String password = "postgres";

        // PostgreSQLへ接続
        try {

            Class.forName("org.postgresql.Driver");

            conn = DriverManager.getConnection(url, user, password);

            //自動コミットOFF
            conn.setAutoCommit(false);

            //SELECT文の実行
            stmt = conn.createStatement();

            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO productmanagement (product_id, product_name,product_price,product_count,category_id) VALUES (");

            sb.append(productId);
            sb.append(",");
            sb.append("'" + productName + "'");
            sb.append(",");
            sb.append(productPrice);
            sb.append(",");
            sb.append(productCount);
            sb.append(",");
            sb.append(categoryId + ");");
            System.out.println(sb.toString());

            stmt.executeUpdate(sb.toString());
            conn.commit();
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
    }

    public void editProduct(int productId, int productName,int productPrice, int productCount, Integer categoryId) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;

        // 接続文字列
        String url = "jdbc:postgresql://localhost:5432/pr";
        String user = "postgres";
        String password = "postgres";

    // PostgreSQLへ接続
        try {

            Class.forName("org.postgresql.Driver");

            conn = DriverManager.getConnection(url, user, password);

            //自動コミットOFF
            conn.setAutoCommit(false);

            //SELECT文の実行
            stmt = conn.createStatement();

            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE productmanagement SET product_name='");
            sb.append(productName);
            sb.append("', product_count=");
            sb.append(productCount);
            sb.append(", product_price=");
            sb.append(productPrice);
            sb.append(", category_id=");
            sb.append(categoryId);
            sb.append(" WHERE product_id=");
            sb.append(productId);
            sb.append(";");

            System.out.println(sb.toString());
            stmt.executeUpdate(sb.toString());
            conn.commit();

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

    }
}
