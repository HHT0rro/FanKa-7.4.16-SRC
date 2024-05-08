package android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class SimpleAdapter extends BaseAdapter implements Filterable, ThemedSpinnerAdapter {
    private List<? extends Map<String, ?>> mData;
    private LayoutInflater mDropDownInflater;
    private int mDropDownResource;
    private SimpleFilter mFilter;
    private String[] mFrom;
    private final LayoutInflater mInflater;
    private int mResource;
    private int[] mTo;
    private ArrayList<Map<String, ?>> mUnfilteredData;
    private ViewBinder mViewBinder;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface ViewBinder {
        boolean setViewValue(View view, Object obj, String str);
    }

    public SimpleAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
        this.mData = data;
        this.mDropDownResource = resource;
        this.mResource = resource;
        this.mFrom = from;
        this.mTo = to;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mData.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        return this.mData.get(position);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        return createViewFromResource(this.mInflater, position, convertView, parent, this.mResource);
    }

    private View createViewFromResource(LayoutInflater inflater, int position, View convertView, ViewGroup parent, int resource) {
        View v2;
        if (convertView == null) {
            v2 = inflater.inflate(resource, parent, false);
        } else {
            v2 = convertView;
        }
        bindView(position, v2);
        return v2;
    }

    public void setDropDownViewResource(int resource) {
        this.mDropDownResource = resource;
    }

    @Override // android.widget.ThemedSpinnerAdapter
    public void setDropDownViewTheme(Resources.Theme theme) {
        if (theme == null) {
            this.mDropDownInflater = null;
        } else if (theme == this.mInflater.getContext().getTheme()) {
            this.mDropDownInflater = this.mInflater;
        } else {
            Context context = new ContextThemeWrapper(this.mInflater.getContext(), theme);
            this.mDropDownInflater = LayoutInflater.from(context);
        }
    }

    @Override // android.widget.ThemedSpinnerAdapter
    public Resources.Theme getDropDownViewTheme() {
        LayoutInflater layoutInflater = this.mDropDownInflater;
        if (layoutInflater == null) {
            return null;
        }
        return layoutInflater.getContext().getTheme();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = this.mDropDownInflater;
        if (layoutInflater == null) {
            layoutInflater = this.mInflater;
        }
        LayoutInflater inflater = layoutInflater;
        return createViewFromResource(inflater, position, convertView, parent, this.mDropDownResource);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void bindView(int position, View view) {
        Map dataSet = this.mData.get(position);
        if (dataSet == null) {
            return;
        }
        ViewBinder viewBinder = this.mViewBinder;
        String[] from = this.mFrom;
        int[] to = this.mTo;
        int count = to.length;
        for (int i10 = 0; i10 < count; i10++) {
            View findViewById = view.findViewById(to[i10]);
            if (findViewById != 0) {
                Object data = dataSet.get(from[i10]);
                String text = data == null ? "" : data.toString();
                if (text == null) {
                    text = "";
                }
                boolean bound = false;
                if (viewBinder != null) {
                    bound = viewBinder.setViewValue(findViewById, data, text);
                }
                if (bound) {
                    continue;
                } else if (findViewById instanceof Checkable) {
                    if (data instanceof Boolean) {
                        ((Checkable) findViewById).setChecked(((Boolean) data).booleanValue());
                    } else if (findViewById instanceof TextView) {
                        setViewText((TextView) findViewById, text);
                    } else {
                        throw new IllegalStateException(findViewById.getClass().getName() + " should be bound to a Boolean, not a " + (data == null ? "<unknown type>" : data.getClass()));
                    }
                } else if (findViewById instanceof TextView) {
                    setViewText((TextView) findViewById, text);
                } else if (findViewById instanceof ImageView) {
                    if (data instanceof Integer) {
                        setViewImage((ImageView) findViewById, ((Integer) data).intValue());
                    } else {
                        setViewImage((ImageView) findViewById, text);
                    }
                } else {
                    throw new IllegalStateException(findViewById.getClass().getName() + " is not a  view that can be bounds by this SimpleAdapter");
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

    public void setViewImage(ImageView v2, int value) {
        v2.setImageResource(value);
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

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.mFilter == null) {
            this.mFilter = new SimpleFilter();
        }
        return this.mFilter;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private class SimpleFilter extends Filter {
        private SimpleFilter() {
        }

        @Override // android.widget.Filter
        protected Filter.FilterResults performFiltering(CharSequence prefix) {
            Filter.FilterResults results = new Filter.FilterResults();
            if (SimpleAdapter.this.mUnfilteredData == null) {
                SimpleAdapter.this.mUnfilteredData = new ArrayList(SimpleAdapter.this.mData);
            }
            if (prefix == null || prefix.length() == 0) {
                ArrayList<Map<String, ?>> list = SimpleAdapter.this.mUnfilteredData;
                results.values = list;
                results.count = list.size();
            } else {
                String prefixString = prefix.toString().toLowerCase();
                ArrayList<Map<String, ?>> unfilteredValues = SimpleAdapter.this.mUnfilteredData;
                int count = unfilteredValues.size();
                ArrayList<Map<String, ?>> newValues = new ArrayList<>(count);
                for (int i10 = 0; i10 < count; i10++) {
                    Map<String, ?> h10 = unfilteredValues.get(i10);
                    if (h10 != null) {
                        int len = SimpleAdapter.this.mTo.length;
                        for (int j10 = 0; j10 < len; j10++) {
                            String str = (String) h10.get(SimpleAdapter.this.mFrom[j10]);
                            String[] words = str.split(" ");
                            int wordCount = words.length;
                            int k10 = 0;
                            while (true) {
                                if (k10 < wordCount) {
                                    String word = words[k10];
                                    if (!word.toLowerCase().startsWith(prefixString)) {
                                        k10++;
                                    } else {
                                        newValues.add(h10);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                results.values = newValues;
                results.count = newValues.size();
            }
            return results;
        }

        @Override // android.widget.Filter
        protected void publishResults(CharSequence constraint, Filter.FilterResults results) {
            SimpleAdapter.this.mData = (List) results.values;
            if (results.count > 0) {
                SimpleAdapter.this.notifyDataSetChanged();
            } else {
                SimpleAdapter.this.notifyDataSetInvalidated();
            }
        }
    }
}
