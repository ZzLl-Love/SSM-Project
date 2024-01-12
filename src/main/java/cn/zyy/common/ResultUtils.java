package cn.zyy.common;


/**
 * 返回工具类
 */
public class ResultUtils {

    /**
     * 返回成功
     * @param data
     * @param <T>
     * @return
     */
    public static  <T> BaseResponse<T> success( T data){
        return new BaseResponse<>(200, data, "ok");
    }


    /**
     * 返回失败
     * @param errorCode
     * @return
     */
    public static BaseResponse error(ErrorCode errorCode){
        return new BaseResponse<>(errorCode);
    }

    /**
     * 返回失败
     * @param errorCode
     * @param message
     * @param description
     * @return
     */
    public static BaseResponse error(ErrorCode errorCode,String message, String description ){
        return new BaseResponse<>(errorCode.getCode(), null, message, description);
    }

    public static BaseResponse error(ErrorCode errorCode,String description) {
        return new BaseResponse<>(errorCode.getCode(),errorCode.getDescription(),description);
    }

    /**
     * 失败
     * @param code
     * @param message
     * @param description
     * @return
     */
    public static BaseResponse error(int code,String message, String description) {

        return new BaseResponse<>(code, null, message, description);
    }


    /**
     * 返回数据为空
     */
    public static BaseResponse dataNull(ErrorCode errorcode){
        return new BaseResponse(errorcode);
    }


}
