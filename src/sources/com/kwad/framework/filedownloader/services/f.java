package com.kwad.framework.filedownloader.services;

import android.content.Intent;
import com.baidu.mobads.sdk.internal.bk;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class f {
    public static void f(com.kwad.framework.filedownloader.d.c cVar) {
        if (cVar != null) {
            if (cVar.tV() == -3) {
                Intent intent = new Intent("filedownloader.intent.action.completed");
                intent.putExtra(bk.f9900i, cVar);
                com.kwad.framework.filedownloader.f.c.wL().sendBroadcast(intent);
                return;
            }
            throw new IllegalStateException();
        }
        throw new IllegalArgumentException();
    }
}
