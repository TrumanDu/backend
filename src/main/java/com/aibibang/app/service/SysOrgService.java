package com.aibibang.app.service;

import com.aibibang.app.domain.SysOrg;

import java.util.List;

public interface SysOrgService {

	public List<SysOrg> find(SysOrg org);
	
	public List<SysOrg> findForTreeTable(Long parentId);
	
	public SysOrg getById(Long id);
	
	public void add(SysOrg org);
	
	public void update(SysOrg org);
	
	public void delete(Long id);
}
