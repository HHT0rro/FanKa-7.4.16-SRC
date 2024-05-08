package com.huawei.openalliance.ad.uriaction;

import android.content.Context;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.lc;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class r {
    private static final String Code = "r";

    public static q Code(Context context, AdContentData adContentData, Map<String, String> map) {
        if (context == null || adContentData == null || map == null) {
            return new k();
        }
        List<q> Code2 = Code(context, adContentData, map, adContentData.m());
        if (Code2 == null || Code2.size() <= 0) {
            return new k();
        }
        q qVar = null;
        for (q qVar2 : Code2) {
            if (qVar != null) {
                qVar.Code(qVar2);
            }
            qVar = qVar2;
        }
        return Code2.get(0);
    }

    private static List<q> Code(Context context, AdContentData adContentData, Map<String, String> map, List<Integer> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Object obj = null;
        for (Integer num : list) {
            int intValue = num.intValue();
            if (intValue != 300) {
                switch (intValue) {
                    case 0:
                        obj = new k();
                        break;
                    case 1:
                        obj = new j(context, adContentData, false, map);
                        break;
                    case 2:
                        obj = new i(context, adContentData, map);
                        break;
                    case 3:
                        obj = new a(context, adContentData);
                        break;
                    case 4:
                        obj = new j(context, adContentData, true, map);
                        break;
                    case 5:
                        obj = new n(context, adContentData);
                        break;
                    case 6:
                        obj = new c(context, adContentData);
                        break;
                    case 7:
                        obj = new b(context, adContentData);
                        break;
                    case 8:
                        obj = new m(context, adContentData);
                        break;
                    case 9:
                        obj = new p(context, adContentData);
                        break;
                    default:
                        switch (intValue) {
                            case 11:
                                obj = new g(context, adContentData);
                                break;
                            case 12:
                                obj = new e(context, adContentData);
                                break;
                            case 13:
                                if (lc.Code(context)) {
                                    obj = new o(context, adContentData);
                                    break;
                                }
                                break;
                            case 14:
                                obj = new f(context, adContentData, true, map);
                                break;
                            default:
                                gl.I(Code, "unsupport action:" + ((Object) num));
                                obj = null;
                                break;
                        }
                }
            } else {
                obj = new l(context, adContentData, map);
            }
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
