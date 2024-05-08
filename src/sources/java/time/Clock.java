package java.time;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.time.temporal.TemporalAmount;
import java.util.Objects;
import jdk.internal.misc.VM;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class Clock implements InstantSource {
    private static final long OFFSET_SEED;
    private static long offset;

    public abstract ZoneId getZone();

    @Override // java.time.InstantSource
    public abstract Instant instant();

    @Override // java.time.InstantSource
    public abstract Clock withZone(ZoneId zoneId);

    public static Clock systemUTC() {
        return SystemClock.UTC;
    }

    public static Clock systemDefaultZone() {
        return new SystemClock(ZoneId.systemDefault());
    }

    public static Clock system(ZoneId zone) {
        Objects.requireNonNull(zone, "zone");
        if (zone == ZoneOffset.UTC) {
            return SystemClock.UTC;
        }
        return new SystemClock(zone);
    }

    public static Clock tickMillis(ZoneId zone) {
        return new TickClock(system(zone), 1000000L);
    }

    public static Clock tickSeconds(ZoneId zone) {
        return new TickClock(system(zone), 1000000000L);
    }

    public static Clock tickMinutes(ZoneId zone) {
        return new TickClock(system(zone), 60000000000L);
    }

    public static Clock tick(Clock baseClock, Duration tickDuration) {
        Objects.requireNonNull(baseClock, "baseClock");
        Objects.requireNonNull(tickDuration, "tickDuration");
        if (tickDuration.isNegative()) {
            throw new IllegalArgumentException("Tick duration must not be negative");
        }
        long tickNanos = tickDuration.toNanos();
        if (tickNanos % 1000000 != 0 && 1000000000 % tickNanos != 0) {
            throw new IllegalArgumentException("Invalid tick duration");
        }
        if (tickNanos <= 1) {
            return baseClock;
        }
        return new TickClock(baseClock, tickNanos);
    }

    public static Clock fixed(Instant fixedInstant, ZoneId zone) {
        Objects.requireNonNull(fixedInstant, "fixedInstant");
        Objects.requireNonNull(zone, "zone");
        return new FixedClock(fixedInstant, zone);
    }

    public static Clock offset(Clock baseClock, Duration offsetDuration) {
        Objects.requireNonNull(baseClock, "baseClock");
        Objects.requireNonNull(offsetDuration, "offsetDuration");
        if (offsetDuration.equals(Duration.ZERO)) {
            return baseClock;
        }
        return new OffsetClock(baseClock, offsetDuration);
    }

    protected Clock() {
    }

    @Override // java.time.InstantSource
    public long millis() {
        return instant().toEpochMilli();
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }

    static {
        long currentTimeMillis = (System.currentTimeMillis() / 1000) - 1024;
        OFFSET_SEED = currentTimeMillis;
        offset = currentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Instant currentInstant() {
        long localOffset = offset;
        long adjustment = VM.getNanoTimeAdjustment(localOffset);
        if (adjustment == -1) {
            localOffset = (System.currentTimeMillis() / 1000) - 1024;
            adjustment = VM.getNanoTimeAdjustment(localOffset);
            if (adjustment == -1) {
                throw new InternalError("Offset " + localOffset + " is not in range");
            }
            offset = localOffset;
        }
        return Instant.ofEpochSecond(localOffset, adjustment);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class SystemInstantSource implements InstantSource, Serializable {
        static final SystemInstantSource INSTANCE = new SystemInstantSource();
        private static final long serialVersionUID = 3232399674412L;

        SystemInstantSource() {
        }

        @Override // java.time.InstantSource
        public Clock withZone(ZoneId zone) {
            return Clock.system(zone);
        }

        @Override // java.time.InstantSource
        public long millis() {
            return System.currentTimeMillis();
        }

        @Override // java.time.InstantSource
        public Instant instant() {
            return Clock.currentInstant();
        }

        public boolean equals(Object obj) {
            return obj instanceof SystemInstantSource;
        }

        public int hashCode() {
            return SystemInstantSource.class.hashCode();
        }

        public String toString() {
            return "SystemInstantSource";
        }

        private Object readResolve() throws ObjectStreamException {
            return INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class SystemClock extends Clock implements Serializable {
        static final SystemClock UTC = new SystemClock(ZoneOffset.UTC);
        private static final long serialVersionUID = 6740630888130243051L;
        private final ZoneId zone;

        SystemClock(ZoneId zone) {
            this.zone = zone;
        }

        @Override // java.time.Clock
        public ZoneId getZone() {
            return this.zone;
        }

        @Override // java.time.Clock, java.time.InstantSource
        public Clock withZone(ZoneId zone) {
            if (zone.equals(this.zone)) {
                return this;
            }
            return new SystemClock(zone);
        }

        @Override // java.time.Clock, java.time.InstantSource
        public long millis() {
            return System.currentTimeMillis();
        }

        @Override // java.time.Clock, java.time.InstantSource
        public Instant instant() {
            return currentInstant();
        }

        @Override // java.time.Clock
        public boolean equals(Object obj) {
            if (obj instanceof SystemClock) {
                return this.zone.equals(((SystemClock) obj).zone);
            }
            return false;
        }

        @Override // java.time.Clock
        public int hashCode() {
            return this.zone.hashCode() + 1;
        }

        public String toString() {
            return "SystemClock[" + ((Object) this.zone) + "]";
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class FixedClock extends Clock implements Serializable {
        private static final long serialVersionUID = 7430389292664866958L;
        private final Instant instant;
        private final ZoneId zone;

        FixedClock(Instant fixedInstant, ZoneId zone) {
            this.instant = fixedInstant;
            this.zone = zone;
        }

        @Override // java.time.Clock
        public ZoneId getZone() {
            return this.zone;
        }

        @Override // java.time.Clock, java.time.InstantSource
        public Clock withZone(ZoneId zone) {
            if (zone.equals(this.zone)) {
                return this;
            }
            return new FixedClock(this.instant, zone);
        }

        @Override // java.time.Clock, java.time.InstantSource
        public long millis() {
            return this.instant.toEpochMilli();
        }

        @Override // java.time.Clock, java.time.InstantSource
        public Instant instant() {
            return this.instant;
        }

        @Override // java.time.Clock
        public boolean equals(Object obj) {
            if (obj instanceof FixedClock) {
                FixedClock other = (FixedClock) obj;
                if (this.instant.equals(other.instant) && this.zone.equals(other.zone)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.time.Clock
        public int hashCode() {
            return this.instant.hashCode() ^ this.zone.hashCode();
        }

        public String toString() {
            return "FixedClock[" + ((Object) this.instant) + "," + ((Object) this.zone) + "]";
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class OffsetClock extends Clock implements Serializable {
        private static final long serialVersionUID = 2007484719125426256L;
        private final Clock baseClock;
        private final Duration offset;

        OffsetClock(Clock baseClock, Duration offset) {
            this.baseClock = baseClock;
            this.offset = offset;
        }

        @Override // java.time.Clock
        public ZoneId getZone() {
            return this.baseClock.getZone();
        }

        @Override // java.time.Clock, java.time.InstantSource
        public Clock withZone(ZoneId zone) {
            if (zone.equals(this.baseClock.getZone())) {
                return this;
            }
            return new OffsetClock(this.baseClock.withZone(zone), this.offset);
        }

        @Override // java.time.Clock, java.time.InstantSource
        public long millis() {
            return Math.addExact(this.baseClock.millis(), this.offset.toMillis());
        }

        @Override // java.time.Clock, java.time.InstantSource
        public Instant instant() {
            return this.baseClock.instant().plus((TemporalAmount) this.offset);
        }

        @Override // java.time.Clock
        public boolean equals(Object obj) {
            if (obj instanceof OffsetClock) {
                OffsetClock other = (OffsetClock) obj;
                if (this.baseClock.equals(other.baseClock) && this.offset.equals(other.offset)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.time.Clock
        public int hashCode() {
            return this.baseClock.hashCode() ^ this.offset.hashCode();
        }

        public String toString() {
            return "OffsetClock[" + ((Object) this.baseClock) + "," + ((Object) this.offset) + "]";
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class TickClock extends Clock implements Serializable {
        private static final long serialVersionUID = 6504659149906368850L;
        private final Clock baseClock;
        private final long tickNanos;

        TickClock(Clock baseClock, long tickNanos) {
            this.baseClock = baseClock;
            this.tickNanos = tickNanos;
        }

        @Override // java.time.Clock
        public ZoneId getZone() {
            return this.baseClock.getZone();
        }

        @Override // java.time.Clock, java.time.InstantSource
        public Clock withZone(ZoneId zone) {
            if (zone.equals(this.baseClock.getZone())) {
                return this;
            }
            return new TickClock(this.baseClock.withZone(zone), this.tickNanos);
        }

        @Override // java.time.Clock, java.time.InstantSource
        public long millis() {
            long millis = this.baseClock.millis();
            return millis - Math.floorMod(millis, this.tickNanos / 1000000);
        }

        @Override // java.time.Clock, java.time.InstantSource
        public Instant instant() {
            if (this.tickNanos % 1000000 == 0) {
                long millis = this.baseClock.millis();
                return Instant.ofEpochMilli(millis - Math.floorMod(millis, this.tickNanos / 1000000));
            }
            Instant instant = this.baseClock.instant();
            long nanos = instant.getNano();
            long adjust = Math.floorMod(nanos, this.tickNanos);
            return instant.minusNanos(adjust);
        }

        @Override // java.time.Clock
        public boolean equals(Object obj) {
            if (obj instanceof TickClock) {
                TickClock other = (TickClock) obj;
                if (this.tickNanos == other.tickNanos && this.baseClock.equals(other.baseClock)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.time.Clock
        public int hashCode() {
            int hashCode = this.baseClock.hashCode();
            long j10 = this.tickNanos;
            return hashCode ^ ((int) (j10 ^ (j10 >>> 32)));
        }

        public String toString() {
            return "TickClock[" + ((Object) this.baseClock) + "," + ((Object) Duration.ofNanos(this.tickNanos)) + "]";
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class SourceClock extends Clock implements Serializable {
        private static final long serialVersionUID = 235386528762398L;
        private final InstantSource baseSource;
        private final ZoneId zone;

        /* JADX INFO: Access modifiers changed from: package-private */
        public SourceClock(InstantSource baseSource, ZoneId zone) {
            this.baseSource = baseSource;
            this.zone = zone;
        }

        @Override // java.time.Clock
        public ZoneId getZone() {
            return this.zone;
        }

        @Override // java.time.Clock, java.time.InstantSource
        public Clock withZone(ZoneId zone) {
            if (zone.equals(this.zone)) {
                return this;
            }
            return new SourceClock(this.baseSource, zone);
        }

        @Override // java.time.Clock, java.time.InstantSource
        public long millis() {
            return this.baseSource.millis();
        }

        @Override // java.time.Clock, java.time.InstantSource
        public Instant instant() {
            return this.baseSource.instant();
        }

        @Override // java.time.Clock
        public boolean equals(Object obj) {
            if (obj instanceof SourceClock) {
                SourceClock other = (SourceClock) obj;
                if (this.zone.equals(other.zone) && this.baseSource.equals(other.baseSource)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.time.Clock
        public int hashCode() {
            return this.baseSource.hashCode() ^ this.zone.hashCode();
        }

        public String toString() {
            return "SourceClock[" + ((Object) this.baseSource) + "," + ((Object) this.zone) + "]";
        }
    }
}
