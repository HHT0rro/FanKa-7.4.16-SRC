package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.web.WebConfigViewModel;
import com.cupidapp.live.base.web.fragment.FKWebViewFragment;
import com.cupidapp.live.consult.fragment.ConsultListFragment;
import com.cupidapp.live.liveshow.fragment.FKFollowUserLiveListFragment;
import com.cupidapp.live.liveshow.fragment.FKGeneralLiveListFragment;
import com.cupidapp.live.liveshow.fragment.FKHotLiveListFragment;
import com.cupidapp.live.liveshow.fragment.FKNearbyLiveListFragment;
import com.cupidapp.live.liveshow.fragment.FKRecommendLiveListFragment;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LiveContainerFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveTabConfigModel implements Serializable {

    /* renamed from: default, reason: not valid java name */
    private final boolean f200default;

    /* renamed from: id, reason: collision with root package name */
    private final int f15103id;

    @NotNull
    private final String tab;

    @NotNull
    private final String type;

    @Nullable
    private final String url;

    public LiveTabConfigModel(int i10, @NotNull String type, @NotNull String tab, boolean z10, @Nullable String str) {
        s.i(type, "type");
        s.i(tab, "tab");
        this.f15103id = i10;
        this.type = type;
        this.tab = tab;
        this.f200default = z10;
        this.url = str;
    }

    public static /* synthetic */ LiveTabConfigModel copy$default(LiveTabConfigModel liveTabConfigModel, int i10, String str, String str2, boolean z10, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = liveTabConfigModel.f15103id;
        }
        if ((i11 & 2) != 0) {
            str = liveTabConfigModel.type;
        }
        String str4 = str;
        if ((i11 & 4) != 0) {
            str2 = liveTabConfigModel.tab;
        }
        String str5 = str2;
        if ((i11 & 8) != 0) {
            z10 = liveTabConfigModel.f200default;
        }
        boolean z11 = z10;
        if ((i11 & 16) != 0) {
            str3 = liveTabConfigModel.url;
        }
        return liveTabConfigModel.copy(i10, str4, str5, z11, str3);
    }

    public final int component1() {
        return this.f15103id;
    }

    @NotNull
    public final String component2() {
        return this.type;
    }

    @NotNull
    public final String component3() {
        return this.tab;
    }

    public final boolean component4() {
        return this.f200default;
    }

    @Nullable
    public final String component5() {
        return this.url;
    }

    @NotNull
    public final LiveTabConfigModel copy(int i10, @NotNull String type, @NotNull String tab, boolean z10, @Nullable String str) {
        s.i(type, "type");
        s.i(tab, "tab");
        return new LiveTabConfigModel(i10, type, tab, z10, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveTabConfigModel)) {
            return false;
        }
        LiveTabConfigModel liveTabConfigModel = (LiveTabConfigModel) obj;
        return this.f15103id == liveTabConfigModel.f15103id && s.d(this.type, liveTabConfigModel.type) && s.d(this.tab, liveTabConfigModel.tab) && this.f200default == liveTabConfigModel.f200default && s.d(this.url, liveTabConfigModel.url);
    }

    public final boolean getDefault() {
        return this.f200default;
    }

    public final int getId() {
        return this.f15103id;
    }

    @Nullable
    public final FKBaseFragment getLiveSubTabFragment() {
        String str = this.type;
        if (s.d(str, LiveSubTabType.RECOMMEND.getValue())) {
            return new FKRecommendLiveListFragment();
        }
        if (s.d(str, LiveSubTabType.HOT.getValue())) {
            return new FKHotLiveListFragment();
        }
        if (s.d(str, LiveSubTabType.NEARBY.getValue())) {
            return new FKNearbyLiveListFragment();
        }
        if (s.d(str, LiveSubTabType.FOLLOW.getValue())) {
            return new FKFollowUserLiveListFragment();
        }
        if (s.d(str, LiveSubTabType.GENERAL.getValue())) {
            return new FKGeneralLiveListFragment();
        }
        if (s.d(str, LiveSubTabType.VOICE_ROOM.getValue())) {
            return new ConsultListFragment();
        }
        if (!s.d(str, LiveSubTabType.WEB.getValue())) {
            return null;
        }
        return FKWebViewFragment.a.e(FKWebViewFragment.f13075p, this.url, null, new WebConfigViewModel(false, false, false, false, false, SensorPosition.ConsultList, true, 6, null), 2, null);
    }

    @NotNull
    public final String getTab() {
        return this.tab;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.f15103id * 31) + this.type.hashCode()) * 31) + this.tab.hashCode()) * 31;
        boolean z10 = this.f200default;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode + i10) * 31;
        String str = this.url;
        return i11 + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        return "LiveTabConfigModel(id=" + this.f15103id + ", type=" + this.type + ", tab=" + this.tab + ", default=" + this.f200default + ", url=" + this.url + ")";
    }
}
