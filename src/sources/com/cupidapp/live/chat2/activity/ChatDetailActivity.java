package com.cupidapp.live.chat2.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.activity.g;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.chat2.fragment.ChatDetailFragment;
import com.cupidapp.live.chat2.model.ChatBundleData;
import com.cupidapp.live.profile.model.User;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatDetailActivity.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatDetailActivity extends FKBaseActivity {

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public static final a f13276r = new a(null);

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public static ChatBundleData f13277s;

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13278q = new LinkedHashMap();

    /* compiled from: ChatDetailActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context, @NotNull ChatBundleData bundleData) {
            s.i(bundleData, "bundleData");
            if (context == null) {
                return;
            }
            ChatDetailActivity.f13277s = bundleData;
            Intent intent = new Intent(context, (Class<?>) ChatDetailActivity.class);
            intent.putExtra("CHAT_DETAIL_USER_ID", bundleData.getOtherUser().userId());
            intent.addFlags(335544320);
            context.startActivity(intent);
            if (bundleData.isShowKeyboard()) {
                FKBaseActivity.f11750o.b(context, R$anim.anim_activity_bottom_to_top, R$anim.anim_activity_nothing);
            } else {
                FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
            }
        }
    }

    /* compiled from: ChatDetailActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements g {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ChatDetailFragment f13279b;

        public b(ChatDetailFragment chatDetailFragment) {
            this.f13279b = chatDetailFragment;
        }

        @Override // com.cupidapp.live.base.activity.g
        public boolean a() {
            return this.f13279b.onBackPressed();
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return SensorPosition.MessageDetail;
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    public boolean T0() {
        return false;
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        User otherUser;
        super.onCreate(bundle);
        setContentView(R$layout.activity_chat_detail);
        ChatBundleData chatBundleData = f13277s;
        if (chatBundleData != null && chatBundleData.isShowKeyboard()) {
            d1(R$anim.anim_activity_nothing, Integer.valueOf(R$anim.anim_activity_top_to_bottom));
        }
        String stringExtra = getIntent().getStringExtra("CHAT_DETAIL_USER_ID");
        ChatBundleData chatBundleData2 = f13277s;
        if (chatBundleData2 != null) {
            if (s.d((chatBundleData2 == null || (otherUser = chatBundleData2.getOtherUser()) == null) ? null : otherUser.userId(), stringExtra)) {
                ChatDetailFragment.a aVar = ChatDetailFragment.f13305o;
                ChatBundleData chatBundleData3 = f13277s;
                s.f(chatBundleData3);
                ChatDetailFragment c4 = aVar.c(chatBundleData3);
                FKBaseActivity.g1(this, c4, false, R$id.chat_detail_root_layout, false, false, 24, null);
                z0(new b(c4));
                return;
            }
        }
        finish();
    }
}
