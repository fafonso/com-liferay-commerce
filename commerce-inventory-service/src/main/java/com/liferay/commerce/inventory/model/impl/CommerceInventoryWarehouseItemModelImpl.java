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

package com.liferay.commerce.inventory.model.impl;

import com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem;
import com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItemModel;
import com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItemSoap;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the CommerceInventoryWarehouseItem service. Represents a row in the &quot;CIWarehouseItem&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>CommerceInventoryWarehouseItemModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommerceInventoryWarehouseItemImpl}.
 * </p>
 *
 * @author Luca Pellizzon
 * @see CommerceInventoryWarehouseItemImpl
 * @generated
 */
@JSON(strict = true)
public class CommerceInventoryWarehouseItemModelImpl
	extends BaseModelImpl<CommerceInventoryWarehouseItem>
	implements CommerceInventoryWarehouseItemModel {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a commerce inventory warehouse item model instance should use the <code>CommerceInventoryWarehouseItem</code> interface instead.
	 */
	public static final String TABLE_NAME = "CIWarehouseItem";

	public static final Object[][] TABLE_COLUMNS = {
		{"externalReferenceCode", Types.VARCHAR},
		{"CIWarehouseItemId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"commerceInventoryWarehouseId", Types.BIGINT}, {"sku", Types.VARCHAR},
		{"quantity", Types.INTEGER}, {"reservedQuantity", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("externalReferenceCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("CIWarehouseItemId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("commerceInventoryWarehouseId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("sku", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("quantity", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("reservedQuantity", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table CIWarehouseItem (externalReferenceCode VARCHAR(75) null,CIWarehouseItemId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,commerceInventoryWarehouseId LONG,sku VARCHAR(75) null,quantity INTEGER,reservedQuantity INTEGER)";

	public static final String TABLE_SQL_DROP = "drop table CIWarehouseItem";

	public static final String ORDER_BY_JPQL =
		" ORDER BY commerceInventoryWarehouseItem.commerceInventoryWarehouseItemId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY CIWarehouseItem.CIWarehouseItemId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.commerce.inventory.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.commerce.inventory.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.commerce.inventory.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem"),
		true);

	public static final long COMMERCEINVENTORYWAREHOUSEID_COLUMN_BITMASK = 1L;

	public static final long COMPANYID_COLUMN_BITMASK = 2L;

	public static final long EXTERNALREFERENCECODE_COLUMN_BITMASK = 4L;

	public static final long SKU_COLUMN_BITMASK = 8L;

	public static final long COMMERCEINVENTORYWAREHOUSEITEMID_COLUMN_BITMASK =
		16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CommerceInventoryWarehouseItem toModel(
		CommerceInventoryWarehouseItemSoap soapModel) {

		if (soapModel == null) {
			return null;
		}

		CommerceInventoryWarehouseItem model =
			new CommerceInventoryWarehouseItemImpl();

		model.setExternalReferenceCode(soapModel.getExternalReferenceCode());
		model.setCommerceInventoryWarehouseItemId(
			soapModel.getCommerceInventoryWarehouseItemId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCommerceInventoryWarehouseId(
			soapModel.getCommerceInventoryWarehouseId());
		model.setSku(soapModel.getSku());
		model.setQuantity(soapModel.getQuantity());
		model.setReservedQuantity(soapModel.getReservedQuantity());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CommerceInventoryWarehouseItem> toModels(
		CommerceInventoryWarehouseItemSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<CommerceInventoryWarehouseItem> models =
			new ArrayList<CommerceInventoryWarehouseItem>(soapModels.length);

		for (CommerceInventoryWarehouseItemSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.commerce.inventory.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem"));

	public CommerceInventoryWarehouseItemModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _commerceInventoryWarehouseItemId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCommerceInventoryWarehouseItemId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _commerceInventoryWarehouseItemId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CommerceInventoryWarehouseItem.class;
	}

	@Override
	public String getModelClassName() {
		return CommerceInventoryWarehouseItem.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CommerceInventoryWarehouseItem, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CommerceInventoryWarehouseItem, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceInventoryWarehouseItem, Object>
				attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply(
					(CommerceInventoryWarehouseItem)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CommerceInventoryWarehouseItem, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CommerceInventoryWarehouseItem, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CommerceInventoryWarehouseItem)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CommerceInventoryWarehouseItem, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CommerceInventoryWarehouseItem, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CommerceInventoryWarehouseItem>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CommerceInventoryWarehouseItem.class.getClassLoader(),
			CommerceInventoryWarehouseItem.class, ModelWrapper.class);

		try {
			Constructor<CommerceInventoryWarehouseItem> constructor =
				(Constructor<CommerceInventoryWarehouseItem>)
					proxyClass.getConstructor(InvocationHandler.class);

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

	private static final Map
		<String, Function<CommerceInventoryWarehouseItem, Object>>
			_attributeGetterFunctions;
	private static final Map
		<String, BiConsumer<CommerceInventoryWarehouseItem, Object>>
			_attributeSetterBiConsumers;

	static {
		Map<String, Function<CommerceInventoryWarehouseItem, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String,
					 Function<CommerceInventoryWarehouseItem, Object>>();
		Map<String, BiConsumer<CommerceInventoryWarehouseItem, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<CommerceInventoryWarehouseItem, ?>>();

		attributeGetterFunctions.put(
			"externalReferenceCode",
			new Function<CommerceInventoryWarehouseItem, Object>() {

				@Override
				public Object apply(
					CommerceInventoryWarehouseItem
						commerceInventoryWarehouseItem) {

					return commerceInventoryWarehouseItem.
						getExternalReferenceCode();
				}

			});
		attributeSetterBiConsumers.put(
			"externalReferenceCode",
			new BiConsumer<CommerceInventoryWarehouseItem, Object>() {

				@Override
				public void accept(
					CommerceInventoryWarehouseItem
						commerceInventoryWarehouseItem,
					Object externalReferenceCode) {

					commerceInventoryWarehouseItem.setExternalReferenceCode(
						(String)externalReferenceCode);
				}

			});
		attributeGetterFunctions.put(
			"commerceInventoryWarehouseItemId",
			new Function<CommerceInventoryWarehouseItem, Object>() {

				@Override
				public Object apply(
					CommerceInventoryWarehouseItem
						commerceInventoryWarehouseItem) {

					return commerceInventoryWarehouseItem.
						getCommerceInventoryWarehouseItemId();
				}

			});
		attributeSetterBiConsumers.put(
			"commerceInventoryWarehouseItemId",
			new BiConsumer<CommerceInventoryWarehouseItem, Object>() {

				@Override
				public void accept(
					CommerceInventoryWarehouseItem
						commerceInventoryWarehouseItem,
					Object commerceInventoryWarehouseItemId) {

					commerceInventoryWarehouseItem.
						setCommerceInventoryWarehouseItemId(
							(Long)commerceInventoryWarehouseItemId);
				}

			});
		attributeGetterFunctions.put(
			"companyId",
			new Function<CommerceInventoryWarehouseItem, Object>() {

				@Override
				public Object apply(
					CommerceInventoryWarehouseItem
						commerceInventoryWarehouseItem) {

					return commerceInventoryWarehouseItem.getCompanyId();
				}

			});
		attributeSetterBiConsumers.put(
			"companyId",
			new BiConsumer<CommerceInventoryWarehouseItem, Object>() {

				@Override
				public void accept(
					CommerceInventoryWarehouseItem
						commerceInventoryWarehouseItem,
					Object companyId) {

					commerceInventoryWarehouseItem.setCompanyId(
						(Long)companyId);
				}

			});
		attributeGetterFunctions.put(
			"userId",
			new Function<CommerceInventoryWarehouseItem, Object>() {

				@Override
				public Object apply(
					CommerceInventoryWarehouseItem
						commerceInventoryWarehouseItem) {

					return commerceInventoryWarehouseItem.getUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"userId",
			new BiConsumer<CommerceInventoryWarehouseItem, Object>() {

				@Override
				public void accept(
					CommerceInventoryWarehouseItem
						commerceInventoryWarehouseItem,
					Object userId) {

					commerceInventoryWarehouseItem.setUserId((Long)userId);
				}

			});
		attributeGetterFunctions.put(
			"userName",
			new Function<CommerceInventoryWarehouseItem, Object>() {

				@Override
				public Object apply(
					CommerceInventoryWarehouseItem
						commerceInventoryWarehouseItem) {

					return commerceInventoryWarehouseItem.getUserName();
				}

			});
		attributeSetterBiConsumers.put(
			"userName",
			new BiConsumer<CommerceInventoryWarehouseItem, Object>() {

				@Override
				public void accept(
					CommerceInventoryWarehouseItem
						commerceInventoryWarehouseItem,
					Object userName) {

					commerceInventoryWarehouseItem.setUserName(
						(String)userName);
				}

			});
		attributeGetterFunctions.put(
			"createDate",
			new Function<CommerceInventoryWarehouseItem, Object>() {

				@Override
				public Object apply(
					CommerceInventoryWarehouseItem
						commerceInventoryWarehouseItem) {

					return commerceInventoryWarehouseItem.getCreateDate();
				}

			});
		attributeSetterBiConsumers.put(
			"createDate",
			new BiConsumer<CommerceInventoryWarehouseItem, Object>() {

				@Override
				public void accept(
					CommerceInventoryWarehouseItem
						commerceInventoryWarehouseItem,
					Object createDate) {

					commerceInventoryWarehouseItem.setCreateDate(
						(Date)createDate);
				}

			});
		attributeGetterFunctions.put(
			"modifiedDate",
			new Function<CommerceInventoryWarehouseItem, Object>() {

				@Override
				public Object apply(
					CommerceInventoryWarehouseItem
						commerceInventoryWarehouseItem) {

					return commerceInventoryWarehouseItem.getModifiedDate();
				}

			});
		attributeSetterBiConsumers.put(
			"modifiedDate",
			new BiConsumer<CommerceInventoryWarehouseItem, Object>() {

				@Override
				public void accept(
					CommerceInventoryWarehouseItem
						commerceInventoryWarehouseItem,
					Object modifiedDate) {

					commerceInventoryWarehouseItem.setModifiedDate(
						(Date)modifiedDate);
				}

			});
		attributeGetterFunctions.put(
			"commerceInventoryWarehouseId",
			new Function<CommerceInventoryWarehouseItem, Object>() {

				@Override
				public Object apply(
					CommerceInventoryWarehouseItem
						commerceInventoryWarehouseItem) {

					return commerceInventoryWarehouseItem.
						getCommerceInventoryWarehouseId();
				}

			});
		attributeSetterBiConsumers.put(
			"commerceInventoryWarehouseId",
			new BiConsumer<CommerceInventoryWarehouseItem, Object>() {

				@Override
				public void accept(
					CommerceInventoryWarehouseItem
						commerceInventoryWarehouseItem,
					Object commerceInventoryWarehouseId) {

					commerceInventoryWarehouseItem.
						setCommerceInventoryWarehouseId(
							(Long)commerceInventoryWarehouseId);
				}

			});
		attributeGetterFunctions.put(
			"sku",
			new Function<CommerceInventoryWarehouseItem, Object>() {

				@Override
				public Object apply(
					CommerceInventoryWarehouseItem
						commerceInventoryWarehouseItem) {

					return commerceInventoryWarehouseItem.getSku();
				}

			});
		attributeSetterBiConsumers.put(
			"sku",
			new BiConsumer<CommerceInventoryWarehouseItem, Object>() {

				@Override
				public void accept(
					CommerceInventoryWarehouseItem
						commerceInventoryWarehouseItem,
					Object sku) {

					commerceInventoryWarehouseItem.setSku((String)sku);
				}

			});
		attributeGetterFunctions.put(
			"quantity",
			new Function<CommerceInventoryWarehouseItem, Object>() {

				@Override
				public Object apply(
					CommerceInventoryWarehouseItem
						commerceInventoryWarehouseItem) {

					return commerceInventoryWarehouseItem.getQuantity();
				}

			});
		attributeSetterBiConsumers.put(
			"quantity",
			new BiConsumer<CommerceInventoryWarehouseItem, Object>() {

				@Override
				public void accept(
					CommerceInventoryWarehouseItem
						commerceInventoryWarehouseItem,
					Object quantity) {

					commerceInventoryWarehouseItem.setQuantity(
						(Integer)quantity);
				}

			});
		attributeGetterFunctions.put(
			"reservedQuantity",
			new Function<CommerceInventoryWarehouseItem, Object>() {

				@Override
				public Object apply(
					CommerceInventoryWarehouseItem
						commerceInventoryWarehouseItem) {

					return commerceInventoryWarehouseItem.getReservedQuantity();
				}

			});
		attributeSetterBiConsumers.put(
			"reservedQuantity",
			new BiConsumer<CommerceInventoryWarehouseItem, Object>() {

				@Override
				public void accept(
					CommerceInventoryWarehouseItem
						commerceInventoryWarehouseItem,
					Object reservedQuantity) {

					commerceInventoryWarehouseItem.setReservedQuantity(
						(Integer)reservedQuantity);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getExternalReferenceCode() {
		if (_externalReferenceCode == null) {
			return "";
		}
		else {
			return _externalReferenceCode;
		}
	}

	@Override
	public void setExternalReferenceCode(String externalReferenceCode) {
		_columnBitmask |= EXTERNALREFERENCECODE_COLUMN_BITMASK;

		if (_originalExternalReferenceCode == null) {
			_originalExternalReferenceCode = _externalReferenceCode;
		}

		_externalReferenceCode = externalReferenceCode;
	}

	public String getOriginalExternalReferenceCode() {
		return GetterUtil.getString(_originalExternalReferenceCode);
	}

	@JSON
	@Override
	public long getCommerceInventoryWarehouseItemId() {
		return _commerceInventoryWarehouseItemId;
	}

	@Override
	public void setCommerceInventoryWarehouseItemId(
		long commerceInventoryWarehouseItemId) {

		_commerceInventoryWarehouseItemId = commerceInventoryWarehouseItemId;
	}

	@JSON
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

	@JSON
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

	@JSON
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

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
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

	@JSON
	@Override
	public long getCommerceInventoryWarehouseId() {
		return _commerceInventoryWarehouseId;
	}

	@Override
	public void setCommerceInventoryWarehouseId(
		long commerceInventoryWarehouseId) {

		_columnBitmask |= COMMERCEINVENTORYWAREHOUSEID_COLUMN_BITMASK;

		if (!_setOriginalCommerceInventoryWarehouseId) {
			_setOriginalCommerceInventoryWarehouseId = true;

			_originalCommerceInventoryWarehouseId =
				_commerceInventoryWarehouseId;
		}

		_commerceInventoryWarehouseId = commerceInventoryWarehouseId;
	}

	public long getOriginalCommerceInventoryWarehouseId() {
		return _originalCommerceInventoryWarehouseId;
	}

	@JSON
	@Override
	public String getSku() {
		if (_sku == null) {
			return "";
		}
		else {
			return _sku;
		}
	}

	@Override
	public void setSku(String sku) {
		_columnBitmask |= SKU_COLUMN_BITMASK;

		if (_originalSku == null) {
			_originalSku = _sku;
		}

		_sku = sku;
	}

	public String getOriginalSku() {
		return GetterUtil.getString(_originalSku);
	}

	@JSON
	@Override
	public int getQuantity() {
		return _quantity;
	}

	@Override
	public void setQuantity(int quantity) {
		_quantity = quantity;
	}

	@JSON
	@Override
	public int getReservedQuantity() {
		return _reservedQuantity;
	}

	@Override
	public void setReservedQuantity(int reservedQuantity) {
		_reservedQuantity = reservedQuantity;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), CommerceInventoryWarehouseItem.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CommerceInventoryWarehouseItem toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CommerceInventoryWarehouseItem>
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
		CommerceInventoryWarehouseItemImpl commerceInventoryWarehouseItemImpl =
			new CommerceInventoryWarehouseItemImpl();

		commerceInventoryWarehouseItemImpl.setExternalReferenceCode(
			getExternalReferenceCode());
		commerceInventoryWarehouseItemImpl.setCommerceInventoryWarehouseItemId(
			getCommerceInventoryWarehouseItemId());
		commerceInventoryWarehouseItemImpl.setCompanyId(getCompanyId());
		commerceInventoryWarehouseItemImpl.setUserId(getUserId());
		commerceInventoryWarehouseItemImpl.setUserName(getUserName());
		commerceInventoryWarehouseItemImpl.setCreateDate(getCreateDate());
		commerceInventoryWarehouseItemImpl.setModifiedDate(getModifiedDate());
		commerceInventoryWarehouseItemImpl.setCommerceInventoryWarehouseId(
			getCommerceInventoryWarehouseId());
		commerceInventoryWarehouseItemImpl.setSku(getSku());
		commerceInventoryWarehouseItemImpl.setQuantity(getQuantity());
		commerceInventoryWarehouseItemImpl.setReservedQuantity(
			getReservedQuantity());

		commerceInventoryWarehouseItemImpl.resetOriginalValues();

		return commerceInventoryWarehouseItemImpl;
	}

	@Override
	public int compareTo(
		CommerceInventoryWarehouseItem commerceInventoryWarehouseItem) {

		long primaryKey = commerceInventoryWarehouseItem.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CommerceInventoryWarehouseItem)) {
			return false;
		}

		CommerceInventoryWarehouseItem commerceInventoryWarehouseItem =
			(CommerceInventoryWarehouseItem)obj;

		long primaryKey = commerceInventoryWarehouseItem.getPrimaryKey();

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
		CommerceInventoryWarehouseItemModelImpl
			commerceInventoryWarehouseItemModelImpl = this;

		commerceInventoryWarehouseItemModelImpl._originalExternalReferenceCode =
			commerceInventoryWarehouseItemModelImpl._externalReferenceCode;

		commerceInventoryWarehouseItemModelImpl._originalCompanyId =
			commerceInventoryWarehouseItemModelImpl._companyId;

		commerceInventoryWarehouseItemModelImpl._setOriginalCompanyId = false;

		commerceInventoryWarehouseItemModelImpl._setModifiedDate = false;

		commerceInventoryWarehouseItemModelImpl.
			_originalCommerceInventoryWarehouseId =
				commerceInventoryWarehouseItemModelImpl.
					_commerceInventoryWarehouseId;

		commerceInventoryWarehouseItemModelImpl.
			_setOriginalCommerceInventoryWarehouseId = false;

		commerceInventoryWarehouseItemModelImpl._originalSku =
			commerceInventoryWarehouseItemModelImpl._sku;

		commerceInventoryWarehouseItemModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CommerceInventoryWarehouseItem> toCacheModel() {
		CommerceInventoryWarehouseItemCacheModel
			commerceInventoryWarehouseItemCacheModel =
				new CommerceInventoryWarehouseItemCacheModel();

		commerceInventoryWarehouseItemCacheModel.externalReferenceCode =
			getExternalReferenceCode();

		String externalReferenceCode =
			commerceInventoryWarehouseItemCacheModel.externalReferenceCode;

		if ((externalReferenceCode != null) &&
			(externalReferenceCode.length() == 0)) {

			commerceInventoryWarehouseItemCacheModel.externalReferenceCode =
				null;
		}

		commerceInventoryWarehouseItemCacheModel.
			commerceInventoryWarehouseItemId =
				getCommerceInventoryWarehouseItemId();

		commerceInventoryWarehouseItemCacheModel.companyId = getCompanyId();

		commerceInventoryWarehouseItemCacheModel.userId = getUserId();

		commerceInventoryWarehouseItemCacheModel.userName = getUserName();

		String userName = commerceInventoryWarehouseItemCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			commerceInventoryWarehouseItemCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			commerceInventoryWarehouseItemCacheModel.createDate =
				createDate.getTime();
		}
		else {
			commerceInventoryWarehouseItemCacheModel.createDate =
				Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			commerceInventoryWarehouseItemCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			commerceInventoryWarehouseItemCacheModel.modifiedDate =
				Long.MIN_VALUE;
		}

		commerceInventoryWarehouseItemCacheModel.commerceInventoryWarehouseId =
			getCommerceInventoryWarehouseId();

		commerceInventoryWarehouseItemCacheModel.sku = getSku();

		String sku = commerceInventoryWarehouseItemCacheModel.sku;

		if ((sku != null) && (sku.length() == 0)) {
			commerceInventoryWarehouseItemCacheModel.sku = null;
		}

		commerceInventoryWarehouseItemCacheModel.quantity = getQuantity();

		commerceInventoryWarehouseItemCacheModel.reservedQuantity =
			getReservedQuantity();

		return commerceInventoryWarehouseItemCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CommerceInventoryWarehouseItem, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CommerceInventoryWarehouseItem, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceInventoryWarehouseItem, Object>
				attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply(
					(CommerceInventoryWarehouseItem)this));
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
		Map<String, Function<CommerceInventoryWarehouseItem, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CommerceInventoryWarehouseItem, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceInventoryWarehouseItem, Object>
				attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply(
					(CommerceInventoryWarehouseItem)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function
			<InvocationHandler, CommerceInventoryWarehouseItem>
				_escapedModelProxyProviderFunction =
					_getProxyProviderFunction();

	}

	private String _externalReferenceCode;
	private String _originalExternalReferenceCode;
	private long _commerceInventoryWarehouseItemId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _commerceInventoryWarehouseId;
	private long _originalCommerceInventoryWarehouseId;
	private boolean _setOriginalCommerceInventoryWarehouseId;
	private String _sku;
	private String _originalSku;
	private int _quantity;
	private int _reservedQuantity;
	private long _columnBitmask;
	private CommerceInventoryWarehouseItem _escapedModel;

}