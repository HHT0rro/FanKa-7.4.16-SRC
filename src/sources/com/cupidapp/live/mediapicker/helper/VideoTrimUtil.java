package com.cupidapp.live.mediapicker.helper;

import android.content.Context;
import android.view.textclassifier.ConversationAction;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.base.utils.q;
import com.cupidapp.live.base.view.h;
import com.huawei.openalliance.ad.constant.u;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.tencent.connect.common.Constants;
import io.microshow.rxffmpeg.RxFFmpegCommandList;
import io.microshow.rxffmpeg.RxFFmpegInvoke;
import io.microshow.rxffmpeg.RxFFmpegProgress;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.Arrays;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.y;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.reactivestreams.Publisher;
import wseemann.media.FFmpegMediaMetadataRetriever;

/* compiled from: VideoTrimUtil.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VideoTrimUtil {

    /* renamed from: a */
    @NotNull
    public static final VideoTrimUtil f17238a = new VideoTrimUtil();

    public static /* synthetic */ Flowable j(VideoTrimUtil videoTrimUtil, Context context, String str, String str2, int i10, int i11, long j10, long j11, VideoCropScene videoCropScene, e eVar, int i12, Object obj) {
        return videoTrimUtil.i(context, str, str2, i10, i11, j10, j11, videoCropScene, (i12 & 256) != 0 ? null : eVar);
    }

    public static final Publisher k(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        return (Publisher) tmp0.invoke(obj);
    }

    public static final VideoInfoData q(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        return (VideoInfoData) tmp0.invoke(obj);
    }

    public final void g() {
        RxFFmpegInvoke.getInstance().exit();
    }

    public final String[] h(String str) {
        return (String[]) StringsKt__StringsKt.z0(str, new String[]{" "}, false, 0, 6, null).toArray(new String[0]);
    }

    @Nullable
    public final Flowable<RxFFmpegProgress> i(@Nullable Context context, @Nullable String str, @Nullable final String str2, final int i10, final int i11, final long j10, final long j11, @NotNull final VideoCropScene cropScene, @Nullable final e eVar) {
        s.i(cropScene, "cropScene");
        final String g3 = q.f12371a.g(context, str);
        if (context != null) {
            if (!(g3 == null || g3.length() == 0)) {
                if (!(str2 == null || str2.length() == 0)) {
                    Flowable subscribeOn = Flowable.just(g3).subscribeOn(Schedulers.io());
                    final Function1<String, Publisher<? extends RxFFmpegProgress>> function1 = new Function1<String, Publisher<? extends RxFFmpegProgress>>() { // from class: com.cupidapp.live.mediapicker.helper.VideoTrimUtil$compileVideo$1

                        /* compiled from: VideoTrimUtil.kt */
                        @kotlin.d
                        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
                        public /* synthetic */ class a {

                            /* renamed from: a, reason: collision with root package name */
                            public static final /* synthetic */ int[] f17239a;

                            static {
                                int[] iArr = new int[VideoCropScene.values().length];
                                try {
                                    iArr[VideoCropScene.FEED.ordinal()] = 1;
                                } catch (NoSuchFieldError unused) {
                                }
                                try {
                                    iArr[VideoCropScene.VIDEO_AVATAR.ordinal()] = 2;
                                } catch (NoSuchFieldError unused2) {
                                }
                                try {
                                    iArr[VideoCropScene.WEB.ordinal()] = 3;
                                } catch (NoSuchFieldError unused3) {
                                }
                                f17239a = iArr;
                            }
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Publisher<? extends RxFFmpegProgress> invoke(@NotNull String it) {
                            int i12;
                            int i13;
                            String m10;
                            String o10;
                            String o11;
                            s.i(it, "it");
                            float max = Math.max(i10, i11);
                            if (max > 1080.0f) {
                                float f10 = 1080.0f / max;
                                i12 = (int) Math.rint(i10 * f10);
                                i13 = (int) Math.rint(i11 * f10);
                            } else {
                                i12 = i10;
                                i13 = i11;
                            }
                            int i14 = i12 - (i12 % 2);
                            int i15 = i13 - (i13 % 2);
                            int i16 = a.f17239a[cropScene.ordinal()];
                            if (i16 == 1) {
                                m10 = VideoTrimUtil.f17238a.m(i14, i15);
                            } else if (i16 == 2) {
                                VideoTrimUtil videoTrimUtil = VideoTrimUtil.f17238a;
                                float f11 = i14;
                                float f12 = i15;
                                e eVar2 = eVar;
                                m10 = videoTrimUtil.l(f11, f12, eVar2 != null ? Float.valueOf(eVar2.a()) : null);
                            } else {
                                if (i16 != 3) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                m10 = VideoTrimUtil.f17238a.n(i14, i15);
                            }
                            RxFFmpegCommandList rxFFmpegCommandList = new RxFFmpegCommandList();
                            String str3 = g3;
                            long j12 = j10;
                            long j13 = j11;
                            String str4 = str2;
                            rxFFmpegCommandList.append("-i");
                            rxFFmpegCommandList.append(str3);
                            rxFFmpegCommandList.append("-ss");
                            VideoTrimUtil videoTrimUtil2 = VideoTrimUtil.f17238a;
                            o10 = videoTrimUtil2.o(j12);
                            rxFFmpegCommandList.append(o10);
                            rxFFmpegCommandList.append("-to");
                            o11 = videoTrimUtil2.o(j13);
                            rxFFmpegCommandList.append(o11);
                            rxFFmpegCommandList.append("-metadata:s:v");
                            rxFFmpegCommandList.append("rotate='0'");
                            rxFFmpegCommandList.append("-strict");
                            rxFFmpegCommandList.append("-2");
                            rxFFmpegCommandList.append("-vf");
                            rxFFmpegCommandList.append("scale=" + i14 + u.bD + i15 + ",crop=" + m10);
                            rxFFmpegCommandList.append("-c:v");
                            rxFFmpegCommandList.append("libx264");
                            rxFFmpegCommandList.append("-crf");
                            rxFFmpegCommandList.append(Constants.VIA_ACT_TYPE_TWENTY_EIGHT);
                            rxFFmpegCommandList.append("-c:a");
                            rxFFmpegCommandList.append(ConversationAction.TYPE_COPY);
                            rxFFmpegCommandList.append(str4);
                            return RxFFmpegInvoke.getInstance().runCommandRxJava(rxFFmpegCommandList.build());
                        }
                    };
                    return subscribeOn.flatMap(new Function() { // from class: com.cupidapp.live.mediapicker.helper.f
                        @Override // io.reactivex.functions.Function
                        public final Object apply(Object obj) {
                            Publisher k10;
                            k10 = VideoTrimUtil.k(Function1.this, obj);
                            return k10;
                        }
                    });
                }
            }
        }
        h.f12779a.s(context, "编译视频出错，请重试");
        return null;
    }

    public final String l(float f10, float f11, Float f12) {
        float f13;
        float f14;
        float f15;
        float f16 = f10 / f11;
        float floatValue = f12 != null ? f12.floatValue() : 0.5f;
        float f17 = 0.0f;
        if (f16 < 0.75f) {
            f15 = f10 / 0.75f;
            f14 = (f11 - f15) * floatValue;
            f13 = f10;
        } else {
            float f18 = 0.75f * f11;
            f17 = (f10 - f18) * floatValue;
            f13 = f18;
            f14 = 0.0f;
            f15 = f11;
        }
        j.f12332a.a("FKFFmpeg", "getCropCmdStrForAvatar  inputWidth:" + f10 + "  inputHeight:" + f11 + "  outputWidth:" + f13 + "  outputHeight:" + f15 + "  leftX:" + f17 + "  leftY:" + f14);
        return ((int) f13) + u.bD + ((int) f15) + u.bD + ((int) f17) + u.bD + ((int) f14);
    }

    public final String m(float f10, float f11) {
        float f12;
        float f13;
        float f14;
        float f15 = f10 / f11;
        float f16 = 0.0f;
        if (f15 < 0.75f) {
            f13 = f10 / 0.75f;
            f14 = (f11 - f13) / 2.0f;
            f12 = f10;
        } else if (f15 > 1.7777778f) {
            float f17 = 1.7777778f * f11;
            f16 = (f10 - f17) / 2.0f;
            f12 = f17;
            f14 = 0.0f;
            f13 = f11;
        } else {
            f12 = f10;
            f13 = f11;
            f14 = 0.0f;
        }
        j.f12332a.a("FKFFmpeg", "getCropCmdStrForFeed  inputWidth:" + f10 + "  inputHeight:" + f11 + "  outputWidth:" + f12 + "  outputHeight:" + f13 + "  leftX:" + f16 + "  leftY:" + f14);
        return ((int) f12) + u.bD + ((int) f13) + u.bD + ((int) f16) + u.bD + ((int) f14);
    }

    public final String n(float f10, float f11) {
        float f12;
        float f13;
        float f14;
        float f15 = f10 / f11;
        float f16 = 0.0f;
        if (f15 < 0.45f) {
            f13 = f10 / 0.45f;
            f14 = (f11 - f13) / 2.0f;
            f12 = f10;
        } else if (f15 > 2.2222223f) {
            float f17 = 2.2222223f * f11;
            f16 = (f10 - f17) / 2.0f;
            f12 = f17;
            f14 = 0.0f;
            f13 = f11;
        } else {
            f12 = f10;
            f13 = f11;
            f14 = 0.0f;
        }
        j.f12332a.a("FKFFmpeg", "getCropCmdStrForWeb  inputWidth:" + f10 + "  inputHeight:" + f11 + "  outputWidth:" + f12 + "  outputHeight:" + f13 + "  leftX:" + f16 + "  leftY:" + f14);
        return ((int) f12) + u.bD + ((int) f13) + u.bD + ((int) f16) + u.bD + ((int) f14);
    }

    public final String o(long j10) {
        long j11 = 1000;
        long j12 = j10 / j11;
        long j13 = 60;
        int i10 = (int) (j10 % j11);
        y yVar = y.f51038a;
        String format = String.format("%02d:%02d:%02d.%03d", Arrays.copyOf(new Object[]{Integer.valueOf((int) (j12 / SdkConfigData.DEFAULT_REQUEST_INTERVAL)), Integer.valueOf((int) ((j12 / j13) % j13)), Integer.valueOf((int) (j12 % j13)), Integer.valueOf(i10)}, 4));
        s.h(format, "format(format, *args)");
        j.f12332a.a("FKFFmpeg", "getFFmpegMs inputTimeMs:" + j10 + "  outTime:" + format);
        return format;
    }

    @Nullable
    public final Flowable<VideoInfoData> p(@Nullable Context context, @Nullable String str) {
        final String g3 = q.f12371a.g(context, str);
        if (g3 == null || g3.length() == 0) {
            return null;
        }
        Flowable onBackpressureLatest = Flowable.just(g3).onBackpressureLatest();
        final Function1<String, VideoInfoData> function1 = new Function1<String, VideoInfoData>() { // from class: com.cupidapp.live.mediapicker.helper.VideoTrimUtil$getVideoInfoData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final VideoInfoData invoke(@NotNull String it) {
                int i10;
                int i11;
                s.i(it, "it");
                FFmpegMediaMetadataRetriever fFmpegMediaMetadataRetriever = new FFmpegMediaMetadataRetriever();
                fFmpegMediaMetadataRetriever.setDataSource(String.this);
                String extractMetadata = fFmpegMediaMetadataRetriever.extractMetadata(FFmpegMediaMetadataRetriever.METADATA_KEY_VIDEO_WIDTH);
                s.h(extractMetadata, "mmr.extractMetadata(\n   …O_WIDTH\n                )");
                int parseInt = Integer.parseInt(extractMetadata);
                String extractMetadata2 = fFmpegMediaMetadataRetriever.extractMetadata(FFmpegMediaMetadataRetriever.METADATA_KEY_VIDEO_HEIGHT);
                s.h(extractMetadata2, "mmr.extractMetadata(\n   …_HEIGHT\n                )");
                int parseInt2 = Integer.parseInt(extractMetadata2);
                String extractMetadata3 = fFmpegMediaMetadataRetriever.extractMetadata("duration");
                s.h(extractMetadata3, "mmr.extractMetadata(\n   …URATION\n                )");
                long parseLong = Long.parseLong(extractMetadata3);
                String extractMetadata4 = fFmpegMediaMetadataRetriever.extractMetadata(FFmpegMediaMetadataRetriever.METADATA_KEY_VIDEO_ROTATION);
                s.h(extractMetadata4, "mmr.extractMetadata(\n   …OTATION\n                )");
                int parseInt3 = Integer.parseInt(extractMetadata4);
                fFmpegMediaMetadataRetriever.release();
                if (parseInt3 == 90 || parseInt3 == 270) {
                    i10 = parseInt;
                    i11 = parseInt2;
                } else {
                    i11 = parseInt;
                    i10 = parseInt2;
                }
                return new VideoInfoData(i11, i10, parseLong, parseInt3);
            }
        };
        return onBackpressureLatest.map(new Function() { // from class: com.cupidapp.live.mediapicker.helper.g
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                VideoInfoData q10;
                q10 = VideoTrimUtil.q(Function1.this, obj);
                return q10;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public final void r(@Nullable Context context, @Nullable String str, @Nullable String str2, long j10) {
        String g3 = q.f12371a.g(context, str);
        if (context != null) {
            if (!(g3 == null || g3.length() == 0)) {
                if (!(str2 == null || str2.length() == 0)) {
                    RxFFmpegInvoke.getInstance().runFFmpegCmd(h("ffmpeg -y -ss " + o(j10) + " -i " + g3 + " -vframes 1 " + str2));
                    return;
                }
            }
        }
        h.f12779a.s(context, "获取视频帧图片出错，请重试");
    }
}
