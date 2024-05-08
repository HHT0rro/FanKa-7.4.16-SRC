package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a implements NativeExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    private final Context f39328a;

    /* renamed from: b, reason: collision with root package name */
    private final com.tencent.bugly.crashreport.crash.b f39329b;

    /* renamed from: c, reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.info.a f39330c;

    /* renamed from: d, reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.strategy.a f39331d;

    public a(Context context, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.crash.b bVar, com.tencent.bugly.crashreport.common.strategy.a aVar2) {
        this.f39328a = context;
        this.f39329b = bVar;
        this.f39330c = aVar;
        this.f39331d = aVar2;
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final void handleNativeException(int i10, int i11, long j10, long j11, String str, String str2, String str3, String str4, int i12, String str5, int i13, int i14, int i15, String str6, String str7) {
        x.a("Native Crash Happen v1", new Object[0]);
        handleNativeException2(i10, i11, j10, j11, str, str2, str3, str4, i12, str5, i13, i14, i15, str6, str7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x011d A[Catch: all -> 0x0298, TryCatch #2 {all -> 0x0298, blocks: (B:3:0x0010, B:6:0x001c, B:7:0x0069, B:10:0x0071, B:12:0x0074, B:14:0x0078, B:16:0x0093, B:19:0x009c, B:18:0x00a6, B:23:0x00b0, B:25:0x00ba, B:27:0x00c2, B:28:0x00ce, B:30:0x00d8, B:33:0x00df, B:34:0x00ee, B:36:0x00fa, B:39:0x0101, B:40:0x0117, B:42:0x011d, B:45:0x012d, B:47:0x014d, B:48:0x0187, B:50:0x01ac, B:51:0x01b3, B:54:0x01bf, B:56:0x01c7, B:93:0x0165, B:94:0x00ea, B:96:0x00a9, B:99:0x0041, B:100:0x0045, B:102:0x004f), top: B:2:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x014d A[Catch: all -> 0x0298, TryCatch #2 {all -> 0x0298, blocks: (B:3:0x0010, B:6:0x001c, B:7:0x0069, B:10:0x0071, B:12:0x0074, B:14:0x0078, B:16:0x0093, B:19:0x009c, B:18:0x00a6, B:23:0x00b0, B:25:0x00ba, B:27:0x00c2, B:28:0x00ce, B:30:0x00d8, B:33:0x00df, B:34:0x00ee, B:36:0x00fa, B:39:0x0101, B:40:0x0117, B:42:0x011d, B:45:0x012d, B:47:0x014d, B:48:0x0187, B:50:0x01ac, B:51:0x01b3, B:54:0x01bf, B:56:0x01c7, B:93:0x0165, B:94:0x00ea, B:96:0x00a9, B:99:0x0041, B:100:0x0045, B:102:0x004f), top: B:2:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01ac A[Catch: all -> 0x0298, TryCatch #2 {all -> 0x0298, blocks: (B:3:0x0010, B:6:0x001c, B:7:0x0069, B:10:0x0071, B:12:0x0074, B:14:0x0078, B:16:0x0093, B:19:0x009c, B:18:0x00a6, B:23:0x00b0, B:25:0x00ba, B:27:0x00c2, B:28:0x00ce, B:30:0x00d8, B:33:0x00df, B:34:0x00ee, B:36:0x00fa, B:39:0x0101, B:40:0x0117, B:42:0x011d, B:45:0x012d, B:47:0x014d, B:48:0x0187, B:50:0x01ac, B:51:0x01b3, B:54:0x01bf, B:56:0x01c7, B:93:0x0165, B:94:0x00ea, B:96:0x00a9, B:99:0x0041, B:100:0x0045, B:102:0x004f), top: B:2:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01bf A[Catch: all -> 0x0298, TRY_ENTER, TryCatch #2 {all -> 0x0298, blocks: (B:3:0x0010, B:6:0x001c, B:7:0x0069, B:10:0x0071, B:12:0x0074, B:14:0x0078, B:16:0x0093, B:19:0x009c, B:18:0x00a6, B:23:0x00b0, B:25:0x00ba, B:27:0x00c2, B:28:0x00ce, B:30:0x00d8, B:33:0x00df, B:34:0x00ee, B:36:0x00fa, B:39:0x0101, B:40:0x0117, B:42:0x011d, B:45:0x012d, B:47:0x014d, B:48:0x0187, B:50:0x01ac, B:51:0x01b3, B:54:0x01bf, B:56:0x01c7, B:93:0x0165, B:94:0x00ea, B:96:0x00a9, B:99:0x0041, B:100:0x0045, B:102:0x004f), top: B:2:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0223 A[Catch: all -> 0x0294, TryCatch #1 {all -> 0x0294, blocks: (B:62:0x021d, B:64:0x0223, B:66:0x022c), top: B:61:0x021d }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x022c A[Catch: all -> 0x0294, TRY_LEAVE, TryCatch #1 {all -> 0x0294, blocks: (B:62:0x021d, B:64:0x0223, B:66:0x022c), top: B:61:0x021d }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0149 A[SYNTHETIC] */
    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void handleNativeException2(int r27, int r28, long r29, long r31, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, int r37, java.lang.String r38, int r39, int r40, int r41, java.lang.String r42, java.lang.String r43, java.lang.String[] r44) {
        /*
            Method dump skipped, instructions count: 676
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.a.handleNativeException2(int, int, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, int, int, java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final CrashDetailBean packageCrashDatas(String str, String str2, long j10, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, byte[] bArr, Map<String, String> map, boolean z10, boolean z11) {
        int i10;
        String str12;
        int indexOf;
        boolean m10 = c.a().m();
        if (m10) {
            x.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.f39161b = 1;
        crashDetailBean.f39164e = this.f39330c.h();
        com.tencent.bugly.crashreport.common.info.a aVar = this.f39330c;
        crashDetailBean.f39165f = aVar.f39102j;
        crashDetailBean.f39166g = aVar.r();
        crashDetailBean.f39172m = this.f39330c.g();
        crashDetailBean.f39173n = str3;
        crashDetailBean.f39174o = m10 ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        crashDetailBean.f39175p = str4;
        String str13 = str5 != null ? str5 : "";
        crashDetailBean.f39176q = str13;
        crashDetailBean.f39177r = j10;
        crashDetailBean.f39180u = z.a(str13.getBytes());
        crashDetailBean.A = str;
        crashDetailBean.B = str2;
        crashDetailBean.I = this.f39330c.t();
        crashDetailBean.f39167h = this.f39330c.q();
        crashDetailBean.f39168i = this.f39330c.C();
        crashDetailBean.f39181v = str8;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        String dumpFilePath = nativeCrashHandler != null ? nativeCrashHandler.getDumpFilePath() : null;
        String a10 = b.a(dumpFilePath, str8);
        if (!z.a(a10)) {
            crashDetailBean.V = a10;
        }
        crashDetailBean.W = b.b(dumpFilePath);
        crashDetailBean.f39182w = b.a(str9, c.f39241e, null, false);
        crashDetailBean.f39183x = b.a(str10, c.f39241e, null, true);
        crashDetailBean.J = str7;
        crashDetailBean.K = str6;
        crashDetailBean.L = str11;
        crashDetailBean.F = this.f39330c.l();
        crashDetailBean.G = this.f39330c.k();
        crashDetailBean.H = this.f39330c.m();
        if (z10) {
            crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.g();
            crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.e();
            crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.i();
            if (crashDetailBean.f39182w == null) {
                crashDetailBean.f39182w = z.a(this.f39328a, c.f39241e, (String) null);
            }
            crashDetailBean.f39184y = y.a();
            com.tencent.bugly.crashreport.common.info.a aVar2 = this.f39330c;
            crashDetailBean.M = aVar2.f39088a;
            crashDetailBean.N = aVar2.a();
            crashDetailBean.f39185z = z.a(c.f39242f, false);
            int indexOf2 = crashDetailBean.f39176q.indexOf("java:\n");
            if (indexOf2 > 0 && (i10 = indexOf2 + 6) < crashDetailBean.f39176q.length()) {
                String str14 = crashDetailBean.f39176q;
                String substring = str14.substring(i10, str14.length() - 1);
                if (substring.length() > 0 && crashDetailBean.f39185z.containsKey(crashDetailBean.B) && (indexOf = (str12 = crashDetailBean.f39185z.get(crashDetailBean.B)).indexOf(substring)) > 0) {
                    String substring2 = str12.substring(indexOf);
                    crashDetailBean.f39185z.put(crashDetailBean.B, substring2);
                    crashDetailBean.f39176q = crashDetailBean.f39176q.substring(0, i10);
                    crashDetailBean.f39176q += substring2;
                }
            }
            if (str == null) {
                crashDetailBean.A = this.f39330c.f39096d;
            }
            this.f39329b.d(crashDetailBean);
            crashDetailBean.Q = this.f39330c.A();
            crashDetailBean.R = this.f39330c.B();
            crashDetailBean.S = this.f39330c.u();
            crashDetailBean.T = this.f39330c.z();
        } else {
            crashDetailBean.C = -1L;
            crashDetailBean.D = -1L;
            crashDetailBean.E = -1L;
            if (crashDetailBean.f39182w == null) {
                crashDetailBean.f39182w = "this crash is occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
            }
            crashDetailBean.M = -1L;
            crashDetailBean.Q = -1;
            crashDetailBean.R = -1;
            crashDetailBean.S = map;
            crashDetailBean.T = this.f39330c.z();
            crashDetailBean.f39185z = null;
            if (str == null) {
                crashDetailBean.A = "unknown(record)";
            }
            if (bArr != null) {
                crashDetailBean.f39184y = bArr;
            }
        }
        return crashDetailBean;
    }
}
