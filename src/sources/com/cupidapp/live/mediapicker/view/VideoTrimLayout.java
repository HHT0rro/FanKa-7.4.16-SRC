package com.cupidapp.live.mediapicker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.mediapicker.model.VideoEditAttributeModel;
import com.cupidapp.live.mediapicker.view.FKThumbnailSequenceView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.v;
import z0.z;

/* compiled from: VideoTrimLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VideoTrimLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public a f17454b;

    /* renamed from: c, reason: collision with root package name */
    public final long f17455c;

    /* renamed from: d, reason: collision with root package name */
    public final int f17456d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17457e;

    /* compiled from: VideoTrimLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        void a();

        void b(long j10, long j11, long j12);
    }

    /* compiled from: VideoTrimLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements FKThumbnailSequenceView.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ double f17459b;

        public b(double d10) {
            this.f17459b = d10;
        }

        @Override // com.cupidapp.live.mediapicker.view.FKThumbnailSequenceView.b
        public void a() {
            a aVar = VideoTrimLayout.this.f17454b;
            if (aVar != null) {
                aVar.a();
            }
        }

        @Override // com.cupidapp.live.mediapicker.view.FKThumbnailSequenceView.b
        public void b(int i10) {
            ((VideoTrimHandleLayout) VideoTrimLayout.this.a(R$id.video_trim_handle_layout)).setPositionLineXInLeft();
            long leftPosition = (long) ((((VideoTrimHandleLayout) VideoTrimLayout.this.a(r1)).getLeftPosition() + i10) / this.f17459b);
            long rightPosition = (long) ((i10 + ((VideoTrimHandleLayout) VideoTrimLayout.this.a(r1)).getRightPosition()) / this.f17459b);
            a aVar = VideoTrimLayout.this.f17454b;
            if (aVar != null) {
                aVar.b(leftPosition, rightPosition, leftPosition);
            }
        }
    }

    /* compiled from: VideoTrimLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements i {
        public c() {
        }

        @Override // com.cupidapp.live.mediapicker.view.i
        public void a(int i10, int i11, int i12) {
            a aVar = VideoTrimLayout.this.f17454b;
            if (aVar != null) {
                aVar.b(VideoTrimLayout.this.g(i10), VideoTrimLayout.this.g(i11), VideoTrimLayout.this.g(i12));
            }
        }

        @Override // com.cupidapp.live.mediapicker.view.i
        public void b() {
            a aVar = VideoTrimLayout.this.f17454b;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoTrimLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f17457e = new LinkedHashMap();
        this.f17455c = v.r(3);
        this.f17456d = z0.h.c(this, 28.0f);
        i();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f17457e;
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

    public final void d(@NotNull VideoEditAttributeModel model) {
        s.i(model, "model");
        double f10 = f(model.getDurationMs(), model.getMaxDurationMs());
        int i10 = R$id.video_thumbnail_sequence_view;
        FKThumbnailSequenceView fKThumbnailSequenceView = (FKThumbnailSequenceView) a(i10);
        fKThumbnailSequenceView.setBothSideWhiteSpace(this.f17456d, model.getDurationMs() > model.getMaxDurationMs());
        fKThumbnailSequenceView.q(model, 0L, model.getDurationMs(), Math.min(model.getDurationMs(), model.getMaxDurationMs()));
        ((FKThumbnailSequenceView) a(i10)).setOnScrollChangeListener(new b(f10));
        e(f10, model.getTrimInMs(), model.getTrimOutMs());
    }

    public final void e(double d10, long j10, long j11) {
        int i10 = R$id.video_trim_handle_layout;
        VideoTrimHandleLayout videoTrimHandleLayout = (VideoTrimHandleLayout) a(i10);
        videoTrimHandleLayout.setStartAndEndMargin(this.f17456d);
        videoTrimHandleLayout.setMinDistanceBetweenHandle(d10, this.f17455c);
        videoTrimHandleLayout.setSelectedLayerPosition(h(j10), h(j11));
        int handleWidth = this.f17456d - ((VideoTrimHandleLayout) a(i10)).getHandleWidth();
        a(R$id.left_layer_view).getLayoutParams().width = handleWidth;
        a(R$id.right_layer_view).getLayoutParams().width = handleWidth;
        ((VideoTrimHandleLayout) a(i10)).setVideoTrimHandleLayoutListener(new c());
    }

    public final double f(long j10, long j11) {
        return (z0.h.l(this) - (this.f17456d * 2)) / Math.min(j10, j11);
    }

    public final long g(int i10) {
        return ((FKThumbnailSequenceView) a(R$id.video_thumbnail_sequence_view)).o(i10);
    }

    public final int h(long j10) {
        return ((FKThumbnailSequenceView) a(R$id.video_thumbnail_sequence_view)).p(j10);
    }

    public final void i() {
        z.a(this, R$layout.layout_video_trim, true);
    }

    public final void setVideoPlayCurrentTime(long j10) {
        ((VideoTrimHandleLayout) a(R$id.video_trim_handle_layout)).setPositionLineX(h(j10));
    }

    public final void setVideoTrimLayoutListener(@NotNull a listener) {
        s.i(listener, "listener");
        this.f17454b = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoTrimLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f17457e = new LinkedHashMap();
        this.f17455c = v.r(3);
        this.f17456d = z0.h.c(this, 28.0f);
        i();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoTrimLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f17457e = new LinkedHashMap();
        this.f17455c = v.r(3);
        this.f17456d = z0.h.c(this, 28.0f);
        i();
    }
}
