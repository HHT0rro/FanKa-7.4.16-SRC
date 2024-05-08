package com.bytedance.pangle.plugin;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.d.e;
import com.bytedance.pangle.g;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.l;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class PluginManager {
    private static final String TAG = "PluginManager";
    private static volatile PluginManager sInstance;
    private volatile boolean hasInstallFromDownloadDir;
    private ExecutorService mInstallThreadPool;
    private volatile boolean mIsParsePluginConfig;
    private volatile Map<String, Plugin> mPlugins = new ConcurrentHashMap();
    private final c pluginLoader = new c();

    private PluginManager() {
    }

    private void ensurePluginFileExist(Plugin plugin) {
        if (plugin == null || !plugin.isInstalled() || new File(com.bytedance.pangle.d.c.b(plugin.mPkgName, plugin.getVersion())).exists()) {
            return;
        }
        unInstallPackage(plugin.mPkgName);
    }

    public static PluginManager getInstance() {
        if (sInstance == null) {
            synchronized (PluginManager.class) {
                if (sInstance == null) {
                    sInstance = new PluginManager();
                }
            }
        }
        return sInstance;
    }

    private synchronized void parsePluginConfig() {
        if (this.mIsParsePluginConfig) {
            return;
        }
        ZeusLogger.v(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson");
        ArrayList<String> arrayList = new ArrayList();
        try {
            Bundle bundle = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 128).applicationInfo.metaData;
            for (String str : bundle.keySet()) {
                String str2 = g.f10777e;
                if (str2.startsWith("PANGLE_")) {
                    if (str.startsWith(str2) || str.startsWith("ZEUS_PLUGIN_")) {
                        arrayList.add(bundle.getString(str));
                    }
                } else if (str.startsWith(str2)) {
                    arrayList.add(bundle.getString(str));
                }
            }
            try {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                for (String str3 : arrayList) {
                    try {
                        Plugin plugin = new Plugin(new JSONObject(str3));
                        concurrentHashMap.put(plugin.mPkgName, plugin);
                        ZeusLogger.i(ZeusLogger.TAG_INIT, "PluginManagerparsePluginsJson. find " + plugin.mPkgName);
                    } catch (JSONException e2) {
                        ZeusLogger.errReport(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson failed. " + str3.trim(), e2);
                    }
                }
                this.mPlugins = concurrentHashMap;
                ZeusLogger.i(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson success");
            } catch (Exception e10) {
                ZeusLogger.errReport(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson failed.", e10);
            }
            this.mIsParsePluginConfig = true;
        } catch (Exception e11) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson failed.", e11);
        }
    }

    public void asyncInstall(String str, File file) {
        if (file != null) {
            getInstallThreadPool().execute(new a(str, file));
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "PluginManager asyncInstall, file=".concat(String.valueOf(file)));
        } else {
            ZeusPluginStateListener.postStateChange(str, 7, "asyncInstall apk is null !");
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginManager asyncInstall apk is null !");
        }
    }

    public boolean checkPluginInstalled(String str) {
        Plugin plugin = getPlugin(str);
        ensurePluginFileExist(plugin);
        boolean z10 = plugin != null && plugin.isInstalled();
        ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager checkPluginInstalled, " + str + " = " + z10);
        return z10;
    }

    public ExecutorService getInstallThreadPool() {
        if (this.mInstallThreadPool == null) {
            this.mInstallThreadPool = e.a(GlobalParam.getInstance().getInstallThreads());
        }
        return this.mInstallThreadPool;
    }

    public Plugin getPlugin(String str, boolean z10) {
        if (!Zeus.hasInit() && com.bytedance.pangle.util.b.a()) {
            throw new RuntimeException("Please init Zeus first!");
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!this.mIsParsePluginConfig) {
            parsePluginConfig();
        }
        Plugin plugin = this.mPlugins.get(str);
        if (z10 && plugin != null) {
            plugin.init();
        }
        return plugin;
    }

    public synchronized void installFromDownloadDir() {
        if (this.hasInstallFromDownloadDir) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, "PluginManager zeus has been installFromDownloadDir!");
            return;
        }
        if (com.bytedance.pangle.d.d.a(Zeus.getAppApplication())) {
            e.a(new d());
        }
        this.hasInstallFromDownloadDir = true;
    }

    public boolean isLoaded(String str) {
        Plugin plugin = getPlugin(str);
        return plugin != null && plugin.isLoaded();
    }

    public boolean loadPlugin(String str) {
        return this.pluginLoader.a(str);
    }

    public void setAllowDownloadPlugin(String str, int i10, boolean z10) {
        ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager setAllowDownloadPlugin, " + str + " " + i10 + " " + z10);
        if (getPlugin(str) != null) {
            boolean z11 = !z10;
            SharedPreferences.Editor edit = l.a().f11001a.edit();
            String str2 = "DISABLE_DOWNLOAD_" + str + "_" + i10;
            if (z11) {
                edit.putInt(str2, 0);
            } else {
                edit.remove(str2);
            }
            edit.apply();
            ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils markAllowDownloadFlag packageName=" + str + " version=" + i10 + " disable=" + z11);
        }
    }

    public boolean syncInstall(String str, File file) {
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "PluginManager syncInstall, file=".concat(String.valueOf(file)));
        return new a(str, file).a();
    }

    public void tryOfflineInternalPlugin(String str, int i10) {
        Plugin plugin = getPlugin(str);
        if (plugin == null || plugin.getInternalVersionCode() != i10) {
            return;
        }
        ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager offlineInternalPlugin, pkgName:" + str + " pluginVer:" + i10 + " apiVer:" + plugin.getApiVersionCode());
        l a10 = l.a();
        int apiVersionCode = plugin.getApiVersionCode();
        SharedPreferences.Editor edit = a10.f11001a.edit();
        edit.putInt("OFFLINE_INTERNAL_".concat(String.valueOf(str)), apiVersionCode);
        edit.apply();
    }

    public void unInstallPackage(String str) {
        ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager unInstallPackage, ".concat(String.valueOf(str)));
        if (getPlugin(str) != null) {
            SharedPreferences.Editor edit = l.a().f11001a.edit();
            edit.putBoolean("UNINSTALL__".concat(String.valueOf(str)), true);
            edit.apply();
            ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils markUnInstallFlag packageName=".concat(String.valueOf(str)));
        }
    }

    public Plugin getPlugin(String str) {
        return getPlugin(str, true);
    }
}
