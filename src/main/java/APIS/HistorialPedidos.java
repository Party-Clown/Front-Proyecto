/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package APIS;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Laura
 */
public class HistorialPedidos {
    private static List<List<ItemsPedidos>> historial=new ArrayList<>();
   
    public  void AgregarHistorial(List<ItemsPedidos> pedido){
        historial.add(pedido);
        System.out.println("pedido guardado");
    }
    public  List<List<ItemsPedidos>> getHistorial(){
        return historial;
    }
}
