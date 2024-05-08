package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.mm.opensdk.diffdev.OAuthListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class c implements Runnable {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ b f45092g;

    public c(b bVar) {
        this.f45092g = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List list;
        ArrayList arrayList = new ArrayList();
        list = this.f45092g.f45091f.f45088c;
        arrayList.addAll(list);
        Iterator<E> iterator2 = arrayList.iterator2();
        while (iterator2.hasNext()) {
            ((OAuthListener) iterator2.next()).onQrcodeScanned();
        }
    }
}
