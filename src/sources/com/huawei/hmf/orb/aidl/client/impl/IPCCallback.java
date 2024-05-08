package com.huawei.hmf.orb.aidl.client.impl;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hmf.orb.IMessageEntity;
import com.huawei.hmf.orb.aidl.DatagramTransport;
import com.huawei.hmf.orb.aidl.IAIDLCallback;
import com.huawei.hmf.orb.aidl.communicate.DataBuffer;
import com.huawei.hmf.orb.aidl.communicate.ResponseHeader;
import com.huawei.hmf.services.codec.MessageCodec;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class IPCCallback extends IAIDLCallback.Stub {
    private static final String TAG = "IPCCallback";
    private final DatagramTransport.CallBack mCallback;
    private final Class<? extends IMessageEntity> mResponseClass;

    public IPCCallback(Class<? extends IMessageEntity> cls, DatagramTransport.CallBack callBack) {
        this.mResponseClass = cls;
        this.mCallback = callBack;
    }

    @Override // com.huawei.hmf.orb.aidl.IAIDLCallback
    public void call(DataBuffer dataBuffer) throws RemoteException {
        if (dataBuffer != null && !TextUtils.isEmpty(dataBuffer.URI)) {
            MessageCodec messageCodec = new MessageCodec();
            ResponseHeader responseHeader = new ResponseHeader();
            messageCodec.decode(dataBuffer.header, (Bundle) responseHeader);
            IMessageEntity iMessageEntity = null;
            if (dataBuffer.getBodySize() > 0 && (iMessageEntity = newResponseInstance()) != null) {
                messageCodec.decode(dataBuffer.getBody(), (Bundle) iMessageEntity);
            }
            this.mCallback.onCallback(responseHeader.getStatusCode(), iMessageEntity);
            return;
        }
        throw new RemoteException();
    }

    public IMessageEntity newResponseInstance() {
        Class<? extends IMessageEntity> cls = this.mResponseClass;
        if (cls == null) {
            return null;
        }
        try {
            return cls.newInstance();
        } catch (IllegalAccessException | InstantiationException unused) {
            return null;
        }
    }
}
