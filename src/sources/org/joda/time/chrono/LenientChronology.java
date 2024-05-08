package org.joda.time.chrono;

import org.joda.time.DateTimeZone;
import org.joda.time.chrono.AssembledChronology;
import org.joda.time.field.LenientDateTimeField;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class LenientChronology extends AssembledChronology {
    private static final long serialVersionUID = -3148237568046877177L;
    private transient org.joda.time.a iWithUTC;

    private LenientChronology(org.joda.time.a aVar) {
        super(aVar, null);
    }

    private final org.joda.time.b convertField(org.joda.time.b bVar) {
        return LenientDateTimeField.getInstance(bVar, getBase());
    }

    public static LenientChronology getInstance(org.joda.time.a aVar) {
        if (aVar != null) {
            return new LenientChronology(aVar);
        }
        throw new IllegalArgumentException("Must supply a chronology");
    }

    @Override // org.joda.time.chrono.AssembledChronology
    public void assemble(AssembledChronology.a aVar) {
        aVar.E = convertField(aVar.E);
        aVar.F = convertField(aVar.F);
        aVar.G = convertField(aVar.G);
        aVar.H = convertField(aVar.H);
        aVar.I = convertField(aVar.I);
        aVar.f52472x = convertField(aVar.f52472x);
        aVar.f52473y = convertField(aVar.f52473y);
        aVar.f52474z = convertField(aVar.f52474z);
        aVar.D = convertField(aVar.D);
        aVar.A = convertField(aVar.A);
        aVar.B = convertField(aVar.B);
        aVar.C = convertField(aVar.C);
        aVar.f52461m = convertField(aVar.f52461m);
        aVar.f52462n = convertField(aVar.f52462n);
        aVar.f52463o = convertField(aVar.f52463o);
        aVar.f52464p = convertField(aVar.f52464p);
        aVar.f52465q = convertField(aVar.f52465q);
        aVar.f52466r = convertField(aVar.f52466r);
        aVar.f52467s = convertField(aVar.f52467s);
        aVar.f52469u = convertField(aVar.f52469u);
        aVar.f52468t = convertField(aVar.f52468t);
        aVar.f52470v = convertField(aVar.f52470v);
        aVar.f52471w = convertField(aVar.f52471w);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LenientChronology) {
            return getBase().equals(((LenientChronology) obj).getBase());
        }
        return false;
    }

    public int hashCode() {
        return (getBase().hashCode() * 7) + 236548278;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public String toString() {
        return "LenientChronology[" + getBase().toString() + ']';
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public org.joda.time.a withUTC() {
        if (this.iWithUTC == null) {
            if (getZone() == DateTimeZone.UTC) {
                this.iWithUTC = this;
            } else {
                this.iWithUTC = getInstance(getBase().withUTC());
            }
        }
        return this.iWithUTC;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public org.joda.time.a withZone(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        if (dateTimeZone == DateTimeZone.UTC) {
            return withUTC();
        }
        return dateTimeZone == getZone() ? this : getInstance(getBase().withZone(dateTimeZone));
    }
}
