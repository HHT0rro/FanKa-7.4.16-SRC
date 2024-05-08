package com.cupidapp.live.mediapicker.helper;

import androidx.annotation.FloatRange;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VideoTrimUtil.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final float f17244a;

    public e() {
        this(0.0f, 1, null);
    }

    public e(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        this.f17244a = f10;
    }

    public final float a() {
        return this.f17244a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && Float.compare(this.f17244a, ((e) obj).f17244a) == 0;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f17244a);
    }

    @NotNull
    public String toString() {
        return "VideoCropConfig(videoAvatarInitPoint=" + this.f17244a + ")";
    }

    public /* synthetic */ e(float f10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? 0.0f : f10);
    }
}
