package com.vivo.push.d.a;

import android.text.TextUtils;
import com.vivo.push.restructure.request.a.a.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

/* compiled from: SyncProfileInfoInputDS.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b implements com.vivo.push.restructure.request.a.a.b {

    /* renamed from: a, reason: collision with root package name */
    public static final b.a<b> f46149a = new c();

    /* renamed from: b, reason: collision with root package name */
    private String f46150b;

    /* renamed from: c, reason: collision with root package name */
    private List<com.vivo.push.d.b> f46151c;

    /* renamed from: d, reason: collision with root package name */
    private int f46152d;

    public b(String str, List<com.vivo.push.d.b> list, int i10) {
        new ArrayList();
        this.f46150b = str;
        this.f46152d = i10;
        this.f46151c = list;
    }

    @Override // com.vivo.push.restructure.request.a.a.b
    public final void a(com.vivo.push.restructure.request.a.a.a aVar) {
        aVar.a(this.f46150b);
        aVar.a(this.f46152d);
        aVar.a(this.f46151c);
    }

    public final List<String> a() {
        ArrayList arrayList = new ArrayList();
        Iterator<com.vivo.push.d.b> iterator2 = this.f46151c.iterator2();
        while (iterator2.hasNext()) {
            String b4 = iterator2.next().b();
            if (!TextUtils.isEmpty(b4)) {
                arrayList.add(b4);
            }
        }
        return arrayList;
    }

    public b(com.vivo.push.restructure.request.a.a.a aVar) throws JSONException {
        this.f46151c = new ArrayList();
        this.f46150b = aVar.c();
        this.f46152d = aVar.a();
        aVar.a(com.vivo.push.d.b.f46153a, this.f46151c);
    }
}
