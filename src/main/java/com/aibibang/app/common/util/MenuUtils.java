package com.aibibang.app.common.util;

import com.aibibang.app.domain.SysMenu;
import org.apache.commons.lang.StringUtils;

import java.util.List;

public class MenuUtils {


    public static String getMenu(List<SysMenu> menuList, List<Long> userMenus) {

        StringBuilder sb = new StringBuilder();

        if (menuList != null && menuList.size() > 0) {

            for (SysMenu menu : menuList) {

                if (userMenus.contains(menu.getId())) {
                    int childNum = menu.getChildren().size();

                    sb.append("<li>\n")
                            .append("<a href=\"javascript:;\" ");
                    if (StringUtils.isNotEmpty(menu.getMenuUrl()) && childNum == 0) {
                        sb.append("onclick=\"menu(this,'"+menu.getMenuUrl()+"')\"");
                    }
                    sb.append(">\n")
                            .append("<i class=\"" + menu.getMenuIcon() + "\"></i>\n")
                            .append( menu.getMenuName() + "\n");
                    if (childNum > 0) {
                        sb.append("<span class=\"fa fa-chevron-down\"></span>\n");
                    }
                    sb.append("</a>\n");
                    if (childNum > 0) {
                        sb.append(getChildren(menu.getChildren(), userMenus));
                    }
                    sb.append("</li>\n");
                }
            }
        }

        return sb.toString();
    }

    public static String getChildren(List<SysMenu> menuList, List<Long> userMenus) {
        StringBuilder sb = new StringBuilder();

        sb.append("<ul class=\"nav child_menu\">\n");

        for (SysMenu menu : menuList) {

            if (userMenus.contains(menu.getId())) {
                int childNum = menu.getChildren().size();

                sb.append("<li>\n")
                        .append("<a href=\"javascript:;\"  ");
                if (StringUtils.isNotEmpty(menu.getMenuUrl()) && childNum == 0) {
                    sb.append("onclick=\"menu(this,'"+menu.getMenuUrl()+"')\"");
                }
                sb.append(">\n")
                        .append("<i class=\"" + menu.getMenuIcon() + "\"></i>\n")
                        .append( menu.getMenuName() + "\n");
                if (childNum > 0) {
                    sb.append("<span class=\"fa fa-chevron-down\"></span>\n");
                }
                sb.append("</a>\n");
                if (childNum > 0) {
                    sb.append(getChildren(menu.getChildren(), userMenus));
                }
                sb.append("</li>\n");
            }
        }

        sb.append("</ul>");

        return sb.toString();
    }
}
