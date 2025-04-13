package www.lanchefacil.com.lojapizza;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class ResumoDoPedido extends AppCompatActivity {
    TextView resultado;
    TextView preco;
    TextView precoTotal;
    TextView pagamento;
    Button voltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resumo_do_pedido);
        voltar = findViewById(R.id.voltar);
        resultado = findViewById(R.id.resultado);
        preco =findViewById(R.id.preco);
        precoTotal = findViewById(R.id.precoTotal);
        pagamento = findViewById(R.id.pagamento);
        List<String> resumoPizza = new ArrayList<>();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String textResumoPizza = "";
        resumoPizza.add(bundle.getString("tamanho1"));
        resumoPizza.add(bundle.getString("tamanho2"));
        resumoPizza.add(bundle.getString("tamanho3"));
        resumoPizza.add(bundle.getString("tamanho4"));
        resumoPizza.add(bundle.getString("tamanho5"));
        for(String s: resumoPizza){
            if(s != null){
            textResumoPizza = textResumoPizza + s +"\n";

            }
        List<String> precoPizza =new ArrayList<>();


        precoPizza.add(bundle.getString("preco1"));
        precoPizza.add(bundle.getString("preco2"));
        precoPizza.add(bundle.getString("preco3"));
        precoPizza.add(bundle.getString("preco4"));
        precoPizza.add(bundle.getString("preco5"));
        String precoList ="";
        float precoPizzaTotal = 0;
        for(String p: precoPizza){
            if(p != null){
            precoList = precoList + "R$ "+ p + "";
            precoPizzaTotal =precoPizzaTotal + Float.parseFloat(p);
            }
        }
        String pagar = bundle.getString("formaPagamento");
        pagamento.setText(pagar);
        precoTotal.setText(" R$ " + String.format("%.2f",precoPizzaTotal));
        preco.setText(precoList);
        resultado.setText(textResumoPizza);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
        voltar.setOnClickListener(view->{
            Intent voltarInicio = new Intent(this, MainActivity.class);
            startActivity(voltarInicio);
        });
}
}