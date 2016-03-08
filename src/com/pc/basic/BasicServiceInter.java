package com.pc.basic;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author Switch
 * @function ��������ӿ�
 * @description
 *
 */
public interface BasicServiceInter {
	
	/**
	 * ͨ��ID��ȡ����
	 * @param clazz �����
	 * @param id ID
	 * @return ����
	 */
	public Object findById(Class clazz, Serializable id);
	
	/**
	 * ��ѯ
	 * @param hql hql���
	 * @param parameters �����б�
	 * @return �����
	 */
	public List executeQuery(String hql, Object[] parameters);

	/**
	 * ��ҳ��ѯ
	 * @param hql hql���
	 * @param parameters �����б�
	 * @param pageNow ��ǰҳ
	 * @param pageSize ÿҳ��С
	 * @return ��ҳ�����
	 */
	public List executeQueryByPage(String hql, Object[] parameters, int pageNow, int pageSize);
	
	/**
	 * ��Ӷ���
	 * @param object ����
	 */
	public void add(Object object);
	
	/**
	 * ͳһ����ɾ�Ĳ���
	 * @param hql hql���
	 * @param parameters �����б�
	 * @return �����
	 */
	public void executeUpdate(String hql, Object[] parameters);
	
	/**
	 * ���ص�������Ĳ�ѯ
	 * @param hql hql���
	 * @param parameters �����б�
	 * @return ����
	 */
	public Object executeUniqueQuery(String hql, Object[] parameters);
	
	/**
	 * ��ѯҳ��
	 * @param hql hql���
	 * @param parameters �����б�
	 * @param pageSize ҳ��
	 * @return ҳ��
	 */
	public int queryPageCount(String hql, Object[] parameters, int pageSize);
	
	/**
	 * ͨ��ID��ɾ������
	 * @param clazz �����
	 * @param id ID
	 */
	public void deleteById(Class clazz,Serializable id);
	
	/**
	 * ͨ����������޸�
	 * @param object ����
	 */
	public void update(Object object);
}
