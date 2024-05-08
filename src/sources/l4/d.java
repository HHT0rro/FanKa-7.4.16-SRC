package l4;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import com.github.sahasbhop.apngview.R$id;
import com.github.sahasbhop.flog.FLog;
import com.nostra13.universalimageloader.core.assist.FailReason;
import java.io.File;

/* compiled from: ApngImageLoadingListener.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class d implements nb.a {

    /* renamed from: a, reason: collision with root package name */
    public c f51619a;

    /* renamed from: b, reason: collision with root package name */
    public Context f51620b;

    /* renamed from: c, reason: collision with root package name */
    public Uri f51621c;

    public d(Context context, Uri uri, c cVar) {
        this.f51620b = context;
        this.f51621c = uri;
        this.f51619a = cVar;
    }

    @Override // nb.a
    public void a(String str, View view, FailReason failReason) {
        if (view == null) {
            return;
        }
        int i10 = R$id.tag_image;
        Object tag = view.getTag(i10);
        if (k4.b.f50646g) {
            FLog.a("tag: %s", tag);
        }
        view.setTag(i10, null);
        if (b()) {
            this.f51619a.a(false, str, view);
        }
    }

    public final boolean b() {
        return this.f51619a != null;
    }

    @Override // nb.a
    public void onLoadingCancelled(String str, View view) {
        if (view == null) {
            return;
        }
        int i10 = R$id.tag_image;
        Object tag = view.getTag(i10);
        if (k4.b.f50646g) {
            FLog.a("tag: %s", tag);
        }
        view.setTag(i10, null);
        if (b()) {
            this.f51619a.a(false, str, view);
        }
    }

    @Override // nb.a
    public void onLoadingComplete(String str, View view, Bitmap bitmap) {
        if (view == null) {
            return;
        }
        Object tag = view.getTag(R$id.tag_image);
        if (k4.b.f50646g) {
            FLog.a("tag: %s", tag);
        }
        if (tag != null && (tag instanceof String)) {
            String obj = tag.toString();
            File d10 = f.d(this.f51620b, obj);
            if (d10 == null) {
                if (k4.b.f50646g) {
                    FLog.h("Can't locate the file!!! %s", obj);
                }
            } else if (d10.exists()) {
                if (f.g(d10)) {
                    if (k4.b.f50646g) {
                        FLog.a("Setup apng drawable", new Object[0]);
                    }
                    ((ImageView) view).setImageDrawable(new k4.a(this.f51620b, bitmap, Uri.fromFile(d10)));
                } else {
                    ((ImageView) view).setImageBitmap(bitmap);
                }
            } else {
                if (k4.b.f50646g) {
                    FLog.a("Clear cache and reload", new Object[0]);
                }
                pb.e.c(obj, k4.b.p().f());
                pb.a.a(obj, k4.b.p().e());
                k4.b.p().c(obj, (ImageView) view, this);
            }
        }
        if (b()) {
            this.f51619a.a(true, str, view);
        }
    }

    @Override // nb.a
    public void onLoadingStarted(String str, View view) {
        if (view == null) {
            return;
        }
        view.setTag(R$id.tag_image, this.f51621c.toString());
    }
}
