import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class CountryListModel implements ListModel {

    private ArrayList<String> countriesList;

    public CountryListModel(){
        this.countriesList = new ArrayList();
    }

    public Object getElementAt(int index) {
        return(countriesList.get(index));
    }

    public int getSize() {
        return(countriesList.size());
    }

    public void addListDataListener(ListDataListener l) {}

    public void removeListDataListener(ListDataListener l) {}

    public void addCountry(String countryName) {
        if (countriesList.contains(countryName) == false) {
            countriesList.add(countryName);
            Collections.sort(countriesList);
        }
    }

    public void removeCountry(int index){
        countriesList.remove(index);
    }



}




