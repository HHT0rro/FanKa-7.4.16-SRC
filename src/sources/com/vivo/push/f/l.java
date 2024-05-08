package com.vivo.push.f;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OnDelTagsReceiveTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class l extends aa {
    public l(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    public final void a(com.vivo.push.v vVar) {
        com.vivo.push.b.t tVar = (com.vivo.push.b.t) vVar;
        ArrayList<String> d10 = tVar.d();
        List<String> e2 = tVar.e();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int i10 = tVar.i();
        com.vivo.push.util.u.c("OnDelTagsTask", "doTask,删除成功的标签 = " + ((Object) d10) + " 删除失败的= " + ((Object) e2) + " 错误码= " + i10);
        String h10 = tVar.h();
        if (d10 != null) {
            for (String str : d10) {
                if (str.startsWith("ali/")) {
                    arrayList2.add(str.replace("ali/", ""));
                } else if (str.startsWith("tag/")) {
                    arrayList.add(str.replace("tag/", ""));
                }
            }
        }
        if (e2 != null) {
            for (String str2 : e2) {
                if (str2.startsWith("ali/")) {
                    arrayList4.add(str2.replace("ali/", ""));
                } else if (str2.startsWith("tag/")) {
                    arrayList3.add(str2.replace("tag/", ""));
                }
            }
        }
        if (arrayList.size() > 0 || arrayList3.size() > 0) {
            com.vivo.push.util.u.c("OnDelTagsTask", "doTask1,删除成功的别名 = " + ((Object) arrayList) + " 删除失败的别名= " + ((Object) arrayList3) + " 错误码= " + i10);
            if (arrayList.size() > 0) {
                com.vivo.push.m.a();
                com.vivo.push.m.b(arrayList);
            }
            com.vivo.push.m.a().a(tVar.h(), i10);
            com.vivo.push.t.b(new m(this, i10, arrayList, arrayList3, h10));
        }
        if (arrayList2.size() > 0 || arrayList4.size() > 0) {
            com.vivo.push.util.u.c("OnDelTagsTask", "doTask1,删除成功的标签 = " + ((Object) arrayList) + " 删除失败的标签= " + ((Object) arrayList3) + " 错误码= " + i10);
            if (arrayList2.size() > 0) {
                com.vivo.push.m.a().c(arrayList2);
            }
            com.vivo.push.m.a().a(tVar.h(), i10);
            com.vivo.push.t.b(new n(this, i10, arrayList2, arrayList4, h10));
        }
    }
}
