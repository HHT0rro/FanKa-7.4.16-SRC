package com.bytedance.sdk.openadsdk.mediation.bridge;

import android.content.Context;
import androidx.annotation.RequiresApi;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationLoaderConfig;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MediationAdClassLoader implements Bridge {

    /* renamed from: m, reason: collision with root package name */
    private static volatile MediationAdClassLoader f11291m;

    private MediationAdClassLoader() {
    }

    public static MediationAdClassLoader getInstance() {
        if (f11291m == null) {
            synchronized (MediationAdClassLoader.class) {
                f11291m = new MediationAdClassLoader();
            }
        }
        return f11291m;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    @RequiresApi(api = 19)
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        if (i10 == 8106) {
            MediationLoaderConfig create = MediationLoaderConfig.create(valueSet);
            Context context = (Context) valueSet.objectValue(8009, Context.class);
            try {
                Object newInstance = Class.forName(create.getClassName()).newInstance();
                if (newInstance instanceof Bridge) {
                    MediationValueSetBuilder create2 = MediationValueSetBuilder.create();
                    create2.add(8009, context);
                    create2.add(8424, valueSet);
                    ((Bridge) newInstance).call(8241, create2.build(), null);
                }
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
                e2.printStackTrace();
            }
        } else if (i10 == 8229) {
            try {
                Class.forName(valueSet.stringValue(8010));
                return (T) Boolean.TRUE;
            } catch (ClassNotFoundException e10) {
                e10.printStackTrace();
                return (T) Boolean.FALSE;
            }
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
