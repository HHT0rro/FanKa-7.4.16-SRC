package com.hifive.sdk.common;

import android.util.Base64;
import com.hifive.sdk.BuildConfig;
import java.nio.charset.Charset;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.c;
import kotlin.text.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BaseConstance.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class BaseConstance {

    @NotNull
    public static final String BASE_URL = "http://openmusic-api.hifiveai.com";
    public static final int SUCCEED = 200;
    public static final long TIME_OUT = 30;

    @Nullable
    private static String accessTokenMember;

    @Nullable
    private static String accessTokenUnion;

    @Nullable
    private static String memberOutId;

    @Nullable
    private static String societyOutId;
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static String BASE_URL_MUSIC = "https://gateway.open.hifiveai.com";

    @NotNull
    private static String verison = BuildConfig.VERSION_NAME;

    /* compiled from: BaseConstance.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Companion {
        private Companion() {
        }

        @Nullable
        public final String getAccessTokenMember() {
            return BaseConstance.accessTokenMember;
        }

        @Nullable
        public final String getAccessTokenUnion() {
            return BaseConstance.accessTokenUnion;
        }

        @NotNull
        public final String getBASE_URL_MUSIC() {
            return BaseConstance.BASE_URL_MUSIC;
        }

        @Nullable
        public final String getMemberOutId() {
            return BaseConstance.memberOutId;
        }

        @Nullable
        public final String getSign(@NotNull String secret, @NotNull String message) {
            s.j(secret, "secret");
            s.j(message, "message");
            try {
                Mac mac = Mac.getInstance("HmacSHA256");
                s.e(mac, "Mac.getInstance(\"HmacSHA256\")");
                Charset charset = c.f51097b;
                byte[] bytes = secret.getBytes(charset);
                s.e(bytes, "(this as java.lang.String).getBytes(charset)");
                mac.init(new SecretKeySpec(bytes, "HmacSHA256"));
                byte[] bytes2 = message.getBytes(charset);
                s.e(bytes2, "(this as java.lang.String).getBytes(charset)");
                String encodeToString = Base64.encodeToString(mac.doFinal(bytes2), 0);
                s.e(encodeToString, "Base64.encodeToString(sh…Array()), Base64.DEFAULT)");
                return encodeToString;
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }

        @Nullable
        public final String getSignToken(@NotNull String secret, @NotNull String token, @NotNull String time) {
            s.j(secret, "secret");
            s.j(token, "token");
            s.j(time, "time");
            if (p.t(token)) {
                return null;
            }
            String sign = getSign(secret, token + time);
            if (sign != null) {
                return StringsKt__StringsKt.P0(sign).toString();
            }
            return null;
        }

        @Nullable
        public final String getSocietyOutId() {
            return BaseConstance.societyOutId;
        }

        @NotNull
        public final String getVerison() {
            return BaseConstance.verison;
        }

        public final void setAccessTokenMember(@Nullable String str) {
            BaseConstance.accessTokenMember = str;
        }

        public final void setAccessTokenUnion(@Nullable String str) {
            BaseConstance.accessTokenUnion = str;
        }

        public final void setBASE_URL_MUSIC(@NotNull String str) {
            s.j(str, "<set-?>");
            BaseConstance.BASE_URL_MUSIC = str;
        }

        public final void setMemberOutId(@Nullable String str) {
            BaseConstance.memberOutId = str;
        }

        public final void setSocietyOutId(@Nullable String str) {
            BaseConstance.societyOutId = str;
        }

        public final void setVerison(@NotNull String str) {
            s.j(str, "<set-?>");
            BaseConstance.verison = str;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
