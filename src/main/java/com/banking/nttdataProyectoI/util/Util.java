package com.banking.nttdataProyectoI.util;


import com.banking.nttdataProyectoI.model.api.shared.ApiException;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Util {
  public static String getEntityCode(String prefix, int length, Long id) {
    return prefix.concat(StringUtils.leftPad(String.valueOf(id), length, "0"));
  }

  public static Boolean isNumeric(String value) {

    Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    if (value == null) {
      return false;
    }
    return pattern.matcher(value).matches();
  }

  public static Integer getOffsetNumber(int pageNumber, int pageSize) {
    return (pageNumber - 1) * pageSize;
  }

  public static String validateRegex(String regex, String text, String defaultValue) {
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(text);
    return matcher.matches() ? text : defaultValue;
  }

  public static String avoidNulls(String value) {
    return value == null ? "" : value;
  }

  public static Integer avoidNulls(Integer value) {
    return value == null ? 0 : value;
  }

  public static <T> List<T> avoidNull(List<T> value) {
    return value == null ? new ArrayList<T>() : value;
  }

  public static String avoidNullsDate(LocalDateTime value) {
    return value == null ? "" : value.toString();
  }

  public static boolean stringIsNullOrEmpty(String value) {
    return value == null || value.isEmpty();
  }

  public static boolean listIsNullOrEmpty(List value) {
    return value == null || value.isEmpty();
  }

  public static String getBasicAuthenticationHeader(String username, String password) {
    String credentials = username + Constants.TWO_POINTS + password;
    return Constants.BASIC_AUTH
            + Base64.getEncoder().encodeToString(credentials.getBytes());
  }

  public static String getResourceCustomers(String originalFileName) {
    return originalFileName.replace(Constants.DOUBLE_BACK_SLASH, Constants.SLASH);
  }

  public static String convertListToQueryInput(List<String> inputList) {
    return inputList.stream()
            .map(value ->
                    Constants.SINGLE_QUOTE.concat(value).concat(Constants.SINGLE_QUOTE))
            .collect(Collectors.joining(Constants.COMMA_VALUE));
  }

  public static String convertListToQueryInputs(List<String> inputList) {
    return inputList.stream()
            .map(value ->
                    Constants.SINGLE_QUOTE.concat(value).concat(Constants.SINGLE_QUOTE))
            .collect(Collectors.joining(Constants.COMMA));
  }

  public static String convertListToQueryLongInput(List<Long> inputList) {
    inputList = Util.listIsNullOrEmpty(inputList) ? Arrays.asList(0L) : inputList;
    return inputList.stream()
            .map(value -> value.toString())
            .collect(Collectors.joining(Constants.COMMA));

  }

  public static LocalDateTime parseLocalDateTime(String value) {
    return value == null ? null : LocalDateTime.parse(value);
  }

  public static String getFileFormatFromValueType(String valueType) {

    String fileFormat = Constants.EMPTY_VALUE;

    switch (valueType) {
      case Constants.WORK_ORDER_INPUT_VALUE_TYPE_CODE_PNG:
        fileFormat = Constants.FILE_FORMAT_PNG;
        break;
      case Constants.WORK_ORDER_INPUT_VALUE_TYPE_CODE_JPG:
        fileFormat = Constants.FILE_FORMAT_JPG;
        break;
      case Constants.WORK_ORDER_INPUT_VALUE_TYPE_CODE_XLSX:
        fileFormat = Constants.FILE_FORMAT_XLSX;
        break;
      case Constants.WORK_ORDER_INPUT_VALUE_TYPE_CODE_WORD:
        fileFormat = Constants.FILE_FORMAT_WORD;
        break;
      case Constants.WORK_ORDER_INPUT_VALUE_TYPE_CODE_PDF:
        fileFormat = Constants.FILE_FORMAT_PDF;
        break;
      case Constants.WORK_ORDER_INPUT_VALUE_TYPE_CODE_TXT:
        fileFormat = Constants.FILE_FORMAT_TXT;
        break;
      default: return fileFormat;
    }

    return  fileFormat;
  }

  public static String getErrorMessage(ApiException apiException) {
    String errorMessage = Constants.EMPTY_VALUE;
    String errorHttpCode = Constants.EMPTY_VALUE;
    String errorName = Constants.EMPTY_VALUE;
    String message = Constants.EMPTY_VALUE;
    String detailDescription = Constants.EMPTY_VALUE;

    if (apiException.getCategory() != null) {
      //errorHttpCode = Integer.toString(apiException.getCategory().getHttpStatus());
      errorName = apiException.getCategory() != null
              ? apiException.getCategory() : Constants.EMPTY_VALUE;
      errorMessage = errorHttpCode.concat(Constants.WHITE_SPACE_VALUE
              .concat(errorName));
    }

    detailDescription = !Util.listIsNullOrEmpty(apiException.getExceptionDetails())
            ? apiException.getExceptionDetails().get(0).getDescription() : Constants.EMPTY_VALUE;

    message = apiException.getMessage() != null ?  apiException.getMessage()
            : Constants.EMPTY_VALUE;

    errorMessage = errorMessage.concat(Constants.WHITE_SPACE_VALUE.concat(message))
            .concat(Constants.WHITE_SPACE_VALUE.concat(detailDescription));

    return errorMessage;
  }
}
