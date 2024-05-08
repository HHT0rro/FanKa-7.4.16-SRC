package com.kwad.components.offline.api;

import android.content.Context;
import com.kwad.components.offline.api.core.IOfflineHostApi;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class OfflineHostProvider {
    private Context mContext;
    private IOfflineHostApi mOfflineHostApi;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class Holder {
        private static final OfflineHostProvider sInstance = new OfflineHostProvider();

        private Holder() {
        }
    }

    private OfflineHostProvider() {
    }

    public static OfflineHostProvider get() {
        return Holder.sInstance;
    }

    public static IOfflineHostApi getApi() {
        return get().mOfflineHostApi;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void init(Context context, IOfflineHostApi iOfflineHostApi) {
        this.mContext = context;
        this.mOfflineHostApi = iOfflineHostApi;
    }
}
