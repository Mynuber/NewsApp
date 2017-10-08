package xyz.markswebsite.newsapp.onboarding;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import xyz.markswebsite.newsapp.R;

/**
 * Created by Mark on 7/10/2017.
 */

public class SourceLanguageAdapter extends RecyclerView.Adapter<SourceLanguageAdapter.ViewHolder> {

    private List<String> languageList = new ArrayList<>();
    private Set<String> languagesSelected = new HashSet<>();
    private QuickSetupCategoriesFragment.OnItemsSelected onItemsSelectedListener;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public AppCompatCheckBox checkBox;

        public ViewHolder(LinearLayout v) {
            super(v);
            checkBox = (AppCompatCheckBox) v.findViewById(R.id.language_descriptor_background);
        }
    }

    public SourceLanguageAdapter(Set<String> availableLanguages, QuickSetupCategoriesFragment.OnItemsSelected onItemsSelectedListener) {
        this.onItemsSelectedListener = onItemsSelectedListener;
        languageList.addAll(availableLanguages);
    }

    public SourceLanguageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.widget_language_circle, parent, false);
        return new ViewHolder(v);
    }

    public Set<String> getSelectedLanguages () {
        return languagesSelected;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.checkBox.setText(languageList.get(position));
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.checkBox.isChecked()) {
                    languagesSelected.add(languageList.get(position));
                }else {
                    languagesSelected.remove(languageList.get(position));
                }
                onItemsSelectedListener.onChanged(languageList.get(position), holder.checkBox.isChecked());
            }
        });
    }

    @Override
    public int getItemCount() {
        return languageList.size();
    }


}
