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
package org.jtalks.jcommune.service.transactional;

import org.jtalks.jcommune.model.dao.Dao;
import org.jtalks.jcommune.model.entity.User;
import org.jtalks.jcommune.service.UserService;

/**
 * User service class. This class contains method needed to manipulate with User persistent entity.
 *  
 * @author Osadchuck Eugeny
 *
 */
public class TransactionalUserService extends AbstractTransactionlaEntityService<User> implements UserService{

	/**
	 * Create an instance of User entity based service
	 * @param dao - data access object, which should be able do all CRUD operations with user entity. 
	 */
	public TransactionalUserService(Dao<User> dao) {
		super(dao);
	}

}
