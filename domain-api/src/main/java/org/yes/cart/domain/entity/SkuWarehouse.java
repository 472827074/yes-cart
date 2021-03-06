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

package org.yes.cart.domain.entity;

import java.math.BigDecimal;

/**
 * Hold the quantity of {@link ProductSku} on each {@link Warehouse}.
 * The sku quantity became reserved when order paid or payment confirmed.
 * Quantity changed when reserved quantity delivered to customer.
 * <p/>
 * <p/>
 * User: Igor Azarny iazarny@yahoo.com
 * Date: 07-May-2011
 * Time: 11:12:54
 */
public interface SkuWarehouse extends Auditable {

    /**
     * @return primary key
     */
    long getSkuWarehouseId();

    /**
     * Set primary key
     *
     * @param skuWarehouseId primary key
     */
    void setSkuWarehouseId(long skuWarehouseId);


    /**
     * Get the {@link Warehouse}.
     *
     * @return {@link Warehouse}
     */
    Warehouse getWarehouse();

    /**
     * Set {@link Warehouse}
     *
     * @param warehouse {@link Warehouse}
     */
    void setWarehouse(Warehouse warehouse);

    /**
     * Get SKU code.
     *
     * @return sku
     */
    String getSkuCode();

    /**
     * Set SKU code.
     *
     * @param skuCode SKU code
     */
    void setSkuCode(String skuCode);


    /**
     * Get the available quantity.
     *
     * @return available quantity.
     */
    BigDecimal getQuantity();

    /**
     * Set available quantity.
     *
     * @param quantity available quantity.
     */
    void setQuantity(BigDecimal quantity);

    /**
     * Get reserved quantity during payment transaction.
     *
     * @return reserved quantity during payment transaction.
     */
    BigDecimal getReserved();

    /**
     * Set reserved quantity during payment transaction.
     *
     * @param reserved reserved quantity during payment transaction.
     */
    void setReserved(BigDecimal reserved);

    /**
     * Returns true if has quantity and quantity is larger than reserved.
     *
     * @return true if there is quantity available to sell
     */
    boolean isAvailableToSell();

    /**
     * Returns quantity available for sale.
     *
     * @return quantity less reservations
     */
    BigDecimal getAvailableToSell();

}
