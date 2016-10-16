package au.com.owenwalsh.capabilityconnect.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import au.com.owenwalsh.capabilityconnect.Model.Tutorial;
import au.com.owenwalsh.capabilityconnect.R;

/**
 * Created by owenw on 11/10/2016.
 */
public class TutorialAdapter extends RecyclerView.Adapter<TutorialAdapter.ViewHolder> {
    private Context mContext;
    private List<Tutorial> classList;

    private ItemClickCallback itemClickCallback;

    //declaring interface for the on click event
    public interface ItemClickCallback {
        void onItemClick(int p);
    }
    public void setItemClickCallback(final ItemClickCallback itemClickCallback) {
        this.itemClickCallback = itemClickCallback;
    }

    /**
     * Constructor for Tutorial Adapter
     *
     * @param classList
     * @param mContext
     */
    public TutorialAdapter (List<Tutorial> classList, Context mContext){
        this.classList = classList;
        this.mContext = mContext;
    }

    /**
     *
     * @param viewGroup
     * @param viewType
     * @return
     */
    @Override
    public TutorialAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.class_row, viewGroup, false);
        return new ViewHolder(view);
    }

    /**
     *
     * @param viewHolder
     * @param position
     */
    @Override
    public void onBindViewHolder(TutorialAdapter.ViewHolder viewHolder, int position) {
    viewHolder.classID.setText(classList.get(position).getId());
    viewHolder.classDay.setText(classList.get(position).getId());
    viewHolder.classTime.setText(classList.get(position).getId());
    viewHolder.numOfStudents.setText(classList.get(position).getId());

       /* viewHolder.classLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d("Class Clicked: ","a class has been clicked");
            //code for whatever happens when  class is clicked
            }
        });
        viewHolder.assesmentButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Log.d("Assessment Clicked: ","assessment button has been clicked");
                //code for whatever happens when  assessment image button is clicked
            }
        });

        viewHolder.competencyButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Log.d("Competency Clicked: ","competency button has been clicked");
                //code for whatever happens when  competency image button is clicked
            }
        });*/
    }

    public void updateListAdapter(List<Tutorial> classList) {
        this.classList = classList;
    }

    @Override
    public int getItemCount() {
        return classList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView classID;
        public TextView classDay;
        public TextView classTime;
        public TextView numOfStudents;
        public ImageButton assesmentButton;
        public ImageButton competencyButton;
        public RelativeLayout classLayout;
        public View container;

        public ViewHolder(View view) {
            super(view);
            classLayout = (RelativeLayout) view.findViewById(R.id.class_card);
            classID = (TextView) view.findViewById(R.id.class_id);
            classDay = (TextView) view.findViewById(R.id.class_day);
            classTime = (TextView) view.findViewById(R.id.class_time);
            numOfStudents = (TextView) view.findViewById(R.id.class_time);
            container = view.findViewById(R.id.tutorial_cont_item_root);
            container.setOnClickListener(this);

            assesmentButton = (ImageButton) view.findViewById(R.id.assessment_button);
            competencyButton = (ImageButton) view.findViewById(R.id.competency_button);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.cont_item_root) {
                itemClickCallback.onItemClick(getAdapterPosition());
            }
        }
    }
}
