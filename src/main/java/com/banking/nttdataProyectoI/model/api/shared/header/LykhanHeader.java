package com.banking.nttdataProyectoI.model.api.shared.header;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


/**
 * LykhanHeader<br/>
 * <b>Class</b>: LykhanHeader.java<br/>
 * <b>Copyright</b>: &copy; 2022 Banco de Cr&eacute;dito del Per&uacute;<br/>
 * <b>Company</b>: Banco de Cr&eacute;dito del Per&uacute;<br/>
 *
 * @author Banco de Cr&eacute;dito del Per&uacute; (LYKHAN) <br/>
 * <u>Service Provider</u>: Everis Per&uacute; SAC (EVE) <br/>
 * <u>Developed by</u>: <br/>
 * <ul>
 * <li>Kevin Ruben Chihuan O.</li>
 * </ul>
 * <u>Changes</u>:<br/>
 * <ul>
 * <li>29/jul./2022 14:34:25 (CC) Creaci&oacute;n de Clase.</li>
 * </ul>
 * @version 1.0
 */
@Data
public class LykhanHeader {

  @JsonIgnore
  private String dummy;

  /*@AuthorizationHeader
  private String authorization;

  @RequestIdHeader
  private String requestId;

  @RequestDateHeader
  private String requestDate;

  @ApplicationCodeHeader
  private String appCode;

  @CallerNameHeader
  private String callerName;*/

  @UserCodeHeader
  private String userCodeHeader;

  @OcpApimSuscriptionKeyHeader
  private String ocpApimSuscriptionKey;

  @AppClientCodeHeader
  private String appClientCode;

  @UtcZoneHeader
  private String utcZoneHeader;
}
