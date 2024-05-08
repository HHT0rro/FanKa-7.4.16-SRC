package com.cupidapp.live.maskparty.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.activity.g;
import com.cupidapp.live.maskparty.fragment.BaseMaskPartyChatFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyChatActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyChatActivity extends FKBaseActivity {

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public static final a f16230s = new a(null);

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16232r = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f16231q = kotlin.c.b(new Function0<Boolean>() { // from class: com.cupidapp.live.maskparty.activity.MaskPartyChatActivity$isRecommend$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Boolean invoke() {
            return Boolean.valueOf(MaskPartyChatActivity.this.getIntent().getBooleanExtra("IS_RECOMMEND_MATCH", false));
        }
    });

    /* compiled from: MaskPartyChatActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Intent b(a aVar, Context context, String str, int i10, boolean z10, int i11, Object obj) {
            if ((i11 & 8) != 0) {
                z10 = false;
            }
            return aVar.a(context, str, i10, z10);
        }

        @NotNull
        public final Intent a(@Nullable Context context, @Nullable String str, int i10, boolean z10) {
            Intent intent = new Intent(context, (Class<?>) MaskPartyChatActivity.class);
            intent.putExtra("MASK_PARTY_ROOM_ID", str);
            intent.putExtra("MASK_PARTY_TYPE", i10);
            intent.putExtra("IS_RECOMMEND_MATCH", z10);
            return intent;
        }

        public final void c(@Nullable Context context, @Nullable String str, int i10, boolean z10) {
            if (context != null) {
                if (str == null || str.length() == 0) {
                    return;
                }
                context.startActivity(a(context, str, i10, z10));
                FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
            }
        }
    }

    /* compiled from: MaskPartyChatActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements g {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseMaskPartyChatFragment f16233b;

        public b(BaseMaskPartyChatFragment baseMaskPartyChatFragment) {
            this.f16233b = baseMaskPartyChatFragment;
        }

        @Override // com.cupidapp.live.base.activity.g
        public boolean a() {
            BaseMaskPartyChatFragment baseMaskPartyChatFragment = this.f16233b;
            if (baseMaskPartyChatFragment != null) {
                return baseMaskPartyChatFragment.onBackPressed();
            }
            return false;
        }
    }

    public final boolean j1() {
        return ((Boolean) this.f16231q.getValue()).booleanValue();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_mask_party_chat);
        String stringExtra = getIntent().getStringExtra("MASK_PARTY_ROOM_ID");
        int intExtra = getIntent().getIntExtra("MASK_PARTY_TYPE", 0);
        if (!(stringExtra == null || stringExtra.length() == 0) && intExtra > 0) {
            BaseMaskPartyChatFragment b4 = BaseMaskPartyChatFragment.f16269l.b(stringExtra, intExtra, j1());
            FKBaseActivity.g1(this, b4, false, R$id.mask_party_chat_root_layout, false, false, 24, null);
            z0(new b(b4));
            return;
        }
        finish();
    }
}
