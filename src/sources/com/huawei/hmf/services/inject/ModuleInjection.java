package com.huawei.hmf.services.inject;

import com.huawei.hmf.annotation.Inject;
import com.huawei.hmf.repository.ComponentRepository;
import com.huawei.hmf.services.Module;
import com.huawei.hmf.services.inject.InjectValue;
import com.huawei.hmf.services.ui.UIModule;
import com.huawei.hmf.services.ui.internal.PojoGenerator;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ModuleInjection {
    private static final String TAG = "ModuleInjection";
    public static Map<UIModule, Selector> uiModuleSelectorMap = new HashMap();
    private final InjectBindingRegistry mInjectData;

    public ModuleInjection(InjectBindingRegistry injectBindingRegistry) {
        this.mInjectData = injectBindingRegistry;
    }

    private Object createUIModule(String str) {
        InjectInstanceCreator create;
        Module lookup = ComponentRepository.getRepository().lookup(this.mInjectData.getModuleName());
        if (lookup == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("lookup module failed with name ");
            sb2.append(this.mInjectData.getModuleName());
            return null;
        }
        InjectValue injectValue = this.mInjectData.get(str);
        if (injectValue != null && (create = InjectInstanceFactoryRegistry.create(injectValue.getValue())) != null) {
            UIModule uIModule = (UIModule) create.createInstance(lookup, str);
            uIModule.setInjected(injectValue.getType() == InjectValue.Type.EXPLICIT_INJECT);
            return uIModule;
        }
        return lookup.createUIModule(str);
    }

    public static Set<String> getInjectNames(Class cls) {
        HashSet hashSet = new HashSet();
        for (Field field : cls.getDeclaredFields()) {
            Inject inject = (Inject) field.getAnnotation(Inject.class);
            if (inject != null) {
                hashSet.add(inject.value());
            }
        }
        for (Method method : cls.getDeclaredMethods()) {
            Inject inject2 = (Inject) method.getAnnotation(Inject.class);
            if (inject2 != null) {
                hashSet.add(inject2.value());
            }
        }
        return hashSet;
    }

    private void injectField(Object obj) {
        if (obj == null) {
            return;
        }
        for (Field field : obj.getClass().getDeclaredFields()) {
            Inject inject = (Inject) field.getAnnotation(Inject.class);
            if (inject != null) {
                Object createUIModule = createUIModule(inject.value());
                field.setAccessible(true);
                try {
                    field.set(obj, createUIModule);
                } catch (IllegalAccessException unused) {
                }
            }
        }
    }

    private void injectMethod(PojoGenerator pojoGenerator) {
        for (Method method : pojoGenerator.getInterface().getDeclaredMethods()) {
            Inject inject = (Inject) method.getAnnotation(Inject.class);
            if (inject != null) {
                pojoGenerator.setValue(PojoGenerator.resolveName(method.getName()), createUIModule(inject.value()));
            }
        }
    }

    public static Selector selector(UIModule uIModule) {
        Selector selector = uiModuleSelectorMap.get(uIModule);
        if (selector != null) {
            return selector;
        }
        SelectorImpl selectorImpl = new SelectorImpl();
        uiModuleSelectorMap.put(uIModule, selectorImpl);
        return selectorImpl;
    }

    public Object inject(Object obj) {
        if (obj instanceof PojoGenerator) {
            PojoGenerator m2859clone = ((PojoGenerator) obj).m2859clone();
            injectMethod(m2859clone);
            return m2859clone;
        }
        injectField(obj);
        return obj;
    }

    public static Selector selector(Module module) {
        throw new UnsupportedOperationException("Operation not yet implemented");
    }
}
