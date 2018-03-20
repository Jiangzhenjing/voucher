package com.sunesoft.titan.voucher;

/**
 * @author: Zhouzh
 * @Date: 2017/11/24
 */
public class VSSetting {

    public  static  Integer year=2017;

    public static String cardPrifix = "17";

    public static Integer expiredDateSpan= 15;

    public static Integer afterActiveexpiredDateSpan= 30;

    public  Integer getYear() {
        return year;
    }

    public  void setYear(Integer year) {
        VSSetting.year = year;
    }

    public  String getCardPrifix() {
        return cardPrifix;
    }

    public  void setCardPrifix(String cardPrifix) {
        VSSetting.cardPrifix = cardPrifix;
    }

    public  Integer getExpiredDateSpan() {
        return expiredDateSpan;
    }

    public  void setExpiredDateSpan(Integer expiredDateSpan) {
        VSSetting.expiredDateSpan = expiredDateSpan;
    }

    public static Integer getAfterActiveexpiredDateSpan() {
        return afterActiveexpiredDateSpan;
    }

    public static void setAfterActiveexpiredDateSpan(Integer afterActiveexpiredDateSpan) {
        VSSetting.afterActiveexpiredDateSpan = afterActiveexpiredDateSpan;
    }
}
