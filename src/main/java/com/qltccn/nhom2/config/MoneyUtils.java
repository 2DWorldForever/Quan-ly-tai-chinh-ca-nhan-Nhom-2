package com.qltccn.nhom2.config;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Locale;

public class MoneyUtils {

    public static String formatMoney(BigDecimal money) {
        DecimalFormat df = new DecimalFormat("#,###");
        return df.format(money);
    }
}
