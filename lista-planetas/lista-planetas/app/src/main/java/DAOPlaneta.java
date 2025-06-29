package com.ifsc.contaclick;

import java.util.ArrayList;

public class DAOPlaneta {

    ArrayList<Planeta> planetas;

    public DAOPlaneta(){
        planetas = new ArrayList<Planeta>();

        String[] nomes = {"Mercurio", "Venus", "Terra", "Marte", "jupter", "Saturno", "Urano","Netuno"};
        Integer[] imgs = {R.drawable.mercury, R.drawable.venus, R.drawable.earth, R.drawable.mars, R.drawable.jupter, R.drawable.saturn, R.drawable.uranus, R.drawable.neptune};

        for(int i=0;i<nomes.length;i++){
            Planeta p = new Planeta(nomes[i], imgs[i]);
            planetas.add(p);
        }
    }

}
