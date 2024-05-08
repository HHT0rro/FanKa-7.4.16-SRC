package java.time.zone;

import com.amap.api.services.core.AMapException;
import com.android.internal.os.Zygote;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.kwad.sdk.core.response.model.SdkConfigData;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.time.chrono.IsoChronology;
import java.time.temporal.TemporalAdjusters;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class ZoneOffsetTransitionRule implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long serialVersionUID = 6889046316657758795L;
    private final byte dom;
    private final DayOfWeek dow;
    private final Month month;
    private final ZoneOffset offsetAfter;
    private final ZoneOffset offsetBefore;
    private final ZoneOffset standardOffset;
    private final LocalTime time;
    private final TimeDefinition timeDefinition;
    private final boolean timeEndOfDay;

    public static ZoneOffsetTransitionRule of(Month month, int dayOfMonthIndicator, DayOfWeek dayOfWeek, LocalTime time, boolean timeEndOfDay, TimeDefinition timeDefinition, ZoneOffset standardOffset, ZoneOffset offsetBefore, ZoneOffset offsetAfter) {
        Objects.requireNonNull(month, "month");
        Objects.requireNonNull(time, "time");
        Objects.requireNonNull(timeDefinition, "timeDefinition");
        Objects.requireNonNull(standardOffset, "standardOffset");
        Objects.requireNonNull(offsetBefore, "offsetBefore");
        Objects.requireNonNull(offsetAfter, "offsetAfter");
        if (dayOfMonthIndicator < -28 || dayOfMonthIndicator > 31 || dayOfMonthIndicator == 0) {
            throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
        }
        if (timeEndOfDay && !time.equals(LocalTime.MIDNIGHT)) {
            throw new IllegalArgumentException("Time must be midnight when end of day flag is true");
        }
        if (time.getNano() != 0) {
            throw new IllegalArgumentException("Time's nano-of-second must be zero");
        }
        return new ZoneOffsetTransitionRule(month, dayOfMonthIndicator, dayOfWeek, time, timeEndOfDay, timeDefinition, standardOffset, offsetBefore, offsetAfter);
    }

    ZoneOffsetTransitionRule(Month month, int dayOfMonthIndicator, DayOfWeek dayOfWeek, LocalTime time, boolean timeEndOfDay, TimeDefinition timeDefinition, ZoneOffset standardOffset, ZoneOffset offsetBefore, ZoneOffset offsetAfter) {
        this.month = month;
        this.dom = (byte) dayOfMonthIndicator;
        this.dow = dayOfWeek;
        this.time = time;
        this.timeEndOfDay = timeEndOfDay;
        this.timeDefinition = timeDefinition;
        this.standardOffset = standardOffset;
        this.offsetBefore = offsetBefore;
        this.offsetAfter = offsetAfter;
    }

    private void readObject(ObjectInputStream s2) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 3, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(DataOutput out) throws IOException {
        int timeSecs = this.timeEndOfDay ? RemoteMessageConst.DEFAULT_TTL : this.time.toSecondOfDay();
        int stdOffset = this.standardOffset.getTotalSeconds();
        int beforeDiff = this.offsetBefore.getTotalSeconds() - stdOffset;
        int afterDiff = this.offsetAfter.getTotalSeconds() - stdOffset;
        int timeByte = timeSecs % SdkConfigData.DEFAULT_REQUEST_INTERVAL == 0 ? this.timeEndOfDay ? 24 : this.time.getHour() : 31;
        int stdOffsetByte = stdOffset % 900 == 0 ? (stdOffset / 900) + 128 : 255;
        int beforeByte = (beforeDiff == 0 || beforeDiff == 1800 || beforeDiff == 3600) ? beforeDiff / AMapException.CODE_AMAP_CLIENT_ERRORCODE_MISSSING : 3;
        int afterByte = (afterDiff == 0 || afterDiff == 1800 || afterDiff == 3600) ? afterDiff / AMapException.CODE_AMAP_CLIENT_ERRORCODE_MISSSING : 3;
        DayOfWeek dayOfWeek = this.dow;
        int dowByte = dayOfWeek == null ? 0 : dayOfWeek.getValue();
        int b4 = (this.month.getValue() << 28) + ((this.dom + 32) << 22) + (dowByte << 19) + (timeByte << 14) + (this.timeDefinition.ordinal() << 12) + (stdOffsetByte << 4) + (beforeByte << 2) + afterByte;
        out.writeInt(b4);
        if (timeByte == 31) {
            out.writeInt(timeSecs);
        }
        if (stdOffsetByte == 255) {
            out.writeInt(stdOffset);
        }
        if (beforeByte == 3) {
            out.writeInt(this.offsetBefore.getTotalSeconds());
        }
        if (afterByte == 3) {
            out.writeInt(this.offsetAfter.getTotalSeconds());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ZoneOffsetTransitionRule readExternal(DataInput in) throws IOException {
        int data = in.readInt();
        Month month = Month.of(data >>> 28);
        int dom = ((264241152 & data) >>> 22) - 32;
        int dowByte = (3670016 & data) >>> 19;
        DayOfWeek dow = dowByte == 0 ? null : DayOfWeek.of(dowByte);
        int timeByte = (507904 & data) >>> 14;
        TimeDefinition defn = TimeDefinition.values()[(data & Zygote.API_ENFORCEMENT_POLICY_MASK) >>> 12];
        int stdByte = (data & 4080) >>> 4;
        int beforeByte = (data & 12) >>> 2;
        int afterByte = data & 3;
        LocalTime time = timeByte == 31 ? LocalTime.ofSecondOfDay(in.readInt()) : LocalTime.of(timeByte % 24, 0);
        ZoneOffset std = ZoneOffset.ofTotalSeconds(stdByte == 255 ? in.readInt() : (stdByte - 128) * 900);
        ZoneOffset before = ZoneOffset.ofTotalSeconds(beforeByte == 3 ? in.readInt() : std.getTotalSeconds() + (beforeByte * AMapException.CODE_AMAP_CLIENT_ERRORCODE_MISSSING));
        ZoneOffset after = ZoneOffset.ofTotalSeconds(afterByte == 3 ? in.readInt() : std.getTotalSeconds() + (afterByte * AMapException.CODE_AMAP_CLIENT_ERRORCODE_MISSSING));
        return of(month, dom, dow, time, timeByte == 24, defn, std, before, after);
    }

    public Month getMonth() {
        return this.month;
    }

    public int getDayOfMonthIndicator() {
        return this.dom;
    }

    public DayOfWeek getDayOfWeek() {
        return this.dow;
    }

    public LocalTime getLocalTime() {
        return this.time;
    }

    public boolean isMidnightEndOfDay() {
        return this.timeEndOfDay;
    }

    public TimeDefinition getTimeDefinition() {
        return this.timeDefinition;
    }

    public ZoneOffset getStandardOffset() {
        return this.standardOffset;
    }

    public ZoneOffset getOffsetBefore() {
        return this.offsetBefore;
    }

    public ZoneOffset getOffsetAfter() {
        return this.offsetAfter;
    }

    public ZoneOffsetTransition createTransition(int year) {
        LocalDate date;
        byte b4 = this.dom;
        if (b4 < 0) {
            Month month = this.month;
            date = LocalDate.of(year, month, month.length(IsoChronology.INSTANCE.isLeapYear(year)) + 1 + this.dom);
            DayOfWeek dayOfWeek = this.dow;
            if (dayOfWeek != null) {
                date = date.with(TemporalAdjusters.previousOrSame(dayOfWeek));
            }
        } else {
            date = LocalDate.of(year, this.month, b4);
            DayOfWeek dayOfWeek2 = this.dow;
            if (dayOfWeek2 != null) {
                date = date.with(TemporalAdjusters.nextOrSame(dayOfWeek2));
            }
        }
        if (this.timeEndOfDay) {
            date = date.plusDays(1L);
        }
        LocalDateTime localDT = LocalDateTime.of(date, this.time);
        LocalDateTime transition = this.timeDefinition.createDateTime(localDT, this.standardOffset, this.offsetBefore);
        return new ZoneOffsetTransition(transition, this.offsetBefore, this.offsetAfter);
    }

    public boolean equals(Object otherRule) {
        if (otherRule == this) {
            return true;
        }
        if (otherRule instanceof ZoneOffsetTransitionRule) {
            ZoneOffsetTransitionRule other = (ZoneOffsetTransitionRule) otherRule;
            if (this.month == other.month && this.dom == other.dom && this.dow == other.dow && this.timeDefinition == other.timeDefinition && this.timeEndOfDay == other.timeEndOfDay && this.time.equals(other.time) && this.standardOffset.equals(other.standardOffset) && this.offsetBefore.equals(other.offsetBefore) && this.offsetAfter.equals(other.offsetAfter)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int secondOfDay = ((this.time.toSecondOfDay() + (this.timeEndOfDay ? 1 : 0)) << 15) + (this.month.ordinal() << 11) + ((this.dom + 32) << 5);
        DayOfWeek dayOfWeek = this.dow;
        return ((this.standardOffset.hashCode() ^ ((secondOfDay + ((dayOfWeek == null ? 7 : dayOfWeek.ordinal()) << 2)) + this.timeDefinition.ordinal())) ^ this.offsetBefore.hashCode()) ^ this.offsetAfter.hashCode();
    }

    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append("TransitionRule[").append(this.offsetBefore.compareTo(this.offsetAfter) > 0 ? "Gap " : "Overlap ").append((Object) this.offsetBefore).append(" to ").append((Object) this.offsetAfter).append(", ");
        DayOfWeek dayOfWeek = this.dow;
        if (dayOfWeek != null) {
            byte b4 = this.dom;
            if (b4 == -1) {
                buf.append(dayOfWeek.name()).append(" on or before last day of ").append(this.month.name());
            } else if (b4 < 0) {
                buf.append(dayOfWeek.name()).append(" on or before last day minus ").append((-this.dom) - 1).append(" of ").append(this.month.name());
            } else {
                buf.append(dayOfWeek.name()).append(" on or after ").append(this.month.name()).append(' ').append((int) this.dom);
            }
        } else {
            buf.append(this.month.name()).append(' ').append((int) this.dom);
        }
        buf.append(" at ").append(this.timeEndOfDay ? "24:00" : this.time.toString()).append(" ").append((Object) this.timeDefinition).append(", standard offset ").append((Object) this.standardOffset).append(']');
        return buf.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.time.zone.ZoneOffsetTransitionRule$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$time$zone$ZoneOffsetTransitionRule$TimeDefinition;

        static {
            int[] iArr = new int[TimeDefinition.values().length];
            $SwitchMap$java$time$zone$ZoneOffsetTransitionRule$TimeDefinition = iArr;
            try {
                iArr[TimeDefinition.UTC.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$java$time$zone$ZoneOffsetTransitionRule$TimeDefinition[TimeDefinition.STANDARD.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public enum TimeDefinition {
        UTC,
        WALL,
        STANDARD;

        public LocalDateTime createDateTime(LocalDateTime dateTime, ZoneOffset standardOffset, ZoneOffset wallOffset) {
            switch (AnonymousClass1.$SwitchMap$java$time$zone$ZoneOffsetTransitionRule$TimeDefinition[ordinal()]) {
                case 1:
                    int difference = wallOffset.getTotalSeconds();
                    return dateTime.plusSeconds(difference - ZoneOffset.UTC.getTotalSeconds());
                case 2:
                    int difference2 = wallOffset.getTotalSeconds() - standardOffset.getTotalSeconds();
                    return dateTime.plusSeconds(difference2);
                default:
                    return dateTime;
            }
        }
    }
}
