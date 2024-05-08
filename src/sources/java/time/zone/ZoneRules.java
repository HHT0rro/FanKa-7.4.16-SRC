package java.time.zone;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.quickcard.base.Attributes;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class ZoneRules implements Serializable {
    private static final long DAYS_0000_TO_1970 = 719528;
    private static final int DAYS_PER_CYCLE = 146097;
    private static final int LAST_CACHED_YEAR = 2100;
    private static final long serialVersionUID = 3044319355680032515L;
    private final ZoneOffsetTransitionRule[] lastRules;
    private final transient ConcurrentMap<Integer, ZoneOffsetTransition[]> lastRulesCache = new ConcurrentHashMap();
    private final long[] savingsInstantTransitions;
    private final LocalDateTime[] savingsLocalTransitions;
    private final ZoneOffset[] standardOffsets;
    private final long[] standardTransitions;
    private final ZoneOffset[] wallOffsets;
    private static final long[] EMPTY_LONG_ARRAY = new long[0];
    private static final ZoneOffsetTransitionRule[] EMPTY_LASTRULES = new ZoneOffsetTransitionRule[0];
    private static final LocalDateTime[] EMPTY_LDT_ARRAY = new LocalDateTime[0];

    public static ZoneRules of(ZoneOffset baseStandardOffset, ZoneOffset baseWallOffset, List<ZoneOffsetTransition> standardOffsetTransitionList, List<ZoneOffsetTransition> transitionList, List<ZoneOffsetTransitionRule> lastRules) {
        Objects.requireNonNull(baseStandardOffset, "baseStandardOffset");
        Objects.requireNonNull(baseWallOffset, "baseWallOffset");
        Objects.requireNonNull(standardOffsetTransitionList, "standardOffsetTransitionList");
        Objects.requireNonNull(transitionList, "transitionList");
        Objects.requireNonNull(lastRules, "lastRules");
        return new ZoneRules(baseStandardOffset, baseWallOffset, standardOffsetTransitionList, transitionList, lastRules);
    }

    public static ZoneRules of(ZoneOffset offset) {
        Objects.requireNonNull(offset, Attributes.Style.OFFSET);
        return new ZoneRules(offset);
    }

    ZoneRules(ZoneOffset baseStandardOffset, ZoneOffset baseWallOffset, List<ZoneOffsetTransition> standardOffsetTransitionList, List<ZoneOffsetTransition> transitionList, List<ZoneOffsetTransitionRule> lastRules) {
        this.standardTransitions = new long[standardOffsetTransitionList.size()];
        ZoneOffset[] zoneOffsetArr = new ZoneOffset[standardOffsetTransitionList.size() + 1];
        this.standardOffsets = zoneOffsetArr;
        zoneOffsetArr[0] = baseStandardOffset;
        for (int i10 = 0; i10 < standardOffsetTransitionList.size(); i10++) {
            this.standardTransitions[i10] = standardOffsetTransitionList.get(i10).toEpochSecond();
            this.standardOffsets[i10 + 1] = standardOffsetTransitionList.get(i10).getOffsetAfter();
        }
        List<LocalDateTime> localTransitionList = new ArrayList<>();
        List<ZoneOffset> localTransitionOffsetList = new ArrayList<>();
        localTransitionOffsetList.add(baseWallOffset);
        for (ZoneOffsetTransition trans : transitionList) {
            if (trans.isGap()) {
                localTransitionList.add(trans.getDateTimeBefore());
                localTransitionList.add(trans.getDateTimeAfter());
            } else {
                localTransitionList.add(trans.getDateTimeAfter());
                localTransitionList.add(trans.getDateTimeBefore());
            }
            localTransitionOffsetList.add(trans.getOffsetAfter());
        }
        this.savingsLocalTransitions = (LocalDateTime[]) localTransitionList.toArray(new LocalDateTime[localTransitionList.size()]);
        this.wallOffsets = (ZoneOffset[]) localTransitionOffsetList.toArray(new ZoneOffset[localTransitionOffsetList.size()]);
        this.savingsInstantTransitions = new long[transitionList.size()];
        for (int i11 = 0; i11 < transitionList.size(); i11++) {
            this.savingsInstantTransitions[i11] = transitionList.get(i11).toEpochSecond();
        }
        Object[] temp = lastRules.toArray();
        ZoneOffsetTransitionRule[] rulesArray = (ZoneOffsetTransitionRule[]) Arrays.copyOf(temp, temp.length, ZoneOffsetTransitionRule[].class);
        if (rulesArray.length > 16) {
            throw new IllegalArgumentException("Too many transition rules");
        }
        this.lastRules = rulesArray;
    }

    private ZoneRules(long[] standardTransitions, ZoneOffset[] standardOffsets, long[] savingsInstantTransitions, ZoneOffset[] wallOffsets, ZoneOffsetTransitionRule[] lastRules) {
        this.standardTransitions = standardTransitions;
        this.standardOffsets = standardOffsets;
        this.savingsInstantTransitions = savingsInstantTransitions;
        this.wallOffsets = wallOffsets;
        this.lastRules = lastRules;
        if (savingsInstantTransitions.length == 0) {
            this.savingsLocalTransitions = EMPTY_LDT_ARRAY;
            return;
        }
        List<LocalDateTime> localTransitionList = new ArrayList<>();
        for (int i10 = 0; i10 < savingsInstantTransitions.length; i10++) {
            ZoneOffset before = wallOffsets[i10];
            ZoneOffset after = wallOffsets[i10 + 1];
            ZoneOffsetTransition trans = new ZoneOffsetTransition(savingsInstantTransitions[i10], before, after);
            if (trans.isGap()) {
                localTransitionList.add(trans.getDateTimeBefore());
                localTransitionList.add(trans.getDateTimeAfter());
            } else {
                localTransitionList.add(trans.getDateTimeAfter());
                localTransitionList.add(trans.getDateTimeBefore());
            }
        }
        int i11 = localTransitionList.size();
        this.savingsLocalTransitions = (LocalDateTime[]) localTransitionList.toArray(new LocalDateTime[i11]);
    }

    private ZoneRules(ZoneOffset offset) {
        this.standardOffsets = r0;
        ZoneOffset[] zoneOffsetArr = {offset};
        long[] jArr = EMPTY_LONG_ARRAY;
        this.standardTransitions = jArr;
        this.savingsInstantTransitions = jArr;
        this.savingsLocalTransitions = EMPTY_LDT_ARRAY;
        this.wallOffsets = zoneOffsetArr;
        this.lastRules = EMPTY_LASTRULES;
    }

    private void readObject(ObjectInputStream s2) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 1, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(DataOutput out) throws IOException {
        out.writeInt(this.standardTransitions.length);
        for (long trans : this.standardTransitions) {
            Ser.writeEpochSec(trans, out);
        }
        for (ZoneOffset offset : this.standardOffsets) {
            Ser.writeOffset(offset, out);
        }
        out.writeInt(this.savingsInstantTransitions.length);
        for (long trans2 : this.savingsInstantTransitions) {
            Ser.writeEpochSec(trans2, out);
        }
        for (ZoneOffset offset2 : this.wallOffsets) {
            Ser.writeOffset(offset2, out);
        }
        out.writeByte(this.lastRules.length);
        for (ZoneOffsetTransitionRule rule : this.lastRules) {
            rule.writeExternal(out);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ZoneRules readExternal(DataInput in) throws IOException, ClassNotFoundException {
        int stdSize = in.readInt();
        if (stdSize > 1024) {
            throw new InvalidObjectException("Too many transitions");
        }
        long[] stdTrans = stdSize == 0 ? EMPTY_LONG_ARRAY : new long[stdSize];
        for (int i10 = 0; i10 < stdSize; i10++) {
            stdTrans[i10] = Ser.readEpochSec(in);
        }
        int i11 = stdSize + 1;
        ZoneOffset[] stdOffsets = new ZoneOffset[i11];
        for (int i12 = 0; i12 < stdOffsets.length; i12++) {
            stdOffsets[i12] = Ser.readOffset(in);
        }
        int savSize = in.readInt();
        if (savSize > 1024) {
            throw new InvalidObjectException("Too many saving offsets");
        }
        long[] savTrans = savSize == 0 ? EMPTY_LONG_ARRAY : new long[savSize];
        for (int i13 = 0; i13 < savSize; i13++) {
            savTrans[i13] = Ser.readEpochSec(in);
        }
        int i14 = savSize + 1;
        ZoneOffset[] savOffsets = new ZoneOffset[i14];
        for (int i15 = 0; i15 < savOffsets.length; i15++) {
            savOffsets[i15] = Ser.readOffset(in);
        }
        int ruleSize = in.readByte();
        if (ruleSize > 16) {
            throw new InvalidObjectException("Too many transition rules");
        }
        ZoneOffsetTransitionRule[] rules = ruleSize == 0 ? EMPTY_LASTRULES : new ZoneOffsetTransitionRule[ruleSize];
        for (int i16 = 0; i16 < ruleSize; i16++) {
            rules[i16] = ZoneOffsetTransitionRule.readExternal(in);
        }
        return new ZoneRules(stdTrans, stdOffsets, savTrans, savOffsets, rules);
    }

    public boolean isFixedOffset() {
        return this.standardOffsets[0].equals(this.wallOffsets[0]) && this.standardTransitions.length == 0 && this.savingsInstantTransitions.length == 0 && this.lastRules.length == 0;
    }

    public ZoneOffset getOffset(Instant instant) {
        if (this.savingsInstantTransitions.length == 0) {
            return this.wallOffsets[0];
        }
        long epochSec = instant.getEpochSecond();
        if (this.lastRules.length > 0) {
            if (epochSec > this.savingsInstantTransitions[r2.length - 1]) {
                int year = findYear(epochSec, this.wallOffsets[r2.length - 1]);
                ZoneOffsetTransition[] transArray = findTransitionArray(year);
                ZoneOffsetTransition trans = null;
                for (int i10 = 0; i10 < transArray.length; i10++) {
                    trans = transArray[i10];
                    if (epochSec < trans.toEpochSecond()) {
                        return trans.getOffsetBefore();
                    }
                }
                return trans.getOffsetAfter();
            }
        }
        int index = Arrays.binarySearch(this.savingsInstantTransitions, epochSec);
        if (index < 0) {
            index = (-index) - 2;
        }
        return this.wallOffsets[index + 1];
    }

    public ZoneOffset getOffset(LocalDateTime localDateTime) {
        Object info = getOffsetInfo(localDateTime);
        if (info instanceof ZoneOffsetTransition) {
            return ((ZoneOffsetTransition) info).getOffsetBefore();
        }
        return (ZoneOffset) info;
    }

    public List<ZoneOffset> getValidOffsets(LocalDateTime localDateTime) {
        Object info = getOffsetInfo(localDateTime);
        if (info instanceof ZoneOffsetTransition) {
            return ((ZoneOffsetTransition) info).getValidOffsets();
        }
        return Collections.singletonList((ZoneOffset) info);
    }

    public ZoneOffsetTransition getTransition(LocalDateTime localDateTime) {
        Object info = getOffsetInfo(localDateTime);
        if (info instanceof ZoneOffsetTransition) {
            return (ZoneOffsetTransition) info;
        }
        return null;
    }

    private Object getOffsetInfo(LocalDateTime dt) {
        LocalDateTime[] localDateTimeArr = this.savingsLocalTransitions;
        if (localDateTimeArr.length == 0) {
            return this.wallOffsets[0];
        }
        if (this.lastRules.length > 0 && dt.isAfter(localDateTimeArr[localDateTimeArr.length - 1])) {
            ZoneOffsetTransition[] transArray = findTransitionArray(dt.getYear());
            Object info = null;
            for (ZoneOffsetTransition trans : transArray) {
                info = findOffsetInfo(dt, trans);
                if ((info instanceof ZoneOffsetTransition) || info.equals(trans.getOffsetBefore())) {
                    return info;
                }
            }
            return info;
        }
        int index = Arrays.binarySearch(this.savingsLocalTransitions, dt);
        if (index == -1) {
            return this.wallOffsets[0];
        }
        if (index < 0) {
            index = (-index) - 2;
        } else {
            Object[] objArr = this.savingsLocalTransitions;
            if (index < objArr.length - 1 && objArr[index].equals(objArr[index + 1])) {
                index++;
            }
        }
        if ((index & 1) == 0) {
            LocalDateTime[] localDateTimeArr2 = this.savingsLocalTransitions;
            LocalDateTime dtBefore = localDateTimeArr2[index];
            LocalDateTime dtAfter = localDateTimeArr2[index + 1];
            ZoneOffset[] zoneOffsetArr = this.wallOffsets;
            ZoneOffset offsetBefore = zoneOffsetArr[index / 2];
            ZoneOffset offsetAfter = zoneOffsetArr[(index / 2) + 1];
            if (offsetAfter.getTotalSeconds() > offsetBefore.getTotalSeconds()) {
                return new ZoneOffsetTransition(dtBefore, offsetBefore, offsetAfter);
            }
            return new ZoneOffsetTransition(dtAfter, offsetBefore, offsetAfter);
        }
        return this.wallOffsets[(index / 2) + 1];
    }

    private Object findOffsetInfo(LocalDateTime dt, ZoneOffsetTransition trans) {
        LocalDateTime localTransition = trans.getDateTimeBefore();
        if (trans.isGap()) {
            if (dt.isBefore(localTransition)) {
                return trans.getOffsetBefore();
            }
            if (dt.isBefore(trans.getDateTimeAfter())) {
                return trans;
            }
            return trans.getOffsetAfter();
        }
        if (!dt.isBefore(localTransition)) {
            return trans.getOffsetAfter();
        }
        if (dt.isBefore(trans.getDateTimeAfter())) {
            return trans.getOffsetBefore();
        }
        return trans;
    }

    private ZoneOffsetTransition[] findTransitionArray(int year) {
        Integer yearObj = Integer.valueOf(year);
        ZoneOffsetTransition[] transArray = this.lastRulesCache.get(yearObj);
        if (transArray != null) {
            return transArray;
        }
        ZoneOffsetTransitionRule[] ruleArray = this.lastRules;
        ZoneOffsetTransition[] transArray2 = new ZoneOffsetTransition[ruleArray.length];
        for (int i10 = 0; i10 < ruleArray.length; i10++) {
            transArray2[i10] = ruleArray[i10].createTransition(year);
        }
        if (year < 2100) {
            this.lastRulesCache.putIfAbsent(yearObj, transArray2);
        }
        return transArray2;
    }

    public ZoneOffset getStandardOffset(Instant instant) {
        if (this.standardTransitions.length == 0) {
            return this.standardOffsets[0];
        }
        long epochSec = instant.getEpochSecond();
        int index = Arrays.binarySearch(this.standardTransitions, epochSec);
        if (index < 0) {
            index = (-index) - 2;
        }
        return this.standardOffsets[index + 1];
    }

    public Duration getDaylightSavings(Instant instant) {
        if (isFixedOffset()) {
            return Duration.ZERO;
        }
        ZoneOffset standardOffset = getStandardOffset(instant);
        ZoneOffset actualOffset = getOffset(instant);
        return Duration.ofSeconds(actualOffset.getTotalSeconds() - standardOffset.getTotalSeconds());
    }

    public boolean isDaylightSavings(Instant instant) {
        return !getStandardOffset(instant).equals(getOffset(instant));
    }

    public boolean isValidOffset(LocalDateTime localDateTime, ZoneOffset offset) {
        return getValidOffsets(localDateTime).contains(offset);
    }

    public ZoneOffsetTransition nextTransition(Instant instant) {
        if (this.savingsInstantTransitions.length == 0) {
            return null;
        }
        long epochSec = instant.getEpochSecond();
        long[] jArr = this.savingsInstantTransitions;
        if (epochSec >= jArr[jArr.length - 1]) {
            if (this.lastRules.length == 0) {
                return null;
            }
            int year = findYear(epochSec, this.wallOffsets[r0.length - 1]);
            ZoneOffsetTransition[] transArray = findTransitionArray(year);
            for (ZoneOffsetTransition trans : transArray) {
                if (epochSec < trans.toEpochSecond()) {
                    return trans;
                }
            }
            if (year < 999999999) {
                return findTransitionArray(year + 1)[0];
            }
            return null;
        }
        int index = Arrays.binarySearch(jArr, epochSec);
        int index2 = index < 0 ? (-index) - 1 : index + 1;
        long j10 = this.savingsInstantTransitions[index2];
        ZoneOffset[] zoneOffsetArr = this.wallOffsets;
        return new ZoneOffsetTransition(j10, zoneOffsetArr[index2], zoneOffsetArr[index2 + 1]);
    }

    public ZoneOffsetTransition previousTransition(Instant instant) {
        if (this.savingsInstantTransitions.length == 0) {
            return null;
        }
        long epochSec = instant.getEpochSecond();
        if (instant.getNano() > 0 && epochSec < Long.MAX_VALUE) {
            epochSec++;
        }
        long lastHistoric = this.savingsInstantTransitions[r0.length - 1];
        if (this.lastRules.length > 0 && epochSec > lastHistoric) {
            ZoneOffset lastHistoricOffset = this.wallOffsets[r0.length - 1];
            int year = findYear(epochSec, lastHistoricOffset);
            ZoneOffsetTransition[] transArray = findTransitionArray(year);
            for (int i10 = transArray.length - 1; i10 >= 0; i10--) {
                if (epochSec > transArray[i10].toEpochSecond()) {
                    return transArray[i10];
                }
            }
            int lastHistoricYear = findYear(lastHistoric, lastHistoricOffset);
            int year2 = year - 1;
            if (year2 > lastHistoricYear) {
                return findTransitionArray(year2)[r1.length - 1];
            }
        }
        int index = Arrays.binarySearch(this.savingsInstantTransitions, epochSec);
        if (index < 0) {
            index = (-index) - 1;
        }
        if (index <= 0) {
            return null;
        }
        long j10 = this.savingsInstantTransitions[index - 1];
        ZoneOffset[] zoneOffsetArr = this.wallOffsets;
        return new ZoneOffsetTransition(j10, zoneOffsetArr[index - 1], zoneOffsetArr[index]);
    }

    private int findYear(long epochSecond, ZoneOffset offset) {
        long localSecond = epochSecond + offset.getTotalSeconds();
        long zeroDay = (Math.floorDiv(localSecond, RemoteMessageConst.DEFAULT_TTL) + DAYS_0000_TO_1970) - 60;
        long adjust = 0;
        if (zeroDay < 0) {
            long adjustCycles = ((zeroDay + 1) / 146097) - 1;
            adjust = adjustCycles * 400;
            zeroDay += (-adjustCycles) * 146097;
        }
        long yearEst = ((zeroDay * 400) + 591) / 146097;
        long doyEst = zeroDay - ((((yearEst * 365) + (yearEst / 4)) - (yearEst / 100)) + (yearEst / 400));
        if (doyEst < 0) {
            yearEst--;
            doyEst = zeroDay - ((((365 * yearEst) + (yearEst / 4)) - (yearEst / 100)) + (yearEst / 400));
        }
        int marchDoy0 = (int) doyEst;
        int marchMonth0 = ((marchDoy0 * 5) + 2) / 153;
        return (int) Math.min(yearEst + adjust + (marchMonth0 / 10), 999999999L);
    }

    public List<ZoneOffsetTransition> getTransitions() {
        List<ZoneOffsetTransition> list = new ArrayList<>();
        for (int i10 = 0; i10 < this.savingsInstantTransitions.length; i10++) {
            long j10 = this.savingsInstantTransitions[i10];
            ZoneOffset[] zoneOffsetArr = this.wallOffsets;
            list.add(new ZoneOffsetTransition(j10, zoneOffsetArr[i10], zoneOffsetArr[i10 + 1]));
        }
        return Collections.unmodifiableList(list);
    }

    public List<ZoneOffsetTransitionRule> getTransitionRules() {
        return List.of((Object[]) this.lastRules);
    }

    public boolean equals(Object otherRules) {
        if (this == otherRules) {
            return true;
        }
        if (otherRules instanceof ZoneRules) {
            ZoneRules other = (ZoneRules) otherRules;
            if (Arrays.equals(this.standardTransitions, other.standardTransitions) && Arrays.equals(this.standardOffsets, other.standardOffsets) && Arrays.equals(this.savingsInstantTransitions, other.savingsInstantTransitions) && Arrays.equals(this.wallOffsets, other.wallOffsets) && Arrays.equals(this.lastRules, other.lastRules)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((Arrays.hashCode(this.standardTransitions) ^ Arrays.hashCode(this.standardOffsets)) ^ Arrays.hashCode(this.savingsInstantTransitions)) ^ Arrays.hashCode(this.wallOffsets)) ^ Arrays.hashCode(this.lastRules);
    }

    public String toString() {
        return new StringBuilder().append("ZoneRules[currentStandardOffset=").append((Object) this.standardOffsets[r1.length - 1]).append("]").toString();
    }
}
