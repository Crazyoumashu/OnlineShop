package com.hhw.dto;

import com.hhw.beans.CartHasGoods;

import java.io.Serializable;
import java.util.List;

public class CartListDTO implements Serializable {
    private List<CartHasGoods> cartList;
    public CartListDTO(){
        super();
    }

    public List<CartHasGoods> getCartList() {
        return cartList;
    }

    public void setCartList(List<CartHasGoods> cartList) {
        this.cartList = cartList;
    }
}
