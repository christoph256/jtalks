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
package org.jtalks.jcommune.service;

import org.jtalks.jcommune.model.entity.Topic;

/**
 * This interface should have methods which give us more abilities in manipulating Topic persistent entity.
 * 
 * @author Osadchuck Eugeny
 *
 */
public interface TopicService extends EntityService<Topic> {
	
	/**
	 * Get topic with fetched topics fields(userCreated, posts).
	 * By default method fetch only userCReated field. If you need fetch topic with posts you should set parameter isLoadPosts to true.
	 * @param id - topic primary id.
	 * @param isLoadPosts - set to true if you want fetch topic with posts, false fetch topic with userCreated field only
	 * @return - <code>Topic<code> with fetched topic fields or null if no topic found by this primary id. 
	 */
	Topic getTopic(long id, boolean isLoadPosts);
	
}
