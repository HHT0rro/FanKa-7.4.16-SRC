package com.cupidapp.live.match.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.match.view.FKSwipeCardFakeAvatarTipLayout;
import com.cupidapp.live.track.group.GroupOthersLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKSwipeCardFakeAvatarTipLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKSwipeCardFakeAvatarTipLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public a f16871d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16872e;

    /* compiled from: FKSwipeCardFakeAvatarTipLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        void l();
    }

    /* compiled from: FKSwipeCardFakeAvatarTipLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16873a;

        static {
            int[] iArr = new int[FakeTipStyle.values().length];
            try {
                iArr[FakeTipStyle.CAN_SEE_DETAIL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FakeTipStyle.UPLOAD_TIP_GUIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FakeTipStyle.UPLOAD_TIP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f16873a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSwipeCardFakeAvatarTipLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16872e = new LinkedHashMap();
        g();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f16872e;
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

    public final void g() {
        z0.z.a(this, R$layout.layout_fake_upload_avatar, true);
        setVisibility(8);
        TextView see_detail = (TextView) e(R$id.see_detail);
        kotlin.jvm.internal.s.h(see_detail, "see_detail");
        z0.u.a(see_detail);
        RelativeLayout see_more_ll = (RelativeLayout) e(R$id.see_more_ll);
        kotlin.jvm.internal.s.h(see_more_ll, "see_more_ll");
        z0.y.d(see_more_ll, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardFakeAvatarTipLayout$initView$1
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
                FKSwipeCardFakeAvatarTipLayout.a aVar;
                aVar = FKSwipeCardFakeAvatarTipLayout.this.f16871d;
                if (aVar != null) {
                    aVar.l();
                }
                GroupOthersLog.f18702a.F(GroupOthersLog.GuideType.UPLOAD_AVATAR_NO_FAKE, SensorPosition.Match, SensorScene.Match);
            }
        });
        TextView no_face_guide = (TextView) e(R$id.no_face_guide);
        kotlin.jvm.internal.s.h(no_face_guide, "no_face_guide");
        z0.y.d(no_face_guide, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardFakeAvatarTipLayout$initView$2
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
                FKSwipeCardFakeAvatarTipLayout.a aVar;
                aVar = FKSwipeCardFakeAvatarTipLayout.this.f16871d;
                if (aVar != null) {
                    aVar.l();
                }
                GroupOthersLog.f18702a.F(GroupOthersLog.GuideType.CLICK_TO_UPLOAD_AVATAR, SensorPosition.Match, SensorScene.Match);
            }
        });
        TextView no_face = (TextView) e(R$id.no_face);
        kotlin.jvm.internal.s.h(no_face, "no_face");
        z0.y.d(no_face, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardFakeAvatarTipLayout$initView$3
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
                FKSwipeCardFakeAvatarTipLayout.a aVar;
                aVar = FKSwipeCardFakeAvatarTipLayout.this.f16871d;
                if (aVar != null) {
                    aVar.l();
                }
                GroupOthersLog.f18702a.F(GroupOthersLog.GuideType.NO_CLEAR_FACE, SensorPosition.Match, SensorScene.Match);
            }
        });
    }

    public final void h(@NotNull FakeTipStyle tipStyle) {
        kotlin.jvm.internal.s.i(tipStyle, "tipStyle");
        int i10 = b.f16873a[tipStyle.ordinal()];
        if (i10 == 1) {
            ((RelativeLayout) e(R$id.see_more_ll)).setVisibility(0);
            ((TextView) e(R$id.no_face_guide)).setVisibility(8);
            ((TextView) e(R$id.no_face)).setVisibility(8);
            setVisibility(0);
            GroupOthersLog.M(GroupOthersLog.f18702a, GroupOthersLog.GuideType.UPLOAD_AVATAR_NO_FAKE, SensorPosition.Match, SensorScene.Match, null, 8, null);
            return;
        }
        if (i10 == 2) {
            ((RelativeLayout) e(R$id.see_more_ll)).setVisibility(8);
            ((TextView) e(R$id.no_face_guide)).setVisibility(0);
            ((TextView) e(R$id.no_face)).setVisibility(8);
            setVisibility(0);
            GroupOthersLog.M(GroupOthersLog.f18702a, GroupOthersLog.GuideType.CLICK_TO_UPLOAD_AVATAR, SensorPosition.Match, SensorScene.Match, null, 8, null);
            return;
        }
        if (i10 != 3) {
            setVisibility(8);
            return;
        }
        ((RelativeLayout) e(R$id.see_more_ll)).setVisibility(8);
        ((TextView) e(R$id.no_face_guide)).setVisibility(8);
        ((TextView) e(R$id.no_face)).setVisibility(0);
        setVisibility(0);
        GroupOthersLog.M(GroupOthersLog.f18702a, GroupOthersLog.GuideType.NO_CLEAR_FACE, SensorPosition.Match, SensorScene.Match, null, 8, null);
    }

    public final void setCallback(@NotNull a callback) {
        kotlin.jvm.internal.s.i(callback, "callback");
        this.f16871d = callback;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSwipeCardFakeAvatarTipLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16872e = new LinkedHashMap();
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSwipeCardFakeAvatarTipLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16872e = new LinkedHashMap();
        g();
    }
}
