package com.cupidapp.live.club.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.view.dialog.h;
import com.cupidapp.live.club.model.ClubNoticeModel;
import com.cupidapp.live.club.model.ClubUserRoleType;
import com.cupidapp.live.club.view.ClubNoticeLayout;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.c;
import kotlin.collections.r;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q1.g;
import z0.u;
import z0.y;

/* compiled from: ClubNoticeActivity.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubNoticeActivity extends FKBaseActivity {

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public static final a f13497t = new a(null);

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public ClubNoticeModel f13499r;

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13500s = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f13498q = c.b(new Function0<String>() { // from class: com.cupidapp.live.club.activity.ClubNoticeActivity$clubId$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final String invoke() {
            return ClubNoticeActivity.this.getIntent().getStringExtra("CLUB_ID");
        }
    });

    /* compiled from: ClubNoticeActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String clubId, @Nullable Integer num) {
            s.i(context, "context");
            s.i(clubId, "clubId");
            Intent intent = new Intent(context, (Class<?>) ClubNoticeActivity.class);
            intent.putExtra("CLUB_ID", clubId);
            intent.putExtra("USER_ROLE", num);
            context.startActivity(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f13500s;
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

    public final void o1() {
        ImageView return_imageview = (ImageView) j1(R$id.return_imageview);
        s.h(return_imageview, "return_imageview");
        y.d(return_imageview, new Function1<View, p>() { // from class: com.cupidapp.live.club.activity.ClubNoticeActivity$bindClickEvent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                ClubNoticeActivity.this.finish();
            }
        });
        TextView edit_notice_textview = (TextView) j1(R$id.edit_notice_textview);
        s.h(edit_notice_textview, "edit_notice_textview");
        y.d(edit_notice_textview, new Function1<View, p>() { // from class: com.cupidapp.live.club.activity.ClubNoticeActivity$bindClickEvent$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                ClubNoticeActivity.this.q1(true);
            }
        });
        TextView cancel_edit_textview = (TextView) j1(R$id.cancel_edit_textview);
        s.h(cancel_edit_textview, "cancel_edit_textview");
        y.d(cancel_edit_textview, new Function1<View, p>() { // from class: com.cupidapp.live.club.activity.ClubNoticeActivity$bindClickEvent$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                ClubNoticeActivity.this.q1(false);
            }
        });
        TextView complete_edit_textview = (TextView) j1(R$id.complete_edit_textview);
        s.h(complete_edit_textview, "complete_edit_textview");
        y.d(complete_edit_textview, new Function1<View, p>() { // from class: com.cupidapp.live.club.activity.ClubNoticeActivity$bindClickEvent$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                ClubNoticeActivity.this.u1();
            }
        });
        new g(r.e((EditText) j1(R$id.notice_edittext)), new Function1<Boolean, p>() { // from class: com.cupidapp.live.club.activity.ClubNoticeActivity$bindClickEvent$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return p.f51048a;
            }

            public final void invoke(boolean z10) {
                ClubNoticeActivity.this.v1();
            }
        });
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_club_notice);
        t1();
        o1();
        s1();
    }

    public final void p1(ClubNoticeModel clubNoticeModel) {
        this.f13499r = clubNoticeModel;
        String msg = clubNoticeModel.getMsg();
        if (msg == null || msg.length() == 0) {
            ClubNoticeLayout notice_layout = (ClubNoticeLayout) j1(R$id.notice_layout);
            s.h(notice_layout, "notice_layout");
            notice_layout.setVisibility(8);
            TextView empty_club_notice_textview = (TextView) j1(R$id.empty_club_notice_textview);
            s.h(empty_club_notice_textview, "empty_club_notice_textview");
            empty_club_notice_textview.setVisibility(0);
        } else {
            int i10 = R$id.notice_layout;
            ClubNoticeLayout notice_layout2 = (ClubNoticeLayout) j1(i10);
            s.h(notice_layout2, "notice_layout");
            notice_layout2.setVisibility(0);
            ((ClubNoticeLayout) j1(i10)).b(clubNoticeModel);
            TextView empty_club_notice_textview2 = (TextView) j1(R$id.empty_club_notice_textview);
            s.h(empty_club_notice_textview2, "empty_club_notice_textview");
            empty_club_notice_textview2.setVisibility(8);
            int i11 = R$id.notice_edittext;
            ((EditText) j1(i11)).setText(clubNoticeModel.getMsg());
            ((EditText) j1(i11)).setSelection(((EditText) j1(i11)).length());
        }
        Integer userRole = clubNoticeModel.getUserRole();
        int intValue = userRole != null ? userRole.intValue() : getIntent().getIntExtra("USER_ROLE", 0);
        TextView edit_notice_textview = (TextView) j1(R$id.edit_notice_textview);
        s.h(edit_notice_textview, "edit_notice_textview");
        edit_notice_textview.setVisibility(ClubUserRoleType.Companion.b(Integer.valueOf(intValue)) ? 0 : 8);
        TextView cancel_edit_textview = (TextView) j1(R$id.cancel_edit_textview);
        s.h(cancel_edit_textview, "cancel_edit_textview");
        cancel_edit_textview.setVisibility(8);
        TextView complete_edit_textview = (TextView) j1(R$id.complete_edit_textview);
        s.h(complete_edit_textview, "complete_edit_textview");
        complete_edit_textview.setVisibility(8);
        Group notice_group = (Group) j1(R$id.notice_group);
        s.h(notice_group, "notice_group");
        notice_group.setVisibility(8);
        ImageView return_imageview = (ImageView) j1(R$id.return_imageview);
        s.h(return_imageview, "return_imageview");
        return_imageview.setVisibility(0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00dc, code lost:
    
        if ((r0 == null || r0.length() == 0) == false) goto L54;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void q1(boolean r7) {
        /*
            Method dump skipped, instructions count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.club.activity.ClubNoticeActivity.q1(boolean):void");
    }

    public final String r1() {
        return (String) this.f13498q.getValue();
    }

    public final void s1() {
        if (r1() == null) {
            return;
        }
        a2.a u10 = NetworkClient.f11868a.u();
        String r12 = r1();
        s.f(r12);
        Disposable disposed = u10.r(r12).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ClubNoticeModel, p>() { // from class: com.cupidapp.live.club.activity.ClubNoticeActivity$getClubNotice$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ClubNoticeModel clubNoticeModel) {
                m2509invoke(clubNoticeModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2509invoke(ClubNoticeModel clubNoticeModel) {
                ClubNoticeActivity.this.p1(clubNoticeModel);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void t1() {
        TextView club_notice_title = (TextView) j1(R$id.club_notice_title);
        s.h(club_notice_title, "club_notice_title");
        u.a(club_notice_title);
        RelativeLayout club_notice_title_layout = (RelativeLayout) j1(R$id.club_notice_title_layout);
        s.h(club_notice_title_layout, "club_notice_title_layout");
        com.cupidapp.live.base.view.s.b(this, club_notice_title_layout);
        ((EditText) j1(R$id.notice_edittext)).setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(140)});
    }

    public final void u1() {
        if (r1() == null) {
            return;
        }
        int i10 = R$id.notice_edittext;
        String obj = ((EditText) j1(i10)).getText().toString();
        if (StringsKt__StringsKt.P0(obj).toString().length() == 0) {
            ((EditText) j1(i10)).setText("");
            obj = "";
        }
        h.d(h.f12743a, null, false, 3, null);
        z0.h.q(this, null, 1, null);
        a2.a u10 = NetworkClient.f11868a.u();
        String r12 = r1();
        s.f(r12);
        Disposable disposed = u10.j(r12, obj).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ClubNoticeModel, p>() { // from class: com.cupidapp.live.club.activity.ClubNoticeActivity$publishCLubNotice$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ClubNoticeModel clubNoticeModel) {
                m2510invoke(clubNoticeModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2510invoke(ClubNoticeModel clubNoticeModel) {
                h.f12743a.b();
                ClubNoticeActivity.this.p1(clubNoticeModel);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.club.activity.ClubNoticeActivity$publishCLubNotice$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                h.f12743a.b();
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void v1() {
        SpannableStringBuilder c4;
        int length = 140 - ((EditText) j1(R$id.notice_edittext)).length();
        String string = getString(R$string.remaining_input_words, new Object[]{Integer.valueOf(length)});
        s.h(string, "getString(R.string.remaining_input_words, remain)");
        TextView textView = (TextView) j1(R$id.notice_words_textview);
        c4 = q1.d.f53006a.c(string, kotlin.collections.s.o(String.valueOf(length)), (r18 & 4) != 0 ? null : -49088, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? false : false, (r18 & 32) != 0 ? null : null, (r18 & 64) != 0 ? null : null);
        textView.setText(c4);
    }
}
