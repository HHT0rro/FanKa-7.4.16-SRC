package com.huawei.appmarket.service.externalservice.distribution.download.response;

import android.os.Parcelable;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCResponse;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.EnableAutoParcel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class GetRecommendCardResponse extends BaseIPCResponse {
    public static final Parcelable.Creator<GetRecommendCardResponse> CREATOR = new AutoParcelable.AutoCreator(GetRecommendCardResponse.class);

    @EnableAutoParcel(9)
    private int chunkCode;

    @EnableAutoParcel(6)
    private String mCardId;

    @EnableAutoParcel(5)
    private String mErrCause;

    @EnableAutoParcel(3)
    private int mHttpStatusCode;

    @EnableAutoParcel(2)
    private String mJsonData;

    @EnableAutoParcel(4)
    private int mResponseCode;

    @EnableAutoParcel(1)
    private int mResult;

    @EnableAutoParcel(7)
    private String mUuid;

    @EnableAutoParcel(10)
    private int responseId;

    @EnableAutoParcel(8)
    private int transmitCode;

    public String getCardId() {
        return this.mCardId;
    }

    public int getChunkCode() {
        return this.chunkCode;
    }

    public String getErrCause() {
        return this.mErrCause;
    }

    public int getHttpStatusCode() {
        return this.mHttpStatusCode;
    }

    public String getJsonData() {
        return this.mJsonData;
    }

    public int getResponseCode() {
        return this.mResponseCode;
    }

    public int getResponseId() {
        return this.responseId;
    }

    public int getResult() {
        return this.mResult;
    }

    public int getTransmitCode() {
        return this.transmitCode;
    }

    public String getUuid() {
        return this.mUuid;
    }

    public void setChunkCode(int i10) {
        this.chunkCode = i10;
    }

    public void setJsonData(String str) {
        this.mJsonData = str;
    }

    public void setResponseId(int i10) {
        this.responseId = i10;
    }

    public void setTransmitCode(int i10) {
        this.transmitCode = i10;
    }
}
