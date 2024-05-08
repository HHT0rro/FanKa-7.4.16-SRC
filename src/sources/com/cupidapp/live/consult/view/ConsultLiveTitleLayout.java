package com.cupidapp.live.consult.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.view.h;
import com.cupidapp.live.consult.model.ConsultLiveCategory;
import com.cupidapp.live.consult.model.ConsultLiveModel;
import com.cupidapp.live.voiceparty.engine.IVoiceEngine;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: ConsultLiveTitleLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultLiveTitleLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public IVoiceEngine.NetworkStateLevel f13865b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13866c;

    /* compiled from: ConsultLiveTitleLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13867a;

        static {
            int[] iArr = new int[IVoiceEngine.NetworkStateLevel.values().length];
            try {
                iArr[IVoiceEngine.NetworkStateLevel.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IVoiceEngine.NetworkStateLevel.BAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IVoiceEngine.NetworkStateLevel.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[IVoiceEngine.NetworkStateLevel.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f13867a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultLiveTitleLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13866c = new LinkedHashMap();
        f();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f13866c;
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

    public final void b(@NotNull final Function0<p> closeCallback) {
        s.i(closeCallback, "closeCallback");
        ImageView title_consult_close_btn = (ImageView) a(R$id.title_consult_close_btn);
        s.h(title_consult_close_btn, "title_consult_close_btn");
        y.d(title_consult_close_btn, new Function1<View, p>() { // from class: com.cupidapp.live.consult.view.ConsultLiveTitleLayout$bindClickEvent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                closeCallback.invoke();
            }
        });
    }

    public final void c(@NotNull IVoiceEngine.NetworkStateLevel localLevel, @NotNull IVoiceEngine.NetworkStateLevel remoteLevel) {
        s.i(localLevel, "localLevel");
        s.i(remoteLevel, "remoteLevel");
        if (this.f13865b != localLevel) {
            this.f13865b = localLevel;
            int i10 = a.f13867a[localLevel.ordinal()];
            int i11 = R$mipmap.ic_network_state_error;
            if (i10 == 1) {
                i11 = R$mipmap.ic_network_state_normal;
            } else if (i10 == 2) {
                i11 = R$mipmap.ic_network_state_bad;
            } else if (i10 != 3 && i10 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            ((ImageView) a(R$id.title_consult_network_state_img)).setImageResource(i11);
        }
        IVoiceEngine.NetworkStateLevel networkStateLevel = IVoiceEngine.NetworkStateLevel.ERROR;
        if (localLevel == networkStateLevel || remoteLevel != networkStateLevel) {
            return;
        }
        IVoiceEngine a10 = d4.b.f48611a.a();
        if (a10 != null && a10.b()) {
            h.f12779a.l(getContext(), R$string.other_network_state_is_error);
        }
    }

    public final void d(@NotNull ConsultLiveModel model) {
        int i10;
        s.i(model, "model");
        String category = model.getCategory();
        int i11 = 0;
        if (s.d(category, ConsultLiveCategory.ASTROLABE.getValue())) {
            i11 = R$mipmap.ic_consult_astrolabe;
            i10 = R$string.astrolabe;
        } else if (s.d(category, ConsultLiveCategory.TAROT.getValue())) {
            i11 = R$mipmap.ic_consult_tarot;
            i10 = R$string.tarot;
        } else if (s.d(category, ConsultLiveCategory.PSYCHOLOGY.getValue())) {
            i11 = R$mipmap.ic_consult_psychology;
            i10 = R$string.psychology;
        } else {
            i10 = 0;
        }
        ((ImageView) a(R$id.title_consult_type_img)).setImageResource(i11);
        ((TextView) a(R$id.title_consult_type_name)).setText(i10);
        ((TextView) a(R$id.title_consult_title_text)).setText(model.getTitle());
        e(model.getViewerCount());
    }

    public final void e(@Nullable String str) {
        if (str == null || str.length() == 0) {
            str = "0";
        }
        ((TextView) a(R$id.title_consult_online_num_text)).setText(getContext().getString(R$string.number_of_listeners, str));
    }

    public final void f() {
        z.a(this, R$layout.layout_consult_live_title, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultLiveTitleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13866c = new LinkedHashMap();
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultLiveTitleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13866c = new LinkedHashMap();
        f();
    }
}
