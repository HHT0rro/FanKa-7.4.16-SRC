package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.mobads.sdk.api.IBasicCPUData;
import com.baidu.mobads.sdk.internal.ae;
import com.baidu.mobads.sdk.internal.ao;
import com.baidu.mobads.sdk.internal.aq;
import com.baidu.mobads.sdk.internal.ar;
import com.baidu.mobads.sdk.internal.as;
import com.baidu.mobads.sdk.internal.aw;
import com.baidu.mobads.sdk.internal.br;
import com.baidu.mobads.sdk.internal.x;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class NativeCPUAdData implements IBasicCPUData, Observer {
    private static final String CLASS_NAME = x.f10427l;
    private final ClassLoader classLoader;
    private IBasicCPUData.CpuNativeStatusCB mCpuNativeStatusCBListener;
    private final Context mCtx;
    public Object mInstance;
    private final HashMap<String, Object> mSettings;
    public ar remoteUtils;

    public NativeCPUAdData(Context context, Object obj, HashMap<String, Object> hashMap) {
        this.mCtx = context;
        this.mInstance = obj;
        this.mSettings = hashMap;
        this.remoteUtils = ar.a(context, CLASS_NAME);
        this.classLoader = br.a(context);
    }

    private String getAdid() {
        return this.remoteUtils.c(this.mInstance, "getAdid", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCanClickView(View view) {
        HashMap<String, Object> hashMap = this.mSettings;
        if (hashMap != null) {
            this.remoteUtils.a(this.mInstance, "setConfigParams", hashMap);
        }
        if (view instanceof CpuVideoView) {
            this.remoteUtils.a(this.mInstance, "handClickVideo", 1, 0);
        } else if (view instanceof TextView) {
            this.remoteUtils.a(this.mInstance, "handClickVideo", 2, 0);
        }
        this.remoteUtils.a(this.mInstance, "handleCanClickView", view);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void cancelAppDownload() {
        if (this.mCtx == null || !isNeedDownloadApp()) {
            return;
        }
        aq.a(this.mCtx.getApplicationContext()).b(getAppPackageName());
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void clickHotItem(View view) {
        this.remoteUtils.a(this.mInstance, "clickHotItem", view);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getActionType() {
        Object b4 = this.remoteUtils.b(this.mInstance, "getActionType", new Object[0]);
        if (b4 instanceof Integer) {
            return ((Integer) b4).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getAdHeight() {
        Object b4 = this.remoteUtils.b(this.mInstance, "getAdHeight", new Object[0]);
        if (b4 instanceof Integer) {
            return ((Integer) b4).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getAdLogoUrl() {
        Object b4 = this.remoteUtils.b(this.mInstance, "getAdLogoUrl", new Object[0]);
        return b4 instanceof String ? (String) b4 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getAdWidth() {
        Object b4 = this.remoteUtils.b(this.mInstance, "getAdWidth", new Object[0]);
        if (b4 instanceof Integer) {
            return ((Integer) b4).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getAppPackageName() {
        Object b4 = this.remoteUtils.b(this.mInstance, "getPackageName", new Object[0]);
        return b4 instanceof String ? (String) b4 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getAppPermissionUrl() {
        return this.remoteUtils.c(this.mInstance, "getAppPermissionUrl", new Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getAppPrivacyUrl() {
        return this.remoteUtils.c(this.mInstance, "getAppPrivacyUrl", new Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getAppPublisher() {
        return this.remoteUtils.c(this.mInstance, "getAppPublisher", new Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getAppVersion() {
        return this.remoteUtils.c(this.mInstance, "getAppVersion", new Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getAttribute() {
        Object b4 = this.remoteUtils.b(this.mInstance, "getAttribute", new Object[0]);
        if (b4 instanceof Integer) {
            return ((Integer) b4).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getAuthor() {
        Object b4 = this.remoteUtils.b(this.mInstance, "getAuthor", new Object[0]);
        return b4 instanceof String ? (String) b4 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getBaiduLogoUrl() {
        Object b4 = this.remoteUtils.b(this.mInstance, "getBaiduLogoUrl", new Object[0]);
        return b4 instanceof String ? (String) b4 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getBrandName() {
        Object b4 = this.remoteUtils.b(this.mInstance, "getBrandName", new Object[0]);
        return b4 instanceof String ? (String) b4 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getChannelId() {
        Object b4 = this.remoteUtils.b(this.mInstance, "getCatId", new Object[0]);
        return b4 instanceof String ? (String) b4 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getChannelName() {
        Object b4 = this.remoteUtils.b(this.mInstance, "getCatName", new Object[0]);
        return b4 instanceof String ? (String) b4 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getCommentCounts() {
        Object b4 = this.remoteUtils.b(this.mInstance, "getCommentCounts", new Object[0]);
        if (b4 instanceof Integer) {
            return ((Integer) b4).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public List<Integer> getContentAttributesList() {
        Object b4 = this.remoteUtils.b(this.mInstance, "getContentAttributesList", new Object[0]);
        if (b4 instanceof List) {
            return (List) b4;
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getContentClickUrl() {
        Object b4 = this.remoteUtils.b(this.mInstance, "getContentClickUrl", new Object[0]);
        return b4 instanceof String ? (String) b4 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public long getCtime() {
        Object b4 = this.remoteUtils.b(this.mInstance, "getCtime", new Object[0]);
        if (b4 instanceof Long) {
            return ((Long) b4).longValue();
        }
        return 0L;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getDesc() {
        Object b4 = this.remoteUtils.b(this.mInstance, "getContent", new Object[0]);
        return b4 instanceof String ? (String) b4 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public JSONArray getDislikeReasons() {
        return (JSONArray) this.remoteUtils.b(this.mInstance, "getDislikeReasons", new Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getDownloadStatus() {
        Object b4 = this.remoteUtils.b(this.mInstance, "getDownloadStatus", new Object[0]);
        if (b4 instanceof Integer) {
            return ((Integer) b4).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getDuration() {
        Object b4 = this.remoteUtils.b(this.mInstance, "getDuration", new Object[0]);
        if (b4 instanceof Integer) {
            return ((Integer) b4).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public JSONObject getExtra() {
        return (JSONObject) this.remoteUtils.b(this.mInstance, "getExtra", new Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public long getHotId() {
        Object b4 = this.remoteUtils.b(this.mInstance, "getHotId", new Object[0]);
        if (b4 instanceof Long) {
            return ((Long) b4).longValue();
        }
        return 0L;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getHotWord() {
        return this.remoteUtils.c(this.mInstance, "getHotWord", new Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getIconUrl() {
        Object b4 = this.remoteUtils.b(this.mInstance, "getAvatar", new Object[0]);
        return b4 instanceof String ? (String) b4 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getImage() {
        return this.remoteUtils.c(this.mInstance, "getImage", new Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public List<String> getImageUrls() {
        Object b4 = this.remoteUtils.b(this.mInstance, "getImageList", new Object[0]);
        if (b4 instanceof List) {
            return (List) b4;
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getLabel() {
        return this.remoteUtils.c(this.mInstance, "getLabel", new Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getPlayCounts() {
        Object b4 = this.remoteUtils.b(this.mInstance, "getPlayCounts", new Object[0]);
        if (b4 instanceof Integer) {
            return ((Integer) b4).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getPresentationType() {
        Object b4 = this.remoteUtils.b(this.mInstance, "getPresentationType", new Object[0]);
        if (b4 instanceof Integer) {
            return ((Integer) b4).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getReadCounts() {
        Object b4 = this.remoteUtils.b(this.mInstance, "getReadCounts", new Object[0]);
        if (b4 instanceof Integer) {
            return ((Integer) b4).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public double getScore() {
        Object b4 = this.remoteUtils.b(this.mInstance, "getScore", new Object[0]);
        return b4 instanceof Double ? ((Double) b4).doubleValue() : ShadowDrawableWrapper.COS_45;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public List<String> getSmallImageUrls() {
        Object b4 = this.remoteUtils.b(this.mInstance, "getSmallImageList", new Object[0]);
        if (b4 instanceof List) {
            return (List) b4;
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getStyleTypeCpu() {
        Object b4 = this.remoteUtils.b(this.mInstance, "getStyleTypeCpu", new Object[0]);
        if (b4 instanceof Integer) {
            return ((Integer) b4).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getThumbHeight() {
        Object b4 = this.remoteUtils.b(this.mInstance, "getThumbHeight", new Object[0]);
        if (b4 instanceof Integer) {
            return ((Integer) b4).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getThumbUrl() {
        Object b4 = this.remoteUtils.b(this.mInstance, "getThumbUrl", new Object[0]);
        return b4 instanceof String ? (String) b4 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getThumbWidth() {
        Object b4 = this.remoteUtils.b(this.mInstance, "getThumbWidth", new Object[0]);
        if (b4 instanceof Integer) {
            return ((Integer) b4).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getTitle() {
        Object b4 = this.remoteUtils.b(this.mInstance, "getTitle", new Object[0]);
        return b4 instanceof String ? (String) b4 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getType() {
        Object b4 = this.remoteUtils.b(this.mInstance, "getType", new Object[0]);
        return b4 instanceof String ? (String) b4 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getUpdateTime() {
        Object b4 = this.remoteUtils.b(this.mInstance, "getUpdateTime", new Object[0]);
        return b4 instanceof String ? (String) b4 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getVUrl() {
        Object b4 = this.remoteUtils.b(this.mInstance, "getVUrl", new Object[0]);
        return b4 instanceof String ? (String) b4 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void handleClick(View view, Object... objArr) {
        HashMap<String, Object> hashMap = this.mSettings;
        if (hashMap != null) {
            this.remoteUtils.a(this.mInstance, "setConfigParams", hashMap);
        }
        long j10 = 0;
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Long)) {
            j10 = ((Long) objArr[0]).longValue();
        }
        if (view instanceof CpuVideoView) {
            this.remoteUtils.a(this.mInstance, "handClickVideo", 1, Long.valueOf(j10));
        } else if (view instanceof TextView) {
            this.remoteUtils.a(this.mInstance, "handClickVideo", 2, Long.valueOf(j10));
        }
        this.remoteUtils.a(this.mInstance, "handleClick", view);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void handleCreativeView(View view) {
        HashMap<String, Object> hashMap = this.mSettings;
        if (hashMap != null) {
            this.remoteUtils.a(this.mInstance, "setConfigParams", hashMap);
        }
        if (view instanceof CpuVideoView) {
            this.remoteUtils.a(this.mInstance, "handClickVideo", 1, 0);
        } else if (view instanceof TextView) {
            this.remoteUtils.a(this.mInstance, "handClickVideo", 2, 0);
        }
        this.remoteUtils.a(this.mInstance, "handleCreativeView", view);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void handleDislikeClick(View view, int i10) {
        this.remoteUtils.a(this.mInstance, "handleDislikeClick", view, Integer.valueOf(i10));
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public boolean isAutoplay() {
        Object b4 = this.remoteUtils.b(this.mInstance, "isAutoplay", new Object[0]);
        if (b4 instanceof Boolean) {
            return ((Boolean) b4).booleanValue();
        }
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public boolean isCanGoLp() {
        Object b4 = this.remoteUtils.b(this.mInstance, "isCanGoLp", new Object[0]);
        if (b4 instanceof Boolean) {
            return ((Boolean) b4).booleanValue();
        }
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public boolean isNeedDownloadApp() {
        return ((Boolean) this.remoteUtils.b(this.mInstance, "isDownloadApp", new Object[0])).booleanValue();
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public boolean isTop() {
        Object b4 = this.remoteUtils.b(this.mInstance, "isTop", new Object[0]);
        if (b4 instanceof Boolean) {
            return ((Boolean) b4).booleanValue();
        }
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void markDislike(String[] strArr) {
        this.remoteUtils.a(this.mInstance, "markDislike", strArr);
    }

    public void monitorVisibleTime(View view) {
        HashMap<String, Object> hashMap = this.mSettings;
        if (hashMap != null) {
            this.remoteUtils.a(this.mInstance, "setConfigParams", hashMap);
        }
        this.remoteUtils.a(this.mInstance, "monitorVisibleTime", view);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void onImpression(View view) {
        HashMap<String, Object> hashMap = this.mSettings;
        if (hashMap != null) {
            this.remoteUtils.a(this.mInstance, "setConfigParams", hashMap);
        }
        this.remoteUtils.a(this.mInstance, "onImpression", view);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void pauseAppDownload() {
        if (this.mCtx == null || !isNeedDownloadApp()) {
            return;
        }
        aq.a(this.mCtx.getApplicationContext()).a(getAppPackageName());
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void registerViewForInteraction(View view, final List<View> list, List<View> list2, IBasicCPUData.CpuNativeStatusCB cpuNativeStatusCB) {
        setStatusListener(cpuNativeStatusCB);
        onImpression(view);
        monitorVisibleTime(view);
        if (list != null && list.size() > 0) {
            for (final View view2 : list) {
                if (view2 != null) {
                    view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mobads.sdk.api.NativeCPUAdData.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            NativeCPUAdData.this.handleCanClickView(view3);
                            view2.setClickable(false);
                            view2.postDelayed(new Runnable() { // from class: com.baidu.mobads.sdk.api.NativeCPUAdData.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    View view4 = view2;
                                    if (view4 != null) {
                                        view4.setClickable(true);
                                    }
                                }
                            }, 1000L);
                        }
                    });
                }
            }
        }
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        for (final View view3 : list2) {
            if (view3 != null) {
                view3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mobads.sdk.api.NativeCPUAdData.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view4) {
                        NativeCPUAdData.this.handleCreativeView(view4);
                        view3.setClickable(false);
                        view3.postDelayed(new Runnable() { // from class: com.baidu.mobads.sdk.api.NativeCPUAdData.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                if (list != null) {
                                    view3.setClickable(true);
                                }
                            }
                        }, 1000L);
                    }
                });
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void setStatusListener(final IBasicCPUData.CpuNativeStatusCB cpuNativeStatusCB) {
        this.mCpuNativeStatusCBListener = cpuNativeStatusCB;
        try {
            this.remoteUtils.a(this.mInstance, "setStatusListener", Proxy.newProxyInstance(this.classLoader, new Class[]{as.a(x.f10428m, this.classLoader)}, new InvocationHandler() { // from class: com.baidu.mobads.sdk.api.NativeCPUAdData.3
                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj, Method method, Object[] objArr) {
                    aw.h("NativeCPUAdData").c("invoke: " + method.getName());
                    if (cpuNativeStatusCB == null) {
                        return null;
                    }
                    String name = method.getName();
                    if ("onAdDownloadWindowShow".equals(name)) {
                        cpuNativeStatusCB.onAdDownloadWindowShow();
                    } else if ("onPermissionShow".equals(name)) {
                        cpuNativeStatusCB.onPermissionShow();
                    } else if ("onPermissionClose".equals(name)) {
                        cpuNativeStatusCB.onPermissionClose();
                    } else if ("onPrivacyClick".equals(name)) {
                        cpuNativeStatusCB.onPrivacyClick();
                    } else if ("onPrivacyLpClose".equals(name)) {
                        cpuNativeStatusCB.onPrivacyLpClose();
                    } else if ("onNotifyPerformance".equals(name)) {
                        if (objArr != null && objArr.length >= 1 && (objArr[0] instanceof String)) {
                            cpuNativeStatusCB.onNotifyPerformance((String) objArr[0]);
                        }
                    } else if ("startRouter".equals(name)) {
                        ao.a((Context) objArr[0], (String) objArr[1]);
                    }
                    return null;
                }
            }));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if ((observable instanceof ae) && this.mCpuNativeStatusCBListener != null && isNeedDownloadApp() && (obj instanceof IOAdEvent)) {
            IOAdEvent iOAdEvent = (IOAdEvent) obj;
            String message = iOAdEvent.getMessage();
            Map<String, Object> data = iOAdEvent.getData();
            if (data != null) {
                Object obj2 = data.get("adid");
                if ((obj2 instanceof String) && ((String) obj2).equals(getAdid())) {
                    this.mCpuNativeStatusCBListener.onAdStatusChanged(message, getDownloadStatus());
                }
            }
        }
    }
}
