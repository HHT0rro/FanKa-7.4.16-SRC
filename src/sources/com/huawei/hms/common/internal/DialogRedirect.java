package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class DialogRedirect implements DialogInterface.OnClickListener {
    public static DialogRedirect getInstance(Activity activity, Intent intent, int i10) {
        return new DialogRedirectImpl(intent, activity, i10);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i10) {
        try {
            try {
                redirect();
                if (dialogInterface == null) {
                }
            } catch (Throwable unused) {
                HMSLog.e("DialogRedirect", "Failed to start resolution intent");
            }
        } finally {
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
        }
    }

    public abstract void redirect();
}
