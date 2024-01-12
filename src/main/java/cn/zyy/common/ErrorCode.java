package cn.zyy.common;


/**
 * 错误码
 */
public enum ErrorCode {

    SUCCESS(00000, "OK", ""),
    SUCCESS_GOODS_NULL(00004, "商品不存在",""),
    SUCCESS_DB_NULL(00040, "数据库数据为空",""),
    PARAMS_ERROR(40000, "请求参数错误", ""),
    PARAMS_NULL_ERROR(40001, "请求数据为空", ""),
    ADD_ERROR(40002, "添加失败", ""),
    DEL_ERROR(40003, "删除失败", ""),
    UPDATE_ERROR(40004, "修改失败", ""),
    BATCH_UPDATE_ERROR(40005, "批量删除失败", ""),
    SYSTEM_ERROR(50000, "系统内部异常","")
    ;

    private final int code;

    /**
     * 状态码信息
     */
    private  final String message;

    /**
     * 状态码描述(详情)
     */
    private  final String description;



    ErrorCode(int code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;

    }


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }
}
