package com.hailiang.advlib.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.annotation.Keep;
import com.hailiang.advlib.ui.front.InciteVideoListener;

@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface IInciteAd {
    void ReportBootstrapFeature(int[] iArr);

    void doWhenReflect(Activity activity);

    void onActivityResultRef(int i10, int i11, Intent intent);

    void onDestroyRef(Activity activity);

    boolean onKeyEvent(int i10, KeyEvent keyEvent);

    void onPauseRef(Activity activity);

    void onResumeRef(Activity activity);

    void onStartRef(Activity activity);

    void onStopRef(Activity activity);

    void showInciteVideo(Context context, ICliBundle iCliBundle, Bundle bundle, InciteVideoListener inciteVideoListener);

    void whenPermDialogReturns(int i10, String[] strArr, int[] iArr);
}
