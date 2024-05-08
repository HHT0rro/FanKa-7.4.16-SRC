package com.taobao.dp.util;

import com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
public class ZipUtils {
    public static byte[] unZip(byte[] bArr) {
        byte[] bArr2 = null;
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ZipInputStream zipInputStream = new ZipInputStream(byteArrayInputStream);
            while (zipInputStream.getNextEntry() != null) {
                byte[] bArr3 = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = zipInputStream.read(bArr3, 0, bArr3.length);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr3, 0, read);
                    }
                }
                bArr2 = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
            }
            zipInputStream.close();
            byteArrayInputStream.close();
        } catch (Exception unused) {
        }
        return bArr2;
    }

    public static byte[] zip(byte[] bArr) {
        byte[] bArr2 = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
            ZipEntry zipEntry = new ZipEntry(SplashAdCacheManager.SPLASH_AD_ZIP_PATH);
            zipEntry.setSize(bArr.length);
            zipOutputStream.putNextEntry(zipEntry);
            zipOutputStream.write(bArr);
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            bArr2 = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return bArr2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return bArr2;
        }
    }
}