package com.huawei.flexiblelayout.parser.cardmanager;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.quickcard.cardmanager.util.CardUriUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CardInfo {
    public static final String SCHEME_COMBO = "flayout";
    public static final String SCHEME_QUICK = "fastView";
    public static final String TYPE_COMBO = "combo";
    public static final String TYPE_QUICK = "quick";

    /* renamed from: a, reason: collision with root package name */
    private String f28309a;

    /* renamed from: b, reason: collision with root package name */
    private String f28310b;

    /* renamed from: c, reason: collision with root package name */
    private String f28311c;

    /* renamed from: d, reason: collision with root package name */
    private int f28312d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f28313e = 0;

    /* renamed from: f, reason: collision with root package name */
    private String f28314f;

    /* renamed from: g, reason: collision with root package name */
    private String f28315g;

    public String getContent() {
        return this.f28314f;
    }

    public int getMinSdkVer() {
        return this.f28313e;
    }

    public String getName() {
        return this.f28311c;
    }

    public String getQualifiedName() {
        return isCombo() ? c.a(getName(), getUri()) : "";
    }

    public String getSign() {
        return this.f28315g;
    }

    public String getType() {
        return this.f28310b;
    }

    public String getUri() {
        return this.f28309a;
    }

    public int getVer() {
        return this.f28312d;
    }

    public boolean isCombo() {
        return "combo".equals(this.f28310b);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class Builder {

        /* renamed from: b, reason: collision with root package name */
        private static final String f28316b = "CardInfo$Builder";

        /* renamed from: a, reason: collision with root package name */
        private final CardInfo f28317a;

        public Builder() {
            this.f28317a = new CardInfo();
        }

        public static Builder fromUri(@NonNull String str) {
            Builder builder = new Builder();
            if (!TextUtils.isEmpty(str)) {
                builder.setUri(str);
                try {
                    Uri parse = Uri.parse(str);
                    builder.setName(parse.getHost());
                    builder.setVer(getIntParam(parse, "ver"));
                    if ("flayout".equals(parse.getScheme())) {
                        builder.setMinSdkVer(getIntParam(parse, CardUriUtils.PARAM_MIN_SDK_VER));
                        builder.setType("combo");
                    } else if ("fastView".equals(parse.getScheme())) {
                        builder.setMinSdkVer(getIntParam(parse, "minPlatformVer"));
                        builder.setType("quick");
                    }
                    builder.setSign(parse.getQueryParameter(CardUriUtils.PARAM_SIGN));
                } catch (Throwable unused) {
                    Log.e(f28316b, "Failed to parse the uri: '" + str + "'.");
                }
            }
            return builder;
        }

        public static int getIntParam(Uri uri, String str) {
            try {
                String queryParameter = uri.getQueryParameter(str);
                if (queryParameter != null) {
                    return Integer.parseInt(queryParameter);
                }
            } catch (NumberFormatException unused) {
            }
            return 0;
        }

        @NonNull
        public CardInfo build() {
            return this.f28317a;
        }

        public Builder setContent(String str) {
            this.f28317a.f28314f = str;
            return this;
        }

        public Builder setMinSdkVer(int i10) {
            this.f28317a.f28313e = i10;
            return this;
        }

        public Builder setName(String str) {
            this.f28317a.f28311c = str;
            return this;
        }

        public void setSign(String str) {
            this.f28317a.f28315g = str;
        }

        public Builder setType(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.f28317a.f28310b = str;
            }
            return this;
        }

        public Builder setUri(String str) {
            this.f28317a.f28309a = str;
            return this;
        }

        public Builder setVer(int i10) {
            this.f28317a.f28312d = i10;
            return this;
        }

        public Builder(CardInfo cardInfo) {
            this.f28317a = cardInfo;
        }
    }

    public void a(String str) {
        this.f28314f = str;
    }
}
