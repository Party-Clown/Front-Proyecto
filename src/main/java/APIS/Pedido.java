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
public class Pedido {
    private static int contador =1;
 private int id;
 private List<ItemsPedidos> items=new ArrayList<>();

 public Pedido(){
     this.id=contador++;
 }

  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ItemsPedidos> getItems() {
        return items;
    }

    public void setItems(List<ItemsPedidos> items) {
        this.items = items;
    }
    public double getTotal(){
        return items.stream().mapToDouble(ItemsPedidos::getSubtotal).sum();
    }
 @Override
    public String toString() {
        return "pedido #" + " x" + "-Total: $" + getTotal();
    }
}

    

