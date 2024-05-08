package o1;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.view.View;
import com.cupidapp.live.base.network.model.ConstantsResult;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import p1.g;

/* compiled from: GrayUtils.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f52250a = new a();

    public final void a(@NotNull View view) {
        s.i(view, "view");
        ConstantsResult q10 = g.f52734a.q();
        if (q10 != null ? s.d(q10.getGrayModeOpen(), Boolean.TRUE) : false) {
            Paint paint = new Paint();
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(0.0f);
            paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            view.setLayerType(2, paint);
        }
    }
}
