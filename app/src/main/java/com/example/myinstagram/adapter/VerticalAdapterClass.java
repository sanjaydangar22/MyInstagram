package com.example.myinstagram.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myinstagram.R;
import com.example.myinstagram.interfac.VerticalClickListner;
import com.example.myinstagram.modelclass.VerticalModelClass;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class VerticalAdapterClass extends RecyclerView.Adapter<VerticalAdapterClass.InstaHolder> {
    ArrayList<VerticalModelClass> verticalList;
    VerticalClickListner verticalClickListner;

    public VerticalAdapterClass(ArrayList<VerticalModelClass> verticalList, VerticalClickListner verticalClickListner) {
        this.verticalList = verticalList;
        this.verticalClickListner=verticalClickListner;
    }

    @NonNull
    @Override
    public VerticalAdapterClass.InstaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.vertical_list, parent, false);
        InstaHolder instaHolder = new InstaHolder(v);
        return instaHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalAdapterClass.InstaHolder holder, int position) {
        holder.imgDp.setImageResource(verticalList.get(position).getImgDp());
        holder.txtNameID.setText(verticalList.get(position).getNameID());
        holder.imgShow.setImageResource(verticalList.get(position).getImgShow());
        holder.txtNIDBottom.setText(verticalList.get(position).getNameID());
        holder.layVertical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verticalClickListner.onClick(verticalList.get(position).getImgDp(),verticalList.get(position).getNameID(),verticalList.get(position).getImgShow());

            }
        });

    }

    @Override
    public int getItemCount() {
        return verticalList.size();
    }

    public class InstaHolder extends RecyclerView.ViewHolder {
        CircleImageView imgDp;
        TextView txtNameID,txtNIDBottom;
        ImageView imgShow;
        LinearLayout layVertical;

        public InstaHolder(@NonNull View itemView) {
            super(itemView);
            imgDp = itemView.findViewById(R.id.imgDp1);
            txtNameID = itemView.findViewById(R.id.txtNameID);
            imgShow = itemView.findViewById(R.id.imgShow);
            txtNIDBottom = itemView.findViewById(R.id.txtNIDBottom);
            layVertical = itemView.findViewById(R.id.layVertical);

        }
    }
}
