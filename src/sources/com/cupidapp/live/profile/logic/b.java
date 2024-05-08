package com.cupidapp.live.profile.logic;

import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.profile.model.UserListResult;
import io.reactivex.Observable;
import java.util.List;
import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;

/* compiled from: LikedUnMatchLogic.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b implements ILikedUnMatchLogic {
    @Override // com.cupidapp.live.profile.logic.ILikedUnMatchLogic
    @NotNull
    public Observable<Result<Object>> a(@Nullable List<String> list) {
        return a.C0836a.g(NetworkClient.f11868a.N(), list, 0, 2, null);
    }

    @Override // com.cupidapp.live.profile.logic.ILikedUnMatchLogic
    public int b() {
        return R$string.confirm_un_follow_all_un_match_uer;
    }

    @Override // com.cupidapp.live.profile.logic.ILikedUnMatchLogic
    public boolean c() {
        return true;
    }

    @Override // com.cupidapp.live.profile.logic.ILikedUnMatchLogic
    public boolean d() {
        return true;
    }

    @Override // com.cupidapp.live.profile.logic.ILikedUnMatchLogic
    @NotNull
    public Observable<Result<UserListResult>> e(@Nullable String str) {
        return a.C0836a.i(NetworkClient.f11868a.N(), str, 0, 2, null);
    }

    @Override // com.cupidapp.live.profile.logic.ILikedUnMatchLogic
    @NotNull
    public Observable<Result<Object>> f() {
        return NetworkClient.f11868a.N().c0(null, 1);
    }

    @Override // com.cupidapp.live.profile.logic.ILikedUnMatchLogic
    public int getTitle() {
        return R$string.un_match_user;
    }
}
