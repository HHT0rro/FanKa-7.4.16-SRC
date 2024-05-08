package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.util.Base64;
import com.alicom.tools.networking.RSA;
import com.baidu.mobads.sdk.internal.by;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.io.File;
import java.io.FilenameFilter;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class br extends File {

    /* renamed from: a, reason: collision with root package name */
    public static final String f9937a = "LocalApkFile";

    /* renamed from: b, reason: collision with root package name */
    private static final long f9938b = 6916965592955692235L;

    /* renamed from: h, reason: collision with root package name */
    private static ClassLoader f9939h;

    /* renamed from: c, reason: collision with root package name */
    private bw f9940c;

    /* renamed from: d, reason: collision with root package name */
    private Class<?> f9941d;

    /* renamed from: e, reason: collision with root package name */
    private Context f9942e;

    /* renamed from: f, reason: collision with root package name */
    private PublicKey f9943f;

    /* renamed from: g, reason: collision with root package name */
    private bs f9944g;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class a implements FilenameFilter {
        public a() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return true;
        }
    }

    public br(String str, Context context) {
        this(str, context, null);
    }

    private void d() {
        File[] listFiles = this.f9942e.getFilesDir().listFiles(new a());
        for (int i10 = 0; listFiles != null && i10 < listFiles.length; i10++) {
            if (listFiles[i10].getAbsolutePath().contains(by.f9982e)) {
                this.f9944g.a(f9937a, "clearDexCacheFiles-->" + i10 + "--" + listFiles[i10].getAbsolutePath());
                listFiles[i10].delete();
            }
        }
    }

    public void a() {
        if (this.f9940c != null) {
            String a10 = a(new File(getAbsolutePath()));
            String b4 = b(this.f9940c.d());
            if (a10.equalsIgnoreCase(b4)) {
                return;
            }
            throw new by.a("doCheckApkIntegrity failed, md5sum: " + a10 + ", checksum in json info: " + b4);
        }
        this.f9944g.a(f9937a, "built-in apk, no need to check");
    }

    public Class<?> b() {
        if (this.f9941d == null) {
            File file = new File(getAbsolutePath());
            try {
                this.f9941d = b(file);
            } catch (Exception unused) {
                file.delete();
            }
        }
        return this.f9941d;
    }

    public double c() {
        bw bwVar = this.f9940c;
        return bwVar == null ? ShadowDrawableWrapper.COS_45 : bwVar.b();
    }

    public br(String str, Context context, bw bwVar) {
        super(str);
        this.f9941d = null;
        this.f9942e = null;
        this.f9944g = bs.a();
        this.f9942e = context;
        this.f9940c = bwVar;
        if (bwVar != null) {
            try {
                this.f9943f = c("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDBcp8gg3O7bjdnz+pSxg+JH/mbcKfm7dEjcRqVNAFwG7bTpLwDQh40bZJzrcBKQWbD6kArR6TPuQUCMQ09/y55Vk1P2Kq7vJGGisFpjlqv2qlg8drLdhXkLQUt/SeZVJgT+CNxVbuzxAF61EEf8M0MHi1I2dm6n6lOA6fomiCD9wIDAQAB");
            } catch (Exception unused) {
                this.f9943f = null;
            }
        }
    }

    private static PublicKey c(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NullPointerException unused) {
            throw new Exception("NullPointerException");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("NoSuchAlgorithmException");
        } catch (InvalidKeySpecException unused3) {
            throw new Exception("InvalidKeySpecException");
        }
    }

    private String b(String str) {
        if (this.f9943f == null) {
            return null;
        }
        byte[] decode = Base64.decode(str, 0);
        try {
            Cipher cipher = Cipher.getInstance(RSA.RSA_ALGORITHM);
            cipher.init(2, this.f9943f);
            return new String(cipher.doFinal(decode), "UTF-8").trim();
        } catch (Exception e2) {
            this.f9944g.c("ErrorWhileVerifySigNature", e2);
            return null;
        }
    }

    public void a(String str) {
        renameTo(new File(str));
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x009d A[Catch: Exception -> 0x0099, TRY_LEAVE, TryCatch #5 {Exception -> 0x0099, blocks: (B:55:0x0095, B:48:0x009d), top: B:54:0x0095 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(java.io.File r9) {
        /*
            r8 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "LocalApkFile"
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6f
            r3.<init>(r9)     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6f
            java.lang.String r9 = "MD5"
            java.security.MessageDigest r9 = java.security.MessageDigest.getInstance(r9)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L68
            java.security.DigestInputStream r4 = new java.security.DigestInputStream     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L68
            r4.<init>(r3, r9)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L68
            r2 = 4096(0x1000, float:5.74E-42)
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
        L19:
            int r5 = r4.read(r2)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            r6 = -1
            if (r5 == r6) goto L21
            goto L19
        L21:
            byte[] r9 = r9.digest()     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            r2 = 0
            r5 = r0
        L27:
            int r6 = r9.length     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            if (r2 >= r6) goto L4d
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            r6.<init>()     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            r6.append(r5)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            r5 = r9[r2]     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r5 = r5 + 256
            r7 = 16
            java.lang.String r5 = java.lang.Integer.toString(r5, r7)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            r7 = 1
            java.lang.String r5 = r5.substring(r7)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            r6.append(r5)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            java.lang.String r5 = r6.toString()     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            int r2 = r2 + 1
            goto L27
        L4d:
            r3.close()     // Catch: java.lang.Exception -> L54
            r4.close()     // Catch: java.lang.Exception -> L54
            goto L5e
        L54:
            r9 = move-exception
            com.baidu.mobads.sdk.internal.bs r0 = r8.f9944g
            java.lang.String r9 = r9.getMessage()
            r0.a(r1, r9)
        L5e:
            r0 = r5
            goto L91
        L60:
            r9 = move-exception
            goto L66
        L62:
            r9 = move-exception
            goto L6a
        L64:
            r9 = move-exception
            r4 = r2
        L66:
            r2 = r3
            goto L93
        L68:
            r9 = move-exception
            r4 = r2
        L6a:
            r2 = r3
            goto L71
        L6c:
            r9 = move-exception
            r4 = r2
            goto L93
        L6f:
            r9 = move-exception
            r4 = r2
        L71:
            com.baidu.mobads.sdk.internal.bs r3 = r8.f9944g     // Catch: java.lang.Throwable -> L92
            java.lang.String r9 = r9.getMessage()     // Catch: java.lang.Throwable -> L92
            r3.a(r1, r9)     // Catch: java.lang.Throwable -> L92
            if (r2 == 0) goto L82
            r2.close()     // Catch: java.lang.Exception -> L80
            goto L82
        L80:
            r9 = move-exception
            goto L88
        L82:
            if (r4 == 0) goto L91
            r4.close()     // Catch: java.lang.Exception -> L80
            goto L91
        L88:
            com.baidu.mobads.sdk.internal.bs r2 = r8.f9944g
            java.lang.String r9 = r9.getMessage()
            r2.a(r1, r9)
        L91:
            return r0
        L92:
            r9 = move-exception
        L93:
            if (r2 == 0) goto L9b
            r2.close()     // Catch: java.lang.Exception -> L99
            goto L9b
        L99:
            r0 = move-exception
            goto La1
        L9b:
            if (r4 == 0) goto Laa
            r4.close()     // Catch: java.lang.Exception -> L99
            goto Laa
        La1:
            com.baidu.mobads.sdk.internal.bs r2 = r8.f9944g
            java.lang.String r0 = r0.getMessage()
            r2.a(r1, r0)
        Laa:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.br.a(java.io.File):java.lang.String");
    }

    private Class<?> b(File file) {
        Class<?> cls;
        this.f9944g.a(f9937a, "Android version:" + bk.a(this.f9942e).c());
        Class<?> cls2 = null;
        try {
            synchronized (by.class) {
                String absolutePath = file.getAbsolutePath();
                ClassLoader classLoader = getClass().getClassLoader();
                String absolutePath2 = this.f9942e.getFilesDir().getAbsolutePath();
                String str = x.aP;
                f9939h = ao.a(absolutePath, absolutePath2, (String) null, classLoader);
                this.f9944g.a(f9937a, "dexPath=" + absolutePath + ", cl=" + ((Object) classLoader) + ", dir=" + absolutePath2 + ", len=" + file.length() + ", list=" + ((Object) file.list()));
                cls = Class.forName(str, true, f9939h);
            }
            cls2 = cls;
        } catch (Exception e2) {
            this.f9944g.a(f9937a, e2.getMessage());
        }
        this.f9944g.a(f9937a, "jar.path=" + file.getAbsolutePath() + ", clz=" + ((Object) cls2));
        return cls2;
    }

    public static ClassLoader a(Context context) {
        ClassLoader classLoader = f9939h;
        return classLoader != null ? classLoader : as.a(context.getApplicationContext());
    }
}
