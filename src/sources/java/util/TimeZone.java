package java.util;

import android.icu.text.TimeZoneNames;
import com.android.i18n.timezone.ZoneInfoData;
import com.android.i18n.timezone.ZoneInfoDb;
import com.android.icu.util.ExtendedTimeZone;
import com.android.internal.accessibility.common.ShortcutConstants;
import com.google.android.material.datepicker.UtcDates;
import dalvik.system.RuntimeHooks;
import java.io.IOException;
import java.io.Serializable;
import java.time.ZoneId;
import java.util.Locale;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import libcore.io.IoUtils;
import libcore.util.ZoneInfo;
import org.apache.commons.lang3.time.TimeZones;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class TimeZone implements Serializable, Cloneable {
    public static final int LONG = 1;
    public static final int SHORT = 0;
    private static volatile TimeZone defaultTimeZone = null;
    static final long serialVersionUID = 3581463369166924961L;
    private String ID;
    private static final TimeZone GMT = new SimpleTimeZone(0, TimeZones.GMT_ID);
    private static final TimeZone UTC = new SimpleTimeZone(0, UtcDates.UTC);
    static final TimeZone NO_TIMEZONE = null;

    private static native String getSystemGMTOffsetID();

    private static native String getSystemTimeZoneID(String str, String str2);

    public abstract int getOffset(int i10, int i11, int i12, int i13, int i14, int i15);

    public abstract int getRawOffset();

    public abstract boolean inDaylightTime(Date date);

    public abstract void setRawOffset(int i10);

    public abstract boolean useDaylightTime();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class NoImagePreloadHolder {
        public static final Pattern CUSTOM_ZONE_ID_PATTERN = Pattern.compile("^GMT[-+](\\d{1,2})(:?(\\d\\d))?$");

        private NoImagePreloadHolder() {
        }
    }

    public int getOffset(long date) {
        if (inDaylightTime(new Date(date))) {
            return getRawOffset() + getDSTSavings();
        }
        return getRawOffset();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getOffsets(long date, int[] offsets) {
        int rawoffset = getRawOffset();
        int dstoffset = 0;
        if (inDaylightTime(new Date(date))) {
            dstoffset = getDSTSavings();
        }
        if (offsets != null) {
            offsets[0] = rawoffset;
            offsets[1] = dstoffset;
        }
        return rawoffset + dstoffset;
    }

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        if (ID == null) {
            throw new NullPointerException();
        }
        this.ID = ID;
    }

    public final String getDisplayName() {
        return getDisplayName(false, 1, Locale.getDefault(Locale.Category.DISPLAY));
    }

    public final String getDisplayName(Locale locale) {
        return getDisplayName(false, 1, locale);
    }

    public final String getDisplayName(boolean daylight, int style) {
        return getDisplayName(daylight, style, Locale.getDefault(Locale.Category.DISPLAY));
    }

    public String getDisplayName(boolean daylightTime, int style, Locale locale) {
        TimeZoneNames.NameType nameType;
        switch (style) {
            case 0:
                if (daylightTime) {
                    nameType = TimeZoneNames.NameType.SHORT_DAYLIGHT;
                    break;
                } else {
                    nameType = TimeZoneNames.NameType.SHORT_STANDARD;
                    break;
                }
            case 1:
                if (daylightTime) {
                    nameType = TimeZoneNames.NameType.LONG_DAYLIGHT;
                    break;
                } else {
                    nameType = TimeZoneNames.NameType.LONG_STANDARD;
                    break;
                }
            default:
                throw new IllegalArgumentException("Illegal style: " + style);
        }
        String canonicalID = android.icu.util.TimeZone.getCanonicalID(getID());
        if (canonicalID != null) {
            TimeZoneNames names = TimeZoneNames.getInstance(locale);
            long now = System.currentTimeMillis();
            String displayName = names.getDisplayName(canonicalID, nameType, now);
            if (displayName != null) {
                return displayName;
            }
        }
        int offsetMillis = getRawOffset();
        if (daylightTime) {
            offsetMillis += getDSTSavings();
        }
        return createGmtOffsetString(true, true, offsetMillis);
    }

    public static String createGmtOffsetString(boolean includeGmt, boolean includeMinuteSeparator, int offsetMillis) {
        int offsetMinutes = offsetMillis / 60000;
        char sign = '+';
        if (offsetMinutes < 0) {
            sign = '-';
            offsetMinutes = -offsetMinutes;
        }
        StringBuilder builder = new StringBuilder(9);
        if (includeGmt) {
            builder.append(TimeZones.GMT_ID);
        }
        builder.append(sign);
        appendNumber(builder, 2, offsetMinutes / 60);
        if (includeMinuteSeparator) {
            builder.append(ShortcutConstants.SERVICES_SEPARATOR);
        }
        appendNumber(builder, 2, offsetMinutes % 60);
        return builder.toString();
    }

    private static void appendNumber(StringBuilder builder, int count, int value) {
        String string = Integer.toString(value);
        for (int i10 = 0; i10 < count - string.length(); i10++) {
            builder.append('0');
        }
        builder.append(string);
    }

    public int getDSTSavings() {
        if (useDaylightTime()) {
            return 3600000;
        }
        return 0;
    }

    public boolean observesDaylightTime() {
        return useDaylightTime() || inDaylightTime(new Date());
    }

    public static synchronized TimeZone getTimeZone(String id2) {
        synchronized (TimeZone.class) {
            if (id2 == null) {
                throw new NullPointerException("id == null");
            }
            if (id2.length() == 3) {
                if (id2.equals(TimeZones.GMT_ID)) {
                    return (TimeZone) GMT.clone();
                }
                if (id2.equals(UtcDates.UTC)) {
                    return (TimeZone) UTC.clone();
                }
            }
            ZoneInfoData zoneInfoData = ZoneInfoDb.getInstance().makeZoneInfoData(id2);
            ZoneInfo createZoneInfo = zoneInfoData == null ? null : ZoneInfo.createZoneInfo(zoneInfoData);
            if (createZoneInfo == null && id2.length() > 3 && id2.startsWith(TimeZones.GMT_ID)) {
                createZoneInfo = getCustomTimeZone(id2);
            }
            return createZoneInfo != null ? createZoneInfo : (TimeZone) GMT.clone();
        }
    }

    public static TimeZone getTimeZone(ZoneId zoneId) {
        String tzid = zoneId.getId();
        char c4 = tzid.charAt(0);
        if (c4 == '+' || c4 == '-') {
            tzid = TimeZones.GMT_ID + tzid;
        } else if (c4 == 'Z' && tzid.length() == 1) {
            tzid = UtcDates.UTC;
        }
        return getTimeZone(tzid);
    }

    public ZoneId toZoneId() {
        return ZoneId.of(getID(), ZoneId.SHORT_IDS);
    }

    private static TimeZone getCustomTimeZone(String id2) {
        Matcher m10 = NoImagePreloadHolder.CUSTOM_ZONE_ID_PATTERN.matcher(id2);
        if (!m10.matches()) {
            return null;
        }
        int minute = 0;
        try {
            int hour = Integer.parseInt(m10.group(1));
            if (m10.group(3) != null) {
                minute = Integer.parseInt(m10.group(3));
            }
            if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
                return null;
            }
            char sign = id2.charAt(3);
            int raw = (3600000 * hour) + (60000 * minute);
            if (sign == '-') {
                raw = -raw;
            }
            String cleanId = String.format(Locale.ROOT, "GMT%c%02d:%02d", Character.valueOf(sign), Integer.valueOf(hour), Integer.valueOf(minute));
            return new SimpleTimeZone(raw, cleanId);
        } catch (NumberFormatException impossible) {
            throw new AssertionError(impossible);
        }
    }

    public static synchronized String[] getAvailableIDs(int rawOffset) {
        String[] availableIDs;
        synchronized (TimeZone.class) {
            availableIDs = ZoneInfoDb.getInstance().getAvailableIDs(rawOffset);
        }
        return availableIDs;
    }

    public static synchronized String[] getAvailableIDs() {
        String[] availableIDs;
        synchronized (TimeZone.class) {
            availableIDs = ZoneInfoDb.getInstance().getAvailableIDs();
        }
        return availableIDs;
    }

    public static TimeZone getDefault() {
        return (TimeZone) getDefaultRef().clone();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized TimeZone getDefaultRef() {
        TimeZone timeZone;
        synchronized (TimeZone.class) {
            if (defaultTimeZone == null) {
                Supplier<String> tzGetter = RuntimeHooks.getTimeZoneIdSupplier();
                String zoneName = tzGetter != null ? tzGetter.get() : null;
                if (zoneName != null) {
                    zoneName = zoneName.trim();
                }
                if (zoneName == null || zoneName.isEmpty()) {
                    try {
                        zoneName = IoUtils.readFileAsString("/etc/timezone");
                    } catch (IOException e2) {
                        zoneName = TimeZones.GMT_ID;
                    }
                }
                defaultTimeZone = getTimeZone(zoneName);
            }
            timeZone = defaultTimeZone;
        }
        return timeZone;
    }

    public static synchronized void setDefault(TimeZone timeZone) {
        synchronized (TimeZone.class) {
            SecurityManager sm = System.getSecurityManager();
            if (sm != null) {
                sm.checkPermission(new PropertyPermission("user.timezone", "write"));
            }
            defaultTimeZone = timeZone != null ? (TimeZone) timeZone.clone() : null;
            ExtendedTimeZone.clearDefaultTimeZone();
        }
    }

    public boolean hasSameRules(TimeZone other) {
        return other != null && getRawOffset() == other.getRawOffset() && useDaylightTime() == other.useDaylightTime();
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new InternalError(e2);
        }
    }
}
