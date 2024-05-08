package com.huawei.hmf.orb.aidl;

import android.app.Activity;
import android.app.Fragment;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import com.huawei.hmf.orb.RemoteInvoker;
import com.huawei.hmf.orb.dexloader.internal.ReflectionUtils;
import com.huawei.hmf.repository.ComponentRepository;
import com.huawei.hmf.services.ApiSpec;
import com.huawei.hmf.services.Module;
import com.huawei.hmf.services.inject.InjectBindingRegistry;
import com.huawei.hmf.services.inject.InjectValue;
import com.huawei.hmf.services.inject.ModuleInjection;
import com.huawei.hmf.services.inject.SelectorImpl;
import com.huawei.hmf.services.internal.ApplicationContext;
import com.huawei.hmf.services.ui.ActivityResultFragment;
import com.huawei.hmf.services.ui.UIModule;
import java.util.Arrays;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class RemoteUIModule extends UIModule {
    private static final String TAG = "RemoteUIModule";
    private PendingIntent mPendingIntent;
    private final IRemoteActivity remoteActivity;

    public RemoteUIModule(Module module, ApiSpec apiSpec, RemoteInvoker remoteInvoker, String str) {
        super(module, apiSpec);
        this.remoteActivity = (IRemoteActivity) NamingRemoteProxy.create(remoteInvoker, new Class[]{IRemoteActivity.class}, IRemoteActivity.Uri, str);
    }

    private PendingIntent makePendingIntent(Class cls, int i10, int i11) {
        Context context = ApplicationContext.getContext();
        return PendingIntent.getActivity(context, i10, new Intent(context, (Class<?>) cls), i11);
    }

    @Override // com.huawei.hmf.services.ui.UIModule
    public void buildInjectData(InjectBindingRegistry injectBindingRegistry) {
        Class<?> protocol;
        SelectorImpl selectorImpl = (SelectorImpl) ModuleInjection.selector(this);
        if (!selectorImpl.isEmpty()) {
            for (Map.Entry<String, Object> entry : selectorImpl.getValue().entrySet()) {
                String key = entry.getKey();
                Class cls = (Class) entry.getValue();
                if (Activity.class.isAssignableFrom(cls)) {
                    injectBindingRegistry.add(key, new InjectValue(InjectValue.Type.EXPLICIT_INJECT, makePendingIntent(cls, hashCode(key), 134217728)));
                } else {
                    throw new IllegalArgumentException("Can not inject non Activity `" + ((Object) cls) + "` to remote.");
                }
            }
        }
        if (!isInjected() || (protocol = getUIModuleSpec().getProtocol()) == null) {
            return;
        }
        for (String str : ModuleInjection.getInjectNames(protocol)) {
            UIModule createUIModule = ComponentRepository.getRepository().lookup(injectBindingRegistry.getModuleName()).createUIModule(str);
            injectBindingRegistry.add(str, new InjectValue(InjectValue.Type.IMPLICIT_INJECT, makePendingIntent(createUIModule.getUIModuleSpec().getType(), createUIModule.hashCode(), 134217728)));
        }
    }

    public PendingIntent getPendingIntent(int i10) {
        PendingIntent pendingIntent = this.mPendingIntent;
        return pendingIntent != null ? pendingIntent : this.remoteActivity.getActivity(i10);
    }

    public int hashCode(Object obj) {
        return Arrays.hashCode(new Object[]{this, obj});
    }

    @Override // com.huawei.hmf.services.ui.UIModule
    public void startActivity(Context context, Intent intent) {
        PendingIntent pendingIntent = getPendingIntent(hashCode());
        if (pendingIntent != null) {
            Intent intent2 = getIntent(context);
            Bundle bundle = null;
            if (intent != null) {
                bundle = getAndRemoveActivityOptions(intent);
                intent2.fillIn(intent, 0);
            }
            try {
                context.startIntentSender(pendingIntent.getIntentSender(), intent2, 0, 0, 0, bundle);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.huawei.hmf.services.ui.UIModule
    public void startActivityForResult(Context context, Intent intent, int i10) {
        PendingIntent pendingIntent = getPendingIntent(i10);
        if (pendingIntent != null) {
            Intent intent2 = getIntent(context);
            Bundle bundle = null;
            if (intent != null) {
                bundle = getAndRemoveActivityOptions(intent);
                intent2.fillIn(intent, 0);
            }
            Bundle bundle2 = bundle;
            try {
                Fragment injectIfNeededIn = ActivityResultFragment.injectIfNeededIn((Activity) context, i10);
                if (injectIfNeededIn == null) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 24) {
                    injectIfNeededIn.startIntentSenderForResult(pendingIntent.getIntentSender(), i10, intent2, 0, 0, 0, bundle2);
                    return;
                }
                String str = (String) ReflectionUtils.getField(injectIfNeededIn, Fragment.class, "mWho");
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
                Activity activity = new Activity();
                ReflectionUtils.setField(activity, Activity.class, "mEmbeddedID", str);
                ((Activity) context).startIntentSenderFromChild(activity, pendingIntent.getIntentSender(), i10, intent2, 0, 0, 0, bundle2);
            } catch (Exception e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("start remote's activity failed, ");
                sb2.append(e2.getMessage());
            }
        }
    }

    public RemoteUIModule(Module module, UIModule uIModule, PendingIntent pendingIntent) {
        super(module, uIModule);
        this.remoteActivity = null;
        this.mPendingIntent = pendingIntent;
    }
}
