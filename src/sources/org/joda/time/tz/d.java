package org.joda.time.tz;

import com.google.android.material.datepicker.UtcDates;
import java.util.Collections;
import java.util.Set;
import org.joda.time.DateTimeZone;

/* compiled from: UTCProvider.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class d implements c {

    /* renamed from: a, reason: collision with root package name */
    public static final Set<String> f52707a = Collections.singleton(UtcDates.UTC);

    @Override // org.joda.time.tz.c
    public DateTimeZone a(String str) {
        if (UtcDates.UTC.equalsIgnoreCase(str)) {
            return DateTimeZone.UTC;
        }
        return null;
    }

    @Override // org.joda.time.tz.c
    public Set<String> b() {
        return f52707a;
    }
}
