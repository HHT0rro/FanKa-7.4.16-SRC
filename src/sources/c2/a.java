package c2;

import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.consult.model.ConnectFinishedModel;
import com.cupidapp.live.consult.model.ConnectOrderModel;
import com.cupidapp.live.consult.model.ConsultAnchorCloseLiveResult;
import com.cupidapp.live.consult.model.ConsultCommentResult;
import com.cupidapp.live.consult.model.ConsultConnectChargeResult;
import com.cupidapp.live.consult.model.ConsultConnectInfoResult;
import com.cupidapp.live.consult.model.ConsultConnectUserResult;
import com.cupidapp.live.consult.model.ConsultCoverResult;
import com.cupidapp.live.consult.model.ConsultListResult;
import com.cupidapp.live.consult.model.ConsultLiveHangOverResult;
import com.cupidapp.live.consult.model.ConsultLiveModel;
import com.cupidapp.live.consult.model.ConsultLiveNextListResult;
import com.cupidapp.live.consult.model.ConsultReserveResult;
import com.cupidapp.live.consult.model.QuickJoinResult;
import com.cupidapp.live.consult.model.RequestConnectResult;
import io.reactivex.Observable;
import java.util.List;
import kotlin.d;
import ne.c;
import ne.e;
import ne.f;
import ne.o;
import ne.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultService.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface a {

    /* compiled from: ConsultService.kt */
    @d
    /* renamed from: c2.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class C0025a {
        public static /* synthetic */ Observable a(a aVar, String str, String str2, boolean z10, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enterRoomOrSwitchRoleSuccess");
            }
            if ((i10 & 2) != 0) {
                str2 = null;
            }
            if ((i10 & 4) != 0) {
                z10 = false;
            }
            return aVar.o(str, str2, z10);
        }

        public static /* synthetic */ Observable b(a aVar, String str, Integer num, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: voiceRoomChatList");
            }
            if ((i10 & 2) != 0) {
                num = null;
            }
            return aVar.s(str, num);
        }

        public static /* synthetic */ Observable c(a aVar, String str, boolean z10, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: voiceRoomViewer");
            }
            if ((i10 & 2) != 0) {
                z10 = false;
            }
            return aVar.c(str, z10);
        }
    }

    @o("/voice-room/chat/heartbeat")
    @e
    @NotNull
    Observable<Result<ConsultConnectUserResult>> a(@c("roomId") @NotNull String str, @c("requestId") @Nullable String str2);

    @o("/voice-room/open")
    @e
    @NotNull
    Observable<Result<ConsultLiveModel>> b(@c("title") @NotNull String str, @c("category") @NotNull String str2, @c("push") boolean z10);

    @o("/voice-room/viewer")
    @e
    @NotNull
    Observable<Result<ConsultLiveModel>> c(@c("roomId") @NotNull String str, @c("onlyReturnView") boolean z10);

    @o("/voice-room/chat/agree")
    @e
    @NotNull
    Observable<Result<Object>> d(@c("roomId") @NotNull String str, @c("requestId") @NotNull String str2);

    @f("/voice-room/quick-join")
    @NotNull
    Observable<Result<QuickJoinResult>> e();

    @o("/voice-room/cover/update")
    @e
    @NotNull
    Observable<Result<Object>> f(@c("imageId") @NotNull String str);

    @f("/voice-room/leave")
    @NotNull
    Observable<Result<Object>> g(@t("roomId") @NotNull String str);

    @o("/voice-room/chat/apply")
    @e
    @NotNull
    Observable<Result<RequestConnectResult>> h(@c("roomId") @NotNull String str, @c("voiceConnectType") @NotNull String str2);

    @o("/voice-room/next")
    @e
    @NotNull
    Observable<Result<ConsultLiveNextListResult>> i(@c("viewed[]") @NotNull List<String> list, @c("data") @Nullable String str);

    @o("/voice-room/comment")
    @e
    @NotNull
    Observable<Result<ConsultCommentResult>> j(@c("roomId") @NotNull String str, @c("message") @NotNull String str2);

    @f("/voice-room/chat/connect-info")
    @NotNull
    Observable<Result<ConsultConnectInfoResult>> k(@t("roomId") @NotNull String str);

    @o("/voice-room/close")
    @e
    @NotNull
    Observable<Result<ConsultAnchorCloseLiveResult>> l(@c("roomId") @NotNull String str);

    @o("/voice-room/anchor-info")
    @NotNull
    Observable<Result<ConsultLiveHangOverResult>> m();

    @o("/voice-room/chat/charge")
    @e
    @NotNull
    Observable<Result<ConsultConnectChargeResult>> n(@c("roomId") @NotNull String str, @c("requestId") @NotNull String str2);

    @o("/voice-room/chat/call-third/success")
    @e
    @NotNull
    Observable<Result<Object>> o(@c("roomId") @NotNull String str, @c("requestId") @Nullable String str2, @c("bySuspend") boolean z10);

    @o("/voice-room/chat/cancel")
    @e
    @NotNull
    Observable<Result<Object>> p(@c("roomId") @NotNull String str, @c("requestId") @NotNull String str2);

    @o("/voice-room/reserve")
    @NotNull
    Observable<Result<ConsultReserveResult>> q();

    @f("/voice-room/list")
    @NotNull
    Observable<Result<ConsultListResult>> r(@t("cursor") @Nullable String str);

    @f("/voice-room/chat/list")
    @NotNull
    Observable<Result<ListResult<ConnectOrderModel>>> s(@t("roomId") @NotNull String str, @t("count") @Nullable Integer num);

    @o("/voice-room/chat/change-room")
    @e
    @NotNull
    Observable<Result<Object>> t(@c("roomId") @NotNull String str, @c("newRoomId") @NotNull String str2);

    @f("/voice-room/cover")
    @NotNull
    Observable<Result<ConsultCoverResult>> u();

    @o("/voice-room/chat/hang-up")
    @e
    @NotNull
    Observable<Result<ConnectFinishedModel>> v(@c("roomId") @NotNull String str, @c("requestId") @NotNull String str2);
}
