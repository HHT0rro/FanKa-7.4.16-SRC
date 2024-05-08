package com.alimm.tanx.core.ad.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.alimm.tanx.core.utils.NotConfused;
import com.wangmai.appsdkdex.R$dimen;
import com.wangmai.appsdkdex.R$id;
import com.wangmai.appsdkdex.R$layout;
import com.wangmai.appsdkdex.R$style;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class WebMenuDialog extends Dialog implements NotConfused {
    public final Context mContext;
    public final LayoutInflater mInflater;
    public final MenuClick mMenuClick;
    public final List<ActionMenu> mMenuList;
    public final AdapterView.OnItemClickListener onMenuOnItemClickListener;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface MenuClick {
        void click(int i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class tanxc_do extends BaseAdapter {
        public tanxc_do() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return WebMenuDialog.this.mMenuList.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i10) {
            return WebMenuDialog.this.mMenuList.get(i10);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            tanxc_if tanxc_ifVar;
            if (view == null) {
                tanxc_if tanxc_ifVar2 = new tanxc_if();
                View inflate = WebMenuDialog.this.mInflater.inflate(R$layout.tanx_layout_browser_simple_popmenu_items, viewGroup, false);
                tanxc_ifVar2.tanxc_do = (ImageView) inflate.findViewById(R$id.tanx_browser_menu_item_img);
                tanxc_ifVar2.tanxc_if = (TextView) inflate.findViewById(R$id.tanx_browser_menu_item_title);
                inflate.setTag(tanxc_ifVar2);
                tanxc_ifVar = tanxc_ifVar2;
                view = inflate;
            } else {
                tanxc_ifVar = (tanxc_if) view.getTag();
            }
            ActionMenu actionMenu = (ActionMenu) getItem(i10);
            tanxc_ifVar.tanxc_do.setImageResource(actionMenu.drawable);
            tanxc_ifVar.tanxc_if.setText(actionMenu.name);
            return view;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class tanxc_if {
        public ImageView tanxc_do;
        public TextView tanxc_if;
    }

    public WebMenuDialog(Context context, List<ActionMenu> list, MenuClick menuClick) {
        super(context, R$style.Theme_Tanx_Browser_Dialog);
        this.onMenuOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.alimm.tanx.core.ad.view.WebMenuDialog.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
                WebMenuDialog.this.mMenuClick.click(((ActionMenu) WebMenuDialog.this.mMenuList.get(i10)).f4181id);
                WebMenuDialog.this.dismiss();
            }
        };
        this.mContext = context;
        this.mMenuClick = menuClick;
        this.mMenuList = list;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCanceledOnTouchOutside(true);
        if (getWindow() != null) {
            getWindow().setGravity(53);
            getWindow().getAttributes().f817y = this.mContext.getResources().getDimensionPixelOffset(R$dimen.tanx_browser_default_height);
            getWindow().getAttributes().width = -2;
            getWindow().getAttributes().height = -2;
        }
        setContentView(R$layout.tanx_layout_browser_popmenu);
        ListView listView = (ListView) findViewById(R$id.tanx_browser_menu_listview);
        listView.setAdapter((ListAdapter) new tanxc_do());
        listView.setOnItemClickListener(this.onMenuOnItemClickListener);
    }
}
