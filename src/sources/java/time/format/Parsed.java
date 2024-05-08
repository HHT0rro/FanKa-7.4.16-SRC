package java.time.format;

import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.time.chrono.ChronoZonedDateTime;
import java.time.chrono.Chronology;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalQuery;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Parsed implements TemporalAccessor {
    Chronology chrono;
    private ChronoLocalDate date;
    DateTimeFormatterBuilder.DayPeriod dayPeriod;
    boolean leapSecond;
    private ResolverStyle resolverStyle;
    private LocalTime time;
    ZoneId zone;
    final Map<TemporalField, Long> fieldValues = new HashMap();
    Period excessDays = Period.ZERO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Parsed copy() {
        Parsed cloned = new Parsed();
        cloned.fieldValues.putAll(this.fieldValues);
        cloned.zone = this.zone;
        cloned.chrono = this.chrono;
        cloned.leapSecond = this.leapSecond;
        cloned.dayPeriod = this.dayPeriod;
        return cloned;
    }

    @Override // java.time.temporal.TemporalAccessor
    public boolean isSupported(TemporalField field) {
        ChronoLocalDate chronoLocalDate;
        LocalTime localTime;
        if (this.fieldValues.containsKey(field) || (((chronoLocalDate = this.date) != null && chronoLocalDate.isSupported(field)) || ((localTime = this.time) != null && localTime.isSupported(field)))) {
            return true;
        }
        return (field == null || (field instanceof ChronoField) || !field.isSupportedBy(this)) ? false : true;
    }

    @Override // java.time.temporal.TemporalAccessor
    public long getLong(TemporalField field) {
        Objects.requireNonNull(field, "field");
        Long value = this.fieldValues.get(field);
        if (value != null) {
            return value.longValue();
        }
        ChronoLocalDate chronoLocalDate = this.date;
        if (chronoLocalDate != null && chronoLocalDate.isSupported(field)) {
            return this.date.getLong(field);
        }
        LocalTime localTime = this.time;
        if (localTime != null && localTime.isSupported(field)) {
            return this.time.getLong(field);
        }
        if (field instanceof ChronoField) {
            throw new UnsupportedTemporalTypeException("Unsupported field: " + ((Object) field));
        }
        return field.getFrom(this);
    }

    @Override // java.time.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.zoneId()) {
            return (R) this.zone;
        }
        if (temporalQuery == TemporalQueries.chronology()) {
            return (R) this.chrono;
        }
        if (temporalQuery == TemporalQueries.localDate()) {
            ChronoLocalDate chronoLocalDate = this.date;
            if (chronoLocalDate != null) {
                return (R) LocalDate.from((TemporalAccessor) chronoLocalDate);
            }
            return null;
        }
        if (temporalQuery == TemporalQueries.localTime()) {
            return (R) this.time;
        }
        if (temporalQuery == TemporalQueries.offset()) {
            Long l10 = this.fieldValues.get(ChronoField.OFFSET_SECONDS);
            if (l10 != null) {
                return (R) ZoneOffset.ofTotalSeconds(l10.intValue());
            }
            R r10 = (R) this.zone;
            if (r10 instanceof ZoneOffset) {
                return r10;
            }
            return temporalQuery.queryFrom(this);
        }
        if (temporalQuery == TemporalQueries.zone()) {
            return temporalQuery.queryFrom(this);
        }
        if (temporalQuery == TemporalQueries.precision()) {
            return null;
        }
        return temporalQuery.queryFrom(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TemporalAccessor resolve(ResolverStyle resolverStyle, Set<TemporalField> resolverFields) {
        if (resolverFields != null) {
            this.fieldValues.h().retainAll(resolverFields);
        }
        this.resolverStyle = resolverStyle;
        resolveFields();
        resolveTimeLenient();
        crossCheck();
        resolvePeriod();
        resolveFractional();
        resolveInstant();
        return this;
    }

    private void resolveFields() {
        resolveInstantFields();
        resolveDateFields();
        resolveTimeFields();
        if (this.fieldValues.size() > 0) {
            int changedCount = 0;
            loop0: while (changedCount < 50) {
                for (Map.Entry<TemporalField, Long> entry : this.fieldValues.entrySet()) {
                    TemporalField targetField = entry.getKey();
                    TemporalAccessor resolvedObject = targetField.resolve(this.fieldValues, this, this.resolverStyle);
                    if (resolvedObject != null) {
                        if (resolvedObject instanceof ChronoZonedDateTime) {
                            ChronoZonedDateTime<?> czdt = (ChronoZonedDateTime) resolvedObject;
                            ZoneId zoneId = this.zone;
                            if (zoneId == null) {
                                this.zone = czdt.getZone();
                            } else if (!zoneId.equals(czdt.getZone())) {
                                throw new DateTimeException("ChronoZonedDateTime must use the effective parsed zone: " + ((Object) this.zone));
                            }
                            resolvedObject = czdt.toLocalDateTime2();
                        }
                        if (resolvedObject instanceof ChronoLocalDateTime) {
                            ChronoLocalDateTime<?> cldt = (ChronoLocalDateTime) resolvedObject;
                            updateCheckConflict(cldt.toLocalTime(), Period.ZERO);
                            updateCheckConflict(cldt.toLocalDate());
                            changedCount++;
                        } else if (resolvedObject instanceof ChronoLocalDate) {
                            updateCheckConflict((ChronoLocalDate) resolvedObject);
                            changedCount++;
                        } else if (resolvedObject instanceof LocalTime) {
                            updateCheckConflict((LocalTime) resolvedObject, Period.ZERO);
                            changedCount++;
                        } else {
                            throw new DateTimeException("Method resolve() can only return ChronoZonedDateTime, ChronoLocalDateTime, ChronoLocalDate or LocalTime");
                        }
                    } else if (!this.fieldValues.containsKey(targetField)) {
                        changedCount++;
                    }
                }
            }
            if (changedCount == 50) {
                throw new DateTimeException("One of the parsed fields has an incorrectly implemented resolve method");
            }
            if (changedCount > 0) {
                resolveInstantFields();
                resolveDateFields();
                resolveTimeFields();
            }
        }
    }

    private void updateCheckConflict(TemporalField targetField, TemporalField changeField, Long changeValue) {
        Long old = this.fieldValues.put(changeField, changeValue);
        if (old != null && old.longValue() != changeValue.longValue()) {
            throw new DateTimeException("Conflict found: " + ((Object) changeField) + " " + ((Object) old) + " differs from " + ((Object) changeField) + " " + ((Object) changeValue) + " while resolving  " + ((Object) targetField));
        }
    }

    private void resolveInstantFields() {
        if (this.fieldValues.containsKey(ChronoField.INSTANT_SECONDS)) {
            ZoneId zoneId = this.zone;
            if (zoneId != null) {
                resolveInstantFields0(zoneId);
                return;
            }
            Long offsetSecs = this.fieldValues.get(ChronoField.OFFSET_SECONDS);
            if (offsetSecs != null) {
                ZoneOffset offset = ZoneOffset.ofTotalSeconds(offsetSecs.intValue());
                resolveInstantFields0(offset);
            }
        }
    }

    private void resolveInstantFields0(ZoneId selectedZone) {
        Instant instant = Instant.ofEpochSecond(this.fieldValues.get(ChronoField.INSTANT_SECONDS).longValue());
        ChronoZonedDateTime<?> zdt = this.chrono.zonedDateTime(instant, selectedZone);
        updateCheckConflict(zdt.toLocalDate());
        updateCheckConflict(ChronoField.INSTANT_SECONDS, ChronoField.SECOND_OF_DAY, Long.valueOf(zdt.toLocalTime().toSecondOfDay()));
        updateCheckConflict(ChronoField.INSTANT_SECONDS, ChronoField.OFFSET_SECONDS, Long.valueOf(zdt.getOffset().getTotalSeconds()));
    }

    private void resolveDateFields() {
        updateCheckConflict(this.chrono.resolveDate(this.fieldValues, this.resolverStyle));
    }

    private void updateCheckConflict(ChronoLocalDate cld) {
        ChronoLocalDate chronoLocalDate = this.date;
        if (chronoLocalDate != null) {
            if (cld != null && !chronoLocalDate.equals(cld)) {
                throw new DateTimeException("Conflict found: Fields resolved to two different dates: " + ((Object) this.date) + " " + ((Object) cld));
            }
        } else if (cld != null) {
            if (!this.chrono.equals(cld.getChronology())) {
                throw new DateTimeException("ChronoLocalDate must use the effective parsed chronology: " + ((Object) this.chrono));
            }
            this.date = cld;
        }
    }

    private void resolveTimeFields() {
        if (this.fieldValues.containsKey(ChronoField.CLOCK_HOUR_OF_DAY)) {
            long ch = this.fieldValues.remove(ChronoField.CLOCK_HOUR_OF_DAY).longValue();
            if (this.resolverStyle == ResolverStyle.STRICT || (this.resolverStyle == ResolverStyle.SMART && ch != 0)) {
                ChronoField.CLOCK_HOUR_OF_DAY.checkValidValue(ch);
            }
            updateCheckConflict(ChronoField.CLOCK_HOUR_OF_DAY, ChronoField.HOUR_OF_DAY, Long.valueOf(ch == 24 ? 0L : ch));
        }
        if (this.fieldValues.containsKey(ChronoField.CLOCK_HOUR_OF_AMPM)) {
            long ch2 = this.fieldValues.remove(ChronoField.CLOCK_HOUR_OF_AMPM).longValue();
            if (this.resolverStyle == ResolverStyle.STRICT || (this.resolverStyle == ResolverStyle.SMART && ch2 != 0)) {
                ChronoField.CLOCK_HOUR_OF_AMPM.checkValidValue(ch2);
            }
            updateCheckConflict(ChronoField.CLOCK_HOUR_OF_AMPM, ChronoField.HOUR_OF_AMPM, Long.valueOf(ch2 == 12 ? 0L : ch2));
        }
        if (this.fieldValues.containsKey(ChronoField.AMPM_OF_DAY) && this.fieldValues.containsKey(ChronoField.HOUR_OF_AMPM)) {
            long ap = this.fieldValues.remove(ChronoField.AMPM_OF_DAY).longValue();
            long hap = this.fieldValues.remove(ChronoField.HOUR_OF_AMPM).longValue();
            if (this.resolverStyle == ResolverStyle.LENIENT) {
                updateCheckConflict(ChronoField.AMPM_OF_DAY, ChronoField.HOUR_OF_DAY, Long.valueOf(Math.addExact(Math.multiplyExact(ap, 12), hap)));
            } else {
                ChronoField.AMPM_OF_DAY.checkValidValue(ap);
                ChronoField.HOUR_OF_AMPM.checkValidValue(hap);
                updateCheckConflict(ChronoField.AMPM_OF_DAY, ChronoField.HOUR_OF_DAY, Long.valueOf((ap * 12) + hap));
            }
        }
        if (this.fieldValues.containsKey(ChronoField.NANO_OF_DAY)) {
            long nod = this.fieldValues.remove(ChronoField.NANO_OF_DAY).longValue();
            if (this.resolverStyle != ResolverStyle.LENIENT) {
                ChronoField.NANO_OF_DAY.checkValidValue(nod);
            }
            updateCheckConflict(ChronoField.NANO_OF_DAY, ChronoField.HOUR_OF_DAY, Long.valueOf(nod / 3600000000000L));
            updateCheckConflict(ChronoField.NANO_OF_DAY, ChronoField.MINUTE_OF_HOUR, Long.valueOf((nod / 60000000000L) % 60));
            updateCheckConflict(ChronoField.NANO_OF_DAY, ChronoField.SECOND_OF_MINUTE, Long.valueOf((nod / 1000000000) % 60));
            updateCheckConflict(ChronoField.NANO_OF_DAY, ChronoField.NANO_OF_SECOND, Long.valueOf(nod % 1000000000));
        }
        if (this.fieldValues.containsKey(ChronoField.MICRO_OF_DAY)) {
            long cod = this.fieldValues.remove(ChronoField.MICRO_OF_DAY).longValue();
            if (this.resolverStyle != ResolverStyle.LENIENT) {
                ChronoField.MICRO_OF_DAY.checkValidValue(cod);
            }
            updateCheckConflict(ChronoField.MICRO_OF_DAY, ChronoField.SECOND_OF_DAY, Long.valueOf(cod / 1000000));
            updateCheckConflict(ChronoField.MICRO_OF_DAY, ChronoField.MICRO_OF_SECOND, Long.valueOf(cod % 1000000));
        }
        if (this.fieldValues.containsKey(ChronoField.MILLI_OF_DAY)) {
            long lod = this.fieldValues.remove(ChronoField.MILLI_OF_DAY).longValue();
            if (this.resolverStyle != ResolverStyle.LENIENT) {
                ChronoField.MILLI_OF_DAY.checkValidValue(lod);
            }
            updateCheckConflict(ChronoField.MILLI_OF_DAY, ChronoField.SECOND_OF_DAY, Long.valueOf(lod / 1000));
            updateCheckConflict(ChronoField.MILLI_OF_DAY, ChronoField.MILLI_OF_SECOND, Long.valueOf(lod % 1000));
        }
        if (this.fieldValues.containsKey(ChronoField.SECOND_OF_DAY)) {
            long sod = this.fieldValues.remove(ChronoField.SECOND_OF_DAY).longValue();
            if (this.resolverStyle != ResolverStyle.LENIENT) {
                ChronoField.SECOND_OF_DAY.checkValidValue(sod);
            }
            updateCheckConflict(ChronoField.SECOND_OF_DAY, ChronoField.HOUR_OF_DAY, Long.valueOf(sod / 3600));
            updateCheckConflict(ChronoField.SECOND_OF_DAY, ChronoField.MINUTE_OF_HOUR, Long.valueOf((sod / 60) % 60));
            updateCheckConflict(ChronoField.SECOND_OF_DAY, ChronoField.SECOND_OF_MINUTE, Long.valueOf(sod % 60));
        }
        if (this.fieldValues.containsKey(ChronoField.MINUTE_OF_DAY)) {
            long mod = this.fieldValues.remove(ChronoField.MINUTE_OF_DAY).longValue();
            if (this.resolverStyle != ResolverStyle.LENIENT) {
                ChronoField.MINUTE_OF_DAY.checkValidValue(mod);
            }
            updateCheckConflict(ChronoField.MINUTE_OF_DAY, ChronoField.HOUR_OF_DAY, Long.valueOf(mod / 60));
            updateCheckConflict(ChronoField.MINUTE_OF_DAY, ChronoField.MINUTE_OF_HOUR, Long.valueOf(mod % 60));
        }
        if (this.fieldValues.containsKey(ChronoField.NANO_OF_SECOND)) {
            long nos = this.fieldValues.get(ChronoField.NANO_OF_SECOND).longValue();
            if (this.resolverStyle != ResolverStyle.LENIENT) {
                ChronoField.NANO_OF_SECOND.checkValidValue(nos);
            }
            if (this.fieldValues.containsKey(ChronoField.MICRO_OF_SECOND)) {
                long cos = this.fieldValues.remove(ChronoField.MICRO_OF_SECOND).longValue();
                if (this.resolverStyle != ResolverStyle.LENIENT) {
                    ChronoField.MICRO_OF_SECOND.checkValidValue(cos);
                }
                nos = (cos * 1000) + (nos % 1000);
                updateCheckConflict(ChronoField.MICRO_OF_SECOND, ChronoField.NANO_OF_SECOND, Long.valueOf(nos));
            }
            if (this.fieldValues.containsKey(ChronoField.MILLI_OF_SECOND)) {
                long los = this.fieldValues.remove(ChronoField.MILLI_OF_SECOND).longValue();
                if (this.resolverStyle != ResolverStyle.LENIENT) {
                    ChronoField.MILLI_OF_SECOND.checkValidValue(los);
                }
                updateCheckConflict(ChronoField.MILLI_OF_SECOND, ChronoField.NANO_OF_SECOND, Long.valueOf((los * 1000000) + (nos % 1000000)));
            }
        }
        if (this.dayPeriod != null && this.fieldValues.containsKey(ChronoField.HOUR_OF_AMPM)) {
            long hoap = this.fieldValues.remove(ChronoField.HOUR_OF_AMPM).longValue();
            if (this.resolverStyle != ResolverStyle.LENIENT) {
                ChronoField.HOUR_OF_AMPM.checkValidValue(hoap);
            }
            Long mohObj = this.fieldValues.get(ChronoField.MINUTE_OF_HOUR);
            long moh = mohObj != null ? Math.floorMod(mohObj.longValue(), 60) : 0L;
            long excessHours = this.dayPeriod.includes(((long) ((Math.floorMod(hoap, 12) + 12) * 60)) + moh) ? 12L : 0L;
            long hod = Math.addExact(hoap, excessHours);
            updateCheckConflict(ChronoField.HOUR_OF_AMPM, ChronoField.HOUR_OF_DAY, Long.valueOf(hod));
            this.dayPeriod = null;
        }
        if (this.fieldValues.containsKey(ChronoField.HOUR_OF_DAY) && this.fieldValues.containsKey(ChronoField.MINUTE_OF_HOUR) && this.fieldValues.containsKey(ChronoField.SECOND_OF_MINUTE) && this.fieldValues.containsKey(ChronoField.NANO_OF_SECOND)) {
            long hod2 = this.fieldValues.remove(ChronoField.HOUR_OF_DAY).longValue();
            long moh2 = this.fieldValues.remove(ChronoField.MINUTE_OF_HOUR).longValue();
            long som = this.fieldValues.remove(ChronoField.SECOND_OF_MINUTE).longValue();
            resolveTime(hod2, moh2, som, this.fieldValues.remove(ChronoField.NANO_OF_SECOND).longValue());
        }
    }

    private void resolveTimeLenient() {
        if (this.time == null) {
            if (this.fieldValues.containsKey(ChronoField.MILLI_OF_SECOND)) {
                long los = this.fieldValues.remove(ChronoField.MILLI_OF_SECOND).longValue();
                if (this.fieldValues.containsKey(ChronoField.MICRO_OF_SECOND)) {
                    long cos = (los * 1000) + (this.fieldValues.get(ChronoField.MICRO_OF_SECOND).longValue() % 1000);
                    updateCheckConflict(ChronoField.MILLI_OF_SECOND, ChronoField.MICRO_OF_SECOND, Long.valueOf(cos));
                    this.fieldValues.remove(ChronoField.MICRO_OF_SECOND);
                    this.fieldValues.put(ChronoField.NANO_OF_SECOND, Long.valueOf(1000 * cos));
                } else {
                    this.fieldValues.put(ChronoField.NANO_OF_SECOND, Long.valueOf(1000000 * los));
                }
            } else if (this.fieldValues.containsKey(ChronoField.MICRO_OF_SECOND)) {
                this.fieldValues.put(ChronoField.NANO_OF_SECOND, Long.valueOf(1000 * this.fieldValues.remove(ChronoField.MICRO_OF_SECOND).longValue()));
            }
            if (!this.fieldValues.containsKey(ChronoField.HOUR_OF_DAY) && !this.fieldValues.containsKey(ChronoField.MINUTE_OF_HOUR) && !this.fieldValues.containsKey(ChronoField.SECOND_OF_MINUTE) && !this.fieldValues.containsKey(ChronoField.NANO_OF_SECOND) && this.resolverStyle != ResolverStyle.STRICT) {
                DateTimeFormatterBuilder.DayPeriod dayPeriod = this.dayPeriod;
                if (dayPeriod != null) {
                    long midpoint = dayPeriod.mid();
                    resolveTime(midpoint / 60, midpoint % 60, 0L, 0L);
                    this.dayPeriod = null;
                } else if (this.fieldValues.containsKey(ChronoField.AMPM_OF_DAY)) {
                    long ap = this.fieldValues.remove(ChronoField.AMPM_OF_DAY).longValue();
                    if (this.resolverStyle == ResolverStyle.LENIENT) {
                        resolveTime(Math.addExact(Math.multiplyExact(ap, 12), 6L), 0L, 0L, 0L);
                    } else {
                        ChronoField.AMPM_OF_DAY.checkValidValue(ap);
                        resolveTime((12 * ap) + 6, 0L, 0L, 0L);
                    }
                }
            }
            Long hod = this.fieldValues.get(ChronoField.HOUR_OF_DAY);
            if (hod != null) {
                Long moh = this.fieldValues.get(ChronoField.MINUTE_OF_HOUR);
                Long som = this.fieldValues.get(ChronoField.SECOND_OF_MINUTE);
                Long nos = this.fieldValues.get(ChronoField.NANO_OF_SECOND);
                if (moh == null && (som != null || nos != null)) {
                    return;
                }
                if (moh != null && som == null && nos != null) {
                    return;
                }
                long mohVal = moh != null ? moh.longValue() : 0L;
                long somVal = som != null ? som.longValue() : 0L;
                long nosVal = nos != null ? nos.longValue() : 0L;
                if (this.dayPeriod != null && this.resolverStyle != ResolverStyle.LENIENT && !this.dayPeriod.includes((hod.longValue() * 60) + mohVal)) {
                    throw new DateTimeException("Conflict found: Resolved time %02d:%02d".formatted(hod, Long.valueOf(mohVal)) + " conflicts with " + ((Object) this.dayPeriod));
                }
                resolveTime(hod.longValue(), mohVal, somVal, nosVal);
                this.fieldValues.remove(ChronoField.HOUR_OF_DAY);
                this.fieldValues.remove(ChronoField.MINUTE_OF_HOUR);
                this.fieldValues.remove(ChronoField.SECOND_OF_MINUTE);
                this.fieldValues.remove(ChronoField.NANO_OF_SECOND);
            }
        }
        if (this.resolverStyle != ResolverStyle.LENIENT && this.fieldValues.size() > 0) {
            for (Map.Entry<TemporalField, Long> entry : this.fieldValues.entrySet()) {
                TemporalField field = entry.getKey();
                if ((field instanceof ChronoField) && field.isTimeBased()) {
                    ((ChronoField) field).checkValidValue(entry.getValue().longValue());
                }
            }
        }
    }

    private void resolveTime(long hod, long moh, long som, long nos) {
        if (this.resolverStyle == ResolverStyle.LENIENT) {
            long totalNanos = Math.addExact(Math.addExact(Math.addExact(Math.multiplyExact(hod, 3600000000000L), Math.multiplyExact(moh, 60000000000L)), Math.multiplyExact(som, 1000000000L)), nos);
            int excessDays = (int) Math.floorDiv(totalNanos, 86400000000000L);
            long nod = Math.floorMod(totalNanos, 86400000000000L);
            updateCheckConflict(LocalTime.ofNanoOfDay(nod), Period.ofDays(excessDays));
            return;
        }
        int mohVal = ChronoField.MINUTE_OF_HOUR.checkValidIntValue(moh);
        int nosVal = ChronoField.NANO_OF_SECOND.checkValidIntValue(nos);
        if (this.resolverStyle == ResolverStyle.SMART && hod == 24 && mohVal == 0 && som == 0 && nosVal == 0) {
            updateCheckConflict(LocalTime.MIDNIGHT, Period.ofDays(1));
            return;
        }
        int hodVal = ChronoField.HOUR_OF_DAY.checkValidIntValue(hod);
        int somVal = ChronoField.SECOND_OF_MINUTE.checkValidIntValue(som);
        updateCheckConflict(LocalTime.of(hodVal, mohVal, somVal, nosVal), Period.ZERO);
    }

    private void resolvePeriod() {
        if (this.date != null && this.time != null && !this.excessDays.isZero()) {
            this.date = this.date.plus((TemporalAmount) this.excessDays);
            this.excessDays = Period.ZERO;
        }
    }

    private void resolveFractional() {
        if (this.time == null) {
            if (this.fieldValues.containsKey(ChronoField.INSTANT_SECONDS) || this.fieldValues.containsKey(ChronoField.SECOND_OF_DAY) || this.fieldValues.containsKey(ChronoField.SECOND_OF_MINUTE)) {
                if (this.fieldValues.containsKey(ChronoField.NANO_OF_SECOND)) {
                    long nos = this.fieldValues.get(ChronoField.NANO_OF_SECOND).longValue();
                    this.fieldValues.put(ChronoField.MICRO_OF_SECOND, Long.valueOf(nos / 1000));
                    this.fieldValues.put(ChronoField.MILLI_OF_SECOND, Long.valueOf(nos / 1000000));
                } else {
                    this.fieldValues.put(ChronoField.NANO_OF_SECOND, 0L);
                    this.fieldValues.put(ChronoField.MICRO_OF_SECOND, 0L);
                    this.fieldValues.put(ChronoField.MILLI_OF_SECOND, 0L);
                }
            }
        }
    }

    private void resolveInstant() {
        if (!this.fieldValues.containsKey(ChronoField.INSTANT_SECONDS) && this.date != null && this.time != null) {
            Long offsetSecs = this.fieldValues.get(ChronoField.OFFSET_SECONDS);
            if (offsetSecs != null) {
                ZoneOffset offset = ZoneOffset.ofTotalSeconds(offsetSecs.intValue());
                long instant = this.date.atTime(this.time).atZone2(offset).toEpochSecond();
                this.fieldValues.put(ChronoField.INSTANT_SECONDS, Long.valueOf(instant));
            } else if (this.zone != null) {
                long instant2 = this.date.atTime(this.time).atZone2(this.zone).toEpochSecond();
                this.fieldValues.put(ChronoField.INSTANT_SECONDS, Long.valueOf(instant2));
            }
        }
    }

    private void updateCheckConflict(LocalTime timeToSet, Period periodToSet) {
        LocalTime localTime = this.time;
        if (localTime != null) {
            if (!localTime.equals(timeToSet)) {
                throw new DateTimeException("Conflict found: Fields resolved to different times: " + ((Object) this.time) + " " + ((Object) timeToSet));
            }
            if (!this.excessDays.isZero() && !periodToSet.isZero() && !this.excessDays.equals(periodToSet)) {
                throw new DateTimeException("Conflict found: Fields resolved to different excess periods: " + ((Object) this.excessDays) + " " + ((Object) periodToSet));
            }
            this.excessDays = periodToSet;
            return;
        }
        this.time = timeToSet;
        this.excessDays = periodToSet;
    }

    private void crossCheck() {
        ChronoLocalDate chronoLocalDate = this.date;
        if (chronoLocalDate != null) {
            crossCheck(chronoLocalDate);
        }
        LocalTime localTime = this.time;
        if (localTime != null) {
            crossCheck(localTime);
            if (this.date != null && this.fieldValues.size() > 0) {
                crossCheck(this.date.atTime(this.time));
            }
        }
    }

    private void crossCheck(TemporalAccessor target) {
        Iterator<Map.Entry<TemporalField, Long>> it = this.fieldValues.entrySet().iterator2();
        while (it.hasNext()) {
            Map.Entry<TemporalField, Long> entry = it.next();
            TemporalField field = entry.getKey();
            if (target.isSupported(field)) {
                try {
                    long val1 = target.getLong(field);
                    long val2 = entry.getValue().longValue();
                    if (val1 != val2) {
                        throw new DateTimeException("Conflict found: Field " + ((Object) field) + " " + val1 + " differs from " + ((Object) field) + " " + val2 + " derived from " + ((Object) target));
                    }
                    it.remove();
                } catch (RuntimeException e2) {
                }
            }
        }
    }

    public String toString() {
        StringBuilder buf = new StringBuilder(64);
        buf.append((Object) this.fieldValues).append(',').append((Object) this.chrono);
        if (this.zone != null) {
            buf.append(',').append((Object) this.zone);
        }
        if (this.date != null || this.time != null) {
            buf.append(" resolved to ");
            ChronoLocalDate chronoLocalDate = this.date;
            if (chronoLocalDate != null) {
                buf.append((Object) chronoLocalDate);
                if (this.time != null) {
                    buf.append('T').append((Object) this.time);
                }
            } else {
                buf.append((Object) this.time);
            }
        }
        return buf.toString();
    }
}
