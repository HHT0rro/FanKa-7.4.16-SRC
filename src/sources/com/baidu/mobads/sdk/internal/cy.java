package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.baidu.mobads.sdk.api.CPUAdType;
import com.baidu.mobads.sdk.api.CPUDramaDetailConfig;
import com.baidu.mobads.sdk.api.CPUDramaListener;
import com.baidu.mobads.sdk.api.CPUDramaRequestParams;
import com.baidu.mobads.sdk.api.CPUDramaResponse;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.internal.concrete.FragmentDelegate;
import com.baidu.mobads.sdk.internal.concrete.FragmentV4Delegate;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class cy extends bg {

    /* renamed from: a, reason: collision with root package name */
    private CPUDramaRequestParams f10131a;

    /* renamed from: q, reason: collision with root package name */
    private CPUDramaResponse f10132q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f10133r;

    /* renamed from: s, reason: collision with root package name */
    private CPUDramaListener f10134s;

    public cy(Context context, CPUDramaRequestParams cPUDramaRequestParams, CPUDramaListener cPUDramaListener) {
        super(context);
        this.f10131a = cPUDramaRequestParams;
        this.f10134s = cPUDramaListener;
        this.f10133r = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(IOAdEvent iOAdEvent) {
        if (this.f10134s != null) {
            CPUDramaResponse cPUDramaResponse = null;
            if (iOAdEvent != null) {
                try {
                    Map<String, Object> data = iOAdEvent.getData();
                    cPUDramaResponse = new CPUDramaResponse().setContentId((String) data.get(com.huawei.openalliance.ad.constant.as.f32246u)).setSubVideoId((String) data.get("subVideoId")).setTitle((String) data.get("title")).setRepresent(((Integer) data.get("represent")).intValue()).setCoverImageUrl((String) data.get("coverImageUrl"));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            this.f10134s.onVideoCollect(cPUDramaResponse);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(IOAdEvent iOAdEvent) {
        if (this.f10134s != null) {
            CPUDramaResponse cPUDramaResponse = null;
            if (iOAdEvent != null) {
                try {
                    Map<String, Object> data = iOAdEvent.getData();
                    cPUDramaResponse = new CPUDramaResponse().setContentId((String) data.get(com.huawei.openalliance.ad.constant.as.f32246u)).setSubVideoId((String) data.get("subVideoId")).setTitle((String) data.get("title")).setRepresent(((Integer) data.get("represent")).intValue()).setCoverImageUrl((String) data.get("coverImageUrl"));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            this.f10134s.onVideoPlay(cPUDramaResponse);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void a(int i10, String str) {
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void a(IOAdEvent iOAdEvent) {
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void b(String str, int i10) {
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void e(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.f10134s == null || iOAdEvent == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        Object obj = data.get("adType");
        if (obj instanceof String) {
            this.f10134s.onADExposed(CPUAdType.parse((String) obj));
        }
    }

    public void f() {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "refresh");
        } catch (JSONException e2) {
            bs.a().a(e2);
        }
        a(jSONObject, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void h(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.f10134s == null || iOAdEvent == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        Object obj = data.get("adType");
        if (obj instanceof String) {
            this.f10134s.onAdClick(CPUAdType.parse((String) obj));
        }
    }

    public Fragment b(com.baidu.mobads.sdk.internal.a.e eVar) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "getSupportFragment");
            a(jSONObject, hashMap);
            Object obj = hashMap.get("frag");
            if (!(obj instanceof FragmentV4Delegate)) {
                return null;
            }
            FragmentV4Delegate fragmentV4Delegate = (FragmentV4Delegate) obj;
            fragmentV4Delegate.setProxy(eVar);
            return fragmentV4Delegate;
        } catch (JSONException e2) {
            bs.a().a(e2);
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void a() {
        HashMap hashMap;
        String str;
        Object remove;
        String str2;
        if (this.f9881k != null && this.f10131a != null) {
            this.f9882l = true;
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(IAdInterListener.AdReqParam.PROD, "cpu_drama");
                this.f9881k.createProdHandler(jSONObject3);
                n();
                cz czVar = new cz(this);
                this.f9881k.addEventListener("onContentLoaded", czVar);
                this.f9881k.addEventListener("onContentFailed", czVar);
                this.f9881k.addEventListener(x.f10416ar, czVar);
                this.f9881k.addEventListener(x.as, czVar);
                hashMap = new HashMap(this.f10131a.getExtras());
                str = (String) hashMap.remove("subChannelId");
                remove = hashMap.remove("dramaDetailConfig");
                str2 = (String) hashMap.remove("appsid");
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                jSONObject.put(IAdInterListener.AdReqParam.PROD, "cpu_drama");
                jSONObject.put("subChannelId", str);
                jSONObject.put("appid", str2);
                jSONObject.put("isDramaListRequest", this.f10133r);
                CPUDramaResponse cPUDramaResponse = this.f10132q;
                if (cPUDramaResponse != null) {
                    jSONObject.put("dramaContentId", cPUDramaResponse.getDramaContentId());
                    jSONObject.put("dramaSubVideoId", this.f10132q.getDramaSubVideoId());
                    jSONObject.put("dramaRepresent", this.f10132q.getRepresent());
                }
                jSONObject2 = k.a((HashMap<String, Object>) hashMap);
                if (remove instanceof CPUDramaDetailConfig) {
                    jSONObject2.put("freeCount", ((CPUDramaDetailConfig) remove).mFreeCount);
                    jSONObject2.put("unLockCount", ((CPUDramaDetailConfig) remove).mUnLockCount);
                }
                this.f9881k.loadAd(jSONObject, jSONObject2);
                return;
            }
            CPUDramaListener cPUDramaListener = this.f10134s;
            if (cPUDramaListener != null) {
                cPUDramaListener.onContentFailed(-2, "短剧请求缺少sid 或 scid！");
            }
            aw.c().e("短剧请求缺少sid 或 scid！");
            return;
        }
        this.f9882l = false;
        CPUDramaListener cPUDramaListener2 = this.f10134s;
        if (cPUDramaListener2 != null) {
            cPUDramaListener2.onContentFailed(-2, "短剧请求缺少必要参数！");
        }
        aw.c().e("短剧请求缺少必要参数！");
    }

    public cy(Context context, CPUDramaRequestParams cPUDramaRequestParams, CPUDramaResponse cPUDramaResponse, CPUDramaListener cPUDramaListener) {
        super(context);
        this.f10131a = cPUDramaRequestParams;
        this.f10132q = cPUDramaResponse;
        this.f10134s = cPUDramaListener;
        this.f10133r = false;
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void f(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.f10134s == null || iOAdEvent == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        Object obj = data.get("adType");
        if (obj instanceof String) {
            this.f10134s.onADExposureFailed(CPUAdType.parse((String) obj));
        }
    }

    public android.app.Fragment a(com.baidu.mobads.sdk.internal.a.e eVar) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "getFragment");
            a(jSONObject, hashMap);
            Object obj = hashMap.get("frag");
            if (!(obj instanceof FragmentDelegate)) {
                return null;
            }
            FragmentDelegate fragmentDelegate = (FragmentDelegate) obj;
            fragmentDelegate.setProxy(eVar);
            return fragmentDelegate;
        } catch (JSONException e2) {
            bs.a().a(e2);
            return null;
        }
    }
}
