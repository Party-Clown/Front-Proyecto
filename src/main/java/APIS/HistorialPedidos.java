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
    private static List<Pedido> historial = new ArrayList<>();

    public void AgregarHistorial(Pedido pedido) {
        if (pedido != null) {
            historial.add(pedido);
            System.out.println("Pedido guardado en historial con ID: " + pedido.getId());
        }
    }

    public List<Pedido> getHistorial() {
        return historial;
    }
    public void clearHistorial(){
        historial.clear();
    }
}
