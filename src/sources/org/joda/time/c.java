package org.joda.time;

import com.google.android.material.datepicker.UtcDates;
import java.text.DateFormatSymbols;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.lang3.time.TimeZones;
import org.joda.time.chrono.ISOChronology;

/* compiled from: DateTimeUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final a f52446a;

    /* renamed from: b, reason: collision with root package name */
    public static volatile a f52447b;

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicReference<Map<String, DateTimeZone>> f52448c;

    /* compiled from: DateTimeUtils.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface a {
        long getMillis();
    }

    /* compiled from: DateTimeUtils.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class b implements a {
        @Override // org.joda.time.c.a
        public long getMillis() {
            return System.currentTimeMillis();
        }
    }

    static {
        b bVar = new b();
        f52446a = bVar;
        f52447b = bVar;
        f52448c = new AtomicReference<>();
    }

    public static Map<String, DateTimeZone> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        DateTimeZone dateTimeZone = DateTimeZone.UTC;
        linkedHashMap.put("UT", dateTimeZone);
        linkedHashMap.put(UtcDates.UTC, dateTimeZone);
        linkedHashMap.put(TimeZones.GMT_ID, dateTimeZone);
        o(linkedHashMap, "EST", "America/New_York");
        o(linkedHashMap, "EDT", "America/New_York");
        o(linkedHashMap, "CST", "America/Chicago");
        o(linkedHashMap, "CDT", "America/Chicago");
        o(linkedHashMap, "MST", "America/Denver");
        o(linkedHashMap, "MDT", "America/Denver");
        o(linkedHashMap, "PST", "America/Los_Angeles");
        o(linkedHashMap, "PDT", "America/Los_Angeles");
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public static final long b() {
        return f52447b.getMillis();
    }

    public static final org.joda.time.a c(org.joda.time.a aVar) {
        return aVar == null ? ISOChronology.getInstance() : aVar;
    }

    public static final DateFormatSymbols d(Locale locale) {
        try {
            return (DateFormatSymbols) DateFormatSymbols.class.getMethod("getInstance", Locale.class).invoke(null, locale);
        } catch (Exception unused) {
            return new DateFormatSymbols(locale);
        }
    }

    public static final Map<String, DateTimeZone> e() {
        AtomicReference<Map<String, DateTimeZone>> atomicReference = f52448c;
        Map<String, DateTimeZone> map = atomicReference.get();
        if (map != null) {
            return map;
        }
        Map<String, DateTimeZone> a10 = a();
        return !atomicReference.compareAndSet(null, a10) ? atomicReference.get() : a10;
    }

    public static final long f(h hVar) {
        if (hVar == null) {
            return 0L;
        }
        return hVar.getMillis();
    }

    public static final org.joda.time.a g(i iVar) {
        if (iVar == null) {
            return ISOChronology.getInstance();
        }
        org.joda.time.a chronology = iVar.getChronology();
        return chronology == null ? ISOChronology.getInstance() : chronology;
    }

    public static final long h(i iVar) {
        if (iVar == null) {
            return b();
        }
        return iVar.getMillis();
    }

    public static final org.joda.time.a i(i iVar, i iVar2) {
        org.joda.time.a chronology;
        if (iVar != null) {
            chronology = iVar.getChronology();
        } else {
            chronology = iVar2 != null ? iVar2.getChronology() : null;
        }
        return chronology == null ? ISOChronology.getInstance() : chronology;
    }

    public static final org.joda.time.a j(j jVar) {
        if (jVar == null) {
            return ISOChronology.getInstance();
        }
        org.joda.time.a chronology = jVar.getChronology();
        return chronology == null ? ISOChronology.getInstance() : chronology;
    }

    public static final PeriodType k(PeriodType periodType) {
        return periodType == null ? PeriodType.standard() : periodType;
    }

    public static final j l(j jVar) {
        if (jVar != null) {
            return jVar;
        }
        long b4 = b();
        return new Interval(b4, b4);
    }

    public static final DateTimeZone m(DateTimeZone dateTimeZone) {
        return dateTimeZone == null ? DateTimeZone.getDefault() : dateTimeZone;
    }

    public static final boolean n(k kVar) {
        if (kVar != null) {
            DurationFieldType durationFieldType = null;
            for (int i10 = 0; i10 < kVar.size(); i10++) {
                org.joda.time.b field = kVar.getField(i10);
                if (i10 > 0 && (field.getRangeDurationField() == null || field.getRangeDurationField().getType() != durationFieldType)) {
                    return false;
                }
                durationFieldType = field.getDurationField().getType();
            }
            return true;
        }
        throw new IllegalArgumentException("Partial must not be null");
    }

    public static void o(Map<String, DateTimeZone> map, String str, String str2) {
        try {
            map.put(str, DateTimeZone.forID(str2));
        } catch (RuntimeException unused) {
        }
    }
}
