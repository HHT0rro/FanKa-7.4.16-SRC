package fd;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.internal.bk;
import com.hailiang.advlib.core.QMConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONObject;

/* compiled from: SdkPuller.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static String f49297a;

    /* compiled from: SdkPuller.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ QMConfig f49298b;

        public a(QMConfig qMConfig) {
            this.f49298b = qMConfig;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.e(this.f49298b);
            com.hailiang.advlib.common.d.a(this, 900000L);
        }
    }

    /* compiled from: SdkPuller.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static e f49300a = new e(null);
    }

    public /* synthetic */ e(a aVar) {
        this();
    }

    public static e a() {
        return b.f49300a;
    }

    public static String b(@NonNull Context context) {
        if (!TextUtils.isEmpty(f49297a)) {
            return f49297a;
        }
        String b4 = com.hailiang.advlib.common.e.b(context);
        f49297a = b4;
        return b4;
    }

    public static String c(Context context, String str, String str2, String str3) throws IOException {
        long currentTimeMillis = System.currentTimeMillis();
        URLConnection openConnection = new URL(str).openConnection();
        try {
            File file = new File(str2 + "/" + str3);
            String a10 = (file.exists() && Build.VERSION.SDK_INT == 33) ? com.hailiang.advlib.common.e.a(new FileInputStream(file), 0, -1) : "";
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            InputStream inputStream = openConnection.getInputStream();
            if (str.endsWith(".jar")) {
                com.hailiang.advlib.common.e.a(inputStream, fileOutputStream);
            } else {
                com.hailiang.advlib.common.e.b(inputStream, fileOutputStream);
            }
            inputStream.close();
            fileOutputStream.flush();
            fileOutputStream.close();
            file.setReadOnly();
            if (f(file)) {
                if (Build.VERSION.SDK_INT == 33) {
                    if (g(a10, file)) {
                        com.hailiang.advlib.common.d.a(context, "FINISH", str, System.currentTimeMillis() - currentTimeMillis);
                        String str4 = str2 + str3;
                        try {
                            if (openConnection instanceof HttpURLConnection) {
                                if (((HttpURLConnection) openConnection).getErrorStream() != null) {
                                    ((HttpURLConnection) openConnection).getErrorStream().close();
                                }
                                ((HttpURLConnection) openConnection).disconnect();
                            }
                        } catch (Throwable unused) {
                        }
                        return str4;
                    }
                    com.hailiang.advlib.common.d.a(context, "READ_FILE", str, System.currentTimeMillis() - currentTimeMillis);
                    try {
                        if (openConnection instanceof HttpURLConnection) {
                            if (((HttpURLConnection) openConnection).getErrorStream() != null) {
                                ((HttpURLConnection) openConnection).getErrorStream().close();
                            }
                            ((HttpURLConnection) openConnection).disconnect();
                        }
                    } catch (Throwable unused2) {
                    }
                    return "";
                }
                com.hailiang.advlib.common.d.a(context, "FINISH", str, System.currentTimeMillis() - currentTimeMillis);
                String str5 = str2 + str3;
                try {
                    if (openConnection instanceof HttpURLConnection) {
                        if (((HttpURLConnection) openConnection).getErrorStream() != null) {
                            ((HttpURLConnection) openConnection).getErrorStream().close();
                        }
                        ((HttpURLConnection) openConnection).disconnect();
                    }
                } catch (Throwable unused3) {
                }
                return str5;
            }
            com.hailiang.advlib.common.d.a(context, "NOT_MATCH", str, System.currentTimeMillis() - currentTimeMillis);
            file.delete();
            try {
                if (openConnection instanceof HttpURLConnection) {
                    if (((HttpURLConnection) openConnection).getErrorStream() != null) {
                        ((HttpURLConnection) openConnection).getErrorStream().close();
                    }
                    ((HttpURLConnection) openConnection).disconnect();
                }
            } catch (Throwable unused4) {
            }
            return "";
        } catch (Throwable th) {
            if (openConnection != null) {
                try {
                    if (openConnection instanceof HttpURLConnection) {
                        if (((HttpURLConnection) openConnection).getErrorStream() != null) {
                            ((HttpURLConnection) openConnection).getErrorStream().close();
                        }
                        ((HttpURLConnection) openConnection).disconnect();
                    }
                } catch (Throwable unused5) {
                }
            }
            throw th;
        }
    }

    public static boolean f(@NonNull File file) throws IOException {
        ZipFile zipFile;
        boolean z10;
        try {
            zipFile = new ZipFile(file);
        } catch (Throwable th) {
            th = th;
            zipFile = null;
        }
        try {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (true) {
                if (!entries.hasMoreElements()) {
                    z10 = false;
                    break;
                }
                if (entries.nextElement().getName().equals("androidx.temp")) {
                    z10 = true;
                    break;
                }
            }
            try {
                zipFile.close();
            } catch (IOException unused) {
            }
            return com.hailiang.advlib.common.e.a() == z10;
        } catch (Throwable th2) {
            th = th2;
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    public static boolean g(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            return !str.equals(com.hailiang.advlib.common.e.a(new FileInputStream(file), 0, -1));
        } catch (Throwable unused) {
            return true;
        }
    }

    public final JSONObject d(Context context, QMConfig qMConfig) {
        FileInputStream fileInputStream;
        String str;
        File file = new File(f.f49306f + "/" + f.f49302b);
        try {
            if (file.length() > 0) {
                fileInputStream = new FileInputStream(file);
                try {
                    str = com.hailiang.advlib.common.e.a(fileInputStream, 0, -1);
                } catch (Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                            }
                        }
                        return null;
                    } finally {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th3) {
                                th3.printStackTrace();
                            }
                        }
                    }
                }
            } else {
                str = "";
                fileInputStream = null;
            }
            String str2 = Build.VERSION.RELEASE;
            if (str2 != null) {
                String str3 = Build.BRAND;
                String str4 = Build.MODEL;
                String packageName = context.getPackageName();
                String b4 = b(context);
                if (TextUtils.isEmpty(b4)) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                String androidId = qMConfig.getAndroidId();
                if (TextUtils.isEmpty(androidId)) {
                    androidId = f.i(context);
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("value=");
                sb2.append(androidId);
                jSONObject.put("current_md5", str).put("brand", str3).put(bk.f9900i, str4).put("sdk_version", "3.460.12.426").put("os_version", str2).put("package_name", packageName).put("app_version", b4).put("dda", URLEncoder.encode(fd.a.a("CPC!@#$%Q529! 1*", androidId)));
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                }
                return jSONObject;
            }
            throw new IllegalStateException();
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x009a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void e(com.hailiang.advlib.core.QMConfig r9) {
        /*
            r8 = this;
            java.lang.String r0 = "UTF-8"
            android.content.Context r1 = r9.getContext()
            r2 = 1
            r3 = 0
            org.json.JSONObject r9 = r8.d(r1, r9)     // Catch: java.lang.Exception -> L65 org.json.JSONException -> L68
            if (r9 != 0) goto Lf
            return
        Lf:
            java.lang.String r4 = fd.f.f49303c     // Catch: java.lang.Exception -> L65 org.json.JSONException -> L68
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Exception -> L65 org.json.JSONException -> L68
            java.lang.String r9 = com.hailiang.advlib.common.e.a(r4, r9)     // Catch: java.lang.Exception -> L65 org.json.JSONException -> L68
            boolean r4 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Exception -> L65 org.json.JSONException -> L68
            if (r4 == 0) goto L20
            return
        L20:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Exception -> L65 org.json.JSONException -> L68
            r4.<init>(r9)     // Catch: java.lang.Exception -> L65 org.json.JSONException -> L68
            java.lang.String r9 = "action"
            int r9 = r4.getInt(r9)     // Catch: java.lang.Exception -> L65 org.json.JSONException -> L68
            if (r9 == 0) goto L64
            if (r9 == r2) goto L31
            r1 = r3
            goto L80
        L31:
            java.lang.String r9 = "version"
            java.lang.String r9 = r4.optString(r9)     // Catch: java.lang.Exception -> L65 org.json.JSONException -> L68
            boolean r5 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Exception -> L65 org.json.JSONException -> L68
            if (r5 != 0) goto L46
            java.lang.String r5 = "3.460"
            int r9 = r5.compareTo(r9)     // Catch: java.lang.Exception -> L65 org.json.JSONException -> L68
            if (r9 < 0) goto L46
            return
        L46:
            java.lang.String r9 = "target_url"
            java.lang.String r9 = r4.getString(r9)     // Catch: java.lang.Exception -> L65 org.json.JSONException -> L68
            java.lang.String r5 = "START"
            r6 = 0
            com.hailiang.advlib.common.d.a(r1, r5, r9, r6)     // Catch: java.lang.Exception -> L65 org.json.JSONException -> L68
            java.lang.String r5 = fd.f.f49306f     // Catch: java.lang.Exception -> L65 org.json.JSONException -> L68
            java.lang.String r6 = fd.f.f49302b     // Catch: java.lang.Exception -> L65 org.json.JSONException -> L68
            java.lang.String r9 = c(r1, r9, r5, r6)     // Catch: java.lang.Exception -> L65 org.json.JSONException -> L68
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Exception -> L65 org.json.JSONException -> L68
            if (r9 != 0) goto L64
            fd.f.e(r4)     // Catch: java.lang.Exception -> L65 org.json.JSONException -> L68
        L64:
            return
        L65:
            r9 = move-exception
            r1 = r3
            goto L83
        L68:
            r9 = move-exception
            r9.printStackTrace()     // Catch: java.lang.Exception -> L65
            java.lang.String r1 = r9.getMessage()     // Catch: java.lang.Exception -> L7b
            java.lang.Class r9 = r9.getClass()     // Catch: java.lang.Exception -> L79
            java.lang.String r9 = r9.getName()     // Catch: java.lang.Exception -> L79
            goto L98
        L79:
            r9 = move-exception
            goto L7d
        L7b:
            r9 = move-exception
            r1 = r3
        L7d:
            r9.printStackTrace()     // Catch: java.lang.Exception -> L82
        L80:
            r9 = r3
            goto L98
        L82:
            r9 = move-exception
        L83:
            r9.printStackTrace()
            java.lang.String r1 = r9.getMessage()     // Catch: java.lang.Exception -> L93
            java.lang.Class r9 = r9.getClass()     // Catch: java.lang.Exception -> L93
            java.lang.String r9 = r9.getName()     // Catch: java.lang.Exception -> L93
            goto L98
        L93:
            r9 = move-exception
            r9.printStackTrace()
            goto L80
        L98:
            if (r1 == 0) goto Le2
            if (r9 == 0) goto Le2
            java.lang.String r4 = "%s?iclicashsid=baadfaad&os=Android&v=%s&op1=%s&t=%s&op2=%s&op3=%s"
            r5 = 6
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Exception -> Lde
            r6 = 0
            java.lang.String r7 = "https://tracelog-debug.qquanquan.com"
            r5[r6] = r7     // Catch: java.lang.Exception -> Lde
            java.lang.String r6 = android.os.Build.VERSION.RELEASE     // Catch: java.lang.Exception -> Lde
            java.lang.String r6 = java.net.URLEncoder.encode(r6, r0)     // Catch: java.lang.Exception -> Lde
            r5[r2] = r6     // Catch: java.lang.Exception -> Lde
            r2 = 2
            java.lang.String r1 = java.net.URLEncoder.encode(r1, r0)     // Catch: java.lang.Exception -> Lde
            r5[r2] = r1     // Catch: java.lang.Exception -> Lde
            r1 = 3
            java.lang.String r9 = java.net.URLEncoder.encode(r9, r0)     // Catch: java.lang.Exception -> Lde
            r5[r1] = r9     // Catch: java.lang.Exception -> Lde
            r9 = 4
            java.lang.String r1 = android.os.Build.BRAND     // Catch: java.lang.Exception -> Lde
            java.lang.String r1 = java.net.URLEncoder.encode(r1, r0)     // Catch: java.lang.Exception -> Lde
            r5[r9] = r1     // Catch: java.lang.Exception -> Lde
            r9 = 5
            java.lang.String r1 = android.os.Build.MODEL     // Catch: java.lang.Exception -> Lde
            java.lang.String r0 = java.net.URLEncoder.encode(r1, r0)     // Catch: java.lang.Exception -> Lde
            r5[r9] = r0     // Catch: java.lang.Exception -> Lde
            java.lang.String r9 = java.lang.String.format(r4, r5)     // Catch: java.lang.Exception -> Lde
            android.net.Uri r9 = android.net.Uri.parse(r9)     // Catch: java.lang.Exception -> Lde
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Exception -> Lde
            com.hailiang.advlib.common.e.a(r9, r3)     // Catch: java.lang.Exception -> Lde
            goto Le2
        Lde:
            r9 = move-exception
            r9.printStackTrace()
        Le2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fd.e.e(com.hailiang.advlib.core.QMConfig):void");
    }

    public void h(QMConfig qMConfig) {
        com.hailiang.advlib.common.d.a(new a(qMConfig));
    }

    public e() {
    }
}
