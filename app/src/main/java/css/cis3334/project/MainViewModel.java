package css.cis3334.project;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private final MutableLiveData<String> mScreenText;
    private MutableLiveData<Integer> orderQuantity;
    private MutableLiveData<String> cupcakeFlavor;
    private MutableLiveData<String> pickupDate;
    private MutableLiveData<Double> cupcakePrice;

    public MainViewModel() {
        mScreenText = new MutableLiveData<>();
        mScreenText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mScreenText;
    }
    public void setText(String newText) {
        mScreenText.setValue(newText);
    }

    public void setQuanity(Integer numberOfCupcakes) {
        orderQuantity.setValue(numberOfCupcakes);
    }

    public void setFlavor(String newFlavor) {
        cupcakeFlavor.setValue(newFlavor);
    }

    public void setPickupDate(String newPickupDate) {
        pickupDate.setValue(newPickupDate);
    }
}