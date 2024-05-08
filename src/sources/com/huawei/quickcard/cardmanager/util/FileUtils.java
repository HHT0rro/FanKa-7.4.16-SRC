package com.huawei.quickcard.cardmanager.util;

import androidx.annotation.NonNull;
import com.huawei.quickcard.cardmanager.log.ManagerLogUtil;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class FileUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33568a = "FileUtils";

    private static FileOutputStream a(@NonNull File file, boolean z10) throws IOException {
        if (!file.isDirectory() && file.canWrite()) {
            return new FileOutputStream(file, z10);
        }
        throw new IOException("\"" + ((Object) file) + "\" may be directory or can not be written");
    }

    private static FileOutputStream b(@NonNull File file, boolean z10) throws IOException {
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.isDirectory() && !parentFile.mkdirs()) {
            throw new IOException("\"" + ((Object) parentFile) + "\" can not be created");
        }
        return new FileOutputStream(file, z10);
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                ManagerLogUtil.e("FileUtils", "An exception occurred while closing the 'Closeable' object.");
            }
        }
    }

    public static FileInputStream openInputStream(@NonNull File file) throws IOException, FileNotFoundException {
        if (file.exists()) {
            if (!file.isDirectory() && file.canRead()) {
                return new FileInputStream(file);
            }
            throw new IOException("\"" + ((Object) file) + "\" is a directory or can not be read");
        }
        throw new FileNotFoundException("\"" + ((Object) file) + "\" is not exist");
    }

    public static FileOutputStream openOutputStream(@NonNull File file, boolean z10) throws IOException {
        if (file.exists()) {
            return a(file, z10);
        }
        return b(file, z10);
    }
}
