package com.huawei.openalliance.ad.inter;

import android.content.Context;
import com.huawei.hms.ads.kv;
import com.huawei.openalliance.ad.constant.t;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AdEventRecord;
import com.huawei.openalliance.ad.inter.data.AdEventType;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.v;
import java.util.List;

@com.huawei.openalliance.ad.annotations.b
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class f {
    private static f Code;
    private static final byte[] V = new byte[0];
    private Context I;

    private f(Context context) {
        this.I = context.getApplicationContext();
    }

    @com.huawei.openalliance.ad.annotations.b
    public static f Code(Context context) {
        return V(context);
    }

    private void Code(AdContentData adContentData, Long l10, boolean z10) {
        if (adContentData == null) {
            return;
        }
        adContentData.V(String.valueOf(v.Code()));
        kv.Code(this.I, adContentData, (String) null, l10, Boolean.valueOf(z10));
    }

    private void Code(com.huawei.openalliance.ad.inter.data.d dVar, Long l10, boolean z10) {
        Code(dVar.l(), l10, z10);
        kv.Code(this.I, dVar.l(), Long.valueOf(Math.min(dVar.e() - dVar.d(), dVar.r())), Integer.valueOf(dVar.s()), (Integer) 7, l10, Boolean.valueOf(z10));
    }

    private static f V(Context context) {
        f fVar;
        synchronized (V) {
            if (Code == null) {
                Code = new f(context);
            }
            fVar = Code;
        }
        return fVar;
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(List<AdEventRecord> list) {
        com.huawei.openalliance.ad.inter.data.d Code2;
        if (aa.Code(list)) {
            return;
        }
        int size = list.size();
        int i10 = 0;
        while (i10 < size) {
            AdEventRecord adEventRecord = list.get(i10);
            if (adEventRecord != null && (Code2 = adEventRecord.Code()) != null && Code2.x()) {
                String Z = adEventRecord.Z();
                Long valueOf = Long.valueOf(adEventRecord.B() == null ? v.Code() : adEventRecord.B().longValue());
                boolean z10 = i10 >= size + (-1);
                if ("imp".equalsIgnoreCase(Z)) {
                    Code(Code2, valueOf, z10);
                } else if (AdEventType.SHOW_START.equalsIgnoreCase(Z)) {
                    Code(Code2.l(), valueOf, z10);
                } else if ("click".equalsIgnoreCase(Z)) {
                    kv.Code(this.I, Code2.l(), null, 0, 0, t.D, 12, null, valueOf, Boolean.valueOf(z10), null);
                } else if ("intentSuccess".equalsIgnoreCase(Z)) {
                    kv.Code(this.I, Code2.l(), "intentSuccess", (Integer) 1, (Integer) null, valueOf, Boolean.valueOf(z10));
                }
            }
            i10++;
        }
    }
}
