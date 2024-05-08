package com.wangmai.adIdUtils.oaid.impl;

import android.app.KeyguardManager;
import android.content.Context;
import com.wangmai.adIdUtils.oaid.IGetter;
import com.wangmai.adIdUtils.oaid.IOAID;
import com.wangmai.adIdUtils.oaid.OAIDException;
import com.wangmai.adIdUtils.oaid.OAIDLog;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class CooseaImpl implements IOAID {
    public final Context context;
    public final KeyguardManager keyguardManager;

    public CooseaImpl(Context context) {
        this.context = context;
        this.keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
    }

    @Override // com.wangmai.adIdUtils.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        KeyguardManager keyguardManager = this.keyguardManager;
        if (keyguardManager == null) {
            iGetter.onOAIDGetError(new OAIDException("KeyguardManager not found"));
            return;
        }
        try {
            Object invoke = keyguardManager.getClass().getDeclaredMethod("obtainOaid", new Class[0]).invoke(this.keyguardManager, new Object[0]);
            if (invoke != null) {
                String obj = invoke.toString();
                OAIDLog.print("OAID obtain success: " + obj);
                iGetter.onOAIDGetComplete(obj);
                return;
            }
            throw new OAIDException("OAID obtain failed");
        } catch (Exception e2) {
            OAIDLog.print(e2);
        }
    }

    @Override // com.wangmai.adIdUtils.oaid.IOAID
    public boolean supported() {
        KeyguardManager keyguardManager;
        if (this.context == null || (keyguardManager = this.keyguardManager) == null) {
            return false;
        }
        try {
            Object invoke = keyguardManager.getClass().getDeclaredMethod("isSupported", new Class[0]).invoke(this.keyguardManager, new Object[0]);
            Objects.requireNonNull(invoke);
            return ((Boolean) invoke).booleanValue();
        } catch (Exception e2) {
            OAIDLog.print(e2);
            return false;
        }
    }
}
