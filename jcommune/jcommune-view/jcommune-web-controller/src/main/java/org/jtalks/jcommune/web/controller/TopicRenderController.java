/**
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
 */

package org.jtalks.jcommune.web.controller;

import org.jtalks.jcommune.model.entity.Topic;
import org.jtalks.jcommune.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * TopicRenderController handles GET and POST request with /topics/{topicId} Uri,
 * where topicId could be from 1 to infinity. Controller displays selected topic.
 * Class throws no exceptions
 *
 * @author Kravchenko Vitaliy
 */

@Controller
public final class TopicRenderController {

    private final TopicService topicService;

    /**
     * Constructor creates MVC controller with specifying TopicService,
     * parameter passed via autowiring
     *
     * @param topicService the objects that represents work Topic entity
     * @see TopicService
     * @see Topic
     */
    @Autowired
    public TopicRenderController(TopicService topicService) {
        this.topicService = topicService;
    }

    /**
     * Method handles GET requests with URI - /topics/{topicId},
     * where {topicId} could be an integer value from 1 to infinity
     *
     * @param topicID the Id os selected Topic
     * @return ModelAndView object which has "renderTopic" as view name and object that represent selected Topic
     */
    @RequestMapping(value = "/topics/{topicId}", method = RequestMethod.GET)
    public ModelAndView showTopic(@PathVariable("topicId") long topicID) {
        Topic selectedTopic = topicService.getTopic(topicID, true);
        ModelAndView mav = new ModelAndView("renderTopic");
        mav.addObject("selectedTopic", selectedTopic);
        return mav;
    }
}
