
import com.mycompany.travel_software_zwetti.weatherClasses.OpenWeatherResponse;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import restMain.RestClient;


public class WeatherModel extends AbstractTableModel{
    
    private RestClient restClient=new RestClient();
    private ArrayList<OpenWeatherResponse> destinations = new ArrayList<OpenWeatherResponse>();
    private String[] names = {"Icon", "Name", "Temperatur","Höchste Temperatur","Niedrigste Temperatur", "Luftfeuchtigkeit"};

    @Override
    public int getRowCount() {
        return destinations.size();
    }

    @Override
    public int getColumnCount() {
       return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         return destinations.get(rowIndex);
    }
    
    public void add(String d) throws Exception {
        
        destinations.add(restClient.searchDestinationByName(d));
        fireTableDataChanged();
     //   save();
    }

    public String getColumnName(int i) {
        return names[i];
    }
    
  
    
}