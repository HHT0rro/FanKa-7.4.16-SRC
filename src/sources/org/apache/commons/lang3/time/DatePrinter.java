package org.apache.commons.lang3.time;

import java.text.FieldPosition;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface DatePrinter {
    <B extends Appendable> B format(long j10, B b4);

    <B extends Appendable> B format(Calendar calendar, B b4);

    <B extends Appendable> B format(Date date, B b4);

    String format(long j10);

    String format(Calendar calendar);

    String format(Date date);

    @Deprecated
    StringBuffer format(long j10, StringBuffer stringBuffer);

    StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition);

    @Deprecated
    StringBuffer format(Calendar calendar, StringBuffer stringBuffer);

    @Deprecated
    StringBuffer format(Date date, StringBuffer stringBuffer);

    Locale getLocale();

    String getPattern();

    TimeZone getTimeZone();
}
