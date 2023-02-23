package cn.leafoct.emoji.ui.TravelPlaces;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import cn.leafoct.emoji.EmojiAdapter;
import cn.leafoct.emoji.EmojiItem;
import cn.leafoct.emoji.EmojiList;
import cn.leafoct.emoji.R;
import cn.leafoct.emoji.databinding.FragmentTravelPlacesBinding;

public class TravelPlacesFragment extends Fragment {

    private FragmentTravelPlacesBinding binding;
    private List<EmojiItem> emoji_list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentTravelPlacesBinding.inflate(inflater,container,false);
        View root = binding.getRoot();
        emoji_list= EmojiList.travel_places;
        RecyclerView recyclerView = binding.travelPlacesRecyclerview;
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 5);
        recyclerView.setLayoutManager(layoutManager);
        EmojiAdapter adapter = new EmojiAdapter(emoji_list);
        recyclerView.setAdapter(adapter);
        return root;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding=null;
    }
}