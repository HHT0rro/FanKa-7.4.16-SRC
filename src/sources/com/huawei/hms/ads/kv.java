package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.ku;
import com.huawei.openalliance.ad.beans.inner.AdEventReport;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.FeedbackInfo;
import com.huawei.openalliance.ad.utils.aa;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class kv {
    public static AdEventReport Code(AdContentData adContentData) {
        AdEventReport adEventReport = new AdEventReport();
        if (adContentData != null) {
            adEventReport.Code(adContentData.Code());
            adEventReport.Code(adContentData.S());
            adEventReport.Z(adContentData.B());
            adEventReport.B(adContentData.E());
            adEventReport.D(adContentData.ah());
            adEventReport.I(adContentData.ak());
            adEventReport.Code(adContentData.aw());
            adEventReport.Z(adContentData.aA());
            adEventReport.a(adContentData.az());
            adEventReport.b(adContentData.C());
        }
        return adEventReport;
    }

    public static void Code(Context context, AdContentData adContentData) {
        Code(context, com.huawei.openalliance.ad.constant.q.I, Code(adContentData));
    }

    public static void Code(Context context, AdContentData adContentData, int i10, int i11, String str) {
        Code(context, adContentData, i10, i11, (List<String>) null, str);
    }

    public static void Code(Context context, AdContentData adContentData, int i10, int i11, String str, int i12, com.huawei.openalliance.ad.inter.data.m mVar, String str2, int[] iArr) {
        AdEventReport Code = Code(adContentData);
        Code.V(i10);
        Code.I(i11);
        if (!aa.Code(iArr) && iArr.length > 1) {
            Code.D(Integer.valueOf(iArr[0]));
            Code.L(Integer.valueOf(iArr[1]));
            Code.a(Integer.valueOf(com.huawei.openalliance.ad.utils.ay.L(context)));
        }
        Code.I(str);
        Code.V(Integer.valueOf(i12));
        Code.F(str2);
        if (mVar != null) {
            Code.S(mVar.Code());
            Code.F(mVar.V());
            Code.L(mVar.I());
        }
        Code.Z(Long.valueOf(com.huawei.openalliance.ad.utils.v.Code()));
        Code(context, com.huawei.openalliance.ad.constant.q.B, Code);
    }

    public static void Code(Context context, AdContentData adContentData, int i10, int i11, String str, int i12, String str2) {
        AdEventReport Code = Code(adContentData);
        Code.V(i10);
        Code.I(i11);
        Code.I(str);
        Code.V(Integer.valueOf(i12));
        Code.F(str2);
        Code.Z(Long.valueOf(com.huawei.openalliance.ad.utils.v.Code()));
        Code(context, com.huawei.openalliance.ad.constant.q.B, Code);
    }

    public static void Code(Context context, AdContentData adContentData, int i10, int i11, String str, int i12, String str2, int[] iArr) {
        AdEventReport Code = Code(adContentData);
        Code.V(i10);
        Code.I(i11);
        Code.I(str);
        Code.V(Integer.valueOf(i12));
        Code.F(str2);
        if (!aa.Code(iArr) && iArr.length > 1) {
            Code.D(Integer.valueOf(iArr[0]));
            Code.L(Integer.valueOf(iArr[1]));
            Code.a(Integer.valueOf(com.huawei.openalliance.ad.utils.ay.L(context)));
        }
        Code.Z(Long.valueOf(com.huawei.openalliance.ad.utils.v.Code()));
        Code(context, com.huawei.openalliance.ad.constant.q.B, Code);
    }

    public static void Code(Context context, AdContentData adContentData, int i10, int i11, String str, com.huawei.openalliance.ad.inter.data.m mVar, String str2, int[] iArr) {
        AdEventReport Code = Code(adContentData);
        Code.V(i10);
        Code.I(i11);
        if (!aa.Code(iArr) && iArr.length > 1) {
            Code.D(Integer.valueOf(iArr[0]));
            Code.L(Integer.valueOf(iArr[1]));
            Code.a(Integer.valueOf(com.huawei.openalliance.ad.utils.ay.L(context)));
        }
        Code.I(str);
        Code.F(str2);
        if (mVar != null) {
            Code.S(mVar.Code());
            Code.F(mVar.V());
            Code.L(mVar.I());
        }
        Code.Z(Long.valueOf(com.huawei.openalliance.ad.utils.v.Code()));
        Code(context, com.huawei.openalliance.ad.constant.q.B, Code);
    }

    public static void Code(Context context, AdContentData adContentData, int i10, int i11, String str, String str2) {
        Code(context, adContentData, i10, i11, str, (com.huawei.openalliance.ad.inter.data.m) null, str2, new int[0]);
    }

    public static void Code(Context context, AdContentData adContentData, int i10, int i11, String str, String str2, int[] iArr) {
        Code(context, adContentData, i10, i11, str, (com.huawei.openalliance.ad.inter.data.m) null, str2, iArr);
    }

    public static void Code(Context context, AdContentData adContentData, int i10, int i11, List<String> list) {
        Code(context, adContentData, i10, i11, list, (String) null);
    }

    private static void Code(Context context, AdContentData adContentData, int i10, int i11, List<String> list, String str) {
        AdEventReport Code = Code(adContentData);
        Code.V(i10);
        Code.I(i11);
        Code.Code(list);
        if (!com.huawei.openalliance.ad.utils.au.Code(str)) {
            Code.V(str);
        }
        Code(context, com.huawei.openalliance.ad.constant.q.C, Code);
    }

    public static void Code(Context context, AdContentData adContentData, long j10, int i10) {
        ku.a aVar = new ku.a();
        aVar.Code(Long.valueOf(j10)).Code(Integer.valueOf(i10));
        Code(context, adContentData, true, aVar.Code());
    }

    public static void Code(Context context, AdContentData adContentData, ku kuVar) {
        Code(context, adContentData, false, kuVar);
    }

    public static void Code(Context context, AdContentData adContentData, ku kuVar, String str) {
        Code(context, adContentData, false, kuVar, str);
    }

    public static void Code(Context context, AdContentData adContentData, Integer num) {
        AdEventReport Code = Code(adContentData);
        Code.V(num);
        Code(context, com.huawei.openalliance.ad.constant.q.D, Code);
    }

    public static void Code(Context context, AdContentData adContentData, Integer num, String str) {
        AdEventReport Code = Code(adContentData);
        Code.V(num);
        Code.C(str);
        Code(context, com.huawei.openalliance.ad.constant.q.F, Code);
    }

    public static void Code(Context context, AdContentData adContentData, Long l10, Integer num, Integer num2, Long l11, Boolean bool) {
        ku.a aVar = new ku.a();
        aVar.Code(l10).Code(num).V(num2).V(l11).Code(bool);
        Code(context, adContentData, false, aVar.Code());
    }

    public static void Code(Context context, AdContentData adContentData, Long l10, Integer num, Integer num2, String str) {
        ku.a aVar = new ku.a();
        aVar.Code(l10);
        aVar.Code(num);
        aVar.V(num2);
        aVar.Code(str);
        Code(context, adContentData, false, aVar.Code());
    }

    public static void Code(Context context, AdContentData adContentData, String str) {
        Code(context, adContentData, str, (Long) null, (Boolean) null);
    }

    public static void Code(Context context, AdContentData adContentData, String str, int i10, int i11, String str2, int i12, String str3, com.huawei.openalliance.ad.inter.data.m mVar) {
        Code(context, adContentData, str, i10, i11, str2, i12, str3, null, null, mVar);
    }

    public static void Code(Context context, AdContentData adContentData, String str, int i10, int i11, String str2, int i12, String str3, Long l10, Boolean bool, com.huawei.openalliance.ad.inter.data.m mVar) {
        AdEventReport Code = Code(adContentData);
        Code.V(i10);
        Code.I(i11);
        Code.I(str2);
        Code.V(Integer.valueOf(i12));
        Code.C(str);
        Code.F(str3);
        Code.Z(l10);
        Code.Code(bool);
        if (mVar != null) {
            Code.S(mVar.Code());
            Code.F(mVar.V());
            Code.L(mVar.I());
        }
        Code(context, com.huawei.openalliance.ad.constant.q.B, Code);
    }

    public static void Code(Context context, AdContentData adContentData, String str, Integer num, Integer num2) {
        Code(context, adContentData, str, num, num2, (Long) null, (Boolean) null);
    }

    public static void Code(Context context, AdContentData adContentData, String str, Integer num, Integer num2, Long l10, Boolean bool) {
        AdEventReport Code = Code(adContentData);
        Code.V(str);
        Code.B(num);
        Code.C(num2);
        Code.Z(l10);
        Code.Code(bool);
        Code(context, com.huawei.openalliance.ad.constant.q.S, Code);
    }

    public static void Code(Context context, AdContentData adContentData, String str, Long l10, Boolean bool) {
        AdEventReport Code = Code(adContentData);
        Code.C(str);
        Code(context, com.huawei.openalliance.ad.constant.q.I, Code);
    }

    public static void Code(Context context, AdContentData adContentData, String str, Long l10, Integer num, Integer num2, String str2) {
        ku.a aVar = new ku.a();
        aVar.V(str).Code(l10).Code(num).V(num2).Code(str2);
        Code(context, adContentData, false, aVar.Code());
    }

    public static void Code(Context context, AdContentData adContentData, String str, Long l10, Long l11, Integer num, Integer num2) {
        AdEventReport Code = Code(adContentData);
        Code.V(str);
        Code.V(l10);
        Code.I(l11);
        Code.I(num);
        Code.Z(num2);
        Code(context, com.huawei.openalliance.ad.constant.q.Z, Code);
    }

    public static void Code(Context context, AdContentData adContentData, String str, Long l10, Long l11, Integer num, Integer num2, String str2) {
        AdEventReport Code = Code(adContentData);
        Code.V(str);
        Code.V(l10);
        Code.I(l11);
        Code.I(num);
        Code.Z(num2);
        Code.C(str2);
        Code(context, com.huawei.openalliance.ad.constant.q.Z, Code);
    }

    public static void Code(Context context, AdContentData adContentData, String str, String str2, String str3) {
        AdEventReport Code = Code(adContentData);
        if (str != null) {
            Code.C(str);
        } else {
            gl.I("event", "on ad rewarded, customData is null");
        }
        if (str2 != null) {
            Code.S(str2);
        } else {
            gl.I("event", "on ad rewarded, userId is null");
        }
        Code.F(str3);
        Code(context, com.huawei.openalliance.ad.constant.q.f32319b, Code);
    }

    public static void Code(Context context, AdContentData adContentData, List<FeedbackInfo> list, int i10) {
        AdEventReport Code = Code(adContentData);
        Code.C(String.valueOf(i10));
        Code.V(list);
        Code(context, com.huawei.openalliance.ad.constant.q.f32340w, Code);
    }

    public static void Code(Context context, AdContentData adContentData, boolean z10) {
        AdEventReport Code = Code(adContentData);
        Code.V(z10);
        Code(context, com.huawei.openalliance.ad.constant.q.f32326i, Code);
    }

    private static void Code(Context context, AdContentData adContentData, boolean z10, ku kuVar) {
        Code(context, adContentData, z10, kuVar, (String) null);
    }

    private static void Code(Context context, AdContentData adContentData, boolean z10, ku kuVar, String str) {
        if (adContentData == null) {
            gl.I("EvtProcessor", "on ad show, ad data is null");
            return;
        }
        AdEventReport Code = Code(adContentData);
        Code.Code(z10);
        if (kuVar != null) {
            if (kuVar.S() != null) {
                Code.C(kuVar.S());
            }
            if (kuVar.Code() != null) {
                Code.Code(kuVar.Code());
            }
            if (kuVar.V() != null) {
                Code.Code(kuVar.V());
            }
            if (kuVar.I() != null) {
                Code.V(kuVar.I());
            }
            if (kuVar.Z() != null) {
                Code.F(kuVar.Z());
            }
            if (kuVar.B() != null) {
                Code.Z(kuVar.B());
            }
            if (kuVar.C() != null) {
                Code.Code(kuVar.C());
            }
        }
        if (!com.huawei.openalliance.ad.utils.au.Code(str)) {
            Code.V(str);
        }
        Code(context, com.huawei.openalliance.ad.constant.q.V, Code);
    }

    private static void Code(Context context, String str, AdEventReport adEventReport) {
        if (context == null) {
            return;
        }
        com.huawei.openalliance.ad.ipc.h.Code(context, adEventReport.r()).Code(str, com.huawei.openalliance.ad.utils.z.V(adEventReport), null, null);
    }

    public static void V(Context context, AdContentData adContentData) {
        Code(context, com.huawei.openalliance.ad.constant.q.f32321d, Code(adContentData));
    }

    public static void V(Context context, AdContentData adContentData, String str) {
        AdEventReport Code = Code(adContentData);
        Code.C(str);
        Code(context, com.huawei.openalliance.ad.constant.q.f32322e, Code);
    }
}
