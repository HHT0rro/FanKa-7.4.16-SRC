package b9;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.SecretKey;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class f implements a9.d {

    /* renamed from: a, reason: collision with root package name */
    public final a9.c f1439a;

    /* renamed from: b, reason: collision with root package name */
    public SecretKey f1440b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1441c = false;

    public f(a9.c cVar) {
        this.f1439a = cVar;
    }

    public static boolean b(String str) {
        return !TextUtils.isEmpty(str) && Pattern.matches("^\\[!([A-Fa-f0-9]*)]", str);
    }

    public final void a() {
        try {
            this.f1440b = k.a(new e(this.f1439a.getString("/code/code1", null), this.f1439a.getString("/code/code2", null), this.f1439a.getString("/code/code3", null), this.f1439a.getString("/code/code4", null), "PBKDF2WithHmacSHA1", 10000));
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException unused) {
            this.f1440b = null;
        }
        this.f1441c = true;
    }

    public final String c(String str) {
        try {
            Matcher matcher = Pattern.compile("^\\[!([A-Fa-f0-9]*)]").matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
        } catch (IllegalStateException | IndexOutOfBoundsException unused) {
        }
        return "";
    }

    @Override // a9.d
    public String decrypt(String str, String str2) {
        if (!this.f1441c) {
            a();
        }
        if (this.f1440b != null && b(str)) {
            try {
                return new String(k.b(this.f1440b, a.b(c(str))), "UTF-8");
            } catch (UnsupportedEncodingException | IllegalArgumentException | GeneralSecurityException unused) {
            }
        }
        return str2;
    }
}
