package com.example.lightfuture.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.lightfuture.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class ListFragment extends Fragment {

    private RecyclerView.Adapter adapter;
    private static RecyclerView recyclerView;
    private static ArrayList<DataModelListItem> data;
//    private ImageButton imageButtonFiltersFragmentHome, ibAddTaskType;
//    private SwipeRefreshLayout swipeRefreshLayout;
    private View root;
    private ProgressBar progressBar_tasksTape;
    private FloatingActionButton fabStartNewTaskActivity;
    private LinearLayoutManager layoutManager;



//    private Gson gson = new Gson();
    private boolean isAddTask = true;

    private boolean isUpdateTaskList = false;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, final Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_list, container, false);

        init();

//        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                updateTasksList();
//            }
//        });

//        data.clear();
        recyclerView.setAdapter(adapter);



        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    if ((layoutManager.getChildCount() + layoutManager.findFirstVisibleItemPosition()) >= layoutManager.getItemCount()-3) {
                        if (isAddTask) {
                            isAddTask = false;
                            addTasksToList();
                        }
                    }
                }
                if (dy > 0) {
                    if ((layoutManager.getChildCount() + layoutManager.findFirstVisibleItemPosition()) > layoutManager.getItemCount()-0.01) {
                        progressBar_tasksTape.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
        return root;
    }

    private void init(){
        recyclerView = root.findViewById(R.id.list_item_recycler_view);
//        fabStartNewTaskActivity = root.findViewById(R.id.fab_newTask_fragment_task);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        data = new ArrayList<DataModelListItem>();
        for (ModelListItem i:TipaDatabase.ItsDataList){
            data.add(new DataModelListItem(i.id,i.number));
        }
        adapter = new CustomAdapterListItem(data);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();

        updateTasksList();

    }

    private void updateTasksList(){
//        data.clear();
    }

    private void addTasksToList(){
    }

}