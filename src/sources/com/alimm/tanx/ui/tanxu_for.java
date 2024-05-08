package com.alimm.tanx.ui;

import com.alimm.tanx.core.ad.listener.ut.ITanxUserTracker;
import com.alimm.tanx.ui.ut.AdUtAnalytics;
import java.util.Map;

/* compiled from: TanxThirdInstanceBuilder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class tanxu_for implements ITanxUserTracker {
    public tanxu_for(TanxThirdInstanceBuilder tanxThirdInstanceBuilder) {
    }

    @Override // com.alimm.tanx.core.ad.listener.ut.ITanxUserTracker
    public void track(String str, String str2, String str3, int i10, int i11, String str4, String str5, String str6, Map<String, Object> map, String str7) {
        AdUtAnalytics.getInstance().track(str, str2, str3, i10, i11, str4, str5, str6, map, str7);
    }
}
