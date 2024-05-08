package com.huawei.openalliance.ad.uriaction;

import android.content.Context;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class d {
    private static final String Code = "BtnUriActionFactory";

    public static q Code(Context context, AdContentData adContentData, Map<String, String> map, List<Integer> list) {
        if (context == null || adContentData == null || map == null) {
            return new k();
        }
        List<q> V = V(context, adContentData, map, list);
        if (V == null || V.size() <= 0) {
            return new k();
        }
        q qVar = null;
        for (q qVar2 : V) {
            if (qVar != null) {
                qVar.Code(qVar2);
            }
            qVar = qVar2;
        }
        return V.get(0);
    }

    private static List<q> V(Context context, AdContentData adContentData, Map<String, String> map, List<Integer> list) {
        q kVar;
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (Integer num : list) {
            int intValue = num.intValue();
            if (intValue == 0) {
                kVar = new k();
            } else if (intValue != 14) {
                gl.I(Code, "unsupport action:" + ((Object) num));
                kVar = null;
            } else {
                kVar = new f(context, adContentData, true, map);
            }
            if (kVar != null) {
                arrayList.add(kVar);
            }
        }
        return arrayList;
    }
}
