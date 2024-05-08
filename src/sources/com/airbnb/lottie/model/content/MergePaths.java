package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.layer.BaseLayer;
import e.k;
import n.d;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class MergePaths implements ContentModel {

    /* renamed from: a, reason: collision with root package name */
    public final String f1963a;

    /* renamed from: b, reason: collision with root package name */
    public final MergePathsMode f1964b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f1965c;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum MergePathsMode {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static MergePathsMode forId(int i10) {
            if (i10 == 1) {
                return MERGE;
            }
            if (i10 == 2) {
                return ADD;
            }
            if (i10 == 3) {
                return SUBTRACT;
            }
            if (i10 == 4) {
                return INTERSECT;
            }
            if (i10 != 5) {
                return MERGE;
            }
            return EXCLUDE_INTERSECTIONS;
        }
    }

    public MergePaths(String str, MergePathsMode mergePathsMode, boolean z10) {
        this.f1963a = str;
        this.f1964b = mergePathsMode;
        this.f1965c = z10;
    }

    public MergePathsMode a() {
        return this.f1964b;
    }

    public String b() {
        return this.f1963a;
    }

    public boolean c() {
        return this.f1965c;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    @Nullable
    public Content toContent(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        if (!lottieDrawable.D()) {
            d.c("Animation contains merge paths but they are disabled.");
            return null;
        }
        return new k(this);
    }

    public String toString() {
        return "MergePaths{mode=" + ((Object) this.f1964b) + '}';
    }
}
