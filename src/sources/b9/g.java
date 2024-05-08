package b9;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class g implements a9.d {

    /* renamed from: a, reason: collision with root package name */
    public SecretKey f1442a;

    /* renamed from: b, reason: collision with root package name */
    public final e f1443b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1444c = false;

    public g(e eVar) {
        this.f1443b = eVar;
    }

    public final void a() {
        try {
            this.f1442a = k.a(this.f1443b);
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException unused) {
            this.f1442a = null;
        }
        this.f1444c = true;
    }

    @Override // a9.d
    public String decrypt(String str, String str2) {
        if (!this.f1444c) {
            a();
        }
        if (this.f1442a != null && !TextUtils.isEmpty(str)) {
            try {
                return new String(k.b(this.f1442a, a.b(str)), "UTF-8");
            } catch (UnsupportedEncodingException | IllegalArgumentException | GeneralSecurityException e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("decrypt exception:");
                sb2.append(e2.getMessage());
            }
        }
        return str2;
    }
}
