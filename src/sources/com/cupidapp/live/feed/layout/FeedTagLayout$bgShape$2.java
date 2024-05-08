package com.cupidapp.live.feed.layout;

import android.graphics.drawable.GradientDrawable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: FeedTagLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedTagLayout$bgShape$2 extends Lambda implements Function0<GradientDrawable> {
    public static final FeedTagLayout$bgShape$2 INSTANCE = new FeedTagLayout$bgShape$2();

    public FeedTagLayout$bgShape$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final GradientDrawable invoke() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(z0.h.c(gradientDrawable, 12.0f));
        return gradientDrawable;
    }
}
