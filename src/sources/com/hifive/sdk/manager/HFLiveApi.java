package com.hifive.sdk.manager;

import android.app.Application;
import android.content.Context;
import com.google.gson.Gson;
import com.hifive.sdk.common.BaseConstance;
import com.hifive.sdk.common.HFLiveCallback;
import com.hifive.sdk.controller.MusicManager;
import com.hifive.sdk.rx.BaseException;
import com.hifive.sdk.utils.MetaDataUtils;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.c;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.v;
import kotlin.reflect.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HFLiveApi.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class HFLiveApi {

    @Nullable
    private static String APP_ID;

    @Nullable
    private static String SECRET;

    @Nullable
    private static HFLiveCallback callbacks;

    @Nullable
    private static Context hiFiveContext;
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final Lazy gson$delegate = c.b(new Function0<Gson>() { // from class: com.hifive.sdk.manager.HFLiveApi$Companion$gson$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Gson invoke() {
            return new Gson();
        }
    });

    /* compiled from: HFLiveApi.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Companion {
        public static final /* synthetic */ j[] $$delegatedProperties = {v.h(new PropertyReference1Impl(v.b(Companion.class), "gson", "getGson()Lcom/google/gson/Gson;")), v.g(new PropertyReference0Impl(v.b(Companion.class), "instance", "<v#0>"))};

        private Companion() {
        }

        public final void configCallBack(@Nullable HFLiveCallback hFLiveCallback) {
            if (getHiFiveContext() != null) {
                String app_id = getAPP_ID();
                if (!(app_id == null || app_id.length() == 0)) {
                    String secret = getSECRET();
                    if (!(secret == null || secret.length() == 0)) {
                        HFLiveApi.Companion.setCallbacks(hFLiveCallback);
                        if (hFLiveCallback != null) {
                            hFLiveCallback.onSuccess();
                            return;
                        }
                        return;
                    }
                }
            }
            if (hFLiveCallback != null) {
                hFLiveCallback.onError(new BaseException(10000, "SDK未初始化"));
            }
        }

        @Nullable
        public final String getAPP_ID() {
            return HFLiveApi.APP_ID;
        }

        @Nullable
        public final HFLiveCallback getCallbacks() {
            return HFLiveApi.callbacks;
        }

        @NotNull
        public final Gson getGson() {
            Lazy lazy = HFLiveApi.gson$delegate;
            Companion companion = HFLiveApi.Companion;
            j jVar = $$delegatedProperties[0];
            return (Gson) lazy.getValue();
        }

        @Nullable
        public final Context getHiFiveContext() {
            return HFLiveApi.hiFiveContext;
        }

        @Nullable
        public final MusicManager getInstance() {
            if (getHiFiveContext() != null) {
                String app_id = getAPP_ID();
                if (!(app_id == null || app_id.length() == 0)) {
                    String secret = getSECRET();
                    if (!(secret == null || secret.length() == 0)) {
                        Lazy a10 = c.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<MusicManager>() { // from class: com.hifive.sdk.manager.HFLiveApi$Companion$getInstance$instance$2
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            @NotNull
                            public final MusicManager invoke() {
                                Context hiFiveContext = HFLiveApi.Companion.getHiFiveContext();
                                if (hiFiveContext == null) {
                                    s.u();
                                }
                                return new MusicManager(hiFiveContext);
                            }
                        });
                        j jVar = $$delegatedProperties[1];
                        return (MusicManager) a10.getValue();
                    }
                }
            }
            HFLiveCallback callbacks = getCallbacks();
            if (callbacks != null) {
                callbacks.onError(new BaseException(10000, "SDK未初始化"));
            }
            if (getHiFiveContext() != null) {
                String app_id2 = getAPP_ID();
                if (!(app_id2 == null || app_id2.length() == 0)) {
                    String secret2 = getSECRET();
                    if (secret2 == null || secret2.length() == 0) {
                        throw new IllegalArgumentException("Failed to obtain information : The HIFive_SECRET cannot be null");
                    }
                    return null;
                }
                throw new IllegalArgumentException("Failed to obtain information : The HIFive_APPID cannot be null");
            }
            throw new IllegalArgumentException("Failed to obtain information : The context cannot be null");
        }

        @Nullable
        public final String getSECRET() {
            return HFLiveApi.SECRET;
        }

        public final void registerApp(@Nullable Context context, @NotNull String APP_ID, @NotNull String SECRET) {
            s.j(APP_ID, "APP_ID");
            s.j(SECRET, "SECRET");
            if (context != null) {
                Companion companion = HFLiveApi.Companion;
                companion.setAPP_ID(APP_ID);
                companion.setSECRET(SECRET);
                setHiFiveContext(context);
                return;
            }
            throw new IllegalArgumentException("Failed to obtain information : The application cannot be null");
        }

        public final void setAPP_ID(@Nullable String str) {
            HFLiveApi.APP_ID = str;
        }

        public final void setCallbacks(@Nullable HFLiveCallback hFLiveCallback) {
            HFLiveApi.callbacks = hFLiveCallback;
        }

        public final void setHiFiveContext(@Nullable Context context) {
            HFLiveApi.hiFiveContext = context;
        }

        public final void setSECRET(@Nullable String str) {
            HFLiveApi.SECRET = str;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void registerApp(@Nullable Application application) {
            if (application != null) {
                setHiFiveContext(application);
                setAPP_ID(MetaDataUtils.getApplicationMetaData(application, "HIFIVE_APPID"));
                setSECRET(MetaDataUtils.getApplicationMetaData(application, "HIFIVE_SECRET"));
                return;
            }
            throw new IllegalArgumentException("Failed to obtain information : The application cannot be null");
        }

        public final void registerApp(@Nullable Application application, @NotNull String domain) {
            s.j(domain, "domain");
            if (application != null) {
                BaseConstance.Companion.setBASE_URL_MUSIC(domain);
                setHiFiveContext(application);
                setAPP_ID(MetaDataUtils.getApplicationMetaData(application, "HIFIVE_APPID"));
                setSECRET(MetaDataUtils.getApplicationMetaData(application, "HIFIVE_SECRET"));
                return;
            }
            throw new IllegalArgumentException("Failed to obtain information : The application cannot be null");
        }
    }

    public static final void configCallBack(@Nullable HFLiveCallback hFLiveCallback) {
        Companion.configCallBack(hFLiveCallback);
    }

    @Nullable
    public static final MusicManager getInstance() {
        return Companion.getInstance();
    }

    public static final void registerApp(@Nullable Application application) {
        Companion.registerApp(application);
    }

    public static final void registerApp(@Nullable Application application, @NotNull String str) {
        Companion.registerApp(application, str);
    }

    public static final void registerApp(@Nullable Context context, @NotNull String str, @NotNull String str2) {
        Companion.registerApp(context, str, str2);
    }
}
