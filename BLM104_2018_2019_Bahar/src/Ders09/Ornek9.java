/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ders09;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author alinizam
 */
public class Ornek9 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BLM104_2018_2019_BaharPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        String sql = "select m from Malzeme m";
        Query q = em.createQuery(sql);
        List<Malzeme> malzemeler = q.getResultList();
        for (Malzeme malzeme : malzemeler) {
            if (malzeme.getMalzemeId() == 5) {
                malzeme.setAdi("Çatal");
            }
            System.out.println(malzeme.getAdi() + " " + malzeme.getTuru());
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
