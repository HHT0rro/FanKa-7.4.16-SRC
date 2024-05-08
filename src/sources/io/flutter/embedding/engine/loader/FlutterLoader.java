package io.flutter.embedding.engine.loader;

import android.app.ActivityManager;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.quickcard.base.Attributes;
import io.flutter.FlutterInjector;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.util.HandlerCompat;
import io.flutter.util.PathUtils;
import io.flutter.util.TraceSection;
import io.flutter.view.VsyncWaiter;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class FlutterLoader {
    public static final String AOT_SHARED_LIBRARY_NAME = "aot-shared-library-name";
    public static final String AOT_VMSERVICE_SHARED_LIBRARY_NAME = "aot-vmservice-shared-library-name";
    public static final String AUTOMATICALLY_REGISTER_PLUGINS_KEY = "automatically-register-plugins";
    private static final String DEFAULT_KERNEL_BLOB = "kernel_blob.bin";
    private static final String DEFAULT_LIBRARY = "libflutter.so";
    private static final String ENABLE_IMPELLER_META_DATA_KEY = "io.flutter.embedding.android.EnableImpeller";
    private static final String ENABLE_VULKAN_VALIDATION_META_DATA_KEY = "io.flutter.embedding.android.EnableVulkanValidation";
    public static final String FLUTTER_ASSETS_DIR_KEY = "flutter-assets-dir";
    private static final String IMPELLER_BACKEND_META_DATA_KEY = "io.flutter.embedding.android.ImpellerBackend";
    private static final String IMPELLER_OPENGL_GPU_TRACING_DATA_KEY = "io.flutter.embedding.android.EnableOpenGLGPUTracing";
    public static final String ISOLATE_SNAPSHOT_DATA_KEY = "isolate-snapshot-data";
    private static final String LEAK_VM_META_DATA_KEY = "io.flutter.embedding.android.LeakVM";
    private static final String OLD_GEN_HEAP_SIZE_META_DATA_KEY = "io.flutter.embedding.android.OldGenHeapSize";
    public static final String SNAPSHOT_ASSET_PATH_KEY = "snapshot-asset-path";
    private static final String TAG = "FlutterLoader";
    private static final String VMSERVICE_SNAPSHOT_LIBRARY = "libvmservice_snapshot.so";
    public static final String VM_SNAPSHOT_DATA_KEY = "vm-snapshot-data";
    private static FlutterLoader instance;
    private ExecutorService executorService;
    private FlutterApplicationInfo flutterApplicationInfo;
    private FlutterJNI flutterJNI;

    @Nullable
    public Future<InitResult> initResultFuture;
    private long initStartTimestampMillis;
    private boolean initialized;

    @Nullable
    private Settings settings;

    /* renamed from: io.flutter.embedding.engine.loader.FlutterLoader$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class AnonymousClass1 implements Callable<InitResult> {
        public final /* synthetic */ Context val$appContext;

        public AnonymousClass1(Context context) {
            this.val$appContext = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$call$0() {
            FlutterLoader.this.flutterJNI.prefetchDefaultFontManager();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public InitResult call() {
            TraceSection scoped = TraceSection.scoped("FlutterLoader initTask");
            try {
                ResourceExtractor initResources = FlutterLoader.this.initResources(this.val$appContext);
                FlutterLoader.this.flutterJNI.loadLibrary();
                FlutterLoader.this.flutterJNI.updateRefreshRate();
                FlutterLoader.this.executorService.execute(new Runnable() { // from class: io.flutter.embedding.engine.loader.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        FlutterLoader.AnonymousClass1.this.lambda$call$0();
                    }
                });
                if (initResources != null) {
                    initResources.waitForCompletion();
                }
                InitResult initResult = new InitResult(PathUtils.getFilesDir(this.val$appContext), PathUtils.getCacheDirectory(this.val$appContext), PathUtils.getDataDirectory(this.val$appContext), null);
                if (scoped != null) {
                    scoped.close();
                }
                return initResult;
            } catch (Throwable th) {
                if (scoped != null) {
                    try {
                        scoped.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class InitResult {
        public final String appStoragePath;
        public final String dataDirPath;
        public final String engineCachesPath;

        public /* synthetic */ InitResult(String str, String str2, String str3, AnonymousClass1 anonymousClass1) {
            this(str, str2, str3);
        }

        private InitResult(String str, String str2, String str3) {
            this.appStoragePath = str;
            this.engineCachesPath = str2;
            this.dataDirPath = str3;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class Settings {
        private String logTag;

        @Nullable
        public String getLogTag() {
            return this.logTag;
        }

        public void setLogTag(String str) {
            this.logTag = str;
        }
    }

    public FlutterLoader() {
        this(FlutterInjector.instance().getFlutterJNIFactory().provideFlutterJNI());
    }

    private static boolean areValidationLayersOnByDefault() {
        return false;
    }

    @NonNull
    private String fullAssetPathFrom(@NonNull String str) {
        return this.flutterApplicationInfo.flutterAssetsDir + File.separator + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ResourceExtractor initResources(@NonNull Context context) {
        return null;
    }

    private static boolean isLeakVM(@Nullable Bundle bundle) {
        if (bundle == null) {
            return true;
        }
        return bundle.getBoolean(LEAK_VM_META_DATA_KEY, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$ensureInitializationCompleteAsync$0(Context context, String[] strArr, Handler handler, Runnable runnable) {
        ensureInitializationComplete(context.getApplicationContext(), strArr);
        handler.post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$ensureInitializationCompleteAsync$1(final Context context, final String[] strArr, final Handler handler, final Runnable runnable) {
        try {
            this.initResultFuture.get();
            HandlerCompat.createAsyncHandler(Looper.getMainLooper()).post(new Runnable() { // from class: io.flutter.embedding.engine.loader.b
                @Override // java.lang.Runnable
                public final void run() {
                    FlutterLoader.this.lambda$ensureInitializationCompleteAsync$0(context, strArr, handler, runnable);
                }
            });
        } catch (Exception e2) {
            Log.e(TAG, "Flutter initialization failed.", e2);
            throw new RuntimeException(e2);
        }
    }

    @NonNull
    public boolean automaticallyRegisterPlugins() {
        return this.flutterApplicationInfo.automaticallyRegisterPlugins;
    }

    public void ensureInitializationComplete(@NonNull Context context, @Nullable String[] strArr) {
        if (this.initialized) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (this.settings != null) {
                try {
                    TraceSection scoped = TraceSection.scoped("FlutterLoader#ensureInitializationComplete");
                    try {
                        InitResult initResult = this.initResultFuture.get();
                        ArrayList arrayList = new ArrayList();
                        arrayList.add("--icu-symbol-prefix=_binary_icudtl_dat");
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("--icu-native-lib-path=");
                        sb2.append(this.flutterApplicationInfo.nativeLibraryDir);
                        String str = File.separator;
                        sb2.append(str);
                        sb2.append(DEFAULT_LIBRARY);
                        arrayList.add(sb2.toString());
                        if (strArr != null) {
                            Collections.addAll(arrayList, strArr);
                        }
                        arrayList.add("--aot-shared-library-name=" + this.flutterApplicationInfo.aotSharedLibraryName);
                        arrayList.add("--aot-shared-library-name=" + this.flutterApplicationInfo.nativeLibraryDir + str + this.flutterApplicationInfo.aotSharedLibraryName);
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("--cache-dir-path=");
                        sb3.append(initResult.engineCachesPath);
                        arrayList.add(sb3.toString());
                        if (this.flutterApplicationInfo.domainNetworkPolicy != null) {
                            arrayList.add("--domain-network-policy=" + this.flutterApplicationInfo.domainNetworkPolicy);
                        }
                        if (this.settings.getLogTag() != null) {
                            arrayList.add("--log-tag=" + this.settings.getLogTag());
                        }
                        Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                        int i10 = bundle != null ? bundle.getInt(OLD_GEN_HEAP_SIZE_META_DATA_KEY) : 0;
                        if (i10 == 0) {
                            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(new ActivityManager.MemoryInfo());
                            i10 = (int) ((r6.totalMem / 1000000.0d) / 2.0d);
                        }
                        arrayList.add("--old-gen-heap-size=" + i10);
                        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                        arrayList.add("--resource-cache-max-bytes-threshold=" + (displayMetrics.widthPixels * displayMetrics.heightPixels * 12 * 4));
                        arrayList.add("--prefetched-default-font-manager");
                        if (bundle != null) {
                            if (bundle.getBoolean(ENABLE_IMPELLER_META_DATA_KEY, false)) {
                                arrayList.add(FlutterShellArgs.ARG_ENABLE_IMPELLER);
                            }
                            if (bundle.getBoolean(ENABLE_VULKAN_VALIDATION_META_DATA_KEY, areValidationLayersOnByDefault())) {
                                arrayList.add(FlutterShellArgs.ARG_ENABLE_VULKAN_VALIDATION);
                            }
                            if (bundle.getBoolean(IMPELLER_OPENGL_GPU_TRACING_DATA_KEY, false)) {
                                arrayList.add("--enable-opengl-gpu-tracing");
                            }
                            String string = bundle.getString(IMPELLER_BACKEND_META_DATA_KEY);
                            if (string != null) {
                                arrayList.add("--impeller-backend=" + string);
                            }
                        }
                        arrayList.add("--leak-vm=" + (isLeakVM(bundle) ? "true" : "false"));
                        this.flutterJNI.init(context, (String[]) arrayList.toArray(new String[0]), null, initResult.appStoragePath, initResult.engineCachesPath, SystemClock.uptimeMillis() - this.initStartTimestampMillis);
                        this.initialized = true;
                        if (scoped != null) {
                            scoped.close();
                            return;
                        }
                        return;
                    } finally {
                    }
                } catch (Exception e2) {
                    Log.e(TAG, "Flutter initialization failed.", e2);
                    throw new RuntimeException(e2);
                }
            }
            throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
        }
        throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
    }

    public void ensureInitializationCompleteAsync(@NonNull final Context context, @Nullable final String[] strArr, @NonNull final Handler handler, @NonNull final Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (this.settings != null) {
                if (this.initialized) {
                    handler.post(runnable);
                    return;
                } else {
                    this.executorService.execute(new Runnable() { // from class: io.flutter.embedding.engine.loader.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            FlutterLoader.this.lambda$ensureInitializationCompleteAsync$1(context, strArr, handler, runnable);
                        }
                    });
                    return;
                }
            }
            throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
        }
        throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
    }

    @NonNull
    public String findAppBundlePath() {
        return this.flutterApplicationInfo.flutterAssetsDir;
    }

    @NonNull
    public String getLookupKeyForAsset(@NonNull String str) {
        return fullAssetPathFrom(str);
    }

    public boolean initialized() {
        return this.initialized;
    }

    public void startInitialization(@NonNull Context context) {
        startInitialization(context, new Settings());
    }

    public FlutterLoader(@NonNull FlutterJNI flutterJNI) {
        this(flutterJNI, FlutterInjector.instance().executorService());
    }

    @NonNull
    public String getLookupKeyForAsset(@NonNull String str, @NonNull String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("packages");
        String str3 = File.separator;
        sb2.append(str3);
        sb2.append(str2);
        sb2.append(str3);
        sb2.append(str);
        return getLookupKeyForAsset(sb2.toString());
    }

    public void startInitialization(@NonNull Context context, @NonNull Settings settings) {
        if (this.settings != null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            TraceSection scoped = TraceSection.scoped("FlutterLoader#startInitialization");
            try {
                Context applicationContext = context.getApplicationContext();
                this.settings = settings;
                this.initStartTimestampMillis = SystemClock.uptimeMillis();
                this.flutterApplicationInfo = ApplicationInfoLoader.load(applicationContext);
                VsyncWaiter.getInstance((DisplayManager) applicationContext.getSystemService(Attributes.Style.DISPLAY), this.flutterJNI).init();
                this.initResultFuture = this.executorService.submit(new AnonymousClass1(applicationContext));
                if (scoped != null) {
                    scoped.close();
                    return;
                }
                return;
            } catch (Throwable th) {
                if (scoped != null) {
                    try {
                        scoped.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        throw new IllegalStateException("startInitialization must be called on the main thread");
    }

    public FlutterLoader(@NonNull FlutterJNI flutterJNI, @NonNull ExecutorService executorService) {
        this.initialized = false;
        this.flutterJNI = flutterJNI;
        this.executorService = executorService;
    }
}
