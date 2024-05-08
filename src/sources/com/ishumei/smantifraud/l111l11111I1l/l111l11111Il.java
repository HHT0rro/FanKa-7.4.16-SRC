package com.ishumei.smantifraud.l111l11111I1l;

import android.os.Build;
import com.baidu.mobads.sdk.internal.bk;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l111l11111Il {
    public static HashMap<String, String> l1111l111111Il() {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put("board", Build.BOARD);
            hashMap.put(bk.f9900i, Build.MODEL);
            hashMap.put("brand", Build.BRAND);
            hashMap.put("manufacturer", Build.MANUFACTURER);
            hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, Build.FINGERPRINT);
            hashMap.put("cpu_abi", Build.CPU_ABI);
            hashMap.put("cpu_abi2", Build.CPU_ABI2);
            hashMap.put("radioVersion", Build.getRadioVersion());
        } catch (Exception unused) {
        }
        return hashMap;
    }
}
