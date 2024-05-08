package com.vivo.push.c;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.util.u;
import java.util.HashMap;

/* compiled from: CoreConfigManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f46137a;

    /* renamed from: b, reason: collision with root package name */
    private HashMap<String, String> f46138b = new HashMap<>();

    public a(Context context) {
        this.f46137a = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.content.ContentProviderClient, android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int e() {
        /*
            Method dump skipped, instructions count: 216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.c.a.e():int");
    }

    public final int a() {
        int a10 = a(1);
        u.d("CoreConfigManager", "isSupportNewControlStrategies : ".concat(String.valueOf(a10)));
        return a10;
    }

    public final int b() {
        int a10 = a(4);
        u.d("CoreConfigManager", "isSupportSyncProfileInfo : ".concat(String.valueOf(a10)));
        return a10;
    }

    public final boolean c() {
        int a10 = a(8);
        u.d("CoreConfigManager", "isSupportdeleteRegid : ".concat(String.valueOf(a10)));
        return a10 == 0;
    }

    public final boolean d() {
        int a10 = a(16);
        u.d("CoreConfigManager", "isSupportQueryCurrentAppState : ".concat(String.valueOf(a10)));
        return a10 == 0;
    }

    /* JADX WARN: Not initialized variable reg: 8, insn: 0x00b0: MOVE (r3 I:??[OBJECT, ARRAY]) = (r8 I:??[OBJECT, ARRAY]), block:B:71:0x00af */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a1 A[Catch: Exception -> 0x008e, TRY_ENTER, TryCatch #0 {Exception -> 0x008e, blocks: (B:29:0x0083, B:32:0x008a, B:40:0x00a1, B:42:0x00a6, B:44:0x00aa), top: B:2:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r15, java.lang.String r16) {
        /*
            Method dump skipped, instructions count: 199
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.c.a.a(android.content.Context, java.lang.String):java.lang.String");
    }

    private int a(int i10) {
        int e2 = e();
        if (e2 != 0) {
            return e2;
        }
        HashMap<String, String> hashMap = this.f46138b;
        if (hashMap == null || hashMap.size() == 0) {
            return 8006;
        }
        String str = this.f46138b.get("pushSupport");
        if (TextUtils.isEmpty(str)) {
            return 2;
        }
        try {
            return (i10 & Integer.parseInt(str)) > 0 ? 0 : 1;
        } catch (Exception unused) {
            return 8007;
        }
    }
}
