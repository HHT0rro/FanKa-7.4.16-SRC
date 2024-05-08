package org.joda.time;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Partial extends je.e implements Serializable {
    private static final long serialVersionUID = 12324121189002L;
    private final a iChronology;
    private transient org.joda.time.format.b[] iFormatter;
    private final DateTimeFieldType[] iTypes;
    private final int[] iValues;

    public Partial() {
        this((a) null);
    }

    @Override // org.joda.time.k
    public a getChronology() {
        return this.iChronology;
    }

    @Override // je.e
    public b getField(int i10, a aVar) {
        return this.iTypes[i10].getField(aVar);
    }

    @Override // je.e, org.joda.time.k
    public DateTimeFieldType getFieldType(int i10) {
        return this.iTypes[i10];
    }

    @Override // je.e
    public DateTimeFieldType[] getFieldTypes() {
        return (DateTimeFieldType[]) this.iTypes.clone();
    }

    public org.joda.time.format.b getFormatter() {
        org.joda.time.format.b[] bVarArr = this.iFormatter;
        if (bVarArr == null) {
            if (size() == 0) {
                return null;
            }
            bVarArr = new org.joda.time.format.b[2];
            try {
                ArrayList arrayList = new ArrayList(Arrays.asList(this.iTypes));
                bVarArr[0] = org.joda.time.format.i.j(arrayList, true, false);
                if (arrayList.size() == 0) {
                    bVarArr[1] = bVarArr[0];
                }
            } catch (IllegalArgumentException unused) {
            }
            this.iFormatter = bVarArr;
        }
        return bVarArr[0];
    }

    @Override // org.joda.time.k
    public int getValue(int i10) {
        return this.iValues[i10];
    }

    @Override // je.e
    public int[] getValues() {
        return (int[]) this.iValues.clone();
    }

    public boolean isMatch(i iVar) {
        long h10 = c.h(iVar);
        a g3 = c.g(iVar);
        int i10 = 0;
        while (true) {
            DateTimeFieldType[] dateTimeFieldTypeArr = this.iTypes;
            if (i10 >= dateTimeFieldTypeArr.length) {
                return true;
            }
            if (dateTimeFieldTypeArr[i10].getField(g3).get(h10) != this.iValues[i10]) {
                return false;
            }
            i10++;
        }
    }

    public Partial minus(l lVar) {
        return withPeriodAdded(lVar, -1);
    }

    public Partial plus(l lVar) {
        return withPeriodAdded(lVar, 1);
    }

    public Property property(DateTimeFieldType dateTimeFieldType) {
        return new Property(this, indexOfSupported(dateTimeFieldType));
    }

    @Override // org.joda.time.k
    public int size() {
        return this.iTypes.length;
    }

    public String toString() {
        org.joda.time.format.b[] bVarArr = this.iFormatter;
        if (bVarArr == null) {
            getFormatter();
            bVarArr = this.iFormatter;
            if (bVarArr == null) {
                return toStringList();
            }
        }
        org.joda.time.format.b bVar = bVarArr[1];
        if (bVar == null) {
            return toStringList();
        }
        return bVar.l(this);
    }

    public String toStringList() {
        int size = size();
        StringBuilder sb2 = new StringBuilder(size * 20);
        sb2.append('[');
        for (int i10 = 0; i10 < size; i10++) {
            if (i10 > 0) {
                sb2.append(',');
                sb2.append(' ');
            }
            sb2.append(this.iTypes[i10].getName());
            sb2.append('=');
            sb2.append(this.iValues[i10]);
        }
        sb2.append(']');
        return sb2.toString();
    }

    public Partial with(DateTimeFieldType dateTimeFieldType, int i10) {
        int i11;
        int compareTo;
        if (dateTimeFieldType != null) {
            int indexOf = indexOf(dateTimeFieldType);
            if (indexOf != -1) {
                return i10 == getValue(indexOf) ? this : new Partial(this, getField(indexOf).set(this, indexOf, getValues(), i10));
            }
            int length = this.iTypes.length + 1;
            DateTimeFieldType[] dateTimeFieldTypeArr = new DateTimeFieldType[length];
            int[] iArr = new int[length];
            d field = dateTimeFieldType.getDurationType().getField(this.iChronology);
            if (field.isSupported()) {
                i11 = 0;
                while (true) {
                    DateTimeFieldType[] dateTimeFieldTypeArr2 = this.iTypes;
                    if (i11 >= dateTimeFieldTypeArr2.length) {
                        break;
                    }
                    DateTimeFieldType dateTimeFieldType2 = dateTimeFieldTypeArr2[i11];
                    d field2 = dateTimeFieldType2.getDurationType().getField(this.iChronology);
                    if (field2.isSupported() && ((compareTo = field.compareTo(field2)) > 0 || (compareTo == 0 && (dateTimeFieldType.getRangeDurationType() == null || (dateTimeFieldType2.getRangeDurationType() != null && dateTimeFieldType.getRangeDurationType().getField(this.iChronology).compareTo(dateTimeFieldType2.getRangeDurationType().getField(this.iChronology)) > 0))))) {
                        break;
                    }
                    i11++;
                }
            } else {
                i11 = 0;
            }
            System.arraycopy(this.iTypes, 0, dateTimeFieldTypeArr, 0, i11);
            System.arraycopy((Object) this.iValues, 0, (Object) iArr, 0, i11);
            dateTimeFieldTypeArr[i11] = dateTimeFieldType;
            iArr[i11] = i10;
            int i12 = i11 + 1;
            int i13 = (length - i11) - 1;
            System.arraycopy(this.iTypes, i11, dateTimeFieldTypeArr, i12, i13);
            System.arraycopy((Object) this.iValues, i11, (Object) iArr, i12, i13);
            Partial partial = new Partial(dateTimeFieldTypeArr, iArr, this.iChronology);
            this.iChronology.validate(partial, iArr);
            return partial;
        }
        throw new IllegalArgumentException("The field type must not be null");
    }

    public Partial withChronologyRetainFields(a aVar) {
        a withUTC = c.c(aVar).withUTC();
        if (withUTC == getChronology()) {
            return this;
        }
        Partial partial = new Partial(withUTC, this.iTypes, this.iValues);
        withUTC.validate(partial, this.iValues);
        return partial;
    }

    public Partial withField(DateTimeFieldType dateTimeFieldType, int i10) {
        int indexOfSupported = indexOfSupported(dateTimeFieldType);
        if (i10 == getValue(indexOfSupported)) {
            return this;
        }
        return new Partial(this, getField(indexOfSupported).set(this, indexOfSupported, getValues(), i10));
    }

    public Partial withFieldAddWrapped(DurationFieldType durationFieldType, int i10) {
        int indexOfSupported = indexOfSupported(durationFieldType);
        if (i10 == 0) {
            return this;
        }
        return new Partial(this, getField(indexOfSupported).addWrapPartial(this, indexOfSupported, getValues(), i10));
    }

    public Partial withFieldAdded(DurationFieldType durationFieldType, int i10) {
        int indexOfSupported = indexOfSupported(durationFieldType);
        if (i10 == 0) {
            return this;
        }
        return new Partial(this, getField(indexOfSupported).add(this, indexOfSupported, getValues(), i10));
    }

    public Partial withPeriodAdded(l lVar, int i10) {
        if (lVar == null || i10 == 0) {
            return this;
        }
        int[] values = getValues();
        for (int i11 = 0; i11 < lVar.size(); i11++) {
            int indexOf = indexOf(lVar.getFieldType(i11));
            if (indexOf >= 0) {
                values = getField(indexOf).add(this, indexOf, values, org.joda.time.field.e.h(lVar.getValue(i11), i10));
            }
        }
        return new Partial(this, values);
    }

    public Partial without(DateTimeFieldType dateTimeFieldType) {
        int indexOf = indexOf(dateTimeFieldType);
        if (indexOf == -1) {
            return this;
        }
        int size = size() - 1;
        DateTimeFieldType[] dateTimeFieldTypeArr = new DateTimeFieldType[size];
        int size2 = size() - 1;
        int[] iArr = new int[size2];
        System.arraycopy(this.iTypes, 0, dateTimeFieldTypeArr, 0, indexOf);
        int i10 = indexOf + 1;
        System.arraycopy(this.iTypes, i10, dateTimeFieldTypeArr, indexOf, size - indexOf);
        System.arraycopy((Object) this.iValues, 0, (Object) iArr, 0, indexOf);
        System.arraycopy((Object) this.iValues, i10, (Object) iArr, indexOf, size2 - indexOf);
        Partial partial = new Partial(this.iChronology, dateTimeFieldTypeArr, iArr);
        this.iChronology.validate(partial, iArr);
        return partial;
    }

    public Partial(a aVar) {
        this.iChronology = c.c(aVar).withUTC();
        this.iTypes = new DateTimeFieldType[0];
        this.iValues = new int[0];
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class Property extends org.joda.time.field.a implements Serializable {
        private static final long serialVersionUID = 53278362873888L;
        private final int iFieldIndex;
        private final Partial iPartial;

        public Property(Partial partial, int i10) {
            this.iPartial = partial;
            this.iFieldIndex = i10;
        }

        public Partial addToCopy(int i10) {
            return new Partial(this.iPartial, getField().add(this.iPartial, this.iFieldIndex, this.iPartial.getValues(), i10));
        }

        public Partial addWrapFieldToCopy(int i10) {
            return new Partial(this.iPartial, getField().addWrapField(this.iPartial, this.iFieldIndex, this.iPartial.getValues(), i10));
        }

        @Override // org.joda.time.field.a
        public int get() {
            return this.iPartial.getValue(this.iFieldIndex);
        }

        @Override // org.joda.time.field.a
        public b getField() {
            return this.iPartial.getField(this.iFieldIndex);
        }

        public Partial getPartial() {
            return this.iPartial;
        }

        @Override // org.joda.time.field.a
        public k getReadablePartial() {
            return this.iPartial;
        }

        public Partial setCopy(int i10) {
            return new Partial(this.iPartial, getField().set(this.iPartial, this.iFieldIndex, this.iPartial.getValues(), i10));
        }

        public Partial withMaximumValue() {
            return setCopy(getMaximumValue());
        }

        public Partial withMinimumValue() {
            return setCopy(getMinimumValue());
        }

        public Partial setCopy(String str, Locale locale) {
            return new Partial(this.iPartial, getField().set(this.iPartial, this.iFieldIndex, this.iPartial.getValues(), str, locale));
        }

        public Partial setCopy(String str) {
            return setCopy(str, null);
        }
    }

    public Partial(DateTimeFieldType dateTimeFieldType, int i10) {
        this(dateTimeFieldType, i10, (a) null);
    }

    public boolean isMatch(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("The partial must not be null");
        }
        int i10 = 0;
        while (true) {
            DateTimeFieldType[] dateTimeFieldTypeArr = this.iTypes;
            if (i10 >= dateTimeFieldTypeArr.length) {
                return true;
            }
            if (kVar.get(dateTimeFieldTypeArr[i10]) != this.iValues[i10]) {
                return false;
            }
            i10++;
        }
    }

    public Partial(DateTimeFieldType dateTimeFieldType, int i10, a aVar) {
        a withUTC = c.c(aVar).withUTC();
        this.iChronology = withUTC;
        if (dateTimeFieldType != null) {
            this.iTypes = new DateTimeFieldType[]{dateTimeFieldType};
            int[] iArr = {i10};
            this.iValues = iArr;
            withUTC.validate(this, iArr);
            return;
        }
        throw new IllegalArgumentException("The field type must not be null");
    }

    public String toString(String str) {
        if (str == null) {
            return toString();
        }
        return org.joda.time.format.a.b(str).l(this);
    }

    public String toString(String str, Locale locale) {
        if (str == null) {
            return toString();
        }
        return org.joda.time.format.a.b(str).v(locale).l(this);
    }

    public Partial(DateTimeFieldType[] dateTimeFieldTypeArr, int[] iArr) {
        this(dateTimeFieldTypeArr, iArr, (a) null);
    }

    public Partial(DateTimeFieldType[] dateTimeFieldTypeArr, int[] iArr, a aVar) {
        a withUTC = c.c(aVar).withUTC();
        this.iChronology = withUTC;
        if (dateTimeFieldTypeArr == null) {
            throw new IllegalArgumentException("Types array must not be null");
        }
        if (iArr != null) {
            if (iArr.length == dateTimeFieldTypeArr.length) {
                if (dateTimeFieldTypeArr.length == 0) {
                    this.iTypes = dateTimeFieldTypeArr;
                    this.iValues = iArr;
                    return;
                }
                int i10 = 0;
                for (int i11 = 0; i11 < dateTimeFieldTypeArr.length; i11++) {
                    if (dateTimeFieldTypeArr[i11] == null) {
                        throw new IllegalArgumentException("Types array must not contain null: index " + i11);
                    }
                }
                d dVar = null;
                while (i10 < dateTimeFieldTypeArr.length) {
                    DateTimeFieldType dateTimeFieldType = dateTimeFieldTypeArr[i10];
                    d field = dateTimeFieldType.getDurationType().getField(this.iChronology);
                    if (i10 > 0) {
                        if (!field.isSupported()) {
                            if (dVar.isSupported()) {
                                throw new IllegalArgumentException("Types array must be in order largest-smallest: " + dateTimeFieldTypeArr[i10 - 1].getName() + " < " + dateTimeFieldType.getName());
                            }
                            throw new IllegalArgumentException("Types array must not contain duplicate unsupported: " + dateTimeFieldTypeArr[i10 - 1].getName() + " and " + dateTimeFieldType.getName());
                        }
                        int compareTo = dVar.compareTo(field);
                        if (compareTo < 0) {
                            throw new IllegalArgumentException("Types array must be in order largest-smallest: " + dateTimeFieldTypeArr[i10 - 1].getName() + " < " + dateTimeFieldType.getName());
                        }
                        if (compareTo != 0) {
                            continue;
                        } else if (dVar.equals(field)) {
                            int i12 = i10 - 1;
                            DurationFieldType rangeDurationType = dateTimeFieldTypeArr[i12].getRangeDurationType();
                            DurationFieldType rangeDurationType2 = dateTimeFieldType.getRangeDurationType();
                            if (rangeDurationType == null) {
                                if (rangeDurationType2 == null) {
                                    throw new IllegalArgumentException("Types array must not contain duplicate: " + dateTimeFieldTypeArr[i12].getName() + " and " + dateTimeFieldType.getName());
                                }
                            } else if (rangeDurationType2 != null) {
                                d field2 = rangeDurationType.getField(this.iChronology);
                                d field3 = rangeDurationType2.getField(this.iChronology);
                                if (field2.compareTo(field3) >= 0) {
                                    if (field2.compareTo(field3) == 0) {
                                        throw new IllegalArgumentException("Types array must not contain duplicate: " + dateTimeFieldTypeArr[i12].getName() + " and " + dateTimeFieldType.getName());
                                    }
                                } else {
                                    throw new IllegalArgumentException("Types array must be in order largest-smallest: " + dateTimeFieldTypeArr[i12].getName() + " < " + dateTimeFieldType.getName());
                                }
                            } else {
                                throw new IllegalArgumentException("Types array must be in order largest-smallest: " + dateTimeFieldTypeArr[i12].getName() + " < " + dateTimeFieldType.getName());
                            }
                        } else if (dVar.isSupported() && dVar.getType() != DurationFieldType.YEARS_TYPE) {
                            throw new IllegalArgumentException("Types array must be in order largest-smallest, for year-based fields, years is defined as being largest: " + dateTimeFieldTypeArr[i10 - 1].getName() + " < " + dateTimeFieldType.getName());
                        }
                    }
                    i10++;
                    dVar = field;
                }
                this.iTypes = (DateTimeFieldType[]) dateTimeFieldTypeArr.clone();
                withUTC.validate(this, iArr);
                this.iValues = (int[]) iArr.clone();
                return;
            }
            throw new IllegalArgumentException("Values array must be the same length as the types array");
        }
        throw new IllegalArgumentException("Values array must not be null");
    }

    public Partial(k kVar) {
        if (kVar != null) {
            this.iChronology = c.c(kVar.getChronology()).withUTC();
            this.iTypes = new DateTimeFieldType[kVar.size()];
            this.iValues = new int[kVar.size()];
            for (int i10 = 0; i10 < kVar.size(); i10++) {
                this.iTypes[i10] = kVar.getFieldType(i10);
                this.iValues[i10] = kVar.getValue(i10);
            }
            return;
        }
        throw new IllegalArgumentException("The partial must not be null");
    }

    public Partial(Partial partial, int[] iArr) {
        this.iChronology = partial.iChronology;
        this.iTypes = partial.iTypes;
        this.iValues = iArr;
    }

    public Partial(a aVar, DateTimeFieldType[] dateTimeFieldTypeArr, int[] iArr) {
        this.iChronology = aVar;
        this.iTypes = dateTimeFieldTypeArr;
        this.iValues = iArr;
    }
}
