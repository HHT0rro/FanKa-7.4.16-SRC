package com.cupidapp.live.mediapicker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.mediapicker.model.VideoEditAttributeModel;
import com.cupidapp.live.mediapicker.view.VideoEditTrimTimeLayout;
import com.cupidapp.live.mediapicker.view.VideoTrimLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: VideoEditTrimTimeLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VideoEditTrimTimeLayout extends CustomAnimationLayout {

    /* renamed from: c, reason: collision with root package name */
    public long f17431c;

    /* renamed from: d, reason: collision with root package name */
    public long f17432d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public a f17433e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17434f;

    /* compiled from: VideoEditTrimTimeLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        void a();

        void b(long j10);

        void c(long j10, long j11);

        void d(long j10, long j11);
    }

    /* compiled from: VideoEditTrimTimeLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements VideoTrimLayout.a {
        public b() {
        }

        @Override // com.cupidapp.live.mediapicker.view.VideoTrimLayout.a
        public void a() {
            a aVar = VideoEditTrimTimeLayout.this.f17433e;
            if (aVar != null) {
                aVar.c(VideoEditTrimTimeLayout.this.f17431c, VideoEditTrimTimeLayout.this.f17432d);
            }
        }

        @Override // com.cupidapp.live.mediapicker.view.VideoTrimLayout.a
        public void b(long j10, long j11, long j12) {
            VideoEditTrimTimeLayout.this.f17431c = j10;
            VideoEditTrimTimeLayout.this.f17432d = j11;
            a aVar = VideoEditTrimTimeLayout.this.f17433e;
            if (aVar != null) {
                aVar.b(j12);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoEditTrimTimeLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f17434f = new LinkedHashMap();
        m();
    }

    @Override // com.cupidapp.live.mediapicker.view.CustomAnimationLayout
    public void a() {
        Property<View, Float> Y = View.Y;
        s.h(Y, "Y");
        b(Y);
        a aVar = this.f17433e;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Nullable
    public View f(int i10) {
        Map<Integer, View> map = this.f17434f;
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

    public final void l(@NotNull VideoEditAttributeModel model) {
        s.i(model, "model");
        this.f17431c = model.getTrimInMs();
        this.f17432d = model.getTrimOutMs();
        ((VideoTrimLayout) f(R$id.videoEditVideoTrimLayout)).d(model);
    }

    public final void m() {
        z.a(this, R$layout.layout_video_edit_trim_time, true);
        int i10 = R$id.confirmAndCancelLayout;
        ((BottomConfirmAndCancelLayout) f(i10)).setConfirmButtonClickEvent(new Function0<p>() { // from class: com.cupidapp.live.mediapicker.view.VideoEditTrimTimeLayout$initView$1
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
                VideoEditTrimTimeLayout videoEditTrimTimeLayout = VideoEditTrimTimeLayout.this;
                Property<View, Float> Y = View.Y;
                s.h(Y, "Y");
                videoEditTrimTimeLayout.b(Y);
                VideoEditTrimTimeLayout.a aVar = VideoEditTrimTimeLayout.this.f17433e;
                if (aVar != null) {
                    aVar.d(VideoEditTrimTimeLayout.this.f17431c, VideoEditTrimTimeLayout.this.f17432d);
                }
            }
        });
        ((BottomConfirmAndCancelLayout) f(i10)).setCancelButtonClickEvent(new Function0<p>() { // from class: com.cupidapp.live.mediapicker.view.VideoEditTrimTimeLayout$initView$2
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
                VideoEditTrimTimeLayout.this.a();
            }
        });
        ((VideoTrimLayout) f(R$id.videoEditVideoTrimLayout)).setVideoTrimLayoutListener(new b());
    }

    public final void setVideoEditTrimTimeListener(@NotNull a listener) {
        s.i(listener, "listener");
        this.f17433e = listener;
    }

    public final void setVideoPlayCurrentTime(long j10) {
        ((VideoTrimLayout) f(R$id.videoEditVideoTrimLayout)).setVideoPlayCurrentTime(j10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoEditTrimTimeLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f17434f = new LinkedHashMap();
        m();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoEditTrimTimeLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f17434f = new LinkedHashMap();
        m();
    }
}
