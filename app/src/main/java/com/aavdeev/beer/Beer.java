package com.aavdeev.beer;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;


public class Beer extends Activity {
    private BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer);
    }

    public void onClickFindBeer(View view) {
        //Получаем ссылку на TextView
        TextView brands = (TextView) findViewById(R.id.brands);
        //Получить ссылку на Spinner
        Spinner color = (Spinner) findViewById(R.id.color);
        //Получить вариант, выбранный в Spinner
        String beerType = String.valueOf(color.getSelectedItem());
       //Получаем рекомендации из класса BeerExpert

        //Получеам контейнер List с сортами пива
        List<String> brandlist = expert.getBrands(beerType);

        //Строем строку (String) по данным из List
        StringBuilder brandsFormatted = new StringBuilder();

        //Вы водим каждый сорт пива с новой стоки
        for (String brand : brandlist) {
            brandsFormatted.append(brand).append('n');
        }

        //Выводим результат в надписи
        brands.setText(brandsFormatted);
    }
}
