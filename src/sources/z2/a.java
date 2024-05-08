package z2;

import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.maskparty.model.MaskPartyChatMessageResult;
import com.cupidapp.live.maskparty.model.MaskPartyChatRoomModel;
import com.cupidapp.live.maskparty.model.MaskPartyHangUpMessageModel;
import com.cupidapp.live.maskparty.model.MaskPartyMatchConfigResult;
import com.cupidapp.live.maskparty.model.MaskPartyQuestionModel;
import com.cupidapp.live.maskparty.model.MaskPartyRecommendUserResult;
import com.cupidapp.live.maskparty.model.MaskPartyRoomModel;
import com.cupidapp.live.maskparty.model.MaskPartyScriptModel;
import com.cupidapp.live.maskparty.model.MaskPartyScriptTaskModel;
import com.cupidapp.live.maskparty.model.MaskPartyStartMatchResult;
import com.cupidapp.live.maskparty.model.QuitRoomModel;
import io.reactivex.Observable;
import java.util.List;
import kotlin.d;
import ne.c;
import ne.e;
import ne.f;
import ne.l;
import ne.o;
import ne.q;
import ne.t;
import okhttp3.MultipartBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyService.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface a {

    /* compiled from: MaskPartyService.kt */
    @d
    /* renamed from: z2.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class C0844a {
        public static /* synthetic */ Observable a(a aVar, String str, String str2, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: maskMatchMessage");
            }
            if ((i11 & 2) != 0) {
                str2 = null;
            }
            return aVar.x(str, str2, i10);
        }
    }

    @o("/mask-match/inbox/send/screenCapture")
    @e
    @NotNull
    Observable<Result<Object>> A(@c("roomId") @NotNull String str, @c("toUserId") @NotNull String str2);

    @o("/mask-match/create-room")
    @e
    @NotNull
    Observable<Result<MaskPartyRoomModel>> B(@c("matchUserId") @NotNull String str, @c("type") int i10);

    @o("/mask-match/typing")
    @e
    @NotNull
    Observable<Result<Object>> C(@c("roomId") @NotNull String str, @c("toUserId") @NotNull String str2);

    @o("/mask-match/inbox/message/snap/unpack")
    @e
    @NotNull
    Observable<Result<MaskPartyChatMessageResult>> a(@c("messageId") @NotNull String str);

    @f("/mask-match/script/info")
    @NotNull
    Observable<Result<MaskPartyScriptModel>> b(@t("roomId") @NotNull String str);

    @o("/mask-match/script/chooseRole")
    @e
    @NotNull
    Observable<Result<Object>> c(@c("roomId") @NotNull String str, @c("roleId") int i10);

    @o("/mask-match/avatar")
    @e
    @NotNull
    Observable<Result<Object>> d(@c("id") @NotNull String str);

    @f("/mask-match/chat-room")
    @NotNull
    Observable<Result<MaskPartyChatRoomModel>> e(@t("roomId") @NotNull String str);

    @o("/mask-match/inbox/send/image")
    @l
    @NotNull
    Observable<Result<MaskPartyChatMessageResult>> f(@q @NotNull MultipartBody.Part part, @t("roomId") @NotNull String str, @t("toUserId") @NotNull String str2);

    @o("/mask-match/script/showProfile")
    @e
    @NotNull
    Observable<Result<Object>> g(@c("roomId") @NotNull String str);

    @f("/mask-match/config")
    @NotNull
    Observable<Result<MaskPartyMatchConfigResult>> h();

    @o("/mask-match/start")
    @e
    @NotNull
    Observable<Result<MaskPartyStartMatchResult>> i(@c("types[]") @NotNull List<Integer> list, @c("retry") boolean z10, @c("cardType[]") @Nullable List<Integer> list2, @c("cardValue[]") @Nullable List<Integer> list3);

    @o("/mask-match/inbox/send/text")
    @e
    @NotNull
    Observable<Result<MaskPartyChatMessageResult>> j(@c("text") @NotNull String str, @c("roomId") @NotNull String str2, @c("toUserId") @NotNull String str3, @c("actionType") int i10);

    @o("/mask-match/inbox/message/delete")
    @e
    @NotNull
    Observable<Result<Object>> k(@c("roomId") @NotNull String str, @c("messageId") @NotNull String str2);

    @o("/mask-match/round")
    @e
    @NotNull
    Observable<Result<Object>> l(@c("roomId") @NotNull String str);

    @o("/mask-match/stop")
    @e
    @NotNull
    Observable<Result<Object>> m(@c("types[]") @NotNull List<Integer> list, @c("retry") boolean z10);

    @o("/mask-match/inbox/send/snapImage")
    @l
    @NotNull
    Observable<Result<MaskPartyChatMessageResult>> n(@q @NotNull MultipartBody.Part part, @t("roomId") @NotNull String str, @t("toUserId") @NotNull String str2, @t("countdownSeconds") int i10);

    @f("/mask-match/script/roleInfo")
    @NotNull
    Observable<Result<MaskPartyScriptTaskModel>> o(@t("roomId") @NotNull String str);

    @o("/mask-match/question-type")
    @e
    @NotNull
    Observable<Result<Object>> p(@c("roomId") @NotNull String str, @c("type") int i10);

    @f("/mask-match/leave-room")
    @NotNull
    Observable<Result<QuitRoomModel>> q(@t("roomId") @NotNull String str, @t("costTime") @Nullable Integer num);

    @o("/mask-match/exchange")
    @NotNull
    Observable<Result<Object>> r();

    @o("/mask-match/popup-info")
    @e
    @NotNull
    Observable<Result<MaskPartyRecommendUserResult>> s(@c("matchUserId") @NotNull String str, @c("show") int i10, @c("type") int i11);

    @o("/mask-match/app-change")
    @e
    @NotNull
    Observable<Result<MaskPartyHangUpMessageModel>> t(@c("roomId") @NotNull String str, @c("type") int i10);

    @f("/mask-match/question-list")
    @NotNull
    Observable<Result<ListResult<MaskPartyQuestionModel>>> u(@t("type") int i10);

    @o("/mask-match/script/guessIdentity")
    @e
    @NotNull
    Observable<Result<Object>> v(@c("roomId") @NotNull String str, @c("identityId") int i10);

    @f("mask-match/propCardTipWindow")
    @NotNull
    Observable<Result<Object>> w();

    @f("/mask-match/inbox/message")
    @NotNull
    Observable<Result<MaskPartyChatMessageResult>> x(@t("roomId") @NotNull String str, @t("endCursor") @Nullable String str2, @t("count") int i10);

    @o("/mask-match/in-room")
    @e
    @NotNull
    Observable<Result<Object>> y(@c("roomId") @NotNull String str);

    @o("/mask-match/inbox/message/cancel")
    @e
    @NotNull
    Observable<Result<Object>> z(@c("roomId") @NotNull String str, @c("messageId") @NotNull String str2);
}
