package com.tencent.cloud.huiyansdkface.normal.tools;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.tencent.cloud.huiyansdkface.normal.thread.ThreadOperate;
import com.tencent.cloud.huiyansdkface.wejson.WeJson;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WLogger {
    private static boolean isEnable;
    private static File mLocalFile;
    private static LogInterface mLog;
    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss.SSS");
    private static String mName = "empty";
    private static String mLocalLogName = "";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface LogInterface {
        void d(String str, String str2);

        void e(String str, String str2);

        void i(String str, String str2);

        void v(String str, String str2);

        void w(String str, String str2);
    }

    private static String buildMessage(String str, String str2, Throwable th) {
        String str3 = mLocalLogName;
        if (str3 != null && !"".equals(str3) && isEnable) {
            StackTraceElement stackTraceElement = new Throwable().fillInStackTrace().getStackTrace()[2];
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(stackTraceElement.getClassName());
            stringBuffer.append(".");
            stringBuffer.append(stackTraceElement.getMethodName());
            stringBuffer.append("(");
            stringBuffer.append(stackTraceElement.getFileName());
            stringBuffer.append(": ");
            stringBuffer.append(stackTraceElement.getLineNumber());
            stringBuffer.append(")");
            stringBuffer.append(" : ");
            stringBuffer.append(str2);
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(dateFormat.format(new Date()));
            stringBuffer2.append("    ");
            stringBuffer2.append("    ");
            stringBuffer2.append(str);
            stringBuffer2.append("    ");
            stringBuffer2.append(stringBuffer);
            if (th != null) {
                stringBuffer2.append(System.getProperty("line.separator"));
                stringBuffer2.append(Log.getStackTraceString(th));
            }
            save2File(stringBuffer2.toString());
        }
        return str2;
    }

    public static void d(String str, String str2) {
        LogInterface logInterface = mLog;
        if (logInterface != null) {
            logInterface.d(str, str2);
            return;
        }
        if (isEnable) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(mName);
            sb2.append("_");
            sb2.append(str);
            buildMessage(str, str2, null);
        }
    }

    public static void e(String str, String str2) {
        LogInterface logInterface = mLog;
        if (logInterface != null) {
            logInterface.e(str, str2);
            return;
        }
        if (isEnable) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(mName);
            sb2.append("_");
            sb2.append(str);
            buildMessage(str, str2, null);
        }
    }

    public static File getLogFile(Context context, String str) {
        int i10;
        if (context == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) context.getExternalCacheDir());
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append("TxCloudHuiyanSdkFaceLog");
        String sb3 = sb2.toString();
        if (context.getApplicationInfo() != null && (i10 = context.getApplicationInfo().targetSdkVersion) > 13 && i10 < 29) {
            sb3 = ((Object) Environment.getExternalStorageDirectory()) + str2 + "TxCloudHuiyanSdkFaceLog";
        }
        File file = new File(sb3 + str2 + str);
        if (!file.exists() && !file.mkdirs()) {
            return null;
        }
        File file2 = new File(file.getPath() + str2 + (dateFormat.format(new Date()) + ".log"));
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return file2;
    }

    @Deprecated
    public static File getLogFile(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) Environment.getExternalStorageDirectory());
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append("TxCloudHuiyanSdkFaceLog");
        sb2.append(str2);
        sb2.append(str);
        File file = new File(sb2.toString());
        if (!file.exists() && !file.mkdirs()) {
            return null;
        }
        File file2 = new File(file.getPath() + str2 + (dateFormat.format(new Date()) + ".log"));
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return file2;
    }

    public static void i(String str) {
        LogInterface logInterface = mLog;
        if (logInterface != null) {
            logInterface.i(mName, str);
        } else {
            i("", str);
        }
    }

    public static void i(String str, Object obj) {
        LogInterface logInterface = mLog;
        if (logInterface != null) {
            logInterface.i(mName, obj.toString());
        } else if (isEnable) {
            try {
                buildMessage(str, new WeJson().toJson(obj), null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void i(String str, String str2) {
        LogInterface logInterface = mLog;
        if (logInterface != null) {
            logInterface.i(str, str2);
            return;
        }
        if (isEnable) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(mName);
            sb2.append("_");
            sb2.append(str);
            buildMessage(str, str2, null);
        }
    }

    public static void localLogFileName(Context context, String str) {
        mLocalLogName = str;
        mLocalFile = getLogFile(context, str);
    }

    @Deprecated
    public static void localLogFileName(String str) {
        mLocalLogName = str;
        mLocalFile = getLogFile(str);
    }

    private static void save2File(String str) {
        File file = mLocalFile;
        if (file != null) {
            writeFile(file, str);
        }
    }

    public static void setEnable(boolean z10, String str) {
        isEnable = z10;
        mName = str;
    }

    public static void setILog(LogInterface logInterface) {
        mLog = logInterface;
    }

    public static void v(String str, String str2) {
        LogInterface logInterface = mLog;
        if (logInterface != null) {
            logInterface.v(str, str2);
            return;
        }
        if (isEnable) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(mName);
            sb2.append("_");
            sb2.append(str);
            buildMessage(str, str2, null);
        }
    }

    public static void w(String str, String str2) {
        LogInterface logInterface = mLog;
        if (logInterface != null) {
            logInterface.w(str, str2);
            return;
        }
        if (isEnable) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(mName);
            sb2.append("_");
            sb2.append(str);
            buildMessage(str, str2, null);
        }
    }

    public static void writeFile(final File file, final String str) {
        ThreadOperate.runOnSubThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.normal.tools.WLogger.1
            /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r7 = this;
                    r0 = 0
                    java.io.PrintWriter r1 = new java.io.PrintWriter     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L23
                    java.io.BufferedWriter r2 = new java.io.BufferedWriter     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L23
                    java.io.FileWriter r3 = new java.io.FileWriter     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L23
                    java.io.File r4 = java.io.File.this     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L23
                    r5 = 1
                    r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L23
                    r2.<init>(r3)     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L23
                    r1.<init>(r2)     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L23
                    java.lang.String r0 = r2     // Catch: java.lang.Exception -> L1c java.lang.Throwable -> L30
                    r1.println(r0)     // Catch: java.lang.Exception -> L1c java.lang.Throwable -> L30
                    r1.flush()     // Catch: java.lang.Exception -> L1c java.lang.Throwable -> L30
                    goto L2c
                L1c:
                    r0 = move-exception
                    goto L27
                L1e:
                    r1 = move-exception
                    r6 = r1
                    r1 = r0
                    r0 = r6
                    goto L31
                L23:
                    r1 = move-exception
                    r6 = r1
                    r1 = r0
                    r0 = r6
                L27:
                    r0.printStackTrace()     // Catch: java.lang.Throwable -> L30
                    if (r1 == 0) goto L2f
                L2c:
                    r1.close()
                L2f:
                    return
                L30:
                    r0 = move-exception
                L31:
                    if (r1 == 0) goto L36
                    r1.close()
                L36:
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.normal.tools.WLogger.AnonymousClass1.run():void");
            }
        });
    }
}
