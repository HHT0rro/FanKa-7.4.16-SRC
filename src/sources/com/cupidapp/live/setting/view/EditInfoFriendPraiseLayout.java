package com.cupidapp.live.setting.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.profile.activity.FriendPraiseActivity;
import com.cupidapp.live.profile.holder.ProfileFriendPraiseModel;
import com.cupidapp.live.profile.model.FriendPraiseBundleData;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: EditInfoFriendPraiseLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class EditInfoFriendPraiseLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18202b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditInfoFriendPraiseLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18202b = new LinkedHashMap();
        e();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f18202b;
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

    public final void c(@NotNull ProfileFriendPraiseModel model) {
        s.i(model, "model");
        if (model.getCount() > 0) {
            d(true);
            ((ImageView) a(R$id.edit_friend_praise_header_img)).setVisibility(0);
            ((TextView) a(R$id.edit_friend_praise_title_text)).setText(model.getContent());
            int i10 = R$id.edit_friend_praise_arrow_img;
            ((ImageView) a(i10)).setImageResource(R$mipmap.ic_black_arrow_right);
            ((ImageView) a(i10)).setScaleType(ImageView.ScaleType.CENTER);
            ((ImageView) a(R$id.edit_friend_praise_mark_img)).setVisibility(0);
        } else {
            d(false);
            ((ImageView) a(R$id.edit_friend_praise_header_img)).setVisibility(8);
            ((TextView) a(R$id.edit_friend_praise_title_text)).setText(getContext().getString(R$string.invite_friend_praise));
            int i11 = R$id.edit_friend_praise_arrow_img;
            ((ImageView) a(i11)).setImageResource(R$mipmap.icon_friend_praise_add);
            ((ImageView) a(i11)).setScaleType(ImageView.ScaleType.FIT_CENTER);
            ((ImageView) a(R$id.edit_friend_praise_mark_img)).setVisibility(8);
        }
        View edit_friend_praise_bg = a(R$id.edit_friend_praise_bg);
        s.h(edit_friend_praise_bg, "edit_friend_praise_bg");
        y.d(edit_friend_praise_bg, new Function1<View, p>() { // from class: com.cupidapp.live.setting.view.EditInfoFriendPraiseLayout$configEditFriendPraiseData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                EditInfoFriendPraiseLayout.this.f();
            }
        });
    }

    public final void d(boolean z10) {
        if (z10) {
            int i10 = R$id.edit_friend_praise_share_layout;
            ((LinearLayout) a(i10)).setVisibility(0);
            LinearLayout edit_friend_praise_share_layout = (LinearLayout) a(i10);
            s.h(edit_friend_praise_share_layout, "edit_friend_praise_share_layout");
            y.d(edit_friend_praise_share_layout, new Function1<View, p>() { // from class: com.cupidapp.live.setting.view.EditInfoFriendPraiseLayout$configShareBtn$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(View view) {
                    invoke2(view);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable View view) {
                    EditInfoFriendPraiseLayout.this.f();
                }
            });
            return;
        }
        ((LinearLayout) a(R$id.edit_friend_praise_share_layout)).setVisibility(8);
    }

    public final void e() {
        z.a(this, R$layout.layout_edit_info_friend_praise, true);
        TextView edit_friend_praise_count_text = (TextView) a(R$id.edit_friend_praise_count_text);
        s.h(edit_friend_praise_count_text, "edit_friend_praise_count_text");
        u.a(edit_friend_praise_count_text);
    }

    public final void f() {
        FriendPraiseActivity.A.a(getContext(), new FriendPraiseBundleData(SensorPosition.EditProfile));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditInfoFriendPraiseLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18202b = new LinkedHashMap();
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditInfoFriendPraiseLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18202b = new LinkedHashMap();
        e();
    }
}
