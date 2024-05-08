package com.cupidapp.live.match.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.setting.activity.EditUserInfoActivity;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKSwipeCardUploadAvatarLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKSwipeCardUploadAvatarLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16899d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSwipeCardUploadAvatarLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16899d = new LinkedHashMap();
        f();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f16899d;
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

    public final void f() {
        z0.z.a(this, R$layout.layout_swipe_card_upload_avatar, true);
        setVisibility(8);
        TextView upload_avatar_button = (TextView) e(R$id.upload_avatar_button);
        kotlin.jvm.internal.s.h(upload_avatar_button, "upload_avatar_button");
        z0.y.d(upload_avatar_button, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardUploadAvatarLayout$initView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                p1.g.f52734a.J3(Long.valueOf(System.currentTimeMillis()));
                FKSwipeCardUploadAvatarLayout.this.setVisibility(8);
                EditUserInfoActivity.a.b(EditUserInfoActivity.f17947y, FKSwipeCardUploadAvatarLayout.this.getContext(), null, false, 6, null);
                j1.i.f50236a.a(PopupName.UPLOAD_AVATAR_GUIDE, PopupButtonName.ToUpload, SensorPosition.Match);
            }
        });
        ImageView close_upload_avatar = (ImageView) e(R$id.close_upload_avatar);
        kotlin.jvm.internal.s.h(close_upload_avatar, "close_upload_avatar");
        z0.y.d(close_upload_avatar, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardUploadAvatarLayout$initView$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                p1.g.f52734a.J3(Long.valueOf(System.currentTimeMillis()));
                FKSwipeCardUploadAvatarLayout.this.setVisibility(8);
                j1.i.f50236a.a(PopupName.UPLOAD_AVATAR_GUIDE, PopupButtonName.Close, SensorPosition.Match);
            }
        });
    }

    public final void g(boolean z10) {
        if (z10) {
            if (getVisibility() != 0) {
                j1.i.g(j1.i.f50236a, PopupName.UPLOAD_AVATAR_GUIDE, SensorPosition.Match, null, 4, null);
            }
            setVisibility(0);
            return;
        }
        setVisibility(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSwipeCardUploadAvatarLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16899d = new LinkedHashMap();
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSwipeCardUploadAvatarLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16899d = new LinkedHashMap();
        f();
    }
}
