package com.ss.android.socialbase.appdownloader.m;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.utils.bf;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class sy extends m {
    public sy(Context context, DownloadSetting downloadSetting, String str) {
        super(context, downloadSetting, str);
    }

    public static String m(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            stringBuffer.append(entry.getKey());
            stringBuffer.append("=");
            stringBuffer.append(URLEncoder.encode(entry.getValue()));
            stringBuffer.append("&");
        }
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.endsWith("&") ? stringBuffer2.substring(0, stringBuffer2.length() - 1) : stringBuffer2;
    }

    @Override // com.ss.android.socialbase.appdownloader.m.np
    public Intent dk() {
        String optString = this.dk.optString(t.f36222g);
        String m10 = com.ss.android.socialbase.appdownloader.n.ej.m(this.dk.optString("bb"), optString);
        if (!TextUtils.isEmpty(m10) && m10.split(",").length == 2) {
            String m11 = com.ss.android.socialbase.appdownloader.n.ej.m(this.dk.optString("bc"), optString);
            if (!TextUtils.isEmpty(m11) && m11.split(",").length == 2) {
                String[] split = m10.split(",");
                String[] split2 = m11.split(",");
                String m12 = com.ss.android.socialbase.appdownloader.n.ej.m(this.dk.optString("bd"), optString);
                String m13 = com.ss.android.socialbase.appdownloader.n.ej.m(this.dk.optString("be"), optString);
                String m14 = com.ss.android.socialbase.appdownloader.n.ej.m(this.dk.optString(bf.TAG), optString);
                HashMap hashMap = new HashMap();
                hashMap.put(split[0], split[1]);
                hashMap.put(split2[0], split2[1]);
                hashMap.put(m12, this.ej);
                Intent intent = new Intent();
                intent.setAction(m14);
                intent.setData(Uri.parse(m13 + m(hashMap)));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }
}
