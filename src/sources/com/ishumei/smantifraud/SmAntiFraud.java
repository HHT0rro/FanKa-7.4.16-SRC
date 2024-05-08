package com.ishumei.smantifraud;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.ishumei.smantifraud.l1111l111111Il.l111l1111lIl;
import com.ishumei.smantifraud.l1111l111111Il.l111l11IlIlIl;
import com.ishumei.smantifraud.l1111l111111Il.l11l1111Il;
import com.ishumei.smantifraud.l111l11111lIl.l1111l111111Il.l111l11111Il;
import com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il;
import com.ishumei.smantifraud.l111l1111llIl.l111l11111lIl;
import com.ishumei.smantifraud.l111l1111llIl.l111l1111llIl;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class SmAntiFraud {
    public static final String AREA_BJ = "bj";
    public static final String AREA_FJNY = "fjny";
    public static final String AREA_XJP = "xjp";
    public static final int SM_AF_ASYN_MODE = 1;
    public static final int SM_AF_SYN_MODE = 0;
    private static final String l1111l111111Il = "Smlog";
    private static IServerSmidCallback l111l11111lIl;
    public static SmOption option;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface IDeviceIdCallback {
        void onResult(String str);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface IServerSmidCallback {
        void onError(int i10);

        void onSuccess(String str);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class SmOption {
        private static final int l1111l111111Il = 1024;
        private boolean l11l1111I11l;
        private Set<String> l11l1111Il1l;
        private boolean l11l1111Ill;
        private String l11l111l1Il;
        private byte[] l11l111l1lll;
        private boolean l111l11111lIl = false;
        private String l111l11111I1l = "";
        private String l111l11111Il = "";
        private boolean l111l1111l1Il = true;
        private boolean l111l1111llIl = true;
        private String l111l1111lI1l = null;
        private String l111l1111lIl = null;
        private String l11l1111lIIl = null;
        private boolean l11l1111I1l = false;
        private boolean l11l1111I1ll = false;
        private IServerSmidCallback l11l1111Il = null;
        private String l11l11IlIIll = "default";
        private String l11l111l11Il = null;
        private boolean l111l11IlIlIl = false;
        private String l11l111l1I1l = SmAntiFraud.AREA_BJ;

        private byte[] l111l11IlIlIl() {
            return this.l11l111l1lll;
        }

        private boolean l11l111l1I1l() {
            return this.l111l11111lIl;
        }

        private boolean l11l111l1Il() {
            return this.l11l1111Ill;
        }

        private boolean l11l111l1lll() {
            return this.l111l11IlIlIl;
        }

        public final String l1111l111111Il() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.l111l1111l1Il ? "1" : "0");
            sb2.append(this.l111l1111llIl ? "1" : "0");
            sb2.append(this.l11l1111I11l ? "1" : "0");
            sb2.append(this.l11l1111I1ll ? "1" : "0");
            sb2.append(SmAntiFraud.l111l11111lIl != null ? "1" : "0");
            Set<String> set = this.l11l1111Il1l;
            sb2.append((set == null || set.size() <= 0) ? "0" : "1");
            sb2.append(this.l111l11IlIlIl ? "1" : "0");
            return sb2.toString();
        }

        public final boolean l111l11111I1l() {
            return this.l11l1111I1ll;
        }

        public final String l111l11111Il() {
            return this.l11l111l11Il;
        }

        public final String l111l11111lIl() {
            return this.l11l111l1I1l;
        }

        public final IServerSmidCallback l111l1111l1Il() {
            return this.l11l1111Il;
        }

        public final boolean l111l1111lI1l() {
            return this.l11l1111I11l;
        }

        public final boolean l111l1111lIl() {
            return this.l11l1111I1l;
        }

        public final String l111l1111llIl() {
            return this.l11l1111lIIl;
        }

        public final boolean l11l1111I11l() {
            return this.l111l1111l1Il;
        }

        public final String l11l1111I1l() {
            return this.l111l11111I1l;
        }

        public final String l11l1111I1ll() {
            return this.l111l11111Il;
        }

        public final String l11l1111Il() {
            return this.l111l1111lI1l;
        }

        public final String l11l1111Il1l() {
            return this.l111l1111lIl;
        }

        public final Set<String> l11l1111Ill() {
            return this.l11l1111Il1l;
        }

        public final boolean l11l1111lIIl() {
            return this.l111l1111llIl;
        }

        public final String l11l111l11Il() {
            return this.l11l111l1Il;
        }

        public final String l11l11IlIIll() {
            return this.l11l11IlIIll;
        }

        public void setAppId(String str) {
            this.l11l11IlIIll = str;
        }

        public void setArea(String str) {
            this.l11l111l1I1l = str;
        }

        public void setChannel(String str) {
            this.l111l11111Il = str;
        }

        public void setCheckCrt(boolean z10) {
            this.l111l11IlIlIl = z10;
        }

        public void setCloudConf(boolean z10) {
            this.l111l1111llIl = z10;
        }

        public void setConfUrl(String str) {
            this.l11l1111lIIl = str;
        }

        public void setExtraInfo(String str) {
            if (str == null) {
                return;
            }
            if (str.length() > 1024) {
                this.l11l111l1Il = str.substring(0, 1024);
            } else {
                this.l11l111l1Il = str;
            }
        }

        public void setFirst(boolean z10) {
            this.l11l1111Ill = z10;
        }

        public void setHttpsCrt(byte[] bArr) {
            this.l11l111l1lll = bArr;
        }

        public void setNotCollect(Set<String> set) {
            this.l11l1111Il1l = set;
        }

        public void setOrganization(String str) {
            this.l111l11111I1l = str;
        }

        public void setPublicKey(String str) {
            this.l11l111l11Il = str;
        }

        public void setRetryUrl(String str) {
            this.l111l1111lIl = str;
        }

        public void setServerIdCallback(IServerSmidCallback iServerSmidCallback) {
            this.l11l1111Il = iServerSmidCallback;
        }

        public void setSynMode(boolean z10) {
            this.l111l11111lIl = z10;
        }

        public void setTransport(boolean z10) {
            this.l111l1111l1Il = z10;
        }

        public void setUrl(String str) {
            this.l111l1111lI1l = str;
        }

        public void setUsingHttps(boolean z10) {
            this.l11l1111I1ll = z10;
        }

        public void setUsingMD5(boolean z10) {
            this.l11l1111I11l = z10;
        }

        public void usingShortBoxData(boolean z10) {
            this.l11l1111I1l = z10;
        }
    }

    private SmAntiFraud() {
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0128 A[Catch: all -> 0x01a2, TryCatch #0 {all -> 0x01a2, blocks: (B:13:0x0035, B:15:0x004c, B:18:0x005e, B:20:0x006a, B:21:0x0084, B:23:0x0090, B:24:0x00a5, B:27:0x00b3, B:28:0x00c3, B:29:0x00c7, B:30:0x00ce, B:32:0x00da, B:33:0x00ed, B:40:0x0117, B:42:0x0128, B:43:0x0130, B:45:0x013e, B:47:0x0142, B:48:0x0153, B:50:0x015d, B:52:0x0165, B:54:0x016d, B:55:0x0186, B:57:0x018e, B:64:0x010c), top: B:12:0x0035, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x015d A[Catch: all -> 0x01a2, TryCatch #0 {all -> 0x01a2, blocks: (B:13:0x0035, B:15:0x004c, B:18:0x005e, B:20:0x006a, B:21:0x0084, B:23:0x0090, B:24:0x00a5, B:27:0x00b3, B:28:0x00c3, B:29:0x00c7, B:30:0x00ce, B:32:0x00da, B:33:0x00ed, B:40:0x0117, B:42:0x0128, B:43:0x0130, B:45:0x013e, B:47:0x0142, B:48:0x0153, B:50:0x015d, B:52:0x0165, B:54:0x016d, B:55:0x0186, B:57:0x018e, B:64:0x010c), top: B:12:0x0035, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0032 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized boolean create(android.content.Context r6, com.ishumei.smantifraud.SmAntiFraud.SmOption r7) {
        /*
            Method dump skipped, instructions count: 453
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ishumei.smantifraud.SmAntiFraud.create(android.content.Context, com.ishumei.smantifraud.SmAntiFraud$SmOption):boolean");
    }

    public static void destroy() {
        l111l1111l1Il.l111l1111l1Il = true;
    }

    public static String getDeviceId() {
        synchronized (SmAntiFraud.class) {
            if (l111l1111l1Il.l111l1111l1Il) {
                return "Dc21zZGsgaGFzIGJlZW4gZGVzdHJveWVk";
            }
            if (TextUtils.isEmpty(l111l11111lIl.l1111l111111Il)) {
                l111l11111Il.l1111l111111Il();
                return l111l11111Il.l111l11111lIl();
            }
            String str = l111l11111lIl.l1111l111111Il;
            try {
                throw new IllegalAccessException(l111l11111lIl.l1111l111111Il);
            } catch (Throwable th) {
                try {
                    return "D" + l111l1111llIl.l1111l111111Il(l11l1111Il.l1111l111111Il().l1111l111111Il(th).getBytes());
                } catch (Throwable th2) {
                    return "D" + Base64.encodeToString((l111l11111lIl.l1111l111111Il + ";" + th2).getBytes(), 0);
                }
            }
        }
    }

    public static void getDeviceId(IDeviceIdCallback iDeviceIdCallback) {
        if (iDeviceIdCallback == null) {
            throw new IllegalArgumentException("callback cannot be null.");
        }
        l111l11111Il.l1111l111111Il().l1111l111111Il(iDeviceIdCallback, Thread.currentThread() == Looper.getMainLooper().getThread());
    }

    public static String getSDKVersion() {
        return "3.7.3_build1";
    }

    public static IServerSmidCallback getServerIdCallback() {
        return l111l11111lIl;
    }

    public static String getVData() {
        if (option == null) {
            return "DU21PcHRpb24gaXMgbnVsbC4=";
        }
        try {
            return "D" + l111l1111llIl.l1111l111111Il(l111l11IlIlIl.l1111l111111Il().l111l11111lIl().getBytes());
        } catch (Throwable th) {
            return "D" + l11l1111Il.l1111l111111Il().l1111l111111Il(th);
        }
    }

    private static void l1111l111111Il(SmOption smOption) {
        IServerSmidCallback iServerSmidCallback;
        l111l11111lIl(smOption);
        String l111l11111Il = l111l11111Il.l1111l111111Il().l111l11111Il();
        if (!TextUtils.isEmpty(l111l11111Il) && (iServerSmidCallback = l111l11111lIl) != null) {
            iServerSmidCallback.onSuccess("B" + l111l11111Il);
        }
        if (com.ishumei.smantifraud.l111l11111lIl.l111l11111Il.l1111l111111Il().l111l11111lIl()) {
            if (option.l11l1111I11l() && option.l11l1111lIIl()) {
                com.ishumei.smantifraud.l1111l111111Il.l111l1111l1Il.l1111l111111Il().l1111l111111Il(option.l111l1111llIl(), option.l11l1111Il1l(), option.l11l1111I1l());
            }
            if (option.l11l1111I11l()) {
                l111l1111lIl.l1111l111111Il().l1111l111111Il(option.l11l1111Il(), option.l11l1111Il1l());
            }
        }
    }

    private static boolean l1111l111111Il(Context context, SmOption smOption) {
        String str;
        if (context == null) {
            str = "context is null!";
        } else if (smOption == null) {
            str = "SmOption is null!";
        } else if (TextUtils.isEmpty(smOption.l11l1111I1l())) {
            str = "SmOption.organization is null!";
        } else {
            if (!TextUtils.isEmpty(smOption.l111l11111Il())) {
                return true;
            }
            str = "SmOption.publicKey is null!";
        }
        l111l11111lIl.l1111l111111Il = str;
        return false;
    }

    private static void l111l11111lIl(SmOption smOption) {
        boolean z10;
        SmOption smOption2;
        String l11l1111Il;
        option = smOption;
        if (TextUtils.isEmpty(smOption.l11l1111Il())) {
            z10 = true;
            SmOption smOption3 = option;
            smOption3.setUrl(com.ishumei.smantifraud.l111l11111I1l.l1111l111111Il.l111l1111llIl.l1111l111111Il(smOption3.l111l11111lIl(), option.l111l11111I1l()));
        } else {
            z10 = false;
        }
        if (TextUtils.isEmpty(option.l11l1111Il1l())) {
            if (z10) {
                smOption2 = option;
                l11l1111Il = com.ishumei.smantifraud.l111l11111I1l.l1111l111111Il.l111l1111llIl.l111l11111lIl(smOption2.l111l11111lIl(), option.l111l11111I1l());
            } else {
                smOption2 = option;
                l11l1111Il = smOption2.l11l1111Il();
            }
            smOption2.setRetryUrl(l11l1111Il);
        }
        if (TextUtils.isEmpty(option.l111l1111llIl())) {
            SmOption smOption4 = option;
            smOption4.setConfUrl(com.ishumei.smantifraud.l111l11111I1l.l1111l111111Il.l111l1111llIl.l111l11111I1l(smOption4.l111l11111lIl(), option.l11l1111I1ll));
        }
        l111l11111Il l1111l111111Il2 = l111l11111Il.l1111l111111Il();
        com.ishumei.smantifraud.l111l11111I1l.l1111l111111Il.l111l1111llIl.l1111l111111Il(option.l111l11111lIl());
        l1111l111111Il2.l1111l111111Il(option.l11l1111I1l());
        if (option.l111l1111l1Il() != null) {
            l111l11111lIl = option.l111l1111l1Il();
        }
    }

    public static synchronized void registerServerIdCallback(IServerSmidCallback iServerSmidCallback) {
        synchronized (SmAntiFraud.class) {
            l111l11111lIl = iServerSmidCallback;
        }
    }

    public static void startDetector(AbsDetector absDetector) {
        if (option == null) {
            return;
        }
        l111l11IlIlIl.l1111l111111Il().l1111l111111Il(absDetector);
    }

    public static void stopDetector(AbsDetector absDetector) {
        if (option == null) {
            return;
        }
        l111l11IlIlIl.l1111l111111Il().l111l11111lIl(absDetector);
    }
}
