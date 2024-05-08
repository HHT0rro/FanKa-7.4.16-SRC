package android.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import com.android.internal.R;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.WeakHashMap;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
class SuggestionsAdapter extends ResourceCursorAdapter implements View.OnClickListener {
    private static final boolean DBG = false;
    private static final long DELETE_KEY_POST_DELAY = 500;
    static final int INVALID_INDEX = -1;
    private static final String LOG_TAG = "SuggestionsAdapter";
    private static final int QUERY_LIMIT = 50;
    static final int REFINE_ALL = 2;
    static final int REFINE_BY_ENTRY = 1;
    static final int REFINE_NONE = 0;
    private boolean mClosed;
    private final int mCommitIconResId;
    private int mFlagsCol;
    private int mIconName1Col;
    private int mIconName2Col;
    private final WeakHashMap<String, Drawable.ConstantState> mOutsideDrawablesCache;
    private final Context mProviderContext;
    private int mQueryRefinement;
    private final SearchManager mSearchManager;
    private final SearchView mSearchView;
    private final SearchableInfo mSearchable;
    private int mText1Col;
    private int mText2Col;
    private int mText2UrlCol;
    private ColorStateList mUrlColor;

    public SuggestionsAdapter(Context context, SearchView searchView, SearchableInfo searchable, WeakHashMap<String, Drawable.ConstantState> outsideDrawablesCache) {
        super(context, searchView.getSuggestionRowLayout(), (Cursor) null, true);
        this.mClosed = false;
        this.mQueryRefinement = 1;
        this.mText1Col = -1;
        this.mText2Col = -1;
        this.mText2UrlCol = -1;
        this.mIconName1Col = -1;
        this.mIconName2Col = -1;
        this.mFlagsCol = -1;
        this.mSearchManager = (SearchManager) this.mContext.getSystemService("search");
        this.mSearchView = searchView;
        this.mSearchable = searchable;
        this.mCommitIconResId = searchView.getSuggestionCommitIconResId();
        Context activityContext = searchable.getActivityContext(this.mContext);
        this.mProviderContext = searchable.getProviderContext(this.mContext, activityContext);
        this.mOutsideDrawablesCache = outsideDrawablesCache;
        getFilter().setDelayer(new Filter.Delayer() { // from class: android.widget.SuggestionsAdapter.1
            private int mPreviousLength = 0;

            @Override // android.widget.Filter.Delayer
            public long getPostingDelay(CharSequence constraint) {
                if (constraint == null) {
                    return 0L;
                }
                long delay = constraint.length() < this.mPreviousLength ? 500L : 0L;
                this.mPreviousLength = constraint.length();
                return delay;
            }
        });
    }

    public void setQueryRefinement(int refineWhat) {
        this.mQueryRefinement = refineWhat;
    }

    public int getQueryRefinement() {
        return this.mQueryRefinement;
    }

    @Override // android.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.CursorAdapter, android.widget.CursorFilter.CursorFilterClient
    public Cursor runQueryOnBackgroundThread(CharSequence constraint) {
        String query = constraint == null ? "" : constraint.toString();
        if (this.mSearchView.getVisibility() != 0 || this.mSearchView.getWindowVisibility() != 0) {
            return null;
        }
        try {
            Cursor cursor = this.mSearchManager.getSuggestions(this.mSearchable, query, 50);
            if (cursor != null) {
                cursor.getCount();
                return cursor;
            }
        } catch (RuntimeException e2) {
            Log.w(LOG_TAG, "Search suggestions query threw an exception.", e2);
        }
        return null;
    }

    public void close() {
        changeCursor(null);
        this.mClosed = true;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        updateSpinnerState(getCursor());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        updateSpinnerState(getCursor());
    }

