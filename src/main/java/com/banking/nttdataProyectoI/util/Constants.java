package com.banking.nttdataProyectoI.util;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Constants {


  public static final String REGEX_NO_SQL =
          "^(?s)(?i)((?!SELECT|INSERT|UPDATE|DELETE|DROP|CREATE|AND|OR|BETWEEN|ALTER|.*[=()]).*)$";
  public static final String REGEX_TEXT_250 =  "^[A-Za-zÁ-Úá-ú\\s-'.'`]{1,250}|" + REGEX_NO_SQL;
  public static final String REGEX_TEXT_100 =  "^[A-Za-zÁ-Úá-ú\\s-'.'`]{1,100}|" + REGEX_NO_SQL;
  public static final String REGEX_GENERAL_CODE_NO_SQL = "^[A-Za-z0-9]{5,8}|"
          + "(?![\\s,-;:]|)" + REGEX_NO_SQL;



  private Constants() {
  }

  //SHARED
  public static final String DEFAULT_USER_CODE = "U00000";
  public static final String URL_EXAMPLE =
      "https://blobstorage.com/lcom/APPLICATION/INCIDENT/EVIDENCE/"
          + "WOSND000000000001_pantallaerror2.jpg?token=SHJT324567JASD.JSDFOEhsdgfjhsdsaFX";
  public static final String BAISC_SYMBOLS = ".";
  public static final String LOWER_LETTERS = "abcdefghijklmnopqrstuvwxyz";
  public static final String UPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  public static final String BASIC_NUMBERS = "0123456789";


  // DATETIME
  public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
  public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
  public static final String DATETIME_NUMBER_FORMAT = "yyyyMMddHHmmssSSS";
  public static final String FULL_DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
  public static final String FULL_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
  public static final String EMAIL_DATE_FORMAT = "dd/MM/yyyy - HH:mm a";
  public static final String TRAY_REQUEST_DATETIME = "yyyy-MM-dd'T'HH:mm:ss'Z'";
  public static final String FORMATTER_DATE = "yyyy-MM-dd";
  public static final String FORMATTER_HOUR_LYNX = "HH:mm:ss.SSS";
  public static final DateTimeFormatter HOUR_LYNX =
          DateTimeFormatter.ofPattern(FORMATTER_HOUR_LYNX);
  public static final DateTimeFormatter FORMATTER_REQUEST =
          DateTimeFormatter.ofPattern(FULL_DATE_FORMAT);
  public static final DateTimeFormatter DATE_LYNX = DateTimeFormatter.ofPattern(FORMATTER_DATE);
  public static final DateTimeFormatter FORMATTER_NOTIFICATION = DateTimeFormatter
          .ofPattern(EMAIL_DATE_FORMAT).withLocale(new Locale("es", "ES"));

  public static final String NUMBER_REGEX = "^(\\d)*$";
  public static final String DISPATCH_PRODUCT_CODE_REGEX = "^[A-Za-z0-9]{3,4}$";
  public static final String FILTER_SYMBOLS_LYNX_REGEX = "[^A-zÀ-ú0-9\\s]";
  public static final String FILTER_SYMBOLS_REGEX = "[^A-zÀ-ú0-9\\s]";
  public static final String CUSTOMER_REGEXP =
          "([a-zA-Z\\d\\-]{1,11}[ABCDEFLM]([\\d]{3})|[a-zA-Z\\d\\-]{1,11}[1234567](000))";
  public static final String CLEAN_LETTER = "[^0-9]";
  public static final String DATE_FORMAT_REGEX
          = "^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{3}[+-]\\d{4}([a-z]|[A-Z]|\\d)?$";
  public static final String SERVER_UTC_ZONE = "UTC+00:00";
  public static final String DEFAULT_UTC_ZONE = "UTC-05:00";
  public static final String UTC_ZONE_ID = "UTC";

  //ENTITY
  public static final Integer ENABLED_STATE_CODE = 1;
  public static final Integer DISABLED_STATE_CODE = 0;

  public static final String APPROVAL_STATE_CODE = "PASC0001";

  //AUTHORIZATION
  public static final String BASIC_AUTH = "Basic ";

  //CHARACTER
  public static final String HIPHEN = "-";
  //public static final String SUB_HIPHEN = "_";
  public static final String EMPTY_VALUE = "";
  public static final String WHITE_SPACE_VALUE = " ";
  public static final String COMMA_VALUE = ",";
  public static final String TWO_POINTS = ":";
  public static final String SPLIT_SYMBOL = "|";
  public static final String DELIMITER = "->";
  public static final String COMMA = ",";
  public static final String SLASH = "/";
  public static final String COLON = ":";
  public static final String SEMICOLON = ";";
  public static final String DOUBLE_BACK_SLASH = "\\";
  public static final String DOT = ".";
  public static final String EMPTY_STRING = "";
  public static final String SINGLE_QUOTE = "'";

  //FILES
  public static final String BASE64 = ";base64";
  public static final String UNDERLINE = "%2F";
  public static final String DATAURI = "data:application/";
  public static final String FILE_FORMATS = "pdf,doc,docx,xls,xlsx,png,jpg";
  public static final String FILE_FORMATS_REGULAR_EXPRESSION
          = "^(pdf|docx?|xlsx?|png?|txt?|jpe?g)$";

  public static final String XML_EXTENSION = ".xml";
  public static final String DEFAULT_CONTAINER = "lcom";
  public static final String DEFAULT_INCIDENT_PATH = "/aplications/incidents/";
  public static final String INPUT_FILE_NAME = "input-file";
  public static final String INPUT_FILE_MASSIVE = "massive";

  //RESPONSE
  public static final Boolean DEFAULT_FALSE = Boolean.FALSE;
  public static final String ACCEPTED = "ACCEPTED";
  public static final String RESULT_SUCCESS = "SUCCESS";
  public static final String ERROR_SIGN = "La operación no pudo procesarse y "
          + "permanecerá {status}. Vuelve a intentarlo en breve.";
  public static final String SUCCESS_BUSINESS_ID = "TL0001";
  public static final String SUCCESS_MESSAGE = "Operación exitosa";

  public static final String WORK_ORDER_NUMBER_PREFIX = "WOSN";
  public static final int WORK_ORDER_NUMBER_SIZE = 12;

  public static final String PETITION_NUMBER_PREFIX = "PN";
  public static final int PETITION_NUMBER_SIZE = 12;

  // WORK ORDER
  public static final String WORK_ORDER_TYPE_SINGLE_SELF = "PWTC0001";
  public static final String WORK_ORDER_TYPE_SINGLE_OTHER = "PWTC0002";
  public static final String WORK_ORDER_TYPE_GROUP = "PWTC0003";
  public static final String WORK_ORDER_TYPE_MASSIVE = "PWTC0004";

  public static final Integer WORK_ORDER_TEMPORAL_FLAG = 1;
  public static final Integer WORK_ORDER_PERMANENT_FLAG = 0;

  public static final String WORK_ORDER_STATUS_CODE_PENDING = "PWSC0001";
  public static final String WORK_ORDER_STATUS_CODE_RUNNING = "PWSC0002";
  public static final String WORK_ORDER_STATUS_CODE_FAILED = "PWSC0003";
  public static final String WORK_ORDER_STATUS_CODE_COMPLETED = "PWSC0004";
  public static final String WORK_ORDER_STATUS_CODE_PARTIALLY__COMPLETED = "PWSC0005";

  public static final String INPUT_TYPE_CODE_FILE = "PITC0004";

  public static final String AUTHORIZATION_DOCUMENT = "authorization";

  // WORK ORDER TICKET
  public static final String WORK_ORDER_TICKET_STATUS_CODE_PENDING = "PWTSC0001";
  public static final String WORK_ORDER_TICKET_STATUS_CODE_AUTHORIZED = "PWTSC0002";
  public static final String WORK_ORDER_TICKET_STATUS_CODE_PARTIALLY_AUTHORIZED = "PWTSC0003";
  public static final String WORK_ORDER_TICKET_STATUS_CODE_UNAUTHORIZED = "PWTSC0004";
  public static final String WORK_ORDER_TICKET_STATUS_CODE_SEND = "PWTSC0005";
  public static final String WORK_ORDER_TICKET_STATUS_CODE_REJECTED = "PWTSC0006";
  public static final String WORK_ORDER_TICKET_STATUS_CODE_RUNNING = "PWTSC0007";
  public static final String WORK_ORDER_TICKET_STATUS_CODE_OBSERVED = "PWTSC0008";
  public static final String WORK_ORDER_TICKET_STATUS_CODE_COMPLETED = "PWTSC0009";
  public static final String WORK_ORDER_TICKET_STATUS_CODE_FAILED = "PWTSC0010";

  public static final List<String> WORK_ORDER_TICKET_ALL_STATUS_CODES
          = Arrays.asList(WORK_ORDER_TICKET_STATUS_CODE_PENDING,
          WORK_ORDER_TICKET_STATUS_CODE_AUTHORIZED,
          WORK_ORDER_TICKET_STATUS_CODE_PARTIALLY_AUTHORIZED,
          WORK_ORDER_TICKET_STATUS_CODE_UNAUTHORIZED,
          WORK_ORDER_TICKET_STATUS_CODE_SEND,
          WORK_ORDER_TICKET_STATUS_CODE_REJECTED,
          WORK_ORDER_TICKET_STATUS_CODE_RUNNING,
          WORK_ORDER_TICKET_STATUS_CODE_OBSERVED,
          WORK_ORDER_TICKET_STATUS_CODE_COMPLETED,
          WORK_ORDER_TICKET_STATUS_CODE_FAILED);

  public static final List<String> WORK_ORDER_TICKET_VERIFY_STATUS_CODES =
          Arrays.asList(Constants.WORK_ORDER_TICKET_STATUS_CODE_SEND,
                  Constants.WORK_ORDER_TICKET_STATUS_CODE_RUNNING,
                  Constants.WORK_ORDER_TICKET_STATUS_CODE_OBSERVED);

  //SERVICE
  public static final String SERVICE_CATEGORY_CODE_ACCESS = "SCC000001";
  public static final String SERVICE_CATEGORY_CODE_APPS = "SCC000002";
  public static final String SERVICE_CODE = "SC000002";

  // WORK ODER INPUT
  public static final String WORK_ORDER_INPUT_VALUE_TYPE_CODE_PNG = "PVTC0004";
  public static final String WORK_ORDER_INPUT_VALUE_TYPE_CODE_JPG = "PVTC0005";
  public static final String WORK_ORDER_INPUT_VALUE_TYPE_CODE_XLSX = "PVTC0006";
  public static final String WORK_ORDER_INPUT_VALUE_TYPE_CODE_WORD = "PVTC0007";
  public static final String WORK_ORDER_INPUT_VALUE_TYPE_CODE_PDF = "PVTC0008";
  public static final String WORK_ORDER_INPUT_VALUE_TYPE_CODE_TXT = "PVTC0009";

  public static final String FILE_FORMAT_PNG = "png";
  public static final String FILE_FORMAT_JPG = "jpg";
  public static final String FILE_FORMAT_XLSX = "xlsx";
  public static final String FILE_FORMAT_WORD = "doc";
  public static final String FILE_FORMAT_PDF = "pdf";
  public static final String FILE_FORMAT_TXT = "txt";

  // TICKETS

  public static final String CREATE_WORK_ORDER_WORK_LOG_TYPE = "General Information";
  public static final String CREATE_WORK_ORDER_WORK_LOG_SUMMARY
          = "Work Order Created using REST API";
  public static final String CREATE_WORK_ORDER_WORK_LOG_DETAILS = "Attachment using REST API";
  public static final String CREATE_WORK_ORDER_WORK_LOG_VIEW_ACCESS = "Internal";
  public static final String CREATE_WORK_ORDER_WORK_LOG_SECURE = "No";
  public static final String CREATE_WORK_ORDER_SUMMARY = "Test API Work Order - PostMan";
  public static final String CREATE_WORK_ORDER_STATUS = "Assigned";
  public static final String CREATE_WORK_ORDER_PRIORITY = "4-Low";
  public static final String CREATE_WORK_ORDER_REPORTED_SOURCE = "Web";
  public static final String CREATE_WORK_ORDER_SUPPORT_ORGANIZATION = "AIO - HELPDESK";

  public static final String CREATE_WORK_ORDER_TEMPORARY_SINGLE_CATEGORY_TIER_ONE
          = "GESTION DE PROCESOS";
  public static final String CREATE_WORK_ORDER_TEMPORARY_SINGLE_CATEGORY_TIER_TWO
          = "GESTION DE ACCESOS";
  public static final String CREATE_WORK_ORDER_TEMPORARY_SINGLE_CATEGORY_TIER_TRHEE
          = "TEMPORAL - INDIVIDUAL";
  public static final String CREATE_WORK_ORDER_TEMPORARY_SINGLE_CATEGORY_TIER_FOR = "SOFTWARE";
  public static final String CREATE_WORK_ORDER_TEMPORARY_SINGLE_CATEGORY_TIER_FIVE = "APLICACIONES";
  public static final String CREATE_WORK_ORDER_TEMPORARY_SINGLE_CATEGORY_TIER_SIX
          = "OTROS";

  public static final String CREATE_WORK_ORDER_TEMPORARY_MASSIVE_CATEGORY_TIER_ONE
          = "GESTION DE PROCESOS";
  public static final String CREATE_WORK_ORDER_TEMPORARY_MASSIVE_CATEGORY_TIER_TWO
          = "GESTION DE ACCESOS";
  public static final String CREATE_WORK_ORDER_TEMPORARY_MASSIVE_CATEGORY_TIER_TRHEE
          = "TEMPORAL - MASIVOS";
  public static final String CREATE_WORK_ORDER_TEMPORARY_MASSIVE_CATEGORY_TIER_FOR
          = "SOFTWARE";
  public static final String CREATE_WORK_ORDER_TEMPORARY_MASSIVE_CATEGORY_TIER_FIVE
          = "APLICACIONES";
  public static final String CREATE_WORK_ORDER_TEMPORARY_MASSIVE_CATEGORY_TIER_SIX
          = "OTROS";

  public static final String CREATE_WORK_ORDER_PERMANENT_SINGLE_CATEGORY_TIER_ONE
          = "GESTION DE PROCESOS";
  public static final String CREATE_WORK_ORDER_PERMANENT_SINGLE_CATEGORY_TIER_TWO
          = "GESTION DE ACCESOS";
  public static final String CREATE_WORK_ORDER_PERMANENT_SINGLE_CATEGORY_TIER_TRHEE
          = "BRINDAR ACCESOS - INDIVIDUAL";
  public static final String CREATE_WORK_ORDER_PERMANENT_SINGLE_CATEGORY_TIER_FOR
          = "SOFTWARE";
  public static final String CREATE_WORK_ORDER_PERMANENT_SINGLE_CATEGORY_TIER_FIVE
          = "APLICACIONES";
  public static final String CREATE_WORK_ORDER_PERMANENT_SINGLE_CATEGORY_TIER_SIX
          = "OTROS";

  public static final String CREATE_WORK_ORDER_PERMANENT_MASSIVE_CATEGORY_TIER_ONE
          = "GESTION DE PROCESOS";
  public static final String CREATE_WORK_ORDER_PERMANENT_MASSIVE_CATEGORY_TIER_TWO
          = "GESTION DE ACCESOS";
  public static final String CREATE_WORK_ORDER_PERMANENT_MASSIVE_CATEGORY_TIER_TRHEE
          = "BRINDAR ACCESOS - MASIVOS";
  public static final String CREATE_WORK_ORDER_PERMANENT_MASSIVE_CATEGORY_TIER_FOR
          = "SOFTWARE";
  public static final String CREATE_WORK_ORDER_PERMANENT_MASSIVE_CATEGORY_TIER_FIVE
          = "APLICACIONES";
  public static final String CREATE_WORK_ORDER_PERMANENT_MASSIVE_CATEGORY_TIER_SIX
          = "OTROS";


  public static final String CREATE_WORK_ORDER_MANUFACTURER = "OTROS";
  public static final String CREATE_WORK_ORDER_LOG_TYPE = "General Information";
  public static final String CREATE_WORK_ORDER_LOG_SUMMARY = "Se adjunta detalle de acceso";
  public static final String CREATE_WORK_ORDER_LOG_DETAILS = "Attachment using REST API";
  public static final String CREATE_WORK_ORDER_LOG_VIEW_ACCESS = "Internal";
  public static final String CREATE_WORK_ORDER_LOG_SECURE = "No";


  public static final String CREATE_INCIDENT_ORDER_SUMMARY = "Test API Work Order - PostMan";
  public static final String CREATE_INCIDENT_ORDER_STATUS = "Assigned";
  public static final String CREATE_INCIDENT_ORDER_URGENCY_LVL_THREE = "3-Medium";
  public static final String CREATE_INCIDENT_ORDER_IMPACT_LVL_THREE = "3-Moderate/Limited";
  public static final String CREATE_INCIDENT_ORDER_URGENCY_LVL_FOUR = "4-Low";
  public static final String CREATE_INCIDENT_ORDER_IMPACT_LVL_FOUR = "4-Minor/Localized";
  public static final String CREATE_INCIDENT_ORDER_REPORTED_SOURCE = "Web";
  public static final String CREATE_INCIDENT_ORDER_SERVICE_TYPE  = "User Service Restoration";
  public static final String CREATE_INCIDENT_ORDER_SUPPORT_ORGANIZATION = "AIO - HELPDESK";
  public static final String CREATE_INCIDENT_ORDER_LOG_TYPE = "General Information";
  public static final String CREATE_INCIDENT_ORDER_LOG_COMMUNICATION_SOURCE = "Email";
  public static final String CREATE_INCIDENT_ORDER_LOG_SUMMARY
          = "Se adjunta evidencias";
  public static final String CREATE_INCIDENT_ORDER_LOG_DETAILS = "Attachment using REST API";
  public static final String CREATE_INCIDENT_ORDER_LOG_VIEW_ACCESS = "Internal";
  public static final String CREATE_INCIDENT_ORDER_LOG_SECURE = "No";

  public static final String CREATE_INCIDENT_ORDER_OPERATION_CATEGORY_TIER_ONE = "APLICACIONES";
  public static final String CREATE_INCIDENT_ORDER_OPERATION_CATEGORY_TIER_TWO
          = "APLICACIONES DEL NEGOCIO";
  public static final String CREATE_INCIDENT_ORDER_OPERATION_CATEGORY_TIER_TRHEE = "AVERIA - ERROR";
  public static final String CREATE_INCIDENT_ORDER_PRODUCT_CATEGORY_TIER_ONE = "SOFTWARE";
  public static final String CREATE_INCIDENT_ORDER_PRODUCT_CATEGORY_TIER_TWO
          = "APLICACIONES DEL NEGOCIO";
  public static final String CREATE_INCIDENT_ORDER_PRODUCT_CATEGORY_TIER_TRHEE
          = "OTROS";

  // WORK ORDER AUTHORIZERS

  // WORK ORDER AUTHORIZERS
  public static final String AUTHORIZER_STATUS_CODE_PENDING = "PAUTSC0001";
  public static final String AUTHORIZER_STATUS_CODE_APPROVED = "PAUTSC0002";
  public static final String AUTHORIZER_STATUS_CODE_PARTIALLY = "PAUTSC0003";
  public static final String AUTHORIZER_STATUS_CODE_DENIED = "PAUTSC0004";

  public static final List<String> AUTHORIZER_APPROVAL_ALL_STATUS_CODES
          = Arrays.asList(AUTHORIZER_STATUS_CODE_PENDING,
          AUTHORIZER_STATUS_CODE_APPROVED,
          AUTHORIZER_STATUS_CODE_PARTIALLY,
          AUTHORIZER_STATUS_CODE_DENIED);

  public static final String AUTHORIZER_APPROVAL_STATUS_CODE_APPROVED = "PASC0001";
  public static final String AUTHORIZER_APPROVAL_STATUS_CODE_DISAPROVED = "PASC0002";




}