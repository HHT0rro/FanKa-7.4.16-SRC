package com.tencent.turingface.sdk.mfa;

import android.window.TaskConstants;
import com.tencent.turingface.sdk.mfa.BfUKf;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class A48DB {

    /* renamed from: a, reason: collision with root package name */
    public static final A48DB f45525a = new A48DB();

    /* renamed from: b, reason: collision with root package name */
    public CvowV f45526b;

    public final tmnyR a(byte[] bArr) {
        tmnyR tmnyr;
        BfUKf bfUKf = this.f45526b.f45540b;
        if (bfUKf == null) {
            return tmnyR.a(TaskConstants.TASK_CHILD_LAYER_LETTERBOX_BACKGROUND);
        }
        try {
            System.currentTimeMillis();
            BfUKf.spXPg onHttpPost = bfUKf.onHttpPost(bArr);
            if (onHttpPost == null) {
                tmnyr = tmnyR.a(TaskConstants.TASK_CHILD_LAYER_LETTERBOX_BACKGROUND);
            } else {
                int i10 = onHttpPost.errCode;
                if (i10 != 0) {
                    tmnyr = tmnyR.a(i10 + TaskConstants.TASK_CHILD_LAYER_LETTERBOX_BACKGROUND);
                } else {
                    tmnyr = new tmnyR(0, onHttpPost.data, 0, 0);
                }
            }
            return tmnyr;
        } catch (Throwable unused) {
            return tmnyR.a(TaskConstants.TASK_CHILD_LAYER_LETTERBOX_BACKGROUND);
        }
    }
}
