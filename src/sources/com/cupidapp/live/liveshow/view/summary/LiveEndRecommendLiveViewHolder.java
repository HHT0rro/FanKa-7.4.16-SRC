package com.cupidapp.live.liveshow.view.summary;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.liveshow.constants.FKLiveType;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.RedEnvelopeTagModel;
import com.irisdt.client.live.LiveProtos;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: LiveEndAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveEndRecommendLiveViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f15953c = new a(null);

    /* compiled from: LiveEndAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final LiveEndRecommendLiveViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new LiveEndRecommendLiveViewHolder(z.b(parent, R$layout.view_holder_live_end_recommend_live, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveEndRecommendLiveViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        ((TextView) itemView.findViewById(R$id.live_title_textview)).getPaint().setFakeBoldText(true);
        int l10 = (h.l(this) - h.c(this, 48.0f)) / 2;
        ImageLoaderView imageLoaderView = (ImageLoaderView) itemView.findViewById(R$id.live_cover_imageview);
        s.h(imageLoaderView, "itemView.live_cover_imageview");
        y.n(imageLoaderView, Integer.valueOf(l10), Integer.valueOf(l10));
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof LiveShowModel) {
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.live_cover_imageview);
            s.h(imageLoaderView, "itemView.live_cover_imageview");
            LiveShowModel liveShowModel = (LiveShowModel) obj;
            ImageLoaderView.g(imageLoaderView, liveShowModel.getCoverImage(), null, null, 6, null);
            ((TextView) this.itemView.findViewById(R$id.live_title_textview)).setText(liveShowModel.getTitle());
            ((TextView) this.itemView.findViewById(R$id.user_name_textview)).setText(liveShowModel.getUser().getName());
            ((TextView) this.itemView.findViewById(R$id.live_view_count_textView)).setText(liveShowModel.getFormatHeatValue());
            SensorsLogLiveShow sensorsLogLiveShow = SensorsLogLiveShow.f12212a;
            String itemId = liveShowModel.getItemId();
            String userId = liveShowModel.getUser().userId();
            SensorPosition sensorPosition = SensorPosition.LiveEnd;
            SensorScene sensorScene = SensorScene.Live;
            String viewerCount = liveShowModel.getViewerCount();
            Integer anchorPrivilegeType = liveShowModel.getAnchorPrivilegeType();
            String strategyId = liveShowModel.getStrategyId();
            SensorsLogLiveShow.EnterLiveShowSource enterLiveShowSource = SensorsLogLiveShow.EnterLiveShowSource.LIVE_RECOMMEND;
            FKLiveType liveType = liveShowModel.getLiveType();
            LiveProtos.CoverType coverType = liveShowModel.getCoverType();
            RedEnvelopeTagModel redPacketInfo = liveShowModel.getRedPacketInfo();
            sensorsLogLiveShow.o(itemId, userId, sensorPosition, sensorScene, (r33 & 16) != 0 ? null : viewerCount, (r33 & 32) != 0 ? null : anchorPrivilegeType, (r33 & 64) != 0 ? null : strategyId, (r33 & 128) != 0 ? null : enterLiveShowSource, (r33 & 256) != 0 ? null : liveType, (r33 & 512) != 0 ? null : coverType, (r33 & 1024) != 0 ? null : null, (r33 & 2048) != 0 ? null : null, (r33 & 4096) != 0 ? null : null, (r33 & 8192) != 0 ? null : redPacketInfo != null ? redPacketInfo.getIconCategory() : null);
        }
    }
}
