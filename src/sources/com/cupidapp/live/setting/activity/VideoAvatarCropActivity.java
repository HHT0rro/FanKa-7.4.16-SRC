package com.cupidapp.live.setting.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.activity.result.ActivityResultLauncher;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.extension.ImageAttributeModel;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.network.model.UploadImageFileResult;
import com.cupidapp.live.base.network.model.UploadVideoFileResult;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.base.utils.p0;
import com.cupidapp.live.base.video.ExoMediaPlayer;
import com.cupidapp.live.base.view.dialog.FKLoadingLayout;
import com.cupidapp.live.base.view.progress.ProgressBarDialog;
import com.cupidapp.live.main.model.UserModifyResult;
import com.cupidapp.live.mediapicker.helper.FKFireBaseDetectorOptionsKt;
import com.cupidapp.live.mediapicker.helper.VideoCropScene;
import com.cupidapp.live.mediapicker.helper.VideoInfoData;
import com.cupidapp.live.mediapicker.helper.VideoTrimUtil;
import com.cupidapp.live.mediapicker.model.VideoEditAttributeModel;
import com.cupidapp.live.mediapicker.view.BottomConfirmAndCancelLayout;
import com.cupidapp.live.mediapicker.view.ImageTrimBoxLayout;
import com.cupidapp.live.mediapicker.view.VideoTrimLayout;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.setting.view.TrimDragLayout;
import io.microshow.rxffmpeg.RxFFmpegProgress;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$LongRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.reactivestreams.Subscription;

