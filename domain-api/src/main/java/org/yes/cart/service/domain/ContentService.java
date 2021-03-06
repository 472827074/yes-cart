/*
 * Copyright 2009 Denys Pavlov, Igor Azarnyi
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.yes.cart.service.domain;

import org.yes.cart.domain.entity.Category;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * User: Denis Pavlov
 * Date: 27-June-2013
 */
public interface ContentService extends GenericService<Category> {

    /**
     * Get the root content for shop.
     *
     * @param shopId PK of shop
     *
     * @return root content (or null).
     */
    Category getRootContent(long shopId);

    /**
     * Create root content for shop.
     *
     * @param shopId PK of shop
     *
     * @return root content.
     */
    Category createRootContent(final long shopId);

    /**
     * Get the "template variation" template (No fail over).
     *
     * @param contentId given content PK
     * @return Template variation
     */
    String getContentTemplate(long contentId);


    /**
     * Get the child content without recursion, only one level down.
     *
     * @param contentId given parent content PK
     * @return list of child content
     */
    List<Category> getChildContent(long contentId);

    /**
     * Get the child content without recursion, only one level down.
     *
     * @param contentId        given parent content PK
     * @param withAvailability with availability date range filtering or not
     * @return list of child content
     */
    List<Category> findChildContentWithAvailability(long contentId, boolean withAvailability);

    /**
     * Get the child contents with recursion.
     * Content from parameter will be included also.
     *
     * @param contentId given contentId
     * @return list of child content
     */
    Set<Category> getChildContentRecursive(long contentId);

    /**
     * Get content body for a particular content.
     * See CONTENT_BODY setting.
     *
     * @param contentId content id
     * @param locale locale to get body for
     *
     * @return body or null if none exists for this locale or if content is not available
     */
    String getContentBody(long contentId, String locale);

    /**
     * Get content body for a particular content.
     * See CONTENT_BODY setting.
     *
     * @param contentUri content URI
     * @param locale locale to get body for
     *
     * @return body or null if none exists for this locale or if content is not available
     */
    String getContentBody(String contentUri, String locale);

    /**
     * Get content body for a particular content.
     * See CONTENT_BODY setting.
     *
     * @param contentId content id
     * @param locale locale to get body for
     * @param context runtime content passed from web module (e.g. current category, product, shopping cart etc)
     *
     * @return body or null if none exists for this locale or if content is not available
     */
    String getDynamicContentBody(long contentId, String locale, Map<String, Object> context);

    /**
     * Get content body for a particular content.
     * See CONTENT_BODY setting.
     *
     * @param contentUri content URI
     * @param locale locale to get body for
     * @param context runtime content passed from web module (e.g. current category, product, shopping cart etc)
     *
     * @return body or null if none exists for this locale or if content is not available
     */
    String getDynamicContentBody(String contentUri, String locale, Map<String, Object> context);


    /**
     * Get the value of given attribute. If value not present in given content
     * failover to parent content will be used.
     *
     *
     * @param locale        locale for localised value (or null for raw value)
     * @param contentId     given content
     * @param attributeName attribute name
     * @param defaultValue  default value will be returned if value not found in hierarchy
     * @return value of given attribute name or defaultValue if value not found in content hierarchy
     */
    String getContentAttributeRecursive(String locale, long contentId, String attributeName, String defaultValue);

    /**
     * Get the values of given attributes. If value not present in given category
     * failover to parent category will be used.  In case if attribute value for first
     * attribute will be found, the rest values also will be collected form the same category.
     *
     *
     * @param locale         locale for localised value (or null for raw value)
     * @param contentId      given content
     * @param attributeNames set of attributes, to collect values.
     * @return value of given attribute name or defaultValue if value not found in category hierarchy
     */
    String[] getContentAttributeRecursive(final String locale, long contentId, String[] attributeNames);

    /**
     * Get category by id.
     *
     * @param categoryId given category id
     * @return category
     */
    Category getById(long categoryId);

    /**
     * Get content id by given seo uri
     *
     * @param seoUri given seo uri
     * @return content id if found otherwise null
     */
    Long findContentIdBySeoUri(String seoUri);

    /**
     * Get content id by given GUID
     *
     * @param guid given GUID
     * @return content id if found otherwise null
     */
    Long findContentIdByGUID(String guid);

    /**
     * Get content SEO uri by given id
     *
     * @param contentId given content id
     * @return seo uri if found otherwise null
     */
    String findSeoUriByContentId(Long contentId);

    /**
     * Does given sub content belong to tree with given parent <code>topContent</code>.
     *
     * @param topContentId given root for content tree.
     * @param subContentId candidate to check.
     *
     * @return true in case if content belongs to tree that starts from <code>topContent</code>
     */
    boolean isContentHasSubcontent(long topContentId, long subContentId);


}
