package org.apache.commons.lang3.time;

import com.google.android.material.datepicker.UtcDates;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class FastTimeZone {
    private static final Pattern GMT_PATTERN = Pattern.compile("^(?:(?i)GMT)?([+-])?(\\d\\d?)?(:?(\\d\\d?))?$");
    private static final TimeZone GREENWICH = new GmtTimeZone(false, 0, 0);

    private FastTimeZone() {
    }

    public static TimeZone getGmtTimeZone() {
        return GREENWICH;
    }

    public static TimeZone getTimeZone(String str) {
        TimeZone gmtTimeZone = getGmtTimeZone(str);
        return gmtTimeZone != null ? gmtTimeZone : TimeZone.getTimeZone(str);
    }

    private static int parseInt(String str) {
        if (str != null) {
            return Integer.parseInt(str);
        }
        return 0;
    }

    private static boolean parseSign(String str) {
        return str != null && str.charAt(0) == '-';
    }

    public static TimeZone getGmtTimeZone(String str) {
        if (!"Z".equals(str) && !UtcDates.UTC.equals(str)) {
            Matcher matcher = GMT_PATTERN.matcher(str);
            if (!matcher.matches()) {
                return null;
            }
            int parseInt = parseInt(matcher.group(2));
            int parseInt2 = parseInt(matcher.group(4));
            if (parseInt == 0 && parseInt2 == 0) {
                return GREENWICH;
            }
            return new GmtTimeZone(parseSign(matcher.group(1)), parseInt, parseInt2);
        }
        return GREENWICH;
    }
}
