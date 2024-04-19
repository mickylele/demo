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
public class OrderManagementObj {

    private Integer orderNumber;

    private String orderDate;
    
    private Integer totalPrice;
    
    public OrderManagementObj(){
        
    }

    public OrderManagementObj(Integer orderNumber,String orderDate,Integer totalPrice) {
         this.orderNumber = orderNumber;
        this.orderDate = orderDate ;
        this.totalPrice=totalPrice;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String toString() {
        return orderDate;
    }
    
    
}
