package com.bytedance.pangle.util.b;

import com.bytedance.pangle.util.b.b.d;
import com.bytedance.pangle.util.g;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.zip.ZipException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final d f10971a;

    /* renamed from: b, reason: collision with root package name */
    public final com.bytedance.pangle.util.b.a.b f10972b = new com.bytedance.pangle.util.b.a.b();

    public a(d dVar) {
        this.f10971a = dVar;
    }

    public static void a(File file) {
        if (file.exists() && !file.delete()) {
            throw new ZipException("Could not delete temporary file");
        }
    }

    public static void a(RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2, long j10, long j11, String str) {
        g.a(randomAccessFile, randomAccessFile2, j10, j10 + j11, str);
    }
}
