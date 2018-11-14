package com.app.coacingcenter.utils;

public class CommonConstants {

	public static final String FORWARD_SLASH = "/";
	public static final String MAIL_ATTACHMENT_FILENAME = "transaction.pdf";
	public static final String UI_DATE_FORMAT = "MM/dd/yyyy";
	public static final String UI_DATE_FORMAT_WITH_TIME = "MM/dd/yyyy HH:mm:ss";
	public static final String DB_DATE_FORMAT = "yyyy-MM-dd";
	public static final String CONVERSION_DATE_FORMAT = "EEE MMM dd HH:mm:ss z yyyy";
	public static final String DB_DATE_FORMAT_YYYYMMDD = "yyyyMMdd";
	public static final String AUDIT_LOG_DATE_FORMAT = "MMM dd yyyy h:mm a";
	public static final String FILE_DATE_FORMAT = "MMddyyyy";
	public static final String REAQ_BODID_DATE_FORMAT = "MMddyyyyhhmmss";
	public static final String US_MILITARY_DATE_FORMAT = "MMddyyHHmm";
	public static final String MAIL_DATE_FORMAT_DD_MMM_YYYY = "dd MMM yyyy";
	public static final String XML_GREGORIAN_CALENDAR_CONVERSION_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
	public static final String SEDTRAN_UPDATE_TIMESTAMP_CONVERSION_FORMAT = "yyyy-MM-dd-HH.mm.ss.SSS";
	public static final String BUYBACK_TYPES_ID = "01";
	public static final String ELECTRONIC_FORM_DATE_FORMAT = "MMMM dd, yyyy";

	public static final String D = "D";
	public static final String ACTIVE = "A";
	public static final String IN_ACTIVE = "I";
	public static final String Y = "Y";
	public static final String N = "N";
	public static final String ALL = "ALL";
	public static final String EMAIL_TYPES_ID = "23";
	public static final String SUCCESS_CODE = "1";
	public static final String ERROR_CODE = "0";
	public static final String SUCCESS_MSG = "success";
	public static final String ERROR_MSG = "error";
	public static final String CREATED_BY = "Admin";
	public static final String DT_MATCH_MODE_DATE = "date";
	public static final String DT_MATCH_MODE_EQUAL = "equal";
	public static final String DT_MATCH_MODE_LIKE = "like";
	public static final String DT_MATCH_MODE_AMOUNT = "amount";
	public static final String DT_MATCH_MODE_INTEGER = "integer";

	public static final Integer DECREMENT = -1;
	public static final Integer INCREMENT = 1;

	public static final String BUYBACK_STATUS_WITHDRAWN = "5";
	public static final String BUYBACK_STATUS_DRAFT = "1";
	public static final int BUYBACK_STATUS_DISPOSAL_APPROVED = 14;

	public static final String CUSTOMER_NAME = "customerName";
	public static final String STATUS = "status";
	public static final String CAIR_ID = "cairId";
	public static final String CODE_MASTER_SEQ = "iCodeMstrSeq";
	public static final String ISO_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.S'Z'";
	public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static final String T_ID = "TR642NS";
	public static final String BUYBACK_ID = "buybackId";
	public static final String NON_BUYBACK_ID = "nonBuybackId";
	public static final String QUERY_LIKE = "%";

	public static final String CHECK_TYPE_ID = "45";
	public static final String CHECK_STATUS_ID = "27";
	public static final String CHECK_FLAG_ID = "41";
	public static final String CHECK_TYPE_NORMAL = "N";
	public static final String CHECK_TYPE_SUPPLEMENTARY = "S";
	public static final String CHECK_TYPE_VIOD = "V";
	public static final String CHECK_TYPE_REISSUE = "R";
	public static final String CHECK_TYPE_REISSUE_WITH_CORRECTION = "RC";
	public static final String CHECK_STATUS_NEW_REQUEST = "N";
	public static final String CHECK_STATUS_NEXT_BATCH = "Y";
	public static final String CHECK_FLAG_PROCESS = "P";
	public static final String CHECK_FLAG_HOLD = "H";

	public static final String CHECK_AUDIT_PREFIX = "Check - ";

	public static final String PACKAGE_FLAG = "P";
	public static final String CHECK_FLAG = "C";

	public static final String SEND_TO = "sendTo";

	public static final String CAIR_WS_HOME_PHONE = "H";
	public static final String CAIR_WS_MOBILE_PHONE = "C";
	public static final String CAIR_WS_BUSINESS_PHONE = "B";

	public static final String PAYEES_ADDITIONAL_KEY = "additionalPayees";
	public static final String PAYEES_SUPPLEMENTARY_KEY = "subPayees";

	public static final String PACKAGE = "package";

	public static final String DISPOSAL = "disposal";

	public static final String PACKAGE_APPROVER = "package-approver";

	public static final String TEMPLATE = "template";
	public static final int PACKAGE_CATEGORY = 136;
	public static final int CAIR_ID_RANDOM1 = 10000000;
	public static final int CAIR_ID_RANDOM2 = 900000;
	public static final int BUYBACK_STATUS_CODE_ACTIVE = 31;
	public static final String KEY_AUDIT_FIELDS = "AUDIT_FIELDS";

	public static final String COMMENTS = "comments";
	public static final Integer PACKAGE_SATATUS_END = 48;
	public static final Integer DISPOSAL_SATATUS_START = 580;

	public static final int GOODWILL_AMOUNT_PERCENTAGE = 50;

	public static final String CHECK_INITIAL_PAYMENT = "Initial Payment";
	public static final String CHECK_FINAL_PAYMENT = "Final Payment";

	public static final String KEY_TEMPLATE_APPROVER_COMMENT = "TEMPLATE_APPROVER_COMMENT";

	public static final String INITIAL_AMOUNT = "0.00";

