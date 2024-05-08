package com.ishumei.smantifraud.l111l11111lIl.l1111l111111Il;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.ishumei.smantifraud.SmAntiFraud;
import com.ishumei.smantifraud.l1111l111111Il.l11l1111Il;
import com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l111l1111lI1l;
import java.util.ArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class l111l11111Il {
    private static String l1111l111111Il = "sm";
    private static l111l11111Il l111l11111lIl;
    private l111l1111lI1l.l1111l111111Il l111l11111I1l;
    private l111l1111lI1l.l1111l111111Il l111l11111Il;
    private l111l1111lI1l.l1111l111111Il l111l1111l1Il;
    private l111l1111lI1l.l1111l111111Il l111l1111lI1l;
    private l111l1111lI1l.l1111l111111Il l111l1111lIl;
    private l111l1111lI1l.l1111l111111Il l111l1111llIl;
    private String l11l1111lIIl;

    private l111l11111Il() {
    }

    public static l111l11111Il l1111l111111Il() {
        if (l111l11111lIl == null) {
            synchronized (l111l11111Il.class) {
                if (l111l11111lIl == null) {
                    l111l11111lIl = new l111l11111Il();
                }
            }
        }
        return l111l11111lIl;
    }

    public static String l111l11111lIl() {
        String l1111l111111Il2;
        if (!TextUtils.isEmpty(com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l111l11111Il)) {
            return "B" + com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l111l11111Il;
        }
        String l111l11111Il = l1111l111111Il().l111l11111Il();
        if (!TextUtils.isEmpty(l111l11111Il)) {
            com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l111l11111Il = l111l11111Il;
            return "B" + l111l11111Il;
        }
        String l111l11111I1l = com.ishumei.smantifraud.l1111l111111Il.l1111l111111Il.l1111l111111Il().l111l11111I1l();
        if (!TextUtils.isEmpty(l111l11111I1l)) {
            return "D" + l111l11111I1l;
        }
        boolean l111l1111lI1l = SmAntiFraud.option.l111l1111lI1l();
        if (com.ishumei.smantifraud.l1111l111111Il.l1111l111111Il.l1111l111111Il().l111l11111lIl()) {
            return "DZ2V0RGV2aWNlSWQgZW1wdHk=";
        }
        try {
            l1111l111111Il2 = com.ishumei.smantifraud.l1111l111111Il.l1111l111111Il.l1111l111111Il().l1111l111111Il(l111l1111lI1l ? 1 : 0);
            if (l1111l111111Il2 == null) {
                if (com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l111l1111l1Il) {
                    return "Dc21zZGsgaGFzIGJlZW4gZGVzdHJveWVk";
                }
            }
        } catch (Throwable th) {
            l1111l111111Il2 = l11l1111Il.l1111l111111Il().l1111l111111Il(th);
        }
        if (l1111l111111Il2 == null) {
            try {
                return "D" + com.ishumei.smantifraud.l111l1111llIl.l111l1111llIl.l1111l111111Il(l11l1111Il.l1111l111111Il().l1111l111111Il(new IllegalStateException()).getBytes());
            } catch (Throwable th2) {
                return "D" + Base64.encodeToString(th2.toString().getBytes(), 0);
            }
        }
        try {
            return "D" + com.ishumei.smantifraud.l111l1111llIl.l111l1111llIl.l1111l111111Il(l1111l111111Il2.getBytes());
        } catch (Throwable th3) {
            try {
                return "D" + com.ishumei.smantifraud.l111l1111llIl.l111l1111llIl.l1111l111111Il(l11l1111Il.l1111l111111Il().l1111l111111Il(th3).getBytes());
            } catch (Throwable th4) {
                return "D" + Base64.encodeToString(th4.toString().getBytes(), 0);
            }
        }
    }

    private void l111l11111lIl(String str) {
        l111l1111lI1l.l1111l111111Il l1111l111111il = this.l111l11111I1l;
        if (l1111l111111il != null) {
            l1111l111111il.l111l11111lIl(str);
        }
    }

    private String l11l1111I11l() {
        if (!TextUtils.isEmpty(this.l11l1111lIIl)) {
            return this.l11l1111lIIl;
        }
        ArrayList<l111l1111lI1l.l1111l111111Il> arrayList = new ArrayList();
        l111l1111lI1l.l1111l111111Il l1111l111111il = this.l111l11111I1l;
        if (l1111l111111il != null) {
            arrayList.add(l1111l111111il);
        }
        l111l1111lI1l.l1111l111111Il l1111l111111il2 = this.l111l1111lI1l;
        if (l1111l111111il2 != null) {
            arrayList.add(l1111l111111il2);
        }
        l111l1111lI1l.l1111l111111Il l1111l111111il3 = this.l111l1111l1Il;
        if (l1111l111111il3 != null) {
            arrayList.add(l1111l111111il3);
        }
        for (l111l1111lI1l.l1111l111111Il l1111l111111il4 : arrayList) {
            if (l1111l111111il4 != null) {
                String l111l11111lIl2 = l1111l111111il4.l111l11111lIl();
                if (!TextUtils.isEmpty(l111l11111lIl2)) {
                    this.l11l1111lIIl = l111l11111lIl2;
                    return l111l11111lIl2;
                }
            }
        }
        return "";
    }

    public final void l1111l111111Il(final SmAntiFraud.IDeviceIdCallback iDeviceIdCallback, final boolean z10) {
        new Thread(new Runnable() { // from class: com.ishumei.smantifraud.l111l11111lIl.l1111l111111Il.l111l11111Il.1
            @Override // java.lang.Runnable
            public final void run() {
                final String l111l11111lIl2 = l111l11111Il.l111l11111lIl();
                if (z10) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ishumei.smantifraud.l111l11111lIl.l1111l111111Il.l111l11111Il.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            iDeviceIdCallback.onResult(l111l11111lIl2);
                        }
                    });
                } else {
                    iDeviceIdCallback.onResult(l111l11111lIl2);
                }
            }
        }).start();
    }

    public final void l1111l111111Il(String str) {
        try {
            this.l111l11111I1l = new l111l1111l1Il(str);
            this.l111l1111l1Il = new l111l1111llIl();
            this.l111l1111lI1l = new l111l1111lI1l();
        } catch (Throwable unused) {
        }
    }

    public final synchronized void l1111l111111Il(String str, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l111l11111Il = str;
        l111l1111lI1l.l1111l111111Il l1111l111111il = l1111l111111Il().l111l11111I1l;
        if (l1111l111111il != null) {
            l1111l111111il.l111l11111lIl(str);
        }
        if (SmAntiFraud.getServerIdCallback() != null) {
            SmAntiFraud.getServerIdCallback().onSuccess("B" + str);
        }
    }

    public final String l111l11111I1l() {
        if (!TextUtils.isEmpty(this.l11l1111lIIl)) {
            return this.l11l1111lIIl;
        }
        ArrayList<l111l1111lI1l.l1111l111111Il> arrayList = new ArrayList();
        l111l1111lI1l.l1111l111111Il l1111l111111il = this.l111l11111I1l;
        if (l1111l111111il != null) {
            arrayList.add(l1111l111111il);
        }
        l111l1111lI1l.l1111l111111Il l1111l111111il2 = this.l111l1111lI1l;
        if (l1111l111111il2 != null) {
            arrayList.add(l1111l111111il2);
        }
        l111l1111lI1l.l1111l111111Il l1111l111111il3 = this.l111l1111l1Il;
        if (l1111l111111il3 != null) {
            arrayList.add(l1111l111111il3);
        }
        for (l111l1111lI1l.l1111l111111Il l1111l111111il4 : arrayList) {
            if (l1111l111111il4 != null) {
                String l111l11111lIl2 = l1111l111111il4.l111l11111lIl();
                if (!TextUtils.isEmpty(l111l11111lIl2)) {
                    this.l11l1111lIIl = l111l11111lIl2;
                    return l111l11111lIl2;
                }
            }
        }
        return "";
    }

    public final synchronized String l111l11111Il() {
        l111l1111lI1l.l1111l111111Il l1111l111111il = this.l111l11111I1l;
        if (l1111l111111il == null) {
            return "";
        }
        return l1111l111111il.l111l11111lIl();
    }

    public final String l111l1111l1Il() {
        return "";
    }

    public final String l111l1111lI1l() {
        return "";
    }

    public final String l111l1111lIl() {
        l111l1111lI1l.l1111l111111Il l1111l111111il = this.l111l1111lI1l;
        return l1111l111111il == null ? "" : l1111l111111il.l111l11111lIl();
    }

    public final String l111l1111llIl() {
        l111l1111lI1l.l1111l111111Il l1111l111111il = this.l111l1111l1Il;
        return l1111l111111il == null ? "" : l1111l111111il.l111l11111lIl();
    }

    public final String l11l1111lIIl() {
        return "";
    }
}
