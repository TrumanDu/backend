package com.aibibang.app.service.impl;

import com.aibibang.app.common.persistence.Page;
import com.aibibang.app.domain.SysRole;
import com.aibibang.app.domain.SysRoleMenu;
import com.aibibang.app.repository.SysRoleDao;
import com.aibibang.app.repository.SysRoleMenuDao;
import com.aibibang.app.service.SysRoleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 角色管理service实现类
 */

@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {

	@Resource
	private SysRoleDao sysRoleDao;
	@Resource
	private SysRoleMenuDao sysRoleMenuDao;
	
	@Override
	public Page<SysRole> findByPage(SysRole sysRole, Page<SysRole> page) {

		page.setResult(sysRoleDao.find(sysRole, page));
		
		return page;
	}
	
	@Override
	public List<SysRole> findBySearch(SysRole sysRole) {

		return sysRoleDao.find(sysRole);
	}
	
	@Override
	public SysRole getById(Long id) {

		return sysRoleDao.getById(id);
	}

	@Override
	public void add(SysRole sysRole) {

		sysRoleDao.add(sysRole);
		
		if(StringUtils.isNotEmpty(sysRole.getMenuIds())){
			List<SysRoleMenu> roleMenuList = new ArrayList<SysRoleMenu>();
			for(String menuId : sysRole.getMenuIds().split(",")){
				if(StringUtils.isNotEmpty(menuId)){
					SysRoleMenu roleMenu = new SysRoleMenu();
					roleMenu.setMenuId(Long.parseLong(menuId));
					roleMenu.setRoleId(sysRole.getId());
					roleMenuList.add(roleMenu);
				}
			}
			if(roleMenuList.size() > 0){
				sysRoleMenuDao.batchAdd(roleMenuList);
			}
		}
	}
	
	@Override
	public void update(SysRole sysRole) {
		
		sysRoleDao.update(sysRole);
		
		// 删除旧数据
		sysRoleMenuDao.deleteByRoleId(sysRole.getId());
		
		if(StringUtils.isNotEmpty(sysRole.getMenuIds())){
			List<SysRoleMenu> roleMenuList = new ArrayList<SysRoleMenu>();
			for(String menuId : sysRole.getMenuIds().split(",")){
				if(StringUtils.isNotEmpty(menuId)){
					SysRoleMenu roleMenu = new SysRoleMenu();
					roleMenu.setMenuId(Long.parseLong(menuId));
					roleMenu.setRoleId(sysRole.getId());
					roleMenuList.add(roleMenu);
				}
			}
			if(roleMenuList.size() > 0){
				sysRoleMenuDao.batchAdd(roleMenuList);
			}
		}
	}

	@Override
	public void delete(Long id) {

		sysRoleDao.delete(id);
	}

	@Override
	public List<Long> findByRoleId(Long roleId) {
		
		return sysRoleMenuDao.findByRoleId(roleId);
	}
 	
}