	public static final String ENTITY_ATTR_CHECK_BUYBACK = "buyback";
	public static final String ENTITY_ATTR_CHECK_SCHEDULE_FLAG = "scheduleFlag";
	public static final String ENTITY_ATTR_CHECK_CHECK_STATUS = "checkStatus";
	public static final String ENTITY_ATTR_PACKAGE_VEHICLE_DETAILS = "vehicleDetail";
	public static final String ENTITY_ATTR_BUYBACK_VEHICLE_VIN = "iBybkVin";
	public static final String SEARCH_ATTR_VEHICLE_VIN = "buyback.vehicleInfo.vin";

	public static final Integer LEGAL_APPROVER_TYPE = 716;
	public static final Integer RA_APPROVER_TYPE = 717;
	public static final Integer FINANCE_APPROVER_TYPE = 720;
	public static final Integer CC_MANAGER_APPROVER_TYPE = 721;
	public static final Integer CC_DIR_APPROVER_TYPE = 722;
	public static final Integer FIANANCE_DIR_APPROVER_TYPE = 723;
	public static final Integer VP_OPERATION_APPROVER_TYPE = 724;
	public static final Integer VP_FINANCE_APPROVER_TYPE = 725;
	public static final Integer VP_LEGAL_APPROVER_TYPE = 726;
	public static final Integer PRESIDENT_TYPE = 737;

	public static final String USER = "user";
	public static final String ROLE = "role";
	public static final String BUS_CNTR_CODE = "bussinessCenterCode";
	public static final String LVL2 = "LVL 2";
	public static final String LVL3 = "LVL 3";
	public static final String LVL4 = "LVL 4";
	public static final String LVL1 = "LVL 1";
	public static final String FIELD_USER = "Field User";
	public static final String LROLE_LVL = "lRoleLvl";
	public static final String L_EMAIL = "lEmail";
	public static final String I_USER = "iUser";

	public static final String BUYBACK = "BuyBack";
	public static final String GOODWILL = "Goodwill";
	public static final String CASH_AND_KEEP = "Cash and Keep";

	public static final String NON_BUYBACK = "NonBuyBack";

	public static final int TYPE_BUYBACK = 1;
	public static final int TYPE_GOODWILL = 2;
	public static final int TYPE_CASHANDKEEP = 3;

	public static final String MULTIPLE_APPROVAL = "MULTIPLE_APPROVAL";
	public static final String MULTIPLE_RETURN = "MULTIPLE_RETURN";

	public static final String EMAIL_SPLIT_SEMICOLON = ";";
	public static final String EMAIL_TO = "mailto";
	public static final String EMAIL_CC = "mailcc";

	public static final String BUYBACK_APPROVAL_COMMENT = "Buyback Approval Comment";
	public static final String BUYBACK_PACKAGE_STATUS = "Buyback Package Status";
	public static final String TEMPLATE_STATUS = "Template Status";
	public static final String BUYBACK_TYPE = "Buyback Type";
	public static final String CAIR = "CAIR";
	public static final String CASE = "CASE";
	public static final String VIN = "VIN";
	public static final String APPROVAL_COMMENT = "Buyback Approval Comment";

	public static final String EMPTY_STRING = "";

	public static final String FAILURE = "Failure";

	public static final String SUCCESS = "Success";

	public static final String CASE_ID = "caseId";

	public static final int PROBLEM_CODE = 798;
	public static final int REASON_CODE = 799;

	/** Date Formats **/
	public static final String DATE_FORMAT_YYYYMMDD = "yyyy-MM-dd";
	public static final String DATE_FORMAT_MMDDYYYY = "MM/dd/yyyy";
	public static final String CAC_TO_PSAP_JOB_RUN_DATE = "yyyy-MM-dd-HH.mm.ss.SSSSSS";

	public static final String VIN_FLAG_YES = "Y";
	public static final String VIN_FLAG_NO = "N";
	public static final String CAIR_TYPE = "VBBS";
	public static final String CURRENTLY_OWNS = "Y";
	public static final String DUPLICATE = "duplicate";
	public static final String TIME_FORMAT_HHmmss = "HHmmss";
	public static final String TIME_FORMAT_hhmma = "hh:mm a";
	public static final String CAC_TO_PSAP_JOB_START_TIME = "HHmmss";
	public static final String KEY_DATA = "data";
	public static final String STATUS_ACTIVE = "Active";
	public static final String STATUS_INACTIVE = "InActive";

	public static final String DATE_LETTER = "STGTest";
	public static final String XML_GOODWILL = "GOODWILL";
	public static final String XML_CASHANDKEEP = "CASH&KEEP";
	public static final String XML_BUYBACK = "BUYBACK";
	public static final String XML_YES = "Yes";
	public static final String XML_NO = "No";
	public static final String XML_BUSINESS_CENTER_ID = "87";
	public static final String BATCH_JOB_SUCCESS = "job finished successfully";
	public static final String BATCH_JOB_FAILURE = "job error";

	public static final String REAQ_WEBSERVICE_EXCEPTION = "REAQ WebService not reacheable";
	public static final String CAIR_WEBSERVICE_EXCEPTION = "CAIR WebService not reacheable";
	public static final int CAIR_NOT_CREATED = -1;

	public static final String HYPHEN = "-";
	public static final String CAIR_NUMBER_PREFIX = "A";

	public static final String CASH_AND_KEEP_INVOICE = "01";
	public static final String DEFAULT_PROFILE = "local";
	public static final String TEST_PROFILE = "test";
	public static final String TEST_DB_PROFILE = "testdb";
	public static final String APPLICATION_PROPERTY = "application.properties";
	public static final String CONTENTMANAGER_PROPERTY = "contentmanager.properties";
	public static final Integer APPROVEL_LEVEL_ONE = 0;

	public static final String KEY_FOR_TOTAL_RECORDS = "totalRecords";
	public static final String KEY_FOR_RESULT_DATA = "resultData";

