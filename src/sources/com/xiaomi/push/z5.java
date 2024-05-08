package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.r;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class z5 extends r.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f48540a;

    public z5(Context context) {
        this.f48540a = context;
    }

    @Override // com.xiaomi.push.r.b
    public void b() {
        Object obj;
        ArrayList arrayList;
        List list;
        List list2;
        obj = y5.f48514d;
        synchronized (obj) {
            list = y5.f48515e;
            arrayList = new ArrayList(list);
            list2 = y5.f48515e;
            list2.clear();
        }
        y5.o(this.f48540a, arrayList);
    }
}
