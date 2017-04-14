package com.tidyjava.petclinic.mvc;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<View> views = new ArrayList<>();

    public void addView(View view) {
        this.views.add(view);
    }

    public void changed() {
        views.forEach(View::modelChanged);
    }
}
