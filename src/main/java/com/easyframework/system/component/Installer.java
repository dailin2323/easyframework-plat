package com.easyframework.system.component;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.stereotype.Component;

import com.easyframework.core.base.BaseTest;
import com.easyframework.system.model.Group;
import com.easyframework.system.model.Resource;
import com.easyframework.system.model.Role;
import com.easyframework.system.model.User;
import com.easyframework.system.service.GroupService;
import com.easyframework.system.service.ResourceService;
import com.easyframework.system.service.RoleService;
import com.easyframework.system.service.UserService;

/**
 * 
 * @Title: Installer.java
 * @Description: TODO
 * @author 邹凯明
 * @date 2014-3-5 下午3:58:48
 * @最后修改人：邹凯明
 * @最后修改时间：2014-3-5 下午3:58:48
 */
@Component
public class Installer extends BaseTest {
	
	@javax.annotation.Resource
	private ResourceService resourceService;
	
	@javax.annotation.Resource
	private UserService userService;
	
	@javax.annotation.Resource
	private RoleService roleService;
	
	@javax.annotation.Resource
	private GroupService groupService;
	
	private long resourceIndex = 1L;
	
	
	@Test
	public void install(){
		logger.info("开始安装");
		this.initDB();
		this.initResource();
		this.initDict();
		this.initGroup();
		this.initRole();
		this.initUser();
		logger.info("安装完成");
	}
	
	/**
	 * 初始化数据库
	 */
	private void initDB(){		
		/** 清除用户 */
		List<User> userList = userService.findAll();
		for(User user:userList){
			user.getRoles().clear();
			user.getGroups().clear();
			userService.delete(user);
		}
		

		/** 清除组 */
		List<Group> groupList = groupService.findAll();
		for(Group group:groupList){
			groupService.delete(group);
		}
		
		/** 清楚角色 */
		List<Role> roleList = roleService.findAll();
		for(Role role:roleList){
			role.getResources().clear();
			roleService.delete(role);
		}
		
		/** 清除资源 */
		List<Resource> resourceList = resourceService.findAll();
		for(Resource resource:resourceList){
			resourceService.delete(resource);
		}
		
	}
	
	/**
	 * 初始化资源
	 */
	private void initResource(){
		Resource r1 = createResource("系统管理", "", null);
		Resource r11 = createResource("用户管理", "/user/userManagerUI", r1);
		Resource r12 = createResource("组织管理", "/group/groupManagerUI", r1);
		Resource r13 = createResource("角色管理", "/role/roleManagerUI", r1);
		Resource r14 = createResource("资源管理", "/resource/resourceManagerUI", r1);
		Resource r15 = createResource("其他", "", r1);
		
		
	}
	
	private Resource createResource(String name, String url, Resource parent){
		Resource resource = new Resource();
		resource.setName(name);
		resource.setUrl(url);
		resource.setParent(parent);
		resourceService.save(resource);
		return resource;
	}
	
	/**
	 * 初始化用户
	 */
	private void initUser(){
		User admin = new User();
		admin.setName("admin");
		admin.setPassword("admin");
		admin.setNickName("aa");
		admin.setRealName("aa");
		admin.setSex((byte) 0);
		admin.setAge(20);
		admin.setBirthday(new Date());
		/*User test1 = new User();
		test1.setName("test1");
		test1.setPassword("123654");
		
		User test2 = new User();
		test2.setName("test2");
		test2.setPassword("123654");*/
		
		userService.reg(admin);
		//userService.save(test1);
		//userService.save(test2);
	}
	
	/**
	 * 初始化角色
	 */
	private void initRole(){
		Role role1 = new Role();
		role1.setName("测试角色1");
		
		roleService.save(role1);
	}
	
	/**
	 * 初始化组
	 */
	private void initGroup(){
		Group group1 = new Group();
		group1.setName("测试组1");
		
		groupService.save(group1);
	}
	
	/**
	 * 初始化字典
	 */
	private void initDict(){
		
	}

}
