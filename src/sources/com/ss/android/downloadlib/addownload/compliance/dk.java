package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.ss.android.download.api.config.f;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.c;
import com.ss.android.downloadlib.hc.ej;
import com.ss.android.downloadlib.hc.ve;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class dk {

    /* renamed from: m, reason: collision with root package name */
    private SoftReference<Activity> f38505m;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class m {

        /* renamed from: m, reason: collision with root package name */
        private static dk f38509m = new dk();
    }

    public void dk(long j10) {
        com.ss.android.downloadlib.addownload.np m10 = com.ss.android.downloadlib.hc.m().m(com.ss.android.downloadlib.addownload.dk.n.m().np(j10).dk.getDownloadUrl());
        if (m10 != null) {
            m10.m(true, true);
        } else {
            hc.m(11, j10);
            com.ss.android.downloadlib.np.ej.m().dk("startDownload handler null");
        }
    }

    private dk() {
    }

    public static dk m() {
        return m.f38509m;
    }

    public void m(long j10) {
        TTDelegateActivity.m(j10);
    }

    public boolean m(DownloadModel downloadModel) {
        if (!downloadModel.isAd() || c.w().optInt("ad_lp_show_app_dialog") == 0) {
            return false;
        }
        String webUrl = downloadModel.getDeepLink() == null ? null : downloadModel.getDeepLink().getWebUrl();
        return (TextUtils.isEmpty(webUrl) || Pattern.compile(c.w().optString("ad_allow_web_url_regex", ".+(www.chengzijianzhan.com|www.toutiaopage.com/tetris/page|ad.toutiao.com/tetris/page).+")).matcher(webUrl).matches()) ? false : true;
    }

    public Activity dk() {
        Activity activity = this.f38505m.get();
        this.f38505m = null;
        return activity;
    }

    public boolean m(@NonNull com.ss.android.downloadlib.addownload.dk.np npVar) {
        long j10;
        long j11;
        if (!TextUtils.isEmpty(npVar.dk.getLogExtra())) {
            try {
                j10 = ve.m(new JSONObject(npVar.dk.getLogExtra()), "convert_id");
            } catch (Exception e2) {
                e2.printStackTrace();
                j10 = 0;
            }
            if (j10 <= 0) {
                hc.m(3, npVar);
            }
            j11 = j10;
        } else {
            hc.m(9, npVar);
            com.ss.android.downloadlib.np.ej.m().m("requestAppInfo getLogExtra null");
            j11 = 0;
        }
        final long j12 = npVar.f38586m;
        com.ss.android.downloadlib.addownload.dk.dk m10 = ej.m().m(j11, j12);
        if (m10 != null) {
            l.m().m(m10.m(), j12, m10.f38560l);
            m(m10.m());
            hc.m("lp_app_dialog_try_show", npVar);
            return true;
        }
        StringBuilder sb2 = new StringBuilder();
        if (j11 > 0) {
            sb2.append("convert_id=");
            sb2.append(j11);
        }
        if (!TextUtils.isEmpty(npVar.dk.getPackageName())) {
            if (sb2.length() > 0) {
                sb2.append("&");
            }
            sb2.append("package_name=");
            sb2.append(npVar.dk.getPackageName());
        }
        if (sb2.length() <= 0) {
            hc.m(6, npVar);
            return false;
        }
        final long j13 = j11;
        com.ss.android.downloadlib.hc.ej.m((ej.m<String, R>) new ej.m<String, Boolean>() { // from class: com.ss.android.downloadlib.addownload.compliance.dk.2
            @Override // com.ss.android.downloadlib.hc.ej.m
            public Boolean m(String str) {
                final boolean[] zArr = {false};
                c.l().m("GET", str, new HashMap(), new f() { // from class: com.ss.android.downloadlib.addownload.compliance.dk.2.1
                    @Override // com.ss.android.download.api.config.f
                    public void m(String str2) {
                        boolean[] zArr2 = zArr;
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        zArr2[0] = dk.this.m(j13, j12, str2);
                    }

                    @Override // com.ss.android.download.api.config.f
                    public void m(Throwable th) {
                        hc.m(2, j12);
                        zArr[0] = false;
                    }
                });
                return Boolean.valueOf(zArr[0]);
            }
        }, "https://apps.oceanengine.com/customer/api/app/pkg_info?" + sb2.toString()).m(new ej.m<Boolean, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.dk.1
            @Override // com.ss.android.downloadlib.hc.ej.m
            public Object m(Boolean bool) {
                if (bool.booleanValue()) {
                    dk.this.m(com.ss.android.downloadlib.addownload.dk.dk.m(j13, j12));
                    hc.dk("lp_app_dialog_try_show", j12);
                    return null;
                }
                dk.this.dk(j12);
                return null;
            }
        }).m();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(long j10, long j11, String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("package");
            if (optJSONObject != null && optJSONObject.length() != 0) {
                com.ss.android.downloadlib.addownload.dk.dk dkVar = new com.ss.android.downloadlib.addownload.dk.dk();
                dkVar.f38561m = j10;
                dkVar.dk = j11;
                dkVar.f38560l = optJSONObject.optString("icon_url");
                dkVar.np = optJSONObject.optString("app_name");
                dkVar.ej = optJSONObject.optString("package_name");
                dkVar.f38562n = optJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
                dkVar.f38559hc = optJSONObject.optString("developer_name");
                dkVar.f38563w = optJSONObject.optString("policy_url");
                JSONArray optJSONArray = optJSONObject.optJSONArray("permissions");
                if (optJSONArray != null) {
                    for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                        JSONObject jSONObject = (JSONObject) optJSONArray.get(i10);
                        dkVar.f38558e.add(new Pair<>(jSONObject.optString("permission_name"), jSONObject.optString("permission_desc")));
                    }
                }
                ej.m().m(dkVar);
                l.m().m(dkVar.m(), j11, dkVar.f38560l);
                return true;
            }
            hc.m(7, j11);
            return false;
        } catch (Exception e2) {
            com.ss.android.downloadlib.np.ej.m().m(e2, "AdLpComplianceManager parseResponse");
            hc.m(7, j11);
            return false;
        }
    }

    public void m(Activity activity) {
        this.f38505m = new SoftReference<>(activity);
    }
}