	public static final String AUDIT_TRIAL_DATE_SEARCH_FORMAT = "yyyy-MM-dd hh:mm:ss";

	public static final String CREATED_USER = "createdby";

	public static final String RESPONSE_CONTENT_TYPE = "application/ms-excel";
	public static final String RESPONSE_HEADER_TYPE = "Content-disposition";
	public static final String HEADERNAME_PRIMARYCATEGORY = "Primary Catgeory";
	public static final String HEADERNAME_REASONCODE = "Reason Code";
	public static final String HEADERNAME_PROBLEM_CODE = "Problem Code";
	public static final String MAP_KEY_SHEETNAME = "sheetname";
	public static final String MAP_KEY_HEADERNAME = "headers";
	public static final String MAP_KEY_RESULTNAME = "results";

	public static final String BUYBACK_APPROVAL_MAIL_TEMPLATE = "buyback-approval-mail-template";
	public static final String PSAP_CAC_MAIL_TEMPLATE = "psaptocac-job-mail-template";
	public static final String CAC_PSAP_MAIL_TEMPLATE = "cactopsap-job-mail-template";

	public static final String PENTASAP_SEQ_NO_FORMAT = "%06d";
	public static final String INVOICE_REISSUE_SEQ_NO_FORMAT = "%01d";
	public static final String PENTASAP_AMOUNT_FORMAT = "%08d";

	public static final String USER_ID_SYSTEM = "SYSTEM";
	public static final String USER_ID_PENTASAP = "PSAP";
	public static final String USER_ID_DLR_JOB = "DLR_JOB";
	public static final String USER_ID_VEHICLE_REMARKETING = "VR";
	public static final String USER_ID_VBBS = "VBBSUPD";

	public static final String USER_ID_SEDTRAN = "SEDTRAN";
	public static final String CAC_PSAP_QUERY_STRING = "SELECT c FROM Check c WHERE c.scheduleFlag.iCodeMstrSeq = '598'";

	public static final String SFTP_GET = "mget";
	public static final String PSAP_CAC_PAYLOAD = "payload";

	public static final String SKIPPED_RECORDS = "skippedRecords";
	public static final String INVOICES_NOT_FOUND = "invoicesNotFound";
	public static final String INVOICES_PROCESSED = "invoicesProcessed";

	public static final String BATCH_JOB_EXECUTED_TIME_FORMAT = "dd-MM-yyyy HH:mm";
	public static final String LOGON_USER_ANONYMOUS_USER = "anonymousUser";
	public static final String BATCH_JOB_STATUS_FAILED = "FAILED";

	public static final String SFTP_MOVE = "mv";
	public static final String LINE_BREAK = "<br>";
	public static final String TAB_SAPCE = "\t";

	public static final String NEWLY_CREATED_TID_KEY = "newUserTId";
	public static final String IS_AUCTION = "isAuction";
	public static final String NEWLY_CREATED_ROLE = "newRole";
	public static final String UPDATED_ROLE_KEY = "updateRole";
	public static final String ADDED_DEALER_KEY = "newDealer";
	public static final String UPDATED_DEALER_KEY = "updatedDealer";
	public static final String AUCTION_ADDED_KEY = "addedAuction";
	public static final String AUCTION_UPDATED_KEY = "updatedAuction";
	public static final String MARSHALL_YARD_ADDED_KEY = "addedMarshallYard";
	public static final String MARSHALL_YARD_UPDATED_KEY = "updatedMarshallYard";
	public static final String UPDATED_TID_KEY = "updatedTid";

	public static final String CONTROL_FLAG = "controlFlag";
	public static final String YEAR = "year";
	public static final String MAKE = "make";
	public static final String MODEL = "model";
	public static final String DISCLSR_TYPE = "disclsrType";
	public static final String UPDATED_DISCLSR_TYPE = "updatedDisclsrType";
	public static final String YEAR_MAKE_MODEL = "yearMakeModel";
	public static final String ASSIGNED_AUCTION = "assignedAuction";
	public static final String ASSIGNED_AUCTION_CODE = "assignedAuctionCode";
	public static final String ASSIGNED_AUCTION_NAME = "assignedAuctionName";
	public static final String CREATED_DATE = "createdDate";
	public static final String INVENTORIED_AUCTION = "inventoriedAuction";
	public static final String CONSIGNED_AUCTION = "consignedAuction";
	public static final String REQUESTED_AUCTION = "requestedAuction";
	public static final String CONSIGNED_DATE = "consignedDate";
	public static final String PURCHASING_DEALER = "purchasingDealer";
	public static final String PURCHASING_DATE = "purchasingDate";
	public static final String TITLE_STATE = "titleState";
	public static final String VR_DEALER_STATE = "vrDlrState";
	public static final String BUYBACK_CATEGORY = "bbCAT";
	public static final String ZIP = "zip";
	public static final String STATE = "state";
	public static final String CITY = "city";
	public static final String RESTRICTED_STATES = "cantResellTo";
	public static final String EMISSION = "emission";
	public static final String MILEAGE = "mileage";

	public static final int CAIR_FIELD_LENTH = 8;
	public static final int CHECK_INVC_FIELD_LENGTH = CAIR_FIELD_LENTH + 4;
	public static final int CHECK_INVC_FIELD_FULL_LENTH = CHECK_INVC_FIELD_LENGTH + 4;

	public static final String NULL = "null";
	public static final String LOGGER_STARTED_CASH_AND_KEEP_PACKAGE = "Cash and Keep Package - Started - Service Implementation -";
	public static final String LOGGER_COMPLETED_CASH_AND_KEEP_PACKAGE = "Cash and Keep Package - Completed - Service Implementation -";

	public static final String LABEL_DISTRICT = "District";
	public static final String LABEL_BUSINESSCENTER = "Business Center Identity";
	public static final String LABEL_LEVELTYPE = "Level Type";
	public static final String LABEL_ROLE = "Role";

