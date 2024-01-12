package cn.zyy.exception;

import cn.zyy.common.ErrorCode;
import lombok.Getter;

/**
 * @Author: Zz
 * @Date: 2023/11/21/22:36
 * @Description: 致敬
 */
@Getter
public class BusinessException extends RuntimeException {

    private final int code;

    private final String description;

    public BusinessException(String message,int code, String description) {
        super(message);
        this.code = code;
        this.description = description;
    }

    public BusinessException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
        this.description = errorCode.getDescription();

    }

    public BusinessException(ErrorCode errorCode,String description){
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
        this.description =description;

    }


}
