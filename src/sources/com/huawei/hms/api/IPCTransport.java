package com.huawei.hms.api;

import android.os.Bundle;
import com.huawei.hms.core.aidl.CodecLookup;
import com.huawei.hms.core.aidl.DataBuffer;
import com.huawei.hms.core.aidl.IAIDLCallback;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.MessageCodec;
import com.huawei.hms.core.aidl.RequestHeader;
import com.huawei.hms.support.api.client.AidlApiClient;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.InnerApiClient;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.api.transport.DatagramTransport;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class IPCTransport implements DatagramTransport {
    private static final String TAG = "IPCTransport";
    private int apiLevel;
    private final IMessageEntity mEntity;
    private final Class<? extends IMessageEntity> mResponseClass;
    private final String mURI;

    public IPCTransport(String str, IMessageEntity iMessageEntity, Class<? extends IMessageEntity> cls) {
        this.mURI = str;
        this.mEntity = iMessageEntity;
        this.mResponseClass = cls;
    }

    private int syncCall(ApiClient apiClient, IAIDLCallback iAIDLCallback) {
        if (apiClient instanceof InnerApiClient) {
            DataBuffer dataBuffer = new DataBuffer(this.mURI, ProtocolNegotiate.getInstance().getVersion());
            MessageCodec find = CodecLookup.find(dataBuffer.getProtocol());
            dataBuffer.addBody(find.encode(this.mEntity, new Bundle()));
            RequestHeader requestHeader = new RequestHeader();
            requestHeader.setAppID(apiClient.getAppID());
            requestHeader.setPackageName(apiClient.getPackageName());
            requestHeader.setSdkVersion(61100302);
            requestHeader.setApiNameList(((AidlApiClient) apiClient).getApiNameList());
            requestHeader.setSessionId(apiClient.getSessionId());
            requestHeader.setApiLevel(this.apiLevel);
            dataBuffer.header = find.encode(requestHeader, new Bundle());
            try {
                AidlApiClient aidlApiClient = (AidlApiClient) apiClient;
                if (aidlApiClient.getService() == null) {
                    HMSLog.e(TAG, "HuaweiApiClient is not binded to service yet.");
                    return CommonCode.ErrorCode.INTERNAL_ERROR;
                }
                aidlApiClient.getService().asyncCall(dataBuffer, iAIDLCallback);
                return 0;
            } catch (Exception e2) {
                HMSLog.e(TAG, "sync call ex:" + ((Object) e2));
                return CommonCode.ErrorCode.INTERNAL_ERROR;
            }
        }
        if (apiClient instanceof AidlApiClient) {
            AidlApiClient aidlApiClient2 = (AidlApiClient) apiClient;
            DataBuffer dataBuffer2 = new DataBuffer(this.mURI, ProtocolNegotiate.getInstance().getVersion());
            dataBuffer2.addBody(CodecLookup.find(dataBuffer2.getProtocol()).encode(this.mEntity, new Bundle()));
            try {
                aidlApiClient2.getService().asyncCall(dataBuffer2, iAIDLCallback);
                return 0;
            } catch (Exception e10) {
                HMSLog.e(TAG, "sync call ex:" + ((Object) e10));
            }
        }
        return CommonCode.ErrorCode.INTERNAL_ERROR;
    }

    @Override // com.huawei.hms.support.api.transport.DatagramTransport
    public final void post(ApiClient apiClient, DatagramTransport.a aVar) {
        send(apiClient, aVar);
    }

    @Override // com.huawei.hms.support.api.transport.DatagramTransport
    public final void send(ApiClient apiClient, DatagramTransport.a aVar) {
        int syncCall = syncCall(apiClient, new IPCCallback(this.mResponseClass, aVar));
        if (syncCall == 0 || aVar == null) {
            return;
        }
        aVar.a(syncCall, null);
    }

    public IPCTransport(String str, IMessageEntity iMessageEntity, Class<? extends IMessageEntity> cls, int i10) {
        this.mURI = str;
        this.mEntity = iMessageEntity;
        this.mResponseClass = cls;
        this.apiLevel = i10;
    }
}
