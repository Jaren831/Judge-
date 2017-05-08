package com.app.android.judge.History;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.android.judge.Data.MatchHistoryContract;
import com.app.android.judge.Data.MatchHistoryDBHelper;
import com.app.android.judge.R;

/**
 * Created by jaren on 5/7/2017.
 */

public class HistoryCursorAdapter extends android.widget.CursorAdapter {

    private LayoutInflater cursorInflater;

    MatchHistoryDBHelper matchHistoryDBHelper;

    HistoryCursorAdapter historyCursorAdapter;


    public HistoryCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor);
        cursorInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View newView(final Context context, Cursor cursor, final ViewGroup parent) {
        return cursorInflater.inflate(R.layout.history_list_item, parent, false);
    }

    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView
    @Override
    public void bindView(View view, final Context context, Cursor cursor) {

        // Find fields to populate in inflated template
        TextView player1 = (TextView) view.findViewById(R.id.history_player1);
        TextView player2 = (TextView) view.findViewById(R.id.history_player2);

        String player1Life = cursor.getString(cursor.getColumnIndex(MatchHistoryContract.MatchHistoryEntry.COLUMN_PLAYER1_LIFE));
        String player2Life = cursor.getString(cursor.getColumnIndex(MatchHistoryContract.MatchHistoryEntry.COLUMN_PLAYER2_LIFE));

        player1.setText(player1Life);
        player2.setText(player2Life);
    }

}
