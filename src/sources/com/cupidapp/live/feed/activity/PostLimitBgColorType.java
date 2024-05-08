package com.cupidapp.live.feed.activity;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import com.cupidapp.live.R$color;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.feed.layout.PostLimitTextBgType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: PostLimitEditActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum PostLimitBgColorType {
    RED(R$drawable.shape_post_limit_edit_red_gradient_bg, R$mipmap.icon_post_limit_red_bg_btn, R$color.white_FEFFFE_60_alpha),
    BLUE(R$drawable.shape_post_limit_edit_blue_gradient_bg, R$mipmap.icon_post_limit_blue_bg_btn, R$color.white_FEFFFE_60_alpha),
    BLACK(R$color.gray_31343A, R$mipmap.icon_post_limit_black_bg_btn, R$color.white_FEFFFE_60_alpha),
    WHITE(R$color.white_FFFBEF, R$mipmap.icon_post_limit_white_bg_btn, R$color.app_black_60_alpha),
    RAINBOW(R$color.white_FFFBEF, R$mipmap.icon_post_limit_rainbow_bg_btn, R$color.app_black_60_alpha);


    @NotNull
    public static final a Companion = new a(null);
    private final int bgResId;
    private final int btnResId;
    private final int textColorResId;

    /* compiled from: PostLimitEditActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {

        /* compiled from: PostLimitEditActivity.kt */
        @kotlin.d
        /* renamed from: com.cupidapp.live.feed.activity.PostLimitBgColorType$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public /* synthetic */ class C0152a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f14090a;

            static {
                int[] iArr = new int[PostLimitBgColorType.values().length];
                try {
                    iArr[PostLimitBgColorType.RED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[PostLimitBgColorType.BLUE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[PostLimitBgColorType.BLACK.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[PostLimitBgColorType.WHITE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[PostLimitBgColorType.RAINBOW.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                f14090a = iArr;
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PostLimitTextBgType a(@NotNull PostLimitBgColorType type) {
            kotlin.jvm.internal.s.i(type, "type");
            int i10 = C0152a.f14090a[type.ordinal()];
            if (i10 == 1 || i10 == 2 || i10 == 3) {
                return PostLimitTextBgType.NO_BG_WHITE_TEXT;
            }
            if (i10 == 4 || i10 == 5) {
                return PostLimitTextBgType.NO_BG_BLACK_TEXT;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    PostLimitBgColorType(@DrawableRes int i10, @DrawableRes int i11, @ColorRes int i12) {
        this.bgResId = i10;
        this.btnResId = i11;
        this.textColorResId = i12;
    }

    public final int getBgResId() {
        return this.bgResId;
    }

    public final int getBtnResId() {
        return this.btnResId;
    }

    public final int getTextColorResId() {
        return this.textColorResId;
    }
}
