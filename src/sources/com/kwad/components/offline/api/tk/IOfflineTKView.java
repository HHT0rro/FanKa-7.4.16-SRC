package com.kwad.components.offline.api.tk;

import android.app.Activity;
import android.view.View;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface IOfflineTKView {
    void bindActivity(Activity activity);

    Object callJSFunc(String str, String str2, IOfflineTKFunction iOfflineTKFunction);

    View getView();

    boolean onBackPressed();

    void render();

    void setData(Object... objArr);
}
