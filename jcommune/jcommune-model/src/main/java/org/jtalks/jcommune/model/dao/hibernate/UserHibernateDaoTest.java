/*
 * JTalks for uniting people
 * Copyright (C) 2011  JavaTalks Team
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 * Also add information on how to contact you by electronic and paper mail.
 *
 * This file creation date: Apr 12, 2011 / 8:05:19 PM
 * The JTalks Project
 * http://www.jtalks.org
 */

package org.jtalks.jcommune.model.dao.hibernate;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.jtalks.jcommune.model.entity.Persistent;
import org.jtalks.jcommune.model.entity.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * DAO tests for instance of {@link UserHibernateDao}
 *
 * @author Artem Mamchych
 */
public class UserHibernateDaoTest extends BaseTest {

    /**
     * Hibernate Session Factory instance.
     */
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    private UserHibernateDao dao;
    private User entity;
    private List<Persistent> listAll;

    @Before
    public void setUp() throws Exception {
        dao = new UserHibernateDao();
        dao.setSessionFactory(sessionFactory);
        entity = new User();
        entity.setFirstName("FirstName");
        entity.setLastName("LastName");
        entity.setNickName("NickName");

        //Clear DB table
        Query query = sessionFactory.getCurrentSession().createQuery("delete "
                + entity.getClass().getSimpleName());
        query.executeUpdate();
    }

    @After
    public void tearDown() throws Exception {
        entity = null;
    }

    @Test
    public void testEntityState() throws Exception {
        testSave();
        listAll = dao.getAll();
        Assert.assertTrue(PERSISTENCE_ERROR, entity.equals(listAll.get(0)));
        Assert.assertFalse(PERSISTENCE_ERROR, entity.equals(listAll.get(1)));
    }

    @Test
    public void testDBEmpty() throws Exception {
        int sizeBefore = dao.getAll().size();
        Assert.assertEquals(DB_TABLE_NOT_EMPTY, 0, sizeBefore);
    }

    @Test
    public void testSave() throws Exception {
        //Add 2 users to DB
        dao.saveOrUpdate(entity);
        dao.saveOrUpdate(new User());

        int size = dao.getAll().size();
        Assert.assertEquals(ENTITIES_IS_NOT_INCREASED_BY_2, 2, size);
    }

    @Test
    public void testDelete() throws Exception {
        testSave();
        listAll = dao.getAll();
        int size = listAll.size();
        Assert.assertEquals(DB_MUST_BE_NOT_EMPTY, 2, size);

        for (Persistent p : listAll) {
            dao.delete(p);
        }
        testDBEmpty();
    }

    @Test
    public void testDeleteById() throws Exception {
        testSave();
        listAll = dao.getAll();
        int size = listAll.size();
        Assert.assertEquals(DB_MUST_BE_NOT_EMPTY, 2, size);

        for (Persistent p : listAll) {
            dao.delete(p.getId());
        }
        testDBEmpty();
    }

    @Test
    public void testGetById() throws Exception {
        testSave();
        listAll = dao.getAll();
        int size = listAll.size();
        Assert.assertEquals(DB_MUST_BE_NOT_EMPTY, 2, size);

        for (Persistent p : listAll) {
            dao.delete(dao.get(p.getId()));
        }
        testDBEmpty();
    }

    @Test
    public void testGetAll() throws Exception {
        dao.saveOrUpdate(entity);

        int size = dao.getAll().size();
        Assert.assertEquals(ENTITIES_IS_NOT_INCREASED_BY_1, 1, size);
    }

    @Test
    public void testUpdate() throws Exception {
        dao.saveOrUpdate(entity);
        dao.saveOrUpdate(entity);
        dao.saveOrUpdate(entity);

        int size = dao.getAll().size();
        Assert.assertEquals(ENTITIES_IS_NOT_INCREASED_BY_1, 1, size);
    }
}
