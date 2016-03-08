package com.pc.basic;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.transaction.annotation.Transactional;

//����ע��@Transactional�ô�����spring������������ӹܸ�Service������
@Transactional
public abstract class BasicService implements BasicServiceInter {
	// ����ĳ������������@Resource��spring������byName�ķ�ʽע������ֵ
	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public Object executeUniqueQuery(String hql, Object[] parameters) {
		// TODO Auto-generated method stub
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		
		// ��?��ֵ
		if(parameters != null && parameters.length > 0) {
			for(int i = 0; i < parameters.length; i++) {
				query.setParameter(i, parameters[i]);
			}
		}
		return query.uniqueResult();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Object findById(Class clazz, Serializable id) {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().load(clazz, id);
	}

	@Override
	public List executeQuery(String hql, Object[] parameters) {
		// TODO Auto-generated method stub
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		
		// ע��?
		if(parameters != null && parameters.length > 0) {
			for(int i = 0; i < parameters.length; i++) {
				query.setParameter(i, parameters[i]);
			}
		}
		
		return query.list();
	}

	@Override
	public List executeQueryByPage(String hql, Object[] parameters,
			int pageNow, int pageSize) {
		// TODO Auto-generated method stub
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		
		// ע��?
		if(parameters != null && parameters.length > 0) {
			for(int i = 0; i < parameters.length; i++) {
				query.setParameter(i, parameters[i]);
			}
		}
		
		// ��ҳ
		// ������ʼ��¼
		query.setFirstResult((pageNow - 1) * pageSize);
		// ����ÿҳ��¼��
		query.setMaxResults(pageSize);
		
		return query.list();
	}

	@Override
	public void add(Object object) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(object);
	}

	@Override
	public void executeUpdate(String hql, Object[] parameters) {
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		// ע��?
		if(parameters != null && parameters.length > 0) {
			for(int i = 0; i < parameters.length; i++) {
				query.setParameter(i, parameters[i]);
			}
		}
	}
	
	@Override
	public int queryPageCount(String hql, Object[] parameters, int pageSize) {
		// ��ȡrowCount
		int pageRow = Integer.parseInt(this.executeUniqueQuery(hql, parameters).toString());
		// ��ҳ��ҳ���㷨��pageSize - 1�൱���������
		return (pageRow + pageSize - 1) / pageSize;
	}

	@Override
	public void deleteById(Class clazz,Serializable id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(this.findById(clazz, id));
	}

	@Override
	public void update(Object object) {
		this.sessionFactory.getCurrentSession().update(object);
	}
}
