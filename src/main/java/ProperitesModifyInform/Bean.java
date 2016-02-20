package ProperitesModifyInform;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Created by Administrator on 2016/2/20.
 */
public class Bean {

    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    private int value;

    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener){
        propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
    }

    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener){
        propertyChangeSupport.removePropertyChangeListener(propertyChangeListener);
    }


    public void setValue(int value) {
        int oldvalue = this.value;

        this.value = value;

        propertyChangeSupport.firePropertyChange("value",oldvalue,value);
    }

    public static void main(String[] args){

        Bean bean = new Bean();
        bean.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println("oldvalue:" + evt.getOldValue());
                System.out.println("newvalue:" + evt.getNewValue());
            }
        });

        bean.setValue(10);
    }
}
