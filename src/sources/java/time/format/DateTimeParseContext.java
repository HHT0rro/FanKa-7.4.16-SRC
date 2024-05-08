package java.time.format;

import java.time.ZoneId;
import java.time.chrono.Chronology;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class DateTimeParseContext {
    private ArrayList<Consumer<Chronology>> chronoListeners;
    private DateTimeFormatter formatter;
    private final ArrayList<Parsed> parsed;
    private boolean caseSensitive = true;
    private boolean strict = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DateTimeParseContext(DateTimeFormatter formatter) {
        ArrayList<Parsed> arrayList = new ArrayList<>();
        this.parsed = arrayList;
        this.chronoListeners = null;
        this.formatter = formatter;
        arrayList.add(new Parsed());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DateTimeParseContext copy() {
        DateTimeParseContext newContext = new DateTimeParseContext(this.formatter);
        newContext.caseSensitive = this.caseSensitive;
        newContext.strict = this.strict;
        return newContext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Locale getLocale() {
        return this.formatter.getLocale();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DecimalStyle getDecimalStyle() {
        return this.formatter.getDecimalStyle();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Chronology getEffectiveChronology() {
        Chronology chrono = currentParsed().chrono;
        if (chrono == null) {
            Chronology chrono2 = this.formatter.getChronology();
            if (chrono2 == null) {
                return IsoChronology.INSTANCE;
            }
            return chrono2;
        }
        return chrono;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isCaseSensitive() {
        return this.caseSensitive;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCaseSensitive(boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean subSequenceEquals(CharSequence cs1, int offset1, CharSequence cs2, int offset2, int length) {
        if (offset1 + length > cs1.length() || offset2 + length > cs2.length()) {
            return false;
        }
        if (isCaseSensitive()) {
            for (int i10 = 0; i10 < length; i10++) {
                if (cs1.charAt(offset1 + i10) != cs2.charAt(offset2 + i10)) {
                    return false;
                }
            }
            return true;
        }
        for (int i11 = 0; i11 < length; i11++) {
            char ch1 = cs1.charAt(offset1 + i11);
            char ch2 = cs2.charAt(offset2 + i11);
            if (ch1 != ch2 && Character.toUpperCase(ch1) != Character.toUpperCase(ch2) && Character.toLowerCase(ch1) != Character.toLowerCase(ch2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean charEquals(char ch1, char ch2) {
        if (isCaseSensitive()) {
            return ch1 == ch2;
        }
        return charEqualsIgnoreCase(ch1, ch2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean charEqualsIgnoreCase(char c12, char c22) {
        return c12 == c22 || Character.toUpperCase(c12) == Character.toUpperCase(c22) || Character.toLowerCase(c12) == Character.toLowerCase(c22);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isStrict() {
        return this.strict;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStrict(boolean strict) {
        this.strict = strict;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startOptional() {
        this.parsed.add(currentParsed().copy());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void endOptional(boolean successful) {
        if (successful) {
            this.parsed.remove(r0.size() - 2);
        } else {
            this.parsed.remove(r0.size() - 1);
        }
    }

    private Parsed currentParsed() {
        return this.parsed.get(r0.size() - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Parsed toUnresolved() {
        return currentParsed();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TemporalAccessor toResolved(ResolverStyle resolverStyle, Set<TemporalField> resolverFields) {
        Parsed parsed = currentParsed();
        parsed.chrono = getEffectiveChronology();
        parsed.zone = parsed.zone != null ? parsed.zone : this.formatter.getZone();
        return parsed.resolve(resolverStyle, resolverFields);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Long getParsed(TemporalField field) {
        return currentParsed().fieldValues.get(field);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int setParsedField(TemporalField field, long value, int errorPos, int successPos) {
        Objects.requireNonNull(field, "field");
        Long old = currentParsed().fieldValues.put(field, Long.valueOf(value));
        return (old == null || old.longValue() == value) ? successPos : ~errorPos;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setParsed(Chronology chrono) {
        Objects.requireNonNull(chrono, "chrono");
        currentParsed().chrono = chrono;
        ArrayList<Consumer<Chronology>> arrayList = this.chronoListeners;
        if (arrayList != null && !arrayList.isEmpty()) {
            Consumer<Chronology>[] tmp = new Consumer[1];
            Consumer<Chronology>[] listeners = (Consumer[]) this.chronoListeners.toArray(tmp);
            this.chronoListeners.clear();
            for (Consumer<Chronology> l10 : listeners) {
                l10.accept(chrono);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addChronoChangedListener(Consumer<Chronology> listener) {
        if (this.chronoListeners == null) {
            this.chronoListeners = new ArrayList<>();
        }
        this.chronoListeners.add(listener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setParsed(ZoneId zone) {
        Objects.requireNonNull(zone, "zone");
        currentParsed().zone = zone;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setParsedLeapSecond() {
        currentParsed().leapSecond = true;
    }

    void setParsedDayPeriod(DateTimeFormatterBuilder.DayPeriod dayPeriod) {
        currentParsed().dayPeriod = dayPeriod;
    }

    public String toString() {
        return currentParsed().toString();
    }
}
