/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Prestamo;
import java.util.List;
import javax.persistence.EntityManager;

public class PrestamoDAO extends DAO<Prestamo> {

    @Override
    public void persistirEntidad(Prestamo prestamo) {
        super.persistirEntidad(prestamo);
    }

    @Override
    public void actualizarEntidad(Prestamo prestamo) {
        super.actualizarEntidad(prestamo);
    }

    @Override
    public void borrarEntidad(Prestamo prestamo) {
        super.borrarEntidad(prestamo);
    }

    public Prestamo buscarPrestamoId(Integer id) {
        conectarBase();
        Prestamo prestamo = EntityManager.find(Prestamo.class, id);
        desconectarBase();
        return prestamo;
    }

    public List<Prestamo> buscarPrestamoCliente(long dni) {
        conectarBase();
        List<Prestamo> prestamos = EntityManager.createQuery("SELECT P FROM Prestamo p WHERE p.cliente.documento = :dni AND p.alta = TRUE").setParameter("dni", dni).getResultList();
        desconectarBase();
        return prestamos;
    }

    
}