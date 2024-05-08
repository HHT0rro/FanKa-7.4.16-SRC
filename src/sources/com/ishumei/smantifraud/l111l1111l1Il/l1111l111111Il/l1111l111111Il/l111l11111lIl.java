package com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l1111l111111Il;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.security.common.utils.DESCoderUtils;
import com.ishumei.smantifraud.l1111l111111Il.l11l111l11Il;
import com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l1111l111111Il.l111l1111lI1l;
import com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111I1l;
import com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111I1ll;
import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class l111l11111lIl implements com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l111l11111Il {
    private final l1111l111111Il l1111l111111Il;

    public l111l11111lIl() {
    }

    public l111l11111lIl(l1111l111111Il l1111l111111il) {
        this.l1111l111111Il = l1111l111111il;
    }

    public static String l1111l111111Il(String str, byte[] bArr, int i10) {
        try {
            return new String(l111l11111lIl(str, bArr, i10), "utf-8");
        } catch (Exception e2) {
            throw new IOException(e2);
        }
    }

    public static byte[] l111l11111lIl(String str, byte[] bArr, int i10) {
        try {
            Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
            cipher.init(2, new SecretKeySpec(str.getBytes("utf-8"), DESCoderUtils.SECRETFACTORY_ALGORITHM));
            byte[] doFinal = cipher.doFinal(bArr);
            byte[] bArr2 = new byte[i10];
            System.arraycopy((Object) doFinal, 0, (Object) bArr2, 0, i10);
            return bArr2;
        } catch (Exception e2) {
            throw new IOException(e2);
        }
    }

    @Override // com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l111l11111Il
    public final com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111lIIl<?> l1111l111111Il(com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l111l1111lI1l<?> l111l1111li1l) {
        l111l1111lI1l.l1111l111111Il l1111l111111il;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        byte b4 = 0;
        l111l1111li1l.l1111l111111Il(false);
        while (true) {
            try {
                l11l111l11Il l1111l111111Il = this.l1111l111111Il.l1111l111111Il(l111l1111li1l, Collections.emptyMap());
                byte[] l111l11111I1l = l1111l111111Il.l111l11111I1l();
                int l1111l111111Il2 = l1111l111111Il.l1111l111111Il();
                if (l111l11111I1l == null) {
                    l111l11111I1l = new byte[0];
                }
                byte[] bArr = l111l11111I1l;
                if (l1111l111111Il2 < 200 || l1111l111111Il2 > 299) {
                    throw new IOException();
                }
                com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111lIIl<?> l1111l111111Il3 = l111l1111li1l.l1111l111111Il(new com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l111l1111llIl(l1111l111111Il2, bArr, false, SystemClock.elapsedRealtime() - elapsedRealtime, (List<com.ishumei.smantifraud.l1111l111111Il>) null));
                l111l1111li1l.l1111l111111Il("network-parse-complete");
                if (l1111l111111Il3.l1111l111111Il()) {
                    return l1111l111111Il3;
                }
                l11l1111I1ll l11l1111i1ll = l1111l111111Il3.l111l11111lIl;
                if (l11l1111i1ll != null) {
                    throw l11l1111i1ll;
                }
                throw new Exception("");
            } catch (Exception e2) {
                l111l1111li1l.l1111l111111Il(true);
                if ((e2 instanceof IllegalArgumentException) && TextUtils.equals(e2.getMessage(), "body is null")) {
                    throw ((IllegalArgumentException) e2);
                }
                if ((e2 instanceof SocketTimeoutException) || (e2 instanceof ConnectException)) {
                    l1111l111111il = new l111l1111lI1l.l1111l111111Il("socket", new l11l1111I1ll(-2), b4);
                } else {
                    if (e2 instanceof UnknownHostException) {
                        throw new l11l1111I1ll(e2, -1);
                    }
                    if (e2 instanceof MalformedURLException) {
                        throw new RuntimeException("Bad URL " + l111l1111li1l.l111l1111lI1l(), e2);
                    }
                    l1111l111111il = e2 instanceof l11l1111I1ll ? new l111l1111lI1l.l1111l111111Il("VolleyError", (l11l1111I1ll) e2, b4) : new l111l1111lI1l.l1111l111111Il("network", new l11l1111I1ll(e2, -4), b4);
                }
                l11l1111I1l l11l1111Ill = l111l1111li1l.l11l1111Ill();
                int l11l1111Il1l = l111l1111li1l.l11l1111Il1l();
                try {
                    l11l1111Ill.l1111l111111Il(l111l1111lI1l.l1111l111111Il.l1111l111111Il(l1111l111111il));
                    l111l1111li1l.l1111l111111Il(String.format("%s-retry [timeout=%s]", l111l1111lI1l.l1111l111111Il.l111l11111lIl(l1111l111111il), Integer.valueOf(l11l1111Il1l)));
                } catch (l11l1111I1ll e10) {
                    l111l1111li1l.l1111l111111Il(String.format("%s-timeout-giveup [timeout=%s]", l111l1111lI1l.l1111l111111Il.l111l11111lIl(l1111l111111il), Integer.valueOf(l11l1111Il1l)));
                    throw e10;
                }
            }
        }
    }
}
