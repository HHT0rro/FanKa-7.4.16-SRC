package com.huawei.quickcard;

import android.content.Context;
import com.huawei.quickcard.base.bi.CardReporter;
import com.huawei.quickcard.base.utils.QuickReportUtils;
import com.huawei.quickcard.cardmanager.bi.CardReportBean;
import com.huawei.quickcard.cardmanager.bi.Reporter;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class r implements Reporter {
    @Override // com.huawei.quickcard.cardmanager.bi.Reporter
    public int getHostVersionCode(Context context) {
        return QuickReportUtils.getHostVersionCode(context);
    }

    @Override // com.huawei.quickcard.cardmanager.bi.Reporter
    public void reportDownload(Context context, CardReportBean cardReportBean) {
        com.huawei.quickcard.base.bi.CardReportBean cardReportBean2 = new com.huawei.quickcard.base.bi.CardReportBean();
        cardReportBean2.setErrorCode(cardReportBean.getErrorCode());
        cardReportBean2.setErrorMsg(cardReportBean.getErrorMsg());
        cardReportBean2.setStartTime(cardReportBean.getStartTime());
        cardReportBean2.setEndTime(cardReportBean.getEndTime());
        cardReportBean2.setEngineVersion(cardReportBean.getEngineVersion());
        cardReportBean2.setType(cardReportBean.getType());
        cardReportBean2.setDeviceModel(cardReportBean.getDeviceModel());
        cardReportBean2.setQuickCardUri(cardReportBean.getQuickCardUri());
        cardReportBean2.setHostPkg(cardReportBean.getHostPkg());
        cardReportBean2.setHostVer(cardReportBean.getHostVer());
        cardReportBean2.setRetryTimes(cardReportBean.getRetryTimes());
        cardReportBean2.setNetwork(cardReportBean.getNetwork());
        cardReportBean2.setStoreUrl(cardReportBean.getStoreUrl());
        CardReporter.from(context).bean(cardReportBean2).reportDownload();
    }
}
