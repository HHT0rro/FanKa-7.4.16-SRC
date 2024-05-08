package java.time.chrono;

import com.alibaba.wireless.security.SecExceptionCode;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.time.temporal.ValueRange;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import sun.util.calendar.CalendarDate;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class JapaneseEra implements Era, Serializable {
    static final sun.util.calendar.Era[] ERA_CONFIG;
    static final int ERA_OFFSET = 2;
    public static final JapaneseEra HEISEI;
    private static final JapaneseEra[] KNOWN_ERAS;
    public static final JapaneseEra MEIJI;
    private static final int N_ERA_CONSTANTS;
    public static final JapaneseEra REIWA;
    public static final JapaneseEra SHOWA;
    public static final JapaneseEra TAISHO;
    private static final long serialVersionUID = 1466499369062886794L;
    private final transient int eraValue;
    private final transient LocalDate since;

    static {
        JapaneseEra japaneseEra = new JapaneseEra(-1, LocalDate.of(1868, 1, 1));
        MEIJI = japaneseEra;
        JapaneseEra japaneseEra2 = new JapaneseEra(0, LocalDate.of(SecExceptionCode.SEC_ERROR_GENERIC_AVMP_VM_CALL_FAILED, 7, 30));
        TAISHO = japaneseEra2;
        JapaneseEra japaneseEra3 = new JapaneseEra(1, LocalDate.of(1926, 12, 25));
        SHOWA = japaneseEra3;
        JapaneseEra japaneseEra4 = new JapaneseEra(2, LocalDate.of(1989, 1, 8));
        HEISEI = japaneseEra4;
        JapaneseEra japaneseEra5 = new JapaneseEra(3, LocalDate.of(2019, 5, 1));
        REIWA = japaneseEra5;
        N_ERA_CONSTANTS = japaneseEra5.getValue() + 2;
        sun.util.calendar.Era[] eras = JapaneseChronology.JCAL.getEras();
        ERA_CONFIG = eras;
        JapaneseEra[] japaneseEraArr = new JapaneseEra[eras.length];
        KNOWN_ERAS = japaneseEraArr;
        japaneseEraArr[0] = japaneseEra;
        japaneseEraArr[1] = japaneseEra2;
        japaneseEraArr[2] = japaneseEra3;
        japaneseEraArr[3] = japaneseEra4;
        japaneseEraArr[4] = japaneseEra5;
        int i10 = N_ERA_CONSTANTS;
        while (true) {
            sun.util.calendar.Era[] eraArr = ERA_CONFIG;
            if (i10 < eraArr.length) {
                CalendarDate date = eraArr[i10].getSinceDate();
                LocalDate isoDate = LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth());
                KNOWN_ERAS[i10] = new JapaneseEra((i10 - 2) + 1, isoDate);
                i10++;
            } else {
                return;
            }
        }
    }

    private JapaneseEra(int eraValue, LocalDate since) {
        this.eraValue = eraValue;
        this.since = since;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public sun.util.calendar.Era getPrivateEra() {
        return ERA_CONFIG[ordinal(this.eraValue)];
    }

    public static JapaneseEra of(int japaneseEra) {
        int i10 = ordinal(japaneseEra);
        if (i10 >= 0) {
            JapaneseEra[] japaneseEraArr = KNOWN_ERAS;
            if (i10 < japaneseEraArr.length) {
                return japaneseEraArr[i10];
            }
        }
        throw new DateTimeException("Invalid era: " + japaneseEra);
    }

    public static JapaneseEra valueOf(String japaneseEra) {
        Objects.requireNonNull(japaneseEra, "japaneseEra");
        for (JapaneseEra era : KNOWN_ERAS) {
            if (era.getName().equals(japaneseEra)) {
                return era;
            }
        }
        throw new IllegalArgumentException("japaneseEra is invalid");
    }

    public static JapaneseEra[] values() {
        JapaneseEra[] japaneseEraArr = KNOWN_ERAS;
        return (JapaneseEra[]) Arrays.copyOf(japaneseEraArr, japaneseEraArr.length);
    }

    @Override // java.time.chrono.Era
    public String getDisplayName(TextStyle style, Locale locale) {
        if (getValue() <= N_ERA_CONSTANTS - 2) {
            return new DateTimeFormatterBuilder().appendText(ChronoField.ERA, style).toFormatter(locale).withChronology(JapaneseChronology.INSTANCE).format(this == MEIJI ? JapaneseDate.MEIJI_6_ISODATE : this.since);
        }
        Objects.requireNonNull(locale, "locale");
        return style.asNormal() == TextStyle.NARROW ? getAbbreviation() : getName();
    }

    static JapaneseEra from(LocalDate date) {
        if (date.isBefore(JapaneseDate.MEIJI_6_ISODATE)) {
            throw new DateTimeException("JapaneseDate before Meiji 6 are not supported");
        }
        for (int i10 = KNOWN_ERAS.length - 1; i10 > 0; i10--) {
            JapaneseEra era = KNOWN_ERAS[i10];
            if (date.compareTo((ChronoLocalDate) era.since) >= 0) {
                return era;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JapaneseEra toJapaneseEra(sun.util.calendar.Era privateEra) {
        for (int i10 = ERA_CONFIG.length - 1; i10 >= 0; i10--) {
            if (ERA_CONFIG[i10].equals(privateEra)) {
                return KNOWN_ERAS[i10];
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static sun.util.calendar.Era privateEraFrom(LocalDate isoDate) {
        for (int i10 = KNOWN_ERAS.length - 1; i10 > 0; i10--) {
            JapaneseEra era = KNOWN_ERAS[i10];
            if (isoDate.compareTo((ChronoLocalDate) era.since) >= 0) {
                return ERA_CONFIG[i10];
            }
        }
        return null;
    }

    private static int ordinal(int eraValue) {
        return (eraValue + 2) - 1;
    }

    @Override // java.time.chrono.Era
    public int getValue() {
        return this.eraValue;
    }

    @Override // java.time.chrono.Era, java.time.temporal.TemporalAccessor
    public ValueRange range(TemporalField field) {
        if (field == ChronoField.ERA) {
            return JapaneseChronology.INSTANCE.range(ChronoField.ERA);
        }
        return super.range(field);
    }

    String getAbbreviation() {
        return ERA_CONFIG[ordinal(getValue())].getAbbreviation();
    }

    String getName() {
        return ERA_CONFIG[ordinal(getValue())].getName();
    }

    public String toString() {
        return getName();
    }

    private void readObject(ObjectInputStream s2) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 5, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(DataOutput out) throws IOException {
        out.writeByte(getValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JapaneseEra readExternal(DataInput in) throws IOException {
        byte eraValue = in.readByte();
        return of(eraValue);
    }
}
