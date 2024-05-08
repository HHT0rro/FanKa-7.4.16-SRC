package com.huawei.hmf.orb.aidl.communicate;

import android.os.Bundle;
import android.os.RemoteException;
import com.huawei.hmf.orb.IMessageEntity;
import com.huawei.hmf.orb.aidl.IAIDLCallback;
import com.huawei.hmf.services.codec.MessageCodec;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class AIDLResponse {
    private static final String TAG = "AIDLResponse";
    private IAIDLCallback callBack;
    public String URI = "void";
    public int version = 1;

    public AIDLResponse(IAIDLCallback iAIDLCallback) {
        this.callBack = iAIDLCallback;
    }

    public final void call(IMessageEntity iMessageEntity) {
        call(0, iMessageEntity);
    }

    public final void failure(int i10) {
        call(i10, null);
    }

    public String getURI() {
        return this.URI;
    }

    public void setProtocol(int i10) {
        this.version = i10;
    }

    public void setURI(String str) {
        this.URI = str;
    }

    public void call(int i10, IMessageEntity iMessageEntity) {
        DataBuffer dataBuffer = new DataBuffer(this.URI, this.version);
        MessageCodec find = CodecLookup.find(dataBuffer.getProtocol());
        if (iMessageEntity != null) {
            dataBuffer.URI = iMessageEntity.getClass().getName();
            dataBuffer.addBody(find.encode(iMessageEntity, new Bundle()));
        }
        dataBuffer.header = find.encode(new ResponseHeader(i10), new Bundle());
        try {
            this.callBack.call(dataBuffer);
        } catch (RemoteException | Exception unused) {
        }
    }
}
