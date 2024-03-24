package com.yugi.common.exception;

import com.yugi.common.enums.Msg;

/**
 * Yugi断言
 *
 * @author clnzbqll
 * @since 2024-03-09 11:00:23
 */
public class YugiAssert {
    /**
     * 直接断言
     * （true：抛出，false：不抛出）
     *
     * @param accord 依据
     * @param msg 信息
     */
    public static void cast(boolean accord, String msg) {
        if (accord) {
            throw new YugiException(msg);
        }
    }

    /**
     * 直接断言
     * （true：抛出，false：不抛出）
     *
     * @param accord 依据
     * @param msg 信息
     */
    public static void cast(boolean accord, Msg msg) {
        if (accord) {
            throw new YugiException(msg);
        }
    }

    /**
     * 判空断言
     * （null：抛出，non-null：不抛出）
     *
     * @param object 对象
     * @param msg 信息
     */
    public static void empty(Object object, String msg) {
        if (object == null) {
            throw new YugiException(msg);
        }
    }
}