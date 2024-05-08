package android.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class SimpleCursorTreeAdapter extends ResourceCursorTreeAdapter {
    private int[] mChildFrom;
    private String[] mChildFromNames;
    private int[] mChildTo;
    private int[] mGroupFrom;
    private String[] mGroupFromNames;
    private int[] mGroupTo;
    private ViewBinder mViewBinder;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface ViewBinder {
        boolean setViewValue(View view, Cursor cursor, int i10);
    }

    public SimpleCursorTreeAdapter(Context context, Cursor cursor, int collapsedGroupLayout, int expandedGroupLayout, String[] groupFrom, int[] groupTo, int childLayout, int lastChildLayout, String[] childFrom, int[] childTo) {
        super(context, cursor, collapsedGroupLayout, expandedGroupLayout, childLayout, lastChildLayout);
        init(groupFrom, groupTo, childFrom, childTo);
    }

    public SimpleCursorTreeAdapter(Context context, Cursor cursor, int collapsedGroupLayout, int expandedGroupLayout, String[] groupFrom, int[] groupTo, int childLayout, String[] childFrom, int[] childTo) {
        super(context, cursor, collapsedGroupLayout, expandedGroupLayout, childLayout);
        init(groupFrom, groupTo, childFrom, childTo);
    }

    public SimpleCursorTreeAdapter(Context context, Cursor cursor, int groupLayout, String[] groupFrom, int[] groupTo, int childLayout, String[] childFrom, int[] childTo) {
        super(context, cursor, groupLayout, childLayout);
        init(groupFrom, groupTo, childFrom, childTo);
    }

    private void init(String[] groupFromNames, int[] groupTo, String[] childFromNames, int[] childTo) {
        this.mGroupFromNames = groupFromNames;
        this.mGroupTo = groupTo;
        this.mChildFromNames = childFromNames;
        this.mChildTo = childTo;
    }

    public ViewBinder getViewBinder() {
        return this.mViewBinder;
    }

    public void setViewBinder(ViewBinder viewBinder) {
        this.mViewBinder = viewBinder;
    }

    private void bindView(View view, Context context, Cursor cursor, int[] from, int[] to) {
        ViewBinder binder = this.mViewBinder;
        for (int i10 = 0; i10 < to.length; i10++) {
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
                        throw new IllegalStateException("SimpleCursorTreeAdapter can bind values only to TextView and ImageView!");
                    }
                }
            }
        }
    }

    private void initFromColumns(Cursor cursor, String[] fromColumnNames, int[] fromColumns) {
        for (int i10 = fromColumnNames.length - 1; i10 >= 0; i10--) {
            fromColumns[i10] = cursor.getColumnIndexOrThrow(fromColumnNames[i10]);
        }
    }

    @Override // android.widget.CursorTreeAdapter
    protected void bindChildView(View view, Context context, Cursor cursor, boolean isLastChild) {
        if (this.mChildFrom == null) {
            String[] strArr = this.mChildFromNames;
            int[] iArr = new int[strArr.length];
            this.mChildFrom = iArr;
            initFromColumns(cursor, strArr, iArr);
        }
        bindView(view, context, cursor, this.mChildFrom, this.mChildTo);
    }

    @Override // android.widget.CursorTreeAdapter
    protected void bindGroupView(View view, Context context, Cursor cursor, boolean isExpanded) {
        if (this.mGroupFrom == null) {
            String[] strArr = this.mGroupFromNames;
            int[] iArr = new int[strArr.length];
            this.mGroupFrom = iArr;
            initFromColumns(cursor, strArr, iArr);
        }
        bindView(view, context, cursor, this.mGroupFrom, this.mGroupTo);
    }

    protected void setViewImage(ImageView v2, String value) {
        try {
            v2.setImageResource(Integer.parseInt(value));
        } catch (NumberFormatException e2) {
            v2.setImageURI(Uri.parse(value));
        }
    }

    public void setViewText(TextView v2, String text) {
        v2.setText(text);
    }
}
