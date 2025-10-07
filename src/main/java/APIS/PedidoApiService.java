/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package APIS;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 *
 * @author Laura
 */
public interface PedidoApiService {
     @GET("/api/pedidos")
   Call<List<Pedido>> getAllPedidos();
   
   @GET("/api/pedidos/{id}")
   Call<Pedido> getPedidosById(@Path("id")int id);

   @POST("/api/pedidos")
   Call<Pedido> createPedido(@Body Pedido pedido);
   
    @DELETE("/api/pedidos/{id}")
   Call<Void> deletePedido(@Path("id")int id);
}
