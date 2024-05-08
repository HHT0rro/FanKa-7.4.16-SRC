package x1;

import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.chat.model.AfterModifyChatStateModel;
import com.cupidapp.live.chat.model.ChatRecommendModel;
import com.cupidapp.live.chat.model.ChatStatusItemModel;
import com.cupidapp.live.chat.service.InboxSessionResult;
import com.cupidapp.live.chat2.model.ChatMessageResult;
import com.cupidapp.live.chat2.model.ChatTopicModel;
import com.cupidapp.live.chat2.model.MessageBubbleModel;
import com.cupidapp.live.chat2.model.SurveyChatMessageModel;
import com.cupidapp.live.chat2.model.SurveyChatMessageResult;
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

/* compiled from: ChatService.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface a {

    /* compiled from: ChatService.kt */
    @d
    /* renamed from: x1.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class C0835a {
        public static /* synthetic */ Observable a(a aVar, String str, String str2, String str3, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getInboxMessageList");
            }
            if ((i11 & 2) != 0) {
                str2 = null;
            }
            if ((i11 & 4) != 0) {
                str3 = null;
            }
            if ((i11 & 8) != 0) {
                i10 = 21;
            }
            return aVar.p(str, str2, str3, i10);
        }
    }

    @o("/inbox/message/snap/unpack")
    @e
    @NotNull
    Observable<Result<ChatMessageResult>> a(@c("messageId") @NotNull String str);

    @f("/inbox/session/get/v3")
    @NotNull
    Observable<Result<InboxSessionResult>> b(@t("sessionId") @NotNull String str);

    @o("/inbox/message/cancel")
    @e
    @NotNull
    Observable<Result<CompatResult>> c(@c("messageId") @NotNull String str);

    @o("/inbox/send/snapImage/v3")
    @l
    @NotNull
    Observable<Result<ChatMessageResult>> d(@q @NotNull MultipartBody.Part part, @t("toUserId") @NotNull String str, @t("countdownSeconds") int i10, @t("relatedPostId") @Nullable String str2, @t("popupMillis") @Nullable Long l10, @t("labelId") @Nullable Integer num);

    @o("/inbox/send/image/v3")
    @l
    @NotNull
    Observable<Result<ChatMessageResult>> e(@q @NotNull MultipartBody.Part part, @t("toUserId") @NotNull String str, @t("relatedPostId") @Nullable String str2, @t("popupMillis") @Nullable Long l10, @t("labelId") @Nullable Integer num);

    @o("/operation-message/option-choice")
    @e
    @NotNull
    Observable<Result<ListResult<SurveyChatMessageModel>>> f(@c("id") @NotNull String str, @c("messageId") @NotNull String str2, @c("optionId") @NotNull String str3);

    @f("/chat/status/items")
    @NotNull
    Observable<Result<ListResult<ChatStatusItemModel>>> g();

    @o("/inbox/message/markRead/v2")
    @e
    @NotNull
    Observable<Result<Object>> h(@c("sessionId") @NotNull String str, @c("messageId") @NotNull String[] strArr, @c("clearUnreadCount") boolean z10);

    @o("/inbox/message/snap/capture")
    @e
    @NotNull
    Observable<Result<Object>> i(@c("ownerId") @NotNull String str, @c("messageId") @NotNull String str2, @c("sessionId") @NotNull String str3);

    @f("/chat/recommend")
    @NotNull
    Observable<Result<ListResult<User>>> j();

    @o("/inbox/send/greet")
    @e
    @NotNull
    Observable<Result<Object>> k(@c("toUserId") @NotNull String str, @c("text") @NotNull String str2);

    @f("/inbox/session/message/bubble/get")
    @NotNull
    Observable<Result<MessageBubbleModel>> l();

    @f("/operation-message/message-info-detail")
    @NotNull
    Observable<Result<SurveyChatMessageResult>> m(@t("id") @NotNull String str);

    @o("/chat/nope")
    @e
    @NotNull
    Observable<Result<Object>> n(@c("userId") @NotNull String str);

    @f("/chat/status/list")
    @NotNull
    Observable<Result<ChatRecommendModel>> o();

    @f("/inbox/session/message/v3")
    @NotNull
    Observable<Result<ChatMessageResult>> p(@t("sessionId") @NotNull String str, @t("cursor") @Nullable String str2, @t("endCursor") @Nullable String str3, @t("count") int i10);

    @o("/inbox/marketing/red-dot/clean")
    @e
    @NotNull
    Observable<Result<Object>> q(@c("toUserId") @NotNull String str);

    @o("/chat/status")
    @e
    @NotNull
    Observable<Result<AfterModifyChatStateModel>> r(@c("status") @Nullable Integer num);

    @f("/inbox/chat-topic/list")
    @NotNull
    Observable<Result<ListResult<ChatTopicModel>>> s();

    @o("/inbox/send/screenCapture/v3")
    @e
    @NotNull
    Observable<Result<ChatMessageResult>> t(@c("toUserId") @NotNull String str);

    @o("/inbox/send/snapText/v3")
    @e
    @NotNull
    Observable<Result<ChatMessageResult>> u(@c("text") @NotNull String str, @c("toUserId") @NotNull String str2, @c("countdownSeconds") int i10, @c("relatedPostId") @Nullable String str3, @c("popupMillis") @Nullable Long l10, @c("labelId") @Nullable Integer num);

    @o("/v1/inbox/message/delete")
    @e
    @NotNull
    Observable<Result<Object>> v(@c("messageId") @NotNull String str, @c("sessionId") @NotNull String str2);

    @f("/inbox/message/bubble/url/get")
    @NotNull
    Observable<Result<ListResult<String>>> w();

    @o("/inbox/send/text/v3")
    @e
    @NotNull
    Observable<Result<ChatMessageResult>> x(@c("text") @NotNull String str, @c("toUserId") @NotNull String str2, @c("relatedPostId") @Nullable String str3, @c("popupMillis") @Nullable Long l10, @c("labelId") @Nullable Integer num, @c("textType") @Nullable Integer num2);
}
