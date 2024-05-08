package com.huawei.hianalytics;

import com.huawei.hianalytics.core.log.HiLog;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ikl {
    public static ikl hij = new ikl();
    public ConcurrentHashMap<String, ijk> lmn = null;
    public volatile boolean klm = false;
    public volatile boolean ikl = false;
    public klm ijk = null;

    public static ikl klm() {
        return hij;
    }

    public String ijk() {
        klm klmVar = this.ijk;
        if (klmVar == null) {
            HiLog.i("ABDataCenter", "getUserID(): ABDataCenter needs init first");
            return "";
        }
        return klmVar.ijk;
    }

    public String ikl() {
        klm klmVar = this.ijk;
        if (klmVar == null) {
            HiLog.i("ABDataCenter", "getSecretKey(): ABDataCenter needs init first");
            return "";
        }
        return klmVar.lmn;
    }

    public String lmn() {
        klm klmVar = this.ijk;
        if (klmVar == null) {
            HiLog.i("ABDataCenter", "getABServerURL(): ABDataCenter needs init first");
            return "";
        }
        return klmVar.ikl;
    }
}
