package com.kwad.sdk.crash.utils;

import android.content.Context;
import android.os.Debug;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.system.Os;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.model.message.DiskInfo;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.JavaExceptionMessage;
import com.kwad.sdk.crash.model.message.MemoryInfo;
import com.kwad.sdk.crash.model.message.NativeExceptionMessage;
import com.kwad.sdk.crash.model.message.ThreadInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.q;
import com.kwad.sdk.utils.s;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class g {
    private static final String TAG = "g";
    private static final File aHO = new File("/proc/self/fd");
    private static final File aHP = new File("/proc/self/task");

    private g() {
    }

    public static void E(File file) {
        try {
            d.a(SystemUtil.ed(21) ? new String[]{"logcat", "-v", "threadtime", "-b", "main", "-b", "system", "-b", "events", "-b", "crash", "-d", "-f", file.getPath()} : new String[]{"logcat", "-v", "threadtime", "-b", "main", "-b", "system", "-b", "events", "-d", "-f", file.getPath()}, 0);
        } catch (IOException e2) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
        }
    }

    public static void F(File file) {
        if (file == null) {
            return;
        }
        try {
            q.T(file);
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
        }
    }

    public static void G(File file) {
        try {
            q.P(file);
            BufferedWriter bufferedWriter = null;
            try {
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file, true));
                    try {
                        for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                            String b4 = b(entry.getValue());
                            if (b4.isEmpty()) {
                                b4 = "(no managed stack frames)\n";
                            }
                            bufferedWriter2.write(entry.getKey().getName());
                            bufferedWriter2.newLine();
                            bufferedWriter2.write(b4);
                            bufferedWriter2.newLine();
                        }
                        b.closeQuietly(bufferedWriter2);
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        bufferedWriter = bufferedWriter2;
                        com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                        b.closeQuietly(bufferedWriter);
                    } catch (IOException e10) {
                        e = e10;
                        bufferedWriter = bufferedWriter2;
                        com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                        b.closeQuietly(bufferedWriter);
                    } catch (Throwable th) {
                        th = th;
                        bufferedWriter = bufferedWriter2;
                        b.closeQuietly(bufferedWriter);
                        throw th;
                    }
                } catch (FileNotFoundException e11) {
                    e = e11;
                } catch (IOException e12) {
                    e = e12;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e13) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e13);
        }
    }

    public static void H(File file) {
        try {
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            Object field = s.getField(s.a("android.app.ActivityThread", "currentActivityThread", new Object[0]), "mAppThread");
            ParcelFileDescriptor open = ParcelFileDescriptor.open(file, 1006632960);
            FileDescriptor fileDescriptor = open;
            if (!SystemUtil.ed(26)) {
                fileDescriptor = open.getFileDescriptor();
            }
            if (SystemUtil.ed(24)) {
                Boolean bool = Boolean.FALSE;
                Boolean bool2 = Boolean.TRUE;
                s.callMethod(field, "dumpMemInfo", fileDescriptor, memoryInfo, bool, bool2, bool2, bool, bool, new String[0]);
            } else if (SystemUtil.ed(23)) {
                Boolean bool3 = Boolean.FALSE;
                Boolean bool4 = Boolean.TRUE;
                s.callMethod(field, "dumpMemInfo", fileDescriptor, memoryInfo, bool3, bool4, bool4, bool3, new String[0]);
            } else if (SystemUtil.ed(19)) {
                Boolean bool5 = Boolean.TRUE;
                s.callMethod(field, "dumpMemInfo", fileDescriptor, memoryInfo, Boolean.FALSE, bool5, bool5, new String[0]);
            }
            ParcelFileDescriptor open2 = ParcelFileDescriptor.open(file, 973078528);
            FileDescriptor fileDescriptor2 = open2;
            if (!SystemUtil.ed(26)) {
                fileDescriptor2 = open2.getFileDescriptor();
            }
            s.callMethod(field, "dumpGfxInfo", fileDescriptor2, new String[]{SystemUtil.getProcessName(com.kwad.sdk.crash.e.Hu().getContext())});
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
        }
    }

    private static int If() {
        File[] listFiles;
        File file = aHO;
        ap.checkNotNull(file);
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            return listFiles.length;
        }
        return 0;
    }

    public static void a(ExceptionMessage exceptionMessage, int i10) {
        com.kwad.sdk.crash.h HA = com.kwad.sdk.crash.e.Hu().HA();
        if (HA == null) {
            com.kwad.sdk.core.e.c.d("tag", "getter is null!");
        } else {
            exceptionMessage.mCustomMsg = HA.nb().toString();
        }
    }

    private static String aj(@NonNull String str, String str2) {
        ap.gH(str);
        return !str.endsWith(str2) ? str : str.substring(0, str.lastIndexOf(str2));
    }

    private static double aw(long j10) {
        return BigDecimal.valueOf(((float) (j10 >> 20)) / 1024.0f).setScale(2, 4).floatValue();
    }

    public static void b(@Nullable Throwable th, @NonNull ExceptionMessage exceptionMessage, @Nullable Context context) {
        if (th != null) {
            b(th, exceptionMessage);
        }
        a(exceptionMessage, context);
        MemoryInfo memoryInfo = new MemoryInfo();
        a(exceptionMessage, memoryInfo, context);
        a(exceptionMessage, new DiskInfo());
        if (exceptionMessage instanceof NativeExceptionMessage) {
            a(exceptionMessage, memoryInfo);
        } else if (exceptionMessage instanceof JavaExceptionMessage) {
            a(th, exceptionMessage);
        }
    }

    private static String bx(Context context) {
        InputStream inputStream = null;
        try {
            inputStream = context.getResources().getAssets().open("apk.json");
            return new JSONObject(h.d(inputStream)).getString(MonitorConstants.EXTRA_DOWNLOAD_TASK_ID);
        } catch (IOException e2) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
            return "";
        } catch (JSONException e10) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e10);
            return "";
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            return "";
        } finally {
            b.closeQuietly(inputStream);
        }
    }

    private static String by(Context context) {
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append("BuildConfig Version Name: " + com.kwad.sdk.crash.e.Hu().getSdkVersion() + "\n");
            sb2.append("PackageInfo CodePath: " + context.getPackageCodePath() + "\n");
            sb2.append("PackageInfo ResPath: " + context.getPackageResourcePath() + "\n");
            sb2.append("DexPath: " + bz(context) + "\n");
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
        }
        return sb2.toString();
    }

    private static String bz(Context context) {
        StringBuilder sb2 = new StringBuilder();
        ClassLoader classLoader = context.getClassLoader();
        if (classLoader != null) {
            String obj = classLoader.toString();
            StringBuilder sb3 = new StringBuilder("ClassLoader ");
            int i10 = 0;
            sb3.append(0);
            sb3.append(" : ");
            sb3.append(obj);
            sb2.append(sb3.toString());
            while (classLoader.getParent() != null) {
                classLoader = classLoader.getParent();
                i10++;
                sb2.append("\nClassLoader " + i10 + " : " + classLoader.toString());
            }
            if (obj != null) {
                String[] split = obj.split("\"");
                if (split.length >= 2) {
                    sb2.append("\n====path: " + split[1] + ", length: " + fI(split[1]));
                }
            }
        }
        return sb2.toString();
    }

    public static void d(File file, File file2) {
        BufferedReader bufferedReader;
        try {
            q.P(file);
            q.P(file2);
            BufferedWriter bufferedWriter = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(file));
                    try {
                        BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file2, true));
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                bufferedWriter2.write(readLine);
                                bufferedWriter2.newLine();
                            } catch (FileNotFoundException e2) {
                                e = e2;
                                bufferedWriter = bufferedWriter2;
                                com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                                b.closeQuietly(bufferedWriter);
                                b.closeQuietly(bufferedReader);
                            } catch (IOException e10) {
                                e = e10;
                                bufferedWriter = bufferedWriter2;
                                com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                                b.closeQuietly(bufferedWriter);
                                b.closeQuietly(bufferedReader);
                            } catch (Throwable th) {
                                th = th;
                                bufferedWriter = bufferedWriter2;
                                b.closeQuietly(bufferedWriter);
                                b.closeQuietly(bufferedReader);
                                throw th;
                            }
                        }
                        b.closeQuietly(bufferedWriter2);
                    } catch (FileNotFoundException e11) {
                        e = e11;
                    } catch (IOException e12) {
                        e = e12;
                    }
                } catch (FileNotFoundException e13) {
                    e = e13;
                    bufferedReader = null;
                } catch (IOException e14) {
                    e = e14;
                    bufferedReader = null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = null;
                }
                b.closeQuietly(bufferedReader);
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e15) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e15);
        }
    }

    private static void e(@NonNull ExceptionMessage exceptionMessage) {
        exceptionMessage.mVirtualApp = com.kwad.sdk.crash.e.Hu().Hx();
        exceptionMessage.mVersionCode = com.kwad.sdk.crash.e.Hu().getSdkVersion();
    }

    public static String fG(String str) {
        return str.contains(".") ? str.substring(0, str.lastIndexOf(46)) : str;
    }

    public static String fH(String str) {
        return (str.contains("(") && str.contains(")")) ? str.substring(str.lastIndexOf(40) + 1, str.lastIndexOf(41)) : str;
    }

    private static long fI(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.length();
            }
            return -1L;
        } catch (Exception unused) {
            return -1L;
        }
    }

    private static String fJ(String str) {
        HashSet hashSet = new HashSet();
        for (String str2 : str.split("\n")) {
            hashSet.add(str2);
        }
        ArrayList arrayList = new ArrayList(hashSet);
        StringBuilder sb2 = new StringBuilder();
        Iterator<E> iterator2 = arrayList.iterator2();
        while (iterator2.hasNext()) {
            sb2.append((String) iterator2.next());
            sb2.append("\n");
        }
        return sb2.substring(0);
    }

    public static int getIndex(String str) {
        if (str.contains("-")) {
            return Integer.parseInt(str.substring(str.lastIndexOf(45)));
        }
        return -1;
    }

    private static boolean q(@Nullable Throwable th) {
        if (th == null) {
            return false;
        }
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th instanceof OutOfMemoryError;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String r(Throwable th) {
        String th2 = th.toString();
        PrintWriter printWriter = null;
        try {
            try {
                StringWriter stringWriter = new StringWriter();
                try {
                    printWriter = new PrintWriter(stringWriter);
                    f.a(th, printWriter);
                    th2 = stringWriter.toString();
                    b.closeQuietly(stringWriter);
                } catch (Exception e2) {
                    e = e2;
                    printWriter = stringWriter;
                    com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                    b.closeQuietly(printWriter);
                    return th2;
                } catch (Throwable th3) {
                    th = th3;
                    printWriter = stringWriter;
                    b.closeQuietly(printWriter);
                    throw th;
                }
            } catch (Exception e10) {
                e = e10;
            }
            return th2;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    private static void a(@NonNull ExceptionMessage exceptionMessage, @Nullable Context context) {
        if (exceptionMessage instanceof JavaExceptionMessage) {
            if ("Unknown".equals(exceptionMessage.mThreadName)) {
                exceptionMessage.mThreadName = Thread.currentThread().getName();
            }
            exceptionMessage.mTid = Process.myTid();
        }
        if (context != null) {
            String processName = SystemUtil.getProcessName(context);
            if (!TextUtils.isEmpty(processName)) {
                exceptionMessage.mProcessName = processName;
            }
        }
        exceptionMessage.mPid = Process.myPid();
        exceptionMessage.mCurrentTimeStamp = System.currentTimeMillis();
        exceptionMessage.mUsageTimeMills = com.kwad.sdk.crash.e.Hu().HB();
        exceptionMessage.mAbi = AbiUtil.isArm64(context) ? "arm64" : "arm";
        exceptionMessage.mVersionConflict = TextUtils.equals(exceptionMessage.mVersionCode, ExceptionMessage.getSdkCrashVersionName("1.0", com.kwad.sdk.crash.e.Hu().Hy()));
        exceptionMessage.mBuildConfigInfo = by(context);
        e(exceptionMessage);
        b(exceptionMessage, context);
        exceptionMessage.mTaskId = bx(context);
    }

    private static void b(@NonNull Throwable th, @NonNull ExceptionMessage exceptionMessage) {
        String r10 = r(th);
        if (th instanceof StackOverflowError) {
            r10 = fJ(r10);
        }
        exceptionMessage.mCrashDetail = r10.replaceAll("[\n\t]", "#");
    }

    private static void b(@NonNull ExceptionMessage exceptionMessage, @Nullable Context context) {
        String absolutePath;
        if (context == null) {
            return;
        }
        File parentFile = context.getCacheDir().getParentFile().getParentFile().getParentFile();
        try {
            absolutePath = parentFile.getCanonicalPath();
        } catch (IOException e2) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
            absolutePath = parentFile.getAbsolutePath();
        }
        if (!com.kwad.sdk.crash.d.aFE.matcher(absolutePath).matches() && !com.kwad.sdk.crash.d.aFF.matcher(absolutePath).matches()) {
            Matcher matcher = com.kwad.sdk.crash.d.aFG.matcher(absolutePath);
            Matcher matcher2 = com.kwad.sdk.crash.d.aFH.matcher(absolutePath);
            if (matcher.matches()) {
                exceptionMessage.mVirtualApp = matcher.group(1);
                return;
            } else if (matcher2.matches()) {
                exceptionMessage.mVirtualApp = matcher2.group(1);
                return;
            } else {
                exceptionMessage.mVirtualApp = absolutePath;
                return;
            }
        }
        exceptionMessage.mVirtualApp = context.getPackageName();
    }

    private static void a(Throwable th, ExceptionMessage exceptionMessage) {
        if (q(th) && exceptionMessage.mCrashType.equals(exceptionMessage.getTypeCommon())) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeHeapOOM();
        }
    }

    private static void a(ExceptionMessage exceptionMessage, MemoryInfo memoryInfo, @Nullable Context context) {
        SystemUtil.a MR = SystemUtil.MR();
        MR.aQr = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        MR.aQn = SystemUtil.MQ();
        long pss = Debug.getPss();
        MR.aQq = pss;
        memoryInfo.mTotalMB = (int) (MR.aQn / 1048576);
        memoryInfo.mJavaHeapLimitMB = (int) (com.kwad.sdk.crash.d.aFD / 1048576.0d);
        memoryInfo.mJavaHeapMB = (int) (MR.aQr / 1048576);
        memoryInfo.mVssMB = (int) (MR.aQo / 1024);
        memoryInfo.mRssMB = (int) (MR.aQp / 1024);
        memoryInfo.mPssMB = (int) (pss / 1024);
        memoryInfo.mThreadsCount = MR.mThreadsCount;
        memoryInfo.mFdCount = If();
        if (context != null) {
            memoryInfo.mAvailableMB = (int) (SystemUtil.cV(context) / 1048576);
        }
        exceptionMessage.mFdOverflow = "False";
        if (memoryInfo.mFdCount > 800) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeFdOOM();
            exceptionMessage.mFdOverflow = "True";
            File[] listFiles = aHO.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    try {
                        memoryInfo.mFds.add(Os.readlink(file.getPath()));
                    } catch (Exception e2) {
                        com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
                    }
                }
                Collections.sort(memoryInfo.mFds);
            }
        }
        exceptionMessage.mThreadOverflow = "False";
        if (MR.mThreadsCount > 400) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeThreadOOM();
            exceptionMessage.mThreadOverflow = "True";
            a(memoryInfo);
            Collections.sort(memoryInfo.mAllThreads, new Comparator<ThreadInfo>() { // from class: com.kwad.sdk.crash.utils.g.1
                private static int a(ThreadInfo threadInfo, ThreadInfo threadInfo2) {
                    return threadInfo.mName.compareTo(threadInfo2.mName);
                }

                @Override // java.util.Comparator
                public final /* synthetic */ int compare(ThreadInfo threadInfo, ThreadInfo threadInfo2) {
                    return a(threadInfo, threadInfo2);
                }
            });
        }
        exceptionMessage.mMemoryInfo = memoryInfo.toJson().toString();
    }

    private static String b(StackTraceElement[] stackTraceElementArr) {
        return a(stackTraceElementArr, 0);
    }

    public static boolean b(com.kwad.sdk.crash.model.b bVar) {
        boolean z10 = (bVar.aGf & 2) != 0 && com.kwad.framework.a.a.adI.booleanValue();
        com.kwad.sdk.core.e.c.d(TAG, "isNativeOpen:" + z10);
        return z10;
    }

    private static void a(MemoryInfo memoryInfo) {
        File[] listFiles = aHP.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            ThreadInfo threadInfo = new ThreadInfo();
            try {
                threadInfo.mName = h.I(new File(file, "comm"));
            } catch (IOException e2) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
            }
            if (!TextUtils.isEmpty(threadInfo.mName)) {
                threadInfo.mName = aj(threadInfo.mName, "\n");
                memoryInfo.mAllThreads.add(threadInfo);
            }
        }
    }

    private static void a(ExceptionMessage exceptionMessage, MemoryInfo memoryInfo) {
        if (memoryInfo.mPssMB * 2 > memoryInfo.mTotalMB || (!AbiUtil.isArm64(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext()) && memoryInfo.mVssMB > 3686.4d)) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeHeapOOM();
        }
    }

    private static void a(ExceptionMessage exceptionMessage, DiskInfo diskInfo) {
        File externalStorageDirectory;
        try {
            String path = Environment.getDataDirectory().getPath();
            diskInfo.mDataTotalGB = aw(h.getTotalBytes(path));
            if (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).X(1024L)) {
                diskInfo.mDataAvailableGB = aw(h.getAvailableBytes(path));
            }
            if ("mounted".equals(Environment.getExternalStorageState()) && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
                diskInfo.mExternalStorageTotalGB = aw(h.getTotalBytes(externalStorageDirectory.getPath()));
                if (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).X(1024L)) {
                    diskInfo.mExternalStorageAvailableGB = aw(h.getAvailableBytes(externalStorageDirectory.getPath()));
                }
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
        }
        exceptionMessage.mDiskInfo = diskInfo.toJson().toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0010, code lost:
    
        r2 = r0.readLine();
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0014, code lost:
    
        if (r2 == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001a, code lost:
    
        if (r2.isEmpty() == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0023, code lost:
    
        r2 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0024, code lost:
    
        r3 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0035, code lost:
    
        com.kwad.sdk.core.e.c.printStackTraceOnly(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0038, code lost:
    
        com.kwad.sdk.crash.utils.b.closeQuietly(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0020, code lost:
    
        r2 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0021, code lost:
    
        r3 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x002d, code lost:
    
        com.kwad.sdk.core.e.c.printStackTraceOnly(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0030, code lost:
    
        com.kwad.sdk.crash.utils.b.closeQuietly(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0033, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x001d, code lost:
    
        r2 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x001e, code lost:
    
        r3 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x003c, code lost:
    
        com.kwad.sdk.crash.utils.b.closeQuietly(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x003f, code lost:
    
        throw r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000e, code lost:
    
        if (r2 != null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0026, code lost:
    
        com.kwad.sdk.crash.utils.b.closeQuietly(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0029, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(com.kwad.sdk.crash.report.e r2, java.lang.String r3, java.io.File r4) {
        /*
            com.kwad.sdk.utils.q.P(r4)     // Catch: java.io.IOException -> L40
            r3 = 0
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L2a java.io.IOException -> L2c java.io.FileNotFoundException -> L34
            java.io.FileReader r1 = new java.io.FileReader     // Catch: java.lang.Throwable -> L2a java.io.IOException -> L2c java.io.FileNotFoundException -> L34
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L2a java.io.IOException -> L2c java.io.FileNotFoundException -> L34
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L2a java.io.IOException -> L2c java.io.FileNotFoundException -> L34
            if (r2 == 0) goto L26
        L10:
            java.lang.String r2 = r0.readLine()     // Catch: java.lang.Throwable -> L1d java.io.IOException -> L20 java.io.FileNotFoundException -> L23
            if (r2 == 0) goto L26
            boolean r2 = r2.isEmpty()     // Catch: java.lang.Throwable -> L1d java.io.IOException -> L20 java.io.FileNotFoundException -> L23
            if (r2 == 0) goto L10
            goto L26
        L1d:
            r2 = move-exception
            r3 = r0
            goto L3c
        L20:
            r2 = move-exception
            r3 = r0
            goto L2d
        L23:
            r2 = move-exception
            r3 = r0
            goto L35
        L26:
            com.kwad.sdk.crash.utils.b.closeQuietly(r0)
            return
        L2a:
            r2 = move-exception
            goto L3c
        L2c:
            r2 = move-exception
        L2d:
            com.kwad.sdk.core.e.c.printStackTraceOnly(r2)     // Catch: java.lang.Throwable -> L2a
            com.kwad.sdk.crash.utils.b.closeQuietly(r3)
            return
        L34:
            r2 = move-exception
        L35:
            com.kwad.sdk.core.e.c.printStackTraceOnly(r2)     // Catch: java.lang.Throwable -> L2a
            com.kwad.sdk.crash.utils.b.closeQuietly(r3)
            return
        L3c:
            com.kwad.sdk.crash.utils.b.closeQuietly(r3)
            throw r2
        L40:
            r2 = move-exception
            com.kwad.sdk.core.e.c.printStackTraceOnly(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.crash.utils.g.a(com.kwad.sdk.crash.report.e, java.lang.String, java.io.File):void");
    }

    public static void a(File file, CharSequence charSequence) {
        a(file, charSequence, Charset.defaultCharset(), false);
    }

    public static void a(File file, CharSequence charSequence, boolean z10) {
        a(file, charSequence, Charset.defaultCharset(), true);
    }

    private static void a(File file, CharSequence charSequence, Charset charset, boolean z10) {
        a(file, charSequence == null ? null : charSequence.toString(), charset, z10);
    }

    private static void a(File file, String str, Charset charset, boolean z10) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = q.a(file, z10);
            h.a(str, fileOutputStream, charset);
            a(fileOutputStream);
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
        } finally {
            b.closeQuietly(fileOutputStream);
        }
    }

    private static boolean a(FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return true;
        }
        try {
            fileOutputStream.getFD().sync();
            return true;
        } catch (IOException e2) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
            return false;
        }
    }

    private static String a(StackTraceElement[] stackTraceElementArr, int i10) {
        if (stackTraceElementArr == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            sb2.append("at ");
            sb2.append((Object) stackTraceElement);
            sb2.append('\n');
        }
        return sb2.substring(0);
    }

    public static boolean a(com.kwad.sdk.crash.model.b bVar) {
        boolean z10 = (bVar.aGf & 1) != 0 && com.kwad.framework.a.a.adD.booleanValue();
        com.kwad.sdk.core.e.c.d(TAG, "isAnrOpen:" + z10);
        return z10;
    }
}
