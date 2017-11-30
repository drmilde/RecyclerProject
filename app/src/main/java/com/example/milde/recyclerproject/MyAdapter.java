package com.example.milde.recyclerproject;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Die Klasse implementiert beispielhaft einen Adapter für den RecyclerView.
 * Der Adapter erwartet einen ViewHolder, eine Wrapperklasse, die
 * die Daten einer Zeile aufnehmen kann.
 *
 * Jede Zeile wird an einen ViewHolder gebunden. Damit kann man auf den
 * gespeicherten View zugreifen (hier ein CardView) und so Daten in den View
 * übertragen.
 *
 * Created by milde on 30.11.17.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private String[] mDataset;


    public MyAdapter(String[] mDataset) {
        this.mDataset = mDataset;
    }


    /**
     * Expandiert (inflate) das Zeilenlayout, hier ein CardView.
     * Initialisiert den ViewHolder, hier wird der expandierte CardView gespeichert.
     * Damit wird später der Zugriff auf die einzelnen Bestandteile des
     * Zeilenlayout möglich.
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);

        ViewHolder vh = new ViewHolder(cv);
        return vh;
    }

    /**
     * Bindet den ViewHolder an die Daten.
     * Über den Zugriff auf den im ViewHolder gespeicherten CardView
     * lassen sie die Felder setzen: das Bild, der Name und das Alter.
     *
     * Gleichzeitg werden auf den CardView OnClickListener registriert.
     * Damit kann eine Click Aktion über den Listeneintrag ausgelöst werden.
     * In diesem Beispiel ein Toast.
     *
     * @param holder ViewHolder des aktuellen Datensatzes
     * @param position Position des Datensatzes im RecyclerView/Datenarray.
     */

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "clicked cardview: " + position, Toast.LENGTH_SHORT).show();
            }
        });

        ImageView iv = (ImageView)holder.mCardView.findViewById(R.id.person_photo);
        iv.setImageResource(R.drawable.turing);
        TextView tv = (TextView)holder.mCardView.findViewById(R.id.person_name);
        tv.setText(mDataset[position]);
        TextView tva = (TextView)holder.mCardView.findViewById(R.id.person_age);
        tva.setText(mDataset[position]);
    }

    /**
     * Liefert die Größe des Daten-Arrays zurück.
     * So wird die länge der LIste festgelegt.
     *
      * @return Length des datenarrays
     */
    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        //
        public CardView mCardView;

        public ViewHolder(CardView v) {
            super(v);
            mCardView = v;
        }
    }
}
