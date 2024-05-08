package sun.misc;

import java.io.PrintStream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Version {
    private static final String java_profile_name = "";
    private static final String java_runtime_name = "Android Runtime";
    private static final String java_runtime_version = "0.9";
    private static final String java_version = "0";
    private static boolean jvmVersionInfoAvailable = false;
    private static final String launcher_name = "";
    private static boolean versionsInitialized = false;
    private static int jvm_major_version = 0;
    private static int jvm_minor_version = 0;
    private static int jvm_micro_version = 0;
    private static int jvm_update_version = 0;
    private static int jvm_build_number = 0;
    private static String jvm_special_version = null;
    private static int jdk_major_version = 0;
    private static int jdk_minor_version = 0;
    private static int jdk_micro_version = 0;
    private static int jdk_update_version = 0;
    private static int jdk_build_number = 0;
    private static String jdk_special_version = null;

    public static native String getJdkSpecialVersion();

    private static native void getJdkVersionInfo();

    public static native String getJvmSpecialVersion();

    private static native boolean getJvmVersionInfo();

    public static void initSystemProperties() {
        System.setUnchangeableSystemProperty("java.version", "0");
        System.setUnchangeableSystemProperty("java.runtime.version", java_runtime_version);
        System.setUnchangeableSystemProperty("java.runtime.name", java_runtime_name);
    }

    public static void print() {
        print(System.err);
    }

    public static void println() {
        print(System.err);
        System.err.println();
    }

    public static void print(PrintStream ps) {
        boolean isHeadless = false;
        String headless = System.getProperty("java.awt.headless");
        if (headless != null && headless.equalsIgnoreCase("true")) {
            isHeadless = true;
        }
        ps.println(" version \"0\"");
        ps.print("Android Runtime (build 0.9");
        if ("".length() > 0) {
            ps.print(", profile ");
        }
        if (java_runtime_name.indexOf("Embedded") != -1 && isHeadless) {
            ps.print(", headless");
        }
        ps.println(')');
        String java_vm_name = System.getProperty("java.vm.name");
        String java_vm_version = System.getProperty("java.vm.version");
        String java_vm_info = System.getProperty("java.vm.info");
        ps.println(java_vm_name + " (build " + java_vm_version + ", " + java_vm_info + ")");
    }

    public static synchronized int jvmMajorVersion() {
        int i10;
        synchronized (Version.class) {
            if (!versionsInitialized) {
                initVersions();
            }
            i10 = jvm_major_version;
        }
        return i10;
    }

    public static synchronized int jvmMinorVersion() {
        int i10;
        synchronized (Version.class) {
            if (!versionsInitialized) {
                initVersions();
            }
            i10 = jvm_minor_version;
        }
        return i10;
    }

    public static synchronized int jvmMicroVersion() {
        int i10;
        synchronized (Version.class) {
            if (!versionsInitialized) {
                initVersions();
            }
            i10 = jvm_micro_version;
        }
        return i10;
    }

    public static synchronized int jvmUpdateVersion() {
        int i10;
        synchronized (Version.class) {
            if (!versionsInitialized) {
                initVersions();
            }
            i10 = jvm_update_version;
        }
        return i10;
    }

    public static synchronized String jvmSpecialVersion() {
        String str;
        synchronized (Version.class) {
            if (!versionsInitialized) {
                initVersions();
            }
            if (jvm_special_version == null) {
                jvm_special_version = getJvmSpecialVersion();
            }
            str = jvm_special_version;
        }
        return str;
    }

    public static synchronized int jvmBuildNumber() {
        int i10;
        synchronized (Version.class) {
            if (!versionsInitialized) {
                initVersions();
            }
            i10 = jvm_build_number;
        }
        return i10;
    }

    public static synchronized int jdkMajorVersion() {
        int i10;
        synchronized (Version.class) {
            if (!versionsInitialized) {
                initVersions();
            }
            i10 = jdk_major_version;
        }
        return i10;
    }

    public static synchronized int jdkMinorVersion() {
        int i10;
        synchronized (Version.class) {
            if (!versionsInitialized) {
                initVersions();
            }
            i10 = jdk_minor_version;
        }
        return i10;
    }

    public static synchronized int jdkMicroVersion() {
        int i10;
        synchronized (Version.class) {
            if (!versionsInitialized) {
                initVersions();
            }
            i10 = jdk_micro_version;
        }
        return i10;
    }

    public static synchronized int jdkUpdateVersion() {
        int i10;
        synchronized (Version.class) {
            if (!versionsInitialized) {
                initVersions();
            }
            i10 = jdk_update_version;
        }
        return i10;
    }

    public static synchronized String jdkSpecialVersion() {
        String str;
        synchronized (Version.class) {
            if (!versionsInitialized) {
                initVersions();
            }
            if (jdk_special_version == null) {
                jdk_special_version = getJdkSpecialVersion();
            }
            str = jdk_special_version;
        }
        return str;
    }

    public static synchronized int jdkBuildNumber() {
        int i10;
        synchronized (Version.class) {
            if (!versionsInitialized) {
                initVersions();
            }
            i10 = jdk_build_number;
        }
        return i10;
    }

    private static synchronized void initVersions() {
        char c4;
        synchronized (Version.class) {
            if (versionsInitialized) {
                return;
            }
            boolean jvmVersionInfo = getJvmVersionInfo();
            jvmVersionInfoAvailable = jvmVersionInfo;
            if (!jvmVersionInfo) {
                CharSequence cs = System.getProperty("java.vm.version");
                if (cs.length() >= 5 && Character.isDigit(cs.charAt(0)) && cs.charAt(1) == '.' && Character.isDigit(cs.charAt(2)) && cs.charAt(3) == '.' && Character.isDigit(cs.charAt(4))) {
                    jvm_major_version = Character.digit(cs.charAt(0), 10);
                    jvm_minor_version = Character.digit(cs.charAt(2), 10);
                    jvm_micro_version = Character.digit(cs.charAt(4), 10);
                    CharSequence cs2 = cs.subSequence(5, cs.length());
                    if (cs2.charAt(0) == '_' && cs2.length() >= 3) {
                        int nextChar = 0;
                        if (Character.isDigit(cs2.charAt(1)) && Character.isDigit(cs2.charAt(2)) && Character.isDigit(cs2.charAt(3))) {
                            nextChar = 4;
                        } else if (Character.isDigit(cs2.charAt(1)) && Character.isDigit(cs2.charAt(2))) {
                            nextChar = 3;
                        }
                        try {
                            String uu = cs2.subSequence(1, nextChar).toString();
                            jvm_update_version = Integer.valueOf(uu).intValue();
                            if (cs2.length() >= nextChar + 1 && (c4 = cs2.charAt(nextChar)) >= 'a' && c4 <= 'z') {
                                jvm_special_version = Character.toString(c4);
                                nextChar++;
                            }
                            cs2 = cs2.subSequence(nextChar, cs2.length());
                        } catch (NumberFormatException e2) {
                            return;
                        }
                    }
                    if (cs2.charAt(0) == 45) {
                        String[] res = cs2.subSequence(1, cs2.length()).toString().split("-");
                        int length = res.length;
                        int i10 = 0;
                        while (true) {
                            if (i10 >= length) {
                                break;
                            }
                            String s2 = res[i10];
                            if (s2.charAt(0) != 'b' || s2.length() != 3 || !Character.isDigit(s2.charAt(1)) || !Character.isDigit(s2.charAt(2))) {
                                i10++;
                            } else {
                                jvm_build_number = Integer.valueOf(s2.substring(1, 3)).intValue();
                                break;
                            }
                        }
                    }
                }
            }
            getJdkVersionInfo();
            versionsInitialized = true;
        }
    }
}
