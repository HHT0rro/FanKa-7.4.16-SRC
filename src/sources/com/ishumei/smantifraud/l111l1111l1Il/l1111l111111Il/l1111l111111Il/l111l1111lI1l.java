package com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l1111l111111Il;

import com.huawei.openalliance.ad.ipc.c;
import com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111I1l;
import com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111I1ll;
import com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111Il;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
final class l111l1111lI1l {
    private static final int l1111l111111Il = 3000;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class l1111l111111Il {
        private final String l1111l111111Il;
        private final l11l1111I1ll l111l11111lIl;

        private l1111l111111Il(String str, l11l1111I1ll l11l1111i1ll) {
            this.l1111l111111Il = str;
            this.l111l11111lIl = l11l1111i1ll;
        }

        public /* synthetic */ l1111l111111Il(String str, l11l1111I1ll l11l1111i1ll, byte b4) {
            this(str, l11l1111i1ll);
        }
    }

    private l111l1111lI1l() {
    }

    public static l1111l111111Il l1111l111111Il(com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l111l1111lI1l<?> l111l1111li1l, Exception exc) {
        if ((exc instanceof SocketTimeoutException) || (exc instanceof ConnectException)) {
            return new l1111l111111Il("socket", new l11l1111I1ll(-2), (byte) 0);
        }
        if (exc instanceof UnknownHostException) {
            throw new l11l1111I1ll(exc, -1);
        }
        if (!(exc instanceof MalformedURLException)) {
            return exc instanceof l11l1111I1ll ? new l1111l111111Il("VolleyError", (l11l1111I1ll) exc, (byte) 0) : new l1111l111111Il("network", new l11l1111I1ll(exc, -4), (byte) 0);
        }
        throw new RuntimeException("Bad URL " + l111l1111li1l.l111l1111lI1l(), exc);
    }

    private static void l1111l111111Il(long j10, com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l111l1111lI1l<?> l111l1111li1l, byte[] bArr, int i10) {
        if (l11l1111Il.l1111l111111Il || j10 > c.Code) {
            Object[] objArr = new Object[5];
            objArr[0] = l111l1111li1l;
            objArr[1] = Long.valueOf(j10);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(i10);
            objArr[4] = Integer.valueOf(l111l1111li1l.l11l1111Ill().l111l11111lIl());
            l11l1111Il.l111l11111lIl("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    public static void l1111l111111Il(com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l111l1111lI1l<?> l111l1111li1l, l1111l111111Il l1111l111111il) {
        l11l1111I1l l11l1111Ill = l111l1111li1l.l11l1111Ill();
        int l11l1111Il1l = l111l1111li1l.l11l1111Il1l();
        try {
            l11l1111Ill.l1111l111111Il(l1111l111111il.l111l11111lIl);
            l111l1111li1l.l1111l111111Il(String.format("%s-retry [timeout=%s]", l1111l111111il.l1111l111111Il, Integer.valueOf(l11l1111Il1l)));
        } catch (l11l1111I1ll e2) {
            l111l1111li1l.l1111l111111Il(String.format("%s-timeout-giveup [timeout=%s]", l1111l111111il.l1111l111111Il, Integer.valueOf(l11l1111Il1l)));
            throw e2;
        }
    }

    public static byte[] l1111l111111Il(InputStream inputStream, int i10, l111l11111I1l l111l11111i1l) {
        byte[] bArr;
        l11l1111lIIl l11l1111liil = new l11l1111lIIl(l111l11111i1l, i10);
        try {
            bArr = l111l11111i1l.l1111l111111Il(1024);
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    l11l1111liil.write(bArr, 0, read);
                } catch (Throwable th) {
                    th = th;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                            l11l1111Il.l1111l111111Il("Error occurred when closing InputStream", new Object[0]);
                        }
                    }
                    l111l11111i1l.l1111l111111Il(bArr);
                    l11l1111liil.close();
                    throw th;
                }
            }
            byte[] byteArray = l11l1111liil.toByteArray();
            try {
                inputStream.close();
            } catch (IOException unused2) {
                l11l1111Il.l1111l111111Il("Error occurred when closing InputStream", new Object[0]);
            }
            l111l11111i1l.l1111l111111Il(bArr);
            l11l1111liil.close();
            return byteArray;
        } catch (Throwable th2) {
            th = th2;
            bArr = null;
        }
    }
}
