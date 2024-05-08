package x1;

import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.chat.service.InboxSessionResult;
import com.cupidapp.live.chat.service.SnapCaptureStatusModel;
import io.reactivex.Observable;
import kotlin.d;
import ne.c;
import ne.e;
import ne.f;
import ne.o;
import ne.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ContactService.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface b {

    /* compiled from: ContactService.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public static /* synthetic */ Observable a(b bVar, String str, int i10, boolean z10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContactList");
            }
            if ((i11 & 1) != 0) {
                str = null;
            }
            if ((i11 & 2) != 0) {
                i10 = 25;
            }
            return bVar.d(str, i10, z10);
        }
    }

    @o("/v1/inbox/session/delete")
    @e
    @NotNull
    Observable<Result<Object>> a(@c("id") @NotNull String str);

    @f("/inbox/session/get/v3")
    @NotNull
    Observable<Result<InboxSessionResult>> b(@t("sessionId") @NotNull String str);

    @o("/inbox/session/clearUnread/v2")
    @e
    @NotNull
    Observable<Result<Object>> c(@c("sessionId") @NotNull String str);

    @f("/group/session")
    @NotNull
    Observable<Result<InboxSessionResult>> d(@t("cursor") @Nullable String str, @t("count") int i10, @t("unmatchOnly") boolean z10);

    @o("/inbox/send/post/limit")
    @e
    @NotNull
    Observable<Result<Object>> e(@c("postLimitId") @NotNull String str, @c("text") @NotNull String str2, @c("toUserId") @NotNull String str3);

    @o("/operation-message/delete")
    @e
    @NotNull
    Observable<Result<Object>> f(@c("id") @Nullable String str);

    @o("/inbox/message/snap/capture/status")
    @e
    @NotNull
    Observable<Result<SnapCaptureStatusModel>> g(@c("userId") @NotNull String str);
}
