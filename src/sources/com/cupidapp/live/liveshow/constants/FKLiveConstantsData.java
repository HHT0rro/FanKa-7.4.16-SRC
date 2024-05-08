package com.cupidapp.live.liveshow.constants;

import com.cupidapp.live.liveshow.beauty.zegocapture.FKLiveVideoCaptureFactory;
import com.cupidapp.live.liveshow.beauty.zegocapture.VideoCaptureFromImage;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.LiveShowResult;
import com.zego.zegoavkit2.ZegoExternalVideoCapture;
import com.zego.zegoavkit2.ZegoVideoCaptureDevice;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveConstantsData.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveConstantsData {

    @Nullable
    private static FKLiveVideoCaptureFactory fkLiveFKLiveVideoCaptureFactory;

    @Nullable
    private static LiveShowResult fkLiveShowResult;

    @Nullable
    private static String fkLiveStrategyId;

    @Nullable
    private static ZegoVideoCaptureDevice.Client fkLiveVideoCaptureClient;

    @Nullable
    private static VideoCaptureFromImage fkLiveVideoCaptureImage;

    @Nullable
    private static Long liveShowViewDuration;
    private static int totalCommentCount;
    private static float totalDiamondCount;

    @NotNull
    public static final FKLiveConstantsData INSTANCE = new FKLiveConstantsData();

    @NotNull
    private static FKLiveType fkLiveType = FKLiveType.COMMON;

    @Nullable
    private static Long miniLiveViewDuration = 0L;

    private FKLiveConstantsData() {
    }

    @Nullable
    public final FKLiveVideoCaptureFactory getFkLiveFKLiveVideoCaptureFactory() {
        return fkLiveFKLiveVideoCaptureFactory;
    }

    @Nullable
    public final LiveShowResult getFkLiveShowResult() {
        return fkLiveShowResult;
    }

    @Nullable
    public final String getFkLiveStrategyId() {
        return fkLiveStrategyId;
    }

    @NotNull
    public final FKLiveType getFkLiveType() {
        return fkLiveType;
    }

    @Nullable
    public final ZegoVideoCaptureDevice.Client getFkLiveVideoCaptureClient() {
        return fkLiveVideoCaptureClient;
    }

    @Nullable
    public final VideoCaptureFromImage getFkLiveVideoCaptureImage() {
        return fkLiveVideoCaptureImage;
    }

    @Nullable
    public final LiveShowModel getLiveShowModel() {
        LiveShowResult liveShowResult = fkLiveShowResult;
        if (liveShowResult != null) {
            return liveShowResult.getLiveShow();
        }
        return null;
    }

    @Nullable
    public final Long getLiveShowViewDuration() {
        if (liveShowViewDuration == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Long l10 = liveShowViewDuration;
        s.f(l10);
        return Long.valueOf((currentTimeMillis - l10.longValue()) / 1000);
    }

    @Nullable
    public final Long getMiniLiveViewDuration() {
        Long l10 = miniLiveViewDuration;
        if (l10 != null && (l10 == null || l10.longValue() != 0)) {
            long currentTimeMillis = System.currentTimeMillis();
            Long l11 = miniLiveViewDuration;
            s.f(l11);
            return Long.valueOf((currentTimeMillis - l11.longValue()) / 1000);
        }
        return -1L;
    }

    @Nullable
    public final LiveShowModel getPkLiveShowModel() {
        LiveShowResult liveShowResult = fkLiveShowResult;
        if (liveShowResult != null) {
            return liveShowResult.getPkLiveShow();
        }
        return null;
    }

    @Nullable
    public final LiveShowModel getRemoteConnectLiveShow() {
        List<LiveShowModel> connectLive;
        LiveShowModel liveShowModel = getLiveShowModel();
        if (liveShowModel == null || (connectLive = liveShowModel.getConnectLive()) == null) {
            return null;
        }
        return (LiveShowModel) CollectionsKt___CollectionsKt.V(connectLive);
    }

    public final int getTotalCommentCount() {
        return totalCommentCount;
    }

    public final float getTotalDiamondCount() {
        return totalDiamondCount;
    }

    public final void leaveRoomResetData() {
        liveShowViewDuration = null;
        totalCommentCount = 0;
        totalDiamondCount = 0.0f;
        fkLiveStrategyId = null;
    }

    public final void resetLiveConstantsData() {
        setFkLiveShowResult(null);
        fkLiveType = FKLiveType.COMMON;
    }

    public final void resetLiveVideoCapture() {
        fkLiveFKLiveVideoCaptureFactory = null;
        fkLiveVideoCaptureImage = null;
        fkLiveVideoCaptureClient = null;
        ZegoExternalVideoCapture.setVideoCaptureFactory(null, 0);
    }

    public final void setFkLiveFKLiveVideoCaptureFactory(@Nullable FKLiveVideoCaptureFactory fKLiveVideoCaptureFactory) {
        fkLiveFKLiveVideoCaptureFactory = fKLiveVideoCaptureFactory;
    }

    public final void setFkLiveShowResult(@Nullable LiveShowResult liveShowResult) {
        FKLiveType liveType;
        fkLiveShowResult = liveShowResult;
        if ((liveShowResult != null ? liveShowResult.getLiveShow() : null) == null) {
            liveType = FKLiveType.FINISH;
        } else {
            liveType = liveShowResult.getLiveType();
        }
        fkLiveType = liveType;
    }

    public final void setFkLiveStrategyId(@Nullable String str) {
        fkLiveStrategyId = str;
    }

    public final void setFkLiveType(@NotNull FKLiveType fKLiveType) {
        s.i(fKLiveType, "<set-?>");
        fkLiveType = fKLiveType;
    }

    public final void setFkLiveVideoCaptureClient(@Nullable ZegoVideoCaptureDevice.Client client) {
        fkLiveVideoCaptureClient = client;
    }

    public final void setFkLiveVideoCaptureImage(@Nullable VideoCaptureFromImage videoCaptureFromImage) {
        fkLiveVideoCaptureImage = videoCaptureFromImage;
    }

    public final void setLiveShowModel(@NotNull LiveShowModel liveShow) {
        s.i(liveShow, "liveShow");
        LiveShowResult liveShowResult = fkLiveShowResult;
        if (liveShowResult == null) {
            return;
        }
        liveShowResult.setLiveShow(liveShow);
    }

    public final void setLiveShowViewDuration(@Nullable Long l10) {
        liveShowViewDuration = l10;
    }

    public final void setMiniLiveViewDuration(@Nullable Long l10) {
        miniLiveViewDuration = l10;
    }

    public final void setTotalCommentCount(int i10) {
        totalCommentCount = i10;
    }

    public final void setTotalDiamondCount(float f10) {
        totalDiamondCount = f10;
    }
}
