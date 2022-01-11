package com.example.listeachat;

import androidx.recyclerview.widget.RecyclerView;

public interface RecyclerItemToucheHelper {
				void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position);
}
