package com.kwad.sdk.crash.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.MemoryInfo;
import com.kwad.sdk.crash.model.message.NativeExceptionMessage;
import com.kwad.sdk.crash.model.message.ThreadInfo;
import com.kwad.sdk.utils.q;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class g extends d {
    public static final Pattern aHi = Pattern.compile("(.*)\\s\\(tid=(\\d+), index=(\\d+)*");
    public static final Pattern aHj = Pattern.compile("\\sd+\\spc");

    private NativeExceptionMessage D(File file) {
        String str;
        try {
            str = q.V(file);
        } catch (IOException e2) {
            this.mErrorMessage += ((Object) e2) + "\n";
            str = null;
        }
        NativeExceptionMessage nativeExceptionMessage = new NativeExceptionMessage();
        if (str != null) {
            try {
                nativeExceptionMessage.parseJson(new JSONObject(str));
            } catch (Exception e10) {
                this.mErrorMessage += ((Object) e10) + "\n";
            }
        }
        q.S(file);
        return nativeExceptionMessage;
    }

    private static void c(File file, ExceptionMessage exceptionMessage) {
        try {
            MemoryInfo memoryInfo = new MemoryInfo(exceptionMessage.mMemoryInfo);
            ArrayList arrayList = new ArrayList();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            try {
                try {
                    ThreadInfo threadInfo = new ThreadInfo();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (readLine.isEmpty()) {
                            arrayList.add(threadInfo);
                            threadInfo = new ThreadInfo();
                        } else if (aHj.matcher(readLine).matches()) {
                            if (threadInfo.mTrace != null) {
                                readLine = threadInfo.mTrace + readLine;
                            }
                            threadInfo.mTrace = readLine;
                            threadInfo.mTrace += "\n";
                        } else {
                            Matcher matcher = aHi.matcher(readLine);
                            if (matcher.lookingAt()) {
                                threadInfo.mName = matcher.group(1);
                                threadInfo.mTid = Integer.parseInt(matcher.group(2));
                                threadInfo.mIndex = Integer.parseInt(matcher.group(3));
                            }
                        }
                    }
                    memoryInfo.mNativeThreads = arrayList;
                    exceptionMessage.mMemoryInfo = memoryInfo.toJson().toString();
                } catch (IOException e2) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
                }
            } finally {
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
            }
        } catch (Exception e10) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e10);
        }
    }

    @Override // com.kwad.sdk.crash.report.d
    public final ExceptionMessage a(@NonNull File file, File file2, File file3, String str) {
        File file4 = new File(str + ".jtrace");
        NativeExceptionMessage D = D(file2);
        try {
            a(D, file);
            b(file3, D);
            d.a(file4, D);
            c(new File(str + ".ntrace"), D);
            com.kwad.sdk.crash.utils.g.a(file, (CharSequence) D.toString(), true);
            com.kwad.sdk.crash.utils.g.d(file3, file);
            file.renameTo(file3);
            D.toString();
            D.mDumpsys = q.V(new File(str + ".minfo"));
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
            this.mErrorMessage += ((Object) e2) + "\n";
        }
        if (!TextUtils.isEmpty(this.mErrorMessage)) {
            D.mErrorMessage += this.mErrorMessage;
        }
        return D;
    }

    private void a(NativeExceptionMessage nativeExceptionMessage, File file) {
        nativeExceptionMessage.mLogUUID = com.kwad.sdk.crash.utils.g.fG(file.getName());
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        boolean z10 = false;
        boolean z11 = false;
        while (true) {
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (z10 && readLine.startsWith("backtrace:")) {
                        z10 = false;
                        z11 = true;
                    } else if (z11) {
                        if (readLine.startsWith("###### ending of java stack trace ######")) {
                            break;
                        }
                        sb2.append(readLine);
                        sb2.append('\n');
                    } else if (z10) {
                        a(nativeExceptionMessage, readLine, sb3);
                    } else if (readLine.startsWith("*** ***")) {
                        z10 = true;
                    }
                } catch (IOException e2) {
                    this.mErrorMessage += ((Object) e2) + "\n";
                }
            } finally {
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
            }
        }
        if (sb2.length() > 1) {
            nativeExceptionMessage.mCrashDetail = sb2.substring(0, sb2.length() - 1);
        }
        if (sb3.length() > 1) {
            nativeExceptionMessage.mRegister = sb3.substring(0, sb3.length() - 1);
        }
    }

    private static void a(NativeExceptionMessage nativeExceptionMessage, String str, StringBuilder sb2) {
        if (str.startsWith("Build fingerprint: ")) {
            nativeExceptionMessage.mFingerprint = str.substring(19);
            return;
        }
        if (str.startsWith("Revision: ")) {
            nativeExceptionMessage.mRevision = str.substring(10);
            return;
        }
        if (str.startsWith("ABI: ")) {
            nativeExceptionMessage.mAbi = str.substring(5);
            return;
        }
        if (str.startsWith("Current UTC: ")) {
            nativeExceptionMessage.mCurrentTimeStamp = Long.parseLong(str.substring(13));
            return;
        }
        if (str.startsWith("Abort message: ")) {
            nativeExceptionMessage.mAbortMsg = str.substring(15);
            return;
        }
        if (!str.startsWith("    r") && !str.startsWith("    ip") && !str.startsWith("    x") && !str.startsWith("    sp")) {
            if (str.startsWith("pid: ")) {
                String[] split = str.split("\\s+");
                if (split.length < 9) {
                    return;
                }
                int i10 = 0;
                int i11 = 0;
                int i12 = 0;
                for (int i13 = 0; i13 < split.length; i13++) {
                    if ("name:".equals(split[i13])) {
                        i10 = i13;
                    } else if (">>>".equals(split[i13])) {
                        i11 = i13;
                    } else if ("<<<".equals(split[i13])) {
                        i12 = i13;
                    }
                }
                StringBuilder sb3 = new StringBuilder();
                int i14 = i10 + 1;
                sb3.append(split[i14]);
                while (true) {
                    i14++;
                    if (i14 >= i11) {
                        break;
                    }
                    sb3.append(" ");
                    sb3.append(split[i14]);
                }
                nativeExceptionMessage.mThreadName = sb3.toString();
                sb3.setLength(0);
                int i15 = i11 + 1;
                sb3.append(split[i15]);
                while (true) {
                    i15++;
                    if (i15 < i12) {
                        sb3.append(" ");
                        sb3.append(split[i15]);
                    } else {
                        nativeExceptionMessage.mProcessName = sb3.toString();
                        return;
                    }
                }
            } else if (str.startsWith("signal ")) {
                String[] split2 = str.split("\\s+");
                if (split2.length >= 9) {
                    nativeExceptionMessage.mSignal = com.kwad.sdk.crash.utils.g.fH(split2[2]);
                    nativeExceptionMessage.mCode = com.kwad.sdk.crash.utils.g.fH(split2[5]);
                    nativeExceptionMessage.mFaultAddr = split2[split2.length - 1];
                    nativeExceptionMessage.mManuallyKill = "--------".equals(split2[split2.length + (-1)]) ? "True" : "False";
                }
            }
        } else {
            sb2.append(str);
            sb2.append('\n');
        }
    }
}
