package com.example.randomizerpath;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {
    PathCreator newPath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newPath = new PathCreator();
    }

    public void notValidPath(Button b){
        b.setVisibility(b.INVISIBLE);
    }

    public void validPath(Button b){
        b.setText("|");
    }

    public void clicked(View view){
        Button b = (Button) view;
        switch(b.getId()){
            case R.id.BTN1: if(newPath.checkValid(0,0)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN2: if(newPath.checkValid(0,1)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN3: if(newPath.checkValid(0,2)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN4: if(newPath.checkValid(0,3)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN5: if(newPath.checkValid(0,4)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN6: if(newPath.checkValid(0,5)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN7: if(newPath.checkValid(0,6)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN8: if(newPath.checkValid(0,7)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN9: if(newPath.checkValid(0,8)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN10: if(newPath.checkValid(0,9)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN11: if(newPath.checkValid(1,0)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN12: if(newPath.checkValid(1,1)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN13: if(newPath.checkValid(1,2)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN14: if(newPath.checkValid(1,3)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN15: if(newPath.checkValid(1,4)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN16: if(newPath.checkValid(1,5)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN17: if(newPath.checkValid(1,6)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN18: if(newPath.checkValid(1,7)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN19: if(newPath.checkValid(1,8)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN20: if(newPath.checkValid(1,9)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN21: if(newPath.checkValid(2,0)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN22: if(newPath.checkValid(2,1)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN23: if(newPath.checkValid(2,2)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN24: if(newPath.checkValid(2,3)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN25: if(newPath.checkValid(2,4)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN26: if(newPath.checkValid(2,5)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN27: if(newPath.checkValid(2,6)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN28: if(newPath.checkValid(2,7)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN29: if(newPath.checkValid(2,8)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN30: if(newPath.checkValid(2,9)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN31: if(newPath.checkValid(3,0)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN32: if(newPath.checkValid(3,1)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN33: if(newPath.checkValid(3,2)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN34: if(newPath.checkValid(3,3)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN35: if(newPath.checkValid(3,4)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN36: if(newPath.checkValid(3,5)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN37: if(newPath.checkValid(3,6)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN38: if(newPath.checkValid(3,7)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN39: if(newPath.checkValid(3,8)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN40: if(newPath.checkValid(3,9)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN41: if(newPath.checkValid(4,0)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN42: if(newPath.checkValid(4,1)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN43: if(newPath.checkValid(4,2)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN44: if(newPath.checkValid(4,3)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN45: if(newPath.checkValid(4,4)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN46: if(newPath.checkValid(4,5)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN47: if(newPath.checkValid(4,6)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN48: if(newPath.checkValid(4,7)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN49: if(newPath.checkValid(4,8)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN50: if(newPath.checkValid(4,9)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN51: if(newPath.checkValid(5,0)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN52: if(newPath.checkValid(5,1)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN53: if(newPath.checkValid(5,2)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN54: if(newPath.checkValid(5,3)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN55: if(newPath.checkValid(5,4)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN56: if(newPath.checkValid(5,5)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN57: if(newPath.checkValid(5,6)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN58: if(newPath.checkValid(5,7)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN59: if(newPath.checkValid(5,8)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN60: if(newPath.checkValid(5,9)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN61: if(newPath.checkValid(6,0)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN62: if(newPath.checkValid(6,1)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN63: if(newPath.checkValid(6,2)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN64: if(newPath.checkValid(6,3)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN65: if(newPath.checkValid(6,4)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN66: if(newPath.checkValid(6,5)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN67: if(newPath.checkValid(6,6)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN68: if(newPath.checkValid(6,7)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN69: if(newPath.checkValid(6,8)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN70: if(newPath.checkValid(6,9)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN71: if(newPath.checkValid(7,0)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN72: if(newPath.checkValid(7,1)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN73: if(newPath.checkValid(7,2)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN74: if(newPath.checkValid(7,3)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN75: if(newPath.checkValid(7,4)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN76: if(newPath.checkValid(7,5)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN77: if(newPath.checkValid(7,6)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN78: if(newPath.checkValid(7,7)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN79: if(newPath.checkValid(7,8)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN80: if(newPath.checkValid(7,9)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN81: if(newPath.checkValid(8,0)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN82: if(newPath.checkValid(8,1)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN83: if(newPath.checkValid(8,2)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN84: if(newPath.checkValid(8,3)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN85: if(newPath.checkValid(8,4)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN86: if(newPath.checkValid(8,5)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN87: if(newPath.checkValid(8,6)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN88: if(newPath.checkValid(8,7)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN89: if(newPath.checkValid(8,8)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN90: if(newPath.checkValid(8,9)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN91: if(newPath.checkValid(9,0)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN92: if(newPath.checkValid(9,1)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN93: if(newPath.checkValid(9,2)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN94: if(newPath.checkValid(9,3)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN95: if(newPath.checkValid(9,4)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN96: if(newPath.checkValid(9,5)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN97: if(newPath.checkValid(9,6)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN98: if(newPath.checkValid(9,7)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN99: if(newPath.checkValid(9,8)){ validPath(b); }else{ notValidPath(b); } break;
            case R.id.BTN100: if(newPath.checkValid(9,9)){ validPath(b); }else{ notValidPath(b); } break;
        }
    }

}