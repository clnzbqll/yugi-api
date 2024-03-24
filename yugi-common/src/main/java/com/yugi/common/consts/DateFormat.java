package com.yugi.common.consts;

/**
 * 日期格式
 *
 * @author clnzbqll
 * @since 2024-03-17 07:19:23
 */
public interface DateFormat {
    /**
     * 年
     */
    String YYYY = "yyyy";

    /**
     * 月
     */
    String MM = "MM";

    /**
     * 日
     */
    String DD = "dd";

    /**
     * 年-月
     */
    String YYYY_MM = "yyyy-MM";

    /**
     * 年-月-日
     */
    String YYYY_MM_DD = "yyyy-MM-dd";

    /**
     * 年月日时分秒
     */
    String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    /**
     * 年-月-日 时:分:秒
     */
    String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    /**
     * 年/月/日
     */
    String[] YMD = {YYYY, MM, DD};

    /**
     * 日期格式
     */
    String[] PATTERNS = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"
    };
}
