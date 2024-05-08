package com.kwad.sdk.crash.handler;

import android.os.Build;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.NativeExceptionMessage;
import com.kwad.sdk.crash.report.e;
import com.kwad.sdk.crash.utils.g;
import java.io.File;
import java.util.concurrent.CountDownLatch;

@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class NativeCrashHandler extends b {
    private static final String NATIVE_CRASH_HAPPENED_BEGIN = "------ Native Crash Happened Begin ------\n";
    private static final String TAG = "NativeCrashHandler";
    private static ExceptionMessage mMessage = new NativeExceptionMessage();
    private File mMessageFile;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {
        private static final NativeCrashHandler aFZ = new NativeCrashHandler();
    }

    public static native void doCrash();

    public static NativeCrashHandler getInstance() {
        return a.aFZ;
    }

    public static native void install(@NonNull String str, boolean z10, @NonNull String str2, int i10);

    @Keep
    public static void onCallFromNative() {
        com.kwad.sdk.core.e.c.d(TAG, "onCallFromNative NativeCrashHandler.doCrash()");
        File file = getInstance().mLogDir;
        File file2 = getInstance().mMessageFile;
        File file3 = getInstance().mJavaTraceFile;
        File file4 = getInstance().mMemoryInfoFile;
        e uploader = getInstance().getUploader();
        try {
            if (!file.exists() && !file.mkdirs()) {
                StringBuilder sb2 = new StringBuilder();
                ExceptionMessage exceptionMessage = mMessage;
                sb2.append(exceptionMessage.mErrorMessage);
                sb2.append("create ");
                sb2.append(file.getPath());
                sb2.append(" failed!\n");
                exceptionMessage.mErrorMessage = sb2.toString();
                if (uploader != null) {
                    mMessage.toJson();
                }
            }
            if (file2 == null) {
                StringBuilder sb3 = new StringBuilder();
                getInstance();
                sb3.append(b.FILE_NAME_BASE);
                sb3.append(".msg");
                file2 = new File(file, sb3.toString());
            }
            if (file3 == null) {
                StringBuilder sb4 = new StringBuilder();
                getInstance();
                sb4.append(b.FILE_NAME_BASE);
                sb4.append(".jtrace");
                file3 = new File(file, sb4.toString());
            }
            if (file4 == null) {
                StringBuilder sb5 = new StringBuilder();
                getInstance();
                sb5.append(b.FILE_NAME_BASE);
                sb5.append(".minfo");
                file4 = new File(file, sb5.toString());
            }
            g.b(null, mMessage, com.kwad.sdk.crash.e.Hu().getContext());
            g.a(mMessage, getInstance().getCrashType());
            if (getInstance().mExceptionListener != null) {
                getInstance().mExceptionListener.a(getInstance().getCrashType(), mMessage);
            }
            try {
                g.a(file2, mMessage.toJson().toString());
                g.G(file3);
                getInstance().backupLogFiles(file);
                g.a(uploader, TAG, getInstance().mDumpFile);
                getInstance().uploadRemainingExceptions();
                g.H(file4);
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                if (uploader != null) {
                    g.r(th);
                }
            }
        } catch (Throwable th2) {
            try {
                StringBuilder sb6 = new StringBuilder();
                ExceptionMessage exceptionMessage2 = mMessage;
                sb6.append(exceptionMessage2.mErrorMessage);
                sb6.append((Object) th2);
                exceptionMessage2.mErrorMessage = sb6.toString();
                com.kwad.sdk.core.e.c.printStackTraceOnly(th2);
            } finally {
                if (file2 != null) {
                    try {
                        g.a(file2, mMessage.toJson().toString());
                    } catch (Throwable th3) {
                        com.kwad.sdk.core.e.c.printStackTraceOnly(th3);
                        if (uploader != null) {
                            g.r(th3);
                        }
                    }
                }
                g.G(file3);
                getInstance().backupLogFiles(file);
                g.a(uploader, TAG, getInstance().mDumpFile);
                getInstance().uploadRemainingExceptions();
                g.H(file4);
            }
        }
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final int getCrashType() {
        return 4;
    }

    public final void init(@NonNull File file, boolean z10, @NonNull String str, com.kwad.sdk.crash.report.c cVar) {
        super.init(file, null, cVar);
        if (com.kwad.sdk.crash.b.Hd()) {
            this.mLogDir = file;
            if (!file.exists()) {
                this.mLogDir.mkdirs();
            }
            StringBuilder sb2 = new StringBuilder();
            String str2 = b.FILE_NAME_BASE;
            sb2.append(str2);
            sb2.append(".dump");
            this.mDumpFile = new File(file, sb2.toString());
            this.mJavaTraceFile = new File(file, str2 + ".jtrace");
            this.mMemoryInfoFile = new File(file, str2 + ".minfo");
            try {
                com.kwad.sdk.core.e.c.d(TAG, "ANR init2 " + this.mDumpFile.getPath());
                install(this.mDumpFile.getPath(), z10, str, Build.VERSION.SDK_INT);
                this.mMessageFile = new File(file, str2 + ".msg");
            } catch (Throwable unused) {
                getUploader();
            }
        }
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final void reportException(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch) {
        com.kwad.sdk.crash.report.g gVar = new com.kwad.sdk.crash.report.g();
        gVar.a(getUploader());
        for (File file : fileArr) {
            gVar.a(file, countDownLatch);
        }
    }

    private NativeCrashHandler() {
    }
}
