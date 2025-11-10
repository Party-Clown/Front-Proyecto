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
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

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
   
   @PUT("/api/pedidos/{id}/estado/{nuevoEstado}")
   Call<Void> actualizarEstadoPedido(@Path("id") int id, @Path("nuevoEstado") String nuevoEstado);
   
   @PUT("/api/pedidos/{id}/terminar")
    Call<Void> terminarPedido(@Path("id") int id);  
}
