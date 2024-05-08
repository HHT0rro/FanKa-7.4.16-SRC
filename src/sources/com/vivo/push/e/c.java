package com.vivo.push.e;

import android.content.Context;
import android.security.KeyPairGeneratorSpec;
import android.text.TextUtils;
import android.util.Base64;
import com.vivo.push.util.u;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.UnrecoverableEntryException;
import java.util.Calendar;
import javax.security.auth.x500.X500Principal;

/* compiled from: RsaSecurity.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c implements a {

    /* renamed from: a, reason: collision with root package name */
    private PrivateKey f46178a = null;

    /* renamed from: b, reason: collision with root package name */
    private PublicKey f46179b = null;

    /* renamed from: c, reason: collision with root package name */
    private KeyStore f46180c;

    /* renamed from: d, reason: collision with root package name */
    private X500Principal f46181d;

    /* renamed from: e, reason: collision with root package name */
    private Context f46182e;

    public c(Context context) {
        this.f46182e = context;
        a(context);
    }

    private synchronized void a(Context context) {
        try {
            b();
            if (!b("PushRsaKeyAlias")) {
                b(context);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            u.a("RsaSecurity", "init error" + e2.getMessage());
        }
    }

    private void b(Context context) {
        try {
            if (context == null) {
                u.d("RsaSecurity", " generateRSAKeyPairSign context == null ");
                return;
            }
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.add(1, 999);
            KeyPairGeneratorSpec build = new KeyPairGeneratorSpec.Builder(context.getApplicationContext()).setAlias("PushRsaKeyAlias").setSubject(this.f46181d).setSerialNumber(BigInteger.valueOf(1337L)).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
            keyPairGenerator.initialize(build);
            keyPairGenerator.generateKeyPair();
        } catch (Exception e2) {
            e2.printStackTrace();
            u.a("RsaSecurity", "generateRSAKeyPairSign error" + e2.getMessage());
        }
    }

    private PrivateKey c(Context context) {
        PrivateKey privateKey;
        try {
            privateKey = this.f46178a;
        } catch (Exception e2) {
            e2.printStackTrace();
            u.a("RsaSecurity", "getPrivateKeySigin error" + e2.getMessage());
        }
        if (privateKey != null) {
            return privateKey;
        }
        if (context == null) {
            u.d("RsaSecurity", " getPrivateKeySigin context == null ");
            return null;
        }
        KeyStore.Entry d10 = d(context);
        if (d10 instanceof KeyStore.PrivateKeyEntry) {
            PrivateKey privateKey2 = ((KeyStore.PrivateKeyEntry) d10).getPrivateKey();
            this.f46178a = privateKey2;
            return privateKey2;
        }
        return null;
    }

    private KeyStore.Entry d(Context context) throws UnrecoverableEntryException, NoSuchAlgorithmException, KeyStoreException {
        try {
            if (context == null) {
                u.d("RsaSecurity", " getPrivateKeySigin context == null ");
                return null;
            }
            if (!b("PushRsaKeyAlias")) {
                b(context);
            }
            return this.f46180c.getEntry("PushRsaKeyAlias", null);
        } catch (Exception e2) {
            b(context);
            KeyStore.Entry entry = this.f46180c.getEntry("PushRsaKeyAlias", null);
            e2.printStackTrace();
            u.a("RsaSecurity", "getPrivateKeySigin error" + e2.getMessage());
            return entry;
        }
    }

    @Override // com.vivo.push.e.a
    public final String a(String str) {
        try {
            if (TextUtils.isEmpty(str) || c(this.f46182e) == null) {
                return null;
            }
            byte[] bytes = str.getBytes("UTF-8");
            PrivateKey c4 = c(this.f46182e);
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(c4);
            signature.update(bytes);
            String encodeToString = Base64.encodeToString(signature.sign(), 2);
            u.d("RsaSecurity", str.hashCode() + " = " + encodeToString);
            return encodeToString;
        } catch (Exception e2) {
            e2.printStackTrace();
            u.a("RsaSecurity", "signClientSDK error" + e2.getMessage());
            return null;
        }
    }

    private boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (this.f46180c == null) {
                b();
            }
            return this.f46180c.containsAlias(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            u.a("RsaSecurity", "getPrivateKeySigin error" + e2.getMessage());
            return false;
        }
    }

    @Override // com.vivo.push.e.a
    public final boolean a(byte[] bArr, PublicKey publicKey, byte[] bArr2) {
        try {
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initVerify(publicKey);
            signature.update(bArr);
            return signature.verify(bArr2);
        } catch (Exception e2) {
            e2.printStackTrace();
            u.a("RsaSecurity", "verifyClientSDK error" + e2.getMessage());
            return false;
        }
    }

    private void b() {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            this.f46180c = keyStore;
            keyStore.load(null);
            this.f46181d = new X500Principal("CN=Push SDK, OU=VIVO, O=VIVO PUSH, C=CN");
        } catch (Exception e2) {
            e2.printStackTrace();
            u.a("RsaSecurity", "initKeyStore error" + e2.getMessage());
        }
    }

    @Override // com.vivo.push.e.a
    public final PublicKey a() {
        try {
            PublicKey publicKey = this.f46179b;
            if (publicKey != null) {
                return publicKey;
            }
            KeyStore.Entry d10 = d(this.f46182e);
            if (!(d10 instanceof KeyStore.PrivateKeyEntry)) {
                return null;
            }
            PublicKey publicKey2 = ((KeyStore.PrivateKeyEntry) d10).getCertificate().getPublicKey();
            this.f46179b = publicKey2;
            return publicKey2;
        } catch (Exception e2) {
            e2.printStackTrace();
            u.a("RsaSecurity", "getPublicKeySign error" + e2.getMessage());
            return null;
        }
    }
}
