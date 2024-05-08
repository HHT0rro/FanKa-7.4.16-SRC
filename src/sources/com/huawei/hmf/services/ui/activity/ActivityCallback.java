package com.huawei.hmf.services.ui.activity;

import android.app.Activity;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class ActivityCallback<T> {
    private Activity mActivity;

    public <R extends Activity> R getActivity() {
        return (R) this.mActivity;
    }

    public abstract void onResult(int i10, T t2);

    public void onResult(Activity activity, int i10, T t2) {
        this.mActivity = activity;
        onResult(i10, t2);
    }
}
