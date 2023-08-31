/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Autor;
import java.util.List;
import javax.persistence.EntityManager;

public class AutorDAO extends DAO<Autor> {

    @Override
    public void persistirEntidad(Autor autor) {
        super.persistirEntidad(autor);
    }

    @Override
    public void actualizarEntidad(Autor autor) {
        super.actualizarEntidad(autor);
    }

    @Override
    public void borrarEntidad(Autor autor) {
        super.borrarEntidad(autor);
    }

    public Autor buscarAutor(Integer id) {
        conectarBase();
        Autor autor = EntityManager.find(Autor.class, id);
        desconectarBase();
        return autor;
    }

    public List<Autor> buscarAutorNombre(String nombre) {
        conectarBase();
        List<Autor> autores = EntityManager.createQuery("SELECT a FROM Autor a where a.nombre = :nombre AND a.alta = TRUE").setParameter("nombre", nombre).getResultList();
        desconectarBase();
        return autores;
    }

    public List<Autor> validarNombreAutor(String nombre) {
        conectarBase();
        List<Autor> autores = EntityManager.createQuery("SELECT a FROM Autor a where a.nombre = :nombre").setParameter("nombre", nombre).getResultList();
        desconectarBase();
        return autores;
    }
}