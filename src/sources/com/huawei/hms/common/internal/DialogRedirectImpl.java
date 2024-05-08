package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Intent;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class DialogRedirectImpl extends DialogRedirect {

    /* renamed from: a, reason: collision with root package name */
    private final Activity f29715a;

    /* renamed from: b, reason: collision with root package name */
    private final int f29716b;

    /* renamed from: c, reason: collision with root package name */
    private final Intent f29717c;

    public DialogRedirectImpl(Intent intent, Activity activity, int i10) {
        this.f29717c = intent;
        this.f29715a = activity;
        this.f29716b = i10;
    }

    @Override // com.huawei.hms.common.internal.DialogRedirect
    public final void redirect() {
        Activity activity;
        Intent intent = this.f29717c;
        if (intent == null || (activity = this.f29715a) == null) {
            return;
        }
        activity.startActivityForResult(intent, this.f29716b);
    }
}
