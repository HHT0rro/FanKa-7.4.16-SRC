package com.inno.innosecure;

import android.content.Context;
import android.text.TextUtils;
import com.inno.innosecure.bean.EncryptedData;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.UUID;
import pc.b;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class InnoSecureUtils {
    public static final String TAG = "MyTestLog";
    public static int cpcVersion = 0;
    public static String localSdkVsersion = "3.1.2.200708";
    public static boolean newInterfaceInited;
    public static byte[] res;
    public static String sCid;
    public static int sVerifySign;
    public static String sign;

    /* renamed from: v, reason: collision with root package name */
    public static String f35691v;

    /* renamed from: com.inno.innosecure.InnoSecureUtils$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class AnonymousClass1 implements Runnable {
        public final /* synthetic */ Context val$context;
        public final /* synthetic */ String val$myPackage;

        public AnonymousClass1(Context context, String str) {
            this.val$context = context;
            this.val$myPackage = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            byte[] unused = InnoSecureUtils.res = InnoSecureUtils.getRes(this.val$context, InnoSecureUtils.access$100(), this.val$myPackage);
            String unused2 = InnoSecureUtils.sign = InnoSecureUtils.getSign(this.val$context);
        }
    }

    /* renamed from: com.inno.innosecure.InnoSecureUtils$2, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class AnonymousClass2 implements Runnable {
        public final /* synthetic */ Context val$context;
        public final /* synthetic */ String val$myPackage;

        public AnonymousClass2(Context context, String str) {
            this.val$context = context;
            this.val$myPackage = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                byte[] unused = InnoSecureUtils.res = InnoSecureUtils.getRes(this.val$context, InnoSecureUtils.access$100(), this.val$myPackage);
                String unused2 = InnoSecureUtils.sign = InnoSecureUtils.getSign(this.val$context);
            } catch (Throwable unused3) {
            }
        }
    }

    /* renamed from: com.inno.innosecure.InnoSecureUtils$3, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class AnonymousClass3 implements Runnable {
        public final /* synthetic */ Context val$context;
        public final /* synthetic */ String val$myPackage;

        public AnonymousClass3(Context context, String str) {
            this.val$context = context;
            this.val$myPackage = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            byte[] unused = InnoSecureUtils.res = InnoSecureUtils.getRes(this.val$context, InnoSecureUtils.access$100(), this.val$myPackage);
            String unused2 = InnoSecureUtils.sign = InnoSecureUtils.getSign(this.val$context);
        }
    }

    /* renamed from: com.inno.innosecure.InnoSecureUtils$4, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class AnonymousClass4 implements Runnable {
        public final /* synthetic */ Context val$context;
        public final /* synthetic */ String val$myPackage;

        public AnonymousClass4(Context context, String str) {
            this.val$context = context;
            this.val$myPackage = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            byte[] unused = InnoSecureUtils.res = InnoSecureUtils.getRes(this.val$context, InnoSecureUtils.access$100(), this.val$myPackage);
            String unused2 = InnoSecureUtils.sign = InnoSecureUtils.getSign(this.val$context);
        }
    }

    /* renamed from: com.inno.innosecure.InnoSecureUtils$5, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class AnonymousClass5 implements Runnable {
        public final /* synthetic */ Context val$context;
        public final /* synthetic */ String val$myPackage;

        public AnonymousClass5(Context context, String str) {
            this.val$context = context;
            this.val$myPackage = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            byte[] unused = InnoSecureUtils.res = InnoSecureUtils.getRes(this.val$context, InnoSecureUtils.access$100(), this.val$myPackage);
            String unused2 = InnoSecureUtils.sign = InnoSecureUtils.getSign(this.val$context);
        }
    }

    static {
        try {
            System.loadLibrary("InnoSecure");
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("InnoSecure load failed:   ");
            sb2.append(th.toString());
        }
    }

    public static /* synthetic */ String access$100() {
        return getn();
    }

    public static void checkLib(Context context) {
        try {
            try {
                b.a(context, "InnoSecure");
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            System.loadLibrary("InnoSecure");
        }
    }

    public static void checkParams() {
    }

    public static native byte[] decode(byte[] bArr, String str, byte[] bArr2, int i10);

    public static byte[] decodeSo(Context context, byte[] bArr) {
        return decodeSo(context, bArr, null);
    }

    public static byte[] getRes(Context context, String str, String str2) {
        int resource1;
        InputStream inputStream;
        if (str2 == null || str2.equals("")) {
            str2 = context.getPackageName();
        }
        try {
            resource1 = getResource1(context, str, str2);
            if (resource1 == 0) {
                resource1 = getResource(context, str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (resource1 == 0) {
            return null;
        }
        try {
            inputStream = context.getResources().openRawResource(resource1);
        } catch (Exception e2) {
            e2.printStackTrace();
            inputStream = null;
        }
        if (inputStream != null) {
            try {
                byte[] bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                return bArr;
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return null;
    }

    public static int getResource(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, "drawable", context.getPackageName());
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public static int getResource1(Context context, String str, String str2) {
        try {
            Field field = Class.forName(str2 + ".R$drawable").getField(str);
            if (field == null) {
                return 0;
            }
            return field.getInt(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public static synchronized String getSign(Context context) {
        String charsString;
        synchronized (InnoSecureUtils.class) {
            try {
                charsString = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toCharsString();
            } catch (Throwable th) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("出错1:   ");
                sb2.append(th.toString());
                return "error";
            }
        }
        return charsString;
    }

    public static String getVersion(Context context) {
        return getVersion(context, null);
    }

    public static native String getn();

    public static native String getv(byte[] bArr);

    public static void init(Context context) {
        checkLib(context);
        try {
            res = getRes(context, getn(), null);
            sign = getSign(context);
        } catch (Throwable unused) {
        }
    }

    public static native byte[] secure(String str, String str2, String str3, byte[] bArr, String str4, int i10);

    public static byte[] secureData(Context context, byte[] bArr, String str) {
        checkLib(context);
        if (bArr == null) {
            return null;
        }
        try {
            UUID randomUUID = UUID.randomUUID();
            String uuid = (randomUUID == null || randomUUID.toString().length() != 36) ? "12345678-1234-1234-1234-123456789012" : randomUUID.toString();
            if (res == null || sign == null) {
                res = getRes(context, getn(), str);
                sign = getSign(context);
            }
            if (res != null && sign != null) {
                TextUtils.isEmpty(sCid);
                return secureData(bArr, bArr.length, uuid, sign, res, sCid, sVerifySign);
            }
            return null;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                return null;
            } catch (Throwable th2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("出错2:   ");
                sb2.append(th2.toString());
                return null;
            }
        }
    }

    public static native byte[] secureData(byte[] bArr, int i10, String str, String str2, byte[] bArr2, String str3, int i11);

    public static byte[] secureSo(Context context, String str) {
        return secureSo(context, str, null);
    }

    public static EncryptedData secureSoWithReturnCode(Context context, String str, String str2) throws Exception {
        checkLib(context);
        EncryptedData encryptedData = new EncryptedData(0);
        if (str != null) {
            try {
                if (!str.equals("")) {
                    try {
                        UUID randomUUID = UUID.randomUUID();
                        String uuid = (randomUUID == null || randomUUID.toString().length() != 36) ? "12345678-1234-1234-1234-123456789012" : randomUUID.toString();
                        if (res == null || sign == null) {
                            res = getRes(context, getn(), str2);
                            sign = getSign(context);
                        }
                        byte[] bArr = res;
                        if (bArr == null) {
                            encryptedData.setResultCode(2);
                            return encryptedData;
                        }
                        String str3 = sign;
                        if (str3 == null) {
                            encryptedData.setResultCode(3);
                            return encryptedData;
                        }
                        encryptedData.setEncodedData(secure(str, uuid, str3, bArr, sCid, sVerifySign));
                        if (encryptedData.getEncodedData() == null || encryptedData.getEncodedData().length == 0) {
                            encryptedData.setResultCode(5);
                        }
                        return encryptedData;
                    } catch (Throwable th) {
                        encryptedData.setResultCode(4);
                        encryptedData.setExceptionInfo("1st: " + th.toString());
                        return encryptedData;
                    }
                }
            } catch (Throwable th2) {
                encryptedData.setResultCode(4);
                encryptedData.setExceptionInfo("2nd: " + th2.toString());
                return encryptedData;
            }
        }
        encryptedData.setResultCode(1);
        return encryptedData;
    }

    public static void setCid(String str) {
        sCid = str;
    }

    public static void setCpc(int i10) {
        cpcVersion = i10;
        if (i10 == 4) {
            setSdkVersion("3.0.0.190911");
        }
    }

    public static void setSdkVersion(String str) {
        localSdkVsersion = str;
    }

    public static byte[] decodeSo(Context context, byte[] bArr, String str) {
        String str2;
        checkLib(context);
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    try {
                        if (res == null || sign == null) {
                            res = getRes(context, getn(), str);
                            sign = getSign(context);
                        }
                        byte[] bArr2 = res;
                        if (bArr2 != null && (str2 = sign) != null) {
                            return decode(bArr, str2, bArr2, sVerifySign);
                        }
                    } catch (Throwable unused) {
                    }
                    return null;
                }
            } catch (Throwable th) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("出错2:   ");
                sb2.append(th.toString());
            }
        }
        return null;
    }

    public static String getVersion(Context context, String str) {
        checkLib(context);
        try {
            if (TextUtils.isEmpty(f35691v)) {
                return f35691v;
            }
            String vVar = getv(getRes(context, getn(), str));
            f35691v = vVar;
            return vVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] secureSo(Context context, String str, String str2) {
        checkLib(context);
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                UUID randomUUID = UUID.randomUUID();
                String uuid = (randomUUID == null || randomUUID.toString().length() != 36) ? "12345678-1234-1234-1234-123456789012" : randomUUID.toString();
                if (res == null || sign == null) {
                    res = getRes(context, getn(), str2);
                    sign = getSign(context);
                }
                if (res != null && sign != null) {
                    TextUtils.isEmpty(sCid);
                    return secure(str, uuid, sign, res, sCid, sVerifySign);
                }
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        } catch (Throwable th2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("出错2:   ");
            sb2.append(th2.toString());
            return null;
        }
    }

    public static void init(Context context, String str) {
        checkLib(context);
        try {
            res = getRes(context, getn(), str);
            sign = getSign(context);
        } catch (Throwable unused) {
        }
    }
}
