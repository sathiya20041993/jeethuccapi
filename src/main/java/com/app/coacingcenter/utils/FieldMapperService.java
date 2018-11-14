package com.app.coacingcenter.utils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Handled object to object data copy - Filed mapper service
 * 
 * @author STG
 *
 */
@Component("fieldMapperService")
public class FieldMapperService {
	private static final Logger logger = LoggerFactory.getLogger(FieldMapperService.class);

	private static final String NONE_CONS = "none";

	/**
	 * Copy field from one object to another.
	 * 
	 * @param objectToGet
	 * @param objectToSet
	 */
	private void copyFields(Object objectToGet, Object objectToSet) {
		try {
			/** Getting fields from object **/
			Field[] filedsInSuperToSet = objectToSet.getClass().getSuperclass().getDeclaredFields();
			Field[] filedsInClassToSet = objectToSet.getClass().getDeclaredFields();
			Field[] filedsInSuperClassToGet = objectToGet.getClass().getSuperclass().getDeclaredFields();
			Field[] filedsInClassToGet = objectToGet.getClass().getDeclaredFields();

			@SuppressWarnings({ "unchecked", "rawtypes" })
			List<Field> filedsToSet = new ArrayList(Arrays.asList(filedsInSuperToSet));
			filedsToSet.addAll(Arrays.asList(filedsInClassToSet));

			@SuppressWarnings({ "unchecked", "rawtypes" })
			List<Field> filedsToGet = new ArrayList(Arrays.asList(filedsInSuperClassToGet));
			filedsToGet.addAll(Arrays.asList(filedsInClassToGet));

			for (Field fieldToSet : filedsToSet) {
				SetFieldObjectAccesible(fieldToSet);
				/** Checking field contains fieldmapper annotation **/
				if (fieldToSet.isAnnotationPresent(FieldMapper.class)) {
					FieldMapper fieldSetName = getAnnotation(fieldToSet);
					/** Comparing converison methods in both fields **/
					if (fieldSetName.conversionMethod().equals(FieldMapperConstants.ADD_DATE)) {
						Object addDate = fieldToSet.get(objectToSet);
						if (addDate == null) {
							Object addDateVal = DateTimeUtil.getCurrentTimeStamp();
							fieldToSet.set(objectToSet, addDateVal);
						}
					}
					if (fieldSetName.conversionMethod().equals(FieldMapperConstants.UPDATE_DATE)) {
						Object updateDate = DateTimeUtil.getCurrentTimeStamp();
						fieldToSet.set(objectToSet, updateDate);
					}

					for (Field fieldToGet : filedsToGet) {
						// TODO should check another way to access private
						// fields due to security errors
						/** Making field Accessible to set valule **/
						SetFieldObjectAccesible(fieldToGet);
						if (fieldToGet.isAnnotationPresent(FieldMapper.class)) {
							FieldMapper fieldGetName = getAnnotation(fieldToGet);
							Object value = fieldToGet.get(objectToGet);
							if (fieldGetName.name().equals(fieldSetName.name())) {

								/**
								 * getting conversion method and converting
								 * value accordingly
								 **/
								if (NONE_CONS.equals(fieldSetName.conversionMethod())
										&& (null != value || !fieldSetName.required())) {

									fieldToSet.set(objectToSet,
											(value instanceof String) ? ((String) value).trim() : value);
								} else {
									if (fieldSetName.conversionMethod().equals(FieldMapperConstants.BOOLEAN_TO_Y_N)) {

										fieldToSet.set(objectToSet,
												CommonConversions.booleanToYnConversion((Boolean) value));
									} else if (fieldSetName.conversionMethod()
											.equals(FieldMapperConstants.Y_N_TO_BOOLEAN)) {
										fieldToSet.set(objectToSet,
												CommonConversions.ynToBooleanConversion((String) value));
									} else if (fieldSetName.conversionMethod()
											.equals(FieldMapperConstants.BOOLEAN_TO_A_I)) {

										fieldToSet.set(objectToSet,
												(Boolean) (value) ? CommonConstants.ACTIVE : CommonConstants.IN_ACTIVE);
									} else if (fieldSetName.conversionMethod()
											.equals(FieldMapperConstants.A_I_TO_BOOLEAN)) {
										fieldToSet.set(objectToSet, CommonConstants.ACTIVE.equals(value));
									} else if (fieldSetName.conversionMethod()
											.equals(FieldMapperConstants.INNER_CLASS)) {
										Object resultObject = populateDataToNewInstance(value, fieldGetName.target());
										fieldToSet.set(objectToSet, resultObject);
									} else if (fieldSetName.conversionMethod()
											.equals(FieldMapperConstants.MMDDYYYY_TO_TIMESTAMP)) {
										fieldToSet.set(objectToSet, CommonConversions.isoToTimeStamp((String) value));

									} else if (fieldSetName.conversionMethod()
											.equals(FieldMapperConstants.TIMESTAMP_TO_MMDDYYYY)) {
										fieldToSet.set(objectToSet,
												CommonConversions.timeStampToDDMMYYYY((Timestamp) value));
									} else if (fieldSetName.conversionMethod()
											.equals(FieldMapperConstants.MMDDYYYY_TO_DATE) && null != value) {
										fieldToSet.set(objectToSet, DateTimeUtil.getDate((String) value,
												CommonConstants.DATE_FORMAT_MMDDYYYY));

									} else if (fieldSetName.conversionMethod()
											.equals(FieldMapperConstants.DATE_TO_MMDDYYYY) && null != value) {
										fieldToSet.set(objectToSet, CommonConversions
												.timeStampToDDMMYYYY(DateTimeUtil.dateToTimeStamp((Date) value)));
									} else if (fieldSetName.conversionMethod()
											.equals(FieldMapperConstants.INNER_CLASS_COLLECTION)) {

										Collection<Object> populatedCollection = new ArrayList<>();
										Collection<Object> value1 = (Collection<Object>) fieldToGet.get(objectToGet);
										for (Object obj : value1)
											populatedCollection.add(populateDataToNewInstance(obj, fieldGetName.target()));

										fieldToSet.set(objectToSet, populatedCollection);
									} else if (fieldSetName.conversionMethod()
											.equals(FieldMapperConstants.BIGDECIMAL_TO_INTEGER)) {
										fieldToSet.set(objectToSet,
												CommonConversions.bigdecimalToInt((BigDecimal) value));
									} else if (fieldSetName.conversionMethod()
											.equals(FieldMapperConstants.INTEGER_TO_BIGDECIMAL)) {
										fieldToSet.set(objectToSet, CommonConversions.intToBigdecimal((Integer) value));

									} else if (fieldSetName.conversionMethod()
											.equals(FieldMapperConstants.INTEGER_TO_STRING)) {
										fieldToSet.set(objectToSet, CommonConversions.intToString((Integer) value));

									} else if (fieldSetName.conversionMethod()
											.equals(FieldMapperConstants.STRING_TO_INTEGER)) {
										fieldToSet.set(objectToSet, CommonConversions.stringToInt((String) value));

									} else if (fieldSetName.conversionMethod()
											.equals(FieldMapperConstants.STRING_TO_STRINGARRAY)) {
										fieldToSet.set(objectToSet,
												CommonConversions.stringToStringArray((String) value));
									} else if (fieldSetName.conversionMethod()
											.equals(FieldMapperConstants.STRINGARRAY_TO_STRING)) {
										fieldToSet.set(objectToSet,
												CommonConversions.stringArrayToStringConversion((String[]) value));
									} else if (fieldSetName.conversionMethod()
											.equals(FieldMapperConstants.BIGDECIMAL_TO_FLOAT)) {
										fieldToSet.set(objectToSet,
												CommonConversions.bigDecimalToFloat((BigDecimal) value));
									} else if (fieldSetName.conversionMethod()
											.equals(FieldMapperConstants.BIGDECIMAL_TO_STRING)) {
										fieldToSet.set(objectToSet,
												CommonConversions.bigDecimalToString((BigDecimal) value));
									} else if (fieldSetName.conversionMethod()
											.equals(FieldMapperConstants.BIGDECIMAL_TO_FORMAT_STRING)) {
										fieldToSet.set(objectToSet,
												CommonConversions.bigDecimalToFormatString((BigDecimal) value));
									} else if (fieldSetName.conversionMethod()
											.equals(FieldMapperConstants.FLOAT_TO_BIGDECIMAL)) {
										fieldToSet.set(objectToSet, CommonConversions.floatToBigDecimal((Float) value));
									} else if (fieldSetName.conversionMethod()
											.equals(FieldMapperConstants.STRING_TO_MMDDYYYY)) {
										fieldToSet.set(objectToSet,
												CommonConversions.getMMDDYYYYFromYYYMMDD((String) value));
									} else if (fieldSetName.conversionMethod()
											.equals(FieldMapperConstants.ISO_TO_DATE)) {
										fieldToSet.set(objectToSet, CommonConversions.isoToDate((String) value));

									}
								}
								break;
							}
						}
					}

				}
			}
		} catch (IllegalAccessException e) {
			logger.error("Exception while occuring in copyFields : ", e);
		}
	}

