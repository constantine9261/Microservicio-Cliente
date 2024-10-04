package com.banking.nttdataProyectoI.util.api;

public class ApiConstants {

  //SETTING PARAMETERS
  public static final String TAG_SETTING_PARAMETER = "Setting Parameter";
  public static final String POST_SETTING_PARAMETER_SUMMARY
          = "Creación de un parámetro de configuración.";
  public static final String PUT_SETTING_PARAMETER_SUMMARY
          = "Actualiza los parámetros de configuración.";
  public static final String DEL_SETTING_PARAMETER_SUMMARY
          = "Elimina los datos de un parámetro de configuración.";
  public static final String POST_SETTING_PARAMETER_DESC
          = "classpath:/client/ApiDescription/SettingParameter/createSettingParameter.md";
  public static final String PUT_SETTING_PARAMETER_DESC
          = "classpath:/client/ApiDescription/SettingParameter/replaceSettingParameter.md";
  public static final String GET_SETTING_PARAMETER_DESC
          = "classpath:/client/ApiDescription/SettingParameter/listSettingParameters.md";
  public static final String DEL_SETTING_PARAMETER_DESC
          = "classpath:/client/ApiDescription/SettingParameter/deleteSettingParameter.md";
  public static final String GET_SETTING_PARAMETER_LIST_SUMMARY
          = "Lista los parámetros de configuración.";


  public static final String TAG_APPLICATIONS = "Application";
  public static final String GET_APPLICATION_SUMMARY
          = "Detalle de una sola aplicación.";
  public static final String GET_APPLICATION_DESC
          = "classpath:/client/ApiDescription/Application/getApplication.md";

  //WORKORDERTICKETS
  public static final String TAG_WORK_ORDER_TICKET = "WorkOrderTicket";
  public static final String GET_WORK_ORDER_LIST_TICKET_SUMMARY
          = "Lista los tickets de las ordenes de trabajo de Help Desk.";
  public static final String GET_WORK_ORDER_LIST_TICKET_DESC
          = "classpath:/client/ApiDescription/WorkOrderTicket/listWorkOrderTickets.md";
  public static final String GET_WORK_ORDER_TICKET_SUMMARY
          = "Consulta el detalle de un ticket de trabajo.";
  public static final String GET_WORK_ORDER_TICKET_DESC
          = "classpath:/client/ApiDescription/WorkOrderTicket/getWorkOrderTicket.md";
  public static final String DISPATCH_WORK_ORDER_TICKET_SUMMARY
          = "Envía las ordenes de trabajo de Help Desk.";
  public static final String DISPATCH_WORK_ORDER_TICKET_DESC
          = "classpath:/client/ApiDescription/WorkOrderTicket/dispatchWorkOrder.md";
  //WORKORDERS
  public static final String TAG_WORK_ORDER = "WorkOrder";
  public static final String GET_WORK_ORDER_LIST_SUMMARY
          = "Lista los clientes con sus cuentas asociadas.";
  public static final String GET_WORK_ORDER_LIST_DESC
          = "classpath:/client/ApiDescription/WorkOrder/listWorkOrders.md";
  public static final String GET_AUTHORIZATION_WORK_ORDER_LIST_SUMMARY
          = "Lista las autorizacones asociadas a las ordenes de trabajo de Help Desk.";
  public static final String GET_AUTHORIZATION_WORK_ORDER_LIST_DESC
          = "classpath:/client/ApiDescription/WorkOrder/listAuthorizationWorkOrders.md";
  public static final String GET_AUTHORIZATION_WORK_ORDER_SUMMARY
          = "Consulta la autorización asociada a un orde de trabajo";
  public static final String GET_AUTHORIZATION_WORK_ORDER_DESC
          = "classpath:/client/ApiDescription/WorkOrder/getAuthorizationWorkOrder.md";
  public static final String GET_WORK_ORDER_SUMMARY
          = "Consulta el detalle de una orden de trabajo.";
  public static final String GET_WORK_ORDER_DESC
          = "classpath:/client/ApiDescription/WorkOrder/getWorkOrder.md";
  public static final String GET_WORK_ORDER_DETAIL_WORK_ORDER_SUMMARY =
          "Lista los detalles de trabajo asociadas a una orden de trabajo.";
  public static final String GET_WORK_ORDER_DETAIL_WORK_ORDER_DESC
          = "classpath:/client/ApiDescription/WorkOrder/getWorkOrdersDetailByWorkOrder.md";
  public static final String PATCH_WORK_ORDER_STATE_SUMMARY
          = "Actualización del estado una orden de trabajo.";
  public static final String PATCH_WORK_ORDER_STATE_DESC
          = "classpath:/client/ApiDescription/WorkOrder/updateWorkOrder.md";
  public static final String POST_WORK_ORDER_SUMMARY = "Creación de un cliente.";
  public static final String GET_CLIENT_ID_SUMMARY = "Obtiene el detalle del cliente.";
  public static final String PUT_CLIENT_ID_SUMMARY = "Actualiza el detalle del cliente.";
  public static final String DELETE_CLIENT_ID_SUMMARY = "Elimina el detalle del cliente.";

  public static final String POST_WORK_ORDER_AUTHORIZE_SUMMARY
          = "Autorización de una orden de trabajo.";
  public static final String POST_WORK_ORDER_AUTHORIZE_DESC
          = "classpath:/client/ApiDescription/WorkOrder/authorizeWorkOrder.md";
  public static final String POST_WORK_ORDER_DESC
          = "classpath:/client/ApiDescription/WorkOrder/createWorkOrder.md";
  public static final String VERIFY_WORK_ORDER_TICKET_SUMMARY
          = "Verifica si la orden de trabajo corresponde a una incidencia.";
  public static final String VERIFY_WORK_ORDER_TICKET_DESC
          = "classpath:/client/ApiDescription/WorkOrder/verifyWorkOrder.md";

  //WorkOrderDetail
  public static final String TAG_WORK_ORDER_DETAIL = "Work Order Detail";
  public static final String GET_WORK_ORDER_DETAIL_LIST_SUMMARY
          = "Lista las ordenes de trabajo de Help Desk.";
  public static final String GET_WORK_ORDER_DETAIL_LIST_DESC
          = "classpath:/client/ApiDescription/WorkOrderDetail/listWorkOrdersDetail.md";
  public static final String GET_WORK_ORDER_DETAIL_SUMMARY
          = "Consulta el detalle de una orden de trabajo.";
  public static final String GET_WORK_ORDER_DETAIL_DESC
          = "classpath:/client/ApiDescription/WorkOrderDetail/getWorkOrderDetail.md";
  public static final String PATCH_WORK_ORDER_DETAIL_SUMMARY =
          "Actualización del estado del detalle de una orden de trabajo.";
  public static final String PATCH_WORK_ORDER_DETAIL_DESC
          = "classpath:/client/ApiDescription/WorkOrderDetail/updateWorkOrderDetailState.md";


}
