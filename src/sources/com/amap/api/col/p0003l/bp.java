package com.amap.api.col.p0003l;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: FileCopy.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class bp {

    /* compiled from: FileCopy.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface a {
        void a();

        void a(float f10);

        void b();
    }

    private static float a(long j10, long j11) {
        return (((float) j10) / ((float) j11)) * 100.0f;
    }

    public final long a(File file, File file2, long j10, long j11, a aVar) {
        long j12;
        if (j10 == 0) {
            if (aVar != null) {
                aVar.b();
            }
            return 0L;
        }
        file.getAbsolutePath();
        file2.getAbsolutePath();
        try {
            if (file.isDirectory()) {
                if (!file2.exists() && !file2.mkdirs()) {
                    throw new IOException("Cannot create dir " + file2.getAbsolutePath());
                }
                String[] list = file.list();
                j12 = j10;
                if (list == null) {
                    return j12;
                }
                int i10 = 0;
                while (i10 < list.length) {
                    try {
                        int i11 = i10;
                        j12 = a(new File(file, list[i10]), new File(new File(file2, file.getName()), list[i10]), j12, j11, aVar);
                        i10 = i11 + 1;
                    } catch (Exception e2) {
                        e = e2;
                    }
                }
                return j12;
            }
            File parentFile = file2.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                throw new IOException("Cannot create dir " + parentFile.getAbsolutePath());
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[1024];
            long j13 = j10;
            while (true) {
                try {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                    j13 += read;
                    if (aVar != null) {
                        aVar.a(a(j13, j11));
                    }
                } catch (Exception e10) {
                    e = e10;
                    j12 = j13;
                }
            }
            fileInputStream.close();
            fileOutputStream.flush();
            fileOutputStream.close();
            if (aVar != null && j13 >= j11 - 1) {
                aVar.a();
            }
            return j13;
        } catch (Exception e11) {
            e = e11;
            j12 = j10;
        }
        e.printStackTrace();
        if (aVar == null) {
            return j12;
        }
        aVar.b();
        return j12;
    }
}
