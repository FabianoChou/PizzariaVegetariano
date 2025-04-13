package www.lanchefacil.com.lojapizza;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnSelect;
    CheckBox pizza1;
    CheckBox pizza2;
    CheckBox pizza3;
    CheckBox pizza4;
    CheckBox pizza5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btnSelect = findViewById(R.id.btnSelect);
        pizza1 = findViewById(R.id.Pizza1);
        pizza2 = findViewById(R.id.Pizza2);
        pizza3 = findViewById(R.id.Pizza3);
        pizza4 = findViewById(R.id.Pizza4);
        pizza5 = findViewById(R.id.Pizza5);



        btnSelect.setOnClickListener(view->{
            Intent intent = new Intent(this,SelectPagamentoETamanho.class);
            if(pizza1.isChecked()){
                intent.putExtra("pizza1","Pizza de Margherita");
            }
            if(pizza2.isChecked()){
                intent.putExtra("pizza2","Pizza de Milho");
            }
            if(pizza3.isChecked()){
                intent.putExtra("pizza3","Pizza de Palmito");
            }
            if(pizza4.isChecked()){
                intent.putExtra("pizza4","Pizza de Brócolis");
            }
            if(pizza5.isChecked()){
                intent.putExtra("pizza5","Nutella e Morango");
            }
            startActivity(intent);
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}