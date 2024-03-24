package com.yugi.common.utils;


import com.yugi.common.enums.Msg;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import java.util.Locale;

/**
 * 国际化工具类
 *
 * @author clnzbqll
 * @since 2024-03-03 08:22:16
 */
public class MessageUtils {
    /**
     * 消息国际化
     *
     * @param msg  消息
     * @param args 参数
     * @return 国际化消息
     */
    public static String message(Msg msg, Object... args) {
        MessageSource messageSource = SpringUtils.getBean(MessageSource.class);
        Locale locale = LocaleContextHolder.getLocale().getLanguage().equals(Locale.CHINA.getLanguage())?Locale.SIMPLIFIED_CHINESE:Locale.US;
        LocaleContextHolder.setLocale(locale);
        return messageSource.getMessage(msg.name(), args, LocaleContextHolder.getLocale());
    }
}