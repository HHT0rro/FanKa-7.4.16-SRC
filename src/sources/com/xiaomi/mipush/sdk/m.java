package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.o0;
import com.xiaomi.push.fk;
import com.xiaomi.push.ir;
import com.xiaomi.push.ix;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public static Map<String, o0.a> f47030a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public static Map<String, Long> f47031b = new HashMap();

    public static void a(Context context, ir irVar) {
        o0.a aVar;
        String b4 = irVar.b();
        if (irVar.a() == 0 && (aVar = f47030a.get(b4)) != null) {
            aVar.e(irVar.f521e, irVar.f522f);
            o0.c(context).h(b4, aVar);
        }
        ArrayList arrayList = null;
        if (!TextUtils.isEmpty(irVar.f521e)) {
            arrayList = new ArrayList();
            arrayList.add(irVar.f521e);
        }
        p.a(fk.COMMAND_REGISTER.f266a, arrayList, irVar.f511a, irVar.f520d, null);
    }

    public static void b(Context context, ix ixVar) {
        p.a(fk.COMMAND_UNREGISTER.f266a, null, ixVar.f587a, ixVar.f595d, null);
        ixVar.a();
    }
}
