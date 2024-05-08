package com.kwad.sdk.crash.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.MemoryInfo;
import com.kwad.sdk.crash.model.message.ThreadInfo;
import com.kwad.sdk.utils.m;
import com.kwad.sdk.utils.q;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class d {
    public String mErrorMessage = "";
    public e mUploader;

    private static void b(File file, @Nullable CountDownLatch countDownLatch) {
        com.kwad.sdk.crash.report.upload.d.a(file, true, countDownLatch);
    }

    private static String fC(String str) {
        return (str == null || !str.contains("-")) ? str : str.substring(0, str.lastIndexOf(45));
    }

    public final void C(File file) {
        com.kwad.sdk.core.e.c.d("AdExceptionCollector", "reportException dir =" + ((Object) file));
        File[] listFiles = file.listFiles(new FileFilter() { // from class: com.kwad.sdk.crash.report.d.1
            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                return file2.getName().endsWith(".dump");
            }
        });
        if (listFiles != null) {
            for (File file2 : listFiles) {
                a(file2, (CountDownLatch) null);
            }
        }
    }

    public abstract ExceptionMessage a(@NonNull File file, File file2, File file3, String str);

    public final void a(e eVar) {
        this.mUploader = eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(File file, @Nullable CountDownLatch countDownLatch) {
        String fG = com.kwad.sdk.crash.utils.g.fG(file.getPath());
        File file2 = new File(fG + ".msg");
        File file3 = new File(fG + ".log");
        File file4 = new File(fG + ".blog");
        File file5 = new File(fG + ".jtrace");
        File file6 = new File(fG + ".minfo");
        ArrayList arrayList = new ArrayList();
        try {
            ExceptionMessage a10 = a(file, file2, file3, fG);
            if (a10 == null) {
                try {
                    q.delete(file.getPath());
                    q.delete(file3.getPath());
                    q.delete(file4.getPath());
                    q.delete(file2.getPath());
                    q.delete(file5.getPath());
                    q.delete(file6.getPath());
                    Iterator<E> iterator2 = arrayList.iterator2();
                    while (iterator2.hasNext()) {
                        q.delete(((File) iterator2.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.F(com.kwad.sdk.crash.handler.b.sBackupDir);
                    return;
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                    return;
                }
            }
            com.kwad.sdk.core.e.c.d("AdExceptionCollector", "message.mCrashSource=" + a10.mCrashSource);
            if (a10.mCrashSource == 2) {
                try {
                    q.delete(file.getPath());
                    q.delete(file3.getPath());
                    q.delete(file4.getPath());
                    q.delete(file2.getPath());
                    q.delete(file5.getPath());
                    q.delete(file6.getPath());
                    Iterator<E> iterator22 = arrayList.iterator2();
                    while (iterator22.hasNext()) {
                        q.delete(((File) iterator22.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.F(com.kwad.sdk.crash.handler.b.sBackupDir);
                    return;
                } catch (Throwable th2) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th2);
                    return;
                }
            }
            this.mUploader.a(a10, countDownLatch);
            if (this instanceof f) {
                com.kwad.sdk.core.e.c.d("AdExceptionCollector", " java crash 不上传文件");
                try {
                    q.delete(file.getPath());
                    q.delete(file3.getPath());
                    q.delete(file4.getPath());
                    q.delete(file2.getPath());
                    q.delete(file5.getPath());
                    q.delete(file6.getPath());
                    Iterator<E> iterator23 = arrayList.iterator2();
                    while (iterator23.hasNext()) {
                        q.delete(((File) iterator23.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.F(com.kwad.sdk.crash.handler.b.sBackupDir);
                    return;
                } catch (Throwable th3) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th3);
                    return;
                }
            }
            com.kwad.sdk.crash.utils.g.E(file4);
            List<File> arrayList2 = new ArrayList<>();
            Collections.addAll(arrayList2, file3, file4);
            Iterator<E> iterator24 = arrayList2.iterator2();
            while (iterator24.hasNext()) {
                if (!((File) iterator24.next()).exists()) {
                    iterator24.remove();
                }
            }
            File file7 = new File(file.getParentFile().getParent(), "custom");
            if (file7.exists()) {
                for (File file8 : file7.listFiles()) {
                    if (!file8.isDirectory() && (file8.getName().startsWith(a10.mLogUUID) || file8.getName().startsWith(fC(a10.mLogUUID)))) {
                        arrayList.add(file8);
                    }
                }
                arrayList2.addAll(arrayList);
            }
            a(a10, arrayList2, countDownLatch);
            try {
                q.delete(file.getPath());
                q.delete(file3.getPath());
                q.delete(file4.getPath());
                q.delete(file2.getPath());
                q.delete(file5.getPath());
                q.delete(file6.getPath());
                Iterator<E> iterator25 = arrayList.iterator2();
                while (iterator25.hasNext()) {
                    q.delete(((File) iterator25.next()).getPath());
                }
                com.kwad.sdk.crash.utils.g.F(com.kwad.sdk.crash.handler.b.sBackupDir);
            } catch (Throwable th4) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(th4);
            }
        } catch (Throwable th5) {
            try {
                com.kwad.sdk.core.e.c.printStackTraceOnly(th5);
                com.kwad.sdk.crash.utils.g.r(th5);
                try {
                    q.delete(file.getPath());
                    q.delete(file3.getPath());
                    q.delete(file4.getPath());
                    q.delete(file2.getPath());
                    q.delete(file5.getPath());
                    q.delete(file6.getPath());
                    Iterator<E> iterator26 = arrayList.iterator2();
                    while (iterator26.hasNext()) {
                        q.delete(((File) iterator26.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.F(com.kwad.sdk.crash.handler.b.sBackupDir);
                } catch (Throwable th6) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th6);
                }
            } catch (Throwable th7) {
                try {
                    q.delete(file.getPath());
                    q.delete(file3.getPath());
                    q.delete(file4.getPath());
                    q.delete(file2.getPath());
                    q.delete(file5.getPath());
                    q.delete(file6.getPath());
                    Iterator<E> iterator27 = arrayList.iterator2();
                    while (iterator27.hasNext()) {
                        q.delete(((File) iterator27.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.F(com.kwad.sdk.crash.handler.b.sBackupDir);
                    throw th7;
                } catch (Throwable th8) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th8);
                    throw th7;
                }
            }
        }
    }

    public final void b(File file, ExceptionMessage exceptionMessage) {
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        StringBuilder sb6;
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                boolean z10 = false;
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            if (!z10 && readLine.contains("JNI DETECTED ERROR IN APPLICATION")) {
                                exceptionMessage.mJNIError = readLine.substring(readLine.indexOf("JNI DETECTED ERROR IN APPLICATION"));
                                z10 = true;
                            } else {
                                if (!readLine.contains("Waiting for a blocking GC ") && !readLine.contains("WaitForGcToComplete")) {
                                    if (readLine.contains("dvm_lock_sample")) {
                                        if (TextUtils.isEmpty(exceptionMessage.mLockInfo)) {
                                            sb3 = new StringBuilder();
                                            sb3.append(readLine);
                                            sb3.append("\n");
                                        } else {
                                            sb3 = new StringBuilder();
                                            sb3.append(exceptionMessage.mLockInfo);
                                            sb3.append(readLine);
                                            sb3.append("\n");
                                        }
                                        exceptionMessage.mLockInfo = sb3.toString();
                                    } else if (readLine.contains("Long monitor")) {
                                        if (TextUtils.isEmpty(exceptionMessage.mMonitorInfo)) {
                                            sb4 = new StringBuilder();
                                            sb4.append(readLine);
                                            sb4.append("\n");
                                        } else {
                                            sb4 = new StringBuilder();
                                            sb4.append(exceptionMessage.mMonitorInfo);
                                            sb4.append(readLine);
                                            sb4.append("\n");
                                        }
                                        exceptionMessage.mMonitorInfo = sb4.toString();
                                    } else if (readLine.contains("Slow Looper")) {
                                        if (TextUtils.isEmpty(exceptionMessage.mSlowLooper)) {
                                            sb5 = new StringBuilder();
                                            sb5.append(readLine);
                                            sb5.append("\n");
                                        } else {
                                            sb5 = new StringBuilder();
                                            sb5.append(exceptionMessage.mSlowLooper);
                                            sb5.append(readLine);
                                            sb5.append("\n");
                                        }
                                        exceptionMessage.mSlowLooper = sb5.toString();
                                    } else if (readLine.contains("Slow Operation")) {
                                        if (TextUtils.isEmpty(exceptionMessage.mSlowOperation)) {
                                            sb6 = new StringBuilder();
                                            sb6.append(readLine);
                                            sb6.append("\n");
                                        } else {
                                            sb6 = new StringBuilder();
                                            sb6.append(exceptionMessage.mSlowOperation);
                                            sb6.append(readLine);
                                            sb6.append("\n");
                                        }
                                        exceptionMessage.mSlowOperation = sb6.toString();
                                    }
                                }
                                if (TextUtils.isEmpty(exceptionMessage.mGCInfo)) {
                                    sb2 = new StringBuilder();
                                    sb2.append(readLine);
                                    sb2.append("\n");
                                } else {
                                    sb2 = new StringBuilder();
                                    sb2.append(exceptionMessage.mGCInfo);
                                    sb2.append(readLine);
                                    sb2.append("\n");
                                }
                                exceptionMessage.mGCInfo = sb2.toString();
                            }
                        } else {
                            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                            return;
                        }
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        bufferedReader = bufferedReader2;
                        this.mErrorMessage += ((Object) e) + "\n";
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return;
                    } catch (IOException e10) {
                        e = e10;
                        bufferedReader = bufferedReader2;
                        this.mErrorMessage += ((Object) e) + "\n";
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        throw th;
                    }
                }
            } catch (FileNotFoundException e11) {
                e = e11;
            } catch (IOException e12) {
                e = e12;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void a(ExceptionMessage exceptionMessage, @NonNull List<File> list, @Nullable CountDownLatch countDownLatch) {
        com.kwad.sdk.core.e.c.d("AdExceptionCollector", "compressAndUpload");
        File Hp = this.mUploader.Hp();
        if (!Hp.exists()) {
            Hp.mkdir();
        }
        File file = new File(Hp, exceptionMessage.mLogUUID + ".zip");
        StringBuilder sb2 = new StringBuilder("compressAndUpload zipFile=");
        sb2.append(file.getPath());
        com.kwad.sdk.core.e.c.d("AdExceptionCollector", sb2.toString());
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e2) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
            }
        }
        m.a((File[]) list.toArray(new File[0]), file.getPath());
        if (file.length() > 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("mLogUUID", exceptionMessage.mLogUUID);
            new JSONObject(hashMap);
            b(file, countDownLatch);
            return;
        }
        q.S(file);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(File file, ExceptionMessage exceptionMessage) {
        String readLine;
        String str;
        try {
            MemoryInfo memoryInfo = new MemoryInfo(exceptionMessage.mMemoryInfo);
            ArrayList arrayList = new ArrayList();
            BufferedReader bufferedReader = null;
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    BufferedReader bufferedReader3 = new BufferedReader(new FileReader(file));
                    try {
                        ThreadInfo threadInfo = new ThreadInfo();
                        while (true) {
                            readLine = bufferedReader3.readLine();
                            if (readLine == 0) {
                                break;
                            }
                            if (readLine.isEmpty()) {
                                arrayList.add(threadInfo);
                                threadInfo = new ThreadInfo();
                            } else {
                                if (!readLine.startsWith("at ") && !readLine.startsWith("(no ")) {
                                    threadInfo.mName = readLine;
                                }
                                if (threadInfo.mTrace == null) {
                                    str = readLine;
                                } else {
                                    str = threadInfo.mTrace + readLine;
                                }
                                threadInfo.mTrace = str;
                                threadInfo.mTrace += "#";
                            }
                        }
                        memoryInfo.mJavaThreads = arrayList;
                        exceptionMessage.mMemoryInfo = memoryInfo.toJson().toString();
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader3);
                        bufferedReader = readLine;
                    } catch (IOException e2) {
                        e = e2;
                        bufferedReader2 = bufferedReader3;
                        com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                        bufferedReader = bufferedReader2;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader3;
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        throw th;
                    }
                } catch (IOException e10) {
                    e = e10;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e11) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e11);
        }
    }
}
