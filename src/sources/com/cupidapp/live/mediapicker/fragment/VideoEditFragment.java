package com.cupidapp.live.mediapicker.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.android.internal.logging.nano.MetricsProto;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.base.video.BaseExoMediaPlayer;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.base.view.dialog.FKLoadingLayout;
import com.cupidapp.live.base.view.progress.ProgressBarDialog;
import com.cupidapp.live.hashtag.model.HashTagSimpleModel;
import com.cupidapp.live.mediapicker.activity.FeedPublishActivity;
import com.cupidapp.live.mediapicker.fragment.VideoEditFragment;
import com.cupidapp.live.mediapicker.helper.VideoCropScene;
import com.cupidapp.live.mediapicker.helper.VideoInfoData;
import com.cupidapp.live.mediapicker.helper.VideoTrimUtil;
import com.cupidapp.live.mediapicker.model.MediaEditButtonViewModel;
import com.cupidapp.live.mediapicker.model.UploadImageModel;
import com.cupidapp.live.mediapicker.model.UploadVideoModel;
import com.cupidapp.live.mediapicker.model.VideoContentModel;
import com.cupidapp.live.mediapicker.model.VideoEditAttributeModel;
import com.cupidapp.live.mediapicker.view.MediaEditButtonListLayout;
import com.cupidapp.live.mediapicker.view.VideoEditChooseCoverLayout;
import com.cupidapp.live.mediapicker.view.VideoEditTrimTimeLayout;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.reactivestreams.Subscription;
import z0.k;
import z0.v;
import z0.y;

