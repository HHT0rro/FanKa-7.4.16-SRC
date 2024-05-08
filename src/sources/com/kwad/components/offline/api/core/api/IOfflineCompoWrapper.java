package com.kwad.components.offline.api.core.api;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class IOfflineCompoWrapper {
    public String mOfflinePackageName;

    public IOfflineCompoWrapper(String str) {
        this.mOfflinePackageName = str;
    }

    @Deprecated
    public abstract Context unwrapContextIfNeed(Context context);

    public abstract Context wrapContextIfNeed(@Nullable Context context);

    public abstract Application wrapGetApplication(Context context);

    public abstract LayoutInflater wrapInflaterIfNeed(LayoutInflater layoutInflater);
}
