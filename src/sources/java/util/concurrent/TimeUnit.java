package java.util.concurrent;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import okhttp3.internal.http2.Http2Connection;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public enum TimeUnit {
    NANOSECONDS(1),
    MICROSECONDS(1000),
    MILLISECONDS(1000000),
    SECONDS(SECOND_SCALE),
    MINUTES(MINUTE_SCALE),
    HOURS(HOUR_SCALE),
    DAYS(DAY_SCALE);

    private static final long DAY_SCALE = 86400000000000L;
    private static final long HOUR_SCALE = 3600000000000L;
    private static final long MICRO_SCALE = 1000;
    private static final long MILLI_SCALE = 1000000;
    private static final long MINUTE_SCALE = 60000000000L;
    private static final long NANO_SCALE = 1;
    private static final long SECOND_SCALE = 1000000000;
    private final long maxMicros;
    private final long maxMillis;
    private final long maxNanos;
    private final long maxSecs;
    private final long microRatio;
    private final int milliRatio;
    private final long scale;
    private final int secRatio;

    TimeUnit(long s2) {
        this.scale = s2;
        this.maxNanos = Long.MAX_VALUE / s2;
        long ur = s2 >= 1000 ? s2 / 1000 : 1000 / s2;
        this.microRatio = ur;
        this.maxMicros = Long.MAX_VALUE / ur;
        long mr = s2 >= 1000000 ? s2 / 1000000 : 1000000 / s2;
        this.milliRatio = (int) mr;
        this.maxMillis = Long.MAX_VALUE / mr;
        long sr = s2 >= SECOND_SCALE ? s2 / SECOND_SCALE : SECOND_SCALE / s2;
        this.secRatio = (int) sr;
        this.maxSecs = Long.MAX_VALUE / sr;
    }

    private static long cvt(long d10, long dst, long src) {
        if (src == dst) {
            return d10;
        }
        if (src < dst) {
            return d10 / (dst / src);
        }
        long r10 = src / dst;
        long m10 = Long.MAX_VALUE / r10;
        if (d10 > m10) {
            return Long.MAX_VALUE;
        }
        if (d10 < (-m10)) {
            return Long.MIN_VALUE;
        }
        return d10 * r10;
    }

    public long convert(long sourceDuration, TimeUnit sourceUnit) {
        switch (AnonymousClass1.$SwitchMap$java$util$concurrent$TimeUnit[ordinal()]) {
            case 1:
                return sourceUnit.toNanos(sourceDuration);
            case 2:
                return sourceUnit.toMicros(sourceDuration);
            case 3:
                return sourceUnit.toMillis(sourceDuration);
            case 4:
                return sourceUnit.toSeconds(sourceDuration);
            default:
                return cvt(sourceDuration, this.scale, sourceUnit.scale);
        }
    }

    public long convert(Duration duration) {
        long nanoVal;
        long secs = duration.getSeconds();
        int nano = duration.getNano();
        if (secs < 0 && nano > 0) {
            secs++;
            nano -= Http2Connection.DEGRADED_PONG_TIMEOUT_NS;
        }
        if (this == NANOSECONDS) {
            nanoVal = nano;
        } else {
            long nanoVal2 = this.scale;
            if (nanoVal2 < SECOND_SCALE) {
                nanoVal = nano / nanoVal2;
            } else {
                if (this == SECONDS) {
                    return secs;
                }
                return secs / this.secRatio;
            }
        }
        long val = (this.secRatio * secs) + nanoVal;
        long j10 = this.maxSecs;
        if ((secs >= j10 || secs <= (-j10)) && ((secs != j10 || val <= 0) && (secs != (-j10) || val >= 0))) {
            return secs > 0 ? Long.MAX_VALUE : Long.MIN_VALUE;
        }
        return val;
    }

    public long toNanos(long duration) {
        long s2 = this.scale;
        if (s2 == 1) {
            return duration;
        }
        long m10 = this.maxNanos;
        if (duration > m10) {
            return Long.MAX_VALUE;
        }
        if (duration < (-m10)) {
            return Long.MIN_VALUE;
        }
        return duration * s2;
    }

    public long toMicros(long duration) {
        long s2 = this.scale;
        if (s2 <= 1000) {
            return s2 == 1000 ? duration : duration / this.microRatio;
        }
        long m10 = this.maxMicros;
        if (duration > m10) {
            return Long.MAX_VALUE;
        }
        if (duration < (-m10)) {
            return Long.MIN_VALUE;
        }
        return this.microRatio * duration;
    }

    public long toMillis(long duration) {
        long s2 = this.scale;
        if (s2 <= 1000000) {
            return s2 == 1000000 ? duration : duration / this.milliRatio;
        }
        long m10 = this.maxMillis;
        if (duration > m10) {
            return Long.MAX_VALUE;
        }
        if (duration < (-m10)) {
            return Long.MIN_VALUE;
        }
        return this.milliRatio * duration;
    }

    public long toSeconds(long duration) {
        long s2 = this.scale;
        if (s2 <= SECOND_SCALE) {
            return s2 == SECOND_SCALE ? duration : duration / this.secRatio;
        }
        long m10 = this.maxSecs;
        if (duration > m10) {
            return Long.MAX_VALUE;
        }
        if (duration < (-m10)) {
            return Long.MIN_VALUE;
        }
        return this.secRatio * duration;
    }

    public long toMinutes(long duration) {
        return cvt(duration, MINUTE_SCALE, this.scale);
    }

    public long toHours(long duration) {
        return cvt(duration, HOUR_SCALE, this.scale);
    }

    public long toDays(long duration) {
        return cvt(duration, DAY_SCALE, this.scale);
    }

    private int excessNanos(long d10, long m10) {
        long s2 = this.scale;
        if (s2 == 1) {
            return (int) (d10 - (1000000 * m10));
        }
        if (s2 == 1000) {
            return (int) ((1000 * d10) - (1000000 * m10));
        }
        return 0;
    }

    public void timedWait(Object obj, long timeout) throws InterruptedException {
        if (timeout > 0) {
            long ms = toMillis(timeout);
            int ns = excessNanos(timeout, ms);
            obj.wait(ms, ns);
        }
    }

    public void timedJoin(Thread thread, long timeout) throws InterruptedException {
        if (timeout > 0) {
            long ms = toMillis(timeout);
            int ns = excessNanos(timeout, ms);
            thread.join(ms, ns);
        }
    }

    public void sleep(long timeout) throws InterruptedException {
        if (timeout > 0) {
            long ms = toMillis(timeout);
            int ns = excessNanos(timeout, ms);
            Thread.sleep(ms, ns);
        }
    }

    public ChronoUnit toChronoUnit() {
        switch (AnonymousClass1.$SwitchMap$java$util$concurrent$TimeUnit[ordinal()]) {
            case 1:
                return ChronoUnit.NANOS;
            case 2:
                return ChronoUnit.MICROS;
            case 3:
                return ChronoUnit.MILLIS;
            case 4:
                return ChronoUnit.SECONDS;
            case 5:
                return ChronoUnit.MINUTES;
            case 6:
                return ChronoUnit.HOURS;
            case 7:
                return ChronoUnit.DAYS;
            default:
                throw new AssertionError();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.util.concurrent.TimeUnit$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$time$temporal$ChronoUnit;
        static final /* synthetic */ int[] $SwitchMap$java$util$concurrent$TimeUnit;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            $SwitchMap$java$time$temporal$ChronoUnit = iArr;
            try {
                iArr[ChronoUnit.NANOS.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.MICROS.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.MILLIS.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError e15) {
            }
            int[] iArr2 = new int[TimeUnit.values().length];
            $SwitchMap$java$util$concurrent$TimeUnit = iArr2;
            try {
                iArr2[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError e16) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError e17) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError e18) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError e19) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError e20) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError e21) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError e22) {
            }
        }
    }

    public static TimeUnit of(ChronoUnit chronoUnit) {
        switch (AnonymousClass1.$SwitchMap$java$time$temporal$ChronoUnit[((ChronoUnit) Objects.requireNonNull(chronoUnit, "chronoUnit")).ordinal()]) {
            case 1:
                return NANOSECONDS;
            case 2:
                return MICROSECONDS;
            case 3:
                return MILLISECONDS;
            case 4:
                return SECONDS;
            case 5:
                return MINUTES;
            case 6:
                return HOURS;
            case 7:
                return DAYS;
            default:
                throw new IllegalArgumentException("No TimeUnit equivalent for " + ((Object) chronoUnit));
        }
    }
}
