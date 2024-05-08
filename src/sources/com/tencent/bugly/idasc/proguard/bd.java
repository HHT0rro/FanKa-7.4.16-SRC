package com.tencent.bugly.idasc.proguard;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.bugly.idasc.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.idasc.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.idasc.crashreport.crash.jni.NativeExceptionHandler;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bd implements NativeExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    private final Context f39738a;

    /* renamed from: b, reason: collision with root package name */
    private final as f39739b;

    /* renamed from: c, reason: collision with root package name */
    private final aa f39740c;

    /* renamed from: d, reason: collision with root package name */
    private final ac f39741d;

    public bd(Context context, aa aaVar, as asVar, ac acVar) {
        this.f39738a = context;
        this.f39739b = asVar;
        this.f39740c = aaVar;
        this.f39741d = acVar;
    }

    private static Map<String, String> a(String[] strArr) {
        HashMap hashMap = new HashMap(strArr == null ? 1 : strArr.length);
        if (strArr != null) {
            for (int i10 = 0; i10 < strArr.length; i10++) {
                String str = strArr[i10];
                if (str != null) {
                    al.a("Extra message[%d]: %s", Integer.valueOf(i10), str);
                    String[] split = str.split("=");
                    if (split.length == 2) {
                        hashMap.put(split[0], split[1]);
                    } else {
                        al.d("bad extraMsg %s", str);
                    }
                }
            }
        } else {
            al.c("not found extraMsg", new Object[0]);
        }
        return hashMap;
    }

    @Override // com.tencent.bugly.idasc.crashreport.crash.jni.NativeExceptionHandler
    public final boolean getAndUpdateAnrState() {
        if (ay.a() == null) {
            return false;
        }
        ay a10 = ay.a();
        if (a10.f39700a.get()) {
            al.c("anr is processing, return", new Object[0]);
            return false;
        }
        ActivityManager activityManager = a10.f39701b;
        if (!((z.a(activityManager) || az.a(activityManager, 0L) == null) ? false : true)) {
            al.c("proc is not in anr, wait next check", new Object[0]);
            return false;
        }
        if (a10.a(System.currentTimeMillis())) {
            return false;
        }
        return a10.a(true);
    }

    @Override // com.tencent.bugly.idasc.crashreport.crash.jni.NativeExceptionHandler
    public final void handleNativeException(int i10, int i11, long j10, long j11, String str, String str2, String str3, String str4, int i12, String str5, int i13, int i14, int i15, String str6, String str7) {
        al.a("Native Crash Happen v1", new Object[0]);
        handleNativeException2(i10, i11, j10, j11, str, str2, str3, str4, i12, str5, i13, i14, i15, str6, str7, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x009c A[Catch: all -> 0x0224, TryCatch #1 {all -> 0x0224, blocks: (B:79:0x0016, B:4:0x0036, B:6:0x0049, B:8:0x0051, B:9:0x005d, B:11:0x0069, B:14:0x0070, B:15:0x007c, B:17:0x009c, B:18:0x00b5, B:19:0x00cc, B:21:0x00ef, B:22:0x00f6, B:25:0x0102, B:27:0x010a, B:35:0x0152, B:36:0x0156, B:38:0x0160, B:75:0x00ba, B:76:0x007a), top: B:78:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ef A[Catch: all -> 0x0224, TryCatch #1 {all -> 0x0224, blocks: (B:79:0x0016, B:4:0x0036, B:6:0x0049, B:8:0x0051, B:9:0x005d, B:11:0x0069, B:14:0x0070, B:15:0x007c, B:17:0x009c, B:18:0x00b5, B:19:0x00cc, B:21:0x00ef, B:22:0x00f6, B:25:0x0102, B:27:0x010a, B:35:0x0152, B:36:0x0156, B:38:0x0160, B:75:0x00ba, B:76:0x007a), top: B:78:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01a3 A[Catch: all -> 0x0220, TryCatch #0 {all -> 0x0220, blocks: (B:42:0x019d, B:44:0x01a3, B:46:0x01ac), top: B:41:0x019d }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01ac A[Catch: all -> 0x0220, TRY_LEAVE, TryCatch #0 {all -> 0x0220, blocks: (B:42:0x019d, B:44:0x01a3, B:46:0x01ac), top: B:41:0x019d }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ba A[Catch: all -> 0x0224, TryCatch #1 {all -> 0x0224, blocks: (B:79:0x0016, B:4:0x0036, B:6:0x0049, B:8:0x0051, B:9:0x005d, B:11:0x0069, B:14:0x0070, B:15:0x007c, B:17:0x009c, B:18:0x00b5, B:19:0x00cc, B:21:0x00ef, B:22:0x00f6, B:25:0x0102, B:27:0x010a, B:35:0x0152, B:36:0x0156, B:38:0x0160, B:75:0x00ba, B:76:0x007a), top: B:78:0x0016 }] */
    @Override // com.tencent.bugly.idasc.crashreport.crash.jni.NativeExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void handleNativeException2(int r28, int r29, long r30, long r32, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, int r38, java.lang.String r39, int r40, int r41, int r42, java.lang.String r43, java.lang.String r44, java.lang.String[] r45) {
        /*
            Method dump skipped, instructions count: 560
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.idasc.proguard.bd.handleNativeException2(int, int, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, int, int, java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    @Override // com.tencent.bugly.idasc.crashreport.crash.jni.NativeExceptionHandler
    public final CrashDetailBean packageCrashDatas(String str, String str2, long j10, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, byte[] bArr, Map<String, String> map, boolean z10, boolean z11) {
        int i10;
        String str12;
        int indexOf;
        boolean i11 = at.a().i();
        if (i11) {
            al.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.f39410b = 1;
        crashDetailBean.f39413e = this.f39740c.g();
        aa aaVar = this.f39740c;
        crashDetailBean.f39414f = aaVar.f39485o;
        crashDetailBean.f39415g = aaVar.q();
        crashDetailBean.f39421m = this.f39740c.f();
        crashDetailBean.f39422n = str3;
        crashDetailBean.f39423o = i11 ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        crashDetailBean.f39424p = str4;
        String str13 = str5 != null ? str5 : "";
        crashDetailBean.f39425q = str13;
        crashDetailBean.f39426r = j10;
        crashDetailBean.f39429u = ap.c(str13.getBytes());
        crashDetailBean.A = str;
        crashDetailBean.B = str2;
        crashDetailBean.L = this.f39740c.s();
        crashDetailBean.f39416h = this.f39740c.p();
        crashDetailBean.f39417i = this.f39740c.A();
        crashDetailBean.f39430v = str8;
        String dumpFilePath = NativeCrashHandler.getInstance() != null ? NativeCrashHandler.getDumpFilePath() : null;
        String a10 = be.a(dumpFilePath, str8);
        if (!ap.b(a10)) {
            crashDetailBean.Z = a10;
        }
        crashDetailBean.f39409aa = be.b(dumpFilePath);
        crashDetailBean.f39431w = be.a(str9, at.f39637f, at.f39642k, at.f39647p);
        crashDetailBean.f39432x = be.a(str10, at.f39637f, null, true);
        crashDetailBean.N = str7;
        crashDetailBean.O = str6;
        crashDetailBean.P = str11;
        crashDetailBean.F = this.f39740c.k();
        crashDetailBean.G = this.f39740c.j();
        crashDetailBean.H = this.f39740c.l();
        crashDetailBean.I = ab.b(this.f39738a);
        crashDetailBean.J = ab.g();
        crashDetailBean.K = ab.h();
        if (z10) {
            crashDetailBean.C = ab.j();
            crashDetailBean.D = ab.f();
            crashDetailBean.E = ab.l();
            crashDetailBean.f39433y = ao.a();
            aa aaVar2 = this.f39740c;
            crashDetailBean.Q = aaVar2.f39465a;
            crashDetailBean.R = aaVar2.a();
            crashDetailBean.f39434z = ap.a(this.f39740c.Q, at.f39639h);
            int indexOf2 = crashDetailBean.f39425q.indexOf("java:\n");
            if (indexOf2 > 0 && (i10 = indexOf2 + 6) < crashDetailBean.f39425q.length()) {
                String str14 = crashDetailBean.f39425q;
                String substring = str14.substring(i10, str14.length() - 1);
                if (substring.length() > 0 && crashDetailBean.f39434z.containsKey(crashDetailBean.B) && (indexOf = (str12 = crashDetailBean.f39434z.get(crashDetailBean.B)).indexOf(substring)) > 0) {
                    String substring2 = str12.substring(indexOf);
                    crashDetailBean.f39434z.put(crashDetailBean.B, substring2);
                    crashDetailBean.f39425q = crashDetailBean.f39425q.substring(0, i10);
                    crashDetailBean.f39425q += substring2;
                }
            }
            if (str == null) {
                crashDetailBean.A = this.f39740c.f39474d;
            }
            crashDetailBean.U = this.f39740c.z();
            aa aaVar3 = this.f39740c;
            crashDetailBean.V = aaVar3.f39494x;
            crashDetailBean.W = aaVar3.t();
            crashDetailBean.X = this.f39740c.y();
        } else {
            crashDetailBean.C = -1L;
            crashDetailBean.D = -1L;
            crashDetailBean.E = -1L;
            if (crashDetailBean.f39431w == null) {
                crashDetailBean.f39431w = "This crash occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
            }
            crashDetailBean.Q = -1L;
            crashDetailBean.U = -1;
            crashDetailBean.V = -1;
            crashDetailBean.W = map;
            crashDetailBean.X = this.f39740c.y();
            crashDetailBean.f39434z = null;
            if (str == null) {
                crashDetailBean.A = "unknown(record)";
            }
            if (bArr != null) {
                crashDetailBean.f39433y = bArr;
            }
        }
        return crashDetailBean;
    }
}
