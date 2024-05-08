package com.tencent.open.utils;

import com.kuaishou.weapon.p0.t;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Properties;
import java.util.zip.ZipConstants;
import java.util.zip.ZipException;

/* compiled from: ProGuard */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final m f45282a = new m(ZipConstants.ENDSIG);

    /* renamed from: b, reason: collision with root package name */
    private static final n f45283b = new n(38651);

    /* compiled from: ProGuard */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public Properties f45284a;

        /* renamed from: b, reason: collision with root package name */
        public byte[] f45285b;

        private a() {
            this.f45284a = new Properties();
        }

        public void a(byte[] bArr) throws IOException {
            if (bArr == null) {
                return;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int length = b.f45283b.a().length;
            byte[] bArr2 = new byte[length];
            wrap.get(bArr2);
            if (b.f45283b.equals(new n(bArr2))) {
                if (bArr.length - length <= 2) {
                    return;
                }
                byte[] bArr3 = new byte[2];
                wrap.get(bArr3);
                int b4 = new n(bArr3).b();
                if ((bArr.length - length) - 2 < b4) {
                    return;
                }
                byte[] bArr4 = new byte[b4];
                wrap.get(bArr4);
                this.f45284a.load(new ByteArrayInputStream(bArr4));
                int length2 = ((bArr.length - length) - b4) - 2;
                if (length2 > 0) {
                    byte[] bArr5 = new byte[length2];
                    this.f45285b = bArr5;
                    wrap.get(bArr5);
                    return;
                }
                return;
            }
            throw new ProtocolException("unknow protocl [" + Arrays.toString(bArr) + "]");
        }

        public String toString() {
            return "ApkExternalInfo [p=" + ((Object) this.f45284a) + ", otherData=" + Arrays.toString(this.f45285b) + "]";
        }
    }

    public static String a(File file, String str) throws IOException {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        byte b4 = 0;
        try {
            randomAccessFile = new RandomAccessFile(file, t.f36226k);
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] a10 = a(randomAccessFile);
            if (a10 == null) {
                randomAccessFile.close();
                return null;
            }
            a aVar = new a();
            aVar.a(a10);
            String property = aVar.f45284a.getProperty(str);
            randomAccessFile.close();
            return property;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            throw th;
        }
    }

    public static String a(File file) throws IOException {
        return a(file, "channelNo");
    }

    private static byte[] a(RandomAccessFile randomAccessFile) throws IOException {
        boolean z10;
        long length = randomAccessFile.length() - 22;
        randomAccessFile.seek(length);
        byte[] a10 = f45282a.a();
        int read = randomAccessFile.read();
        while (true) {
            z10 = true;
            if (read == -1) {
                z10 = false;
                break;
            }
            if (read == a10[0] && randomAccessFile.read() == a10[1] && randomAccessFile.read() == a10[2] && randomAccessFile.read() == a10[3]) {
                break;
            }
            length--;
            randomAccessFile.seek(length);
            read = randomAccessFile.read();
        }
        if (z10) {
            randomAccessFile.seek(length + 16 + 4);
            byte[] bArr = new byte[2];
            randomAccessFile.readFully(bArr);
            int b4 = new n(bArr).b();
            if (b4 == 0) {
                return null;
            }
            byte[] bArr2 = new byte[b4];
            randomAccessFile.read(bArr2);
            return bArr2;
        }
        throw new ZipException("archive is not a ZIP archive");
    }
}
