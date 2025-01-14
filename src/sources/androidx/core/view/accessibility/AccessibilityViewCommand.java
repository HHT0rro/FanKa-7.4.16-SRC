package androidx.core.view.accessibility;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface AccessibilityViewCommand {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static abstract class CommandArguments {
        public Bundle mBundle;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void setBundle(@Nullable Bundle bundle) {
            this.mBundle = bundle;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class MoveAtGranularityArguments extends CommandArguments {
        public boolean getExtendSelection() {
            return this.mBundle.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
        }

        public int getGranularity() {
            return this.mBundle.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class MoveHtmlArguments extends CommandArguments {
        @Nullable
        public String getHTMLElement() {
            return this.mBundle.getString("ACTION_ARGUMENT_HTML_ELEMENT_STRING");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class MoveWindowArguments extends CommandArguments {
        public int getX() {
            return this.mBundle.getInt("ACTION_ARGUMENT_MOVE_WINDOW_X");
        }

        public int getY() {
            return this.mBundle.getInt("ACTION_ARGUMENT_MOVE_WINDOW_Y");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class ScrollToPositionArguments extends CommandArguments {
        public int getColumn() {
            return this.mBundle.getInt("android.view.accessibility.action.ARGUMENT_COLUMN_INT");
        }

        public int getRow() {
            return this.mBundle.getInt("android.view.accessibility.action.ARGUMENT_ROW_INT");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class SetProgressArguments extends CommandArguments {
        public float getProgress() {
            return this.mBundle.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class SetSelectionArguments extends CommandArguments {
        public int getEnd() {
            return this.mBundle.getInt("ACTION_ARGUMENT_SELECTION_END_INT");
        }

        public int getStart() {
            return this.mBundle.getInt("ACTION_ARGUMENT_SELECTION_START_INT");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class SetTextArguments extends CommandArguments {
        @Nullable
        public CharSequence getText() {
            return this.mBundle.getCharSequence("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE");
        }
    }

    boolean perform(@NonNull View view, @Nullable CommandArguments commandArguments);
}
