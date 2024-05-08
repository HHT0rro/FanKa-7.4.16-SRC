package com.huawei.hms.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class dz {
    private static final String Code = "ActivityStarter";
    private static final String I = "com.huawei.hms.pps.action.PPS_AR";
    private static final String V = "com.huawei.hms.pps.action.PPS_DETAIL";
    private static final int Z = 1;

    private static void Code(Context context, AdContentData adContentData, Intent intent) {
        intent.putExtra("content_id", adContentData.S());
        intent.putExtra("sdk_version", "13.4.62.302");
        intent.putExtra(com.huawei.openalliance.ad.constant.ax.f32262e, adContentData.B());
        intent.putExtra(com.huawei.openalliance.ad.constant.ax.f32264g, adContentData.E());
        intent.putExtra(com.huawei.openalliance.ad.constant.ax.f32282y, context.getPackageName());
        intent.putExtra(com.huawei.openalliance.ad.constant.ax.N, adContentData.ao());
        intent.putExtra(com.huawei.openalliance.ad.constant.ax.O, adContentData.ap());
        intent.putExtra("templateId", adContentData.az());
        intent.putExtra("slotid", adContentData.C());
        intent.putExtra("apiVer", adContentData.aA());
    }

    private static void Code(Context context, AdContentData adContentData, gd gdVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            Code(adContentData, jSONObject);
            jSONObject.put(com.huawei.openalliance.ad.constant.ax.f32261d, adContentData.t());
            jSONObject.put(com.huawei.openalliance.ad.constant.ax.f32268k, adContentData.v());
            jSONObject.put("unique_id", adContentData.T());
            Code(jSONObject, gdVar);
            com.huawei.openalliance.ad.ipc.h.Code(context, adContentData.ak()).Code(com.huawei.openalliance.ad.constant.q.f32318a, jSONObject.toString(), null, null);
        } catch (JSONException e2) {
            gl.I(Code, "startAdActivityViaAidl, e:" + e2.getClass().getSimpleName());
        }
    }

    public static void Code(Context context, AdContentData adContentData, gd gdVar, boolean z10) {
        try {
            if (!(context instanceof Activity) || adContentData.ak()) {
                Code(context, adContentData, gdVar);
                return;
            }
            gl.V(Code, "activity context");
            Intent intent = new Intent();
            intent.setAction(V);
            intent.setPackage(com.huawei.openalliance.ad.utils.v.Z(context));
            Code(context, adContentData, intent);
            intent.putExtra(com.huawei.openalliance.ad.constant.ax.f32261d, adContentData.t());
            intent.putExtra(com.huawei.openalliance.ad.constant.ax.f32268k, adContentData.v());
            intent.putExtra("unique_id", adContentData.T());
            Code(intent, gdVar);
            if (z10) {
                intent.addFlags(268959744);
            }
            intent.setClipData(com.huawei.openalliance.ad.constant.u.cG);
            ((Activity) context).startActivityForResult(intent, 1);
        } catch (Throwable th) {
            gl.Code(3, th);
            gl.V(Code, "startAdActivity error, %s", th.getClass().getSimpleName());
        }
    }

    private static void Code(Intent intent, gd gdVar) {
        gl.Code(Code, "parseLinkedAdConfig");
        if (intent == null || gdVar == null) {
            return;
        }
        intent.putExtra(com.huawei.openalliance.ad.constant.ax.f32271n, gdVar.B());
        intent.putExtra(com.huawei.openalliance.ad.constant.ax.f32270m, gdVar.C());
        intent.putExtra(com.huawei.openalliance.ad.constant.ax.f32272o, gdVar.Code());
        intent.putExtra(com.huawei.openalliance.ad.constant.ax.f32274q, gdVar.I());
        intent.putExtra(com.huawei.openalliance.ad.constant.ax.f32273p, gdVar.V());
    }

    private static void Code(Intent intent, JSONObject jSONObject, Map<String, String> map, boolean z10) {
        if (map == null || map.isEmpty()) {
            return;
        }
        String V2 = com.huawei.openalliance.ad.utils.z.V(map);
        if (com.huawei.openalliance.ad.utils.au.Code(V2)) {
            return;
        }
        if (z10) {
            intent.putExtra(com.huawei.openalliance.ad.constant.ax.P, V2);
            return;
        }
        try {
            jSONObject.put(com.huawei.openalliance.ad.constant.ax.P, V2);
        } catch (JSONException e2) {
            gl.Z(Code, "set ar linked params error," + e2.getClass().getSimpleName());
        }
    }

    private static void Code(AdContentData adContentData, JSONObject jSONObject) {
        jSONObject.put("content_id", adContentData.S());
        jSONObject.put("sdk_version", "13.4.62.302");
        jSONObject.put(com.huawei.openalliance.ad.constant.ax.f32262e, adContentData.B());
        jSONObject.put(com.huawei.openalliance.ad.constant.ax.f32264g, adContentData.E());
        jSONObject.put(com.huawei.openalliance.ad.constant.ax.N, adContentData.ao());
        jSONObject.put(com.huawei.openalliance.ad.constant.ax.O, adContentData.ap());
        jSONObject.put("templateId", adContentData.az());
        jSONObject.put("slotid", adContentData.C());
        jSONObject.put("apiVer", adContentData.aA());
    }

    public static void Code(JSONObject jSONObject, gd gdVar) {
        if (jSONObject == null || gdVar == null) {
            return;
        }
        gl.Code(Code, "parseLinkedAdConfigViaAid");
        try {
            jSONObject.put(com.huawei.openalliance.ad.constant.ax.f32271n, gdVar.B());
            jSONObject.put(com.huawei.openalliance.ad.constant.ax.f32270m, gdVar.C());
            jSONObject.put(com.huawei.openalliance.ad.constant.ax.f32272o, gdVar.Code());
            jSONObject.put(com.huawei.openalliance.ad.constant.ax.f32274q, gdVar.I());
            jSONObject.put(com.huawei.openalliance.ad.constant.ax.f32273p, gdVar.V());
        } catch (JSONException e2) {
            gl.I(Code, "startAdActivityViaAidl, e:" + e2.getClass().getSimpleName());
        }
    }

    public static boolean Code(Context context, AdContentData adContentData, Map<String, String> map) {
        String str;
        try {
            if (!(context instanceof Activity) || adContentData.ak()) {
                return V(context, adContentData, map);
            }
            try {
                try {
                    Intent intent = new Intent();
                    intent.setAction(I);
                    intent.setPackage(com.huawei.openalliance.ad.utils.v.Z(context));
                    Code(context, adContentData, intent);
                    Code(intent, (JSONObject) null, map, true);
                    intent.setClipData(com.huawei.openalliance.ad.constant.u.cG);
                    ((Activity) context).startActivityForResult(intent, 1);
                    return true;
                } catch (Exception e2) {
                    str = "Exception e:" + e2.getClass().getSimpleName();
                    gl.I(Code, str);
                    return false;
                }
            } catch (ActivityNotFoundException e10) {
                str = "ActivityNotFoundException e:" + e10.getClass().getSimpleName();
                gl.I(Code, str);
                return false;
            }
        } catch (Throwable th) {
            gl.Code(3, th);
            gl.V(Code, "startArActivity error, %s", th.getClass().getSimpleName());
            return false;
        }
    }

    private static boolean V(Context context, AdContentData adContentData, Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            Code(adContentData, jSONObject);
            Code((Intent) null, jSONObject, map, false);
            com.huawei.openalliance.ad.ipc.h.Code(context, adContentData.ak()).Code(com.huawei.openalliance.ad.constant.q.f32332o, jSONObject.toString(), null, null);
            return true;
        } catch (JSONException e2) {
            gl.I(Code, "startArActivityViaAidl, e:" + e2.getClass().getSimpleName());
            return false;
        }
    }
}
