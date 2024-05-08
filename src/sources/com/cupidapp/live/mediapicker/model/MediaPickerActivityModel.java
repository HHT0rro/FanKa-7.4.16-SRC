package com.cupidapp.live.mediapicker.model;

import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.hashtag.model.HashTagSimpleModel;
import com.cupidapp.live.mediapicker.newmediapicker.model.MediaType;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MediaPickerResult.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MediaPickerActivityModel implements Serializable {

    @Nullable
    private final String birthDay;

    @Nullable
    private final HashTagSimpleModel hashTag;

    @Nullable
    private final String itemId;

    @Nullable
    private final MediaType mediaType;
    private final int requestCode;

    @Nullable
    private final SensorPosition showPosition;
    private final boolean showTakePhotoButton;

    @NotNull
    private final CameraStartPosition startPosition;

    @Nullable
    private final String userName;

    @Nullable
    private final String webTitle;

    public MediaPickerActivityModel(@Nullable HashTagSimpleModel hashTagSimpleModel, boolean z10, int i10, @Nullable MediaType mediaType, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable SensorPosition sensorPosition, @NotNull CameraStartPosition startPosition) {
        s.i(startPosition, "startPosition");
        this.hashTag = hashTagSimpleModel;
        this.showTakePhotoButton = z10;
        this.requestCode = i10;
        this.mediaType = mediaType;
        this.userName = str;
        this.birthDay = str2;
        this.itemId = str3;
        this.webTitle = str4;
        this.showPosition = sensorPosition;
        this.startPosition = startPosition;
    }

    @Nullable
    public final HashTagSimpleModel component1() {
        return this.hashTag;
    }

    @NotNull
    public final CameraStartPosition component10() {
        return this.startPosition;
    }

    public final boolean component2() {
        return this.showTakePhotoButton;
    }

    public final int component3() {
        return this.requestCode;
    }

    @Nullable
    public final MediaType component4() {
        return this.mediaType;
    }

    @Nullable
    public final String component5() {
        return this.userName;
    }

    @Nullable
    public final String component6() {
        return this.birthDay;
    }

    @Nullable
    public final String component7() {
        return this.itemId;
    }

    @Nullable
    public final String component8() {
        return this.webTitle;
    }

    @Nullable
    public final SensorPosition component9() {
        return this.showPosition;
    }

    @NotNull
    public final MediaPickerActivityModel copy(@Nullable HashTagSimpleModel hashTagSimpleModel, boolean z10, int i10, @Nullable MediaType mediaType, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable SensorPosition sensorPosition, @NotNull CameraStartPosition startPosition) {
        s.i(startPosition, "startPosition");
        return new MediaPickerActivityModel(hashTagSimpleModel, z10, i10, mediaType, str, str2, str3, str4, sensorPosition, startPosition);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaPickerActivityModel)) {
            return false;
        }
        MediaPickerActivityModel mediaPickerActivityModel = (MediaPickerActivityModel) obj;
        return s.d(this.hashTag, mediaPickerActivityModel.hashTag) && this.showTakePhotoButton == mediaPickerActivityModel.showTakePhotoButton && this.requestCode == mediaPickerActivityModel.requestCode && this.mediaType == mediaPickerActivityModel.mediaType && s.d(this.userName, mediaPickerActivityModel.userName) && s.d(this.birthDay, mediaPickerActivityModel.birthDay) && s.d(this.itemId, mediaPickerActivityModel.itemId) && s.d(this.webTitle, mediaPickerActivityModel.webTitle) && this.showPosition == mediaPickerActivityModel.showPosition && this.startPosition == mediaPickerActivityModel.startPosition;
    }

    @Nullable
    public final String getBirthDay() {
        return this.birthDay;
    }

    @Nullable
    public final HashTagSimpleModel getHashTag() {
        return this.hashTag;
    }

    @Nullable
    public final String getItemId() {
        return this.itemId;
    }

    @Nullable
    public final MediaType getMediaType() {
        return this.mediaType;
    }

    public final int getRequestCode() {
        return this.requestCode;
    }

    @Nullable
    public final SensorPosition getShowPosition() {
        return this.showPosition;
    }

    public final boolean getShowTakePhotoButton() {
        return this.showTakePhotoButton;
    }

    @NotNull
    public final CameraStartPosition getStartPosition() {
        return this.startPosition;
    }

    @Nullable
    public final String getUserName() {
        return this.userName;
    }

    @Nullable
    public final String getWebTitle() {
        return this.webTitle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        HashTagSimpleModel hashTagSimpleModel = this.hashTag;
        int hashCode = (hashTagSimpleModel == null ? 0 : hashTagSimpleModel.hashCode()) * 31;
        boolean z10 = this.showTakePhotoButton;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (((hashCode + i10) * 31) + this.requestCode) * 31;
        MediaType mediaType = this.mediaType;
        int hashCode2 = (i11 + (mediaType == null ? 0 : mediaType.hashCode())) * 31;
        String str = this.userName;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.birthDay;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.itemId;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.webTitle;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        SensorPosition sensorPosition = this.showPosition;
        return ((hashCode6 + (sensorPosition != null ? sensorPosition.hashCode() : 0)) * 31) + this.startPosition.hashCode();
    }

    @NotNull
    public String toString() {
        HashTagSimpleModel hashTagSimpleModel = this.hashTag;
        boolean z10 = this.showTakePhotoButton;
        int i10 = this.requestCode;
        MediaType mediaType = this.mediaType;
        return "MediaPickerActivityModel(hashTag=" + ((Object) hashTagSimpleModel) + ", showTakePhotoButton=" + z10 + ", requestCode=" + i10 + ", mediaType=" + ((Object) mediaType) + ", userName=" + this.userName + ", birthDay=" + this.birthDay + ", itemId=" + this.itemId + ", webTitle=" + this.webTitle + ", showPosition=" + ((Object) this.showPosition) + ", startPosition=" + ((Object) this.startPosition) + ")";
    }

    public /* synthetic */ MediaPickerActivityModel(HashTagSimpleModel hashTagSimpleModel, boolean z10, int i10, MediaType mediaType, String str, String str2, String str3, String str4, SensorPosition sensorPosition, CameraStartPosition cameraStartPosition, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : hashTagSimpleModel, (i11 & 2) != 0 ? true : z10, i10, mediaType, (i11 & 16) != 0 ? null : str, (i11 & 32) != 0 ? null : str2, (i11 & 64) != 0 ? null : str3, (i11 & 128) != 0 ? null : str4, sensorPosition, cameraStartPosition);
    }
}
