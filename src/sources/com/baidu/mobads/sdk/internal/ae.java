package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.api.NativeCPUAdData;
import com.baidu.mobads.sdk.api.NativeCPUManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ae extends bg {

    /* renamed from: a, reason: collision with root package name */
    public static final int f9755a = 17;

    /* renamed from: q, reason: collision with root package name */
    private static final String f9756q = "javascript:";
    private int A;
    private boolean B;
    private String C;

    /* renamed from: r, reason: collision with root package name */
    private int f9757r;

    /* renamed from: s, reason: collision with root package name */
    private int f9758s;

    /* renamed from: t, reason: collision with root package name */
    private int[] f9759t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f9760u;

    /* renamed from: v, reason: collision with root package name */
    private int f9761v;

    /* renamed from: w, reason: collision with root package name */
    private HashMap<String, Object> f9762w;

    /* renamed from: x, reason: collision with root package name */
    private NativeCPUManager.CPUAdListener f9763x;

    /* renamed from: y, reason: collision with root package name */
    private NativeCPUManager f9764y;

    /* renamed from: z, reason: collision with root package name */
    private int f9765z;

    public ae(Context context) {
        super(context);
        this.f9765z = 5;
        this.A = 60;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Map<String, Object> map) {
        if (map != null) {
            Object obj = map.get("adInnerPageInterval");
            Object obj2 = map.get("adBottomRefreshInterval");
            Object obj3 = map.get("adFrontChapterInterval");
            Object obj4 = map.get("isShowFeeds");
            Object obj5 = map.get("isAdSwitch");
            Object obj6 = map.get("showCount");
            Object obj7 = map.get("clickCount");
            if (obj != null && obj2 != null) {
                ao.a(((Integer) obj).intValue());
                ao.b(((Integer) obj2).intValue());
            }
            if ((obj3 instanceof Integer) && (obj4 instanceof Boolean)) {
                ao.a(((Integer) obj3).intValue(), ((Boolean) obj4).booleanValue());
            }
            if (obj5 instanceof Integer) {
                ao.a(((Integer) obj5).intValue() != 0);
            }
            if ((obj6 instanceof Integer) && (obj7 instanceof Integer)) {
                ao.a(((Integer) obj6).intValue(), ((Integer) obj7).intValue());
            }
        }
    }

    private String j(String str) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        ao.b();
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void b_() {
        NativeCPUManager.CPUAdListener cPUAdListener = this.f9763x;
        if (cPUAdListener != null) {
            cPUAdListener.onVideoDownloadSuccess();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void c_() {
        NativeCPUManager.CPUAdListener cPUAdListener = this.f9763x;
        if (cPUAdListener != null) {
            cPUAdListener.onVideoDownloadFailed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void d() {
        NativeCPUManager.CPUAdListener cPUAdListener = this.f9763x;
        if (cPUAdListener != null) {
            cPUAdListener.onExitLp();
        }
    }

    public void f() {
        ao.a(this.f9765z);
        ao.b(this.A);
        ao.a(new aj(this));
    }

    public Activity g() {
        return ao.c();
    }

    public boolean h() {
        return ao.d();
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void b(String str, int i10) {
        super.b(str, i10);
        NativeCPUManager.CPUAdListener cPUAdListener = this.f9763x;
        if (cPUAdListener != null) {
            cPUAdListener.onAdError(str, i10);
        }
    }

    public void a(NativeCPUManager.CPUAdListener cPUAdListener) {
        this.f9763x = cPUAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void d(IOAdEvent iOAdEvent) {
        try {
            if (this.f9763x == null || iOAdEvent == null) {
                return;
            }
            HashMap<String, Object> hashMap = (HashMap) iOAdEvent.getData();
            this.f9763x.onLpCustomEventCallBack(hashMap, new ah(this, hashMap.get("activity")));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public ae(Context context, String str, NativeCPUManager nativeCPUManager) {
        super(context);
        this.f9765z = 5;
        this.A = 60;
        this.f9885o = str;
        this.f9764y = nativeCPUManager;
    }

    public void a(int i10, int i11, int[] iArr, boolean z10, HashMap<String, Object> hashMap) {
        this.f9758s = i10;
        this.f9757r = i11;
        this.f9759t = iArr;
        this.f9760u = z10;
        this.f9762w = hashMap;
        this.B = ao.f();
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void b(IOAdEvent iOAdEvent) {
        notifyObservers(iOAdEvent);
        setChanged();
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void a() {
        if (this.f9881k == null) {
            this.f9882l = false;
            return;
        }
        this.f9882l = true;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_CPU);
            this.f9881k.createProdHandler(jSONObject3);
            n();
            this.f9881k.addEventListener("Update_fbReader_Setting", new af(this));
            this.f9881k.addEventListener("closeInterstitialAd", new ag(this));
            jSONObject.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_CPU);
            jSONObject.put("appsid", this.f9885o);
            jSONObject.put("pageIndex", this.f9758s);
            jSONObject.put("pageSize", this.f9757r);
            jSONObject.put("channels", this.f9759t);
            jSONObject.put("showAd", this.f9760u);
            jSONObject.put("openActivitylink", this.C);
            if (!TextUtils.isEmpty(this.f9885o)) {
                jSONObject.put("appid", this.f9885o);
            }
            jSONObject2.put("timeout", this.f9761v);
            HashMap<String, Object> hashMap = this.f9762w;
            if (hashMap == null || hashMap.isEmpty()) {
                aw.c().e("内容联盟元素需要传入 CPUAdRequest配置信息");
            }
            jSONObject2 = k.a(this.f9762w);
            if (jSONObject2 != null) {
                jSONObject2.put("isInitNovelSDK", this.B);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f9881k.loadAd(jSONObject, jSONObject2);
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void c(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            Map<String, Object> data = iOAdEvent.getData();
            Integer num = (Integer) data.get("position");
            String str = (String) data.get("mislikereason");
            NativeCPUManager.CPUAdListener cPUAdListener = this.f9763x;
            if (cPUAdListener == null || num == null || str == null) {
                return;
            }
            cPUAdListener.onDisLikeAdClick(num.intValue(), str);
        }
    }

    public void a(int i10) {
        this.f9761v = i10;
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void a(IOAdEvent iOAdEvent) {
        if (this.f9763x != null) {
            ArrayList arrayList = new ArrayList();
            Iterator iterator2 = ((List) iOAdEvent.getData().get("cpuAdList")).iterator2();
            while (iterator2.hasNext()) {
                NativeCPUAdData nativeCPUAdData = new NativeCPUAdData(this.f9878h, iterator2.next(), this.f9762w);
                arrayList.add(nativeCPUAdData);
                addObserver(nativeCPUAdData);
            }
            this.f9763x.onAdLoaded(arrayList);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void a(int i10, String str) {
        super.a(i10, str);
        NativeCPUManager.CPUAdListener cPUAdListener = this.f9763x;
        if (cPUAdListener != null) {
            cPUAdListener.onAdError(str, i10);
        }
    }

    public void a(WebView webView, JSONObject jSONObject) {
        bg.a(new ai(this, jSONObject, webView));
    }

    public void a(String str) {
        this.C = str;
    }
}
