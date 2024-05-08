package com.cupidapp.live.voiceparty.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: VoiceAvatarLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VoiceAvatarLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f19018b;

    /* compiled from: VoiceAvatarLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19019a;

        static {
            int[] iArr = new int[VoiceAvatarMarkType.values().length];
            try {
                iArr[VoiceAvatarMarkType.MASK_MARK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VoiceAvatarMarkType.PUBLIC_PROFILE_MARK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VoiceAvatarMarkType.ME_FOLLOW_OTHER_MARK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[VoiceAvatarMarkType.OTHER_FOLLOW_ME_MARK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[VoiceAvatarMarkType.BOTH_GONE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f19019a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceAvatarLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f19018b = new LinkedHashMap();
        d();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f19018b;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void b(@Nullable ImageModel imageModel, @Nullable String str) {
        ImageLoaderView voice_avatar_img = (ImageLoaderView) a(R$id.voice_avatar_img);
        s.h(voice_avatar_img, "voice_avatar_img");
        ImageLoaderView.g(voice_avatar_img, imageModel, null, null, 6, null);
        ((TextView) a(R$id.voice_name_text)).setText(str);
    }

    public final void c(boolean z10) {
        if (z10) {
            ((ImageView) a(R$id.voice_game_win_img)).setVisibility(0);
        } else {
            ((ImageView) a(R$id.voice_game_win_img)).setVisibility(4);
        }
    }

    public final void d() {
        z.a(this, R$layout.layout_voice_avatar, true);
    }

    public final void e(@NotNull VoiceAvatarMarkType type) {
        View view;
        s.i(type, "type");
        int i10 = R$id.voice_mask_mark_img;
        int i11 = R$id.voice_profile_public_layout;
        int i12 = R$id.voice_me_follow_other_text;
        int i13 = R$id.voice_other_follow_me_text;
        List<View> m10 = kotlin.collections.s.m((ImageView) a(i10), (LinearLayout) a(i11), (TextView) a(i12), (TextView) a(i13));
        int i14 = a.f19019a[type.ordinal()];
        if (i14 == 1) {
            view = (ImageView) a(i10);
        } else if (i14 == 2) {
            view = (LinearLayout) a(i11);
        } else if (i14 == 3) {
            view = (TextView) a(i12);
        } else if (i14 == 4) {
            view = (TextView) a(i13);
        } else {
            if (i14 != 5) {
                throw new NoWhenBranchMatchedException();
            }
            view = null;
        }
        for (View view2 : m10) {
            view2.setVisibility(view != null && view2.getId() == view.getId() ? 0 : 8);
        }
    }

    @NotNull
    public final String getUserName() {
        return ((TextView) a(R$id.voice_name_text)).getText().toString();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceAvatarLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f19018b = new LinkedHashMap();
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceAvatarLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f19018b = new LinkedHashMap();
        d();
    }
}