	/**
	 * To set data from given object data to generic class.
	 * 
	 * @param objectToGet
	 * @param classToSet
	 * @return generic object
	 */
	public <O> O populateDataToNewInstance(Object objectToGet, Class<O> classToSet) {
		O objInstance = null;
		try {
			objInstance = classToSet.newInstance();
			copyFields(objectToGet, objInstance);
		} catch (InstantiationException | IllegalAccessException e) {
			logger.error("Exception occurring while accessing populateEntityFromDto :", e);
		}

		return objInstance;
	}

	/**
	 * Merge given object data to generic class
	 * 
	 * @param objectToGet
	 * @param objectToSet
	 */
	public void mergeObjects(Object objectToGet, Object objectToSet) {
		copyFields(objectToGet, objectToSet);
	}

	public List<Map<String, Object>> compareFields(Object expectedObject, Object actualObject) {

		try {
			List<Map<String, Object>> changeList = new ArrayList<>();
			Field[] filedsInSuperClassToObject1 = expectedObject.getClass().getSuperclass().getDeclaredFields();

			Field[] filedsInClassToObject1 = expectedObject.getClass().getDeclaredFields();
			Field[] filedsInSuperClassToObject2 = actualObject.getClass().getSuperclass().getDeclaredFields();
			Field[] filedsInClassToObject2 = actualObject.getClass().getDeclaredFields();

			@SuppressWarnings({ "unchecked", "rawtypes" })
			List<Field> filedsObject1 = new ArrayList(Arrays.asList(filedsInSuperClassToObject1));
			filedsObject1.addAll(Arrays.asList(filedsInClassToObject1));

			@SuppressWarnings({ "unchecked", "rawtypes" })
			List<Field> filedsObject2 = new ArrayList(Arrays.asList(filedsInSuperClassToObject2));
			filedsObject2.addAll(Arrays.asList(filedsInClassToObject2));
			for (Field object1Field : filedsObject1) {
				SetFieldObjectAccesible(object1Field);
				if (object1Field.isAnnotationPresent(FieldMapper.class)) {
					FieldMapper fieldObject1 = getAnnotation(object1Field);
					for (Field object2Field : filedsObject2) {
						SetFieldObjectAccesible(object2Field);
						if (object2Field.isAnnotationPresent(FieldMapper.class)) {
							FieldMapper fieldObject2 = getAnnotation(object2Field);
							if (fieldObject1.name().equals(fieldObject2.name())) {
								Object object1Value = object1Field.get(expectedObject);
								Object object2Value = object2Field.get(actualObject);
								Map<String, Object> change = new HashMap<>();
								if (object1Value != null && !object1Value.equals(object2Value)) {
									change.put("fieldName", object1Field.getName());
									change.put("ExpectedValue", object1Value);
									change.put("ActualValue", object2Value);
									changeList.add(change);
								}
								break;
							}
						}
					}
				}
			}
			return changeList;
		} catch (IllegalAccessException e) {
			logger.error("Exception occured while invoking compareFields :", e);
		}
		return Collections.emptyList();

	}

	private void SetFieldObjectAccesible(Field filedObj) {
		filedObj.setAccessible(true);
	}

	private FieldMapper getAnnotation(Field fieldToSet) {
		FieldMapper fieldSetName = fieldToSet.getAnnotation(FieldMapper.class);
		return fieldSetName;
	}

}
