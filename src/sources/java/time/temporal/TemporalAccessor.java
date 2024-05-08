package java.time.temporal;

import java.time.DateTimeException;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface TemporalAccessor {
    long getLong(TemporalField temporalField);

    boolean isSupported(TemporalField temporalField);

    default ValueRange range(TemporalField field) {
        if (field instanceof ChronoField) {
            if (isSupported(field)) {
                return field.range();
            }
            throw new UnsupportedTemporalTypeException("Unsupported field: " + ((Object) field));
        }
        Objects.requireNonNull(field, "field");
        return field.rangeRefinedBy(this);
    }

    default int get(TemporalField field) {
        ValueRange range = range(field);
        if (!range.isIntValue()) {
            throw new UnsupportedTemporalTypeException("Invalid field " + ((Object) field) + " for get() method, use getLong() instead");
        }
        long value = getLong(field);
        if (!range.isValidValue(value)) {
            throw new DateTimeException("Invalid value for " + ((Object) field) + " (valid values " + ((Object) range) + "): " + value);
        }
        return (int) value;
    }

    default <R> R query(TemporalQuery<R> query) {
        if (query == TemporalQueries.zoneId() || query == TemporalQueries.chronology() || query == TemporalQueries.precision()) {
            return null;
        }
        return query.queryFrom(this);
    }
}
