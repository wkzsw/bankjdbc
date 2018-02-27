package com.feicuiedu.dao;

import java.util.List;
import java.util.Map;
/**
 * 创建jdbc方法接口
 * @author www.99071491
 *
 * @param <T>
 */
public interface UserDao<T> {
	//添加
	public void save(T t) throws Exception;
	//删除
	public void delete(Object id, Class<T> clazz) throws Exception;
    //更改
	public void update(T t) throws Exception;
    //获取
	public T get(Object id, Class<T> clazz) throws Exception;

	/**
	 * 根据条件查询
	 * 
	 * @param sqlWhereMap
	 *            key：条件字段名 value：条件字段值
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public List<T> findAllByConditions(Map<String, Object> sqlWhereMap, Class<T> clazz) throws Exception;
	

}
