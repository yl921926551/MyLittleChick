package cn.ly.mlc.entity.common;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import common.util.TwoTuple;
import topdeep.common.entity.base.BeanFieldAttribute;

/**
 * 网关接口数据字典类型定义
 */
public class BaseInfoType extends topdeep.common.entity.constant.BaseInfoType {
	private static Log logger = LogFactory.getLog(BaseInfoType.class);

	private static Object syncObj = new Object();

	/**
	 * 网关接口错误码
	 */
	public static String GATEWAY_ERROR_CODE = "101";

	/**
	 * 门店面积分类
	 */
	public static String AREA_SIZE_TYPE = "102";


	private static List<TwoTuple<String, String>> typeList = null;

	public static List<TwoTuple<String, String>> getTypeList() {
		if (typeList == null) {
			synchronized (syncObj) {
				if (typeList == null) {
					typeList = new ArrayList<TwoTuple<String, String>>();
					Class<?> type = BaseInfoType.class;
					Field[] fields = type.getDeclaredFields();
					for (Field item : fields) {
						BeanFieldAttribute attr = item.getAnnotation(BeanFieldAttribute.class);
						if (attr != null) {
							try {
								String value = (String) item.get(null);
								typeList.add(new TwoTuple<String, String>(value, attr.Name()));
							} catch (Exception e) {
								logger.error("baseInfoType getTypeList error " + attr.Name() + ": ", e);
							}
						}
					}
				}
			}
		}
		return typeList;
	}

}
