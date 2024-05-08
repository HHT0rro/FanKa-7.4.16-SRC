package com.ss.android.socialbase.appdownloader.m;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alipay.sdk.sys.a;
import com.kuaishou.weapon.p0.t;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class w extends m {

    /* renamed from: l, reason: collision with root package name */
    private String f38896l;
    private String np;

    public w(Context context, DownloadSetting downloadSetting, String str, String str2, String str3) {
        super(context, downloadSetting, str);
        this.f38896l = str2;
        this.np = str3;
    }

    @Override // com.ss.android.socialbase.appdownloader.m.np
    public Intent dk() {
        String str;
        String optString = this.dk.optString(t.f36222g);
        String m10 = com.ss.android.socialbase.appdownloader.n.ej.m(this.dk.optString("ak"), optString);
        String m11 = com.ss.android.socialbase.appdownloader.n.ej.m(this.dk.optString("am"), optString);
        String m12 = com.ss.android.socialbase.appdownloader.n.ej.m(this.dk.optString(a.f4668i), optString);
        String str2 = null;
        if (!TextUtils.isEmpty(m12) && m12.split(",").length == 2) {
            String[] split = m12.split(",");
            String m13 = com.ss.android.socialbase.appdownloader.n.ej.m(this.dk.optString("al"), optString);
            String m14 = com.ss.android.socialbase.appdownloader.n.ej.m(this.dk.optString("ao"), optString);
            if (!TextUtils.isEmpty(m14) && m14.split(",").length == 2) {
                String[] split2 = m14.split(",");
                JSONObject optJSONObject = this.dk.optJSONObject(DownloadSettingKeys.KEY_ANTI_HIJACK_DIR);
                if (optJSONObject != null) {
                    String optString2 = optJSONObject.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_DIR_NAME);
                    if (!TextUtils.isEmpty(optString2) && optString2.contains("%s")) {
                        try {
                            str = String.format(optString2, this.np);
                        } catch (Throwable unused) {
                            str = this.np;
                        }
                    } else {
                        str = this.np;
                    }
                    str2 = str;
                    if (str2.length() > 255) {
                        str2 = m13.substring(str2.length() - 255);
                    }
                }
                Intent intent = new Intent(m10);
                intent.putExtra(split2[0], split2[1]);
                intent.putExtra(m11, this.f38896l);
                intent.putExtra(m13, str2);
                intent.putExtra(split[0], Integer.parseInt(split[1]));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }
}
