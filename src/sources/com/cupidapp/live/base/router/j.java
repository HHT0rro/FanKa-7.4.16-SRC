package com.cupidapp.live.base.router;

import android.content.Context;
import android.net.Uri;
import androidx.lifecycle.Lifecycle;
import com.cupidapp.live.base.router.jumper.FeedPublishJumper;
import com.cupidapp.live.base.router.jumper.ImagePasterJumper;
import com.cupidapp.live.base.router.jumper.LiveShowUrlJumper;
import com.cupidapp.live.base.router.jumper.LiveUrlJumper;
import com.cupidapp.live.base.router.jumper.LocationPermissionUrlJumper;
import com.cupidapp.live.base.router.jumper.MapFilterUrlJumper;
import com.cupidapp.live.base.router.jumper.OpenChatDetailJumper;
import com.cupidapp.live.base.router.jumper.OpenQRScanUrlJumper;
import com.cupidapp.live.base.router.jumper.PersonalPostListUrlJumper;
import com.cupidapp.live.base.router.jumper.PostUrlJumper;
import com.cupidapp.live.base.router.jumper.PreviewVoiceRoomJumper;
import com.cupidapp.live.base.router.jumper.TravelUseJumper;
import com.cupidapp.live.base.router.jumper.UserUrlJumper;
import com.cupidapp.live.base.router.jumper.WebActionJumper;
import com.cupidapp.live.base.router.jumper.a0;
import com.cupidapp.live.base.router.jumper.b0;
import com.cupidapp.live.base.router.jumper.c0;
import com.cupidapp.live.base.router.jumper.d0;
import com.cupidapp.live.base.router.jumper.e0;
import com.cupidapp.live.base.router.jumper.f0;
import com.cupidapp.live.base.router.jumper.g0;
import com.cupidapp.live.base.router.jumper.h0;
import com.cupidapp.live.base.router.jumper.j0;
import com.cupidapp.live.base.router.jumper.k0;
import com.cupidapp.live.base.router.jumper.l0;
import com.cupidapp.live.base.router.jumper.m0;
import com.cupidapp.live.base.router.jumper.n0;
import com.cupidapp.live.base.router.jumper.o0;
import com.cupidapp.live.base.router.jumper.p;
import com.cupidapp.live.base.router.jumper.p0;
import com.cupidapp.live.base.router.jumper.q;
import com.cupidapp.live.base.router.jumper.q0;
import com.cupidapp.live.base.router.jumper.r;
import com.cupidapp.live.base.router.jumper.r0;
import com.cupidapp.live.base.router.jumper.s;
import com.cupidapp.live.base.router.jumper.s0;
import com.cupidapp.live.base.router.jumper.t;
import com.cupidapp.live.base.router.jumper.t0;
import com.cupidapp.live.base.router.jumper.u;
import com.cupidapp.live.base.router.jumper.u0;
import com.cupidapp.live.base.router.jumper.v;
import com.cupidapp.live.base.router.jumper.v0;
import com.cupidapp.live.base.router.jumper.w;
import com.cupidapp.live.base.router.jumper.w0;
import com.cupidapp.live.base.router.jumper.x;
import com.cupidapp.live.base.router.jumper.x0;
import com.cupidapp.live.base.router.jumper.y;
import com.cupidapp.live.base.router.jumper.y0;
import com.cupidapp.live.base.router.jumper.z;
import com.cupidapp.live.base.web.WebStyleViewModel;
import com.cupidapp.live.base.web.activity.FKBaseWebActivity;
import com.cupidapp.live.base.web.activity.FKTransparentWebActivity;
import com.cupidapp.live.base.web.helper.WebUrlWhiteListHelper;
import com.cupidapp.live.liveshow.beauty.databeauty.UserData;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.i0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKRouter.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class j {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f12156c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final Map<String, Class<? extends h>> f12157d = i0.h(kotlin.f.a("accountLimited", com.cupidapp.live.base.router.jumper.a.class), kotlin.f.a("pay", PurchaseUrlJumper.class), kotlin.f.a("aliyun", f.class), kotlin.f.a("webview", WebActionJumper.class), kotlin.f.a("live", LiveUrlJumper.class), kotlin.f.a("visitor", y0.class), kotlin.f.a("closeFriend", com.cupidapp.live.base.router.jumper.e.class), kotlin.f.a("mapFilter", MapFilterUrlJumper.class), kotlin.f.a("chatStatus", com.cupidapp.live.base.router.jumper.d.class), kotlin.f.a("privateAlbum", n0.class), kotlin.f.a("personalPostList", PersonalPostListUrlJumper.class), kotlin.f.a("likedPhoto", v.class), kotlin.f.a("editIntroduce", com.cupidapp.live.base.router.jumper.k.class), kotlin.f.a("changeAppIcon", k0.class), kotlin.f.a("superBoostStatusChange", s0.class), kotlin.f.a(UserData.NAME, UserUrlJumper.class), kotlin.f.a("miniUser", c0.class), kotlin.f.a("message", b0.class), kotlin.f.a("newmatch", d0.class), kotlin.f.a("post", PostUrlJumper.class), kotlin.f.a("notify", e0.class), kotlin.f.a("Router", p0.class), kotlin.f.a("match", a0.class), kotlin.f.a("contact", com.cupidapp.live.base.router.jumper.i.class), kotlin.f.a("hashtag", s.class), kotlin.f.a("liveShow", LiveShowUrlJumper.class), kotlin.f.a("openAppStore", f0.class), kotlin.f.a("newhashtag", t.class), kotlin.f.a("paster", ImagePasterJumper.class), kotlin.f.a("pasteboardCopy", j0.class), kotlin.f.a("openapp", g0.class), kotlin.f.a("editProfile", com.cupidapp.live.base.router.jumper.m.class), kotlin.f.a("publishFeed", FeedPublishJumper.class), kotlin.f.a("vipPrivilege", x0.class), kotlin.f.a("bindPhoneNumber", com.cupidapp.live.base.router.jumper.c.class), kotlin.f.a("changeTabBar", u0.class), kotlin.f.a("matchFilter", z.class), kotlin.f.a("previewLiveShow", l0.class), kotlin.f.a("privacySetting", m0.class), kotlin.f.a("superLikePurchasePopup", t0.class), kotlin.f.a("vipPurchasePopup", w0.class), kotlin.f.a("share", q0.class), kotlin.f.a("storyLabel", p.class), kotlin.f.a("getReward", v0.class), kotlin.f.a("focusRelation", r.class), kotlin.f.a("openMaskGameSelectPage", y.class), kotlin.f.a("superBoostBuyAlert", r0.class), kotlin.f.a("liveShowSettings", x.class), kotlin.f.a("editPostLimit", com.cupidapp.live.base.router.jumper.l.class), kotlin.f.a("editFriendPraise", com.cupidapp.live.base.router.jumper.j.class), kotlin.f.a("openLiveShowFansGroup", h0.class), kotlin.f.a("completeIntroduction", com.cupidapp.live.base.router.jumper.n.class), kotlin.f.a("likedUnMatch", w.class), kotlin.f.a("contactManage", com.cupidapp.live.base.router.jumper.h.class), kotlin.f.a("alohaCancelList", com.cupidapp.live.base.router.jumper.b.class), kotlin.f.a("internalTestUse", u.class), kotlin.f.a("clubList", com.cupidapp.live.base.router.jumper.g.class), kotlin.f.a("clubGroupChat", com.cupidapp.live.base.router.jumper.f.class), kotlin.f.a("diamondRecharge", o0.class), kotlin.f.a("previewVoiceRoom", PreviewVoiceRoomJumper.class), kotlin.f.a("enterVoiceRoom", com.cupidapp.live.base.router.jumper.o.class), kotlin.f.a("openChatDetail", OpenChatDetailJumper.class), kotlin.f.a("feedClassify", q.class), kotlin.f.a("openWeChatMiniProgram", com.cupidapp.live.base.router.jumper.i0.class), kotlin.f.a("setTravelMode", TravelUseJumper.class), kotlin.f.a("openQRScan", OpenQRScanUrlJumper.class), kotlin.f.a("getLocation", LocationPermissionUrlJumper.class));

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final Context f12158a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final k f12159b = new k();

    /* compiled from: FKRouter.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void b(a aVar, Context context, String str, WebStyleViewModel webStyleViewModel, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                webStyleViewModel = null;
            }
            aVar.a(context, str, webStyleViewModel);
        }

        public final void a(@Nullable Context context, @Nullable String str, @Nullable WebStyleViewModel webStyleViewModel) {
            if (str != null) {
                if (str.length() == 0) {
                    return;
                }
                Uri uri = Uri.parse(str);
                if (kotlin.jvm.internal.s.d(uri.getScheme(), "finka2020")) {
                    j.e(new j(context), str, null, 2, null);
                } else if (WebUrlWhiteListHelper.f13094a.c(str)) {
                    kotlin.jvm.internal.s.h(uri, "uri");
                    c(context, str, uri, webStyleViewModel);
                } else {
                    d(context, str, webStyleViewModel);
                }
            }
        }

        public final void c(Context context, String str, Uri uri, WebStyleViewModel webStyleViewModel) {
            String queryParameter = uri.getQueryParameter("finkaAction");
            if (queryParameter == null || queryParameter.length() == 0) {
                d(context, str, webStyleViewModel);
            } else {
                a(context, queryParameter, webStyleViewModel);
            }
        }

        public final void d(Context context, String str, WebStyleViewModel webStyleViewModel) {
            List<Float> location;
            float[] fArr = null;
            if (StringsKt__StringsKt.K(str, "showTransparentBg", false, 2, null)) {
                FKTransparentWebActivity.a aVar = FKTransparentWebActivity.f13044w;
                if (webStyleViewModel != null && (location = webStyleViewModel.getLocation()) != null) {
                    fArr = CollectionsKt___CollectionsKt.v0(location);
                }
                FKTransparentWebActivity.a.b(aVar, context, str, false, fArr, 4, null);
                return;
            }
            FKBaseWebActivity.a aVar2 = FKBaseWebActivity.f13036s;
            if (webStyleViewModel == null) {
                webStyleViewModel = new WebStyleViewModel(null, false, null, 7, null);
            }
            aVar2.c(context, str, webStyleViewModel);
        }
    }

    public j(@Nullable Context context) {
        this.f12158a = context;
        g();
    }

    public static /* synthetic */ boolean e(j jVar, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        return jVar.d(str, str2);
    }

    public final boolean a(Uri uri) {
        return kotlin.jvm.internal.s.d(uri != null ? uri.getScheme() : null, "finka2020");
    }

    public final h b(Uri uri) {
        if (a(uri)) {
            return this.f12159b.a(uri.getHost());
        }
        return null;
    }

    public final boolean c(Uri uri, String str) {
        kotlin.p pVar;
        h b4 = b(uri);
        if (b4 != null) {
            b4.a(this.f12158a, uri, str);
            pVar = kotlin.p.f51048a;
        } else {
            pVar = null;
        }
        return pVar != null;
    }

    public final boolean d(@Nullable String str, @Nullable String str2) {
        if (str == null) {
            return false;
        }
        Uri parse = Uri.parse(str);
        kotlin.jvm.internal.s.h(parse, "parse(url)");
        return c(parse, str2);
    }

    public final void f(@NotNull Lifecycle lifecycle, @Nullable com.cupidapp.live.base.activity.h hVar) {
        kotlin.jvm.internal.s.i(lifecycle, "lifecycle");
        this.f12159b.b(lifecycle, hVar);
    }

    public final void g() {
        this.f12159b.c(f12157d);
    }
}
