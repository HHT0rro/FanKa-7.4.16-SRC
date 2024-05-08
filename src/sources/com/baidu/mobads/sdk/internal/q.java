package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.aa;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private static volatile q f10296a;

    /* renamed from: b, reason: collision with root package name */
    private List<aa.a> f10297b = new CopyOnWriteArrayList();

    private q() {
    }

    public static q a() {
        if (f10296a == null) {
            synchronized (q.class) {
                if (f10296a == null) {
                    f10296a = new q();
                }
            }
        }
        return f10296a;
    }

    private void b(aa.a aVar) {
        if (this.f10297b.contains(aVar)) {
            this.f10297b.remove(aVar);
        }
    }

    public void a(aa.a aVar) {
        if (aVar == null || this.f10297b.contains(aVar)) {
            return;
        }
        this.f10297b.add(aVar);
    }

    public void a(int i10) {
        for (aa.a aVar : this.f10297b) {
            if (i10 == 1) {
                aVar.onSuccess();
            } else if (i10 == 2) {
                aVar.onFailure();
            }
            b(aVar);
        }
    }
}
