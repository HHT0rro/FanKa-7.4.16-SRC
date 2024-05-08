package com.bytedance.pangle.plugin;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusApplication;
import com.bytedance.pangle.d.e;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.g;
import com.bytedance.pangle.util.k;
import com.bytedance.pangle.util.l;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import com.huawei.openalliance.ad.constant.u;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class Plugin {
    public static final int LIFE_INSTALLED = 2;
    public static final int LIFE_LOADED = 3;
    public static final int LIFE_PENDING = 1;
    private static final String TAG = "Plugin";
    private int mApiVersionCode;
    public final String mAppKey;
    public final String mAppSecretKey;
    public ZeusApplication mApplication;
    public PluginClassLoader mClassLoader;
    public PluginApplicationWrapper mHostApplication;
    public ApplicationInfo mHostApplicationInfoHookSomeField;
    private volatile boolean mInitialized;
    private String mInternalPath;
    private int mInternalVersionCode;
    public boolean mIsSupportLibIso;
    public int mMaxVersionCode;
    public int mMinVersionCode;
    public final boolean mOpenLoadClassOpt;
    private String mPackageDir;
    public String mPkgName;
    public final boolean mReInstallInternalPluginByMd5;
    public Resources mResources;
    public String mSignature;
    public final boolean mUnInstallPluginWhenHostChange;
    public final boolean mUseMemoryForActivityIntent;
    private int mVersionCode;
    public String response;
    public HashMap<String, ActivityInfo> pluginActivities = new HashMap<>();
    public HashMap<String, ServiceInfo> pluginServices = new HashMap<>();
    public HashMap<String, ActivityInfo> pluginReceiver = new HashMap<>();
    public HashMap<String, ProviderInfo> pluginProvider = new HashMap<>();
    private volatile int mLifeCycle = 1;
    public final List<String> mSharedHostSos = new ArrayList();
    public final Object installLock = new Object();
    public final Object initializeLock = new Object();

    public Plugin(JSONObject jSONObject) {
        this.mInternalVersionCode = -1;
        this.mMaxVersionCode = Integer.MAX_VALUE;
        this.mPkgName = jSONObject.getString("packageName");
        this.mMinVersionCode = jSONObject.optInt("minPluginVersion", 0);
        this.mMaxVersionCode = jSONObject.optInt("maxPluginVersion", Integer.MAX_VALUE);
        this.mApiVersionCode = jSONObject.getInt(TTLiveConstants.LIVE_API_VERSION_KEY);
        String signature = GlobalParam.getInstance().getSignature(this.mPkgName);
        this.mSignature = signature;
        if (TextUtils.isEmpty(signature)) {
            this.mSignature = jSONObject.optString("signature", "");
        }
        this.mIsSupportLibIso = jSONObject.optBoolean("isSupportLibIsolate", false);
        this.mInternalPath = jSONObject.optString("internalPath", "");
        this.mInternalVersionCode = jSONObject.optInt("internalVersionCode", -1);
        this.mAppKey = jSONObject.optString("appKey", "");
        this.mAppSecretKey = jSONObject.optString("appSecretKey", "");
        this.mOpenLoadClassOpt = jSONObject.optBoolean("loadClassOpt", false);
        this.mUnInstallPluginWhenHostChange = jSONObject.optBoolean("unInstallPluginWhenHostChange", false);
        this.mUseMemoryForActivityIntent = jSONObject.optBoolean("useMemoryForActivityIntent", false);
        this.mReInstallInternalPluginByMd5 = jSONObject.optBoolean("reInstallInternalPluginByMd5", false);
        JSONArray optJSONArray = jSONObject.optJSONArray("sharedHostSo");
        if (optJSONArray != null) {
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                this.mSharedHostSos.add((String) optJSONArray.get(i10));
            }
        }
        setupInternalPlugin();
    }

    private boolean checkValid(File file, String str, int i10) {
        if (!TextUtils.equals(this.mPkgName, str)) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " package name not match !!!");
            return false;
        }
        if (i10 >= this.mMinVersionCode && i10 <= this.mMaxVersionCode) {
            if (i10 < this.mVersionCode && isInstalled()) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + String.format(" pluginApk ver[%s] lower than installed plugin[%s].", Integer.valueOf(i10), Integer.valueOf(this.mVersionCode)));
                return false;
            }
            if (file != null && file.exists()) {
                if (i10 == this.mVersionCode && l.a().f11001a.getString("IDENTITY_".concat(String.valueOf(str)), "").equals(com.bytedance.pangle.util.c.a(file)[0])) {
                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " pluginApk with the same identity has already installed.");
                    return false;
                }
                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + u.bD + i10 + " true");
                return true;
            }
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " pluginApk not exist.");
            return false;
        }
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " " + String.format(" pluginApk ver[%s] not match plugin VerRange[%s, %s].", Integer.valueOf(i10), Integer.valueOf(this.mMinVersionCode), Integer.valueOf(this.mMaxVersionCode)));
        return false;
    }

    private boolean checkVersionValid(int i10, int i11, boolean z10) {
        int a10 = l.a().a(this.mPkgName);
        boolean z11 = false;
        if (a10 > i11) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, TAG.concat(String.valueOf(String.format(" checkVersionValid %s apiVersion downgrade , lastApiVersion=%s , currentApiVersion=%s", this.mPkgName, Integer.valueOf(a10), Integer.valueOf(i11)))));
            return false;
        }
        boolean z12 = i10 >= 0 && i10 >= this.mMinVersionCode && i10 <= this.mMaxVersionCode;
        if (z12 && i11 != -1) {
            l a11 = l.a();
            String str = this.mPkgName;
            int i12 = a11.f11001a.getInt("API_MIN_" + str + "_" + i10, 0);
            l a12 = l.a();
            String str2 = this.mPkgName;
            int i13 = a12.f11001a.getInt("API_MAX_" + str2 + "_" + i10, Integer.MAX_VALUE);
            int i14 = i13 != 0 ? i13 : Integer.MAX_VALUE;
            if (i11 < i12 || i11 > i14) {
                ZeusLogger.w(ZeusLogger.TAG_INIT, TAG.concat(String.valueOf(String.format(" checkVersionValid plugin[%s, ver=%s] is not compatible with api[ver_code=%s], apiCompatibleVer=[%s,%s]", this.mPkgName, Integer.valueOf(this.mVersionCode), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i14)))));
                z12 = false;
            }
        }
        if (z12 && z10 && com.bytedance.pangle.d.b.b(new File(com.bytedance.pangle.d.c.b(this.mPkgName, i10)))) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, TAG.concat(String.valueOf(String.format(" checkVersionValid plugin[%s, ver=%s] not match hostAbi", this.mPkgName, Integer.valueOf(i10)))));
        } else {
            z11 = z12;
        }
        ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin checkVersionValid, pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", valid=" + z11);
        return z11;
    }

    private void deleteIfNeeded() {
        if (com.bytedance.pangle.d.d.a(Zeus.getAppApplication())) {
            if (l.a().f11001a.getBoolean("UNINSTALL__".concat(String.valueOf(this.mPkgName)), false)) {
                l a10 = l.a();
                String str = this.mPkgName;
                SharedPreferences.Editor edit = a10.f11001a.edit();
                edit.remove("UNINSTALL__".concat(String.valueOf(str)));
                edit.apply();
                deleteInstalledPlugin();
                ZeusLogger.w(ZeusLogger.TAG_INIT, "Plugin deleteIfNeeded " + this.mPkgName);
            }
        }
    }

    private void deleteInstalledPlugin() {
        if (TextUtils.isEmpty(this.mPackageDir)) {
            this.mPackageDir = com.bytedance.pangle.d.c.a(this.mPkgName);
        }
        new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.3
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                if (file.getName().matches("^version-(\\d+)$")) {
                    l.a().a(Plugin.this.mPkgName, Integer.parseInt(file.getName().split("-")[1]), false);
                }
                return false;
            }
        });
        g.a(this.mPackageDir);
    }

    private void deleteOtherExpiredVer(int i10) {
        if (com.bytedance.pangle.d.d.a(Zeus.getAppApplication())) {
            if (TextUtils.isEmpty(this.mPackageDir)) {
                this.mPackageDir = com.bytedance.pangle.d.c.a(this.mPkgName);
            }
            final String concat = "version-".concat(String.valueOf(i10));
            new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.4
                @Override // java.io.FileFilter
                public final boolean accept(File file) {
                    if (file != null && !concat.equals(file.getName()) && !"data".equals(file.getName())) {
                        g.a(file.getAbsolutePath());
                        ZeusLogger.w(ZeusLogger.TAG_INIT, "Plugin deleteOtherExpired " + file.getAbsolutePath());
                        if (file.getName().matches("^version-(\\d+)$")) {
                            l.a().a(Plugin.this.mPkgName, Integer.parseInt(file.getName().split("-")[1]), false);
                        }
                    }
                    return false;
                }
            });
        }
    }

    private void installInternalPlugin() {
        if (com.bytedance.pangle.d.d.a(Zeus.getAppApplication())) {
            if (this.mReInstallInternalPluginByMd5) {
                if (getVersion() > this.mInternalVersionCode) {
                    return;
                }
            } else if (getVersion() >= this.mInternalVersionCode) {
                return;
            }
            if (TextUtils.isEmpty(this.mInternalPath)) {
                return;
            }
            e.a(new Runnable() { // from class: com.bytedance.pangle.plugin.Plugin.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        File file = new File(com.bytedance.pangle.d.c.b(), Plugin.this.mPkgName + ".apk");
                        ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin copyInternalPlugin " + Plugin.this.mInternalPath + " --> " + file.getAbsolutePath());
                        g.a(Zeus.getAppApplication().getAssets().open(Plugin.this.mInternalPath), new FileOutputStream(file));
                        if (file.exists()) {
                            PluginManager.getInstance().asyncInstall(Plugin.this.mPkgName, file);
                            return;
                        }
                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "installInternalPlugin failed. " + file.getAbsolutePath() + " is not exists.");
                    } catch (Throwable th) {
                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "installInternalPlugin failed. " + th.getMessage());
                    }
                }
            });
        }
    }

    private int modifyResIfNeed(int i10) {
        String a10 = com.bytedance.pangle.util.b.a(Zeus.getAppApplication());
        if (!TextUtils.isEmpty(a10) && TextUtils.equals(l.a().b(this.mPkgName), a10)) {
            return i10;
        }
        if (!this.mUnInstallPluginWhenHostChange && !GlobalParam.getInstance().unInstallPluginWhenHostChange(this.mPkgName)) {
            ZeusLogger.d(ZeusLogger.TAG_INIT, "modifyRes by init. " + this.mPkgName + " " + i10);
            int a11 = new com.bytedance.pangle.res.a.c().a(new File(com.bytedance.pangle.d.c.b(this.mPkgName, i10)), true, new StringBuilder());
            if (a11 == 100 || a11 == 200) {
                return i10;
            }
            return 0;
        }
        ZeusLogger.d(ZeusLogger.TAG_INIT, "uninstall plugin by host update. " + this.mPkgName + " " + i10);
        return 0;
    }

    private void setupInternalPlugin() {
        int a10;
        if (l.a().f11001a.getInt(String.format(Locale.getDefault(), "OFFLINE_INTERNAL_%s", this.mPkgName), -1) == this.mApiVersionCode) {
            return;
        }
        if (TextUtils.isEmpty(this.mInternalPath) || this.mInternalVersionCode == -1) {
            try {
                for (String str : Zeus.getAppApplication().getAssets().list(com.bytedance.pangle.g.f10776d)) {
                    if (str.startsWith(this.mPkgName + "_") && (a10 = k.a(str.split("_")[1])) != -1) {
                        this.mInternalPath = com.bytedance.pangle.g.f10776d + "/" + str;
                        this.mInternalVersionCode = a10;
                        return;
                    }
                }
            } catch (IOException e2) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "setupInternalPlugin failed.", e2);
            }
        }
    }

    private void updateInstallStateFromMainProcess() {
        com.bytedance.pangle.c a10;
        try {
            if (com.bytedance.pangle.d.d.a(Zeus.getAppApplication()) || this.mLifeCycle >= 2 || (a10 = com.bytedance.pangle.servermanager.b.a()) == null || !a10.a(this.mPkgName)) {
                return;
            }
            updateToInstalled(a10.b(this.mPkgName));
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder("updateInstallStateFromMainProcess error. process = ");
            Zeus.getAppApplication();
            sb2.append(com.bytedance.pangle.d.d.a());
            ZeusLogger.w(ZeusLogger.TAG_PPM, sb2.toString(), th);
        }
    }

    private void updateToInstalled(int i10) {
        this.mVersionCode = i10;
        this.mLifeCycle = 2;
    }

    public int getApiVersionCode() {
        return this.mApiVersionCode;
    }

    public int getInstalledMaxVer() {
        if (TextUtils.isEmpty(this.mPackageDir)) {
            this.mPackageDir = com.bytedance.pangle.d.c.a(this.mPkgName);
        }
        File[] listFiles = new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.2
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                return file != null && file.getName().matches("^version-(\\d+)$");
            }
        });
        int i10 = -1;
        if (listFiles != null && listFiles.length > 0) {
            for (File file : listFiles) {
                int parseInt = Integer.parseInt(file.getName().split("-")[1]);
                if (parseInt > i10 && l.a().a(this.mPkgName, parseInt) && new File(com.bytedance.pangle.d.c.b(this.mPkgName, parseInt)).exists()) {
                    i10 = parseInt;
                }
            }
        }
        ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin getInstalledMaxVersion, pkg=" + this.mPkgName + ", maxVer=" + i10);
        return i10;
    }

    public String getInternalPath() {
        return this.mInternalPath;
    }

    public int getInternalVersionCode() {
        return this.mInternalVersionCode;
    }

    public int getLifeCycle() {
        updateInstallStateFromMainProcess();
        return this.mLifeCycle;
    }

    public String getNativeLibraryDir() {
        int i10 = this.mVersionCode;
        if (i10 > 0) {
            return com.bytedance.pangle.d.c.d(this.mPkgName, i10);
        }
        return com.bytedance.pangle.d.c.a(this.mPkgName);
    }

    public int getVersion() {
        updateInstallStateFromMainProcess();
        return this.mVersionCode;
    }

    public void init() {
        boolean z10;
        if (this.mInitialized) {
            return;
        }
        synchronized (this.initializeLock) {
            if (this.mInitialized) {
                return;
            }
            if (com.bytedance.pangle.d.d.a(Zeus.getAppApplication())) {
                int i10 = 0;
                if (!TextUtils.isEmpty(l.a().f11001a.getString("HOST_ABI_".concat(String.valueOf(this.mPkgName)), ""))) {
                    l a10 = l.a();
                    String str = this.mPkgName;
                    z10 = !TextUtils.equals(a10.f11001a.getString("HOST_ABI_".concat(String.valueOf(str)), ""), Zeus.getHostAbi());
                    ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils isHostAbiUpdate HOST_ABI=" + a10.f11001a.getString("HOST_ABI_".concat(String.valueOf(str)), "") + ", " + Zeus.getHostAbi() + ", result=" + z10);
                } else {
                    z10 = false;
                }
                deleteIfNeeded();
                int installedMaxVer = getInstalledMaxVer();
                if (checkVersionValid(installedMaxVer, this.mApiVersionCode, z10)) {
                    i10 = modifyResIfNeed(installedMaxVer);
                    updateToInstalled(i10);
                }
                deleteOtherExpiredVer(i10);
                ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin initPlugins result=".concat(String.valueOf(this)));
                l a11 = l.a();
                String str2 = this.mPkgName;
                SharedPreferences.Editor edit = a11.f11001a.edit();
                edit.putString("ROM_LAST_".concat(String.valueOf(str2)), Build.VERSION.INCREMENTAL);
                edit.apply();
                l a12 = l.a();
                String str3 = this.mPkgName;
                String string = a12.f11001a.getString("HOST_ABI_".concat(String.valueOf(str3)), "");
                SharedPreferences.Editor edit2 = a12.f11001a.edit();
                edit2.putString("HOST_ABI_".concat(String.valueOf(str3)), Zeus.getHostAbi());
                edit2.apply();
                ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setHostAbiUpdated HOST_ABI=" + string + " --> " + Zeus.getHostAbi());
                l a13 = l.a();
                String str4 = this.mPkgName;
                String a14 = com.bytedance.pangle.util.b.a(Zeus.getAppApplication());
                String b4 = a13.b(str4);
                if (!TextUtils.equals(b4, a14)) {
                    SharedPreferences.Editor edit3 = a13.f11001a.edit();
                    edit3.putString("HOST_IDENTITY_".concat(String.valueOf(str4)), a14);
                    edit3.apply();
                }
                ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setHostIdentity(" + str4 + ") " + b4 + " --> " + a14);
                l a15 = l.a();
                String str5 = this.mPkgName;
                int i11 = this.mApiVersionCode;
                int a16 = a15.a(str5);
                if (a16 != i11) {
                    SharedPreferences.Editor edit4 = a15.f11001a.edit();
                    edit4.putInt("PLUGIN_API_VERSION_".concat(String.valueOf(str5)), i11);
                    edit4.apply();
                }
                ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setPluginApiVersion " + a16 + " --> " + i11);
            } else {
                updateInstallStateFromMainProcess();
            }
            this.mInitialized = true;
            installInternalPlugin();
        }
    }

    public void injectResponse(String str) {
        this.response = str;
    }

    public boolean install(File file, com.bytedance.pangle.f.a.e eVar) {
        boolean z10 = false;
        try {
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin install from local file " + ((Object) file) + ", " + Thread.currentThread().getName());
            String str = eVar.f10767a;
            int i10 = eVar.f10768b;
            synchronized (this.installLock) {
                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin synchronized begin, plugin=".concat(String.valueOf(this)));
                boolean checkValid = checkValid(file, str, i10);
                if (checkValid) {
                    String str2 = com.bytedance.pangle.util.c.a(file)[0];
                    z10 = b.a(file, str, i10);
                    if (z10) {
                        l a10 = l.a();
                        String str3 = this.mPkgName;
                        SharedPreferences.Editor edit = a10.f11001a.edit();
                        edit.putString("IDENTITY_".concat(String.valueOf(str3)), str2);
                        edit.apply();
                        l.a().a(this.mPkgName, i10, true);
                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin markPluginInstalled, " + this.mPkgName + u.bD + i10 + " identity=" + str2);
                        g.a(file);
                    }
                }
                synchronized (this) {
                    if (checkValid) {
                        if (this.mLifeCycle == 3) {
                            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin LIFE_LOADED, valid next restart " + str + u.bD + i10);
                        } else if (z10) {
                            updateToInstalled(i10);
                            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin INSTALLED " + str + u.bD + i10);
                        } else {
                            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin INSTALL_FAILED" + str + u.bD + i10);
                            g.a(file);
                            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin delete file by failedCount > 0 " + str + u.bD + i10);
                        }
                    } else {
                        g.a(file);
                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin deleting invalid " + str + u.bD + i10);
                    }
                }
            }
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "Plugin IMPOSSIBLE!!!", th);
        }
        return z10;
    }

    public boolean isInstalled() {
        updateInstallStateFromMainProcess();
        return this.mLifeCycle >= 2;
    }

    public boolean isLoaded() {
        return this.mLifeCycle == 3;
    }

    public boolean isVersionInstalled(int i10) {
        return l.a().a(this.mPkgName, i10);
    }

    public void setApiCompatVersion(int i10, int i11, int i12) {
        l a10 = l.a();
        String str = this.mPkgName;
        SharedPreferences.Editor edit = a10.f11001a.edit();
        edit.putInt("API_MIN_" + str + "_" + i10, i11);
        edit.putInt("API_MAX_" + str + "_" + i10, i12);
        edit.apply();
    }

    public void setLifeCycle(int i10) {
        this.mLifeCycle = i10;
    }

    public String toString() {
        return "Plugin{pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", life=" + this.mLifeCycle + '}';
    }
}
