package com.huawei.hms.scankit.p;

import com.huawei.hms.ml.scan.HmsScan;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CalendarDateTimeParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class d3 {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f30836a = Pattern.compile("(\\d{4})(\\d{2})(\\d{2})T(\\d{2})(\\d{2})(\\d{2})Z");

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f30837b = Pattern.compile("(\\d{4})(\\d{2})(\\d{2})T(\\d{2})(\\d{2})(\\d{2})");

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f30838c = Pattern.compile("(\\d{4})(\\d{2})(\\d{2})");

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f30839d = Pattern.compile("(\\d{4})(\\d{2})(\\d{2})\\d{6}Z");

    public static void a(String str, HmsScan.EventTime eventTime) {
        Matcher matcher = f30836a.matcher(str);
        Matcher matcher2 = f30837b.matcher(str);
        Matcher matcher3 = f30838c.matcher(str);
        Matcher matcher4 = f30839d.matcher(str);
        try {
            if (matcher.matches()) {
                a(eventTime, Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)));
                b(eventTime, Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
                eventTime.isUTCTime = true;
                eventTime.originalValue = str;
            } else if (matcher2.matches()) {
                a(eventTime, Integer.parseInt(matcher2.group(1)), Integer.parseInt(matcher2.group(2)), Integer.parseInt(matcher2.group(3)));
                b(eventTime, Integer.parseInt(matcher2.group(4)), Integer.parseInt(matcher2.group(5)), Integer.parseInt(matcher2.group(6)));
                eventTime.originalValue = str;
            } else if (matcher3.matches()) {
                a(eventTime, Integer.parseInt(matcher3.group(1)), Integer.parseInt(matcher3.group(2)), Integer.parseInt(matcher3.group(3)));
                eventTime.originalValue = str;
            } else if (matcher4.matches()) {
                a(eventTime, Integer.parseInt(matcher4.group(1)), Integer.parseInt(matcher4.group(2)), Integer.parseInt(matcher4.group(3)));
            }
        } catch (NullPointerException unused) {
            o4.b("exception", "NullPointerException");
        }
    }

    private static void b(HmsScan.EventTime eventTime, int i10, int i11, int i12) {
        eventTime.hours = i10;
        eventTime.minutes = i11;
        eventTime.seconds = i12;
    }

    private static void a(HmsScan.EventTime eventTime, int i10, int i11, int i12) {
        eventTime.year = i10;
        eventTime.month = i11;
        eventTime.day = i12;
    }
}
