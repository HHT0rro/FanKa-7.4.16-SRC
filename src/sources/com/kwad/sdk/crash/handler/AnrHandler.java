package com.kwad.sdk.crash.handler;

import android.app.ActivityManager;
import android.os.Build;
import android.os.FileObserver;
import android.os.Looper;
import android.os.Process;
import android.util.Printer;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.e;
import com.kwad.sdk.crash.f;
import com.kwad.sdk.crash.model.message.AnrExceptionMessage;
import com.kwad.sdk.crash.model.message.AnrReason;
import com.kwad.sdk.crash.utils.g;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.q;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class AnrHandler extends b {
    private static final String ANR_HAPPENED_BEGIN = "------ ANR Happened Begin ------\n";
    private static final String DEFAULT_TRACE_ROOT = "/data/anr/";
    private static final long GET_REASON_INTERVAL = 500;
    private static final long PARSE_TRACE_INTERVAL = 10000;
    private static final String TAG = "AnrHandler";
    private static final long TRY_TIMES = 20;
    private static long sLastTime;
    private FileObserver mTraceFileObserver;
    private static final int MY_PID = Process.myPid();
    private static final Pattern PID_PATTERN = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
    private static final boolean DUMP_FROM_SIG_QUIT = SystemUtil.ed(21);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {
        private static final AnrHandler aFW = new AnrHandler();
    }

    private static synchronized void dumpAnr(@Nullable String str, int i10) {
        synchronized (AnrHandler.class) {
            com.kwad.sdk.core.e.c.d(TAG, "ANR dumpAnr tracePath=" + str + " index=" + i10);
            AnrExceptionMessage anrExceptionMessage = new AnrExceptionMessage();
            File file = getInstance().mLogDir;
            boolean z10 = true;
            try {
                if (!file.exists() && !file.mkdirs()) {
                    com.kwad.sdk.core.e.c.d(TAG, "ANR dumpAnr create dir failed.");
                    anrExceptionMessage.mErrorMessage += "create " + file.getPath() + " failed!\n";
                    z10 = false;
                }
                if (str != null && z10) {
                    StringBuilder sb2 = new StringBuilder();
                    getInstance();
                    String str2 = b.FILE_NAME_BASE;
                    sb2.append(str2);
                    sb2.append("-");
                    sb2.append(i10);
                    sb2.append(".dump");
                    q.f(new File(str), new File(file, sb2.toString()));
                    StringBuilder sb3 = new StringBuilder();
                    getInstance();
                    sb3.append(str2);
                    sb3.append("-");
                    sb3.append(i10);
                    sb3.append(".log");
                    g.E(new File(file, sb3.toString()));
                }
                g.b(null, anrExceptionMessage, e.Hu().getContext());
                g.a(anrExceptionMessage, 3);
                if (getInstance().mExceptionListener != null) {
                    getInstance().mExceptionListener.a(getInstance().getCrashType(), anrExceptionMessage);
                }
            } catch (Throwable th) {
                try {
                    anrExceptionMessage.mErrorMessage += ((Object) th);
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                } finally {
                    dumpAnrReason(str, i10, anrExceptionMessage, z10);
                }
            }
        }
    }

    private static void dumpAnrReason(@Nullable String str, int i10, @NonNull AnrExceptionMessage anrExceptionMessage, boolean z10) {
        com.kwad.sdk.core.e.c.d(TAG, "ANR dumpAnrReason tracePath=" + str + " index=" + i10 + " dirReady=" + z10);
        com.kwad.sdk.crash.report.e uploader = getInstance().getUploader();
        try {
            File file = getInstance().mLogDir;
            final StringBuilder sb2 = new StringBuilder();
            Looper.getMainLooper().dump(new Printer() { // from class: com.kwad.sdk.crash.handler.AnrHandler.2
                @Override // android.util.Printer
                public final void println(String str2) {
                    StringBuilder sb3 = StringBuilder.this;
                    sb3.append(str2);
                    sb3.append("\n");
                }
            }, "");
            anrExceptionMessage.mMessageQueueDetail = sb2.substring(0, sb2.length() - 1);
            String jSONObject = anrExceptionMessage.toJson().toString();
            StringBuilder sb3 = new StringBuilder();
            getInstance();
            String str2 = b.FILE_NAME_BASE;
            sb3.append(str2);
            sb3.append("-");
            sb3.append(i10);
            sb3.append(".dump");
            File file2 = new File(file, sb3.toString());
            if (z10) {
                StringBuilder sb4 = new StringBuilder();
                getInstance();
                sb4.append(str2);
                sb4.append("-");
                sb4.append(i10);
                sb4.append(".msg");
                File file3 = new File(file, sb4.toString());
                StringBuilder sb5 = new StringBuilder();
                getInstance();
                sb5.append(str2);
                sb5.append("-");
                sb5.append(i10);
                sb5.append(".minfo");
                File file4 = new File(file, sb5.toString());
                g.a(file3, jSONObject);
                getInstance().backupLogFiles(file);
                if (uploader != null) {
                    anrExceptionMessage.toString();
                }
                g.a(uploader, TAG, file2);
                getInstance().uploadRemainingExceptions();
                g.H(file4);
            } else if (uploader != null) {
                if (str != null) {
                    uploader.a(anrExceptionMessage, null);
                }
                anrExceptionMessage.toString();
            }
            StringBuilder sb6 = new StringBuilder();
            getInstance();
            sb6.append(str2);
            sb6.append("-");
            sb6.append(i10);
            sb6.append(".anr");
            getAnrReason(str, new File(file, sb6.toString()));
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            if (uploader != null) {
                g.r(th);
            }
        }
    }

    private static void getAnrReason(@Nullable String str, final File file) {
        com.kwad.sdk.core.e.c.d(TAG, "ANR getAnrReason");
        if (str == null) {
            com.kwad.sdk.utils.g.schedule(new Runnable() { // from class: com.kwad.sdk.crash.handler.AnrHandler.3
                @Override // java.lang.Runnable
                public final void run() {
                    AnrHandler.getAnrReasonInner(null, File.this);
                }
            }, 0L, TimeUnit.MILLISECONDS);
        } else {
            getAnrReasonInner(str, file);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void getAnrReasonInner(@Nullable String str, File file) {
        com.kwad.sdk.core.e.c.d(TAG, "ANR getAnrReasonInner");
        getInstance().getUploader();
        if (str != null) {
            try {
                long lastModified = new File(str).lastModified();
                if (Math.abs(lastModified - sLastTime) < PARSE_TRACE_INTERVAL) {
                    return;
                } else {
                    sLastTime = lastModified;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        ActivityManager activityManager = (ActivityManager) e.Hu().getContext().getSystemService("activity");
        ActivityManager.ProcessErrorStateInfo processErrorStateInfo = null;
        if (activityManager == null) {
            return;
        }
        for (int i10 = 0; i10 < TRY_TIMES; i10++) {
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
            if (processesInErrorState != null) {
                Iterator<ActivityManager.ProcessErrorStateInfo> iterator2 = processesInErrorState.iterator2();
                while (true) {
                    if (!iterator2.hasNext()) {
                        break;
                    }
                    ActivityManager.ProcessErrorStateInfo next = iterator2.next();
                    if (next.condition == 2) {
                        processErrorStateInfo = next;
                        break;
                    }
                }
            }
            if (processErrorStateInfo != null) {
                break;
            }
            Thread.sleep(500L);
        }
        if (processErrorStateInfo != null && processErrorStateInfo.pid == MY_PID) {
            AnrReason anrReason = new AnrReason();
            anrReason.mTag = processErrorStateInfo.tag;
            anrReason.mShortMsg = processErrorStateInfo.shortMsg;
            anrReason.mLongMsg = processErrorStateInfo.longMsg;
            g.a(file, anrReason.toJson().toString());
        }
    }

    public static AnrHandler getInstance() {
        return a.aFW;
    }

    public static native void install(String str, int i10);

    @Keep
    public static void onCallFromNative(int i10) {
        com.kwad.sdk.core.e.c.d(TAG, "ANR onCallFromNative index=" + i10);
        dumpAnr(null, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTraceFileWritten(String str) {
        com.kwad.sdk.core.e.c.d(TAG, "ANR onTraceFileWritten");
        if (parseTraceFile(str)) {
            dumpAnr(str, this.mIndex.getAndIncrement());
        }
    }

    private boolean parseTraceFile(String str) {
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(str));
                int i10 = -1;
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (PID_PATTERN.matcher(readLine).matches()) {
                            i10 = Integer.parseInt(readLine.split("\\s")[2]);
                            break;
                        }
                    } catch (FileNotFoundException unused) {
                        bufferedReader = bufferedReader2;
                        getUploader();
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return false;
                    } catch (IOException unused2) {
                        bufferedReader = bufferedReader2;
                        getUploader();
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        throw th;
                    }
                }
                boolean z10 = i10 == MY_PID;
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                return z10;
            } catch (FileNotFoundException unused3) {
            } catch (IOException unused4) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void watchTraceFile() {
        com.kwad.sdk.core.e.c.d(TAG, "ANR watchTraceFile");
        FileObserver fileObserver = new FileObserver(DEFAULT_TRACE_ROOT, 8) { // from class: com.kwad.sdk.crash.handler.AnrHandler.1
            @Override // android.os.FileObserver
            public final void onEvent(int i10, @Nullable String str) {
                if (str != null) {
                    AnrHandler.this.onTraceFileWritten(AnrHandler.DEFAULT_TRACE_ROOT + str);
                }
            }
        };
        this.mTraceFileObserver = fileObserver;
        try {
            fileObserver.startWatching();
        } catch (Throwable unused) {
            getInstance().getUploader();
        }
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final int getCrashType() {
        return 3;
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final void init(File file, f fVar, com.kwad.sdk.crash.report.e eVar) {
        super.init(file, fVar, eVar);
        if (com.kwad.sdk.crash.b.Hd()) {
            com.kwad.sdk.core.e.c.d(TAG, "ANR init ");
            this.mLogDir = file;
            if (!file.exists()) {
                this.mLogDir.mkdirs();
            }
            File file2 = new File(this.mLogDir, b.FILE_NAME_BASE);
            if (!DUMP_FROM_SIG_QUIT) {
                watchTraceFile();
                return;
            }
            try {
                install(file2.getPath(), Build.VERSION.SDK_INT);
            } catch (Throwable unused) {
                getUploader();
            }
        }
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final void reportException(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch) {
        com.kwad.sdk.crash.report.b bVar = new com.kwad.sdk.crash.report.b();
        bVar.a(getUploader());
        for (File file : fileArr) {
            bVar.a(file, countDownLatch);
        }
    }

    private AnrHandler() {
    }
}
