/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.bean;

/**
 *
 * @author sonra
 */
public class ProductObj {

    private Integer productId;

    private String productName;
    
    private Integer productPrice;
    
    private Integer productCount;
    
    private Integer categoryId;
    
    public ProductObj() {
    }

    public ProductObj(Integer productId, String productName,Integer productCount,Integer productPrice,Integer categoryId) {
        this.productId= productId;
        this.productName = productName;
        this.productCount=productCount;
        this.productPrice =productPrice;
        this.categoryId=categoryId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
 
    @Override
    public String toString() {
        return productName;
    }

}
