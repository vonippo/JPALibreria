/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Editorial;
import java.util.List;
import javax.persistence.EntityManager;

public class EditorialDAO extends DAO<Editorial> {

    @Override
    public void persistirEntidad(Editorial editorial) {
        super.persistirEntidad(editorial);
    }

    @Override
    public void actualizarEntidad(Editorial editorial) {
        super.actualizarEntidad(editorial);
    }

    @Override
    public void borrarEntidad(Editorial editorial) {
        super.borrarEntidad(editorial);
    }

    public Editorial buscarEditorial(Integer id) {
        conectarBase();
        Editorial editorial = EntityManager.find(Editorial.class, id);
        desconectarBase();
        return editorial;
    }

    public List<Editorial> buscarEditorialNombre(String nombre) {
        conectarBase();
        List<Editorial> editoriales = EntityManager.createQuery("SELECT e FROM Editorial e where e.nombre = :nombre AND e.alta = TRUE").setParameter("nombre", nombre).getResultList();
        desconectarBase();
        return editoriales;
    }
    
        public List<Editorial> validarEditorialNombre(String nombre) {
        conectarBase();
        List<Editorial> editoriales = EntityManager.createQuery("SELECT e FROM Editorial e where e.nombre = :nombre").setParameter("nombre", nombre).getResultList();
        desconectarBase();
        return editoriales;
    }
}