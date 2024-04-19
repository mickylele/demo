/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.service;

import demo.bean.CategoryObj;
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
public class CategoryService {

    public List<CategoryObj> getCategoryList() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;

        // 接続文字列
        String url = "jdbc:postgresql://localhost:5432/pr";
        String user = "postgres";
        String password = "postgres";

        // PostgreSQLへ接続
        List<CategoryObj> categoryObjList = new ArrayList<CategoryObj>();

        try {

            Class.forName("org.postgresql.Driver");

            conn = DriverManager.getConnection(url, user, password);

            //自動コミットOFF
            conn.setAutoCommit(false);

            //SELECT文の実行
            stmt = conn.createStatement();
            String sql = "select * from category order by category_id asc;";
            rset = stmt.executeQuery(sql);

            //SELECT結果の受け取り
            while (rset.next()) {
                int categoryId = rset.getInt(1);
                String categoryName = rset.getString(2);

                CategoryObj obj = new CategoryObj();

                obj.setCategoryId(categoryId);
                obj.setCategoryName(categoryName);
                categoryObjList.add(obj);

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
        return categoryObjList;
    }

    /**
     * カテゴリー登録処理
     *
     * @param categoryId
     * @param categoryName
     */
    public void addCategory(int categoryId, String categoryName) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;

        // 接続文字列
        String url = "jdbc:postgresql://localhost:5432/pr";
        String user = "postgres";
        String password = "postgres";

        // PostgreSQLへ接続
        List<CategoryObj> categoryObjList = new ArrayList<CategoryObj>();
        try {

            Class.forName("org.postgresql.Driver");

            conn = DriverManager.getConnection(url, user, password);

            //自動コミットOFF
            conn.setAutoCommit(false);

            //SELECT文の実行
            stmt = conn.createStatement();

            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO category (category_id, category_name) VALUES (");

            sb.append(categoryId);
            sb.append(",");
            sb.append("'" + categoryName + "');");
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

    /**
     * カテゴリー編集処理
     *
     * @param categoryId
     * @param categoryName
     */
    public void editCategory(int categoryId, String categoryName) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;

        // 接続文字列
        String url = "jdbc:postgresql://localhost:5432/pr";
        String user = "postgres";
        String password = "postgres";

        // PostgreSQLへ接続
        List<CategoryObj> categoryObjList = new ArrayList<CategoryObj>();
        try {

            Class.forName("org.postgresql.Driver");

            conn = DriverManager.getConnection(url, user, password);

            //自動コミットOFF
            conn.setAutoCommit(false);

            //SELECT文の実行
            stmt = conn.createStatement();

            StringBuilder sb = new StringBuilder();
            sb.append("update  category set category_name=");

            sb.append("'" + categoryName + "'");
            sb.append(" WHERE category_id= ");
            sb.append("'" + categoryId + "';");

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

    /**
     * カテゴリー削除処理
     *
     * @param categoryId
     * @param categoryName
     */
    public void deleteCategory(String categoryId, String categoryName) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;

        // 接続文字列
        String url = "jdbc:postgresql://localhost:5432/pr";
        String user = "postgres";
        String password = "postgres";

        // PostgreSQLへ接続
        List<CategoryObj> categoryObjList = new ArrayList<CategoryObj>();
        try {

            Class.forName("org.postgresql.Driver");

            conn = DriverManager.getConnection(url, user, password);

            //自動コミットOFF
            conn.setAutoCommit(false);

            //SELECT文の実行
            stmt = conn.createStatement();

            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM category WHERE category_id= ");
            sb.append("'" + categoryId + "';");
            System.out.println(sb.toString());

            //INSERT文の実行
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
