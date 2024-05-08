package java.time;

import com.google.android.material.badge.BadgeDrawable;
import com.huawei.openalliance.ad.constant.u;
import com.kwad.sdk.core.response.model.SdkConfigData;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalQuery;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.time.temporal.ValueRange;
import java.time.zone.ZoneRules;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class ZoneOffset extends ZoneId implements TemporalAccessor, TemporalAdjuster, Comparable<ZoneOffset>, Serializable {
    private static final long serialVersionUID = 2357656521762053153L;

    /* renamed from: id, reason: collision with root package name */
    private final transient String f50419id;
    private final int totalSeconds;
    private static final ConcurrentMap<Integer, ZoneOffset> SECONDS_CACHE = new ConcurrentHashMap(16, 0.75f, 4);
    private static final ConcurrentMap<String, ZoneOffset> ID_CACHE = new ConcurrentHashMap(16, 0.75f, 4);
    public static final ZoneOffset UTC = ofTotalSeconds(0);
    public static final ZoneOffset MIN = ofTotalSeconds(-64800);
    private static final int MAX_SECONDS = 64800;
    public static final ZoneOffset MAX = ofTotalSeconds(MAX_SECONDS);

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0018. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0094 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.time.ZoneOffset of(java.lang.String r8) {
        /*
            java.lang.String r0 = "offsetId"
            java.util.Objects.requireNonNull(r8, r0)
            java.util.concurrent.ConcurrentMap<java.lang.String, java.time.ZoneOffset> r0 = java.time.ZoneOffset.ID_CACHE
            java.lang.Object r0 = r0.get(r8)
            java.time.ZoneOffset r0 = (java.time.ZoneOffset) r0
            if (r0 == 0) goto L10
            return r0
        L10:
            int r1 = r8.length()
            r2 = 4
            r3 = 3
            r4 = 1
            r5 = 0
            switch(r1) {
                case 2: goto L64;
                case 3: goto L83;
                case 4: goto L1b;
                case 5: goto L5a;
                case 6: goto L50;
                case 7: goto L42;
                case 8: goto L1b;
                case 9: goto L34;
                default: goto L1b;
            }
        L1b:
            java.time.DateTimeException r1 = new java.time.DateTimeException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Invalid ID for ZoneOffset, invalid format: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L34:
            int r1 = parseNumber(r8, r4, r5)
            int r2 = parseNumber(r8, r2, r4)
            r3 = 7
            int r3 = parseNumber(r8, r3, r4)
            goto L8a
        L42:
            int r1 = parseNumber(r8, r4, r5)
            int r2 = parseNumber(r8, r3, r5)
            r3 = 5
            int r3 = parseNumber(r8, r3, r5)
            goto L8a
        L50:
            int r1 = parseNumber(r8, r4, r5)
            int r2 = parseNumber(r8, r2, r4)
            r3 = 0
            goto L8a
        L5a:
            int r1 = parseNumber(r8, r4, r5)
            int r2 = parseNumber(r8, r3, r5)
            r3 = 0
            goto L8a
        L64:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            char r2 = r8.charAt(r5)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = "0"
            java.lang.StringBuilder r1 = r1.append(r2)
            char r2 = r8.charAt(r4)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r8 = r1.toString()
        L83:
            int r1 = parseNumber(r8, r4, r5)
            r2 = 0
            r3 = 0
        L8a:
            char r4 = r8.charAt(r5)
            r5 = 43
            r6 = 45
            if (r4 == r5) goto Lb0
            if (r4 != r6) goto L97
            goto Lb0
        L97:
            java.time.DateTimeException r5 = new java.time.DateTimeException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Invalid ID for ZoneOffset, plus/minus not found when expected: "
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.StringBuilder r6 = r6.append(r8)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        Lb0:
            if (r4 != r6) goto Lba
            int r5 = -r1
            int r6 = -r2
            int r7 = -r3
            java.time.ZoneOffset r5 = ofHoursMinutesSeconds(r5, r6, r7)
            return r5
        Lba:
            java.time.ZoneOffset r5 = ofHoursMinutesSeconds(r1, r2, r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: java.time.ZoneOffset.of(java.lang.String):java.time.ZoneOffset");
    }

    private static int parseNumber(CharSequence offsetId, int pos, boolean precededByColon) {
        if (precededByColon && offsetId.charAt(pos - 1) != ':') {
            throw new DateTimeException("Invalid ID for ZoneOffset, colon not found when expected: " + ((Object) offsetId));
        }
        char ch1 = offsetId.charAt(pos);
        char ch2 = offsetId.charAt(pos + 1);
        if (ch1 < '0' || ch1 > '9' || ch2 < '0' || ch2 > '9') {
            throw new DateTimeException("Invalid ID for ZoneOffset, non numeric characters found: " + ((Object) offsetId));
        }
        return ((ch1 - '0') * 10) + (ch2 - '0');
    }

    public static ZoneOffset ofHours(int hours) {
        return ofHoursMinutesSeconds(hours, 0, 0);
    }

    public static ZoneOffset ofHoursMinutes(int hours, int minutes) {
        return ofHoursMinutesSeconds(hours, minutes, 0);
    }

    public static ZoneOffset ofHoursMinutesSeconds(int hours, int minutes, int seconds) {
        validate(hours, minutes, seconds);
        int totalSeconds = totalSeconds(hours, minutes, seconds);
        return ofTotalSeconds(totalSeconds);
    }

    public static ZoneOffset from(TemporalAccessor temporal) {
        Objects.requireNonNull(temporal, "temporal");
        ZoneOffset offset = (ZoneOffset) temporal.query(TemporalQueries.offset());
        if (offset == null) {
            throw new DateTimeException("Unable to obtain ZoneOffset from TemporalAccessor: " + ((Object) temporal) + " of type " + temporal.getClass().getName());
        }
        return offset;
    }

    private static void validate(int hours, int minutes, int seconds) {
        if (hours < -18 || hours > 18) {
            throw new DateTimeException("Zone offset hours not in valid range: value " + hours + " is not in the range -18 to 18");
        }
        if (hours > 0) {
            if (minutes < 0 || seconds < 0) {
                throw new DateTimeException("Zone offset minutes and seconds must be positive because hours is positive");
            }
        } else if (hours < 0) {
            if (minutes > 0 || seconds > 0) {
                throw new DateTimeException("Zone offset minutes and seconds must be negative because hours is negative");
            }
        } else if ((minutes > 0 && seconds < 0) || (minutes < 0 && seconds > 0)) {
            throw new DateTimeException("Zone offset minutes and seconds must have the same sign");
        }
        if (minutes < -59 || minutes > 59) {
            throw new DateTimeException("Zone offset minutes not in valid range: value " + minutes + " is not in the range -59 to 59");
        }
        if (seconds < -59 || seconds > 59) {
            throw new DateTimeException("Zone offset seconds not in valid range: value " + seconds + " is not in the range -59 to 59");
        }
        if (Math.abs(hours) == 18 && (minutes | seconds) != 0) {
            throw new DateTimeException("Zone offset not in valid range: -18:00 to +18:00");
        }
    }

    private static int totalSeconds(int hours, int minutes, int seconds) {
        return (hours * SdkConfigData.DEFAULT_REQUEST_INTERVAL) + (minutes * 60) + seconds;
    }

    public static ZoneOffset ofTotalSeconds(int totalSeconds) {
        if (totalSeconds < -64800 || totalSeconds > MAX_SECONDS) {
            throw new DateTimeException("Zone offset not in valid range: -18:00 to +18:00");
        }
        if (totalSeconds % 900 == 0) {
            Integer totalSecs = Integer.valueOf(totalSeconds);
            ConcurrentMap<Integer, ZoneOffset> concurrentMap = SECONDS_CACHE;
            ZoneOffset result = concurrentMap.get(totalSecs);
            if (result == null) {
                concurrentMap.putIfAbsent(totalSecs, new ZoneOffset(totalSeconds));
                ZoneOffset result2 = concurrentMap.get(totalSecs);
                ID_CACHE.putIfAbsent(result2.getId(), result2);
                return result2;
            }
            return result;
        }
        return new ZoneOffset(totalSeconds);
    }

    private ZoneOffset(int totalSeconds) {
        this.totalSeconds = totalSeconds;
        this.f50419id = buildId(totalSeconds);
    }

    private static String buildId(int totalSeconds) {
        if (totalSeconds == 0) {
            return "Z";
        }
        int absTotalSeconds = Math.abs(totalSeconds);
        StringBuilder buf = new StringBuilder();
        int absHours = absTotalSeconds / SdkConfigData.DEFAULT_REQUEST_INTERVAL;
        int absMinutes = (absTotalSeconds / 60) % 60;
        buf.append(totalSeconds < 0 ? "-" : BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX).append(absHours < 10 ? "0" : "").append(absHours).append(absMinutes < 10 ? ":0" : u.bD).append(absMinutes);
        int absSeconds = absTotalSeconds % 60;
        if (absSeconds != 0) {
            buf.append(absSeconds >= 10 ? u.bD : ":0").append(absSeconds);
        }
        return buf.toString();
    }

    public int getTotalSeconds() {
        return this.totalSeconds;
    }

    @Override // java.time.ZoneId
    public String getId() {
        return this.f50419id;
    }

    @Override // java.time.ZoneId
    public ZoneRules getRules() {
        return ZoneRules.of(this);
    }

    @Override // java.time.temporal.TemporalAccessor
    public boolean isSupported(TemporalField field) {
        return field instanceof ChronoField ? field == ChronoField.OFFSET_SECONDS : field != null && field.isSupportedBy(this);
    }

    @Override // java.time.temporal.TemporalAccessor
    public ValueRange range(TemporalField field) {
        return super.range(field);
    }

    @Override // java.time.temporal.TemporalAccessor
    public int get(TemporalField field) {
        if (field == ChronoField.OFFSET_SECONDS) {
            return this.totalSeconds;
        }
        if (field instanceof ChronoField) {
            throw new UnsupportedTemporalTypeException("Unsupported field: " + ((Object) field));
        }
        return range(field).checkValidIntValue(getLong(field), field);
    }

    @Override // java.time.temporal.TemporalAccessor
    public long getLong(TemporalField field) {
        if (field == ChronoField.OFFSET_SECONDS) {
            return this.totalSeconds;
        }
        if (field instanceof ChronoField) {
            throw new UnsupportedTemporalTypeException("Unsupported field: " + ((Object) field));
        }
        return field.getFrom(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.time.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.offset() || temporalQuery == TemporalQueries.zone()) {
            return this;
        }
        return (R) super.query(temporalQuery);
    }

    @Override // java.time.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.OFFSET_SECONDS, this.totalSeconds);
    }

    @Override // java.lang.Comparable
    public int compareTo(ZoneOffset other) {
        return other.totalSeconds - this.totalSeconds;
    }

    @Override // java.time.ZoneId
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ZoneOffset) && this.totalSeconds == ((ZoneOffset) obj).totalSeconds;
    }

    @Override // java.time.ZoneId
    public int hashCode() {
        return this.totalSeconds;
    }

    @Override // java.time.ZoneId
    public String toString() {
        return this.f50419id;
    }

    private Object writeReplace() {
        return new Ser((byte) 8, this);
    }

    private void readObject(ObjectInputStream s2) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.time.ZoneId
    public void write(DataOutput out) throws IOException {
        out.writeByte(8);
        writeExternal(out);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(DataOutput out) throws IOException {
        int offsetSecs = this.totalSeconds;
        int offsetByte = offsetSecs % 900 == 0 ? offsetSecs / 900 : 127;
        out.writeByte(offsetByte);
        if (offsetByte == 127) {
            out.writeInt(offsetSecs);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ZoneOffset readExternal(DataInput in) throws IOException {
        int offsetByte = in.readByte();
        return ofTotalSeconds(offsetByte == 127 ? in.readInt() : offsetByte * 900);
    }
}
