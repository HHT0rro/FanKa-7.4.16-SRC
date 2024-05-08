package org.joda.time.base;

import java.io.Serializable;
import java.util.Locale;
import je.e;
import ke.d;
import ke.l;
import org.joda.time.a;
import org.joda.time.c;
import org.joda.time.format.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class BasePartial extends e implements Serializable {
    private static final long serialVersionUID = 2353678632973660L;
    private final a iChronology;
    private final int[] iValues;

    public BasePartial() {
        this(c.b(), (a) null);
    }

    @Override // org.joda.time.k
    public a getChronology() {
        return this.iChronology;
    }

    @Override // org.joda.time.k
    public int getValue(int i10) {
        return this.iValues[i10];
    }

    @Override // je.e
    public int[] getValues() {
        return (int[]) this.iValues.clone();
    }

    public void setValue(int i10, int i11) {
        int[] iArr = getField(i10).set(this, i10, this.iValues, i11);
        int[] iArr2 = this.iValues;
        System.arraycopy((Object) iArr, 0, (Object) iArr2, 0, iArr2.length);
    }

    public void setValues(int[] iArr) {
        getChronology().validate(this, iArr);
        int[] iArr2 = this.iValues;
        System.arraycopy((Object) iArr, 0, (Object) iArr2, 0, iArr2.length);
    }

    @Override // org.joda.time.k
    public abstract /* synthetic */ int size();

    public String toString(String str) {
        if (str == null) {
            return toString();
        }
        return org.joda.time.format.a.b(str).l(this);
    }

    public BasePartial(a aVar) {
        this(c.b(), aVar);
    }

    public BasePartial(long j10) {
        this(j10, (a) null);
    }

    public String toString(String str, Locale locale) throws IllegalArgumentException {
        if (str == null) {
            return toString();
        }
        return org.joda.time.format.a.b(str).v(locale).l(this);
    }

    public BasePartial(long j10, a aVar) {
        a c4 = c.c(aVar);
        this.iChronology = c4.withUTC();
        this.iValues = c4.get(this, j10);
    }

    public BasePartial(Object obj, a aVar) {
        l e2 = d.b().e(obj);
        a c4 = c.c(e2.a(obj, aVar));
        this.iChronology = c4.withUTC();
        this.iValues = e2.i(this, obj, c4);
    }

    public BasePartial(Object obj, a aVar, b bVar) {
        l e2 = d.b().e(obj);
        a c4 = c.c(e2.a(obj, aVar));
        this.iChronology = c4.withUTC();
        this.iValues = e2.f(this, obj, c4, bVar);
    }

    public BasePartial(int[] iArr, a aVar) {
        a c4 = c.c(aVar);
        this.iChronology = c4.withUTC();
        c4.validate(this, iArr);
        this.iValues = iArr;
    }

    public BasePartial(BasePartial basePartial, int[] iArr) {
        this.iChronology = basePartial.iChronology;
        this.iValues = iArr;
    }

    public BasePartial(BasePartial basePartial, a aVar) {
        this.iChronology = aVar.withUTC();
        this.iValues = basePartial.iValues;
    }
}