/* compiled from: VideoAvatarCropActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VideoAvatarCropActivity extends FKBaseActivity {

    /* renamed from: w, reason: collision with root package name */
    @NotNull
    public static final a f18028w = new a(null);

    /* renamed from: q, reason: collision with root package name */
    public boolean f18029q;

    /* renamed from: s, reason: collision with root package name */
    public float f18031s;

    /* renamed from: t, reason: collision with root package name */
    @Nullable
    public ChangeAvatarModel f18032t;

    /* renamed from: u, reason: collision with root package name */
    public long f18033u;

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18034v = new LinkedHashMap();

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final Runnable f18030r = new Runnable() { // from class: com.cupidapp.live.setting.activity.g0
        @Override // java.lang.Runnable
        public final void run() {
            VideoAvatarCropActivity.b2(VideoAvatarCropActivity.this);
        }
    };

    /* compiled from: VideoAvatarCropActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @Nullable ActivityResultLauncher<Intent> activityResultLauncher, @NotNull String uriString, @Nullable ChangeAvatarModel changeAvatarModel) {
            kotlin.jvm.internal.s.i(context, "context");
            kotlin.jvm.internal.s.i(uriString, "uriString");
            if (activityResultLauncher == null) {
                return;
            }
            Intent intent = new Intent(context, (Class<?>) VideoAvatarCropActivity.class);
            intent.putExtra("URI_STRING", uriString);
            if (changeAvatarModel != null) {
                z0.g.c(intent, changeAvatarModel);
            }
            activityResultLauncher.launch(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    /* compiled from: VideoAvatarCropActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b extends com.cupidapp.live.mediapicker.helper.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f18035b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ VideoAvatarCropActivity f18036c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f18037d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f18038e;

        public b(long j10, VideoAvatarCropActivity videoAvatarCropActivity, Context context, String str) {
            this.f18035b = j10;
            this.f18036c = videoAvatarCropActivity;
            this.f18037d = context;
            this.f18038e = str;
        }

        @Override // com.cupidapp.live.mediapicker.helper.a, io.microshow.rxffmpeg.RxFFmpegInvoke.IFFmpegListener
        public void onCancel() {
            super.onCancel();
            ProgressBarDialog progressBarDialog = (ProgressBarDialog) this.f18036c.t1(R$id.video_crop_progress_bar);
            if (progressBarDialog == null) {
                return;
            }
            progressBarDialog.setVisibility(8);
        }

        @Override // com.cupidapp.live.mediapicker.helper.a, io.microshow.rxffmpeg.RxFFmpegInvoke.IFFmpegListener
        public void onError(@NotNull String message) {
            kotlin.jvm.internal.s.i(message, "message");
            super.onError(message);
            com.cupidapp.live.base.view.h.f12779a.m(this.f18037d, message);
            ProgressBarDialog progressBarDialog = (ProgressBarDialog) this.f18036c.t1(R$id.video_crop_progress_bar);
            if (progressBarDialog == null) {
                return;
            }
            progressBarDialog.setVisibility(8);
        }

        @Override // com.cupidapp.live.mediapicker.helper.a, io.microshow.rxffmpeg.RxFFmpegInvoke.IFFmpegListener
        public void onFinish() {
            super.onFinish();
            this.f18036c.O1(this.f18037d, this.f18038e);
        }

        @Override // com.cupidapp.live.mediapicker.helper.a, io.microshow.rxffmpeg.RxFFmpegInvoke.IFFmpegListener
        public void onProgress(int i10, long j10) {
            ProgressBarDialog progressBarDialog;
            super.onProgress(i10, j10);
            float v2 = ((((float) z0.v.v(j10)) / ((float) this.f18035b)) * 100) - 5;
            if (v2 < 0.0f || (progressBarDialog = (ProgressBarDialog) this.f18036c.t1(R$id.video_crop_progress_bar)) == null) {
                return;
            }
            progressBarDialog.setProgress((int) v2);
        }
    }

    /* compiled from: VideoAvatarCropActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements ExoMediaPlayer.b {

        /* compiled from: VideoAvatarCropActivity.kt */
        @kotlin.d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f18040a;

            static {
                int[] iArr = new int[ExoMediaPlayer.PlayState.values().length];
                try {
                    iArr[ExoMediaPlayer.PlayState.READY.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ExoMediaPlayer.PlayState.ENDED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ExoMediaPlayer.PlayState.IDLE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[ExoMediaPlayer.PlayState.BUFFERING.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                f18040a = iArr;
            }
        }

        public c() {
        }

        @Override // com.cupidapp.live.base.video.ExoMediaPlayer.b
        public void a(@NotNull ExoMediaPlayer.PlayState state) {
            kotlin.jvm.internal.s.i(state, "state");
            int i10 = a.f18040a[state.ordinal()];
            if (i10 != 1) {
                if (i10 == 2 || i10 == 3) {
                    VideoAvatarCropActivity.this.f18029q = false;
                    return;
                } else {
                    if (i10 != 4) {
                        return;
                    }
                    ((FKLoadingLayout) VideoAvatarCropActivity.this.t1(R$id.video_crop_loading_layout)).postDelayed(VideoAvatarCropActivity.this.f18030r, 1000L);
                    return;
                }
            }
            VideoAvatarCropActivity videoAvatarCropActivity = VideoAvatarCropActivity.this;
            int i11 = R$id.video_crop_loading_layout;
            ((FKLoadingLayout) videoAvatarCropActivity.t1(i11)).removeCallbacks(VideoAvatarCropActivity.this.f18030r);
            ((FKLoadingLayout) VideoAvatarCropActivity.this.t1(i11)).setVisibility(8);
            ((FKLoadingLayout) VideoAvatarCropActivity.this.t1(i11)).c();
            if (VideoAvatarCropActivity.this.f18029q) {
                return;
            }
            VideoAvatarCropActivity.this.f18029q = true;
            ((FrameLayout) VideoAvatarCropActivity.this.t1(R$id.video_crop_preview_layout)).setVisibility(0);
        }
    }

    /* compiled from: VideoAvatarCropActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d implements VideoTrimLayout.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref$LongRef f18041a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref$LongRef f18042b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ VideoEditAttributeModel f18043c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ VideoAvatarCropActivity f18044d;

        public d(Ref$LongRef ref$LongRef, Ref$LongRef ref$LongRef2, VideoEditAttributeModel videoEditAttributeModel, VideoAvatarCropActivity videoAvatarCropActivity) {
            this.f18041a = ref$LongRef;
            this.f18042b = ref$LongRef2;
            this.f18043c = videoEditAttributeModel;
            this.f18044d = videoAvatarCropActivity;
        }

        @Override // com.cupidapp.live.mediapicker.view.VideoTrimLayout.a
        public void a() {
            this.f18043c.setTrimInMs(this.f18041a.element);
            this.f18043c.setTrimOutMs(this.f18042b.element);
            VideoAvatarCropActivity videoAvatarCropActivity = this.f18044d;
            VideoEditAttributeModel videoEditAttributeModel = this.f18043c;
            videoAvatarCropActivity.e2(videoEditAttributeModel, Long.valueOf(videoEditAttributeModel.getTrimInMs()), Long.valueOf(this.f18043c.getTrimOutMs()));
        }

        @Override // com.cupidapp.live.mediapicker.view.VideoTrimLayout.a
        public void b(long j10, long j11, long j12) {
            ExoMediaPlayer exoMediaPlayer = ExoMediaPlayer.f12408a;
            exoMediaPlayer.x(null);
            this.f18041a.element = j10;
            this.f18042b.element = j11;
            exoMediaPlayer.p();
            exoMediaPlayer.w(j12);
        }
    }

    /* compiled from: VideoAvatarCropActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class e implements ExoMediaPlayer.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f18045a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f18046b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ VideoAvatarCropActivity f18047c;

        public e(long j10, long j11, VideoAvatarCropActivity videoAvatarCropActivity) {
            this.f18045a = j10;
            this.f18046b = j11;
            this.f18047c = videoAvatarCropActivity;
        }

        @Override // com.cupidapp.live.base.video.ExoMediaPlayer.a
        public void a(long j10) {
            long j11 = this.f18045a;
            if (j10 >= j11 && j10 <= this.f18046b) {
                ((VideoTrimLayout) this.f18047c.t1(R$id.video_crop_layout)).setVideoPlayCurrentTime(j10);
            } else {
                ExoMediaPlayer.f12408a.w(j11);
            }
        }
    }

    public static final void N1(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void P1(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void Q1(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void R1(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void T1(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void U1(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void X1(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void Y1(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void Z1(final VideoAvatarCropActivity this$0, VideoEditAttributeModel model) {
        float f10;
        float f11;
        float width;
        float f12;
        kotlin.jvm.internal.s.i(this$0, "this$0");
        kotlin.jvm.internal.s.i(model, "$model");
        int i10 = R$id.video_crop_trim_box_layout;
        float height = ((ImageTrimBoxLayout) this$0.t1(i10)).getHeight() - (z0.h.c(this$0, 50.0f) * 2.0f);
        float f13 = height * 0.75f;
        float l10 = z0.h.l(this$0) - (z0.h.c(this$0, 30.0f) * 2.0f);
        if (f13 > l10) {
            f10 = l10 / 0.75f;
            f11 = l10;
        } else {
            f10 = height;
            f11 = f13;
        }
        ((ImageTrimBoxLayout) this$0.t1(i10)).setTrimBoxSize(f11, f10);
        if (model.getWidth() < model.getHeight()) {
            f12 = (model.getHeight() * f11) / model.getWidth();
            width = f11;
        } else {
            width = (model.getWidth() * f10) / model.getHeight();
            f12 = f10;
        }
        int i11 = R$id.video_crop_preview_layout;
        FrameLayout video_crop_preview_layout = (FrameLayout) this$0.t1(i11);
        kotlin.jvm.internal.s.h(video_crop_preview_layout, "video_crop_preview_layout");
        z0.y.n(video_crop_preview_layout, Integer.valueOf((int) width), Integer.valueOf((int) f12));
        FrameLayout frameLayout = (FrameLayout) this$0.t1(i11);
        ExoMediaPlayer exoMediaPlayer = ExoMediaPlayer.f12408a;
        frameLayout.addView(ExoMediaPlayer.l(exoMediaPlayer, false, 1, null));
        exoMediaPlayer.y(new c());
        f2(this$0, model, null, null, 6, null);
        boolean z10 = model.getWidth() < model.getHeight();
        final float f14 = z10 ? (f12 - f10) / 2 : (width - f11) / 2;
        ((TrimDragLayout) this$0.t1(R$id.video_crop_trim_drag_layout)).d(z10, (int) f14, new Function1<Integer, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.VideoAvatarCropActivity$initVideoPlayerView$4$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Integer num) {
                invoke(num.intValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(int i12) {
                VideoAvatarCropActivity videoAvatarCropActivity = VideoAvatarCropActivity.this;
                float f15 = f14;
                videoAvatarCropActivity.f18031s = (i12 + f15) / (f15 * 2);
            }
        });
    }

    public static final void b2(VideoAvatarCropActivity this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        int i10 = R$id.video_crop_loading_layout;
        ((FKLoadingLayout) this$0.t1(i10)).f();
        ((FKLoadingLayout) this$0.t1(i10)).setVisibility(0);
        ((FKLoadingLayout) this$0.t1(i10)).setLoadingText("视频正在拼命加载中...");
    }

    public static /* synthetic */ void f2(VideoAvatarCropActivity videoAvatarCropActivity, VideoEditAttributeModel videoEditAttributeModel, Long l10, Long l11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            l10 = null;
        }
        if ((i10 & 4) != 0) {
            l11 = null;
        }
        videoAvatarCropActivity.e2(videoEditAttributeModel, l10, l11);
    }

    public final void L1(String str, String str2, ChangeAvatarModel changeAvatarModel) {
        User X = p1.g.f52734a.X();
        List<String> list = null;
        if (X != null) {
            list = X.getAvatarImageIdsByReset(changeAvatarModel != null ? changeAvatarModel.getDeleteAvatarId() : null, str2);
        }
        Disposable disposed = NetworkClient.f11868a.N().A0(list, str, str2).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<UserModifyResult, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.VideoAvatarCropActivity$changeAvatar$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(UserModifyResult userModifyResult) {
                m2797invoke(userModifyResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2797invoke(UserModifyResult userModifyResult) {
                ProgressBarDialog progressBarDialog = (ProgressBarDialog) VideoAvatarCropActivity.this.t1(R$id.video_crop_progress_bar);
                if (progressBarDialog != null) {
                    progressBarDialog.setProgress(100);
                }
                p1.g.f52734a.B2(true);
                com.cupidapp.live.base.view.h.f12779a.c(VideoAvatarCropActivity.this, R$string.upload_success);
                VideoAvatarCropActivity.this.setResult(-1);
                VideoAvatarCropActivity.this.finish();
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.setting.activity.VideoAvatarCropActivity$changeAvatar$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                ((ProgressBarDialog) VideoAvatarCropActivity.this.t1(R$id.video_crop_progress_bar)).setVisibility(8);
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void M1(Context context, VideoEditAttributeModel videoEditAttributeModel) {
        Flowable<RxFFmpegProgress> observeOn;
        File j10 = z0.k.f54819a.j(context, System.currentTimeMillis() + "_avatar_after_compile.mp4");
        String absolutePath = j10 != null ? j10.getAbsolutePath() : null;
        if (absolutePath == null || absolutePath.length() == 0) {
            com.cupidapp.live.base.view.h.f12779a.s(context, "创建编译的视频文件失败");
            return;
        }
        long trimOutMs = videoEditAttributeModel.getTrimOutMs() - videoEditAttributeModel.getTrimInMs();
        Flowable<RxFFmpegProgress> i10 = VideoTrimUtil.f17238a.i(context, videoEditAttributeModel.getUriString(), absolutePath, videoEditAttributeModel.getWidth(), videoEditAttributeModel.getHeight(), videoEditAttributeModel.getTrimInMs(), videoEditAttributeModel.getTrimOutMs(), VideoCropScene.VIDEO_AVATAR, new com.cupidapp.live.mediapicker.helper.e(this.f18031s));
        if (i10 == null || (observeOn = i10.observeOn(AndroidSchedulers.mainThread())) == null) {
            return;
        }
        final Function1<Subscription, kotlin.p> function1 = new Function1<Subscription, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.VideoAvatarCropActivity$compileVideo$1
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
                VideoAvatarCropActivity videoAvatarCropActivity = VideoAvatarCropActivity.this;
                int i11 = R$id.video_crop_progress_bar;
                ProgressBarDialog progressBarDialog = (ProgressBarDialog) videoAvatarCropActivity.t1(i11);
                if (progressBarDialog != null) {
                    progressBarDialog.setVisibility(0);
                }
                ProgressBarDialog progressBarDialog2 = (ProgressBarDialog) VideoAvatarCropActivity.this.t1(i11);
                if (progressBarDialog2 != null) {
                    progressBarDialog2.setProgress(0);
                }
            }
        };
        Flowable<RxFFmpegProgress> doOnSubscribe = observeOn.doOnSubscribe(new Consumer() { // from class: com.cupidapp.live.setting.activity.f0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VideoAvatarCropActivity.N1(Function1.this, obj);
            }
        });
        if (doOnSubscribe != null) {
            doOnSubscribe.subscribe((FlowableSubscriber<? super RxFFmpegProgress>) new b(trimOutMs, this, context, absolutePath));
        }
    }

    public final void O1(final Context context, final String str) {
        File i10 = z0.k.f54819a.i(context, System.currentTimeMillis() + "_avatar_cover_image.jpg");
        final String absolutePath = i10 != null ? i10.getAbsolutePath() : null;
        if (absolutePath == null || absolutePath.length() == 0) {
            com.cupidapp.live.base.view.h.f12779a.s(context, "创建封面图片文件失败");
            return;
        }
        Flowable subscribeOn = Flowable.just(str).subscribeOn(Schedulers.io());
        final Function1<String, kotlin.p> function1 = new Function1<String, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.VideoAvatarCropActivity$generateCoverImage$1
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
                VideoTrimUtil.f17238a.r(context, str2, absolutePath, 0L);
            }
        };
        Flowable observeOn = subscribeOn.doOnNext(new Consumer() { // from class: com.cupidapp.live.setting.activity.z
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VideoAvatarCropActivity.P1(Function1.this, obj);
            }
        }).observeOn(AndroidSchedulers.mainThread());
        final Function1<String, kotlin.p> function12 = new Function1<String, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.VideoAvatarCropActivity$generateCoverImage$2
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
                ProgressBarDialog progressBarDialog = (ProgressBarDialog) VideoAvatarCropActivity.this.t1(R$id.video_crop_progress_bar);
                if (progressBarDialog != null) {
                    progressBarDialog.setProgress(96);
                }
                VideoAvatarCropActivity.this.S1(context, str, absolutePath);
            }
        };
        Consumer consumer = new Consumer() { // from class: com.cupidapp.live.setting.activity.e0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VideoAvatarCropActivity.Q1(Function1.this, obj);
            }
        };
        final Function1<Throwable, kotlin.p> function13 = new Function1<Throwable, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.VideoAvatarCropActivity$generateCoverImage$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                com.cupidapp.live.base.view.h.f12779a.s(context, "封面图获取失败");
            }
        };
        Disposable subscribe = observeOn.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.setting.activity.a0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VideoAvatarCropActivity.R1(Function1.this, obj);
            }
        });
        if (subscribe != null) {
            H(subscribe);
        }
    }

    public final void S1(Context context, final String str, final String str2) {
        Flowable<VideoInfoData> p10 = VideoTrimUtil.f17238a.p(context, str);
        if (p10 != null) {
            final Function1<VideoInfoData, kotlin.p> function1 = new Function1<VideoInfoData, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.VideoAvatarCropActivity$getUploadVideoInfoData$1
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
                    ProgressBarDialog progressBarDialog = (ProgressBarDialog) VideoAvatarCropActivity.this.t1(R$id.video_crop_progress_bar);
                    if (progressBarDialog != null) {
                        progressBarDialog.setProgress(97);
                    }
                    VideoAvatarCropActivity.this.h2(str, str2, videoInfoData.getWidth(), videoInfoData.getHeight());
                }
            };
            Consumer<? super VideoInfoData> consumer = new Consumer() { // from class: com.cupidapp.live.setting.activity.b0
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    VideoAvatarCropActivity.T1(Function1.this, obj);
                }
            };
            final VideoAvatarCropActivity$getUploadVideoInfoData$2 videoAvatarCropActivity$getUploadVideoInfoData$2 = new Function1<Throwable, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.VideoAvatarCropActivity$getUploadVideoInfoData$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
                    invoke2(th);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    com.cupidapp.live.base.view.h.f12779a.t("获取编译成功后的视频基础信息失败");
                }
            };
            Disposable subscribe = p10.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.setting.activity.d0
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    VideoAvatarCropActivity.U1(Function1.this, obj);
                }
            });
            if (subscribe != null) {
                H(subscribe);
            }
        }
    }

    public final void V1(final VideoEditAttributeModel videoEditAttributeModel) {
        ((ImageTrimBoxLayout) t1(R$id.video_crop_trim_box_layout)).post(new Runnable() { // from class: com.cupidapp.live.setting.activity.h0
            @Override // java.lang.Runnable
            public final void run() {
                VideoAvatarCropActivity.Z1(VideoAvatarCropActivity.this, videoEditAttributeModel);
            }
        });
    }

    public final void W1(final String str) {
        if (str == null || str.length() == 0) {
            com.cupidapp.live.base.view.h.f12779a.s(this, "获取视频路径失败");
            return;
        }
        Flowable<VideoInfoData> p10 = VideoTrimUtil.f17238a.p(this, str);
        if (p10 != null) {
            final Function1<VideoInfoData, kotlin.p> function1 = new Function1<VideoInfoData, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.VideoAvatarCropActivity$initVideoPlayerView$1
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
                    long r10 = z0.v.r(2);
                    final VideoEditAttributeModel videoEditAttributeModel = new VideoEditAttributeModel(String.this, videoInfoData.getWidth(), videoInfoData.getHeight(), videoInfoData.getDuration(), videoInfoData.getRotation(), r10, 0L, 0L, Math.min(videoInfoData.getDuration(), r10), 192, null);
                    com.cupidapp.live.base.utils.j.f12332a.a("VideoCropActivity", "VideoEditAttributeModel:" + ((Object) videoEditAttributeModel));
                    this.a2(videoEditAttributeModel);
                    this.V1(videoEditAttributeModel);
                    BottomConfirmAndCancelLayout bottomConfirmAndCancelLayout = (BottomConfirmAndCancelLayout) this.t1(R$id.confirm_and_cancel_layout);
                    final VideoAvatarCropActivity videoAvatarCropActivity = this;
                    bottomConfirmAndCancelLayout.setConfirmButtonClickEvent(new Function0<kotlin.p>() { // from class: com.cupidapp.live.setting.activity.VideoAvatarCropActivity$initVideoPlayerView$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            VideoAvatarCropActivity videoAvatarCropActivity2 = VideoAvatarCropActivity.this;
                            videoAvatarCropActivity2.M1(videoAvatarCropActivity2, videoEditAttributeModel);
                        }
                    });
                }
            };
            Consumer<? super VideoInfoData> consumer = new Consumer() { // from class: com.cupidapp.live.setting.activity.y
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    VideoAvatarCropActivity.X1(Function1.this, obj);
                }
            };
            final Function1<Throwable, kotlin.p> function12 = new Function1<Throwable, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.VideoAvatarCropActivity$initVideoPlayerView$2
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
                    com.cupidapp.live.base.view.h.f12779a.s(VideoAvatarCropActivity.this, "获取视频基础信息失败");
                }
            };
            Disposable subscribe = p10.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.setting.activity.c0
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    VideoAvatarCropActivity.Y1(Function1.this, obj);
                }
            });
            if (subscribe != null) {
                H(subscribe);
            }
        }
    }

    public final void a2(VideoEditAttributeModel videoEditAttributeModel) {
        Ref$LongRef ref$LongRef = new Ref$LongRef();
        Ref$LongRef ref$LongRef2 = new Ref$LongRef();
        int i10 = R$id.video_crop_layout;
        ((VideoTrimLayout) t1(i10)).setVideoTrimLayoutListener(new d(ref$LongRef, ref$LongRef2, videoEditAttributeModel, this));
        ((VideoTrimLayout) t1(i10)).d(videoEditAttributeModel);
    }

    public final void c2(long j10, int i10, int i11, Throwable th) {
        SensorPosition changeAvatarPosition;
        long currentTimeMillis = System.currentTimeMillis() - this.f18033u;
        SensorsLogFeed sensorsLogFeed = SensorsLogFeed.f12208a;
        SensorsLogFeed.UploadFileType uploadFileType = SensorsLogFeed.UploadFileType.AVATAR;
        SensorPosition sensorPosition = SensorPosition.EditAvatar;
        boolean z10 = th == null;
        String a10 = com.cupidapp.live.base.network.j.f12008a.a(th);
        String message = a10 == null ? th != null ? th.getMessage() : null : a10;
        ChangeAvatarModel changeAvatarModel = this.f18032t;
        sensorsLogFeed.O(currentTimeMillis, j10, i10, i11, uploadFileType, "视频", sensorPosition, z10, message, (r33 & 512) != 0 ? null : null, (r33 & 1024) != 0 ? null : null, (r33 & 2048) != 0 ? null : (changeAvatarModel == null || (changeAvatarPosition = changeAvatarModel.getChangeAvatarPosition()) == null) ? null : changeAvatarPosition.getValue());
    }

    public final void d2(long j10, int i10, int i11, Throwable th, String str, SensorPosition sensorPosition) {
        long currentTimeMillis = System.currentTimeMillis() - this.f18033u;
        SensorsLogFeed sensorsLogFeed = SensorsLogFeed.f12208a;
        SensorsLogFeed.UploadFileType uploadFileType = SensorsLogFeed.UploadFileType.AVATAR;
        boolean z10 = th == null;
        String a10 = com.cupidapp.live.base.network.j.f12008a.a(th);
        sensorsLogFeed.O(currentTimeMillis, j10, i10, i11, uploadFileType, "视频", sensorPosition, z10, a10 == null ? th != null ? th.getMessage() : null : a10, (r33 & 512) != 0 ? null : str, (r33 & 1024) != 0 ? null : null, (r33 & 2048) != 0 ? null : sensorPosition != null ? sensorPosition.getValue() : null);
    }

    public final void e2(VideoEditAttributeModel videoEditAttributeModel, Long l10, Long l11) {
        long longValue = l10 != null ? l10.longValue() : videoEditAttributeModel.getTrimInMs();
        long longValue2 = l11 != null ? l11.longValue() : videoEditAttributeModel.getTrimOutMs();
        ExoMediaPlayer exoMediaPlayer = ExoMediaPlayer.f12408a;
        exoMediaPlayer.x(new e(longValue, longValue2, this));
        exoMediaPlayer.m();
        ExoMediaPlayer.t(exoMediaPlayer, videoEditAttributeModel.getUriString(), true, null, false, 12, null);
    }

    public final void g2(final String str, final String str2) {
        final File file = new File(str2);
        String path = file.getPath();
        kotlin.jvm.internal.s.h(path, "imageFile.path");
        FKFireBaseDetectorOptionsKt.h(this, path, new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.VideoAvatarCropActivity$uploadCoverImage$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                VideoAvatarCropActivity.this.f18033u = System.currentTimeMillis();
                final long a10 = z0.l.a(file);
                ImageAttributeModel l10 = z0.f.l(VideoAvatarCropActivity.this, str2);
                final int width = l10.getWidth();
                final int height = l10.getHeight();
                Observable<Result<UploadImageFileResult>> f10 = NetworkClient.f11868a.i().f(com.cupidapp.live.base.network.f.a(file), Boolean.valueOf(z10));
                final VideoAvatarCropActivity videoAvatarCropActivity = VideoAvatarCropActivity.this;
                final String str3 = str;
                Disposable disposed = f10.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<UploadImageFileResult, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.VideoAvatarCropActivity$uploadCoverImage$1$invoke$$inlined$handle$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(UploadImageFileResult uploadImageFileResult) {
                        m2798invoke(uploadImageFileResult);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m2798invoke(UploadImageFileResult uploadImageFileResult) {
                        ChangeAvatarModel changeAvatarModel;
                        ChangeAvatarModel changeAvatarModel2;
                        UploadImageFileResult uploadImageFileResult2 = uploadImageFileResult;
                        ProgressBarDialog progressBarDialog = (ProgressBarDialog) VideoAvatarCropActivity.this.t1(R$id.video_crop_progress_bar);
                        if (progressBarDialog != null) {
                            progressBarDialog.setProgress(99);
                        }
                        VideoAvatarCropActivity videoAvatarCropActivity2 = VideoAvatarCropActivity.this;
                        long j10 = a10;
                        int i10 = width;
                        int i11 = height;
                        String imageId = uploadImageFileResult2.getImage().getImageId();
                        changeAvatarModel = VideoAvatarCropActivity.this.f18032t;
                        videoAvatarCropActivity2.d2(j10, i10, i11, null, imageId, changeAvatarModel != null ? changeAvatarModel.getChangeAvatarPosition() : null);
                        VideoAvatarCropActivity videoAvatarCropActivity3 = VideoAvatarCropActivity.this;
                        String str4 = str3;
                        String imageId2 = uploadImageFileResult2.getImage().getImageId();
                        changeAvatarModel2 = VideoAvatarCropActivity.this.f18032t;
                        videoAvatarCropActivity3.L1(str4, imageId2, changeAvatarModel2);
                    }
                }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.setting.activity.VideoAvatarCropActivity$uploadCoverImage$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull Throwable it) {
                        ChangeAvatarModel changeAvatarModel;
                        kotlin.jvm.internal.s.i(it, "it");
                        VideoAvatarCropActivity videoAvatarCropActivity2 = VideoAvatarCropActivity.this;
                        long j10 = a10;
                        int i10 = width;
                        int i11 = height;
                        changeAvatarModel = videoAvatarCropActivity2.f18032t;
                        videoAvatarCropActivity2.d2(j10, i10, i11, it, null, changeAvatarModel != null ? changeAvatarModel.getChangeAvatarPosition() : null);
                        return Boolean.FALSE;
                    }
                }, videoAvatarCropActivity)));
                if (disposed != null) {
                    kotlin.jvm.internal.s.h(disposed, "disposed");
                    if (videoAvatarCropActivity != null) {
                        videoAvatarCropActivity.H(disposed);
                    }
                }
                kotlin.jvm.internal.s.h(disposed, "disposed");
            }
        });
    }

    public final void h2(String str, final String str2, final int i10, final int i11) {
        File file = new File(str);
        final long a10 = z0.l.a(file);
        this.f18033u = System.currentTimeMillis();
        Disposable disposed = NetworkClient.f11868a.i().c(com.cupidapp.live.base.network.f.a(file), i10, i11).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<UploadVideoFileResult, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.VideoAvatarCropActivity$uploadVideo$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(UploadVideoFileResult uploadVideoFileResult) {
                m2799invoke(uploadVideoFileResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2799invoke(UploadVideoFileResult uploadVideoFileResult) {
                UploadVideoFileResult uploadVideoFileResult2 = uploadVideoFileResult;
                VideoAvatarCropActivity.this.c2(a10, i10, i11, null);
                ProgressBarDialog progressBarDialog = (ProgressBarDialog) VideoAvatarCropActivity.this.t1(R$id.video_crop_progress_bar);
                if (progressBarDialog != null) {
                    progressBarDialog.setProgress(98);
                }
                VideoAvatarCropActivity.this.g2(uploadVideoFileResult2.getVideo().getVideoId(), str2);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.setting.activity.VideoAvatarCropActivity$uploadVideo$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                VideoAvatarCropActivity.this.c2(a10, i10, i11, it);
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_video_avatar_crop);
        p0.a(this);
        Intent intent = getIntent();
        kotlin.jvm.internal.s.h(intent, "intent");
        this.f18032t = (ChangeAvatarModel) z0.g.a(intent, ChangeAvatarModel.class);
        W1(getIntent().getStringExtra("URI_STRING"));
        ((BottomConfirmAndCancelLayout) t1(R$id.confirm_and_cancel_layout)).setCancelButtonClickEvent(new Function0<kotlin.p>() { // from class: com.cupidapp.live.setting.activity.VideoAvatarCropActivity$onCreate$1
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
                VideoAvatarCropActivity.this.onBackPressed();
            }
        });
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        VideoTrimUtil.f17238a.g();
        ExoMediaPlayer exoMediaPlayer = ExoMediaPlayer.f12408a;
        exoMediaPlayer.z();
        exoMediaPlayer.u();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        ((FKLoadingLayout) t1(R$id.video_crop_loading_layout)).removeCallbacks(this.f18030r);
    }

    @Nullable
    public View t1(int i10) {
        Map<Integer, View> map = this.f18034v;
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
}
