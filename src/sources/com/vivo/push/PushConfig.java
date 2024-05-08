package com.vivo.push;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class PushConfig {
    private boolean mAgreePrivacyStatement;
    private boolean mOpenMultiUser;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class Builder {
        private boolean mAgreePrivacyStatement = true;
        private boolean mOpenMultiUser = false;

        public final Builder agreePrivacyStatement(boolean z10) {
            this.mAgreePrivacyStatement = z10;
            return this;
        }

        public final PushConfig build() {
            return new PushConfig(this);
        }

        public final Builder openMultiUserMode(boolean z10) {
            this.mOpenMultiUser = z10;
            return this;
        }
    }

    public boolean isAgreePrivacyStatement() {
        return this.mAgreePrivacyStatement;
    }

    public boolean isOpenMultiUser() {
        return this.mOpenMultiUser;
    }

    private PushConfig(Builder builder) {
        this.mAgreePrivacyStatement = true;
        this.mOpenMultiUser = false;
        this.mAgreePrivacyStatement = builder.mAgreePrivacyStatement;
        this.mOpenMultiUser = builder.mOpenMultiUser;
    }
}
