package com.nilswesthoff.nils.connectfour;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView infoTextView;
    private TableLayout boardTableLayout;
    private int column;
    private Button columnButton;
    private int discColor = Color.RED;
    private FourInARowGame fourInARowGame = new FourInARowGame();

    private void info(String info) {
        infoTextView.setText(info);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        infoTextView = findViewById(R.id.info_textview);
        boardTableLayout = findViewById(R.id.board_tablelayout);
        info("Player 1 plays first!");
    }

    private ImageView getBoardImageView(int rowIndex, int columnIndex) {
        TableRow tableRow = (TableRow) boardTableLayout.getChildAt(rowIndex);
        return (ImageView) tableRow.getChildAt(columnIndex);
    }

    private void showDisc(int row, int column, int color) {
        // set the background color
        getBoardImageView(row - 1, column - 1).setBackgroundColor(color);
    }

    public void columnButtonClicked(View view) {
        columnButton = (Button) view;
        column = Integer.parseInt(columnButton.getText().toString());

//        int row = 6;
//        while (row > 0 && ((ColorDrawable) getBoardImageView(row - 1,
//                column - 1).getBackground()).getColor() != Color.parseColor("#bbbbbb"))
//            row--;

        int row = fourInARowGame.dropDisc(column);

        if (row == 1) columnButton.setEnabled(false);
        if (discColor == Color.RED) {
            showDisc(row, column, discColor);
            discColor = Color.BLUE;
            info("Next move by Blue Player");
        } else {
            showDisc(row, column, discColor);
            discColor = Color.RED;
            info("Next move by Red Player");
        }
    }
}
