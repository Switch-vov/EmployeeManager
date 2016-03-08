package com.pc.service.interfaces;

import java.io.Serializable;
import java.util.List;

import com.pc.basic.BasicServiceInter;
import com.pc.domain.Employee;

/**
 * 
 * @author Switch
 * @function ��Ա����ӿ�
 * @description
 *
 */
public interface EmployeeServiceInter extends BasicServiceInter{
	/**
	 * ��֤,�ù�Ա���ڣ��򷵻ظù�Ա��������Ϣ�����򷵻ؿ�
	 * @param employee �������ֻ����Ա�˺�����Ĺ�Ա����
	 * @return ��������Ϣ��Ա������
	 */
	public Employee checkEmployee(Employee employee);
	
	/**
	 * ��ʾ��Ա�б����Ƿ�ҳ
	 * @return ��Ա�б�
	 */
	public List<Employee> showEmployeeList(int pageNow, int pageSize);
	
	/**
	 * ͨ��ҳ����ȡҳ��
	 * @param pageSize ҳ��
	 * @return ҳ��
	 */
	public int getPageCount(int pageSize);
	
}
