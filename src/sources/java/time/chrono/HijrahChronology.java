package java.time.chrono;

import java.io.FilePermission;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.time.Clock;
import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.time.temporal.ValueRange;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import sun.util.logging.PlatformLogger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class HijrahChronology extends AbstractChronology implements Serializable {
    private static final Path CONF_PATH;
    public static final HijrahChronology INSTANCE;
    private static final String KEY_ID = "id";
    private static final String KEY_ISO_START = "iso-start";
    private static final String KEY_TYPE = "type";
    private static final String KEY_VERSION = "version";
    private static final String RESOURCE_PREFIX = "hijrah-config-";
    private static final String RESOURCE_SUFFIX = ".properties";
    private static final long serialVersionUID = 3127340209035924785L;
    private final transient String calendarType;
    private transient int[] hijrahEpochMonthStartDays;
    private transient int hijrahStartEpochMonth;
    private volatile transient boolean initComplete;
    private transient int maxEpochDay;
    private transient int maxMonthLength;
    private transient int maxYearLength;
    private transient int minEpochDay;
    private transient int minMonthLength;
    private transient int minYearLength;
    private final transient String typeId;

    @Override // java.time.chrono.AbstractChronology, java.time.chrono.Chronology
    public /* bridge */ /* synthetic */ ChronoLocalDate resolveDate(Map map, ResolverStyle resolverStyle) {
        return resolveDate((Map<TemporalField, Long>) map, resolverStyle);
    }

    static {
        HijrahChronology hijrahChronology = new HijrahChronology("Hijrah-umalqura", "islamic-umalqura");
        INSTANCE = hijrahChronology;
        AbstractChronology.registerChrono(hijrahChronology, "Hijrah");
        AbstractChronology.registerChrono(hijrahChronology, "islamic");
        CONF_PATH = Path.of((String) AccessController.doPrivileged(new PrivilegedAction() { // from class: java.time.chrono.HijrahChronology$$ExternalSyntheticLambda7
            @Override // java.security.PrivilegedAction
            public final Object run() {
                String property;
                property = System.getProperty("java.home");
                return property;
            }
        }), "conf", "chronology");
        registerCustomChrono();
    }

    private HijrahChronology(String id2, String calType) {
        if (id2.isEmpty()) {
            throw new IllegalArgumentException("calendar id is empty");
        }
        if (calType.isEmpty()) {
            throw new IllegalArgumentException("calendar typeId is empty");
        }
        this.typeId = id2;
        this.calendarType = calType;
    }

    private void checkCalendarInit() {
        if (!this.initComplete) {
            loadCalendarData();
            this.initComplete = true;
        }
    }

    @Override // java.time.chrono.Chronology
    public String getId() {
        return this.typeId;
    }

    @Override // java.time.chrono.Chronology
    public String getCalendarType() {
        return this.calendarType;
    }

    @Override // java.time.chrono.Chronology
    public HijrahDate date(Era era, int yearOfEra, int month, int dayOfMonth) {
        return date(prolepticYear(era, yearOfEra), month, dayOfMonth);
    }

    @Override // java.time.chrono.Chronology
    public HijrahDate date(int prolepticYear, int month, int dayOfMonth) {
        return HijrahDate.of(this, prolepticYear, month, dayOfMonth);
    }

    @Override // java.time.chrono.Chronology
    public HijrahDate dateYearDay(Era era, int yearOfEra, int dayOfYear) {
        return dateYearDay(prolepticYear(era, yearOfEra), dayOfYear);
    }

    @Override // java.time.chrono.Chronology
    public HijrahDate dateYearDay(int prolepticYear, int dayOfYear) {
        HijrahDate date = HijrahDate.of(this, prolepticYear, 1, 1);
        if (dayOfYear > date.lengthOfYear()) {
            throw new DateTimeException("Invalid dayOfYear: " + dayOfYear);
        }
        return date.plusDays(dayOfYear - 1);
    }

    @Override // java.time.chrono.Chronology
    public HijrahDate dateEpochDay(long epochDay) {
        return HijrahDate.ofEpochDay(this, epochDay);
    }

    @Override // java.time.chrono.Chronology
    public HijrahDate dateNow() {
        return dateNow(Clock.systemDefaultZone());
    }

    @Override // java.time.chrono.Chronology
    public HijrahDate dateNow(ZoneId zone) {
        return dateNow(Clock.system(zone));
    }

    @Override // java.time.chrono.Chronology
    public HijrahDate dateNow(Clock clock) {
        return date((TemporalAccessor) LocalDate.now(clock));
    }

    @Override // java.time.chrono.Chronology
    public HijrahDate date(TemporalAccessor temporal) {
        if (temporal instanceof HijrahDate) {
            return (HijrahDate) temporal;
        }
        return HijrahDate.ofEpochDay(this, temporal.getLong(ChronoField.EPOCH_DAY));
    }

    @Override // java.time.chrono.Chronology
    public ChronoLocalDateTime<HijrahDate> localDateTime(TemporalAccessor temporal) {
        return super.localDateTime(temporal);
    }

    @Override // java.time.chrono.Chronology
    public ChronoZonedDateTime<HijrahDate> zonedDateTime(TemporalAccessor temporal) {
        return super.zonedDateTime(temporal);
    }

    @Override // java.time.chrono.Chronology
    public ChronoZonedDateTime<HijrahDate> zonedDateTime(Instant instant, ZoneId zone) {
        return super.zonedDateTime(instant, zone);
    }

    @Override // java.time.chrono.Chronology
    public boolean isLeapYear(long prolepticYear) {
        checkCalendarInit();
        if (prolepticYear < getMinimumYear() || prolepticYear > getMaximumYear()) {
            return false;
        }
        int len = getYearLength((int) prolepticYear);
        return len > 354;
    }

    @Override // java.time.chrono.Chronology
    public int prolepticYear(Era era, int yearOfEra) {
        if (!(era instanceof HijrahEra)) {
            throw new ClassCastException("Era must be HijrahEra");
        }
        return yearOfEra;
    }

    @Override // java.time.chrono.Chronology
    public HijrahEra eraOf(int eraValue) {
        switch (eraValue) {
            case 1:
                return HijrahEra.AH;
            default:
                throw new DateTimeException("invalid Hijrah era");
        }
    }

    @Override // java.time.chrono.Chronology
    public List<Era> eras() {
        return List.of((Object[]) HijrahEra.values());
    }

    @Override // java.time.chrono.Chronology
    public ValueRange range(ChronoField field) {
        checkCalendarInit();
        if (field instanceof ChronoField) {
            switch (AnonymousClass1.$SwitchMap$java$time$temporal$ChronoField[field.ordinal()]) {
                case 1:
                    return ValueRange.of(1L, 1L, getMinimumMonthLength(), getMaximumMonthLength());
                case 2:
                    return ValueRange.of(1L, getMaximumDayOfYear());
                case 3:
                    return ValueRange.of(1L, 5L);
                case 4:
                case 5:
                    return ValueRange.of(getMinimumYear(), getMaximumYear());
                case 6:
                    return ValueRange.of(1L, 1L);
                default:
                    return field.range();
            }
        }
        return field.range();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.time.chrono.HijrahChronology$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$time$temporal$ChronoField;

        static {
            int[] iArr = new int[ChronoField.values().length];
            $SwitchMap$java$time$temporal$ChronoField = iArr;
            try {
                iArr[ChronoField.DAY_OF_MONTH.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.DAY_OF_YEAR.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.ALIGNED_WEEK_OF_MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.YEAR.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.YEAR_OF_ERA.ordinal()] = 5;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.ERA.ordinal()] = 6;
            } catch (NoSuchFieldError e14) {
            }
        }
    }

    @Override // java.time.chrono.AbstractChronology, java.time.chrono.Chronology
    public HijrahDate resolveDate(Map<TemporalField, Long> fieldValues, ResolverStyle resolverStyle) {
        return (HijrahDate) super.resolveDate(fieldValues, resolverStyle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int checkValidYear(long prolepticYear) {
        if (prolepticYear < getMinimumYear() || prolepticYear > getMaximumYear()) {
            throw new DateTimeException("Invalid Hijrah year: " + prolepticYear);
        }
        return (int) prolepticYear;
    }

    void checkValidDayOfYear(int dayOfYear) {
        if (dayOfYear < 1 || dayOfYear > getMaximumDayOfYear()) {
            throw new DateTimeException("Invalid Hijrah day of year: " + dayOfYear);
        }
    }

    void checkValidMonth(int month) {
        if (month < 1 || month > 12) {
            throw new DateTimeException("Invalid Hijrah month: " + month);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] getHijrahDateInfo(int epochDay) {
        checkCalendarInit();
        if (epochDay < this.minEpochDay || epochDay >= this.maxEpochDay) {
            throw new DateTimeException("Hijrah date out of range");
        }
        int epochMonth = epochDayToEpochMonth(epochDay);
        int year = epochMonthToYear(epochMonth);
        int month = epochMonthToMonth(epochMonth);
        int day1 = epochMonthToEpochDay(epochMonth);
        int date = epochDay - day1;
        int[] dateInfo = {year, month + 1, date + 1};
        return dateInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getEpochDay(int prolepticYear, int monthOfYear, int dayOfMonth) {
        checkCalendarInit();
        checkValidMonth(monthOfYear);
        int epochMonth = yearToEpochMonth(prolepticYear) + (monthOfYear - 1);
        if (epochMonth < 0 || epochMonth >= this.hijrahEpochMonthStartDays.length) {
            throw new DateTimeException("Invalid Hijrah date, year: " + prolepticYear + ", month: " + monthOfYear);
        }
        if (dayOfMonth < 1 || dayOfMonth > getMonthLength(prolepticYear, monthOfYear)) {
            throw new DateTimeException("Invalid Hijrah day of month: " + dayOfMonth);
        }
        return epochMonthToEpochDay(epochMonth) + (dayOfMonth - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getDayOfYear(int prolepticYear, int month) {
        return yearMonthToDayOfYear(prolepticYear, month - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMonthLength(int prolepticYear, int monthOfYear) {
        int epochMonth = yearToEpochMonth(prolepticYear) + (monthOfYear - 1);
        if (epochMonth < 0 || epochMonth >= this.hijrahEpochMonthStartDays.length) {
            throw new DateTimeException("Invalid Hijrah date, year: " + prolepticYear + ", month: " + monthOfYear);
        }
        return epochMonthLength(epochMonth);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getYearLength(int prolepticYear) {
        return yearMonthToDayOfYear(prolepticYear, 12);
    }

    int getMinimumYear() {
        return epochMonthToYear(0);
    }

    int getMaximumYear() {
        return epochMonthToYear(this.hijrahEpochMonthStartDays.length - 1) - 1;
    }

    int getMaximumMonthLength() {
        return this.maxMonthLength;
    }

    int getMinimumMonthLength() {
        return this.minMonthLength;
    }

    int getMaximumDayOfYear() {
        return this.maxYearLength;
    }

    int getSmallestMaximumDayOfYear() {
        return this.minYearLength;
    }

    private int epochDayToEpochMonth(int epochDay) {
        int ndx = Arrays.binarySearch(this.hijrahEpochMonthStartDays, epochDay);
        if (ndx < 0) {
            return (-ndx) - 2;
        }
        return ndx;
    }

    private int epochMonthToYear(int epochMonth) {
        return (this.hijrahStartEpochMonth + epochMonth) / 12;
    }

    private int yearToEpochMonth(int year) {
        return (year * 12) - this.hijrahStartEpochMonth;
    }

    private int epochMonthToMonth(int epochMonth) {
        return (this.hijrahStartEpochMonth + epochMonth) % 12;
    }

    private int epochMonthToEpochDay(int epochMonth) {
        return this.hijrahEpochMonthStartDays[epochMonth];
    }

    private int yearMonthToDayOfYear(int prolepticYear, int month) {
        int epochMonthFirst = yearToEpochMonth(prolepticYear);
        return epochMonthToEpochDay(epochMonthFirst + month) - epochMonthToEpochDay(epochMonthFirst);
    }

    private int epochMonthLength(int epochMonth) {
        int[] iArr = this.hijrahEpochMonthStartDays;
        return iArr[epochMonth + 1] - iArr[epochMonth];
    }

    private static Properties readConfigProperties(String chronologyId, String calendarType) throws Exception {
        Supplier<InputStream> getResourceAction;
        final String resourceName = RESOURCE_PREFIX + chronologyId + "_" + calendarType + RESOURCE_SUFFIX;
        if (calendarType.equals("islamic-umalqura")) {
            getResourceAction = new Supplier() { // from class: java.time.chrono.HijrahChronology$$ExternalSyntheticLambda0
                @Override // java.util.function.Supplier
                public final Object get() {
                    InputStream resourceAsStream;
                    resourceAsStream = HijrahChronology.class.getResourceAsStream(String.this);
                    return resourceAsStream;
                }
            };
        } else {
            getResourceAction = new Supplier() { // from class: java.time.chrono.HijrahChronology$$ExternalSyntheticLambda1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return HijrahChronology.lambda$readConfigProperties$2(String.this);
                }
            };
        }
        InputStream is = getResourceAction.get();
        try {
            if (is == null) {
                throw new RuntimeException("Hijrah calendar resource not found: " + resourceName);
            }
            Properties props = new Properties();
            props.load(is);
            if (is != null) {
                is.close();
            }
            return props;
        } catch (Throwable th) {
            if (is != null) {
                try {
                    is.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ InputStream lambda$readConfigProperties$2(String resourceName) {
        try {
            return Files.newInputStream(CONF_PATH.resolve(resourceName), StandardOpenOption.READ);
        } catch (IOException e2) {
            throw new UncheckedIOException(e2);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0064. Please report as an issue. */
    private void loadCalendarData() {
        char c4;
        try {
            Properties props = readConfigProperties(this.typeId, this.calendarType);
            Map<Integer, int[]> years = new HashMap<>();
            int minYear = Integer.MAX_VALUE;
            int maxYear = Integer.MIN_VALUE;
            String id2 = null;
            String type = null;
            String version = null;
            int isoStart = 0;
            for (Map.Entry<Object, Object> entry : props.entrySet()) {
                String key = (String) entry.getKey();
                switch (key.hashCode()) {
                    case -1117701862:
                        if (key.equals(KEY_ISO_START)) {
                            c4 = 3;
                            break;
                        }
                        break;
                    case 3355:
                        if (key.equals("id")) {
                            c4 = 0;
                            break;
                        }
                        break;
                    case 3575610:
                        if (key.equals("type")) {
                            c4 = 1;
                            break;
                        }
                        break;
                    case 351608024:
                        if (key.equals("version")) {
                            c4 = 2;
                            break;
                        }
                        break;
                }
                c4 = 65535;
                switch (c4) {
                    case 0:
                        id2 = (String) entry.getValue();
                    case 1:
                        type = (String) entry.getValue();
                    case 2:
                        version = (String) entry.getValue();
                    case 3:
                        int[] ymd = parseYMD((String) entry.getValue());
                        isoStart = (int) LocalDate.of(ymd[0], ymd[1], ymd[2]).toEpochDay();
                    default:
                        try {
                            int year = Integer.parseInt(key);
                            int[] months = parseMonths((String) entry.getValue());
                            years.put(Integer.valueOf(year), months);
                            maxYear = Math.max(maxYear, year);
                            minYear = Math.min(minYear, year);
                        } catch (NumberFormatException e2) {
                            throw new IllegalArgumentException("bad key: " + key);
                        }
                }
            }
            if (!getId().equals(id2)) {
                throw new IllegalArgumentException("Configuration is for a different calendar: " + id2);
            }
            if (!getCalendarType().equals(type)) {
                throw new IllegalArgumentException("Configuration is for a different calendar type: " + type);
            }
            if (version == null || version.isEmpty()) {
                throw new IllegalArgumentException("Configuration does not contain a version");
            }
            if (isoStart == 0) {
                throw new IllegalArgumentException("Configuration does not contain a ISO start date");
            }
            this.hijrahStartEpochMonth = minYear * 12;
            this.minEpochDay = isoStart;
            int[] createEpochMonths = createEpochMonths(isoStart, minYear, maxYear, years);
            this.hijrahEpochMonthStartDays = createEpochMonths;
            this.maxEpochDay = createEpochMonths[createEpochMonths.length - 1];
            for (int year2 = minYear; year2 < maxYear; year2++) {
                int length = getYearLength(year2);
                this.minYearLength = Math.min(this.minYearLength, length);
                this.maxYearLength = Math.max(this.maxYearLength, length);
            }
        } catch (Exception ex) {
            PlatformLogger logger = PlatformLogger.getLogger("java.time.chrono");
            logger.severe("Unable to initialize Hijrah calendar proxy: " + this.typeId, ex);
            throw new DateTimeException("Unable to initialize HijrahCalendar: " + this.typeId, ex);
        }
    }

    private int[] createEpochMonths(int epochDay, int minYear, int maxYear, Map<Integer, int[]> years) {
        int numMonths = (((maxYear - minYear) + 1) * 12) + 1;
        int epochMonth = 0;
        int[] epochMonths = new int[numMonths];
        this.minMonthLength = Integer.MAX_VALUE;
        this.maxMonthLength = Integer.MIN_VALUE;
        for (int year = minYear; year <= maxYear; year++) {
            int[] months = years.get(Integer.valueOf(year));
            int month = 0;
            while (month < 12) {
                int length = months[month];
                int epochMonth2 = epochMonth + 1;
                epochMonths[epochMonth] = epochDay;
                if (length < 29 || length > 32) {
                    throw new IllegalArgumentException("Invalid month length in year: " + minYear);
                }
                epochDay += length;
                this.minMonthLength = Math.min(this.minMonthLength, length);
                this.maxMonthLength = Math.max(this.maxMonthLength, length);
                month++;
                epochMonth = epochMonth2;
            }
        }
        int epochMonth3 = epochMonth + 1;
        epochMonths[epochMonth] = epochDay;
        if (epochMonth3 != epochMonths.length) {
            throw new IllegalStateException("Did not fill epochMonths exactly: ndx = " + epochMonth3 + " should be " + epochMonths.length);
        }
        return epochMonths;
    }

    private int[] parseMonths(String line) {
        int[] months = new int[12];
        String[] numbers = line.split("\\s");
        if (numbers.length != 12) {
            throw new IllegalArgumentException("wrong number of months on line: " + Arrays.toString(numbers) + "; count: " + numbers.length);
        }
        for (int i10 = 0; i10 < 12; i10++) {
            try {
                months[i10] = Integer.parseInt(numbers[i10]);
            } catch (NumberFormatException e2) {
                throw new IllegalArgumentException("bad key: " + numbers[i10]);
            }
        }
        return months;
    }

    private int[] parseYMD(String string) {
        String string2 = string.trim();
        try {
            if (string2.charAt(4) != '-' || string2.charAt(7) != '-') {
                throw new IllegalArgumentException("date must be yyyy-MM-dd");
            }
            int[] ymd = {Integer.parseInt(string2, 0, 4, 10), Integer.parseInt(string2, 5, 7, 10), Integer.parseInt(string2, 8, 10, 10)};
            return ymd;
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("date must be yyyy-MM-dd", ex);
        }
    }

    private static void registerCustomChrono() {
        AccessController.doPrivileged(new PrivilegedAction() { // from class: java.time.chrono.HijrahChronology$$ExternalSyntheticLambda6
            @Override // java.security.PrivilegedAction
            public final Object run() {
                return HijrahChronology.lambda$registerCustomChrono$7();
            }
        }, (AccessControlContext) null, new FilePermission("<<ALL FILES>>", "read"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Void lambda$registerCustomChrono$7() {
        Path path = CONF_PATH;
        if (Files.isDirectory(path, new LinkOption[0])) {
            try {
                Files.list(path).map(new Function() { // from class: java.time.chrono.HijrahChronology$$ExternalSyntheticLambda2
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        String path2;
                        path2 = ((Path) obj).getFileName().toString();
                        return path2;
                    }
                }).filter(new Predicate() { // from class: java.time.chrono.HijrahChronology$$ExternalSyntheticLambda3
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        boolean matches;
                        matches = ((String) obj).matches("hijrah-config-[^\\.]+\\.properties");
                        return matches;
                    }
                }).map(new Function() { // from class: java.time.chrono.HijrahChronology$$ExternalSyntheticLambda4
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        String replaceAll;
                        replaceAll = ((String) obj).replaceAll("(hijrah-config-|\\.properties)", "");
                        return replaceAll;
                    }
                }).forEach(new Consumer() { // from class: java.time.chrono.HijrahChronology$$ExternalSyntheticLambda5
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        HijrahChronology.lambda$registerCustomChrono$6((String) obj);
                    }
                });
                return null;
            } catch (IOException e2) {
                PlatformLogger.getLogger("java.time.chrono").warning("Hijrah custom config init failed.", e2);
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$registerCustomChrono$6(String idtype) {
        int delimiterPos = idtype.indexOf(95);
        if (delimiterPos > 1 && delimiterPos < idtype.length() - 1) {
            AbstractChronology.registerChrono(new HijrahChronology(idtype.substring(0, delimiterPos), idtype.substring(delimiterPos + 1)));
        } else {
            PlatformLogger.getLogger("java.time.chrono").warning("Hijrah custom config init failed.'<id>_<type>' name convention not followed: " + idtype);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.time.chrono.AbstractChronology
    public Object writeReplace() {
        return super.writeReplace();
    }

    private void readObject(ObjectInputStream s2) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
