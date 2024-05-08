package com.mobile.auth.gatewayauth;

import android.view.View;
import com.mobile.auth.gatewayauth.annotations.AuthNumber;

@AuthNumber
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class AuthRegisterViewConfig {
    private CustomInterface customInterface;
    private int rootViewId;
    private View view;

    @AuthNumber
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class Builder {
        private CustomInterface customInterface;
        private int rootViewId;
        private View view;

        public static /* synthetic */ CustomInterface access$000(Builder builder) {
            try {
                return builder.customInterface;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ View access$100(Builder builder) {
            try {
                return builder.view;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ int access$200(Builder builder) {
            try {
                return builder.rootViewId;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public AuthRegisterViewConfig build() {
            try {
                return new AuthRegisterViewConfig(this);
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setCustomInterface(CustomInterface customInterface) {
            try {
                this.customInterface = customInterface;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setRootViewId(int i10) {
            try {
                this.rootViewId = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setView(View view) {
            try {
                this.view = view;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }
    }

    @AuthNumber
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class RootViewId {
        public static final int ROOT_VIEW_ID_BODY = 0;
        public static final int ROOT_VIEW_ID_NUMBER = 2;
        public static final int ROOT_VIEW_ID_TITLE_BAR = 1;
    }

    private AuthRegisterViewConfig(Builder builder) {
        this.customInterface = Builder.access$000(builder);
        this.view = Builder.access$100(builder);
        this.rootViewId = Builder.access$200(builder);
    }

    public CustomInterface getCustomInterface() {
        try {
            return this.customInterface;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getRootViewId() {
        try {
            return this.rootViewId;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public View getView() {
        try {
            return this.view;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }
}
