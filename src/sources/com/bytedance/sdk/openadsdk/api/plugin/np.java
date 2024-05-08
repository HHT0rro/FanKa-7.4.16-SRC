package com.bytedance.sdk.openadsdk.api.plugin;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.Initializer;
import com.bykv.vk.openvk.api.proto.Result;
import com.bytedance.pangle.Zeus;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.api.m;
import com.bytedance.sdk.openadsdk.api.plugin.l;
import com.bytedance.sdk.openadsdk.live.ILiveAdCustomConfig;
import dalvik.system.BaseDexClassLoader;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import o0.a;
import o0.b;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class np extends com.bytedance.sdk.openadsdk.api.m {

    /* renamed from: m, reason: collision with root package name */
    private static final m f11133m = new m();
    private volatile Initializer dk;
    private ej ej;

    /* renamed from: l, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.m.dk f11134l = new com.bytedance.sdk.openadsdk.m.dk() { // from class: com.bytedance.sdk.openadsdk.api.plugin.np.1
        @Override // com.bytedance.sdk.openadsdk.m.dk
        public Bridge m(int i10) {
            return np.this.m(i10);
        }
    };

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class m extends m.ej {
        private m() {
        }

        @Override // com.bytedance.sdk.openadsdk.api.m.ej
        public void m(Throwable th) {
            l.m(th);
        }

        @Override // com.bytedance.sdk.openadsdk.api.m.ej
        public Object m(Object obj) {
            boolean z10 = obj instanceof TTPluginListener;
            if (z10) {
                l.m(TTAppContextHolder.getContext()).m((TTPluginListener) obj);
            }
            if (!z10) {
                return obj instanceof ILiveAdCustomConfig ? com.bytedance.sdk.openadsdk.live.dk.m((ILiveAdCustomConfig) obj) : obj;
            }
            TTPluginListener tTPluginListener = (TTPluginListener) obj;
            return l.m(TTAppContextHolder.getContext()).m(tTPluginListener.packageName(), tTPluginListener.config());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.m
    public boolean dk(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        super.dk(context, adConfig, initCallback);
        this.ej = ej.m("duration");
        dk.m(adConfig);
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.m
    public com.bytedance.sdk.openadsdk.m.dk ej() {
        return this.f11134l;
    }

    @Override // com.bytedance.sdk.openadsdk.api.m
    public void m(Result result) {
        if (result.isSuccess()) {
            Bundle bundle = new Bundle();
            bundle.putInt("action", 0);
            ExecutorService executorService = (ExecutorService) TTAdSdk.getAdManager().getExtra(ExecutorService.class, bundle);
            if (executorService != null) {
                com.bytedance.sdk.openadsdk.np.m.m().m(executorService);
            }
            dk.m();
            return;
        }
        dk.m(result.code(), result.message(), 0L);
    }

    @Override // com.bytedance.sdk.openadsdk.api.m
    public void dk(Context context, a aVar) {
        ej ejVar = this.ej;
        if (ejVar == null) {
            ejVar = ej.m("duration");
        }
        ejVar.dk("wait_asyn_cost");
        try {
            Initializer m10 = m(ejVar);
            try {
                if (m10 != null) {
                    m(m10.getManager());
                    try {
                        ejVar.m();
                        JSONObject jSONObject = new JSONObject();
                        ejVar.m(jSONObject, 20L);
                        jSONObject.put("zeus", l.m(TTAppContextHolder.getContext()).m());
                        m10.init(context, aVar.h(9, jSONObject).a());
                        if (context != null) {
                            Zeus.hookHuaWeiVerifier((Application) context.getApplicationContext());
                            return;
                        }
                        return;
                    } catch (Exception e2) {
                        Zeus.unInstallPlugin("com.byted.pangle.m");
                        dk(b.b().f(false).c(4207).e("Init error").a());
                        throw e2;
                    }
                }
                dk(b.b().f(false).c(TTAdConstant.INIT_FAILED_CREATE_INITIALIZER_FAILED).e("Init error").a());
            } catch (Throwable th) {
                th.printStackTrace();
                dk(b.b().f(false).c(4203).e("UnExpected initializer error :" + th.getMessage()).a());
            }
        } catch (com.bytedance.sdk.openadsdk.api.plugin.m e10) {
            e10.printStackTrace();
            dk(b.b().f(false).c(e10.m()).e(e10.getMessage()).a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bridge m(int i10) {
        if (i10 == 2) {
            return com.bytedance.sdk.openadsdk.live.dk.m();
        }
        if (i10 == 3) {
            return com.bytedance.sdk.openadsdk.downloadnew.l.m(TTAppContextHolder.getContext());
        }
        if (i10 != 4) {
            return null;
        }
        return com.bytedance.sdk.openadsdk.api.plugin.m.m.m();
    }

    @Override // com.bytedance.sdk.openadsdk.api.m
    public boolean m(Context context, a aVar) {
        if (this.dk == null) {
            return false;
        }
        this.dk.init(context, aVar.a());
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.m
    public boolean m() {
        if (this.dk != null) {
            return this.dk.isInitSuccess();
        }
        return false;
    }

    private Initializer m(ej ejVar) throws com.bytedance.sdk.openadsdk.api.plugin.m {
        if (this.dk == null) {
            synchronized (this) {
                if (this.dk == null) {
                    com.bytedance.sdk.openadsdk.api.ej.dk("TTPluginManager", "Create initializer");
                    this.dk = dk(ejVar);
                }
            }
        }
        return this.dk;
    }

    @Override // com.bytedance.sdk.openadsdk.api.m
    public m.ej dk() {
        return f11133m;
    }

    private static Initializer dk(ej ejVar) throws com.bytedance.sdk.openadsdk.api.plugin.m {
        try {
            ejVar.dk("call_create_initializer");
            BaseDexClassLoader m10 = l.m(TTAppContextHolder.getContext()).m(ejVar);
            if (m10 != null) {
                Class<?> loadClass = m10.loadClass(TTAdSdk.INITIALIZER_CLASS_NAME);
                ejVar.dk("get_init_class_cost");
                Bundle bundle = new Bundle();
                bundle.putSerializable(PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER, new l.ej());
                ejVar.dk("create_bundle_cost");
                Method declaredMethod = loadClass.getDeclaredMethod("getNewInstance", Bundle.class);
                ejVar.dk("get_init_method_cost");
                try {
                    Initializer initializer = (Initializer) declaredMethod.invoke(null, bundle);
                    ejVar.dk("get_init_instance_cost");
                    com.bytedance.sdk.openadsdk.api.ej.dk("TTPluginManager", "Create initializer success");
                    return initializer;
                } catch (Throwable th) {
                    Zeus.unInstallPlugin("com.byted.pangle.m");
                    throw th;
                }
            }
            throw new com.bytedance.sdk.openadsdk.api.plugin.m(4205, "Get initializer failed");
        } catch (Throwable th2) {
            if (th2 instanceof com.bytedance.sdk.openadsdk.api.plugin.m) {
                throw new com.bytedance.sdk.openadsdk.api.plugin.m(4205, "(" + th2.m() + ", " + th2.getMessage() + ")");
            }
            throw new com.bytedance.sdk.openadsdk.api.plugin.m(4206, th2.getMessage());
        }
    }
}
