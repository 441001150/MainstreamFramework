package com.runen.wnhz.runen.common.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    public static boolean isNotEmpty(String str) {
        if (str != null && str.length() > 0 && !str.equals("null")) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str)) {
            return true;
        }
        return false;
    }

    /**
     * 过滤空字符,防止报空指针
     */
    public static String filterNull(String string) {
        if (string != null && string.length() > 0 && !string.equals("null")) {
            return string;
        } else {
            return "";
        }
    }

    /**
     * 使用java正则表达式去掉多余的.与0
     *
     * @param s
     * @return
     */
    public static String subZeroAndDot(String s) {
        if (s.indexOf(".") > 0) {
            s = s.replaceAll("0+?$", "");//去掉多余的0
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        return s;
    }

    /**
     * double转String,保留小数点后两位
     *
     * @param num
     * @return
     */
    public static String doubleToString(double num) {
        //使用0.00不足位补0，#.##仅保留有效位
        return new DecimalFormat("0.00").format(num);
    }

    /**
     * 格式化字符串，每隔一定位数加空格
     *
     * @param text 需要格式化的字符串
     * @param num  每隔多少位
     * @return
     */
    public static String formatBankNum(String text, int num) {
        text = " " + text;
        String result = "";
        for (int i = 0; i < text.length(); i++) {

            if (i % num == 0 && i != 0) {
                result += text.charAt(i) + "\u0020" + "\u0020";
            } else {
                result += text.charAt(i);
            }
        }
        return result.trim();
    }


    /***
     * 替换所有空格
     * @param text
     * @return
     */
    public static String replaceSpace(String text) {
        if (isNotEmpty(text)) {
            return text.replaceAll(" +", "");
        } else {
            return "";
        }
    }

    /***
     * 回车替换成空格
     * @param text
     * @return
     */
    public static String replaceEnter2Space(String text) {
        if (isNotEmpty(text)) {
            return text.replaceAll("[\\t\\n\\r]", " ");
        } else {
            return "";
        }
    }

    /***
     * 格式化手机号码
     * @param text
     * @return
     */
    public static String formatPhoneNum(String text) {


        if (text.length() == 11) {
            
            StringBuffer stringBuffer = new StringBuffer(text);
            stringBuffer.insert(3, " ");
            stringBuffer.insert(8, " ");
            return stringBuffer.toString();
        } else {
            return text;
        }

    }

    /***
     * 格式化手机号码
     * @param text
     * @return
     */
    public static String encryptionPhoneNum(String text) {


        if (text.length() == 11) {
            String num1 = text.substring(0, 3);
            String num2 = text.substring(7, text.length());
            return num1 + "****" + num2;

//            StringBuffer stringBuffer = new StringBuffer(text);
//            stringBuffer.insert(3, " ");
//            stringBuffer.insert(8, " ");
//            return stringBuffer.toString();
        } else {
            return text;
        }

    }

    /**
     * 关键字高亮显示
     *
     * @param keyword 需要高亮的关键字
     * @param content 需要显示的文字
     * @return spannable 处理完后的结果，记得不要toString()，否则没有效果
     */
    public static SpannableString setKeyWordColor(String content, String keyword, int color) {
        try {
            SpannableString style = new SpannableString(content);
            if (isNotEmpty(keyword)) {
                int fstart = content.indexOf(keyword);
                int fend = fstart + keyword.length();
                if (fstart != -1 && fend <= content.length()) {
                    style.setSpan(new ForegroundColorSpan(color), fstart, fend, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
                }
            }
            return style;
        } catch (Exception e) {
            return new SpannableString(content);
        }
    }

    /**
     * 取括号中的字符
     *
     * @param msg
     * @return
     */
    public static String extractMessageByRegular(String msg) {
        int startIndex = 0;
        int endIndex = 0;
        if (msg.contains("(") || msg.contains("（") || msg.contains(")") || msg.contains("）")) {
            if (msg.contains("(")) {
                startIndex = msg.lastIndexOf("(");
            }
            if (msg.contains("（") && msg.lastIndexOf("（") > startIndex) {
                startIndex = msg.lastIndexOf("（");
            }

            if (msg.contains(")")) {
                endIndex = msg.indexOf(")");
            }
            if (msg.contains("）") && msg.indexOf("）") < endIndex) {
                endIndex = msg.indexOf("）");
            }
            if (endIndex == 0 || endIndex < startIndex) {
                return msg;
            }
            return msg.substring(startIndex + 1, endIndex);
        }
        return msg;
    }

    /**
     * 是否有emoji
     *
     * @param str
     * @return
     */
    public static boolean containsEmoji(String str) {
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (isEmojiCharacter(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEmojiCharacter(char codePoint) {
        return !((codePoint == 0x0) ||
                (codePoint == 0x9) ||
                (codePoint == 0xA) ||
                (codePoint == 0xD) ||
                ((codePoint >= 0x20) && (codePoint <= 0xD7FF)) ||
                ((codePoint >= 0xE000) && (codePoint <= 0xFFFD)) ||
                ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF)));
    }

    /**
     * 从字符串中查找数字字符串
     */
    public static List<String> getNumbers(String content) {
        List<String> digitList = new ArrayList<String>();
        Pattern p = Pattern.compile("(\\d+)");
        Matcher m = p.matcher(content);
        while (m.find()) {
            String find = m.group(1).toString();
            if (find.length() >= 8 && find.length() <= 11) {
                digitList.add(find);
            }
        }
        return digitList;
    }

    /**
     * 从字符串中查找数字字符串
     */
    public static List<String> getUrls(String content) {
        List<String> digitList = new ArrayList<String>();
        Pattern p = Pattern.compile("(\\d+)");
        Matcher m = p.matcher(content);
        while (m.find()) {
            String find = m.group(1).toString();
            if (find.length() >= 8 && find.length() <= 11) {
                digitList.add(find);
            }
        }
        return digitList;
    }

    /**
     * 从字符串中查找url
     */
    public static List<String> getUrlsInContent(String content) {
        List<String> termList = new ArrayList<String>();

//        String patternString = "[http|https]+[://]+[0-9A-Za-z:/[-]_#[?][=][.][&][%]]*";
//        String patternString = "[A-Za-z:/]+[.]+[0-9A-Za-z:/[-]_#[?][=][.][&][%]]*";
        String patternString = "((http|ftp|https)://)(([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,4})*(/[a-zA-Z0-9\\&%_\\./-~-]*)?|(([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,4})*(/[a-zA-Z0-9\\&%_\\./-~-]*)?";


        Pattern pattern = Pattern.compile(patternString);

        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            termList.add(matcher.group());
        }

        return termList;
    }

    public static void copyUtil(Context context, String content) {
        WeakReference<Context> w_context = new WeakReference<Context>(context);
        ClipboardManager copy = (ClipboardManager) w_context.get().getSystemService(Context.CLIPBOARD_SERVICE);
        copy.setPrimaryClip(ClipData.newPlainText(null, content));
    }

}
