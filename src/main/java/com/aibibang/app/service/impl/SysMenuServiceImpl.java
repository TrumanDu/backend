package com.aibibang.app.service.impl;

import com.aibibang.app.domain.SysMenu;
import com.aibibang.app.repository.SysMenuDao;
import com.aibibang.app.service.SysMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {

    @Resource
    private SysMenuDao sysMenuDao;

    @Override
    public List<SysMenu> find(SysMenu menu) {

        return sysMenuDao.find(menu);
    }

    @Override
    public List<SysMenu> getByParentId(Long parentId) {

        return sysMenuDao.getByParentId(parentId);
    }

    @Override
    public SysMenu getById(Long id) {

        return sysMenuDao.getById(id);
    }

    @Override
    public void add(SysMenu menu) {

        sysMenuDao.add(menu);
    }

    @Override
    public void update(SysMenu menu) {

        sysMenuDao.update(menu);
    }

    @Override
    public void delete(Long id) {

        deleteChildren(id);
        sysMenuDao.delete(id);
    }

    public void deleteChildren(Long id) {
        SysMenu param = new SysMenu();
        param.setParentId(id);
        List<SysMenu> children = sysMenuDao.find(param);
        if (children != null && children.size() > 0) {
            for (SysMenu child : children) {
                deleteChildren(child.getId());
            }
            sysMenuDao.deleteByParentId(id);
        }
    }

    @Override
    public List<SysMenu> findForTreeTable(Long parentId) {

        return sysMenuDao.findForTreeTable(parentId);
    }

}
