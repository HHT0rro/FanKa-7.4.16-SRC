package org.joda.time;

import com.android.internal.accessibility.common.ShortcutConstants;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.datepicker.UtcDates;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.lang3.time.TimeZones;
import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.chrono.BaseChronology;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.tz.FixedDateTimeZone;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class DateTimeZone implements Serializable {
    public static final String DEFAULT_TZ_DATA_PATH = "org/joda/time/tz/data";
    private static final int MAX_MILLIS = 86399999;
    private static final long serialVersionUID = 5546345482340108586L;
    private final String iID;
    public static final DateTimeZone UTC = UTCDateTimeZone.INSTANCE;
    private static final AtomicReference<org.joda.time.tz.c> cProvider = new AtomicReference<>();
    private static final AtomicReference<org.joda.time.tz.b> cNameProvider = new AtomicReference<>();
    private static final AtomicReference<DateTimeZone> cDefault = new AtomicReference<>();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class LazyInit {

        /* renamed from: a, reason: collision with root package name */
        public static final Map<String, String> f52444a = b();

        /* renamed from: b, reason: collision with root package name */
        public static final org.joda.time.format.b f52445b = a();

        public static org.joda.time.format.b a() {
            return new DateTimeFormatterBuilder().M(null, true, 2, 4).e0().u(new BaseChronology() { // from class: org.joda.time.DateTimeZone.LazyInit.1
                private static final long serialVersionUID = -3128740902654445468L;

                @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
                public DateTimeZone getZone() {
                    return null;
                }

                @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
                public String toString() {
                    return AnonymousClass1.class.getName();
                }

                @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
                public a withUTC() {
                    return this;
                }

                @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
                public a withZone(DateTimeZone dateTimeZone) {
                    return this;
                }
            });
        }

        public static Map<String, String> b() {
            HashMap hashMap = new HashMap();
            hashMap.put(TimeZones.GMT_ID, UtcDates.UTC);
            hashMap.put("WET", "WET");
            hashMap.put("CET", "CET");
            hashMap.put("MET", "CET");
            hashMap.put("ECT", "CET");
            hashMap.put("EET", "EET");
            hashMap.put("MIT", "Pacific/Apia");
            hashMap.put("HST", "Pacific/Honolulu");
            hashMap.put("AST", "America/Anchorage");
            hashMap.put("PST", "America/Los_Angeles");
            hashMap.put("MST", "America/Denver");
            hashMap.put("PNT", "America/Phoenix");
            hashMap.put("CST", "America/Chicago");
            hashMap.put("EST", "America/New_York");
            hashMap.put("IET", "America/Indiana/Indianapolis");
            hashMap.put("PRT", "America/Puerto_Rico");
            hashMap.put("CNT", "America/St_Johns");
            hashMap.put("AGT", "America/Argentina/Buenos_Aires");
            hashMap.put("BET", "America/Sao_Paulo");
            hashMap.put("ART", "Africa/Cairo");
            hashMap.put("CAT", "Africa/Harare");
            hashMap.put("EAT", "Africa/Addis_Ababa");
            hashMap.put("NET", "Asia/Yerevan");
            hashMap.put("PLT", "Asia/Karachi");
            hashMap.put("IST", "Asia/Kolkata");
            hashMap.put("BST", "Asia/Dhaka");
            hashMap.put("VST", "Asia/Ho_Chi_Minh");
            hashMap.put("CTT", "Asia/Shanghai");
            hashMap.put("JST", "Asia/Tokyo");
            hashMap.put("ACT", "Australia/Darwin");
            hashMap.put("AET", "Australia/Sydney");
            hashMap.put("SST", "Pacific/Guadalcanal");
            hashMap.put("NST", "Pacific/Auckland");
            return Collections.unmodifiableMap(hashMap);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Stub implements Serializable {
        private static final long serialVersionUID = -6471952376487863581L;
        private transient String iID;

        public Stub(String str) {
            this.iID = str;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            this.iID = objectInputStream.readUTF();
        }

        private Object readResolve() throws ObjectStreamException {
            return DateTimeZone.forID(this.iID);
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeUTF(this.iID);
        }
    }

    public DateTimeZone(String str) {
        if (str != null) {
            this.iID = str;
            return;
        }
        throw new IllegalArgumentException("Id must not be null");
    }

    private static String convertToAsciiNumber(String str) {
        StringBuilder sb2 = new StringBuilder(str);
        for (int i10 = 0; i10 < sb2.length(); i10++) {
            int digit = Character.digit(sb2.charAt(i10), 10);
            if (digit >= 0) {
                sb2.setCharAt(i10, (char) (digit + 48));
            }
        }
        return sb2.toString();
    }

    private static DateTimeZone fixedOffsetZone(String str, int i10) {
        if (i10 == 0) {
            return UTC;
        }
        return new FixedDateTimeZone(str, null, i10, i10);
    }

    @FromString
    public static DateTimeZone forID(String str) {
        if (str == null) {
            return getDefault();
        }
        if (str.equals(UtcDates.UTC)) {
            return UTC;
        }
        DateTimeZone a10 = getProvider().a(str);
        if (a10 != null) {
            return a10;
        }
        if (!str.startsWith(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX) && !str.startsWith("-")) {
            throw new IllegalArgumentException("The datetime zone id '" + str + "' is not recognised");
        }
        int parseOffset = parseOffset(str);
        if (parseOffset == 0) {
            return UTC;
        }
        return fixedOffsetZone(printOffset(parseOffset), parseOffset);
    }

    public static DateTimeZone forOffsetHours(int i10) throws IllegalArgumentException {
        return forOffsetHoursMinutes(i10, 0);
    }

    public static DateTimeZone forOffsetHoursMinutes(int i10, int i11) throws IllegalArgumentException {
        if (i10 == 0 && i11 == 0) {
            return UTC;
        }
        if (i10 < -23 || i10 > 23) {
            throw new IllegalArgumentException("Hours out of range: " + i10);
        }
        if (i11 < -59 || i11 > 59) {
            throw new IllegalArgumentException("Minutes out of range: " + i11);
        }
        if (i10 > 0 && i11 < 0) {
            throw new IllegalArgumentException("Positive hours must not have negative minutes: " + i11);
        }
        int i12 = i10 * 60;
        try {
            return forOffsetMillis(org.joda.time.field.e.h(i12 < 0 ? i12 - Math.abs(i11) : i12 + i11, 60000));
        } catch (ArithmeticException unused) {
            throw new IllegalArgumentException("Offset is too large");
        }
    }

    public static DateTimeZone forOffsetMillis(int i10) {
        if (i10 >= -86399999 && i10 <= MAX_MILLIS) {
            return fixedOffsetZone(printOffset(i10), i10);
        }
        throw new IllegalArgumentException("Millis out of range: " + i10);
    }

    public static DateTimeZone forTimeZone(TimeZone timeZone) {
        char charAt;
        if (timeZone == null) {
            return getDefault();
        }
        String id2 = timeZone.getID();
        if (id2 != null) {
            if (id2.equals(UtcDates.UTC)) {
                return UTC;
            }
            String convertedId = getConvertedId(id2);
            org.joda.time.tz.c provider = getProvider();
            DateTimeZone a10 = convertedId != null ? provider.a(convertedId) : null;
            if (a10 == null) {
                a10 = provider.a(id2);
            }
            if (a10 != null) {
                return a10;
            }
            if (convertedId == null && (id2.startsWith("GMT+") || id2.startsWith("GMT-"))) {
                String substring = id2.substring(3);
                if (substring.length() > 2 && (charAt = substring.charAt(1)) > '9' && Character.isDigit(charAt)) {
                    substring = convertToAsciiNumber(substring);
                }
                int parseOffset = parseOffset(substring);
                if (parseOffset == 0) {
                    return UTC;
                }
                return fixedOffsetZone(printOffset(parseOffset), parseOffset);
            }
            throw new IllegalArgumentException("The datetime zone id '" + id2 + "' is not recognised");
        }
        throw new IllegalArgumentException("The TimeZone id must not be null");
    }

    public static Set<String> getAvailableIDs() {
        return getProvider().b();
    }

    private static String getConvertedId(String str) {
        return LazyInit.f52444a.get(str);
    }

    public static DateTimeZone getDefault() {
        DateTimeZone dateTimeZone = cDefault.get();
        if (dateTimeZone != null) {
            return dateTimeZone;
        }
        try {
            String property = System.getProperty("user.timezone");
            if (property != null) {
                dateTimeZone = forID(property);
            }
        } catch (RuntimeException unused) {
        }
        if (dateTimeZone == null) {
            try {
                dateTimeZone = forTimeZone(TimeZone.getDefault());
            } catch (IllegalArgumentException unused2) {
            }
        }
        if (dateTimeZone == null) {
            dateTimeZone = UTC;
        }
        AtomicReference<DateTimeZone> atomicReference = cDefault;
        return !atomicReference.compareAndSet(null, dateTimeZone) ? atomicReference.get() : dateTimeZone;
    }

    private static org.joda.time.tz.b getDefaultNameProvider() {
        org.joda.time.tz.b bVar = null;
        try {
            String property = System.getProperty("org.joda.time.DateTimeZone.NameProvider");
            if (property != null) {
                try {
                    Class<?> cls = Class.forName(property, false, DateTimeZone.class.getClassLoader());
                    if (!org.joda.time.tz.b.class.isAssignableFrom(cls)) {
                        throw new IllegalArgumentException("System property referred to class that does not implement " + ((Object) org.joda.time.tz.b.class));
                    }
                    bVar = (org.joda.time.tz.b) cls.asSubclass(org.joda.time.tz.b.class).getConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
        } catch (SecurityException unused) {
        }
        return bVar == null ? new org.joda.time.tz.a() : bVar;
    }

    private static org.joda.time.tz.c getDefaultProvider() {
        try {
            String property = System.getProperty("org.joda.time.DateTimeZone.Provider");
            if (property != null) {
                try {
                    Class<?> cls = Class.forName(property, false, DateTimeZone.class.getClassLoader());
                    if (!org.joda.time.tz.c.class.isAssignableFrom(cls)) {
                        throw new IllegalArgumentException("System property referred to class that does not implement " + ((Object) org.joda.time.tz.c.class));
                    }
                    return validateProvider((org.joda.time.tz.c) cls.asSubclass(org.joda.time.tz.c.class).getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
        } catch (SecurityException unused) {
        }
        try {
            String property2 = System.getProperty("org.joda.time.DateTimeZone.Folder");
            if (property2 != null) {
                try {
                    return validateProvider(new org.joda.time.tz.f(new File(property2)));
                } catch (Exception e10) {
                    throw new RuntimeException(e10);
                }
            }
        } catch (SecurityException unused2) {
        }
        try {
            return validateProvider(new org.joda.time.tz.f(DEFAULT_TZ_DATA_PATH));
        } catch (Exception e11) {
            e11.printStackTrace();
            return new org.joda.time.tz.d();
        }
    }

    public static org.joda.time.tz.b getNameProvider() {
        AtomicReference<org.joda.time.tz.b> atomicReference = cNameProvider;
        org.joda.time.tz.b bVar = atomicReference.get();
        if (bVar != null) {
            return bVar;
        }
        org.joda.time.tz.b defaultNameProvider = getDefaultNameProvider();
        return !atomicReference.compareAndSet(null, defaultNameProvider) ? atomicReference.get() : defaultNameProvider;
    }

    public static org.joda.time.tz.c getProvider() {
        AtomicReference<org.joda.time.tz.c> atomicReference = cProvider;
        org.joda.time.tz.c cVar = atomicReference.get();
        if (cVar != null) {
            return cVar;
        }
        org.joda.time.tz.c defaultProvider = getDefaultProvider();
        return !atomicReference.compareAndSet(null, defaultProvider) ? atomicReference.get() : defaultProvider;
    }

    private static int parseOffset(String str) {
        return -((int) LazyInit.f52445b.j(str));
    }

    private static String printOffset(int i10) {
        StringBuffer stringBuffer = new StringBuffer();
        if (i10 >= 0) {
            stringBuffer.append('+');
        } else {
            stringBuffer.append('-');
            i10 = -i10;
        }
        int i11 = i10 / 3600000;
        org.joda.time.format.h.b(stringBuffer, i11, 2);
        int i12 = i10 - (i11 * 3600000);
        int i13 = i12 / 60000;
        stringBuffer.append(ShortcutConstants.SERVICES_SEPARATOR);
        org.joda.time.format.h.b(stringBuffer, i13, 2);
        int i14 = i12 - (i13 * 60000);
        if (i14 == 0) {
            return stringBuffer.toString();
        }
        int i15 = i14 / 1000;
        stringBuffer.append(ShortcutConstants.SERVICES_SEPARATOR);
        org.joda.time.format.h.b(stringBuffer, i15, 2);
        int i16 = i14 - (i15 * 1000);
        if (i16 == 0) {
            return stringBuffer.toString();
        }
        stringBuffer.append('.');
        org.joda.time.format.h.b(stringBuffer, i16, 3);
        return stringBuffer.toString();
    }

    public static void setDefault(DateTimeZone dateTimeZone) throws SecurityException {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new JodaTimePermission("DateTimeZone.setDefault"));
        }
        if (dateTimeZone != null) {
            cDefault.set(dateTimeZone);
            return;
        }
        throw new IllegalArgumentException("The datetime zone must not be null");
    }

    public static void setNameProvider(org.joda.time.tz.b bVar) throws SecurityException {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new JodaTimePermission("DateTimeZone.setNameProvider"));
        }
        if (bVar == null) {
            bVar = getDefaultNameProvider();
        }
        cNameProvider.set(bVar);
    }

    public static void setProvider(org.joda.time.tz.c cVar) throws SecurityException {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new JodaTimePermission("DateTimeZone.setProvider"));
        }
        if (cVar == null) {
            cVar = getDefaultProvider();
        } else {
            validateProvider(cVar);
        }
        cProvider.set(cVar);
    }

    private static org.joda.time.tz.c validateProvider(org.joda.time.tz.c cVar) {
        Set<String> b4 = cVar.b();
        if (b4 != null && b4.size() != 0) {
            if (b4.contains(UtcDates.UTC)) {
                if (UTC.equals(cVar.a(UtcDates.UTC))) {
                    return cVar;
                }
                throw new IllegalArgumentException("Invalid UTC zone provided");
            }
            throw new IllegalArgumentException("The provider doesn't support UTC");
        }
        throw new IllegalArgumentException("The provider doesn't have any available ids");
    }

    public long adjustOffset(long j10, boolean z10) {
        long j11 = j10 - 10800000;
        long offset = getOffset(j11);
        long offset2 = getOffset(10800000 + j10);
        if (offset <= offset2) {
            return j10;
        }
        long j12 = offset - offset2;
        long nextTransition = nextTransition(j11);
        long j13 = nextTransition - j12;
        return (j10 < j13 || j10 >= nextTransition + j12) ? j10 : j10 - j13 >= j12 ? z10 ? j10 : j10 - j12 : z10 ? j10 + j12 : j10;
    }

    public long convertLocalToUTC(long j10, boolean z10, long j11) {
        int offset = getOffset(j11);
        long j12 = j10 - offset;
        return getOffset(j12) == offset ? j12 : convertLocalToUTC(j10, z10);
    }

    public long convertUTCToLocal(long j10) {
        long offset = getOffset(j10);
        long j11 = j10 + offset;
        if ((j10 ^ j11) >= 0 || (j10 ^ offset) < 0) {
            return j11;
        }
        throw new ArithmeticException("Adding time zone offset caused overflow");
    }

    public abstract boolean equals(Object obj);

    @ToString
    public final String getID() {
        return this.iID;
    }

    public long getMillisKeepLocal(DateTimeZone dateTimeZone, long j10) {
        if (dateTimeZone == null) {
            dateTimeZone = getDefault();
        }
        DateTimeZone dateTimeZone2 = dateTimeZone;
        return dateTimeZone2 == this ? j10 : dateTimeZone2.convertLocalToUTC(convertUTCToLocal(j10), false, j10);
    }

    public final String getName(long j10) {
        return getName(j10, null);
    }

    public abstract String getNameKey(long j10);

    public abstract int getOffset(long j10);

    public final int getOffset(i iVar) {
        if (iVar == null) {
            return getOffset(c.b());
        }
        return getOffset(iVar.getMillis());
    }

    public int getOffsetFromLocal(long j10) {
        int offset = getOffset(j10);
        long j11 = j10 - offset;
        int offset2 = getOffset(j11);
        if (offset != offset2) {
            if (offset - offset2 < 0) {
                long nextTransition = nextTransition(j11);
                if (nextTransition == j11) {
                    nextTransition = Long.MAX_VALUE;
                }
                long j12 = j10 - offset2;
                long nextTransition2 = nextTransition(j12);
                if (nextTransition != (nextTransition2 != j12 ? nextTransition2 : Long.MAX_VALUE)) {
                    return offset;
                }
            }
        } else if (offset >= 0) {
            long previousTransition = previousTransition(j11);
            if (previousTransition < j11) {
                int offset3 = getOffset(previousTransition);
                if (j11 - previousTransition <= offset3 - offset) {
                    return offset3;
                }
            }
        }
        return offset2;
    }

    public final String getShortName(long j10) {
        return getShortName(j10, null);
    }

    public abstract int getStandardOffset(long j10);

    public int hashCode() {
        return getID().hashCode() + 57;
    }

    public abstract boolean isFixed();

    public boolean isLocalDateTimeGap(LocalDateTime localDateTime) {
        if (isFixed()) {
            return false;
        }
        try {
            localDateTime.toDateTime(this);
            return false;
        } catch (IllegalInstantException unused) {
            return true;
        }
    }

    public boolean isStandardOffset(long j10) {
        return getOffset(j10) == getStandardOffset(j10);
    }

    public abstract long nextTransition(long j10);

    public abstract long previousTransition(long j10);

    public String toString() {
        return getID();
    }

    public TimeZone toTimeZone() {
        return TimeZone.getTimeZone(this.iID);
    }

    public Object writeReplace() throws ObjectStreamException {
        return new Stub(this.iID);
    }

    public String getName(long j10, Locale locale) {
        String b4;
        if (locale == null) {
            locale = Locale.getDefault();
        }
        String nameKey = getNameKey(j10);
        if (nameKey == null) {
            return this.iID;
        }
        org.joda.time.tz.b nameProvider = getNameProvider();
        if (nameProvider instanceof org.joda.time.tz.a) {
            b4 = ((org.joda.time.tz.a) nameProvider).d(locale, this.iID, nameKey, isStandardOffset(j10));
        } else {
            b4 = nameProvider.b(locale, this.iID, nameKey);
        }
        return b4 != null ? b4 : printOffset(getOffset(j10));
    }

    public String getShortName(long j10, Locale locale) {
        String a10;
        if (locale == null) {
            locale = Locale.getDefault();
        }
        String nameKey = getNameKey(j10);
        if (nameKey == null) {
            return this.iID;
        }
        org.joda.time.tz.b nameProvider = getNameProvider();
        if (nameProvider instanceof org.joda.time.tz.a) {
            a10 = ((org.joda.time.tz.a) nameProvider).g(locale, this.iID, nameKey, isStandardOffset(j10));
        } else {
            a10 = nameProvider.a(locale, this.iID, nameKey);
        }
        return a10 != null ? a10 : printOffset(getOffset(j10));
    }

    public long convertLocalToUTC(long j10, boolean z10) {
        long j11;
        int offset = getOffset(j10);
        long j12 = j10 - offset;
        int offset2 = getOffset(j12);
        if (offset != offset2 && (z10 || offset < 0)) {
            long nextTransition = nextTransition(j12);
            if (nextTransition == j12) {
                nextTransition = Long.MAX_VALUE;
            }
            long j13 = j10 - offset2;
            long nextTransition2 = nextTransition(j13);
            if (nextTransition != (nextTransition2 != j13 ? nextTransition2 : Long.MAX_VALUE)) {
                if (z10) {
                    throw new IllegalInstantException(j10, getID());
                }
                long j14 = offset;
                j11 = j10 - j14;
                if ((j10 ^ j11) < 0 || (j10 ^ j14) >= 0) {
                    return j11;
                }
                throw new ArithmeticException("Subtracting time zone offset caused overflow");
            }
        }
        offset = offset2;
        long j142 = offset;
        j11 = j10 - j142;
        if ((j10 ^ j11) < 0) {
        }
        return j11;
    }
}
