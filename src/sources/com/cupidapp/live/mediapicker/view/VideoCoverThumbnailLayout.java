package com.cupidapp.live.mediapicker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.mediapicker.model.VideoEditAttributeModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: VideoCoverThumbnailLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VideoCoverThumbnailLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public a f17422b;

    /* renamed from: c, reason: collision with root package name */
    public int f17423c;

    /* renamed from: d, reason: collision with root package name */
    public float f17424d;

    /* renamed from: e, reason: collision with root package name */
    public final int f17425e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17426f;

    /* compiled from: VideoCoverThumbnailLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        void a(long j10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoCoverThumbnailLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f17426f = new LinkedHashMap();
        this.f17425e = z0.h.c(this, 20.0f);
        f();
    }

    public static final boolean d(VideoCoverThumbnailLayout this$0, View view, MotionEvent motionEvent) {
        s.i(this$0, "this$0");
        view.performClick();
        int action = motionEvent.getAction();
        if (action == 0) {
            this$0.f17423c = view.getLeft();
            this$0.f17424d = motionEvent.getRawX();
        } else if (action == 1) {
            this$0.g(0);
        } else if (action == 2) {
            float rawX = motionEvent.getRawX();
            int b4 = ae.b.b(rawX - this$0.f17424d);
            this$0.f17424d = rawX;
            this$0.g(b4);
        }
        return true;
    }

    private final void setVideoCoverSliderPosition(long j10) {
        int i10 = R$id.video_cover_slider;
        ImageView imageView = (ImageView) b(i10);
        int i11 = this.f17425e;
        imageView.setPadding(i11, 0, i11, 0);
        int p10 = ((FKThumbnailSequenceView) b(R$id.choose_cover_sequence_view)).p(j10);
        ImageView video_cover_slider = (ImageView) b(i10);
        s.h(video_cover_slider, "video_cover_slider");
        y.m(video_cover_slider, Integer.valueOf(p10), null, null, null, 14, null);
    }

    @Nullable
    public View b(int i10) {
        Map<Integer, View> map = this.f17426f;
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

    public final void c() {
        ((ImageView) b(R$id.video_cover_slider)).setOnTouchListener(new View.OnTouchListener() { // from class: com.cupidapp.live.mediapicker.view.g
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean d10;
                d10 = VideoCoverThumbnailLayout.d(VideoCoverThumbnailLayout.this, view, motionEvent);
                return d10;
            }
        });
    }

    public final void e(@NotNull VideoEditAttributeModel model) {
        s.i(model, "model");
        FKThumbnailSequenceView fKThumbnailSequenceView = (FKThumbnailSequenceView) b(R$id.choose_cover_sequence_view);
        fKThumbnailSequenceView.setBothSideWhiteSpace(this.f17425e, false);
        fKThumbnailSequenceView.q(model, model.getTrimInMs(), model.getTrimOutMs(), model.getTrimOutMs() - model.getTrimInMs());
        setVideoCoverSliderPosition(model.getSelectCoverImageTimeMs());
    }

    public final void f() {
        z.a(this, R$layout.layout_video_cover_thumbnail, true);
        c();
    }

    public final void g(int i10) {
        int i11 = this.f17423c + i10;
        this.f17423c = i11;
        if (i11 <= 0) {
            this.f17423c = 0;
        }
        int l10 = z0.h.l(this);
        int i12 = this.f17423c;
        int i13 = R$id.video_cover_slider;
        if (i12 >= l10 - ((ImageView) b(i13)).getWidth()) {
            this.f17423c = l10 - ((ImageView) b(i13)).getWidth();
        }
        ImageView video_cover_slider = (ImageView) b(i13);
        s.h(video_cover_slider, "video_cover_slider");
        y.m(video_cover_slider, Integer.valueOf(this.f17423c), null, null, null, 14, null);
        long o10 = ((FKThumbnailSequenceView) b(R$id.choose_cover_sequence_view)).o((this.f17423c + (((ImageView) b(i13)).getWidth() / 2)) - this.f17425e);
        a aVar = this.f17422b;
        if (aVar != null) {
            aVar.a(o10);
        }
    }

    public final void setVideoCoverThumbnailChangeListener(@NotNull a listener) {
        s.i(listener, "listener");
        this.f17422b = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoCoverThumbnailLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f17426f = new LinkedHashMap();
        this.f17425e = z0.h.c(this, 20.0f);
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoCoverThumbnailLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f17426f = new LinkedHashMap();
        this.f17425e = z0.h.c(this, 20.0f);
        f();
    }
}
