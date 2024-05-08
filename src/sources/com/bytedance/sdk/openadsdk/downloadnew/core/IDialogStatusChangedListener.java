package com.bytedance.sdk.openadsdk.downloadnew.core;

import android.content.DialogInterface;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface IDialogStatusChangedListener {
    void onCancel(DialogInterface dialogInterface);

    void onNegativeBtnClick(DialogInterface dialogInterface);

    void onPositiveBtnClick(DialogInterface dialogInterface);
}
