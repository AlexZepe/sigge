/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.TbEmbarque;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author aspire e 14
 */
@Stateless
public class TbEmbarqueFacade extends AbstractFacade<TbEmbarque> {

    @PersistenceContext(unitName = "siggePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbEmbarqueFacade() {
        super(TbEmbarque.class);
    }
    
}
