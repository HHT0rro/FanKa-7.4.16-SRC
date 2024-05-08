package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.EntryResponse;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.XAdEntryResponse;
import com.baidu.mobads.sdk.api.XAdNativeResponse;
import com.baidu.mobads.sdk.internal.f;
import com.huawei.openalliance.ad.constant.bg;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class dj extends bg {
    private f.a A;
    private BaiduNativeManager.ExpressAdListener B;
    private BaiduNativeManager.EntryAdListener C;
    private f.b D;
    private int E;

    /* renamed from: a, reason: collision with root package name */
    private List<NativeResponse> f10180a;

    /* renamed from: q, reason: collision with root package name */
    private List<ExpressResponse> f10181q;

    /* renamed from: r, reason: collision with root package name */
    private List<EntryResponse> f10182r;

    /* renamed from: s, reason: collision with root package name */
    private int f10183s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f10184t;

    /* renamed from: u, reason: collision with root package name */
    private String f10185u;

    /* renamed from: v, reason: collision with root package name */
    private String f10186v;

    /* renamed from: w, reason: collision with root package name */
    private int f10187w;

    /* renamed from: x, reason: collision with root package name */
    private int f10188x;

    /* renamed from: y, reason: collision with root package name */
    private RequestParameters f10189y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f10190z;

    public dj(Context context, String str, String str2, boolean z10, int i10) {
        super(context);
        this.f10190z = false;
        this.E = 0;
        this.f10186v = str;
        this.f10185u = str2;
        this.f10184t = z10;
        this.f10183s = i10;
        this.f10187w = 600;
        this.f10188x = 500;
    }

    public void a(f.a aVar) {
        this.A = aVar;
    }

    public void b(Activity activity) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "bindExpressActivity");
            hashMap.put("activity", activity);
        } catch (JSONException e2) {
            bs.a().a(e2);
        }
        a(jSONObject, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void b_() {
        f.a aVar = this.A;
        if (aVar != null) {
            aVar.b();
            return;
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.B;
        if (expressAdListener != null) {
            expressAdListener.onVideoDownloadSuccess();
        }
    }

    public void c(boolean z10) {
        this.f10190z = z10;
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void c_() {
        f.a aVar = this.A;
        if (aVar != null) {
            aVar.c();
            return;
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.B;
        if (expressAdListener != null) {
            expressAdListener.onVideoDownloadFailed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void d() {
        f.a aVar = this.A;
        if (aVar != null) {
            aVar.a();
            return;
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.B;
        if (expressAdListener != null) {
            expressAdListener.onLpClosed();
            return;
        }
        BaiduNativeManager.EntryAdListener entryAdListener = this.C;
        if (entryAdListener != null) {
            entryAdListener.onLpClosed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void e(IOAdEvent iOAdEvent) {
        String message = iOAdEvent.getMessage();
        int i10 = 0;
        if (this.A != null && !TextUtils.isEmpty(message) && this.f10180a != null) {
            while (i10 < this.f10180a.size()) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f10180a.get(i10);
                if (xAdNativeResponse.getUniqueId().equals(message)) {
                    this.A.a(xAdNativeResponse);
                }
                i10++;
            }
            return;
        }
        if (this.B != null && !TextUtils.isEmpty(message) && this.f10181q != null) {
            while (i10 < this.f10181q.size()) {
                bp bpVar = (bp) this.f10181q.get(i10);
                if (TextUtils.equals(message, bpVar.a())) {
                    bpVar.c();
                }
                i10++;
            }
            return;
        }
        if (this.C == null || TextUtils.isEmpty(message) || this.f10182r == null) {
            return;
        }
        while (i10 < this.f10182r.size()) {
            XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.f10182r.get(i10);
            if (TextUtils.equals(message, xAdEntryResponse.getUniqueId())) {
                xAdEntryResponse.onADExposed();
            }
            i10++;
        }
    }

    public String f() {
        return this.f10185u;
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void g(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.B == null || iOAdEvent == null || this.f10181q == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        for (int i10 = 0; i10 < this.f10181q.size(); i10++) {
            bp bpVar = (bp) this.f10181q.get(i10);
            if (TextUtils.equals(bpVar.a(), str)) {
                bpVar.a(bpVar);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void h(IOAdEvent iOAdEvent) {
        String message = iOAdEvent.getMessage();
        int i10 = 0;
        if (this.A != null && !TextUtils.isEmpty(message) && this.f10180a != null) {
            while (i10 < this.f10180a.size()) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f10180a.get(i10);
                if (xAdNativeResponse.getUniqueId().equals(message)) {
                    this.A.b(xAdNativeResponse);
                }
                i10++;
            }
            return;
        }
        if (this.B != null && !TextUtils.isEmpty(message) && this.f10181q != null) {
            while (i10 < this.f10181q.size()) {
                bp bpVar = (bp) this.f10181q.get(i10);
                if (TextUtils.equals(message, bpVar.a())) {
                    bpVar.b();
                }
                i10++;
            }
            return;
        }
        if (this.C == null || TextUtils.isEmpty(message) || this.f10182r == null) {
            return;
        }
        while (i10 < this.f10182r.size()) {
            XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.f10182r.get(i10);
            if (TextUtils.equals(message, xAdEntryResponse.getUniqueId())) {
                xAdEntryResponse.onAdClick();
            }
            i10++;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void i(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.B == null || iOAdEvent == null || this.f10181q == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        View view = (View) data.get("expressView");
        int intValue = ((Integer) data.get("viewWidth")).intValue();
        int intValue2 = ((Integer) data.get("viewHeight")).intValue();
        for (int i10 = 0; i10 < this.f10181q.size(); i10++) {
            bp bpVar = (bp) this.f10181q.get(i10);
            if (TextUtils.equals(bpVar.a(), str)) {
                bpVar.a(view, intValue, intValue2);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void j(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.B == null || iOAdEvent == null || this.f10181q == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        View view = (View) data.get("expressView");
        int intValue = ((Integer) data.get("error_code")).intValue();
        String str2 = (String) data.get("error_message");
        for (int i10 = 0; i10 < this.f10181q.size(); i10++) {
            bp bpVar = (bp) this.f10181q.get(i10);
            if (TextUtils.equals(bpVar.a(), str)) {
                bpVar.a(view, str2, intValue);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void k(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (iOAdEvent == null || this.f10180a == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        String str2 = (String) data.get("type");
        for (int i10 = 0; i10 < this.f10180a.size(); i10++) {
            XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f10180a.get(i10);
            if (TextUtils.equals(xAdNativeResponse.getUniqueId(), str) && TextUtils.equals(bg.b.C, str2)) {
                xAdNativeResponse.onShakeViewDismiss();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timeout", this.f10183s);
            jSONObject.put("isCacheVideo", this.f10184t);
            jSONObject.put("cacheVideoOnlyWifi", this.f10190z);
            RequestParameters requestParameters = this.f10189y;
            jSONObject.put("appConfirmPolicy", requestParameters == null ? 1 : requestParameters.getAPPConfirmPolicy());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0076, code lost:
    
        if (com.baidu.mobads.sdk.internal.bt.a(r16.f9878h, r9) != false) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00fa A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a7  */
    @Override // com.baidu.mobads.sdk.internal.bg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void q() {
        /*
            Method dump skipped, instructions count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.dj.q():void");
    }

    public void a(BaiduNativeManager.ExpressAdListener expressAdListener) {
        this.B = expressAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void c(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.B == null || iOAdEvent == null || this.f10181q == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        String str2 = (String) data.get("type");
        for (int i10 = 0; i10 < this.f10181q.size(); i10++) {
            bp bpVar = (bp) this.f10181q.get(i10);
            if (TextUtils.equals(bpVar.a(), str)) {
                if (TextUtils.equals("show", str2)) {
                    bpVar.d();
                } else if (TextUtils.equals("click", str2)) {
                    Object obj = data.get("reason");
                    bpVar.a(obj instanceof String ? (String) obj : "");
                } else if (TextUtils.equals("close", str2)) {
                    bpVar.e();
                }
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void f(IOAdEvent iOAdEvent) {
        if (iOAdEvent == null) {
            return;
        }
        Map<String, Object> data = iOAdEvent.getData();
        int i10 = 0;
        if (this.A != null && data != null && this.f10180a != null) {
            String str = (String) data.get(bg.f9875e);
            while (i10 < this.f10180a.size()) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f10180a.get(i10);
                if (xAdNativeResponse != null && xAdNativeResponse.getUniqueId().equals(str)) {
                    this.A.a(xAdNativeResponse, Integer.parseInt((String) data.get(bg.f9876f)));
                }
                i10++;
            }
            return;
        }
        if (this.C == null || data == null || this.f10182r == null) {
            return;
        }
        String str2 = (String) data.get(bg.f9875e);
        while (i10 < this.f10182r.size()) {
            XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.f10182r.get(i10);
            if (xAdEntryResponse != null && xAdEntryResponse.getUniqueId().equals(str2)) {
                xAdEntryResponse.onADExposureFailed(Integer.parseInt((String) data.get(bg.f9876f)));
            }
            i10++;
        }
    }

    public void a(BaiduNativeManager.EntryAdListener entryAdListener) {
        this.C = entryAdListener;
    }

    public void a(f.b bVar) {
        this.D = bVar;
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void a() {
        IAdInterListener iAdInterListener = this.f9881k;
        if (iAdInterListener == null) {
            this.f9882l = false;
        } else {
            this.f9882l = true;
            iAdInterListener.loadAd(k(), l());
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void b(IOAdEvent iOAdEvent) {
        if (this.D == null || iOAdEvent == null || this.f10180a == null) {
            return;
        }
        String message = iOAdEvent.getMessage();
        for (int i10 = 0; i10 < this.f10180a.size(); i10++) {
            XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f10180a.get(i10);
            if (xAdNativeResponse.getUniqueId().equals(message)) {
                this.D.a(xAdNativeResponse);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void d(String str) {
        if (!TextUtils.isEmpty(str) && this.f10180a != null) {
            for (int i10 = 0; i10 < this.f10180a.size(); i10++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f10180a.get(i10);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onAdUnionClick();
                }
            }
        }
        if (!TextUtils.isEmpty(str) && this.f10181q != null) {
            for (int i11 = 0; i11 < this.f10181q.size(); i11++) {
                bp bpVar = (bp) this.f10181q.get(i11);
                if (TextUtils.equals(str, bpVar.a())) {
                    bpVar.f();
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.f10182r == null) {
            return;
        }
        for (int i12 = 0; i12 < this.f10182r.size(); i12++) {
            XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.f10182r.get(i12);
            if (TextUtils.equals(str, xAdEntryResponse.getUniqueId())) {
                xAdEntryResponse.onAdUnionClick();
            }
        }
    }

    public RequestParameters g() {
        return this.f10189y;
    }

    public void a(RequestParameters requestParameters) {
        int width = requestParameters.getWidth();
        int height = requestParameters.getHeight();
        if (width > 0 && height > 0) {
            this.f10187w = width;
            this.f10188x = height;
        }
        this.f10189y = requestParameters;
        a(requestParameters.getExtras());
        c(requestParameters.getExt());
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, this.f10185u);
            this.f9881k.createProdHandler(jSONObject2);
            this.f9881k.setAdContainer(this.f9877g);
            n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, this.f10185u);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.f10186v);
            if (cp.a().b()) {
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML");
            } else {
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML,CLICK2VIDEO");
            }
            jSONObject.put("n", "1");
            if (!TextUtils.isEmpty(this.f9885o)) {
                jSONObject.put("appid", this.f9885o);
            }
            if ("video".equals(this.f10185u)) {
                jSONObject.put("at", "10");
                jSONObject.put(IAdInterListener.AdReqParam.MIME_TYPE, "video/mp4,image/jpg,image/gif,image/png");
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,HTML,MSSP,VIDEO,NMON");
            } else {
                jSONObject.put("at", "2");
            }
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + this.f10187w);
            jSONObject.put("h", "" + this.f10188x);
            jSONObject.put("msa", 143);
            jSONObject = k.a(jSONObject, b(this.f9883m));
            jSONObject.put("opt", this.E);
            if (this.E == 0) {
                jSONObject.put("optn", 1);
            }
            b(jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void b(String str, int i10) {
        f.a aVar = this.A;
        if (aVar != null) {
            aVar.b(i10, str);
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.B;
        if (expressAdListener != null) {
            expressAdListener.onNativeFail(i10, str);
        }
        BaiduNativeManager.EntryAdListener entryAdListener = this.C;
        if (entryAdListener != null) {
            entryAdListener.onNativeFail(i10, str);
        }
    }

    public void a(int i10) {
        this.E = i10;
    }

    public ViewGroup a(a aVar) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "initExpressContainer");
            jSONObject.put("uniqueId", aVar.H());
        } catch (JSONException e2) {
            bs.a().a(e2);
        }
        a(jSONObject, hashMap);
        Object obj = hashMap.get("container");
        if (obj instanceof ViewGroup) {
            return (ViewGroup) obj;
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void e(String str) {
        if (!TextUtils.isEmpty(str) && this.f10180a != null) {
            for (int i10 = 0; i10 < this.f10180a.size(); i10++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f10180a.get(i10);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onADPrivacyClick();
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.f10181q == null) {
            return;
        }
        for (int i11 = 0; i11 < this.f10181q.size(); i11++) {
            bp bpVar = (bp) this.f10181q.get(i11);
            if (TextUtils.equals(str, bpVar.a())) {
                bpVar.g();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void f(String str) {
        if (!TextUtils.isEmpty(str) && this.f10180a != null) {
            for (int i10 = 0; i10 < this.f10180a.size(); i10++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f10180a.get(i10);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onADFunctionClick();
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.f10181q == null) {
            return;
        }
        for (int i11 = 0; i11 < this.f10181q.size(); i11++) {
            bp bpVar = (bp) this.f10181q.get(i11);
            if (TextUtils.equals(str, bpVar.a())) {
                bpVar.h();
            }
        }
    }

    public String h() {
        return this.f10186v;
    }

    public void c(Map<String, String> map) {
        try {
            HashMap<String, String> a10 = k.a(map);
            if (this.f9883m == null) {
                this.f9883m = new HashMap<>();
            }
            if (a10.isEmpty()) {
                return;
            }
            for (String str : a10.h()) {
                if (!TextUtils.isEmpty(str)) {
                    String str2 = a10.get(str);
                    if (!TextUtils.isEmpty(str2)) {
                        this.f9883m.put(str, str2);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void b(String str, boolean z10) {
        if (!TextUtils.isEmpty(str) && this.f10180a != null) {
            for (int i10 = 0; i10 < this.f10180a.size(); i10++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f10180a.get(i10);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onAdDownloadWindow(z10);
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.f10181q == null) {
            return;
        }
        for (int i11 = 0; i11 < this.f10181q.size(); i11++) {
            bp bpVar = (bp) this.f10181q.get(i11);
            if (TextUtils.equals(str, bpVar.a())) {
                bpVar.b(z10);
            }
        }
    }

    public void a(ViewGroup viewGroup, a aVar) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "renderExpressView");
            jSONObject.put("uniqueId", aVar.H());
            hashMap.put("container", viewGroup);
        } catch (JSONException e2) {
            bs.a().a(e2);
        }
        a(jSONObject, hashMap);
    }

    public boolean a(View view, a aVar, int i10) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "switchTheme");
            hashMap.put("view", view);
            hashMap.put("code", Integer.valueOf(i10));
        } catch (JSONException e2) {
            bs.a().a(e2);
        }
        a(jSONObject, hashMap);
        Object obj = hashMap.get("result");
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void a(int i10, String str) {
        f.a aVar = this.A;
        if (aVar != null) {
            aVar.a(i10, str);
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.B;
        if (expressAdListener != null) {
            expressAdListener.onNoAd(i10, str);
        }
        BaiduNativeManager.EntryAdListener entryAdListener = this.C;
        if (entryAdListener != null) {
            entryAdListener.onNoAd(i10, str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void a(String str, boolean z10) {
        if (!TextUtils.isEmpty(str) && this.f10180a != null) {
            for (int i10 = 0; i10 < this.f10180a.size(); i10++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f10180a.get(i10);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onADPermissionShow(z10);
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.f10181q == null) {
            return;
        }
        for (int i11 = 0; i11 < this.f10181q.size(); i11++) {
            bp bpVar = (bp) this.f10181q.get(i11);
            if (TextUtils.equals(str, bpVar.a())) {
                bpVar.a(z10);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void a(Map<String, String> map) {
        int length;
        if (map == null || map.isEmpty()) {
            return;
        }
        HashMap hashMap = new HashMap(map);
        HashMap<String, String> hashMap2 = new HashMap<>();
        int i10 = 0;
        for (String str : ArticleInfo.PREDEFINED_KEYS) {
            if (hashMap.containsKey(str)) {
                String str2 = (String) hashMap.remove(str);
                if (!TextUtils.isEmpty(str2) && (length = str2.length() + i10) < 150) {
                    hashMap2.put(str, str2);
                    i10 = length;
                }
            }
        }
        if (!hashMap.isEmpty()) {
            for (String str3 : hashMap.h()) {
                if (!TextUtils.isEmpty(str3)) {
                    String str4 = (String) hashMap.get(str3);
                    if (!TextUtils.isEmpty(str4)) {
                        int length2 = i10 + str3.length() + str4.length();
                        if (length2 >= 150) {
                            break;
                        }
                        hashMap2.put("c_" + str3, str4);
                        i10 = length2 + 2;
                    } else {
                        continue;
                    }
                }
            }
        }
        this.f9883m = hashMap2;
    }
}
