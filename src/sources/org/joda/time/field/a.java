package org.joda.time.field;

import java.util.Locale;
import org.joda.time.DateTimeFieldType;
import org.joda.time.k;

/* compiled from: AbstractPartialFieldProperty.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class a {
    public int compareTo(org.joda.time.i iVar) {
        if (iVar != null) {
            int i10 = get();
            int i11 = iVar.get(getFieldType());
            if (i10 < i11) {
                return -1;
            }
            return i10 > i11 ? 1 : 0;
        }
        throw new IllegalArgumentException("The instant must not be null");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return get() == aVar.get() && getFieldType() == aVar.getFieldType() && e.a(getReadablePartial().getChronology(), aVar.getReadablePartial().getChronology());
    }

    public abstract int get();

    public String getAsShortText() {
        return getAsShortText(null);
    }

    public String getAsString() {
        return Integer.toString(get());
    }

    public String getAsText() {
        return getAsText(null);
    }

    public org.joda.time.d getDurationField() {
        return getField().getDurationField();
    }

    public abstract org.joda.time.b getField();

    public DateTimeFieldType getFieldType() {
        return getField().getType();
    }

    public int getMaximumShortTextLength(Locale locale) {
        return getField().getMaximumShortTextLength(locale);
    }

    public int getMaximumTextLength(Locale locale) {
        return getField().getMaximumTextLength(locale);
    }

    public int getMaximumValue() {
        return getField().getMaximumValue(getReadablePartial());
    }

    public int getMaximumValueOverall() {
        return getField().getMaximumValue();
    }

    public int getMinimumValue() {
        return getField().getMinimumValue(getReadablePartial());
    }

    public int getMinimumValueOverall() {
        return getField().getMinimumValue();
    }

    public String getName() {
        return getField().getName();
    }

    public org.joda.time.d getRangeDurationField() {
        return getField().getRangeDurationField();
    }

    public abstract k getReadablePartial();

    public int hashCode() {
        return ((((247 + get()) * 13) + getFieldType().hashCode()) * 13) + getReadablePartial().getChronology().hashCode();
    }

    public String toString() {
        return "Property[" + getName() + "]";
    }

    public String getAsShortText(Locale locale) {
        return getField().getAsShortText(getReadablePartial(), get(), locale);
    }

    public String getAsText(Locale locale) {
        return getField().getAsText(getReadablePartial(), get(), locale);
    }

    public int compareTo(k kVar) {
        if (kVar != null) {
            int i10 = get();
            int i11 = kVar.get(getFieldType());
            if (i10 < i11) {
                return -1;
            }
            return i10 > i11 ? 1 : 0;
        }
        throw new IllegalArgumentException("The instant must not be null");
    }
}
