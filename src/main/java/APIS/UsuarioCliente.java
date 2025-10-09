/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package APIS;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * @author Laura
 */
public class UsuarioCliente {
    public  final String BASE_URL="http://localhost:9090";
    private static UsuarioApiService apiService;
    
    public UsuarioCliente(){
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        this.apiService = retrofit.create(UsuarioApiService.class);
}
    public Map<String, Object> login(String email, String password) throws IOException {
        Map<String, String> credenciales = new HashMap<>();
        credenciales.put("email", email);
        credenciales.put("password", password);

        Response<Map<String, Object>> response = apiService.login(credenciales).execute();

        if (response.isSuccessful() && response.body() != null) {
            return response.body(); // contiene role, message, etc.
        } else {
            Map<String, Object> error = new HashMap<>();
            error.put("error", "Credenciales inválidas o servidor no disponible");
            return error;
        }
    }
    public List<Usuario> listarTodosUsuarios()throws IOException {
        
            Response<List<Usuario>> response = apiService.getAllUsuarios().execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
               throw new IOException("error al listar usuarios: "+response.code());
            }
        
      
    }
     public Usuario buscarUsuarioPorId(int id)throws IOException {
         
   
            Response<Usuario> response = apiService.getUsuarioByEmail(id).execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                throw new IOException("usuario no encontrado"+response.code());
            }
      
    }
     public Usuario crearUsuario(Usuario usuario)throws IOException {
         
         Response<Usuario>response=apiService.createUsuario(usuario).execute();
        if(response.isSuccessful()){
            return response.body();
        }else{
            throw new IOException("Error al crear usuario: "+ response.code());
        }
     }
     public Usuario actualizarUsuario(int id,Usuario usuario){
         try {
            Response<Usuario> response = apiService.updateUsuario(id,usuario).execute();
            if (response.isSuccessful()) {
               return response.body();
            } else {
                throw new IOException("error al actualizar usuario" + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
     }
 
     public  void eliminarUsuario(int id)throws IOException{
         Response<Void>response=apiService.deleteUsuario(id).execute();
             if(!response.isSuccessful()){
                throw new IOException("error al eliminar usuario"+ response.code());
             }
         }
     public List<Usuario> buscarPorFiltros(String nombre, Integer id) throws IOException {
        Response<List<Usuario>> response = apiService.buscarUsuarios(nombre, id).execute();
        if (response.isSuccessful()) {
        return response.body();
    } else {
        throw new IOException("Error al buscar por filtros: " + response.code());
    }
}

     
     }
     

