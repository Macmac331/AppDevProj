package com.example.finalappdevproj;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class MissionVision extends Fragment {

    private RecyclerView recyclerView;
    private MissionVisionAdapter missionVisionAdapter;
    private List<MissionVisionData> missionVisionList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mission_vision, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL));

        missionVisionList = new ArrayList<>();
        missionVisionAdapter = new MissionVisionAdapter(missionVisionList);
        recyclerView.setAdapter(missionVisionAdapter);

        // Populate data
        missionVisionContent();

        return view;
    }

    private void missionVisionContent() {
        MissionVisionData data1 = new MissionVisionData("Mission", "Laguna University is committed to produce academically prepared and technically skilled individuals who are socially and morally upright");
        missionVisionList.add(data1);

        MissionVisionData data2 = new MissionVisionData("Vision", "Laguna University shall be a socially responsive educational institution of choice providing holistically developed individuals in the Asia-Pacific Region");
        missionVisionList.add(data2);

        // Notify the adapter that the data has changed
        missionVisionAdapter.notifyDataSetChanged();
    }
}