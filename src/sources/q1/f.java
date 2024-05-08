package q1;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LinkMovementClickMethod.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class f extends LinkMovementMethod {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f53013b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public static f f53014c;

    /* renamed from: a, reason: collision with root package name */
    public long f53015a;

    /* compiled from: LinkMovementClickMethod.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final f a() {
            if (f.f53014c == null) {
                f.f53014c = new f();
            }
            return f.f53014c;
        }
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(@NotNull TextView widget, @NotNull Spannable buffer, @NotNull MotionEvent event) {
        s.i(widget, "widget");
        s.i(buffer, "buffer");
        s.i(event, "event");
        int action = event.getAction();
        if (action == 0 || action == 1) {
            int x10 = (int) event.getX();
            int y10 = (int) event.getY();
            int totalPaddingLeft = x10 - widget.getTotalPaddingLeft();
            int totalPaddingTop = y10 - widget.getTotalPaddingTop();
            int scrollX = totalPaddingLeft + widget.getScrollX();
            int scrollY = totalPaddingTop + widget.getScrollY();
            Layout layout = widget.getLayout();
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
            ClickableSpan[] links = (ClickableSpan[]) buffer.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            s.h(links, "links");
            if (!(links.length == 0)) {
                ClickableSpan clickableSpan = links[0];
                if (action == 0) {
                    Selection.setSelection(buffer, buffer.getSpanStart(clickableSpan), buffer.getSpanEnd(clickableSpan));
                    this.f53015a = System.currentTimeMillis();
                } else if (action == 1 && System.currentTimeMillis() - this.f53015a < 500) {
                    clickableSpan.onClick(widget);
                }
                return true;
            }
            Selection.removeSelection(buffer);
        }
        return super.onTouchEvent(widget, buffer, event);
    }
}
