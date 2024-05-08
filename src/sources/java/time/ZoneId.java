package java.time;

import com.alibaba.security.realidentity.build.cg;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.datepicker.UtcDates;
import com.huawei.quickcard.base.Attributes;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalQuery;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.time.zone.ZoneRules;
import java.time.zone.ZoneRulesException;
import java.time.zone.ZoneRulesProvider;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import org.apache.commons.lang3.time.TimeZones;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class ZoneId implements Serializable {
    public static final Map<String, String> SHORT_IDS = Map.ofEntries(Map.entry("ACT", "Australia/Darwin"), Map.entry("AET", "Australia/Sydney"), Map.entry("AGT", "America/Argentina/Buenos_Aires"), Map.entry("ART", "Africa/Cairo"), Map.entry("AST", "America/Anchorage"), Map.entry("BET", "America/Sao_Paulo"), Map.entry("BST", "Asia/Dhaka"), Map.entry("CAT", "Africa/Harare"), Map.entry("CNT", "America/St_Johns"), Map.entry("CST", "America/Chicago"), Map.entry("CTT", "Asia/Shanghai"), Map.entry("EAT", "Africa/Addis_Ababa"), Map.entry("ECT", "Europe/Paris"), Map.entry("IET", "America/Indiana/Indianapolis"), Map.entry("IST", "Asia/Kolkata"), Map.entry("JST", "Asia/Tokyo"), Map.entry("MIT", "Pacific/Apia"), Map.entry("NET", "Asia/Yerevan"), Map.entry("NST", "Pacific/Auckland"), Map.entry("PLT", "Asia/Karachi"), Map.entry("PNT", "America/Phoenix"), Map.entry("PRT", "America/Puerto_Rico"), Map.entry("PST", "America/Los_Angeles"), Map.entry("SST", "Pacific/Guadalcanal"), Map.entry("VST", "Asia/Ho_Chi_Minh"), Map.entry("EST", "-05:00"), Map.entry("MST", "-07:00"), Map.entry("HST", "-10:00"));
    private static final long serialVersionUID = 8352817235686L;

    public abstract String getId();

    public abstract ZoneRules getRules();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void write(DataOutput dataOutput) throws IOException;

    public static ZoneId systemDefault() {
        return TimeZone.getDefault().toZoneId();
    }

    public static Set<String> getAvailableZoneIds() {
        return new HashSet(ZoneRulesProvider.getAvailableZoneIds());
    }

    public static ZoneId of(String zoneId, Map<String, String> aliasMap) {
        Objects.requireNonNull(zoneId, "zoneId");
        Objects.requireNonNull(aliasMap, "aliasMap");
        String id2 = (String) Objects.requireNonNullElse(aliasMap.get(zoneId), zoneId);
        return of(id2);
    }

    public static ZoneId of(String zoneId) {
        return of(zoneId, true);
    }

    public static ZoneId ofOffset(String prefix, ZoneOffset offset) {
        Objects.requireNonNull(prefix, cg.f3323m);
        Objects.requireNonNull(offset, Attributes.Style.OFFSET);
        if (prefix.isEmpty()) {
            return offset;
        }
        if (!prefix.equals(TimeZones.GMT_ID) && !prefix.equals(UtcDates.UTC) && !prefix.equals("UT")) {
            throw new IllegalArgumentException("prefix should be GMT, UTC or UT, is: " + prefix);
        }
        if (offset.getTotalSeconds() != 0) {
            prefix = prefix.concat(offset.getId());
        }
        return new ZoneRegion(prefix, offset.getRules());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ZoneId of(String zoneId, boolean checkAvailable) {
        Objects.requireNonNull(zoneId, "zoneId");
        if (zoneId.length() <= 1 || zoneId.startsWith(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX) || zoneId.startsWith("-")) {
            return ZoneOffset.of(zoneId);
        }
        if (zoneId.startsWith(UtcDates.UTC) || zoneId.startsWith(TimeZones.GMT_ID)) {
            return ofWithPrefix(zoneId, 3, checkAvailable);
        }
        if (zoneId.startsWith("UT")) {
            return ofWithPrefix(zoneId, 2, checkAvailable);
        }
        return ZoneRegion.ofId(zoneId, checkAvailable);
    }

    private static ZoneId ofWithPrefix(String zoneId, int prefixLength, boolean checkAvailable) {
        String prefix = zoneId.substring(0, prefixLength);
        if (zoneId.length() == prefixLength) {
            return ofOffset(prefix, ZoneOffset.UTC);
        }
        if (zoneId.charAt(prefixLength) != '+' && zoneId.charAt(prefixLength) != '-') {
            return ZoneRegion.ofId(zoneId, checkAvailable);
        }
        try {
            ZoneOffset offset = ZoneOffset.of(zoneId.substring(prefixLength));
            if (offset == ZoneOffset.UTC) {
                return ofOffset(prefix, offset);
            }
            return ofOffset(prefix, offset);
        } catch (DateTimeException ex) {
            throw new DateTimeException("Invalid ID for offset-based ZoneId: " + zoneId, ex);
        }
    }

    public static ZoneId from(TemporalAccessor temporal) {
        ZoneId obj = (ZoneId) temporal.query(TemporalQueries.zone());
        if (obj == null) {
            throw new DateTimeException("Unable to obtain ZoneId from TemporalAccessor: " + ((Object) temporal) + " of type " + temporal.getClass().getName());
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZoneId() {
        if (getClass() != ZoneOffset.class && getClass() != ZoneRegion.class) {
            throw new AssertionError((Object) "Invalid subclass");
        }
    }

    public String getDisplayName(TextStyle style, Locale locale) {
        return new DateTimeFormatterBuilder().appendZoneText(style).toFormatter(locale).format(toTemporal());
    }

    private TemporalAccessor toTemporal() {
        return new TemporalAccessor() { // from class: java.time.ZoneId.1
            @Override // java.time.temporal.TemporalAccessor
            public boolean isSupported(TemporalField field) {
                return false;
            }

            @Override // java.time.temporal.TemporalAccessor
            public long getLong(TemporalField field) {
                throw new UnsupportedTemporalTypeException("Unsupported field: " + ((Object) field));
            }

            @Override // java.time.temporal.TemporalAccessor
            public <R> R query(TemporalQuery<R> temporalQuery) {
                if (temporalQuery == TemporalQueries.zoneId()) {
                    return (R) ZoneId.this;
                }
                return (R) super.query(temporalQuery);
            }
        };
    }

    public ZoneId normalized() {
        try {
            ZoneRules rules = getRules();
            if (rules.isFixedOffset()) {
                return rules.getOffset(Instant.EPOCH);
            }
        } catch (ZoneRulesException e2) {
        }
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ZoneId) {
            ZoneId other = (ZoneId) obj;
            if (getId().equals(other.getId())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return getId().hashCode();
    }

    private void readObject(ObjectInputStream s2) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public String toString() {
        return getId();
    }

    private Object writeReplace() {
        return new Ser((byte) 7, this);
    }
}
