package com.kwad.components.offline.c.a;

import com.kwad.components.offline.api.tk.IOfflineApkLoader;
import com.kwad.components.offline.api.tk.IOfflineApkLoaderHolder;
import com.kwad.sdk.components.j;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e implements IOfflineApkLoaderHolder {
    private j Zk;

    public e(j jVar) {
        this.Zk = jVar;
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoaderHolder
    public final IOfflineApkLoader getApkLoader(int i10) {
        return new d(this.Zk.aS(i10));
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoaderHolder
    public final IOfflineApkLoader getApkLoader(String str) {
        return new d(this.Zk.aT(str));
    }
}
