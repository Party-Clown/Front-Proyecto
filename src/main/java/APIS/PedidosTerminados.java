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
public class PedidosTerminados {
    private ArrayList<Pedido> pedidosTerminados = new ArrayList<>();

public  void agregarPedido(Pedido pedido) {
        pedidosTerminados.add(pedido);
    }

    // Obtener todos los pedidos terminados
    public  List<Pedido> getPedidosTerminados() {
        return pedidosTerminados;
    }

    // Reemplazar toda la lista si es necesario
    public  void setPedidosTerminados(List<Pedido> nuevaLista) {
        pedidosTerminados = (ArrayList<Pedido>) nuevaLista;
    }

    // Limpiar todos los pedidos
    public  void limpiarPedidos() {
        pedidosTerminados.clear();
    }
}
