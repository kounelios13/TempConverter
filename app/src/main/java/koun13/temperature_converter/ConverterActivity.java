package koun13.temperature_converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;


public class ConverterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);
        final Button convert =(Button) findViewById(R.id.convertButton);
        final RadioButton cRadio = (RadioButton) findViewById(R.id.cTemp),
        				  fRadio = (RadioButton) findViewById(R.id.fTemp);
        final TextView resField = (TextView) findViewById(R.id.resultField);
        final EditText inputField = (EditText) findViewById(R.id.tempField);
        convert.setOnClickListener(new View.OnClickListener(){
        	public double toCelsius(Double v){
        		return v * 9 / 5 + 32;
        	}
        	public double toFahrenheit(Double v){
        		return (v-32) * 5 / 9;
        	}
        	public void onClick(View view){
                String userValue = String.valueOf(inputField.getText());
                if(userValue.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Please enter a temperature",Toast.LENGTH_SHORT).show();
                    return;
                }
        		double temperature = Double.parseDouble(userValue);
                CharSequence res="";
                res=cRadio.isChecked()?toCelsius(temperature)+" C":toFahrenheit(temperature)+" F";
                resField.setText(res);
        	}
        });
    }
}
