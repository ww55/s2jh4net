/**
 * Copyright © 2015 - 2017 EntDIY JavaEE Development Framework
 *
 * Site: https://www.entdiy.com, E-Mail: xautlx@hotmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package xyz.entdiy.dev.demo.service;

import com.entdiy.core.service.BaseService;
import com.entdiy.core.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.entdiy.dev.demo.dao.DemoOrderDao;
import xyz.entdiy.dev.demo.entity.DemoOrder;

@Service
@Transactional
public class DemoOrderService extends BaseService<DemoOrder, Long> {

    @Autowired
    private DemoOrderDao orderDao;

    public DemoOrder submitOrder(DemoOrder entity) {
        entity.setSubmitTime(DateUtils.currentDateTime());
        return orderDao.save(entity);
    }
    
    public DemoOrder payOrder(DemoOrder entity) {
        entity.setPayTime(DateUtils.currentDateTime());
        return orderDao.save(entity);
    }
}
