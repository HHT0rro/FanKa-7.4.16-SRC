package org.apache.commons.io;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class FileSystemUtils {
    private static final String DF;
    private static final int INIT_PROBLEM = -1;
    private static final FileSystemUtils INSTANCE = new FileSystemUtils();
    private static final int OS;
    private static final int OTHER = 0;
    private static final int POSIX_UNIX = 3;
    private static final int UNIX = 2;
    private static final int WINDOWS = 1;

    static {
        String property;
        String str = "df";
        int i10 = -1;
        try {
            property = System.getProperty("os.name");
        } catch (Exception unused) {
        }
        if (property != null) {
            String lowerCase = property.toLowerCase(Locale.ENGLISH);
            if (lowerCase.indexOf("windows") != -1) {
                i10 = 1;
            } else {
                if (lowerCase.indexOf("linux") == -1 && lowerCase.indexOf("mpe/ix") == -1 && lowerCase.indexOf("freebsd") == -1 && lowerCase.indexOf("irix") == -1 && lowerCase.indexOf("digital unix") == -1 && lowerCase.indexOf("unix") == -1 && lowerCase.indexOf("mac os x") == -1) {
                    if (lowerCase.indexOf("sun os") == -1 && lowerCase.indexOf("sunos") == -1 && lowerCase.indexOf("solaris") == -1) {
                        if (lowerCase.indexOf("hp-ux") == -1 && lowerCase.indexOf("aix") == -1) {
                            i10 = 0;
                        }
                        i10 = 3;
                    }
                    str = "/usr/xpg4/bin/df";
                    i10 = 3;
                }
                i10 = 2;
            }
            OS = i10;
            DF = str;
            return;
        }
        throw new IOException("os.name not found");
    }

    @Deprecated
    public static long freeSpace(String str) throws IOException {
        return INSTANCE.freeSpaceOS(str, OS, false, -1L);
    }

    public static long freeSpaceKb(String str) throws IOException {
        return freeSpaceKb(str, -1L);
    }

    public long freeSpaceOS(String str, int i10, boolean z10, long j10) throws IOException {
        if (str == null) {
            throw new IllegalArgumentException("Path must not be empty");
        }
        if (i10 == 0) {
            throw new IllegalStateException("Unsupported operating system");
        }
        if (i10 == 1) {
            long freeSpaceWindows = freeSpaceWindows(str, j10);
            return z10 ? freeSpaceWindows / 1024 : freeSpaceWindows;
        }
        if (i10 == 2) {
            return freeSpaceUnix(str, z10, false, j10);
        }
        if (i10 == 3) {
            return freeSpaceUnix(str, z10, true, j10);
        }
        throw new IllegalStateException("Exception caught when determining operating system");
    }

    public long freeSpaceUnix(String str, boolean z10, boolean z11, long j10) throws IOException {
        if (str.length() != 0) {
            String str2 = "-";
            if (z10) {
                str2 = "-k";
            }
            if (z11) {
                str2 = str2 + "P";
            }
            List<String> performCommand = performCommand(str2.length() > 1 ? new String[]{DF, str2, str} : new String[]{DF, str}, 3, j10);
            if (performCommand.size() >= 2) {
                StringTokenizer stringTokenizer = new StringTokenizer(performCommand.get(1), " ");
                if (stringTokenizer.countTokens() < 4) {
                    if (stringTokenizer.countTokens() == 1 && performCommand.size() >= 3) {
                        stringTokenizer = new StringTokenizer(performCommand.get(2), " ");
                    } else {
                        throw new IOException("Command line '" + DF + "' did not return data as expected for path '" + str + "'- check path is valid");
                    }
                } else {
                    stringTokenizer.nextToken();
                }
                stringTokenizer.nextToken();
                stringTokenizer.nextToken();
                return parseBytes(stringTokenizer.nextToken(), str);
            }
            throw new IOException("Command line '" + DF + "' did not return info as expected for path '" + str + "'- response was " + ((Object) performCommand));
        }
        throw new IllegalArgumentException("Path must not be empty");
    }

    public long freeSpaceWindows(String str, long j10) throws IOException {
        String normalize = FilenameUtils.normalize(str, false);
        if (normalize.length() > 0 && normalize.charAt(0) != '\"') {
            normalize = "\"" + normalize + "\"";
        }
        List<String> performCommand = performCommand(new String[]{"cmd.exe", "/C", "dir /a /-c " + normalize}, Integer.MAX_VALUE, j10);
        for (int size = performCommand.size() - 1; size >= 0; size--) {
            String str2 = performCommand.get(size);
            if (str2.length() > 0) {
                return parseDir(str2, normalize);
            }
        }
        throw new IOException("Command line 'dir /-c' did not return any info for path '" + normalize + "'");
    }

    public Process openProcess(String[] strArr) throws IOException {
        return Runtime.getRuntime().exec(strArr);
    }

    public long parseBytes(String str, String str2) throws IOException {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong >= 0) {
                return parseLong;
            }
            throw new IOException("Command line '" + DF + "' did not find free space in response for path '" + str2 + "'- check path is valid");
        } catch (NumberFormatException e2) {
            throw new IOExceptionWithCause("Command line '" + DF + "' did not return numeric data as expected for path '" + str2 + "'- check path is valid", e2);
        }
    }

    public long parseDir(String str, String str2) throws IOException {
        int i10;
        int i11;
        int i12;
        int length = str.length();
        while (true) {
            length--;
            i10 = 0;
            if (length < 0) {
                i11 = 0;
                break;
            }
            if (Character.isDigit(str.charAt(length))) {
                i11 = length + 1;
                break;
            }
        }
        while (true) {
            if (length < 0) {
                i12 = 0;
                break;
            }
            char charAt = str.charAt(length);
            if (!Character.isDigit(charAt) && charAt != ',' && charAt != '.') {
                i12 = length + 1;
                break;
            }
            length--;
        }
        if (length >= 0) {
            StringBuilder sb2 = new StringBuilder(str.substring(i12, i11));
            while (i10 < sb2.length()) {
                if (sb2.charAt(i10) == ',' || sb2.charAt(i10) == '.') {
                    sb2.deleteCharAt(i10);
                    i10--;
                }
                i10++;
            }
            return parseBytes(sb2.toString(), str2);
        }
        throw new IOException("Command line 'dir /-c' did not return valid info for path '" + str2 + "'");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x010b  */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.io.BufferedReader, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<java.lang.String> performCommand(java.lang.String[] r10, int r11, long r12) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 271
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.FileSystemUtils.performCommand(java.lang.String[], int, long):java.util.List");
    }

    public static long freeSpaceKb(String str, long j10) throws IOException {
        return INSTANCE.freeSpaceOS(str, OS, true, j10);
    }

    public static long freeSpaceKb() throws IOException {
        return freeSpaceKb(-1L);
    }

    public static long freeSpaceKb(long j10) throws IOException {
        return freeSpaceKb(new File(".").getAbsolutePath(), j10);
    }
}
