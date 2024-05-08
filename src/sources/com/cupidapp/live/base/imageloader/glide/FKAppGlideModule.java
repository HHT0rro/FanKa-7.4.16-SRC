package com.cupidapp.live.base.imageloader.glide;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.AppGlideModule;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import kotlin.d;
import kotlin.jvm.internal.s;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKAppGlideModule.kt */
@GlideModule
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKAppGlideModule extends AppGlideModule {
    @Override // com.bumptech.glide.module.AppGlideModule, com.bumptech.glide.module.AppliesOptions
    public void applyOptions(@NotNull Context context, @NotNull GlideBuilder builder) {
        s.i(context, "context");
        s.i(builder, "builder");
        super.applyOptions(context, builder);
        builder.setSourceExecutor(GlideExecutor.newSourceBuilder().setUncaughtThrowableStrategy(GlideExecutor.UncaughtThrowableStrategy.IGNORE).build());
    }

    @Override // com.bumptech.glide.module.AppGlideModule
    public boolean isManifestParsingEnabled() {
        return false;
    }

    @Override // com.bumptech.glide.module.LibraryGlideModule, com.bumptech.glide.module.RegistersComponents
    public void registerComponents(@NotNull Context context, @NotNull Glide glide, @NotNull Registry registry) {
        s.i(context, "context");
        s.i(glide, "glide");
        s.i(registry, "registry");
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        registry.replace(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(builder.connectTimeout(10L, timeUnit).readTimeout(10L, timeUnit).build()));
    }
}
