package com.huawei.appgallery.agd.core.impl.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.core.impl.store.openevent.OpenEventUploadRequest;
import com.huawei.appgallery.agd.core.internalapi.OpenEventInfo;
import com.huawei.appgallery.agd.serverreq.ServerAgent;
import com.huawei.appgallery.agd.serverreq.bean.BaseResponseBean;
import com.huawei.appgallery.agd.serverreq.bean.ResponseBean;
import com.huawei.appgallery.agd.serverreq.listener.IServerCallbackEx;
import n9.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class OpenUploadEventUtil {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class OpenEventUploadCallback implements IServerCallbackEx {

        /* renamed from: a, reason: collision with root package name */
        public final int f27453a;

        /* renamed from: b, reason: collision with root package name */
        public final String f27454b;

        public OpenEventUploadCallback(int i10, String str) {
            this.f27453a = i10;
            this.f27454b = str;
        }

        @Override // com.huawei.appgallery.agd.serverreq.listener.IServerCallbackEx
        public void onFail(int i10, String str) {
            MaintBi.reportOpenEventUploadResult("code: " + i10 + ", msg: " + str, this.f27453a, this.f27454b);
        }

        @Override // com.huawei.appgallery.agd.serverreq.listener.IServerCallbackEx
        public void onResponse(ResponseBean responseBean) {
            if (!(responseBean instanceof BaseResponseBean)) {
                a.f52175d.w("OpenUploadEventUtil", "responseBean instanceof BaseResponseBean");
                return;
            }
            a aVar = a.f52175d;
            aVar.i("OpenUploadEventUtil", "rtnCode : " + responseBean.getRtnCode_() + " , rtnDesc : " + responseBean.getRtnDesc());
            if (responseBean.getRtnCode_() == 0 && responseBean.getResponseCode() == 0) {
                aVar.w("OpenUploadEventUtil", "rtnCode is " + responseBean.getRtnCode_());
                return;
            }
            MaintBi.reportOpenEventUploadResult(" rtnCode: " + responseBean.getRtnCode_() + ", desc: " + responseBean.getRtnDesc() + ", responseCode:" + responseBean.getResponseCode(), this.f27453a, this.f27454b);
        }
    }

    public static void reportEvent(String str, @NonNull OpenEventInfo openEventInfo) {
        OpenEventUploadRequest openEventUploadRequest = new OpenEventUploadRequest();
        openEventUploadRequest.setEventType(openEventInfo.getEventType());
        openEventUploadRequest.setEventDetail(openEventInfo.getEventDetail());
        openEventUploadRequest.setReferrer(TextUtils.isEmpty(openEventInfo.getReferrer()) ? str : openEventInfo.getReferrer());
        if (!TextUtils.isEmpty(openEventInfo.getEventValue())) {
            openEventUploadRequest.setEventValue(openEventInfo.getEventValue());
        }
        a.f52175d.i("OpenUploadEventUtil", "reportEvent " + openEventUploadRequest.toString());
        ServerAgent.invokeServerEx(openEventUploadRequest, new OpenEventUploadCallback(openEventInfo.getEventType(), str));
    }
}
