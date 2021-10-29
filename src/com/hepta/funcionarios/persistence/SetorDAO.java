package com.hepta.funcionarios.persistence;

import com.hepta.funcionarios.entity.Setor;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class SetorDAO {
    public List<Setor> getAll() throws Exception {
        EntityManager em = HibernateUtil.getEntityManager();
        List<Setor> Setores = new ArrayList<>();
        try {
            Query query = em.createQuery("FROM Setor");
            Setores = query.getResultList();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception(e);
        } finally {
            em.close();
        }
        return Setores;
    }
}
