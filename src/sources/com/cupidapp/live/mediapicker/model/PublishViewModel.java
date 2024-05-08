package com.cupidapp.live.mediapicker.model;

import android.content.Context;
import com.cupidapp.live.base.extension.ImageAttributeModel;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.feed.model.PostBoostModel;
import com.cupidapp.live.mediapicker.helper.FKFireBaseDetectorOptionsKt;
import java.io.File;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PublishViewModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class PublishViewModel {

    @Nullable
    private String jumpUrl;

    @Nullable
    private PostBoostModel postBoost;
    private float progress;

    @NotNull
    private UploadState state = UploadState.Uploading;

    @Nullable
    private Function2<? super Throwable, ? super PublishViewModel, p> uploadErrorCallback;
    private long uploadStartTime;

    @Nullable
    private Function1<? super PublishViewModel, p> uploadSuccessCallback;

    private final void publishSensorLog(MediaContentModel mediaContentModel, String str, String str2, int i10, String str3, Throwable th, String str4) {
    }

    public final void fileUploadImage(@NotNull Context context, @NotNull UploadImageModel uploadImage, @NotNull SensorPosition uploadPosition, @Nullable String str, @NotNull Function1<? super Throwable, p> publishError) {
        s.i(context, "context");
        s.i(uploadImage, "uploadImage");
        s.i(uploadPosition, "uploadPosition");
        s.i(publishError, "publishError");
        String localPath = uploadImage.getLocalPath();
        if (localPath == null) {
            return;
        }
        File file = new File(localPath);
        ImageAttributeModel l10 = z0.f.l(context, localPath);
        long currentTimeMillis = System.currentTimeMillis();
        j.f12332a.a("fileUploadImage", "start time " + currentTimeMillis);
        String path = file.getPath();
        s.h(path, "imageFile.path");
        FKFireBaseDetectorOptionsKt.h(context, path, new PublishViewModel$fileUploadImage$1(currentTimeMillis, this, file, l10, context, uploadImage, uploadPosition, str, publishError));
    }

    @Nullable
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @Nullable
    public final PostBoostModel getPostBoost() {
        return this.postBoost;
    }

    public final float getProgress() {
        return this.progress;
    }

    @NotNull
    public final UploadState getState() {
        return this.state;
    }

    public final long getUploadStartTime() {
        return this.uploadStartTime;
    }

    public abstract void imageUploadSuccess(@NotNull Context context, @NotNull UploadImageModel uploadImageModel, @NotNull ImageModel imageModel);

    public final void publishError(@NotNull MediaContentModel model, @NotNull String feedType, int i10, @Nullable String str, @NotNull Throwable exception) {
        s.i(model, "model");
        s.i(feedType, "feedType");
        s.i(exception, "exception");
        this.postBoost = null;
        this.jumpUrl = null;
        this.state = UploadState.Error;
        Function2<? super Throwable, ? super PublishViewModel, p> function2 = this.uploadErrorCallback;
        if (function2 != null) {
            function2.mo1743invoke(exception, this);
        }
        publishSensorLog(model, null, feedType, i10, str, exception, model.getWebTitle());
    }

    public final void publishSuccess(@NotNull MediaContentModel model, @Nullable String str, @NotNull String feedType, int i10, @Nullable String str2, @Nullable PostBoostModel postBoostModel, @Nullable String str3) {
        s.i(model, "model");
        s.i(feedType, "feedType");
        this.jumpUrl = str3;
        this.postBoost = postBoostModel;
        this.state = UploadState.Success;
        this.progress = 100.0f;
        Function1<? super PublishViewModel, p> function1 = this.uploadSuccessCallback;
        if (function1 != null) {
            function1.invoke(this);
        }
        publishSensorLog(model, str, feedType, i10, str2, null, model.getWebTitle());
    }

    public final void setJumpUrl(@Nullable String str) {
        this.jumpUrl = str;
    }

    public final void setPostBoost(@Nullable PostBoostModel postBoostModel) {
        this.postBoost = postBoostModel;
    }

    public final void setProgress(float f10) {
        this.progress = f10;
    }

    public final void setState(@NotNull UploadState uploadState) {
        s.i(uploadState, "<set-?>");
        this.state = uploadState;
    }

    public final void setUploadStartTime(long j10) {
        this.uploadStartTime = j10;
    }

    public void startPublish(@NotNull Context context, @NotNull Function1<? super PublishViewModel, p> success, @NotNull Function2<? super Throwable, ? super PublishViewModel, p> error) {
        s.i(context, "context");
        s.i(success, "success");
        s.i(error, "error");
        this.postBoost = null;
        this.jumpUrl = null;
        this.uploadSuccessCallback = success;
        this.uploadErrorCallback = error;
        this.state = UploadState.Uploading;
        this.progress = 0.0f;
    }

    public abstract void updateImageUpload(float f10);

    @Nullable
    public abstract String uploadCoverImage();

    public final void uploadFilesSensorLog(long j10, int i10, int i11, @NotNull String fileType, @NotNull SensorPosition uploadPosition, @Nullable Throwable th, @Nullable String str) {
        String str2;
        s.i(fileType, "fileType");
        s.i(uploadPosition, "uploadPosition");
        long currentTimeMillis = System.currentTimeMillis() - this.uploadStartTime;
        SensorsLogFeed sensorsLogFeed = SensorsLogFeed.f12208a;
        SensorsLogFeed.UploadFileType uploadFileType = SensorsLogFeed.UploadFileType.FEED;
        boolean z10 = th == null;
        String a10 = com.cupidapp.live.base.network.j.f12008a.a(th);
        if (a10 == null) {
            str2 = th != null ? th.getMessage() : null;
        } else {
            str2 = a10;
        }
        sensorsLogFeed.O(currentTimeMillis, j10, i10, i11, uploadFileType, fileType, uploadPosition, z10, str2, (r33 & 512) != 0 ? null : null, (r33 & 1024) != 0 ? null : str, (r33 & 2048) != 0 ? null : null);
    }
}
