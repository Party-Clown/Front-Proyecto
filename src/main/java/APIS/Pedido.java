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
  
 private int id;
 private List<ItemsPedidos> items=new ArrayList<>();
private String CorreoUsuario;
private String NombreUsuario;
private String Estado;

    public Pedido() {
        this.id = id;
        this.CorreoUsuario = CorreoUsuario;
        this.NombreUsuario = NombreUsuario;
        this.Estado=Estado;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getCorreoUsuario() {
        return CorreoUsuario;
    }

    public void setCorreoUsuario(String CorreoUsuario) {
        this.CorreoUsuario = CorreoUsuario;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
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

    

