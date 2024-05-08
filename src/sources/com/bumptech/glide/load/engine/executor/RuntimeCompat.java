package com.bumptech.glide.load.engine.executor;

import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class RuntimeCompat {
    private static final String CPU_LOCATION = "/sys/devices/system/cpu/";
    private static final String CPU_NAME_REGEX = "cpu[0-9]+";
    private static final String TAG = "GlideRuntimeCompat";

    private RuntimeCompat() {
    }

    public static int availableProcessors() {
        return Runtime.getRuntime().availableProcessors();
    }

    private static int getCoreCountPre17() {
        File[] fileArr;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                File file = new File(CPU_LOCATION);
                final Pattern compile = Pattern.compile(CPU_NAME_REGEX);
                fileArr = file.listFiles(new FilenameFilter() { // from class: com.bumptech.glide.load.engine.executor.RuntimeCompat.1
                    @Override // java.io.FilenameFilter
                    public boolean accept(File file2, String str) {
                        return Pattern.this.matcher(str).matches();
                    }
                });
            } catch (Throwable unused) {
                Log.isLoggable(TAG, 6);
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                fileArr = null;
            }
            return Math.max(1, fileArr != null ? fileArr.length : 0);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }
}
