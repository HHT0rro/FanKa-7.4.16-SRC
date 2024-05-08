package com.huawei.quickcard.manager;

import com.huawei.quickcard.base.utils.CardThreadUtils;
import com.huawei.quickcard.cardmanager.bi.CardReporterUtil;
import com.huawei.quickcard.cardmanager.config.VersionUtils;
import com.huawei.quickcard.cardmanager.http.CardServerUtil;
import com.huawei.quickcard.cardmanager.http.ManagerHttpClientUtil;
import com.huawei.quickcard.cardmanager.http.ServerConfigUtil;
import com.huawei.quickcard.cardmanager.log.ManagerLogUtil;
import com.huawei.quickcard.cardmanager.sha.ShaUtils;
import com.huawei.quickcard.cardmanager.task.TaskThreadUtil;
import com.huawei.quickcard.n0;
import com.huawei.quickcard.r;
import com.huawei.quickcard.r1;
import com.huawei.quickcard.s1;
import com.huawei.quickcard.t1;
import com.huawei.quickcard.x0;
import com.huawei.quickcard.x1;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ManagerDependence {
    public static void setDependence() {
        ShaUtils.setSha(new t1());
        ManagerHttpClientUtil.setHttpClient(new n0());
        CardReporterUtil.setReporter(new r());
        CardServerUtil.setCardServer(new s1());
        ServerConfigUtil.setServerConfig(new r1());
        TaskThreadUtil.setWorker(CardThreadUtils.get().worker());
        VersionUtils.setVersionConfig(new x1());
    }

    public static void setPrintLog() {
        ManagerLogUtil.setManagerLog(new x0());
    }
}
