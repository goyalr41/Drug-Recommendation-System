package drs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class split_lists {
    
    void split(List l)
    {
        List allergy = new ArrayList<>();
        List pre_drug = new ArrayList<>();
        List disease = new ArrayList<>();
        
        allergy.add(l.get(5));
        allergy.add(l.get(6));
        pre_drug.add(l.get(7));
        pre_drug.add(l.get(8));
        disease.add(l.get(9));
        disease.add(l.get(10));
        
        universal_drugfordisease ob= new universal_drugfordisease();
        ob.connection();
        ob.universalset(l.get(9).toString());
        ob.universalset(l.get(10).toString());
        
        intersection ob2 = new intersection();
        ob2.allergy_intersection(allergy);
        ob2.drug_intersection(pre_drug);
        ob2.final_drugs();
        
    }





}
