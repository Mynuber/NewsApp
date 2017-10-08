package xyz.markswebsite.newsapp.onboarding;

import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import xyz.markswebsite.newsapp.R;

/**
 * Created by Mark on 8/10/2017.
 */

public class SourceCategoriesAdapter  extends RecyclerView.Adapter<SourceCategoriesAdapter.ViewHolder>{

    private List<String> categoriesList = new ArrayList<>();

    private QuickSetupCategoriesFragment.OnItemsSelected onItemsSelected;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public AppCompatCheckBox checkBox;

        public ViewHolder(LinearLayout v) {
            super(v);
            checkBox = (AppCompatCheckBox) v.findViewById(R.id.categories_checkbox);
        }
    }

    public SourceCategoriesAdapter(Set<String> categories, QuickSetupCategoriesFragment.OnItemsSelected onItemsSelected) {
        this.onItemsSelected = onItemsSelected;
        categoriesList.addAll(categories);
        Collections.sort(categoriesList);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.widget_categories_checkbox, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String myString = categoriesList.get(position);
        String upperString = myString.substring(0,1).toUpperCase() + myString.substring(1);
        holder.checkBox.setText(upperString);
    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }
}

