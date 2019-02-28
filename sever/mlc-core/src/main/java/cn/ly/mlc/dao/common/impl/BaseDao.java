package cn.ly.mlc.dao.common.impl;

import org.springframework.stereotype.Repository;

import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author ly
 * 
 */
@Repository("mlcBaseDao")
public class BaseDao implements cn.ly.mlc.dao.common.BaseDao {

	protected org.apache.commons.logging.Log logger = org.apache.commons.logging.LogFactory.getLog(getClass());


	public String getPageSql(String sql, int beginRow, int endRow, String order) {
		return "select * from (" + sql + ") TTT___ order by " + order + " limit " + beginRow + "," + (endRow - beginRow);
	}

	private static Hashtable<Class, Hashtable<String, Method>> objMetaList = new Hashtable<Class, Hashtable<String, Method>>();

	private Method getObjSetMethod(Class type, String fieldName) {
		Hashtable<String, Method> methodList = objMetaList.get(type);
		if (methodList == null) {
			synchronized (objMetaList) {
				methodList = objMetaList.get(type);
				if (methodList == null) {
					methodList = new Hashtable<String, Method>();
					// create
					Method[] methods = type.getMethods();
					for (Method method : methods) {
						if (method.getName().startsWith("set") && (method.getParameterTypes().length == 1)) {
							String key = method.getName().toLowerCase().substring(3);
							if (!methodList.containsKey(key)) {
								methodList.put(key, method);
							}
							// if(method.getParameterTypes()[0] == boolean.class){
							//
							// }
						}
					}
					objMetaList.put(type, methodList);
				}
			}
		}
		String fieldKey = fieldName.toLowerCase().replaceAll("_", "");
		if (methodList.containsKey(fieldKey)) {
			return methodList.get(fieldKey);
		} else {
			if (fieldKey.startsWith("is")) {
				fieldKey = fieldKey.substring(2);
				if (methodList.containsKey(fieldKey)) {
					return methodList.get(fieldKey);
				}
			}
			return null;
		}
	}

	private void readObj(Object obj, Map<String, Object> data) {
		for (String key : data.keySet()) {
			String fieldName = key;
			Method method = getObjSetMethod(obj.getClass(), fieldName);
			if (method != null) {
				try {
					method.invoke(obj, data.get(key));
				} catch (Exception e) {
					logger.error(e.getMessage(), e);
				}
			} else {
				logger.warn("can't read " + fieldName + " value");
			}
		}

	}



}
