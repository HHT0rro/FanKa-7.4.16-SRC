package com.alibaba.security.realidentity.build;

import android.content.Context;
import android.os.Environment;
import com.alibaba.security.biometrics.jni.VersionKey;
import com.alibaba.security.common.log.RPLogging;
import com.alibaba.security.common.track.RPTrack;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.common.utils.CommonUtils;
import com.alibaba.security.common.utils.FileUtils;
import com.alibaba.security.common.utils.JsonUtils;
import com.alibaba.security.realidentity.build.j;
import java.io.File;
import java.lang.Thread;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: RpCrashHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ao implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3087a = ao.class.getSimpleName();

    /* renamed from: b, reason: collision with root package name */
    private static final String f3088b = "rpsdk";

    /* renamed from: c, reason: collision with root package name */
    private static final String f3089c = "crash";

    /* renamed from: d, reason: collision with root package name */
    private final Context f3090d;

    /* renamed from: e, reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f3091e;

    /* renamed from: f, reason: collision with root package name */
    private final ThreadPoolExecutor f3092f;

    /* renamed from: g, reason: collision with root package name */
    private final CountDownLatch f3093g;

    /* compiled from: RpCrashHandler.java */
    /* renamed from: com.alibaba.security.realidentity.build.ao$3, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class AnonymousClass3 implements Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                String c4 = ao.c(ao.this);
                File file = new File(c4);
                if (file.exists() && file.length() != 0) {
                    TrackLog trackLog = (TrackLog) JsonUtils.parseObject(FileUtils.readStrFromFile(ao.this.f3090d, c4, false), TrackLog.class, true);
                    if (trackLog != null) {
                        RPTrack.t(trackLog);
                        RPTrack.uploadNow();
                    }
                    file.delete();
                }
            } catch (Exception unused) {
            }
        }
    }

    public ao(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Context context) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(10), new ThreadFactory() { // from class: com.alibaba.security.realidentity.build.ao.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "rpsdk-crash-handler");
            }
        });
        this.f3092f = threadPoolExecutor;
        this.f3093g = new CountDownLatch(1);
        this.f3091e = uncaughtExceptionHandler;
        this.f3090d = context;
        threadPoolExecutor.submit(new AnonymousClass3());
    }

    private String c() {
        return b() + File.separator + "crash";
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005b, code lost:
    
        if (r0.matches("com.taobao.*") == false) goto L28;
     */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void uncaughtException(java.lang.Thread r9, java.lang.Throwable r10) {
        /*
            r8 = this;
            java.lang.StackTraceElement[] r0 = r10.getStackTrace()
            int r1 = r0.length
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L61
            int r1 = r0.length
            r4 = 0
        Lb:
            if (r4 >= r1) goto L61
            r5 = r0[r4]
            java.lang.String r6 = r5.getClassName()
            java.lang.String r7 = "java.*"
            boolean r7 = r6.matches(r7)
            if (r7 != 0) goto L3e
            java.lang.String r7 = "javax.*"
            boolean r7 = r6.matches(r7)
            if (r7 != 0) goto L3e
            java.lang.String r7 = "android.*"
            boolean r7 = r6.matches(r7)
            if (r7 != 0) goto L3e
            java.lang.String r7 = "androidx.*"
            boolean r7 = r6.matches(r7)
            if (r7 != 0) goto L3e
            java.lang.String r7 = "dalvik.*"
            boolean r6 = r6.matches(r7)
            if (r6 == 0) goto L3c
            goto L3e
        L3c:
            r6 = 0
            goto L3f
        L3e:
            r6 = 1
        L3f:
            if (r6 != 0) goto L5e
            java.lang.String r0 = r5.getClassName()
            java.lang.String r1 = "com.alibaba.*"
            boolean r1 = r0.matches(r1)
            if (r1 != 0) goto L62
            java.lang.String r1 = "com.uc.*"
            boolean r1 = r0.matches(r1)
            if (r1 != 0) goto L62
            java.lang.String r1 = "com.taobao.*"
            boolean r0 = r0.matches(r1)
            if (r0 == 0) goto L61
            goto L62
        L5e:
            int r4 = r4 + 1
            goto Lb
        L61:
            r2 = 0
        L62:
            if (r2 == 0) goto L6f
            java.lang.String r0 = com.alibaba.security.realidentity.build.ao.f3087a
            java.lang.String r1 = "rp sdk crash"
            com.alibaba.security.common.log.RPLogging.d(r0, r1)
            r8.b(r10)
            goto L76
        L6f:
            java.lang.String r0 = com.alibaba.security.realidentity.build.ao.f3087a
            java.lang.String r1 = "not rp sdk crash"
            com.alibaba.security.common.log.RPLogging.d(r0, r1)
        L76:
            java.lang.Thread$UncaughtExceptionHandler r0 = r8.f3091e
            if (r0 == 0) goto L7d
            r0.uncaughtException(r9, r10)
        L7d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.realidentity.build.ao.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
    }

    private void a() {
        this.f3092f.submit(new AnonymousClass3());
    }

    private void b(final Throwable th) {
        this.f3092f.submit(new Runnable() { // from class: com.alibaba.security.realidentity.build.ao.2
            @Override // java.lang.Runnable
            public final void run() {
                TrackLog createSdkCrashLog = TrackLog.createSdkCrashLog(CommonUtils.getStackTrace(th));
                createSdkCrashLog.setVerifyToken(j.a.f3944a.f3895e);
                createSdkCrashLog.addTag9(VersionKey.RP_SDK_VERSION + "/3.3.0");
                createSdkCrashLog.addTag10("Android");
                String json = JsonUtils.toJSON(createSdkCrashLog);
                if (json != null) {
                    FileUtils.saveBytes2File(ao.this.b(), json.getBytes(), "crash");
                }
                ao.this.f3093g.countDown();
            }
        });
        try {
            this.f3093g.await();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    private static boolean c(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace.length != 0) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                String className = stackTraceElement.getClassName();
                if (!(className.matches("java.*") || className.matches("javax.*") || className.matches("android.*") || className.matches("androidx.*") || className.matches("dalvik.*"))) {
                    String className2 = stackTraceElement.getClassName();
                    return className2.matches("com.alibaba.*") || className2.matches("com.uc.*") || className2.matches("com.taobao.*");
                }
            }
        }
        return false;
    }

    private static boolean a(String str) {
        return str.matches("com.alibaba.*") || str.matches("com.uc.*") || str.matches("com.taobao.*");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f3090d.getExternalCacheDir().getPath());
            String str = File.separator;
            sb2.append(str);
            sb2.append("rpsdk");
            sb2.append(str);
            return sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(this.f3090d.getCacheDir().getPath());
        String str2 = File.separator;
        sb3.append(str2);
        sb3.append("rpsdk");
        sb3.append(str2);
        return sb3.toString();
    }

    private boolean a(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        boolean z10 = false;
        if (stackTrace.length != 0) {
            int length = stackTrace.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                StackTraceElement stackTraceElement = stackTrace[i10];
                String className = stackTraceElement.getClassName();
                if (className.matches("java.*") || className.matches("javax.*") || className.matches("android.*") || className.matches("androidx.*") || className.matches("dalvik.*")) {
                    i10++;
                } else {
                    String className2 = stackTraceElement.getClassName();
                    if (className2.matches("com.alibaba.*") || className2.matches("com.uc.*") || className2.matches("com.taobao.*")) {
                        z10 = true;
                    }
                }
            }
        }
        if (z10) {
            RPLogging.d(f3087a, "rp sdk crash");
            b(th);
        } else {
            RPLogging.d(f3087a, "not rp sdk crash");
        }
        return true;
    }

    private static boolean b(String str) {
        return str.matches("java.*") || str.matches("javax.*") || str.matches("android.*") || str.matches("androidx.*") || str.matches("dalvik.*");
    }

    public static /* synthetic */ String c(ao aoVar) {
        return aoVar.b() + File.separator + "crash";
    }
}
