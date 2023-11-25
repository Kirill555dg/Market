package com.example.market;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.market.databinding.ElementsBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ElementsBinding binding = ElementsBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.RG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
            }
        });

        binding.ET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d("TEXTCHANGED"+" BEFORE", s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("TEXTCHANGED"+" ON", s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("TEXTCHANGED"+" AFTER", s.toString());
            }
        });

        binding.B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int added = 0;
                String str = "Добавленные товары: ";
                if (binding.CHB1.isChecked()) {
                    str += binding.CHB1.getText();
                    added++;
                }
                if (binding.CHB2.isChecked()) {
                    if (added>0) {
                        str += ", ";
                    }
                    str += binding.CHB2.getText();
                    added++;
                }
                if (binding.CHB3.isChecked()) {
                    if (added>0) {
                        str += ", ";
                    }
                    str += " " + binding.CHB3.getText();
                    added++;
                }
                if (binding.CHB4.isChecked()) {
                    if (added>0) {
                        str += ", ";
                    }
                    str += " " + binding.CHB4.getText();
                    added++;
                }
                if (binding.CHB5.isChecked()) {
                    if (added>0) {
                        str += ", ";
                    }
                    str += " " + binding.CHB5.getText();
                    added++;
                }
                if (binding.CHB6.isChecked()) {
                    if (added>0) {
                        str += ", ";
                    }
                    str += " " + binding.CHB6.getText();
                    added++;
                }
                if (added == 0) Toast.makeText(getApplicationContext(), "Вы не добавили товаров в заказ", Toast.LENGTH_LONG).show();
                else {
                    str += ".\n";

                    str += "Способ доставки: ";
                    if (binding.RB1.isChecked()) {
                        str += binding.RB1.getText();
                    } else if (binding.RB2.isChecked()) {
                        str += binding.RB2.getText();
                    } else if (binding.RB3.isChecked()) {
                        str += binding.RB3.getText();
                    } else {
                        str += "не выбран. Товар доставится в пункт самовывоза.";
                    }
                    str += "\n";
                    if (binding.ET.getText() != null) {
                        System.out.println(binding.ET.getText());
                        str += "Комментарий к заказу: " + binding.ET.getText();
                    }
                    binding.TV.setText(str);

                    Toast.makeText(getApplicationContext(), "Заказ оформлен", Toast.LENGTH_LONG).show();
                }
                binding.CHB1.setChecked(false);
                binding.CHB2.setChecked(false);
                binding.CHB3.setChecked(false);
                binding.CHB4.setChecked(false);
                binding.CHB5.setChecked(false);
                binding.CHB6.setChecked(false);
                binding.RB1.setChecked(false);
                binding.RB2.setChecked(false);
                binding.RB3.setChecked(false);
                binding.ET.setText("");
            }
        });

        binding.B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.CHB1.setChecked(false);
                binding.CHB2.setChecked(false);
                binding.CHB3.setChecked(false);
                binding.CHB4.setChecked(false);
                binding.CHB5.setChecked(false);
                binding.CHB6.setChecked(false);
                binding.RB1.setChecked(false);
                binding.RB2.setChecked(false);
                binding.RB3.setChecked(false);
                binding.ET.setText("");
                binding.TV.setText("");
                Toast.makeText(getApplicationContext(), "Форма сброшена", Toast.LENGTH_LONG).show();
            }
        });
    }
}