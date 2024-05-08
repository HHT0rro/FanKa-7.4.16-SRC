package com.ss.android.downloadlib.hc;

import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class hc {
    public static long m(File file) {
        if (file == null || !file.exists()) {
            return 0L;
        }
        return m(file, file.lastModified(), 0);
    }

    private static long m(File file, long j10, int i10) {
        File[] listFiles;
        if (file != null && file.exists()) {
            j10 = Math.max(j10, file.lastModified());
            int i11 = i10 + 1;
            if (i11 >= 50) {
                return j10;
            }
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    j10 = Math.max(j10, m(file2, j10, i11));
                }
            }
        }
        return j10;
    }
}
