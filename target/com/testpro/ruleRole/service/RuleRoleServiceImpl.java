package com.testpro.ruleRole.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.ruleRole.service.spi.IRuleRoleService;

/**
 * Service Implementation:RuleRole
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class RuleRoleServiceImpl extends MyBatisServiceSupport implements IRuleRoleService {
	
}