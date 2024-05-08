package java.time.format;

import java.time.DateTimeException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.Chronology;
import java.time.chrono.IsoChronology;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalQuery;
import java.time.temporal.ValueRange;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class DateTimePrintContext {
    private DateTimeFormatter formatter;
    private int optional;
    private TemporalAccessor temporal;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DateTimePrintContext(TemporalAccessor temporal, DateTimeFormatter formatter) {
        this.temporal = adjust(temporal, formatter);
        this.formatter = formatter;
    }

    private static TemporalAccessor adjust(final TemporalAccessor temporal, DateTimeFormatter formatter) {
        final ChronoLocalDate effectiveDate;
        Chronology overrideChrono = formatter.getChronology();
        ZoneId overrideZone = formatter.getZone();
        if (overrideChrono == null && overrideZone == null) {
            return temporal;
        }
        Chronology temporalChrono = (Chronology) temporal.query(TemporalQueries.chronology());
        ZoneId temporalZone = (ZoneId) temporal.query(TemporalQueries.zoneId());
        if (Objects.equals(overrideChrono, temporalChrono)) {
            overrideChrono = null;
        }
        if (Objects.equals(overrideZone, temporalZone)) {
            overrideZone = null;
        }
        if (overrideChrono == null && overrideZone == null) {
            return temporal;
        }
        final Chronology effectiveChrono = overrideChrono != null ? overrideChrono : temporalChrono;
        if (overrideZone != null) {
            if (temporal.isSupported(ChronoField.INSTANT_SECONDS)) {
                Chronology chrono = (Chronology) Objects.requireNonNullElse(effectiveChrono, IsoChronology.INSTANCE);
                return chrono.zonedDateTime(Instant.from(temporal), overrideZone);
            }
            if ((overrideZone.normalized() instanceof ZoneOffset) && temporal.isSupported(ChronoField.OFFSET_SECONDS) && temporal.get(ChronoField.OFFSET_SECONDS) != overrideZone.getRules().getOffset(Instant.EPOCH).getTotalSeconds()) {
                throw new DateTimeException("Unable to apply override zone '" + ((Object) overrideZone) + "' because the temporal object being formatted has a different offset but does not represent an instant: " + ((Object) temporal));
            }
        }
        final ZoneId effectiveZone = overrideZone != null ? overrideZone : temporalZone;
        if (overrideChrono != null) {
            if (temporal.isSupported(ChronoField.EPOCH_DAY)) {
                effectiveDate = effectiveChrono.date(temporal);
            } else {
                if (overrideChrono != IsoChronology.INSTANCE || temporalChrono != null) {
                    for (ChronoField f10 : ChronoField.values()) {
                        if (f10.isDateBased() && temporal.isSupported(f10)) {
                            throw new DateTimeException("Unable to apply override chronology '" + ((Object) overrideChrono) + "' because the temporal object being formatted contains date fields but does not represent a whole date: " + ((Object) temporal));
                        }
                    }
                }
                effectiveDate = null;
            }
        } else {
            effectiveDate = null;
        }
        return new TemporalAccessor() { // from class: java.time.format.DateTimePrintContext.1
            @Override // java.time.temporal.TemporalAccessor
            public boolean isSupported(TemporalField field) {
                if (ChronoLocalDate.this != null && field.isDateBased()) {
                    return ChronoLocalDate.this.isSupported(field);
                }
                return temporal.isSupported(field);
            }

            @Override // java.time.temporal.TemporalAccessor
            public ValueRange range(TemporalField field) {
                if (ChronoLocalDate.this != null && field.isDateBased()) {
                    return ChronoLocalDate.this.range(field);
                }
                return temporal.range(field);
            }

            @Override // java.time.temporal.TemporalAccessor
            public long getLong(TemporalField field) {
                if (ChronoLocalDate.this != null && field.isDateBased()) {
                    return ChronoLocalDate.this.getLong(field);
                }
                return temporal.getLong(field);
            }

            @Override // java.time.temporal.TemporalAccessor
            public <R> R query(TemporalQuery<R> temporalQuery) {
                if (temporalQuery == TemporalQueries.chronology()) {
                    return (R) effectiveChrono;
                }
                if (temporalQuery == TemporalQueries.zoneId()) {
                    return (R) effectiveZone;
                }
                if (temporalQuery == TemporalQueries.precision()) {
                    return (R) temporal.query(temporalQuery);
                }
                return temporalQuery.queryFrom(this);
            }

            public String toString() {
                return ((Object) temporal) + (effectiveChrono != null ? " with chronology " + ((Object) effectiveChrono) : "") + (effectiveZone != null ? " with zone " + ((Object) effectiveZone) : "");
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TemporalAccessor getTemporal() {
        return this.temporal;
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
    public void startOptional() {
        this.optional++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void endOptional() {
        this.optional--;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <R> R getValue(TemporalQuery<R> temporalQuery) {
        R r10 = (R) this.temporal.query(temporalQuery);
        if (r10 == null && this.optional == 0) {
            throw new DateTimeException("Unable to extract " + ((Object) temporalQuery) + " from temporal " + ((Object) this.temporal));
        }
        return r10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Long getValue(TemporalField field) {
        if (this.optional > 0 && !this.temporal.isSupported(field)) {
            return null;
        }
        return Long.valueOf(this.temporal.getLong(field));
    }

    public String toString() {
        return this.temporal.toString();
    }
}
