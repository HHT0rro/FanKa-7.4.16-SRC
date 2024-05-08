package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.CPUWebAdRequestParam;
import com.baidu.mobads.sdk.api.CpuAdView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class cs extends bg {

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, Object> f10117a;

    /* renamed from: q, reason: collision with root package name */
    private int f10118q;

    /* renamed from: r, reason: collision with root package name */
    private RelativeLayout f10119r;

    /* renamed from: s, reason: collision with root package name */
    private CpuAdView.CpuAdViewInternalStatusListener f10120s;

    public cs(Context context, RelativeLayout relativeLayout, String str, int i10, CPUWebAdRequestParam cPUWebAdRequestParam) {
        super(context);
        this.f9885o = str;
        this.f10119r = relativeLayout;
        this.f10118q = i10;
        if (cPUWebAdRequestParam == null) {
            aw.c().e("内容联盟模板需要传入 CPUWebAdRequestParam配置信息");
        } else {
            this.f10117a = (HashMap) cPUWebAdRequestParam.getParameters();
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        ao.b();
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void b(String str, int i10) {
        CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener = this.f10120s;
        if (cpuAdViewInternalStatusListener != null) {
            cpuAdViewInternalStatusListener.loadDataError(str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void d() {
        CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener = this.f10120s;
        if (cpuAdViewInternalStatusListener != null) {
            cpuAdViewInternalStatusListener.onExitLp();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void e(IOAdEvent iOAdEvent) {
        Map<String, Object> data = iOAdEvent.getData();
        Boolean bool = (Boolean) data.get("isImpressionFeAd");
        String str = (String) data.get("nums");
        if (this.f10120s != null && bool != null && bool.booleanValue()) {
            this.f10120s.onAdImpression(str);
            return;
        }
        CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener = this.f10120s;
        if (cpuAdViewInternalStatusListener == null || bool == null) {
            return;
        }
        cpuAdViewInternalStatusListener.onContentImpression(str);
    }

    public Activity f() {
        return ao.c();
    }

    public boolean g() {
        return ao.d();
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void h(IOAdEvent iOAdEvent) {
        Boolean bool = (Boolean) iOAdEvent.getData().get("isClickFeAd");
        if (this.f10120s != null && bool != null && bool.booleanValue()) {
            this.f10120s.onAdClick();
            return;
        }
        CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener = this.f10120s;
        if (cpuAdViewInternalStatusListener == null || bool == null) {
            return;
        }
        cpuAdViewInternalStatusListener.onContentClick();
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void d(IOAdEvent iOAdEvent) {
        if (this.f10120s == null || iOAdEvent == null) {
            return;
        }
        this.f10120s.onLpContentStatus(iOAdEvent.getData());
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void a() {
        if (this.f9881k == null) {
            this.f9882l = false;
            return;
        }
        this.f9882l = true;
        JSONObject jSONObject = new JSONObject();
        if (this.f9881k != null) {
            try {
                jSONObject.put(TTLiveConstants.INIT_CHANNEL, this.f10118q);
                jSONObject.put(IAdInterListener.AdReqParam.PROD, "cpu_h5");
                jSONObject.put("timeout", 10000);
                if (!TextUtils.isEmpty(this.f9885o)) {
                    jSONObject.put("appid", this.f9885o);
                }
                if (this.f10119r != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(IAdInterListener.AdReqParam.PROD, "cpu_h5");
                    this.f9881k.createProdHandler(jSONObject2);
                    this.f9881k.setAdContainer(this.f10119r);
                    n();
                    this.f9881k.addEventListener("Update_fbReader_Setting", new ct(this));
                    this.f9881k.addEventListener("closeInterstitialAd", new cu(this));
                    this.f9881k.addEventListener("feOpenFbReader", new cv(this));
                    JSONObject a10 = k.a(this.f10117a);
                    a10.put("isInitNovelSDK", ao.f());
                    this.f9881k.loadAd(jSONObject, a10);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i10, int i11, String str, int i12, int i13, String str2) {
        ao.a(i10);
        ao.b(i11);
        ao.a(new cw(this, i12, i13, str2));
        ao.a(this.f9878h, str);
    }

    public void a(CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener) {
        this.f10120s = cpuAdViewInternalStatusListener;
    }
}
