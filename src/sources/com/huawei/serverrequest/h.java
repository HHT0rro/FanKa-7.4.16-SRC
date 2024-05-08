package com.huawei.serverrequest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

/* compiled from: FileUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class h {
    public static boolean a(@NonNull String str, @NonNull String str2) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str), StandardCharsets.UTF_8.newEncoder()));
            try {
                bufferedWriter.write(str2);
                bufferedWriter.close();
                return true;
            } finally {
            }
        } catch (IOException unused) {
            return false;
        }
    }

    public static long b(@NonNull String str) {
        try {
            return new File(str).lastModified();
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Nullable
    public static String c(@NonNull String str) {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(str), StandardCharsets.UTF_8);
            try {
                StringWriter stringWriter = new StringWriter();
                try {
                    char[] cArr = new char[4096];
                    while (true) {
                        int read = inputStreamReader.read(cArr);
                        if (read != -1) {
                            stringWriter.write(cArr, 0, read);
                        } else {
                            String stringWriter2 = stringWriter.toString();
                            stringWriter.close();
                            inputStreamReader.close();
                            return stringWriter2;
                        }
                    }
                } finally {
                }
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public static boolean a(@NonNull String str) {
        return a(new File(str));
    }

    private static boolean a(@NonNull File file) {
        File[] listFiles;
        if (!file.exists()) {
            return true;
        }
        if (!file.isFile() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                a(file2);
            }
        }
        return file.delete();
    }
}
