package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.baidu.mobads.sdk.internal.by;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class bn {

    /* renamed from: a, reason: collision with root package name */
    public static final String f9914a = "ContainerFactoryBuilder";

    /* renamed from: e, reason: collision with root package name */
    private static IXAdContainerFactory f9915e;

    /* renamed from: c, reason: collision with root package name */
    private Context f9917c;

    /* renamed from: d, reason: collision with root package name */
    private Class<?> f9918d;

    /* renamed from: b, reason: collision with root package name */
    public double f9916b = 0.1d;

    /* renamed from: f, reason: collision with root package name */
    private bs f9919f = bs.a();

    public bn(Class<?> cls, Context context) {
        this.f9918d = null;
        this.f9918d = cls;
        this.f9917c = context;
    }

    public IXAdContainerFactory a() {
        if (f9915e == null) {
            try {
                f9915e = (IXAdContainerFactory) this.f9918d.getDeclaredConstructor(Context.class).newInstance(this.f9917c);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("p_ver", "9.332");
                f9915e.initConfig(jSONObject);
                this.f9916b = f9915e.getRemoteVersion();
                f9915e.onTaskDistribute(ba.f9855a, MobadsPermissionSettings.getPermissionInfo());
                f9915e.initCommonModuleObj(r.a());
            } catch (Throwable th) {
                this.f9919f.b(f9914a, th.getMessage());
                throw new by.a("ContainerFactory() failed, possibly API incompatible: " + th.getMessage());
            }
        }
        return f9915e;
    }

    public void b() {
        f9915e = null;
    }
}
