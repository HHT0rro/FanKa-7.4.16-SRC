package com.tencent.open.utils;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, g> f45297a = Collections.synchronizedMap(new HashMap());

    /* renamed from: b, reason: collision with root package name */
    private static String f45298b = null;

    /* renamed from: c, reason: collision with root package name */
    private Context f45299c;

    /* renamed from: d, reason: collision with root package name */
    private String f45300d;

    /* renamed from: e, reason: collision with root package name */
    private JSONObject f45301e = null;

    /* renamed from: f, reason: collision with root package name */
    private long f45302f = 0;

    /* renamed from: g, reason: collision with root package name */
    private int f45303g = 0;

    /* renamed from: h, reason: collision with root package name */
    private boolean f45304h = true;

    private g(Context context, String str) {
        this.f45299c = null;
        this.f45300d = null;
        this.f45299c = context.getApplicationContext();
        this.f45300d = str;
        a();
        b();
    }

    private void b() {
        if (this.f45303g != 0) {
            d("update thread is running, return");
            return;
        }
        this.f45303g = 1;
        final Bundle bundle = new Bundle();
        bundle.putString("appid", this.f45300d);
        bundle.putString("appid_for_getting_config", this.f45300d);
        bundle.putString("status_os", Build.VERSION.RELEASE);
        bundle.putString("status_machine", Build.MODEL);
        bundle.putString("status_version", Build.VERSION.SDK);
        bundle.putString("sdkv", Constants.SDK_VERSION);
        bundle.putString("sdkp", "a");
        new Thread() { // from class: com.tencent.open.utils.g.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    g.this.a(l.d(HttpUtils.openUrl2(g.this.f45299c, "https://cgi.connect.qq.com/qqconnectopen/openapi/policy_conf", "GET", bundle).f45327a));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                g.this.f45303g = 0;
            }
        }.start();
    }

    private String c(String str) {
        InputStream open;
        String str2;
        String str3 = "";
        try {
            try {
                if (this.f45300d != null) {
                    str2 = str + "." + this.f45300d;
                } else {
                    str2 = str;
                }
                open = this.f45299c.openFileInput(str2);
            } catch (FileNotFoundException unused) {
                open = this.f45299c.getAssets().open(str);
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open, Charset.forName("UTF-8")));
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                try {
                    try {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(readLine);
                        } catch (Throwable th) {
                            try {
                                open.close();
                                bufferedReader.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            throw th;
                        }
                    } catch (IOException e10) {
                        e10.printStackTrace();
                        open.close();
                        bufferedReader.close();
                    }
                } catch (IOException e11) {
                    e11.printStackTrace();
                }
            }
            str3 = stringBuffer.toString();
            open.close();
            bufferedReader.close();
            return str3;
        } catch (IOException e12) {
            e12.printStackTrace();
            return "";
        }
    }

    private void d(String str) {
        if (this.f45304h) {
            SLog.v("openSDK_LOG.OpenConfig", str + "; appid: " + this.f45300d);
        }
    }

    public static g a(Context context, String str) {
        g gVar;
        synchronized (f45297a) {
            SLog.v("openSDK_LOG.OpenConfig", "getInstance begin");
            if (str != null) {
                f45298b = str;
            }
            if (str == null && (str = f45298b) == null) {
                str = "0";
            }
            gVar = f45297a.get(str);
            if (gVar == null) {
                gVar = new g(context, str);
                f45297a.put(str, gVar);
            }
            SLog.v("openSDK_LOG.OpenConfig", "getInstance end");
        }
        return gVar;
    }

    private void a() {
        try {
            this.f45301e = new JSONObject(c("com.tencent.open.config.json"));
        } catch (JSONException unused) {
            this.f45301e = new JSONObject();
        }
    }

    public boolean b(String str) {
        d("get " + str);
        c();
        Object opt = this.f45301e.opt(str);
        if (opt == null) {
            return false;
        }
        if (opt instanceof Integer) {
            return !opt.equals(0);
        }
        if (opt instanceof Boolean) {
            return ((Boolean) opt).booleanValue();
        }
        return false;
    }

    private void a(String str, String str2) {
        try {
            if (this.f45300d != null) {
                str = str + "." + this.f45300d;
            }
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.f45299c.openFileOutput(str, 0), Charset.forName("UTF-8"));
            outputStreamWriter.write(str2);
            outputStreamWriter.flush();
            outputStreamWriter.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void c() {
        int optInt = this.f45301e.optInt("Common_frequency");
        if (optInt == 0) {
            optInt = 1;
        }
        if (SystemClock.elapsedRealtime() - this.f45302f >= optInt * 3600000) {
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        d("cgi back, do update");
        this.f45301e = jSONObject;
        a("com.tencent.open.config.json", jSONObject.toString());
        this.f45302f = SystemClock.elapsedRealtime();
    }

    public int a(String str) {
        d("get " + str);
        c();
        return this.f45301e.optInt(str);
    }
}
