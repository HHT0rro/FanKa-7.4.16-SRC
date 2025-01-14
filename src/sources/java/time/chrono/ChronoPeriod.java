package java.time.chrono;

import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface ChronoPeriod extends TemporalAmount {
    @Override // java.time.temporal.TemporalAmount
    Temporal addTo(Temporal temporal);

    boolean equals(Object obj);

    @Override // java.time.temporal.TemporalAmount
    long get(TemporalUnit temporalUnit);

    Chronology getChronology();

    @Override // java.time.temporal.TemporalAmount
    List<TemporalUnit> getUnits();

    int hashCode();

    ChronoPeriod minus(TemporalAmount temporalAmount);

    ChronoPeriod multipliedBy(int i10);

    ChronoPeriod normalized();

    ChronoPeriod plus(TemporalAmount temporalAmount);

    @Override // java.time.temporal.TemporalAmount
    Temporal subtractFrom(Temporal temporal);

    String toString();

    static ChronoPeriod between(ChronoLocalDate startDateInclusive, ChronoLocalDate endDateExclusive) {
        Objects.requireNonNull(startDateInclusive, "startDateInclusive");
        Objects.requireNonNull(endDateExclusive, "endDateExclusive");
        return startDateInclusive.until(endDateExclusive);
    }

    default boolean isZero() {
        for (TemporalUnit unit : getUnits()) {
            if (get(unit) != 0) {
                return false;
            }
        }
        return true;
    }

    default boolean isNegative() {
        for (TemporalUnit unit : getUnits()) {
            if (get(unit) < 0) {
                return true;
            }
        }
        return false;
    }

    default ChronoPeriod negated() {
        return multipliedBy(-1);
    }
}