	public static final String SPACE = " ";
	public static final String ON = "on";
	public static final String HASH_SYMBOL = "#";

	public static final String LABEL_PACKAGE_APPROVER_TYPE = "Package Approver Type";
	public static final String SYMBOL_HYPEN = " - ";
	public static final String BUSSINESS_CENTER = "businessCenterIdentity";
	public static final String DISTRICT = "district";
	public static final String ROLES = "roles";
	public static final String LEVEL_TYPE = "levelType";

	public static final String AUCTION_FLAG = "A";
	public static final String DEALER_FLAG = "D";
	public static final String MARSHALL_YARD_FLAG = "M";

	public static final String JOB_PARAMETER_TIME = "time";
	public static final String TIME_ZONE_EST = "EST";
	public static final String TIME_ZONE_IST = "IST";

	// spring cache keys
	public static final String CODE_MASTER_CACHE = "CODE_MASTER_CACHE";
	public static final String TYPE_MASTER_CACHE = "TYPE_MASTER_CACHE";

	public static final String RESTRICTED_DEALER = "restrictedDealer";

	public static final String UPLOAD_FAILED_FILES = "uploadFailedFiles";
	// public static final String CHECKED_BOX_IMG_CLASS = "checked";
	// public static final String UNCHECKED_BOX_ING_CLASS = "unchecked";

	// buyback package constants
	public static final String REAQ_BODID = "buyback package reaq bodId";
	public static final String BYBK_PACKAGE_CATEGORY = "buyback package category";
	public static final String BYBK_PACKAGE_ARBITRATION_DATE = "buyback package arbitration date";
	public static final String VEHICLE_CURRENT_MILEAGE = "vehicle current mileage";
	public static final String BYBK_DISPOSAL_ADDRESS1 = "buyback disposal address line1";
	public static final String BYBK_DISPOSAL_ADDRESS2 = "buyback disposal address line2";
	public static final String BYBK_DISPOSAL_AREA_REPAIRED_AND_COST = "buyback disposal area repaired and cost";
	public static final String BYBK_DISPOSAL_ASSIGN_TO_AUCTION = "buyback disposal assign to auction";
	public static final String BYBK_DISPOSAL_CITY = "buyback disposal city";
	public static final String BYBK_DISPOSAL_CONTACT = "buyback disposal contact";
	public static final String BYBK_DISPOSAL_TYPE = "buyback disposal type";
	public static final String BYBK_BRANDING_REQUIRED = "buyback branding required?";
	public static final String BYBK_MULTIPLE_REPAIR_ATTEMPTS = "buyback multiple repair attempts";
	public static final String BYBK_DISPOSAL_NON_CONFORMITY_HAZARD = "buyback disposal non conformity hazard";
	public static final String BYBK_DISPOSAL_NUMBER_OF_DAYS = "buyback disposal number of days";
	public static final String BYBK_DISPOSAL_PHONE = "buyback disposal phone";
	public static final String BYBK_DISPOSAL_ACCIDENT_DAMAGE = "buyback disposal prior or current accident damage";
	public static final String BYBK_DISPOSAL_STATE = "buyback disposal state";
	public static final String BYBK_DISPOSAL_TITLE_NUMBER = "buyback disposal title number";
	public static final String BYBK_DISPOSAL_TITLE_STATE = "buyback disposal title state";
	public static final String BYBK_DISPOSAL_VEHICLE_LOCATION = "buyback disposal vehicle location";
	public static final String BYBK_DISPOSAL_VEHICLE_LOCATION_TYPE = "buyback disposal vehicle location type";
	public static final String BYBK_DISPOSAL_VEHICLE_LOCATION_NAME = "buyback disposal vehicle location name";
	public static final String BYBK_DISPOSAL_ZIP = "buyback disposal zip";
	public static final String BYBK_PACKAGE_REPAIRING_DEALER_EMAIL = "buyback package repairing dealer email";
	public static final String BYBK_PACKAGE_REPAIRING_DEALER_PHONE = "buyback package repairing dealer phone";
	public static final String BYBK_PACKAGE_REPAIRING_DEALER_NAME = "buyback package repairing dealer dealer name";
	public static final String BYBK_PACKAGE_MILESTONES = "milestones";
	public static final String BYBK_VIN = "buyback vin";
	public static final String MILESTONE_STARTING_DATE = "01/01/1900";
	public static final String AUDIT_FUNCTION = "audit function";
	public static final String DISPOSAL_STATUS = "buyback disposal status";
	public static final String BYBK_PACKAGE_ARBITRATION_DECISION = "buyback package arbitration decision";
	public static final String BYBK_PACKAGE_LEMON_LAW_CASE_NUMBER = "buyback package lemon law case number";
	public static final String BYBK_PACKAGE_ARBITRATION_CASE_FILED = "buyback package arbitration case filed";
	public static final String BYBK_PACKAGE_LEMON_LAW_FILED = "buyback package lemon law filed";
	public static final String BYBK_DISPOSAL_CREATED_DATE = "buyback disposal created date";
	public static final String REAQ_UPDATE_PACKAGE_INVALID_INPUT = "reaqInvalidInput";
	public static final String BUYBACK_MINOR_STATUS = "Buyback minor status";
	public static final String BUYBACK_VEHICLE_REACQUIRED_DATE = "vehicle reacquired date";
	public static final String CHECK_PAYEE_NAME = "payee name";
	public static final String CHECK_PAYEE_ADDRESS1 = "payee address line1";
	public static final String CHECK_PAYEE_ADDRESS2 = "payee address line2";
	public static final String CHECK_PAYEE_CITY = "payee city";
	public static final String CHECK_PAYEE_STATE = "payee state";
	public static final String CHECK_PAYEE_ZIP = "payee zip";
	public static final String LEMON_LAW_STATE = "Lemon law state";
	public static final String FCA_CASE_NO = "FCA Case Number";
	public static final String IS_VEHICLE_REACQUIRED = "Is Vehicle Reacquired";
	public static final String PACKAGE_STATUS = "Package Status";
	public static final String MINOR_STATUS_DATE = " minor status date ";
	public static final String CUSTOMER_SIGNED_DISCLOSURE = "Customer Signed Disclosure";

