package com.huawei.hms.api;

import android.content.Intent;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class UserRecoverableException extends Exception {
    private final Intent mIntent;

    public UserRecoverableException(String str, Intent intent) {
        super(str);
        this.mIntent = intent;
    }

    public Intent getIntent() {
        return new Intent(this.mIntent);
    }
}
