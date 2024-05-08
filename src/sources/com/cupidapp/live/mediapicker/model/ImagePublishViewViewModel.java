package com.cupidapp.live.mediapicker.model;

import android.content.Context;
import com.cupidapp.live.appdialog.layout.FKAppRatingLayout;
import com.cupidapp.live.appdialog.model.AppDialogModel;
import com.cupidapp.live.appdialog.model.GuideOpenPushDialogModel;
import com.cupidapp.live.appdialog.model.WindowType;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.hashtag.model.HashTagSimpleModel;
import com.cupidapp.live.main.event.ShowGuideOpenPushDialogAfterPublishFeedEvent;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.t;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ImagePublishViewViewModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ImagePublishViewViewModel extends PublishViewModel {
    public ImageContentModel imageContent;

    private final void checkUploadStatus(Context context) {
        int i10;
        UploadImageModel uploadImageModel;
        Iterator<UploadImageModel> iterator2 = getImageContent().getUploadImageList().iterator2();
        while (true) {
            i10 = 0;
            if (!iterator2.hasNext()) {
                uploadImageModel = null;
                break;
            } else {
                uploadImageModel = iterator2.next();
                if (uploadImageModel.getImage() == null) {
                    break;
                }
            }
        }
        UploadImageModel uploadImageModel2 = uploadImageModel;
        Iterator<UploadImageModel> iterator22 = getImageContent().getUploadImageList().iterator2();
        while (true) {
            if (!iterator22.hasNext()) {
                i10 = -1;
                break;
            } else if (s.d(iterator22.next(), uploadImageModel2)) {
                break;
            } else {
                i10++;
            }
        }
        final int size = getImageContent().getUploadImageList().size();
        final String str = size > 1 ? "多图" : "图片";
        if (i10 >= 0) {
            updateImageUpload(i10 / size);
        }
        if (uploadImageModel2 != null) {
            super.fileUploadImage(context, uploadImageModel2, getImageContent().getPublishPosition(), getImageContent().getWebTitle(), new Function1<Throwable, p>() { // from class: com.cupidapp.live.mediapicker.model.ImagePublishViewViewModel$checkUploadStatus$1
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
                public final void invoke2(@NotNull Throwable exception) {
                    s.i(exception, "exception");
                    ImagePublishViewViewModel imagePublishViewViewModel = ImagePublishViewViewModel.this;
                    ImageContentModel imageContent = imagePublishViewViewModel.getImageContent();
                    String str2 = str;
                    int i11 = size;
                    FrameAspectRatio frameType = ImagePublishViewViewModel.this.getImageContent().getFrameType();
                    imagePublishViewViewModel.publishError(imageContent, str2, i11, a.a(frameType != null ? Float.valueOf(frameType.getRatio()) : null), exception);
                }
            });
            return;
        }
        List<UploadImageModel> uploadImageList = getImageContent().getUploadImageList();
        ArrayList arrayList = new ArrayList(t.t(uploadImageList, 10));
        Iterator<UploadImageModel> iterator23 = uploadImageList.iterator2();
        while (iterator23.hasNext()) {
            ImageModel image = iterator23.next().getImage();
            s.f(image);
            arrayList.add(image.getImageId());
        }
        FrameAspectRatio frameType = getImageContent().getFrameType();
        final String a10 = a.a(frameType != null ? Float.valueOf(frameType.getRatio()) : null);
        f3.a E = NetworkClient.f11868a.E();
        String title = getImageContent().getTitle();
        String description = getImageContent().getDescription();
        Location location = getImageContent().getLocation();
        String id2 = location != null ? location.getId() : null;
        HashTagSimpleModel hashTag = getImageContent().getHashTag();
        String itemId = hashTag != null ? hashTag.getItemId() : null;
        String replaceAtListStr = getImageContent().getReplaceAtListStr();
        boolean closeFriendOnly = getImageContent().getCloseFriendOnly();
        Location location2 = getImageContent().getLocation();
        String address = location2 != null ? location2.getAddress() : null;
        Location location3 = getImageContent().getLocation();
        String name = location3 != null ? location3.getName() : null;
        Location location4 = getImageContent().getLocation();
        Double latitude = location4 != null ? location4.getLatitude() : null;
        Location location5 = getImageContent().getLocation();
        Double longitude = location5 != null ? location5.getLongitude() : null;
        Location location6 = getImageContent().getLocation();
        Observable<R> flatMap = E.a(arrayList, title, description, id2, itemId, null, replaceAtListStr, closeFriendOnly, address, name, latitude, longitude, location6 != null ? location6.getCityname() : null, getImageContent().getWebTitle()).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).flatMap(new com.cupidapp.live.base.network.i());
        final Function1<ImageResult<? extends FeedModel>, p> function1 = new Function1<ImageResult<? extends FeedModel>, p>() { // from class: com.cupidapp.live.mediapicker.model.ImagePublishViewViewModel$checkUploadStatus$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ImageResult<? extends FeedModel> imageResult) {
                invoke2((ImageResult<FeedModel>) imageResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ImageResult<FeedModel> imageResult) {
                FKAppRatingLayout.f11658f.c(imageResult.getWindows());
                List<AppDialogModel> windows = imageResult.getWindows();
                AppDialogModel appDialogModel = null;
                if (windows != null) {
                    Iterator<AppDialogModel> iterator24 = windows.iterator2();
                    while (true) {
                        if (!iterator24.hasNext()) {
                            break;
                        }
                        AppDialogModel next = iterator24.next();
                        if (s.d(next.getWindowType(), WindowType.PushPriWindow.getType())) {
                            appDialogModel = next;
                            break;
                        }
                    }
                    appDialogModel = appDialogModel;
                }
                if (appDialogModel != null && (appDialogModel instanceof GuideOpenPushDialogModel)) {
                    EventBus.c().o(new ShowGuideOpenPushDialogAfterPublishFeedEvent((GuideOpenPushDialogModel) appDialogModel));
                }
                ImagePublishViewViewModel imagePublishViewViewModel = ImagePublishViewViewModel.this;
                imagePublishViewViewModel.publishSuccess(imagePublishViewViewModel.getImageContent(), imageResult.getImage().getPostId(), str, size, a10, imageResult.getPostBoost(), imageResult.getUrl());
            }
        };
        Consumer consumer = new Consumer() { // from class: com.cupidapp.live.mediapicker.model.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ImagePublishViewViewModel.checkUploadStatus$lambda$3(Function1.this, obj);
            }
        };
        final Function1<Throwable, p> function12 = new Function1<Throwable, p>() { // from class: com.cupidapp.live.mediapicker.model.ImagePublishViewViewModel$checkUploadStatus$3
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
                ImagePublishViewViewModel imagePublishViewViewModel = ImagePublishViewViewModel.this;
                ImageContentModel imageContent = imagePublishViewViewModel.getImageContent();
                String str2 = str;
                int i11 = size;
                String str3 = a10;
                s.h(t2, "t");
                imagePublishViewViewModel.publishError(imageContent, str2, i11, str3, t2);
            }
        };
        flatMap.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.mediapicker.model.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ImagePublishViewViewModel.checkUploadStatus$lambda$4(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkUploadStatus$lambda$3(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkUploadStatus$lambda$4(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @NotNull
    public final ImageContentModel getImageContent() {
        ImageContentModel imageContentModel = this.imageContent;
        if (imageContentModel != null) {
            return imageContentModel;
        }
        s.A("imageContent");
        return null;
    }

    @Override // com.cupidapp.live.mediapicker.model.PublishViewModel
    public void imageUploadSuccess(@NotNull Context context, @NotNull UploadImageModel image, @NotNull ImageModel resultImage) {
        UploadImageModel uploadImageModel;
        s.i(context, "context");
        s.i(image, "image");
        s.i(resultImage, "resultImage");
        Iterator<UploadImageModel> iterator2 = getImageContent().getUploadImageList().iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                uploadImageModel = null;
                break;
            } else {
                uploadImageModel = iterator2.next();
                if (s.d(uploadImageModel, image)) {
                    break;
                }
            }
        }
        UploadImageModel uploadImageModel2 = uploadImageModel;
        if (uploadImageModel2 != null) {
            uploadImageModel2.setImage(resultImage);
        }
        checkUploadStatus(context);
    }

    public final void setImageContent(@NotNull ImageContentModel imageContentModel) {
        s.i(imageContentModel, "<set-?>");
        this.imageContent = imageContentModel;
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
        UploadImageModel uploadImageModel = (UploadImageModel) CollectionsKt___CollectionsKt.V(getImageContent().getUploadImageList());
        if (uploadImageModel != null) {
            return uploadImageModel.getLocalPath();
        }
        return null;
    }
}