	public static final String REPAIR_PROCESS_REQUEST_DATE = "repair process request date";
	public static final String REPAIR_PROCESS = "repair process";
	public static final String VEHICLE_ARRIVAL_DATE = "vehicle arrival date";
	public static final String FINAL_RO_RECEIVE_DATE = "final RO receive date";

	public static final String DISPOSAL_REASON_REASONCODE = "disposal reason code";
	public static final String DISPOSAL_REASON_REPAIRED_DATE = "disposal reason repaired date";
	public static final String DISPOSAL_REASON_NON_CONFORMITIES = "disposal reason non-confirmities";
	public static final String DISPOSAL_REASON_OTHER_COMMENTS = "disposal reason other comments";
	public static final String DISPOSAL_REASON_STATUS = "disposal reason status";

	public static final String BYBK_NOT_FOUND = "no buyback record found";
	public static final String REAQ_SECRET_KEY = "vbbs-reaq-app";
	public static final String VEHICLE_SURRENDERED = "Vehicle Surrendered";

	public static final String SEDTRAN_VIN_NOT_FOUND = "VIN not present";
	public static final String SEDTRAN_STP_STATUS_UPDATED = "00";
	public static final String SEDTRAN_STP_STATUS_INSERTED = "01";
	public static final String SEDTRAN_STP_STATUS_VIN_BLANK = "02";
	public static final String SEDTRAN_STP_VIN_INVALID = "03";
	public static final String SEDTRAN_STP_VIN_ERROR = "04";
	public static final String DISCLOSURE_SEDTRAN_STATUS = "Disclosure Sedtran Status";
	public static final String DISCLOSURE_CONSIGNMENT_STATUS = "Disclosure Consignment Status";
	public static final String SEDTRAN_SEND_DATE = "Sedtran Send Date";
	public static final String SEDTRAN_RETURN_CODE = "Sedtran Return Code";
	public static final String SEDTRAN_BLANK_VIN = "VIN received is blank. Please provide 17 digit VIN";

	public static final String SEDTRAN_STORED_PROCEDURE_DELIMITER = "[|]";
	public static final String QUALITY_EXCEPTION = "Quality Exception";
	public static final String VEHICLE_LOCATION_TYPE_DEALER = "D";
	public static final String VEHICLE_LOCATION_TYPE_AUCTION = "A";
	public static final String INTRANSIT = "InTransit";
	public static final String LOGGER_DATA = "data={}";

	public static final String COMMA_SEPARATOR = ", ";

	public static final String EXTERNAL_URL = "/external/";
	public static final String BEARER = "Bearer ";

	public static final String FILTER_EXTERNAL_URL = "/external/**";

	public static final String SEMICOLON_SEPARATOR = ";";

	public static final String I_DISCLSR_TYP = "iDisclsrTyp";
	public static final String AUCTION_CENTER = "auctionCenter";
	public static final String NO_OF_DAYS = "noOfDays";

	public static final int SORT_ASCENDING_ORDER = 1;
	public static final int SORT_DESCENDING_ORDER = -1;
	public static final String SEDTRAN_INVENTORY_DEALER_CODE = "inventory dealer code";
	public static final String SEDTRAN_INVENTORY_DEALER_NAME = "inventory dealer name";
	public static final String SEDTRAN_INVENTORY_DEALER_ADDRESS1 = "inventory dealer address1";
	public static final String SEDTRAN_INVENTORY_DEALER_ADDRESS2 = "inventory dealer address2";
	public static final String SEDTRAN_INVENTORY_DEALER_CITY = "inventory dealer city";
	public static final String SEDTRAN_INVENTORY_DEALER_STATE = "inventory dealer state";
	public static final String SEDTRAN_INVENTORY_DEALER_COUNTRY = "inventory dealer country";
	public static final String SEDTRAN_INVENTORY_DEALER_ZIP = "inventory dealer zip";
	public static final String SEDTRAN_INVENTORY_AUCTION_RECEIVED_DATE = "inventory auction received date";
	public static final String SEDTRAN_INVENTORY_AUCTION_DEALER_CODE = "inventory auction dealer code";
	public static final String SEDTRAN_INVENTORY_SOLD_DATE = "inventory sold date";
	public static final String SEDTRAN_INVENTORY_AUCTION_GROSS_AMOUNT = "inventory auction gross amount";
	public static final String SEDTRAN_INVENTORY_AUCTION_NET_AMOUNT = "inventory auction net amount";
	public static final String SEDTRAN_INVENTORY_AUCTION_TYPE = "inventory auction type";
	public static final String SEDTRAN_INVENTORY_SALES_UNWOUND = "D";
	public static final String SEDTRAN_INVENTORY_CONSIGNMENT_STATUS = "inventory consignment status";
	public static final String SEDTRAN_INVENTORY_PRINTED_DEALER = "Printed Dealer";
	public static final String SEDTRAN_INVENTORY_PRINTED_DEALER_DATE = "Printed Dealer Date";
	public static final String SEDTRAN_INVENTORY_SOLD_TO_DEALER = "Sold To Dealer";
	public static final String SEDTRAN_INVENTORY_AUCTION_CENTRE = "Auction Centre";
	public static final String INVENTORIED_AUCTION_ADDRESS_LINE1 = "Auction Address line1";
	public static final String INVENTORIED_AUCTION_ADDRESS_LINE2 = "Auction Address line2";
	public static final String AUCTION_CITY_NAME = "Auction city name";
	public static final String AUCTION_COUNTRY_CODE = "Auction country code";
	public static final String AUCTION_COUNTRY_NAME = "Auction country name";
	public static final String DEALER_COUNTRY_CODE = "Dealer country code";
	public static final String DEALER_COUNTRY_NAME = "Dealer country name";
	public static final String AUCTION_STATE = "Auction state";
	public static final String AUCTION_ZIP_CODE = "Auction zip code";
	public static final String DEALER_CODE = "Dealer code";
	public static final String DEALER_LINE1 = "Dealer line1";
	public static final String DEALER_LINE2 = "Dealer line2";
	public static final String DEALER_CITY = "Dealer city";
	public static final String INVENTORIED_DEALER_STATE = "inventoried state";
	public static final int SEDTRAN_INVENTORY_DATA_LENGTH = 24;

