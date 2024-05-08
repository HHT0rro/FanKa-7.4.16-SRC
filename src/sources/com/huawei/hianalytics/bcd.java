package com.huawei.hianalytics;

import android.text.TextUtils;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.framework.policy.IStoragePolicy;
import com.huawei.hianalytics.util.DeviceUtil;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class bcd implements IStoragePolicy {
    public String lmn;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static /* synthetic */ class lmn {
        public static final /* synthetic */ int[] lmn;

        static {
            int[] iArr = new int[IStoragePolicy.PolicyType.values().length];
            lmn = iArr;
            try {
                iArr[IStoragePolicy.PolicyType.STORAGELENGTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                lmn[IStoragePolicy.PolicyType.NETWORK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                lmn[IStoragePolicy.PolicyType.PARAMS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                lmn[IStoragePolicy.PolicyType.STORAGECYCLY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                lmn[IStoragePolicy.PolicyType.STORAGESIZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public bcd(String str) {
        this.lmn = str;
    }

    @Override // com.huawei.hianalytics.framework.policy.IStoragePolicy
    public boolean decide(IStoragePolicy.PolicyType policyType, String str) {
        int i10 = lmn.lmn[policyType.ordinal()];
        if (i10 == 1) {
            return new File(c.klm().lmn.f28748e.getDatabasePath("haformal_event.db").getPath()).length() > ((long) c.klm().lmn.efg) * 1048576;
        }
        if (i10 != 2) {
            return true;
        }
        String str2 = this.lmn;
        if (!TextUtils.isEmpty(DeviceUtil.getNetworkType(c.klm().lmn.f28748e))) {
            return true;
        }
        HiLog.sw("ReportPolicy", "The network is unavailable. TAG: %s,TYPE: %s", str2, str);
        return false;
    }

    @Override // com.huawei.hianalytics.framework.policy.IStoragePolicy
    public boolean decide(IStoragePolicy.PolicyType policyType, String str, long j10) {
        int i10 = lmn.lmn[policyType.ordinal()];
        if (i10 == 4) {
            long currentTimeMillis = System.currentTimeMillis() - j10;
            w lmn2 = d.lmn(this.lmn, str);
            return currentTimeMillis > (((long) (lmn2 != null ? lmn2.cde : 7)) * 24) * 3600000;
        }
        if (i10 != 5) {
            return false;
        }
        w lmn3 = d.lmn(this.lmn, str);
        return j10 >= ((long) (lmn3 != null ? lmn3.def : 30));
    }
}
