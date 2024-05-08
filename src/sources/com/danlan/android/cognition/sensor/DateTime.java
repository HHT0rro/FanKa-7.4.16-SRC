package com.danlan.android.cognition.sensor;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.danlan.android.cognition.StringFog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
final class DateTime {
    public static String buildISODate(long j10) {
        return buildISODate(new Date(j10));
    }

    public static String buildISODate(Date date) {
        return getISODateFormat().format(date);
    }

    public static String buildISODateFromCurrentTime() {
        return buildISODate(new Date(System.currentTimeMillis()));
    }

    @RequiresApi(24)
    private static String getDateFormat() {
        return StringFog.decrypt("WFpdWgxuaQxFRwRraRlJTBtQVw1ycHc=");
    }

    private static String getDateFormatLegacy() {
        return StringFog.decrypt("WFpdWgxuaQxFRwRraRlJTBtQVw1ycHc=");
    }

    public static SimpleDateFormat getISODateFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Build.VERSION.SDK_INT <= 23 ? getDateFormatLegacy() : getDateFormat(), Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        return simpleDateFormat;
    }

    public static long utcSecondsSinceEpoch() {
        return new Date().getTime() / 1000;
    }
}
