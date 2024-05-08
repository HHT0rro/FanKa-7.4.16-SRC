package ke;

import java.util.Calendar;
import java.util.GregorianCalendar;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.chrono.GJChronology;
import org.joda.time.chrono.GregorianChronology;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.chrono.JulianChronology;

/* compiled from: CalendarConverter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class b extends a implements h, l {

    /* renamed from: a, reason: collision with root package name */
    public static final b f50880a = new b();

    @Override // ke.a, ke.h, ke.l
    public org.joda.time.a a(Object obj, org.joda.time.a aVar) {
        DateTimeZone dateTimeZone;
        if (aVar != null) {
            return aVar;
        }
        Calendar calendar = (Calendar) obj;
        try {
            dateTimeZone = DateTimeZone.forTimeZone(calendar.getTimeZone());
        } catch (IllegalArgumentException unused) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        return b(calendar, dateTimeZone);
    }

    @Override // ke.a, ke.h, ke.l
    public org.joda.time.a b(Object obj, DateTimeZone dateTimeZone) {
        if (obj.getClass().getName().endsWith(".BuddhistCalendar")) {
            return BuddhistChronology.getInstance(dateTimeZone);
        }
        if (obj instanceof GregorianCalendar) {
            long time = ((GregorianCalendar) obj).getGregorianChange().getTime();
            if (time == Long.MIN_VALUE) {
                return GregorianChronology.getInstance(dateTimeZone);
            }
            if (time == Long.MAX_VALUE) {
                return JulianChronology.getInstance(dateTimeZone);
            }
            return GJChronology.getInstance(dateTimeZone, time, 4);
        }
        return ISOChronology.getInstance(dateTimeZone);
    }

    @Override // ke.c
    public Class<?> e() {
        return Calendar.class;
    }

    @Override // ke.a, ke.h
    public long k(Object obj, org.joda.time.a aVar) {
        return ((Calendar) obj).getTime().getTime();
    }
}
