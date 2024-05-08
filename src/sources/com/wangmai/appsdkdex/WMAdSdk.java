package com.wangmai.appsdkdex;

import ad.b;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import com.wangmai.common.bean.AppConfigRespBean;
import com.wangmai.common.bean.SdkTrackEventBean;
import com.wangmai.common.bean.SdkTrackEventBeans;
import com.wangmai.common.utils.AesUtil;
import com.wangmai.common.utils.AppConfigUtil;
import com.wangmai.common.utils.ConstantInfo;
import com.wangmai.common.utils.DebugLog;
import com.wangmai.common.utils.GZIPUtils;
import com.wangmai.common.utils.GsonUtils;
import com.wangmai.common.utils.SDKTrackUtils;
import com.wangmai.common.utils.SharedPreferencesHelper;
import com.wangmai.common.utils.Utils;
import com.wangmai.okhttp.OkHttp;
import com.wangmai.okhttp.callback.ByteCallback;
import com.wangmai.okhttp.callback.FileCallback;
import com.wangmai.okhttp.callback.StringCallback;
import com.wangmai.okhttp.model.HttpHeaders;
import com.wangmai.okhttp.model.Response;
import com.wangmai.okhttp.request.PostRequest;
import com.wangmai.okhttp.utils.ThreadUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WMAdSdk {

    /* renamed from: i, reason: collision with root package name */
    public static final String f46886i = zc.b.a("XNBeTel");

    /* renamed from: j, reason: collision with root package name */
    public static boolean f46887j = false;

    /* renamed from: k, reason: collision with root package name */
    public static boolean f46888k = false;

    /* renamed from: l, reason: collision with root package name */
    public static String f46889l;

    /* renamed from: m, reason: collision with root package name */
    public static String f46890m;

    /* renamed from: n, reason: collision with root package name */
    public static String f46891n;

    /* renamed from: a, reason: collision with root package name */
    public Context f46892a;

    /* renamed from: b, reason: collision with root package name */
    public String f46893b;

    /* renamed from: c, reason: collision with root package name */
    public String f46894c;

    /* renamed from: d, reason: collision with root package name */
    public String f46895d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f46896e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f46897f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f46898g;

    /* renamed from: h, reason: collision with root package name */
    public WMCustomPrivateController f46899h;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class Builder {
        public String dexa;

        /* renamed from: dexb, reason: collision with root package name */
        public String f46900dexb;
        public String dexc;
        public boolean dexe;
        public String dexg;
        public WMCustomPrivateController dexh;
        public boolean dexd = true;
        public boolean dexf = true;

        public WMAdSdk build(Context context) {
            return new WMAdSdk(context, this, null);
        }

        public Builder debug(boolean z10) {
            this.dexe = z10;
            return this;
        }

        public Builder enableCrashIntercept(boolean z10) {
            this.dexd = z10;
            return this;
        }

        public Builder enablePersonalized(boolean z10) {
            this.dexf = z10;
            return this;
        }

        public Builder setLocalConfigFileName(String str) {
            this.dexg = str;
            return this;
        }

        public Builder setPrivateController(WMCustomPrivateController wMCustomPrivateController) {
            this.dexh = wMCustomPrivateController;
            return this;
        }

        public Builder setToken(String str) {
            this.dexa = str;
            return this;
        }

        public Builder setWXAppId(String str) {
            this.dexc = str;
            return this;
        }

        public Builder setkey(String str) {
            this.f46900dexb = str;
            return this;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f46901b;

        /* renamed from: com.wangmai.appsdkdex.WMAdSdk$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
        public class C0696a implements b.InterfaceC0011b {
            public C0696a() {
            }

            @Override // ad.b.InterfaceC0011b
            public void a() {
                AppConfigRespBean appConfigRespBean;
                try {
                    String preferencesString = SharedPreferencesHelper.getInstance(a.this.f46901b).getPreferencesString(ConstantInfo.SP_KEY_APP_CONFIG);
                    if (!TextUtils.isEmpty(preferencesString)) {
                        AppConfigRespBean appConfigRespBean2 = (AppConfigRespBean) GsonUtils.getInstance().fromJson(preferencesString, AppConfigRespBean.class);
                        WMAdSdk.f46890m = appConfigRespBean2.getRealmName();
                        WMAdSdk.f46891n = appConfigRespBean2.getTrackHost();
                    } else {
                        String h10 = WMAdSdk.h(a.this.f46901b, WMAdSdk.f46889l);
                        if (!TextUtils.isEmpty(h10) && (appConfigRespBean = (AppConfigRespBean) GsonUtils.getInstance().fromJson(h10, AppConfigRespBean.class)) != null) {
                            WMAdSdk.f46890m = appConfigRespBean.getRealmName();
                            WMAdSdk.f46891n = appConfigRespBean.getTrackHost();
                            AppConfigUtil.getInstance().saveAppConfig(a.this.f46901b, h10);
                        }
                    }
                    WMAdSdk.t(a.this.f46901b);
                } catch (Throwable th) {
                    DebugLog.release_e(zc.b.a("XNBeTel"), zc.b.a("joju!dpogjh!fssps;") + th.toString());
                }
            }

            @Override // ad.b.InterfaceC0011b
            public void onSuccess() {
                WMAdSdk.t(a.this.f46901b);
            }
        }

        public a(Context context) {
            this.f46901b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            System.currentTimeMillis();
            if (TextUtils.isEmpty(WMAdSdk.f46890m)) {
                WMAdSdk.f46890m = zc.b.a("iuuqt;00tel/npcbet/bexbohnbj/dpn0");
            }
            ad.b.a().b(this.f46901b, WMAdSdk.f46890m, new C0696a());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ConcurrentHashMap f46903b;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
        public class a extends ByteCallback {
            public a() {
            }

            @Override // com.wangmai.okhttp.callback.AbsCallback, com.wangmai.okhttp.callback.Callback
            public void onError(Response<byte[]> response) {
                super.onError(response);
                DebugLog.W(zc.b.a("XNBeTel"), zc.b.a("usbdl!sftq!gbjmfe;") + response.getException().toString());
            }

            @Override // com.wangmai.okhttp.callback.Callback
            public void onSuccess(Response<byte[]> response) {
                try {
                    GZIPUtils.unZipStringToByte(AesUtil.decryptToByte(response.body(), ConstantInfo.getAppToken()));
                } catch (Throwable th) {
                    DebugLog.W(zc.b.a("XNBeTel"), zc.b.a("usbdl!sftq!fssps;") + th.toString());
                }
            }
        }

        public b(ConcurrentHashMap concurrentHashMap) {
            this.f46903b = concurrentHashMap;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.isEmpty(WMAdSdk.f46891n)) {
                WMAdSdk.f46891n = zc.b.a("iuuqt;00tel/npcbet/bexbohnbj/dpn0");
            }
            ArrayList arrayList = new ArrayList();
            long currentTimeMillis = System.currentTimeMillis();
            for (SdkTrackEventBean sdkTrackEventBean : this.f46903b.values()) {
                sdkTrackEventBean.setRequest_time(currentTimeMillis);
                arrayList.add(sdkTrackEventBean);
            }
            SdkTrackEventBeans sdkTrackEventBeans = new SdkTrackEventBeans();
            sdkTrackEventBeans.setSdk_track_event(arrayList);
            ((PostRequest) ((PostRequest) OkHttp.post(WMAdSdk.f46891n + zc.b.a("tel0usbdlfwfou/bqj")).headers(zc.b.a("Dpoufou.Uzqf"), zc.b.a("bqqmjdbujpo0ktpo"))).upBytes(AesUtil.encryptByt(GZIPUtils.compress(GsonUtils.getInstance().toJson(sdkTrackEventBeans), zc.b.a("vug.9")), ConstantInfo.getAppToken())).retryCount(2)).execute(new a());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f46905b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f46906c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f46907d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Context f46908e;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
        public class a extends StringCallback {
            public a() {
            }

            @Override // com.wangmai.okhttp.callback.AbsCallback, com.wangmai.okhttp.callback.Callback
            public void onError(Response<String> response) {
                DebugLog.release_e(zc.b.a("XNBeTel"), zc.b.a("difdl!wfstjpo!poFssps;") + response.getException().toString());
            }

            @Override // com.wangmai.okhttp.callback.Callback
            public void onSuccess(Response<String> response) {
                if (response.isSuccessful()) {
                    try {
                        String body = response.body();
                        if (!TextUtils.isEmpty(body)) {
                            JSONObject jSONObject = new JSONObject(body);
                            if (jSONObject.getInt(zc.b.a("sfu")) == 0) {
                                String string = jSONObject.getString(zc.b.a("wfstjpo"));
                                String string2 = jSONObject.getString(zc.b.a("epxompbeVsm"));
                                long j10 = jSONObject.getLong(zc.b.a("difdlTvn"));
                                if (!TextUtils.isEmpty(string)) {
                                    if (WMAdSdk.n(string, c.this.f46907d)) {
                                        WMAdSdk.k(c.this.f46908e, string2, j10);
                                    } else {
                                        DebugLog.release_d(zc.b.a("XNBeTel"), zc.b.a("op!vqebuf"));
                                    }
                                }
                            } else {
                                DebugLog.release_d(zc.b.a("XNBeTel"), zc.b.a("op!ebub"));
                            }
                        }
                        return;
                    } catch (Throwable th) {
                        DebugLog.release_e(zc.b.a("XNBeTel"), zc.b.a("difdl!wfstjpo!fssps;") + th.toString());
                        return;
                    }
                }
                DebugLog.release_e(zc.b.a("XNBeTel"), zc.b.a("difdl!wfstjpo!gbjmfe;") + response.toString());
            }
        }

        public c(String str, String str2, String str3, Context context) {
            this.f46905b = str;
            this.f46906c = str2;
            this.f46907d = str3;
            this.f46908e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            OkHttp.get(Uri.parse(zc.b.a("iuuqt;00tel/npcbet/bexbohnbj/dpn0tel0hfuBqlJogp")).buildUpon().appendQueryParameter(zc.b.a("telWfstjpo"), zc.b.a("7/7/1")).appendQueryParameter(zc.b.a("bqlWfstjpo"), this.f46907d).appendQueryParameter(zc.b.a("uplfo"), this.f46906c).appendQueryParameter(zc.b.a("tjho"), Utils.md5Decode(this.f46905b + this.f46906c)).build().toString()).execute(new a());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class d extends FileCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f46910a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f46911b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, String str2, long j10, String str3) {
            super(str, str2);
            this.f46910a = j10;
            this.f46911b = str3;
        }

        @Override // com.wangmai.okhttp.callback.AbsCallback, com.wangmai.okhttp.callback.Callback
        public void onError(Response<File> response) {
            DebugLog.release_e(zc.b.a("XNBeTel"), zc.b.a("vqebuf!poFssps;") + response.getException().toString());
        }

        @Override // com.wangmai.okhttp.callback.Callback
        public void onSuccess(Response<File> response) {
            File body = response.body();
            if (!WMAdSdk.m(body.getAbsolutePath(), this.f46910a)) {
                body.delete();
                return;
            }
            File file = new File(this.f46911b, zc.b.a("xnefw`7/7/1"));
            if (file.exists()) {
                file.delete();
            }
            body.renameTo(file);
            zc.a.b();
        }
    }

    public /* synthetic */ WMAdSdk(Context context, Builder builder, a aVar) {
        this(context, builder);
    }

    public static void e(Context context, String str, String str2) {
        String o10 = o(context);
        if (TextUtils.isEmpty(o10)) {
            return;
        }
        ThreadUtils.runOnThreadPool(new c(str2, str, o10, context));
    }

    public static String getSdkVersion() {
        return zc.b.a("7/7/1");
    }

    public static String h(Context context, String str) {
        String str2;
        String string;
        if (TextUtils.isEmpty(str)) {
            DebugLog.W(f46886i, zc.b.a("mpdbm!dpogjh!opu!fyjtu"));
            return null;
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(str)));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb2.append(readLine);
            }
            string = new JSONObject(sb2.toString()).getString(zc.b.a("nfttbhf"));
        } catch (Throwable th) {
            str2 = zc.b.a("\\") + str + zc.b.a("^") + zc.b.a("ꆎ辯痈強鰼搗楲鵦�鰸礁砦bttfut蜯澖幌ꆎ辯痈強癰摧殙杩") + zc.b.a("-fssps>") + th;
        }
        if (!TextUtils.isEmpty(string)) {
            return AesUtil.decrypt(string, ConstantInfo.getAppToken());
        }
        str2 = zc.b.a("\\") + str + zc.b.a("^") + zc.b.a("ꆎ辯痈強瘡疉");
        DebugLog.release_w(f46886i, str2);
        return null;
    }

    public static void j(Context context) {
        ThreadUtils.runOnThreadPool(new a(context));
    }

    public static void k(Context context, String str, long j10) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String b4 = ad.a.b(context);
            OkHttp.get(str).execute(new d(b4, zc.b.a("xnefwmpbe`7/7/1"), j10, b4));
        } catch (Throwable th) {
            DebugLog.release_e(f46886i, zc.b.a("vqebuf!fssps;") + th.toString());
        }
    }

    public static boolean l(Context context, String str, String str2) {
        if (context == null) {
            DebugLog.release_e(f46886i, zc.b.a("Dpoufyu!jt!ovmm-!Qmfbtf!difdl!XNBeTel/Cvjmefs)*/cvjme)dpoufyu*!gvodujpo!xifuifs!ps!opu!up!tfu\""));
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            DebugLog.release_e(f46886i, zc.b.a("Uplfo!jt!ovmm-!qmfbtf!difdl!XNBeTel/Cvjmefs)*/tfuUplfo)uplfo*!gvodujpo!xifuifs!ps!opu!up!tfu\""));
            return false;
        }
        if (!TextUtils.isEmpty(str2)) {
            return true;
        }
        DebugLog.release_e(f46886i, zc.b.a("Lfz!jt!ovmm-!qmfbtf!difdl!XNBeTel/Cvjmefs)*/tfuLfz)lfz*!gvodujpo!xifuifs!ps!opu!up!tfu\""));
        return false;
    }

    public static boolean m(String str, long j10) {
        CheckedInputStream checkedInputStream;
        FileInputStream fileInputStream;
        CRC32 crc32;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                crc32 = new CRC32();
                checkedInputStream = new CheckedInputStream(fileInputStream, crc32);
            } catch (Throwable th) {
                th = th;
                checkedInputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
            checkedInputStream = null;
        }
        try {
            do {
            } while (checkedInputStream.read(new byte[8192]) != -1);
        } catch (Throwable th3) {
            th = th3;
            fileInputStream2 = fileInputStream;
            try {
                DebugLog.release_e(f46886i, zc.b.a("Difdl!Gjmf!Fydfqujpo;") + th.toString());
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused) {
                    }
                }
                if (checkedInputStream == null) {
                    return false;
                }
                try {
                    checkedInputStream.close();
                    return false;
                } catch (IOException unused2) {
                    return false;
                }
            } finally {
            }
        }
        if (crc32.getValue() == j10) {
            try {
                fileInputStream.close();
            } catch (IOException unused3) {
            }
            try {
                checkedInputStream.close();
            } catch (IOException unused4) {
            }
            return true;
        }
        try {
            fileInputStream.close();
        } catch (IOException unused5) {
        }
        checkedInputStream.close();
        return false;
    }

    public static boolean n(String str, String str2) {
        return ad.a.d(str) > ad.a.d(str2);
    }

    public static String o(Context context) {
        try {
            PackageInfo a10 = ad.a.a(context, new File(ad.a.b(context), zc.b.a("xnefwdbm`7/7/1")).getAbsolutePath());
            File file = new File(ad.a.b(context), zc.b.a("xnefw`7/7/1"));
            PackageInfo a11 = file.exists() ? ad.a.a(context, file.getAbsolutePath()) : null;
            if (a11 == null) {
                return a10.versionName;
            }
            return ad.a.c(a10.versionName, a11.versionName);
        } catch (Throwable unused) {
            DebugLog.W(f46886i, zc.b.a("jowbmje!wfstjpoObnf"));
            return "";
        }
    }

    public static boolean p() {
        return f46887j;
    }

    public static String q(Context context) {
        String str;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(zc.b.a("bdujwjuz"))).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == Process.myPid() && (str = runningAppProcessInfo.processName) != null) {
                return str;
            }
        }
        return null;
    }

    public static boolean s(Context context) {
        String q10 = q(context);
        if (context.getPackageName().equals(q10)) {
            return true;
        }
        DebugLog.release_e(f46886i, zc.b.a("TEL盃幎異獂杩殑���詌幮扞樌捗!") + q10);
        return false;
    }

    public static void t(Context context) {
        System.currentTimeMillis();
        ConcurrentHashMap<String, SdkTrackEventBean> sdkTrackReportBeanMap = SDKTrackUtils.getInstance().getSdkTrackReportBeanMap(context);
        if (sdkTrackReportBeanMap == null || sdkTrackReportBeanMap.isEmpty()) {
            return;
        }
        SDKTrackUtils.getInstance().cleanSdkTrackReportBean(context);
        ThreadUtils.runOnThreadPool(new b(sdkTrackReportBeanMap));
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x008f, code lost:
    
        if (r2 != null) goto L63;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void u(android.content.Context r7) {
        /*
            java.lang.Class<com.wangmai.appsdkdex.WMAdSdk> r0 = com.wangmai.appsdkdex.WMAdSdk.class
            monitor-enter(r0)
            boolean r1 = com.wangmai.appsdkdex.WMAdSdk.f46888k     // Catch: java.lang.Throwable -> Lb0
            if (r1 != 0) goto La3
            r1 = 0
            java.lang.String r2 = ad.a.b(r7)     // Catch: java.lang.Throwable -> L64
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L64
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L64
            boolean r4 = r3.exists()     // Catch: java.lang.Throwable -> L64
            if (r4 != 0) goto L1a
            r3.mkdirs()     // Catch: java.lang.Throwable -> L64
        L1a:
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L64
            java.lang.String r4 = "xnefwdbm`7/7/1"
            java.lang.String r4 = zc.b.a(r4)     // Catch: java.lang.Throwable -> L64
            r3.<init>(r2, r4)     // Catch: java.lang.Throwable -> L64
            android.content.res.AssetManager r7 = r7.getAssets()     // Catch: java.lang.Throwable -> L64
            java.lang.String r2 = "7171151311"
            java.lang.String r2 = zc.b.a(r2)     // Catch: java.lang.Throwable -> L64
            java.io.InputStream r7 = r7.open(r2)     // Catch: java.lang.Throwable -> L64
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L5f
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L5f
            r1 = 8192(0x2000, float:1.14794E-41)
            byte[] r1 = new byte[r1]     // Catch: java.lang.Throwable -> L5d
        L3c:
            int r3 = r7.read(r1)     // Catch: java.lang.Throwable -> L5d
            r4 = -1
            if (r3 == r4) goto L4b
            r4 = 0
            r2.write(r1, r4, r3)     // Catch: java.lang.Throwable -> L5d
            r2.flush()     // Catch: java.lang.Throwable -> L5d
            goto L3c
        L4b:
            r1 = 1
            com.wangmai.appsdkdex.WMAdSdk.f46888k = r1     // Catch: java.lang.Throwable -> L5d
            java.lang.String r1 = com.wangmai.appsdkdex.WMAdSdk.f46886i     // Catch: java.lang.Throwable -> L5d
            java.lang.String r3 = "fyqpsu!dpnqmfufe"
            java.lang.String r3 = zc.b.a(r3)     // Catch: java.lang.Throwable -> L5d
            com.wangmai.common.utils.DebugLog.D(r1, r3)     // Catch: java.lang.Throwable -> L5d
            r7.close()     // Catch: java.io.IOException -> L91 java.lang.Throwable -> Lb0
            goto L91
        L5d:
            r1 = move-exception
            goto L6a
        L5f:
            r2 = move-exception
            r6 = r2
            r2 = r7
            r7 = r6
            goto L66
        L64:
            r7 = move-exception
            r2 = r1
        L66:
            r6 = r1
            r1 = r7
            r7 = r2
            r2 = r6
        L6a:
            java.lang.String r3 = com.wangmai.appsdkdex.WMAdSdk.f46886i     // Catch: java.lang.Throwable -> L95
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L95
            r4.<init>()     // Catch: java.lang.Throwable -> L95
            java.lang.String r5 = "fyqpsu!fssps;"
            java.lang.String r5 = zc.b.a(r5)     // Catch: java.lang.Throwable -> L95
            r4.append(r5)     // Catch: java.lang.Throwable -> L95
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L95
            r4.append(r1)     // Catch: java.lang.Throwable -> L95
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L95
            com.wangmai.common.utils.DebugLog.release_e(r3, r1)     // Catch: java.lang.Throwable -> L95
            if (r7 == 0) goto L8f
            r7.close()     // Catch: java.io.IOException -> L8e java.lang.Throwable -> Lb0
            goto L8f
        L8e:
        L8f:
            if (r2 == 0) goto Lae
        L91:
            r2.close()     // Catch: java.io.IOException -> Lae java.lang.Throwable -> Lb0
            goto Lae
        L95:
            r1 = move-exception
            if (r7 == 0) goto L9d
            r7.close()     // Catch: java.io.IOException -> L9c java.lang.Throwable -> Lb0
            goto L9d
        L9c:
        L9d:
            if (r2 == 0) goto La2
            r2.close()     // Catch: java.io.IOException -> La2 java.lang.Throwable -> Lb0
        La2:
            throw r1     // Catch: java.lang.Throwable -> Lb0
        La3:
            java.lang.String r7 = com.wangmai.appsdkdex.WMAdSdk.f46886i     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r1 = "gjmf!fyjtut"
            java.lang.String r1 = zc.b.a(r1)     // Catch: java.lang.Throwable -> Lb0
            com.wangmai.common.utils.DebugLog.release_d(r7, r1)     // Catch: java.lang.Throwable -> Lb0
        Lae:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb0
            return
        Lb0:
            r7 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb0
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wangmai.appsdkdex.WMAdSdk.u(android.content.Context):void");
    }

    public final void i() {
        try {
            ConstantInfo.deviceFingerprint = Utils.getFingerprint();
            ConstantInfo.bootMark = Utils.getBootMark();
            ConstantInfo.updateMark = Utils.getUpdateMark();
            String preferencesString = SharedPreferencesHelper.getInstance(this.f46892a).getPreferencesString(ConstantInfo.SP_KEY_WM_ID, "");
            if (TextUtils.isEmpty(preferencesString)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(AesUtil.md5Decode(ConstantInfo.deviceFingerprint));
                stringBuffer.append(zc.b.a("."));
                stringBuffer.append(AesUtil.md5Decode(ConstantInfo.bootMark));
                stringBuffer.append(zc.b.a("."));
                stringBuffer.append(AesUtil.md5Decode(ConstantInfo.updateMark));
                preferencesString = stringBuffer.toString();
                SharedPreferencesHelper.getInstance(this.f46892a).savePreferencesString(ConstantInfo.SP_KEY_WM_ID, preferencesString);
            }
            ConstantInfo.wmId = preferencesString;
        } catch (Throwable th) {
            DebugLog.release_w(f46886i, zc.b.a("joju!xnJe!fssps;") + th.toString());
        }
    }

    public void init() {
        try {
            if (l(this.f46892a, this.f46893b, this.f46894c)) {
                if (f46887j || !s(this.f46892a)) {
                    return;
                }
                String str = f46886i;
                DebugLog.release_d(str, zc.b.a("joju!") + Thread.currentThread().getName());
                long currentTimeMillis = System.currentTimeMillis();
                if (this.f46896e) {
                    bd.b.b(this.f46892a, zc.b.a("dpn/xbohnbj"), bd.b.f1482f);
                }
                i();
                ConstantInfo.setAppToken(this.f46893b);
                ConstantInfo.setAppKey(this.f46894c);
                ConstantInfo.setWxAppId(this.f46895d);
                ConstantInfo.setDebug(this.f46897f);
                ConstantInfo.setEnablePersonalized(this.f46898g);
                WMCustomPrivateController wMCustomPrivateController = this.f46899h;
                if (wMCustomPrivateController != null) {
                    ConstantInfo.setCanUseLocation(wMCustomPrivateController.isCanUseLocation());
                    ConstantInfo.setDevWMLocation(this.f46899h.getLocation());
                    ConstantInfo.setCanUsePhoneState(this.f46899h.isCanUsePhoneState());
                    ConstantInfo.setDevImei(this.f46899h.getDevImei());
                    ConstantInfo.setCanUseOaid(this.f46899h.isCanUseOaid());
                    ConstantInfo.setDevOaid(this.f46899h.getDevOaid());
                    ConstantInfo.setCanUseWifiState(this.f46899h.isCanUseWifiState());
                    ConstantInfo.setDevMacAddress(this.f46899h.getDevMacAddress());
                    ConstantInfo.setCanUseNetworkState(this.f46899h.isCanUseNetworkState());
                    ConstantInfo.setCanUseWriteExternal(this.f46899h.isCanUseWriteExternal());
                    ConstantInfo.setCanUseAppList(this.f46899h.isCanUseAppList());
                    ConstantInfo.setCanUsePermissionRecordAudio(this.f46899h.isCanUsePermissionRecordAudio());
                }
                r(this.f46892a);
                u(this.f46892a);
                ((Application) this.f46892a.getApplicationContext()).registerActivityLifecycleCallbacks(WMDexAdHelper.topActivityCallbacks);
                e(this.f46892a, this.f46893b, this.f46894c);
                f46887j = true;
                zc.a.f55051c.countDown();
                long currentTimeMillis2 = System.currentTimeMillis();
                ConstantInfo.sdkInitTime = currentTimeMillis2;
                ConstantInfo.sdkInitCostTime = currentTimeMillis2 - currentTimeMillis;
                DebugLog.D(str, zc.b.a("joju!tvddfttgvm!") + ConstantInfo.sdkInitCostTime);
                ConstantInfo.sdkTrackEventMap = new ConcurrentHashMap<>();
                return;
            }
            DebugLog.release_e(f46886i, zc.b.a("tel!joju!gbjmfe)轻汒搃疱*"));
        } catch (Throwable th) {
            DebugLog.release_e(f46886i, zc.b.a("tel!joju!gbjmfe�") + th.toString());
        }
    }

    public final void r(Context context) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.put(zc.b.a("Vtfs.BqqUplfo"), ConstantInfo.getAppToken());
        OkHttp.getInstance().init(context).addCommonHeaders(httpHeaders);
        j(context);
    }

    public WMAdSdk(Context context, Builder builder) {
        this.f46892a = context;
        this.f46893b = builder.dexa;
        this.f46894c = builder.f46900dexb;
        this.f46895d = builder.dexc;
        this.f46896e = builder.dexd;
        this.f46897f = builder.dexe;
        this.f46899h = builder.dexh;
        f46889l = builder.dexg;
        this.f46898g = builder.dexf;
    }
}
