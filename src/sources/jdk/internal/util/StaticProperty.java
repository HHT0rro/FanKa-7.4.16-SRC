package jdk.internal.util;

import java.util.Properties;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class StaticProperty {
    private static final String JAVA_HOME;
    private static final String JAVA_IO_TMPDIR;
    private static final String JAVA_LIBRARY_PATH;
    private static final String USER_DIR;
    private static final String USER_HOME;
    private static final String USER_NAME;

    private StaticProperty() {
    }

    static {
        Properties props = System.getProperties();
        JAVA_HOME = getProperty(props, "java.home");
        USER_HOME = getProperty(props, "user.home");
        USER_DIR = getProperty(props, "user.dir");
        USER_NAME = getProperty(props, "user.name");
        JAVA_IO_TMPDIR = getProperty(props, "java.io.tmpdir");
        JAVA_LIBRARY_PATH = getProperty(props, "java.library.path", "");
    }

    private static String getProperty(Properties props, String key) {
        String v2 = props.getProperty(key);
        if (v2 == null) {
            throw new InternalError("null property: " + key);
        }
        return v2;
    }

    private static String getProperty(Properties props, String key, String defaultVal) {
        String v2 = props.getProperty(key);
        return v2 == null ? defaultVal : v2;
    }

    public static String javaHome() {
        return JAVA_HOME;
    }

    public static String userHome() {
        return USER_HOME;
    }

    public static String userDir() {
        return USER_DIR;
    }

    public static String userName() {
        return USER_NAME;
    }

    public static String javaLibraryPath() {
        return JAVA_LIBRARY_PATH;
    }

    public static String javaIoTmpDir() {
        return JAVA_IO_TMPDIR;
    }
}
