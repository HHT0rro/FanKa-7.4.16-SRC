package androidx.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Collections;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class DataBinderMapper {
    @NonNull
    public List<DataBinderMapper> collectDependencies() {
        return Collections.emptyList();
    }

    public abstract String convertBrIdToString(int i10);

    public abstract ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i10);

    public abstract ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i10);

    public abstract int getLayoutId(String str);
}
