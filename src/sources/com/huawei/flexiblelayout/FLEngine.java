package com.huawei.flexiblelayout;

import android.content.Context;
import android.util.ArrayMap;
import com.huawei.flexiblelayout.card.FLCell;
import com.huawei.flexiblelayout.card.FLNode;
import com.huawei.flexiblelayout.card.buildin.FLDivider;
import com.huawei.flexiblelayout.card.dnode.FLDNodeService;
import com.huawei.flexiblelayout.card.props.CardSpecHelper;
import com.huawei.flexiblelayout.card.snode.FLSNodeService;
import com.huawei.flexiblelayout.common.Debuggable;
import com.huawei.flexiblelayout.creator.CardResolver;
import com.huawei.flexiblelayout.creator.FLDefaultNodeResolver;
import com.huawei.flexiblelayout.creator.FLResolverRegistry;
import com.huawei.flexiblelayout.creator.NodeResolver;
import com.huawei.flexiblelayout.data.FLayoutSpec;
import com.huawei.flexiblelayout.script.ScriptConfigService;
import com.huawei.flexiblelayout.services.ServiceTokenProvider;
import com.huawei.flexiblelayout.services.action.CardActionService;
import com.huawei.flexiblelayout.services.analytics.AnalyticsService;
import com.huawei.flexiblelayout.services.configuration.ConfigurationService;
import com.huawei.flexiblelayout.services.effect.FLEffectService;
import com.huawei.flexiblelayout.services.exposure.CardExposureService;
import com.huawei.flexiblelayout.services.exposure.impl.CardExposureServiceImpl;
import com.huawei.flexiblelayout.services.imageloader.ImageLoaderService;
import com.huawei.flexiblelayout.services.loadmore.LoadMoreService;
import com.huawei.flexiblelayout.services.loadmore.impl.LoadMoreServiceImpl;
import com.huawei.flexiblelayout.services.safearea.SafeAreaService;
import com.huawei.flexiblelayout.services.task.TaskHandlerRegistryService;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FLEngine {

    /* renamed from: e, reason: collision with root package name */
    private static volatile FLEngine f27695e;

    /* renamed from: a, reason: collision with root package name */
    private final Context f27696a;

    /* renamed from: b, reason: collision with root package name */
    private final CardSpecHelper f27697b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, Object> f27698c = new ArrayMap();

    /* renamed from: d, reason: collision with root package name */
    private FLConfig f27699d;

    private FLEngine(Context context) {
        this.f27696a = context;
        this.f27697b = new CardSpecHelper(context);
        com.huawei.flexiblelayout.css.a.b().a(context);
        Debuggable.init(context);
        registerNode(FLNode.TYPE, new FLDefaultNodeResolver(FLNode.class));
        registerNode(com.huawei.flexiblelayout.card.g.f27847h, new FLDefaultNodeResolver(com.huawei.flexiblelayout.card.g.class));
        registerNode(com.huawei.flexiblelayout.card.e.f27831h, new FLDefaultNodeResolver(com.huawei.flexiblelayout.card.e.class));
        registerNode(com.huawei.flexiblelayout.card.f.f27833n, new FLDefaultNodeResolver(com.huawei.flexiblelayout.card.f.class));
        registerNode(com.huawei.flexiblelayout.card.h.f27848h, new FLDefaultNodeResolver(com.huawei.flexiblelayout.card.h.class));
        registerNode(com.huawei.flexiblelayout.card.a.f27807g, new FLDefaultNodeResolver(com.huawei.flexiblelayout.card.a.class));
        registerNode(com.huawei.flexiblelayout.card.c.f27817j, new FLDefaultNodeResolver(com.huawei.flexiblelayout.card.c.class));
        registerNode(com.huawei.flexiblelayout.card.b.f27815h, new FLDefaultNodeResolver(com.huawei.flexiblelayout.card.b.class));
        register(FLDivider.f27816g, FLDivider.class);
        register(com.huawei.flexiblelayout.card.d.f27830e, com.huawei.flexiblelayout.card.d.class);
        registerService(CardActionService.class, new h1());
        registerService(LoadMoreService.class, new LoadMoreServiceImpl());
        registerService(TaskHandlerRegistryService.class, new p1());
        registerService(FLSNodeService.class, new com.huawei.flexiblelayout.card.snode.a());
        registerService(ImageLoaderService.class, new n1());
        registerService(AnalyticsService.class, new i1(context));
        registerService(ConfigurationService.class, new l1());
        registerService(SafeAreaService.class, new o1());
        registerService(FLDNodeService.class, new a());
        registerService(FLEffectService.class, m1.a());
        registerService(CardExposureService.class, new CardExposureServiceImpl(context));
        registerService(ScriptConfigService.class, com.huawei.flexiblelayout.script.impl.a.a());
    }

    public static FLEngine getInstance(Context context) {
        if (f27695e == null) {
            synchronized (FLEngine.class) {
                if (f27695e == null) {
                    f27695e = new FLEngine(context.getApplicationContext());
                }
            }
        }
        return f27695e;
    }

    public CardSpecHelper getCardSpecHelper() {
        return this.f27697b;
    }

    public FLConfig getConfig() {
        if (this.f27699d == null) {
            this.f27699d = FLConfig.newConfig();
        }
        return this.f27699d;
    }

    public Context getContext() {
        return this.f27696a;
    }

    public <T> T getService(Class<T> cls) {
        return (T) getService(cls, null);
    }

    public void register(String str, Class<? extends FLCell> cls) {
        FLResolverRegistry.registerCard(str, new CardResolver(str, cls));
    }

    public void registerNode(String str, NodeResolver nodeResolver) {
        FLResolverRegistry.registerNode(str, nodeResolver);
    }

    public void registerNodeSpec(FLayoutSpec.FNodeSpec fNodeSpec) {
        FLResolverRegistry.registerNodeSpec(fNodeSpec);
    }

    public <T> void registerService(Class<T> cls, T t2) {
        this.f27698c.put(cls.getName(), t2);
    }

    public void setConfig(FLConfig fLConfig) {
        this.f27699d = fLConfig;
    }

    public <T> void unregisterService(Class<T> cls) {
        this.f27698c.remove(cls.getName());
    }

    public <T> T getService(Class<T> cls, ServiceTokenProvider serviceTokenProvider) {
        String name = cls.getName();
        T t2 = null;
        if (serviceTokenProvider != null) {
            for (com.huawei.flexiblelayout.services.a serviceToken = serviceTokenProvider.getServiceToken(); serviceToken != null; serviceToken = serviceToken.a()) {
                t2 = (T) this.f27698c.get(name + "/" + serviceToken.b());
                if (t2 != null) {
                    break;
                }
            }
        }
        return t2 == null ? (T) this.f27698c.get(name) : t2;
    }

    public void register(Class<? extends FLCell> cls) {
        FLResolverRegistry.registerCard(cls);
    }

    public <T> void registerService(Class<T> cls, T t2, ServiceTokenProvider serviceTokenProvider) {
        this.f27698c.put(cls.getName() + "/" + serviceTokenProvider.getServiceToken().b(), t2);
    }

    public <T> void unregisterService(Class<T> cls, ServiceTokenProvider serviceTokenProvider) {
        this.f27698c.remove(cls.getName() + "/" + serviceTokenProvider.getServiceToken().b());
    }
}