	public static final int AUCTION_RECEIVED_DATE_INDEX = 2;
	public static final int AUCTION_DEALER_CODE_INDEX = 3;
	public static final int AUCTION_GROSS_AMOUNT_INDEX = 5;
	public static final int AUCTION_NET_AMOUNT_INDEX = 6;
	public static final int AUCTION_TYPE_INDEX = 7;
	public static final int SOLD_DATE_INDEX = 4;
	public static final int AUCTION_DELETE_FLAG_INDEX = 8;
	public static final int INVENTORIED_AUCTION_CENTRE_INDEX = 9;
	public static final int INVENTORIED_AUCTION_ADDRESS1_INDEX = 10;
	public static final int INVENTORIED_AUCTION_ADDRESS2_INDEX = 11;
	public static final int INVENTORIED_AUCTION_CITY_INDEX = 12;
	public static final int AUCTION_COUNTRY_CODE_INDEX = 13;
	public static final int AUCTION_STATE_INDEX = 14;
	public static final int AUCTION_COUNTRY_NAME_INDEX = 15;
	public static final int AUCTION_ZIP_INDEX = 16;
	public static final int DEALER_NAME_INDEX = 17;
	public static final int DEALER_LINE1_INDEX = 18;
	public static final int DEALER_LINE2_INDEX = 19;
	public static final int DEALER_CITY_INDEX = 20;
	public static final int INVENTORIED_DEALER_STATE_INDEX = 21;
	public static final int INVENTORIED_DEALER_COUNTRY_INDEX = 22;
	public static final int INVENTORIED_DEALER_ZIP_INDEX = 23;

	public static final String SEDTRAN_CONSIGNMENT_DEALER_CODE = "consignment dealer code";
	public static final String SEDTRAN_CONSIGNMENT_DATE = "consignment date";
	public static final String SEDTRAN_CONSIGNMENT_DEALER_NAME = "consignment dealer name";
	public static final String SEDTRAN_CONSIGNMENT_DEALER_ADDRESS1 = "consignment dealer address1";
	public static final String SEDTRAN_CONSIGNMENT_DEALER_ADDRESS2 = "consignment dealer address2";
	public static final String SEDTRAN_CONSIGNMENT_DEALER_CITY = "consignment dealer city";
	public static final String SEDTRAN_CONSIGNMENT_DEALER_STATE = "consignment dealer state";
	public static final String SEDTRAN_CONSIGNMENT_DEALER_ZIP = "consignment dealer zip";

	public static final String SEDTRAN_RECOVERY_AUCTION_AMOUNT = "recovery data auction amount";
	public static final String SEDTRAN_RECOVERY_AUCTION_SALES_TYPE = "recovery data auction sales type";
	public static final String SEDTRAN_RECOVERY_AUCTION_RECEIVE_DATE = "recovery data auction receive date";
	public static final String SEDTRAN_RECOVERY_AUCTION_GROSS_AMOUNT = "recovery data auction gross amount";

	public static final String SEDTRAN_COMMA_SEPARATOR = ",";
	public static final String USER_ID_REAQ = "REAQ";

	public static final String AUCTION = "auctionDetail";
	public static final String LABEL_AUCTION = "Auction";

	public static final String MOCK_VEHICLE_REMARKETING_SEDTRAN_STATUS = "I_SEDTRAN_STAT should be 1401 (SEDTRAN Updated) ";
	public static final String MOCK_VEHICLE_REMARKETING_VEHICLE_SOLD = "vehicle already sold";
	public static final String MOCK_VEHICLE_REMARKETING_SAVE_SUCCESS = "remarketing data saved successfully";

	public static final String LEGAL_FEEDS_PAYMENT_TYPE = "Vehicle Buyback";
	public static final String LEGAL_FEEDS_NOTE = "Received via VBBS interface <MM/DD/YYY>";
	public static final int RECALL_ID_LENGTH = 20;
	public static final int RECALL_DATE_LENGTH = 500;
	public static final int RECALL_STATUS_LENGTH = 50;
	public static final int RECALL_TYPE_LENGTH = 50;
	public static final String RECALL_STATUS_COMPLETE = "COMPLETE";
	public static final String CORP_LOC = "999";
	public static final String INSERT_SYSTEM_DATE = "<<Insert System Date>>";

	public static final String VBBS_MOCK_CONTROLLER_LOAD_PROPERTY = "mock.controller.load";

	public static final String MAJOR_DAMAGE_DISCLOSURE_TEMPLATE_TITLE = "DISCLOSURE NOTICE MAJOR DAMAGE";

	public static final String QUALITY_EXCEPTION_DISCLOSURE_TEMPLATE_TITLE = "DISCLOSURE NOTICE QUALITY EXCEPTION";

	public static final String ARBITRATION_PROVISION_DISCLOSURE_TEMPLATE_TITLE = "ARBITRATION PROVISION";

