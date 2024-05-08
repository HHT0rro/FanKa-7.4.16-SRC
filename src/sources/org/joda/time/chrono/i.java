package org.joda.time.chrono;

import java.util.Locale;
import org.joda.time.DateTimeFieldType;

/* compiled from: GJDayOfWeekDateTimeField.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class i extends org.joda.time.field.h {

    /* renamed from: d, reason: collision with root package name */
    public final BasicChronology f52507d;

    public i(BasicChronology basicChronology, org.joda.time.d dVar) {
        super(DateTimeFieldType.dayOfWeek(), dVar);
        this.f52507d = basicChronology;
    }

    @Override // org.joda.time.field.b
    public int a(String str, Locale locale) {
        return k.h(locale).c(str);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int get(long j10) {
        return this.f52507d.getDayOfWeek(j10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public String getAsShortText(int i10, Locale locale) {
        return k.h(locale).d(i10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public String getAsText(int i10, Locale locale) {
        return k.h(locale).e(i10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMaximumShortTextLength(Locale locale) {
        return k.h(locale).i();
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMaximumTextLength(Locale locale) {
        return k.h(locale).j();
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMaximumValue() {
        return 7;
    }

    @Override // org.joda.time.field.h, org.joda.time.field.b, org.joda.time.b
    public int getMinimumValue() {
        return 1;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public org.joda.time.d getRangeDurationField() {
        return this.f52507d.weeks();
    }
}
