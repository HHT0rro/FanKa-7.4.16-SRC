package java.time.chrono;

import java.time.DateTimeException;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public enum MinguoEra implements Era {
    BEFORE_ROC,
    ROC;

    public static MinguoEra of(int minguoEra) {
        switch (minguoEra) {
            case 0:
                return BEFORE_ROC;
            case 1:
                return ROC;
            default:
                throw new DateTimeException("Invalid era: " + minguoEra);
        }
    }

    @Override // java.time.chrono.Era
    public int getValue() {
        return ordinal();
    }

    @Override // java.time.chrono.Era
    public String getDisplayName(TextStyle style, Locale locale) {
        return new DateTimeFormatterBuilder().appendText(ChronoField.ERA, style).toFormatter(locale).withChronology(MinguoChronology.INSTANCE).format(this == ROC ? MinguoDate.of(1, 1, 1) : MinguoDate.of(0, 1, 1));
    }
}
