package com.cupidapp.live.liveshow.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.sensorslog.SensorLogActivity;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.liveshow.activity.FKLiveOpenWebFragmentEvent;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.model.RedEnvelopeModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.v;
import z0.y;
import z0.z;

/* compiled from: LiveRedEnvelopeView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveRedEnvelopeView extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public com.cupidapp.live.base.utils.i f15307b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public String f15308c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15309d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveRedEnvelopeView(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15309d = new LinkedHashMap();
        d();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15309d;
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

    public final void c(@Nullable final RedEnvelopeModel redEnvelopeModel) {
        this.f15308c = redEnvelopeModel != null ? redEnvelopeModel.getEntranceUrl() : null;
        if (redEnvelopeModel == null) {
            setVisibility(8);
            return;
        }
        if (!(getVisibility() == 0)) {
            SensorLogActivity.f12204a.b(SensorPosition.LiveShowRoom.getValue(), this.f15308c, SensorLogActivity.Type.TOP_RED_PACKET.getType());
        }
        setVisibility(0);
        ImageLoaderView red_envelope_imageview = (ImageLoaderView) a(R$id.red_envelope_imageview);
        s.h(red_envelope_imageview, "red_envelope_imageview");
        ImageLoaderView.g(red_envelope_imageview, redEnvelopeModel.getRedPacketIcon(), null, null, 6, null);
        TextView red_envelope_countdown_textview = (TextView) a(R$id.red_envelope_countdown_textview);
        s.h(red_envelope_countdown_textview, "red_envelope_countdown_textview");
        red_envelope_countdown_textview.setVisibility(0);
        int currentTimeMillis = (int) ((System.currentTimeMillis() - redEnvelopeModel.getStartTimeMills()) / 1000);
        int countdownSeconds = redEnvelopeModel.getCountdownSeconds() + redEnvelopeModel.getWaitSeconds();
        if (currentTimeMillis >= 0) {
            countdownSeconds -= currentTimeMillis;
        }
        e(countdownSeconds + 1, new Function1<Integer, p>() { // from class: com.cupidapp.live.liveshow.view.LiveRedEnvelopeView$configRedEnvelopeView$1
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
                int countdownSeconds2 = i10 - RedEnvelopeModel.this.getCountdownSeconds();
                if (countdownSeconds2 <= 0) {
                    TextView red_envelope_countdown_textview2 = (TextView) this.a(R$id.red_envelope_countdown_textview);
                    s.h(red_envelope_countdown_textview2, "red_envelope_countdown_textview");
                    red_envelope_countdown_textview2.setVisibility(8);
                    ImageLoaderView red_envelope_imageview2 = (ImageLoaderView) this.a(R$id.red_envelope_imageview);
                    s.h(red_envelope_imageview2, "red_envelope_imageview");
                    ImageLoaderView.g(red_envelope_imageview2, RedEnvelopeModel.this.getRedPacketOpenIcon(), null, null, 6, null);
                } else {
                    ((TextView) this.a(R$id.red_envelope_countdown_textview)).setText(v.j(countdownSeconds2));
                }
                if (i10 == 0) {
                    this.setVisibility(8);
                }
            }
        });
    }

    public final void d() {
        z.a(this, R$layout.live_red_envelope_view, true);
        setVisibility(8);
        y.d(this, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.LiveRedEnvelopeView$initView$1
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
                String str;
                String str2;
                EventBus c4 = EventBus.c();
                str = LiveRedEnvelopeView.this.f15308c;
                c4.l(new FKLiveOpenWebFragmentEvent(str, false, 2, null));
                if (FKLiveConstantsData.INSTANCE.getLiveShowModel() != null) {
                    LiveRedEnvelopeView liveRedEnvelopeView = LiveRedEnvelopeView.this;
                    SensorLogActivity sensorLogActivity = SensorLogActivity.f12204a;
                    String value = SensorPosition.LiveShowRoom.getValue();
                    str2 = liveRedEnvelopeView.f15308c;
                    sensorLogActivity.a(value, str2, SensorLogActivity.Type.TOP_RED_PACKET.getType());
                }
            }
        });
    }

    public final void e(int i10, final Function1<? super Integer, p> function1) {
        com.cupidapp.live.base.utils.i iVar = new com.cupidapp.live.base.utils.i();
        this.f15307b = iVar;
        com.cupidapp.live.base.utils.i.d(iVar, Integer.valueOf(i10), 1, null, new Function1<Integer, p>() { // from class: com.cupidapp.live.liveshow.view.LiveRedEnvelopeView$startCountDown$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Integer num) {
                invoke(num.intValue());
                return p.f51048a;
            }

            public final void invoke(int i11) {
                function1.invoke(Integer.valueOf(i11));
            }
        }, 4, null);
    }

    public final void f() {
        com.cupidapp.live.base.utils.i iVar = this.f15307b;
        if (iVar != null) {
            iVar.g();
        }
        this.f15307b = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveRedEnvelopeView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15309d = new LinkedHashMap();
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveRedEnvelopeView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15309d = new LinkedHashMap();
        d();
    }
}
