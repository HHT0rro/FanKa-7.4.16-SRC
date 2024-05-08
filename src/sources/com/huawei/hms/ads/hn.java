package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.hp;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class hn<V extends hp> implements ho<V> {
    public AdContentData Code;
    private Map<String, Boolean> I = new HashMap();
    private V V;

    private boolean V(String str) {
        return this.I.containsKey(str) && this.I.get(str).booleanValue();
    }

    public void Code(long j10) {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            adContentData.Z(j10);
        }
    }

    public void Code(Context context, long j10, long j11) {
        String str;
        if (j10 >= j11) {
            str = "complete";
            if (V("complete")) {
                return;
            }
        } else {
            long j12 = j11 / 4;
            if (j10 > 3 * j12) {
                str = com.huawei.openalliance.ad.constant.cj.Z;
                if (V(com.huawei.openalliance.ad.constant.cj.Z)) {
                    return;
                }
            } else if (j10 > j11 / 2) {
                str = com.huawei.openalliance.ad.constant.cj.I;
                if (V(com.huawei.openalliance.ad.constant.cj.I)) {
                    return;
                }
            } else if (j10 > j12) {
                str = com.huawei.openalliance.ad.constant.cj.V;
                if (V(com.huawei.openalliance.ad.constant.cj.V)) {
                    return;
                }
            } else {
                if (j10 <= 0) {
                    return;
                }
                str = "start";
                if (V("start")) {
                    return;
                }
            }
        }
        kv.V(context, this.Code, str);
        this.I.put(str, Boolean.TRUE);
    }

    @Override // com.huawei.hms.ads.ho
    public void Code(V v2) {
        this.V = v2;
    }

    public void Code(String str) {
        AdContentData adContentData = this.Code;
        if (adContentData == null) {
            return;
        }
        adContentData.V(str);
        Z();
    }

    @Override // com.huawei.hms.ads.ho
    public V I() {
        return this.V;
    }

    public void Z() {
        Map<String, Boolean> map = this.I;
        if (map == null) {
            return;
        }
        map.clear();
    }
}
