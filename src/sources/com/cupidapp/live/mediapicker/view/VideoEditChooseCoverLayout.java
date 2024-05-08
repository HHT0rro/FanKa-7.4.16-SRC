package com.cupidapp.live.mediapicker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.mediapicker.model.VideoEditAttributeModel;
import com.cupidapp.live.mediapicker.view.VideoCoverThumbnailLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: VideoEditChooseCoverLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VideoEditChooseCoverLayout extends CustomAnimationLayout {

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public h f17427c;

    /* renamed from: d, reason: collision with root package name */
    public long f17428d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17429e;

    /* compiled from: VideoEditChooseCoverLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements VideoCoverThumbnailLayout.a {
        public a() {
        }

        @Override // com.cupidapp.live.mediapicker.view.VideoCoverThumbnailLayout.a
        public void a(long j10) {
            VideoEditChooseCoverLayout.this.f17428d = j10;
            h hVar = VideoEditChooseCoverLayout.this.f17427c;
            if (hVar != null) {
                hVar.b(j10);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoEditChooseCoverLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f17429e = new LinkedHashMap();
        k();
    }

    @Override // com.cupidapp.live.mediapicker.view.CustomAnimationLayout
    public void a() {
        Property<View, Float> Y = View.Y;
        s.h(Y, "Y");
        b(Y);
        h hVar = this.f17427c;
        if (hVar != null) {
            hVar.a();
        }
    }

    @Nullable
    public View f(int i10) {
        Map<Integer, View> map = this.f17429e;
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

    public final void j(@NotNull VideoEditAttributeModel model) {
        s.i(model, "model");
        ((VideoCoverThumbnailLayout) f(R$id.videoCoverThumbnailLayout)).e(model);
    }

    public final void k() {
        z.a(this, R$layout.layout_video_edit_choose_cover, true);
        int i10 = R$id.confirmAndCancelLayout;
        ((BottomConfirmAndCancelLayout) f(i10)).setConfirmButtonClickEvent(new Function0<p>() { // from class: com.cupidapp.live.mediapicker.view.VideoEditChooseCoverLayout$initView$1
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
                long j10;
                VideoEditChooseCoverLayout videoEditChooseCoverLayout = VideoEditChooseCoverLayout.this;
                Property<View, Float> Y = View.Y;
                s.h(Y, "Y");
                videoEditChooseCoverLayout.b(Y);
                h hVar = VideoEditChooseCoverLayout.this.f17427c;
                if (hVar != null) {
                    j10 = VideoEditChooseCoverLayout.this.f17428d;
                    hVar.c(j10);
                }
            }
        });
        ((BottomConfirmAndCancelLayout) f(i10)).setCancelButtonClickEvent(new Function0<p>() { // from class: com.cupidapp.live.mediapicker.view.VideoEditChooseCoverLayout$initView$2
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
                VideoEditChooseCoverLayout.this.a();
            }
        });
        ((VideoCoverThumbnailLayout) f(R$id.videoCoverThumbnailLayout)).setVideoCoverThumbnailChangeListener(new a());
    }

    public final void setVideoEditChooseCoverListener(@NotNull h listener) {
        s.i(listener, "listener");
        this.f17427c = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoEditChooseCoverLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f17429e = new LinkedHashMap();
        k();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoEditChooseCoverLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f17429e = new LinkedHashMap();
        k();
    }
}
