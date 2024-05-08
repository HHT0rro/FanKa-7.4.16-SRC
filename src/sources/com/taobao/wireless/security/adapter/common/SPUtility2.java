package com.taobao.wireless.security.adapter.common;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import com.kuaishou.weapon.p0.g;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
public class SPUtility2 {

    /* renamed from: а, reason: contains not printable characters */
    private static Context f207;

    /* renamed from: б, reason: contains not printable characters */
    private static C0598 f208;

    public static String getTempFile(String str) throws IOException {
        String rootDir = rootDir();
        if (rootDir == null) {
            return "";
        }
        File file = new File(rootDir, str);
        return (file.exists() || file.createNewFile()) ? file.getAbsolutePath() : "";
    }

    public static void init(Context context) {
        if (context != null) {
            f207 = context;
            f208 = new C0598(context, "sp.lock");
        }
    }

    public static String read(String str) {
        String str2 = "";
        if (!m2875(1)) {
            return "";
        }
        String tempFile = getTempFile(str);
        synchronized (SPUtility2.class) {
            try {
                if (f208.m2888()) {
                    str2 = m2872(tempFile, true);
                }
            } finally {
                f208.m2889();
            }
        }
        return str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0026, code lost:
    
        if (r3.length() > 0) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String readFromSPUnified(java.lang.String r3, java.lang.String r4, java.lang.String r5) {
        /*
            if (r4 == 0) goto L42
            int r0 = r4.length()
            if (r0 <= 0) goto L42
            if (r3 == 0) goto L42
            int r0 = r3.length()
            if (r0 <= 0) goto L42
            java.lang.Class<com.taobao.wireless.security.adapter.common.SPUtility2> r0 = com.taobao.wireless.security.adapter.common.SPUtility2.class
            monitor-enter(r0)
            com.taobao.wireless.security.adapter.common.г r1 = com.taobao.wireless.security.adapter.common.SPUtility2.f208     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L38
            boolean r1 = r1.m2888()     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L38
            r2 = 1
            if (r1 != r2) goto L29
            java.lang.String r3 = m2871(r3, r4, r5)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L38
            if (r3 == 0) goto L29
            int r4 = r3.length()     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L38
            if (r4 <= 0) goto L29
            goto L2a
        L29:
            r3 = r5
        L2a:
            com.taobao.wireless.security.adapter.common.г r4 = com.taobao.wireless.security.adapter.common.SPUtility2.f208     // Catch: java.lang.Throwable -> L3f
            r4.m2889()     // Catch: java.lang.Throwable -> L3f
            r5 = r3
            goto L3d
        L31:
            r3 = move-exception
            com.taobao.wireless.security.adapter.common.г r4 = com.taobao.wireless.security.adapter.common.SPUtility2.f208     // Catch: java.lang.Throwable -> L3f
            r4.m2889()     // Catch: java.lang.Throwable -> L3f
            throw r3     // Catch: java.lang.Throwable -> L3f
        L38:
            com.taobao.wireless.security.adapter.common.г r3 = com.taobao.wireless.security.adapter.common.SPUtility2.f208     // Catch: java.lang.Throwable -> L3f
            r3.m2889()     // Catch: java.lang.Throwable -> L3f
        L3d:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3f
            goto L42
        L3f:
            r3 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3f
            throw r3
        L42:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.wireless.security.adapter.common.SPUtility2.readFromSPUnified(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public static String readSS(Context context, String str) {
        String str2 = null;
        if (context != null) {
            try {
                if ((Build.VERSION.SDK_INT < 23 || context.getApplicationInfo().targetSdkVersion < 23) && str != null && str.length() > 0) {
                    synchronized (SPUtility2.class) {
                        try {
                            if (f208.m2888()) {
                                str2 = Settings.System.getString(context.getContentResolver(), str);
                            }
                        } finally {
                            f208.m2889();
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return str2;
    }

    public static boolean removeFromSPUnified(String str, String str2, boolean z10) {
        if (str2 == null || str2.length() <= 0 || str == null || str.length() <= 0) {
            return false;
        }
        synchronized (SPUtility2.class) {
            try {
                if (!f208.m2888()) {
                    return false;
                }
                return m2876(str, str2);
            } finally {
                f208.m2889();
            }
        }
    }

    public static String rootDir() {
        try {
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return null;
            }
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/.com.taobao.dp");
            if (file.exists() || file.mkdir()) {
                return file.getAbsolutePath();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static int saveToFileUnifiedForNative(String str, String str2, String str3, boolean z10) {
        int i10 = 1;
        if (str2 != null && str2.length() > 0 && str != null && str.length() > 0) {
            synchronized (SPUtility2.class) {
                try {
                    if (f208.m2888()) {
                        i10 = m2877("SGMANAGER_DATA2", str + "_" + str2, str3);
                    }
                } finally {
                    f208.m2889();
                }
            }
        }
        return i10;
    }

    public static boolean saveToSPUnified(String str, String str2, String str3, boolean z10) {
        return saveToFileUnifiedForNative(str, str2, str3, z10) == 0;
    }

    public static void write(String str, String str2) {
        String tempFile;
        try {
            if (m2875(0) && (tempFile = getTempFile(str)) != null && tempFile.length() > 0) {
                synchronized (SPUtility2.class) {
                    try {
                        if (f208.m2888()) {
                            m2874(tempFile, str2, false);
                        }
                    } finally {
                        f208.m2889();
                    }
                }
            }
        } catch (IOException unused) {
        }
    }

    public static boolean writeSS(Context context, String str, String str2) {
        boolean z10 = false;
        if (context != null) {
            try {
                if ((Build.VERSION.SDK_INT < 23 || context.getApplicationInfo().targetSdkVersion < 23) && str != null && str.length() > 0) {
                    synchronized (SPUtility2.class) {
                        try {
                            if (f208.m2888()) {
                                z10 = Settings.System.putString(context.getContentResolver(), str, str2);
                            }
                        } finally {
                            f208.m2889();
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return z10;
    }

    /* renamed from: а, reason: contains not printable characters */
    private static int m2870(Context context, String str, String str2) {
        OutputStreamWriter outputStreamWriter = null;
        try {
            String absolutePath = context.getFilesDir().getAbsolutePath();
            if (absolutePath != null && absolutePath.length() > 0) {
                File file = new File(absolutePath + File.separator + str + ".tmp");
                StringBuilder sb2 = new StringBuilder();
                sb2.append(absolutePath);
                sb2.append(File.separator);
                sb2.append(str);
                File file2 = new File(sb2.toString());
                OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(file));
                try {
                    outputStreamWriter2.write(str2);
                    outputStreamWriter2.close();
                    file2.delete();
                    return file.renameTo(file2) ? 0 : 5;
                } catch (Exception unused) {
                    outputStreamWriter = outputStreamWriter2;
                    if (outputStreamWriter == null) {
                        return 6;
                    }
                    try {
                        outputStreamWriter.close();
                        return 6;
                    } catch (Exception unused2) {
                        return 6;
                    }
                } catch (Throwable th) {
                    outputStreamWriter = outputStreamWriter2;
                    th = th;
                    if (outputStreamWriter != null) {
                        try {
                            outputStreamWriter.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th;
                }
            }
            return 4;
        } catch (Exception unused4) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: а, reason: contains not printable characters */
    private static String m2871(String str, String str2, String str3) {
        if (str2 == null || str2.length() <= 0 || str == null || str.length() <= 0) {
            return str3;
        }
        try {
            String str4 = str + "_" + str2;
            JSONObject m2873 = m2873("SGMANAGER_DATA2");
            return m2873 != null ? m2873.getString(str4) : str3;
        } catch (Throwable unused) {
            return str3;
        }
    }

    /* renamed from: а, reason: contains not printable characters */
    private static String m2872(String str, boolean z10) throws IOException {
        StringBuilder sb2 = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(str))));
        String readLine = bufferedReader.readLine();
        if (readLine == null) {
            readLine = "";
        }
        sb2.append(readLine);
        if (!z10) {
            while (true) {
                String readLine2 = bufferedReader.readLine();
                if (readLine2 == null) {
                    break;
                }
                sb2.append(readLine2);
            }
        }
        bufferedReader.close();
        return sb2.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x005b, code lost:
    
        if (r4 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005f, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0054, code lost:
    
        if (r4 == null) goto L20;
     */
    /* renamed from: а, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static org.json.JSONObject m2873(java.lang.String r4) {
        /*
            r0 = 0
            android.content.Context r1 = com.taobao.wireless.security.adapter.common.SPUtility2.f207     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L5a
            java.io.File r1 = r1.getFilesDir()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L5a
            java.lang.String r1 = r1.getAbsolutePath()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L5a
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L5a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L5a
            r3.<init>()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L5a
            r3.append(r1)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L5a
            java.lang.String r1 = java.io.File.separator     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L5a
            r3.append(r1)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L5a
            r3.append(r4)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L5a
            java.lang.String r4 = r3.toString()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L5a
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L5a
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L5a
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L5a
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L5a
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L5a
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L5a
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L5a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            r1.<init>()     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
        L38:
            java.lang.String r2 = r4.readLine()     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            if (r2 == 0) goto L42
            r1.append(r2)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            goto L38
        L42:
            r4.close()     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L5a
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L5a
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L5a
            goto L5f
        L4f:
            goto L54
        L51:
            goto L5b
        L53:
            r4 = r0
        L54:
            if (r4 == 0) goto L5e
        L56:
            r4.close()     // Catch: java.lang.Exception -> L5e
            goto L5e
        L5a:
            r4 = r0
        L5b:
            if (r4 == 0) goto L5e
            goto L56
        L5e:
            r4 = r0
        L5f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.wireless.security.adapter.common.SPUtility2.m2873(java.lang.String):org.json.JSONObject");
    }

    /* renamed from: а, reason: contains not printable characters */
    private static void m2874(String str, String str2, boolean z10) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(str), z10);
        fileOutputStream.write(str2.getBytes());
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    /* renamed from: а, reason: contains not printable characters */
    private static boolean m2875(int i10) {
        Context context = f207;
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        if (context == null) {
            return false;
        }
        try {
            if (context.getApplicationInfo().targetSdkVersion < 23) {
                return true;
            }
            try {
                Method method = Context.class.getMethod("checkSelfPermission", String.class);
                if (method != null) {
                    String str = g.f36123i;
                    if (i10 == 0) {
                        str = g.f36124j;
                    }
                    return ((Integer) method.invoke(context, str)).intValue() == 0;
                }
            } catch (Throwable unused) {
            }
            return false;
        } catch (Throwable unused2) {
            return true;
        }
    }

    /* renamed from: а, reason: contains not printable characters */
    private static boolean m2876(String str, String str2) {
        Context context = f207;
        if (context == null || str2 == null || str2.length() <= 0 || str == null || str.length() <= 0) {
            return false;
        }
        try {
            String str3 = str + "_" + str2;
            JSONObject m2873 = m2873("SGMANAGER_DATA2");
            if (m2873 == null) {
                return false;
            }
            m2873.remove(str3);
            return m2870(context, "SGMANAGER_DATA2", m2873.toString()) == 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: б, reason: contains not printable characters */
    private static int m2877(String str, String str2, String str3) {
        Context context = f207;
        if (str2 != null && str2.length() > 0 && str != null && str.length() > 0) {
            try {
                JSONObject m2873 = m2873(str);
                if (m2873 == null) {
                    m2873 = new JSONObject();
                }
                m2873.put(str2, str3);
                return m2870(context, str, m2873.toString());
            } catch (Throwable unused) {
            }
        }
        return 2;
    }
}
