package com.ss.android.downloadlib.hc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.textclassifier.ConversationAction;
import androidx.annotation.NonNull;
import com.huawei.openalliance.ad.constant.u;
import com.kuaishou.weapon.p0.t;
import com.ss.android.download.api.config.f;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadlib.activity.JumpKllkActivity;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sun.util.locale.LanguageTag;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class e {
    private static void e(Context context, com.ss.android.downloadlib.addownload.dk.np npVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.m(str, npVar.f38586m, "need_comment");
        } catch (Exception unused) {
            com.ss.android.downloadlib.dk.m.m(m(context, Uri.parse("market://details?id=" + str)), npVar, true);
            dk(npVar, jSONObject, 9, 8, "market://details?id=" + str);
        }
    }

    private static com.ss.android.downloadlib.addownload.dk.hc ej(Context context, com.ss.android.downloadlib.addownload.dk.np npVar, String str) {
        Intent intent = new Intent(context, (Class<?>) JumpKllkActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("dl", true);
        intent.putExtra(t.f36217b, str);
        intent.putExtra("id", npVar.f38586m);
        if (Build.VERSION.SDK_INT >= 29) {
            intent.putExtra("bk", "com.heytap.browser");
        } else if (ve.np(context, "com.android.browser")) {
            intent.putExtra("bk", "com.android.browser");
        } else if (ve.np(context, "com.coloros.browser")) {
            intent.putExtra("bk", "com.coloros.browser");
        } else {
            return m(context, Uri.parse("market://details?id=" + str));
        }
        intent.putExtra("start_only_for_android", true);
        JSONObject jSONObject = new JSONObject();
        try {
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.dk.hc(7, "am_kllk3");
        } catch (Throwable unused) {
            dk(npVar, jSONObject, 1, 3, "market://details?id=" + str);
            return m(context, Uri.parse("market://details?id=" + str));
        }
    }

    private static void hc(final Context context, final com.ss.android.downloadlib.addownload.dk.np npVar, final String str) {
        com.ss.android.downloadlib.l.m().m(new Runnable() { // from class: com.ss.android.downloadlib.hc.e.7
            @Override // java.lang.Runnable
            public void run() {
                JSONObject w3 = com.ss.android.downloadlib.addownload.c.w();
                String optString = w3.optString(t.f36222g);
                final JSONObject jSONObject = new JSONObject();
                String m10 = com.ss.android.socialbase.appdownloader.n.ej.m(w3.optString(LanguageTag.PRIVATEUSE), optString);
                JSONObject jSONObject2 = new JSONObject();
                ve.m(jSONObject2, "t", t.f36218c);
                ve.m(jSONObject2, t.f36217b, String.this);
                byte[] bytes = jSONObject2.toString().getBytes();
                com.ss.android.downloadlib.addownload.c.l().m(m10, com.ss.android.downloadlib.addownload.c.f().m(bytes, bytes.length), "application/octet-stream;tt-data=a", 0, new f() { // from class: com.ss.android.downloadlib.hc.e.7.1
                    @Override // com.ss.android.download.api.config.f
                    public void m(String str2) {
                        AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                        e.dk(context, String.this, str2, npVar, jSONObject);
                    }

                    @Override // com.ss.android.download.api.config.f
                    public void m(Throwable th) {
                        com.ss.android.downloadlib.dk.m.m(e.m(context, Uri.parse("market://details?id=" + String.this)), npVar, true);
                        ve.m(jSONObject, "ttdownloader_message", th != null ? th.getMessage() : "null");
                        e.dk(npVar, jSONObject, 7, 5, "market://details?id=" + String.this);
                    }
                });
            }
        });
    }

    private static com.ss.android.downloadlib.addownload.dk.hc l(@NonNull Context context, @NonNull String str) {
        try {
            Uri parse = Uri.parse("https://www.samsungapps.com/appquery/appDetail.as?appId=" + str);
            Intent intent = new Intent();
            intent.setClassName("com.sec.android.app.samsungapps", "com.sec.android.app.samsungapps.Main");
            intent.setData(parse);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.dk.hc(5);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.dk.hc(6, 14);
        }
    }

    private static void n(Context context, com.ss.android.downloadlib.addownload.dk.np npVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.m(str, npVar.f38586m);
        } catch (Exception unused) {
            com.ss.android.downloadlib.dk.m.m(m(context, Uri.parse("market://details?id=" + str)), npVar, true);
            dk(npVar, jSONObject, 13, 10, "market://details?id=" + str);
        }
    }

    private static void np(final Context context, final com.ss.android.downloadlib.addownload.dk.np npVar, final String str) {
        com.ss.android.downloadlib.l.m().m(new Runnable() { // from class: com.ss.android.downloadlib.hc.e.6
            @Override // java.lang.Runnable
            public void run() {
                JSONObject w3 = com.ss.android.downloadlib.addownload.c.w();
                final JSONObject jSONObject = new JSONObject();
                try {
                    String optString = w3.optString(t.f36222g);
                    String m10 = com.ss.android.socialbase.appdownloader.n.ej.m(w3.optString("bw"), optString);
                    String m11 = com.ss.android.socialbase.appdownloader.n.ej.m(w3.optString("bx"), optString);
                    String m12 = com.ss.android.socialbase.appdownloader.n.ej.m(w3.optString("by"), optString);
                    Uri.Builder builder = new Uri.Builder();
                    builder.scheme("https").authority(m10).appendPath(m11).appendQueryParameter(m12, String.this);
                    com.ss.android.downloadlib.addownload.c.l().m("GET", builder.build().toString(), null, new f() { // from class: com.ss.android.downloadlib.hc.e.6.1
                        /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
                        /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
                        @Override // com.ss.android.download.api.config.f
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public void m(java.lang.String r6) {
                            /*
                                r5 = this;
                                boolean r0 = android.text.TextUtils.isEmpty(r6)
                                r1 = 1
                                if (r0 != 0) goto L28
                                java.lang.String r6 = com.ss.android.downloadlib.hc.e.m(r6)
                                boolean r0 = android.text.TextUtils.isEmpty(r6)
                                if (r0 != 0) goto L28
                                java.lang.String r6 = com.ss.android.downloadlib.hc.e.dk(r6)
                                boolean r0 = android.text.TextUtils.isEmpty(r6)
                                if (r0 != 0) goto L28
                                com.ss.android.downloadlib.hc.e$6 r0 = com.ss.android.downloadlib.hc.e.AnonymousClass6.this
                                android.content.Context r2 = r2
                                com.ss.android.downloadlib.addownload.dk.np r3 = r3
                                java.lang.String r0 = java.lang.String.this
                                com.ss.android.downloadlib.hc.e.m(r2, r3, r0, r6)
                                r6 = 1
                                goto L29
                            L28:
                                r6 = 0
                            L29:
                                if (r6 != 0) goto L73
                                com.ss.android.downloadlib.hc.e$6 r6 = com.ss.android.downloadlib.hc.e.AnonymousClass6.this
                                android.content.Context r6 = r2
                                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                                r0.<init>()
                                java.lang.String r2 = "market://details?id="
                                r0.append(r2)
                                com.ss.android.downloadlib.hc.e$6 r3 = com.ss.android.downloadlib.hc.e.AnonymousClass6.this
                                java.lang.String r3 = java.lang.String.this
                                r0.append(r3)
                                java.lang.String r0 = r0.toString()
                                android.net.Uri r0 = android.net.Uri.parse(r0)
                                com.ss.android.downloadlib.addownload.dk.hc r6 = com.ss.android.downloadlib.hc.e.m(r6, r0)
                                com.ss.android.downloadlib.hc.e$6 r0 = com.ss.android.downloadlib.hc.e.AnonymousClass6.this
                                com.ss.android.downloadlib.addownload.dk.np r0 = r3
                                com.ss.android.downloadlib.dk.m.m(r6, r0, r1)
                                com.ss.android.downloadlib.hc.e$6 r6 = com.ss.android.downloadlib.hc.e.AnonymousClass6.this
                                com.ss.android.downloadlib.addownload.dk.np r6 = r3
                                org.json.JSONObject r0 = r2
                                r1 = 10
                                r3 = 9
                                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                                r4.<init>()
                                r4.append(r2)
                                com.ss.android.downloadlib.hc.e$6 r2 = com.ss.android.downloadlib.hc.e.AnonymousClass6.this
                                java.lang.String r2 = java.lang.String.this
                                r4.append(r2)
                                java.lang.String r2 = r4.toString()
                                com.ss.android.downloadlib.hc.e.m(r6, r0, r1, r3, r2)
                            L73:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.hc.e.AnonymousClass6.AnonymousClass1.m(java.lang.String):void");
                        }

                        @Override // com.ss.android.download.api.config.f
                        public void m(Throwable th) {
                            com.ss.android.downloadlib.dk.m.m(e.m(context, Uri.parse("market://details?id=" + String.this)), npVar, true);
                            ve.m(jSONObject, "ttdownloader_message", th != null ? th.getMessage() : "null");
                            e.dk(npVar, jSONObject, 11, 9, "market://details?id=" + String.this);
                        }
                    });
                } catch (Exception e2) {
                    e2.printStackTrace();
                    e.dk(npVar, jSONObject, 4, 9, "market://details?id=" + String.this);
                }
            }
        });
    }

    private static com.ss.android.downloadlib.addownload.dk.hc dk(Context context, com.ss.android.downloadlib.addownload.dk.np npVar, String str) {
        Intent intent = new Intent(context, (Class<?>) JumpKllkActivity.class);
        intent.addFlags(268435456);
        intent.putExtra(t.f36217b, str);
        intent.putExtra("id", npVar.f38586m);
        intent.putExtra("start_only_for_android", true);
        JSONObject jSONObject = new JSONObject();
        try {
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.dk.hc(7, "am_kllk2");
        } catch (Throwable unused) {
            dk(npVar, jSONObject, 1, 3, "market://details?id=" + str);
            return m(context, Uri.parse("market://details?id=" + str));
        }
    }

    public static com.ss.android.downloadlib.addownload.dk.hc m(Context context, Uri uri) {
        if (!com.ss.android.socialbase.appdownloader.n.np.ej() && (context == null || uri == null || !"market".equals(uri.getScheme()))) {
            return new com.ss.android.downloadlib.addownload.dk.hc(6, 12);
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            if (!ve.m(context, intent)) {
                return new com.ss.android.downloadlib.addownload.dk.hc(6, 13);
            }
            String oa2 = com.ss.android.socialbase.appdownloader.n.np.oa();
            if (ve.np(context, oa2) && !com.ss.android.socialbase.appdownloader.n.np.hc()) {
                intent.setPackage(oa2);
            }
            if (DownloadSetting.obtainGlobal().optBugFix("fix_jump_market")) {
                intent.addFlags(335544320);
            } else if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            if (DownloadSetting.obtainGlobal().optInt("test_jump_market_failed") == 1) {
                com.ss.android.downloadlib.np.ej.m().m(false, "jump market error");
                return new com.ss.android.downloadlib.addownload.dk.hc(6, 25);
            }
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.dk.hc(5);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.dk.hc(6, 14);
        }
    }

    private static void l(final Context context, final com.ss.android.downloadlib.addownload.dk.np npVar, final String str) {
        com.ss.android.downloadlib.l.m().m(new Runnable() { // from class: com.ss.android.downloadlib.hc.e.5
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.downloadlib.dk.m.m(e.m(context, Uri.parse("market://details?id=" + str)), npVar, true);
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject w3 = com.ss.android.downloadlib.addownload.c.w();
                    Thread.sleep(w3.optInt("m2_delay_millis", 1000));
                    com.ss.android.downloadlib.m.m.m.m().m(context, true);
                    com.ss.android.downloadlib.m.m.dk dkVar = new com.ss.android.downloadlib.m.m.dk();
                    dkVar.f38800m = 1;
                    dkVar.dk = 0;
                    String m10 = com.ss.android.socialbase.appdownloader.n.ej.m(w3.optString(t.f36218c), w3.optString(t.f36222g));
                    dkVar.ej = String.format(m10, str);
                    com.ss.android.downloadlib.m.m.m.m().m(dkVar, (com.ss.android.downloadlib.m.m.l) null);
                    com.ss.android.downloadlib.m.m.m.m().dk();
                    e.dk(npVar, jSONObject, -1, 2, String.format(m10, str));
                } catch (Throwable th) {
                    th.printStackTrace();
                    e.dk(npVar, jSONObject, 1, 2, "market://details?id=" + str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dk(Context context, String str, String str2, @NonNull com.ss.android.downloadlib.addownload.dk.np npVar, @NonNull JSONObject jSONObject) {
        ve.m(jSONObject, "ttdownloader_type", (Object) 5);
        try {
            String m10 = com.ss.android.socialbase.appdownloader.n.ej.m(new JSONObject(str2).optString("a"));
            if (!TextUtils.isEmpty(m10)) {
                TTDelegateActivity.m(str, npVar.f38586m, m10, jSONObject);
            } else {
                com.ss.android.downloadlib.dk.m.m(m(context, Uri.parse("market://details?id=" + str)), npVar, true);
                dk(npVar, jSONObject, 5, 5, "market://details?id=" + str);
            }
        } catch (Exception unused) {
            com.ss.android.downloadlib.dk.m.m(m(context, Uri.parse("market://details?id=" + str)), npVar, true);
            dk(npVar, jSONObject, 6, 5, "market://details?id=" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String l(String str) {
        List<String> pathSegments = Uri.parse(str).getPathSegments();
        if (pathSegments.size() > 0) {
            return pathSegments.get(pathSegments.size() - 1);
        }
        return null;
    }

    public static boolean ej(@NonNull Activity activity, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra("start_only_for_android", true);
        String oa2 = com.ss.android.socialbase.appdownloader.n.np.oa();
        if (ve.np(com.ss.android.downloadlib.addownload.c.getContext(), oa2)) {
            intent.setPackage(oa2);
        }
        if (!ve.m(com.ss.android.downloadlib.addownload.c.getContext(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e2) {
            com.ss.android.downloadlib.np.ej.m().m(e2, "start HM2");
            return false;
        }
    }

    public static boolean dk(@NonNull Activity activity, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra("start_only_for_android", true);
        String oa2 = com.ss.android.socialbase.appdownloader.n.np.oa();
        if (ve.np(com.ss.android.downloadlib.addownload.c.getContext(), oa2)) {
            intent.setPackage(oa2);
        }
        if (!ve.m(com.ss.android.downloadlib.addownload.c.getContext(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e2) {
            com.ss.android.downloadlib.np.ej.m().m(e2, "start HM1");
            return false;
        }
    }

    public static com.ss.android.downloadlib.addownload.dk.hc m(final Context context, Uri uri, com.ss.android.downloadlib.addownload.dk.np npVar) {
        com.ss.android.downloadad.api.m.dk dkVar;
        if (context != null && com.ss.android.downloadlib.dk.oa.m(uri)) {
            try {
                final Intent intent = new Intent("android.intent.action.VIEW", uri);
                if (!ve.m(context, intent)) {
                    return new com.ss.android.downloadlib.addownload.dk.hc(6, 13);
                }
                String oa2 = com.ss.android.socialbase.appdownloader.n.np.oa();
                if (ve.np(context, oa2)) {
                    intent.setPackage(oa2);
                }
                intent.addFlags(335544320);
                if (DownloadSetting.obtainGlobal().optInt("test_jump_market_failed") == 1 && "local_test".equals(com.ss.android.downloadlib.addownload.c.oa().ej)) {
                    com.ss.android.downloadlib.np.ej.m().m(false, "jump market error");
                    return new com.ss.android.downloadlib.addownload.dk.hc(6, 25);
                }
                intent.putExtra("start_only_for_android", true);
                long optLong = com.ss.android.downloadlib.addownload.c.w().optLong("market_jump_delay", 1000L);
                if (optLong > 0 && npVar != null && (dkVar = npVar.np) != null && !dkVar.by()) {
                    com.ss.android.downloadlib.hc.m().dk().post(new Runnable() { // from class: com.ss.android.downloadlib.hc.e.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.ss.android.downloadlib.addownload.c.ej().m(8, com.ss.android.downloadlib.addownload.c.getContext(), null, "浏览器跳转失败，正在前往应用商店", null, 0);
                        }
                    });
                }
                com.ss.android.downloadlib.l.m().m(new Runnable() { // from class: com.ss.android.downloadlib.hc.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        context.startActivity(intent);
                    }
                }, optLong);
                return new com.ss.android.downloadlib.addownload.dk.hc(5);
            } catch (Exception unused) {
                return new com.ss.android.downloadlib.addownload.dk.hc(6, 14);
            }
        }
        return new com.ss.android.downloadlib.addownload.dk.hc(6, 12);
    }

    public static boolean ej(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            intent.addFlags(268435456);
            intent.putExtra(ConversationAction.TYPE_OPEN_URL, str);
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dk(com.ss.android.downloadlib.addownload.dk.np npVar, JSONObject jSONObject, int i10, int i11, String str) {
        ve.m(jSONObject, "error_code", Integer.valueOf(i10));
        ve.m(jSONObject, "ttdownloader_type", Integer.valueOf(i11));
        ve.m(jSONObject, "rmu", str);
        ve.m(jSONObject, com.ss.android.socialbase.appdownloader.n.np.oa(), Integer.valueOf(ve.dk(com.ss.android.downloadlib.addownload.c.getContext(), com.ss.android.socialbase.appdownloader.n.np.oa())));
        com.ss.android.downloadlib.l.m.m().dk("am_result", jSONObject, npVar);
    }

    public static com.ss.android.downloadlib.addownload.dk.hc dk(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return new com.ss.android.downloadlib.addownload.dk.hc(4, 11);
        }
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.c.getContext();
        }
        Intent hc2 = ve.hc(context, str);
        if (hc2 == null) {
            return new com.ss.android.downloadlib.addownload.dk.hc(4, 22);
        }
        hc2.putExtra("start_only_for_android", true);
        try {
            context.startActivity(hc2);
            return new com.ss.android.downloadlib.addownload.dk.hc(3);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.dk.hc(4, 23);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String ej(String str) {
        Matcher matcher = Pattern.compile("<input[\\s\\S]*>\\n").matcher(str);
        String group = matcher.find() ? matcher.group() : "";
        if (!group.equals(null) && group.length() > 0) {
            for (String str2 : group.split("\\n")) {
                if (str2.startsWith("<input")) {
                    for (String str3 : str2.split("\\s")) {
                        if (str3.startsWith("value")) {
                            return str3.substring(7, str3.length() - 1);
                        }
                    }
                }
            }
        }
        return null;
    }

    public static com.ss.android.downloadlib.addownload.dk.hc m(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (com.ss.android.socialbase.appdownloader.n.np.hc() && ve.np(context, "com.sec.android.app.samsungapps")) {
                return l(context, str);
            }
            return m(context, Uri.parse("market://details?id=" + str));
        }
        return new com.ss.android.downloadlib.addownload.dk.hc(6, 11);
    }

    public static com.ss.android.downloadlib.addownload.dk.hc dk(String str, @NonNull com.ss.android.downloadad.api.m.m mVar) {
        if (TextUtils.isEmpty(str)) {
            return new com.ss.android.downloadlib.addownload.dk.hc(2, 21);
        }
        Context context = com.ss.android.downloadlib.addownload.c.getContext();
        Uri parse = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(parse);
        intent.addFlags(268435456);
        intent.putExtra(ConversationAction.TYPE_OPEN_URL, str);
        intent.putExtra("start_only_for_android", true);
        if (DownloadSetting.obtainGlobal().optBugFix("fix_app_link_flag")) {
            intent.addFlags(67108864);
        }
        if (ve.dk(context, intent)) {
            if (com.ss.android.downloadlib.addownload.c.w().optInt("open_url_mode") == 0 && com.ss.android.downloadlib.addownload.c.ve() != null && com.ss.android.downloadlib.addownload.c.ve().m() && Build.VERSION.SDK_INT >= 26 && mVar.t()) {
                TTDelegateActivity.m(str, mVar);
            } else {
                try {
                    com.ss.android.downloadlib.addownload.c.getContext().startActivity(intent);
                } catch (Exception unused) {
                    return new com.ss.android.downloadlib.addownload.dk.hc(2);
                }
            }
            return new com.ss.android.downloadlib.addownload.dk.hc(1);
        }
        return new com.ss.android.downloadlib.addownload.dk.hc(2, 24);
    }

    public static com.ss.android.downloadlib.addownload.dk.hc m(Context context, com.ss.android.downloadlib.addownload.dk.np npVar, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (com.ss.android.socialbase.appdownloader.n.np.hc() && ve.np(context, "com.sec.android.app.samsungapps")) {
                return l(context, str);
            }
            if (npVar.dk.isAd() && npVar.f38585l.enableAM()) {
                JSONArray optJSONArray = com.ss.android.downloadlib.addownload.c.w().optJSONArray("am_plans");
                if (com.ss.android.socialbase.appdownloader.n.np.np() && com.ss.android.socialbase.appdownloader.n.m.m(optJSONArray, "am_3")) {
                    return dk(context, npVar, str);
                }
                if (com.ss.android.socialbase.appdownloader.n.np.n() && com.ss.android.socialbase.appdownloader.n.m.m(optJSONArray, "am_2")) {
                    l(context, npVar, str);
                    return new com.ss.android.downloadlib.addownload.dk.hc(7, "am_m2");
                }
                if (com.ss.android.socialbase.appdownloader.n.np.l() && com.ss.android.socialbase.appdownloader.n.m.m(optJSONArray, "am_5")) {
                    hc(context, npVar, str);
                    return new com.ss.android.downloadlib.addownload.dk.hc(7, "am_v1");
                }
                if (com.ss.android.socialbase.appdownloader.n.np.np() && com.ss.android.socialbase.appdownloader.n.m.m(optJSONArray, "am_7")) {
                    DownloadController downloadController = npVar.f38585l;
                    if ((downloadController instanceof AdDownloadController) && ((AdDownloadController) downloadController).enableOppoAutoDownload()) {
                        return ej(context, npVar, str);
                    }
                }
                if (com.ss.android.socialbase.appdownloader.n.np.l() && com.ss.android.socialbase.appdownloader.n.m.m(optJSONArray, "am_8") && ve.m(ve.ej(context, "com.bbk.appstore"), "8.7.2.0") >= 0) {
                    e(context, npVar, str);
                    return new com.ss.android.downloadlib.addownload.dk.hc(7, "am_v2");
                }
                if ((com.ss.android.socialbase.appdownloader.n.np.m() || com.ss.android.socialbase.appdownloader.n.np.dk()) && com.ss.android.socialbase.appdownloader.n.m.m(optJSONArray, "am_9")) {
                    np(context, npVar, str);
                    return new com.ss.android.downloadlib.addownload.dk.hc(7, "am_hr");
                }
                if ((com.ss.android.socialbase.appdownloader.n.np.m() || com.ss.android.socialbase.appdownloader.n.np.dk()) && com.ss.android.socialbase.appdownloader.n.m.m(optJSONArray, "am_10")) {
                    n(context, npVar, str);
                    return new com.ss.android.downloadlib.addownload.dk.hc(7, "am_hr2");
                }
                return m(context, Uri.parse("market://details?id=" + str));
            }
            return m(context, Uri.parse("market://details?id=" + str));
        }
        return new com.ss.android.downloadlib.addownload.dk.hc(6, 11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dk(Context context, @NonNull com.ss.android.downloadlib.addownload.dk.np npVar, @NonNull String str, @NonNull String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.dk(str, npVar.f38586m, str2);
        } catch (Exception unused) {
            com.ss.android.downloadlib.dk.m.m(m(context, Uri.parse("market://details?id=" + str)), npVar, true);
            dk(npVar, jSONObject, 12, 9, "market://details?id=" + str);
        }
    }

    public static void dk(@NonNull Activity activity, String str, long j10, String str2) {
        com.ss.android.downloadlib.addownload.dk.np np = com.ss.android.downloadlib.addownload.dk.n.m().np(j10);
        JSONObject jSONObject = new JSONObject();
        JSONObject w3 = com.ss.android.downloadlib.addownload.c.w();
        String optString = w3.optString(t.f36222g);
        String m10 = com.ss.android.socialbase.appdownloader.n.ej.m(w3.optString("bz"), optString);
        String m11 = com.ss.android.socialbase.appdownloader.n.ej.m(w3.optString("ca"), optString);
        String m12 = com.ss.android.socialbase.appdownloader.n.ej.m(w3.optString("cb"), optString);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("hiapplink").authority(u.W);
        if (!TextUtils.isEmpty(m10)) {
            builder.appendQueryParameter(m10, str2);
        }
        if (!TextUtils.isEmpty(m11) && !TextUtils.isEmpty(m12)) {
            builder.appendQueryParameter(m11, m12);
        }
        if (dk(activity, builder.build())) {
            dk(np, jSONObject, -1, 9, "market://details?id=" + str);
            com.ss.android.downloadlib.dk.m.m("am_hr", jSONObject, np, true);
            return;
        }
        dk(np, jSONObject, 2, 9, "market://details?id=" + str);
        com.ss.android.downloadlib.dk.m.m(m((Context) activity, Uri.parse("market://details?id=" + str)), np, true);
    }

    public static boolean m(Context context, com.ss.android.downloadlib.addownload.dk.np npVar, String str, JSONObject jSONObject, boolean z10, int i10) {
        ve.m(jSONObject, "download_scene", Integer.valueOf(npVar.mj()));
        com.ss.android.downloadlib.l.m.m().dk("market_click_open", jSONObject, npVar);
        com.ss.android.downloadlib.addownload.dk.hc m10 = m(context, Uri.parse(str));
        String m11 = ve.m(m10.dk(), "open_market");
        int type = m10.getType();
        if (type == 5) {
            com.ss.android.downloadlib.dk.m.m(m11, jSONObject, npVar, true);
        } else {
            if (type == 6) {
                ve.m(jSONObject, "error_code", Integer.valueOf(m10.m()));
                ve.m(jSONObject, "download_scene", Integer.valueOf(npVar.mj()));
                com.ss.android.downloadlib.l.m.m().dk("market_open_failed", jSONObject, npVar);
                return false;
            }
            if (type != 7) {
                return false;
            }
        }
        if (z10) {
            com.ss.android.downloadlib.l.m.m().m(npVar.f38586m, i10);
        }
        return true;
    }

    public static void m(Context context, String str, long j10, boolean z10) {
        JSONObject jSONObject = new JSONObject();
        com.ss.android.downloadlib.addownload.dk.np np = com.ss.android.downloadlib.addownload.dk.n.m().np(j10);
        try {
            JSONObject w3 = com.ss.android.downloadlib.addownload.c.w();
            String optString = w3.optString(t.f36222g);
            String m10 = com.ss.android.socialbase.appdownloader.n.ej.m(w3.optString("aa"), optString);
            String m11 = com.ss.android.socialbase.appdownloader.n.ej.m(w3.optString("ac"), optString);
            String m12 = com.ss.android.socialbase.appdownloader.n.ej.m(w3.optString("af"), optString);
            boolean m13 = com.ss.android.socialbase.appdownloader.n.m.m(w3, context, m11);
            StringBuilder sb2 = new StringBuilder(String.format(m10, str, m12, m11));
            Intent intent = new Intent("android.intent.action.VIEW");
            String oa2 = com.ss.android.socialbase.appdownloader.n.np.oa();
            if (ve.np(context, oa2)) {
                intent.setPackage(oa2);
            }
            if (z10) {
                sb2.append(com.ss.android.socialbase.appdownloader.n.ej.m(w3.optString("ae"), optString));
            } else {
                intent.addFlags(335544320);
            }
            ve.m(jSONObject, "mf", Boolean.valueOf(m13));
            ve.m(jSONObject, "if", Boolean.valueOf(z10));
            intent.setData(Uri.parse(sb2.toString()));
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            com.ss.android.downloadlib.dk.m.m("am_kllk2", jSONObject, np, true);
            if (m13) {
                dk(np, jSONObject, -1, 3, sb2.toString());
            } else {
                dk(np, jSONObject, 3, 3, sb2.toString());
            }
        } catch (Exception unused) {
            com.ss.android.downloadlib.dk.m.m(m(com.ss.android.downloadlib.addownload.c.getContext(), Uri.parse("market://details?id=" + str)), np, true);
            dk(np, jSONObject, 2, 3, "market://details?id=" + str);
        }
    }

    public static void m(final Context context, String str, long j10, String str2, boolean z10) {
        JSONObject jSONObject = new JSONObject();
        com.ss.android.downloadlib.addownload.dk.np np = com.ss.android.downloadlib.addownload.dk.n.m().np(j10);
        try {
            JSONObject w3 = com.ss.android.downloadlib.addownload.c.w();
            String optString = w3.optString(t.f36222g);
            String m10 = com.ss.android.socialbase.appdownloader.n.ej.m(w3.optString("br"), optString);
            String m11 = com.ss.android.socialbase.appdownloader.n.ej.m(w3.optString("bs_1"), optString);
            String m12 = com.ss.android.socialbase.appdownloader.n.ej.m(w3.optString("bs_2"), optString);
            String m13 = com.ss.android.socialbase.appdownloader.n.ej.m(w3.optString("bs_3"), optString);
            String m14 = com.ss.android.socialbase.appdownloader.n.ej.m(w3.optString("bt"), optString);
            String m15 = com.ss.android.socialbase.appdownloader.n.ej.m(w3.optString("bu"), optString);
            StringBuilder sb2 = new StringBuilder(String.format("https://", new Object[0]));
            sb2.append(m10);
            sb2.append(m11);
            sb2.append(m12);
            sb2.append(m13);
            sb2.append(m14);
            sb2.append(m15);
            final Intent intent = new Intent("android.intent.action.VIEW");
            intent.setPackage(str2);
            if (z10) {
                sb2.append("pkg=" + str);
                sb2.append("&dl=true");
            } else {
                intent.addFlags(335544320);
            }
            ve.m(jSONObject, "dl", Boolean.valueOf(z10));
            intent.setData(Uri.parse(sb2.toString()));
            intent.putExtra("start_only_for_android", true);
            long optLong = com.ss.android.downloadlib.addownload.c.w().optLong("oppo_browser_jump_delay", 1000L);
            if (optLong > 0) {
                com.ss.android.downloadlib.hc.m().dk().post(new Runnable() { // from class: com.ss.android.downloadlib.hc.e.3
                    @Override // java.lang.Runnable
                    public void run() {
                        com.ss.android.downloadlib.addownload.c.ej().m(12, com.ss.android.downloadlib.addownload.c.getContext(), null, "正在前往浏览器下载", null, 0);
                    }
                });
            }
            com.ss.android.downloadlib.l.m().m(new Runnable() { // from class: com.ss.android.downloadlib.hc.e.4
                @Override // java.lang.Runnable
                public void run() {
                    context.startActivity(intent);
                }
            }, optLong);
            com.ss.android.downloadad.api.m.dk dkVar = np.np;
            if (dkVar != null) {
                dkVar.li(true);
            }
            com.ss.android.downloadlib.dk.m.m("am_kllk3", jSONObject, np, true);
            dk(np, jSONObject, -1, 7, sb2.toString());
        } catch (Exception unused) {
            com.ss.android.downloadad.api.m.dk dkVar2 = np.np;
            if (dkVar2 != null) {
                dkVar2.li(false);
            }
            com.ss.android.downloadlib.dk.m.m(m(com.ss.android.downloadlib.addownload.c.getContext(), Uri.parse("market://details?id=" + str), np), np, true);
            dk(np, jSONObject, 2, 7, "market://details?id=" + str);
        }
    }

    private static boolean m(@NonNull Activity activity, @NonNull String str, @NonNull HashMap<String, String> hashMap) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("market://details?id=" + str));
        intent.putExtra("start_only_for_android", true);
        intent.putExtra("param", hashMap);
        String oa2 = com.ss.android.socialbase.appdownloader.n.np.oa();
        if (ve.np(com.ss.android.downloadlib.addownload.c.getContext(), oa2)) {
            intent.setPackage(oa2);
        }
        if (!ve.m(com.ss.android.downloadlib.addownload.c.getContext(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e2) {
            com.ss.android.downloadlib.np.ej.m().m(e2, "start v1");
            return false;
        }
    }

    public static void m(@NonNull Activity activity, String str, long j10, String str2, String str3) {
        JSONObject jSONObject;
        int i10;
        try {
            jSONObject = new JSONObject(str3);
        } catch (JSONException unused) {
            jSONObject = new JSONObject();
        }
        com.ss.android.downloadlib.addownload.dk.np np = com.ss.android.downloadlib.addownload.dk.n.m().np(j10);
        try {
            JSONObject w3 = com.ss.android.downloadlib.addownload.c.w();
            boolean m10 = com.ss.android.socialbase.appdownloader.n.m.m(w3, activity, com.ss.android.socialbase.appdownloader.n.ej.m(w3.optString("bg"), w3.optString(t.f36222g)));
            HashMap<String, String> dk = ve.dk(new JSONObject(str2));
            if (m10 && !dk.isEmpty() && m(activity, str, dk)) {
                dk(np, jSONObject, -1, 5, "market://details?id=" + str);
                com.ss.android.downloadlib.dk.m.m("am_v1", jSONObject, np, true);
                return;
            }
            if (m10) {
                i10 = dk.isEmpty() ? 1 : 2;
            } else {
                i10 = 3;
            }
            dk(np, jSONObject, i10, 5, "market://details?id=" + str);
            com.ss.android.downloadlib.dk.m.m(m((Context) activity, Uri.parse("market://details?id=" + str)), np, true);
        } catch (Exception unused2) {
            com.ss.android.downloadlib.dk.m.m(m(com.ss.android.downloadlib.addownload.c.getContext(), Uri.parse("market://details?id=" + str)), np, true);
            dk(np, jSONObject, 4, 5, "market://details?id=" + str);
        }
    }

    public static void m(@NonNull Activity activity, String str, long j10, String str2) {
        com.ss.android.downloadlib.addownload.dk.np np = com.ss.android.downloadlib.addownload.dk.n.m().np(j10);
        JSONObject jSONObject = new JSONObject();
        JSONObject w3 = com.ss.android.downloadlib.addownload.c.w();
        String m10 = com.ss.android.socialbase.appdownloader.n.ej.m(w3.optString("bv"), w3.optString(t.f36222g));
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("market").authority("details").appendQueryParameter("id", str);
        if (!TextUtils.isEmpty(m10)) {
            builder.appendQueryParameter(m10, str2);
        }
        if (m(activity, builder.build())) {
            dk(np, jSONObject, -1, 8, "market://details?id=" + str);
            com.ss.android.downloadlib.dk.m.m("am_v2", jSONObject, np, true);
            return;
        }
        dk(np, jSONObject, 2, 8, "market://details?id=" + str);
        com.ss.android.downloadlib.dk.m.m(m((Context) activity, Uri.parse("market://details?id=" + str)), np, true);
    }

    public static boolean m(@NonNull Activity activity, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra("start_only_for_android", true);
        String oa2 = com.ss.android.socialbase.appdownloader.n.np.oa();
        if (ve.np(com.ss.android.downloadlib.addownload.c.getContext(), oa2)) {
            intent.setPackage(oa2);
        }
        if (!ve.m(com.ss.android.downloadlib.addownload.c.getContext(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e2) {
            com.ss.android.downloadlib.np.ej.m().m(e2, "start v2");
            return false;
        }
    }

    public static com.ss.android.downloadlib.addownload.dk.hc m(Context context, String str, com.ss.android.downloadad.api.m.m mVar) {
        Intent hc2 = ve.hc(context, str);
        if (hc2 == null) {
            return new com.ss.android.downloadlib.addownload.dk.hc(4, 22);
        }
        if (Build.VERSION.SDK_INT >= 26 && com.ss.android.downloadlib.addownload.c.w().optInt("open_package_mode") == 1 && com.ss.android.downloadlib.addownload.c.ve() != null && com.ss.android.downloadlib.addownload.c.ve().m() && mVar.t()) {
            TTDelegateActivity.dk(str, mVar);
            return new com.ss.android.downloadlib.addownload.dk.hc(3);
        }
        hc2.putExtra("start_only_for_android", true);
        try {
            context.startActivity(hc2);
            return new com.ss.android.downloadlib.addownload.dk.hc(3);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.dk.hc(4, 23);
        }
    }

    public static com.ss.android.downloadlib.addownload.dk.hc m(String str, com.ss.android.downloadad.api.m.m mVar) {
        return m(com.ss.android.downloadlib.addownload.c.getContext(), str, mVar);
    }

    public static com.ss.android.downloadlib.addownload.dk.hc m(@NonNull com.ss.android.downloadad.api.m.dk dkVar, String str, String str2) {
        com.ss.android.downloadlib.addownload.dk.hc dk = dk(str, dkVar);
        return (com.ss.android.downloadlib.dk.n.m(dkVar) && dk.getType() == 2) ? m(str2, dkVar) : dk;
    }

    public static void m(@NonNull Activity activity, String str, long j10) {
        com.ss.android.downloadlib.addownload.dk.np np = com.ss.android.downloadlib.addownload.dk.n.m().np(j10);
        JSONObject jSONObject = new JSONObject();
        JSONObject w3 = com.ss.android.downloadlib.addownload.c.w();
        String optString = w3.optString(t.f36222g);
        String m10 = com.ss.android.socialbase.appdownloader.n.ej.m(w3.optString("ca"), optString);
        String m11 = com.ss.android.socialbase.appdownloader.n.ej.m(w3.optString("cc"), optString);
        StringBuilder sb2 = new StringBuilder("market://details?id=");
        if (!TextUtils.isEmpty(m10) && !TextUtils.isEmpty(m11)) {
            sb2.append(str);
            sb2.append("&");
            sb2.append(m10);
            sb2.append("=");
            sb2.append(m11);
        }
        if (ej(activity, Uri.parse(sb2.toString()))) {
            dk(np, jSONObject, -1, 10, "market://details?id=" + str);
            com.ss.android.downloadlib.dk.m.m("am_hr2", jSONObject, np, true);
            return;
        }
        dk(np, jSONObject, 2, 10, "market://details?id=" + str);
        com.ss.android.downloadlib.dk.m.m(m((Context) activity, Uri.parse("market://details?id=" + str)), np, true);
    }
}
