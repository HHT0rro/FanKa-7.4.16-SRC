package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.beans.inner.AnalysisEventReport;
import com.huawei.openalliance.ad.beans.inner.ApiStatisticsReq;
import com.huawei.openalliance.ad.beans.metadata.AdTimeStatistics;
import com.huawei.openalliance.ad.beans.metadata.DelayInfo;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.c;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.aa;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class eo {
    public static void Code(Context context) {
        V(context, en.F, null, null, null);
    }

    public static <T extends com.huawei.openalliance.ad.inter.data.d> void Code(final Context context, final int i10, final String str, final int i11, final Map<String, List<T>> map, final long j10, final long j11, final long j12) {
        if (j10 <= 0 || j10 > j11) {
            return;
        }
        com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.hms.ads.eo.3
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList;
                ArrayList arrayList2;
                DelayInfo delayInfo;
                if (com.huawei.openalliance.ad.utils.af.Code(Map.this)) {
                    arrayList = null;
                    arrayList2 = null;
                    delayInfo = null;
                } else {
                    arrayList = new ArrayList();
                    arrayList2 = new ArrayList();
                    delayInfo = null;
                    for (Map.Entry entry : Map.this.entrySet()) {
                        arrayList.add(entry.getKey());
                        List<com.huawei.openalliance.ad.inter.data.d> list = (List) entry.getValue();
                        if (!aa.Code(list)) {
                            for (com.huawei.openalliance.ad.inter.data.d dVar : list) {
                                if (dVar != null) {
                                    if (dVar instanceof c) {
                                        c cVar = (c) dVar;
                                        if (cVar.j_() != null) {
                                            delayInfo = cVar.j_();
                                        }
                                    }
                                    arrayList2.add(dVar.D());
                                }
                            }
                        }
                    }
                }
                if (delayInfo == null) {
                    delayInfo = new DelayInfo();
                }
                DelayInfo delayInfo2 = delayInfo;
                delayInfo2.Code(arrayList);
                delayInfo2.V(arrayList2);
                delayInfo2.j().Code(j10);
                delayInfo2.j().V(j11);
                delayInfo2.j().c(j12);
                eo.V(context, com.huawei.openalliance.ad.constant.q.f32320c, com.huawei.openalliance.ad.utils.z.V(eo.V(j11 - j10, com.huawei.openalliance.ad.constant.g.Code, str, i11, i10, delayInfo2)), null, null);
            }
        });
    }

    public static <T extends com.huawei.openalliance.ad.inter.data.d> void Code(final Context context, final int i10, final String str, final int i11, final Map<String, List<T>> map, final long j10, final DelayInfo delayInfo) {
        if (gl.Code()) {
            Object[] objArr = new Object[2];
            objArr[0] = Long.valueOf(j10);
            objArr[1] = Boolean.valueOf(delayInfo != null);
            gl.Code("AnalysisReport", "reportE2ECostTime,  duration = %s delayInfo: %s", objArr);
        }
        if (context == null || delayInfo == null || j10 <= 0) {
            return;
        }
        com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.hms.ads.eo.4
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList;
                ArrayList arrayList2;
                if (com.huawei.openalliance.ad.utils.af.Code(Map.this)) {
                    arrayList = null;
                    arrayList2 = null;
                } else {
                    arrayList = new ArrayList();
                    arrayList2 = new ArrayList();
                    for (Map.Entry entry : Map.this.entrySet()) {
                        arrayList.add(entry.getKey());
                        List<com.huawei.openalliance.ad.inter.data.d> list = (List) entry.getValue();
                        if (!aa.Code(list)) {
                            for (com.huawei.openalliance.ad.inter.data.d dVar : list) {
                                if (dVar != null) {
                                    arrayList2.add(dVar.D());
                                }
                            }
                        }
                    }
                }
                delayInfo.Code(arrayList);
                delayInfo.V(arrayList2);
                eo.V(context, com.huawei.openalliance.ad.constant.q.f32320c, com.huawei.openalliance.ad.utils.z.V(eo.V(j10, com.huawei.openalliance.ad.constant.g.Code, str, i11, i10, delayInfo)), null, null);
            }
        });
    }

    public static void Code(Context context, int i10, String str, AdContentData adContentData) {
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        analysisEventReport.Code(adContentData);
        analysisEventReport.Code(i10);
        analysisEventReport.I(str);
        analysisEventReport.C(adContentData.S());
        analysisEventReport.S(adContentData.az());
        analysisEventReport.F(adContentData.C());
        analysisEventReport.I(adContentData.aA());
        V(context, com.huawei.openalliance.ad.constant.q.f32334q, com.huawei.openalliance.ad.utils.z.V(analysisEventReport), null, null);
    }

    public static void Code(Context context, int i10, String str, String str2, String str3) {
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        analysisEventReport.V(i10);
        analysisEventReport.I(str);
        analysisEventReport.Z(str2);
        analysisEventReport.B(str3);
        V(context, com.huawei.openalliance.ad.download.app.a.Code.equals(str3) ? en.I : en.Z, com.huawei.openalliance.ad.utils.z.V(analysisEventReport), null, null);
    }

    public static void Code(Context context, AdContentData adContentData, long j10, long j11) {
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        analysisEventReport.V(j10);
        analysisEventReport.I(j11);
        if (adContentData != null) {
            analysisEventReport.C(adContentData.S());
            analysisEventReport.S(adContentData.az());
            analysisEventReport.F(adContentData.C());
            analysisEventReport.I(adContentData.aA());
        } else {
            analysisEventReport.C("");
        }
        V(context, en.V, com.huawei.openalliance.ad.utils.z.V(analysisEventReport), null, null);
    }

    public static void Code(Context context, AdContentData adContentData, String str) {
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        analysisEventReport.Code(adContentData);
        analysisEventReport.I(str);
        if (adContentData != null) {
            analysisEventReport.C(adContentData.S());
            analysisEventReport.S(adContentData.az());
            analysisEventReport.F(adContentData.C());
            analysisEventReport.I(adContentData.aA());
        }
        V(context, com.huawei.openalliance.ad.constant.q.f32339v, com.huawei.openalliance.ad.utils.z.V(analysisEventReport), null, null);
    }

    public static void Code(final Context context, final String str, final int i10, final AdContentData adContentData, final DelayInfo delayInfo) {
        if (delayInfo == null || delayInfo.Code() == null) {
            return;
        }
        com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.hms.ads.eo.2
            @Override // java.lang.Runnable
            public void run() {
                AdContentData adContentData2 = AdContentData.this;
                if (adContentData2 != null) {
                    delayInfo.V(adContentData2.af());
                    delayInfo.V(Collections.singletonList(AdContentData.this.S()));
                    delayInfo.Code(AdContentData.this.al());
                    delayInfo.Code(Integer.valueOf(AdContentData.this.h()));
                    DelayInfo ai = AdContentData.this.ai();
                    if (ai != null) {
                        delayInfo.C(ai.c());
                        delayInfo.Code(ai.V());
                        delayInfo.I(ai.Z());
                        delayInfo.B(ai.C());
                        delayInfo.V(ai.I());
                        delayInfo.F(ai.g().longValue());
                        delayInfo.I(ai.m());
                        AdTimeStatistics j10 = ai.j();
                        if (j10 != null) {
                            AdTimeStatistics j11 = delayInfo.j();
                            j10.Code(j11.Code());
                            j10.V(j11.V());
                            j10.c(j11.c());
                            j10.d(j11.d());
                            j10.e(j11.e());
                            delayInfo.Code(j10);
                        }
                    }
                }
                eo.V(context, com.huawei.openalliance.ad.constant.q.f32320c, com.huawei.openalliance.ad.utils.z.V(eo.V(delayInfo.Code().longValue(), com.huawei.openalliance.ad.constant.g.Code, str, i10, eo.V(delayInfo), delayInfo)), null, null);
            }
        });
    }

    public static void Code(Context context, String str, AdContentData adContentData, String str2) {
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        analysisEventReport.C(str);
        analysisEventReport.I(str2);
        if (adContentData != null) {
            analysisEventReport.S(adContentData.az());
            analysisEventReport.F(adContentData.C());
            analysisEventReport.I(adContentData.aA());
        }
        V(context, en.C, com.huawei.openalliance.ad.utils.z.V(analysisEventReport), null, null);
    }

    public static void Code(final Context context, final String str, final String str2, final int i10, final int i11, final String str3) {
        com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.hms.ads.eo.1
            @Override // java.lang.Runnable
            public void run() {
                AnalysisEventReport analysisEventReport = new AnalysisEventReport();
                analysisEventReport.Code(i11);
                analysisEventReport.V(i10);
                analysisEventReport.I(str);
                analysisEventReport.Z(str2);
                analysisEventReport.B(str3);
                eo.V(context, en.Code, com.huawei.openalliance.ad.utils.z.V(analysisEventReport), null, null);
            }
        });
    }

    public static void Code(final Context context, final String str, final String str2, final int i10, final String str3) {
        com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.hms.ads.eo.6
            @Override // java.lang.Runnable
            public void run() {
                AnalysisEventReport analysisEventReport = new AnalysisEventReport();
                analysisEventReport.I(String.this);
                analysisEventReport.Z(str2);
                analysisEventReport.Code(i10);
                analysisEventReport.B(str3);
                eo.V(context, en.D, com.huawei.openalliance.ad.utils.z.V(analysisEventReport), null, null);
            }
        });
    }

    public static void Code(final Context context, final String str, final String str2, final long j10) {
        com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.hms.ads.eo.5
            @Override // java.lang.Runnable
            public void run() {
                AnalysisEventReport analysisEventReport = new AnalysisEventReport();
                analysisEventReport.I(String.this);
                analysisEventReport.Z(str2);
                analysisEventReport.V(j10);
                analysisEventReport.Code(0);
                eo.V(context, en.D, com.huawei.openalliance.ad.utils.z.V(analysisEventReport), null, null);
            }
        });
    }

    public static void Code(Context context, String str, String str2, long j10, AdContentData adContentData, String str3) {
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        analysisEventReport.Code(adContentData);
        analysisEventReport.C(str2);
        analysisEventReport.I(str);
        analysisEventReport.I(j10);
        analysisEventReport.V(str3);
        if (adContentData != null) {
            analysisEventReport.S(adContentData.az());
            analysisEventReport.F(adContentData.C());
            analysisEventReport.I(adContentData.aA());
        }
        I(context, en.B, com.huawei.openalliance.ad.utils.z.V(analysisEventReport), null, null);
    }

    private static <T> void I(Context context, String str, String str2, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        com.huawei.openalliance.ad.ipc.d.Code(context).Code(str, str2, remoteCallResultCallback, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int V(DelayInfo delayInfo) {
        Integer l10;
        int f10 = delayInfo.f();
        if (f10 == -2) {
            Integer F = com.huawei.openalliance.ad.utils.au.F(delayInfo.b());
            f10 = (F != null ? 10000 + F.intValue() : 10000) + delayInfo.i();
        } else if (f10 == 494 && (l10 = delayInfo.l()) != null) {
            f10 = l10.intValue();
        }
        delayInfo.I(f10);
        return f10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ApiStatisticsReq V(long j10, String str, String str2, int i10, int i11, DelayInfo delayInfo) {
        ApiStatisticsReq apiStatisticsReq = new ApiStatisticsReq();
        apiStatisticsReq.V(j10);
        apiStatisticsReq.V(str);
        apiStatisticsReq.S(str2);
        apiStatisticsReq.I(i10);
        apiStatisticsReq.V(i11);
        apiStatisticsReq.Code(delayInfo);
        return apiStatisticsReq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void V(Context context, String str, String str2, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        com.huawei.openalliance.ad.ipc.g.V(context).Code(str, str2, remoteCallResultCallback, cls);
    }
}
