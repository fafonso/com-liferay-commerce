/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.commerce.product.model.impl;

import com.liferay.commerce.product.model.CPFriendlyURLEntry;
import com.liferay.commerce.product.model.CPFriendlyURLEntryModel;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the CPFriendlyURLEntry service. Represents a row in the &quot;CPFriendlyURLEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>CPFriendlyURLEntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CPFriendlyURLEntryImpl}.
 * </p>
 *
 * @author Marco Leo
 * @see CPFriendlyURLEntryImpl
 * @generated
 */
public class CPFriendlyURLEntryModelImpl
	extends BaseModelImpl<CPFriendlyURLEntry>
	implements CPFriendlyURLEntryModel {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cp friendly url entry model instance should use the <code>CPFriendlyURLEntry</code> interface instead.
	 */
	public static final String TABLE_NAME = "CPFriendlyURLEntry";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"CPFriendlyURLEntryId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"classNameId", Types.BIGINT}, {"classPK", Types.BIGINT},
		{"languageId", Types.VARCHAR}, {"urlTitle", Types.VARCHAR},
		{"main", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("CPFriendlyURLEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("classNameId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("classPK", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("languageId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("urlTitle", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("main", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table CPFriendlyURLEntry (uuid_ VARCHAR(75) null,CPFriendlyURLEntryId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,classNameId LONG,classPK LONG,languageId VARCHAR(75) null,urlTitle VARCHAR(255) null,main BOOLEAN)";

	public static final String TABLE_SQL_DROP = "drop table CPFriendlyURLEntry";

	public static final String ORDER_BY_JPQL =
		" ORDER BY cpFriendlyURLEntry.classNameId ASC, cpFriendlyURLEntry.classPK ASC, cpFriendlyURLEntry.urlTitle ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY CPFriendlyURLEntry.classNameId ASC, CPFriendlyURLEntry.classPK ASC, CPFriendlyURLEntry.urlTitle ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.commerce.product.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.com.liferay.commerce.product.model.CPFriendlyURLEntry"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.commerce.product.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.com.liferay.commerce.product.model.CPFriendlyURLEntry"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.commerce.product.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.com.liferay.commerce.product.model.CPFriendlyURLEntry"),
		true);

	public static final long CLASSNAMEID_COLUMN_BITMASK = 1L;

	public static final long CLASSPK_COLUMN_BITMASK = 2L;

	public static final long COMPANYID_COLUMN_BITMASK = 4L;

	public static final long GROUPID_COLUMN_BITMASK = 8L;

	public static final long LANGUAGEID_COLUMN_BITMASK = 16L;

	public static final long MAIN_COLUMN_BITMASK = 32L;

	public static final long URLTITLE_COLUMN_BITMASK = 64L;

	public static final long UUID_COLUMN_BITMASK = 128L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.commerce.product.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.commerce.product.model.CPFriendlyURLEntry"));

	public CPFriendlyURLEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _CPFriendlyURLEntryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCPFriendlyURLEntryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _CPFriendlyURLEntryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CPFriendlyURLEntry.class;
	}

	@Override
	public String getModelClassName() {
		return CPFriendlyURLEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CPFriendlyURLEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CPFriendlyURLEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CPFriendlyURLEntry, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CPFriendlyURLEntry)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CPFriendlyURLEntry, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CPFriendlyURLEntry, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CPFriendlyURLEntry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CPFriendlyURLEntry, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CPFriendlyURLEntry, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CPFriendlyURLEntry>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CPFriendlyURLEntry.class.getClassLoader(), CPFriendlyURLEntry.class,
			ModelWrapper.class);

		try {
			Constructor<CPFriendlyURLEntry> constructor =
				(Constructor<CPFriendlyURLEntry>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<CPFriendlyURLEntry, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CPFriendlyURLEntry, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CPFriendlyURLEntry, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<CPFriendlyURLEntry, Object>>();
		Map<String, BiConsumer<CPFriendlyURLEntry, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<CPFriendlyURLEntry, ?>>();

		attributeGetterFunctions.put(
			"uuid",
			new Function<CPFriendlyURLEntry, Object>() {

				@Override
				public Object apply(CPFriendlyURLEntry cpFriendlyURLEntry) {
					return cpFriendlyURLEntry.getUuid();
				}

			});
		attributeSetterBiConsumers.put(
			"uuid",
			new BiConsumer<CPFriendlyURLEntry, Object>() {

				@Override
				public void accept(
					CPFriendlyURLEntry cpFriendlyURLEntry, Object uuid) {

					cpFriendlyURLEntry.setUuid((String)uuid);
				}

			});
		attributeGetterFunctions.put(
			"CPFriendlyURLEntryId",
			new Function<CPFriendlyURLEntry, Object>() {

				@Override
				public Object apply(CPFriendlyURLEntry cpFriendlyURLEntry) {
					return cpFriendlyURLEntry.getCPFriendlyURLEntryId();
				}

			});
		attributeSetterBiConsumers.put(
			"CPFriendlyURLEntryId",
			new BiConsumer<CPFriendlyURLEntry, Object>() {

				@Override
				public void accept(
					CPFriendlyURLEntry cpFriendlyURLEntry,
					Object CPFriendlyURLEntryId) {

					cpFriendlyURLEntry.setCPFriendlyURLEntryId(
						(Long)CPFriendlyURLEntryId);
				}

			});
		attributeGetterFunctions.put(
			"groupId",
			new Function<CPFriendlyURLEntry, Object>() {

				@Override
				public Object apply(CPFriendlyURLEntry cpFriendlyURLEntry) {
					return cpFriendlyURLEntry.getGroupId();
				}

			});
		attributeSetterBiConsumers.put(
			"groupId",
			new BiConsumer<CPFriendlyURLEntry, Object>() {

				@Override
				public void accept(
					CPFriendlyURLEntry cpFriendlyURLEntry, Object groupId) {

					cpFriendlyURLEntry.setGroupId((Long)groupId);
				}

			});
		attributeGetterFunctions.put(
			"companyId",
			new Function<CPFriendlyURLEntry, Object>() {

				@Override
				public Object apply(CPFriendlyURLEntry cpFriendlyURLEntry) {
					return cpFriendlyURLEntry.getCompanyId();
				}

			});
		attributeSetterBiConsumers.put(
			"companyId",
			new BiConsumer<CPFriendlyURLEntry, Object>() {

				@Override
				public void accept(
					CPFriendlyURLEntry cpFriendlyURLEntry, Object companyId) {

					cpFriendlyURLEntry.setCompanyId((Long)companyId);
				}

			});
		attributeGetterFunctions.put(
			"userId",
			new Function<CPFriendlyURLEntry, Object>() {

				@Override
				public Object apply(CPFriendlyURLEntry cpFriendlyURLEntry) {
					return cpFriendlyURLEntry.getUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"userId",
			new BiConsumer<CPFriendlyURLEntry, Object>() {

				@Override
				public void accept(
					CPFriendlyURLEntry cpFriendlyURLEntry, Object userId) {

					cpFriendlyURLEntry.setUserId((Long)userId);
				}

			});
		attributeGetterFunctions.put(
			"userName",
			new Function<CPFriendlyURLEntry, Object>() {

				@Override
				public Object apply(CPFriendlyURLEntry cpFriendlyURLEntry) {
					return cpFriendlyURLEntry.getUserName();
				}

			});
		attributeSetterBiConsumers.put(
			"userName",
			new BiConsumer<CPFriendlyURLEntry, Object>() {

				@Override
				public void accept(
					CPFriendlyURLEntry cpFriendlyURLEntry, Object userName) {

					cpFriendlyURLEntry.setUserName((String)userName);
				}

			});
		attributeGetterFunctions.put(
			"createDate",
			new Function<CPFriendlyURLEntry, Object>() {

				@Override
				public Object apply(CPFriendlyURLEntry cpFriendlyURLEntry) {
					return cpFriendlyURLEntry.getCreateDate();
				}

			});
		attributeSetterBiConsumers.put(
			"createDate",
			new BiConsumer<CPFriendlyURLEntry, Object>() {

				@Override
				public void accept(
					CPFriendlyURLEntry cpFriendlyURLEntry, Object createDate) {

					cpFriendlyURLEntry.setCreateDate((Date)createDate);
				}

			});
		attributeGetterFunctions.put(
			"modifiedDate",
			new Function<CPFriendlyURLEntry, Object>() {

				@Override
				public Object apply(CPFriendlyURLEntry cpFriendlyURLEntry) {
					return cpFriendlyURLEntry.getModifiedDate();
				}

			});
		attributeSetterBiConsumers.put(
			"modifiedDate",
			new BiConsumer<CPFriendlyURLEntry, Object>() {

				@Override
				public void accept(
					CPFriendlyURLEntry cpFriendlyURLEntry,
					Object modifiedDate) {

					cpFriendlyURLEntry.setModifiedDate((Date)modifiedDate);
				}

			});
		attributeGetterFunctions.put(
			"classNameId",
			new Function<CPFriendlyURLEntry, Object>() {

				@Override
				public Object apply(CPFriendlyURLEntry cpFriendlyURLEntry) {
					return cpFriendlyURLEntry.getClassNameId();
				}

			});
		attributeSetterBiConsumers.put(
			"classNameId",
			new BiConsumer<CPFriendlyURLEntry, Object>() {

				@Override
				public void accept(
					CPFriendlyURLEntry cpFriendlyURLEntry, Object classNameId) {

					cpFriendlyURLEntry.setClassNameId((Long)classNameId);
				}

			});
		attributeGetterFunctions.put(
			"classPK",
			new Function<CPFriendlyURLEntry, Object>() {

				@Override
				public Object apply(CPFriendlyURLEntry cpFriendlyURLEntry) {
					return cpFriendlyURLEntry.getClassPK();
				}

			});
		attributeSetterBiConsumers.put(
			"classPK",
			new BiConsumer<CPFriendlyURLEntry, Object>() {

				@Override
				public void accept(
					CPFriendlyURLEntry cpFriendlyURLEntry, Object classPK) {

					cpFriendlyURLEntry.setClassPK((Long)classPK);
				}

			});
		attributeGetterFunctions.put(
			"languageId",
			new Function<CPFriendlyURLEntry, Object>() {

				@Override
				public Object apply(CPFriendlyURLEntry cpFriendlyURLEntry) {
					return cpFriendlyURLEntry.getLanguageId();
				}

			});
		attributeSetterBiConsumers.put(
			"languageId",
			new BiConsumer<CPFriendlyURLEntry, Object>() {

				@Override
				public void accept(
					CPFriendlyURLEntry cpFriendlyURLEntry, Object languageId) {

					cpFriendlyURLEntry.setLanguageId((String)languageId);
				}

			});
		attributeGetterFunctions.put(
			"urlTitle",
			new Function<CPFriendlyURLEntry, Object>() {

				@Override
				public Object apply(CPFriendlyURLEntry cpFriendlyURLEntry) {
					return cpFriendlyURLEntry.getUrlTitle();
				}

			});
		attributeSetterBiConsumers.put(
			"urlTitle",
			new BiConsumer<CPFriendlyURLEntry, Object>() {

				@Override
				public void accept(
					CPFriendlyURLEntry cpFriendlyURLEntry, Object urlTitle) {

					cpFriendlyURLEntry.setUrlTitle((String)urlTitle);
				}

			});
		attributeGetterFunctions.put(
			"main",
			new Function<CPFriendlyURLEntry, Object>() {

				@Override
				public Object apply(CPFriendlyURLEntry cpFriendlyURLEntry) {
					return cpFriendlyURLEntry.getMain();
				}

			});
		attributeSetterBiConsumers.put(
			"main",
			new BiConsumer<CPFriendlyURLEntry, Object>() {

				@Override
				public void accept(
					CPFriendlyURLEntry cpFriendlyURLEntry, Object main) {

					cpFriendlyURLEntry.setMain((Boolean)main);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getCPFriendlyURLEntryId() {
		return _CPFriendlyURLEntryId;
	}

	@Override
	public void setCPFriendlyURLEntryId(long CPFriendlyURLEntryId) {
		_CPFriendlyURLEntryId = CPFriendlyURLEntryId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getClassName() {
		if (getClassNameId() <= 0) {
			return "";
		}

		return PortalUtil.getClassName(getClassNameId());
	}

	@Override
	public void setClassName(String className) {
		long classNameId = 0;

		if (Validator.isNotNull(className)) {
			classNameId = PortalUtil.getClassNameId(className);
		}

		setClassNameId(classNameId);
	}

	@Override
	public long getClassNameId() {
		return _classNameId;
	}

	@Override
	public void setClassNameId(long classNameId) {
		_columnBitmask = -1L;

		if (!_setOriginalClassNameId) {
			_setOriginalClassNameId = true;

			_originalClassNameId = _classNameId;
		}

		_classNameId = classNameId;
	}

	public long getOriginalClassNameId() {
		return _originalClassNameId;
	}

	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		_columnBitmask = -1L;

		if (!_setOriginalClassPK) {
			_setOriginalClassPK = true;

			_originalClassPK = _classPK;
		}

		_classPK = classPK;
	}

	public long getOriginalClassPK() {
		return _originalClassPK;
	}

	@Override
	public String getLanguageId() {
		if (_languageId == null) {
			return "";
		}
		else {
			return _languageId;
		}
	}

	@Override
	public void setLanguageId(String languageId) {
		_columnBitmask |= LANGUAGEID_COLUMN_BITMASK;

		if (_originalLanguageId == null) {
			_originalLanguageId = _languageId;
		}

		_languageId = languageId;
	}

	public String getOriginalLanguageId() {
		return GetterUtil.getString(_originalLanguageId);
	}

	@Override
	public String getUrlTitle() {
		if (_urlTitle == null) {
			return "";
		}
		else {
			return _urlTitle;
		}
	}

	@Override
	public void setUrlTitle(String urlTitle) {
		_columnBitmask = -1L;

		if (_originalUrlTitle == null) {
			_originalUrlTitle = _urlTitle;
		}

		_urlTitle = urlTitle;
	}

	public String getOriginalUrlTitle() {
		return GetterUtil.getString(_originalUrlTitle);
	}

	@Override
	public boolean getMain() {
		return _main;
	}

	@Override
	public boolean isMain() {
		return _main;
	}

	@Override
	public void setMain(boolean main) {
		_columnBitmask |= MAIN_COLUMN_BITMASK;

		if (!_setOriginalMain) {
			_setOriginalMain = true;

			_originalMain = _main;
		}

		_main = main;
	}

	public boolean getOriginalMain() {
		return _originalMain;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(CPFriendlyURLEntry.class.getName()),
			getClassNameId());
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), CPFriendlyURLEntry.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CPFriendlyURLEntry toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CPFriendlyURLEntry>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CPFriendlyURLEntryImpl cpFriendlyURLEntryImpl =
			new CPFriendlyURLEntryImpl();

		cpFriendlyURLEntryImpl.setUuid(getUuid());
		cpFriendlyURLEntryImpl.setCPFriendlyURLEntryId(
			getCPFriendlyURLEntryId());
		cpFriendlyURLEntryImpl.setGroupId(getGroupId());
		cpFriendlyURLEntryImpl.setCompanyId(getCompanyId());
		cpFriendlyURLEntryImpl.setUserId(getUserId());
		cpFriendlyURLEntryImpl.setUserName(getUserName());
		cpFriendlyURLEntryImpl.setCreateDate(getCreateDate());
		cpFriendlyURLEntryImpl.setModifiedDate(getModifiedDate());
		cpFriendlyURLEntryImpl.setClassNameId(getClassNameId());
		cpFriendlyURLEntryImpl.setClassPK(getClassPK());
		cpFriendlyURLEntryImpl.setLanguageId(getLanguageId());
		cpFriendlyURLEntryImpl.setUrlTitle(getUrlTitle());
		cpFriendlyURLEntryImpl.setMain(isMain());

		cpFriendlyURLEntryImpl.resetOriginalValues();

		return cpFriendlyURLEntryImpl;
	}

	@Override
	public int compareTo(CPFriendlyURLEntry cpFriendlyURLEntry) {
		int value = 0;

		if (getClassNameId() < cpFriendlyURLEntry.getClassNameId()) {
			value = -1;
		}
		else if (getClassNameId() > cpFriendlyURLEntry.getClassNameId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getClassPK() < cpFriendlyURLEntry.getClassPK()) {
			value = -1;
		}
		else if (getClassPK() > cpFriendlyURLEntry.getClassPK()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = getUrlTitle().compareTo(cpFriendlyURLEntry.getUrlTitle());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CPFriendlyURLEntry)) {
			return false;
		}

		CPFriendlyURLEntry cpFriendlyURLEntry = (CPFriendlyURLEntry)obj;

		long primaryKey = cpFriendlyURLEntry.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		CPFriendlyURLEntryModelImpl cpFriendlyURLEntryModelImpl = this;

		cpFriendlyURLEntryModelImpl._originalUuid =
			cpFriendlyURLEntryModelImpl._uuid;

		cpFriendlyURLEntryModelImpl._originalGroupId =
			cpFriendlyURLEntryModelImpl._groupId;

		cpFriendlyURLEntryModelImpl._setOriginalGroupId = false;

		cpFriendlyURLEntryModelImpl._originalCompanyId =
			cpFriendlyURLEntryModelImpl._companyId;

		cpFriendlyURLEntryModelImpl._setOriginalCompanyId = false;

		cpFriendlyURLEntryModelImpl._setModifiedDate = false;

		cpFriendlyURLEntryModelImpl._originalClassNameId =
			cpFriendlyURLEntryModelImpl._classNameId;

		cpFriendlyURLEntryModelImpl._setOriginalClassNameId = false;

		cpFriendlyURLEntryModelImpl._originalClassPK =
			cpFriendlyURLEntryModelImpl._classPK;

		cpFriendlyURLEntryModelImpl._setOriginalClassPK = false;

		cpFriendlyURLEntryModelImpl._originalLanguageId =
			cpFriendlyURLEntryModelImpl._languageId;

		cpFriendlyURLEntryModelImpl._originalUrlTitle =
			cpFriendlyURLEntryModelImpl._urlTitle;

		cpFriendlyURLEntryModelImpl._originalMain =
			cpFriendlyURLEntryModelImpl._main;

		cpFriendlyURLEntryModelImpl._setOriginalMain = false;

		cpFriendlyURLEntryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CPFriendlyURLEntry> toCacheModel() {
		CPFriendlyURLEntryCacheModel cpFriendlyURLEntryCacheModel =
			new CPFriendlyURLEntryCacheModel();

		cpFriendlyURLEntryCacheModel.uuid = getUuid();

		String uuid = cpFriendlyURLEntryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			cpFriendlyURLEntryCacheModel.uuid = null;
		}

		cpFriendlyURLEntryCacheModel.CPFriendlyURLEntryId =
			getCPFriendlyURLEntryId();

		cpFriendlyURLEntryCacheModel.groupId = getGroupId();

		cpFriendlyURLEntryCacheModel.companyId = getCompanyId();

		cpFriendlyURLEntryCacheModel.userId = getUserId();

		cpFriendlyURLEntryCacheModel.userName = getUserName();

		String userName = cpFriendlyURLEntryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			cpFriendlyURLEntryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			cpFriendlyURLEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			cpFriendlyURLEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			cpFriendlyURLEntryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			cpFriendlyURLEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		cpFriendlyURLEntryCacheModel.classNameId = getClassNameId();

		cpFriendlyURLEntryCacheModel.classPK = getClassPK();

		cpFriendlyURLEntryCacheModel.languageId = getLanguageId();

		String languageId = cpFriendlyURLEntryCacheModel.languageId;

		if ((languageId != null) && (languageId.length() == 0)) {
			cpFriendlyURLEntryCacheModel.languageId = null;
		}

		cpFriendlyURLEntryCacheModel.urlTitle = getUrlTitle();

		String urlTitle = cpFriendlyURLEntryCacheModel.urlTitle;

		if ((urlTitle != null) && (urlTitle.length() == 0)) {
			cpFriendlyURLEntryCacheModel.urlTitle = null;
		}

		cpFriendlyURLEntryCacheModel.main = isMain();

		return cpFriendlyURLEntryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CPFriendlyURLEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CPFriendlyURLEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CPFriendlyURLEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((CPFriendlyURLEntry)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<CPFriendlyURLEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CPFriendlyURLEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CPFriendlyURLEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CPFriendlyURLEntry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CPFriendlyURLEntry>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private String _originalUuid;
	private long _CPFriendlyURLEntryId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _classNameId;
	private long _originalClassNameId;
	private boolean _setOriginalClassNameId;
	private long _classPK;
	private long _originalClassPK;
	private boolean _setOriginalClassPK;
	private String _languageId;
	private String _originalLanguageId;
	private String _urlTitle;
	private String _originalUrlTitle;
	private boolean _main;
	private boolean _originalMain;
	private boolean _setOriginalMain;
	private long _columnBitmask;
	private CPFriendlyURLEntry _escapedModel;

}