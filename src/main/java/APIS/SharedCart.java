/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package APIS;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Laura
 */
public class SharedCart {
     private static final SharedCart INSTANCE = new SharedCart();
    private List<ItemsPedidos> items;

    private SharedCart() {
        items = new ArrayList<>();
    }

    public static SharedCart getInstance() {
        return INSTANCE;
    }

    public List<ItemsPedidos> getItems() {
        return items;
    }

    public void addItem(ItemsPedidos item) {
        if (item != null) items.add(item);
    }

    public void clear() {
        items.clear();
    }
}

