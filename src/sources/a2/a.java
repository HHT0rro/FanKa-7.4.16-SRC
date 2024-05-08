package a2;

import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.chat.service.InboxSessionResult;
import com.cupidapp.live.club.model.ActivityListResult;
import com.cupidapp.live.club.model.ClubChatMsgModel;
import com.cupidapp.live.club.model.ClubChatMsgResult;
import com.cupidapp.live.club.model.ClubEnterRequestUserModel;
import com.cupidapp.live.club.model.ClubInfoDetailModel;
import com.cupidapp.live.club.model.ClubListResult;
import com.cupidapp.live.club.model.ClubModel;
import com.cupidapp.live.club.model.ClubNoticeModel;
import com.cupidapp.live.club.model.ClubRedPacketResult;
import com.cupidapp.live.club.model.ClubWonderfulActModel;
import com.cupidapp.live.club.model.FeedGroupEntryResult;
import com.cupidapp.live.club.model.OpenRedEnvelopeResult;
import com.cupidapp.live.profile.model.CompatResult;
import com.cupidapp.live.profile.model.User;
import io.reactivex.Observable;
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

/* compiled from: ClubService.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface a {

    /* compiled from: ClubService.kt */
    @d
    /* renamed from: a2.a$a */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class C0010a {
        public static /* synthetic */ Observable a(a aVar, String str, boolean z10, String str2, String str3, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getActivityList");
            }
            if ((i10 & 1) != 0) {
                str = null;
            }
            if ((i10 & 2) != 0) {
                z10 = false;
            }
            if ((i10 & 4) != 0) {
                str2 = null;
            }
            if ((i10 & 8) != 0) {
                str3 = null;
            }
            return aVar.A(str, z10, str2, str3);
        }

        public static /* synthetic */ Observable b(a aVar, String str, String str2, String str3, int i10, boolean z10, int i11, Object obj) {
            if (obj == null) {
                return aVar.v(str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? 21 : i10, (i11 & 16) != 0 ? false : z10);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getClubChatMsgList");
        }

        public static /* synthetic */ Observable c(a aVar, String str, String str2, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getClubList");
            }
            if ((i10 & 1) != 0) {
                str = null;
            }
            if ((i10 & 2) != 0) {
                str2 = null;
            }
            return aVar.s(str, str2);
        }

        public static /* synthetic */ Observable d(a aVar, String str, String str2, int i10, int i11, int i12, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendRedPacket");
            }
            if ((i12 & 8) != 0) {
                i11 = 2;
            }
            return aVar.d(str, str2, i10, i11);
        }
    }

    @f("/group/activity/recent")
    @NotNull
    Observable<Result<ActivityListResult>> A(@t("cursorId") @Nullable String str, @t("endedActivity") boolean z10, @t("groupId") @Nullable String str2, @t("orderType") @Nullable String str3);

    @f("/feed/group/entry")
    @NotNull
    Observable<Result<FeedGroupEntryResult>> B();

    @o("/group/chat/tip/click")
    @e
    @NotNull
    Observable<Result<Object>> a(@c("groupId") @NotNull String str, @c("stage") int i10);

    @f("/group/member")
    @NotNull
    Observable<Result<ListResult<User>>> b(@t("groupId") @NotNull String str, @t("cursorId") @Nullable String str2);

    @f("/group/detail")
    @NotNull
    Observable<Result<ClubInfoDetailModel>> c(@t("groupId") @NotNull String str);

    @o("/group/red-packet/create")
    @e
    @NotNull
    Observable<Result<Object>> d(@c("groupId") @NotNull String str, @c("giftId") @NotNull String str2, @c("num") int i10, @c("source") int i11);

    @o("/group/message/delete")
    @e
    @NotNull
    Observable<Result<Object>> e(@c("groupId") @NotNull String str, @c("messageId") @Nullable String str2);

    @o("/group/activity/share")
    @e
    @NotNull
    Observable<Result<Object>> f(@c("groupId") @NotNull String str, @c("activityId") @NotNull String str2);

    @o("/group/member/delete")
    @e
    @NotNull
    Observable<Result<Object>> g(@c("groupId") @NotNull String str, @c("userId") @NotNull String str2);

    @o("/group/message/read")
    @e
    @NotNull
    Observable<Result<Object>> h(@c("groupId") @NotNull String str);

    @o("/group/message/send/image")
    @l
    @NotNull
    Observable<Result<ClubChatMsgModel>> i(@t("groupId") @NotNull String str, @q @NotNull MultipartBody.Part part);

    @o("/group/send/announce")
    @e
    @NotNull
    Observable<Result<ClubNoticeModel>> j(@c("groupId") @NotNull String str, @c("remark") @NotNull String str2);

    @f("/group/member/dict-order")
    @NotNull
    Observable<Result<ListResult<User>>> k(@t("groupId") @NotNull String str);

    @o("/group/session/delete")
    @e
    @NotNull
    Observable<Result<Object>> l(@c("groupId") @NotNull String str);

    @o("/group/message-switch")
    @e
    @NotNull
    Observable<Result<Object>> m(@c("groupId") @NotNull String str, @c("open") boolean z10);

    @f("/group/activity/banner/list")
    @NotNull
    Observable<Result<ClubWonderfulActModel>> n();

    @o("/group/message/send/text")
    @e
    @NotNull
    Observable<Result<ClubChatMsgModel>> o(@c("groupId") @NotNull String str, @c("text") @Nullable String str2, @c("quoteMessageId") @Nullable String str3);

    @f("/group/session/get")
    @NotNull
    Observable<Result<InboxSessionResult>> p(@t("groupId") @NotNull String str);

    @f("/group/gift/list")
    @NotNull
    Observable<Result<ClubRedPacketResult>> q(@t("scene") int i10);

    @f("/group/announce/get")
    @NotNull
    Observable<Result<ClubNoticeModel>> r(@t("groupId") @NotNull String str);

    @f("/group/home")
    @NotNull
    Observable<Result<ClubListResult>> s(@t("cursorId") @Nullable String str, @t("orderType") @Nullable String str2);

    @o("/group/message/cancel")
    @e
    @NotNull
    Observable<Result<CompatResult>> t(@c("groupId") @NotNull String str, @c("messageId") @Nullable String str2);

    @o("/group/red-packet/unpack")
    @e
    @NotNull
    Observable<Result<OpenRedEnvelopeResult>> u(@c("groupId") @NotNull String str, @c("redPacketId") @NotNull String str2);

    @f("/group/message/get")
    @NotNull
    Observable<Result<ClubChatMsgResult>> v(@t("groupId") @NotNull String str, @t("cursor") @Nullable String str2, @t("endCursor") @Nullable String str3, @t("count") int i10, @t("fetchAfterCursor") boolean z10);

    @f("/group/list/mine")
    @NotNull
    Observable<Result<ListResult<ClubModel>>> w(@t("userId") @NotNull String str);

    @o("/group/message/send/at")
    @e
    @NotNull
    Observable<Result<ClubChatMsgModel>> x(@c("groupId") @NotNull String str, @c("text") @Nullable String str2, @c("atUserIds") @Nullable String str3, @c("quoteMessageId") @Nullable String str4);

    @f("/group/apply/list")
    @NotNull
    Observable<Result<ListResult<ClubEnterRequestUserModel>>> y(@t("groupId") @NotNull String str, @t("cursorId") @Nullable String str2);

    @o("/group/exit")
    @e
    @NotNull
    Observable<Result<Object>> z(@c("groupId") @NotNull String str);
}
