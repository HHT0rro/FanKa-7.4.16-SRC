package java.nio.file.attribute;

import com.android.internal.accessibility.common.ShortcutConstants;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class FileTime implements Comparable<FileTime> {
    private static final long DAYS_PER_10000_YEARS = 3652425;
    private static final long HOURS_PER_DAY = 24;
    private static final long MAX_SECOND = 31556889864403199L;
    private static final long MICROS_PER_SECOND = 1000000;
    private static final long MILLIS_PER_SECOND = 1000;
    private static final long MINUTES_PER_HOUR = 60;
    private static final long MIN_SECOND = -31557014167219200L;
    private static final int NANOS_PER_MICRO = 1000;
    private static final int NANOS_PER_MILLI = 1000000;
    private static final long NANOS_PER_SECOND = 1000000000;
    private static final long SECONDS_0000_TO_1970 = 62167219200L;
    private static final long SECONDS_PER_10000_YEARS = 315569520000L;
    private static final long SECONDS_PER_DAY = 86400;
    private static final long SECONDS_PER_HOUR = 3600;
    private static final long SECONDS_PER_MINUTE = 60;
    private Instant instant;
    private final TimeUnit unit;
    private final long value;
    private String valueAsString;

    private FileTime(long value, TimeUnit unit, Instant instant) {
        this.value = value;
        this.unit = unit;
        this.instant = instant;
    }

    public static FileTime from(long value, TimeUnit unit) {
        Objects.requireNonNull(unit, "unit");
        return new FileTime(value, unit, null);
    }

    public static FileTime fromMillis(long value) {
        return new FileTime(value, TimeUnit.MILLISECONDS, null);
    }

    public static FileTime from(Instant instant) {
        Objects.requireNonNull(instant, "instant");
        return new FileTime(0L, null, instant);
    }

    public long to(TimeUnit unit) {
        Objects.requireNonNull(unit, "unit");
        TimeUnit timeUnit = this.unit;
        if (timeUnit != null) {
            return unit.convert(this.value, timeUnit);
        }
        long secs = unit.convert(this.instant.getEpochSecond(), TimeUnit.SECONDS);
        if (secs == Long.MIN_VALUE || secs == Long.MAX_VALUE) {
            return secs;
        }
        long nanos = unit.convert(this.instant.getNano(), TimeUnit.NANOSECONDS);
        long r10 = secs + nanos;
        if (((secs ^ r10) & (nanos ^ r10)) < 0) {
            return secs < 0 ? Long.MIN_VALUE : Long.MAX_VALUE;
        }
        return r10;
    }

    public long toMillis() {
        TimeUnit timeUnit = this.unit;
        if (timeUnit != null) {
            return timeUnit.toMillis(this.value);
        }
        long secs = this.instant.getEpochSecond();
        int nanos = this.instant.getNano();
        long r10 = secs * 1000;
        long ax = Math.abs(secs);
        if (((ax | 1000) >>> 31) == 0 || r10 / 1000 == secs) {
            return (nanos / 1000000) + r10;
        }
        return secs < 0 ? Long.MIN_VALUE : Long.MAX_VALUE;
    }

    private static long scale(long d10, long m10, long over) {
        if (d10 > over) {
            return Long.MAX_VALUE;
        }
        if (d10 < (-over)) {
            return Long.MIN_VALUE;
        }
        return d10 * m10;
    }

    public Instant toInstant() {
        long secs;
        if (this.instant == null) {
            int nanos = 0;
            switch (AnonymousClass1.$SwitchMap$java$util$concurrent$TimeUnit[this.unit.ordinal()]) {
                case 1:
                    secs = scale(this.value, SECONDS_PER_DAY, 106751991167300L);
                    break;
                case 2:
                    secs = scale(this.value, SECONDS_PER_HOUR, 2562047788015215L);
                    break;
                case 3:
                    secs = scale(this.value, 60L, 153722867280912930L);
                    break;
                case 4:
                    secs = this.value;
                    break;
                case 5:
                    secs = Math.floorDiv(this.value, 1000L);
                    nanos = ((int) Math.floorMod(this.value, 1000L)) * 1000000;
                    break;
                case 6:
                    secs = Math.floorDiv(this.value, 1000000L);
                    nanos = ((int) Math.floorMod(this.value, 1000000L)) * 1000;
                    break;
                case 7:
                    secs = Math.floorDiv(this.value, NANOS_PER_SECOND);
                    nanos = (int) Math.floorMod(this.value, NANOS_PER_SECOND);
                    break;
                default:
                    throw new AssertionError((Object) "Unit not handled");
            }
            if (secs <= MIN_SECOND) {
                this.instant = Instant.MIN;
            } else if (secs >= MAX_SECOND) {
                this.instant = Instant.MAX;
            } else {
                this.instant = Instant.ofEpochSecond(secs, nanos);
            }
        }
        return this.instant;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.nio.file.attribute.FileTime$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$util$concurrent$TimeUnit;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            $SwitchMap$java$util$concurrent$TimeUnit = iArr;
            try {
                iArr[TimeUnit.DAYS.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.HOURS.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MINUTES.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MILLISECONDS.ordinal()] = 5;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MICROSECONDS.ordinal()] = 6;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.NANOSECONDS.ordinal()] = 7;
            } catch (NoSuchFieldError e15) {
            }
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof FileTime) && compareTo((FileTime) obj) == 0;
    }

    public int hashCode() {
        return toInstant().hashCode();
    }

    private long toDays() {
        TimeUnit timeUnit = this.unit;
        if (timeUnit != null) {
            return timeUnit.toDays(this.value);
        }
        return TimeUnit.SECONDS.toDays(toInstant().getEpochSecond());
    }

    private long toExcessNanos(long days) {
        TimeUnit timeUnit = this.unit;
        if (timeUnit != null) {
            return timeUnit.toNanos(this.value - timeUnit.convert(days, TimeUnit.DAYS));
        }
        return TimeUnit.SECONDS.toNanos(toInstant().getEpochSecond() - TimeUnit.DAYS.toSeconds(days));
    }

    @Override // java.lang.Comparable
    public int compareTo(FileTime other) {
        TimeUnit timeUnit = this.unit;
        if (timeUnit != null && timeUnit == other.unit) {
            return Long.compare(this.value, other.value);
        }
        long secs = toInstant().getEpochSecond();
        long secsOther = other.toInstant().getEpochSecond();
        int cmp = Long.compare(secs, secsOther);
        if (cmp != 0) {
            return cmp;
        }
        int cmp2 = Long.compare(toInstant().getNano(), other.toInstant().getNano());
        if (cmp2 != 0) {
            return cmp2;
        }
        if (secs != MAX_SECOND && secs != MIN_SECOND) {
            return 0;
        }
        long days = toDays();
        long daysOther = other.toDays();
        if (days == daysOther) {
            return Long.compare(toExcessNanos(days), other.toExcessNanos(daysOther));
        }
        return Long.compare(days, daysOther);
    }

    private StringBuilder append(StringBuilder sb2, int w3, int d10) {
        while (w3 > 0) {
            sb2.append((char) ((d10 / w3) + 48));
            d10 %= w3;
            w3 /= 10;
        }
        return sb2;
    }

    public String toString() {
        long secs;
        LocalDateTime ldt;
        int year;
        if (this.valueAsString == null) {
            int nanos = 0;
            if (this.instant == null && this.unit.compareTo(TimeUnit.SECONDS) >= 0) {
                secs = this.unit.toSeconds(this.value);
            } else {
                secs = toInstant().getEpochSecond();
                nanos = toInstant().getNano();
            }
            if (secs >= -62167219200L) {
                long zeroSecs = (secs - SECONDS_PER_10000_YEARS) + SECONDS_0000_TO_1970;
                long hi = Math.floorDiv(zeroSecs, SECONDS_PER_10000_YEARS) + 1;
                long lo = Math.floorMod(zeroSecs, SECONDS_PER_10000_YEARS);
                ldt = LocalDateTime.ofEpochSecond(lo - SECONDS_0000_TO_1970, nanos, ZoneOffset.UTC);
                year = ldt.getYear() + (((int) hi) * 10000);
            } else {
                long zeroSecs2 = secs + SECONDS_0000_TO_1970;
                long hi2 = zeroSecs2 / SECONDS_PER_10000_YEARS;
                long lo2 = zeroSecs2 % SECONDS_PER_10000_YEARS;
                ldt = LocalDateTime.ofEpochSecond(lo2 - SECONDS_0000_TO_1970, nanos, ZoneOffset.UTC);
                year = ldt.getYear() + (((int) hi2) * 10000);
            }
            if (year <= 0) {
                year--;
            }
            int fraction = ldt.getNano();
            StringBuilder sb2 = new StringBuilder(64);
            sb2.append(year < 0 ? "-" : "");
            int year2 = Math.abs(year);
            if (year2 < 10000) {
                append(sb2, 1000, Math.abs(year2));
            } else {
                sb2.append(String.valueOf(year2));
            }
            sb2.append('-');
            append(sb2, 10, ldt.getMonthValue());
            sb2.append('-');
            append(sb2, 10, ldt.getDayOfMonth());
            sb2.append('T');
            append(sb2, 10, ldt.getHour());
            sb2.append(ShortcutConstants.SERVICES_SEPARATOR);
            append(sb2, 10, ldt.getMinute());
            sb2.append(ShortcutConstants.SERVICES_SEPARATOR);
            append(sb2, 10, ldt.getSecond());
            if (fraction != 0) {
                sb2.append('.');
                int w3 = 100000000;
                while (fraction % 10 == 0) {
                    fraction /= 10;
                    w3 /= 10;
                }
                append(sb2, w3, fraction);
            }
            sb2.append('Z');
            this.valueAsString = sb2.toString();
        }
        return this.valueAsString;
    }
}
