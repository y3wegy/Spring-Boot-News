package com.y3wegy.web.provider.service.web;


import com.y3wegy.base.web.bean.web.MenuDto;

import java.util.List;

/**
 * @author y3wegy
 */
public interface MenuService {

    /**
     * -------------------------------------------------------------
     * @author     @date        @comment
     * Chen, Rui   1/29/2019     init version
     * -------------------------------------------------------------
     * @return
     */
    List<MenuDto> getMenuData();
}