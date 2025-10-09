/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package APIS;

import java.util.List;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 *
 * @author Laura
 */
public interface UsuarioApiService {
   @GET("/api/usuario")
   Call<List<Usuario>> getAllUsuarios();
   
   @GET("/api/usuario/{id}")
   Call<Usuario> getUsuarioByEmail(@Path("id")int id);

   @POST("/api/usuario")
   Call<Usuario> createUsuario(@Body Usuario usuario);
   
   @PUT("/api/usuario/{id}")
    Call<Usuario> updateUsuario(@Path("id")int id, @Body Usuario usuario);       

   @GET("api/usuario/buscar")
   Call<List<Usuario>> buscarUsuarios(
         @Query("nombre")String nombre,
         @Query("id")Integer id
          );
   
   @DELETE("api/usuario/{id}")
   Call<Void> deleteUsuario(@Path("id")int id);

   @POST("/api/usuario/login")
    Call<Map<String, Object>> login(@Body Map<String, String> credenciales);
   
}
