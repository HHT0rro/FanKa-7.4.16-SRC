package com.wangmai.adIdUtils.oaid.impl;

import android.content.Context;
import com.wangmai.adIdUtils.oaid.IGetter;
import com.wangmai.adIdUtils.oaid.IOAID;
import com.wangmai.adIdUtils.oaid.OAIDException;
import com.wangmai.adIdUtils.oaid.OAIDLog;
import java.lang.reflect.InvocationTargetException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class XiaomiImpl implements IOAID {
    public final Context context;
    public Class<?> idProviderClass;
    public Object idProviderImpl;

    public XiaomiImpl(Context context) {
        this.context = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.idProviderClass = cls;
            this.idProviderImpl = cls.newInstance();
        } catch (Exception e2) {
            OAIDLog.print(e2);
        }
    }

    private String getOAID() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return (String) this.idProviderClass.getMethod("getOAID", Context.class).invoke(this.idProviderImpl, this.context);
    }

    @Override // com.wangmai.adIdUtils.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        if (this.idProviderClass != null && this.idProviderImpl != null) {
            try {
                String oaid = getOAID();
                if (oaid != null && oaid.length() != 0) {
                    OAIDLog.print("OAID query success: " + oaid);
                    iGetter.onOAIDGetComplete(oaid);
                    return;
                }
                throw new OAIDException("OAID query failed");
            } catch (Exception e2) {
                OAIDLog.print(e2);
                iGetter.onOAIDGetError(e2);
                return;
            }
        }
        iGetter.onOAIDGetError(new OAIDException("Xiaomi IdProvider not exists"));
    }

    @Override // com.wangmai.adIdUtils.oaid.IOAID
    public boolean supported() {
        return this.idProviderImpl != null;
    }
}
