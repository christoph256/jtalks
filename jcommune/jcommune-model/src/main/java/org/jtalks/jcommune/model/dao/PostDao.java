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
package org.jtalks.jcommune.model.dao;

import org.jtalks.jcommune.model.dao.hibernate.PostHibernateDao;
import org.jtalks.jcommune.model.entity.Post;

/**
 * Interface allows to make basic CRUD operations with the 
 * {@link Post} objects. 
 * At the current moment it doesn't provides any additional methods over the basic {@link Dao} interface
 * but some specific methods will be added soon.
 * @see PostHibernateDao
 * 
 * @author Pavel Vervenko
 */
public interface PostDao extends Dao<Post> {
    
}