	public static final int CALIFORNIA_ST_ID = 144;
	public static final int CONNITICUT_ST_ID = 146;
	public static final int FLORIDA_ST_ID = 149;
	public static final int GEORGIA_ST_ID = 150;
	public static final int HAWAAII_ST_ID = 152;
	public static final int IOWA_ST_ID = 156;
	public static final int IDAHO_ST_ID = 153;
	public static final int ILLILINOIS_ST_ID = 154;
	public static final int INDIANA_ST_ID = 155;
	public static final int LOUSIANA_ST_ID = 159;
	public static final int MASSACHUSETTS_ST_ID = 162;
	public static final int MINNESOTA_ST_ID = 164;
	public static final int NORTH_DOKOTA_ST_ID = 175;
	public static final int NEWJERSEY_ST_ID = 171;
	public static final int NEVADA_ST_ID = 169;
	public static final int NEWYORK_ST_ID = 173;
	public static final int OHIO_ST_ID = 176;
	public static final int PENSYLUVANIA_ST_ID = 179;
	public static final int TEXAS_ST_ID = 185;
	public static final int UTAH_ST_ID = 186;
	public static final int WEST_VERGINIA_ST_ID = 191;
	public static final String LEGAL_FEEDS_RECORD_COUNT = "recordCount";

	public static final String SCREEN_OPERATION_ID_KEY = "screenOperationId";
	public static final String AUDIT_LOG_COMMENT_KEY = "logComment";
	public static final String AUDIT_LOG_FUNCTION_STATUS_KEY = "logFuntionStatus";

	public static final String FCA_REP_FOR_GA_DISCLOSURE_PRINT = "fcaRepName";
	public static final int SAMPLE_SORT_ID = 1;

	public static final String COVERAGE_CODE_B = "B";

	public static final String QUALITY_EXCEPTION_ADMIN_PENDING = "Pending";
	public static final String NEW = "New";
	public static final String XML_FILE_FORMAT = ".xml";

	public static final String REPORT_ID = "ReportID";

	public static final String REPORT_SAVED = "Report Saved Successfully";
	public static final String REPORT_UPDATED = "Report Updated Successfully";
	public static final String REPORT_PUBLISHED = "Report Published Successfully";

	public static final String COLUMN_NAME_PLACEHOLDER = "<<COL>>";
	public static final String SQL_SELECT = "Select";
	public static final String SQL_AS = "as";
	public static final String SQL_FROM = "from";
	public static final String SQL_GROUP_BY = "group by " + COLUMN_NAME_PLACEHOLDER;
	public static final String SQL_ORDER_BY = "order by sum_column desc";
	public static final String SQL_FUNC_SUM = "sum(" + COLUMN_NAME_PLACEHOLDER + ") as sum_column";
	public static final String SQL_FUNC_COALESCE = "coalesce(cast(" + COLUMN_NAME_PLACEHOLDER + " as varchar(1024)),'"
			+ HYPHEN + "')";
	public static final String KEY_CHART_TYPE = "type";
	public static final String CRITERIA_ENTITY_GRAPH = "javax.persistence.fetchgraph";
	public static final String ENTITY_GRAPH_KEY_DASH_BD = "DashBd.findEager";
	public static final String ENTITY_GRAPH_KEY_ROLE_FUNCTION = "RoleFunction.findEager";
	public static final String ENTITY_GRAPH_KEY_CODE_MASTER = "CodeMaster.findEager";

	public static final String RECOVERY_UPDATED = "Recovery Information Updated Successfully.";
	public static final String RECOVERY_UPDATE_ERROR = "Error in updating Recovery Information.";
	public static final String DEALER_CODE_ERROR = "Dealer Code not found.";
	public static final String AUCTION_CODE_ERROR = "Auction Code not found.";
	public static final String RESELL_STATE_ID = "ID";
	public static final String RESELL_STATE_MN = "MN";
	public static final String RESELL_STATE_NH = "NH";
	public static final String RESELL_STATE_OH = "OH";
	public static final String RESELL_STATE_PA = "PA";
	public static final String RESELL_STATE_AL = "AL";
	public static final String RESELL_STATE_MD = "MD";
	public static final String RESELL_STATE_ND = "ND";
	public static final String RESELL_STATE_VT = "VT";
	public static final String RESELL_STATE_WA = "WA";

	public static final String RESELL_STATE_AK = "AK";
	public static final String RESELL_STATE_AR = "AR";
	public static final String RESELL_STATE_AZ = "AZ";
	public static final String RESELL_STATE_CO = "CO";
	public static final String RESELL_STATE_DE = "DE";
	public static final String RESELL_STATE_GA = "GA";
	public static final String RESELL_STATE_HI = "HI";
	public static final String RESELL_STATE_IL = "IL";
	public static final String RESELL_STATE_KS = "KS";
	public static final String RESELL_STATE_KY = "KY";
	public static final String RESELL_STATE_MA = "MA";
	public static final String RESELL_STATE_MO = "MO";
	public static final String RESELL_STATE_MI = "MI";
	public static final String RESELL_STATE_MS = "MS";
	public static final String RESELL_STATE_MT = "MT";
	public static final String RESELL_STATE_NC = "NC";
	public static final String RESELL_STATE_NM = "NM";
	public static final String RESELL_STATE_RI = "RI";
	public static final String RESELL_STATE_TN = "TN";
	public static final String RESELL_STATE_VA = "VA";
	public static final String RESELL_STATE_WV = "WV";
	public static final String RESELL_STATE_WY = "WY";

	public static final String CHECK_AUDIT = "Check Audit";

	public static final Integer DEALER_SIGNED_DISCLOUSRE = 1484;
	public static final Integer CUSTOMER_SIGNED_DISCLOUSRE = 1485;
	public static final String REAQ_BYBK_DISPOSAL_NOT_FOUND = "Could not update Diposal Information.Disposal record not available for buyback";

	public static final String WARRANTY_UPDATE_SUCCESS = "Special coverage code has been updated successfully";
	public static final String WARRANTY_UPDATE_DATE_FORMAT = "yyyy-MM-dd";
	public static final String WARRANTY_UPDATE_COVERAGE_CODE_B = "B";
	public static final String WARRANTY_UPDATE_COVERAGE_CODE_S = "S";

