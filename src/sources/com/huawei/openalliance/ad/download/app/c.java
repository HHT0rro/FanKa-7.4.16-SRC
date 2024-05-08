package com.huawei.openalliance.ad.download.app;

import android.content.Context;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.constant.ax;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.v;
import com.huawei.openalliance.ad.utils.z;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c {
    private static final String B = "getDownloadStatus";
    private static final String C = "trafficReminderExceptionEvent";
    private static final String Code = "ApDnApi";
    private static final String D = "AutoOpenForbidden";
    private static final String F = "reportFullScreenNotify";
    private static final String I = "pauseDownloadApp";
    private static final String L = "remoteSharedPrefSet";
    private static final String S = "syncAgProtocolStatus";
    private static final String V = "startDownloadApp";
    private static final String Z = "cancelDownloadApp";

    /* renamed from: a, reason: collision with root package name */
    private static final String f32409a = "reportInstallPermission";

    /* renamed from: b, reason: collision with root package name */
    private static final String f32410b = "reserveDownloadApp";

    public static <T> T Code(Context context, AppInfo appInfo, Class<T> cls) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content", z.V(appInfo));
            return com.huawei.openalliance.ad.ipc.b.Code(context).Code(B, jSONObject.toString(), cls, Code(appInfo)).getData();
        } catch (JSONException unused) {
            gl.I(Code, "queryTask JSONException");
            return null;
        }
    }

    public static <T> void Code(Context context, int i10, String str, String str2, Class<T> cls) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ax.f32263f, i10);
            jSONObject.put(ax.f32265h, str);
            jSONObject.put("ag_action_name", str2);
            com.huawei.openalliance.ad.ipc.b.Code(context).Code(S, jSONObject.toString(), cls, true);
        } catch (JSONException unused) {
            gl.I(Code, "syncAgProcolAgreeStatus JSONException");
        }
    }

    public static <T> void Code(Context context, AppDownloadTask appDownloadTask, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        JSONObject jSONObject = new JSONObject();
        try {
            Code(appDownloadTask, jSONObject);
            com.huawei.openalliance.ad.ipc.g.V(context).Code(V, jSONObject.toString(), remoteCallResultCallback, cls);
        } catch (JSONException unused) {
            Code(remoteCallResultCallback, "startDownload JSONException", V);
        }
    }

    public static <T> void Code(Context context, String str, AdContentData adContentData, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        JSONObject jSONObject = new JSONObject();
        if (adContentData != null) {
            try {
                jSONObject.put("content_id", adContentData.S());
                jSONObject.put("templateId", adContentData.az());
                jSONObject.put("slotid", adContentData.C());
                jSONObject.put("apiVer", adContentData.aA());
            } catch (JSONException unused) {
                Code(remoteCallResultCallback, "reportAnalysisEvent JSONException", C);
                return;
            }
        }
        jSONObject.put(ax.f32252a, str);
        com.huawei.openalliance.ad.ipc.g.V(context).Code(C, jSONObject.toString(), remoteCallResultCallback, cls);
    }

    public static <T> void Code(Context context, boolean z10, int i10, String str, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ax.T, z10);
            jSONObject.put(ax.U, i10);
            jSONObject.put(ax.W, str);
            com.huawei.openalliance.ad.ipc.h.Code(context, true).Code(F, jSONObject.toString(), remoteCallResultCallback, cls);
            if (v.I()) {
                com.huawei.openalliance.ad.ipc.g.V(context).Code(F, jSONObject.toString(), remoteCallResultCallback, cls);
            }
        } catch (JSONException unused) {
            gl.I(Code, "reportFullScreenNotify JSONException");
        }
    }

    public static <T> void Code(Context context, boolean z10, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ax.f32253aa, D);
            jSONObject.put(ax.f32254ab, z10);
            com.huawei.openalliance.ad.ipc.g.V(context).Code(L, jSONObject.toString(), remoteCallResultCallback, cls);
            if (v.I()) {
                com.huawei.openalliance.ad.ipc.h.Code(context, true).Code(L, jSONObject.toString(), remoteCallResultCallback, cls);
            }
        } catch (JSONException unused) {
            gl.I(Code, "setAutoOpenForbidden JSONException");
        }
    }

    private static void Code(AppDownloadTask appDownloadTask, JSONObject jSONObject) {
        String V2 = z.V(appDownloadTask);
        gl.Code(Code, "appdownload=%s", V2);
        jSONObject.put("content", V2);
        jSONObject.put("unique_id", (appDownloadTask == null || appDownloadTask.L() == null || appDownloadTask.L().e() == null) ? "" : appDownloadTask.L().e());
    }

    private static <T> void Code(RemoteCallResultCallback<T> remoteCallResultCallback, String str, String str2) {
        gl.I(Code, str);
        if (remoteCallResultCallback != null) {
            CallResult<T> callResult = new CallResult<>();
            callResult.setCode(-1);
            callResult.setMsg(str);
            remoteCallResultCallback.onRemoteCallResult(str2, callResult);
        }
    }

    private static boolean Code(AppDownloadTask appDownloadTask) {
        return appDownloadTask != null && appDownloadTask.m();
    }

    private static boolean Code(AppInfo appInfo) {
        return appInfo != null && appInfo.o();
    }

    public static <T> void I(Context context, AppDownloadTask appDownloadTask, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content", z.V(appDownloadTask));
            AppInfo V2 = V(appDownloadTask);
            if (V2 != null) {
                jSONObject.put(ax.D, z.V(V2));
            }
            com.huawei.openalliance.ad.ipc.h.Code(context, Code(appDownloadTask)).Code(Z, jSONObject.toString(), remoteCallResultCallback, cls);
        } catch (JSONException unused) {
            Code(remoteCallResultCallback, "cancelDownload JSONException", Z);
        }
    }

    private static AppInfo V(AppDownloadTask appDownloadTask) {
        if (appDownloadTask == null || appDownloadTask.L() == null) {
            return null;
        }
        AppInfo appInfo = new AppInfo();
        appInfo.D(appDownloadTask.L().Code());
        appInfo.I(appDownloadTask.L().g());
        appInfo.a(appDownloadTask.j());
        return appInfo;
    }

    public static <T> void V(Context context, AppDownloadTask appDownloadTask, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content", z.V(appDownloadTask));
            AppInfo V2 = V(appDownloadTask);
            if (V2 != null) {
                jSONObject.put(ax.D, z.V(V2));
            }
            com.huawei.openalliance.ad.ipc.h.Code(context, Code(appDownloadTask)).Code(I, jSONObject.toString(), remoteCallResultCallback, cls);
        } catch (JSONException unused) {
            Code(remoteCallResultCallback, "pauseDownload JSONException", I);
        }
    }

    public static <T> void V(Context context, boolean z10, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ax.ai, z10);
            com.huawei.openalliance.ad.ipc.h.Code(context, true).Code(f32409a, jSONObject.toString(), remoteCallResultCallback, cls);
            if (v.I()) {
                com.huawei.openalliance.ad.ipc.g.V(context).Code(f32409a, jSONObject.toString(), remoteCallResultCallback, cls);
            }
        } catch (JSONException unused) {
            gl.I(Code, "reportInstallPermission JSONException");
        }
    }

    public static <T> void Z(Context context, AppDownloadTask appDownloadTask, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        JSONObject jSONObject = new JSONObject();
        try {
            Code(appDownloadTask, jSONObject);
            com.huawei.openalliance.ad.ipc.g.V(context).Code(f32410b, jSONObject.toString(), remoteCallResultCallback, cls);
        } catch (JSONException unused) {
            Code(remoteCallResultCallback, "reserveDownloadApp JSONException", f32410b);
        }
    }
}
