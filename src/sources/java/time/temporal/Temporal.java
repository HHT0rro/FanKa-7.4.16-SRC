package java.time.temporal;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface Temporal extends TemporalAccessor {
    boolean isSupported(TemporalUnit temporalUnit);

    Temporal plus(long j10, TemporalUnit temporalUnit);

    long until(Temporal temporal, TemporalUnit temporalUnit);

    Temporal with(TemporalField temporalField, long j10);

    default Temporal with(TemporalAdjuster adjuster) {
        return adjuster.adjustInto(this);
    }

    default Temporal plus(TemporalAmount amount) {
        return amount.addTo(this);
    }

    default Temporal minus(TemporalAmount amount) {
        return amount.subtractFrom(this);
    }

    default Temporal minus(long amountToSubtract, TemporalUnit unit) {
        return amountToSubtract == Long.MIN_VALUE ? plus(Long.MAX_VALUE, unit).plus(1L, unit) : plus(-amountToSubtract, unit);
    }
}
