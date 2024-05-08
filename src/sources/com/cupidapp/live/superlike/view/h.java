package com.cupidapp.live.superlike.view;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.cupidapp.live.R$color;
import com.cupidapp.live.R$mipmap;
import java.util.List;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: SuperLikeViewHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f18669a = new h();

    public final int a(int i10) {
        return i10 < 2 ? R$mipmap.success_multi_superlike_bg_v1 : i10 < 6 ? R$mipmap.success_multi_superlike_bg_v2 : i10 < 11 ? R$mipmap.success_multi_superlike_bg_v3 : i10 < 16 ? R$mipmap.success_multi_superlike_bg_v4 : R$mipmap.success_multi_superlike_bg_v5;
    }

    @NotNull
    public final String b(int i10) {
        return i10 < 2 ? "card_top_super_like_count1.svga" : i10 < 6 ? "card_top_super_like_count2.svga" : i10 < 11 ? "card_top_super_like_count3.svga" : i10 < 16 ? "card_top_super_like_count4.svga" : i10 < 100 ? "card_top_super_like_count5.svga" : "card_top_super_like_count6.svga";
    }

    public final int c(@NotNull Context context, int i10) {
        s.i(context, "context");
        if (i10 < 2) {
            return ContextCompat.getColor(context, R$color.purple_7A69FF);
        }
        if (i10 < 6) {
            return ContextCompat.getColor(context, R$color.purple_B651FF);
        }
        if (i10 < 11) {
            return ContextCompat.getColor(context, R$color.purple_E528FF);
        }
        if (i10 < 16) {
            return ContextCompat.getColor(context, R$color.purple_FF357F);
        }
        return ContextCompat.getColor(context, R$color.purple_FF5E50);
    }

    @NotNull
    public final String d(int i10) {
        return i10 == 52 ? "lottie/superlike/success_ribbon_52.json" : i10 == 99 ? "lottie/superlike/success_ribbon_99.json" : i10 == 520 ? "lottie/superlike/success_ribbon_520.json" : i10 < 2 ? "lottie/superlike/success_ribbon_v1.json" : i10 < 6 ? "lottie/superlike/success_ribbon_v2.json" : i10 < 11 ? "lottie/superlike/success_ribbon_v3.json" : i10 < 16 ? "lottie/superlike/success_ribbon_v4.json" : "lottie/superlike/success_ribbon_v5.json";
    }

    @NotNull
    public final List<Integer> e(@NotNull Context context, int i10) {
        s.i(context, "context");
        if (i10 < 2) {
            return kotlin.collections.s.m(Integer.valueOf(ContextCompat.getColor(context, R$color.purple_7A69FF)), Integer.valueOf(ContextCompat.getColor(context, R$color.purple_7A69FF)));
        }
        if (i10 < 6) {
            return kotlin.collections.s.m(Integer.valueOf(ContextCompat.getColor(context, R$color.purple_7A69FF)), Integer.valueOf(ContextCompat.getColor(context, R$color.purple_B651FF)));
        }
        if (i10 < 11) {
            return kotlin.collections.s.m(Integer.valueOf(ContextCompat.getColor(context, R$color.purple_9063FF)), Integer.valueOf(ContextCompat.getColor(context, R$color.purple_E528FF)));
        }
        if (i10 < 16) {
            return kotlin.collections.s.m(Integer.valueOf(ContextCompat.getColor(context, R$color.purple_C041FF)), Integer.valueOf(ContextCompat.getColor(context, R$color.purple_FF357F)));
        }
        return kotlin.collections.s.m(Integer.valueOf(ContextCompat.getColor(context, R$color.purple_C357E8)), Integer.valueOf(ContextCompat.getColor(context, R$color.purple_FF357F)), Integer.valueOf(ContextCompat.getColor(context, R$color.purple_FF5E50)));
    }

    public final int f(int i10) {
        return i10 < 2 ? R$mipmap.super_like_tag_count1 : i10 < 6 ? R$mipmap.super_like_tag_count2 : i10 < 11 ? R$mipmap.super_like_tag_count3 : i10 < 16 ? R$mipmap.super_like_tag_count4 : R$mipmap.super_like_tag_count5;
    }
}
