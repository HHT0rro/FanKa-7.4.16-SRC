package com.cupidapp.live.mediapicker.model;

import android.content.Context;
import com.cupidapp.live.appdialog.layout.FKAppRatingLayout;
import com.cupidapp.live.appdialog.model.AppDialogModel;
import com.cupidapp.live.appdialog.model.GuideOpenPushDialogModel;
import com.cupidapp.live.appdialog.model.WindowType;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.UploadVideoFileResult;
import com.cupidapp.live.base.network.model.VideoModel;
import com.cupidapp.live.hashtag.model.HashTagSimpleModel;
import com.cupidapp.live.main.event.ShowGuideOpenPushDialogAfterPublishFeedEvent;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.l;

/* compiled from: VideoPublishViewViewModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VideoPublishViewViewModel extends PublishViewModel {
    public VideoContentModel videoContent;

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkUploadStatus(Context context) {
        if (getVideoContent().getFirstFrameImage() != null) {
            UploadImageModel firstFrameImage = getVideoContent().getFirstFrameImage();
            if ((firstFrameImage != null ? firstFrameImage.getImage() : null) == null) {
                UploadImageModel firstFrameImage2 = getVideoContent().getFirstFrameImage();
                s.f(firstFrameImage2);
                uploadImage(context, firstFrameImage2);
                return;
            }
        }
        if (getVideoContent().getCoverImage() != null) {
            UploadImageModel coverImage = getVideoContent().getCoverImage();
            if ((coverImage != null ? coverImage.getImage() : null) == null) {
                UploadImageModel coverImage2 = getVideoContent().getCoverImage();
                s.f(coverImage2);
                uploadImage(context, coverImage2);
                return;
            }
        }
        if (getVideoContent().getUploadVideo().getVideo() == null) {
            uploadVideo(context);
        } else {
            publishVideo(context);
        }
    }

    private final void publishVideo(Context context) {
        f3.a E = NetworkClient.f11868a.E();
        UploadImageModel coverImage = getVideoContent().getCoverImage();
        ImageModel image = coverImage != null ? coverImage.getImage() : null;
        s.f(image);
        String imageId = image.getImageId();
        VideoModel video = getVideoContent().getUploadVideo().getVideo();
        s.f(video);
        String videoId = video.getVideoId();
        UploadImageModel firstFrameImage = getVideoContent().getFirstFrameImage();
        ImageModel image2 = firstFrameImage != null ? firstFrameImage.getImage() : null;
        s.f(image2);
        String imageId2 = image2.getImageId();
        String title = getVideoContent().getTitle();
        String description = getVideoContent().getDescription();
        Location location = getVideoContent().getLocation();
        String id2 = location != null ? location.getId() : null;
        HashTagSimpleModel hashTag = getVideoContent().getHashTag();
        String itemId = hashTag != null ? hashTag.getItemId() : null;
        String replaceAtListStr = getVideoContent().getReplaceAtListStr();
        boolean closeFriendOnly = getVideoContent().getCloseFriendOnly();
        Location location2 = getVideoContent().getLocation();
        String address = location2 != null ? location2.getAddress() : null;
        Location location3 = getVideoContent().getLocation();
        String name = location3 != null ? location3.getName() : null;
        Location location4 = getVideoContent().getLocation();
        Double latitude = location4 != null ? location4.getLatitude() : null;
        Location location5 = getVideoContent().getLocation();
        Double longitude = location5 != null ? location5.getLongitude() : null;
        Location location6 = getVideoContent().getLocation();
        Observable<R> flatMap = E.b(imageId, videoId, imageId2, title, description, id2, itemId, replaceAtListStr, closeFriendOnly, address, name, latitude, longitude, location6 != null ? location6.getCityname() : null, getVideoContent().getWebTitle()).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).flatMap(new com.cupidapp.live.base.network.i());
        final Function1<VideoResult<? extends UserVideoListModel>, p> function1 = new Function1<VideoResult<? extends UserVideoListModel>, p>() { // from class: com.cupidapp.live.mediapicker.model.VideoPublishViewViewModel$publishVideo$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(VideoResult<? extends UserVideoListModel> videoResult) {
                invoke2((VideoResult<UserVideoListModel>) videoResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(VideoResult<UserVideoListModel> videoResult) {
                AppDialogModel appDialogModel;
                FeedItemModel feedItemModel;
                AppDialogModel appDialogModel2;
                FKAppRatingLayout.f11658f.c(videoResult.getWindows());
                List<AppDialogModel> windows = videoResult.getWindows();
                String str = null;
                if (windows != null) {
                    Iterator<AppDialogModel> iterator2 = windows.iterator2();
                    while (true) {
                        if (!iterator2.hasNext()) {
                            appDialogModel2 = null;
                            break;
                        } else {
                            appDialogModel2 = iterator2.next();
                            if (s.d(appDialogModel2.getWindowType(), WindowType.PushPriWindow.getType())) {
                                break;
                            }
                        }
                    }
                    appDialogModel = appDialogModel2;
                } else {
                    appDialogModel = null;
                }
                if (appDialogModel != null && (appDialogModel instanceof GuideOpenPushDialogModel)) {
                    EventBus.c().o(new ShowGuideOpenPushDialogAfterPublishFeedEvent((GuideOpenPushDialogModel) appDialogModel));
                }
                VideoPublishViewViewModel videoPublishViewViewModel = VideoPublishViewViewModel.this;
                VideoContentModel videoContent = videoPublishViewViewModel.getVideoContent();
                List<FeedItemModel> videoList = videoResult.getVideo().getVideoList();
                if (videoList != null && (feedItemModel = videoList.get(0)) != null) {
                    str = feedItemModel.getPostId();
                }
                videoPublishViewViewModel.publishSuccess(videoContent, str, "视频", 1, null, videoResult.getPostBoost(), videoResult.getUrl());
            }
        };
        Consumer consumer = new Consumer() { // from class: com.cupidapp.live.mediapicker.model.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VideoPublishViewViewModel.publishVideo$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, p> function12 = new Function1<Throwable, p>() { // from class: com.cupidapp.live.mediapicker.model.VideoPublishViewViewModel$publishVideo$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Throwable th) {
                invoke2(th);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable t2) {
                VideoPublishViewViewModel videoPublishViewViewModel = VideoPublishViewViewModel.this;
                VideoContentModel videoContent = videoPublishViewViewModel.getVideoContent();
                s.h(t2, "t");
                videoPublishViewViewModel.publishError(videoContent, "视频", 1, null, t2);
            }
        };
        flatMap.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.mediapicker.model.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VideoPublishViewViewModel.publishVideo$lambda$1(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void publishVideo$lambda$0(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void publishVideo$lambda$1(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void uploadImage(Context context, UploadImageModel uploadImageModel) {
        super.fileUploadImage(context, uploadImageModel, getVideoContent().getPublishPosition(), getVideoContent().getWebTitle(), new Function1<Throwable, p>() { // from class: com.cupidapp.live.mediapicker.model.VideoPublishViewViewModel$uploadImage$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Throwable th) {
                invoke2(th);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Throwable exception) {
                s.i(exception, "exception");
                VideoPublishViewViewModel videoPublishViewViewModel = VideoPublishViewViewModel.this;
                videoPublishViewViewModel.publishError(videoPublishViewViewModel.getVideoContent(), "视频", 1, null, exception);
            }
        });
    }

    private final void uploadVideo(final Context context) {
        String localPath = getVideoContent().getUploadVideo().getLocalPath();
        if (localPath == null) {
            return;
        }
        File file = new File(localPath);
        setUploadStartTime(System.currentTimeMillis());
        final long a10 = l.a(file);
        final int width = getVideoContent().getWidth();
        final int height = getVideoContent().getHeight();
        Observable<R> flatMap = NetworkClient.f11868a.i().c(com.cupidapp.live.base.network.f.a(file), getVideoContent().getWidth(), getVideoContent().getHeight()).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).flatMap(new com.cupidapp.live.base.network.i());
        final Function1<UploadVideoFileResult, p> function1 = new Function1<UploadVideoFileResult, p>() { // from class: com.cupidapp.live.mediapicker.model.VideoPublishViewViewModel$uploadVideo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(UploadVideoFileResult uploadVideoFileResult) {
                invoke2(uploadVideoFileResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UploadVideoFileResult uploadVideoFileResult) {
                VideoPublishViewViewModel.this.getVideoContent().getUploadVideo().setVideo(uploadVideoFileResult.getVideo());
                VideoPublishViewViewModel videoPublishViewViewModel = VideoPublishViewViewModel.this;
                videoPublishViewViewModel.uploadFilesSensorLog(a10, width, height, "视频", videoPublishViewViewModel.getVideoContent().getPublishPosition(), null, VideoPublishViewViewModel.this.getVideoContent().getWebTitle());
                VideoPublishViewViewModel.this.checkUploadStatus(context);
            }
        };
        Consumer consumer = new Consumer() { // from class: com.cupidapp.live.mediapicker.model.h
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VideoPublishViewViewModel.uploadVideo$lambda$2(Function1.this, obj);
            }
        };
        final Function1<Throwable, p> function12 = new Function1<Throwable, p>() { // from class: com.cupidapp.live.mediapicker.model.VideoPublishViewViewModel$uploadVideo$2
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
            public final void invoke2(Throwable t2) {
                VideoPublishViewViewModel videoPublishViewViewModel = VideoPublishViewViewModel.this;
                VideoContentModel videoContent = videoPublishViewViewModel.getVideoContent();
                s.h(t2, "t");
                videoPublishViewViewModel.publishError(videoContent, "视频", 1, null, t2);
                VideoPublishViewViewModel videoPublishViewViewModel2 = VideoPublishViewViewModel.this;
                videoPublishViewViewModel2.uploadFilesSensorLog(a10, width, height, "视频", videoPublishViewViewModel2.getVideoContent().getPublishPosition(), t2, VideoPublishViewViewModel.this.getVideoContent().getWebTitle());
            }
        };
        flatMap.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.mediapicker.model.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VideoPublishViewViewModel.uploadVideo$lambda$3(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uploadVideo$lambda$2(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uploadVideo$lambda$3(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @NotNull
    public final VideoContentModel getVideoContent() {
        VideoContentModel videoContentModel = this.videoContent;
        if (videoContentModel != null) {
            return videoContentModel;
        }
        s.A("videoContent");
        return null;
    }

    @Override // com.cupidapp.live.mediapicker.model.PublishViewModel
    public void imageUploadSuccess(@NotNull Context context, @NotNull UploadImageModel image, @NotNull ImageModel resultImage) {
        UploadImageModel coverImage;
        UploadImageModel firstFrameImage;
        s.i(context, "context");
        s.i(image, "image");
        s.i(resultImage, "resultImage");
        if (s.d(getVideoContent().getFirstFrameImage(), image) && (firstFrameImage = getVideoContent().getFirstFrameImage()) != null) {
            firstFrameImage.setImage(resultImage);
        }
        if (s.d(getVideoContent().getCoverImage(), image) && (coverImage = getVideoContent().getCoverImage()) != null) {
            coverImage.setImage(resultImage);
        }
        checkUploadStatus(context);
    }

    public final void setVideoContent(@NotNull VideoContentModel videoContentModel) {
        s.i(videoContentModel, "<set-?>");
        this.videoContent = videoContentModel;
    }

    @Override // com.cupidapp.live.mediapicker.model.PublishViewModel
    public void startPublish(@NotNull Context context, @NotNull Function1<? super PublishViewModel, p> success, @NotNull Function2<? super Throwable, ? super PublishViewModel, p> error) {
        s.i(context, "context");
        s.i(success, "success");
        s.i(error, "error");
        super.startPublish(context, success, error);
        checkUploadStatus(context);
    }

    @Override // com.cupidapp.live.mediapicker.model.PublishViewModel
    public void updateImageUpload(float f10) {
        setProgress(Math.max(f10, getProgress()));
    }

    @Override // com.cupidapp.live.mediapicker.model.PublishViewModel
    @Nullable
    public String uploadCoverImage() {
        UploadImageModel coverImage = getVideoContent().getCoverImage();
        if (coverImage != null) {
            return coverImage.getLocalPath();
        }
        return null;
    }
}