    private void updateSpinnerState(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    @Override // android.widget.CursorAdapter, android.widget.CursorFilter.CursorFilterClient
    public void changeCursor(Cursor c4) {
        if (this.mClosed) {
            Log.w(LOG_TAG, "Tried to change cursor after adapter was closed.");
            if (c4 != null) {
                c4.close();
                return;
            }
            return;
        }
        try {
            super.changeCursor(c4);
            if (c4 != null) {
                this.mText1Col = c4.getColumnIndex("suggest_text_1");
                this.mText2Col = c4.getColumnIndex("suggest_text_2");
                this.mText2UrlCol = c4.getColumnIndex("suggest_text_2_url");
                this.mIconName1Col = c4.getColumnIndex("suggest_icon_1");
                this.mIconName2Col = c4.getColumnIndex("suggest_icon_2");
                this.mFlagsCol = c4.getColumnIndex("suggest_flags");
            }
        } catch (Exception e2) {
            Log.e(LOG_TAG, "error changing cursor and caching columns", e2);
        }
    }

    @Override // android.widget.ResourceCursorAdapter, android.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View v2 = super.newView(context, cursor, parent);
        v2.setTag(new ChildViewCache(v2));
        ImageView iconRefine = (ImageView) v2.findViewById(16908979);
        iconRefine.setImageResource(this.mCommitIconResId);
        return v2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class ChildViewCache {
        public final ImageView mIcon1;
        public final ImageView mIcon2;
        public final ImageView mIconRefine;
        public final TextView mText1;
        public final TextView mText2;

        public ChildViewCache(View v2) {
            this.mText1 = (TextView) v2.findViewById(16908308);
            this.mText2 = (TextView) v2.findViewById(16908309);
            this.mIcon1 = (ImageView) v2.findViewById(16908295);
            this.mIcon2 = (ImageView) v2.findViewById(16908296);
            this.mIconRefine = (ImageView) v2.findViewById(16908979);
        }
    }

    @Override // android.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        CharSequence text2;
        ChildViewCache views = (ChildViewCache) view.getTag();
        int flags = 0;
        int i10 = this.mFlagsCol;
        if (i10 != -1) {
            flags = cursor.getInt(i10);
        }
        if (views.mText1 != null) {
            String text1 = getStringOrNull(cursor, this.mText1Col);
            setViewText(views.mText1, text1);
        }
        if (views.mText2 != null) {
            CharSequence text22 = getStringOrNull(cursor, this.mText2UrlCol);
            if (text22 != null) {
                text2 = formatUrl(context, text22);
            } else {
                text2 = getStringOrNull(cursor, this.mText2Col);
            }
            if (TextUtils.isEmpty(text2)) {
                if (views.mText1 != null) {
                    views.mText1.setSingleLine(false);
                    views.mText1.setMaxLines(2);
                }
            } else if (views.mText1 != null) {
                views.mText1.setSingleLine(true);
                views.mText1.setMaxLines(1);
            }
            setViewText(views.mText2, text2);
        }
        if (views.mIcon1 != null) {
            setViewDrawable(views.mIcon1, getIcon1(cursor), 4);
        }
        if (views.mIcon2 != null) {
            setViewDrawable(views.mIcon2, getIcon2(cursor), 8);
        }
        int i11 = this.mQueryRefinement;
        if (i11 == 2 || (i11 == 1 && (flags & 1) != 0)) {
            views.mIconRefine.setVisibility(0);
            views.mIconRefine.setTag(views.mText1.getText());
            views.mIconRefine.setOnClickListener(this);
            return;
        }
        views.mIconRefine.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v2) {
        Object tag = v2.getTag();
        if (tag instanceof CharSequence) {
            this.mSearchView.onQueryRefine((CharSequence) tag);
        }
    }

