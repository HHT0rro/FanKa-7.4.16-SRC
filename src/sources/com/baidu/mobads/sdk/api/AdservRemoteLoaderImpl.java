package com.baidu.mobads.sdk.api;

import com.baidu.mobads.sdk.internal.an;
import com.baidu.mobads.sdk.internal.c;
import com.baidu.mobads.sdk.internal.e;
import com.baidu.mobads.sdk.internal.s;
import dalvik.system.DexClassLoader;

@Route(path = c.a.f10007a)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class AdservRemoteLoaderImpl implements s {
    @Override // com.baidu.mobads.sdk.internal.s
    public void startLoadRemotePhp(double d10, an.b bVar) {
        e.a().a(d10, bVar);
    }

    @Override // com.baidu.mobads.sdk.internal.s
    public DexClassLoader getClassLoaderFromJar(String str, String str2, String str3, ClassLoader classLoader) {
        return e.a().a(str, str2, str3, classLoader);
    }
}
