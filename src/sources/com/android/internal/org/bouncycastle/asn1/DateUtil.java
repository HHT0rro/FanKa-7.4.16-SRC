package com.android.internal.org.bouncycastle.asn1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class DateUtil {
    private static Long ZERO = longValueOf(0);
    private static final Map localeCache = new HashMap();
    static Locale EN_Locale = forEN();

    DateUtil() {
    }

    private static Locale forEN() {
        if ("en".equalsIgnoreCase(Locale.getDefault().getLanguage())) {
            return Locale.getDefault();
        }
        Locale[] locales = Locale.getAvailableLocales();
        for (int i10 = 0; i10 != locales.length; i10++) {
            if ("en".equalsIgnoreCase(locales[i10].getLanguage())) {
                return locales[i10];
            }
        }
        return Locale.getDefault();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Date epochAdjust(Date date) throws ParseException {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return date;
        }
        Map map = localeCache;
        synchronized (map) {
            Long adj = (Long) map.get(locale);
            if (adj == null) {
                SimpleDateFormat dateF = new SimpleDateFormat("yyyyMMddHHmmssz");
                long v2 = dateF.parse("19700101000000GMT+00:00").getTime();
                if (v2 == 0) {
                    adj = ZERO;
                } else {
                    adj = longValueOf(v2);
                }
                map.put(locale, adj);
            }
            if (adj == ZERO) {
                return date;
            }
            return new Date(date.getTime() - adj.longValue());
        }
    }

    private static Long longValueOf(long v2) {
        return Long.valueOf(v2);
    }
}
