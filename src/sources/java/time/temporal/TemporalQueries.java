package java.time.temporal;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.chrono.Chronology;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class TemporalQueries {
    static final TemporalQuery<ZoneId> ZONE_ID = new TemporalQuery<ZoneId>() { // from class: java.time.temporal.TemporalQueries.1
        @Override // java.time.temporal.TemporalQuery
        public ZoneId queryFrom(TemporalAccessor temporal) {
            return (ZoneId) temporal.query(TemporalQueries.ZONE_ID);
        }

        public String toString() {
            return "ZoneId";
        }
    };
    static final TemporalQuery<Chronology> CHRONO = new TemporalQuery<Chronology>() { // from class: java.time.temporal.TemporalQueries.2
        @Override // java.time.temporal.TemporalQuery
        public Chronology queryFrom(TemporalAccessor temporal) {
            return (Chronology) temporal.query(TemporalQueries.CHRONO);
        }

        public String toString() {
            return "Chronology";
        }
    };
    static final TemporalQuery<TemporalUnit> PRECISION = new TemporalQuery<TemporalUnit>() { // from class: java.time.temporal.TemporalQueries.3
        @Override // java.time.temporal.TemporalQuery
        public TemporalUnit queryFrom(TemporalAccessor temporal) {
            return (TemporalUnit) temporal.query(TemporalQueries.PRECISION);
        }

        public String toString() {
            return "Precision";
        }
    };
    static final TemporalQuery<ZoneOffset> OFFSET = new TemporalQuery<ZoneOffset>() { // from class: java.time.temporal.TemporalQueries.4
        @Override // java.time.temporal.TemporalQuery
        public ZoneOffset queryFrom(TemporalAccessor temporal) {
            if (temporal.isSupported(ChronoField.OFFSET_SECONDS)) {
                return ZoneOffset.ofTotalSeconds(temporal.get(ChronoField.OFFSET_SECONDS));
            }
            return null;
        }

        public String toString() {
            return "ZoneOffset";
        }
    };
    static final TemporalQuery<ZoneId> ZONE = new TemporalQuery<ZoneId>() { // from class: java.time.temporal.TemporalQueries.5
        @Override // java.time.temporal.TemporalQuery
        public ZoneId queryFrom(TemporalAccessor temporal) {
            ZoneId zone = (ZoneId) temporal.query(TemporalQueries.ZONE_ID);
            return zone != null ? zone : (ZoneId) temporal.query(TemporalQueries.OFFSET);
        }

        public String toString() {
            return "Zone";
        }
    };
    static final TemporalQuery<LocalDate> LOCAL_DATE = new TemporalQuery<LocalDate>() { // from class: java.time.temporal.TemporalQueries.6
        @Override // java.time.temporal.TemporalQuery
        public LocalDate queryFrom(TemporalAccessor temporal) {
            if (temporal.isSupported(ChronoField.EPOCH_DAY)) {
                return LocalDate.ofEpochDay(temporal.getLong(ChronoField.EPOCH_DAY));
            }
            return null;
        }

        public String toString() {
            return "LocalDate";
        }
    };
    static final TemporalQuery<LocalTime> LOCAL_TIME = new TemporalQuery<LocalTime>() { // from class: java.time.temporal.TemporalQueries.7
        @Override // java.time.temporal.TemporalQuery
        public LocalTime queryFrom(TemporalAccessor temporal) {
            if (temporal.isSupported(ChronoField.NANO_OF_DAY)) {
                return LocalTime.ofNanoOfDay(temporal.getLong(ChronoField.NANO_OF_DAY));
            }
            return null;
        }

        public String toString() {
            return "LocalTime";
        }
    };

    private TemporalQueries() {
    }

    public static TemporalQuery<ZoneId> zoneId() {
        return ZONE_ID;
    }

    public static TemporalQuery<Chronology> chronology() {
        return CHRONO;
    }

    public static TemporalQuery<TemporalUnit> precision() {
        return PRECISION;
    }

    public static TemporalQuery<ZoneId> zone() {
        return ZONE;
    }

    public static TemporalQuery<ZoneOffset> offset() {
        return OFFSET;
    }

    public static TemporalQuery<LocalDate> localDate() {
        return LOCAL_DATE;
    }

    public static TemporalQuery<LocalTime> localTime() {
        return LOCAL_TIME;
    }
}
