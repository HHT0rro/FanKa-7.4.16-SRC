package com.hailiang.advlib.core;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.annotation.Keep;

@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface IADBrowser {
    void doWhenReflect(Activity activity, Bundle bundle);

    void onActivityResultRef(int i10, int i11, Intent intent);

    boolean onKeyEvent(int i10, KeyEvent keyEvent);

    void whenPermDialogReturns(int i10, String[] strArr, int[] iArr);
}
