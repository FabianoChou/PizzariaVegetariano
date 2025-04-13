package www.lanchefacil.com.lojapizza;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class SelectPagamentoETamanho extends AppCompatActivity {
    TextView selectItem;
    RadioGroup selectTamanho;
    Button btnDinheiro;
    Button btnCartao;
    LinearLayout LayoutPizza;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_select_pagamento_etamanho);
        btnDinheiro = findViewById(R.id.btnDinheiro);
        btnCartao = findViewById(R.id.btnCartao);
        LayoutPizza = findViewById(R.id.LayoutPizza);
        Intent intent = new Intent(this, ResumoDoPedido.class);
        List<String> listPizza = new ArrayList<>();
        Bundle bundle = getIntent().getExtras();
        listPizza.add(bundle.getString("pizza1"));
        listPizza.add(bundle.getString("pizza2"));
        listPizza.add(bundle.getString("pizza3"));
        listPizza.add(bundle.getString("pizza4"));
        listPizza.add(bundle.getString("pizza5"));
        for(String s: listPizza ){
            if(s != null) {
                TextView typePizza = new TextView(this);
                typePizza.setText(s);

                RadioGroup groupTypePizza = new RadioGroup(this);
                groupTypePizza.setOrientation(RadioGroup.HORIZONTAL);

                RadioButton pequeno = new RadioButton(this);
                pequeno.setText("Pequeno");
                groupTypePizza.addView(pequeno);

                RadioButton media = new RadioButton(this);
                media.setText("Média");
                groupTypePizza.addView(media);

                RadioButton grande = new RadioButton(this);
                grande.setText("Grande");
                groupTypePizza.addView(grande);

                LayoutPizza.addView(typePizza);
                LayoutPizza.addView(groupTypePizza);
                if(s.equals(bundle.getString("pizza1"))){
                    intent.putExtra("pizza1","Pizza de Margherita");
                    groupTypePizza.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            if(checkedId == pequeno.getId()){
                                intent.putExtra("tamanho1","Pizza Margherita (Pequena)");
                                intent.putExtra("preco1"," 40.00");
                            }else if(checkedId == media.getId()){
                                intent.putExtra("tamanho1","Pizza Margherita (Média)");
                                intent.putExtra("preco1"," 52.00");
;                            } else if (checkedId == grande.getId()) {
                                intent.putExtra("tamanho1","Pizza Margherita (Grande)");
                                intent.putExtra("preco1"," 68.00");
                            }
                        }
                    });
                }
                if(s.equals(bundle.getString("pizza2"))){
                    intent.putExtra("pizza2","Pizza de Milho");
                    groupTypePizza.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            if (checkedId == pequeno.getId()) {
                                intent.putExtra("tamanho2", "Pizza de Milho (Pequena)");
                                intent.putExtra("preco2", " 38.00");
                            } else if (checkedId == media.getId()) {
                                intent.putExtra("tamanho2", "Pizza de Milho (Média)");
                                intent.putExtra("preco2", " 49.00");
                            } else if (checkedId == grande.getId()) {
                                intent.putExtra("tamanho2", "Pizza de Milho (Grande)");
                                intent.putExtra("preco2", " 69.00");
                            }
                        }});
                }
                if(s.equals(bundle.getString("pizza3"))){
                    intent.putExtra("pizza3","Pizza de Palmito");
                    groupTypePizza.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            if (checkedId == pequeno.getId()) {
                                intent.putExtra("tamanho3", "Pizza de Palmito (Pequena)");
                                intent.putExtra("preco3", " 42.00");
                            } else if (checkedId == media.getId()) {
                                intent.putExtra("tamanho3", "Pizza de Palmito (Média)");
                                intent.putExtra("preco3", " 50.00");
                            } else if (checkedId == grande.getId()) {
                                intent.putExtra("tamanho3", "Pizza de Palmito (Grande)");
                                intent.putExtra("preco3", " 64.00");
                            }
                        }});
                }
                if(s.equals(bundle.getString("pizza4"))){
                    intent.putExtra("pizza4","Pizza de Brócolis");
                    groupTypePizza.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            if (checkedId == pequeno.getId()) {
                                intent.putExtra("tamanho4", "Pizza de Brócolis(Pequena)");
                                intent.putExtra("preco2", " 27.99");
                            } else if (checkedId == media.getId()) {
                                intent.putExtra("tamanho4", "Pizza de Brócolis(Média) ");
                                intent.putExtra("preco2", " 36.00");
                            } else if (checkedId == grande.getId()) {
                                intent.putExtra("tamanho4", "Pizza de Brócolis (Grande)");
                                intent.putExtra("preco2", " 50.99");
                            }
                        }});
                }
                if(s.equals(bundle.getString("pizza5"))){
                    intent.putExtra("pizza5","Pizza de Nutella e Morango");
                    groupTypePizza.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            if (checkedId == pequeno.getId()) {
                                intent.putExtra("tamanho5", "Pizza de Nutella e morangos (Pequena)");
                                intent.putExtra("preco5", " 40.00");
                            } else if (checkedId == media.getId()) {
                                intent.putExtra("tamanho5", "Pizza de Nutella e morangos (Média)");
                                intent.putExtra("preco5", " 50.00");
                            } else if (checkedId == grande.getId()) {
                                intent.putExtra("tamanho5", "Pizza de Nutella e morangos (Grande)");
                                intent.putExtra("preco5", " 65.00");
                            }
                        }});
                }


            }
        }
        btnDinheiro.setOnClickListener(view->{
            intent.putExtra("formaPagamento","Dinheiro");
            startActivity(intent);
        });
        btnCartao.setOnClickListener(view->{
            intent.putExtra("formaPagamento","Cartão");
            startActivity(intent);
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}