package com.maneng.jpa.demo.foundation.base.error;

/**
 * Created by rmfish on 2015-11-02 22:48.
 */
public class CommonErrors {

  public static Errors UNKNOWN_ERROR = ErrorsBuilder.create().error().code(1, "未知错误.").build().readOnly();
  public static Errors SYSTEM_ERROR = ErrorsBuilder.create().error().code(2, "系统异常.").build().readOnly();
  public static Errors BIZ_ERROR = ErrorsBuilder.create().warning().code(3, "业务异常.").build().readOnly();
  public static Errors ILLEGAL_PARAM_ERROR = ErrorsBuilder.create().warning().code(4, "参数错误.").build().readOnly();
  public static Errors MISS_ACCESS_USER_ERROR = ErrorsBuilder.create().warning().code(5, "用户不存在.").build().readOnly();
  public static Errors PAGED_NO_MORE_DATA = ErrorsBuilder.create().warning().code(6, "没有更多的数据.").build().readOnly();
  public static Errors PERMISSION_ERROR = ErrorsBuilder.create().warning().code(7, "权限错误.").build().readOnly();
  public static Errors ENTITY_NOT_EXIST = ErrorsBuilder.create().warning().code(8, "数据不存在.").build().readOnly();
  public static Errors RPC_ERROR = ErrorsBuilder.create().error().code(9, "远程服务错误.").build().readOnly();
}
