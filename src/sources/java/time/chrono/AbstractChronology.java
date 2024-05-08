package java.time.chrono;

import androidx.exifinterface.media.ExifInterface;
import com.alibaba.security.biometrics.service.build.b;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;
import java.time.temporal.ValueRange;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import sun.util.logging.PlatformLogger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class AbstractChronology implements Chronology {
    private static final ConcurrentHashMap<String, Chronology> CHRONOS_BY_ID = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Chronology> CHRONOS_BY_TYPE = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Chronology registerChrono(Chronology chrono) {
        return registerChrono(chrono, chrono.getId());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Chronology registerChrono(Chronology chrono, String id2) {
        String type;
        Chronology prev = CHRONOS_BY_ID.putIfAbsent(id2, chrono);
        if (prev == null && (type = chrono.getCalendarType()) != null) {
            CHRONOS_BY_TYPE.putIfAbsent(type, chrono);
        }
        return prev;
    }

    private static boolean initCache() {
        if (CHRONOS_BY_ID.get(ExifInterface.TAG_RW2_ISO) == null) {
            registerChrono(HijrahChronology.INSTANCE);
            registerChrono(JapaneseChronology.INSTANCE);
            registerChrono(MinguoChronology.INSTANCE);
            registerChrono(ThaiBuddhistChronology.INSTANCE);
            ServiceLoader<AbstractChronology> loader = ServiceLoader.load(AbstractChronology.class, null);
            Iterator<AbstractChronology> iterator2 = loader.iterator2();
            while (iterator2.hasNext()) {
                AbstractChronology chrono = iterator2.next();
                String id2 = chrono.getId();
                if (id2.equals(ExifInterface.TAG_RW2_ISO) || registerChrono(chrono) != null) {
                    PlatformLogger logger = PlatformLogger.getLogger("java.time.chrono");
                    logger.warning("Ignoring duplicate Chronology, from ServiceLoader configuration " + id2);
                }
            }
            registerChrono(IsoChronology.INSTANCE);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Chronology ofLocale(Locale locale) {
        Objects.requireNonNull(locale, "locale");
        String type = locale.getUnicodeLocaleType("ca");
        if (type == null || b.bp.equals(type) || "iso8601".equals(type)) {
            return IsoChronology.INSTANCE;
        }
        do {
            Chronology chrono = CHRONOS_BY_TYPE.get(type);
            if (chrono != null) {
                return chrono;
            }
        } while (initCache());
        ServiceLoader<Chronology> loader = ServiceLoader.load(Chronology.class);
        Iterator<Chronology> iterator2 = loader.iterator2();
        while (iterator2.hasNext()) {
            Chronology chrono2 = iterator2.next();
            if (type.equals(chrono2.getCalendarType())) {
                return chrono2;
            }
        }
        throw new DateTimeException("Unknown calendar system: " + type);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Chronology of(String id2) {
        Objects.requireNonNull(id2, "id");
        do {
            Chronology chrono = of0(id2);
            if (chrono != null) {
                return chrono;
            }
        } while (initCache());
        ServiceLoader<Chronology> loader = ServiceLoader.load(Chronology.class);
        Iterator<Chronology> iterator2 = loader.iterator2();
        while (iterator2.hasNext()) {
            Chronology chrono2 = iterator2.next();
            if (id2.equals(chrono2.getId()) || id2.equals(chrono2.getCalendarType())) {
                return chrono2;
            }
        }
        throw new DateTimeException("Unknown chronology: " + id2);
    }

    private static Chronology of0(String id2) {
        Chronology chrono = CHRONOS_BY_ID.get(id2);
        if (chrono == null) {
            return CHRONOS_BY_TYPE.get(id2);
        }
        return chrono;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Set<Chronology> getAvailableChronologies() {
        initCache();
        HashSet<Chronology> chronos = new HashSet<>(CHRONOS_BY_ID.values());
        ServiceLoader<Chronology> loader = ServiceLoader.load(Chronology.class);
        Iterator<Chronology> iterator2 = loader.iterator2();
        while (iterator2.hasNext()) {
            Chronology chrono = iterator2.next();
            chronos.add(chrono);
        }
        return chronos;
    }

    @Override // java.time.chrono.Chronology
    public ChronoLocalDate resolveDate(Map<TemporalField, Long> fieldValues, ResolverStyle resolverStyle) {
        if (fieldValues.containsKey(ChronoField.EPOCH_DAY)) {
            return dateEpochDay(fieldValues.remove(ChronoField.EPOCH_DAY).longValue());
        }
        resolveProlepticMonth(fieldValues, resolverStyle);
        ChronoLocalDate resolved = resolveYearOfEra(fieldValues, resolverStyle);
        if (resolved != null) {
            return resolved;
        }
        if (fieldValues.containsKey(ChronoField.YEAR)) {
            if (fieldValues.containsKey(ChronoField.MONTH_OF_YEAR)) {
                if (fieldValues.containsKey(ChronoField.DAY_OF_MONTH)) {
                    return resolveYMD(fieldValues, resolverStyle);
                }
                if (fieldValues.containsKey(ChronoField.ALIGNED_WEEK_OF_MONTH)) {
                    if (fieldValues.containsKey(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH)) {
                        return resolveYMAA(fieldValues, resolverStyle);
                    }
                    if (fieldValues.containsKey(ChronoField.DAY_OF_WEEK)) {
                        return resolveYMAD(fieldValues, resolverStyle);
                    }
                }
            }
            if (fieldValues.containsKey(ChronoField.DAY_OF_YEAR)) {
                return resolveYD(fieldValues, resolverStyle);
            }
            if (fieldValues.containsKey(ChronoField.ALIGNED_WEEK_OF_YEAR)) {
                if (fieldValues.containsKey(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR)) {
                    return resolveYAA(fieldValues, resolverStyle);
                }
                if (fieldValues.containsKey(ChronoField.DAY_OF_WEEK)) {
                    return resolveYAD(fieldValues, resolverStyle);
                }
                return null;
            }
            return null;
        }
        return null;
    }

    void resolveProlepticMonth(Map<TemporalField, Long> fieldValues, ResolverStyle resolverStyle) {
        Long pMonth = fieldValues.remove(ChronoField.PROLEPTIC_MONTH);
        if (pMonth != null) {
            if (resolverStyle != ResolverStyle.LENIENT) {
                ChronoField.PROLEPTIC_MONTH.checkValidValue(pMonth.longValue());
            }
            ChronoLocalDate chronoDate = dateNow().with((TemporalField) ChronoField.DAY_OF_MONTH, 1L).with((TemporalField) ChronoField.PROLEPTIC_MONTH, pMonth.longValue());
            addFieldValue(fieldValues, ChronoField.MONTH_OF_YEAR, chronoDate.get(ChronoField.MONTH_OF_YEAR));
            addFieldValue(fieldValues, ChronoField.YEAR, chronoDate.get(ChronoField.YEAR));
        }
    }

    ChronoLocalDate resolveYearOfEra(Map<TemporalField, Long> fieldValues, ResolverStyle resolverStyle) {
        int yoe;
        Long yoeLong = fieldValues.remove(ChronoField.YEAR_OF_ERA);
        if (yoeLong != null) {
            Long eraLong = fieldValues.remove(ChronoField.ERA);
            if (resolverStyle != ResolverStyle.LENIENT) {
                yoe = range(ChronoField.YEAR_OF_ERA).checkValidIntValue(yoeLong.longValue(), ChronoField.YEAR_OF_ERA);
            } else {
                yoe = Math.toIntExact(yoeLong.longValue());
            }
            if (eraLong != null) {
                Era eraObj = eraOf(range(ChronoField.ERA).checkValidIntValue(eraLong.longValue(), ChronoField.ERA));
                addFieldValue(fieldValues, ChronoField.YEAR, prolepticYear(eraObj, yoe));
                return null;
            }
            if (fieldValues.containsKey(ChronoField.YEAR)) {
                int year = range(ChronoField.YEAR).checkValidIntValue(fieldValues.get(ChronoField.YEAR).longValue(), ChronoField.YEAR);
                ChronoLocalDate chronoDate = dateYearDay(year, 1);
                addFieldValue(fieldValues, ChronoField.YEAR, prolepticYear(chronoDate.getEra(), yoe));
                return null;
            }
            if (resolverStyle == ResolverStyle.STRICT) {
                fieldValues.put(ChronoField.YEAR_OF_ERA, yoeLong);
                return null;
            }
            List<Era> eras = eras();
            if (eras.isEmpty()) {
                addFieldValue(fieldValues, ChronoField.YEAR, yoe);
                return null;
            }
            Era eraObj2 = eras.get(eras.size() - 1);
            addFieldValue(fieldValues, ChronoField.YEAR, prolepticYear(eraObj2, yoe));
            return null;
        }
        if (fieldValues.containsKey(ChronoField.ERA)) {
            range(ChronoField.ERA).checkValidValue(fieldValues.get(ChronoField.ERA).longValue(), ChronoField.ERA);
            return null;
        }
        return null;
    }

    ChronoLocalDate resolveYMD(Map<TemporalField, Long> fieldValues, ResolverStyle resolverStyle) {
        int y10 = range(ChronoField.YEAR).checkValidIntValue(fieldValues.remove(ChronoField.YEAR).longValue(), ChronoField.YEAR);
        if (resolverStyle == ResolverStyle.LENIENT) {
            long months = Math.subtractExact(fieldValues.remove(ChronoField.MONTH_OF_YEAR).longValue(), 1L);
            long days = Math.subtractExact(fieldValues.remove(ChronoField.DAY_OF_MONTH).longValue(), 1L);
            return date(y10, 1, 1).plus(months, (TemporalUnit) ChronoUnit.MONTHS).plus(days, (TemporalUnit) ChronoUnit.DAYS);
        }
        int moy = range(ChronoField.MONTH_OF_YEAR).checkValidIntValue(fieldValues.remove(ChronoField.MONTH_OF_YEAR).longValue(), ChronoField.MONTH_OF_YEAR);
        ValueRange domRange = range(ChronoField.DAY_OF_MONTH);
        int dom = domRange.checkValidIntValue(fieldValues.remove(ChronoField.DAY_OF_MONTH).longValue(), ChronoField.DAY_OF_MONTH);
        if (resolverStyle == ResolverStyle.SMART) {
            try {
                return date(y10, moy, dom);
            } catch (DateTimeException e2) {
                return date(y10, moy, 1).with(TemporalAdjusters.lastDayOfMonth());
            }
        }
        return date(y10, moy, dom);
    }

    ChronoLocalDate resolveYD(Map<TemporalField, Long> fieldValues, ResolverStyle resolverStyle) {
        int y10 = range(ChronoField.YEAR).checkValidIntValue(fieldValues.remove(ChronoField.YEAR).longValue(), ChronoField.YEAR);
        if (resolverStyle == ResolverStyle.LENIENT) {
            long days = Math.subtractExact(fieldValues.remove(ChronoField.DAY_OF_YEAR).longValue(), 1L);
            return dateYearDay(y10, 1).plus(days, (TemporalUnit) ChronoUnit.DAYS);
        }
        int doy = range(ChronoField.DAY_OF_YEAR).checkValidIntValue(fieldValues.remove(ChronoField.DAY_OF_YEAR).longValue(), ChronoField.DAY_OF_YEAR);
        return dateYearDay(y10, doy);
    }

    ChronoLocalDate resolveYMAA(Map<TemporalField, Long> fieldValues, ResolverStyle resolverStyle) {
        int y10 = range(ChronoField.YEAR).checkValidIntValue(fieldValues.remove(ChronoField.YEAR).longValue(), ChronoField.YEAR);
        if (resolverStyle == ResolverStyle.LENIENT) {
            long months = Math.subtractExact(fieldValues.remove(ChronoField.MONTH_OF_YEAR).longValue(), 1L);
            long weeks = Math.subtractExact(fieldValues.remove(ChronoField.ALIGNED_WEEK_OF_MONTH).longValue(), 1L);
            long days = Math.subtractExact(fieldValues.remove(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH).longValue(), 1L);
            return date(y10, 1, 1).plus(months, (TemporalUnit) ChronoUnit.MONTHS).plus(weeks, (TemporalUnit) ChronoUnit.WEEKS).plus(days, (TemporalUnit) ChronoUnit.DAYS);
        }
        int moy = range(ChronoField.MONTH_OF_YEAR).checkValidIntValue(fieldValues.remove(ChronoField.MONTH_OF_YEAR).longValue(), ChronoField.MONTH_OF_YEAR);
        int aw = range(ChronoField.ALIGNED_WEEK_OF_MONTH).checkValidIntValue(fieldValues.remove(ChronoField.ALIGNED_WEEK_OF_MONTH).longValue(), ChronoField.ALIGNED_WEEK_OF_MONTH);
        int ad2 = range(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH).checkValidIntValue(fieldValues.remove(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH).longValue(), ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        ChronoLocalDate date = date(y10, moy, 1).plus(((aw - 1) * 7) + (ad2 - 1), (TemporalUnit) ChronoUnit.DAYS);
        if (resolverStyle == ResolverStyle.STRICT && date.get(ChronoField.MONTH_OF_YEAR) != moy) {
            throw new DateTimeException("Strict mode rejected resolved date as it is in a different month");
        }
        return date;
    }

    ChronoLocalDate resolveYMAD(Map<TemporalField, Long> fieldValues, ResolverStyle resolverStyle) {
        int y10 = range(ChronoField.YEAR).checkValidIntValue(fieldValues.remove(ChronoField.YEAR).longValue(), ChronoField.YEAR);
        if (resolverStyle != ResolverStyle.LENIENT) {
            int moy = range(ChronoField.MONTH_OF_YEAR).checkValidIntValue(fieldValues.remove(ChronoField.MONTH_OF_YEAR).longValue(), ChronoField.MONTH_OF_YEAR);
            int aw = range(ChronoField.ALIGNED_WEEK_OF_MONTH).checkValidIntValue(fieldValues.remove(ChronoField.ALIGNED_WEEK_OF_MONTH).longValue(), ChronoField.ALIGNED_WEEK_OF_MONTH);
            int dow = range(ChronoField.DAY_OF_WEEK).checkValidIntValue(fieldValues.remove(ChronoField.DAY_OF_WEEK).longValue(), ChronoField.DAY_OF_WEEK);
            ChronoLocalDate date = date(y10, moy, 1).plus((aw - 1) * 7, (TemporalUnit) ChronoUnit.DAYS).with(TemporalAdjusters.nextOrSame(DayOfWeek.of(dow)));
            if (resolverStyle == ResolverStyle.STRICT && date.get(ChronoField.MONTH_OF_YEAR) != moy) {
                throw new DateTimeException("Strict mode rejected resolved date as it is in a different month");
            }
            return date;
        }
        long months = Math.subtractExact(fieldValues.remove(ChronoField.MONTH_OF_YEAR).longValue(), 1L);
        long weeks = Math.subtractExact(fieldValues.remove(ChronoField.ALIGNED_WEEK_OF_MONTH).longValue(), 1L);
        long dow2 = Math.subtractExact(fieldValues.remove(ChronoField.DAY_OF_WEEK).longValue(), 1L);
        return resolveAligned(date(y10, 1, 1), months, weeks, dow2);
    }

    ChronoLocalDate resolveYAA(Map<TemporalField, Long> fieldValues, ResolverStyle resolverStyle) {
        int y10 = range(ChronoField.YEAR).checkValidIntValue(fieldValues.remove(ChronoField.YEAR).longValue(), ChronoField.YEAR);
        if (resolverStyle == ResolverStyle.LENIENT) {
            long weeks = Math.subtractExact(fieldValues.remove(ChronoField.ALIGNED_WEEK_OF_YEAR).longValue(), 1L);
            long days = Math.subtractExact(fieldValues.remove(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR).longValue(), 1L);
            return dateYearDay(y10, 1).plus(weeks, (TemporalUnit) ChronoUnit.WEEKS).plus(days, (TemporalUnit) ChronoUnit.DAYS);
        }
        int aw = range(ChronoField.ALIGNED_WEEK_OF_YEAR).checkValidIntValue(fieldValues.remove(ChronoField.ALIGNED_WEEK_OF_YEAR).longValue(), ChronoField.ALIGNED_WEEK_OF_YEAR);
        int ad2 = range(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR).checkValidIntValue(fieldValues.remove(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR).longValue(), ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR);
        ChronoLocalDate date = dateYearDay(y10, 1).plus(((aw - 1) * 7) + (ad2 - 1), (TemporalUnit) ChronoUnit.DAYS);
        if (resolverStyle == ResolverStyle.STRICT && date.get(ChronoField.YEAR) != y10) {
            throw new DateTimeException("Strict mode rejected resolved date as it is in a different year");
        }
        return date;
    }

    ChronoLocalDate resolveYAD(Map<TemporalField, Long> fieldValues, ResolverStyle resolverStyle) {
        int y10 = range(ChronoField.YEAR).checkValidIntValue(fieldValues.remove(ChronoField.YEAR).longValue(), ChronoField.YEAR);
        if (resolverStyle != ResolverStyle.LENIENT) {
            int aw = range(ChronoField.ALIGNED_WEEK_OF_YEAR).checkValidIntValue(fieldValues.remove(ChronoField.ALIGNED_WEEK_OF_YEAR).longValue(), ChronoField.ALIGNED_WEEK_OF_YEAR);
            int dow = range(ChronoField.DAY_OF_WEEK).checkValidIntValue(fieldValues.remove(ChronoField.DAY_OF_WEEK).longValue(), ChronoField.DAY_OF_WEEK);
            ChronoLocalDate date = dateYearDay(y10, 1).plus((aw - 1) * 7, (TemporalUnit) ChronoUnit.DAYS).with(TemporalAdjusters.nextOrSame(DayOfWeek.of(dow)));
            if (resolverStyle == ResolverStyle.STRICT && date.get(ChronoField.YEAR) != y10) {
                throw new DateTimeException("Strict mode rejected resolved date as it is in a different year");
            }
            return date;
        }
        long weeks = Math.subtractExact(fieldValues.remove(ChronoField.ALIGNED_WEEK_OF_YEAR).longValue(), 1L);
        long dow2 = Math.subtractExact(fieldValues.remove(ChronoField.DAY_OF_WEEK).longValue(), 1L);
        return resolveAligned(dateYearDay(y10, 1), 0L, weeks, dow2);
    }

    ChronoLocalDate resolveAligned(ChronoLocalDate base, long months, long weeks, long dow) {
        ChronoLocalDate date = base.plus(months, (TemporalUnit) ChronoUnit.MONTHS).plus(weeks, (TemporalUnit) ChronoUnit.WEEKS);
        if (dow > 7) {
            date = date.plus((dow - 1) / 7, (TemporalUnit) ChronoUnit.WEEKS);
            dow = ((dow - 1) % 7) + 1;
        } else if (dow < 1) {
            date = date.plus(Math.subtractExact(dow, 7L) / 7, (TemporalUnit) ChronoUnit.WEEKS);
            dow = ((6 + dow) % 7) + 1;
        }
        return date.with(TemporalAdjusters.nextOrSame(DayOfWeek.of((int) dow)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addFieldValue(Map<TemporalField, Long> fieldValues, ChronoField field, long value) {
        Long old = fieldValues.get(field);
        if (old != null && old.longValue() != value) {
            throw new DateTimeException("Conflict found: " + ((Object) field) + " " + ((Object) old) + " differs from " + ((Object) field) + " " + value);
        }
        fieldValues.put(field, Long.valueOf(value));
    }

    @Override // java.time.chrono.Chronology, java.lang.Comparable
    public int compareTo(Chronology other) {
        return getId().compareTo(other.getId());
    }

    @Override // java.time.chrono.Chronology
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AbstractChronology) && compareTo((Chronology) obj) == 0;
    }

    @Override // java.time.chrono.Chronology
    public int hashCode() {
        return getClass().hashCode() ^ getId().hashCode();
    }

    @Override // java.time.chrono.Chronology
    public String toString() {
        return getId();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public Object writeReplace() {
        return new Ser((byte) 1, (Serializable) this);
    }

    private void readObject(ObjectInputStream s2) throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(DataOutput out) throws IOException {
        out.writeUTF(getId());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Chronology readExternal(DataInput in) throws IOException {
        String id2 = in.readUTF();
        return Chronology.of(id2);
    }
}
