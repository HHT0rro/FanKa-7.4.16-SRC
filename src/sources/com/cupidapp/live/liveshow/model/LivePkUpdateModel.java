package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.profile.model.User;
import java.util.List;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLivePkResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LivePkUpdateModel {

    @NotNull
    private final String matchId;

    @NotNull
    private final Map<String, Float> pkCreditMap;

    @Nullable
    private final Map<String, List<User>> pkSofaMap;

    @NotNull
    private final Map<String, Float> pkValueMap;

    /* JADX WARN: Multi-variable type inference failed */
    public LivePkUpdateModel(@NotNull Map<String, Float> pkValueMap, @NotNull Map<String, Float> pkCreditMap, @NotNull String matchId, @Nullable Map<String, ? extends List<User>> map) {
        s.i(pkValueMap, "pkValueMap");
        s.i(pkCreditMap, "pkCreditMap");
        s.i(matchId, "matchId");
        this.pkValueMap = pkValueMap;
        this.pkCreditMap = pkCreditMap;
        this.matchId = matchId;
        this.pkSofaMap = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LivePkUpdateModel copy$default(LivePkUpdateModel livePkUpdateModel, Map map, Map map2, String str, Map map3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            map = livePkUpdateModel.pkValueMap;
        }
        if ((i10 & 2) != 0) {
            map2 = livePkUpdateModel.pkCreditMap;
        }
        if ((i10 & 4) != 0) {
            str = livePkUpdateModel.matchId;
        }
        if ((i10 & 8) != 0) {
            map3 = livePkUpdateModel.pkSofaMap;
        }
        return livePkUpdateModel.copy(map, map2, str, map3);
    }

    @NotNull
    public final Map<String, Float> component1() {
        return this.pkValueMap;
    }

    @NotNull
    public final Map<String, Float> component2() {
        return this.pkCreditMap;
    }

    @NotNull
    public final String component3() {
        return this.matchId;
    }

    @Nullable
    public final Map<String, List<User>> component4() {
        return this.pkSofaMap;
    }

    @NotNull
    public final LivePkUpdateModel copy(@NotNull Map<String, Float> pkValueMap, @NotNull Map<String, Float> pkCreditMap, @NotNull String matchId, @Nullable Map<String, ? extends List<User>> map) {
        s.i(pkValueMap, "pkValueMap");
        s.i(pkCreditMap, "pkCreditMap");
        s.i(matchId, "matchId");
        return new LivePkUpdateModel(pkValueMap, pkCreditMap, matchId, map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LivePkUpdateModel)) {
            return false;
        }
        LivePkUpdateModel livePkUpdateModel = (LivePkUpdateModel) obj;
        return s.d(this.pkValueMap, livePkUpdateModel.pkValueMap) && s.d(this.pkCreditMap, livePkUpdateModel.pkCreditMap) && s.d(this.matchId, livePkUpdateModel.matchId) && s.d(this.pkSofaMap, livePkUpdateModel.pkSofaMap);
    }

    @NotNull
    public final String getMatchId() {
        return this.matchId;
    }

    @NotNull
    public final Map<String, Float> getPkCreditMap() {
        return this.pkCreditMap;
    }

    @Nullable
    public final Map<String, List<User>> getPkSofaMap() {
        return this.pkSofaMap;
    }

    @NotNull
    public final Map<String, Float> getPkValueMap() {
        return this.pkValueMap;
    }

    public int hashCode() {
        int hashCode = ((((this.pkValueMap.hashCode() * 31) + this.pkCreditMap.hashCode()) * 31) + this.matchId.hashCode()) * 31;
        Map<String, List<User>> map = this.pkSofaMap;
        return hashCode + (map == null ? 0 : map.hashCode());
    }

    @NotNull
    public String toString() {
        Map<String, Float> map = this.pkValueMap;
        Map<String, Float> map2 = this.pkCreditMap;
        return "LivePkUpdateModel(pkValueMap=" + ((Object) map) + ", pkCreditMap=" + ((Object) map2) + ", matchId=" + this.matchId + ", pkSofaMap=" + ((Object) this.pkSofaMap) + ")";
    }
}
