package com.cupidapp.live.base.imageloader;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import java.io.File;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ImageLoaderOptions.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f11844a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public String f11845b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final File f11846c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final Uri f11847d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public final Integer f11848e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public final Drawable f11849f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public final Bitmap f11850g;

    /* renamed from: h, reason: collision with root package name */
    public int f11851h;

    /* renamed from: i, reason: collision with root package name */
    public int f11852i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public Drawable f11853j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public TransformationType f11854k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public RoundCornerModel f11855l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public BlurModel f11856m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f11857n;

    /* renamed from: o, reason: collision with root package name */
    public final int f11858o;

    /* renamed from: p, reason: collision with root package name */
    public final int f11859p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f11860q;

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final DiskCacheType f11861r;

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public final PriorityType f11862s;

    public b(boolean z10, @Nullable String str, @Nullable File file, @Nullable Uri uri, @Nullable Integer num, @Nullable Drawable drawable, @Nullable Bitmap bitmap, @ColorInt int i10, @DrawableRes int i11, @Nullable Drawable drawable2, @NotNull TransformationType transformationType, @Nullable RoundCornerModel roundCornerModel, @Nullable BlurModel blurModel, boolean z11, int i12, int i13, boolean z12, @NotNull DiskCacheType diskCacheType, @NotNull PriorityType priority) {
        s.i(transformationType, "transformationType");
        s.i(diskCacheType, "diskCacheType");
        s.i(priority, "priority");
        this.f11844a = z10;
        this.f11845b = str;
        this.f11846c = file;
        this.f11847d = uri;
        this.f11848e = num;
        this.f11849f = drawable;
        this.f11850g = bitmap;
        this.f11851h = i10;
        this.f11852i = i11;
        this.f11853j = drawable2;
        this.f11854k = transformationType;
        this.f11855l = roundCornerModel;
        this.f11856m = blurModel;
        this.f11857n = z11;
        this.f11858o = i12;
        this.f11859p = i13;
        this.f11860q = z12;
        this.f11861r = diskCacheType;
        this.f11862s = priority;
    }

    @Nullable
    public final Bitmap a() {
        return this.f11850g;
    }

    @Nullable
    public final BlurModel b() {
        return this.f11856m;
    }

    @NotNull
    public final DiskCacheType c() {
        return this.f11861r;
    }

    @Nullable
    public final Drawable d() {
        return this.f11849f;
    }

    @Nullable
    public final File e() {
        return this.f11846c;
    }

    public final int f() {
        return this.f11859p;
    }

    public final int g() {
        return this.f11858o;
    }

    public final int h() {
        return this.f11851h;
    }

    @Nullable
    public final Drawable i() {
        return this.f11853j;
    }

    public final int j() {
        return this.f11852i;
    }

    @NotNull
    public final PriorityType k() {
        return this.f11862s;
    }

    @Nullable
    public final Integer l() {
        return this.f11848e;
    }

    @Nullable
    public final RoundCornerModel m() {
        return this.f11855l;
    }

    public final boolean n() {
        return this.f11860q;
    }

    @NotNull
    public final TransformationType o() {
        return this.f11854k;
    }

    @Nullable
    public final Uri p() {
        return this.f11847d;
    }

    @Nullable
    public final String q() {
        return this.f11845b;
    }

    public final boolean r() {
        return this.f11844a;
    }

    public final boolean s() {
        return this.f11857n;
    }

    public final void t(@Nullable BlurModel blurModel) {
        this.f11856m = blurModel;
    }

    public final void u(int i10) {
        this.f11851h = i10;
    }

    public final void v(int i10) {
        this.f11852i = i10;
    }

    public final void w(@Nullable RoundCornerModel roundCornerModel) {
        this.f11855l = roundCornerModel;
    }

    public final void x(@NotNull TransformationType transformationType) {
        s.i(transformationType, "<set-?>");
        this.f11854k = transformationType;
    }

    public final void y(@Nullable String str) {
        this.f11845b = str;
    }

    public /* synthetic */ b(boolean z10, String str, File file, Uri uri, Integer num, Drawable drawable, Bitmap bitmap, int i10, int i11, Drawable drawable2, TransformationType transformationType, RoundCornerModel roundCornerModel, BlurModel blurModel, boolean z11, int i12, int i13, boolean z12, DiskCacheType diskCacheType, PriorityType priorityType, int i14, DefaultConstructorMarker defaultConstructorMarker) {
        this((i14 & 1) != 0 ? true : z10, (i14 & 2) != 0 ? null : str, (i14 & 4) != 0 ? null : file, (i14 & 8) != 0 ? null : uri, (i14 & 16) != 0 ? null : num, (i14 & 32) != 0 ? null : drawable, (i14 & 64) != 0 ? null : bitmap, (i14 & 128) != 0 ? -2302756 : i10, (i14 & 256) != 0 ? 0 : i11, (i14 & 512) != 0 ? null : drawable2, (i14 & 1024) != 0 ? TransformationType.CenterCrop : transformationType, (i14 & 2048) != 0 ? null : roundCornerModel, (i14 & 4096) == 0 ? blurModel : null, (i14 & 8192) != 0 ? false : z11, (i14 & 16384) != 0 ? 0 : i12, (i14 & 32768) != 0 ? 0 : i13, (i14 & 65536) != 0 ? false : z12, (i14 & 131072) != 0 ? DiskCacheType.AUTOMATIC : diskCacheType, (i14 & 262144) != 0 ? PriorityType.NORMAL : priorityType);
    }
}
