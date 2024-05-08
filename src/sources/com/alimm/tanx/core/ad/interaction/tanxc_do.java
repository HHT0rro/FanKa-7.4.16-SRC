package com.alimm.tanx.core.ad.interaction;

import android.content.Context;
import android.text.TextUtils;
import com.alimm.tanx.core.ad.bean.BidInfo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: AdClickProcessor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class tanxc_do {
    public AdClickHandler tanxc_do;
    public Map<String, BidInfo> tanxc_if;

    /* compiled from: AdClickProcessor.java */
    /* renamed from: com.alimm.tanx.core.ad.interaction.tanxc_do$tanxc_do, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class C0090tanxc_do {
        public static final tanxc_do tanxc_do = new tanxc_do(0);
    }

    public /* synthetic */ tanxc_do(byte b4) {
        this();
    }

    public static tanxc_do tanxc_do() {
        return C0090tanxc_do.tanxc_do;
    }

    public tanxc_do() {
        this.tanxc_if = new ConcurrentHashMap(16);
        this.tanxc_do = new AdClickHandler();
    }

    public void tanxc_do(Context context, AdClickInfo adClickInfo, boolean z10) {
        tanxc_do(context, adClickInfo, false, z10);
    }

    public void tanxc_do(Context context, AdClickInfo adClickInfo, boolean z10, boolean z11) {
        this.tanxc_if.clear();
        this.tanxc_do.handleClickAndUt(context, adClickInfo, z10, z11);
    }

    public void tanxc_do(String str, BidInfo bidInfo) {
        if (TextUtils.isEmpty(str) || bidInfo == null) {
            return;
        }
        this.tanxc_if.put(str, bidInfo);
    }

    public BidInfo tanxc_do(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.tanxc_if.remove(str);
    }
}
