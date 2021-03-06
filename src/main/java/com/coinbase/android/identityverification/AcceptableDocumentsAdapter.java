package com.coinbase.android.identityverification;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.coinbase.android.R;
import com.coinbase.android.databinding.AcceptableDocItemBinding;
import java.util.ArrayList;
import java.util.List;

public class AcceptableDocumentsAdapter extends BaseAdapter {
    private Context context;
    private List<ListItem> items;

    private class ListItem {
        int icon;
        String title;

        ListItem() {
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getIcon() {
            return this.icon;
        }

        public void setIcon(int icon) {
            this.icon = icon;
        }
    }

    public AcceptableDocumentsAdapter(Context context, List<String> titles, List<Integer> icons) {
        this.items = new ArrayList(titles.size());
        for (int i = 0; i < titles.size(); i++) {
            ListItem item = new ListItem();
            item.title = (String) titles.get(i);
            item.icon = ((Integer) icons.get(i)).intValue();
            this.items.add(item);
        }
        this.context = context;
    }

    public int getCount() {
        return this.items.size();
    }

    public Object getItem(int position) {
        return this.items.get(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        AcceptableDocItemBinding binding;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.context).inflate(R.layout.acceptable_doc_item, parent, false);
            binding = (AcceptableDocItemBinding) DataBindingUtil.bind(convertView);
            convertView.setTag(binding);
        } else {
            binding = (AcceptableDocItemBinding) convertView.getTag();
        }
        binding.tvText.setText(((ListItem) this.items.get(position)).getTitle());
        binding.ivIcon.setImageResource(((ListItem) this.items.get(position)).getIcon());
        return convertView;
    }
}
