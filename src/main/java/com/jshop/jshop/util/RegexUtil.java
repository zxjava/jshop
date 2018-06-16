package com.jshop.jshop.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {

    /**
     * 正则表达式：验证用户名（英文）
     */
    public static final String REGEX_USERNAME_EN = "^[a-zA-Z]\\w{5,17}$";

    /**
     * 正则表达式：验证用户名（中文文）
     */
    public static final String REGEX_USERNAME_CN = "^[\u4e00-\u9fa5]{2,6}$";

    /**
     * 正则表达式：验证密码
     */
    public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,16}$";

    /**
     * 正则表达式：验证手机号
     */
    public static final String REGEX_MOBILE = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";

    /**
     * 正则表达式：验证邮箱
     */
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    /**
     * 正则表达式：验证汉字
     */
    public static final String REGEX_CHINESE = "^[\u4e00-\u9fa5]{1,}$";

    /**
     * 正则表达式：验证身份证（18位或15位）
     */
    public static final String REGEX_ID_CARD = "(^\\d{18}$)|(^\\d{15}$)";

    /**
     * 正则表达式：验证身份证 （18位）
     */
    public static final String REGEX_ID_CARD_18 = "^\\d{18}$";

    /**
     * 正则表达式：验证身份证（15位）
     */
    public static final String REGEX_ID_CARD_15 = "^\\d{15}$";

    /**
     * 正则表达式：验证URL
     */
    public static final String REGEX_URL = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";

    /**
     * 正则表达式：验证IP地址
     */
    public static final String REGEX_IP_ADDR = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";

    /**
     * 校验英文用户名
     *
     * @param username
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isUsernameEn(String username) {
        return Pattern.matches(REGEX_USERNAME_EN, username);
    }

    /**
     * 校验英文用户名（自定义长度）
     *
     * @param username
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isUsernameEn(String username, int min, int max) {
        String reg = "^[a-zA-Z]\\w{" + min + "," + max + "}$";
        return Pattern.matches(reg, username);
    }

    /**
     * 校验中文用户名
     *
     * @param username
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isUsernameCn(String username) {
        return Pattern.matches(REGEX_USERNAME_CN, username);
    }

    /**
     * 校验中文用户名（自定义长度）
     *
     * @param username
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isUsernameCn(String username, int min, int max) {
        String reg = "^[\u4e00-\u9fa5]{" + min + "," + max + "}$";
        return Pattern.matches(reg, username);
    }

    /**
     * 校验密码
     *
     * @param password 默认长度 6 - 16
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isPassword(String password) {
        return Pattern.matches(REGEX_PASSWORD, password);
    }

    /**
     * 校验密码（自定义长度）
     *
     * @param password 默认长度 6 - 16
     * @param min 最小长度
     * @param max 最大长度
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isPassword(String password, Integer min, Integer max) {
        String reg = "^[a-zA-Z0-9]{" + min + "," + max + "}$";
        return Pattern.matches(reg, password);
    }

    /**
     * 检测是否有特殊字符
     *
     * @param text
     * @return
     */
    public static boolean isExistsSpecialStr(String text) {
        String str = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern pattern = Pattern.compile(str);
        Matcher match = pattern.matcher(text);
        if (match.find())
            return true;
        else
            return false;
    }

    /**
     * 检测SQL关键字防止SQL注入
     *
     * @param text 文本内容
     * @return
     */
    public static String isExistsSQLKeyword(String text) {
        String strResult = text.toUpperCase();
        String strKeyword = "DELETE|UPDATE|DROP|UNION|SELECT|EXEC|XP_CMDSHELL|XP_REGREAD|CHAR(|TRUNCATE";
        strResult = strResult.replace("'", "''");
        strResult = strResult.replace(";", "");
        String[] arr_str = strKeyword.split("\\|");
        for (String str : arr_str) {
            if (strResult.indexOf(str) >= 0) {
                strResult = "";
                break;
            }
        }
        return strResult;
    }

    /**
     * 校验手机号
     *
     * @param mobile
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isMobile(String mobile) {
        return Pattern.matches(REGEX_MOBILE, mobile);
    }

    /**
     * 校验邮箱
     *
     * @param email
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isEmail(String email) {
        return Pattern.matches(REGEX_EMAIL, email);
    }

    /**
     * 校验汉字
     *
     * @param chinese
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isChinese(String chinese) {
        return Pattern.matches(REGEX_CHINESE, chinese);
    }

    /**
     * 校验身份证（18位 和 15位）
     *
     * @param idCard
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isIDCard(String idCard) {
        return Pattern.matches(REGEX_ID_CARD, idCard);
    }

    /**
     * 校验身份证（18位）
     *
     * @param idCard
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isIDCard18(String idCard) {
        return Pattern.matches(REGEX_ID_CARD_18, idCard);
    }

    /**
     * 校验身份证（15位）
     *
     * @param idCard
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isIDCard15(String idCard) {
        return Pattern.matches(REGEX_ID_CARD_15, idCard);
    }

    /**
     * 校验URL
     *
     * @param url
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isUrl(String url) {
        return Pattern.matches(REGEX_URL, url);
    }

    /**
     * 校验IP地址
     *
     * @param ipAddr
     * @return
     */
    public static boolean isIPAddr(String ipAddr) {
        return Pattern.matches(REGEX_IP_ADDR, ipAddr);
    }

    /**
     * 自定义正则校验
     * @param regex
     * @param str
     * @return
     */
    public static boolean regexValidate(String regex, String str) {
        return Pattern.matches(regex, str);
    }

}
