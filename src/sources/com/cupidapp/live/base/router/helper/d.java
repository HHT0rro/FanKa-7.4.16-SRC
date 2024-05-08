package com.cupidapp.live.base.router.helper;

import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.permission.PermissionType;
import com.cupidapp.live.base.permission.RxPermissionHelperKt;
import com.cupidapp.live.base.permission.b;
import com.cupidapp.live.base.router.helper.d;
import com.huawei.quickcard.base.Attributes;
import java.net.URLDecoder;
import kotlin.collections.r;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.k;
import z0.n;

/* compiled from: WebActionDownloadHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f12144a = new d();

    /* compiled from: WebActionDownloadHelper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements n {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f12145a;

        public a(FragmentActivity fragmentActivity) {
            this.f12145a = fragmentActivity;
        }

        public static final void d(FragmentActivity activity) {
            s.i(activity, "$activity");
            com.cupidapp.live.base.view.h.f12779a.c(activity, R$string.image_download_failed);
        }

        public static final void e(FragmentActivity activity) {
            s.i(activity, "$activity");
            com.cupidapp.live.base.view.h.f12779a.c(activity, R$string.image_download_success);
        }

        @Override // z0.n
        public void a(@NotNull Uri uri) {
            s.i(uri, "uri");
            final FragmentActivity fragmentActivity = this.f12145a;
            fragmentActivity.runOnUiThread(new Runnable() { // from class: com.cupidapp.live.base.router.helper.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.a.e(FragmentActivity.this);
                }
            });
        }

        @Override // z0.n
        public void error(@Nullable String str) {
            final FragmentActivity fragmentActivity = this.f12145a;
            fragmentActivity.runOnUiThread(new Runnable() { // from class: com.cupidapp.live.base.router.helper.b
                @Override // java.lang.Runnable
                public final void run() {
                    d.a.d(FragmentActivity.this);
                }
            });
        }
    }

    /* compiled from: WebActionDownloadHelper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements com.cupidapp.live.base.permission.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f12146a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Uri f12147b;

        public b(FragmentActivity fragmentActivity, Uri uri) {
            this.f12146a = fragmentActivity;
            this.f12147b = uri;
        }

        @Override // com.cupidapp.live.base.permission.b
        public void a() {
            d.f12144a.b(this.f12146a, this.f12147b);
        }

        @Override // com.cupidapp.live.base.permission.b
        public void b() {
            b.a.b(this);
        }

        @Override // com.cupidapp.live.base.permission.b
        public void c() {
            com.cupidapp.live.base.view.h.f12779a.r(this.f12146a, R$string.no_storage_permission);
        }

        @Override // com.cupidapp.live.base.permission.b
        public void d() {
            b.a.a(this);
        }
    }

    public final void b(FragmentActivity fragmentActivity, Uri uri) {
        if (s.d(uri.getQueryParameter("type"), Attributes.Component.IMAGE)) {
            String decode = URLDecoder.decode(uri.getQueryParameter("url"), "utf-8");
            if (decode == null || decode.length() == 0) {
                return;
            }
            k.f54819a.l(fragmentActivity, decode, new a(fragmentActivity));
        }
    }

    public final void c(@NotNull FragmentActivity activity, @NotNull Uri uri) {
        s.i(activity, "activity");
        s.i(uri, "uri");
        RxPermissionHelperKt.m(activity, new xb.b(activity), r.e(PermissionType.StoragePermission), new b(activity, uri), false, 16, null);
    }
}
