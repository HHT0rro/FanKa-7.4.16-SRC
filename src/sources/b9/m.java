package b9;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.huawei.quickcard.base.Attributes;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class m {
    public static String a(Context context, String str, String str2) {
        int identifier;
        if (TextUtils.isEmpty(str2) || (identifier = context.getResources().getIdentifier(str2, Attributes.TextOverflow.STRING, str)) == 0) {
            return null;
        }
        try {
            return context.getResources().getString(identifier);
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    public static String b(Context context, String str, String str2, String str3) {
        try {
            return a(context, str, str2 + a.c(c(str3.getBytes("utf-8"))));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getResources exception:");
            sb2.append(e2.getMessage());
            return null;
        }
    }

    public static byte[] c(byte[] bArr) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("SHA-256").digest(bArr);
    }
}
