package com.huawei.quickcard.action;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.quickcard.base.log.CardLogUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class DeeplinkAction extends AbsQuickCardAction {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33269a = "DeeplinkAction";

    public void openUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(268435456);
        Context androidContext = getAndroidContext();
        if (androidContext != null) {
            try {
                androidContext.startActivity(intent);
            } catch (ActivityNotFoundException e2) {
                CardLogUtils.w(f33269a, "DeeplinkAction ActivityNotFoundException exception.", e2);
            }
        }
    }
}
