package java.lang;

import android.system.ErrnoException;
import android.system.StructUtsname;
import dalvik.annotation.optimization.CriticalNative;
import dalvik.annotation.optimization.FastNative;
import dalvik.system.VMRuntime;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Console;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.channels.Channel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.PropertyPermission;
import libcore.icu.ICU;
import libcore.io.Libcore;
import sun.misc.VM;
import sun.misc.Version;
import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class System {
    private static final int ARRAYCOPY_SHORT_BOOLEAN_ARRAY_THRESHOLD = 32;
    private static final int ARRAYCOPY_SHORT_BYTE_ARRAY_THRESHOLD = 32;
    private static final int ARRAYCOPY_SHORT_CHAR_ARRAY_THRESHOLD = 32;
    private static final int ARRAYCOPY_SHORT_DOUBLE_ARRAY_THRESHOLD = 32;
    private static final int ARRAYCOPY_SHORT_FLOAT_ARRAY_THRESHOLD = 32;
    private static final int ARRAYCOPY_SHORT_INT_ARRAY_THRESHOLD = 32;
    private static final int ARRAYCOPY_SHORT_LONG_ARRAY_THRESHOLD = 32;
    private static final int ARRAYCOPY_SHORT_SHORT_ARRAY_THRESHOLD = 32;
    public static final PrintStream err;
    public static final InputStream in;
    private static boolean justRanFinalization;
    private static String lineSeparator;
    public static final PrintStream out;
    private static boolean runGC;
    private static final Object LOCK = new Object();
    private static volatile Console cons = null;
    private static Properties unchangeableProps = initUnchangeableSystemProperties();
    private static Properties props = initProperties();

    @FastNative
    public static native void arraycopy(Object obj, int i10, Object obj2, int i11, int i12);

    @FastNative
    private static native void arraycopyBooleanUnchecked(boolean[] zArr, int i10, boolean[] zArr2, int i11, int i12);

    @FastNative
    private static native void arraycopyByteUnchecked(byte[] bArr, int i10, byte[] bArr2, int i11, int i12);

    @FastNative
    private static native void arraycopyCharUnchecked(char[] cArr, int i10, char[] cArr2, int i11, int i12);

    @FastNative
    private static native void arraycopyDoubleUnchecked(double[] dArr, int i10, double[] dArr2, int i11, int i12);

    @FastNative
    private static native void arraycopyFloatUnchecked(float[] fArr, int i10, float[] fArr2, int i11, int i12);

    @FastNative
    private static native void arraycopyIntUnchecked(int[] iArr, int i10, int[] iArr2, int i11, int i12);

    @FastNative
    private static native void arraycopyLongUnchecked(long[] jArr, int i10, long[] jArr2, int i11, int i12);

    @FastNative
    private static native void arraycopyShortUnchecked(short[] sArr, int i10, short[] sArr2, int i11, int i12);

    @CriticalNative
    public static native long currentTimeMillis();

    private static native void log(char c4, String str, Throwable th);

    public static native String mapLibraryName(String str);

    @CriticalNative
    public static native long nanoTime();

    private static native void setErr0(PrintStream printStream);

    private static native void setIn0(InputStream inputStream);

    private static native void setOut0(PrintStream printStream);

    private static native String[] specialProperties();

    private System() {
    }

    static {
        addLegacyLocaleSystemProperties();
        Version.initSystemProperties();
        lineSeparator = props.getProperty("line.separator");
        FileInputStream fdIn = new FileInputStream(FileDescriptor.in);
        FileOutputStream fdOut = new FileOutputStream(FileDescriptor.out);
        FileOutputStream fdErr = new FileOutputStream(FileDescriptor.err);
        in = new BufferedInputStream(fdIn, 128);
        out = newPrintStream(fdOut, props.getProperty("sun.stdout.encoding"));
        err = newPrintStream(fdErr, props.getProperty("sun.stderr.encoding"));
        VM.initializeOSEnvironment();
        VM.booted();
        jdk.internal.misc.VM.booted();
    }

    public static void setIn(InputStream in2) {
        setIn0(in2);
    }

    public static void setOut(PrintStream out2) {
        setOut0(out2);
    }

    public static void setErr(PrintStream err2) {
        setErr0(err2);
    }

    public static Console console() {
        if (cons == null) {
            synchronized (System.class) {
                if (cons == null) {
                    cons = Console.console();
                }
            }
        }
        return cons;
    }

    public static Channel inheritedChannel() throws IOException {
        return SelectorProvider.provider().inheritedChannel();
    }

    public static void setSecurityManager(SecurityManager s2) {
        if (s2 != null) {
            throw new SecurityException();
        }
    }

    public static SecurityManager getSecurityManager() {
        return null;
    }

    private static void arraycopy(char[] src, int srcPos, char[] dst, int dstPos, int length) {
        if (src == null) {
            throw new NullPointerException("src == null");
        }
        if (dst == null) {
            throw new NullPointerException("dst == null");
        }
        if (srcPos < 0 || dstPos < 0 || length < 0 || srcPos > src.length - length || dstPos > dst.length - length) {
            throw new ArrayIndexOutOfBoundsException("src.length=" + src.length + " srcPos=" + srcPos + " dst.length=" + dst.length + " dstPos=" + dstPos + " length=" + length);
        }
        if (length <= 32) {
            if (src == dst && srcPos < dstPos && dstPos < srcPos + length) {
                for (int i10 = length - 1; i10 >= 0; i10--) {
                    dst[dstPos + i10] = src[srcPos + i10];
                }
                return;
            }
            for (int i11 = 0; i11 < length; i11++) {
                dst[dstPos + i11] = src[srcPos + i11];
            }
            return;
        }
        arraycopyCharUnchecked(src, srcPos, dst, dstPos, length);
    }

    private static void arraycopy(byte[] src, int srcPos, byte[] dst, int dstPos, int length) {
        if (src == null) {
            throw new NullPointerException("src == null");
        }
        if (dst == null) {
            throw new NullPointerException("dst == null");
        }
        if (srcPos < 0 || dstPos < 0 || length < 0 || srcPos > src.length - length || dstPos > dst.length - length) {
            throw new ArrayIndexOutOfBoundsException("src.length=" + src.length + " srcPos=" + srcPos + " dst.length=" + dst.length + " dstPos=" + dstPos + " length=" + length);
        }
        if (length <= 32) {
            if (src == dst && srcPos < dstPos && dstPos < srcPos + length) {
                for (int i10 = length - 1; i10 >= 0; i10--) {
                    dst[dstPos + i10] = src[srcPos + i10];
                }
                return;
            }
            for (int i11 = 0; i11 < length; i11++) {
                dst[dstPos + i11] = src[srcPos + i11];
            }
            return;
        }
        arraycopyByteUnchecked(src, srcPos, dst, dstPos, length);
    }

    private static void arraycopy(short[] src, int srcPos, short[] dst, int dstPos, int length) {
        if (src == null) {
            throw new NullPointerException("src == null");
        }
        if (dst == null) {
            throw new NullPointerException("dst == null");
        }
        if (srcPos < 0 || dstPos < 0 || length < 0 || srcPos > src.length - length || dstPos > dst.length - length) {
            throw new ArrayIndexOutOfBoundsException("src.length=" + src.length + " srcPos=" + srcPos + " dst.length=" + dst.length + " dstPos=" + dstPos + " length=" + length);
        }
        if (length <= 32) {
            if (src == dst && srcPos < dstPos && dstPos < srcPos + length) {
                for (int i10 = length - 1; i10 >= 0; i10--) {
                    dst[dstPos + i10] = src[srcPos + i10];
                }
                return;
            }
            for (int i11 = 0; i11 < length; i11++) {
                dst[dstPos + i11] = src[srcPos + i11];
            }
            return;
        }
        arraycopyShortUnchecked(src, srcPos, dst, dstPos, length);
    }

    private static void arraycopy(int[] src, int srcPos, int[] dst, int dstPos, int length) {
        if (src == null) {
            throw new NullPointerException("src == null");
        }
        if (dst == null) {
            throw new NullPointerException("dst == null");
        }
        if (srcPos < 0 || dstPos < 0 || length < 0 || srcPos > src.length - length || dstPos > dst.length - length) {
            throw new ArrayIndexOutOfBoundsException("src.length=" + src.length + " srcPos=" + srcPos + " dst.length=" + dst.length + " dstPos=" + dstPos + " length=" + length);
        }
        if (length <= 32) {
            if (src == dst && srcPos < dstPos && dstPos < srcPos + length) {
                for (int i10 = length - 1; i10 >= 0; i10--) {
                    dst[dstPos + i10] = src[srcPos + i10];
                }
                return;
            }
            for (int i11 = 0; i11 < length; i11++) {
                dst[dstPos + i11] = src[srcPos + i11];
            }
            return;
        }
        arraycopyIntUnchecked(src, srcPos, dst, dstPos, length);
    }

    private static void arraycopy(long[] src, int srcPos, long[] dst, int dstPos, int length) {
        if (src == null) {
            throw new NullPointerException("src == null");
        }
        if (dst == null) {
            throw new NullPointerException("dst == null");
        }
        if (srcPos < 0 || dstPos < 0 || length < 0 || srcPos > src.length - length || dstPos > dst.length - length) {
            throw new ArrayIndexOutOfBoundsException("src.length=" + src.length + " srcPos=" + srcPos + " dst.length=" + dst.length + " dstPos=" + dstPos + " length=" + length);
        }
        if (length <= 32) {
            if (src == dst && srcPos < dstPos && dstPos < srcPos + length) {
                for (int i10 = length - 1; i10 >= 0; i10--) {
                    dst[dstPos + i10] = src[srcPos + i10];
                }
                return;
            }
            for (int i11 = 0; i11 < length; i11++) {
                dst[dstPos + i11] = src[srcPos + i11];
            }
            return;
        }
        arraycopyLongUnchecked(src, srcPos, dst, dstPos, length);
    }

    private static void arraycopy(float[] src, int srcPos, float[] dst, int dstPos, int length) {
        if (src == null) {
            throw new NullPointerException("src == null");
        }
        if (dst == null) {
            throw new NullPointerException("dst == null");
        }
        if (srcPos < 0 || dstPos < 0 || length < 0 || srcPos > src.length - length || dstPos > dst.length - length) {
            throw new ArrayIndexOutOfBoundsException("src.length=" + src.length + " srcPos=" + srcPos + " dst.length=" + dst.length + " dstPos=" + dstPos + " length=" + length);
        }
        if (length <= 32) {
            if (src == dst && srcPos < dstPos && dstPos < srcPos + length) {
                for (int i10 = length - 1; i10 >= 0; i10--) {
                    dst[dstPos + i10] = src[srcPos + i10];
                }
                return;
            }
            for (int i11 = 0; i11 < length; i11++) {
                dst[dstPos + i11] = src[srcPos + i11];
            }
            return;
        }
        arraycopyFloatUnchecked(src, srcPos, dst, dstPos, length);
    }

    private static void arraycopy(double[] src, int srcPos, double[] dst, int dstPos, int length) {
        if (src == null) {
            throw new NullPointerException("src == null");
        }
        if (dst == null) {
            throw new NullPointerException("dst == null");
        }
        if (srcPos < 0 || dstPos < 0 || length < 0 || srcPos > src.length - length || dstPos > dst.length - length) {
            throw new ArrayIndexOutOfBoundsException("src.length=" + src.length + " srcPos=" + srcPos + " dst.length=" + dst.length + " dstPos=" + dstPos + " length=" + length);
        }
        if (length <= 32) {
            if (src == dst && srcPos < dstPos && dstPos < srcPos + length) {
                for (int i10 = length - 1; i10 >= 0; i10--) {
                    dst[dstPos + i10] = src[srcPos + i10];
                }
                return;
            }
            for (int i11 = 0; i11 < length; i11++) {
                dst[dstPos + i11] = src[srcPos + i11];
            }
            return;
        }
        arraycopyDoubleUnchecked(src, srcPos, dst, dstPos, length);
    }

    private static void arraycopy(boolean[] src, int srcPos, boolean[] dst, int dstPos, int length) {
        if (src == null) {
            throw new NullPointerException("src == null");
        }
        if (dst == null) {
            throw new NullPointerException("dst == null");
        }
        if (srcPos < 0 || dstPos < 0 || length < 0 || srcPos > src.length - length || dstPos > dst.length - length) {
            throw new ArrayIndexOutOfBoundsException("src.length=" + src.length + " srcPos=" + srcPos + " dst.length=" + dst.length + " dstPos=" + dstPos + " length=" + length);
        }
        if (length <= 32) {
            if (src == dst && srcPos < dstPos && dstPos < srcPos + length) {
                for (int i10 = length - 1; i10 >= 0; i10--) {
                    dst[dstPos + i10] = src[srcPos + i10];
                }
                return;
            }
            for (int i11 = 0; i11 < length; i11++) {
                dst[dstPos + i11] = src[srcPos + i11];
            }
            return;
        }
        arraycopyBooleanUnchecked(src, srcPos, dst, dstPos, length);
    }

    public static int identityHashCode(Object x10) {
        if (x10 == null) {
            return 0;
        }
        return Object.identityHashCode(x10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class PropertiesWithNonOverrideableDefaults extends Properties {
        PropertiesWithNonOverrideableDefaults(Properties defaults) {
            super(defaults);
        }

        @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
        public Object put(Object key, Object value) {
            if (this.defaults.containsKey(key)) {
                System.logE("Ignoring attempt to set property \"" + key + "\" to value \"" + value + "\".");
                return this.defaults.get(key);
            }
            return super.put(key, value);
        }

        @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
        public Object remove(Object key) {
            if (this.defaults.containsKey(key)) {
                System.logE("Ignoring attempt to remove property \"" + key + "\".");
                return null;
            }
            return super.remove(key);
        }
    }

    private static void parsePropertyAssignments(Properties p10, String[] assignments) {
        for (String assignment : assignments) {
            int split = assignment.indexOf(61);
            String key = assignment.substring(0, split);
            String value = assignment.substring(split + 1);
            p10.put(key, value);
        }
    }

    private static Properties initUnchangeableSystemProperties() {
        String userName;
        VMRuntime runtime = VMRuntime.getRuntime();
        Properties p10 = new Properties();
        p10.put("java.boot.class.path", runtime.bootClassPath());
        p10.put("java.class.path", runtime.classPath());
        String javaHome = getenv("ANDROID_ART_ROOT");
        if (javaHome == null) {
            javaHome = "/apex/com.android.art";
        }
        p10.put("java.home", javaHome);
        p10.put("java.vm.version", runtime.vmVersion());
        try {
            userName = Libcore.os.getpwuid(Libcore.os.getuid()).pw_name;
        } catch (ErrnoException e2) {
            userName = "unknown";
        }
        p10.put("user.name", userName);
        StructUtsname info = Libcore.os.uname();
        p10.put("os.arch", info.machine);
        p10.put("os.name", info.sysname);
        p10.put("os.version", info.release);
        p10.put("android.icu.library.version", ICU.getIcuVersion());
        p10.put("android.icu.unicode.version", ICU.getUnicodeVersion());
        p10.put("android.icu.cldr.version", ICU.getCldrVersion());
        parsePropertyAssignments(p10, specialProperties());
        parsePropertyAssignments(p10, runtime.properties());
        for (String[] pair : AndroidHardcodedSystemProperties.STATIC_PROPERTIES) {
            if (p10.containsKey(pair[0])) {
                logE("Ignoring command line argument: -D" + pair[0]);
            }
            if (pair[1] != null) {
                p10.put(pair[0], pair[1]);
            } else {
                p10.remove(pair[0]);
            }
        }
        return p10;
    }

    private static Properties initProperties() {
        Properties p10 = new PropertiesWithNonOverrideableDefaults(unchangeableProps);
        setDefaultChangeableProperties(p10);
        return p10;
    }

    private static Properties setDefaultChangeableProperties(Properties p10) {
        if (!unchangeableProps.containsKey("java.io.tmpdir")) {
            p10.put("java.io.tmpdir", "/tmp");
        }
        if (!unchangeableProps.containsKey("user.home")) {
            p10.put("user.home", "");
        }
        return p10;
    }

    public static void setUnchangeableSystemProperty(String key, String value) {
        checkKey(key);
        unchangeableProps.put(key, value);
    }

    private static void addLegacyLocaleSystemProperties() {
        String locale = getProperty("user.locale", "");
        if (!locale.isEmpty()) {
            Locale l10 = Locale.forLanguageTag(locale);
            setUnchangeableSystemProperty("user.language", l10.getLanguage());
            setUnchangeableSystemProperty("user.region", l10.getCountry());
            setUnchangeableSystemProperty("user.variant", l10.getVariant());
            return;
        }
        String language = getProperty("user.language", "");
        String region = getProperty("user.region", "");
        if (language.isEmpty()) {
            setUnchangeableSystemProperty("user.language", "en");
        }
        if (region.isEmpty()) {
            setUnchangeableSystemProperty("user.region", "US");
        }
    }

    public static Properties getProperties() {
        SecurityManager sm = getSecurityManager();
        if (sm != null) {
            sm.checkPropertiesAccess();
        }
        return props;
    }

    public static String lineSeparator() {
        return lineSeparator;
    }

    public static void setProperties(Properties props2) {
        Properties baseProperties = new PropertiesWithNonOverrideableDefaults(unchangeableProps);
        if (props2 != null) {
            baseProperties.putAll(props2);
        } else {
            setDefaultChangeableProperties(baseProperties);
        }
        props = baseProperties;
    }

    public static String getProperty(String key) {
        checkKey(key);
        SecurityManager sm = getSecurityManager();
        if (sm != null) {
            sm.checkPropertyAccess(key);
        }
        return props.getProperty(key);
    }

    public static String getProperty(String key, String def) {
        checkKey(key);
        SecurityManager sm = getSecurityManager();
        if (sm != null) {
            sm.checkPropertyAccess(key);
        }
        return props.getProperty(key, def);
    }

    public static String setProperty(String key, String value) {
        checkKey(key);
        SecurityManager sm = getSecurityManager();
        if (sm != null) {
            sm.checkPermission(new PropertyPermission(key, "write"));
        }
        return (String) props.setProperty(key, value);
    }

    public static String clearProperty(String key) {
        checkKey(key);
        SecurityManager sm = getSecurityManager();
        if (sm != null) {
            sm.checkPermission(new PropertyPermission(key, "write"));
        }
        return (String) props.remove(key);
    }

    private static void checkKey(String key) {
        if (key == null) {
            throw new NullPointerException("key can't be null");
        }
        if (key.equals("")) {
            throw new IllegalArgumentException("key can't be empty");
        }
    }

    public static String getenv(String name) {
        if (name == null) {
            throw new NullPointerException("name == null");
        }
        return Libcore.os.getenv(name);
    }

    public static Map<String, String> getenv() {
        SecurityManager sm = getSecurityManager();
        if (sm != null) {
            sm.checkPermission(new RuntimePermission("getenv.*"));
        }
        return ProcessEnvironment.getenv();
    }

    public static void exit(int status) {
        Runtime.getRuntime().exit(status);
    }

    public static void gc() {
        boolean shouldRunGC;
        synchronized (LOCK) {
            shouldRunGC = justRanFinalization;
            if (shouldRunGC) {
                justRanFinalization = false;
            } else {
                runGC = true;
            }
        }
        if (shouldRunGC) {
            Runtime.getRuntime().gc();
        }
    }

    public static void runFinalization() {
        boolean shouldRunGC;
        Object obj = LOCK;
        synchronized (obj) {
            shouldRunGC = runGC;
            runGC = false;
        }
        if (shouldRunGC) {
            Runtime.getRuntime().gc();
        }
        Runtime.getRuntime().runFinalization();
        synchronized (obj) {
            justRanFinalization = true;
        }
    }

    @Deprecated
    public static void runFinalizersOnExit(boolean value) {
        Runtime.runFinalizersOnExit(value);
    }

    @CallerSensitive
    public static void load(String filename) {
        Runtime.getRuntime().load0(Reflection.getCallerClass(), filename);
    }

    @CallerSensitive
    public static void loadLibrary(String libname) {
        Runtime.getRuntime().loadLibrary0(Reflection.getCallerClass(), libname);
    }

    private static PrintStream newPrintStream(FileOutputStream fos, String enc) {
        if (enc != null) {
            try {
                return new PrintStream((OutputStream) new BufferedOutputStream(fos, 128), true, enc);
            } catch (UnsupportedEncodingException e2) {
            }
        }
        return new PrintStream((OutputStream) new BufferedOutputStream(fos, 128), true);
    }

    public static void logE(String message) {
        log('E', message, null);
    }

    public static void logE(String message, Throwable th) {
        log('E', message, th);
    }

    public static void logI(String message) {
        log('I', message, null);
    }

    public static void logI(String message, Throwable th) {
        log('I', message, th);
    }

    public static void logW(String message) {
        log('W', message, null);
    }

    public static void logW(String message, Throwable th) {
        log('W', message, th);
    }
}
