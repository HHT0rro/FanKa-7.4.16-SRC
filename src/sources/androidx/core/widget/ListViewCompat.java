package androidx.core.widget;

import android.widget.ListView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ListViewCompat {

    @RequiresApi(19)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        public static boolean canScrollList(ListView listView, int i10) {
            return listView.canScrollList(i10);
        }

        @DoNotInline
        public static void scrollListBy(ListView listView, int i10) {
            listView.scrollListBy(i10);
        }
    }

    private ListViewCompat() {
    }

    public static boolean canScrollList(@NonNull ListView listView, int i10) {
        return Api19Impl.canScrollList(listView, i10);
    }

    public static void scrollListBy(@NonNull ListView listView, int i10) {
        Api19Impl.scrollListBy(listView, i10);
    }
}
