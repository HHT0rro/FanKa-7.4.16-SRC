package com.wangmai.adIdUtils.oaid.impl;

import com.wangmai.adIdUtils.oaid.IGetter;
import com.wangmai.adIdUtils.oaid.IOAID;
import com.wangmai.adIdUtils.oaid.OAIDException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DefaultImpl implements IOAID {
    @Override // com.wangmai.adIdUtils.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (iGetter == null) {
            return;
        }
        iGetter.onOAIDGetError(new OAIDException("Unsupported"));
    }

    @Override // com.wangmai.adIdUtils.oaid.IOAID
    public boolean supported() {
        return false;
    }
}
