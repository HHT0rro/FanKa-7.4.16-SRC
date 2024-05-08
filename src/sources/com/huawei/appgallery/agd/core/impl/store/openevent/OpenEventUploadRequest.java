package com.huawei.appgallery.agd.core.impl.store.openevent;

import android.content.Context;
import com.huawei.appgallery.agd.base.util.CommonUtils;
import com.huawei.appgallery.agd.common.application.ApplicationWrapper;
import com.huawei.appgallery.agd.core.impl.store.base.MasRequestBean;
import com.huawei.appgallery.agd.serverreq.json.JsonBean;
import com.huawei.appgallery.agd.serverreq.json.annotation.NetworkTransmission;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCRequest;
import java.util.ArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class OpenEventUploadRequest extends MasRequestBean {
    public static final String APIMETHOD = "client.openEventUpload";
    private static final String VERSION = "1.0";

    @NetworkTransmission
    private String callType;

    @NetworkTransmission
    private String channelId;

    @NetworkTransmission
    private EventDetail eventDetail;

    @NetworkTransmission
    private int eventType;

    @NetworkTransmission
    private String eventValue;

    @NetworkTransmission
    private String referrer;

    @NetworkTransmission
    private String signature;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class EventDetail extends JsonBean {

        @NetworkTransmission
        private ArrayList<String> detailIdList;

        @NetworkTransmission
        private String layoutId;

        public ArrayList<String> getDetailIdList() {
            return this.detailIdList;
        }

        public String getLayoutId() {
            return this.layoutId;
        }

        public void setDetailIdList(ArrayList<String> arrayList) {
            this.detailIdList = arrayList;
        }

        public void setLayoutId(String str) {
            this.layoutId = str;
        }

        public String toString() {
            return "EventDetail{layoutId='" + this.layoutId + "', detailIdList=" + ((Object) this.detailIdList) + '}';
        }
    }

    public OpenEventUploadRequest() {
        super.onSetValue();
        Context context = ApplicationWrapper.getInstance().getContext();
        setTs_(String.valueOf(System.currentTimeMillis()));
        setMethod_(APIMETHOD);
        setVer("1.0");
        this.callType = BaseIPCRequest.CALL_TYPE_AGD_SDK;
        this.channelId = context.getPackageName();
        this.signature = CommonUtils.getCallerAppSigns(this.callerPkg, context);
    }

    public String getCallType() {
        return this.callType;
    }

    public EventDetail getEventDetail() {
        return this.eventDetail;
    }

    public int getEventType() {
        return this.eventType;
    }

    public String getEventValue() {
        return this.eventValue;
    }

    public String getReferrer() {
        return this.referrer;
    }

    public String getSignature() {
        return this.signature;
    }

    public void setEventDetail(EventDetail eventDetail) {
        this.eventDetail = eventDetail;
    }

    public void setEventType(int i10) {
        this.eventType = i10;
    }

    public void setEventValue(String str) {
        this.eventValue = str;
    }

    public void setReferrer(String str) {
        this.referrer = str;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    public String toString() {
        return "OpenEventUploadRequest{eventType=" + this.eventType + ", eventDetail=" + ((Object) this.eventDetail) + ", eventValue='" + this.eventValue + "'}";
    }
}
