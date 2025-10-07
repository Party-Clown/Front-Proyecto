/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package APIS;

import java.io.IOException;
import java.util.List;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * @author Laura
 */
public class PedidoCliente {
    public  final String BASE_URL="http://localhost:9090";
    private static PedidoApiService apiService;
    
    public PedidoCliente(){
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        this.apiService = retrofit.create(PedidoApiService.class);
}
    
    public List<Pedido> listarTodosPedidos()throws IOException {
        
            Response<List<Pedido>> response = apiService.getAllPedidos().execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
               throw new IOException("error al listar usuarios: "+response.code());
            }
        
      
    }
     public Pedido buscarPedidoPorId(int id)throws IOException {
         
   
            Response<Pedido> response = apiService.getPedidosById(id).execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                throw new IOException("usuario no encontrado"+response.code());
            }
      
    }
     public Pedido crearPedido(Pedido pedido)throws IOException {
         
         Response<Pedido>response=apiService.createPedido(pedido).execute();
        if(response.isSuccessful()){
            return response.body();
        }else{
            throw new IOException("Error al crear usuario: "+ response.code());
        }
     }
     public  void eliminarPedido(int id)throws IOException{
         Response<Void>response=apiService.deletePedido(id).execute();
             if(!response.isSuccessful()){
                throw new IOException("error al eliminar pedido"+ response.code());
             }
         }
    
}
