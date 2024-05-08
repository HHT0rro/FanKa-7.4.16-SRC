package com.cupidapp.live.chat.util;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.cupidapp.live.R$color;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.chat.event.BottomTabVisibilityEvent;
import com.cupidapp.live.smartrefresh.layout.constant.RefreshState;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;

/* compiled from: ChatSessionSecondHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f13181a = new a();

    /* compiled from: ChatSessionSecondHelper.kt */
    @d
    /* renamed from: com.cupidapp.live.chat.util.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class C0150a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13182a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            try {
                iArr[RefreshState.TwoLevel.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RefreshState.TwoLevelFinish.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RefreshState.None.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RefreshState.PullDownToRefresh.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[RefreshState.ReleaseToTwoLevel.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f13182a = iArr;
        }
    }

    public final void a(boolean z10) {
        EventBus.c().l(new BottomTabVisibilityEvent(z10));
    }

    public final void b(@NotNull RefreshState newState, @Nullable View view, @Nullable View view2) {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        s.i(newState, "newState");
        int i10 = C0150a.f13182a[newState.ordinal()];
        if (i10 == 1 || i10 == 2) {
            imageView = view != null ? (ImageView) view.findViewById(R$id.hand_action_img) : null;
            if (imageView != null) {
                imageView.setVisibility(4);
            }
            if (view2 != null) {
                view2.setBackgroundResource(R$drawable.gray_top_24_corners);
                return;
            }
            return;
        }
        if (i10 == 3) {
            imageView = view != null ? (ImageView) view.findViewById(R$id.hand_action_img) : null;
            if (imageView != null) {
                imageView.setVisibility(4);
            }
            if (view != null && (imageView2 = (ImageView) view.findViewById(R$id.hand_action_img)) != null) {
                imageView2.setImageResource(R$mipmap.pull_to_second_level);
            }
            if (view2 != null) {
                view2.setBackgroundResource(R$color.background_gray);
                return;
            }
            return;
        }
        if (i10 == 4) {
            imageView = view != null ? (ImageView) view.findViewById(R$id.hand_action_img) : null;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            if (view != null && (imageView3 = (ImageView) view.findViewById(R$id.hand_action_img)) != null) {
                imageView3.setImageResource(R$mipmap.pull_to_second_level);
            }
            if (view2 != null) {
                view2.setBackgroundResource(R$drawable.gray_top_24_corners);
                return;
            }
            return;
        }
        if (i10 != 5) {
            imageView = view != null ? (ImageView) view.findViewById(R$id.hand_action_img) : null;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            if (view2 != null) {
                view2.setBackgroundResource(R$drawable.gray_top_24_corners);
                return;
            }
            return;
        }
        imageView = view != null ? (ImageView) view.findViewById(R$id.hand_action_img) : null;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        if (view2 != null) {
            view2.setBackgroundResource(R$drawable.gray_top_24_corners);
        }
        if (view == null || (imageView4 = (ImageView) view.findViewById(R$id.hand_action_img)) == null) {
            return;
        }
        imageView4.setImageResource(R$mipmap.ic_hand_up);
    }

    public final void c(int i10, float f10, float f11, @Nullable View view, @Nullable View view2, @Nullable View view3) {
        int i11;
        if (view3 == null) {
            return;
        }
        float f12 = f10 * f11;
        double d10 = f12;
        double d11 = d10 / 5.0d;
        double d12 = 1;
        double c4 = h.c(this, 120.0f) * Math.min(d11 - d12, ShadowDrawableWrapper.COS_45);
        if (view2 != null) {
            view2.setTranslationY((float) c4);
        }
        if (view2 != null) {
            view2.setAlpha(d11 > 1.0d ? 1.0f : (float) d11);
        }
        if (d11 >= 1.0d) {
            if (view != null) {
                view.setAlpha(1.0f);
            }
        } else if (view != null) {
            view.setAlpha(0.0f);
        }
        float f13 = (float) ((d10 / 8.0d) * 9);
        if (f13 > 0.6d) {
            f13 = 1.0f;
        }
        ImageView imageView = (ImageView) view3.findViewById(R$id.mask_img);
        if (imageView != null) {
            imageView.setAlpha(1 - f13);
        }
        ImageView imageView2 = (ImageView) view3.findViewById(R$id.hand_action_img);
        if (imageView2 != null) {
            imageView2.setAlpha(f13);
        }
        if (f12 >= 2.0f) {
            View findViewById = view3.findViewById(R$id.top_level_tip);
            s.h(findViewById, "chatSessionRootView.top_level_tip");
            com.cupidapp.live.base.view.s.a(findViewById, 0);
        } else {
            View findViewById2 = view3.findViewById(R$id.top_level_tip);
            s.h(findViewById2, "chatSessionRootView.top_level_tip");
            com.cupidapp.live.base.view.s.a(findViewById2, (int) (i10 * (d12 - (d10 / 2.0d))));
        }
        if (d10 >= 1.65d) {
            a(false);
            i11 = 1;
        } else {
            i11 = 1;
            a(true);
        }
        if (f12 >= 4.0f) {
            LinearLayout linearLayout = (LinearLayout) view3.findViewById(R$id.session_root);
            if (linearLayout == null) {
                return;
            }
            linearLayout.setAlpha(i11 - ((float) Math.min(1.0d, (f12 - 4) / 10.0d)));
            return;
        }
        LinearLayout linearLayout2 = (LinearLayout) view3.findViewById(R$id.session_root);
        if (linearLayout2 == null) {
            return;
        }
        linearLayout2.setAlpha(1.0f);
    }
}
