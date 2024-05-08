package com.bytedance.sdk.openadsdk.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Pair;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Loader;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.downloadnew.core.DownloadBridgeFactory;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.MediationTTLiveTokenInjectionAuthImpl;
import com.bytedance.sdk.openadsdk.mediation.bridge.init.MediationInitCLassLoader;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class m {
    private static volatile boolean dk;

    /* renamed from: m, reason: collision with root package name */
    private TTAdSdk.InitCallback f11076m;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface dk<T> {
        void m(T t2);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static abstract class ej implements TTAdManager {
        private List<WeakReference<dk<Manager>>> dk = new ArrayList();

        /* renamed from: m, reason: collision with root package name */
        private volatile Manager f11079m;

        /* renamed from: com.bytedance.sdk.openadsdk.api.m$ej$1, reason: invalid class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public class AnonymousClass1 extends AbstractC0127m<Loader> {
            public final dk<Manager> dk;
            public final /* synthetic */ SoftReference ej;

            /* renamed from: m, reason: collision with root package name */
            public Loader f11082m;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(SoftReference softReference) {
                super();
                this.ej = softReference;
                this.dk = new dk<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.m.ej.1.1
                    @Override // com.bytedance.sdk.openadsdk.api.m.dk
                    public void m(Manager manager) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        anonymousClass1.f11082m = manager.createLoader((Context) anonymousClass1.ej.get());
                    }
                };
            }

            @Override // com.bytedance.sdk.openadsdk.api.m.AbstractC0127m
            public void m(final dk<Loader> dkVar, int i10) {
                Loader loader = this.f11082m;
                if (loader != null) {
                    dkVar.m(loader);
                } else {
                    ej.this.call(new dk<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.m.ej.1.2
                        @Override // com.bytedance.sdk.openadsdk.api.m.dk
                        public void m(Manager manager) {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            ej.this.m(anonymousClass1.dk);
                            AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                            anonymousClass12.f11082m = manager.createLoader((Context) anonymousClass12.ej.get());
                            dkVar.m(AnonymousClass1.this.f11082m);
                        }
                    }, i10 + 10000);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(final dk<Manager> dkVar, final int i10) {
            if (this.f11079m != null) {
                try {
                    dkVar.m(this.f11079m);
                    return;
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.api.ej.l("_tt_ad_sdk_", "Unexpected manager call error: " + th.getMessage());
                    m(th);
                    return;
                }
            }
            com.bytedance.sdk.openadsdk.np.m.m().m(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.m.ej.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (ej.this.f11079m != null) {
                            dkVar.m(ej.this.f11079m);
                        } else {
                            com.bytedance.sdk.openadsdk.api.ej.l("_tt_ad_sdk_", "Not ready, no manager: " + i10);
                        }
                    } catch (Throwable th2) {
                        com.bytedance.sdk.openadsdk.api.ej.l("_tt_ad_sdk_", "Unexpected manager call error: " + th2.getMessage());
                        ej.this.m(th2);
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T dk(Manager manager, Class<T> cls, Bundle bundle) {
            return (T) manager.getBridge(1).call(6, a.c(2).h(9, cls).h(10, bundle).a(), cls);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public TTAdNative createAdNative(Context context) {
            np npVar = new np(new AnonymousClass1(new SoftReference(context)));
            if (m.dk) {
                return npVar.m();
            }
            throw new IllegalStateException("请在load(请求广告）之前，先调用 start 方法以采集广告预估所需参数，以避免必要参数缺失无法请求广告");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getBiddingToken(AdSlot adSlot) {
            return getBiddingToken(adSlot, false, adSlot.getAdType() > 0 ? adSlot.getAdType() : adSlot.getNativeAdType());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public <T> T getExtra(final Class<T> cls, final Bundle bundle) {
            if (this.f11079m != null) {
                return (T) dk(this.f11079m, cls, bundle);
            }
            call(new dk<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.m.ej.4
                @Override // com.bytedance.sdk.openadsdk.api.m.dk
                public void m(Manager manager) {
                    ej.dk(ej.this.f11079m, cls, bundle);
                }
            }, 6);
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getPluginVersion() {
            return this.f11079m != null ? this.f11079m.values().stringValue(12) : "";
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getSDKVersion() {
            return "5.6.0.3";
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public int getThemeStatus() {
            if (this.f11079m != null) {
                return this.f11079m.values().intValue(11);
            }
            return 0;
        }

        public Object m(Object obj) {
            return obj;
        }

        public void m(Throwable th) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void register(final Object obj) {
            call(new dk<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.m.ej.2
                @Override // com.bytedance.sdk.openadsdk.api.m.dk
                public void m(Manager manager) {
                    manager.getBridge(1).call(4, a.c(1).h(8, ej.this.m(obj)).a(), Void.class);
                }
            }, 4);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void requestPermissionIfNecessary(final Context context) {
            call(new dk<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.m.ej.5
                @Override // com.bytedance.sdk.openadsdk.api.m.dk
                public void m(Manager manager) {
                    manager.getBridge(1).call(3, a.c(1).h(7, context).a(), Void.class);
                }
            }, 3);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void setThemeStatus(final int i10) {
            call(new dk<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.m.ej.6
                @Override // com.bytedance.sdk.openadsdk.api.m.dk
                public void m(Manager manager) {
                    manager.getBridge(1).call(1, a.b().f(11, i10).a(), Void.class);
                }
            }, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public boolean tryShowInstallDialogWhenExit(Activity activity, ExitInstallListener exitInstallListener) {
            HashMap hashMap = new HashMap();
            hashMap.put("activity", activity);
            hashMap.put(TTDownloadField.TT_EXIT_INSTALL_LISTENER, exitInstallListener);
            return ((Boolean) DownloadBridgeFactory.getDownloadBridge(TTAppContextHolder.getContext()).call(0, a.c(1).h(0, hashMap).a(), Boolean.class)).booleanValue();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void unregister(final Object obj) {
            call(new dk<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.m.ej.3
                @Override // com.bytedance.sdk.openadsdk.api.m.dk
                public void m(Manager manager) {
                    manager.getBridge(1).call(5, a.c(1).h(8, obj).a(), Void.class);
                }
            }, 5);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getBiddingToken(AdSlot adSlot, boolean z10, int i10) {
            if (i10 <= 0) {
                i10 = adSlot.getAdType() > 0 ? adSlot.getAdType() : adSlot.getNativeAdType();
            }
            ValueSet a10 = a.k(com.bytedance.sdk.openadsdk.ej.m.ej.dk.dk(adSlot)).j(13, z10).f(14, i10).a();
            if (this.f11079m != null) {
                return (String) this.f11079m.getBridge(1).call(2, a10, String.class);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m(Manager manager) {
            this.f11079m = manager;
            if (this.f11079m != null) {
                Iterator<WeakReference<dk<Manager>>> iterator2 = this.dk.iterator2();
                while (iterator2.hasNext()) {
                    WeakReference<dk<Manager>> next = iterator2.next();
                    dk<Manager> dkVar = next != null ? next.get() : null;
                    if (dkVar != null) {
                        dkVar.m(manager);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m(dk<Manager> dkVar) {
            this.dk.add(new WeakReference<>(dkVar));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class l implements EventListener {
        private l() {
        }

        @Override // com.bykv.vk.openvk.api.proto.EventListener
        public ValueSet onEvent(int i10, Result result) {
            m.this.dk(result);
            return null;
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.api.m$m, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static abstract class AbstractC0127m<T> {
        private AbstractC0127m() {
        }

        public abstract void m(dk<T> dkVar, int i10);

        public void m(Throwable th) {
        }
    }

    public abstract ej dk();

    public abstract void dk(Context context, a aVar);

    public void dk(Result result) {
        m(result);
        if (result.isSuccess()) {
            com.bytedance.sdk.openadsdk.api.ej.dk("_tt_ad_sdk_", "init sdk success ");
            TTAdSdk.InitCallback initCallback = this.f11076m;
            if (initCallback != null) {
                initCallback.success();
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.api.ej.np("_tt_ad_sdk_", "int sdk failed, code: " + result.code() + ", message: " + result.message());
        TTAdSdk.InitCallback initCallback2 = this.f11076m;
        if (initCallback2 != null) {
            initCallback2.fail(result.code(), result.message() != null ? result.message() : "");
        }
    }

    public boolean dk(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        return false;
    }

    public abstract com.bytedance.sdk.openadsdk.m.dk ej();

    public void m(final Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        dk = true;
        com.bytedance.sdk.openadsdk.m.ej.m().m(ej());
        this.f11076m = initCallback;
        if (dk(context, adConfig, initCallback)) {
            final a k10 = a.k(com.bytedance.sdk.openadsdk.ej.m.ej.m.m(adConfig));
            k10.g(1, SystemClock.elapsedRealtime());
            k10.i(5, "main");
            k10.j(4, true);
            k10.f(6, 999);
            k10.f(10, 5603);
            k10.i(11, "5.6.0.3");
            k10.i(12, "com.byted.pangle.m");
            k10.j(14, false);
            k10.h(16, com.bytedance.sdk.openadsdk.m.ej.m());
            Thread currentThread = Thread.currentThread();
            k10.i(2, currentThread.getName());
            k10.f(3, currentThread.getPriority());
            k10.h(15, new l());
            k10.h(8301, new MediationInitCLassLoader());
            if (adConfig instanceof TTAdConfig) {
                k10.h(8318, new MediationTTLiveTokenInjectionAuthImpl(((TTAdConfig) adConfig).getInjectionAuth()));
            }
            if (adConfig != null) {
                MediationApiLog.setDebug(Boolean.valueOf(adConfig.isDebug()));
            }
            if (m(context, k10)) {
                return;
            }
            com.bytedance.sdk.openadsdk.np.m.m().m(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.m.1
                @Override // java.lang.Runnable
                public void run() {
                    m.this.dk(context, k10);
                }
            });
        }
    }

    public void m(Result result) {
    }

    public abstract boolean m();

    public abstract boolean m(Context context, a aVar);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class np extends com.bytedance.sdk.openadsdk.ej.m.m {

        /* renamed from: m, reason: collision with root package name */
        private AbstractC0127m<Loader> f11094m;

        public np(AbstractC0127m<Loader> abstractC0127m) {
            this.f11094m = abstractC0127m;
        }

        private void m(dk<Loader> dkVar, int i10) {
            try {
                com.bytedance.sdk.openadsdk.api.ej.dk("_tt_ad_sdk_", "load ad slot type: " + i10);
                this.f11094m.m(dkVar, i10);
            } catch (Throwable th) {
                this.f11094m.m(th);
                throw th;
            }
        }

        @Override // com.bytedance.sdk.openadsdk.ej.m.m
        public void dk(final ValueSet valueSet, final Bridge bridge) {
            m(new dk<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.m.np.3
                @Override // com.bytedance.sdk.openadsdk.api.m.dk
                public void m(Loader loader) {
                    loader.load(6, a.k(valueSet).h(1, bridge).a(), null);
                }
            }, 6);
        }

        @Override // com.bytedance.sdk.openadsdk.ej.m.m
        public void e(final ValueSet valueSet, final Bridge bridge) {
            m(new dk<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.m.np.10
                @Override // com.bytedance.sdk.openadsdk.api.m.dk
                public void m(Loader loader) {
                    loader.load(9, a.k(valueSet).j(2, true).h(1, bridge).a(), null);
                }
            }, 9);
        }

        @Override // com.bytedance.sdk.openadsdk.ej.m.m
        public void ej(final ValueSet valueSet, final Bridge bridge) {
            m(new dk<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.m.np.4
                @Override // com.bytedance.sdk.openadsdk.api.m.dk
                public void m(Loader loader) {
                    loader.load(9, a.k(valueSet).h(1, bridge).a(), null);
                }
            }, 9);
        }

        @Override // com.bytedance.sdk.openadsdk.ej.m.m
        public void hc(final ValueSet valueSet, final Bridge bridge) {
            m(new dk<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.m.np.9
                @Override // com.bytedance.sdk.openadsdk.api.m.dk
                public void m(Loader loader) {
                    loader.load(5, a.k(valueSet).j(2, true).h(1, bridge).a(), null);
                }
            }, 5);
        }

        @Override // com.bytedance.sdk.openadsdk.ej.m.m
        public void l(final ValueSet valueSet, final Bridge bridge) {
            m(new dk<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.m.np.5
                @Override // com.bytedance.sdk.openadsdk.api.m.dk
                public void m(Loader loader) {
                    loader.load(1, a.k(valueSet).h(1, bridge).a(), null);
                }
            }, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.ej.m.m
        public void n(final ValueSet valueSet, final Bridge bridge) {
            m(new dk<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.m.np.8
                @Override // com.bytedance.sdk.openadsdk.api.m.dk
                public void m(Loader loader) {
                    loader.load(8, a.k(valueSet).h(1, bridge).a(), null);
                }
            }, 8);
        }

        @Override // com.bytedance.sdk.openadsdk.ej.m.m
        public void np(final ValueSet valueSet, final Bridge bridge) {
            m(new dk<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.m.np.7
                @Override // com.bytedance.sdk.openadsdk.api.m.dk
                public void m(Loader loader) {
                    loader.load(7, a.k(valueSet).h(1, bridge).a(), null);
                }
            }, 7);
        }

        @Override // com.bytedance.sdk.openadsdk.ej.m.m
        public void w(final ValueSet valueSet, final Bridge bridge) {
            m(new dk<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.m.np.2
                @Override // com.bytedance.sdk.openadsdk.api.m.dk
                public void m(Loader loader) {
                    loader.load(1, a.k(valueSet).j(2, true).h(1, bridge).a(), null);
                }
            }, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.ej.m.m
        public void m(final ValueSet valueSet, final Bridge bridge) {
            m(new dk<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.m.np.1
                @Override // com.bytedance.sdk.openadsdk.api.m.dk
                public void m(Loader loader) {
                    loader.load(5, a.k(valueSet).h(1, bridge).a(), null);
                }
            }, 5);
        }

        @Override // com.bytedance.sdk.openadsdk.ej.m.m
        public void m(final ValueSet valueSet, final Bridge bridge, final int i10) {
            m(new dk<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.m.np.6
                @Override // com.bytedance.sdk.openadsdk.api.m.dk
                public void m(Loader loader) {
                    loader.load(3, a.k(valueSet).f(3, i10).h(1, bridge).a(), null);
                }
            }, 3);
        }

        @Override // com.bytedance.sdk.openadsdk.ej.m.m
        public Pair<Integer, String> m(Exception exc) {
            com.bytedance.sdk.openadsdk.api.ej.l("_tt_ad_sdk_", "Load ad failed: " + exc.getMessage());
            return new Pair<>(Integer.valueOf(TTAdConstant.INIT_FAILED_CREATE_INVOKE_FAILED), "Load ad failed: " + exc.getMessage());
        }
    }

    public void m(Manager manager) {
        com.bytedance.sdk.openadsdk.api.ej.dk("_tt_ad_sdk_", "update manager");
        dk().m(manager);
        dk().register(com.bytedance.sdk.openadsdk.m.ej.m());
    }
}
