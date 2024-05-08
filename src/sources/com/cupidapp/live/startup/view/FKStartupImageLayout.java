package com.cupidapp.live.startup.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.startup.model.FKAdType;
import com.cupidapp.live.startup.model.FKClickArea;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FKStartupImageLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKStartupImageLayout extends FKBaseStartupLayout {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final FKAdType f18559h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18560i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKStartupImageLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18560i = new LinkedHashMap();
        this.f18559h = FKAdType.Image;
        q();
    }

    @Override // com.cupidapp.live.startup.view.FKBaseStartupLayout
    public void f(boolean z10, int i10, @Nullable final String str) {
        int i11 = R$id.start_up_image_jump_button;
        o(i11).setVisibility(z10 ? 0 : 8);
        if (i10 == FKClickArea.FullScreen.getArea()) {
            ImageLoaderView start_up_image_view = (ImageLoaderView) o(R$id.start_up_image_view);
            s.h(start_up_image_view, "start_up_image_view");
            y.d(start_up_image_view, new Function1<View, p>() { // from class: com.cupidapp.live.startup.view.FKStartupImageLayout$configJumpButtonAndClickArea$1
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
                    FKAdType fKAdType;
                    b listener = FKStartupImageLayout.this.getListener();
                    if (listener != null) {
                        fKAdType = FKStartupImageLayout.this.f18559h;
                        listener.I(fKAdType, str);
                    }
                }
            });
        } else if (i10 == FKClickArea.JumpButton.getArea()) {
            View start_up_image_jump_button = o(i11);
            s.h(start_up_image_jump_button, "start_up_image_jump_button");
            y.d(start_up_image_jump_button, new Function1<View, p>() { // from class: com.cupidapp.live.startup.view.FKStartupImageLayout$configJumpButtonAndClickArea$2
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
                    FKAdType fKAdType;
                    b listener = FKStartupImageLayout.this.getListener();
                    if (listener != null) {
                        fKAdType = FKStartupImageLayout.this.f18559h;
                        listener.I(fKAdType, str);
                    }
                }
            });
        }
    }

    @Override // com.cupidapp.live.startup.view.FKBaseStartupLayout
    public void g(@NotNull String path) {
        s.i(path, "path");
        ImageLoaderView start_up_image_view = (ImageLoaderView) o(R$id.start_up_image_view);
        s.h(start_up_image_view, "start_up_image_view");
        ImageLoaderView.f(start_up_image_view, new com.cupidapp.live.base.imageloader.b(false, path, null, null, null, null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524285, null), null, 2, null);
    }

    @Override // com.cupidapp.live.startup.view.FKBaseStartupLayout
    public void k(@NotNull String tick) {
        s.i(tick, "tick");
        ((TextView) o(R$id.start_up_image_skip_view)).setText(tick);
    }

    @Nullable
    public View o(int i10) {
        Map<Integer, View> map = this.f18560i;
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

    @Override // com.cupidapp.live.startup.view.FKBaseStartupLayout, androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(@NotNull LifecycleOwner owner) {
        s.i(owner, "owner");
        setStartupListener(null);
    }

    @Override // com.cupidapp.live.startup.view.FKBaseStartupLayout, androidx.lifecycle.DefaultLifecycleObserver
    public void onPause(@NotNull LifecycleOwner owner) {
        s.i(owner, "owner");
        m();
    }

    public final void q() {
        z.a(this, R$layout.layout_start_up_image, true);
        setVisibility(4);
        TextView start_up_image_skip_view = (TextView) o(R$id.start_up_image_skip_view);
        s.h(start_up_image_skip_view, "start_up_image_skip_view");
        y.d(start_up_image_skip_view, new Function1<View, p>() { // from class: com.cupidapp.live.startup.view.FKStartupImageLayout$initView$1
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
                FKAdType fKAdType;
                b listener = FKStartupImageLayout.this.getListener();
                if (listener != null) {
                    fKAdType = FKStartupImageLayout.this.f18559h;
                    listener.J0(fKAdType);
                }
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKStartupImageLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18560i = new LinkedHashMap();
        this.f18559h = FKAdType.Image;
        q();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKStartupImageLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18560i = new LinkedHashMap();
        this.f18559h = FKAdType.Image;
        q();
    }
}