/* compiled from: VideoEditFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VideoEditFragment extends FKBaseFragment {

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public static final a f17194k = new a(null);

    /* renamed from: e, reason: collision with root package name */
    public VideoEditAttributeModel f17195e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f17196f;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17200j = new LinkedHashMap();

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final Lazy f17197g = kotlin.c.b(new Function0<BaseExoMediaPlayer>() { // from class: com.cupidapp.live.mediapicker.fragment.VideoEditFragment$mPlayer$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final BaseExoMediaPlayer invoke() {
            return new BaseExoMediaPlayer();
        }
    });

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final Lazy f17198h = kotlin.c.b(new Function0<Config>() { // from class: com.cupidapp.live.mediapicker.fragment.VideoEditFragment$config$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final VideoEditFragment.Config invoke() {
            Bundle arguments = VideoEditFragment.this.getArguments();
            if (arguments != null) {
                return (VideoEditFragment.Config) z0.g.b(arguments, VideoEditFragment.Config.class);
            }
            return null;
        }
    });

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final Runnable f17199i = new Runnable() { // from class: com.cupidapp.live.mediapicker.fragment.g
        @Override // java.lang.Runnable
        public final void run() {
            VideoEditFragment.X1(VideoEditFragment.this);
        }
    };

    /* compiled from: VideoEditFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class Config implements Serializable {

        @Nullable
        private final HashTagSimpleModel hashTag;

        @Nullable
        private final SensorPosition showPosition;

        @NotNull
        private final String uriString;

        @Nullable
        private final String webTitle;

        public Config(@NotNull String uriString, @Nullable HashTagSimpleModel hashTagSimpleModel, @Nullable SensorPosition sensorPosition, @Nullable String str) {
            s.i(uriString, "uriString");
            this.uriString = uriString;
            this.hashTag = hashTagSimpleModel;
            this.showPosition = sensorPosition;
            this.webTitle = str;
        }

        public static /* synthetic */ Config copy$default(Config config, String str, HashTagSimpleModel hashTagSimpleModel, SensorPosition sensorPosition, String str2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = config.uriString;
            }
            if ((i10 & 2) != 0) {
                hashTagSimpleModel = config.hashTag;
            }
            if ((i10 & 4) != 0) {
                sensorPosition = config.showPosition;
            }
            if ((i10 & 8) != 0) {
                str2 = config.webTitle;
            }
            return config.copy(str, hashTagSimpleModel, sensorPosition, str2);
        }

        @NotNull
        public final String component1() {
            return this.uriString;
        }

        @Nullable
        public final HashTagSimpleModel component2() {
            return this.hashTag;
        }

        @Nullable
        public final SensorPosition component3() {
            return this.showPosition;
        }

        @Nullable
        public final String component4() {
            return this.webTitle;
        }

        @NotNull
        public final Config copy(@NotNull String uriString, @Nullable HashTagSimpleModel hashTagSimpleModel, @Nullable SensorPosition sensorPosition, @Nullable String str) {
            s.i(uriString, "uriString");
            return new Config(uriString, hashTagSimpleModel, sensorPosition, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Config)) {
                return false;
            }
            Config config = (Config) obj;
            return s.d(this.uriString, config.uriString) && s.d(this.hashTag, config.hashTag) && this.showPosition == config.showPosition && s.d(this.webTitle, config.webTitle);
        }

        @Nullable
        public final HashTagSimpleModel getHashTag() {
            return this.hashTag;
        }

        @Nullable
        public final SensorPosition getShowPosition() {
            return this.showPosition;
        }

        @NotNull
        public final String getUriString() {
            return this.uriString;
        }

        @Nullable
        public final String getWebTitle() {
            return this.webTitle;
        }

        public int hashCode() {
            int hashCode = this.uriString.hashCode() * 31;
            HashTagSimpleModel hashTagSimpleModel = this.hashTag;
            int hashCode2 = (hashCode + (hashTagSimpleModel == null ? 0 : hashTagSimpleModel.hashCode())) * 31;
            SensorPosition sensorPosition = this.showPosition;
            int hashCode3 = (hashCode2 + (sensorPosition == null ? 0 : sensorPosition.hashCode())) * 31;
            String str = this.webTitle;
            return hashCode3 + (str != null ? str.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            String str = this.uriString;
            HashTagSimpleModel hashTagSimpleModel = this.hashTag;
            SensorPosition sensorPosition = this.showPosition;
            return "Config(uriString=" + str + ", hashTag=" + ((Object) hashTagSimpleModel) + ", showPosition=" + ((Object) sensorPosition) + ", webTitle=" + this.webTitle + ")";
        }
    }

    /* compiled from: VideoEditFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final VideoEditFragment a(@NotNull Config config) {
            s.i(config, "config");
            VideoEditFragment videoEditFragment = new VideoEditFragment();
            Bundle bundle = new Bundle();
            z0.g.d(bundle, config);
            videoEditFragment.setArguments(bundle);
            return videoEditFragment;
        }
    }

    /* compiled from: VideoEditFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements com.cupidapp.live.mediapicker.view.f {
        public b() {
        }

        @Override // com.cupidapp.live.mediapicker.view.f
        public void a(@NotNull MediaEditButtonViewModel model) {
            s.i(model, "model");
            VideoEditFragment.this.f17196f = true;
            if (model.getButtonType() == MediaEditButtonViewModel.EditButtonEnum.Trim) {
                VideoEditFragment.this.c2();
                return;
            }
            if (model.getButtonType() == MediaEditButtonViewModel.EditButtonEnum.Cover) {
                VideoEditFragment videoEditFragment = VideoEditFragment.this;
                String string = videoEditFragment.getString(R$string.select_cover);
                s.h(string, "getString(R.string.select_cover)");
                videoEditFragment.C1(true, string);
                VideoEditFragment.this.P1().n();
                BaseExoMediaPlayer P1 = VideoEditFragment.this.P1();
                VideoEditAttributeModel videoEditAttributeModel = VideoEditFragment.this.f17195e;
                VideoEditAttributeModel videoEditAttributeModel2 = null;
                if (videoEditAttributeModel == null) {
                    s.A("videoAttributeModel");
                    videoEditAttributeModel = null;
                }
                P1.y(videoEditAttributeModel.getSelectCoverImageTimeMs());
                VideoEditFragment videoEditFragment2 = VideoEditFragment.this;
                int i10 = R$id.videoEditChooseCoverLayout;
                VideoEditChooseCoverLayout videoEditChooseCoverLayout = (VideoEditChooseCoverLayout) videoEditFragment2.e1(i10);
                Property<View, Float> Y = View.Y;
                s.h(Y, "Y");
                videoEditChooseCoverLayout.e(Y);
                VideoEditChooseCoverLayout videoEditChooseCoverLayout2 = (VideoEditChooseCoverLayout) VideoEditFragment.this.e1(i10);
                VideoEditAttributeModel videoEditAttributeModel3 = VideoEditFragment.this.f17195e;
                if (videoEditAttributeModel3 == null) {
                    s.A("videoAttributeModel");
                } else {
                    videoEditAttributeModel2 = videoEditAttributeModel3;
                }
                videoEditChooseCoverLayout2.j(videoEditAttributeModel2);
            }
        }
    }

    /* compiled from: VideoEditFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements com.cupidapp.live.mediapicker.view.h {
        public c() {
        }

        @Override // com.cupidapp.live.mediapicker.view.h
        public void a() {
            MediaEditButtonListLayout mediaEditButtonListLayout = (MediaEditButtonListLayout) VideoEditFragment.this.e1(R$id.videoEditButtonListLayout);
            Property<View, Float> ALPHA = View.ALPHA;
            s.h(ALPHA, "ALPHA");
            mediaEditButtonListLayout.e(ALPHA);
            VideoEditFragment.D1(VideoEditFragment.this, false, null, 2, null);
            VideoEditFragment.e2(VideoEditFragment.this, null, null, 3, null);
        }

        @Override // com.cupidapp.live.mediapicker.view.h
        public void b(long j10) {
            VideoEditFragment.this.P1().y(j10);
        }

        @Override // com.cupidapp.live.mediapicker.view.h
        public void c(long j10) {
            VideoEditAttributeModel videoEditAttributeModel = VideoEditFragment.this.f17195e;
            if (videoEditAttributeModel == null) {
                s.A("videoAttributeModel");
                videoEditAttributeModel = null;
            }
            videoEditAttributeModel.setSelectCoverImageTimeMs(j10);
            MediaEditButtonListLayout mediaEditButtonListLayout = (MediaEditButtonListLayout) VideoEditFragment.this.e1(R$id.videoEditButtonListLayout);
            Property<View, Float> ALPHA = View.ALPHA;
            s.h(ALPHA, "ALPHA");
            mediaEditButtonListLayout.e(ALPHA);
            VideoEditFragment.D1(VideoEditFragment.this, false, null, 2, null);
            VideoEditFragment.e2(VideoEditFragment.this, null, null, 3, null);
        }
    }

    /* compiled from: VideoEditFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d implements VideoEditTrimTimeLayout.a {
        public d() {
        }

        @Override // com.cupidapp.live.mediapicker.view.VideoEditTrimTimeLayout.a
        public void a() {
            MediaEditButtonListLayout mediaEditButtonListLayout = (MediaEditButtonListLayout) VideoEditFragment.this.e1(R$id.videoEditButtonListLayout);
            Property<View, Float> ALPHA = View.ALPHA;
            s.h(ALPHA, "ALPHA");
            mediaEditButtonListLayout.e(ALPHA);
            VideoEditFragment.D1(VideoEditFragment.this, false, null, 2, null);
            VideoEditFragment.e2(VideoEditFragment.this, null, null, 3, null);
        }

        @Override // com.cupidapp.live.mediapicker.view.VideoEditTrimTimeLayout.a
        public void b(long j10) {
            VideoEditFragment.this.P1().n();
            VideoEditFragment.this.P1().y(j10);
        }

        @Override // com.cupidapp.live.mediapicker.view.VideoEditTrimTimeLayout.a
        public void c(long j10, long j11) {
            VideoEditFragment.this.d2(Long.valueOf(j10), Long.valueOf(j11));
        }

        @Override // com.cupidapp.live.mediapicker.view.VideoEditTrimTimeLayout.a
        public void d(long j10, long j11) {
            VideoEditAttributeModel videoEditAttributeModel = VideoEditFragment.this.f17195e;
            if (videoEditAttributeModel == null) {
                s.A("videoAttributeModel");
                videoEditAttributeModel = null;
            }
            videoEditAttributeModel.setTrimInMs(j10);
            VideoEditAttributeModel videoEditAttributeModel2 = VideoEditFragment.this.f17195e;
            if (videoEditAttributeModel2 == null) {
                s.A("videoAttributeModel");
                videoEditAttributeModel2 = null;
            }
            videoEditAttributeModel2.setTrimOutMs(j11);
            VideoEditFragment.this.x1();
            MediaEditButtonListLayout mediaEditButtonListLayout = (MediaEditButtonListLayout) VideoEditFragment.this.e1(R$id.videoEditButtonListLayout);
            Property<View, Float> ALPHA = View.ALPHA;
            s.h(ALPHA, "ALPHA");
            mediaEditButtonListLayout.e(ALPHA);
            VideoEditFragment.D1(VideoEditFragment.this, false, null, 2, null);
        }
    }

    /* compiled from: VideoEditFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class e implements BaseExoMediaPlayer.c {

        /* compiled from: VideoEditFragment.kt */
        @kotlin.d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f17205a;

            static {
                int[] iArr = new int[BaseExoMediaPlayer.PlayState.values().length];
                try {
                    iArr[BaseExoMediaPlayer.PlayState.READY.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[BaseExoMediaPlayer.PlayState.BUFFERING.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f17205a = iArr;
            }
        }

        public e() {
        }

        @Override // com.cupidapp.live.base.video.BaseExoMediaPlayer.c
        public void a(@NotNull BaseExoMediaPlayer.PlayState state) {
            s.i(state, "state");
            int i10 = a.f17205a[state.ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    return;
                }
                ((FKLoadingLayout) VideoEditFragment.this.e1(R$id.video_loading_layout)).postDelayed(VideoEditFragment.this.f17199i, 1000L);
            } else {
                VideoEditFragment videoEditFragment = VideoEditFragment.this;
                int i11 = R$id.video_loading_layout;
                ((FKLoadingLayout) videoEditFragment.e1(i11)).removeCallbacks(VideoEditFragment.this.f17199i);
                ((FKLoadingLayout) VideoEditFragment.this.e1(i11)).setVisibility(8);
                ((FKLoadingLayout) VideoEditFragment.this.e1(i11)).c();
            }
        }
    }

    /* compiled from: VideoEditFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class f extends com.cupidapp.live.mediapicker.helper.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f17206b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ VideoEditFragment f17207c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f17208d;

        public f(long j10, VideoEditFragment videoEditFragment, String str) {
            this.f17206b = j10;
            this.f17207c = videoEditFragment;
            this.f17208d = str;
        }

        @Override // com.cupidapp.live.mediapicker.helper.a, io.microshow.rxffmpeg.RxFFmpegInvoke.IFFmpegListener
        public void onCancel() {
            super.onCancel();
            ProgressBarDialog progressBarDialog = (ProgressBarDialog) this.f17207c.e1(R$id.progressBarDialog);
            if (progressBarDialog == null) {
                return;
            }
            progressBarDialog.setVisibility(8);
        }

        @Override // com.cupidapp.live.mediapicker.helper.a, io.microshow.rxffmpeg.RxFFmpegInvoke.IFFmpegListener
        public void onError(@NotNull String message) {
            s.i(message, "message");
            super.onError(message);
            com.cupidapp.live.base.view.h.f12779a.m(this.f17207c.getContext(), message);
            ProgressBarDialog progressBarDialog = (ProgressBarDialog) this.f17207c.e1(R$id.progressBarDialog);
            if (progressBarDialog == null) {
                return;
            }
            progressBarDialog.setVisibility(8);
        }

        @Override // com.cupidapp.live.mediapicker.helper.a, io.microshow.rxffmpeg.RxFFmpegInvoke.IFFmpegListener
        public void onFinish() {
            super.onFinish();
            this.f17207c.I1(this.f17208d);
        }

        @Override // com.cupidapp.live.mediapicker.helper.a, io.microshow.rxffmpeg.RxFFmpegInvoke.IFFmpegListener
        public void onProgress(int i10, long j10) {
            ProgressBarDialog progressBarDialog;
            super.onProgress(i10, j10);
            float v2 = ((((float) v.v(j10)) / ((float) this.f17206b)) * 100) - 2;
            if (v2 < 0.0f || (progressBarDialog = (ProgressBarDialog) this.f17207c.e1(R$id.progressBarDialog)) == null) {
                return;
            }
            progressBarDialog.setProgress((int) v2);
        }
    }

    /* compiled from: VideoEditFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class g implements BaseExoMediaPlayer.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f17209a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f17210b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ VideoEditFragment f17211c;

        public g(long j10, long j11, VideoEditFragment videoEditFragment) {
            this.f17209a = j10;
            this.f17210b = j11;
            this.f17211c = videoEditFragment;
        }

        @Override // com.cupidapp.live.base.video.BaseExoMediaPlayer.b
        public void a(long j10) {
            VideoEditTrimTimeLayout videoEditTrimTimeLayout;
            if (j10 >= this.f17209a && j10 <= this.f17210b) {
                VideoEditFragment videoEditFragment = this.f17211c;
                int i10 = R$id.videoEditTrimTimeLayout;
                VideoEditTrimTimeLayout videoEditTrimTimeLayout2 = (VideoEditTrimTimeLayout) videoEditFragment.e1(i10);
                boolean z10 = false;
                if (videoEditTrimTimeLayout2 != null && videoEditTrimTimeLayout2.getVisibility() == 0) {
                    z10 = true;
                }
                if (!z10 || (videoEditTrimTimeLayout = (VideoEditTrimTimeLayout) this.f17211c.e1(i10)) == null) {
                    return;
                }
                videoEditTrimTimeLayout.setVideoPlayCurrentTime(j10);
                return;
            }
            this.f17211c.P1().y(this.f17209a);
        }
    }

    public static final void A1(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static /* synthetic */ void D1(VideoEditFragment videoEditFragment, boolean z10, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = "";
        }
        videoEditFragment.C1(z10, str);
    }

    public static final void F1(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void G1(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void J1(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void K1(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void L1(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void M1(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void N1(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void V1(int i10, int i11, VideoEditFragment this$0) {
        s.i(this$0, "this$0");
        float f10 = i10 / i11;
        float l10 = z0.h.l(this$0);
        float height = ((ConstraintLayout) this$0.e1(R$id.videoEditPlayerCardView)).getHeight();
        float f11 = 0.75f;
        if (f10 < 0.75f) {
            l10 = Math.min(l10, height * 0.75f);
        } else {
            f11 = 1.7777778f;
            if (f10 <= 1.7777778f) {
                float f12 = f10 * height;
                if (f12 < l10) {
                    l10 = f12;
                } else {
                    height = l10 / f10;
                }
                FrameLayout videoEditPlayerContainer = (FrameLayout) this$0.e1(R$id.videoEditPlayerContainer);
                s.h(videoEditPlayerContainer, "videoEditPlayerContainer");
                y.n(videoEditPlayerContainer, Integer.valueOf((int) l10), Integer.valueOf((int) height));
            }
        }
        height = l10 / f11;
        FrameLayout videoEditPlayerContainer2 = (FrameLayout) this$0.e1(R$id.videoEditPlayerContainer);
        s.h(videoEditPlayerContainer2, "videoEditPlayerContainer");
        y.n(videoEditPlayerContainer2, Integer.valueOf((int) l10), Integer.valueOf((int) height));
    }

    public static final void X1(VideoEditFragment this$0) {
        s.i(this$0, "this$0");
        int i10 = R$id.video_loading_layout;
        ((FKLoadingLayout) this$0.e1(i10)).f();
        ((FKLoadingLayout) this$0.e1(i10)).setVisibility(0);
        ((FKLoadingLayout) this$0.e1(i10)).setLoadingText("视频正在拼命加载中...");
    }

    public static final void a2(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static /* synthetic */ void e2(VideoEditFragment videoEditFragment, Long l10, Long l11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            l10 = null;
        }
        if ((i10 & 2) != 0) {
            l11 = null;
        }
        videoEditFragment.d2(l10, l11);
    }

    public static final void z1(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final boolean B1() {
        VideoEditChooseCoverLayout videoEditChooseCoverLayout = (VideoEditChooseCoverLayout) e1(R$id.videoEditChooseCoverLayout);
        if ((videoEditChooseCoverLayout == null || videoEditChooseCoverLayout.d()) ? false : true) {
            VideoEditTrimTimeLayout videoEditTrimTimeLayout = (VideoEditTrimTimeLayout) e1(R$id.videoEditTrimTimeLayout);
            if (((videoEditTrimTimeLayout == null || videoEditTrimTimeLayout.d()) ? false : true) && W1()) {
                return true;
            }
        }
        return false;
    }

    public final void C1(boolean z10, String str) {
        FKTitleBarLayout it = (FKTitleBarLayout) e1(R$id.videoEditTitleBarLayout);
        if (z10) {
            s.h(it, "it");
            FKTitleBarLayout.setSingleTitle$default(it, str, null, 2, null);
            it.setLeftImageVisible(false);
            FKTitleBarLayout.setRightText$default(it, null, 0, 4, false, 10, null);
            return;
        }
        s.h(it, "it");
        FKTitleBarLayout.setSingleTitle$default(it, str, null, 2, null);
        it.setLeftImageVisible(true);
        FKTitleBarLayout.setRightText$default(it, getString(R$string.complete), 0, 0, false, 14, null);
    }

    public final void E1(final String str) {
        if (str == null || str.length() == 0) {
            com.cupidapp.live.base.view.h.f12779a.s(getContext(), "获取视频路径出错");
            return;
        }
        Flowable<VideoInfoData> p10 = VideoTrimUtil.f17238a.p(getContext(), str);
        if (p10 != null) {
            final Function1<VideoInfoData, kotlin.p> function1 = new Function1<VideoInfoData, kotlin.p>() { // from class: com.cupidapp.live.mediapicker.fragment.VideoEditFragment$configVideoEditAttributeModel$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(VideoInfoData videoInfoData) {
                    invoke2(videoInfoData);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(VideoInfoData videoInfoData) {
                    ConstantsResult q10 = p1.g.f52734a.q();
                    long r10 = v.r(q10 != null ? q10.getVideoMaxSeconds() : 60);
                    VideoEditFragment.this.f17195e = new VideoEditAttributeModel(str, videoInfoData.getWidth(), videoInfoData.getHeight(), videoInfoData.getDuration(), videoInfoData.getRotation(), r10, 0L, 0L, Math.min(videoInfoData.getDuration(), r10), 192, null);
                    j.a aVar = com.cupidapp.live.base.utils.j.f12332a;
                    VideoEditAttributeModel videoEditAttributeModel = VideoEditFragment.this.f17195e;
                    if (videoEditAttributeModel == null) {
                        s.A("videoAttributeModel");
                        videoEditAttributeModel = null;
                    }
                    aVar.a("VideoEditFragment", "videoAttributeModel:" + ((Object) videoEditAttributeModel));
                    VideoEditFragment.this.U1(videoInfoData.getWidth(), videoInfoData.getHeight());
                }
            };
            Consumer<? super VideoInfoData> consumer = new Consumer() { // from class: com.cupidapp.live.mediapicker.fragment.j
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    VideoEditFragment.F1(Function1.this, obj);
                }
            };
            final Function1<Throwable, kotlin.p> function12 = new Function1<Throwable, kotlin.p>() { // from class: com.cupidapp.live.mediapicker.fragment.VideoEditFragment$configVideoEditAttributeModel$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
                    invoke2(th);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    com.cupidapp.live.base.view.h.f12779a.s(VideoEditFragment.this.getContext(), "获取视频基础信息出错");
                }
            };
            Disposable subscribe = p10.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.mediapicker.fragment.o
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    VideoEditFragment.G1(Function1.this, obj);
                }
            });
            if (subscribe != null) {
                H(subscribe);
            }
        }
    }

    public final void H1() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(0);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    public final void I1(final String str) {
        k.a aVar = z0.k.f54819a;
        File i10 = aVar.i(getContext(), System.currentTimeMillis() + "_feed_first_frame.jpg");
        VideoEditAttributeModel videoEditAttributeModel = null;
        final String absolutePath = i10 != null ? i10.getAbsolutePath() : null;
        File i11 = aVar.i(getContext(), System.currentTimeMillis() + "_feed_cover_image.jpg");
        final String absolutePath2 = i11 != null ? i11.getAbsolutePath() : null;
        VideoEditAttributeModel videoEditAttributeModel2 = this.f17195e;
        if (videoEditAttributeModel2 == null) {
            s.A("videoAttributeModel");
            videoEditAttributeModel2 = null;
        }
        long selectCoverImageTimeMs = videoEditAttributeModel2.getSelectCoverImageTimeMs();
        VideoEditAttributeModel videoEditAttributeModel3 = this.f17195e;
        if (videoEditAttributeModel3 == null) {
            s.A("videoAttributeModel");
        } else {
            videoEditAttributeModel = videoEditAttributeModel3;
        }
        final long trimInMs = selectCoverImageTimeMs - videoEditAttributeModel.getTrimInMs();
        Flowable subscribeOn = Flowable.just(str).subscribeOn(Schedulers.io());
        final Function1<String, kotlin.p> function1 = new Function1<String, kotlin.p>() { // from class: com.cupidapp.live.mediapicker.fragment.VideoEditFragment$generateFirstFrameAndCoverImage$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(String str2) {
                invoke2(str2);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str2) {
                VideoTrimUtil.f17238a.r(VideoEditFragment.this.getContext(), str2, absolutePath, 0L);
            }
        };
        Flowable observeOn = subscribeOn.doOnNext(new Consumer() { // from class: com.cupidapp.live.mediapicker.fragment.h
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VideoEditFragment.K1(Function1.this, obj);
            }
        }).observeOn(AndroidSchedulers.mainThread());
        final Function1<String, kotlin.p> function12 = new Function1<String, kotlin.p>() { // from class: com.cupidapp.live.mediapicker.fragment.VideoEditFragment$generateFirstFrameAndCoverImage$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(String str2) {
                invoke2(str2);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str2) {
                ProgressBarDialog progressBarDialog = (ProgressBarDialog) VideoEditFragment.this.e1(R$id.progressBarDialog);
                if (progressBarDialog != null) {
                    progressBarDialog.setProgress(99);
                }
            }
        };
        Flowable subscribeOn2 = observeOn.doOnNext(new Consumer() { // from class: com.cupidapp.live.mediapicker.fragment.m
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VideoEditFragment.L1(Function1.this, obj);
            }
        }).subscribeOn(Schedulers.io());
        final Function1<String, kotlin.p> function13 = new Function1<String, kotlin.p>() { // from class: com.cupidapp.live.mediapicker.fragment.VideoEditFragment$generateFirstFrameAndCoverImage$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(String str2) {
                invoke2(str2);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str2) {
                VideoTrimUtil.f17238a.r(VideoEditFragment.this.getContext(), str2, absolutePath2, trimInMs);
            }
        };
        Flowable observeOn2 = subscribeOn2.doOnNext(new Consumer() { // from class: com.cupidapp.live.mediapicker.fragment.n
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VideoEditFragment.M1(Function1.this, obj);
            }
        }).observeOn(AndroidSchedulers.mainThread());
        final Function1<String, kotlin.p> function14 = new Function1<String, kotlin.p>() { // from class: com.cupidapp.live.mediapicker.fragment.VideoEditFragment$generateFirstFrameAndCoverImage$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(String str2) {
                invoke2(str2);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str2) {
                VideoEditFragment videoEditFragment = VideoEditFragment.this;
                int i12 = R$id.progressBarDialog;
                ProgressBarDialog progressBarDialog = (ProgressBarDialog) videoEditFragment.e1(i12);
                if (progressBarDialog != null) {
                    progressBarDialog.setProgress(100);
                }
                ProgressBarDialog progressBarDialog2 = (ProgressBarDialog) VideoEditFragment.this.e1(i12);
                if (progressBarDialog2 != null) {
                    progressBarDialog2.setVisibility(8);
                }
                VideoEditFragment.this.y1(str, absolutePath, absolutePath2);
            }
        };
        Consumer consumer = new Consumer() { // from class: com.cupidapp.live.mediapicker.fragment.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VideoEditFragment.N1(Function1.this, obj);
            }
        };
        final Function1<Throwable, kotlin.p> function15 = new Function1<Throwable, kotlin.p>() { // from class: com.cupidapp.live.mediapicker.fragment.VideoEditFragment$generateFirstFrameAndCoverImage$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
                invoke2(th);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                com.cupidapp.live.base.view.h.f12779a.s(VideoEditFragment.this.getContext(), "第一帧图、封面图获取失败");
            }
        };
        Disposable subscribe = observeOn2.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.mediapicker.fragment.l
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VideoEditFragment.J1(Function1.this, obj);
            }
        });
        if (subscribe != null) {
            H(subscribe);
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f17200j.clear();
    }

    public final Config O1() {
        return (Config) this.f17198h.getValue();
    }

    public final BaseExoMediaPlayer P1() {
        return (BaseExoMediaPlayer) this.f17197g.getValue();
    }

    public final void Q1() {
        int i10 = R$id.videoEditTitleBarLayout;
        ((FKTitleBarLayout) e1(i10)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.mediapicker.fragment.VideoEditFragment$initTitleBarLayoutClickEvent$1
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
                boolean g22;
                g22 = VideoEditFragment.this.g2();
                if (g22) {
                    VideoEditFragment.this.b2();
                } else {
                    VideoEditFragment.this.H1();
                }
            }
        });
        ((FKTitleBarLayout) e1(i10)).setRightTextClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.mediapicker.fragment.VideoEditFragment$initTitleBarLayoutClickEvent$2
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
                VideoEditFragment.this.Z1();
            }
        });
    }

    public final void R1() {
        int i10 = R$id.videoEditButtonListLayout;
        ((MediaEditButtonListLayout) e1(i10)).i(false);
        ((MediaEditButtonListLayout) e1(i10)).setMediaEditButtonListListener(new b());
    }

    public final void S1() {
        ((VideoEditChooseCoverLayout) e1(R$id.videoEditChooseCoverLayout)).setVideoEditChooseCoverListener(new c());
    }

    public final void T1() {
        ((VideoEditTrimTimeLayout) e1(R$id.videoEditTrimTimeLayout)).setVideoEditTrimTimeListener(new d());
    }

    public final void U1(final int i10, final int i11) {
        ((ConstraintLayout) e1(R$id.videoEditPlayerCardView)).post(new Runnable() { // from class: com.cupidapp.live.mediapicker.fragment.f
            @Override // java.lang.Runnable
            public final void run() {
                VideoEditFragment.V1(i10, i11, this);
            }
        });
        ((FrameLayout) e1(R$id.videoEditPlayerContainer)).addView(P1().k(true));
        P1().A(new e());
        VideoEditAttributeModel videoEditAttributeModel = null;
        e2(this, null, null, 3, null);
        VideoEditAttributeModel videoEditAttributeModel2 = this.f17195e;
        if (videoEditAttributeModel2 == null) {
            s.A("videoAttributeModel");
            videoEditAttributeModel2 = null;
        }
        long durationMs = videoEditAttributeModel2.getDurationMs();
        VideoEditAttributeModel videoEditAttributeModel3 = this.f17195e;
        if (videoEditAttributeModel3 == null) {
            s.A("videoAttributeModel");
        } else {
            videoEditAttributeModel = videoEditAttributeModel3;
        }
        if (durationMs > videoEditAttributeModel.getMaxDurationMs()) {
            c2();
        }
    }

    public final boolean W1() {
        if (!g2()) {
            return true;
        }
        b2();
        return false;
    }

    public final void Y1() {
        if (((VideoEditChooseCoverLayout) e1(R$id.videoEditChooseCoverLayout)).c()) {
            return;
        }
        P1().x();
        P1().l();
    }

    public final void Z1() {
        Flowable observeOn;
        x1();
        File j10 = z0.k.f54819a.j(getContext(), System.currentTimeMillis() + "_feed_after_compile.mp4");
        VideoEditAttributeModel videoEditAttributeModel = null;
        String absolutePath = j10 != null ? j10.getAbsolutePath() : null;
        if (absolutePath == null || absolutePath.length() == 0) {
            com.cupidapp.live.base.view.h.f12779a.s(getContext(), "创建编译的视频文件失败");
            return;
        }
        VideoEditAttributeModel videoEditAttributeModel2 = this.f17195e;
        if (videoEditAttributeModel2 == null) {
            s.A("videoAttributeModel");
            videoEditAttributeModel2 = null;
        }
        long trimOutMs = videoEditAttributeModel2.getTrimOutMs();
        VideoEditAttributeModel videoEditAttributeModel3 = this.f17195e;
        if (videoEditAttributeModel3 == null) {
            s.A("videoAttributeModel");
            videoEditAttributeModel3 = null;
        }
        long trimInMs = trimOutMs - videoEditAttributeModel3.getTrimInMs();
        VideoTrimUtil videoTrimUtil = VideoTrimUtil.f17238a;
        Context context = getContext();
        VideoEditAttributeModel videoEditAttributeModel4 = this.f17195e;
        if (videoEditAttributeModel4 == null) {
            s.A("videoAttributeModel");
            videoEditAttributeModel4 = null;
        }
        String uriString = videoEditAttributeModel4.getUriString();
        VideoEditAttributeModel videoEditAttributeModel5 = this.f17195e;
        if (videoEditAttributeModel5 == null) {
            s.A("videoAttributeModel");
            videoEditAttributeModel5 = null;
        }
        int width = videoEditAttributeModel5.getWidth();
        VideoEditAttributeModel videoEditAttributeModel6 = this.f17195e;
        if (videoEditAttributeModel6 == null) {
            s.A("videoAttributeModel");
            videoEditAttributeModel6 = null;
        }
        int height = videoEditAttributeModel6.getHeight();
        VideoEditAttributeModel videoEditAttributeModel7 = this.f17195e;
        if (videoEditAttributeModel7 == null) {
            s.A("videoAttributeModel");
            videoEditAttributeModel7 = null;
        }
        long trimInMs2 = videoEditAttributeModel7.getTrimInMs();
        VideoEditAttributeModel videoEditAttributeModel8 = this.f17195e;
        if (videoEditAttributeModel8 == null) {
            s.A("videoAttributeModel");
        } else {
            videoEditAttributeModel = videoEditAttributeModel8;
        }
        Flowable j11 = VideoTrimUtil.j(videoTrimUtil, context, uriString, absolutePath, width, height, trimInMs2, videoEditAttributeModel.getTrimOutMs(), VideoCropScene.FEED, null, 256, null);
        if (j11 == null || (observeOn = j11.observeOn(AndroidSchedulers.mainThread())) == null) {
            return;
        }
        final Function1<Subscription, kotlin.p> function1 = new Function1<Subscription, kotlin.p>() { // from class: com.cupidapp.live.mediapicker.fragment.VideoEditFragment$saveVideoEdit$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Subscription subscription) {
                invoke2(subscription);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Subscription subscription) {
                VideoEditFragment videoEditFragment = VideoEditFragment.this;
                int i10 = R$id.progressBarDialog;
                ProgressBarDialog progressBarDialog = (ProgressBarDialog) videoEditFragment.e1(i10);
                if (progressBarDialog != null) {
                    progressBarDialog.setVisibility(0);
                }
                ProgressBarDialog progressBarDialog2 = (ProgressBarDialog) VideoEditFragment.this.e1(i10);
                if (progressBarDialog2 != null) {
                    progressBarDialog2.setProgress(0);
                }
            }
        };
        Flowable doOnSubscribe = observeOn.doOnSubscribe(new Consumer() { // from class: com.cupidapp.live.mediapicker.fragment.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VideoEditFragment.a2(Function1.this, obj);
            }
        });
        if (doOnSubscribe != null) {
            doOnSubscribe.subscribe((FlowableSubscriber) new f(trimInMs, this, absolutePath));
        }
    }

    public final void b2() {
        FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, getContext(), false, 2, null), R$string.media_edit_back_alert, 0, 2, null), R$string.continue_to_return, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.mediapicker.fragment.VideoEditFragment$showCloseFragmentAlertDialog$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ kotlin.p invoke() {
                invoke2();
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                VideoEditFragment.this.H1();
            }
        }, 2, null), 0, null, 3, null), null, 1, null);
    }

    public final void c2() {
        String string = getString(R$string.video_trim);
        s.h(string, "getString(R.string.video_trim)");
        C1(true, string);
        int i10 = R$id.videoEditTrimTimeLayout;
        VideoEditTrimTimeLayout videoEditTrimTimeLayout = (VideoEditTrimTimeLayout) e1(i10);
        Property<View, Float> Y = View.Y;
        s.h(Y, "Y");
        videoEditTrimTimeLayout.e(Y);
        VideoEditTrimTimeLayout videoEditTrimTimeLayout2 = (VideoEditTrimTimeLayout) e1(i10);
        VideoEditAttributeModel videoEditAttributeModel = this.f17195e;
        if (videoEditAttributeModel == null) {
            s.A("videoAttributeModel");
            videoEditAttributeModel = null;
        }
        videoEditTrimTimeLayout2.l(videoEditAttributeModel);
    }

    public final void d2(Long l10, Long l11) {
        long trimInMs;
        long trimOutMs;
        VideoEditAttributeModel videoEditAttributeModel = null;
        if (l10 != null) {
            trimInMs = l10.longValue();
        } else {
            VideoEditAttributeModel videoEditAttributeModel2 = this.f17195e;
            if (videoEditAttributeModel2 == null) {
                s.A("videoAttributeModel");
                videoEditAttributeModel2 = null;
            }
            trimInMs = videoEditAttributeModel2.getTrimInMs();
        }
        long j10 = trimInMs;
        if (l11 != null) {
            trimOutMs = l11.longValue();
        } else {
            VideoEditAttributeModel videoEditAttributeModel3 = this.f17195e;
            if (videoEditAttributeModel3 == null) {
                s.A("videoAttributeModel");
                videoEditAttributeModel3 = null;
            }
            trimOutMs = videoEditAttributeModel3.getTrimOutMs();
        }
        P1().z(new g(j10, trimOutMs, this));
        P1().l();
        BaseExoMediaPlayer P1 = P1();
        VideoEditAttributeModel videoEditAttributeModel4 = this.f17195e;
        if (videoEditAttributeModel4 == null) {
            s.A("videoAttributeModel");
        } else {
            videoEditAttributeModel = videoEditAttributeModel4;
        }
        BaseExoMediaPlayer.q(P1, videoEditAttributeModel.getUriString(), false, null, false, 14, null);
    }

    @Nullable
    public View e1(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f17200j;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i10)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void f2() {
        P1().n();
        P1().w();
    }

    public final boolean g2() {
        VideoEditAttributeModel videoEditAttributeModel = this.f17195e;
        VideoEditAttributeModel videoEditAttributeModel2 = null;
        if (videoEditAttributeModel == null) {
            s.A("videoAttributeModel");
            videoEditAttributeModel = null;
        }
        if (videoEditAttributeModel.getSelectCoverImageTimeMs() != 0 || videoEditAttributeModel.getTrimInMs() != 0) {
            return true;
        }
        long trimOutMs = videoEditAttributeModel.getTrimOutMs();
        VideoEditAttributeModel videoEditAttributeModel3 = this.f17195e;
        if (videoEditAttributeModel3 == null) {
            s.A("videoAttributeModel");
        } else {
            videoEditAttributeModel2 = videoEditAttributeModel3;
        }
        return trimOutMs != videoEditAttributeModel2.getDurationMs();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public boolean onBackPressed() {
        if (isDetached() || !B1()) {
            return true;
        }
        H1();
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_video_edit, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        VideoTrimUtil.f17238a.g();
        P1().r();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Y1();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        ((FKLoadingLayout) e1(R$id.video_loading_layout)).removeCallbacks(this.f17199i);
        f2();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        Q1();
        R1();
        S1();
        T1();
        Config O1 = O1();
        E1(O1 != null ? O1.getUriString() : null);
    }

    public final void x1() {
        VideoEditAttributeModel videoEditAttributeModel = this.f17195e;
        VideoEditAttributeModel videoEditAttributeModel2 = null;
        if (videoEditAttributeModel == null) {
            s.A("videoAttributeModel");
            videoEditAttributeModel = null;
        }
        long selectCoverImageTimeMs = videoEditAttributeModel.getSelectCoverImageTimeMs();
        VideoEditAttributeModel videoEditAttributeModel3 = this.f17195e;
        if (videoEditAttributeModel3 == null) {
            s.A("videoAttributeModel");
            videoEditAttributeModel3 = null;
        }
        if (selectCoverImageTimeMs >= videoEditAttributeModel3.getTrimInMs()) {
            VideoEditAttributeModel videoEditAttributeModel4 = this.f17195e;
            if (videoEditAttributeModel4 == null) {
                s.A("videoAttributeModel");
                videoEditAttributeModel4 = null;
            }
            long selectCoverImageTimeMs2 = videoEditAttributeModel4.getSelectCoverImageTimeMs();
            VideoEditAttributeModel videoEditAttributeModel5 = this.f17195e;
            if (videoEditAttributeModel5 == null) {
                s.A("videoAttributeModel");
                videoEditAttributeModel5 = null;
            }
            if (selectCoverImageTimeMs2 <= videoEditAttributeModel5.getTrimOutMs()) {
                return;
            }
        }
        VideoEditAttributeModel videoEditAttributeModel6 = this.f17195e;
        if (videoEditAttributeModel6 == null) {
            s.A("videoAttributeModel");
            videoEditAttributeModel6 = null;
        }
        VideoEditAttributeModel videoEditAttributeModel7 = this.f17195e;
        if (videoEditAttributeModel7 == null) {
            s.A("videoAttributeModel");
        } else {
            videoEditAttributeModel2 = videoEditAttributeModel7;
        }
        videoEditAttributeModel6.setSelectCoverImageTimeMs(videoEditAttributeModel2.getTrimInMs());
    }

    public final void y1(final String str, final String str2, final String str3) {
        Flowable<VideoInfoData> p10 = VideoTrimUtil.f17238a.p(getContext(), str);
        if (p10 != null) {
            final Function1<VideoInfoData, kotlin.p> function1 = new Function1<VideoInfoData, kotlin.p>() { // from class: com.cupidapp.live.mediapicker.fragment.VideoEditFragment$callbackClickSaveBtn$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(VideoInfoData videoInfoData) {
                    invoke2(videoInfoData);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(VideoInfoData videoInfoData) {
                    VideoEditFragment.Config O1;
                    VideoEditFragment.Config O12;
                    VideoEditFragment.Config O13;
                    boolean z10;
                    VideoEditFragment.Config O14;
                    VideoContentModel videoContentModel = new VideoContentModel(new UploadVideoModel(null, String.this, 1, null), new UploadImageModel(null, str2, null, 5, null), new UploadImageModel(null, str3, null, 5, null), videoInfoData.getWidth(), videoInfoData.getHeight());
                    O1 = this.O1();
                    String str4 = (O1 != null ? O1.getHashTag() : null) == null ? "上传" : "投稿";
                    FeedPublishActivity.a aVar = FeedPublishActivity.K;
                    FragmentActivity activity = this.getActivity();
                    O12 = this.O1();
                    HashTagSimpleModel hashTag = O12 != null ? O12.getHashTag() : null;
                    O13 = this.O1();
                    SensorPosition showPosition = O13 != null ? O13.getShowPosition() : null;
                    z10 = this.f17196f;
                    O14 = this.O1();
                    aVar.a(activity, null, videoContentModel, hashTag, MetricsProto.MetricsEvent.ACTION_TEXT_CLASSIFIER_ACTIONS_SHOWN, str4, showPosition, false, z10, O14 != null ? O14.getWebTitle() : null);
                }
            };
            Consumer<? super VideoInfoData> consumer = new Consumer() { // from class: com.cupidapp.live.mediapicker.fragment.p
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    VideoEditFragment.z1(Function1.this, obj);
                }
            };
            final VideoEditFragment$callbackClickSaveBtn$2 videoEditFragment$callbackClickSaveBtn$2 = new Function1<Throwable, kotlin.p>() { // from class: com.cupidapp.live.mediapicker.fragment.VideoEditFragment$callbackClickSaveBtn$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
                    invoke2(th);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    com.cupidapp.live.base.view.h.f12779a.t("视频编辑失败（点击完成按钮）");
                }
            };
            Disposable subscribe = p10.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.mediapicker.fragment.k
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    VideoEditFragment.A1(Function1.this, obj);
                }
            });
            if (subscribe != null) {
                H(subscribe);
            }
        }
    }
}