	public static final String LOCATION_TYPE_AUCTION = "AUCTION";
	public static final String LOCATION_TYPE_DEALER = "DEALER";
	public static final String DATE_PLACEHOLDER = "[date]";
	public static final String BUYBACK_LOCK_STRING = "SELECT b FROM Buyback b WHERE b.iPkgLockedBy IS NOT NULL";
	public static final String FIELD_USER_ROLE = "Field User";
	public static final String BC_APPROVER = "BC Approver";
	public static final String MODEL_YEAR_PRIOR = " & prior";
	public static final String YEAR_FORMAT = "YYYY";

	public static final String VEHICLE_REMARKETING_RECOVERY_INFO = "Vehicle Remarketing Recovery Information";
	public static final int VIN_MAX_LENGTH = 17;

	public static final Integer ADHOC_XQUERY_MAX_SIZE = 3500;
	public static final String QUERY_LIMIT_EXCEED = "Query size exceeded 3500";

	public static final String NOT_APPLICABLE = "N/A";

	public static final String MIME_TYPE_PDF = "application/pdf";
	public static final String IS_DISCLOSURE_MODIFIED = "isDisclosureModified";
	public static final String MMM_DD_YYYY_FORMAT = "MMM, dd yyyy";
	public static final String DROP_DOWN_DECISION_MAKER = "Decision Maker";

	public static final String MAIL_SENT_SUCCESSFULLY = "Mail Sent Successfully to ";
	public static final String PDF_EXTENSION = ".pdf";
	public static final String FORM_LIST_KEY = "formList";
	public static final String FCA_FROM_MAILID = "VBBS@fcagroup.com";

	public static final String REGEX_BACK_REFERENCE = "<$1$2></$1>";
	public static final String SELF_ENDING_TAG_REGEX = "(?six)<(\\w+)([^<]*?)/>";
	public static final String BR_TAG = "<br>";
	public static final String SPACE_ASCII = "&#32;";
	public static final String HTML_NBSP = "&nbsp;";
	public static final String DIV_CLOSING_TAG = "</div>";
	public static final String DIV_STYLE_WIDTH_755PX = "<div style=\"width:755px;\">";

	public static final Integer VIN_LAST_EIGHT = 8;

	public static final String hyphen = "-";
	public static final String SCHEMANAME = "schemaName";

	public static final String CHECKED_BOX_IMG_CLASS = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACoAAAAqCAYAAADFw8lbAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAAgY0hSTQAAeiYAAICEAAD6AAAAgOgAAHUwAADqYAAAOpgAABdwnLpRPAAAAAlwSFlzAAAOxAAADsQBlSsOGwAAAAZiS0dEAP8A/wD/oL2nkwAAACV0RVh0ZGF0ZTpjcmVhdGUAMjAxNy0wNi0xMlQwMzozMTozMCswODowMAKrykEAAAAldEVYdGRhdGU6bW9kaWZ5ADIwMTYtMDQtMjNUMDA6NDA6MDkrMDg6MDCNvIqaAAAAVHRFWHRzdmc6YmFzZS11cmkAZmlsZTovLy9ob21lL2RiL3N2Z19pbmZvL3N2Zy8xYy8zNi8xYzM2N2UwNWI2ZGI5OWE4M2I0ZWUxMGU4MzFiOGU3ZC5zdmcvLjGgAAACjUlEQVRYR+2ZPY9pQRjHh0QiUa3VeSsWhfgQekQIFZuQJRINnW6L/RZ67xGJiChoFJJt9RtfQaKQQ+N67OMud2aOOXNOYW/8kieZPfOfZ34czjqYCCGHQCBAFEU5Du8Pi8VCVqsVOYke+T56pwSDQWLG8V2z3+9/hyjwEDWa/090t9vhyFhErzg3RZfLJTGZTMRqtZKPjw88qp/Pz89TX7PZTOr1Oh5VB66jXGw2Gzzkv1Wr1XBGnl6vd9UTSo2XlxfIqIccDgfVFBbKkk6nqX5QagiJbjYbqimU1+vFhDipVIrZa7FYYIKNkCiwXq+p5lAejwcTt0kmk8wew+EQE3yERYHJZEJtAuV2uzHBJ5FIMNe+vr5iQh1NokC73aY2g3K5XJig4T2TopKAZlGAJ+t0OjHxA08ym81iQgwpUUBE1ihJQFoUaLValARUKBQ65PN55lwmk8HV2tAlCjSbTUqGV7KSgG5RoNFoUFL/lszpvsQQUWA0GlFy56pWq5iSB0QN+Zh3fHPhiGY8HuNIP+gtRzQaZT6Tl/X8/IxpOXSf+kgkQknxSo+sLlGeZKVSORxPN3Pu6ekJV2tDWpR3ut/e3jDBv3TZ7XZMiCMlGovFqM2hCoUCJn7g/VPQ+jLQLBqPx6lNoViSZzqdDnMNfCAXRZMo3IJcbnQuNckz3W6XuVZUVlh0MBhQm0AVi0VM3IZ1nwSVy+UwwUdIdD6fU82hSqUSJsTp9/vMXu/v75hgIyR62fBc5XIZZ7XDk1UUBRM0QqJ+v/+q4XQ6xRl5ttvtVU8oNYRfo+Fw+HSxns1meMQY4H4L+n59feERNiD6K77I9fl8j2/zDOchajQPUSOB35pOl6fvP+8ZQv4AAGA8+U+bS0EAAAAASUVORK5CYII=";
	public static final String UNCHECKED_BOX_ING_CLASS = "unchecked";
	public static final String NEW_VIN_FORMCONTROL = "newVinNumber";

	public static final String ADDED_CSD_DOCUMENT = "Added CSD document";
	public static final String RECEIVED_CSD_MILESTONE = "Received CSD milestone";

	private CommonConstants() {
	}

}
