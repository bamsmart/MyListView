package learning.shinesdev.mylistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ShioAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<ShioModel> mShio = new ArrayList<>();

    public void setShio(ArrayList<ShioModel> shio) {
        this.mShio = shio;
    }

    public ShioAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null) {
            itemView = LayoutInflater.from(mContext).inflate(R.layout.item_list, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(itemView);
        ShioModel hero = (ShioModel) getItem(i);
        viewHolder.bind(hero);
        return itemView;
    }


    @Override
    public int getCount() {
        return mShio.size();
    }

    @Override
    public Object getItem(int i) {
        return mShio.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    //===========================================================
    private class ViewHolder {
        private ImageView imgShio;
        private TextView txtShioName;
        private TextView txtShioDescription;
        private Button btnDetail;

        ViewHolder(View view) {
            imgShio = view.findViewById(R.id.shio_image);
            txtShioName = view.findViewById(R.id.shio_name);
            txtShioDescription = view.findViewById(R.id.shio_desc);
            btnDetail = view.findViewById(R.id.btn_detail);

        }
        void bind(ShioModel shio) {
            txtShioName.setText(shio.getName());
            txtShioDescription.setText(shio.getDesc());
            imgShio.setImageResource(shio.getImage());
        }
    }
}
