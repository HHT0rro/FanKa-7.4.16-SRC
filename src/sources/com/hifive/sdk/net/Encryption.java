package com.hifive.sdk.net;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.UUID;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.TypeCastException;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;

/* compiled from: Encryption.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class Encryption {
    private static String uniqueID;
    public static final Companion Companion = new Companion(null);
    private static final String UNIQUE_ID = UNIQUE_ID;
    private static final String UNIQUE_ID = UNIQUE_ID;

    /* compiled from: Encryption.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String eccry64(@NotNull byte[] s2) {
            s.j(s2, "s");
            String result = Base64.encodeToString(s2, 0);
            s.e(result, "result");
            if (result == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String upperCase = result.toUpperCase();
            s.e(upperCase, "(this as java.lang.String).toUpperCase()");
            return upperCase;
        }

        public final int getNum() {
            return new Random().nextInt(10000);
        }

        @NotNull
        public final String hmacSHA256Andeccry64(@NotNull String KEY, @NotNull String VALUE) {
            s.j(KEY, "KEY");
            s.j(VALUE, "VALUE");
            try {
                Charset forName = Charset.forName("UTF-8");
                s.e(forName, "Charset.forName(charsetName)");
                byte[] bytes = KEY.getBytes(forName);
                s.e(bytes, "(this as java.lang.String).getBytes(charset)");
                SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "hmacSHA256");
                Mac mac = Mac.getInstance("hmacSHA256");
                mac.init(secretKeySpec);
                Charset forName2 = Charset.forName("UTF-8");
                s.e(forName2, "Charset.forName(charsetName)");
                byte[] bytes2 = VALUE.getBytes(forName2);
                s.e(bytes2, "(this as java.lang.String).getBytes(charset)");
                byte[] rawHmac = mac.doFinal(bytes2);
                byte[] bArr = {(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102};
                byte[] bArr2 = new byte[rawHmac.length * 2];
                s.e(rawHmac, "rawHmac");
                int length = rawHmac.length;
                for (int i10 = 0; i10 < length; i10++) {
                    int and = Util.and(rawHmac[i10], 255);
                    int i11 = i10 * 2;
                    bArr2[i11] = bArr[and >>> 4];
                    bArr2[i11 + 1] = bArr[and & 15];
                }
                return eccry64(bArr2);
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }

        @NotNull
        public final synchronized String requestDeviceId(@NotNull Context context) {
            String str;
            s.j(context, "context");
            if (Encryption.uniqueID == null) {
                SharedPreferences sharedPreferences = context.getSharedPreferences(Encryption.UNIQUE_ID, 0);
                Encryption.uniqueID = sharedPreferences.getString(Encryption.UNIQUE_ID, null);
                if (Encryption.uniqueID == null) {
                    Encryption.uniqueID = UUID.randomUUID().toString();
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString(Encryption.UNIQUE_ID, Encryption.uniqueID);
                    edit.apply();
                }
            }
            str = Encryption.uniqueID;
            if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
            }
            return str;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
