package com.cupidapp.live.liveshow.view.starchallenge;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.sensorslog.SensorLogActivity;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.i;
import com.cupidapp.live.base.view.h;
import com.cupidapp.live.liveshow.model.StarChallengeChestModel;
import com.cupidapp.live.liveshow.view.starchallenge.StarChallengeChestReceiveLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.v;
import z0.y;
import z0.z;

/* compiled from: StarChallengeChestView.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class StarChallengeChestView extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final i f15904b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public StarChallengeChestReceiveLayout f15905c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public StarChallengeChestModel f15906d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f15907e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public Boolean f15908f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15909g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StarChallengeChestView(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15909g = new LinkedHashMap();
        this.f15904b = new i();
        this.f15907e = true;
        j();
    }

    private final SensorPosition getPosition() {
        return this.f15907e ? SensorPosition.LiveShowRoom : SensorPosition.AnchorLiveShowRoom;
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15909g;
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

    public final void h() {
        y.d(this, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.starchallenge.StarChallengeChestView$bindClickEvent$1
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
                StarChallengeChestModel starChallengeChestModel;
                boolean z10;
                Boolean bool;
                starChallengeChestModel = StarChallengeChestView.this.f15906d;
                z10 = StarChallengeChestView.this.f15907e;
                if (z10 && starChallengeChestModel != null) {
                    Context context = StarChallengeChestView.this.getContext();
                    s.h(context, "context");
                    StarChallengeChestReceiveLayout starChallengeChestReceiveLayout = new StarChallengeChestReceiveLayout(context);
                    StarChallengeChestView.this.f15905c = starChallengeChestReceiveLayout;
                    SensorPosition sensorPosition = SensorPosition.LiveShowRoom;
                    starChallengeChestReceiveLayout.e(starChallengeChestModel, sensorPosition);
                    bool = StarChallengeChestView.this.f15908f;
                    starChallengeChestReceiveLayout.f(bool, ((TextView) StarChallengeChestView.this.a(R$id.star_challenge_chest_count_down_text)).getText().toString());
                    StarChallengeChestReceiveLayout.Companion companion = StarChallengeChestReceiveLayout.f15900e;
                    Context context2 = StarChallengeChestView.this.getContext();
                    s.h(context2, "context");
                    final StarChallengeChestView starChallengeChestView = StarChallengeChestView.this;
                    companion.c(context2, starChallengeChestReceiveLayout, sensorPosition, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.starchallenge.StarChallengeChestView$bindClickEvent$1.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ p invoke() {
                            invoke2();
                            return p.f51048a;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            StarChallengeChestView.this.f15905c = null;
                        }
                    });
                    return;
                }
                h.f12779a.l(StarChallengeChestView.this.getContext(), R$string.user_chest_anchor_can_not_receive);
            }
        });
    }

    public final void i(@Nullable final StarChallengeChestModel starChallengeChestModel, boolean z10) {
        this.f15906d = starChallengeChestModel;
        this.f15907e = z10;
        if (starChallengeChestModel == null) {
            k();
            setVisibility(8);
            return;
        }
        int p10 = (int) v.p(System.currentTimeMillis() - starChallengeChestModel.getStartTimeMs());
        int countDownSeconds = starChallengeChestModel.getCountDownSeconds() + starChallengeChestModel.getWaitSeconds();
        if (p10 >= countDownSeconds) {
            k();
            setVisibility(8);
            return;
        }
        if (!(getVisibility() == 0)) {
            SensorLogActivity.f12204a.b(getPosition().getValue(), null, SensorLogActivity.Type.TREASURE_BOX.getType());
        }
        setVisibility(0);
        ImageLoaderView star_challenge_chest_img = (ImageLoaderView) a(R$id.star_challenge_chest_img);
        s.h(star_challenge_chest_img, "star_challenge_chest_img");
        ImageLoaderView.g(star_challenge_chest_img, starChallengeChestModel.getIcon(), null, null, 6, null);
        if (p10 >= 0) {
            countDownSeconds -= p10;
        }
        i.d(this.f15904b, Integer.valueOf(countDownSeconds + 1), 1, null, new Function1<Integer, p>() { // from class: com.cupidapp.live.liveshow.view.starchallenge.StarChallengeChestView$configStarChallengeChestView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Integer num) {
                invoke(num.intValue());
                return p.f51048a;
            }

            public final void invoke(int i10) {
                StarChallengeChestReceiveLayout starChallengeChestReceiveLayout;
                Boolean bool;
                StarChallengeChestReceiveLayout starChallengeChestReceiveLayout2;
                Boolean bool2;
                int waitSeconds = i10 - StarChallengeChestModel.this.getWaitSeconds();
                if (waitSeconds <= 0) {
                    this.f15908f = Boolean.TRUE;
                    TextView star_challenge_chest_count_down_text = (TextView) this.a(R$id.star_challenge_chest_count_down_text);
                    s.h(star_challenge_chest_count_down_text, "star_challenge_chest_count_down_text");
                    star_challenge_chest_count_down_text.setVisibility(8);
                    starChallengeChestReceiveLayout2 = this.f15905c;
                    if (starChallengeChestReceiveLayout2 != null) {
                        bool2 = this.f15908f;
                        starChallengeChestReceiveLayout2.f(bool2, null);
                    }
                } else {
                    this.f15908f = Boolean.FALSE;
                    String j10 = v.j(waitSeconds);
                    StarChallengeChestView starChallengeChestView = this;
                    int i11 = R$id.star_challenge_chest_count_down_text;
                    TextView star_challenge_chest_count_down_text2 = (TextView) starChallengeChestView.a(i11);
                    s.h(star_challenge_chest_count_down_text2, "star_challenge_chest_count_down_text");
                    star_challenge_chest_count_down_text2.setVisibility(0);
                    ((TextView) this.a(i11)).setText(j10);
                    starChallengeChestReceiveLayout = this.f15905c;
                    if (starChallengeChestReceiveLayout != null) {
                        bool = this.f15908f;
                        starChallengeChestReceiveLayout.f(bool, j10);
                    }
                }
                if (i10 == 0) {
                    this.setVisibility(8);
                }
            }
        }, 4, null);
    }

    public final void j() {
        z.a(this, R$layout.layout_star_challenge_chest, true);
        setVisibility(8);
        h();
    }

    public final void k() {
        this.f15904b.g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StarChallengeChestView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15909g = new LinkedHashMap();
        this.f15904b = new i();
        this.f15907e = true;
        j();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StarChallengeChestView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15909g = new LinkedHashMap();
        this.f15904b = new i();
        this.f15907e = true;
        j();
    }
}
