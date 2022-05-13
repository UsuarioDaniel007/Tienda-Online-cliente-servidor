
package Interfaces;

import java.util.List;


public interface CRUDGenerico <T> {
    List<T> obtenerTodos();
    T obtenerPorId(int id);
    Boolean registrar(T t);
    Boolean actualizar(T t);
    Boolean eliminar(T t);
}
