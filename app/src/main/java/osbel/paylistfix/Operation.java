package osbel.paylistfix;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Operation extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private GridView listView;
    public Operation() {
        // Required empty public constructor
    }

    public static Operation newInstance(String param1, String param2) {
        Operation fragment = new Operation();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }


    private List getData() {
        List list = new ArrayList();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        return list;
    }
    public class MyListAdapter extends BaseAdapter {
        private final Context mContext;
        private List mList;

        MyListAdapter(List data, Context context) {
            mList = data;
            mContext = context;
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View root = convertView;
            ViewHolder viewHolder;
            if (null == root) {
                viewHolder = new ViewHolder();
                root = LayoutInflater.from( mContext).inflate(R.layout.list, null);
                viewHolder.textView = (TextView) root.findViewById(R.id.title);
                viewHolder.contentView = (TextView) root.findViewById(R.id.content);
                root.setTag(viewHolder);
            }
            viewHolder = (ViewHolder) root.getTag();
            viewHolder.textView.setText((Integer) mList.get(position)+"");
            viewHolder.contentView.setText((Integer) mList.get(position)+"");
            return root;
        }

        public class ViewHolder {
            TextView textView;
            TextView contentView;
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_restmoney, container, false);
        listView = (GridView) rootView.findViewById(R.id.listview);
        MyListAdapter adapterlist = new MyListAdapter(getData(), getActivity());
        listView.setAdapter(adapterlist);
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
