package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Window;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BuildingDaoCustomImpl implements BuildingDaoCustom {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Window> findAllBuildingWindows(Long id) {
        String jpql = "select w from Window w where w.room.building.id=:id";
        return em.createQuery(jpql)
                .setParameter("id", id)
                .getResultList();

    }
}
