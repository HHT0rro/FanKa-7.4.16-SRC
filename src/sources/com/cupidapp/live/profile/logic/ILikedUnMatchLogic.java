package com.cupidapp.live.profile.logic;

import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.profile.model.UserListResult;
import io.reactivex.Observable;
import java.util.List;
import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ILikedUnMatchLogic.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface ILikedUnMatchLogic {
    @NotNull
    Observable<Result<Object>> a(@Nullable List<String> list);

    int b();

    boolean c();

    boolean d();

    @NotNull
    Observable<Result<UserListResult>> e(@Nullable String str);

    @NotNull
    Observable<Result<Object>> f();

    int getTitle();
}
