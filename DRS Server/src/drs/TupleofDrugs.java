/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Sid
 */
public class TupleofDrugs {
    
    public List<List<String>> tuple(List<List<String>> lst)
{
        //List<List<String>> lst = new ArrayList<List<String>>();

      List<List<String>> result = null;
      result = cartesian(lst);
      for (List<String> r : result) {
            for (String s : r) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
      return result;
}

static public List<List<String>> cartesian(List<List<String>> list)
{
    List<List<String>> result = new ArrayList<List<String>>();
    int numSets = list.size();
   String[] tmpResult = new String[numSets];

    cartesian(list, 0, tmpResult, result);

    return result;
}

static public void cartesian(List<List<String>> list, int n, String[] tmpResult, List<List<String>> result)
{
    if (n == list.size()) {
        result.add(new ArrayList<String>(Arrays.asList(tmpResult)));
        return;
    }

    for (String i : list.get(n)) {
        tmpResult[n] = i;
        cartesian(list, n + 1, tmpResult, result);
    }
}
    
}
