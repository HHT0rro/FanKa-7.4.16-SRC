package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.internal.a.c;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class bg extends Observable {

    /* renamed from: a, reason: collision with root package name */
    private static final String f9871a = "b_f";

    /* renamed from: b, reason: collision with root package name */
    public static final String f9872b = "XAbstractProdTemplate";

    /* renamed from: c, reason: collision with root package name */
    public static final String f9873c = "error_message";

    /* renamed from: d, reason: collision with root package name */
    public static final String f9874d = "error_code";

    /* renamed from: e, reason: collision with root package name */
    public static final String f9875e = "instanceInfo";

    /* renamed from: f, reason: collision with root package name */
    public static final String f9876f = "showState";

    /* renamed from: g, reason: collision with root package name */
    public RelativeLayout f9877g;

    /* renamed from: h, reason: collision with root package name */
    public Context f9878h;

    /* renamed from: m, reason: collision with root package name */
    public HashMap<String, String> f9883m;

    /* renamed from: n, reason: collision with root package name */
    public String f9884n;

    /* renamed from: o, reason: collision with root package name */
    public String f9885o;

    /* renamed from: i, reason: collision with root package name */
    public bs f9879i = bs.a();

    /* renamed from: k, reason: collision with root package name */
    public IAdInterListener f9881k = null;

    /* renamed from: l, reason: collision with root package name */
    public boolean f9882l = true;

    /* renamed from: p, reason: collision with root package name */
    public int f9886p = -1;

    /* renamed from: j, reason: collision with root package name */
    public IOAdEventListener f9880j = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class a implements IOAdEventListener {
        public a() {
        }

        private String a(IOAdEvent iOAdEvent) {
            Map<String, Object> data;
            Object obj;
            if (iOAdEvent == null) {
                return null;
            }
            String message = iOAdEvent.getMessage();
            return (!TextUtils.isEmpty(message) || (data = iOAdEvent.getData()) == null || (obj = data.get("msg")) == null || !(obj instanceof String)) ? message : (String) obj;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            bg.a(new bj(this, iOAdEvent));
        }
    }

    public bg(Context context) {
        this.f9878h = context;
        aa.a().a(this.f9878h, new bh(this));
    }

    public abstract void a();

    public void a(View view, JSONObject jSONObject) {
        IAdInterListener iAdInterListener = this.f9881k;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(view, a(IAdInterListener.AdCommandType.AD_IMPRESSION, jSONObject));
        }
    }

    public void a(IOAdEvent iOAdEvent) {
    }

    public void a(String str, boolean z10) {
    }

    public void b(View view, JSONObject jSONObject) {
        IAdInterListener iAdInterListener = this.f9881k;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(view, a(IAdInterListener.AdCommandType.AD_CLICK, jSONObject));
        }
    }

    public void b(IOAdEvent iOAdEvent) {
    }

    public void b(String str, boolean z10) {
    }

    public void b(boolean z10) {
    }

    public void b_() {
    }

    public void c(IOAdEvent iOAdEvent) {
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            b("bidding id is empty", 2);
        }
        if (this.f9881k != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("bid_id", str);
            a("load_bidding_ad", (Map<String, Object>) hashMap);
            return;
        }
        b("Initialization doesn't finish yet.", 1);
    }

    public void c_() {
    }

    public void d() {
    }

    public void d(IOAdEvent iOAdEvent) {
    }

    public void d(String str) {
    }

    public void e() {
        IAdInterListener iAdInterListener = this.f9881k;
        if (iAdInterListener != null) {
            iAdInterListener.destroyAd();
        }
    }

    public void e(IOAdEvent iOAdEvent) {
    }

    public void e(String str) {
    }

    public void f(IOAdEvent iOAdEvent) {
    }

    public void f(String str) {
    }

    public void g(IOAdEvent iOAdEvent) {
        r();
    }

    public void g(String str) {
    }

    public void h(IOAdEvent iOAdEvent) {
    }

    public void h(String str) {
        this.f9885o = str;
    }

    public void i() {
        this.f9881k = (IAdInterListener) as.a(x.f10426k, br.a(this.f9878h), (Class<?>[]) new Class[]{Context.class}, this.f9878h);
        if (this.f9882l) {
            return;
        }
        a();
    }

    public void i(IOAdEvent iOAdEvent) {
    }

    public void j() {
        b("SDK未初始化", 1);
    }

    public void j(IOAdEvent iOAdEvent) {
    }

    public JSONObject k() {
        return new JSONObject();
    }

    public void k(IOAdEvent iOAdEvent) {
    }

    public JSONObject l() {
        return new JSONObject();
    }

    public String m() {
        JSONObject k10 = k();
        JSONObject l10 = l();
        HashMap hashMap = new HashMap();
        hashMap.put("param_info", k10);
        hashMap.put("ad_buss_param", l10);
        a("get_request_token", (Map<String, Object>) hashMap);
        Object obj = hashMap.get("request_token");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public void n() {
        IAdInterListener iAdInterListener = this.f9881k;
        if (iAdInterListener != null) {
            iAdInterListener.addEventListener(com.baidu.mobads.sdk.internal.a.c.f9727h, new c.a());
            this.f9881k.addEventListener(x.H, this.f9880j);
            this.f9881k.addEventListener(x.J, this.f9880j);
            this.f9881k.addEventListener(x.L, this.f9880j);
            this.f9881k.addEventListener(x.M, this.f9880j);
            this.f9881k.addEventListener(x.W, this.f9880j);
            this.f9881k.addEventListener(x.f10433r, this.f9880j);
            this.f9881k.addEventListener(x.X, this.f9880j);
            this.f9881k.addEventListener(x.f10434s, this.f9880j);
            this.f9881k.addEventListener(x.N, this.f9880j);
            this.f9881k.addEventListener(x.O, this.f9880j);
            this.f9881k.addEventListener(x.K, this.f9880j);
            this.f9881k.addEventListener(x.D, this.f9880j);
            this.f9881k.addEventListener(x.f10413ac, this.f9880j);
            this.f9881k.addEventListener(x.f10414ad, this.f9880j);
            this.f9881k.addEventListener(x.f10411aa, this.f9880j);
            this.f9881k.addEventListener(x.V, this.f9880j);
            this.f9881k.addEventListener(x.f10415ae, this.f9880j);
            this.f9881k.addEventListener(x.af, this.f9880j);
            this.f9881k.addEventListener(x.ag, this.f9880j);
            this.f9881k.addEventListener(x.ah, this.f9880j);
            this.f9881k.addEventListener(x.ai, this.f9880j);
            this.f9881k.addEventListener(x.aj, this.f9880j);
            this.f9881k.addEventListener(x.ak, this.f9880j);
            this.f9881k.addEventListener(x.al, this.f9880j);
            this.f9881k.addEventListener(x.f10412ab, this.f9880j);
            this.f9881k.addEventListener(x.am, this.f9880j);
            this.f9881k.addEventListener(x.Y, this.f9880j);
            this.f9881k.addEventListener(x.an, this.f9880j);
            this.f9881k.addEventListener(x.ao, this.f9880j);
        }
    }

    public void o() {
        IAdInterListener iAdInterListener = this.f9881k;
        if (iAdInterListener != null) {
            iAdInterListener.onAttachedToWindow();
        }
    }

    public void p() {
        IAdInterListener iAdInterListener = this.f9881k;
        if (iAdInterListener != null) {
            iAdInterListener.onDetachedFromWindow();
        }
    }

    public void q() {
    }

    public void r() {
        IAdInterListener iAdInterListener = this.f9881k;
        if (iAdInterListener != null) {
            iAdInterListener.removeAllListeners();
        }
    }

    public void s() {
    }

    public void t() {
    }

    public void u() {
    }

    public void v() {
    }

    public View w() {
        IAdInterListener iAdInterListener = this.f9881k;
        if (iAdInterListener != null) {
            return iAdInterListener.getAdContainerView();
        }
        return null;
    }

    public void a(Activity activity) {
        if (this.f9881k != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("setActivity", activity);
            this.f9881k.onAdTaskProcess(a(IAdInterListener.AdCommandType.CHANGE_ACTIVITY, new JSONObject()), hashMap);
        }
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            b("bidding data is empty", 2);
        }
        if (this.f9881k != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("bidding_data", str);
            a("load_bidding_data", (Map<String, Object>) hashMap);
            return;
        }
        b("Initialization doesn't finish yet.", 1);
    }

    public String i(String str) {
        IXAdContainerFactory c4;
        aa a10 = aa.a();
        if (a10 != null && (c4 = a10.c()) != null) {
            Object remoteParam = c4.getRemoteParam(str, new Object[0]);
            if (remoteParam instanceof String) {
                return (String) remoteParam;
            }
        }
        return null;
    }

    public void a(JSONObject jSONObject) {
        IAdInterListener iAdInterListener = this.f9881k;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(a(IAdInterListener.AdCommandType.HANDLE_EVENT, jSONObject));
        }
    }

    public void b(int i10) {
        IAdInterListener iAdInterListener = this.f9881k;
        if (iAdInterListener != null) {
            iAdInterListener.onWindowVisibilityChanged(i10);
        }
    }

    public void a(JSONObject jSONObject, Map<String, Object> map) {
        IAdInterListener iAdInterListener = this.f9881k;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(a(IAdInterListener.AdCommandType.HANDLE_EVENT, jSONObject), map);
        }
    }

    public void b(String str, int i10) {
        r();
    }

    public void a(String str, Map<String, Object> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_type", "server_bidding");
            jSONObject.put("msg", str);
            IAdInterListener iAdInterListener = this.f9881k;
            if (iAdInterListener != null) {
                iAdInterListener.onAdTaskProcess(a(IAdInterListener.AdCommandType.HANDLE_EVENT, jSONObject), map);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public JSONObject b(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        if (!map.isEmpty()) {
            try {
            } catch (Exception unused) {
                return null;
            }
        }
        return new JSONObject(map);
    }

    public void b(JSONObject jSONObject) {
        int i10 = this.f9886p;
        if (i10 < 0 || jSONObject == null) {
            return;
        }
        try {
            jSONObject.put(f9871a, i10);
        } catch (Throwable th) {
            this.f9879i.a(th);
        }
    }

    public void a(String str, boolean z10, String str2) {
        a(str, z10, str2, null);
    }

    public void a(String str, boolean z10, String str2, HashMap<String, Object> hashMap) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uniqueId", str);
            jSONObject.put("result", z10);
            jSONObject.put("replacement", str2);
            if (hashMap != null) {
                try {
                    for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                        jSONObject.put(String.valueOf(entry.getKey()), entry.getValue());
                    }
                } catch (Throwable th) {
                    aw.f(th.getMessage());
                }
            }
            IAdInterListener iAdInterListener = this.f9881k;
            if (iAdInterListener != null) {
                iAdInterListener.onAdTaskProcess(a("onBiddingResult", jSONObject), (Map<String, Object>) null);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void a(String str, HashMap<String, Object> hashMap) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_type", str);
            IAdInterListener iAdInterListener = this.f9881k;
            if (iAdInterListener != null) {
                iAdInterListener.onAdTaskProcess(a(IAdInterListener.AdCommandType.NOVEL_EVENT, jSONObject), hashMap);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(boolean z10) {
        IAdInterListener iAdInterListener = this.f9881k;
        if (iAdInterListener != null) {
            iAdInterListener.onWindowFocusChanged(z10);
        }
    }

    public boolean a(int i10, KeyEvent keyEvent) {
        IAdInterListener iAdInterListener = this.f9881k;
        if (iAdInterListener != null) {
            return iAdInterListener.onKeyDown(i10, keyEvent);
        }
        return false;
    }

    public void a(int i10, String str) {
        r();
    }

    public static void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                new Handler(Looper.getMainLooper()).post(new bi(runnable));
            }
        } catch (Exception unused) {
        }
    }

    public void a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.f9883m = (HashMap) map;
    }

    private String a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return "bdsdk://" + str + "?jsonObj=" + Uri.encode(jSONObject.toString());
    }
}
