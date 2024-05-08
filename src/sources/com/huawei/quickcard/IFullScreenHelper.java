package com.huawei.quickcard;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface IFullScreenHelper {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface IFullScreenListener {
        void beforeExitFullScreen();

        void onExitFullScreen();
    }

    boolean enterFullScreen(Context context, @NonNull View view, int i10, Object... objArr);

    boolean exitFullScreen();

    FullScreenExtendedParams getExtendedParams();

    void setFullScreenListener(IFullScreenListener iFullScreenListener);
}
