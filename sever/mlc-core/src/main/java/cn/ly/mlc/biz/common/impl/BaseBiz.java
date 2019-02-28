package cn.ly.mlc.biz.common.impl;

import java.util.ConcurrentModificationException;
import java.util.List;

import cn.ly.mlc.dao.common.impl.BaseDao;
import cn.ly.mlc.entity.base.BaseEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 
 * @author shidewen
 *
 */
public class BaseBiz extends cn.ly.mlc.entity.db.BaseBiz implements cn.ly.mlc.biz.common.BaseBiz {

	protected Log logger = LogFactory.getLog(getClass());

	private boolean supportCache = false;

	@Autowired
	@Qualifier("zhstBaseDao")
	private BaseDao baseDao;

	@Override
	public BusinessLogicManage getDao() {
		// TODO Auto-generated method stub
		return baseDao;
	}

	public Long getNextSequValue(String sequName) {
		return baseDao.getNextSequValue(sequName);
	}

	public void checkDatabase() {
		baseDao.checkDatabase();
	}

	public <T> T selectSingleObject(List<T> tlist) {
		if (tlist != null && tlist.size() > 0) {
			return tlist.get(0);
		}
		return null;
	}

	public Object queryScalar(String sql) {
		return baseDao.queryScalar(sql);
	}

	@Override
	public Boolean needCache(String tableName) {
		return supportCache;
	}

	@Override
	public void operatesLogSimpleAdd(String tableName, String operateName, String keyFieldName, String keyFieldValue, Object param, int updateCount) {
		if (tableName.equalsIgnoreCase("T_OPERATE_LOG")) {
			return;
		}

		super.operatesLogSimpleAdd(tableName, operateName, keyFieldName, keyFieldValue, param, updateCount);
	}

	/**
	 * @return the baseDao
	 */
	public BaseDao getBaseDao() {
		return baseDao;
	}

	/**
	 * @param baseDao the baseDao to set
	 */
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	/**
	 * @return the supportCache
	 */
	public boolean getSupportCache() {
		return supportCache;
	}

	/**
	 * @param supportCache the supportCache to set
	 */
	public void setSupportCache(boolean supportCache) {
		this.supportCache = supportCache;
	}


	@Override
	public void throwUpdateFailException(BaseEntity obj, BaseEntity objInDb) {
		if (obj == null) {
			throw new RuntimeException("数据对象为空");
		}
		int oldRowVersion = -1;
		if (obj.getRowVersion() != null) {
			oldRowVersion = obj.getRowVersion();
		}
		int dbRowVersion = -2;
		if (objInDb != null) {
			dbRowVersion = objInDb.getRowVersion();
		}
		if (oldRowVersion != dbRowVersion) {
			throw new ConcurrentModificationException("发现旧数据: version=" + oldRowVersion + ", dbversion=" + dbRowVersion);
		} else {
			throw new RuntimeException("数据更新返回 0 for:" + obj.getClass().getName());
		}
	}

}
