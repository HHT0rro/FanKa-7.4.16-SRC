package com.alimm.tanx.core.ad.ad.template.rendering.reward;

import com.alimm.tanx.core.utils.LogUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: RewardGlobal.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class tanxc_if {
    public static LinkedHashMap<String, com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if> tanxc_do;

    static {
        final int i10 = 3;
        tanxc_do = new LinkedHashMap<String, com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if>(i10) { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardGlobal$1
            @Override // java.util.LinkedHashMap
            public boolean removeEldestEntry(Map.Entry<String, com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if> entry) {
                return tanxc_if.tanxc_do.size() > 3;
            }
        };
    }

    public static void tanxc_do(String str) {
        try {
            Iterator<String> iterator2 = tanxc_do.h().iterator2();
            while (iterator2.hasNext()) {
                if (iterator2.next().equalsIgnoreCase(str)) {
                    iterator2.remove();
                    return;
                }
            }
        } catch (Exception e2) {
            LogUtils.e(e2);
        }
    }
}
