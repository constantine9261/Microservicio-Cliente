package com.banking.nttdataProyectoI.util;

import org.apache.commons.lang3.StringUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {

  public static Date asDate(LocalDate localDate) {
    return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
  }

  public static LocalDateTime getUtcZeroCurrentTime() {
    OffsetDateTime utc = OffsetDateTime.now(ZoneOffset.UTC);
    return  utc.toLocalDateTime();
  }

  public static LocalDateTime getUtcZeroInstantNow() {
    ZonedDateTime zdtNow = Instant.now().atZone(ZoneOffset.UTC);
    return  zdtNow.toLocalDateTime();
  }

  public static String convertDateTimeWithFormatToStr(LocalDateTime date) {
    return convertDateTimeWithFormatToStr(date, Constants.DEFAULT_DATETIME_FORMAT);
  }

  public static String convertDateTimeWithFormatToStr(LocalDateTime date, String format) {
    if (date == null) {
      return null;
    }

    String dateInString = DateTimeFormatter.ofPattern(format).format(date);

    return dateInString;
  }

  public static String convertFromUtcToLocal(LocalDateTime date, String utcZone,
                                             String patternDateTimeFormat) {
    if (date == null) {
      return null;
    }
    String convertResult;
    String dateInString = DateTimeFormatter.ofPattern(
            Constants.FULL_DATETIME_FORMAT).format(date);
    Instant instant = Instant.parse(dateInString);
    String zoneCode = !Util.stringIsNullOrEmpty(utcZone) ? utcZone.trim()
            : Constants.DEFAULT_UTC_ZONE;
    //because '+' changes to ' '. Example: 'UTC+05:00' => result : 'UTC 05:00'
    if (zoneCode.contains(" ")) {
      zoneCode = "+" + StringUtils.deleteWhitespace(zoneCode).substring(3);
    }
    ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of(zoneCode));
    convertResult = DateTimeFormatter.ofPattern(patternDateTimeFormat)
            .format(zonedDateTime.toLocalDateTime());

    return convertResult;
  }

  public static LocalDateTime utcLocal(LocalDateTime date, String utcZone) {
    Instant instant = date.toInstant(ZoneOffset.UTC);
    String zoneCode  = !StringUtils.isEmpty(utcZone) ? utcZone.trim() : Constants.DEFAULT_UTC_ZONE;
    //because '+' changes to ' '. Example: 'UTC+05:00' => result : 'UTC 05:00'
    if (zoneCode.contains(" ")) {
      zoneCode = "+" + StringUtils.deleteWhitespace(zoneCode).substring(3);
    }
    ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of(zoneCode));
    return zonedDateTime.toLocalDateTime();
  }

  public static LocalDateTime convertFromOneZoneToAnother(LocalDateTime date,
                                                          String sourceZone, String destinyZone) {
    sourceZone = sourceZone.trim();
    if (sourceZone.contains(" ")) {
      sourceZone.replace(" ", "-");
    }

    if (sourceZone.contains("-")) {
      Integer startIndex = sourceZone.lastIndexOf('-');
      Integer endIndex = sourceZone.lastIndexOf(':');
      sourceZone = StringUtils.deleteWhitespace(sourceZone)
              .substring(startIndex, endIndex);
    }

    LocalDateTime newDateTime = date.atZone(ZoneId.of(sourceZone))
            .withZoneSameInstant(ZoneId.of(destinyZone))
            .toLocalDateTime();

    return newDateTime;
  }

  public static LocalDateTime convertEpochTimeToDate(Long timestamp) {
    LocalDateTime convertTime =
            LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneOffset.UTC);

    return convertTime;
  }

  public static LocalDateTime dateStrToLocalDateTime(String strDate) {
    return dateStrToLocalDateTime(strDate, Constants.DEFAULT_DATE_FORMAT);
  }

  public static LocalDateTime dateStrToLocalDateTime(String strDate, String dateFormat) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
    LocalDateTime dateTime = LocalDate.parse(strDate, formatter).atStartOfDay();

    return dateTime;
  }

  public static LocalDateTime strToDateWithZone(String zoneOffset, LocalDateTime dateTime) {
    return strToDateWithZone(
            zoneOffset,
            dateTime.atZone(ZoneId.systemDefault())
            .toLocalDateTime()
            .toString()
    );
  }

  public static LocalDateTime strToDateWithZone(String zoneOffset, String datetime) {
    LocalDateTime ldate = OffsetDateTime.parse(datetime.replace(" ", "T")
            + ZoneOffset.UTC.toString(), DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .atZoneSameInstant(ZoneId.of(zoneOffset)).toLocalDateTime();

    return ldate;
  }
}
