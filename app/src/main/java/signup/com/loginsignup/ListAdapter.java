package signup.com.loginsignup;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends ArrayAdapter {
    List list=new ArrayList();
    public ListAdapter(@NonNull Context context, int resource) {
        super(context, resource);

    }
    static class LayoutHandler{
        TextView NAME,EMAIL;

    }

   @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }
    @Override
    public int getCount(){
        return list.size();
    }
    @Nullable
    @Override
    public Object getItem(int position){
        return list.get(position);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row=convertView;
        LayoutHandler layouthandler;
        if(row==null){
            LayoutInflater layoutInflater=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       layouthandler=new LayoutHandler();
       layouthandler.NAME=(TextView)row.findViewById(R.id.textView1);
            layouthandler.EMAIL=(TextView)row.findViewById(R.id.textView2);
            //layouthandler.NAME=(TextView)row.findViewById(R.id.textView1)
            row.setTag(layouthandler);}
            else{
            layouthandler=(LayoutHandler)row.getTag();
            }
            Contact c=(Contact)this.getItem(position);
        layouthandler.NAME.setText(c.getFname());
        layouthandler.NAME.setText(c.getEmail());
        return row;




    }


}
