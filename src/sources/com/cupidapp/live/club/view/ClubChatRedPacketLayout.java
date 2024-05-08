package com.cupidapp.live.club.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.club.model.ClubChatMsgModel;
import com.cupidapp.live.club.model.RedPacketStatus;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.z;

/* compiled from: ClubChatRedPacketLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubChatRedPacketLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13640b;

    /* compiled from: ClubChatRedPacketLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13641a;

        static {
            int[] iArr = new int[RedPacketStatus.values().length];
            try {
                iArr[RedPacketStatus.UnOpened.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f13641a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubChatRedPacketLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13640b = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f13640b;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void b(@NotNull ClubChatMsgModel model) {
        s.i(model, "model");
        ImageLoaderView club_red_packet_gift_img = (ImageLoaderView) a(R$id.club_red_packet_gift_img);
        s.h(club_red_packet_gift_img, "club_red_packet_gift_img");
        ImageLoaderView.g(club_red_packet_gift_img, model.getGiftIcon(), null, null, 6, null);
        ((TextView) a(R$id.club_red_packet_gift_name)).setText(model.getTitle());
        ((TextView) a(R$id.club_red_packet_gift_type)).setText(model.getBottomMsg());
        RedPacketStatus a10 = RedPacketStatus.Companion.a(model.getStatus());
        setAlpha((a10 == null ? -1 : a.f13641a[a10.ordinal()]) == 1 ? 1.0f : 0.3f);
    }

    public final void c() {
        z.a(this, R$layout.layout_club_chat_red_packet, true);
        TextView club_red_packet_gift_name = (TextView) a(R$id.club_red_packet_gift_name);
        s.h(club_red_packet_gift_name, "club_red_packet_gift_name");
        u.a(club_red_packet_gift_name);
        TextView club_red_packet_gift_type = (TextView) a(R$id.club_red_packet_gift_type);
        s.h(club_red_packet_gift_type, "club_red_packet_gift_type");
        u.a(club_red_packet_gift_type);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubChatRedPacketLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13640b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubChatRedPacketLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13640b = new LinkedHashMap();
        c();
    }
}
