package com.vivo.push.model;

import android.content.Intent;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class NotifyArriveCallbackByUser {
    private Intent mIntent;
    private boolean mIsIntercept;

    public NotifyArriveCallbackByUser(Intent intent, boolean z10) {
        this.mIntent = intent;
        this.mIsIntercept = z10;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    public boolean isIntercept() {
        return this.mIsIntercept;
    }
}
