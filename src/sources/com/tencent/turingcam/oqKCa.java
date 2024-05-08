package com.tencent.turingcam;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.os.Debug;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.JsonWriter;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import com.android.internal.content.NativeLibraryHelper;
import com.huawei.flexiblelayout.n;
import com.kuaishou.weapon.p0.t;
import com.nirvana.tools.logger.cache.db.DBHelpTool;
import com.tencent.turingface.sdk.mfa.Bwfl9;
import com.tencent.turingface.sdk.mfa.G1g37;
import com.tencent.turingface.sdk.mfa.ORjG3;
import com.tencent.turingface.sdk.mfa.V3a8U;
import com.tencent.turingface.sdk.mfa.bUA8L;
import com.tencent.turingface.sdk.mfa.fDI6Z;
import com.tencent.turingface.sdk.mfa.kC0XR;
import com.tencent.turingface.sdk.mfa.tbHx2;
import dalvik.system.DexFile;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.security.MessageDigest;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Pattern;
import java.util.zip.DeflaterOutputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class oqKCa {

    /* renamed from: a, reason: collision with root package name */
    public static int f45455a;

    public static int a(int i10, boolean z10, int i11) {
        return i10 | ((z10 ? 1 : 0) << i11);
    }

    public static <E> E a(SparseArray<Object> sparseArray, int i10, Class<E> cls) {
        if (sparseArray == null) {
            return null;
        }
        Object obj = sparseArray.get(i10);
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        return null;
    }

    public static int b(Context context) {
        boolean z10 = false;
        int a10 = a(a(0, Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0, 0), Settings.Secure.getInt(context.getContentResolver(), "development_settings_enabled", 0) > 0, 1);
        try {
            if ((context.getApplicationInfo().flags & 2) > 0) {
                z10 = true;
            }
        } catch (Throwable unused) {
        }
        return a(a(a10, z10, 2), Debug.isDebuggerConnected(), 3);
    }

    public static fDI6Z c(Context context) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return null;
        }
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            tbHx2 tbhx2 = new tbHx2();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            if (context.bindService(intent, tbhx2, 1)) {
                try {
                    IBinder a10 = tbhx2.a();
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                        a10.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        String readString = obtain2.readString();
                        obtain2.recycle();
                        obtain.recycle();
                        obtain = Parcel.obtain();
                        obtain2 = Parcel.obtain();
                        try {
                            obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                            obtain.writeInt(1);
                            a10.transact(2, obtain, obtain2, 0);
                            obtain2.readException();
                            boolean z10 = obtain2.readInt() != 0;
                            obtain2.recycle();
                            obtain.recycle();
                            return new fDI6Z(readString, z10);
                        } finally {
                        }
                    } finally {
                    }
                } catch (Exception unused) {
                } finally {
                    context.unbindService(tbhx2);
                }
            }
        } catch (Exception unused2) {
        }
        return null;
    }

    public static String d(Context context) {
        BufferedReader bufferedReader;
        int i10;
        Pattern[] patternArr;
        System.currentTimeMillis();
        HashSet hashSet = new HashSet();
        try {
            String packageName = context.getPackageName();
            Pattern compile = Pattern.compile("^/data/user/\\d+/" + packageName);
            String str = context.getApplicationInfo().nativeLibraryDir;
            bufferedReader = new BufferedReader(new FileReader(kC0XR.a(kC0XR.f45857n)));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String a10 = a(readLine, packageName, compile, str);
                    if (a10 != null) {
                        hashSet.add(a10);
                    }
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
        b(bufferedReader);
        String[] strArr = V3a8U.f45716a;
        synchronized (V3a8U.class) {
            i10 = 0;
            if (V3a8U.f45717b != null) {
                patternArr = V3a8U.f45717b;
            } else {
                V3a8U.f45717b = new Pattern[strArr.length];
                ArrayList arrayList = new ArrayList();
                for (int i11 = 0; i11 < V3a8U.f45717b.length; i11++) {
                    try {
                        arrayList.add(Pattern.compile(strArr[i11]));
                    } catch (Throwable unused3) {
                    }
                }
                V3a8U.f45717b = (Pattern[]) arrayList.toArray(new Pattern[0]);
                patternArr = V3a8U.f45717b;
            }
        }
        Iterator iterator2 = hashSet.iterator2();
        while (iterator2.hasNext()) {
            String str2 = (String) iterator2.next();
            int length = patternArr.length;
            int i12 = 0;
            while (true) {
                if (i12 >= length) {
                    break;
                }
                if (patternArr[i12].matcher(str2).find()) {
                    iterator2.remove();
                    break;
                }
                i12++;
            }
        }
        if (hashSet.size() <= 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator iterator22 = hashSet.iterator2();
        while (iterator22.hasNext()) {
            i10++;
            sb2.append((String) iterator22.next());
            if (i10 >= 8) {
                break;
            }
            if (iterator22.hasNext()) {
                sb2.append("_");
            }
        }
        return sb2.toString();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(16:3|4|5|6|7|8|9|(3:38|(2:40|(2:43|44)(1:42))|46)|12|13|88|19|20|21|22|23)|50|7|8|9|(1:11)(5:33|35|38|(0)|46)|12|13|88) */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x004b A[Catch: all -> 0x0058, TRY_LEAVE, TryCatch #2 {all -> 0x0058, blocks: (B:9:0x0021, B:33:0x0037, B:35:0x003f, B:38:0x0043, B:40:0x004b), top: B:8:0x0021 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int e(android.content.Context r8) {
        /*
            java.lang.System.currentTimeMillis()
            android.content.pm.PackageManager r0 = r8.getPackageManager()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto Lc
            goto L19
        Lc:
            int[] r3 = com.tencent.turingface.sdk.mfa.kC0XR.f45853l
            java.lang.String r3 = com.tencent.turingface.sdk.mfa.kC0XR.a(r3)
            r4 = 128(0x80, float:1.794E-43)
            r0.getPackageInfo(r3, r4)     // Catch: java.lang.Throwable -> L19
            r0 = 1
            goto L1a
        L19:
            r0 = 0
        L1a:
            int r0 = a(r2, r0, r2)
            java.lang.System.currentTimeMillis()
            int[] r3 = com.tencent.turingface.sdk.mfa.kC0XR.f45857n     // Catch: java.lang.Throwable -> L58
            java.lang.String r3 = com.tencent.turingface.sdk.mfa.kC0XR.a(r3)     // Catch: java.lang.Throwable -> L58
            java.lang.String r4 = new java.lang.String     // Catch: java.lang.Throwable -> L58
            byte[] r3 = d(r3)     // Catch: java.lang.Throwable -> L58
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L58
            boolean r3 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L58
            if (r3 == 0) goto L37
            goto L58
        L37:
            java.lang.String r3 = "\\n"
            java.lang.String[] r3 = r4.split(r3)     // Catch: java.lang.Throwable -> L58
            if (r3 == 0) goto L58
            int r4 = r3.length     // Catch: java.lang.Throwable -> L58
            if (r4 != 0) goto L43
            goto L58
        L43:
            java.lang.String r4 = r8.getPackageName()     // Catch: java.lang.Throwable -> L58
            int r5 = r3.length     // Catch: java.lang.Throwable -> L58
            r6 = 0
        L49:
            if (r6 >= r5) goto L58
            r7 = r3[r6]     // Catch: java.lang.Throwable -> L58
            boolean r7 = a(r4, r7)     // Catch: java.lang.Throwable -> L58
            if (r7 == 0) goto L55
            r3 = 1
            goto L59
        L55:
            int r6 = r6 + 1
            goto L49
        L58:
            r3 = 0
        L59:
            int r0 = a(r0, r3, r1)
            java.lang.System.currentTimeMillis()
            java.lang.Object r3 = new java.lang.Object
            r3.<init>()
            java.util.concurrent.atomic.AtomicReference r4 = new java.util.concurrent.atomic.AtomicReference
            r4.<init>()
            java.util.concurrent.atomic.AtomicBoolean r5 = new java.util.concurrent.atomic.AtomicBoolean
            r5.<init>(r2)
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            r4.set(r6)
            android.os.Handler r6 = new android.os.Handler
            android.os.Looper r8 = r8.getMainLooper()
            r6.<init>(r8)
            java.lang.System.currentTimeMillis()
            com.tencent.turingface.sdk.mfa.afk8T r8 = new com.tencent.turingface.sdk.mfa.afk8T
            r8.<init>(r5, r4, r3)
            r6.post(r8)
            monitor-enter(r3)
            r6 = 100
            r3.wait(r6)     // Catch: java.lang.Throwable -> L8f java.lang.InterruptedException -> L91
            goto L91
        L8f:
            r8 = move-exception
            goto Lbc
        L91:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L8f
            r5.set(r1)
            java.lang.Object r8 = r4.get()
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            r3 = 2
            int r8 = a(r0, r8, r3)
            java.lang.System.currentTimeMillis()
            int[] r0 = com.tencent.turingface.sdk.mfa.kC0XR.F0     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r0 = com.tencent.turingface.sdk.mfa.kC0XR.a(r0)     // Catch: java.lang.Throwable -> Lb5
            java.lang.ClassLoader r3 = java.lang.ClassLoader.getSystemClassLoader()     // Catch: java.lang.Throwable -> Lb5
            r3.loadClass(r0)     // Catch: java.lang.Throwable -> Lb5
            goto Lb6
        Lb5:
            r1 = 0
        Lb6:
            r0 = 3
            int r8 = a(r8, r1, r0)
            return r8
        Lbc:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L8f
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingcam.oqKCa.e(android.content.Context):int");
    }

    public static String f(Context context) {
        String a10 = G1g37.f45591b.a(context, "s_h");
        if (a10 == null || a10.isEmpty()) {
            return "";
        }
        HashSet hashSet = new HashSet(Arrays.asList(a10.split(";")));
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        try {
            jsonWriter.beginObject();
            Iterator iterator2 = hashSet.iterator2();
            while (iterator2.hasNext()) {
                String str = (String) iterator2.next();
                jsonWriter.name(str);
                ORjG3.SkEpO a11 = com.tencent.turingface.sdk.mfa.SkEpO.a(str);
                jsonWriter.beginObject();
                jsonWriter.name("std");
                jsonWriter.value(a11.f45661a);
                jsonWriter.name(NotificationCompat.CATEGORY_ERROR);
                jsonWriter.value(a11.f45662b);
                jsonWriter.endObject();
            }
            jsonWriter.endObject();
            return stringWriter.toString();
        } catch (IOException unused) {
            return "";
        }
    }

    public static boolean f() {
        return true;
    }

    public static int g(Context context) {
        try {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver == null || !TextUtils.equals(registerReceiver.getAction(), "android.intent.action.BATTERY_CHANGED")) {
                return -1;
            }
            int intExtra = registerReceiver.getIntExtra(DBHelpTool.RecordEntry.COLUMN_NAME_LEVEL, 0);
            int intExtra2 = registerReceiver.getIntExtra(n.f28264e, 100);
            if (intExtra2 == 0) {
                return -1;
            }
            int i10 = (intExtra * 100) / intExtra2;
            int i11 = i10 >= 0 ? i10 : 0;
            if (i11 > 100) {
                return 100;
            }
            return i11;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static int h(Context context) {
        Intent intent = null;
        try {
            intent = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Throwable unused) {
        }
        if (intent == null) {
            return 0;
        }
        int intExtra = intent.getIntExtra("status", -1);
        if (!(intExtra == 2 || intExtra == 5)) {
            return 1;
        }
        int intExtra2 = intent.getIntExtra("plugged", -1);
        if (intExtra2 == 2) {
            return 3;
        }
        return intExtra2 == 1 ? 2 : 0;
    }

    public static boolean i(Context context) {
        File file;
        byte[] decode = Base64.decode("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TGFuZHJvaWQvdXRpbC9Mb2c7ABFMamF2YS9sYW5nL0NsYXNzOwAUTGphdmEvbGFuZy9DbGFzczwqPjsAEkxqYXZhL2xhbmcvT2JqZWN0OwASTGphdmEvbGFuZy9TdHJpbmc7ABJMamF2YS9sYW5nL1N5c3RlbTsAFUxqYXZhL2xhbmcvVGhyb3dhYmxlOwAaTGphdmEvbGFuZy9yZWZsZWN0L01ldGhvZDsAJkxtZS93ZWlzaHUvZnJlZXJlZmxlY3Rpb24vQnVpbGRDb25maWc7ACVMbWUvd2Vpc2h1L3JlZmxlY3Rpb24vQm9vdHN0cmFwQ2xhc3M7ACFMbWUvd2Vpc2h1L3JlZmxlY3Rpb24vUmVmbGVjdGlvbjsAClJlZmxlY3Rpb24AD1JlZmxlY3Rpb24uamF2YQAHU0RLX0lOVAADVEFHAAFWAAxWRVJTSU9OX0NPREUADFZFUlNJT05fTkFNRQACVkwAAVoAAlpMABJbTGphdmEvbGFuZy9DbGFzczsAE1tMamF2YS9sYW5nL09iamVjdDsAE1tMamF2YS9sYW5nL1N0cmluZzsAB2NvbnRleHQAF2RhbHZpay5zeXN0ZW0uVk1SdW50aW1lAAFlAAZleGVtcHQACWV4ZW1wdEFsbAAHZm9yTmFtZQAPZnJlZS1yZWZsZWN0aW9uABJnZXRBcHBsaWNhdGlvbkluZm8AEWdldERlY2xhcmVkTWV0aG9kAApnZXRSdW50aW1lAAZpbnZva2UAC2xvYWRMaWJyYXJ5ABhtZS53ZWlzaHUuZnJlZXJlZmxlY3Rpb24ABm1ldGhvZAAHbWV0aG9kcwAZcmVmbGVjdCBib290c3RyYXAgZmFpbGVkOgAHcmVsZWFzZQAKc1ZtUnVudGltZQAWc2V0SGlkZGVuQXBpRXhlbXB0aW9ucwAQdGFyZ2V0U2RrVmVyc2lvbgAEdGhpcwAGdW5zZWFsAAx1bnNlYWxOYXRpdmUADnZtUnVudGltZUNsYXNzAAYABw4AFgAHDmr/AwEyCwEVEAMCNQvwBAREBhcBEg8DAzYLARsPqQUCBQMFBBkeAwAvCgAOAAcOACwBOgcOADYBOwcsnRriAQEDAC8KHgBIAAcOAA0ABw4AEwEtBx1yGWtaAAYXOBc8HxcABAEXAQEXBgEXHwYAAQACGQEZARkBGQEZARkGgYAEiAcDAAUACBoBCgEKB4iABKAHAYGABLQJAQnMCQGJAfQJAQnMCgEAAwALGgyBgAT4CgEJkAsBigIAAAAADgAAAAAAAAABAAAAAAAAAAEAAABEAAAAcAAAAAIAAAATAAAAgAEAAAMAAAALAAAAzAEAAAQAAAAMAAAAUAIAAAUAAAAPAAAAsAIAAAYAAAADAAAAKAMAAAEgAAAIAAAAiAMAAAEQAAAHAAAA3AUAAAIgAABEAAAAFgYAAAMgAAAIAAAAAwoAAAUgAAADAAAAZgoAAAAgAAADAAAAeAoAAAAQAAABAAAAyAoAAA==", 2);
        if (context != null) {
            file = context.getCodeCacheDir();
        } else {
            String property = System.getProperty("java.io.tmpdir");
            if (!TextUtils.isEmpty(property)) {
                File file2 = new File(property);
                if (file2.exists()) {
                    file = file2;
                }
            }
            file = null;
        }
        if (file == null) {
            return false;
        }
        File file3 = new File(file, System.currentTimeMillis() + ".dex");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file3);
            try {
                fileOutputStream.write(decode);
                fileOutputStream.close();
                return ((Boolean) new DexFile(file3).loadClass("me.weishu.reflection.BootstrapClass", null).getDeclaredMethod("exemptAll", new Class[0]).invoke(null, new Object[0])).booleanValue();
            } finally {
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                if (file3.exists()) {
                    file3.delete();
                }
                return false;
            } finally {
                if (file3.exists()) {
                    file3.delete();
                }
            }
        }
    }

    public static int j(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTING || activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED)) {
                if (activeNetworkInfo.getType() == 1) {
                    return 0;
                }
                if (activeNetworkInfo.getType() == 0) {
                    if (Proxy.getDefaultHost() == null) {
                        return Proxy.getHost(context) != null ? 2 : 1;
                    }
                    return 2;
                }
            }
            return -1;
        } catch (Throwable th) {
            String message = th.getMessage();
            return (message == null || !message.contains("ACCESS_NETWORK_STATE")) ? -3 : -2;
        }
    }

    public static String k(Context context) {
        try {
            StringBuilder sb2 = new StringBuilder();
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            sb2.append(telephonyManager.getSimState());
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 23) {
                int phoneCount = telephonyManager.getPhoneCount();
                sb2.append(",");
                sb2.append(phoneCount);
                if (phoneCount > 0 && i10 >= 26) {
                    sb2.append(",");
                    for (int i11 = 0; i11 < phoneCount; i11++) {
                        if (i11 > 0) {
                            sb2.append(";");
                        }
                        sb2.append(telephonyManager.getSimState(i11));
                    }
                }
            }
            return sb2.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean l(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            String message = th.getMessage();
            return message != null && message.contains("ACCESS_NETWORK_STATE");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0036 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m(android.content.Context r5) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 24
            if (r0 < r2) goto L8
            return r1
        L8:
            int[] r0 = com.tencent.turingface.sdk.mfa.kC0XR.f45858n0
            java.lang.String r0 = com.tencent.turingface.sdk.mfa.kC0XR.a(r0)
            java.io.File r2 = new java.io.File
            r2.<init>(r0)
            r0 = 0
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L28
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L28
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L28
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L28
            java.lang.String r0 = r3.readLine()     // Catch: java.lang.Throwable -> L26
            a(r3)
            goto L30
        L26:
            r0 = r3
            goto L29
        L28:
        L29:
            if (r0 == 0) goto L2e
            a(r0)
        L2e:
            java.lang.String r0 = ""
        L30:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L37
            return r1
        L37:
            java.lang.String r2 = "CONFIGURED"
            boolean r2 = r2.equals(r0)
            r3 = 3
            if (r2 == 0) goto L54
            r0 = 1
            android.content.ContentResolver r5 = r5.getContentResolver()     // Catch: java.lang.Throwable -> L4f
            java.lang.String r2 = "adb_enabled"
            int r5 = android.provider.Settings.Secure.getInt(r5, r2, r1)     // Catch: java.lang.Throwable -> L4f
            if (r5 <= 0) goto L50
            r1 = 1
            goto L50
        L4f:
        L50:
            if (r1 == 0) goto L53
            return r0
        L53:
            return r3
        L54:
            java.lang.String r5 = "DISCONNECTED"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L5e
            r5 = 2
            return r5
        L5e:
            java.lang.String r5 = "CONNECTED"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L67
            return r3
        L67:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingcam.oqKCa.m(android.content.Context):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a1 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String n(android.content.Context r7) {
        /*
            java.util.Map<java.lang.String, java.util.Set<java.lang.String>> r0 = com.tencent.turingface.sdk.mfa.V124r.f45714a
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r1 = r7.getPackageName()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            java.lang.String r3 = ""
            r4 = 0
            if (r2 == 0) goto L16
            goto L92
        L16:
            r2 = 0
            android.content.pm.PackageManager r5 = r7.getPackageManager()     // Catch: java.lang.Throwable -> L58
            android.content.pm.PackageManager r7 = r7.getPackageManager()     // Catch: java.lang.Throwable -> L58
            android.content.pm.ApplicationInfo r7 = r7.getApplicationInfo(r1, r4)     // Catch: java.lang.Throwable -> L58
            int r7 = r7.uid     // Catch: java.lang.Throwable -> L58
            java.lang.String[] r7 = r5.getPackagesForUid(r7)     // Catch: java.lang.Throwable -> L58
            r7 = r7[r4]     // Catch: java.lang.Throwable -> L58
            r6 = 64
            android.content.pm.PackageInfo r7 = r5.getPackageInfo(r7, r6)     // Catch: java.lang.Throwable -> L58
            android.content.pm.Signature[] r7 = r7.signatures     // Catch: java.lang.Throwable -> L58
            r7 = r7[r4]     // Catch: java.lang.Throwable -> L58
            java.io.ByteArrayInputStream r5 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L58
            byte[] r7 = r7.toByteArray()     // Catch: java.lang.Throwable -> L58
            r5.<init>(r7)     // Catch: java.lang.Throwable -> L58
            java.lang.String r7 = "X.509"
            java.security.cert.CertificateFactory r7 = java.security.cert.CertificateFactory.getInstance(r7)     // Catch: java.lang.Throwable -> L56
            java.security.cert.Certificate r7 = r7.generateCertificate(r5)     // Catch: java.lang.Throwable -> L56
            java.security.cert.X509Certificate r7 = (java.security.cert.X509Certificate) r7     // Catch: java.lang.Throwable -> L56
            byte[] r7 = r7.getEncoded()     // Catch: java.lang.Throwable -> L56
            java.lang.String r7 = com.tencent.turingface.sdk.mfa.EQsUZ.a(r7)     // Catch: java.lang.Throwable -> L56
            r5.close()     // Catch: java.lang.Throwable -> L5f
            goto L5f
        L56:
            r2 = r5
            goto L59
        L58:
        L59:
            if (r2 == 0) goto L5e
            r2.close()     // Catch: java.lang.Throwable -> L5e
        L5e:
            r7 = r3
        L5f:
            com.tencent.turingface.sdk.mfa.Bwfl9 r2 = new com.tencent.turingface.sdk.mfa.Bwfl9
            r2.<init>()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = com.tencent.turingface.sdk.mfa.uAnWx.f45959a
            r5.append(r6)
            java.lang.String r6 = com.tencent.turingface.sdk.mfa.uAnWx.f45960b
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r2.f45535a = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r1)
            java.lang.String r1 = "_"
            r5.append(r1)
            r5.append(r7)
            java.lang.String r7 = r5.toString()
            r2.f45536b = r7
            r0.add(r2)
        L92:
            int r7 = r0.size()
            if (r7 == 0) goto La1
            java.lang.Object r7 = r0.get(r4)
            com.tencent.turingface.sdk.mfa.Bwfl9 r7 = (com.tencent.turingface.sdk.mfa.Bwfl9) r7
            java.lang.String r7 = r7.f45536b
            return r7
        La1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingcam.oqKCa.n(android.content.Context):java.lang.String");
    }

    public static String a(String str) {
        int indexOf;
        String[] split = str.split(" ", 3);
        if (split.length <= 2 || !"rwxp".equals(split[1]) || (indexOf = split[2].indexOf(47)) == -1) {
            return null;
        }
        String trim = split[2].substring(indexOf).trim();
        if (trim.startsWith("/data/")) {
            return null;
        }
        return split[1] + ";" + trim;
    }

    public static StringBuilder b(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        return sb2;
    }

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        for (byte b4 : bArr) {
            String hexString = Integer.toHexString(b4 & 255);
            if (hexString.length() < 2) {
                stringBuffer.append(0);
            }
            stringBuffer.append(hexString.toUpperCase(Locale.getDefault()));
        }
        return stringBuffer.toString();
    }

    public static byte[] b() {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            String a10 = kC0XR.a(kC0XR.D0);
            int[] iArr = {-36, -46, -45, -77, -22, -10, 47, -77, -72, -69, -32, 25, 21, -21, -6, -75, -71, 31, -39, -49, -49};
            for (int i10 = 0; i10 < a10.length(); i10++) {
                stringBuffer.append((char) (a10.charAt(i10) + iArr[i10]));
            }
            return stringBuffer.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static List<String> a(File file) throws IOException {
        ArrayList arrayList = new ArrayList();
        JarFile jarFile = new JarFile(file);
        try {
            Certificate[] a10 = a(jarFile, jarFile.getJarEntry("AndroidManifest.xml"), new byte[8192]);
            if (a10 != null) {
                for (Certificate certificate : a10) {
                    arrayList.add(com.tencent.turingface.sdk.mfa.EQsUZ.a(certificate.getEncoded()));
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            jarFile.close();
            throw th;
        }
        jarFile.close();
        return arrayList;
    }

    public static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static int b(SparseArray<Object> sparseArray) {
        Integer num = (Integer) a(sparseArray, 0, Integer.class);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.tencent.turingface.sdk.mfa.bUA8L b(int r12) {
        /*
            r0 = 0
            r1 = -1
            java.lang.String r2 = a(r12)     // Catch: java.lang.Throwable -> L96
            r3 = 1
            r4 = 0
            if (r12 == r1) goto L24
            java.lang.String r5 = new java.lang.String     // Catch: java.lang.Throwable -> L97
            java.util.Locale r6 = java.util.Locale.SIMPLIFIED_CHINESE     // Catch: java.lang.Throwable -> L97
            java.lang.String r7 = "/proc/%d/status"
            java.lang.Object[] r8 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L97
            java.lang.Integer r9 = java.lang.Integer.valueOf(r12)     // Catch: java.lang.Throwable -> L97
            r8[r4] = r9     // Catch: java.lang.Throwable -> L97
            java.lang.String r6 = java.lang.String.format(r6, r7, r8)     // Catch: java.lang.Throwable -> L97
            byte[] r6 = d(r6)     // Catch: java.lang.Throwable -> L97
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L97
            goto L37
        L24:
            java.lang.String r5 = new java.lang.String     // Catch: java.lang.Throwable -> L97
            java.util.Locale r6 = java.util.Locale.SIMPLIFIED_CHINESE     // Catch: java.lang.Throwable -> L97
            java.lang.String r7 = "/proc/self/status"
            java.lang.Object[] r8 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L97
            java.lang.String r6 = java.lang.String.format(r6, r7, r8)     // Catch: java.lang.Throwable -> L97
            byte[] r6 = d(r6)     // Catch: java.lang.Throwable -> L97
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L97
        L37:
            java.util.HashMap r6 = new java.util.HashMap     // Catch: java.lang.Throwable -> L97
            r6.<init>()     // Catch: java.lang.Throwable -> L97
            java.lang.String r7 = "\n"
            java.lang.String[] r5 = r5.split(r7)     // Catch: java.lang.Throwable -> L97
            int r7 = r5.length     // Catch: java.lang.Throwable -> L97
            r8 = 0
        L44:
            if (r8 >= r7) goto L65
            r9 = r5[r8]     // Catch: java.lang.Throwable -> L97
            java.lang.String r10 = ":"
            java.lang.String[] r9 = r9.split(r10)     // Catch: java.lang.Throwable -> L97
            int r10 = r9.length     // Catch: java.lang.Throwable -> L97
            r11 = 2
            if (r10 >= r11) goto L53
            goto L62
        L53:
            r10 = r9[r4]     // Catch: java.lang.Throwable -> L97
            java.lang.String r10 = r10.trim()     // Catch: java.lang.Throwable -> L97
            r9 = r9[r3]     // Catch: java.lang.Throwable -> L97
            java.lang.String r9 = r9.trim()     // Catch: java.lang.Throwable -> L97
            r6.put(r10, r9)     // Catch: java.lang.Throwable -> L97
        L62:
            int r8 = r8 + 1
            goto L44
        L65:
            java.lang.String r3 = "PPid"
            java.lang.Object r3 = r6.get(r3)     // Catch: java.lang.Throwable -> L97
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L97
            int r3 = java.lang.Integer.parseInt(r3)     // Catch: java.lang.Throwable -> L97
            java.lang.String r5 = "Uid"
            java.lang.Object r5 = r6.get(r5)     // Catch: java.lang.Throwable -> L98
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L98
            java.lang.String r7 = "\\s+"
            java.lang.String[] r5 = r5.split(r7)     // Catch: java.lang.Throwable -> L98
            r4 = r5[r4]     // Catch: java.lang.Throwable -> L98
            int r4 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.Throwable -> L98
            java.lang.String r5 = "TracerPid"
            java.lang.Object r5 = r6.get(r5)     // Catch: java.lang.Throwable -> L99
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L99
            int r5 = java.lang.Integer.parseInt(r5)     // Catch: java.lang.Throwable -> L99
            r8 = r2
            r7 = r3
            r9 = r4
            r10 = r5
            goto L9d
        L96:
            r2 = r0
        L97:
            r3 = -1
        L98:
            r4 = -1
        L99:
            r8 = r2
            r7 = r3
            r9 = r4
            r10 = -1
        L9d:
            if (r8 == 0) goto Lab
            if (r7 == r1) goto Lab
            if (r9 != r1) goto La4
            goto Lab
        La4:
            com.tencent.turingface.sdk.mfa.bUA8L r0 = new com.tencent.turingface.sdk.mfa.bUA8L
            r5 = r0
            r6 = r12
            r5.<init>(r6, r7, r8, r9, r10)
        Lab:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingcam.oqKCa.b(int):com.tencent.turingface.sdk.mfa.bUA8L");
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static byte a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTING || activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED)) {
                if (activeNetworkInfo.getType() == 1) {
                    return (byte) 0;
                }
                if (activeNetworkInfo.getType() == 0) {
                    if (Proxy.getDefaultHost() == null) {
                        return Proxy.getHost(context) != null ? (byte) 2 : (byte) 1;
                    }
                    return (byte) 2;
                }
            }
            return (byte) -1;
        } catch (Throwable th) {
            String message = th.getMessage();
            return message != null && message.contains("ACCESS_NETWORK_STATE") ? (byte) 0 : (byte) -1;
        }
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        byte[] b4 = b(bArr2);
        if (bArr == null || b4 == null || bArr.length == 0) {
            return bArr;
        }
        int length = bArr.length % 4 == 0 ? (bArr.length >>> 2) + 1 : (bArr.length >>> 2) + 2;
        int[] iArr = new int[length];
        a(bArr, iArr);
        int i10 = length - 1;
        iArr[i10] = bArr.length;
        int length2 = b4.length % 4 == 0 ? b4.length >>> 2 : (b4.length >>> 2) + 1;
        int i11 = length2 >= 4 ? length2 : 4;
        int[] iArr2 = new int[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            iArr2[i12] = 0;
        }
        a(b4, iArr2);
        int i13 = iArr[i10];
        int i14 = iArr[0];
        int i15 = (52 / (i10 + 1)) + 6;
        int i16 = 0;
        while (true) {
            int i17 = i15 - 1;
            if (i15 > 0) {
                i16 -= 1640531527;
                int i18 = (i16 >>> 2) & 3;
                int i19 = 0;
                while (i19 < i10) {
                    int i20 = i19 + 1;
                    int i21 = iArr[i20];
                    i13 = ((((i13 >>> 5) ^ (i21 << 2)) + ((i21 >>> 3) ^ (i13 << 4))) ^ ((i21 ^ i16) + (i13 ^ iArr2[(i19 & 3) ^ i18]))) + iArr[i19];
                    iArr[i19] = i13;
                    i19 = i20;
                }
                int i22 = iArr[0];
                i13 = ((((i13 >>> 5) ^ (i22 << 2)) + ((i22 >>> 3) ^ (i13 << 4))) ^ ((i22 ^ i16) + (i13 ^ iArr2[i18 ^ (i19 & 3)]))) + iArr[i10];
                iArr[i10] = i13;
                i15 = i17;
            } else {
                byte[] bArr3 = new byte[length << 2];
                a(iArr, length, bArr3);
                return bArr3;
            }
        }
    }

    public static byte[] e(String str) {
        RandomAccessFile randomAccessFile;
        byte[] bArr;
        long length;
        int i10;
        try {
            randomAccessFile = new RandomAccessFile(new File(str), t.f36226k);
            try {
                length = randomAccessFile.length();
                i10 = (int) length;
            } catch (Throwable unused) {
                try {
                    bArr = new byte[0];
                    return bArr;
                } finally {
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable unused2) {
            randomAccessFile = null;
        }
        if (i10 == length) {
            bArr = new byte[i10];
            randomAccessFile.readFully(bArr);
            try {
                randomAccessFile.close();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
            return bArr;
        }
        throw new IOException("");
    }

    public static byte[] a(String str, int i10) {
        FileInputStream fileInputStream;
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[i10];
                int i11 = 0;
                do {
                    int read = fileInputStream.read(bArr, i11, i10 - i11);
                    if (read == -1) {
                        break;
                    }
                    i11 += read;
                } while (i11 < i10);
                if (i11 == 0) {
                    b(fileInputStream);
                    return null;
                }
                if (i11 < i10) {
                    byte[] bArr2 = new byte[i11];
                    System.arraycopy((Object) bArr, 0, (Object) bArr2, 0, i11);
                    bArr = bArr2;
                }
                b(fileInputStream);
                return bArr;
            } catch (Throwable unused) {
                b(fileInputStream);
                return null;
            }
        } catch (Throwable unused2) {
            fileInputStream = null;
        }
    }

    public static String c() {
        StringBuilder sb2 = new StringBuilder();
        int myPid = Process.myPid();
        bUA8L b4 = b(myPid);
        if (b4 == null) {
            return sb2.toString();
        }
        int i10 = b4.f45752e;
        if (i10 == 0) {
            return sb2.toString();
        }
        if (i10 == myPid) {
            return sb2.toString();
        }
        sb2.append(myPid);
        sb2.append(",");
        sb2.append(b4.f45749b);
        sb2.append(",");
        sb2.append(b4.f45750c);
        sb2.append(",");
        sb2.append(i10);
        sb2.append(",");
        bUA8L b10 = b(i10);
        if (b10 != null) {
            sb2.append(b10.f45751d);
            sb2.append(",");
            sb2.append(b10.f45750c);
            sb2.append(",");
            sb2.append(b10.f45749b);
        }
        return sb2.toString();
    }

    public static String d() {
        Iterator iterator2 = ((ArrayList) com.tencent.turingface.sdk.mfa.wmqhz.a()).iterator2();
        while (iterator2.hasNext()) {
            Bwfl9 bwfl9 = (Bwfl9) iterator2.next();
            if (bwfl9.f45535a.contains(com.tencent.turingface.sdk.mfa.uAnWx.f45961c)) {
                return bwfl9.f45536b;
            }
        }
        return "";
    }

    public static byte[] d(String str) throws Throwable {
        FileInputStream fileInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(fileInputStream.available());
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
            byteArrayOutputStream = null;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (-1 == read) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (byteArray == null) {
                byteArray = "".getBytes();
            }
            return byteArray;
        } catch (Throwable th4) {
            th = th4;
            try {
                throw th;
            } finally {
                b(fileInputStream);
                b(byteArrayOutputStream);
            }
        }
    }

    public static byte[] a(SparseArray<Object> sparseArray) {
        byte[] bArr = (byte[]) a(sparseArray, 1, byte[].class);
        return bArr == null ? new byte[0] : bArr;
    }

    public static String a(int i10) {
        try {
            byte[] a10 = a(String.format(Locale.SIMPLIFIED_CHINESE, "/proc/%d/cmdline", Integer.valueOf(i10)), 100);
            String str = a10 != null ? new String(a10, 0, a(a10, 0, (char) 0)) : "";
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            byte[] a11 = a(String.format(Locale.SIMPLIFIED_CHINESE, "/proc/%d/status", Integer.valueOf(i10)), 150);
            if (a11 == null) {
                return str;
            }
            int a12 = a(a11, 7, '\n');
            return a12 == 0 ? "" : new String(a11, 6, a12 - 6);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String e() {
        Iterator iterator2 = ((ArrayList) com.tencent.turingface.sdk.mfa.wmqhz.a()).iterator2();
        while (iterator2.hasNext()) {
            Bwfl9 bwfl9 = (Bwfl9) iterator2.next();
            if (bwfl9.f45535a.contains(com.tencent.turingface.sdk.mfa.uAnWx.f45962d)) {
                return bwfl9.f45536b;
            }
        }
        return "";
    }

    public static byte[] b(byte[] bArr) {
        if (bArr == null || bArr.length <= 16) {
            return bArr;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void a(byte[] bArr, int[] iArr) {
        int length = bArr.length >> 2;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = i11 + 1;
            iArr[i10] = bArr[i11] & 255;
            int i13 = i12 + 1;
            iArr[i10] = iArr[i10] | ((bArr[i12] & 255) << 8);
            int i14 = i13 + 1;
            iArr[i10] = iArr[i10] | ((bArr[i13] & 255) << 16);
            iArr[i10] = iArr[i10] | ((bArr[i14] & 255) << 24);
            i10++;
            i11 = i14 + 1;
        }
        if (i11 < bArr.length) {
            int i15 = i11 + 1;
            iArr[i10] = bArr[i11] & 255;
            int i16 = 8;
            while (i15 < bArr.length) {
                iArr[i10] = iArr[i10] | ((bArr[i15] & 255) << i16);
                i15++;
                i16 += 8;
            }
        }
    }

    public static boolean b(File file) {
        if (!file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            try {
                return file.delete();
            } catch (Throwable unused) {
                return false;
            }
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                b(file2);
            }
        }
        try {
            return file.delete();
        } catch (Throwable unused2) {
            return false;
        }
    }

    public static byte[] c(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
        try {
            deflaterOutputStream.write(bArr);
            deflaterOutputStream.finish();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                deflaterOutputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return byteArray;
        } catch (Exception unused) {
            try {
                byteArrayOutputStream.close();
                deflaterOutputStream.close();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
            return null;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
                deflaterOutputStream.close();
            } catch (IOException e11) {
                e11.printStackTrace();
            }
            throw th;
        }
    }

    public static String a(String str, String str2, String str3) {
        return !TextUtils.isEmpty(str3) ? str3.replace(str, str2) : str3;
    }

    public static Certificate[] a(JarFile jarFile, JarEntry jarEntry, byte[] bArr) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            inputStream = jarFile.getInputStream(jarEntry);
            do {
                try {
                } catch (IOException unused) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } while (inputStream.read(bArr, 0, bArr.length) != -1);
            Certificate[] certificates = jarEntry != null ? jarEntry.getCertificates() : null;
            try {
                inputStream.close();
            } catch (IOException unused4) {
            }
            return certificates;
        } catch (IOException unused5) {
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.tencent.turingface.sdk.mfa.ucT3w a(com.tencent.turingface.sdk.mfa.ucT3w r7, byte[] r8) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingcam.oqKCa.a(com.tencent.turingface.sdk.mfa.ucT3w, byte[]):com.tencent.turingface.sdk.mfa.ucT3w");
    }

    public static byte[] c(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            bArr[i10] = Integer.valueOf(str.substring(i11, i11 + 2), 16).byteValue();
        }
        return bArr;
    }

    public static void a(int[] iArr, int i10, byte[] bArr) {
        int i11;
        int length = bArr.length >> 2;
        if (length > i10) {
            length = i10;
        }
        int i12 = 0;
        int i13 = 0;
        while (true) {
            i11 = 8;
            if (i12 >= length) {
                break;
            }
            int i14 = i13 + 1;
            bArr[i13] = (byte) (iArr[i12] & 255);
            int i15 = i14 + 1;
            bArr[i14] = (byte) ((iArr[i12] >>> 8) & 255);
            int i16 = i15 + 1;
            bArr[i15] = (byte) ((iArr[i12] >>> 16) & 255);
            i13 = i16 + 1;
            bArr[i16] = (byte) ((iArr[i12] >>> 24) & 255);
            i12++;
        }
        if (i10 <= length || i13 >= bArr.length) {
            return;
        }
        bArr[i13] = (byte) (iArr[i12] & 255);
        for (int i17 = i13 + 1; i11 <= 24 && i17 < bArr.length; i17++) {
            bArr[i17] = (byte) ((iArr[i12] >>> i11) & 255);
            i11 += 8;
        }
    }

    public static int a(byte[] bArr, int i10, char c4) {
        int i11;
        int i12 = i10 - 1;
        while (true) {
            i11 = i12 + 1;
            if (i12 >= bArr.length) {
                return 0;
            }
            if (i11 == bArr.length || bArr[i11] == c4) {
                break;
            }
            i12 = i11;
        }
        return i11;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] b4 = b(bArr2);
        if (b4 == null || bArr.length == 0) {
            return bArr;
        }
        if (bArr.length % 4 == 0 && bArr.length >= 8) {
            int length = bArr.length >>> 2;
            int[] iArr = new int[length];
            a(bArr, iArr);
            int length2 = b4.length % 4 == 0 ? b4.length >>> 2 : (b4.length >>> 2) + 1;
            int i10 = length2 >= 4 ? length2 : 4;
            int[] iArr2 = new int[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                iArr2[i11] = 0;
            }
            a(b4, iArr2);
            int i12 = length - 1;
            int i13 = iArr[i12];
            int i14 = iArr[0];
            for (int i15 = ((52 / (i12 + 1)) + 6) * (-1640531527); i15 != 0; i15 -= -1640531527) {
                int i16 = (i15 >>> 2) & 3;
                int i17 = i12;
                while (i17 > 0) {
                    int i18 = iArr[i17 - 1];
                    i14 = iArr[i17] - (((i14 ^ i15) + (i18 ^ iArr2[(i17 & 3) ^ i16])) ^ (((i18 >>> 5) ^ (i14 << 2)) + ((i14 >>> 3) ^ (i18 << 4))));
                    iArr[i17] = i14;
                    i17--;
                }
                int i19 = iArr[i12];
                i14 = iArr[0] - (((i14 ^ i15) + (iArr2[i16 ^ (i17 & 3)] ^ i19)) ^ (((i19 >>> 5) ^ (i14 << 2)) + ((i14 >>> 3) ^ (i19 << 4))));
                iArr[0] = i14;
            }
            int i20 = iArr[i12];
            if (i20 >= 0 && i20 <= (i12 << 2)) {
                byte[] bArr3 = new byte[i20];
                a(iArr, i12, bArr3);
                return bArr3;
            }
        }
        return null;
    }

    public static boolean a(InetAddress inetAddress) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket((SocketAddress) null);
            datagramSocket.send(new DatagramPacket(new byte[0], 0, inetAddress, 65535));
            datagramSocket.close();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String a() {
        try {
            File file = new File("/system/lib");
            if (file.canRead()) {
                for (File file2 : file.listFiles()) {
                    if (file2.getName().contains("rockchip")) {
                        return file2.getAbsolutePath();
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String a(String str, String str2, Pattern pattern, String str3) {
        int indexOf;
        String str4;
        boolean endsWith = str.endsWith(".so");
        boolean z10 = !endsWith && str.endsWith(".jar");
        if ((!endsWith && !z10) || (indexOf = str.indexOf(47)) == -1) {
            return null;
        }
        String trim = str.substring(indexOf).trim();
        if (!trim.startsWith("/data/")) {
            return null;
        }
        if (endsWith && str3 != null && trim.startsWith(str3)) {
            return null;
        }
        String str5 = "/data/data/" + str2 + "/";
        if (trim.startsWith(str5)) {
            return null;
        }
        if (trim.startsWith("/data/app/" + str2) || pattern.matcher(trim).find()) {
            return null;
        }
        if (endsWith) {
            try {
                str4 = new File(str5 + NativeLibraryHelper.LIB_DIR_NAME).getCanonicalPath();
            } catch (IOException unused) {
                str4 = null;
            }
            if (str4 == null || trim.startsWith(str4)) {
                return null;
            }
        }
        return trim;
    }

    public static boolean a(String str, String str2) {
        int indexOf;
        if (str2 == null || (indexOf = str2.indexOf(47)) == -1) {
            return false;
        }
        String trim = str2.substring(indexOf).trim();
        if (!trim.startsWith("/data/")) {
            return false;
        }
        if (trim.startsWith("/data/data/" + str + "/")) {
            return false;
        }
        boolean endsWith = trim.endsWith(".so");
        return (endsWith || (!endsWith && trim.endsWith(".jar"))) && str2.contains(kC0XR.a(kC0XR.f45855m));
    }
}
