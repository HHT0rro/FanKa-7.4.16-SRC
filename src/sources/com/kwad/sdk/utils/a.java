package com.kwad.sdk.utils;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    @Nullable
    @WorkerThread
    public static String getFileMD5(File file) {
        try {
            byte[] fileMD5Digest = getFileMD5Digest(file);
            if (fileMD5Digest != null && fileMD5Digest.length != 0) {
                return ad.toHexString(fileMD5Digest, 0, fileMD5Digest.length);
            }
            return null;
        } catch (IOException e2) {
            com.kwad.sdk.core.e.c.e("FileMD5Utils", "cannot calculate md5 of file", e2);
            return null;
        }
    }

    @Nullable
    @WorkerThread
    public static byte[] getFileMD5Digest(File file) {
        if (file == null) {
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[4096];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    return messageDigest.digest();
                }
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.e("FileMD5Utils", "getting file md5 digest error.", e2);
            return null;
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
        }
    }

    @Nullable
    @WorkerThread
    public static byte[] gp(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return getFileMD5Digest(new File(str));
    }
}
