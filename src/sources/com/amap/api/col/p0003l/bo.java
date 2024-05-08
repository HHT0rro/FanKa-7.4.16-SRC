package com.amap.api.col.p0003l;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: FileAccessI.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
final class bo {

    /* renamed from: a, reason: collision with root package name */
    public RandomAccessFile f5149a;

    public bo() throws IOException {
        this("", 0L);
    }

    public final synchronized int a(byte[] bArr) throws IOException {
        this.f5149a.write(bArr);
        return bArr.length;
    }

    public bo(String str, long j10) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
            } catch (IOException e2) {
                gy.b(e2, "FileAccessI", "create");
                e2.printStackTrace();
            }
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rw");
        this.f5149a = randomAccessFile;
        randomAccessFile.seek(j10);
    }

    public final void a() {
        RandomAccessFile randomAccessFile = this.f5149a;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.f5149a = null;
        }
    }
}
