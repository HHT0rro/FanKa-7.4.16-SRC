package com.kwad.components.core.n.b.a;

import android.content.Context;
import com.kwad.components.offline.api.core.network.INetworkChangeListener;
import com.kwad.components.offline.api.core.network.INetworkManager;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bn;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class i implements INetworkManager {
    private List<INetworkChangeListener> MM = new CopyOnWriteArrayList();
    private NetworkMonitor.a MN;

    private void ad(final Context context) {
        if (this.MN != null) {
            return;
        }
        this.MN = new NetworkMonitor.a() { // from class: com.kwad.components.core.n.b.a.i.1
            @Override // com.kwad.sdk.core.NetworkMonitor.a
            public final void a(NetworkMonitor.NetworkState networkState) {
                bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.n.b.a.i.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        int networkType = i.this.getNetworkType(context);
                        Iterator iterator2 = i.this.MM.iterator2();
                        while (iterator2.hasNext()) {
                            ((INetworkChangeListener) iterator2.next()).networkChange(networkType);
                        }
                    }
                });
            }
        };
        NetworkMonitor.getInstance().a(context, this.MN);
    }

    @Override // com.kwad.components.offline.api.core.network.INetworkManager
    public final void addNetworkChangeListener(Context context, INetworkChangeListener iNetworkChangeListener) {
        if (iNetworkChangeListener != null) {
            ad(context);
            this.MM.add(iNetworkChangeListener);
        }
    }

    @Override // com.kwad.components.offline.api.core.network.INetworkManager
    public final int getNetworkType(Context context) {
        return ag.ck(context);
    }

    @Override // com.kwad.components.offline.api.core.network.INetworkManager
    public final void removeNetworkChangeListener(Context context, INetworkChangeListener iNetworkChangeListener) {
        this.MM.remove(iNetworkChangeListener);
    }
}
