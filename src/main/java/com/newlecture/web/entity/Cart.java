package com.newlecture.web.entity;

import java.util.Date;

public class Cart {
    private int id;
    private int memberId;
    private int menuId;
    private boolean ice;
    private boolean large;
    private Date date;


    public Cart() {
        // TODO Auto-generated constructor stub
    }



    public Cart(int memberId, int menuId, boolean ice, boolean large) {
        super();
        this.memberId = memberId;
        this.menuId = menuId;
        this.ice = ice;
        this.large = large;
    }



    public Cart(int id, int memberId, int menuId, boolean ice, boolean large, Date date) {
        super();
        this.id = id;
        this.memberId = memberId;
        this.menuId = menuId;
        this.ice = ice;
        this.large = large;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public boolean isIce() {
        return ice;
    }

    public void setIce(boolean ice) {
        this.ice = ice;
    }

    public boolean isLarge() {
        return large;
    }

    public void setLarge(boolean large) {
        this.large = large;
    }

    @Override
    public String toString() {
        return "Cart [id=" + id + ", memberId=" + memberId + ", menuId=" + menuId + ", ice=" + ice + ", large=" + large
                + ", date=" + date + "]";
    }





}