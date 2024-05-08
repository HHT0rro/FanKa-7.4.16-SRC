package com.huawei.flexiblelayout.creator;

import com.huawei.flexiblelayout.annotation.FLCardDefine;
import com.huawei.flexiblelayout.card.FLCell;
import com.huawei.flexiblelayout.card.i;
import com.huawei.flexiblelayout.creator.cd.IClassHolderRegistry;
import com.huawei.flexiblelayout.data.FLayoutSpec;
import com.huawei.flexiblelayout.log.Log;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FLResolverRegistry {

    /* renamed from: a, reason: collision with root package name */
    private static final String f27937a = "FLResolverRegistry";

    /* renamed from: b, reason: collision with root package name */
    private static Map<String, NodeResolver> f27938b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private static Map<String, CardResolver> f27939c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private static Map<String, FLayoutSpec.FNodeSpec> f27940d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private static final Object f27941e = new Object();

    static {
        registerNode(i.f27849g, new FLDefaultNodeResolver(i.class));
        try {
            Class.forName("com.huawei.flexiblelayout.creator.cd.ClassHolderRegister").getMethod("register", IClassHolderRegistry.class).invoke(null, new IClassHolderRegistry() { // from class: com.huawei.flexiblelayout.creator.FLResolverRegistry.1
                @Override // com.huawei.flexiblelayout.creator.cd.IClassHolderRegistry
                public void register(CardClassHolder cardClassHolder) {
                    FLResolverRegistry.registerCard(cardClassHolder.getName(), new CardResolver(cardClassHolder));
                }
            });
        } catch (Exception unused) {
            Log.w(f27937a, "Failed to register cards (Failed to invoke ClassHolderRegister).");
        }
    }

    public static CardResolver getCardResolver(String str) {
        return f27939c.get(str);
    }

    public static NodeResolver getNodeResolver(String str) {
        NodeResolver nodeResolver = f27938b.get(str);
        return nodeResolver == null ? f27938b.get(i.f27849g) : nodeResolver;
    }

    public static FLayoutSpec.FNodeSpec getNodeSpec(String str) {
        FLayoutSpec.FNodeSpec fNodeSpec;
        synchronized (f27941e) {
            fNodeSpec = f27940d.get(str);
        }
        return fNodeSpec;
    }

    public static boolean isDefinedCard(String str) {
        return f27939c.get(str) != null;
    }

    public static boolean isDefinedNode(String str) {
        return f27938b.get(str) != null;
    }

    public static boolean isDefinedNodeSpec(String str) {
        return getNodeSpec(str) != null;
    }

    public static void registerCard(String str, CardResolver cardResolver) {
        if (f27939c.get(str) == null) {
            f27939c.put(str, cardResolver);
        }
    }

    public static void registerNode(String str, NodeResolver nodeResolver) {
        if (f27938b.get(str) == null) {
            f27938b.put(str, nodeResolver);
        }
    }

    public static void registerNodeSpec(FLayoutSpec.FNodeSpec fNodeSpec) {
        String name = fNodeSpec.name();
        synchronized (f27941e) {
            f27940d.put(name, fNodeSpec);
        }
    }

    public static void registerCard(Class<? extends FLCell> cls) {
        FLCardDefine fLCardDefine = (FLCardDefine) cls.getAnnotation(FLCardDefine.class);
        if (fLCardDefine != null) {
            String type = fLCardDefine.type();
            registerCard(type, new CardResolver(type, cls));
        }
    }
}
