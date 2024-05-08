package q3;

import android.view.ViewGroup;
import androidx.annotation.FloatRange;
import com.cupidapp.live.smartrefresh.layout.constant.RefreshState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RefreshLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface d {
    @Nullable
    d a(boolean z10);

    @Nullable
    d b(@FloatRange(from = 1.0d, to = 10.0d) float f10);

    @NotNull
    ViewGroup getLayout();

    @NotNull
    RefreshState getState();
}
