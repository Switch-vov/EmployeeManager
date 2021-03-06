package com.pc.basic;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author Switch
 * @function 基础服务接口
 * @description
 *
 */
public interface BasicServiceInter {
	
	/**
	 * 通过ID获取对象
	 * @param clazz 类对象
	 * @param id ID
	 * @return 对象
	 */
	public Object findById(Class clazz, Serializable id);
	
	/**
	 * 查询
	 * @param hql hql语句
	 * @param parameters 参数列表
	 * @return 结果集
	 */
	public List executeQuery(String hql, Object[] parameters);

	/**
	 * 分页查询
	 * @param hql hql语句
	 * @param parameters 参数列表
	 * @param pageNow 当前页
	 * @param pageSize 每页大小
	 * @return 分页结果集
	 */
	public List executeQueryByPage(String hql, Object[] parameters, int pageNow, int pageSize);
	
	/**
	 * 添加对象
	 * @param object 对象
	 */
	public void add(Object object);
	
	/**
	 * 统一的增删改操作
	 * @param hql hql语句
	 * @param parameters 参数列表
	 * @return 结果集
	 */
	public void executeUpdate(String hql, Object[] parameters);
	
	/**
	 * 返回单个对象的查询
	 * @param hql hql语句
	 * @param parameters 参数列表
	 * @return 对象
	 */
	public Object executeUniqueQuery(String hql, Object[] parameters);
	
	/**
	 * 查询页数
	 * @param hql hql语句
	 * @param parameters 参数列表
	 * @param pageSize 页长
	 * @return 页数
	 */
	public int queryPageCount(String hql, Object[] parameters, int pageSize);
	
	/**
	 * 通过ID号删除对象
	 * @param clazz 类对象
	 * @param id ID
	 */
	public void deleteById(Class clazz,Serializable id);
	
	/**
	 * 通过对象进行修改
	 * @param object 对象
	 */
	public void update(Object object);
}
