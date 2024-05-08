package java.time;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.kwad.sdk.core.response.model.SdkConfigData;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Duration implements TemporalAmount, Comparable<Duration>, Serializable {
    private static final long serialVersionUID = 3078945930695997490L;
    private final int nanos;
    private final long seconds;
    public static final Duration ZERO = new Duration(0, 0);
    private static final BigInteger BI_NANOS_PER_SECOND = BigInteger.valueOf(1000000000);
    private static final Pattern PATTERN = Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)D)?(T(?:([-+]?[0-9]+)H)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)(?:[.,]([0-9]{0,9}))?S)?)?", 2);

    public static Duration ofDays(long days) {
        return create(Math.multiplyExact(days, RemoteMessageConst.DEFAULT_TTL), 0);
    }

    public static Duration ofHours(long hours) {
        return create(Math.multiplyExact(hours, SdkConfigData.DEFAULT_REQUEST_INTERVAL), 0);
    }

    public static Duration ofMinutes(long minutes) {
        return create(Math.multiplyExact(minutes, 60), 0);
    }

    public static Duration ofSeconds(long seconds) {
        return create(seconds, 0);
    }

    public static Duration ofSeconds(long seconds, long nanoAdjustment) {
        long secs = Math.addExact(seconds, Math.floorDiv(nanoAdjustment, 1000000000L));
        int nos = (int) Math.floorMod(nanoAdjustment, 1000000000L);
        return create(secs, nos);
    }

    public static Duration ofMillis(long millis) {
        long secs = millis / 1000;
        int mos = (int) (millis % 1000);
        if (mos < 0) {
            mos += 1000;
            secs--;
        }
        return create(secs, 1000000 * mos);
    }

    public static Duration ofNanos(long nanos) {
        long secs = nanos / 1000000000;
        int nos = (int) (nanos % 1000000000);
        if (nos < 0) {
            nos = (int) (nos + 1000000000);
            secs--;
        }
        return create(secs, nos);
    }

    public static Duration of(long amount, TemporalUnit unit) {
        return ZERO.plus(amount, unit);
    }

    public static Duration from(TemporalAmount amount) {
        Objects.requireNonNull(amount, "amount");
        Duration duration = ZERO;
        for (TemporalUnit unit : amount.getUnits()) {
            duration = duration.plus(amount.get(unit), unit);
        }
        return duration;
    }

    public static Duration parse(CharSequence text) {
        Objects.requireNonNull(text, "text");
        Matcher matcher = PATTERN.matcher(text);
        if (matcher.matches() && !ExifInterface.GPS_DIRECTION_TRUE.equals(matcher.group(3))) {
            boolean negate = "-".equals(matcher.group(1));
            String dayMatch = matcher.group(2);
            String hourMatch = matcher.group(4);
            String minuteMatch = matcher.group(5);
            String secondMatch = matcher.group(6);
            String fractionMatch = matcher.group(7);
            if (dayMatch != null || hourMatch != null || minuteMatch != null || secondMatch != null) {
                long daysAsSecs = parseNumber(text, dayMatch, RemoteMessageConst.DEFAULT_TTL, "days");
                long hoursAsSecs = parseNumber(text, hourMatch, SdkConfigData.DEFAULT_REQUEST_INTERVAL, "hours");
                long minsAsSecs = parseNumber(text, minuteMatch, 60, "minutes");
                long seconds = parseNumber(text, secondMatch, 1, "seconds");
                int nanos = parseFraction(text, fractionMatch, seconds < 0 ? -1 : 1);
                try {
                    return create(negate, daysAsSecs, hoursAsSecs, minsAsSecs, seconds, nanos);
                } catch (ArithmeticException ex) {
                    throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: overflow", text, 0).initCause(ex));
                }
            }
        }
        throw new DateTimeParseException("Text cannot be parsed to a Duration", text, 0);
    }

    private static long parseNumber(CharSequence text, String parsed, int multiplier, String errorText) {
        if (parsed == null) {
            return 0L;
        }
        try {
            long val = Long.parseLong(parsed);
            return Math.multiplyExact(val, multiplier);
        } catch (ArithmeticException | NumberFormatException ex) {
            throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: " + errorText, text, 0).initCause(ex));
        }
    }

    private static int parseFraction(CharSequence text, String parsed, int negate) {
        if (parsed == null || parsed.length() == 0) {
            return 0;
        }
        try {
            return Integer.parseInt((parsed + "000000000").substring(0, 9)) * negate;
        } catch (ArithmeticException | NumberFormatException ex) {
            throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: fraction", text, 0).initCause(ex));
        }
    }

    private static Duration create(boolean negate, long daysAsSecs, long hoursAsSecs, long minsAsSecs, long secs, int nanos) {
        long seconds = Math.addExact(daysAsSecs, Math.addExact(hoursAsSecs, Math.addExact(minsAsSecs, secs)));
        if (negate) {
            return ofSeconds(seconds, nanos).negated();
        }
        return ofSeconds(seconds, nanos);
    }

    public static Duration between(Temporal startInclusive, Temporal endExclusive) {
        long nanos;
        try {
            return ofNanos(startInclusive.until(endExclusive, ChronoUnit.NANOS));
        } catch (ArithmeticException | DateTimeException e2) {
            long secs = startInclusive.until(endExclusive, ChronoUnit.SECONDS);
            try {
                nanos = endExclusive.getLong(ChronoField.NANO_OF_SECOND) - startInclusive.getLong(ChronoField.NANO_OF_SECOND);
                if (secs > 0 && nanos < 0) {
                    secs++;
                } else if (secs < 0 && nanos > 0) {
                    secs--;
                }
            } catch (DateTimeException e10) {
                nanos = 0;
            }
            return ofSeconds(secs, nanos);
        }
    }

    private static Duration create(long seconds, int nanoAdjustment) {
        if ((nanoAdjustment | seconds) == 0) {
            return ZERO;
        }
        return new Duration(seconds, nanoAdjustment);
    }

    private Duration(long seconds, int nanos) {
        this.seconds = seconds;
        this.nanos = nanos;
    }

    @Override // java.time.temporal.TemporalAmount
    public long get(TemporalUnit unit) {
        if (unit == ChronoUnit.SECONDS) {
            return this.seconds;
        }
        if (unit == ChronoUnit.NANOS) {
            return this.nanos;
        }
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + ((Object) unit));
    }

    @Override // java.time.temporal.TemporalAmount
    public List<TemporalUnit> getUnits() {
        return DurationUnits.UNITS;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class DurationUnits {
        static final List<TemporalUnit> UNITS = Collections.unmodifiableList(Arrays.asList(ChronoUnit.SECONDS, ChronoUnit.NANOS));

        private DurationUnits() {
        }
    }

    public boolean isZero() {
        return (this.seconds | ((long) this.nanos)) == 0;
    }

    public boolean isNegative() {
        return this.seconds < 0;
    }

    public long getSeconds() {
        return this.seconds;
    }

    public int getNano() {
        return this.nanos;
    }

    public Duration withSeconds(long seconds) {
        return create(seconds, this.nanos);
    }

    public Duration withNanos(int nanoOfSecond) {
        ChronoField.NANO_OF_SECOND.checkValidIntValue(nanoOfSecond);
        return create(this.seconds, nanoOfSecond);
    }

    public Duration plus(Duration duration) {
        return plus(duration.getSeconds(), duration.getNano());
    }

    public Duration plus(long amountToAdd, TemporalUnit unit) {
        Objects.requireNonNull(unit, "unit");
        if (unit == ChronoUnit.DAYS) {
            return plus(Math.multiplyExact(amountToAdd, RemoteMessageConst.DEFAULT_TTL), 0L);
        }
        if (unit.isDurationEstimated()) {
            throw new UnsupportedTemporalTypeException("Unit must not have an estimated duration");
        }
        if (amountToAdd == 0) {
            return this;
        }
        if (unit instanceof ChronoUnit) {
            ChronoUnit chronoUnit = (ChronoUnit) unit;
            switch (AnonymousClass1.$SwitchMap$java$time$temporal$ChronoUnit[chronoUnit.ordinal()]) {
                case 1:
                    return plusNanos(amountToAdd);
                case 2:
                    return plusSeconds((amountToAdd / 1000000000) * 1000).plusNanos((amountToAdd % 1000000000) * 1000);
                case 3:
                    return plusMillis(amountToAdd);
                case 4:
                    return plusSeconds(amountToAdd);
                default:
                    return plusSeconds(Math.multiplyExact(unit.getDuration().seconds, amountToAdd));
            }
        }
        Duration duration = unit.getDuration().multipliedBy(amountToAdd);
        return plusSeconds(duration.getSeconds()).plusNanos(duration.getNano());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.time.Duration$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$time$temporal$ChronoUnit;

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
        }
    }

    public Duration plusDays(long daysToAdd) {
        return plus(Math.multiplyExact(daysToAdd, RemoteMessageConst.DEFAULT_TTL), 0L);
    }

    public Duration plusHours(long hoursToAdd) {
        return plus(Math.multiplyExact(hoursToAdd, SdkConfigData.DEFAULT_REQUEST_INTERVAL), 0L);
    }

    public Duration plusMinutes(long minutesToAdd) {
        return plus(Math.multiplyExact(minutesToAdd, 60), 0L);
    }

    public Duration plusSeconds(long secondsToAdd) {
        return plus(secondsToAdd, 0L);
    }

    public Duration plusMillis(long millisToAdd) {
        return plus(millisToAdd / 1000, (millisToAdd % 1000) * 1000000);
    }

    public Duration plusNanos(long nanosToAdd) {
        return plus(0L, nanosToAdd);
    }

    private Duration plus(long secondsToAdd, long nanosToAdd) {
        if ((secondsToAdd | nanosToAdd) == 0) {
            return this;
        }
        long epochSec = Math.addExact(this.seconds, secondsToAdd);
        long nanoAdjustment = this.nanos + (nanosToAdd % 1000000000);
        return ofSeconds(Math.addExact(epochSec, nanosToAdd / 1000000000), nanoAdjustment);
    }

    public Duration minus(Duration duration) {
        long secsToSubtract = duration.getSeconds();
        int nanosToSubtract = duration.getNano();
        if (secsToSubtract == Long.MIN_VALUE) {
            return plus(Long.MAX_VALUE, -nanosToSubtract).plus(1L, 0L);
        }
        return plus(-secsToSubtract, -nanosToSubtract);
    }

    public Duration minus(long amountToSubtract, TemporalUnit unit) {
        return amountToSubtract == Long.MIN_VALUE ? plus(Long.MAX_VALUE, unit).plus(1L, unit) : plus(-amountToSubtract, unit);
    }

    public Duration minusDays(long daysToSubtract) {
        return daysToSubtract == Long.MIN_VALUE ? plusDays(Long.MAX_VALUE).plusDays(1L) : plusDays(-daysToSubtract);
    }

    public Duration minusHours(long hoursToSubtract) {
        return hoursToSubtract == Long.MIN_VALUE ? plusHours(Long.MAX_VALUE).plusHours(1L) : plusHours(-hoursToSubtract);
    }

    public Duration minusMinutes(long minutesToSubtract) {
        return minutesToSubtract == Long.MIN_VALUE ? plusMinutes(Long.MAX_VALUE).plusMinutes(1L) : plusMinutes(-minutesToSubtract);
    }

    public Duration minusSeconds(long secondsToSubtract) {
        return secondsToSubtract == Long.MIN_VALUE ? plusSeconds(Long.MAX_VALUE).plusSeconds(1L) : plusSeconds(-secondsToSubtract);
    }

    public Duration minusMillis(long millisToSubtract) {
        return millisToSubtract == Long.MIN_VALUE ? plusMillis(Long.MAX_VALUE).plusMillis(1L) : plusMillis(-millisToSubtract);
    }

    public Duration minusNanos(long nanosToSubtract) {
        return nanosToSubtract == Long.MIN_VALUE ? plusNanos(Long.MAX_VALUE).plusNanos(1L) : plusNanos(-nanosToSubtract);
    }

    public Duration multipliedBy(long multiplicand) {
        if (multiplicand == 0) {
            return ZERO;
        }
        if (multiplicand == 1) {
            return this;
        }
        return create(toBigDecimalSeconds().multiply(BigDecimal.valueOf(multiplicand)));
    }

    public Duration dividedBy(long divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        if (divisor == 1) {
            return this;
        }
        return create(toBigDecimalSeconds().divide(BigDecimal.valueOf(divisor), RoundingMode.DOWN));
    }

    public long dividedBy(Duration divisor) {
        Objects.requireNonNull(divisor, "divisor");
        BigDecimal dividendBigD = toBigDecimalSeconds();
        BigDecimal divisorBigD = divisor.toBigDecimalSeconds();
        return dividendBigD.divideToIntegralValue(divisorBigD).longValueExact();
    }

    private BigDecimal toBigDecimalSeconds() {
        return BigDecimal.valueOf(this.seconds).add(BigDecimal.valueOf(this.nanos, 9));
    }

    private static Duration create(BigDecimal seconds) {
        BigInteger nanos = seconds.movePointRight(9).toBigIntegerExact();
        BigInteger[] divRem = nanos.divideAndRemainder(BI_NANOS_PER_SECOND);
        if (divRem[0].bitLength() > 63) {
            throw new ArithmeticException("Exceeds capacity of Duration: " + ((Object) nanos));
        }
        return ofSeconds(divRem[0].longValue(), divRem[1].intValue());
    }

    public Duration negated() {
        return multipliedBy(-1L);
    }

    public Duration abs() {
        return isNegative() ? negated() : this;
    }

    @Override // java.time.temporal.TemporalAmount
    public Temporal addTo(Temporal temporal) {
        long j10 = this.seconds;
        if (j10 != 0) {
            temporal = temporal.plus(j10, ChronoUnit.SECONDS);
        }
        int i10 = this.nanos;
        if (i10 != 0) {
            return temporal.plus(i10, ChronoUnit.NANOS);
        }
        return temporal;
    }

    @Override // java.time.temporal.TemporalAmount
    public Temporal subtractFrom(Temporal temporal) {
        long j10 = this.seconds;
        if (j10 != 0) {
            temporal = temporal.minus(j10, ChronoUnit.SECONDS);
        }
        int i10 = this.nanos;
        if (i10 != 0) {
            return temporal.minus(i10, ChronoUnit.NANOS);
        }
        return temporal;
    }

    public long toDays() {
        return this.seconds / 86400;
    }

    public long toHours() {
        return this.seconds / 3600;
    }

    public long toMinutes() {
        return this.seconds / 60;
    }

    public long toSeconds() {
        return this.seconds;
    }

    public long toMillis() {
        long millis = Math.multiplyExact(this.seconds, 1000);
        return Math.addExact(millis, this.nanos / 1000000);
    }

    public long toNanos() {
        long totalNanos = Math.multiplyExact(this.seconds, 1000000000L);
        return Math.addExact(totalNanos, this.nanos);
    }

    public long toDaysPart() {
        return this.seconds / 86400;
    }

    public int toHoursPart() {
        return (int) (toHours() % 24);
    }

    public int toMinutesPart() {
        return (int) (toMinutes() % 60);
    }

    public int toSecondsPart() {
        return (int) (this.seconds % 60);
    }

    public int toMillisPart() {
        return this.nanos / 1000000;
    }

    public int toNanosPart() {
        return this.nanos;
    }

    public Duration truncatedTo(TemporalUnit unit) {
        Objects.requireNonNull(unit, "unit");
        if (unit == ChronoUnit.SECONDS) {
            long j10 = this.seconds;
            if (j10 >= 0 || this.nanos == 0) {
                return new Duration(j10, 0);
            }
        }
        if (unit == ChronoUnit.NANOS) {
            return this;
        }
        Duration unitDur = unit.getDuration();
        if (unitDur.getSeconds() > 86400) {
            throw new UnsupportedTemporalTypeException("Unit is too large to be used for truncation");
        }
        long dur = unitDur.toNanos();
        if (86400000000000L % dur != 0) {
            throw new UnsupportedTemporalTypeException("Unit must divide into a standard day without remainder");
        }
        long nod = ((this.seconds % 86400) * 1000000000) + this.nanos;
        long result = (nod / dur) * dur;
        return plusNanos(result - nod);
    }

    @Override // java.lang.Comparable
    public int compareTo(Duration otherDuration) {
        int cmp = Long.compare(this.seconds, otherDuration.seconds);
        if (cmp != 0) {
            return cmp;
        }
        return this.nanos - otherDuration.nanos;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Duration) {
            Duration otherDuration = (Duration) other;
            if (this.seconds == otherDuration.seconds && this.nanos == otherDuration.nanos) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j10 = this.seconds;
        return ((int) (j10 ^ (j10 >>> 32))) + (this.nanos * 51);
    }

    public String toString() {
        if (this == ZERO) {
            return "PT0S";
        }
        long j10 = this.seconds;
        long hours = j10 / 3600;
        int minutes = (int) ((j10 % 3600) / 60);
        int secs = (int) (j10 % 60);
        StringBuilder buf = new StringBuilder(24);
        buf.append("PT");
        if (hours != 0) {
            buf.append(hours).append('H');
        }
        if (minutes != 0) {
            buf.append(minutes).append('M');
        }
        if (secs == 0 && this.nanos == 0 && buf.length() > 2) {
            return buf.toString();
        }
        if (secs < 0 && this.nanos > 0) {
            if (secs == -1) {
                buf.append("-0");
            } else {
                buf.append(secs + 1);
            }
        } else {
            buf.append(secs);
        }
        if (this.nanos > 0) {
            int pos = buf.length();
            if (secs < 0) {
                buf.append(2000000000 - this.nanos);
            } else {
                buf.append(this.nanos + 1000000000);
            }
            while (buf.charAt(buf.length() - 1) == '0') {
                buf.setLength(buf.length() - 1);
            }
            buf.setCharAt(pos, '.');
        }
        buf.append('S');
        return buf.toString();
    }

    private Object writeReplace() {
        return new Ser((byte) 1, this);
    }

    private void readObject(ObjectInputStream s2) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(DataOutput out) throws IOException {
        out.writeLong(this.seconds);
        out.writeInt(this.nanos);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Duration readExternal(DataInput in) throws IOException {
        long seconds = in.readLong();
        int nanos = in.readInt();
        return ofSeconds(seconds, nanos);
    }
}
