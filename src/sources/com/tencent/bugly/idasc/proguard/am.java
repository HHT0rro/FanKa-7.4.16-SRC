package com.tencent.bugly.idasc.proguard;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class am {
    public static long a(String str, String str2, String str3) {
        if (str == null) {
            al.d("File name is null.", new Object[0]);
            return -1L;
        }
        try {
            if (str.startsWith(str2) && str.endsWith(str3)) {
                return Long.parseLong(str.substring(str2.length(), str.indexOf(str3)));
            }
        } catch (Throwable th) {
            al.a(th);
        }
        return -1L;
    }

    private static List<File> a(File[] fileArr, String str, String str2, long j10) {
        ArrayList arrayList = new ArrayList();
        for (File file : fileArr) {
            long a10 = a(file.getName(), str, str2);
            if (a10 >= 0 && 0 <= a10 && a10 <= j10) {
                arrayList.add(file);
            }
        }
        return arrayList;
    }

    public static void a(String str, String str2, String str3, long j10) {
        try {
            int i10 = 0;
            for (File file : b(str, str2, str3, j10)) {
                al.c("File %s is to be deleted.", file.getName());
                if (file.delete()) {
                    i10++;
                }
            }
            al.c("Number of overdue trace files that has deleted: ".concat(String.valueOf(i10)), new Object[0]);
        } catch (Throwable th) {
            al.a(th);
        }
    }

    public static boolean a(File file, String str, long j10, boolean z10) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, z10));
            boolean a10 = a(bufferedWriter, str.toCharArray(), str.length(), file.length(), j10);
            bufferedWriter.close();
            return a10;
        } catch (Throwable th) {
            al.a(th);
            return false;
        }
    }

    private static boolean a(Writer writer, char[] cArr, int i10, long j10, long j11) {
        if (j10 >= j11) {
            return false;
        }
        try {
            if ((i10 * 2) + j10 <= j11) {
                writer.write(cArr, 0, i10);
            } else {
                writer.write(cArr, 0, (int) ((j11 - j10) / 2));
            }
            writer.flush();
            return true;
        } catch (IOException e2) {
            al.a(e2);
            return false;
        }
    }

    public static boolean a(String str, String str2, int i10) {
        boolean z10 = true;
        al.c("rqdp{  sv sd start} %s", str);
        if (str2 != null && str2.trim().length() > 0) {
            File file = new File(str);
            try {
                if (!file.exists()) {
                    if (file.getParentFile() != null) {
                        file.getParentFile().mkdirs();
                    }
                    file.createNewFile();
                }
                long j10 = i10;
                if (file.length() >= j10) {
                    z10 = false;
                }
                return a(file, str2, j10, z10);
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }

    private static List<File> b(String str, final String str2, final String str3, long j10) {
        ArrayList arrayList = new ArrayList();
        if (str2 == null || str3 == null) {
            al.d("prefix %s and/or postfix %s is null.", str2, str3);
            return arrayList;
        }
        long currentTimeMillis = System.currentTimeMillis();
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return arrayList;
        }
        try {
            File[] listFiles = file.listFiles(new FilenameFilter() { // from class: com.tencent.bugly.idasc.proguard.am.1
                @Override // java.io.FilenameFilter
                public final boolean accept(File file2, String str4) {
                    return str4 != null && str4.startsWith(String.this) && str4.endsWith(str3);
                }
            });
            if (listFiles != null && listFiles.length != 0) {
                return a(listFiles, str2, str3, currentTimeMillis - j10);
            }
            return arrayList;
        } catch (Throwable th) {
            al.a(th);
            return arrayList;
        }
    }
}
