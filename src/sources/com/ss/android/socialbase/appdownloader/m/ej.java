package com.ss.android.socialbase.appdownloader.m;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.quickcard.base.Attributes;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ej extends m {

    /* renamed from: l, reason: collision with root package name */
    private final JSONObject f38894l;

    public ej(Context context, DownloadSetting downloadSetting, String str, JSONObject jSONObject) {
        super(context, downloadSetting, str);
        this.f38894l = jSONObject;
    }

    private static void m(@NonNull Intent intent, JSONObject jSONObject, JSONObject jSONObject2) {
        Iterator<String> keys;
        if (jSONObject == null || jSONObject2 == null || jSONObject.length() != jSONObject2.length() || intent == null || (keys = jSONObject.keys()) == null) {
            return;
        }
        while (keys.hasNext()) {
            String next = keys.next();
            String optString = jSONObject2.optString(next);
            if (optString != null) {
                m(jSONObject, next, optString, intent);
            }
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.m.np
    public Intent dk() {
        String optString = this.f38894l.optString("action");
        String optString2 = this.f38894l.optString(u.ck);
        int optInt = this.f38894l.optInt("flags", 1342210048);
        String optString3 = this.f38894l.optString("path_extra_key");
        String optString4 = this.f38894l.optString("path_data_key");
        JSONObject optJSONObject = this.f38894l.optJSONObject("extra");
        JSONObject optJSONObject2 = this.f38894l.optJSONObject("extra_type");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        Intent intent = new Intent(optString);
        if (!TextUtils.isEmpty(optString2)) {
            intent.addCategory(optString2);
        }
        if (!TextUtils.isEmpty(optString4)) {
            try {
                intent.setData(Uri.parse(String.format(optString4, this.ej)));
            } catch (Throwable unused) {
            }
        }
        intent.setFlags(optInt);
        if (!TextUtils.isEmpty(optString3)) {
            intent.putExtra(optString3, this.ej);
        }
        m(intent, optJSONObject, optJSONObject2);
        return intent;
    }

    private static void m(JSONObject jSONObject, String str, String str2, Intent intent) {
        str2.hashCode();
        char c4 = 65535;
        switch (str2.hashCode()) {
            case -1325958191:
                if (str2.equals("double")) {
                    c4 = 0;
                    break;
                }
                break;
            case -891985903:
                if (str2.equals(Attributes.TextOverflow.STRING)) {
                    c4 = 1;
                    break;
                }
                break;
            case 104431:
                if (str2.equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
                    c4 = 2;
                    break;
                }
                break;
            case 3327612:
                if (str2.equals("long")) {
                    c4 = 3;
                    break;
                }
                break;
            case 64711720:
                if (str2.equals("boolean")) {
                    c4 = 4;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                intent.putExtra(str, jSONObject.optDouble(str));
                return;
            case 1:
                intent.putExtra(str, jSONObject.optString(str));
                return;
            case 2:
                intent.putExtra(str, jSONObject.optInt(str));
                return;
            case 3:
                intent.putExtra(str, jSONObject.optLong(str));
                return;
            case 4:
                intent.putExtra(str, jSONObject.optBoolean(str));
                return;
            default:
                return;
        }
    }
}
