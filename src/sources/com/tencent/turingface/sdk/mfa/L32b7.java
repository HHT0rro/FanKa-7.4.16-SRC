package com.tencent.turingface.sdk.mfa;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class L32b7 {

    /* renamed from: a, reason: collision with root package name */
    public static final String f45625a = kC0XR.a(kC0XR.f45831b);

    /* renamed from: b, reason: collision with root package name */
    public static final String f45626b = kC0XR.a(kC0XR.f45834c);

    /* renamed from: c, reason: collision with root package name */
    public static final String f45627c = kC0XR.a(kC0XR.f45837d);

    /* renamed from: d, reason: collision with root package name */
    public static final String f45628d = kC0XR.a(kC0XR.f45839e);

    /* renamed from: e, reason: collision with root package name */
    public static final String f45629e = kC0XR.a(kC0XR.f45841f);

    /* renamed from: f, reason: collision with root package name */
    public static long f45630f = 0;

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f45631g = {"^/data/user/\\d+$", "^/data/data$"};

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class spXPg {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f45632a;

        /* renamed from: b, reason: collision with root package name */
        public final String f45633b;

        public spXPg(boolean z10, String str) {
            this.f45632a = z10;
            this.f45633b = str;
        }
    }

    public static String a(Context context, String str) {
        String str2;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("_");
        try {
            str2 = context.getPackageManager().getApplicationInfo(str, 0).sourceDir;
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = "";
        }
        try {
            sb2.append((String) ((ArrayList) com.tencent.turingcam.oqKCa.a(new File(str2))).get(0));
        } catch (Throwable unused2) {
            sb2.append("");
        }
        sb2.append("_");
        long j10 = -1;
        if (!TextUtils.isEmpty(str2)) {
            File file = new File(str2);
            if (file.exists()) {
                j10 = file.length();
            }
        }
        sb2.append(j10);
        sb2.append("_");
        sb2.append(Process.myUid());
        return sb2.toString();
    }

    public static boolean a() {
        try {
            return 999 == Process.myUid() / 100000;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(30:1|(1:3)(2:179|(1:181)(5:182|(1:(2:184|(2:187|188)(1:186))(2:208|209))|189|(2:201|(1:207))(1:195)|(1:200)(1:199)))|4|(1:178)(1:8)|9|(1:11)(12:96|97|98|99|100|(3:101|102|(1:163)(3:104|(1:162)(7:106|107|(4:109|(2:118|(2:120|121)(2:122|(1:124)(5:125|126|127|128|(2:130|(1:132)(0))(1:152))))|112|113)(4:153|(2:158|(2:160|161))|112|113)|135|(2:139|(4:141|(1:149)|145|(1:147)(1:148)))|150|(0)(0))|114))|151|134|135|(3:137|139|(0))|150|(0)(0))|12|(1:14)|15|(1:16)|(23:78|79|(20:85|86|(1:90)|52|24|(1:26)|27|28|29|(1:31)|32|(1:34)(1:48)|35|(1:37)|(1:39)|40|(2:43|41)|44|45|46)|92|86|(2:88|90)|52|24|(0)|27|28|29|(0)|32|(0)(0)|35|(0)|(0)|40|(1:41)|44|45|46)(2:18|(19:20|(18:22|23|24|(0)|27|28|29|(0)|32|(0)(0)|35|(0)|(0)|40|(1:41)|44|45|46)|52|24|(0)|27|28|29|(0)|32|(0)(0)|35|(0)|(0)|40|(1:41)|44|45|46)(2:53|(19:55|(18:57|23|24|(0)|27|28|29|(0)|32|(0)(0)|35|(0)|(0)|40|(1:41)|44|45|46)|52|24|(0)|27|28|29|(0)|32|(0)(0)|35|(0)|(0)|40|(1:41)|44|45|46)(2:58|(19:60|(18:62|23|24|(0)|27|28|29|(0)|32|(0)(0)|35|(0)|(0)|40|(1:41)|44|45|46)|52|24|(0)|27|28|29|(0)|32|(0)(0)|35|(0)|(0)|40|(1:41)|44|45|46)(2:63|(2:65|(18:67|23|24|(0)|27|28|29|(0)|32|(0)(0)|35|(0)|(0)|40|(1:41)|44|45|46)(19:68|(1:70)|52|24|(0)|27|28|29|(0)|32|(0)(0)|35|(0)|(0)|40|(1:41)|44|45|46))(19:73|(18:77|23|24|(0)|27|28|29|(0)|32|(0)(0)|35|(0)|(0)|40|(1:41)|44|45|46)|52|24|(0)|27|28|29|(0)|32|(0)(0)|35|(0)|(0)|40|(1:41)|44|45|46)))))|71|23|24|(0)|27|28|29|(0)|32|(0)(0)|35|(0)|(0)|40|(1:41)|44|45|46|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0199, code lost:
    
        r13 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x039a, code lost:
    
        r11 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0417 A[LOOP:0: B:41:0x0411->B:43:0x0417, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x024d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v45, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r0v46 */
    /* JADX WARN: Type inference failed for: r0v47 */
    /* JADX WARN: Type inference failed for: r0v51, types: [int] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v13, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v9, types: [int] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x0344 -> B:24:0x0345). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r17) {
        /*
            Method dump skipped, instructions count: 1088
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingface.sdk.mfa.L32b7.a(android.content.Context):java.lang.String");
    }
}
