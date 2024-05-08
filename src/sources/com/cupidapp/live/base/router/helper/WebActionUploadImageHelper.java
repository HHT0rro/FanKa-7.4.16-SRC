package com.cupidapp.live.base.router.helper;

import android.net.Uri;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.extension.ImageAttributeModel;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.gson.GsonUtil;
import com.cupidapp.live.base.network.j;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.ImageVariant;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.network.model.UploadImageFileResult;
import com.cupidapp.live.base.network.model.UploadVideoFileResult;
import com.cupidapp.live.base.permission.FKRxPermissionAlertDialog;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.base.utils.ImageResizeUtils;
import com.cupidapp.live.base.view.FKAlertLayout;
import com.cupidapp.live.base.web.FKWebView;
import com.cupidapp.live.base.web.fragment.FKWebViewFragment;
import com.cupidapp.live.mediapicker.helper.FKFireBaseDetectorOptionsKt;
import com.cupidapp.live.mediapicker.helper.VideoCropScene;
import com.cupidapp.live.mediapicker.helper.VideoInfoData;
import com.cupidapp.live.mediapicker.helper.VideoTrimUtil;
import com.cupidapp.live.mediapicker.model.CameraStartPosition;
import com.cupidapp.live.mediapicker.model.UploadVideoModel;
import com.cupidapp.live.mediapicker.model.VideoContentModel;
import com.cupidapp.live.mediapicker.model.VideoEditAttributeModel;
import com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment;
import com.cupidapp.live.mediapicker.newmediapicker.model.LocalMedia;
import com.cupidapp.live.mediapicker.newmediapicker.model.MediaType;
import com.cupidapp.live.mediapicker.newmediapicker.model.MimeType;
import com.huawei.appgallery.agd.pageframe.api.CardConstants;
import com.huawei.quickcard.base.Attributes;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.r;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.k;
import z0.l;
import z0.v;