    private CharSequence formatUrl(Context context, CharSequence url) {
        if (this.mUrlColor == null) {
            TypedValue colorValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.textColorSearchUrl, colorValue, true);
            this.mUrlColor = context.getColorStateList(colorValue.resourceId);
        }
        SpannableString text = new SpannableString(url);
        text.setSpan(new TextAppearanceSpan(null, 0, 0, this.mUrlColor, null), 0, url.length(), 33);
        return text;
    }

    private void setViewText(TextView v2, CharSequence text) {
        v2.setText(text);
        if (TextUtils.isEmpty(text)) {
            v2.setVisibility(8);
        } else {
            v2.setVisibility(0);
        }
    }

    private Drawable getIcon1(Cursor cursor) {
        int i10 = this.mIconName1Col;
        if (i10 == -1) {
            return null;
        }
        String value = cursor.getString(i10);
        Drawable drawable = getDrawableFromResourceValue(value);
        if (drawable != null) {
            return drawable;
        }
        return getDefaultIcon1(cursor);
    }

    private Drawable getIcon2(Cursor cursor) {
        int i10 = this.mIconName2Col;
        if (i10 == -1) {
            return null;
        }
        String value = cursor.getString(i10);
        return getDrawableFromResourceValue(value);
    }

    private void setViewDrawable(ImageView v2, Drawable drawable, int nullVisibility) {
        v2.setImageDrawable(drawable);
        if (drawable == null) {
            v2.setVisibility(nullVisibility);
            return;
        }
        v2.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    @Override // android.widget.CursorAdapter, android.widget.CursorFilter.CursorFilterClient
    public CharSequence convertToString(Cursor cursor) {
        String text1;
        String data;
        if (cursor == null) {
            return null;
        }
        String query = getColumnString(cursor, "suggest_intent_query");
        if (query != null) {
            return query;
        }
        if (this.mSearchable.shouldRewriteQueryFromData() && (data = getColumnString(cursor, "suggest_intent_data")) != null) {
            return data;
        }
        if (!this.mSearchable.shouldRewriteQueryFromText() || (text1 = getColumnString(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return text1;
    }

    @Override // android.widget.CursorAdapter, android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        try {
            return super.getView(position, convertView, parent);
        } catch (RuntimeException e2) {
            Log.w(LOG_TAG, "Search suggestions cursor threw exception.", e2);
            View v2 = newView(this.mContext, this.mCursor, parent);
            if (v2 != null) {
                ChildViewCache views = (ChildViewCache) v2.getTag();
                TextView tv = views.mText1;
                tv.setText(e2.toString());
            }
            return v2;
        }
    }

    @Override // android.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        try {
            return super.getDropDownView(position, convertView, parent);
        } catch (RuntimeException e2) {
            Log.w(LOG_TAG, "Search suggestions cursor threw exception.", e2);
            Context context = this.mDropDownContext == null ? this.mContext : this.mDropDownContext;
            View v2 = newDropDownView(context, this.mCursor, parent);
            if (v2 != null) {
                ChildViewCache views = (ChildViewCache) v2.getTag();
                TextView tv = views.mText1;
                tv.setText(e2.toString());
            }
            return v2;
        }
    }

    private Drawable getDrawableFromResourceValue(String drawableId) {
        if (drawableId == null || drawableId.length() == 0 || "0".equals(drawableId)) {
            return null;
        }
        try {
            int resourceId = Integer.parseInt(drawableId);
            String drawableUri = "android.resource://" + this.mProviderContext.getPackageName() + "/" + resourceId;
            Drawable drawable = checkIconCache(drawableUri);
            if (drawable != null) {
                return drawable;
            }
            Drawable drawable2 = this.mProviderContext.getDrawable(resourceId);
            storeInIconCache(drawableUri, drawable2);
            return drawable2;
        } catch (Resources.NotFoundException e2) {
            Log.w(LOG_TAG, "Icon resource not found: " + drawableId);
            return null;
        } catch (NumberFormatException e10) {
            Drawable drawable3 = checkIconCache(drawableId);
            if (drawable3 != null) {
                return drawable3;
            }
            Uri uri = Uri.parse(drawableId);
            Drawable drawable4 = getDrawable(uri);
            storeInIconCache(drawableId, drawable4);
            return drawable4;
        }
    }

    private Drawable getDrawable(Uri uri) {
        try {
            String scheme = uri.getScheme();
            if ("android.resource".equals(scheme)) {
                ContentResolver.OpenResourceIdResult r10 = this.mProviderContext.getContentResolver().getResourceId(uri);
                try {
                    return r10.r.getDrawable(r10.id, this.mProviderContext.getTheme());
                } catch (Resources.NotFoundException e2) {
                    throw new FileNotFoundException("Resource does not exist: " + ((Object) uri));
                }
            }
            InputStream stream = this.mProviderContext.getContentResolver().openInputStream(uri);
            if (stream == null) {
                throw new FileNotFoundException("Failed to open " + ((Object) uri));
            }
            try {
                return Drawable.createFromStream(stream, null);
            } finally {
                try {
                    stream.close();
                } catch (IOException ex) {
                    Log.e(LOG_TAG, "Error closing icon stream for " + ((Object) uri), ex);
                }
            }
        } catch (FileNotFoundException fnfe) {
            Log.w(LOG_TAG, "Icon not found: " + ((Object) uri) + ", " + fnfe.getMessage());
            return null;
        }
        Log.w(LOG_TAG, "Icon not found: " + ((Object) uri) + ", " + fnfe.getMessage());
        return null;
    }

    private Drawable checkIconCache(String resourceUri) {
        Drawable.ConstantState cached = this.mOutsideDrawablesCache.get(resourceUri);
        if (cached == null) {
            return null;
        }
        return cached.newDrawable();
    }

    private void storeInIconCache(String resourceUri, Drawable drawable) {
        if (drawable != null) {
            this.mOutsideDrawablesCache.put(resourceUri, drawable.getConstantState());
        }
    }

    private Drawable getDefaultIcon1(Cursor cursor) {
        Drawable drawable = getActivityIconWithCache(this.mSearchable.getSearchActivity());
        if (drawable != null) {
            return drawable;
        }
        return this.mContext.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable getActivityIconWithCache(ComponentName component) {
        String componentIconKey = component.flattenToShortString();
        if (this.mOutsideDrawablesCache.containsKey(componentIconKey)) {
            Drawable.ConstantState cached = this.mOutsideDrawablesCache.get(componentIconKey);
            if (cached == null) {
                return null;
            }
            return cached.newDrawable(this.mProviderContext.getResources());
        }
        Drawable drawable = getActivityIcon(component);
        Drawable.ConstantState toCache = drawable != null ? drawable.getConstantState() : null;
        this.mOutsideDrawablesCache.put(componentIconKey, toCache);
        return drawable;
    }

    private Drawable getActivityIcon(ComponentName component) {
        PackageManager pm = this.mContext.getPackageManager();
        try {
            ActivityInfo activityInfo = pm.getActivityInfo(component, 128);
            int iconId = activityInfo.getIconResource();
            if (iconId == 0) {
                return null;
            }
            String pkg = component.getPackageName();
            Drawable drawable = pm.getDrawable(pkg, iconId, activityInfo.applicationInfo);
            if (drawable == null) {
                Log.w(LOG_TAG, "Invalid icon resource " + iconId + " for " + component.flattenToShortString());
                return null;
            }
            return drawable;
        } catch (PackageManager.NameNotFoundException ex) {
            Log.w(LOG_TAG, ex.toString());
            return null;
        }
    }

    public static String getColumnString(Cursor cursor, String columnName) {
        int col = cursor.getColumnIndex(columnName);
        return getStringOrNull(cursor, col);
    }

    private static String getStringOrNull(Cursor cursor, int col) {
        if (col == -1) {
            return null;
        }
        try {
            return cursor.getString(col);
        } catch (Exception e2) {
            Log.e(LOG_TAG, "unexpected error retrieving valid column from cursor, did the remote process die?", e2);
            return null;
        }
    }
}
