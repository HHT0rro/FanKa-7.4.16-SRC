package com.kwad.components.core.video;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class VideoAdapters {

    /* renamed from: com.kwad.components.core.video.VideoAdapters$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] UO;

        static {
            int[] iArr = new int[AdaptType.values().length];
            UO = iArr;
            try {
                iArr[AdaptType.PORTRAIT_VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                UO[AdaptType.LANDSCAPE_HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                UO[AdaptType.PORTRAIT_HORIZONTAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                UO[AdaptType.LANDSCAPE_VERTICAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum AdaptType {
        PORTRAIT_VERTICAL,
        PORTRAIT_HORIZONTAL,
        LANDSCAPE_VERTICAL,
        LANDSCAPE_HORIZONTAL
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static abstract class a implements com.kwad.components.core.video.c {
        private static boolean b(View view, View view2, int i10, int i11) {
            if (view == null || i10 == 0 || i11 == 0 || view2 == null) {
                return false;
            }
            return (view2.getWidth() == 0 || view2.getHeight() == 0) ? false : true;
        }

        @Override // com.kwad.components.core.video.c
        public final void a(View view, View view2, int i10, int i11) {
            AdaptType adaptType;
            if (!b(view, view2, i10, i11)) {
                com.kwad.sdk.core.e.c.d("AbstractVideoViewAdapter", "adaptVideo checkArguments invalid");
                return;
            }
            d dVar = new d(view2.getWidth(), view2.getHeight());
            d dVar2 = new d(i10, i11);
            boolean z10 = dVar2.getRatio() >= 1.0f;
            boolean z11 = dVar.getRatio() >= 1.0f;
            if (z11 && z10) {
                adaptType = AdaptType.PORTRAIT_VERTICAL;
            } else if (z11) {
                adaptType = AdaptType.PORTRAIT_HORIZONTAL;
            } else if (z10) {
                adaptType = AdaptType.LANDSCAPE_VERTICAL;
            } else {
                adaptType = AdaptType.LANDSCAPE_HORIZONTAL;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            a(adaptType, layoutParams, dVar, dVar2);
            view.setLayoutParams(layoutParams);
        }

        public abstract void a(@NonNull AdaptType adaptType, @NonNull ViewGroup.LayoutParams layoutParams, @NonNull d dVar, @NonNull d dVar2);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b extends a {
        private float UP = 0.8f;
        private float UQ = 0.9375f;
        private float UR = 1.1046f;

        @Override // com.kwad.components.core.video.VideoAdapters.a
        public final void a(@NonNull AdaptType adaptType, @NonNull ViewGroup.LayoutParams layoutParams, @NonNull d dVar, @NonNull d dVar2) {
            float rP;
            float f10;
            float rQ = dVar.rQ();
            float rQ2 = dVar2.rQ();
            float rP2 = dVar.rP();
            float rO = dVar.rO();
            com.kwad.sdk.core.e.c.d("FullHeightAdapter", "onAdaptVideo containerSize: " + rO + ", " + rP2);
            int i10 = AnonymousClass1.UO[adaptType.ordinal()];
            if (i10 == 1 || i10 == 2) {
                if (rQ > rQ2) {
                    float rO2 = dVar.rO();
                    float f11 = rO2 / rQ2;
                    float f12 = rP2 / f11;
                    float f13 = this.UP;
                    if (f12 >= f13) {
                        f10 = rO2;
                        rP = f11;
                    } else {
                        rP = rP2 / f13;
                        f10 = rP * rQ2;
                    }
                } else {
                    rP = dVar.rP();
                    f10 = rQ2 * rP;
                    float f14 = rO / f10;
                    float f15 = this.UQ;
                    if (f14 < f15) {
                        f10 = rO / f15;
                        rP = f10 / rQ2;
                    }
                }
            } else if (i10 == 3 || i10 == 4) {
                f10 = rP2 * this.UR;
                rP = f10 / rQ2;
            } else {
                rP = -2.14748365E9f;
                f10 = -2.14748365E9f;
            }
            com.kwad.sdk.core.e.c.d("FullHeightAdapter", "onAdaptVideo result: " + f10 + ", " + rP);
            if (f10 == -2.14748365E9f || rP == -2.14748365E9f) {
                return;
            }
            if (dVar2.getHeight() >= dVar2.getWidth()) {
                layoutParams.width = (int) rP;
                layoutParams.height = (int) f10;
            } else {
                layoutParams.height = (int) rP;
                layoutParams.width = (int) f10;
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class c extends a {
        @Override // com.kwad.components.core.video.VideoAdapters.a
        public final void a(@NonNull AdaptType adaptType, @NonNull ViewGroup.LayoutParams layoutParams, @NonNull d dVar, @NonNull d dVar2) {
            float rO;
            float rP;
            float rQ = dVar.rQ();
            float rQ2 = dVar2.rQ();
            int i10 = AnonymousClass1.UO[adaptType.ordinal()];
            if (i10 == 1 || i10 == 2) {
                if (rQ >= rQ2) {
                    rP = dVar.rP();
                    rO = rP * rQ2;
                } else {
                    rO = dVar.rO();
                    rP = rO / rQ2;
                }
            } else if (i10 == 3 || i10 == 4) {
                rO = dVar.rP();
                rP = rO / rQ2;
            } else {
                rO = 0.0f;
                rP = -2.14748365E9f;
            }
            if (rP == -2.14748365E9f || rO == -2.14748365E9f) {
                return;
            }
            if (dVar2.getHeight() > dVar2.getWidth()) {
                layoutParams.width = (int) rP;
                layoutParams.height = (int) rO;
            } else {
                layoutParams.height = (int) rP;
                layoutParams.width = (int) rO;
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class d {
        public float US;
        public float height;
        public float width;

        public d(float f10, float f11) {
            this.US = -1.0f;
            this.width = f10;
            this.height = f11;
            if (f10 <= 0.0f || f11 <= 0.0f) {
                return;
            }
            this.US = f11 / f10;
        }

        private boolean isValid() {
            return this.width > 0.0f && this.height > 0.0f;
        }

        public final float getHeight() {
            return this.height;
        }

        public final float getRatio() {
            return this.US;
        }

        public final float getWidth() {
            return this.width;
        }

        public final float rO() {
            if (isValid()) {
                return Math.max(this.width, this.height);
            }
            return -1.0f;
        }

        public final float rP() {
            if (isValid()) {
                return Math.min(this.width, this.height);
            }
            return -1.0f;
        }

        public final float rQ() {
            if (!isValid()) {
                return -1.0f;
            }
            float f10 = this.height;
            float f11 = this.width;
            return f10 > f11 ? f10 / f11 : f11 / f10;
        }

        public final String toString() {
            return "ViewSize{width=" + this.width + ", height=" + this.height + ", ratio=" + this.US + '}';
        }
    }
}
