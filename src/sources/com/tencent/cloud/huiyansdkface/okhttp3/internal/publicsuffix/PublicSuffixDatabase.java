package com.tencent.cloud.huiyansdkface.okhttp3.internal.publicsuffix;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform;
import com.tencent.cloud.huiyansdkface.okio.BufferedSource;
import com.tencent.cloud.huiyansdkface.okio.GzipSource;
import com.tencent.cloud.huiyansdkface.okio.Okio;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class PublicSuffixDatabase {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f42005a = {ExifInterface.START_CODE};

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f42006b = new String[0];

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f42007c = {StringUtils.NO_PRINT_CODE};

    /* renamed from: d, reason: collision with root package name */
    private static final PublicSuffixDatabase f42008d = new PublicSuffixDatabase();

    /* renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f42009e = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name */
    private final CountDownLatch f42010f = new CountDownLatch(1);

    /* renamed from: g, reason: collision with root package name */
    private byte[] f42011g;

    /* renamed from: h, reason: collision with root package name */
    private byte[] f42012h;

    private static String a(byte[] bArr, byte[][] bArr2, int i10) {
        int i11;
        boolean z10;
        int i12;
        int i13;
        int length = bArr.length;
        int i14 = 0;
        while (i14 < length) {
            int i15 = (i14 + length) / 2;
            while (i15 > -1 && bArr[i15] != 10) {
                i15--;
            }
            int i16 = i15 + 1;
            int i17 = 1;
            while (true) {
                i11 = i16 + i17;
                if (bArr[i11] == 10) {
                    break;
                }
                i17++;
            }
            int i18 = i11 - i16;
            int i19 = i10;
            boolean z11 = false;
            int i20 = 0;
            int i21 = 0;
            while (true) {
                if (z11) {
                    i12 = 46;
                    z10 = false;
                } else {
                    z10 = z11;
                    i12 = bArr2[i19][i20] & 255;
                }
                i13 = i12 - (bArr[i16 + i21] & 255);
                if (i13 == 0) {
                    i21++;
                    i20++;
                    if (i21 == i18) {
                        break;
                    }
                    if (bArr2[i19].length != i20) {
                        z11 = z10;
                    } else {
                        if (i19 == bArr2.length - 1) {
                            break;
                        }
                        i19++;
                        z11 = true;
                        i20 = -1;
                    }
                } else {
                    break;
                }
            }
            if (i13 >= 0) {
                if (i13 <= 0) {
                    int i22 = i18 - i21;
                    int length2 = bArr2[i19].length - i20;
                    while (true) {
                        i19++;
                        if (i19 >= bArr2.length) {
                            break;
                        }
                        length2 += bArr2[i19].length;
                    }
                    if (length2 >= i22) {
                        if (length2 <= i22) {
                            return new String(bArr, i16, i18, Util.f41604e);
                        }
                    }
                }
                i14 = i11 + 1;
            }
            length = i16 - 1;
        }
        return null;
    }

    private void a() {
        boolean z10 = false;
        while (true) {
            try {
                try {
                    b();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z10 = true;
                } catch (IOException e2) {
                    Platform.get().log(5, "Failed to read public suffix list", e2);
                    if (z10) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
    }

    private String[] a(String[] strArr) {
        String str;
        String str2;
        String str3;
        int i10 = 0;
        if (this.f42009e.get() || !this.f42009e.compareAndSet(false, true)) {
            try {
                this.f42010f.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            a();
        }
        synchronized (this) {
            if (this.f42011g == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        int length = strArr.length;
        byte[][] bArr = new byte[length];
        for (int i11 = 0; i11 < strArr.length; i11++) {
            bArr[i11] = strArr[i11].getBytes(Util.f41604e);
        }
        int i12 = 0;
        while (true) {
            str = null;
            if (i12 >= length) {
                str2 = null;
                break;
            }
            str2 = a(this.f42011g, bArr, i12);
            if (str2 != null) {
                break;
            }
            i12++;
        }
        if (length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            for (int i13 = 0; i13 < bArr2.length - 1; i13++) {
                bArr2[i13] = f42005a;
                str3 = a(this.f42011g, bArr2, i13);
                if (str3 != null) {
                    break;
                }
            }
        }
        str3 = null;
        if (str3 != null) {
            while (true) {
                if (i10 >= length - 1) {
                    break;
                }
                String a10 = a(this.f42012h, bArr, i10);
                if (a10 != null) {
                    str = a10;
                    break;
                }
                i10++;
            }
        }
        if (str != null) {
            return ("!" + str).split("\\.");
        }
        if (str2 == null && str3 == null) {
            return f42007c;
        }
        String[] split = str2 != null ? str2.split("\\.") : f42006b;
        String[] split2 = str3 != null ? str3.split("\\.") : f42006b;
        return split.length > split2.length ? split : split2;
    }

    private void b() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream == null) {
            return;
        }
        BufferedSource buffer = Okio.buffer(new GzipSource(Okio.source(resourceAsStream)));
        try {
            byte[] bArr = new byte[buffer.readInt()];
            buffer.readFully(bArr);
            byte[] bArr2 = new byte[buffer.readInt()];
            buffer.readFully(bArr2);
            synchronized (this) {
                this.f42011g = bArr;
                this.f42012h = bArr2;
            }
            this.f42010f.countDown();
        } finally {
            Util.closeQuietly(buffer);
        }
    }

    public static PublicSuffixDatabase get() {
        return f42008d;
    }

    public String getEffectiveTldPlusOne(String str) {
        Objects.requireNonNull(str, "domain == null");
        String[] split = IDN.toUnicode(str).split("\\.");
        String[] a10 = a(split);
        if (split.length == a10.length && a10[0].charAt(0) != '!') {
            return null;
        }
        char charAt = a10[0].charAt(0);
        int length = split.length;
        int length2 = a10.length;
        if (charAt != '!') {
            length2++;
        }
        StringBuilder sb2 = new StringBuilder();
        String[] split2 = str.split("\\.");
        for (int i10 = length - length2; i10 < split2.length; i10++) {
            sb2.append(split2[i10]);
            sb2.append('.');
        }
        sb2.deleteCharAt(sb2.length() - 1);
        return sb2.toString();
    }
}
