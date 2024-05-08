package com.cupidapp.live.base.view.bubble;

import android.graphics.Paint;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: GradientBubbleView.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class GradientBubbleView$mPaint$2 extends Lambda implements Function0<Paint> {
    public static final GradientBubbleView$mPaint$2 INSTANCE = new GradientBubbleView$mPaint$2();

    public GradientBubbleView$mPaint$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Paint invoke() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(-1);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeJoin(Paint.Join.ROUND);
        return paint;
    }
}
