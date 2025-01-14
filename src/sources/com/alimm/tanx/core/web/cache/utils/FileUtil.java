package com.alimm.tanx.core.web.cache.utils;

import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class FileUtil {
    public static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[512];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                inputStream.close();
                outputStream.close();
                return;
            }
        }
    }

    public static void deleteDirs(String str, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    deleteDirs(file2.getAbsolutePath(), z10);
                } else {
                    file2.delete();
                }
            }
            if (z10) {
                file.delete();
            }
        }
    }
}
