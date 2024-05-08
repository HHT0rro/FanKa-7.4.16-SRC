package com.bytedance.pangle.plugin;

import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.f.a.e;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final File f10841a;

    /* renamed from: b, reason: collision with root package name */
    private final String f10842b;

    public a(String str, File file) {
        this.f10841a = file;
        this.f10842b = str;
    }

    public final boolean a() {
        e a10 = com.bytedance.pangle.f.a.d.a(this.f10841a);
        if (a10 == null) {
            ZeusPluginStateListener.postStateChange(this.f10842b, 7, " read local file package info failed !!! pluginPkg = " + this.f10842b + " mApkFile.exists = " + this.f10841a.exists());
            StringBuilder sb2 = new StringBuilder("PluginInstallRunnable read local file package info failed !!! pluginPkg = ");
            sb2.append(this.f10842b);
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, sb2.toString());
            return false;
        }
        Plugin plugin = PluginManager.getInstance().getPlugin(a10.f10767a);
        if (plugin == null) {
            ZeusPluginStateListener.postStateChange(this.f10842b, 7, " plugin == null !!! pluginPkg = " + this.f10842b);
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstallRunnable cannot query valid plugin !!! packageName = " + a10.f10767a);
            return false;
        }
        boolean install = plugin.install(this.f10841a, a10);
        if (install) {
            ZeusPluginStateListener.postStateChange(a10.f10767a, 6, new Object[0]);
        } else {
            ZeusPluginStateListener.postStateChange(a10.f10767a, 7, "Internal error.");
        }
        return install;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();
    }
}
