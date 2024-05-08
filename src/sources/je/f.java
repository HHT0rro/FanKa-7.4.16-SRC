package je;

import org.joda.convert.ToString;
import org.joda.time.DurationFieldType;
import org.joda.time.MutablePeriod;
import org.joda.time.Period;
import org.joda.time.format.j;
import org.joda.time.format.n;
import org.joda.time.l;

/* compiled from: AbstractPeriod.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class f implements l {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (size() != lVar.size()) {
            return false;
        }
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (getValue(i10) != lVar.getValue(i10) || getFieldType(i10) != lVar.getFieldType(i10)) {
                return false;
            }
        }
        return true;
    }

    @Override // org.joda.time.l
    public int get(DurationFieldType durationFieldType) {
        int indexOf = indexOf(durationFieldType);
        if (indexOf == -1) {
            return 0;
        }
        return getValue(indexOf);
    }

    @Override // org.joda.time.l
    public DurationFieldType getFieldType(int i10) {
        return getPeriodType().getFieldType(i10);
    }

    public DurationFieldType[] getFieldTypes() {
        int size = size();
        DurationFieldType[] durationFieldTypeArr = new DurationFieldType[size];
        for (int i10 = 0; i10 < size; i10++) {
            durationFieldTypeArr[i10] = getFieldType(i10);
        }
        return durationFieldTypeArr;
    }

    public int[] getValues() {
        int size = size();
        int[] iArr = new int[size];
        for (int i10 = 0; i10 < size; i10++) {
            iArr[i10] = getValue(i10);
        }
        return iArr;
    }

    public int hashCode() {
        int size = size();
        int i10 = 17;
        for (int i11 = 0; i11 < size; i11++) {
            i10 = (((i10 * 27) + getValue(i11)) * 27) + getFieldType(i11).hashCode();
        }
        return i10;
    }

    public int indexOf(DurationFieldType durationFieldType) {
        return getPeriodType().indexOf(durationFieldType);
    }

    public boolean isSupported(DurationFieldType durationFieldType) {
        return getPeriodType().isSupported(durationFieldType);
    }

    @Override // org.joda.time.l
    public int size() {
        return getPeriodType().size();
    }

    public MutablePeriod toMutablePeriod() {
        return new MutablePeriod(this);
    }

    public Period toPeriod() {
        return new Period(this);
    }

    @ToString
    public String toString() {
        return j.a().i(this);
    }

    public String toString(n nVar) {
        if (nVar == null) {
            return toString();
        }
        return nVar.i(this);
    }
}
