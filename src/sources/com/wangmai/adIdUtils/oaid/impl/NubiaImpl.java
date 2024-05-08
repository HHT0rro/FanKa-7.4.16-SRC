package com.wangmai.adIdUtils.oaid.impl;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.wangmai.adIdUtils.oaid.IGetter;
import com.wangmai.adIdUtils.oaid.IOAID;
import com.wangmai.adIdUtils.oaid.OAIDException;
import com.wangmai.adIdUtils.oaid.OAIDLog;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class NubiaImpl implements IOAID {
    public final Context context;

    public NubiaImpl(Context context) {
        this.context = context;
    }

    @Override // com.wangmai.adIdUtils.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        if (!supported()) {
            OAIDLog.print("Only supports Android 10.0 and above for Nubia");
            iGetter.onOAIDGetError(new OAIDException("Only supports Android 10.0 and above for Nubia"));
            return;
        }
        try {
            ContentProviderClient acquireContentProviderClient = this.context.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            if (acquireContentProviderClient == null) {
                return;
            }
            Bundle call = acquireContentProviderClient.call("getOAID", null, null);
            if (Build.VERSION.SDK_INT >= 24) {
                acquireContentProviderClient.close();
            } else {
                acquireContentProviderClient.release();
            }
            if (call != null) {
                String string = call.getInt("code", -1) == 0 ? call.getString("id") : null;
                if (string != null && string.length() != 0) {
                    OAIDLog.print("OAID query success: " + string);
                    iGetter.onOAIDGetComplete(string);
                    return;
                }
                throw new OAIDException("OAID query failed: " + call.getString("message"));
            }
            throw new OAIDException("OAID query failed: bundle is null");
        } catch (Exception e2) {
            OAIDLog.print(e2);
            iGetter.onOAIDGetError(e2);
        }
    }

    @Override // com.wangmai.adIdUtils.oaid.IOAID
    public boolean supported() {
        return Build.VERSION.SDK_INT >= 29;
    }
}
