package com.nirvana.tools.crash;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class FileUtils {
    private static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1048576];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return;
            } else {
                outputStream.write(bArr, 0, read);
            }
        }
    }

    public static void copyFile(File file, String str) throws IOException {
        File createFileIfUnExist = createFileIfUnExist(str);
        if (createFileIfUnExist == null) {
            return;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(createFileIfUnExist);
        try {
            byte[] bArr = new byte[1048576];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    return;
                } else {
                    fileOutputStream.write(bArr, 0, read);
                }
            }
        } finally {
            fileInputStream.close();
            fileOutputStream.flush();
            fileOutputStream.close();
        }
    }

    private static File createFileIfUnExist(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file;
        }
        File file2 = new File(file.getParent());
        if (!file2.exists()) {
            file2.mkdirs();
        }
        try {
            if (file.createNewFile()) {
                return file;
            }
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void deleteFile(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        file.delete();
    }

    private static String fillContent(Context context, String str, String str2, String str3, long j10, SdkInfo sdkInfo, String str4, Map<String, String> map, Thread thread, Throwable th) {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***\nBasic Information: 'pid: ");
            sb2.append(Process.myPid());
            sb2.append("/tid: ");
            sb2.append(Process.myTid());
            sb2.append("/time: ");
            sb2.append(str);
            sb2.append("'\nCpu Information: 'abi: ");
            sb2.append(str2);
            sb2.append("/processor: ");
            sb2.append(CrashUploadUtils.getFieldFromCpuinfo("Processor"));
            sb2.append("/hardware: ");
            sb2.append(Build.HARDWARE);
            sb2.append("'\nMobile Information: 'model: ");
            sb2.append(Build.MODEL);
            sb2.append("/version: ");
            sb2.append(Build.VERSION.RELEASE);
            sb2.append("/sdk: ");
            sb2.append(Build.VERSION.SDK_INT);
            sb2.append("'\nBuild fingerprint: '");
            sb2.append(Build.FINGERPRINT);
            sb2.append("'\nRuntime Information: 'start: ");
            sb2.append(str3);
            sb2.append("/maxheap: ");
            sb2.append(j10);
            sb2.append("/primaryabi: ");
            String str5 = Build.CPU_ABI;
            sb2.append(str5);
            sb2.append("/ground: fg'\nApplication Information: 'version: ");
            sb2.append(sdkInfo.getSdkVersion());
            sb2.append("/subversion: release'\nCrashSDK Information: 'version:unknow/arch: ");
            sb2.append(str5);
            sb2.append("/target: ");
            sb2.append(CrashUploadUtils.apkInDebugRelease(context));
            sb2.append("'\nReport Name: ");
            sb2.append(str4);
            sb2.append("\nLog Type: java\ncrash_shield_version: 2.1.4\ncustom_uc_upload: true\nUUID: ");
            sb2.append(CrashUploadUtils.getUniqueId(context));
            sb2.append("\nActivity: (none)\n--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---");
            StringBuilder sb3 = new StringBuilder("");
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    sb3.append("\n");
                    sb3.append(entry.getKey());
                    sb3.append(": ");
                    sb3.append(entry.getValue());
                }
            }
            sb3.append("\nwk_appVersion: ");
            sb3.append(CrashUploadUtils.getVersion(context));
            sb2.append(sb3.toString());
            sb2.append("\nprocessName: ");
            sb2.append(CrashUploadUtils.getCurProcessName(context));
            sb2.append("\nthreadName: ");
            sb2.append(thread.getName());
            sb2.append("\nk_ac: CrashShield");
            sb2.append("\n--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---");
            sb2.append("\nBack traces starts.\n");
            sb2.append(Log.getStackTraceString(th));
            sb2.append("\nBack traces ends.\n--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\nmeminfo:\n");
            sb2.append(CrashUploadUtils.getMeminfo());
            sb2.append("\n--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n");
            return sb2.toString();
        } catch (IOException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String getName(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.substring(str.lastIndexOf(File.separatorChar) + 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0055, code lost:
    
        if (r4 != null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0047, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0045, code lost:
    
        if (r4 != null) goto L35;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.zip.GZIPOutputStream] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14, types: [java.io.OutputStream, java.util.zip.GZIPOutputStream] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean gzipCompress(java.io.File r4, java.lang.String r5) {
        /*
            java.io.File r5 = createFileIfUnExist(r5)
            r0 = 0
            if (r5 != 0) goto L8
            return r0
        L8:
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3b java.io.FileNotFoundException -> L4b
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3b java.io.FileNotFoundException -> L4b
            java.util.zip.GZIPOutputStream r4 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L2c java.io.IOException -> L30 java.io.FileNotFoundException -> L34
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L2c java.io.IOException -> L30 java.io.FileNotFoundException -> L34
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L2c java.io.IOException -> L30 java.io.FileNotFoundException -> L34
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L2c java.io.IOException -> L30 java.io.FileNotFoundException -> L34
            copy(r2, r4)     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L28 java.io.FileNotFoundException -> L2a
            r4.flush()     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L28 java.io.FileNotFoundException -> L2a
            r2.close()     // Catch: java.io.IOException -> L24
            r4.close()     // Catch: java.io.IOException -> L24
        L24:
            r4 = 1
            return r4
        L26:
            r5 = move-exception
            goto L2e
        L28:
            r5 = move-exception
            goto L32
        L2a:
            r5 = move-exception
            goto L36
        L2c:
            r5 = move-exception
            r4 = r1
        L2e:
            r1 = r2
            goto L5a
        L30:
            r5 = move-exception
            r4 = r1
        L32:
            r1 = r2
            goto L3d
        L34:
            r5 = move-exception
            r4 = r1
        L36:
            r1 = r2
            goto L4d
        L38:
            r5 = move-exception
            r4 = r1
            goto L5a
        L3b:
            r5 = move-exception
            r4 = r1
        L3d:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L59
            if (r1 == 0) goto L45
            r1.close()     // Catch: java.io.IOException -> L58
        L45:
            if (r4 == 0) goto L58
        L47:
            r4.close()     // Catch: java.io.IOException -> L58
            goto L58
        L4b:
            r5 = move-exception
            r4 = r1
        L4d:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L59
            if (r1 == 0) goto L55
            r1.close()     // Catch: java.io.IOException -> L58
        L55:
            if (r4 == 0) goto L58
            goto L47
        L58:
            return r0
        L59:
            r5 = move-exception
        L5a:
            if (r1 == 0) goto L5f
            r1.close()     // Catch: java.io.IOException -> L64
        L5f:
            if (r4 == 0) goto L64
            r4.close()     // Catch: java.io.IOException -> L64
        L64:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nirvana.tools.crash.FileUtils.gzipCompress(java.io.File, java.lang.String):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:57:0x008f A[Catch: IOException -> 0x008b, TRY_LEAVE, TryCatch #7 {IOException -> 0x008b, blocks: (B:65:0x0087, B:57:0x008f), top: B:64:0x0087 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String readStringFromFile(java.io.File r6) {
        /*
            r0 = 0
            if (r6 == 0) goto L9b
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L48 java.io.IOException -> L4a java.io.FileNotFoundException -> L67
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L48 java.io.IOException -> L4a java.io.FileNotFoundException -> L67
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e java.io.FileNotFoundException -> L43
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e java.io.FileNotFoundException -> L43
            java.lang.String r4 = "UTF-8"
            r3.<init>(r2, r4)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e java.io.FileNotFoundException -> L43
            r6.<init>(r3)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e java.io.FileNotFoundException -> L43
        L19:
            java.lang.String r0 = r6.readLine()     // Catch: java.io.IOException -> L38 java.io.FileNotFoundException -> L3a java.lang.Throwable -> L84
            if (r0 == 0) goto L28
            r1.append(r0)     // Catch: java.io.IOException -> L38 java.io.FileNotFoundException -> L3a java.lang.Throwable -> L84
            java.lang.String r0 = "\n"
            r1.append(r0)     // Catch: java.io.IOException -> L38 java.io.FileNotFoundException -> L3a java.lang.Throwable -> L84
            goto L19
        L28:
            r2.close()     // Catch: java.io.IOException -> L2f
            r6.close()     // Catch: java.io.IOException -> L2f
            goto L33
        L2f:
            r6 = move-exception
            r6.printStackTrace()
        L33:
            java.lang.String r6 = r1.toString()
            return r6
        L38:
            r0 = move-exception
            goto L4e
        L3a:
            r0 = move-exception
            goto L6b
        L3c:
            r6 = r0
            goto L84
        L3e:
            r6 = move-exception
            r5 = r0
            r0 = r6
            r6 = r5
            goto L4e
        L43:
            r6 = move-exception
            r5 = r0
            r0 = r6
            r6 = r5
            goto L6b
        L48:
            r6 = r0
            goto L85
        L4a:
            r6 = move-exception
            r2 = r0
            r0 = r6
            r6 = r2
        L4e:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L84
            if (r2 == 0) goto L59
            r2.close()     // Catch: java.io.IOException -> L57
            goto L59
        L57:
            r6 = move-exception
            goto L5f
        L59:
            if (r6 == 0) goto L62
            r6.close()     // Catch: java.io.IOException -> L57
            goto L62
        L5f:
            r6.printStackTrace()
        L62:
            java.lang.String r6 = r1.toString()
            return r6
        L67:
            r6 = move-exception
            r2 = r0
            r0 = r6
            r6 = r2
        L6b:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L84
            if (r2 == 0) goto L76
            r2.close()     // Catch: java.io.IOException -> L74
            goto L76
        L74:
            r6 = move-exception
            goto L7c
        L76:
            if (r6 == 0) goto L7f
            r6.close()     // Catch: java.io.IOException -> L74
            goto L7f
        L7c:
            r6.printStackTrace()
        L7f:
            java.lang.String r6 = r1.toString()
            return r6
        L84:
            r0 = r2
        L85:
            if (r0 == 0) goto L8d
            r0.close()     // Catch: java.io.IOException -> L8b
            goto L8d
        L8b:
            r6 = move-exception
            goto L93
        L8d:
            if (r6 == 0) goto L96
            r6.close()     // Catch: java.io.IOException -> L8b
            goto L96
        L93:
            r6.printStackTrace()
        L96:
            java.lang.String r6 = r1.toString()
            return r6
        L9b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nirvana.tools.crash.FileUtils.readStringFromFile(java.io.File):java.lang.String");
    }

    public static void renameFile(String str, String str2) {
        new File(str).renameTo(new File(str2));
    }

    public static void writeFile(String str, String str2) {
        File createFileIfUnExist = createFileIfUnExist(str);
        if (createFileIfUnExist == null) {
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(createFileIfUnExist);
                try {
                    fileOutputStream2.write(str2.getBytes());
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (Exception e10) {
                    e = e10;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e11) {
                            e11.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e12) {
                            e12.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e13) {
                e = e13;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String writeSelfJavaLog(Context context, SdkInfo sdkInfo, Thread thread, Throwable th, String str, String str2, String str3, Map<String, String> map) {
        String absolutePath = new File(context.getCacheDir(), "crash/".concat(String.valueOf(str3))).getAbsolutePath();
        createFileIfUnExist(absolutePath);
        long maxMemory = Runtime.getRuntime().maxMemory();
        String join = TextUtils.join(",", Build.SUPPORTED_ABIS);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(absolutePath);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
            outputStreamWriter.append((CharSequence) fillContent(context, str, join, str2, maxMemory, sdkInfo, str3, map, thread, th));
            outputStreamWriter.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e10) {
            e10.printStackTrace();
        }
        return absolutePath;
    }
}
