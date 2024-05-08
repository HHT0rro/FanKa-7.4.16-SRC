package com.bytedance.sdk.openadsdk.live;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.android.live.base.api.ILiveHostContextParam;
import com.bytedance.android.live.base.api.ILiveInitCallback;
import com.bytedance.android.live.base.api.IOuterLiveRoomService;
import com.bytedance.android.live.base.api.MethodChannelService;
import com.bytedance.android.openliveplugin.LivePluginHelper;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.api.ej;
import com.bytedance.sdk.openadsdk.ej.m.m.w;
import com.bytedance.sdk.openadsdk.live.core.TTHostPermissionInner;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import o0.a;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class dk implements Bridge {

    /* renamed from: m, reason: collision with root package name */
    private static final dk f11219m = new dk();
    private ITTLiveTokenInjectionAuth dk;
    private Bridge ej;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class m implements Bridge {

        /* renamed from: m, reason: collision with root package name */
        private ILiveAdCustomConfig f11223m;

        public m(ILiveAdCustomConfig iLiveAdCustomConfig) {
            this.f11223m = iLiveAdCustomConfig;
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
            if (i10 == 0) {
                return (T) Integer.valueOf(this.f11223m.openLR(valueSet.stringValue(0)));
            }
            if (i10 == 1) {
                return (T) this.f11223m.convertToEnterFromMerge(valueSet.intValue(0));
            }
            if (i10 == 2) {
                return (T) this.f11223m.convertToEnterMethod(valueSet.intValue(0), valueSet.booleanValue(1));
            }
            if (i10 == 3) {
                return (T) this.f11223m.invoke(valueSet.intValue(0), (Bundle) valueSet.objectValue(1, Bundle.class));
            }
            if (i10 != 4) {
                return null;
            }
            this.f11223m.onEventV3(valueSet.stringValue(0), (JSONObject) valueSet.objectValue(1, JSONObject.class));
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return a.b().f(10000, 1).a();
        }
    }

    private dk() {
    }

    private void dk(Map map) {
        ILiveHostContextParam.Builder hostActionParam = new ILiveHostContextParam.Builder().setAppName(String.valueOf(map.get("app_name"))).setChannel(String.valueOf(map.get(TTLiveConstants.INIT_CHANNEL))).setIsDebug(Boolean.valueOf(String.valueOf(map.get("debug"))).booleanValue()).setECHostAppId(String.valueOf(map.get(TTLiveConstants.INIT_EC_HOST_APPID))).setPartner(String.valueOf(map.get("partner"))).provideMethodChannel(new MethodChannelService() { // from class: com.bytedance.sdk.openadsdk.live.dk.1
            @Override // com.bytedance.android.live.base.api.MethodChannelService
            public String identity() {
                return MediationConstant.ADN_PANGLE;
            }

            @Override // com.bytedance.android.live.base.api.MethodChannelService
            public Object invokeMethod(String str, Object... objArr) {
                if (dk.this.ej != null) {
                    return dk.this.ej.call(0, a.b().i(0, str).h(1, objArr).a(), Object.class);
                }
                return null;
            }
        }).setPartnerSecret(TTLiveConstants.INIT_PARTENER_SECERET).setHostPermission(new TTHostPermissionInner(m(map))).setHostActionParam(new com.bytedance.sdk.openadsdk.live.core.m(this.ej));
        ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth = this.dk;
        if (iTTLiveTokenInjectionAuth != null) {
            hostActionParam.setInjectionAuth(new com.bytedance.sdk.openadsdk.live.core.dk(iTTLiveTokenInjectionAuth));
        }
        ILiveInitCallback iLiveInitCallback = new ILiveInitCallback() { // from class: com.bytedance.sdk.openadsdk.live.dk.2
            @Override // com.bytedance.android.live.base.api.ILiveInitCallback
            public final void onLiveInitFinish() {
                ej.dk("TTLiveSDkBridge", "onLiveInitFinish!");
                com.bytedance.sdk.openadsdk.live.m.m();
                if (dk.this.ej != null) {
                    dk.this.ej.call(2, a.b().f(0, 2).a(), null);
                }
            }
        };
        if (TTAppContextHolder.getContext() instanceof Application) {
            hostActionParam.setContext((Application) TTAppContextHolder.getContext());
        }
        ej.dk("TTLiveSDkBridge", "execute live sdk initLive method end, (方法顺利执行结果)result: " + com.bytedance.sdk.openadsdk.live.m.m(TTAppContextHolder.getContext(), String.valueOf(map.get(TTLiveConstants.INIT_GENERATE_APPID)), hostActionParam, iLiveInitCallback));
    }

    private Boolean ej(Map<String, Object> map) {
        try {
            String str = (String) map.get(TTLiveConstants.SCHEME_URI_KEY);
            if (TextUtils.isEmpty(str)) {
                return Boolean.FALSE;
            }
            Context context = getContext(map.get("context"));
            Uri parse = Uri.parse(str);
            if (parse != null && context != null) {
                return Boolean.valueOf(com.bytedance.sdk.openadsdk.live.m.m(context, parse));
            }
            return Boolean.FALSE;
        } catch (Throwable th) {
            ej.m("TTLiveSDkBridge", th);
            return Boolean.FALSE;
        }
    }

    private Context getContext(Object obj) {
        if (obj instanceof Context) {
            return (Context) obj;
        }
        return null;
    }

    private Object l(Map<String, Object> map) {
        try {
            String str = (String) map.get(TTLiveConstants.EXPAND_METHOD_NAME_KEY);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            IOuterLiveRoomService liveRoomService = LivePluginHelper.getLiveRoomService();
            Object[] objArr = (Object[]) map.get(TTLiveConstants.EXPAND_METHOD_PARAM_KEY);
            if (objArr != null) {
                return liveRoomService.callExpandMethod(str, objArr);
            }
            return liveRoomService.callExpandMethod(str, new Object[0]);
        } catch (Throwable th) {
            ej.m("TTLiveSDkBridge", th);
            return null;
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        if (i10 != 5) {
            if (i10 == 9) {
                this.ej = (Bridge) valueSet.objectValue(0, Bridge.class);
                Bridge bridge = (Bridge) com.bytedance.sdk.openadsdk.m.ej.m().call(10, a.c(1).f(0, 4).a(), Bridge.class);
                if (bridge != null) {
                    bridge.call(106, a.c(1).h(0, new TTPluginListener() { // from class: com.bytedance.sdk.openadsdk.live.dk.3
                        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
                        public Bundle config() {
                            return null;
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
                        public void onPluginListener(int i11, ClassLoader classLoader, Resources resources, Bundle bundle) {
                            if (dk.this.ej != null) {
                                dk.this.ej.call(3, a.b().f(0, i11).h(1, classLoader).h(2, resources).h(3, bundle).a(), null);
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
                        public String packageName() {
                            return "com.byted.live.lite";
                        }
                    }).a(), Void.class);
                }
            }
            return (T) m(cls, i10, (Map) valueSet.objectValue(0, Map.class));
        }
        dk((Map) valueSet.objectValue(0, Map.class));
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return a.b().f(10000, 2).a();
    }

    public static dk m() {
        return f11219m;
    }

    public void m(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
        this.dk = iTTLiveTokenInjectionAuth;
    }

    private TTCustomController m(Map map) {
        Object obj = map.get(TTLiveConstants.INIT_CUSTOM_CONTROLLER);
        if (obj instanceof Bridge) {
            return new w((Bridge) obj);
        }
        return null;
    }

    public <T> T m(Class<T> cls, int i10, Map<String, Object> map) {
        if (i10 == 0) {
            if (!com.bytedance.sdk.openadsdk.live.m.m(getContext(map.get("context")), m(map.get(TTLiveConstants.BUNDLE_KEY)))) {
                return (T) 2;
            }
            return (T) 0;
        }
        if (i10 == 7) {
            return (T) l(map);
        }
        if (i10 != 8) {
            return null;
        }
        return (T) ej(map);
    }

    private Bundle m(Object obj) {
        if (obj instanceof Bundle) {
            return (Bundle) obj;
        }
        return null;
    }

    public static Bridge m(ILiveAdCustomConfig iLiveAdCustomConfig) {
        return new m(iLiveAdCustomConfig);
    }
}
