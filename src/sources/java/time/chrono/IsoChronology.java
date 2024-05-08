package java.time.chrono;

import androidx.exifinterface.media.ExifInterface;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.Clock;
import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.time.temporal.ValueRange;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class IsoChronology extends AbstractChronology implements Serializable {
    private static final long DAYS_0000_TO_1970 = 719528;
    public static final IsoChronology INSTANCE = new IsoChronology();
    private static final long serialVersionUID = -1440403870442975015L;

    @Override // java.time.chrono.AbstractChronology, java.time.chrono.Chronology
    public /* bridge */ /* synthetic */ ChronoLocalDate resolveDate(Map map, ResolverStyle resolverStyle) {
        return resolveDate((Map<TemporalField, Long>) map, resolverStyle);
    }

    @Override // java.time.chrono.AbstractChronology
    /* bridge */ /* synthetic */ ChronoLocalDate resolveYMD(Map map, ResolverStyle resolverStyle) {
        return resolveYMD((Map<TemporalField, Long>) map, resolverStyle);
    }

    @Override // java.time.chrono.AbstractChronology
    /* bridge */ /* synthetic */ ChronoLocalDate resolveYearOfEra(Map map, ResolverStyle resolverStyle) {
        return resolveYearOfEra((Map<TemporalField, Long>) map, resolverStyle);
    }

    private IsoChronology() {
    }

    @Override // java.time.chrono.Chronology
    public String getId() {
        return ExifInterface.TAG_RW2_ISO;
    }

    @Override // java.time.chrono.Chronology
    public String getCalendarType() {
        return "iso8601";
    }

    @Override // java.time.chrono.Chronology
    public LocalDate date(Era era, int yearOfEra, int month, int dayOfMonth) {
        return date(prolepticYear(era, yearOfEra), month, dayOfMonth);
    }

    @Override // java.time.chrono.Chronology
    public LocalDate date(int prolepticYear, int month, int dayOfMonth) {
        return LocalDate.of(prolepticYear, month, dayOfMonth);
    }

    @Override // java.time.chrono.Chronology
    public LocalDate dateYearDay(Era era, int yearOfEra, int dayOfYear) {
        return dateYearDay(prolepticYear(era, yearOfEra), dayOfYear);
    }

    @Override // java.time.chrono.Chronology
    public LocalDate dateYearDay(int prolepticYear, int dayOfYear) {
        return LocalDate.ofYearDay(prolepticYear, dayOfYear);
    }

    @Override // java.time.chrono.Chronology
    public LocalDate dateEpochDay(long epochDay) {
        return LocalDate.ofEpochDay(epochDay);
    }

    @Override // java.time.chrono.Chronology
    public LocalDate date(TemporalAccessor temporal) {
        return LocalDate.from(temporal);
    }

    @Override // java.time.chrono.Chronology
    public long epochSecond(int prolepticYear, int month, int dayOfMonth, int hour, int minute, int second, ZoneOffset zoneOffset) {
        ChronoField.YEAR.checkValidValue(prolepticYear);
        ChronoField.MONTH_OF_YEAR.checkValidValue(month);
        ChronoField.DAY_OF_MONTH.checkValidValue(dayOfMonth);
        ChronoField.HOUR_OF_DAY.checkValidValue(hour);
        ChronoField.MINUTE_OF_HOUR.checkValidValue(minute);
        ChronoField.SECOND_OF_MINUTE.checkValidValue(second);
        Objects.requireNonNull(zoneOffset, "zoneOffset");
        if (dayOfMonth > 28) {
            int dom = numberOfDaysOfMonth(prolepticYear, month);
            if (dayOfMonth > dom) {
                if (dayOfMonth == 29) {
                    throw new DateTimeException("Invalid date 'February 29' as '" + prolepticYear + "' is not a leap year");
                }
                throw new DateTimeException("Invalid date '" + Month.of(month).name() + " " + dayOfMonth + "'");
            }
        }
        long totalDays = 0 + (prolepticYear * 365);
        long totalDays2 = (prolepticYear >= 0 ? totalDays + (((prolepticYear + 3) / 4) - ((prolepticYear + 99) / 100)) + ((prolepticYear + 399) / 400) : totalDays - (((prolepticYear / (-4)) - (prolepticYear / (-100))) + (prolepticYear / (-400)))) + (((month * 367) - 362) / 12) + (dayOfMonth - 1);
        if (month > 2) {
            totalDays2--;
            if (!INSTANCE.isLeapYear(prolepticYear)) {
                totalDays2--;
            }
        }
        int timeinSec = (((hour * 60) + minute) * 60) + second;
        return Math.addExact(Math.multiplyExact(totalDays2 - DAYS_0000_TO_1970, 86400L), timeinSec - zoneOffset.getTotalSeconds());
    }

    private int numberOfDaysOfMonth(int year, int month) {
        switch (month) {
            case 2:
                return INSTANCE.isLeapYear((long) year) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    @Override // java.time.chrono.Chronology
    public LocalDateTime localDateTime(TemporalAccessor temporal) {
        return LocalDateTime.from(temporal);
    }

    @Override // java.time.chrono.Chronology
    public ZonedDateTime zonedDateTime(TemporalAccessor temporal) {
        return ZonedDateTime.from(temporal);
    }

    @Override // java.time.chrono.Chronology
    public ZonedDateTime zonedDateTime(Instant instant, ZoneId zone) {
        return ZonedDateTime.ofInstant(instant, zone);
    }

    @Override // java.time.chrono.Chronology
    public LocalDate dateNow() {
        return dateNow(Clock.systemDefaultZone());
    }

    @Override // java.time.chrono.Chronology
    public LocalDate dateNow(ZoneId zone) {
        return dateNow(Clock.system(zone));
    }

    @Override // java.time.chrono.Chronology
    public LocalDate dateNow(Clock clock) {
        Objects.requireNonNull(clock, "clock");
        return date((TemporalAccessor) LocalDate.now(clock));
    }

    @Override // java.time.chrono.Chronology
    public boolean isLeapYear(long prolepticYear) {
        return (3 & prolepticYear) == 0 && (prolepticYear % 100 != 0 || prolepticYear % 400 == 0);
    }

    @Override // java.time.chrono.Chronology
    public int prolepticYear(Era era, int yearOfEra) {
        if (era instanceof IsoEra) {
            return era == IsoEra.CE ? yearOfEra : 1 - yearOfEra;
        }
        throw new ClassCastException("Era must be IsoEra");
    }

    @Override // java.time.chrono.Chronology
    public IsoEra eraOf(int eraValue) {
        return IsoEra.of(eraValue);
    }

    @Override // java.time.chrono.Chronology
    public List<Era> eras() {
        return List.of((Object[]) IsoEra.values());
    }

    @Override // java.time.chrono.AbstractChronology, java.time.chrono.Chronology
    public LocalDate resolveDate(Map<TemporalField, Long> fieldValues, ResolverStyle resolverStyle) {
        return (LocalDate) super.resolveDate(fieldValues, resolverStyle);
    }

    @Override // java.time.chrono.AbstractChronology
    void resolveProlepticMonth(Map<TemporalField, Long> fieldValues, ResolverStyle resolverStyle) {
        Long pMonth = fieldValues.remove(ChronoField.PROLEPTIC_MONTH);
        if (pMonth != null) {
            if (resolverStyle != ResolverStyle.LENIENT) {
                ChronoField.PROLEPTIC_MONTH.checkValidValue(pMonth.longValue());
            }
            addFieldValue(fieldValues, ChronoField.MONTH_OF_YEAR, Math.floorMod(pMonth.longValue(), 12) + 1);
            addFieldValue(fieldValues, ChronoField.YEAR, Math.floorDiv(pMonth.longValue(), 12));
        }
    }

    @Override // java.time.chrono.AbstractChronology
    LocalDate resolveYearOfEra(Map<TemporalField, Long> fieldValues, ResolverStyle resolverStyle) {
        Long yoeLong = fieldValues.remove(ChronoField.YEAR_OF_ERA);
        if (yoeLong != null) {
            if (resolverStyle != ResolverStyle.LENIENT) {
                ChronoField.YEAR_OF_ERA.checkValidValue(yoeLong.longValue());
            }
            Long era = fieldValues.remove(ChronoField.ERA);
            if (era != null) {
                if (era.longValue() == 1) {
                    addFieldValue(fieldValues, ChronoField.YEAR, yoeLong.longValue());
                    return null;
                }
                if (era.longValue() == 0) {
                    addFieldValue(fieldValues, ChronoField.YEAR, Math.subtractExact(1L, yoeLong.longValue()));
                    return null;
                }
                throw new DateTimeException("Invalid value for era: " + ((Object) era));
            }
            Long year = fieldValues.get(ChronoField.YEAR);
            if (resolverStyle == ResolverStyle.STRICT) {
                if (year != null) {
                    addFieldValue(fieldValues, ChronoField.YEAR, year.longValue() > 0 ? yoeLong.longValue() : Math.subtractExact(1L, yoeLong.longValue()));
                    return null;
                }
                fieldValues.put(ChronoField.YEAR_OF_ERA, yoeLong);
                return null;
            }
            addFieldValue(fieldValues, ChronoField.YEAR, (year == null || year.longValue() > 0) ? yoeLong.longValue() : Math.subtractExact(1L, yoeLong.longValue()));
            return null;
        }
        if (fieldValues.containsKey(ChronoField.ERA)) {
            ChronoField.ERA.checkValidValue(fieldValues.get(ChronoField.ERA).longValue());
            return null;
        }
        return null;
    }

    @Override // java.time.chrono.AbstractChronology
    LocalDate resolveYMD(Map<TemporalField, Long> fieldValues, ResolverStyle resolverStyle) {
        int y10 = ChronoField.YEAR.checkValidIntValue(fieldValues.remove(ChronoField.YEAR).longValue());
        if (resolverStyle == ResolverStyle.LENIENT) {
            long months = Math.subtractExact(fieldValues.remove(ChronoField.MONTH_OF_YEAR).longValue(), 1L);
            long days = Math.subtractExact(fieldValues.remove(ChronoField.DAY_OF_MONTH).longValue(), 1L);
            return LocalDate.of(y10, 1, 1).plusMonths(months).plusDays(days);
        }
        int moy = ChronoField.MONTH_OF_YEAR.checkValidIntValue(fieldValues.remove(ChronoField.MONTH_OF_YEAR).longValue());
        int dom = ChronoField.DAY_OF_MONTH.checkValidIntValue(fieldValues.remove(ChronoField.DAY_OF_MONTH).longValue());
        if (resolverStyle == ResolverStyle.SMART) {
            if (moy == 4 || moy == 6 || moy == 9 || moy == 11) {
                dom = Math.min(dom, 30);
            } else if (moy == 2) {
                dom = Math.min(dom, Month.FEBRUARY.length(Year.isLeap(y10)));
            }
        }
        return LocalDate.of(y10, moy, dom);
    }

    @Override // java.time.chrono.Chronology
    public ValueRange range(ChronoField field) {
        return field.range();
    }

    @Override // java.time.chrono.Chronology
    public Period period(int years, int months, int days) {
        return Period.of(years, months, days);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.time.chrono.AbstractChronology
    public Object writeReplace() {
        return super.writeReplace();
    }

    private void readObject(ObjectInputStream s2) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
