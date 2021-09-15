package com.technuoma.caservices;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class Home extends Fragment {

    String url1 = "https://previews.123rf.com/images/varijanta/varijanta1604/varijanta160400071/55847737-modern-thin-line-design-concept-for-tax-website-banner-vector-illustration-concept-for-finance-accou.jpg";
    String url2 = "https://previews.123rf.com/images/varijanta/varijanta1604/varijanta160400071/55847737-modern-thin-line-design-concept-for-tax-website-banner-vector-illustration-concept-for-finance-accou.jpg";

    RecyclerView cat, cat1, cat2, cat3;
    CategoryAdapter adapter1;
    ArrayList<Category> category_list;

    Category1Adapter adapter2;
    ArrayList<Category1> cat1_list;

    Category2Adapter adapter3;
    ArrayList<Category2> cat2_list;

    Category3Adapter adapter4;
    ArrayList<Category3> cat3_list;

    MainActivity mainActivity;

    public Home() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mainActivity = (MainActivity) getActivity();

        SliderView sliderView = view.findViewById(R.id.slider);

        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();

        sliderDataArrayList.add(new SliderData(url1));
        sliderDataArrayList.add(new SliderData(url2));

        SliderAdapter adapter = new SliderAdapter(getActivity(), sliderDataArrayList);

        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        sliderView.setSliderAdapter(adapter);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();

        cat = view.findViewById(R.id.cat);
        cat1 = view.findViewById(R.id.cat1);
        cat2 = view.findViewById(R.id.cat2);
        cat3 = view.findViewById(R.id.cat3);

        category_list = new ArrayList<>();
        category_list.add(new Category("Category 1"));
        category_list.add(new Category("Category 1"));
        category_list.add(new Category("Category 1"));
        category_list.add(new Category("Category 1"));

        adapter1 = new CategoryAdapter(getActivity(), category_list);

        GridLayoutManager manager = new GridLayoutManager(getActivity(), 4);

        cat.setAdapter(adapter1);
        cat.setLayoutManager(manager);

        cat1_list = new ArrayList<>();
        cat1_list.add(new Category1("Category 1"));
        cat1_list.add(new Category1("Category 1"));
        cat1_list.add(new Category1("Category 1"));
        cat1_list.add(new Category1("Category 1"));
        cat1_list.add(new Category1("Category 1"));
        cat1_list.add(new Category1("Category 1"));

        adapter2 = new Category1Adapter(getActivity(), cat1_list);

        GridLayoutManager manager1 = new GridLayoutManager(getActivity(), 3);

        cat1.setAdapter(adapter2);
        cat1.setLayoutManager(manager1);

        cat2_list = new ArrayList<>();
        cat2_list.add(new Category2("Category 1"));
        cat2_list.add(new Category2("Category 1"));
        cat2_list.add(new Category2("Category 1"));
        cat2_list.add(new Category2("Category 1"));
        cat2_list.add(new Category2("Category 1"));
        cat2_list.add(new Category2("Category 1"));

        adapter3 = new Category2Adapter(getActivity(), cat2_list);

        GridLayoutManager manager2 = new GridLayoutManager(getActivity(), 3);

        cat2.setAdapter(adapter3);
        cat2.setLayoutManager(manager2);

        cat3_list = new ArrayList<>();
        cat3_list.add(new Category3("Category 1"));
        cat3_list.add(new Category3("Category 1"));
        cat3_list.add(new Category3("Category 1"));
        cat3_list.add(new Category3("Category 1"));
        cat3_list.add(new Category3("Category 1"));
        cat3_list.add(new Category3("Category 1"));

        adapter4 = new Category3Adapter(getActivity(), cat3_list);

        GridLayoutManager manager3 = new GridLayoutManager(getActivity(), 3);

        cat3.setAdapter(adapter4);
        cat3.setLayoutManager(manager3);


        return view;
    }


    class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

        Context context;
        List<Category> list = new ArrayList<>();

        public CategoryAdapter(Context context, List<Category> list) {
            this.context = context;
            this.list = list;
        }

        public void setData(List<Category> list) {
            this.list = list;
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.cat_list_model, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            final Category item = list.get(position);

            holder.name.setText(item.getName());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    FragmentManager fm3 = getActivity().getSupportFragmentManager();
                    FragmentTransaction ft3 = fm3.beginTransaction();
                    ft3.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    Category1Fragment frag13 = new Category1Fragment();
                    ft3.replace(R.id.flFragment, frag13);
                    ft3.addToBackStack(null);
                    ft3.commit();


                }
            });

        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            ImageView image;
            TextView name;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                image = itemView.findViewById(R.id.img);
                name = itemView.findViewById(R.id.name);


            }
        }
    }


    class Category1Adapter extends RecyclerView.Adapter<Category1Adapter.ViewHolder> {

        Context context;
        List<Category1> list = new ArrayList<>();

        public Category1Adapter(Context context, List<Category1> list) {
            this.context = context;
            this.list = list;
        }

        public void setData(List<Category1> list) {
            this.list = list;
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.cat1_list_model, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            final Category1 item = list.get(position);

            holder.name.setText(item.getName());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    FragmentManager fm4 = mainActivity.getSupportFragmentManager();
                    FragmentTransaction ft4 = fm4.beginTransaction();
                    Category2Fragment frag14 = new Category2Fragment();
                    ft4.replace(R.id.flFragment, frag14);
                    ft4.addToBackStack(null);
                    ft4.commit();


                }
            });

        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            ImageView image;
            TextView name;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                image = itemView.findViewById(R.id.img);
                name = itemView.findViewById(R.id.name);


            }
        }
    }


    class Category2Adapter extends RecyclerView.Adapter<Category2Adapter.ViewHolder> {

        Context context;
        List<Category2> list = new ArrayList<>();

        public Category2Adapter(Context context, List<Category2> list) {
            this.context = context;
            this.list = list;
        }

        public void setData(List<Category2> list) {
            this.list = list;
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.cat2_list_model, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            final Category2 item = list.get(position);

            holder.name.setText(item.getName());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    FragmentManager fm4 = mainActivity.getSupportFragmentManager();

                    FragmentTransaction ft4 = fm4.beginTransaction();
                    Category3Fragment frag14 = new Category3Fragment();
                    ft4.replace(R.id.flFragment, frag14);
                    ft4.addToBackStack(null);
                    ft4.commit();


                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            ImageView image;
            TextView name;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                image = itemView.findViewById(R.id.img);
                name = itemView.findViewById(R.id.name);


            }
        }
    }


    class Category3Adapter extends RecyclerView.Adapter<Category3Adapter.ViewHolder> {

        Context context;
        List<Category3> list = new ArrayList<>();

        public Category3Adapter(Context context, List<Category3> list) {
            this.context = context;
            this.list = list;
        }

        public void setData(List<Category3> list) {
            this.list = list;
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.cat3_list_model, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            final Category3 item = list.get(position);

            holder.name.setText(item.getName());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(getActivity(), ImageUploadActivity.class);
                    startActivity(intent);


                }
            });

        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            ImageView image;
            TextView name;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                image = itemView.findViewById(R.id.img);
                name = itemView.findViewById(R.id.name);


            }
        }
    }


}