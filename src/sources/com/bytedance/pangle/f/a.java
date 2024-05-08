package com.bytedance.pangle.f;

import com.bytedance.pangle.c;
import com.bytedance.pangle.plugin.PluginManager;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class a extends c.a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f10747a;

    public static a b() {
        if (f10747a == null) {
            synchronized (a.class) {
                if (f10747a == null) {
                    f10747a = new a();
                }
            }
        }
        return f10747a;
    }

    @Override // com.bytedance.pangle.c
    public final boolean a(String str) {
        return PluginManager.getInstance().checkPluginInstalled(str);
    }

    @Override // com.bytedance.pangle.c
    public final boolean a(String str, String str2) {
        return PluginManager.getInstance().syncInstall(str, new File(str2));
    }

    @Override // com.bytedance.pangle.c
    public final int b(String str) {
        return PluginManager.getInstance().getPlugin(str).getVersion();
    }
}
