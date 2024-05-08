package org.joda.time.chrono;

import java.util.Locale;

/* compiled from: GJMonthOfYearDateTimeField.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class l extends c {
    public l(BasicChronology basicChronology) {
        super(basicChronology, 2);
    }

    @Override // org.joda.time.field.b
    public int a(String str, Locale locale) {
        return k.h(locale).r(str);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public String getAsShortText(int i10, Locale locale) {
        return k.h(locale).s(i10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public String getAsText(int i10, Locale locale) {
        return k.h(locale).t(i10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMaximumShortTextLength(Locale locale) {
        return k.h(locale).m();
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMaximumTextLength(Locale locale) {
        return k.h(locale).n();
    }
}
