package com.cupidapp.live.maskparty.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.activity.g;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.maskparty.fragment.MaskPartyMatchFragment;
import com.cupidapp.live.maskparty.model.MaskPartyType;
import com.cupidapp.live.maskparty.viewmodel.MaskPartyMatchViewModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyMatchActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyMatchActivity extends FKBaseActivity {

    /* renamed from: r */
    @NotNull
    public static final a f16245r = new a(null);

    /* renamed from: q */
    @NotNull
    public Map<Integer, View> f16246q = new LinkedHashMap();

    /* compiled from: MaskPartyMatchActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void b(a aVar, Context context, List list, boolean z10, boolean z11, String str, int i10, Object obj) {
            boolean z12 = (i10 & 4) != 0 ? false : z10;
            boolean z13 = (i10 & 8) != 0 ? false : z11;
            if ((i10 & 16) != 0) {
                str = null;
            }
            aVar.a(context, list, z12, z13, str);
        }

        public final void a(@Nullable Context context, @NotNull List<Integer> partyList, boolean z10, boolean z11, @Nullable String str) {
            s.i(partyList, "partyList");
            if (context == null) {
                return;
            }
            MaskPartyMatchViewModel.Companion.b(partyList);
            Intent intent = new Intent(context, (Class<?>) MaskPartyMatchActivity.class);
            intent.putExtra("MASK_PARTY_START_MATCH", z10);
            intent.putExtra("MASK_PARTY_REMATCH", z11);
            intent.putExtra("MASK_PARTY_FROM", str);
            context.startActivity(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    /* compiled from: MaskPartyMatchActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements g {

        /* renamed from: b */
        public final /* synthetic */ MaskPartyMatchFragment f16247b;

        public b(MaskPartyMatchFragment maskPartyMatchFragment) {
            this.f16247b = maskPartyMatchFragment;
        }

        @Override // com.cupidapp.live.base.activity.g
        public boolean a() {
            return this.f16247b.onBackPressed();
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        String stringExtra;
        SensorPosition sensorPosition;
        super.onCreate(bundle);
        setContentView(R$layout.activity_mask_party_match);
        boolean z10 = false;
        boolean booleanExtra = getIntent().getBooleanExtra("MASK_PARTY_START_MATCH", false);
        boolean booleanExtra2 = getIntent().getBooleanExtra("MASK_PARTY_REMATCH", false);
        MaskPartyMatchFragment b4 = MaskPartyMatchFragment.a.b(MaskPartyMatchFragment.f16296o, booleanExtra, booleanExtra2, false, 4, null);
        FKBaseActivity.g1(this, b4, false, R$id.mask_party_match_container_layout, false, false, 24, null);
        z0(new b(b4));
        if (booleanExtra2 || (stringExtra = getIntent().getStringExtra("MASK_PARTY_FROM")) == null) {
            return;
        }
        List<Integer> a10 = MaskPartyMatchViewModel.Companion.a();
        if (a10 != null && a10.contains(Integer.valueOf(MaskPartyType.VoiceChat.getType()))) {
            z10 = true;
        }
        if (z10) {
            sensorPosition = SensorPosition.VoiceParty;
        } else {
            sensorPosition = SensorPosition.MaskParty;
        }
        j1.c.b(j1.c.f50228a, sensorPosition, null, stringExtra, 2, null);
    }
}