/* compiled from: WebActionUploadImageHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class WebActionUploadImageHelper {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public String f12132a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public MediaPickerFragment f12133b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public WeakReference<FragmentActivity> f12134c;

    /* renamed from: d, reason: collision with root package name */
    public long f12135d;

    /* compiled from: WebActionUploadImageHelper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a extends com.cupidapp.live.mediapicker.helper.a {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f12137c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f12138d;

        public a(FragmentActivity fragmentActivity, String str) {
            this.f12137c = fragmentActivity;
            this.f12138d = str;
        }

        @Override // com.cupidapp.live.mediapicker.helper.a, io.microshow.rxffmpeg.RxFFmpegInvoke.IFFmpegListener
        public void onError(@NotNull String message) {
            s.i(message, "message");
            super.onError(message);
            WebActionUploadImageHelper.this.z(this.f12137c);
            com.cupidapp.live.base.view.h.f12779a.m(this.f12137c, message);
        }

        @Override // com.cupidapp.live.mediapicker.helper.a, io.microshow.rxffmpeg.RxFFmpegInvoke.IFFmpegListener
        public void onFinish() {
            super.onFinish();
            WebActionUploadImageHelper.this.t(this.f12137c, this.f12138d);
        }
    }

    /* compiled from: WebActionUploadImageHelper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements MediaPickerFragment.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f12140b;

        public b(FragmentActivity fragmentActivity) {
            this.f12140b = fragmentActivity;
        }

        @Override // com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment.b
        public void a() {
            WebActionUploadImageHelper.this.r(this.f12140b);
        }

        @Override // com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment.b
        public void b(int i10) {
            MediaPickerFragment.b.a.e(this, i10);
        }

        @Override // com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment.b
        public void c(@NotNull List<String> list) {
            MediaPickerFragment.b.a.a(this, list);
        }

        @Override // com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment.b
        public void d(long j10, int i10, int i11) {
            MediaPickerFragment.b.a.d(this, j10, i10, i11);
        }

        @Override // com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment.b
        public void e(@NotNull LocalMedia media, int i10) {
            s.i(media, "media");
            WebActionUploadImageHelper.this.C(this.f12140b, media.d(), media.c());
        }

        @Override // com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment.b
        public void f() {
            MediaPickerFragment.b.a.b(this);
        }
    }

    public static final void u(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void v(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void x(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void y(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void A(final FragmentActivity fragmentActivity, final String str) {
        F(fragmentActivity);
        ImageResizeUtils.f12268a.m(fragmentActivity, null, r.e(str), new Function1<Map<String, String>, p>() { // from class: com.cupidapp.live.base.router.helper.WebActionUploadImageHelper$imageCompress$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Map<String, String> map) {
                invoke2(map);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Map<String, String> map) {
                String str2 = map != null ? map.get(String.this) : null;
                if (!(map == null || map.isEmpty())) {
                    if (!(str2 == null || str2.length() == 0)) {
                        this.q(fragmentActivity, str2);
                        return;
                    }
                }
                this.z(fragmentActivity);
            }
        }, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? null : null);
    }

    public final void B(FragmentActivity fragmentActivity) {
        this.f12133b = MediaPickerFragment.f17279p.b(new MediaPickerFragment.Config(MediaType.ALL, true, false, false, false, CameraStartPosition.Web, SensorPosition.Web, null, 156, null), new b(fragmentActivity));
        FragmentTransaction addToBackStack = fragmentActivity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R$anim.anim_activity_bottom_to_top, R$anim.anim_activity_top_to_bottom).addToBackStack(null);
        MediaPickerFragment mediaPickerFragment = this.f12133b;
        s.f(mediaPickerFragment);
        addToBackStack.replace(16908290, mediaPickerFragment).commit();
    }

    public final void C(FragmentActivity fragmentActivity, String str, String str2) {
        if (str == null || str.length() == 0) {
            return;
        }
        j1.g.b(j1.g.f50233a, str2, SensorPosition.Web, 1, null, 8, null);
        if (MimeType.Companion.a(str2)) {
            A(fragmentActivity, str);
        } else {
            w(fragmentActivity, str);
        }
    }

    public final void D(long j10, int i10, int i11, String str, Throwable th) {
        String str2;
        long currentTimeMillis = System.currentTimeMillis() - this.f12135d;
        SensorsLogFeed sensorsLogFeed = SensorsLogFeed.f12208a;
        SensorsLogFeed.UploadFileType uploadFileType = SensorsLogFeed.UploadFileType.WEB;
        SensorPosition sensorPosition = SensorPosition.Web;
        boolean z10 = th == null;
        String a10 = j.f12008a.a(th);
        if (a10 == null) {
            str2 = th != null ? th.getMessage() : null;
        } else {
            str2 = a10;
        }
        sensorsLogFeed.O(currentTimeMillis, j10, i10, i11, uploadFileType, str, sensorPosition, z10, str2, (r33 & 512) != 0 ? null : null, (r33 & 1024) != 0 ? null : null, (r33 & 2048) != 0 ? null : null);
    }

    public final void E(@NotNull final FragmentActivity activity, @NotNull final Uri uri) {
        s.i(activity, "activity");
        s.i(uri, "uri");
        this.f12134c = new WeakReference<>(activity);
        FKRxPermissionAlertDialog.f12016a.m(activity, new xb.b(activity), (r16 & 4) != 0 ? null : new Function0<p>() { // from class: com.cupidapp.live.base.router.helper.WebActionUploadImageHelper$requestPermission$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                WebActionUploadImageHelper.this.f12132a = uri.getQueryParameter("callback");
                WebActionUploadImageHelper.this.B(activity);
            }
        }, (r16 & 8) != 0 ? null : null, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? R$string.need_access_media_upload_better : 0);
    }

    public final void F(FragmentActivity fragmentActivity) {
        FKAlertLayout.a aVar = FKAlertLayout.f12456d;
        Window window = fragmentActivity.getWindow();
        s.h(window, "activity.window");
        aVar.b(window).e();
    }

    public final void G(FragmentActivity fragmentActivity, String str, boolean z10, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(CardConstants.KEY_MEDIA_ID, str);
        hashMap.put("mediaType", z10 ? "video" : Attributes.Component.IMAGE);
        if (str2 != null) {
            hashMap.put("mediaPath", str2);
        }
        String json = GsonUtil.f12000a.b().toJson(hashMap);
        FKWebView c4 = FKWebViewFragment.f13075p.c(fragmentActivity);
        if (c4 != null) {
            c4.evaluateJavascript(this.f12132a + "(" + json + ")", null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void H(final FragmentActivity fragmentActivity, String str, boolean z10) {
        File file = new File(str);
        this.f12135d = System.currentTimeMillis();
        final long a10 = l.a(file);
        ImageAttributeModel l10 = z0.f.l(fragmentActivity, str);
        final int width = l10.getWidth();
        final int height = l10.getHeight();
        Observable<Result<UploadImageFileResult>> f10 = NetworkClient.f11868a.i().f(com.cupidapp.live.base.network.f.a(file), Boolean.valueOf(z10));
        Function1<Throwable, Boolean> function1 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.base.router.helper.WebActionUploadImageHelper$uploadImage$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                WebActionUploadImageHelper.this.D(a10, width, height, "图片", it);
                WebActionUploadImageHelper.this.z(fragmentActivity);
                return Boolean.FALSE;
            }
        };
        com.cupidapp.live.base.network.g gVar = fragmentActivity instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) fragmentActivity : null;
        Disposable disposed = f10.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<UploadImageFileResult, p>() { // from class: com.cupidapp.live.base.router.helper.WebActionUploadImageHelper$uploadImage$$inlined$handleByContext$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(UploadImageFileResult uploadImageFileResult) {
                m2465invoke(uploadImageFileResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2465invoke(UploadImageFileResult uploadImageFileResult) {
                ImageVariant imageVariant;
                UploadImageFileResult uploadImageFileResult2 = uploadImageFileResult;
                List<ImageVariant> variants = uploadImageFileResult2.getImage().getVariants();
                WebActionUploadImageHelper.this.G(fragmentActivity, uploadImageFileResult2.getImage().getImageId(), false, (variants == null || (imageVariant = (ImageVariant) CollectionsKt___CollectionsKt.W(variants, 0)) == null) ? null : imageVariant.getUrl());
                WebActionUploadImageHelper.this.D(a10, width, height, "图片", null);
                WebActionUploadImageHelper.this.z(fragmentActivity);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(function1, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        s.h(disposed, "disposed");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void I(final VideoContentModel videoContentModel) {
        WeakReference<FragmentActivity> weakReference;
        final FragmentActivity fragmentActivity;
        UploadVideoModel uploadVideo;
        String localPath = (videoContentModel == null || (uploadVideo = videoContentModel.getUploadVideo()) == null) ? null : uploadVideo.getLocalPath();
        if ((localPath == null || localPath.length() == 0) || (weakReference = this.f12134c) == null || (fragmentActivity = weakReference.get()) == 0) {
            return;
        }
        r(fragmentActivity);
        F(fragmentActivity);
        File file = new File(localPath);
        this.f12135d = System.currentTimeMillis();
        final long a10 = l.a(file);
        Observable<Result<UploadVideoFileResult>> c4 = NetworkClient.f11868a.i().c(com.cupidapp.live.base.network.f.a(file), videoContentModel.getWidth(), videoContentModel.getHeight());
        Function1<Throwable, Boolean> function1 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.base.router.helper.WebActionUploadImageHelper$uploadVideo$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                WebActionUploadImageHelper.this.D(a10, videoContentModel.getWidth(), videoContentModel.getHeight(), "视频", it);
                WebActionUploadImageHelper.this.z(fragmentActivity);
                return Boolean.FALSE;
            }
        };
        com.cupidapp.live.base.network.g gVar = fragmentActivity instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) fragmentActivity : null;
        Disposable disposed = c4.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<UploadVideoFileResult, p>() { // from class: com.cupidapp.live.base.router.helper.WebActionUploadImageHelper$uploadVideo$$inlined$handleByContext$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(UploadVideoFileResult uploadVideoFileResult) {
                m2466invoke(uploadVideoFileResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2466invoke(UploadVideoFileResult uploadVideoFileResult) {
                UploadVideoFileResult uploadVideoFileResult2 = uploadVideoFileResult;
                WebActionUploadImageHelper.this.G(fragmentActivity, uploadVideoFileResult2.getVideo().getVideoId(), true, uploadVideoFileResult2.getVideo().getUrl());
                WebActionUploadImageHelper.this.D(a10, videoContentModel.getWidth(), videoContentModel.getHeight(), "视频", null);
                WebActionUploadImageHelper.this.z(fragmentActivity);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(function1, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        s.h(disposed, "disposed");
    }

    public final void q(final FragmentActivity fragmentActivity, final String str) {
        r(fragmentActivity);
        FKFireBaseDetectorOptionsKt.h(fragmentActivity, str, new Function1<Boolean, p>() { // from class: com.cupidapp.live.base.router.helper.WebActionUploadImageHelper$checkImageHasFace$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return p.f51048a;
            }

            public final void invoke(boolean z10) {
                WebActionUploadImageHelper.this.H(fragmentActivity, str, z10);
            }
        });
    }

    public final void r(FragmentActivity fragmentActivity) {
        MediaPickerFragment mediaPickerFragment = this.f12133b;
        if (mediaPickerFragment != null && mediaPickerFragment.isAdded()) {
            FragmentTransaction beginTransaction = fragmentActivity.getSupportFragmentManager().beginTransaction();
            MediaPickerFragment mediaPickerFragment2 = this.f12133b;
            s.f(mediaPickerFragment2);
            beginTransaction.remove(mediaPickerFragment2).commit();
        }
    }

    public final void s(FragmentActivity fragmentActivity, VideoEditAttributeModel videoEditAttributeModel) {
        Flowable i10;
        Flowable observeOn;
        File j10 = k.f54819a.j(fragmentActivity, System.currentTimeMillis() + "_web_after_compile.mp4");
        String absolutePath = j10 != null ? j10.getAbsolutePath() : null;
        if (absolutePath == null || absolutePath.length() == 0) {
            z(fragmentActivity);
            com.cupidapp.live.base.view.h.f12779a.s(fragmentActivity, "创建编译的视频文件失败");
            return;
        }
        i10 = VideoTrimUtil.f17238a.i(fragmentActivity, videoEditAttributeModel.getUriString(), absolutePath, videoEditAttributeModel.getWidth(), videoEditAttributeModel.getHeight(), videoEditAttributeModel.getTrimInMs(), videoEditAttributeModel.getTrimOutMs(), VideoCropScene.WEB, (r25 & 256) != 0 ? null : null);
        if (i10 == null || (observeOn = i10.observeOn(AndroidSchedulers.mainThread())) == null) {
            return;
        }
        observeOn.subscribe((FlowableSubscriber) new a(fragmentActivity, absolutePath));
    }

    public final void t(final FragmentActivity fragmentActivity, final String str) {
        Flowable<VideoInfoData> p10 = VideoTrimUtil.f17238a.p(fragmentActivity, str);
        if (p10 != null) {
            final Function1<VideoInfoData, p> function1 = new Function1<VideoInfoData, p>() { // from class: com.cupidapp.live.base.router.helper.WebActionUploadImageHelper$getUploadVideoInfoData$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(VideoInfoData videoInfoData) {
                    invoke2(videoInfoData);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(VideoInfoData videoInfoData) {
                    this.I(new VideoContentModel(new UploadVideoModel(null, String.this, 1, null), null, null, videoInfoData.getWidth(), videoInfoData.getHeight(), 6, null));
                }
            };
            Consumer<? super VideoInfoData> consumer = new Consumer() { // from class: com.cupidapp.live.base.router.helper.h
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    WebActionUploadImageHelper.u(Function1.this, obj);
                }
            };
            final Function1<Throwable, p> function12 = new Function1<Throwable, p>() { // from class: com.cupidapp.live.base.router.helper.WebActionUploadImageHelper$getUploadVideoInfoData$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Throwable th) {
                    invoke2(th);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    WebActionUploadImageHelper.this.z(fragmentActivity);
                    com.cupidapp.live.base.view.h.f12779a.t("获取编译成功后的视频基础信息失败");
                }
            };
            Disposable subscribe = p10.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.base.router.helper.g
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    WebActionUploadImageHelper.v(Function1.this, obj);
                }
            });
            if (subscribe == null || !(fragmentActivity instanceof FKBaseActivity)) {
                return;
            }
            ((FKBaseActivity) fragmentActivity).H(subscribe);
        }
    }

    public final void w(final FragmentActivity fragmentActivity, final String str) {
        F(fragmentActivity);
        Flowable<VideoInfoData> p10 = VideoTrimUtil.f17238a.p(fragmentActivity, str);
        if (p10 != null) {
            final Function1<VideoInfoData, p> function1 = new Function1<VideoInfoData, p>() { // from class: com.cupidapp.live.base.router.helper.WebActionUploadImageHelper$getVideoInfoData$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(VideoInfoData videoInfoData) {
                    invoke2(videoInfoData);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(VideoInfoData videoInfoData) {
                    ConstantsResult q10 = p1.g.f52734a.q();
                    long r10 = v.r(q10 != null ? q10.getVideoMaxSeconds() : 60);
                    this.s(fragmentActivity, new VideoEditAttributeModel(String.this, videoInfoData.getWidth(), videoInfoData.getHeight(), videoInfoData.getDuration(), videoInfoData.getRotation(), r10, 0L, 0L, Math.min(videoInfoData.getDuration(), r10), 192, null));
                }
            };
            Consumer<? super VideoInfoData> consumer = new Consumer() { // from class: com.cupidapp.live.base.router.helper.i
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    WebActionUploadImageHelper.x(Function1.this, obj);
                }
            };
            final Function1<Throwable, p> function12 = new Function1<Throwable, p>() { // from class: com.cupidapp.live.base.router.helper.WebActionUploadImageHelper$getVideoInfoData$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Throwable th) {
                    invoke2(th);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    WebActionUploadImageHelper.this.z(fragmentActivity);
                    com.cupidapp.live.base.view.h.f12779a.s(fragmentActivity, "获取视频基础信息失败");
                }
            };
            Disposable subscribe = p10.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.base.router.helper.f
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    WebActionUploadImageHelper.y(Function1.this, obj);
                }
            });
            if (subscribe == null || !(fragmentActivity instanceof FKBaseActivity)) {
                return;
            }
            ((FKBaseActivity) fragmentActivity).H(subscribe);
        }
    }

    public final void z(FragmentActivity fragmentActivity) {
        FKAlertLayout.f12456d.d(fragmentActivity.getWindow());
    }
}
