package com.cupidapp.live.liveshow.fragment;

import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveForViewerFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveInRoomSensorModel implements Serializable {

    @Nullable
    private String enterSource;

    @Nullable
    private Integer listIndex;

    @Nullable
    private final SensorScene scene;

    @Nullable
    private final Double score;

    @Nullable
    private SensorPosition sensorPosition;

    @Nullable
    private final String userType;

    public LiveInRoomSensorModel(@Nullable String str, @Nullable Integer num, @Nullable SensorScene sensorScene, @Nullable SensorPosition sensorPosition, @Nullable String str2, @Nullable Double d10) {
        this.enterSource = str;
        this.listIndex = num;
        this.scene = sensorScene;
        this.sensorPosition = sensorPosition;
        this.userType = str2;
        this.score = d10;
    }

    public static /* synthetic */ LiveInRoomSensorModel copy$default(LiveInRoomSensorModel liveInRoomSensorModel, String str, Integer num, SensorScene sensorScene, SensorPosition sensorPosition, String str2, Double d10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = liveInRoomSensorModel.enterSource;
        }
        if ((i10 & 2) != 0) {
            num = liveInRoomSensorModel.listIndex;
        }
        Integer num2 = num;
        if ((i10 & 4) != 0) {
            sensorScene = liveInRoomSensorModel.scene;
        }
        SensorScene sensorScene2 = sensorScene;
        if ((i10 & 8) != 0) {
            sensorPosition = liveInRoomSensorModel.sensorPosition;
        }
        SensorPosition sensorPosition2 = sensorPosition;
        if ((i10 & 16) != 0) {
            str2 = liveInRoomSensorModel.userType;
        }
        String str3 = str2;
        if ((i10 & 32) != 0) {
            d10 = liveInRoomSensorModel.score;
        }
        return liveInRoomSensorModel.copy(str, num2, sensorScene2, sensorPosition2, str3, d10);
    }

    @Nullable
    public final String component1() {
        return this.enterSource;
    }

    @Nullable
    public final Integer component2() {
        return this.listIndex;
    }

    @Nullable
    public final SensorScene component3() {
        return this.scene;
    }

    @Nullable
    public final SensorPosition component4() {
        return this.sensorPosition;
    }

    @Nullable
    public final String component5() {
        return this.userType;
    }

    @Nullable
    public final Double component6() {
        return this.score;
    }

    @NotNull
    public final LiveInRoomSensorModel copy(@Nullable String str, @Nullable Integer num, @Nullable SensorScene sensorScene, @Nullable SensorPosition sensorPosition, @Nullable String str2, @Nullable Double d10) {
        return new LiveInRoomSensorModel(str, num, sensorScene, sensorPosition, str2, d10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveInRoomSensorModel)) {
            return false;
        }
        LiveInRoomSensorModel liveInRoomSensorModel = (LiveInRoomSensorModel) obj;
        return s.d(this.enterSource, liveInRoomSensorModel.enterSource) && s.d(this.listIndex, liveInRoomSensorModel.listIndex) && this.scene == liveInRoomSensorModel.scene && this.sensorPosition == liveInRoomSensorModel.sensorPosition && s.d(this.userType, liveInRoomSensorModel.userType) && s.d(this.score, liveInRoomSensorModel.score);
    }

    @Nullable
    public final String getEnterSource() {
        return this.enterSource;
    }

    @Nullable
    public final Integer getListIndex() {
        return this.listIndex;
    }

    @Nullable
    public final SensorScene getScene() {
        return this.scene;
    }

    @Nullable
    public final Double getScore() {
        return this.score;
    }

    @Nullable
    public final SensorPosition getSensorPosition() {
        return this.sensorPosition;
    }

    @Nullable
    public final String getUserType() {
        return this.userType;
    }

    public int hashCode() {
        String str = this.enterSource;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.listIndex;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        SensorScene sensorScene = this.scene;
        int hashCode3 = (hashCode2 + (sensorScene == null ? 0 : sensorScene.hashCode())) * 31;
        SensorPosition sensorPosition = this.sensorPosition;
        int hashCode4 = (hashCode3 + (sensorPosition == null ? 0 : sensorPosition.hashCode())) * 31;
        String str2 = this.userType;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Double d10 = this.score;
        return hashCode5 + (d10 != null ? d10.hashCode() : 0);
    }

    public final void setEnterSource(@Nullable String str) {
        this.enterSource = str;
    }

    public final void setListIndex(@Nullable Integer num) {
        this.listIndex = num;
    }

    public final void setSensorPosition(@Nullable SensorPosition sensorPosition) {
        this.sensorPosition = sensorPosition;
    }

    @NotNull
    public String toString() {
        String str = this.enterSource;
        Integer num = this.listIndex;
        SensorScene sensorScene = this.scene;
        SensorPosition sensorPosition = this.sensorPosition;
        return "LiveInRoomSensorModel(enterSource=" + str + ", listIndex=" + ((Object) num) + ", scene=" + ((Object) sensorScene) + ", sensorPosition=" + ((Object) sensorPosition) + ", userType=" + this.userType + ", score=" + ((Object) this.score) + ")";
    }

    public /* synthetic */ LiveInRoomSensorModel(String str, Integer num, SensorScene sensorScene, SensorPosition sensorPosition, String str2, Double d10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, num, sensorScene, sensorPosition, (i10 & 16) != 0 ? null : str2, (i10 & 32) != 0 ? null : d10);
    }
}
