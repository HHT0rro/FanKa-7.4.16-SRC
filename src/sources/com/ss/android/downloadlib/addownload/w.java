package com.ss.android.downloadlib.addownload;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.io.File;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class w {
    public static boolean dk(int i10) {
        return i10 == 2 || i10 == 1;
    }

    public static boolean dk(DownloadModel downloadModel) {
        return downloadModel != null && downloadModel.getModelType() == 2;
    }

    public static boolean m(int i10) {
        return i10 == 0 || i10 == 1;
    }

    public static boolean m(DownloadModel downloadModel) {
        return downloadModel.isAd() && (downloadModel instanceof AdDownloadModel) && downloadModel.getModelType() == 1;
    }

    public static boolean m(DownloadModel downloadModel, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return downloadModel.isAd() && iDownloadButtonClickListener != null;
    }

    public static int m(@NonNull com.ss.android.downloadlib.addownload.dk.np npVar, boolean z10, com.ss.android.socialbase.appdownloader.n nVar) {
        int i10;
        if (nVar == null || TextUtils.isEmpty(nVar.m()) || nVar.getContext() == null) {
            return 0;
        }
        try {
            i10 = m(nVar, nVar.m());
        } catch (Throwable th) {
            c.mj().m(th, "redirectSavePathIfPossible");
            i10 = 4;
        }
        nVar.m(i10);
        if (i10 == 0) {
            nVar.m(new com.ss.android.downloadlib.ej.m());
        }
        if (!nVar.sa()) {
            nVar.m(new com.ss.android.downloadlib.ej.dk());
        }
        int m10 = com.ss.android.socialbase.appdownloader.l.oa().m(nVar);
        com.ss.android.downloadad.api.m.dk m11 = m(npVar, m10);
        com.ss.android.downloadlib.addownload.dk.n.m().m(m11);
        m11.hc(m10);
        m11.e(System.currentTimeMillis());
        m11.w(0L);
        DownloadSetting obtain = DownloadSetting.obtain(nVar.by());
        if (!m(nVar, obtain, m10) && npVar.dk.isShowToast()) {
            String startToast = npVar.dk.getStartToast();
            if (TextUtils.isEmpty(startToast)) {
                startToast = obtain.optString("download_start_toast_text");
            }
            if (TextUtils.isEmpty(startToast)) {
                startToast = z10 ? "已开始下载，可在\"我的\"里查看管理" : "已开始下载";
            }
            c.ej().m(2, nVar.getContext(), npVar.dk, startToast, null, 0);
        }
        return m10;
    }

    private static com.ss.android.downloadad.api.m.dk m(com.ss.android.downloadlib.addownload.dk.np npVar, int i10) {
        com.ss.android.downloadad.api.m.dk dkVar = new com.ss.android.downloadad.api.m.dk(npVar.dk, npVar.ej, npVar.f38585l, i10);
        boolean z10 = true;
        if (DownloadSetting.obtain(i10).optInt("download_event_opt", 1) > 1) {
            try {
                String packageName = npVar.dk.getPackageName();
                if (!TextUtils.isEmpty(packageName)) {
                    if (c.getContext().getPackageManager().getPackageInfo(packageName, 0) == null) {
                        z10 = false;
                    }
                    dkVar.e(z10);
                }
            } catch (Throwable unused) {
            }
        }
        return dkVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0094, code lost:
    
        switch(r9) {
            case 0: goto L58;
            case 1: goto L58;
            case 2: goto L57;
            case 3: goto L71;
            case 4: goto L58;
            case 5: goto L58;
            case 6: goto L54;
            case 7: goto L71;
            default: goto L80;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009e, code lost:
    
        if (com.ss.android.socialbase.appdownloader.dk.dk(r6, r12).dk != 0) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00a1, code lost:
    
        r4 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00a9, code lost:
    
        if (com.ss.android.socialbase.appdownloader.dk.m(r6, r12).dk != 0) goto L78;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean m(com.ss.android.socialbase.appdownloader.n r11, @androidx.annotation.NonNull com.ss.android.socialbase.downloader.setting.DownloadSetting r12, int r13) {
        /*
            java.lang.String r11 = "ah_plans"
            org.json.JSONArray r11 = r12.optJSONArray(r11)
            r0 = 0
            if (r11 == 0) goto Lcc
            int r1 = r11.length()
            if (r1 != 0) goto L11
            goto Lcc
        L11:
            int r1 = r11.length()
            r2 = 0
            r4 = r2
            r3 = 0
        L18:
            r5 = 1
            if (r3 >= r1) goto Lb0
            org.json.JSONObject r6 = r11.optJSONObject(r3)
            if (r6 == 0) goto Lac
            java.lang.String r7 = "type"
            java.lang.String r7 = r6.optString(r7)
            java.lang.String r8 = "plan_c"
            if (r7 == r8) goto L33
            boolean r9 = com.ss.android.socialbase.appdownloader.n.m.m(r6)
            if (r9 != 0) goto L33
            goto Lac
        L33:
            r7.hashCode()
            r9 = -1
            int r10 = r7.hashCode()
            switch(r10) {
                case -985763637: goto L8a;
                case -985763636: goto L7f;
                case -985763635: goto L76;
                case -985763634: goto L6b;
                case -985763633: goto L60;
                case -985763632: goto L55;
                case -985763631: goto L4a;
                case -985763630: goto L3f;
                default: goto L3e;
            }
        L3e:
            goto L94
        L3f:
            java.lang.String r8 = "plan_h"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L48
            goto L94
        L48:
            r9 = 7
            goto L94
        L4a:
            java.lang.String r8 = "plan_g"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L53
            goto L94
        L53:
            r9 = 6
            goto L94
        L55:
            java.lang.String r8 = "plan_f"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L5e
            goto L94
        L5e:
            r9 = 5
            goto L94
        L60:
            java.lang.String r8 = "plan_e"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L69
            goto L94
        L69:
            r9 = 4
            goto L94
        L6b:
            java.lang.String r8 = "plan_d"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L74
            goto L94
        L74:
            r9 = 3
            goto L94
        L76:
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L7d
            goto L94
        L7d:
            r9 = 2
            goto L94
        L7f:
            java.lang.String r8 = "plan_b"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L88
            goto L94
        L88:
            r9 = 1
            goto L94
        L8a:
            java.lang.String r8 = "plan_a"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L93
            goto L94
        L93:
            r9 = 0
        L94:
            switch(r9) {
                case 0: goto La3;
                case 1: goto La3;
                case 2: goto La1;
                case 3: goto Lb0;
                case 4: goto La3;
                case 5: goto La3;
                case 6: goto L98;
                case 7: goto Lb0;
                default: goto L97;
            }
        L97:
            goto Lac
        L98:
            com.ss.android.socialbase.appdownloader.m r6 = com.ss.android.socialbase.appdownloader.dk.dk(r6, r12)
            int r6 = r6.dk
            if (r6 != 0) goto Lac
            goto Lb0
        La1:
            r4 = r6
            goto Lac
        La3:
            com.ss.android.socialbase.appdownloader.m r6 = com.ss.android.socialbase.appdownloader.dk.m(r6, r12)
            int r6 = r6.dk
            if (r6 != 0) goto Lac
            goto Lb0
        Lac:
            int r3 = r3 + 1
            goto L18
        Lb0:
            if (r4 == 0) goto Lcc
            java.lang.String r11 = "show_unknown_source_on_startup"
            int r11 = r4.optInt(r11)
            if (r11 != r5) goto Lbb
            goto Lbc
        Lbb:
            r5 = 0
        Lbc:
            if (r5 == 0) goto Lcc
            android.content.Context r11 = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext()
            com.ss.android.socialbase.appdownloader.m r12 = new com.ss.android.socialbase.appdownloader.m
            r12.<init>()
            boolean r11 = com.ss.android.socialbase.appdownloader.dk.m(r11, r2, r4, r13, r12)
            return r11
        Lcc:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.w.m(com.ss.android.socialbase.appdownloader.n, com.ss.android.socialbase.downloader.setting.DownloadSetting, int):boolean");
    }

    public static String m(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        try {
            String extra = downloadInfo.getExtra();
            if (!TextUtils.isEmpty(extra)) {
                return new JSONObject(extra).optString("notification_jump_url", null);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }

    private static int m(com.ss.android.socialbase.appdownloader.n nVar, String str) {
        DownloadSetting obtain = DownloadSetting.obtain(nVar.by());
        JSONObject optJSONObject = obtain.optJSONObject(DownloadSettingKeys.KEY_ANTI_HIJACK_DIR);
        if (optJSONObject == null || TextUtils.isEmpty(optJSONObject.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_DIR_NAME))) {
            return -1;
        }
        String dk = nVar.dk();
        String d10 = nVar.d();
        if (TextUtils.isEmpty(d10)) {
            d10 = com.ss.android.socialbase.appdownloader.ej.m(str, dk, nVar.ve(), true);
        }
        if (d10.length() > 255) {
            d10 = d10.substring(d10.length() - 255);
        }
        if (TextUtils.isEmpty(dk)) {
            dk = d10;
        }
        String ej = nVar.ej();
        if (TextUtils.isEmpty(ej)) {
            ej = com.ss.android.socialbase.appdownloader.ej.dk();
        }
        String str2 = ej + File.separator + com.ss.android.socialbase.appdownloader.ej.m(dk, obtain);
        DownloadInfo m10 = com.ss.android.socialbase.appdownloader.l.oa().m(nVar.getContext(), str);
        if (m10 != null && m10.isSavePathRedirected()) {
            nVar.ej(m10.getSavePath());
            try {
                nVar.m(new JSONObject(m10.getDownloadSettingString()));
                return 0;
            } catch (Throwable unused) {
                return 0;
            }
        }
        if (m10 != null || !"application/vnd.android.package-archive".equalsIgnoreCase(com.ss.android.socialbase.appdownloader.l.oa().m(d10, nVar.ve()))) {
            return m10 != null ? 8 : 9;
        }
        int m11 = com.ss.android.socialbase.appdownloader.dk.m(obtain);
        if (m11 != 0) {
            return m11;
        }
        nVar.ej(str2);
        return m11;
    }
}
