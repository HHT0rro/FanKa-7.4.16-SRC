package com.bytedance.android.openliveplugin;

import android.app.Application;
import android.util.Pair;
import com.byted.live.api.BuildConfig;
import com.bytedance.android.live.base.api.ILiveHostContextParam;
import com.bytedance.android.live.base.api.ILiveInitCallback;
import com.bytedance.android.live.base.api.IOuterLiveRoomService;
import com.bytedance.android.live.base.api.JavaCallsUtils;
import com.bytedance.android.live.base.api.callback.EmptyCallback;
import com.bytedance.android.openliveplugin.stub.logger.TTLogger;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.plugin.PluginManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class LivePluginHelper {
    public static final String LIVE_PLUGIN_PACKAGE_NAME = "com.byted.live.lite";
    private static IOuterLiveRoomService liveRoomService;
    private static ArrayList<ILiveInitCallback> mLiveInitListeners;
    private static EmptyCallback sInstallCallback;
    public static final ScheduledExecutorService sExecutor = Executors.newSingleThreadScheduledExecutor(new DefaultThreadFactory());
    private static boolean hasLiveInitFinish = false;
    private static boolean hasInitZeus = false;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class DefaultThreadFactory implements ThreadFactory {
        private final ThreadGroup group;
        private final String namePrefix;
        private final AtomicInteger threadNumber;

        public DefaultThreadFactory() {
            this.threadNumber = new AtomicInteger(1);
            this.group = new ThreadGroup("tob_douyin_live_group");
            this.namePrefix = "tob_douyin_live_thread_init";
        }

        public DefaultThreadFactory(String str) {
            this.threadNumber = new AtomicInteger(1);
            this.group = new ThreadGroup("tob_douyin_live_group");
            this.namePrefix = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.group, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 10) {
                thread.setPriority(10);
            }
            return thread;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class LiveInitCallbackWrapper implements ILiveInitCallback {
        public static LiveInitCallbackWrapper INSTANCE = new LiveInitCallbackWrapper();

        private LiveInitCallbackWrapper() {
        }

        @Override // com.bytedance.android.live.base.api.ILiveInitCallback
        public void onLiveInitFinish() {
            LivePluginHelper.logVersionInfo();
            TTLogger.d("live init : LiveInitCallbackWrapper onLiveInitFinish called.");
            LivePluginHelper.initLiveCommerce();
            boolean unused = LivePluginHelper.hasLiveInitFinish = true;
            Iterator iterator2 = LivePluginHelper.mLiveInitListeners.iterator2();
            while (iterator2.hasNext()) {
                ILiveInitCallback iLiveInitCallback = (ILiveInitCallback) iterator2.next();
                if (iLiveInitCallback != null) {
                    iLiveInitCallback.onLiveInitFinish();
                }
            }
        }
    }

    private static void adaptEventBus() {
        JavaCallsUtils.callStaticMethodWithClassLoader("com.bytedance.android.openlive.OpenLiveBackdoor", "tryAdaptEventBus", PluginManager.getInstance().getPlugin("com.byted.live.lite").mClassLoader, "com.bytedance.pangle.activity", "com.bytedance.pangle.wrapper");
    }

    public static void addInitListener(ILiveInitCallback iLiveInitCallback) {
        if (mLiveInitListeners == null) {
            mLiveInitListeners = new ArrayList<>();
        }
        if (iLiveInitCallback == LiveInitCallbackWrapper.INSTANCE || mLiveInitListeners.contains(iLiveInitCallback) || iLiveInitCallback == null) {
            return;
        }
        mLiveInitListeners.add(iLiveInitCallback);
    }

    public static String getLiveArgsJsonStr() {
        return (String) JavaCallsUtils.callStaticMethodWithClassLoader("com.bytedance.android.openlive.OpenLiveBackdoor", "getLiveArgsJsonStr", PluginManager.getInstance().getPlugin("com.byted.live.lite").mClassLoader, new Object[0]);
    }

    public static IOuterLiveRoomService getLiveRoomService() {
        if (liveRoomService == null) {
            liveRoomService = (IOuterLiveRoomService) JavaCallsUtils.callStaticMethodWithClassLoader("com.bytedance.android.openlive.OpenLiveBackdoor", "getOuterLiveRoomService", PluginManager.getInstance().getPlugin("com.byted.live.lite").mClassLoader, new Object[0]);
        }
        return liveRoomService;
    }

    public static void init(Application application) {
        if (application == null) {
            return;
        }
        GlobalParam.getInstance().init();
        Zeus.init(application, true);
        Zeus.installFromDownloadDir();
        Zeus.fetchPlugin("com.byted.live.lite");
    }

    public static void init(Application application, String str, ILiveHostContextParam.Builder builder, ILiveInitCallback iLiveInitCallback) {
        init(application, str, builder, iLiveInitCallback, true);
    }

    public static void init(Application application, String str, ILiveHostContextParam.Builder builder, ILiveInitCallback iLiveInitCallback, boolean z10) {
        if (!hasInitZeus) {
            initZeus(application, z10);
            hasInitZeus = true;
        }
        initLive(application, str, builder, iLiveInitCallback);
    }

    public static void initLive(final Application application, final String str, final ILiveHostContextParam.Builder builder, final ILiveInitCallback iLiveInitCallback) {
        sExecutor.execute(new Runnable() { // from class: com.bytedance.android.openliveplugin.LivePluginHelper.2
            @Override // java.lang.Runnable
            public void run() {
                TTLogger.d("live init : async start init live ~~~");
                if (LivePluginHelper.prepare(new Runnable() { // from class: com.bytedance.android.openliveplugin.LivePluginHelper.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TTLogger.d("live init : runnable real init live ---- ");
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        LivePluginHelper.realInitLivePlugin(application, str, builder, iLiveInitCallback);
                    }
                })) {
                    TTLogger.d("live init : prepared-start real init live ---- ");
                    LivePluginHelper.realInitLivePlugin(application, str, builder, iLiveInitCallback);
                }
            }
        });
    }

    public static void initLiveCommerce() {
        try {
            adaptEventBus();
            JavaCallsUtils.callStaticMethodWithClassLoader("com.bytedance.android.ecom.live.adapter.ECLiveAdapter", "init", PluginManager.getInstance().getPlugin("com.byted.live.lite").mClassLoader, new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void initZeus(Application application, boolean z10) {
        if (application == null) {
            return;
        }
        GlobalParam.getInstance().setApmFlag(false, false, false, false);
        GlobalParam.getInstance().closeCrashMonitor(true);
        GlobalParam.getInstance().init();
        Zeus.init(application, true);
        Zeus.installFromDownloadDir();
        if (z10) {
            Zeus.fetchPlugin("com.byted.live.lite");
        }
        TTLogger.d("live init : initZeus with fetchPlugin = " + z10);
    }

    public static boolean isLiveInited() {
        return hasLiveInitFinish;
    }

    public static void logEventV3(String str, JSONObject jSONObject) {
        JavaCallsUtils.callStaticMethodWithClassLoader("com.bytedance.android.openlive.OpenLiveBackdoor", "onEventV3", PluginManager.getInstance().getPlugin("com.byted.live.lite").mClassLoader, str, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logVersionInfo() {
        Object callStaticMethodWithClassLoader = JavaCallsUtils.callStaticMethodWithClassLoader("com.bytedance.android.openlive.plugin.LivePluginApplication", "getPluginVersion", PluginManager.getInstance().getPlugin("com.byted.live.lite").mClassLoader, new Object[0]);
        if (callStaticMethodWithClassLoader == null) {
            return;
        }
        try {
            Pair pair = (Pair) callStaticMethodWithClassLoader;
            long longValue = ((Long) pair.first).longValue();
            String str = (String) pair.second;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("version_info: lib_version_name=");
            sb2.append(BuildConfig.API_LIB_VERSION_NAME);
            sb2.append("; plugin_version_code=");
            sb2.append(longValue);
            sb2.append("; plugin_version_name=");
            sb2.append(str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean prepare(final Runnable runnable) {
        TTLogger.d("live init : prepare ---- ");
        if (!Zeus.isPluginInstalled("com.byted.live.lite")) {
            TTLogger.d("live init : prepare live plugin is not installed !!! ");
            Zeus.registerPluginStateListener(new ZeusPluginStateListener() { // from class: com.bytedance.android.openliveplugin.LivePluginHelper.3
                @Override // com.bytedance.pangle.ZeusPluginStateListener
                public void onPluginStateChange(String str, int i10, Object... objArr) {
                    if (Runnable.this != null && "com.byted.live.lite".equals(str) && i10 == 6) {
                        if (LivePluginHelper.sInstallCallback != null) {
                            LivePluginHelper.sInstallCallback.invoke();
                        }
                        TTLogger.d("live init : prepare on live plugin install success !!! ");
                        LivePluginHelper.sExecutor.execute(new Runnable() { // from class: com.bytedance.android.openliveplugin.LivePluginHelper.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                String str2;
                                if (Zeus.isPluginLoaded("com.byted.live.lite")) {
                                    str2 = "live init : prepare onPluginStateChange start load live plugin v1 !!! ";
                                } else if (!Zeus.loadPlugin("com.byted.live.lite")) {
                                    return;
                                } else {
                                    str2 = "live init : prepare onPluginStateChange start load live plugin v2 !!! ";
                                }
                                TTLogger.d(str2);
                                Runnable.this.run();
                            }
                        });
                    }
                }
            });
            return false;
        }
        EmptyCallback emptyCallback = sInstallCallback;
        if (emptyCallback != null) {
            emptyCallback.invoke();
        }
        if (Zeus.isPluginLoaded("com.byted.live.lite")) {
            TTLogger.d("live init : prepare live plugin is load !!! ");
            return Zeus.isPluginLoaded("com.byted.live.lite");
        }
        TTLogger.d("live init : prepare start load live plugin !!! ");
        return Zeus.loadPlugin("com.byted.live.lite");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void realInitLivePlugin(final Application application, final String str, final ILiveHostContextParam.Builder builder, final ILiveInitCallback iLiveInitCallback) {
        sExecutor.execute(new Runnable() { // from class: com.bytedance.android.openliveplugin.LivePluginHelper.1
            @Override // java.lang.Runnable
            public void run() {
                JavaCallsUtils.callStaticMethodWithClassLoader("com.bytedance.android.openlive.plugin.LivePluginInitEntrance", "initLiveInPlugin", PluginManager.getInstance().getPlugin("com.byted.live.lite").mClassLoader, application, str, builder, iLiveInitCallback);
            }
        });
    }

    public static void setBoeValue(String str) {
        JavaCallsUtils.callStaticMethodWithClassLoader("com.bytedance.android.openlive.OpenLiveBackdoor", "setBoeValue", PluginManager.getInstance().getPlugin("com.byted.live.lite").mClassLoader, str);
    }

    public static void setInstallCallback(EmptyCallback emptyCallback) {
        sInstallCallback = emptyCallback;
    }

    public static void setPpeValue(String str) {
        JavaCallsUtils.callStaticMethodWithClassLoader("com.bytedance.android.openlive.OpenLiveBackdoor", "setPpeValue", PluginManager.getInstance().getPlugin("com.byted.live.lite").mClassLoader, str);
    }
}
