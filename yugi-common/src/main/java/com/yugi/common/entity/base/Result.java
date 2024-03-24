package com.yugi.common.entity.base;


import com.yugi.common.enums.Msg;
import com.yugi.common.utils.MessageUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import static com.yugi.common.consts.HttpStatus.ERROR;
import static com.yugi.common.consts.HttpStatus.OK;

/**
 * 返回类
 *
 * @param <T> 返回数据
 * @author clnzbqll
 * @since 2024-03-09 06:44:39
 */
@Getter
@Setter
@AllArgsConstructor
public class Result<T> {
    private static final String SUCCESS = "success";

    private static final String FAILURE = "error";

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 描述
     */
    private String msg;

    /**
     * 数据
     */
    private T data;

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static <T> Result<T> success() {
        return new Result<>(OK, SUCCESS, null);
    }

    /**
     * 返回成功消息
     *
     * @param data 数据
     * @return 成功消息
     */
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>(OK, SUCCESS, data);
        return result;
    }

    /**
     * 返回成功消息
     *
     * @param result 判定条件
     * @return 成功消息
     */
    public static <T> Result<T> isOk(boolean result) {
        return result?success():error();
    }

    /**
     * 返回警告消息
     *
     * @return 警告消息
     */
    public static <T> Result<T> error() {
        Result<T> result = new Result<>(ERROR, FAILURE, null);
        return result;
    }


    /**
     * 返回警告消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static <T> Result<T> error(String msg) {
        Result<T> result = new Result<>(ERROR, msg, null);
        return result;
    }

    /**
     * 返回警告消息
     *
     * @param code 状态码
     * @param msg 消息
     * @return 警告消息
     */
    public static <T> Result<T> error(Integer code, String msg) {
        Result<T> result = new Result<>(code, msg, null);
        return result;
    }

    /**
     * 返回警告消息
     *
     * @param msg 消息
     * @return 国际化警告消息
     */
    public static <T> Result<T> error(Msg msg) {
        Result<T> result = new Result<>(ERROR, MessageUtils.message(msg), null);
        return result;
    }

    /**
     * 返回警告消息
     *
     * @param msg 消息
     * @param msg 消息
     * @return 国际化警告消息
     */
    public static <T> Result<T> error(Integer code, Msg msg) {
        Result<T> result = new Result<>(code, MessageUtils.message(msg), null);
        return result;
    }
}
