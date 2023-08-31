/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DAO<T> {

    private final EntityManagerFactory emf;
    protected EntityManager EntityManager;
    
    public DAO() {
        this.emf = Persistence.createEntityManagerFactory("Jpa1LibreriaPU");
        this.EntityManager = emf.createEntityManager();
    }

    protected void conectarBase() {
        if (!EntityManager.isOpen()) {
            EntityManager = emf.createEntityManager();
        }
    }

    protected void desconectarBase() {
        if (EntityManager.isOpen()) {
            EntityManager.close();
        }
    }

    protected void persistirEntidad(T object) {
        try {
            conectarBase();
            EntityManager.getTransaction().begin();
            EntityManager.persist(object);
            EntityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("No se pudo cargar");
            if (EntityManager.getTransaction().isActive()) {
                EntityManager.getTransaction().rollback();
            }
        } finally {
            desconectarBase();
        }
    }

    protected void actualizarEntidad(T object) {
        try {
            conectarBase();
            EntityManager.getTransaction().begin();
            EntityManager.merge(object);
            EntityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("No se pudo actualizar");
            if (EntityManager.getTransaction().isActive()) {
                EntityManager.getTransaction().rollback();
            }
        } finally {
            desconectarBase();
        }
    }

    protected void borrarEntidad(T object) {
        try {
            conectarBase();
            EntityManager.getTransaction().begin();
            EntityManager.remove(object);
            EntityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("No se pudo borrar");
            if (EntityManager.getTransaction().isActive()) {
                EntityManager.getTransaction().rollback();
            }
        } finally {
            desconectarBase();
        }
    }
}