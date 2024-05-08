package com.cupidapp.live.base.view;

import android.graphics.Path;
import org.jetbrains.annotations.NotNull;

/* compiled from: RoundedFrameLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface m {

    /* compiled from: RoundedFrameLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public static void a(@NotNull m mVar, int i10, int i11) {
            float f10 = i10;
            float f11 = i11;
            mVar.getPath().reset();
            mVar.getPath().moveTo(mVar.getTopLeftRadius(), 0.0f);
            mVar.getPath().quadTo(mVar.getTopLeftRadius() * 0.02929f, mVar.getTopLeftRadius() * 0.02929f, 0.0f, mVar.getTopLeftRadius());
            mVar.getPath().lineTo(0.0f, f11 - mVar.getBottomLeftRadius());
            mVar.getPath().quadTo(mVar.getBottomLeftRadius() * 0.02929f, f11 - (mVar.getBottomLeftRadius() * 0.02929f), mVar.getBottomLeftRadius(), f11);
            mVar.getPath().lineTo(f10 - mVar.getBottomRightRadius(), f11);
            mVar.getPath().quadTo(f10 - (mVar.getBottomRightRadius() * 0.02929f), f11 - (mVar.getBottomRightRadius() * 0.02929f), f10, f11 - mVar.getBottomRightRadius());
            mVar.getPath().lineTo(f10, mVar.getTopRightRadius());
            mVar.getPath().quadTo(f10 - (mVar.getTopRightRadius() * 0.02929f), mVar.getTopRightRadius() * 0.02929f, f10 - mVar.getTopRightRadius(), 0.0f);
            mVar.getPath().close();
        }

        public static void b(@NotNull m mVar, float f10) {
            mVar.setTopLeftRadius(f10);
            mVar.setTopRightRadius(f10);
            mVar.setBottomLeftRadius(f10);
            mVar.setBottomRightRadius(f10);
        }

        public static void c(@NotNull m mVar, float f10, float f11, float f12, float f13) {
            mVar.setTopLeftRadius(f10);
            mVar.setTopRightRadius(f12);
            mVar.setBottomLeftRadius(f11);
            mVar.setBottomRightRadius(f13);
        }

        public static /* synthetic */ void d(m mVar, float f10, float f11, float f12, float f13, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setCornerRadius");
            }
            if ((i10 & 1) != 0) {
                f10 = 0.0f;
            }
            if ((i10 & 2) != 0) {
                f11 = 0.0f;
            }
            if ((i10 & 4) != 0) {
                f12 = 0.0f;
            }
            if ((i10 & 8) != 0) {
                f13 = 0.0f;
            }
            mVar.setCornerRadius(f10, f11, f12, f13);
        }
    }

    float getBottomLeftRadius();

    float getBottomRightRadius();

    @NotNull
    Path getPath();

    float getTopLeftRadius();

    float getTopRightRadius();

    void setBottomLeftRadius(float f10);

    void setBottomRightRadius(float f10);

    void setCornerRadius(float f10, float f11, float f12, float f13);

    void setTopLeftRadius(float f10);

    void setTopRightRadius(float f10);
}
