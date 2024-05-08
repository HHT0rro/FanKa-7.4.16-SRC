package com.cupidapp.live.match.model;

import com.cupidapp.live.profile.model.User;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NearByModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NearMatchModel implements Serializable {
    private final boolean hide;

    @Nullable
    private final String lastOnline;

    @Nullable
    private final String locationInfo;
    private final boolean online;

    @Nullable
    private final User user;

    public NearMatchModel(@Nullable User user, @Nullable String str, @Nullable String str2, boolean z10, boolean z11) {
        this.user = user;
        this.locationInfo = str;
        this.lastOnline = str2;
        this.hide = z10;
        this.online = z11;
    }

    public static /* synthetic */ NearMatchModel copy$default(NearMatchModel nearMatchModel, User user, String str, String str2, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            user = nearMatchModel.user;
        }
        if ((i10 & 2) != 0) {
            str = nearMatchModel.locationInfo;
        }
        String str3 = str;
        if ((i10 & 4) != 0) {
            str2 = nearMatchModel.lastOnline;
        }
        String str4 = str2;
        if ((i10 & 8) != 0) {
            z10 = nearMatchModel.hide;
        }
        boolean z12 = z10;
        if ((i10 & 16) != 0) {
            z11 = nearMatchModel.online;
        }
        return nearMatchModel.copy(user, str3, str4, z12, z11);
    }

    @Nullable
    public final User component1() {
        return this.user;
    }

    @Nullable
    public final String component2() {
        return this.locationInfo;
    }

    @Nullable
    public final String component3() {
        return this.lastOnline;
    }

    public final boolean component4() {
        return this.hide;
    }

    public final boolean component5() {
        return this.online;
    }

    @Nullable
    public final NearbyUserModel convertNearByUser() {
        User user = this.user;
        if (user == null) {
            return null;
        }
        return new NearbyUserModel(user.userId(), this.user.getVip(), this.user.getAnnualVip(), this.user.getSvip(), this.user.getAnnualSvip(), this.user.getVipIconHide(), this.user.getAvatarImage(), this.user.getName(), null, this.user.getDistance(), false, false, this.user.getOnline(), null, this.user.getSummaryInfo(), null, null, this.user.getSsvip(), this.user.getAnnualSsvip(), false, null, 1682688, null);
    }

    @NotNull
    public final NearMatchModel copy(@Nullable User user, @Nullable String str, @Nullable String str2, boolean z10, boolean z11) {
        return new NearMatchModel(user, str, str2, z10, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NearMatchModel)) {
            return false;
        }
        NearMatchModel nearMatchModel = (NearMatchModel) obj;
        return s.d(this.user, nearMatchModel.user) && s.d(this.locationInfo, nearMatchModel.locationInfo) && s.d(this.lastOnline, nearMatchModel.lastOnline) && this.hide == nearMatchModel.hide && this.online == nearMatchModel.online;
    }

    public final boolean getHide() {
        return this.hide;
    }

    @Nullable
    public final String getLastOnline() {
        return this.lastOnline;
    }

    @Nullable
    public final String getLocationInfo() {
        return this.locationInfo;
    }

    public final boolean getOnline() {
        return this.online;
    }

    @Nullable
    public final User getUser() {
        return this.user;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        User user = this.user;
        int hashCode = (user == null ? 0 : user.hashCode()) * 31;
        String str = this.locationInfo;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.lastOnline;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z10 = this.hide;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode3 + i10) * 31;
        boolean z11 = this.online;
        return i11 + (z11 ? 1 : z11 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        User user = this.user;
        return "NearMatchModel(user=" + ((Object) user) + ", locationInfo=" + this.locationInfo + ", lastOnline=" + this.lastOnline + ", hide=" + this.hide + ", online=" + this.online + ")";
    }

    public /* synthetic */ NearMatchModel(User user, String str, String str2, boolean z10, boolean z11, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(user, str, str2, (i10 & 8) != 0 ? false : z10, (i10 & 16) != 0 ? false : z11);
    }
}
