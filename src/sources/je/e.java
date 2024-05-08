package je;

import org.joda.time.DateTime;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationFieldType;
import org.joda.time.i;
import org.joda.time.k;

/* compiled from: AbstractPartial.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class e implements k, Comparable<k> {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        if (size() != kVar.size()) {
            return false;
        }
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (getValue(i10) != kVar.getValue(i10) || getFieldType(i10) != kVar.getFieldType(i10)) {
                return false;
            }
        }
        return org.joda.time.field.e.a(getChronology(), kVar.getChronology());
    }

    @Override // org.joda.time.k
    public int get(DateTimeFieldType dateTimeFieldType) {
        return getValue(indexOfSupported(dateTimeFieldType));
    }

    @Override // org.joda.time.k
    public org.joda.time.b getField(int i10) {
        return getField(i10, getChronology());
    }

    public abstract org.joda.time.b getField(int i10, org.joda.time.a aVar);

    @Override // org.joda.time.k
    public DateTimeFieldType getFieldType(int i10) {
        return getField(i10, getChronology()).getType();
    }

    public DateTimeFieldType[] getFieldTypes() {
        int size = size();
        DateTimeFieldType[] dateTimeFieldTypeArr = new DateTimeFieldType[size];
        for (int i10 = 0; i10 < size; i10++) {
            dateTimeFieldTypeArr[i10] = getFieldType(i10);
        }
        return dateTimeFieldTypeArr;
    }

    public org.joda.time.b[] getFields() {
        int size = size();
        org.joda.time.b[] bVarArr = new org.joda.time.b[size];
        for (int i10 = 0; i10 < size; i10++) {
            bVarArr[i10] = getField(i10);
        }
        return bVarArr;
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
        int i10 = 157;
        for (int i11 = 0; i11 < size; i11++) {
            i10 = (((i10 * 23) + getValue(i11)) * 23) + getFieldType(i11).hashCode();
        }
        return i10 + getChronology().hashCode();
    }

    public int indexOf(DateTimeFieldType dateTimeFieldType) {
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (getFieldType(i10) == dateTimeFieldType) {
                return i10;
            }
        }
        return -1;
    }

    public int indexOfSupported(DateTimeFieldType dateTimeFieldType) {
        int indexOf = indexOf(dateTimeFieldType);
        if (indexOf != -1) {
            return indexOf;
        }
        throw new IllegalArgumentException("Field '" + ((Object) dateTimeFieldType) + "' is not supported");
    }

    public boolean isAfter(k kVar) {
        if (kVar != null) {
            return compareTo(kVar) > 0;
        }
        throw new IllegalArgumentException("Partial cannot be null");
    }

    public boolean isBefore(k kVar) {
        if (kVar != null) {
            return compareTo(kVar) < 0;
        }
        throw new IllegalArgumentException("Partial cannot be null");
    }

    public boolean isEqual(k kVar) {
        if (kVar != null) {
            return compareTo(kVar) == 0;
        }
        throw new IllegalArgumentException("Partial cannot be null");
    }

    @Override // org.joda.time.k
    public boolean isSupported(DateTimeFieldType dateTimeFieldType) {
        return indexOf(dateTimeFieldType) != -1;
    }

    public DateTime toDateTime(i iVar) {
        org.joda.time.a g3 = org.joda.time.c.g(iVar);
        return new DateTime(g3.set(this, org.joda.time.c.h(iVar)), g3);
    }

    public String toString(org.joda.time.format.b bVar) {
        if (bVar == null) {
            return toString();
        }
        return bVar.l(this);
    }

    @Override // java.lang.Comparable
    public int compareTo(k kVar) {
        if (this == kVar) {
            return 0;
        }
        if (size() == kVar.size()) {
            int size = size();
            for (int i10 = 0; i10 < size; i10++) {
                if (getFieldType(i10) != kVar.getFieldType(i10)) {
                    throw new ClassCastException("ReadablePartial objects must have matching field types");
                }
            }
            int size2 = size();
            for (int i11 = 0; i11 < size2; i11++) {
                if (getValue(i11) > kVar.getValue(i11)) {
                    return 1;
                }
                if (getValue(i11) < kVar.getValue(i11)) {
                    return -1;
                }
            }
            return 0;
        }
        throw new ClassCastException("ReadablePartial objects must have matching field types");
    }

    public int indexOf(DurationFieldType durationFieldType) {
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (getFieldType(i10).getDurationType() == durationFieldType) {
                return i10;
            }
        }
        return -1;
    }

    public int indexOfSupported(DurationFieldType durationFieldType) {
        int indexOf = indexOf(durationFieldType);
        if (indexOf != -1) {
            return indexOf;
        }
        throw new IllegalArgumentException("Field '" + ((Object) durationFieldType) + "' is not supported");
    }
}
