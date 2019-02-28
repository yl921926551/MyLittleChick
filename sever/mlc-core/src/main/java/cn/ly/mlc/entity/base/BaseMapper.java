package cn.ly.mlc.entity.base;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author shidewen
 *
 */
public interface BaseMapper {
	Long getNextSequValue(String sequName);
	Long checkDatabase();
	Long queryCount(String sql);
	Object queryScalar(String sql);
	List<Map<String, Object>> queryResult(String sql);
}
