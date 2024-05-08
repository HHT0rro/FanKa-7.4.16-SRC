package android.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class SimpleCursorAdapter extends ResourceCursorAdapter {
    private CursorToStringConverter mCursorToStringConverter;
    protected int[] mFrom;
    String[] mOriginalFrom;
    private int mStringConversionColumn;
    protected int[] mTo;
    private ViewBinder mViewBinder;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface CursorToStringConverter {
        CharSequence convertToString(Cursor cursor);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface ViewBinder {
        boolean setViewValue(View view, Cursor cursor, int i10);
    }

    @Deprecated
    public SimpleCursorAdapter(Context context, int layout, Cursor c4, String[] from, int[] to) {
        super(context, layout, c4);
        this.mStringConversionColumn = -1;
        this.mTo = to;
        this.mOriginalFrom = from;
        findColumns(c4, from);
    }

    public SimpleCursorAdapter(Context context, int layout, Cursor c4, String[] from, int[] to, int flags) {
        super(context, layout, c4, flags);
        this.mStringConversionColumn = -1;
        this.mTo = to;
        this.mOriginalFrom = from;
        findColumns(c4, from);
    }

    @Override // android.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        ViewBinder binder = this.mViewBinder;
        int count = this.mTo.length;
        int[] from = this.mFrom;
        int[] to = this.mTo;
        for (int i10 = 0; i10 < count; i10++) {
            View v2 = view.findViewById(to[i10]);
            if (v2 != null) {
                boolean bound = false;
                if (binder != null) {
                    bound = binder.setViewValue(v2, cursor, from[i10]);
                }
                if (bound) {
                    continue;
                } else {
                    String text = cursor.getString(from[i10]);
                    if (text == null) {
                        text = "";
                    }
                    if (v2 instanceof TextView) {
                        setViewText((TextView) v2, text);
                    } else if (v2 instanceof ImageView) {
                        setViewImage((ImageView) v2, text);
                    } else {
                        throw new IllegalStateException(v2.getClass().getName() + " is not a  view that can be bounds by this SimpleCursorAdapter");
                    }
                }
            }
        }
    }

    public ViewBinder getViewBinder() {
        return this.mViewBinder;
    }

    public void setViewBinder(ViewBinder viewBinder) {
        this.mViewBinder = viewBinder;
    }

    public void setViewImage(ImageView v2, String value) {
        try {
            v2.setImageResource(Integer.parseInt(value));
        } catch (NumberFormatException e2) {
            v2.setImageURI(Uri.parse(value));
        }
    }

    public void setViewText(TextView v2, String text) {
        v2.setText(text);
    }

    public int getStringConversionColumn() {
        return this.mStringConversionColumn;
    }

    public void setStringConversionColumn(int stringConversionColumn) {
        this.mStringConversionColumn = stringConversionColumn;
    }

    public CursorToStringConverter getCursorToStringConverter() {
        return this.mCursorToStringConverter;
    }

    public void setCursorToStringConverter(CursorToStringConverter cursorToStringConverter) {
        this.mCursorToStringConverter = cursorToStringConverter;
    }

    @Override // android.widget.CursorAdapter, android.widget.CursorFilter.CursorFilterClient
    public CharSequence convertToString(Cursor cursor) {
        CursorToStringConverter cursorToStringConverter = this.mCursorToStringConverter;
        if (cursorToStringConverter != null) {
            return cursorToStringConverter.convertToString(cursor);
        }
        int i10 = this.mStringConversionColumn;
        if (i10 > -1) {
            return cursor.getString(i10);
        }
        return super.convertToString(cursor);
    }

    private void findColumns(Cursor c4, String[] from) {
        if (c4 != null) {
            int count = from.length;
            int[] iArr = this.mFrom;
            if (iArr == null || iArr.length != count) {
                this.mFrom = new int[count];
            }
            for (int i10 = 0; i10 < count; i10++) {
                this.mFrom[i10] = c4.getColumnIndexOrThrow(from[i10]);
            }
            return;
        }
        this.mFrom = null;
    }

    @Override // android.widget.CursorAdapter
    public Cursor swapCursor(Cursor c4) {
        findColumns(c4, this.mOriginalFrom);
        return super.swapCursor(c4);
    }

    public void changeCursorAndColumns(Cursor c4, String[] from, int[] to) {
        this.mOriginalFrom = from;
        this.mTo = to;
        findColumns(c4, from);
        super.changeCursor(c4);
    }
}
