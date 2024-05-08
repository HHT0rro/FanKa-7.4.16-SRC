package com.huawei.appgallery.agd.core.impl.store.base;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.appgallery.agd.base.util.CommonUtils;
import com.huawei.appgallery.agd.common.application.ApplicationWrapper;
import com.huawei.appgallery.agd.core.api.AgdAdConfig;
import com.huawei.appgallery.agd.core.impl.AgdAdManager;
import com.huawei.appgallery.agd.core.impl.device.OaidUtil;
import com.huawei.appgallery.agd.serverreq.bean.BaseRequestBean;
import com.huawei.appgallery.agd.serverreq.json.annotation.FieldSecurity;
import com.huawei.appgallery.agd.serverreq.json.annotation.NetworkTransmission;
import java.util.UUID;
import m9.g;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class MasRequestBean extends BaseRequestBean {
    private static final int SERVICE_TYPE_MAS = 62;

    @NetworkTransmission
    public String callerPkg;

    @FieldSecurity(security = 1)
    @NetworkTransmission
    public String callerPkgSign;

    @FieldSecurity(security = 1)
    @NetworkTransmission
    private String encDeviceId;

    @FieldSecurity(security = 1)
    @NetworkTransmission
    private String oaid;

    @NetworkTransmission
    private String requestId = UUID.randomUUID().toString().replaceAll("-", "");

    @FieldSecurity(security = 1)
    @NetworkTransmission
    private String riskToken;

    @NetworkTransmission
    private String slotId;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements g.c {
        public a() {
        }

        @Override // m9.g.c
        public void a(int i10, String str) {
            MasRequestBean.this.riskToken = str;
        }
    }

    public String getRequestId() {
        return this.requestId;
    }

    @Override // com.huawei.appgallery.agd.serverreq.bean.BaseRequestBean, com.huawei.appgallery.agd.serverreq.bean.RequestBean
    public void onSetValue() {
        super.onSetValue();
        Context context = ApplicationWrapper.getInstance().getContext();
        setServiceType_(62);
        this.encDeviceId = o9.a.a(context);
        this.oaid = OaidUtil.getOAID();
        this.callerPkg = context.getPackageName();
        AgdAdConfig config = AgdAdManager.getConfig();
        if (p9.a.a(this.callerPkg) && !TextUtils.isEmpty(config.getMediaPkgName())) {
            this.callerPkg = config.getMediaPkgName();
            this.callerPkgSign = config.getMediaPkgSign();
        } else {
            this.callerPkgSign = CommonUtils.getCallerAppSigns(this.callerPkg, context);
        }
        g.o(new a());
        setDeviceId_("");
        setDeviceIdType(9);
    }

    public void setSlotId(String str) {
        this.slotId = str;
    }
}
